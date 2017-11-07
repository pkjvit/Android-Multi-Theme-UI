package com.pkj.wow.multitheme;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Pankaj on 03-11-2017.
 */

public class BaseActivity extends AppCompatActivity {
    public static final int THEME_RED = 0;
    public static final int THEME_PINK = 1;
    public static final int THEME_PURPLE = 2;
    public static final int THEME_DEEPPURPLE = 3;
    public static final int THEME_INDIGO = 4;
    public static final int THEME_BLUE = 5;
    public static final int THEME_LIGHTBLUE = 6;
    public static final int THEME_CYAN = 7;
    public static final int THEME_TEAL = 8;
    public static final int THEME_GREEN = 9;
    public static final int THEME_LIGHTGREEN = 10;
    public static final int THEME_LIME = 11;
    public static final int THEME_YELLOW = 12;
    public static final int THEME_AMBER = 13;
    public static final int THEME_ORANGE = 14;
    public static final int THEME_DEEPORANGE = 15;
    public static final int THEME_BROWN = 16;
    public static final int THEME_GRAY = 17;
    public static final int THEME_BLUEGRAY = 18;



    public static int mTheme = THEME_BLUE;

    public static boolean mIsNightMode = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (mTheme){
            case THEME_RED  :
                setTheme(R.style.AppTheme_RED);
                break;
            case THEME_PINK  :
                setTheme(R.style.AppTheme_PINK);
                break;
            case THEME_PURPLE  :
                setTheme(R.style.AppTheme_PURPLE);
                break;
            case THEME_DEEPPURPLE  :
                setTheme(R.style.AppTheme_DEEPPURPLE);
                break;
            case THEME_INDIGO  :
                setTheme(R.style.AppTheme_INDIGO);
                break;
            case THEME_BLUE  :
                setTheme(R.style.AppTheme_BLUE);
                break;
            case THEME_LIGHTBLUE  :
                setTheme(R.style.AppTheme_LIGHTBLUE);
                break;
            case THEME_CYAN  :
                setTheme(R.style.AppTheme_CYAN);
                break;
            case THEME_TEAL  :
                setTheme(R.style.AppTheme_TEAL);
                break;
            case THEME_GREEN  :
                setTheme(R.style.AppTheme_GREEN);
                break;
            case THEME_LIGHTGREEN  :
                setTheme(R.style.AppTheme_LIGHTGREEN);
                break;
            case THEME_LIME  :
                setTheme(R.style.AppTheme_LIME);
                break;
            case THEME_YELLOW  :
                setTheme(R.style.AppTheme_YELLOW);
                break;
            case THEME_AMBER  :
                setTheme(R.style.AppTheme_AMBER);
                break;
            case THEME_ORANGE  :
                setTheme(R.style.AppTheme_ORANGE);
                break;
            case THEME_DEEPORANGE  :
                setTheme(R.style.AppTheme_DEEPORANGE);
                break;
            case THEME_BROWN  :
                setTheme(R.style.AppTheme_BROWN);
                break;
            case THEME_GRAY  :
                setTheme(R.style.AppTheme_GRAY);
                break;
            case THEME_BLUEGRAY  :
                setTheme(R.style.AppTheme_BLUEGRAY);
                break;
            default:
                break;
        }
    }
}
