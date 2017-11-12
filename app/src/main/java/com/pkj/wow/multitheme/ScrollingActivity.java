package com.pkj.wow.multitheme;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.pkj.wow.multitheme.adapter.ThemeAdapter;
import com.pkj.wow.multitheme.model.Theme;
import com.pkj.wow.multitheme.view.FabProgressLayout;
import com.pkj.wow.multitheme.view.ThemeView;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends BaseActivity implements View.OnClickListener{

    private FabProgressLayout mFabProgressLayout;

    public static List<Theme> mThemeList = new ArrayList<>();
    public static int selectedTheme = 0;
    private RecyclerView mRecyclerView;
    private ThemeAdapter mAdapter;
    private BottomSheetBehavior mBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // get the bottom sheet view
        LinearLayout llBottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);

        // init the bottom sheet behavior
        mBottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // change the state of the bottom sheet
                switch (mBottomSheetBehavior.getState()){
                    case BottomSheetBehavior.STATE_HIDDEN :
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                        break;

                    case BottomSheetBehavior.STATE_COLLAPSED :
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        break;

                    case BottomSheetBehavior.STATE_EXPANDED :
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                        break;
                }
            }
        });

        mFabProgressLayout = findViewById(R.id.fab_progress);
        mFabProgressLayout.setOnClickListener(this);

        SwitchCompat switchCompat = findViewById(R.id.switch_dark_mode);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mIsNightMode = b;
                if(mIsNightMode){
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        mRecyclerView = findViewById(R.id.recyclerView);

        mAdapter = new ThemeAdapter(mThemeList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),4);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        prepareThemeData();

        ThemeView themeView = findViewById(R.id.theme_selected);
        themeView.setTheme(mThemeList.get(selectedTheme));

    }

    private void prepareThemeData() {
        mThemeList.clear();
        mThemeList.add(new Theme(0,R.color.primaryColorRed, R.color.primaryDarkColorRed, R.color.secondaryColorRed));
        mThemeList.add(new Theme(1,R.color.primaryColorPink, R.color.primaryDarkColorPink, R.color.secondaryColorPink));
        mThemeList.add(new Theme(2,R.color.primaryColorPurple, R.color.primaryDarkColorPurple, R.color.secondaryColorPurple));
        mThemeList.add(new Theme(3,R.color.primaryColorDeepPurple, R.color.primaryDarkColorDeepPurple, R.color.secondaryColorDeepPurple));
        mThemeList.add(new Theme(4,R.color.primaryColorIndigo, R.color.primaryDarkColorIndigo, R.color.secondaryColorIndigo));
        mThemeList.add(new Theme(5,R.color.primaryColorBlue, R.color.primaryDarkColorBlue, R.color.secondaryColorBlue));
        mThemeList.add(new Theme(6,R.color.primaryColorLightBlue, R.color.primaryDarkColorLightBlue, R.color.secondaryColorLightBlue));
        mThemeList.add(new Theme(7,R.color.primaryColorCyan, R.color.primaryDarkColorCyan, R.color.secondaryColorCyan));
        mThemeList.add(new Theme(8,R.color.primaryColorTeal, R.color.primaryDarkColorTeal, R.color.secondaryColorTeal));
        mThemeList.add(new Theme(9,R.color.primaryColorGreen, R.color.primaryDarkColorGreen, R.color.secondaryColorGreen));
        mThemeList.add(new Theme(10,R.color.primaryColorLightGreen, R.color.primaryDarkColorLightGreen, R.color.secondaryColorLightGreen));
        mThemeList.add(new Theme(11,R.color.primaryColorLime, R.color.primaryDarkColorLime, R.color.secondaryColorLime));
        mThemeList.add(new Theme(12,R.color.primaryColorYellow, R.color.primaryDarkColorYellow, R.color.secondaryColorYellow));
        mThemeList.add(new Theme(13,R.color.primaryColorAmber, R.color.primaryDarkColorAmber, R.color.secondaryColorAmber));
        mThemeList.add(new Theme(14,R.color.primaryColorOrange, R.color.primaryDarkColorOrange, R.color.secondaryColorOrange));
        mThemeList.add(new Theme(15,R.color.primaryColorDeepOrange, R.color.primaryDarkColorDeepOrange, R.color.secondaryColorDeepOrange));
        mThemeList.add(new Theme(16,R.color.primaryColorBrown, R.color.primaryDarkColorBrown, R.color.secondaryColorBrown));
        mThemeList.add(new Theme(17,R.color.primaryColorGray, R.color.primaryDarkColorGray, R.color.secondaryColorGray));
        mThemeList.add(new Theme(18,R.color.primaryColorBlueGray, R.color.primaryDarkColorBlueGray, R.color.secondaryColorBlueGray));
        mAdapter.notifyDataSetChanged();
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
            case R.id.theme_selected :
                if(mBottomSheetBehavior.getState()!=BottomSheetBehavior.STATE_EXPANDED)
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
        }
    }
}
