package com.androiddevcourse.foodapp;

public class MealItem {

    private final String title;
    private final String calories;
    private final String ingredients;
    private final String linkToRecipe;
    private final String description;
    private final int imageResource;

    public MealItem(String title, String calories, String ingredients, String linkToRecipe, String description, int imageResource) {
        this.title = title;
        this.calories = calories;
        this.ingredients = ingredients;
        this.linkToRecipe = linkToRecipe;
        this.description = description;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getCalories() {
        return calories;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getLinkToRecipe() {
        return linkToRecipe;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}
