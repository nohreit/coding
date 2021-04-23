package com.androiddevcourse.teamsscorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @Title: Teams Score Counter Mini Project 2
 *
 * @Description: This mini project creates a Score Counter App in the main Activity and displays the winner in a second Activity named WinnerActivity.
 *
 * @author Thierno Bah
 *
 *
 */

public class WinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { // here the winner activity is lauched displaying the winner's name and score margin.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        TextView showWinnerName = findViewById(R.id.show_winner_name);
        TextView scoreDifferenceView = findViewById(R.id.score_difference_view);

        Intent intent = getIntent();

        Intent intent1 = getIntent(); // RESULT_OK / RESULT_CANCEL / 2.1_INTENTS



        String[] data = intent.getStringArrayExtra(MainActivity.EXTRA_MESSAGE); // we retried the data from the intent and set them to the views in the two lines of code below.

        showWinnerName.setText(data[0]);
        scoreDifferenceView.setText(data[1]);
    }
}