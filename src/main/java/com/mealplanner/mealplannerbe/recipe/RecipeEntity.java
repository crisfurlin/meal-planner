package com.mealplanner.mealplannerbe.recipe;

import com.mealplanner.mealplannerbe.ingredient.IngredientEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Recipes")
public class RecipeEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private String instructions;
    private String imagePath;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<IngredientEntity> ingredients;

    public RecipeEntity(Integer id, String name, String description, String instructions, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.imagePath = imagePath;
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

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Set<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }
}

