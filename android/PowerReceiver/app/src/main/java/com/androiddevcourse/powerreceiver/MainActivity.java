package com.androiddevcourse.powerreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CustomReceiver receiver;
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new CustomReceiver();

        registerReceiver(receiver, addIntentFilters());

        // Register the receiver using the activity context.
        this.registerReceiver(receiver, addIntentFilters());

        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter(ACTION_CUSTOM_BROADCAST));
    }

    private IntentFilter addIntentFilters() {
        IntentFilter filter = new IntentFilter();

        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_HEADSET_PLUG);
        filter.addAction(ACTION_CUSTOM_BROADCAST);
        return filter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(receiver);
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }

    public void sendCustomBroadcast(View view) {
        Intent customBroadcastIntent = new Intent();
        customBroadcastIntent.setAction(ACTION_CUSTOM_BROADCAST);
        sendBroadcast(customBroadcastIntent);
//        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }
}