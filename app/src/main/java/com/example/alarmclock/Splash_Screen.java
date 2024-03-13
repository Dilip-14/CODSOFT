package com.example.alarmclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       findViewById(R.id.text123);

      Intent intent = new Intent(Splash_Screen.this,MainActivity.class);
      startActivity(intent);

    }
}