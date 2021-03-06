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

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/***
 * The adapter class for the RecyclerView, contains the meal data
 */
class MealItemAdapter extends RecyclerView.Adapter<MealItemAdapter.ViewHolder> {

    final String IMAGE = "image_resource";
    final String TITLE = "title";
    final String CALORIES = "calories";
    final String RECIPE = "recipe";
    final String DESCRIPTION = "description";
    final String INGREDIENTS = "ingredients";

    //Member variables
    private final ArrayList<MealItem> mealData;
    private final Context context;

    /**
     * Constructor that passes in the meal data and the context
     *
     * @param mealData ArrayList containing the meal data
     * @param context    Context of the application
     */
    MealItemAdapter(Context context, ArrayList<MealItem> mealData) {
        this.mealData = mealData;
        this.context = context;
    }


    /**
     * Required method for creating the viewholder objects.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly create ViewHolder.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    /**
     * Required method that binds the data to the viewholder.
     *
     * @param holder   The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Get current sport
        MealItem currentMealItem = mealData.get(position);
        //Populate the textviews with data
        holder.bindTo(currentMealItem);
    }


    /**
     * Required method for determining the size of the data set.
     *
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mealData.size();
    }


    /**
     * ViewHolder class that represents each row of data in the RecyclerView
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //Member Variables for the TextViews
        private final TextView title;
        private final TextView calories;
        private final TextView ingredients;
        private final TextView recipe;
        private final TextView description;
        private final ImageView mealImage;


        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The rootview of the list_item.xml layout file
         */
        ViewHolder(View itemView) {
            super(itemView);

            //Initialize the views
            mealImage = itemView.findViewById(R.id.mealImageDetail);
            title = itemView.findViewById(R.id.mealTitleDetail);
            calories = itemView.findViewById(R.id.caloriesDetail);
            ingredients = itemView.findViewById(R.id.ingredientsDetail);
            recipe = itemView.findViewById(R.id.linkToRecipeDetail);
            description = itemView.findViewById(R.id.descriptionDetail);

            //Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this);
        }

        void bindTo(MealItem currentMeal) {
            //Populate the textviews with data
            title.setText(currentMeal.getTitle());
            calories.setText(currentMeal.getCalories());
            ingredients.setText(currentMeal.getIngredients());
            recipe.setText(currentMeal.getLinkToRecipe());
            description.setText(currentMeal.getDescription());
            Glide.with(context).load(currentMeal.getImageResource()).into(mealImage);
        }

        @Override
        public void onClick(View v) { // Launches DetailActivity putting title and image_resource as extra in the intent
            MealItem currentMeal = mealData.get(getAdapterPosition());

            Intent detailIntent = new Intent(context, DetailActivity.class);
            detailIntent.putExtra(TITLE, currentMeal.getTitle());
            detailIntent.putExtra(CALORIES, currentMeal.getCalories());
            detailIntent.putExtra(INGREDIENTS, currentMeal.getIngredients());
            detailIntent.putExtra(RECIPE, currentMeal.getLinkToRecipe());
            detailIntent.putExtra(DESCRIPTION, currentMeal.getDescription());
            context.startActivity(detailIntent);
        }
    }
}
