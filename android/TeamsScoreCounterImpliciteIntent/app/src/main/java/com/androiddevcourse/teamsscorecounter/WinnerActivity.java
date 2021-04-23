package com.androiddevcourse.teamsscorecounter;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/*
 * @author Thierno Bah
 * @Title: Teams Score Counter Mini Project 3
 * @Description: This mini project creates a Score Counter App in the main Activity and displays the winner in a second Activity named WinnerActivity.
 *               It also allow the user to share the news of the winner by call or message. It also look for the nearest arena for the sport the app support (i.e. "Soccer near me", "Basketball near me", ...).
 * @Sources: https://stackoverflow.com/questions/16169787/how-to-add-two-edit-text-fields-or-views-in-an-alertdialog-box
 *           https://stackoverflow.com/questions/8238952/how-to-disable-enable-dialog-negative-positive-buttons
 * @Video-presentation: https://youtu.be/NIMqU5EsElQ
 * By the way, in the video presentation of the MP3, I forgot to show the Lifecycle supporting the rotation but I made sure it works on the project.
 */

public class WinnerActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    public static final int REQUEST_PERMISSION_PHONE_CALL = 0;
    public static final int REQUEST_PERMISSION_SEND_SMS = 1;
    public static final String[] PERMISSION_SEND_SMS_REQUIRED = {
            Manifest.permission.SEND_SMS,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    private String winner, scoreDiff;

    private EditText phoneInput; // Get the phone number from a dialog to make a call
    private TextView messageInput;

    private AlertDialog callDialog; // call dialog
    private AlertDialog messageDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) { // here the winner activity is launched displaying the winner's name and score margin.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        TextView showWinnerName = findViewById(R.id.show_winner_name);
        TextView scoreDifferenceView = findViewById(R.id.score_difference_view);
        Intent winnerIntent = getIntent();
//        Intent intent1 = getIntent(); // RESULT_OK / RESULT_CANCEL / 2.1_INTENTS

        FloatingActionButton makeCallFab = findViewById(R.id.call_fab);
        FloatingActionButton sendMessageFab = findViewById(R.id.message_fab);
        FloatingActionButton searchMapFab = findViewById(R.id.map_fab);
//        phoneNumber = (EditText) findViewById(R.id.call_friend);

        String[] data = winnerIntent.getStringArrayExtra(MainActivity.EXTRA_MESSAGE); // we retried the data from the intent and set them to the views in the two lines of code below.

        winner = data[0]; // Just for reference
        scoreDiff = data[1];

        showWinnerName.setText(winner); // Display the winner name
        scoreDifferenceView.setText(scoreDiff); // // Display the score difference

        makeCallFab.setOnClickListener(view -> makeCall());
        sendMessageFab.setOnClickListener(view -> sendMessage());
        searchMapFab.setOnClickListener(view -> searchMap());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) { // This check the permission and grants or denies it.
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "inside onRequestPermissionsResult()");
        switch (requestCode) {
            case REQUEST_PERMISSION_PHONE_CALL:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "permission granted");
                    makeCall();
                } else Log.d(TAG, "permission denied");
                break;
            case REQUEST_PERMISSION_SEND_SMS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "permission granted");
                    sendMessage();
                } else Log.d(TAG, "permission denied");
                break;
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private void makeCall() { // This makes a call
        Log.d(TAG, "inside makeCall()");
        createPhoneNumberDialog();
        changesOnInputCallDialog();
    }

    private void sendMessage() { // This sends a message
        Log.d(TAG, "inside sendMessage()");
        createMessageDialog();
        changesOnInputMessageDialog();
    }

    private void searchMap() {
        Log.d(TAG, "inside searchMap()");
        Uri search = Uri.parse("geo:0,0?q=soccer near me");

        Intent searchIntent = new Intent(Intent.ACTION_VIEW, search);
        startActivity(searchIntent);
    }

    private void createPhoneNumberDialog() { // Creates the dialog for the phone call
        AlertDialog.Builder callDialogBuilder = new AlertDialog.Builder(WinnerActivity.this);

        // Below is to define the edit text view for the input
        callDialogBuilder.setTitle(R.string.call_dialog_title);

        phoneInput = new EditText(this);
        phoneInput.setInputType(InputType.TYPE_CLASS_PHONE);
        phoneInput.setHint(R.string.enter_friend_phone_hint);

        callDialogBuilder.setView(phoneInput); // Add the view to the dialog

        callDialogBuilder.setPositiveButton(R.string.call_btn, (dialog, which) -> { // Create a "call" button and define the action
            Log.d(TAG, "inside callDialogBuilder.setPositiveButton()");
            onClickMakeCall();
        });

        callDialogBuilder.setNegativeButton(R.string.cancel_btn, (dialog, which) -> dialog.dismiss());

        callDialog = callDialogBuilder.create();

        callDialog.show(); // Note to self: This line should always come before any kind of view modification

        callDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false); // Disable the button
    }

    private void createMessageDialog() {
        AlertDialog.Builder messageDialogBuilder = new AlertDialog.Builder(WinnerActivity.this);

        messageDialogBuilder.setTitle(R.string.message_dialog_title);
        phoneInput = new EditText(this);
        phoneInput.setInputType(InputType.TYPE_CLASS_PHONE);
        phoneInput.setHint(R.string.enter_friend_phone_hint);

        messageInput = new TextView(this);
        messageInput.setText(String.format(Locale.US, "%s won by %s", winner, scoreDiff));
        messageInput.setTextSize(32);
        messageInput.setTextAppearance(R.style.TextAppearance_AppCompat_Large);
        messageInput.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

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

        messageDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
    }

    @SuppressLint("QueryPermissionsNeeded")
    private void onClickMakeCall() { // Action call for the "call" button
        String getNumber = "tel:" + phoneInput.getText().toString();
        Log.d(TAG, "Phone number: " + getNumber);
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(getNumber));
        if (callIntent.resolveActivity(getPackageManager()) != null) { // Checking the permission to make a call
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.CALL_PHONE}, REQUEST_PERMISSION_PHONE_CALL);
            } else startActivity(callIntent);
        }
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

    private void changesOnInputCallDialog() { // Activate the call button of the dialog
        phoneInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "inside changesOnInputCallDialog().afterTextChanged()\n getContext : " + callDialog.getContext());
                callDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(s.length() > 0); // Enable the button
            }
        });
    }

    private void changesOnInputMessageDialog() { // New addition
        phoneInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                messageDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(s.length() > 0); // Enable the button
            }
        });
    }
}