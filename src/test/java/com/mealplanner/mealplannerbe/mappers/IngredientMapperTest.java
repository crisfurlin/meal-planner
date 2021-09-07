package com.mealplanner.mealplannerbe.mappers;

import com.mealplanner.mealplannerbe.dtos.IngredientDto;
import com.mealplanner.mealplannerbe.ingredient.IngredientEntity;
import org.junit.jupiter.api.Test;

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
}
