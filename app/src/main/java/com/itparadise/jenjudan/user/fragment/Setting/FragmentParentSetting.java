package com.itparadise.jenjudan.user.fragment.Setting;

/**
 * Created by IT Paradise on 21/8/2019
 **/

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.user.base.BaseFragment;
import com.itparadise.jenjudan.databinding.FragmentSettingParentBinding;

public class FragmentParentSetting extends BaseFragment {

    //data binding
    private FragmentSettingParentBinding binding;

    //fragment related
    FragmentSetting settingFragment;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TicketFragment.
     */
    public static FragmentParentSetting newInstance() {
        FragmentParentSetting fragment = new FragmentParentSetting();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public FragmentParentSetting() {
        // Required empty public constructor
    }

    /*
    @Override
    public FragmentTransaction setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        return;
    }
*/

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isAdded() && settingFragment != null) {
            String currentFragmentStr = fragmentHelper.getCurrentFragmentName(getChildFragmentManager(), R.id.setting_parent);
            if (currentFragmentStr.equalsIgnoreCase(FragmentSetting.class.getSimpleName()) && isVisibleToUser) {
                //case of is showing and current showing ticket fragment page
                settingFragment.setUserVisibleHint(true);
            } else {
                settingFragment.setUserVisibleHint(false);
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_setting_parent, container, false);

        //getAllTicketTask();

        //initFirstFragment();

        return binding.getRoot();
    }

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
     */
    /*
    private void initFirstFragment() {
        settingFragment = FragmentSetting.newInstance();
        settingFragment.setListener(new FragmentSetting().FragmentListener() {
            @Override
            public void goToFragment(Fragment fragment) {
                fragmentHelper.loadFragment(getChildFragmentManager(), fragment, "Ticket Parents", R.id.setting_parent);
            }

            @Override
            public void goBack() {
                fragmentHelper.popFragment(getChildFragmentManager());
            }

            public void fetchTicketData() {
                getAllTicketTask();
            }
        });
        fragmentHelper.initFragment(getChildFragmentManager(), ticketFragment, R.id.setting_parent);
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
    private FragmentListener listener;

    public void setListener(FragmentListener listener) {
        this.listener = listener;
    }

    public interface FragmentListener {
        void goToFragment(Fragment fragment);

        void fetchTicketData();
    }
}

