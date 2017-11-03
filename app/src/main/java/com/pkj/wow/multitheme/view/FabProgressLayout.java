package com.pkj.wow.multitheme.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.pkj.wow.multitheme.R;

/**
 * Created by Pankaj on 16-10-2017.
 */
//@CoordinatorLayout.DefaultBehavior(FabProgressLayout.Behavior.class)
public class FabProgressLayout extends FrameLayout {
    private ProgressBar mProgressBar;
    private FloatingActionButton mFab;

    public FabProgressLayout(@NonNull Context context) {
        super(context);
    }

    public FabProgressLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        if (getChildCount() == 0 || getChildCount() > 2) {
            throw new IllegalStateException("Specify only 2 views.");
        }

        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if (view instanceof ProgressBar) {
                mProgressBar = (ProgressBar) view;
            } else if (view instanceof FloatingActionButton) {
                mFab = (FloatingActionButton) view;
            } else {
                throw new IllegalStateException("Specify FAB and Progress Bar" +
                        "as view's children in your layout.");
            }
        }

        if (mFab == null) {
            throw new IllegalStateException("Floating Action Button not specified");
        } else if (mProgressBar == null) {
            throw new IllegalStateException("Progress Bar not specified");
        }

        resize();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (mFab != null && mProgressBar != null) {
            resize();
        }
    }

    private void resize() {
        float translationZpx = getResources().getDisplayMetrics().density * 6; // 6 is needed for progress bar to be visible, 5 doesn't work
        if(Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP)
            mProgressBar.setTranslationZ(translationZpx);

        LayoutParams mFabParams = ((LayoutParams) mFab.getLayoutParams());
        LayoutParams mProgressParams = ((LayoutParams) mProgressBar.getLayoutParams());

        int additionSize = getResources().getDimensionPixelSize(R.dimen.progress_bar_size);
        mProgressBar.getLayoutParams().height = mFab.getHeight() + additionSize;
        mProgressBar.getLayoutParams().width = mFab.getWidth() + additionSize;

        mFabParams.gravity = Gravity.CENTER;
        mProgressParams.gravity = Gravity.CENTER;
    }

    public void startProgress(){
        if(mProgressBar!=null)
            mProgressBar.setVisibility(View.VISIBLE);
    }

    public void stopProgress(){
        if(mProgressBar!=null)
            mProgressBar.setVisibility(View.INVISIBLE);
    }

    public static class Behavior extends CoordinatorLayout.Behavior<FabProgressLayout> {
        public Behavior() {
            super();
        }

        public Behavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public boolean layoutDependsOn(CoordinatorLayout parent, FabProgressLayout child,
                                       View dependency) {
            return dependency instanceof Snackbar.SnackbarLayout;
        }

        @Override
        public boolean onDependentViewChanged(CoordinatorLayout parent,
                                              FabProgressLayout child, View dependency) {
            float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
            if (child.getBottom() > dependency.getTop()) {
                child.setTranslationY(translationY);
            }
            return true;
        }
    }

}
