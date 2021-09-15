package com.mealplanner.mealplannerbe.mappers;

import com.mealplanner.mealplannerbe.dtos.IngredientDto;
import com.mealplanner.mealplannerbe.dtos.RecipeDto;
import com.mealplanner.mealplannerbe.ingredient.IngredientEntity;
import com.mealplanner.mealplannerbe.recipe.RecipeEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class RecipeMapper implements Mapper<RecipeDto, RecipeEntity> {

    private final IngredientMapper ingredientMapper;

    public RecipeMapper(IngredientMapper ingredientMapper) {
        this.ingredientMapper = ingredientMapper;
    }

    @Override
    public RecipeEntity mapToEntity(RecipeDto recipeDto) {
        if (recipeDto == null) {
            return null;
        }

        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setName(recipeDto.getName());
        recipeEntity.setDescription(recipeDto.getDescription());
        recipeEntity.setInstructions(recipeDto.getInstructions());
        recipeEntity.setImagePath(recipeDto.getImagePath());

        recipeEntity.setIngredients(ingredientMapper.mapToEntities(recipeDto.getIngredients()));

        return recipeEntity;
    }

    @Override
    public RecipeDto mapToDto(RecipeEntity recipeEntity) {
        if (recipeEntity == null) {
            return null;
        }

        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipeEntity.getId());
        recipeDto.setName(recipeEntity.getName());
        recipeDto.setDescription(recipeEntity.getDescription());
        recipeDto.setInstructions(recipeEntity.getInstructions());
        recipeDto.setImagePath(recipeEntity.getImagePath());
        recipeDto.setIngredients(ingredientMapper.mapToDtos(recipeEntity.getIngredients()));

        return recipeDto;
    }
}
