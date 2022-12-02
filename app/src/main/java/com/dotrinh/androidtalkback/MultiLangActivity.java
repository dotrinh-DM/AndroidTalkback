package com.dotrinh.androidtalkback;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.dotrinh.androidtalkback.databinding.MultiLangBinding;

public class MultiLangActivity extends AppCompatActivity {

    public MultiLangBinding binding;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MultiLangBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ctx = this;

        binding.lang1.setOnClickListener(v -> {
            ctx = LocaleHelper.setLocale(ctx, "en");
            binding.textView.setText(ctx.getResources().getString(R.string.description));
        });
        binding.lang2.setOnClickListener(v -> {
            ctx = LocaleHelper.setLocale(ctx, "ja");
            binding.textView.setText(ctx.getResources().getString(R.string.description));
        });
    }
}