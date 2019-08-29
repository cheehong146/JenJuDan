package com.itparadise.jenjudan.user.Dialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.DialogRedeem3Binding;
import com.itparadise.jenjudan.databinding.DialogRedeemBinding;
import com.itparadise.jenjudan.databinding.OrderBinding;
import com.itparadise.jenjudan.user.activity.P_Cart;
import com.itparadise.jenjudan.user.base.BaseFragment;
import com.itparadise.jenjudan.user.fragment.Menu.FragmentMenu;

import fr.tvbarthel.lib.blurdialogfragment.SupportBlurDialogFragment;

/**
 * Created by IT Paradise on 21/8/2019
 **/

public class Dialog_Redeem extends SupportBlurDialogFragment {

    private DialogRedeemBinding binding;

    public Dialog_Redeem(){}
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FavouriteFragment.
     */
    public static Dialog_Redeem newInstance() {
        Dialog_Redeem fragment = new Dialog_Redeem();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.dialog_redeem, container, false);


        return binding.getRoot();
    }

    /**
     * listener related
     */
    ClickListener listener;

    public void setupListener(ClickListener listener) {
        this.listener = listener;
    }



    public interface ClickListener {
        void goToFragment(Fragment fragment);

        void fetchHomeApiData();

        void goBack();
    }

    /**
     * set status bar as padding top
     *
     * @param v
     */
    public void setPaddingTopBelowStatusBar(View v) {
        //get status bar height
        int result = 0;
        int resourceId = getActivity().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {

            result = getActivity().getResources().getDimensionPixelSize(resourceId);
            System.out.println("setting below status bar"+result);
        }
        v.setPadding(0, result, 0, 0);
    }

    @Override
    protected float getDownScaleFactor() {
        return 4.0f;
    }

    @Override
    protected int getBlurRadius() {
        return 4;
    }

    @Override
    protected boolean isDimmingEnable() {
        return false;
    }

    @Override
    protected boolean isDebugEnable() {
        return false;
    }

    @Override
    protected boolean isRenderScriptEnable() {
        return true;
    }

}
