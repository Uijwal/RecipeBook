package recipebook.com.RecipeBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipebook.com.RecipeBook.dao.RecipeRepository;
import recipebook.com.RecipeBook.model.Recipe;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {


    @Autowired
    RecipeRepository recipeRepository;
    public List<Recipe> getAllRecipe(){
        return recipeRepository.findAll();
    }

    public Recipe saveRecioe(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public void RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    /*public Recipe getRecipeByTitle(String title) {
        return recipeRepository.findByTitle(title);
    }*/

    public Optional<Recipe> getRecipeById(Long id){
        return recipeRepository.findById(id);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipeById(Long id){
        recipeRepository.deleteById(id);
    }
}
