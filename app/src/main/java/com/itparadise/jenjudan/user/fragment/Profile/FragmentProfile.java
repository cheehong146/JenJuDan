package com.itparadise.jenjudan.user.fragment.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.ActivityHomepageBinding;
import com.itparadise.jenjudan.databinding.ActivityMainBinding;
import com.itparadise.jenjudan.databinding.ProfileAccountBinding;
import com.itparadise.jenjudan.user.activity.MainActivity;
import com.itparadise.jenjudan.user.activity.P_Store;
import com.itparadise.jenjudan.user.adapter.Features.AdapterFeatures;
import com.itparadise.jenjudan.user.adapter.Redemption.AdapterRedemption;
import com.itparadise.jenjudan.user.base.BaseFragment;
import com.itparadise.jenjudan.user.fragment.Home.FragmentHome;

import java.util.ArrayList;
import java.util.Objects;
/*
import com.itparadise.jenjudan.user.adapter.Home.event.EventHappeningAdapter;
import com.itparadise.jenjudan.user.adapter.Home.happening.HomeHappeningAdapter;
import com.itparadise.jenjudan.user.adapter.Home.speaker.SpeakerAdapter;
import com.itparadise.jenjudan.user.base.helper.ListFilterHelper;
import com.itparadise.jenjudan.databinding.ActivityHomepageBinding;
import com.itparadise.jenjudan.user.fragment.home.events.EventDetailsFragment;
import com.itparadise.jenjudan.user.fragment.home.events.HomeAllEventFragment;
import com.itparadise.jenjudan.user.fragment.home.happenings.HappeningTimelineFragment;
import com.itparadise.jenjudan.user.fragment.home.merchandise.HomeAllMerchandiseFragment;
import com.itparadise.jenjudan.user.fragment.home.merchandise.MerchandiseAdapter;
import com.itparadise.jenjudan.user.fragment.home.merchandise.MerchandiseDetailsFragment;
import com.itparadise.jenjudan.user.fragment.home.speakers.HomeAllSpeakerFragment;
import com.itparadise.jenjudan.user.fragment.home.speakers.SpeakerDetailsFragment;
import com.itparadise.jenjudan.user.model.event.EventDetailed;
import com.itparadise.jenjudan.user.model.favourite.FavouriteList;
import com.itparadise.jenjudan.user.model.happening.lastestHappening.Happening;
import com.itparadise.jenjudan.user.model.mechandise.Merchandise;
import com.itparadise.jenjudan.user.model.speaker.SpeakerDetailed;
*/

/**
 * Created by IT Paradise on 21/8/2019
 **/

public class FragmentProfile extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private ProfileAccountBinding binding;
    ImageView back;
    private ArrayList<String> redeemImgUrls = new ArrayList<>();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FavouriteFragment.
     */
    public static FragmentProfile newInstance() {
        FragmentProfile fragment = new FragmentProfile();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        initFeatureContent();

    }

    @Override
    public void onResume() {
        super.onResume();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        //Toast.makeText(getContext(), fm.getBackStackEntryCount()+"profile return",Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                inflater, R.layout.profile_account, container, false);

        setPaddingTopBelowStatusBar(binding.llToolbar);
        uiHelper.setStatusBarTransparent(true);
        //uiHelper.setPaddingTopBelowStatusBar(binding.llAccount1);

        binding.imgProfileBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().onBackPressed();




                //View view2 = bottomNavigationView.findViewById(R.id.navigation_home);
                //view2.performClick();
            }
        });

        binding.accountSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFragment(new FragmentRedeemAll_P());
                FragmentManager fm = getActivity().getSupportFragmentManager();
               // Toast.makeText(getContext(), fm.getBackStackEntryCount()+"profile",Toast.LENGTH_SHORT).show();

            }
        });

        //setupListener();

        LinearLayoutManager lm_redeem = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView rvRedeem = binding.rvRedeem;
        rvRedeem.setLayoutManager(lm_redeem);
        AdapterRedemption adapterFeatures = new AdapterRedemption(redeemImgUrls, getContext());
        rvRedeem.setAdapter(adapterFeatures);

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


    private void initFeatureContent(){
        Log.d(TAG, "initFeatureContent");

        redeemImgUrls.add("https://pickledplum.com/wp-content/uploads/2019/02/homemade-bubble-tea-4OPTM.jpg");

        redeemImgUrls.add("https://images.says.com/uploads/story_source/source_image/696069/0a76.jpg");

        redeemImgUrls.add("https://ichef.bbci.co.uk/news/660/cpsprodpb/17872/production/_107407369_tea.png");

        redeemImgUrls.add("https://www.vitamix.com/media/other/images/500xNxIced-Matcha-Bubble-Tea-470-449.jpg.pagespeed.ic.20R5IQCOGA.jpg");

        redeemImgUrls.add("https://hoodline.imgix.net/uploads/story/image/34081/17523251_1418625778201394_279125323341231461_n.jpg");

        redeemImgUrls.add("https://trademe.tmcdn.co.nz/photoserver/plus/933715986.jpg");

        redeemImgUrls.add("https://d1dxs113ar9ebd.cloudfront.net/225batonrouge/2019/01/43-Teatery-1024x683.jpg");

    }


}
