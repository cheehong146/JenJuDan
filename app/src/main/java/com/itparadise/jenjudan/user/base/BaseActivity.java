package com.itparadise.jenjudan.user.base;

import android.content.Context;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.itparadise.jenjudan.user.base.helper.FragmentHelper;
import com.itparadise.jenjudan.user.base.helper.FunctionHelper;
import com.itparadise.jenjudan.user.base.helper.MessageHelper;
import com.itparadise.jenjudan.user.base.helper.UIHelper;
import com.squareup.picasso.Picasso;

//import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by com.itparadise on 02/01/2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {


    public final String TAG = this.getClass().getSimpleName();

    //loading dialog related
    public KProgressHUD hud;

    //UI helper class
    public UIHelper uiHelper = new UIHelper(this);

    //Function helper class
    public FunctionHelper functionHelper = new FunctionHelper(this);

    //Message helper class
    public MessageHelper messageHelper = new MessageHelper(this);

    //fragment helper
    public FragmentHelper fragmentHelper = new FragmentHelper(this);

    boolean close = false;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        //set status bar transparent
        uiHelper.setStatusBarTransparent(false);

//        //set padding bottom for action bar
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        if (toolbar != null) {
//            uiHelper.setPaddingTopBelowStatusBar(toolbar);
//        }
    }
/*
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
*/
    /**
     * show loading dialog
     *
     * @param title
     * @param msg
     */

    public void showLoadingDialog(String title, String msg) {
        if (hud != null) {
            hud.dismiss();
            hud = null;
        }
        if (msg != null) {
            hud = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel(title)
                    .setDetailsLabel(msg)
                    .setCancellable(false)
                    .setDimAmount(0.5f)
                    .show();
        } else {
            hud = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel(title)
                    .setDimAmount(0.5f)
                    .setCancellable(false)
                    .show();
        }
    }

    /**
     * show loading dialog
     *
     * @param title
     * @param msg
     */

    public void showCancelableLoadingDialog(String title, String msg) {
        if (msg != null) {
            hud = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel(title)
                    .setDetailsLabel(msg)
                    .setCancellable(true)
                    .setDimAmount(0.5f)
                    .show();
        } else {
            hud = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel(title)
                    .setDimAmount(0.5f)
                    .setCancellable(true)
                    .show();
        }
    }

    /**
     * show loading dialog without Dim
     *
     * @param title
     * @param msg
     */

    public void showLoadingDialogWithoutDim(String title, String msg) {
        if (msg != null) {
            hud = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel(title)
                    .setDetailsLabel(msg)
                    .setCancellable(false)
                    .show();
        } else {
            hud = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel(title)
                    .setCancellable(false)
                    .show();
        }
    }

    /**
     * Dismiss loading dialog
     */
    public void dismissLoadingDialog() {
        try {
            hud.dismiss();
            hud = null;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    /**
     * Dismiss loading dialog
     *
     * @param sec
     */
    public void dismissLoadingDialogWithDelay(int sec) {
        try {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    hud.dismiss();
                    hud = null;
                }
            }, sec * 1000);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    /**
     * press again to exit function
     */
    public void doubleBackToClose() {
        if (close) {
            finish();
        }
        close = true;
        messageHelper.toastShort("Press again to exit");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                close = false;
            }
        }, 2000);
    }

    /**
     * show dialog fragment
     *
     * @param fragmentManager
     * @param dialogFragment
     * @param tag
     */
    public void showDialogFragment(FragmentManager fragmentManager, Fragment dialogFragment, String tag) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(dialogFragment, tag);
        ft.commit();
    }


    /**
     * override for mvvm structure
     */
    public void initViewModel() {
    }

    /**
     * Bind components to activity
     * need override in every activity
     */
    public void bindComponents() {

    }

    /**
     * Setup listener for each components
     * need override in every activity
     */
    public abstract void setupListener();

}
