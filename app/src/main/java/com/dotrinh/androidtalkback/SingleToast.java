/*
 * Copyright (c) 2019. USE Inc
 */

package com.dotrinh.androidtalkback;

import android.content.Context;
import android.widget.Toast;

public class SingleToast {

    private static SingleToast ourInstance = new SingleToast();
    private static Toast toast;

    public static synchronized SingleToast getInstance() {
        if (ourInstance == null) {
            ourInstance = new SingleToast();
        }
        return ourInstance;
    }

    public void showShortToast(Context ct, String message) {
        if (null != toast) {
            toast.cancel();
        }
        (toast = Toast.makeText(ct, message, Toast.LENGTH_SHORT)).show();
    }

    public void showLongToast(Context ct, String message) {
        if (null != toast) toast.cancel();
        (toast = Toast.makeText(ct, message, Toast.LENGTH_LONG)).show();
    }
}
