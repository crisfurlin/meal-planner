package com.mealplanner.mealplannerbe.mappers;

import com.mealplanner.mealplannerbe.ingredient.IngredientEntity;

import java.util.ArrayList;
import java.util.Collection;

public interface Mapper<DTO, ENTITY> {

    ENTITY mapToEntity(DTO dto);
    DTO mapToDto(ENTITY entity);

    default Collection<ENTITY> mapToEntities(Collection<DTO> dtos) {
        Collection<ENTITY> entities = new ArrayList<>();
        if (dtos == null) {
            return null;
        }
        for (DTO dto : dtos) {
            entities.add(mapToEntity(dto));
        }
        return entities;
    }

    default Collection<DTO> mapToDtos(Collection<ENTITY> entities) {
        Collection<DTO> dtos = new ArrayList<>();
        if (entities == null) {
            return null;
        }
        for (ENTITY entity : entities) {
            dtos.add(mapToDto(entity));
        }
        return dtos;
    }
}
