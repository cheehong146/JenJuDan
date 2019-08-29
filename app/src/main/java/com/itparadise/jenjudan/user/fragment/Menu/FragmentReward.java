package com.itparadise.jenjudan.user.fragment.Menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.OrderBinding;
import com.itparadise.jenjudan.user.activity.P_Cart;
import com.itparadise.jenjudan.user.base.BaseFragment;

/**
 * Created by IT Paradise on 21/8/2019
 **/

public class FragmentReward extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private OrderBinding binding;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FavouriteFragment.
     */
    public static FragmentReward newInstance() {
        FragmentReward fragment = new FragmentReward();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

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
                inflater, R.layout.order, container, false);

        uiHelper.setStatusBarTransparent(true);
        uiHelper.setPaddingTopBelowStatusBar(binding.llToolbar);

        binding.btnOrderBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), P_Cart.class);
                startActivity(intent);
            }
        });

        binding.imgOrderBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentMenu fragmentMenu = new FragmentMenu();
                loadFragment(fragmentMenu);
            }
        });



        //setupListener();

        return binding.getRoot();


    }

@Override
public void setupListener() {

}

    /**
     * listener related
     */
    ClickListener listener;

    public void setupListener(ClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onRefresh() {

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
