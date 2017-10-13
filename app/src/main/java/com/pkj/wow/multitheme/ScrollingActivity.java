package com.pkj.wow.multitheme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class ScrollingActivity extends AppCompatActivity {

    public static final int THEME_BLUE = 0;
    public static final int THEME_GRAY = 1;
    public static final int THEME_LIME = 2;
    public static boolean mIsNightMode = false;
    public static int mTheme = THEME_BLUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mIsNightMode = !mIsNightMode;
                if(mIsNightMode){
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                recreate();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickTheme(View view){
        switch (view.getId()){
            case R.id.theme_blue :
                mTheme = THEME_BLUE;
                recreate();

                break;
            case R.id.theme_gray :
                mTheme = THEME_GRAY;
                recreate();

                break;
            case R.id.theme_lime :
                mTheme = THEME_LIME;
                recreate();

                break;
            default:
                break;
        }
    }
}
