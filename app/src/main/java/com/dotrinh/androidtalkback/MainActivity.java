package com.dotrinh.androidtalkback;

import static com.dotrinh.androidtalkback.LogUtil.LogI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.checkClickThrough).setOnClickListener(v -> LogI("click checkClickThough"));
    }
}