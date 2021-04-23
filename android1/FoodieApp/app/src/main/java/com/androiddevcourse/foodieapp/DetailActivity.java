package com.androiddevcourse.foodieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final String IMAGE = "image_resource";
        final String TITLE = "title";
        final String CALORIES = "calories";
        final String RECIPE = "recipe";
        final String DESCRIPTION = "description";
        final String INGREDIENTS = "ingredients";


        ImageView mealImage = findViewById(R.id.mealImageDetail);
        TextView title = findViewById(R.id.mealTitleDetail);
        TextView calories = findViewById(R.id.caloriesDetail);
        TextView ingredients = findViewById(R.id.ingredientsDetail);
        TextView recipe = findViewById(R.id.linkToRecipeDetail);
        TextView description = findViewById(R.id.descriptionDetail);


        Glide.with(this).load(getIntent().getIntExtra(IMAGE, 0)).into(mealImage);
        title.setText(getIntent().getStringExtra(TITLE));
        calories.setText(getIntent().getStringExtra(CALORIES));
        ingredients.setText(getIntent().getStringExtra(INGREDIENTS));
        recipe.setText(getIntent().getStringExtra(RECIPE));
        description.setText(getIntent().getStringExtra(DESCRIPTION));
    }
}