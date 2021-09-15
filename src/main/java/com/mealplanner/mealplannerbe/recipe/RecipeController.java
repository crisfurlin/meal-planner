package com.mealplanner.mealplannerbe.recipe;

import com.mealplanner.mealplannerbe.dtos.IngredientDto;
import com.mealplanner.mealplannerbe.dtos.RecipeDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public Collection<RecipeDto> recipesList() {
        return recipeService.listAll();
    }

    @PostMapping
    public void createRecipe(@RequestBody RecipeDto recipe) {
        recipeService.createRecipe(recipe);
    }

}
