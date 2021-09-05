package com.mealplanner.mealplannerbe.ingredient;

import com.mealplanner.mealplannerbe.dtos.IngredientDto;
import com.mealplanner.mealplannerbe.recipe.RecipeEntity;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public void addIngredient(IngredientDto ingredient) {
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setQuantity(ingredient.getQuantity());
        ingredientEntity.setUnit(ingredient.getUnit());
        ingredientEntity.setName(ingredient.getName());

        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(ingredient.getRecipeId());
        ingredientEntity.setRecipe(recipeEntity);

        ingredientRepository.save(ingredientEntity);
    }
}
