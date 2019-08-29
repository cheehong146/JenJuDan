package com.itparadise.jenjudan.user.fragment.Home;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.itparadise.jenjudan.databinding.FragmentSettingParentBinding;
import com.itparadise.jenjudan.user.base.BaseFragment;
import com.itparadise.jenjudan.user.fragment.Setting.FragmentParentSetting;
import com.itparadise.jenjudan.user.fragment.Setting.FragmentSetting;

/**
 * Created by IT Paradise on 21/8/2019
 **/

public class FragmentParentHome extends BaseFragment {

    //data binding
    private FragmentParentHome binding;

    //fragment related
    FragmentHome fragmentHome;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TicketFragment.
     */
        public static FragmentParentHome newInstance() {
            FragmentParentHome fragment = new FragmentParentHome();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public FragmentParentHome() {
        // Required empty public constructor
    }

    /*
    @Override
    public FragmentTransaction setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        return;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isAdded() && ticketFragment != null) {
            String currentFragmentStr = fragmentHelper.getCurrentFragmentName(getChildFragmentManager(), R.id.setting_parent);
            if (currentFragmentStr.equalsIgnoreCase(FragmentSetting.class.getSimpleName()) && isVisibleToUser) {
                //case of is showing and current showing ticket fragment page
                ticketFragment.setUserVisibleHint(true);
            } else {
                ticketFragment.setUserVisibleHint(false);
            }
        }
    }*/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {

        }
    }
    /*
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            binding = DataBindingUtil.inflate(
                    inflater, R.layout.fragment_setting_parent, container, false);

            getAllTicketTask();

            initFirstFragment();

            return binding.getRoot();
        }
    */
    @Override
    public void setupListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


        }

    }

    /**
     * initial first fragment
     *//*
    private void initFirstFragment() {
        settingFragment = FragmentSetting.newInstance(ticketList);
        settingFragment.setListener(new FragmentSetting().FragmentListener() {
            @Override
            public void goToFragment(Fragment fragment) {
                fragmentHelper.loadFragment(getChildFragmentManager(), fragment, "Ticket Parents", R.id.fly_ticket_parent);
            }

            @Override
            public void goBack() {
                fragmentHelper.popFragment(getChildFragmentManager());
            }

            public void fetchTicketData() {
                getAllTicketTask();
            }
        });
        fragmentHelper.initFragment(getChildFragmentManager(), ticketFragment, R.id.fly_ticket_parent);
    }
*/
    /**
     * get all ticket task
     */
    /*
    public void getAllTicketTask() {
        showLoadingDialog(Constants.INFO_LOADING, null);

        ApiListener apiListener = ApiClient.getApiListener();
        Call<TicketResponse> call = apiListener.getAllTicket(API_AUTH_CODE, API_TYPE_LIST,
                LocalStorageData.GET_USER_ID(getContext()));
        call.enqueue(new Callback<TicketResponse>() {
            @Override
            public void onResponse(Call<TicketResponse> call, Response<TicketResponse> response) {
                if (response.isSuccessful()) {
                    TicketResponse ticketListResponse = response.body();
                    if (ticketListResponse.getSuccess() == 1) {
                        //case of success
                        updateTicketList(ticketListResponse.getData().getTicketList());
                    }
                }
                dismissLoadingDialog();
            }

            @Override
            public void onFailure(Call<TicketResponse> call, Throwable t) {
                dismissLoadingDialog();
            }
        });
    }
*/
    /**
     * after api successfully called, set the current data and call it's child fragment to update their data using set
     */
    /*
    public void updateTicketList(List<Ticket> ticketListObjectList) {
        //clear list
        this.ticketList.clear();
        this.ticketList.addAll(ticketListObjectList);

        ticketFragment.setData(ticketList);
        ticketFragment.filterData();
        ticketFragment.updateAdapterData();
    }
*/
    /**
     * listener class related
     */
    private com.itparadise.jenjudan.user.fragment.Setting.FragmentParentSetting.FragmentListener listener;

    public void setListener(com.itparadise.jenjudan.user.fragment.Setting.FragmentParentSetting.FragmentListener listener) {
        this.listener = listener;
    }

    public interface FragmentListener {
        void goToFragment(Fragment fragment);

        void fetchTicketData();
    }
}

