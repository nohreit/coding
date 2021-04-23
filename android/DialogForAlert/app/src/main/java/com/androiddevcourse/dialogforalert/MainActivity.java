package com.androiddevcourse.dialogforalert;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowAlert(View view) {

        AlertDialog.Builder myAlerBuilder = new AlertDialog.Builder(MainActivity.this);
        myAlerBuilder.setTitle("Alert");
        myAlerBuilder.setMessage("Click OK to continue, or Cancel to stop:");

        myAlerBuilder.setPositiveButton(R.string.ok_button, (dialog, which) -> Toast.makeText(getApplicationContext(), R.string.pressed_ok, Toast.LENGTH_SHORT).show());
        myAlerBuilder.setNegativeButton(R.string.cancel_button, (dialog, which) -> Toast.makeText(getApplicationContext(), R.string.pressed_cancel, Toast.LENGTH_SHORT).show());

        myAlerBuilder.show();

    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.datepicker));
    }

    public void processDatePickerResult(int year, int month, int dayOfMonth) {
        String month_string = Integer.toString(month+1),
                day_string = Integer.toString(dayOfMonth),
                year_string = Integer.toString(year),
                dateMessage = (month_string + "/" + day_string + "/" + year_string);
        Toast.makeText(this, "Date: " + dateMessage, Toast.LENGTH_SHORT).show();
    }
}