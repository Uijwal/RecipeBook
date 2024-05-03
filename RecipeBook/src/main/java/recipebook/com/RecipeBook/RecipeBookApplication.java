package recipebook.com.RecipeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecipeBookApplication {

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(RecipeBookApplication.class, args);
	}

}
