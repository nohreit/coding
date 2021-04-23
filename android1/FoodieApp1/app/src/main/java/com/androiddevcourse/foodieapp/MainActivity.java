package com.androiddevcourse.foodieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private final String TAG = ".MainActivity";

    private ArrayList<MealItem> mealData;
    private MealItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        int swipeDirs;

        if(gridColumnCount > 1)
            swipeDirs = 0;
        else
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;

        //Initialize the RecyclerView
        //Member variables
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        //Set the Layout Manager
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        //Initialize the ArrayLIst that will contain the data
        mealData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        adapter = new MealItemAdapter(this, mealData);
        recyclerView.setAdapter(adapter);

        //Get the data
        initializeData();

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP |
                ItemTouchHelper.DOWN, swipeDirs) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(mealData, from, to);
                adapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                mealData.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        helper.attachToRecyclerView(recyclerView);

    }

    /**
     * Method for initializing the sports data from resources.
     */
    private void initializeData() {
        //Get the resources from the XML file
        String[] mealList = getResources().getStringArray(R.array.meal_titles);
        String[] mealCalories = getResources().getStringArray(R.array.meal_calories);
        String[] mealDescription = getResources().getStringArray(R.array.meal_description);
        String[] mealIngredient = getResources().getStringArray(R.array.meal_ingredients);
        String[] mealRecipeLink = getResources().getStringArray(R.array.meal_recipe_link);
        TypedArray mealImageResources = getResources().obtainTypedArray(R.array.meal_images);

        //Clear the existing data (to avoid duplication)
        mealData.clear();

        //Create the ArrayList of Sports objects with the titles and information about each sport
        for (int i = 0; i < mealList.length; i++) {
            mealData.add(new MealItem(mealImageResources.getResourceId(i, 0), mealList[i], mealCalories[i], mealDescription[i], mealIngredient[i],
                    mealRecipeLink[i]));
        }

        Log.d(TAG, "inside initializeData() mealList: "+ Arrays.toString(mealList));

        //Clean up the data in the typed array
        mealImageResources.recycle();

        //Notify the adapter of the change
        adapter.notifyDataSetChanged();
    }

    public void resetSports(View view) {
        initializeData();
    }
}