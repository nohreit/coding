package com.androiddevcourse.teamsscorecounter;

/**
 * @Title: Teams Score Counter Mini Project 2
 *
 * @Description: This mini project creates a Score Counter App in the main Activity and displays the winner in a second Activity named WinnerActivity.
 *
 * @author Thierno Bah
 *
 * @Presentation: https://youtu.be/9Qq_gWr8dBY
 */

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull; // To specify that the parameter not to be null
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.androiddevcourse.teamscorecounter.MESSAGE";
    public static final String TEAM_SCORE_LEFT_KEY = "com.androiddevcourse.teamscorecounter.team_score_left";
    public static final String TEAM_SCORE_RIGHT_KEY = "com.androiddevcourse.teamscorecounter.team_score_right";
//    public static final int REPLAY_REQUEST = 1; // Feature considering to implement (play again)

    private TextView teamNameLeft;
    private TextView teamNameRight;
    private TextView teamScoreLeft;
    private TextView teamScoreRight;
    private Button teamBtnLeft;
    private Button teamBtnRight;
    private int countLeft = 0;
    private int countRight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "------------"); // For debugging purpose
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        teamNameLeft = findViewById(R.id.team_name_left);
        teamNameRight = findViewById(R.id.team_name_right);
        teamScoreLeft = findViewById(R.id.team_score_left);
        teamScoreRight = findViewById(R.id.team_score_right);
        teamBtnLeft = findViewById(R.id.team_btn_left);
        teamBtnRight = findViewById(R.id.team_btn_right);


        if (savedInstanceState != null) { // If there is any change in the app, we execute the body
            countLeft = Integer.parseInt(savedInstanceState.getString(TEAM_SCORE_LEFT_KEY)); // reassign the previous count before the changes in the app.
            Log.d(TAG, "counterLeft: "+countLeft);
            teamScoreLeft.setText(String.format(Locale.US, "%d", countLeft)); // same thing as above but for the textview.

            countRight = Integer.parseInt(savedInstanceState.getString(TEAM_SCORE_RIGHT_KEY));
            Log.d(TAG, "counterRight: "+countRight);
            teamScoreRight.setText(String.format(Locale.US, "%d", countRight));
        }
    }

    // The code below were for debugging purpose
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
//        resetValues(); // Crashes
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
//        resetValues(); // Crashes
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) { // Here we save the data right before any changes in the app (the rotation)
        super.onSaveInstanceState(outState);
        if (!teamScoreLeft.getText().toString().equals("0") || !teamScoreRight.getText().toString().equals("0")) {
            outState.putString(TEAM_SCORE_LEFT_KEY, teamScoreLeft.getText().toString());
            outState.putString(TEAM_SCORE_RIGHT_KEY, teamScoreRight.getText().toString());
        }
    }

    public void addScore(View view) { // This method add one point each time the button is clicked
        Log.d(TAG, "inside addScore()");

        String btnViewName = view.getResources().getResourceName(view.getId());
        String teamBtnLeftName = teamBtnLeft.getResources().getResourceName(teamBtnLeft.getId());
        String teamBtnRightName = teamBtnRight.getResources().getResourceName(teamBtnRight.getId());

        if (btnViewName.equals(teamBtnLeftName)) {
            countLeft++;
            Log.i(TAG, "count -> " + countLeft);

            Log.i(TAG, "inside first if -> " + btnViewName + " == " + teamBtnLeftName);
            teamScoreLeft.setText(String.format(Locale.US, "%d", countLeft));
            isWinner();
        } else if (btnViewName.equals(teamBtnRightName)) {
            countRight++;
            Log.i(TAG, "count -> " + countRight);

            Log.i(TAG, "inside first else if -> " + btnViewName + " == " + teamBtnRightName);
            teamScoreRight.setText(String.format(Locale.US, "%d", countRight));
            isWinner();
        }
    }

    private void isWinner() { // This method is to check if there is a winner and who is the winner
        Log.i(TAG, "inside isWinner()");
        if (teamScoreLeft.getText().toString().equals("5")) {
            Log.i(TAG, "");
            launchWinnerActivity(teamNameLeft.getText().toString(), Math.abs(countLeft - countRight)); // Here we launch the winner activity that display the winner's name and score margin
            Log.d(TAG, "after lauchWinnerActivity");
            resetValues(); // Rest all value when there is a winner
        } else if (teamScoreRight.getText().toString().equals("5")) {
            launchWinnerActivity(teamNameRight.getText().toString(), Math.abs(countRight - countLeft));
            Log.d(TAG, "after lauchWinnerActivity");
            resetValues();
        }
    }

    private void resetValues() {
        countLeft = 0;
        countRight = 0;
        teamScoreLeft.setText(String.format(Locale.US, "%d", countLeft));
        teamScoreRight.setText(String.format(Locale.US, "%d", countRight));
    }

    public void launchWinnerActivity(String winnerName, int scoreDifference) { // When this method is executed, it send the data collected from this activity to the winner activity. I though of using an array to send multiple values.
        Log.d(TAG, "inside launchWinnerActivity()");

        Intent intent = new Intent(this, WinnerActivity.class);
        String[] data = {winnerName, String.valueOf(scoreDifference)};
        intent.putExtra(EXTRA_MESSAGE, data);
        startActivity(intent);
    }
}