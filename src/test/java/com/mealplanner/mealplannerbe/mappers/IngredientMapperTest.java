package com.mealplanner.mealplannerbe.mappers;

import com.mealplanner.mealplannerbe.dtos.IngredientDto;
import com.mealplanner.mealplannerbe.ingredient.IngredientEntity;
import com.mealplanner.mealplannerbe.recipe.RecipeEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class IngredientMapperTest {

    IngredientMapper mapper = new IngredientMapper();

    @Test
    public void it_should_map_dto_to_entity() {
        //given
        IngredientDto dto = new IngredientDto(3, "5", "tbsp", "sugar", 1);
        //when
        IngredientEntity entity = mapper.mapToEntity(dto);
        //then
        assertThat(entity).isNotNull();
        assertThat(entity.getId()).isNull();
        assertThat(entity.getQuantity()).isEqualTo(dto.getQuantity());
        assertThat(entity.getUnit()).isEqualTo(dto.getUnit());
        assertThat(entity.getName()).isEqualTo(dto.getName());
        assertThat(entity.getRecipe().getId()).isEqualTo(dto.getRecipeId());
    }

    @Test
    public void it_should_return_null_entity_if_dto_is_null() {
        //when
        IngredientEntity entity = mapper.mapToEntity(null);
        //then
        assertThat(entity).isNull();
    }

    @Test
    public void it_should_map_entity_to_dto() {
        //given
        RecipeEntity recipe = new RecipeEntity(1, "Pita bread", "Desc example", "Instruc example", "google.com", null);
        IngredientEntity entity = new IngredientEntity(2,"1", "tsp", "salt", recipe);
        //when
        IngredientDto dto = mapper.mapToDto(entity);
        //then
        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(entity.getId());
        assertThat(dto.getQuantity()).isEqualTo(entity.getQuantity());
        assertThat(dto.getUnit()).isEqualTo(entity.getUnit());
        assertThat(dto.getName()).isEqualTo(entity.getName());
        assertThat(dto.getRecipeId()).isEqualTo(entity.getRecipe().getId());
    }

    @Test
    public void it_should_return_null_dto_if_entity_is_null() {
        //when
        IngredientDto dto = mapper.mapToDto(null);
        //then
        assertThat(dto).isNull();
    }

    @Test
    public void it_should_return_empty_entity_if_dto_is_empty() {
        //given
        ArrayList<IngredientDto> ingredientDtos = new ArrayList<>();
        //when
        Iterable<IngredientEntity> ingredientEntities = mapper.mapToEntities(ingredientDtos);
        //then
        assertThat(ingredientEntities).isEmpty();
    }

    @Test
    public void it_should_map_ingredient_dtos_to_ingredient_entities() {
        //given
        ArrayList<IngredientDto> ingredientDtos = new ArrayList<>();
        IngredientDto ingredientOne = new IngredientDto(1, "2", "cup", "flour", 5);
        IngredientDto ingredientTwo = new IngredientDto(2, "3", "ounces", "butter", 5);
        IngredientDto ingredientThree = new IngredientDto(3, "1/2", "tbsp", "baking soda", 5);
        ingredientDtos.add(ingredientOne);
        ingredientDtos.add(ingredientTwo);
        ingredientDtos.add(ingredientThree);
        //when
        Iterable<IngredientEntity> ingredientEntities = mapper.mapToEntities(ingredientDtos);
        //then
        assertThat(ingredientEntities).hasSize(3);

    }

    @Test
    public void it_should_return_null_recipe_entities_if_recipe_dtos_is_null() {
        //when
        Iterable<IngredientEntity> ingredientEntities = mapper.mapToEntities(null);
        //then
        assertThat(ingredientEntities).isNull();
    }

    @Test
    public void it_should_return_empty_dto_if_entity_is_empty() {
        //given
        ArrayList<IngredientEntity> ingredientEntities = new ArrayList<>();
        //when
        Iterable<IngredientDto> ingredientDtos = mapper.mapToDtos(ingredientEntities);
        //then
        assertThat(ingredientDtos).isEmpty();
    }

    @Test
    public void it_should_map_ingredient_entities_to_ingredient_dtos() {
        //given
        ArrayList<IngredientEntity> ingredientEntities = new ArrayList<>();
        IngredientEntity ingredientOne = new IngredientEntity(1, "2", "cup", "flour", new RecipeEntity());
        IngredientEntity ingredientTwo = new IngredientEntity(2, "3", "ounces", "butter", new RecipeEntity());
        IngredientEntity ingredientThree = new IngredientEntity(3, "1/2", "tbsp", "baking soda", new RecipeEntity());
        ingredientEntities.add(ingredientOne);
        ingredientEntities.add(ingredientTwo);
        ingredientEntities.add(ingredientThree);
        //when
        Iterable<IngredientDto> ingredientDtos = mapper.mapToDtos(ingredientEntities);
        //then
        assertThat(ingredientDtos).hasSize(3);
    }

    @Test
    public void it_should_return_null_recipe_dtos_if_recipe_entities_is_null() {
        //when
        Iterable<IngredientDto> ingredientDtos = mapper.mapToDtos(null);
        //then
        assertThat(ingredientDtos).isNull();
    }

}