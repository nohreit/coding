package com.androiddevcourse.foodapp;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * @author Thierno Bah
 *
 */
public class MainActivity extends AppCompatActivity {

    final String TAG = ".MainActivity";
    private ArrayList<MealItem> mealData;
    private MealItemAdapter adapter;
//    private boolean msgConfirm = false;
//    private MealItemAdapter.ViewHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        mealData = new ArrayList<>();
        adapter = new MealItemAdapter(this, mealData);
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        recyclerView.setAdapter(adapter);

        initializeData();

    }

    private void initializeData() {
        // Image resources for meal banner
        TypedArray mealImageResources = getResources().obtainTypedArray(R.array.meal_images);
        // Values resources for meal information
        String[] mealList = getResources().getStringArray(R.array.meal_titles); // meal titles
        String[] mealCalories = getResources().getStringArray(R.array.meal_calories);
        String[] mealIngredients = getResources().getStringArray(R.array.meal_ingredients);
        String[] mealLinkToRecipe = getResources().getStringArray(R.array.meal_recipe_links);
        String[] mealDescription = getResources().getStringArray(R.array.meal_descriptions);

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

//    public void addMealItem(View view) {
//        Log.d(TAG, "addMealItem");
//        TypedArray mealImageResources = getResources().obtainTypedArray(R.array.meal_images);
//
//        int numItem = adapter.getItemCount();
//        Log.d(TAG, "addMealItem numItem: "+numItem);
//
//        // Add new meal item
//        mealData.add(new MealItem("Title" + (numItem + 1), "Calories" + (numItem + 1),
//                "Ingredients" + (numItem + 1),
//                "RecipeLink" + (numItem + 1), "Description" + (numItem + 1),
//                mealImageResources.getResourceId(mealImageResources.length()-1, 0)));
//        Log.d(TAG, "addMealItem mealData: "+mealData);
//
//        // Clean up the data in the typed array
////        mealImageResources.recycle();
//
//        // Notify the adapter for the insertion
//        adapter.notifyItemInserted(mealData.size()-1);
//    }
}