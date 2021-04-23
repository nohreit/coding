package com.example.codelab11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Hello World and Aliens");
        Log.w("MainActivity", "Watch out for ambush");
        Log.e("MainActivity", "You have been slayed");
        Log.i("MainActivity", "Welcome to MOBA");
    }
}