package com.mealplanner.mealplannerbe.dtos;

public class RecipeDto {

    private String name;
    private String description;
    private String instructions;
    private String imagePath;

    public RecipeDto(String name, String description, String instructions, String imagePath) {
        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.imagePath = imagePath;
    }

    public RecipeDto() {
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
}
