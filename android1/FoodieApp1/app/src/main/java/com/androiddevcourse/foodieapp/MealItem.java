package com.androiddevcourse.foodieapp;

public class MealItem {
    //Member variables representing the title and information about the sport
    private final int imageResource;
    private final String title;
    private final String calories;
    private final String ingredients;
    private final String linkToRecipe;
    private final String description;

    /**
     * Constructor for the Sport data model
     *
     * @param title        The name if the meal.
     * @param calories     Calories in the meal
     * @param ingredients  Ingredients for the meal
     * @param linkToRecipe link to web site of the meal recipe
     * @param description  Information about the meal.
     */
    MealItem(int imageResource, String title, String calories, String ingredients, String linkToRecipe, String description) {
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
        this.ingredients = ingredients;
        this.calories = calories;
        this.linkToRecipe = linkToRecipe;
    }

    /**
     * Gets the title of the sport
     *
     * @return The title of the sport.
     */
    String getTitle() {
        return title;
    }

    /**
     * Gets the info about the sport
     *
     * @return The info about the sport.
     */
    String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
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
}
