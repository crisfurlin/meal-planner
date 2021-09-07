package com.mealplanner.mealplannerbe.mappers;

import java.util.ArrayList;
import java.util.List;

public interface Mapper<DTO, ENTITY> {

    ENTITY mapToEntity(DTO dto);
    DTO mapToDto(ENTITY entity);

    default List<ENTITY> mapToEntities(List<DTO> dtos) {
        ArrayList<ENTITY> entities = new ArrayList<>();
        for (DTO dto : dtos) {
            entities.add(mapToEntity(dto));
        }
        return entities;
    }

    default List<DTO> mapToDtos(List<ENTITY> entities) {
        ArrayList<DTO> dtos = new ArrayList<>();
        for (ENTITY entity : entities) {
            dtos.add(mapToDto(entity));
        }
        return dtos;
    }
}