package com.mealplanner.mealplannerbe.dtos;

public class RecipeDto {

    private Integer id;
    private String name;
    private String description;
    private String instructions;
    private String imagePath;

    public RecipeDto(Integer id, String name, String description, String instructions, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.imagePath = imagePath;
    }

    public RecipeDto() {
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
}
