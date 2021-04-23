package com.androiddevcourse.foodapp;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * @author Thierno Bah
 */
public class MainActivity extends AppCompatActivity {

    public final String TAG = ".MainActivity",
            STATE_MEAL_TITLE = ".meal_titles",
            STATE_MEAL_CALORIES = ".meal_calories",
            STATE_MEAL_INGREDIENTS = ".meal_ingredients",
            STATE_MEAL_RECIPE_LINK = ".meal_recipe_links",
            STATE_MEAL_DESCRIPTION = ".meal_descriptions",
            STATE_MEAL_IMAGES = ".meal_images",
            STATE_LIST = "state_list";
    RecyclerView recyclerView;
    private ArrayList<MealItem> mealData, listState;
    private MealItemAdapter adapter;
    private int count, gridColumnCount;
    private String[] mealList, mealCalories, mealIngredients, mealLinkToRecipe, mealDescription;
    //    private boolean msgConfirm = false;
//    private MealItemAdapter.ViewHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        mealData = new ArrayList<>(); // 1. This line before (2)
        gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        setupRecyclerViewGLM(); // 2. This line after (1)

        if (savedInstanceState != null) {
            mealData = savedInstanceState.getParcelableArrayList(STATE_LIST);
            setupRecyclerViewGLM();
        } else
            initializeData();

    }

    private void setupRecyclerViewGLM(){
        adapter = new MealItemAdapter(this, mealData);
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save list state
        Log.d(TAG, "onSaveInstanceState: mealData.size = " + mealData.size());

        outState.putParcelableArrayList(STATE_LIST, (ArrayList<? extends Parcelable>) mealData);
    }

    private void initializeData() {
        // Image resources for meal banner
        TypedArray mealImageResources = getResources().obtainTypedArray(R.array.meal_images);
        // Values resources for meal information
        mealList = getResources().getStringArray(R.array.meal_titles); // meal titles
        mealCalories = getResources().getStringArray(R.array.meal_calories);
        mealIngredients = getResources().getStringArray(R.array.meal_ingredients);
        mealLinkToRecipe = getResources().getStringArray(R.array.meal_recipe_links);
        mealDescription = getResources().getStringArray(R.array.meal_descriptions);

        // Clear the existing data (to avoid duplication)
        mealData.clear();

        // Create the ArrayList of Meals objects
        for (int i = 0; i < mealList.length; i++) {
            mealData.add(new MealItem(mealLinkToRecipe[i], mealCalories[i], mealIngredients[i],
                    mealLinkToRecipe[i], mealDescription[i], mealImageResources.getResourceId(i, 0)));
        }

        // Clean up the data in the typed array
        mealImageResources.recycle();

        // Notify the adapter for the change
        adapter.notifyDataSetChanged();

    }

    public void resetMealItem(View view) {
        initializeData();
    }

    public void addMealItem(View view) {
        Log.d(TAG, "addMealItem");
        TypedArray mealImageResources = getResources().obtainTypedArray(R.array.meal_images);

        Log.d(TAG, "addMealItem count: " + count);
        count = mealData.size() + 1;
        Log.d(TAG, "addMealItem count: " + count);

        // Add new meal item
        mealData.add(new MealItem("Title" + (count), "Calories" + (count),
                "Ingredients" + (count),
                "RecipeLink" + (count), "Description" + (count),
                mealImageResources.getResourceId(mealImageResources.length() - 1, 0)));
        Log.d(TAG, "addMealItem mealData: " + mealData);
        Log.d(TAG, "addMealItem mealData.size: " + mealData.size());


        // Clean up the data in the typed array
        mealImageResources.recycle();

        // Notify the adapter for the insertion
        adapter.notifyItemInserted(mealData.size() - 1);
    }

}