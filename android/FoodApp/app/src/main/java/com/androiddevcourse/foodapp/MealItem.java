package com.androiddevcourse.foodapp;

import android.os.Parcel;
import android.os.Parcelable;

public class MealItem implements Parcelable {

    public static final Parcelable.Creator<MealItem> CREATOR = new Parcelable.Creator<MealItem>() {

        @Override
        public MealItem createFromParcel(Parcel source) {
            return new MealItem(source);
        }

        @Override
        public MealItem[] newArray(int size) {
            return new MealItem[size];
        }
    };

    private final String title;
    private final String calories;
    private final String ingredients;
    private final String linkToRecipe;
    private final String description;
    private final int imageResource;

    public MealItem(String title, String calories, String ingredients, String linkToRecipe,
                    String description, int imageResource) {
        this.title = title;
        this.calories = calories;
        this.ingredients = ingredients;
        this.linkToRecipe = linkToRecipe;
        this.description = description;
        this.imageResource = imageResource;
    }

    private MealItem(Parcel source) {
        this.title = source.readString();
        this.calories = source.readString();
        this.ingredients = source.readString();
        this.linkToRecipe = source.readString();
        this.description = source.readString();
        this.imageResource = source.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.calories);
        dest.writeString(this.ingredients);
        dest.writeString(this.linkToRecipe);
        dest.writeString(this.description);
        dest.writeInt(this.imageResource);
    }
}
