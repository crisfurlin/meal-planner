package com.mealplanner.mealplannerbe.recipe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Recipes")
public class RecipeEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;

    public RecipeEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public RecipeEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

