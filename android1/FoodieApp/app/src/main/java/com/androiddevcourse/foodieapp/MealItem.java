/*
 * Copyright (C) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.androiddevcourse.foodieapp;

/**
 * Data model for each row of the RecyclerView.
 */
class MealItem {

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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
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
