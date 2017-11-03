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

import com.pkj.wow.multitheme.model.Theme;
import com.pkj.wow.multitheme.view.FabProgressLayout;
import com.pkj.wow.multitheme.view.ThemeView;

public class ScrollingActivity extends BaseActivity implements View.OnClickListener{

    private FabProgressLayout mFabProgressLayout;
    private ThemeView mThemeBlue;
    private ThemeView mThemeGray;
    private ThemeView mThemeLime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mThemeBlue = findViewById(R.id.theme_view_blue);
        mThemeBlue.setThemeColor(new Theme(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent));
        mThemeGray = findViewById(R.id.theme_view_gray);
        mThemeGray.setThemeColor(new Theme(R.color.colorPrimary_Gray, R.color.colorPrimaryDark_Gray, R.color.colorAccent_Gray));
        mThemeLime = findViewById(R.id.theme_view_lime);
        mThemeLime.setThemeColor(new Theme(R.color.colorPrimaryLime, R.color.colorPrimaryDarkLime, R.color.colorAccentLime));

        updateTheme();

        FloatingActionButton fab = findViewById(R.id.fab);
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

        mFabProgressLayout = (FabProgressLayout) findViewById(R.id.fab_progress);
        mFabProgressLayout.setOnClickListener(this);

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
            case R.id.theme_view_blue :
                mTheme = THEME_BLUE;
                recreate();
                break;

            case R.id.theme_gray :
            case R.id.theme_view_gray :
                mTheme = THEME_GRAY;
                recreate();
                break;

            case R.id.theme_lime :
            case R.id.theme_view_lime :
                mTheme = THEME_LIME;
                recreate();
                break;

            default:
                break;
        }
    }

    private void updateTheme(){
        switch (mTheme){
            case THEME_BLUE :
                mThemeBlue.setActivated(true);
                mThemeGray.setActivated(false);
                mThemeLime.setActivated(false);
                break;
            case THEME_GRAY :
                mThemeBlue.setActivated(false);
                mThemeGray.setActivated(true);
                mThemeLime.setActivated(false);
                break;
            case THEME_LIME :
                mThemeBlue.setActivated(false);
                mThemeGray.setActivated(false);
                mThemeLime.setActivated(true);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_progress :
                mFabProgressLayout.startProgress();
                mFabProgressLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mFabProgressLayout.stopProgress();
                    }
                },5000);
                break;
        }
    }
}
