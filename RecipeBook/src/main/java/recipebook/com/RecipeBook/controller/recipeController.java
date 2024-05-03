package recipebook.com.RecipeBook.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import recipebook.com.RecipeBook.model.*;
import recipebook.com.RecipeBook.service.RecipeService;

import java.util.Optional;


@Controller
public class recipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/recipe")
    public String showAllRecipe(Model model){
        model.addAttribute("recipe", recipeService.getAllRecipe());
        return "recipe";
    }

    @GetMapping("/recipe/new")
    public String createRecipeForm(Model model){
        Recipe recipe = new Recipe();
        model.addAttribute("recipe",recipe);
        return "create_recipe";
    }

    @PostMapping("/recipe")
    public String saveRecipe(@ModelAttribute("recipe") Recipe recipe) {
        recipeService.saveRecioe(recipe);
        return "redirect:/recipe";
    }


    /*@GetMapping("/recipe/edit/{id}")
    public String editRecipeForm(@PathVariable Long id, Model model) {
        model.addAttribute("recipe", recipeService.getRecipeById(id));
        return "edit_recipe";
    }*/

    @PostMapping("/recipe/{id}")
    public String updateRecipe(@PathVariable Long id, @ModelAttribute("recipe") Recipe recipe, Model model) {
        // Get the existing recipe by id
        Optional<Recipe> existingRecipeOptional = recipeService.getRecipeById(id);

        if (existingRecipeOptional.isPresent()) {
            Recipe existingRecipe = existingRecipeOptional.get();

            // Update the existing recipe with new values
            existingRecipe.setTitle(recipe.getTitle());
            existingRecipe.setDescription(recipe.getDescription());
            existingRecipe.setIngredients(recipe.getIngredients());
            existingRecipe.setInstructions(recipe.getInstructions());

            // Save the updated recipe
            recipeService.updateRecipe(existingRecipe);
        }

        return "redirect:/recipe";
    }

    @GetMapping("/recipe/delete/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipeById(id);
        return "redirect:/recipe";
    }

    @GetMapping("/recipe/edit/{id}")
    public String editRecipeForm(@PathVariable Long id, Model model) {
        // Get the recipe by its id
        Optional<Recipe> recipeOptional = recipeService.getRecipeById(id);
        if (recipeOptional.isPresent()) {
            Recipe recipe = recipeOptional.get();
            model.addAttribute("recipe", recipe);
            return "edit_recipe";
        } else {
            return "error";
        }
    }

}
