package com.itparadise.jenjudan.user.base;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.itparadise.jenjudan.user.base.helper.FragmentHelper;
import com.itparadise.jenjudan.user.base.helper.FunctionHelper;
import com.itparadise.jenjudan.user.base.helper.MessageHelper;
import com.itparadise.jenjudan.user.base.helper.UIHelper;

/**
 * Created by com.itparadise on 04/01/2018.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    public final String TAG = this.getClass().getSimpleName();


    public KProgressHUD hud;

    //UI helper
    public UIHelper uiHelper;
    //function helper
    public FunctionHelper functionHelper;
    //message helper
    public MessageHelper messageHelper;
    //fragment helper
    public FragmentHelper fragmentHelper;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            //initial all helper class here
            //ui helper
            uiHelper = new UIHelper((Activity) context);
            //function helper
            functionHelper = new FunctionHelper((Activity) context);
            //message helper
            messageHelper = new MessageHelper((Activity) context);
            //fragment helper
            fragmentHelper = new FragmentHelper((Activity) context);

        } catch (ClassCastException e) {
            Log.e(TAG, "Error in retrieving data. Please try again");
        }
    }

    //ui helper function start

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
            hud = KProgressHUD.create(getActivity())
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel(title)
                    .setDetailsLabel(msg)
                    .setCancellable(false)
                    .setDimAmount(0.5f)
                    .show();
        } else {
            hud = KProgressHUD.create(getActivity())
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
            hud = KProgressHUD.create(getActivity())
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel(title)
                    .setDetailsLabel(msg)
                    .setCancellable(true)
                    .setDimAmount(0.5f)
                    .show();
        } else {
            hud = KProgressHUD.create(getActivity())
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
            hud = KProgressHUD.create(getActivity())
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel(title)
                    .setDetailsLabel(msg)
                    .setCancellable(false)
                    .show();
        } else {
            hud = KProgressHUD.create(getActivity())
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
        if (hud == null) {
            Log.e(TAG, "dismissLoadingDialog: trying to dismiss a hud object with null val");
            return;
        }
        try {
            hud.dismiss();
            hud = null;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }


    /**
     * Inflater layout function
     *
     * @param inflater
     * @param container
     * @param layout
     * @return
     */
    public ViewGroup getRootView(LayoutInflater inflater, ViewGroup container, int layout) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(layout, container, false);

        //bind components to xml
        bindComponents(rootView);


        setupListener();
//        //set padding below status bar
//        try {
//            uiHelper.setPaddingTopBelowStatusBar(rootView.findViewById(R.id.toolbar));
//        } catch (Exception e) {
//            Log.e(TAG, "No common toolbar found");
//        }

        return rootView;
    }

    /**
     * Bind components to activity
     * need override in every fragment
     *
     * @param rootView
     */
    public void bindComponents(ViewGroup rootView) {

    }

    /**
     * Setup listener for each components
     * need override in every activity
     */
    public abstract void setupListener();


}
