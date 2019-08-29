package com.itparadise.jenjudan.user.base.helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * All UI related function declare here
 * Created by Gimon on 3/17/2018.
 */

public class UIHelper {

    private Activity activity;

    public UIHelper(Activity activity) {
        this.activity = activity;
    }

    /**
     * Set full screen activity
     */
    public void setFullScreen() {
        // To make activity full screen.
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    /**
     * Set status bar color
     *
     * @param color
     */
    public void setStatusBar(int color) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(color);
        }
    }

    /**
     * Set window status bar fully transparent
     */
    public void setStatusBarTransparent(boolean shouldChangeStatusBarTintToDark) {
        int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        boolean on = true;
        boolean set = false;

        //make full transparent statusBar
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            on = true;
            set = true;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            on = false;
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            set = true;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decor = activity.getWindow().getDecorView();
            if (shouldChangeStatusBarTintToDark) {
                decor.setSystemUiVisibility(decor.getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }

        if (set) {
            Window win = activity.getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }

    /**
     * set status bar as padding top
     *
     * @param v
     */
    public void setPaddingTopBelowStatusBar(View v) {
        //get status bar height
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {

            result = activity.getResources().getDimensionPixelSize(resourceId);
            System.out.println("setting below status bar"+result);
        }
        v.setPadding(0, result, 0, 0);
    }

    /**
     * set view as status bar height
     *
     * @param v
     */
    public void setViewAsStatusBarHeight(View v) {
        //get status bar height
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        layoutParams.height = result;
        v.setLayoutParams(layoutParams);
    }

    /**
     * Get the actionBar height
     *
     * @return
     */
    public int getActionBarHeight() {
        // Calculate ActionBar's height
        TypedValue tv = new TypedValue();
        int actionBarHeight = 0;
        if (activity.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, activity.getResources().getDisplayMetrics());
        }
        return actionBarHeight;
    }

    /**
     * get width based on screen size
     *
     * @param context
     * @return
     */
    public int getWidth(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        return width;
    }

    /**
     * set width based
     *
     * @param layout
     * @param width
     */
    public void setWidth(View layout, double width) {
        ViewGroup.LayoutParams params = layout.getLayoutParams();
        params.width = (int) width;
    }


}
