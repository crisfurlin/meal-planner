package com.mealplanner.mealplannerbe.recipe;

import com.mealplanner.mealplannerbe.dtos.IngredientDto;
import com.mealplanner.mealplannerbe.dtos.RecipeDto;
import com.mealplanner.mealplannerbe.ingredient.IngredientEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
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
        recipeEntity.setInstructions(recipe.getInstructions());
        recipeEntity.setImagePath(recipe.getImagePath());

        HashSet ingredients = new HashSet<IngredientEntity>();
        for (IngredientDto ingredientDto : recipe.getIngredients()) {
            IngredientEntity ingredientEntity = new IngredientEntity();
            ingredientEntity.setQuantity(ingredientDto.getQuantity());
            ingredientEntity.setUnit(ingredientDto.getUnit());
            ingredientEntity.setName(ingredientDto.getName());
            ingredientEntity.setRecipe(recipeEntity);
            ingredients.add(ingredientEntity);
        }
        recipeEntity.setIngredients(ingredients);

        recipeRepository.save(recipeEntity);
    }

    public List<RecipeDto> listAll() {
        Iterable<RecipeEntity> allRecipes = recipeRepository.findAll();

        ArrayList<RecipeDto> recipeList = new ArrayList<>();
        for (RecipeEntity recipeEntity : allRecipes) {
            RecipeDto recipeDto = new RecipeDto();
            recipeDto.setId(recipeEntity.getId());
            recipeDto.setName(recipeEntity.getName());
            recipeDto.setDescription(recipeEntity.getDescription());
            recipeDto.setInstructions(recipeEntity.getInstructions());
            recipeDto.setImagePath(recipeEntity.getImagePath());

            HashSet<IngredientDto> ingredients = new HashSet<>();
            for (IngredientEntity ingredient : recipeEntity.getIngredients()) {
                IngredientDto ingredientDto = new IngredientDto();
                ingredientDto.setQuantity(ingredient.getQuantity());
                ingredientDto.setUnit(ingredient.getUnit());
                ingredientDto.setName(ingredient.getName());
                ingredientDto.setId(ingredient.getId());
                ingredientDto.setRecipeId(ingredient.getRecipe().getId());
                ingredients.add(ingredientDto);
            }

            recipeDto.setIngredients(ingredients);

            recipeList.add(recipeDto);
        }

        return recipeList;
    }
}
