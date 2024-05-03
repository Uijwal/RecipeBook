package recipebook.com.RecipeBook.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "Ingredients")
    private  String ingredients;

    @Column(name = "Instruction")
    private String instructions;

    public Recipe() {
    }

    public Recipe(String title, Long id, String description, String ingredients, String instructions) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
