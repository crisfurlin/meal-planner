package com.mealplanner.mealplannerbe.recipe;

import com.mealplanner.mealplannerbe.dtos.RecipeDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void createRecipe(RecipeDto recipe) {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setName(recipe.getName());
        recipeEntity.setDescription(recipe.getDescription());

        recipeRepository.save(recipeEntity);
    }

    public List<RecipeDto> listAll() {
        Iterable<RecipeEntity> allRecipes = recipeRepository.findAll();

        ArrayList<RecipeDto> recipeList = new ArrayList<>();
        for (RecipeEntity recipeEntity : allRecipes) {
            recipeList.add(new RecipeDto(recipeEntity.getName(), recipeEntity.getDescription()));
        }

        return recipeList;
    }
}
