package com.dotrinh.androidtalkback;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

import androidx.appcompat.app.AppCompatActivity;

import com.dotrinh.androidtalkback.databinding.MultiLangBinding;

import java.util.List;

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
            // binding.lang2.setText("日本語");
        });
        binding.lang2.setOnClickListener(v -> {
            ctx = LocaleHelper.setLocale(ctx, "ja");
            binding.textView.setText(ctx.getResources().getString(R.string.description));
        });
        // speak_loud("thank you thank you");
        speak_loud("ありがとうございます");
    }

    /**
     * This method checks if Google Talkback is enabled by using the [accessibilityManager]
     */
    public boolean isGoogleTalkbackActive() {
        AccessibilityManager am = (AccessibilityManager) getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (am != null && am.isEnabled()) {
            List<AccessibilityServiceInfo> serviceInfoList = am.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_SPOKEN);
            if (!serviceInfoList.isEmpty())
                return true;
        }
        return false;
    }

    public void speak_loud(String str_speak) {
        if (isGoogleTalkbackActive()) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) getSystemService(Context.ACCESSIBILITY_SERVICE);
            AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain();
            accessibilityEvent.setEventType(AccessibilityEvent.TYPE_ANNOUNCEMENT);

            accessibilityEvent.getText().add(str_speak);
            if (accessibilityManager != null) {
                accessibilityManager.sendAccessibilityEvent(accessibilityEvent);
            }
        }
    }
}