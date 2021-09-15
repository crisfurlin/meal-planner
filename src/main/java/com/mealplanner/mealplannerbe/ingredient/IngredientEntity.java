package com.mealplanner.mealplannerbe.ingredient;

import com.mealplanner.mealplannerbe.recipe.RecipeEntity;

import javax.persistence.*;

@Entity(name = "Ingredients")
public class IngredientEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String quantity;
    private String unit;
    private String name;
    @ManyToOne
    private RecipeEntity recipe;

    public IngredientEntity(Integer id, String quantity, String unit, String name, RecipeEntity recipe) {
        this.id = id;
        this.quantity = quantity;
        this.unit = unit;
        this.name = name;
        this.recipe = recipe;
    }

    public IngredientEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }
}


