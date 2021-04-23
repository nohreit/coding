package com.androiddevcourse.tipcalculator;

/**
 * @author Thierno Bah
 * @Title: Tip Calculator Mini Project 4
 * @Description: This mini project allows the user to enter the bill amount via the virtual keyboard and then use
 * the SeekBar to drag the Tip Percentage and find out what the Tip should be and the Total (Bill + Tip).
 * It also allows the user to split the bill with more people and rounds up or not the tip or the total amount.
 * Moreover, the user can also share the bill through sms.
 * @Video-presentation: https://youtu.be/m29AUFyjIhk
 */

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener, TextWatcher { //

    public static final String TAG = "MainActivity";
    public static final int REQUEST_PERMISSION_SEND_SMS = 1;
    public static final String[] PERMISSION_SEND_SMS_REQUIRED = {
            Manifest.permission.SEND_SMS,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(), percentFormat = NumberFormat.getPercentInstance();

    private String spinnerLabel = "";
    private Spinner spinner;
    private ArrayAdapter<CharSequence> adapter;
    private TextView textViewPercentTip, textViewTotalAmount, textViewTipAmount, textViewPerPerson, messageInput;
    private RadioButton tipOption, totalOption;
    private EditText editTextBillAmount, phoneInput; // Get the phone number from a dialog to make a call
    private android.app.AlertDialog messageDialog;

    private double billAmount = 0.0, percent = 0.0, tip = 0.0, total = 0.0, perPersonAmount = 0.0;
    private int spinnerValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPercentTip = findViewById(R.id.textView_PercentageTip); // Locate and assign the view to the attribute.
        SeekBar seekBar = findViewById(R.id.seek_bar);
        editTextBillAmount = findViewById(R.id.editText_BillAmount);
        textViewTotalAmount = findViewById(R.id.textView_TotalAmount);
        textViewTipAmount = findViewById(R.id.textView_TipAmount);
        spinner = findViewById(R.id.spinner_spliter);
        RadioButton noOption = findViewById(R.id.no_option);
        tipOption = findViewById(R.id.tip_option);
        totalOption = findViewById(R.id.total_option);
//        textViewPerPerson = findViewById(R.id.per_person_amount); // FIX ME: NullPointerException

        // The section bellow process inputs from the user and update text views.
        seekBar.setOnSeekBarChangeListener(this);
        editTextBillAmount.addTextChangedListener(this);
        //end

        setupSpinner();

        // call the calculate() if one of the three radioButtons are selected
        noOption.setChecked(true); // Default option checked
        noOption.setOnClickListener(view -> calculate());
        tipOption.setOnClickListener(view -> calculate());
        totalOption.setOnClickListener(view -> calculate());

    }

    private void spinnerInfo() {
        Log.d(TAG, "inside spinnerInfo()");
        createSpinnerDialog();
    }

    private void createSpinnerDialog() {
        String text = " The \"Split bill\" is used to split the total among friends.";
        AlertDialog.Builder infoSpinnerBuilder = new AlertDialog.Builder(MainActivity.this);
        TextView detailSpinner = new TextView(this);

        infoSpinnerBuilder.setTitle(R.string.info_menu);
        detailSpinner.setText(text);
        detailSpinner.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        detailSpinner.setTextAppearance(R.style.TextAppearance_AppCompat_Body1);
        infoSpinnerBuilder.setView(detailSpinner);
        infoSpinnerBuilder.setPositiveButton(R.string.ok_btn, ((dialog, which) -> dialog.dismiss()));

        AlertDialog infoSpinner = infoSpinnerBuilder.create();
        infoSpinner.show();
    }

    public void setupSpinner() {
        adapter = ArrayAdapter.createFromResource(this, R.array.spinner_split_list, android.R.layout.simple_spinner_item);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
            spinner.setAdapter(adapter);
        }
    }

    private void calculate() {
        Log.d("MainActivity", "inside calculate method.");

        // format percent and display in percentTextView
        textViewPercentTip.setText(percentFormat.format(percent));

        // calculate the tip and total
        tip = (tipOption.isChecked()) ? Math.ceil(billAmount * percent) : billAmount * percent;

        //use the tip example to do the same for the Total
        total = (totalOption.isChecked()) ? Math.ceil(billAmount + tip) : billAmount + tip;

        // calculate the amount each person has to pay
        perPersonAmount = total / spinnerValue;

        // display tip and total formatted as currency
        //user currencyFormat instead of percentFormat to set the textViewTip
        textViewTipAmount.setText(currencyFormat.format(tip));
        //use the tip example to do the same for the Total
        textViewTotalAmount.setText(currencyFormat.format(total));
//        t84562147
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) { // This check the permission and grants or denies it.
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "inside onRequestPermissionsResult()");
        if (requestCode == REQUEST_PERMISSION_SEND_SMS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "permission granted");
                sendMessage();
            } else Log.d(TAG, "permission denied");
        }
    }

    private void sendMessage() { // This sends a message
        Log.d(TAG, "inside sendMessage()");
        createMessageDialog();
        changesOnInputMessageDialog();
    }

    private void createMessageDialog() {
        android.app.AlertDialog.Builder messageDialogBuilder = new android.app.AlertDialog.Builder(MainActivity.this);

        messageDialogBuilder.setTitle(R.string.message_dialog_title);
        phoneInput = new EditText(this);
        phoneInput.setInputType(InputType.TYPE_CLASS_PHONE);
        phoneInput.setHint(R.string.enter_phone_hint);

        messageInput = new TextView(this);
        messageInput.setText(String.format(Locale.US,
                "%d person(s) will pay this bill amount: $%.2f\nThe tip is: $%.2f\nSo each one pays: $%.2f"
                , spinnerValue, total, tip, perPersonAmount)
        );

        messageInput.setTextSize(32);
        messageInput.setTextAppearance(R.style.TextAppearance_AppCompat_Large);

        LinearLayout linearLayout = new LinearLayout(this); // Note to self: Set this layout to display all view
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(phoneInput);
        linearLayout.addView(messageInput);

        messageDialogBuilder.setView(linearLayout);

        messageDialogBuilder.setPositiveButton(R.string.send_message_btn, (dialog, which) -> {
            Log.d(TAG, "inside callDialogBuilder.setPositiveButton()");
            onClickSendMessage();
        });

        messageDialogBuilder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());

        messageDialog = messageDialogBuilder.create();

        messageDialog.show();

        messageDialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE).setEnabled(false);
    }

    @SuppressLint("QueryPermissionsNeeded")
    private void onClickSendMessage() {
        String getNumber = "smsto:" + phoneInput.getText().toString();
        Log.d(TAG, "Phone number: " + getNumber);
        String msg = messageInput.getText().toString();
        Log.d(TAG, "Message: " + msg);

        if (checkPermissions()) {
            Toast.makeText(this, "Sending message...", Toast.LENGTH_SHORT).show();
            // Use the default sms app on the device to send the message.
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(getNumber, null, msg, null, null);
        }
    }

    private boolean checkPermissions() {
        Log.d(TAG, "inside of checkPermissions()");
        AtomicBoolean permissionGranted = new AtomicBoolean(true);
        for (String permission : PERMISSION_SEND_SMS_REQUIRED) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionGranted.set(false);
                Log.d(TAG, "PERMISSION DENIED " + permission);
                ActivityCompat.requestPermissions(this, new String[]{permission}, REQUEST_PERMISSION_SEND_SMS);
            }
        }
        return permissionGranted.get();
    }

    private void changesOnInputMessageDialog() {
        phoneInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                messageDialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE).setEnabled(s.length() > 0); // Enable the button
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        Log.d("MainActivity", "inside onTextChanged method: charSequence = " + s); // Output message for debugging purpose.

        billAmount = s.toString().equals("") ? 0.0 : Double.parseDouble(s.toString()); // On the starter code the bill amount was divided by 100
        Log.d("MainActivity", "Bill Amount = " + billAmount);

        calculate();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { // Note to self: parent is the adapter
        spinnerLabel = parent.getItemAtPosition(position).toString();
        spinnerValue = Integer.parseInt(spinnerLabel);
        Log.d(TAG, "spinnerLabel: " + spinnerLabel + "; spinnerValue: " + spinnerValue);
        if (!spinnerLabel.equals(parent.getItemAtPosition(0))) {
            Log.d(TAG, "first item not selected...");
        }
        calculate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        percent = (double) progress / 100;
        calculate(); // This method is to calculate the tip based on the tip percentage, and the total amount of the bill.
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                sendMessage();
                return true;
            case R.id.action_info:
                spinnerInfo();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}