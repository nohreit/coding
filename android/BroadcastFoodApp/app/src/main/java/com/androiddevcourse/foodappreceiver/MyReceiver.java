package com.androiddevcourse.foodappreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    protected static final String APP_LAUNCHER = "com.androiddevcourse.foodapplauncher";
    protected static final String I_AM_HOME = APP_LAUNCHER + ".I_AM_HOME";
    private static final String TAG = ".MyReceiver";
    private Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        String intentAction = intent.getAction();

        Log.d(TAG, "onReceive: ");
        displayToastForIntentAction(intentAction);
    }

    private void displayToastForIntentAction(String intentAction) {
        if (I_AM_HOME.equals(intentAction)) {
            Log.d("I_AM_HOME", "displayToastForIntentAction: ");
            Toast.makeText(context, "Launches this activity", Toast.LENGTH_SHORT).show();
        }
    }
}