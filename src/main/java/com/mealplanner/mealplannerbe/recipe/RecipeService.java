package com.mealplanner.mealplannerbe.recipe;

import com.mealplanner.mealplannerbe.dtos.IngredientDto;
import com.mealplanner.mealplannerbe.dtos.RecipeDto;
import com.mealplanner.mealplannerbe.ingredient.IngredientEntity;
import com.mealplanner.mealplannerbe.mappers.IngredientMapper;
import com.mealplanner.mealplannerbe.mappers.Mapper;
import com.mealplanner.mealplannerbe.mappers.RecipeMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public RecipeService(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    public void createRecipe(RecipeDto recipe) {
        recipeRepository.save(recipeMapper.mapToEntity(recipe));
    }

    public Collection<RecipeDto> listAll() {
        List<RecipeEntity> allRecipes = recipeRepository.findAll();

        return recipeMapper.mapToDtos(allRecipes);
    }
}
