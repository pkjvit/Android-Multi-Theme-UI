package com.pkj.wow.multitheme;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Pankaj on 03-11-2017.
 */

public class BaseActivity extends AppCompatActivity {
    public static final int THEME_BLUE = 0;
    public static final int THEME_GRAY = 1;
    public static final int THEME_LIME = 2;
    public static int mTheme = THEME_BLUE;

    public static boolean mIsNightMode = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (mTheme){
            case THEME_BLUE :
                setTheme(R.style.AppTheme_NoActionBar);

                break;
            case THEME_GRAY :
                setTheme(R.style.AppTheme_Grayt);
                break;
            case THEME_LIME :
                setTheme(R.style.AppTheme_Lime);
                break;
            default:
                break;
        }
    }
}
