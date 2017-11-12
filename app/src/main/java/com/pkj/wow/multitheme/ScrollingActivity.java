package com.pkj.wow.multitheme;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
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

import com.pkj.wow.multitheme.adapter.RecyclerViewClickListener;
import com.pkj.wow.multitheme.adapter.SectionsPagerAdapter;
import com.pkj.wow.multitheme.adapter.ThemeAdapter;
import com.pkj.wow.multitheme.model.Theme;
import com.pkj.wow.multitheme.util.ThemeUtil;
import com.pkj.wow.multitheme.view.FabProgressLayout;
import com.pkj.wow.multitheme.view.ThemeView;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends BaseActivity implements View.OnClickListener{
    private SectionsPagerAdapter    mSectionsPagerAdapter;
    private ViewPager               mViewPager;

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

        initBottomSheet();

        prepareThemeData();

        ThemeView themeView = findViewById(R.id.theme_selected);
        themeView.setTheme(mThemeList.get(selectedTheme));

        //------------ view pager and tabs
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void initBottomSheet(){
        // get the bottom sheet view
        LinearLayout llBottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);

        // init the bottom sheet behavior
        mBottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);

        SwitchCompat switchCompat = findViewById(R.id.switch_dark_mode);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mIsNightMode = b;
                int delayTime = 200;
                if(mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED){
                    delayTime = 400;
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                compoundButton.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(mIsNightMode){
                            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        }else{
                            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        }
                    }
                },delayTime);

            }
        });

        mRecyclerView = findViewById(R.id.recyclerView);

        mAdapter = new ThemeAdapter(mThemeList, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ScrollingActivity.this.recreate();
                    }
                },400);
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),4);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void prepareThemeData() {
        mThemeList.clear();
        mThemeList.addAll(ThemeUtil.getThemeList());
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
            case R.id.theme_selected :
            case R.id.fab:
                // change the state of the bottom sheet
                switch (mBottomSheetBehavior.getState()){
                    case BottomSheetBehavior.STATE_HIDDEN :
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                        break;

                    case BottomSheetBehavior.STATE_COLLAPSED :
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        break;

                    case BottomSheetBehavior.STATE_EXPANDED :
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                        break;
                }
                break;
        }
    }


}
