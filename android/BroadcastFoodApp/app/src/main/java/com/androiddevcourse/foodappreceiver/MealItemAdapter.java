package com.androiddevcourse.foodappreceiver;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class MealItemAdapter extends RecyclerView.Adapter<MealItemAdapter.MealItemHolder> {
    final String TAG = ".MealItemAdapter";
    final String IMAGE = "image_resource";
    final String TITLE = "title";
    final String CALORIES = "calories";
    final String RECIPE = "recipe";
    final String DESCRIPTION = "description";
    final String INGREDIENTS = "ingredients";

    private final ArrayList<MealItem> mealData;
    private final Context context;

    public MealItemAdapter(Context context, ArrayList<MealItem> mealData) {
        this.mealData = mealData;
        this.context = context;
    }

    @NonNull
    @Override
    public MealItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MealItemHolder(LayoutInflater.from(context).inflate(R.layout.list_meal, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull MealItemHolder holder, int position) {
        MealItem currentMeal = mealData.get(position);

        Log.d(TAG, "holder A => " + holder);
        holder.bindTo(currentMeal);
        Log.d(TAG, "holder B => " + holder);
        holder.itemView.setOnLongClickListener(v -> removeDialog(holder)); // Remove Item on long click

    }

    public boolean removeDialog(@NonNull RecyclerView.ViewHolder viewHolder) { // Launches the dialog requesting confirmation for deletion
        return createConfirmDialog(viewHolder);
    }

    public boolean createConfirmDialog(@NonNull RecyclerView.ViewHolder viewHolder) { // Creates the confirmation dialog
        AlertDialog.Builder confirmDialogBuilder = new AlertDialog.Builder(this.context);
        AtomicBoolean msgConfirm = new AtomicBoolean(false);

        confirmDialogBuilder.setTitle(R.string.confirmDialogTitle);

        TextView message = new TextView(this.context);
        message.setText(R.string.messageConfirmDialog);
        message.setPadding(8, 8, 8, 8);
        confirmDialogBuilder.setView(message);

        confirmDialogBuilder.setPositiveButton("Yes", (dialog, which) -> msgConfirm.set(true));
        confirmDialogBuilder.setNegativeButton("No", (dialog, which) -> msgConfirm.set(false));

        AlertDialog confirmDialog = confirmDialogBuilder.create();
        confirmDialog.show();

        Button yesBtn = confirmDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        yesBtn.setOnClickListener(v -> { // Set specific action for the yes button
            removeItem(viewHolder); // Call the method to remove the selected item
            confirmDialog.dismiss();
        });

        return msgConfirm.get();
    }

    private void removeItem(RecyclerView.ViewHolder viewHolder) { // We remove the item
        mealData.remove(viewHolder.getAdapterPosition());
        notifyItemRemoved(viewHolder.getAdapterPosition());
    }


    @Override
    public int getItemCount() {
        return mealData.size();
    }

    class MealItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView title;
        private final TextView calories;
        private final TextView ingredients;
        private final TextView linkToRecipe;
        private final TextView description;
        private final ImageView mealImage;

        public MealItemHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.meal_list);
            calories = itemView.findViewById(R.id.meal_calories);
            ingredients = itemView.findViewById(R.id.meal_ingredients);
            linkToRecipe = itemView.findViewById(R.id.meal_link_recipe);
            description = itemView.findViewById(R.id.meal_description);
            mealImage = itemView.findViewById(R.id.meal_image);

            // Set the OnClickListener to the entire view
            itemView.setOnClickListener(this);
        }

        public void bindTo(MealItem currentMeal) {
            // Populate the textviews with data
            title.setText(currentMeal.getTitle());
            calories.setText(currentMeal.getCalories());
            ingredients.setText(currentMeal.getIngredients());
            linkToRecipe.setText(currentMeal.getLinkToRecipe());
            description.setText(currentMeal.getDescription());
            Glide.with(context).load(currentMeal.getImageResource()).into(mealImage);
        }

        @Override
        public void onClick(View v) {
            MealItem currenMealItem = mealData.get(getAdapterPosition());

            Intent detailIntent = new Intent(context, DetailActivity.class);
            detailIntent.putExtra(TITLE, currenMealItem.getTitle());
            detailIntent.putExtra(CALORIES, currenMealItem.getCalories());
            detailIntent.putExtra(INGREDIENTS, currenMealItem.getIngredients());
            detailIntent.putExtra(RECIPE, currenMealItem.getLinkToRecipe());
            detailIntent.putExtra(DESCRIPTION, currenMealItem.getDescription());
            detailIntent.putExtra(IMAGE, currenMealItem.getImageResource());

            context.startActivity(detailIntent);
        }
    }
}
