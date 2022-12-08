package com.dotrinh.androidtalkback;

import static com.dotrinh.androidtalkback.LogUtil.LogI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

import com.dotrinh.androidtalkback.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ctx = this;

        binding.checkClickThrough.setOnClickListener(v -> LogI("click checkClickThough"));
        binding.button2.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);

        //target to specific a view
        binding.getRoot().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.textView.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
            }
        }, 300);
    }
}