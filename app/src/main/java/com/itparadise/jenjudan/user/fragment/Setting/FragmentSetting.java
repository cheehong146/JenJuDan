package com.itparadise.jenjudan.user.fragment.Setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.SettingsBinding;
import com.itparadise.jenjudan.user.base.BaseFragment;
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

public class FragmentSetting extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private SettingsBinding binding;
/*
    //adapter related
    HomeHappeningAdapter adapterHappening;
    EventHappeningAdapter adapterEvent;
    SpeakerAdapter adapterSpeaker;
    MerchandiseAdapter merchandiseAdapter;

    private List<Happening> happeningList = new ArrayList<>();
    private List<EventDetailed> eventDetailedList = new ArrayList<>();
    private List<SpeakerDetailed> speakerDetailedList = new ArrayList<>();
    private List<FavouriteList> favList = new ArrayList<>();
    private List<Merchandise> merchandiseList = new ArrayList<>();

    //fragment related
    private HomeAllEventFragment homeAllEventFragment;
    private HomeAllSpeakerFragment homeAllSpeakerFragment;
*/
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FavouriteFragment.
     */
    public static FragmentSetting newInstance() {
        FragmentSetting fragment = new FragmentSetting();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentSetting() {}

    /**
     * set event list
     */
    /*
    public void setMainList(List<Happening> happeningList, List<EventDetailed> eventDetailedList, List<SpeakerDetailed> speakerDetailedList, List<FavouriteList> favList, List<Merchandise> merchandises) {
        if (eventDetailedList != null) {
            //case of refresh event list
            this.eventDetailedList.clear();
            this.eventDetailedList.addAll(eventDetailedList);
            refreshEventList();
        } else if (happeningList != null) {
            //case of refresh happening list
            this.happeningList.clear();
            this.happeningList.addAll(happeningList);
            refreshHappeningList();
        } else if (speakerDetailedList != null) {
            //case of refresh speaker list
            this.speakerDetailedList.clear();
            this.speakerDetailedList.addAll(speakerDetailedList);
            refreshSpeakerList();
        } else if (favList != null) {
            //case of refresh speaker list
            this.favList.clear();
            this.favList.addAll(favList);
        } else if (merchandises != null) {
            this.merchandiseList.clear();
            this.merchandiseList.addAll(merchandises);
            refreshMerchandiseList();
        }
    }
*/
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
                inflater, R.layout.settings, container, false);

        uiHelper.setStatusBarTransparent(true);
        uiHelper.setPaddingTopBelowStatusBar(binding.llSetting0);


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
}
