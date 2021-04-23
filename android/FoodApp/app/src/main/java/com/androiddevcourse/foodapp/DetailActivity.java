package com.androiddevcourse.foodapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    final String TAG = ".DetailActivity";
    final String IMAGE = "image_resource";
    final String TITLE = "title";
    final String CALORIES = "calories";
    final String RECIPE = "recipe";
    final String DESCRIPTION = "description";
    final String INGREDIENTS = "ingredients";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView title = findViewById(R.id.meal_list_detail),
                calories = findViewById(R.id.meal_calories_detail),
                ingredients = findViewById(R.id.meal_ingredients_detail),
                linkToRecipe = findViewById(R.id.meal_link_recipe_detail),
                description = findViewById(R.id.meal_description_detail);
        ImageView image = findViewById(R.id.meal_image_detail);

        title.setText(getIntent().getStringExtra(TITLE));
        calories.setText(getIntent().getStringExtra(CALORIES));
        ingredients.setText(getIntent().getStringExtra(INGREDIENTS));
        linkToRecipe.setText(getIntent().getStringExtra(RECIPE));
        description.setText(getIntent().getStringExtra(DESCRIPTION));
        Glide.with(this).load(getIntent().getIntExtra(IMAGE, 0)).into(image);
    }
}