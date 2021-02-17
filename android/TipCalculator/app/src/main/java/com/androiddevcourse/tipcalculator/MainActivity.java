package com.androiddevcourse.tipcalculator;

/**
 * @Title: Tip Calculator Mini Project 1
 *
 * @Description: This mini project allows the user to enter the bill amount via the virtual keyboard and then use
 * the SeekBar to drag the Tip Percentage and find out what the Tip should be and the Total (Bill + Tip).
 *
 * @author Thierno Bah
 *
 *
 */

import android.annotation.SuppressLint;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity /*implements TextWatcher, SeekBar.OnSeekBarChangeListener*/ { //


    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat = NumberFormat.getPercentInstance();

    private TextView textViewPercentTip;
    private TextView textViewTotalAmount;
    private TextView textViewTipAmount;

    private double billAmount = 0.0;
    private double percent = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The section bellow update the text view of the tip percentage every time there is a change on the seek bar
        textViewPercentTip = findViewById(R.id.textView_PercentageTip); // Locate and assign the view to the attribute.
        SeekBar seekBar = findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // The listener observes every change on the seek bar triggering the three methods bellow.
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { // Each change trigger this methods and execute the body.
                percent = (double) progress / 100;
                calculate(); // This method is to calculate the tip based on the tip percentage, and the total amount of the bill.
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // The section bellow process inputs from the user and update text views.
        EditText editTextBillAmount = findViewById(R.id.editText_BillAmount); // Locate the edit text widget (the input field)

        textViewTotalAmount = findViewById(R.id.textView_TotalAmount); 

        textViewTipAmount = findViewById(R.id.textView_TipAmount);

        editTextBillAmount.addTextChangedListener(new TextWatcher() { // The listener observes and triggers the methods within it body for every change on the edit text.
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { // This method get triggered at each update and execute the body.
                Log.d("MainActivity", "inside onTextChanged method: charSequence = " + s); // Output message for debugging purpose.

                billAmount = s.toString().equals("") ? 0.0 : Double.parseDouble(s.toString()); // On the starter code the bill amount was divided by 100

                Log.d("MainActivity", "Bill Amount = " + billAmount);

                calculate();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //end
    }

    private void calculate() {
        Log.d("MainActivity", "inside calculate method.");

        // format percent and display in percentTextView
        textViewPercentTip.setText(percentFormat.format(percent));

        // calculate the tip and total
        double tip = billAmount * percent;
        //use the tip example to do the same for the Total
        double total = billAmount + tip;
        Log.d("MainActivity", "inside calculate method -> tip: "+ tip+"; total: "+ total);

        // display tip and total formatted as currency
        //user currencyFormat instead of percentFormat to set the textViewTip
        textViewTipAmount.setText(currencyFormat.format(tip));
        //use the tip example to do the same for the Total
        textViewTotalAmount.setText(currencyFormat.format(total));
    }
}