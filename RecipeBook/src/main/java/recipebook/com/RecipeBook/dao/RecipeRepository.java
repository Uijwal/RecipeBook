package recipebook.com.RecipeBook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import recipebook.com.RecipeBook.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findByTitle(String title);
}
