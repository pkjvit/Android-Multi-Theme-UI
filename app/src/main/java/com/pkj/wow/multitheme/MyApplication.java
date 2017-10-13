package com.pkj.wow.multitheme;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by Pankaj on 11-10-2017.
 */

public class MyApplication extends Application {

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
