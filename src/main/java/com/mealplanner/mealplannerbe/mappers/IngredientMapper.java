package com.mealplanner.mealplannerbe.mappers;

import com.mealplanner.mealplannerbe.dtos.IngredientDto;
import com.mealplanner.mealplannerbe.ingredient.IngredientEntity;
import com.mealplanner.mealplannerbe.recipe.RecipeEntity;

public class IngredientMapper implements Mapper<IngredientDto, IngredientEntity>{

    @Override
    public IngredientEntity mapToEntity(IngredientDto ingredientDto) {
        if (ingredientDto == null) {
            return null;
        }

        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setQuantity(ingredientDto.getQuantity());
        ingredientEntity.setUnit(ingredientDto.getUnit());
        ingredientEntity.setName(ingredientDto.getName());

        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(ingredientDto.getRecipeId());
        ingredientEntity.setRecipe(recipeEntity);

        return ingredientEntity;
    }

    @Override
    public IngredientDto mapToDto(IngredientEntity ingredientEntity) {
        return null;
    }
}
