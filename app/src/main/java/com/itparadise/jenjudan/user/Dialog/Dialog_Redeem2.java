package com.itparadise.jenjudan.user.Dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.DialogRedeemBinding;
import com.itparadise.jenjudan.user.base.BaseFragment;
import com.itparadise.jenjudan.user.fragment.Profile.FragmentRedeemAll_P;

import fr.tvbarthel.lib.blurdialogfragment.SupportBlurDialogFragment;

/**
 * Created by IT Paradise on 21/8/2019
 **/

public class Dialog_Redeem2 extends BaseFragment {

    private DialogRedeemBinding binding;

    public Dialog_Redeem2(){}
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FavouriteFragment.
     */
    public static Dialog_Redeem2 newInstance() {
        Dialog_Redeem2 fragment = new Dialog_Redeem2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                inflater, R.layout.dialog_redeem, container, false);

        binding.imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        return binding.getRoot();
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.dialog_redeem, container, false);

        binding.imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view1 = layoutInflater.inflate(R.layout.activity_main, null);
                BottomNavigationView bottomNavigationView = view1.findViewById(R.id.navigation);
                bottomNavigationView.setBackgroundColor(getContext().getResources().getColor(R.color.colorWhite));
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.popBackStack();
            }
        });

        binding.btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view1 = layoutInflater.inflate(R.layout.activity_main, null);
                BottomNavigationView bottomNavigationView = view1.findViewById(R.id.navigation);
                bottomNavigationView.setBackgroundColor(getContext().getResources().getColor(R.color.colorWhite));
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.popBackStack();
            }
        });

        return binding.getRoot();
        //return inflater.inflate(R.layout.dialog_redeem,container,false);
    }



    /**
     * listener related
     */
    ClickListener listener;

    public void setupListener(ClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void setupListener() {

    }

    @Override
    public void onClick(View view) {

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

    private void loadFragment(Fragment fragment) {

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.vp_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}
