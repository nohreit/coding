package com.androiddevcourse.foodapplauncher;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected static final String APP_LAUNCHER = "com.androiddevcourse.foodapplauncher";
    protected static final String I_AM_HOME = APP_LAUNCHER + ".I_AM_HOME";
    private static final String TAG = "Broadcast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendBroadcast(View view) {
        Log.d(TAG, "sendBroadcast: in");
        Intent intent = new Intent();
        intent.setAction(I_AM_HOME);
        Log.d(TAG, "sendBroadcast: intent:" + intent);
        sendBroadcast(intent);
    }
}