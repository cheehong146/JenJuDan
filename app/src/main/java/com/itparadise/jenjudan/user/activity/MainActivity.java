package com.itparadise.jenjudan.user.activity;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.ActivityMainBinding;
import com.itparadise.jenjudan.user.adapter.CommonPagerAdapter;
import com.itparadise.jenjudan.user.base.BaseActivity;
import com.itparadise.jenjudan.user.fragment.Home.FragmentHome;
import com.itparadise.jenjudan.user.fragment.Home.FragmentParentHome;
import com.itparadise.jenjudan.user.fragment.Menu.FragmentMenu;
import com.itparadise.jenjudan.user.fragment.Profile.FragmentProfile;
import com.itparadise.jenjudan.user.fragment.Menu.FragmentReward;
import com.itparadise.jenjudan.user.fragment.Setting.FragmentParentSetting;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;
    private FragmentParentSetting fragmentParentSetting;
    private FragmentHome fragmentHome;
    private FragmentParentHome fragmentParentHome;
    private CommonPagerAdapter adapter;
    ImageView profileBack;

    //to validate double clicking on the bottom tab item, will refresh the respective fragment
    private int clicknum = 0;
    private boolean exit = false;
    private boolean isHome = false;
    private boolean backhome = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        uiHelper.setStatusBarTransparent(true);

        initViewModel();
        initViewPager();

    }

    @Override
    protected void onResume() {
        super.onResume();
        initViewPager();
    }

    @Override
    public void initViewModel() {
        super.initViewModel();
        setupListener();

    }

    @Override
    public void setupListener() {

        final Intent intent4 = new Intent(this, P_Setting.class);
        binding.navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentManager fm = getSupportFragmentManager();
                clicknum = fm.getBackStackEntryCount();
                //resetBottomTabIcon();
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        FragmentHome fragmentHome = new FragmentHome();
                        //clicknum++;
                        isHome = true;
                        backhome = false;
                        checkPopBackStack(clicknum);
                        loadFragment(fragmentHome);
                        item.setChecked(true);
                        break;

                    case R.id.navigation_reward:
                        FragmentMenu fragmentMenu = new FragmentMenu();
                        //clicknum++;
                        isHome = false;
                        exit = false;
                        backhome = true;
                        checkPopBackStack(clicknum);
                        loadFragment(fragmentMenu);
                        item.setChecked(true);
                        break;

                    case R.id.navigation_profile:
                        FragmentProfile fragmentProfile = new FragmentProfile();
                        //clicknum++;
                        isHome = false;
                        exit = false;
                        backhome = true;
                        checkPopBackStack(clicknum);
                        loadFragment(fragmentProfile);
                        item.setChecked(true);

                        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View view = layoutInflater.inflate(R.layout.profile_account, null);
                        profileBack = view.findViewById(R.id.img_profile_back);
                        profileBack.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //Toast.makeText(getBaseContext(), "click",Toast.LENGTH_SHORT).show();
                                onBackPressed();
                            }
                        });
                        break;

                    case R.id.navigation_setting:
                        isHome = false;
                        exit = false;
                        backhome = false;
                        item.setChecked(true);
                        startActivity(intent4);
                        break;
                }

                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    public void initViewPager() {

        binding.navigation.setSelectedItemId(R.id.navigation_home);

    }

    private void loadFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.vp_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void checkPopBackStack(int clickNum) {

        FragmentManager fm = getSupportFragmentManager();
        //Toast.makeText(getBaseContext(), clicknum+"check...",Toast.LENGTH_SHORT).show();
        System.out.println("Backstackcount: " + fm.getBackStackEntryCount());
        if (clickNum > 1) {
            for (int i = 1; i <= clickNum; i++) {
                fm.popBackStack();
                //clicknum--;
                System.out.println("check I: " +i);
                System.out.println("check click Num: " +clickNum);
                System.out.println("check clicknum: " +clicknum);
            }

        }
    }

    @Override
    public void onBackPressed() {
/*
        if(exit) {
            finishAffinity();
            System.exit(0);
        }else if(isHome) {
            Toast.makeText(getBaseContext(), clicknum+"Press Back Again To Exit...",Toast.LENGTH_SHORT).show();
            exit = true;
        }else if(clicknum == 0) {
            exit = true;
            binding.navigation.setSelectedItemId(R.id.navigation_home);
            Toast.makeText(getBaseContext(), clicknum+"Press Back Again To Exit...",Toast.LENGTH_SHORT).show();
        }else if(clicknum ==1 && !isHome) {
            exit = true;
            binding.navigation.setSelectedItemId(R.id.navigation_home);
            Toast.makeText(getBaseContext(), clicknum+"Press Back Again To Exit...",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getBaseContext(), clicknum+"er...",Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }*/

        if(exit) {
            finishAffinity();
            System.exit(0);
        }else if(isHome) {
            Toast.makeText(getBaseContext(), "Press Back Again To Exit...",Toast.LENGTH_SHORT).show();
            exit = true;
        }else if (backhome) {
            binding.navigation.setSelectedItemId(R.id.navigation_home);
        }else{
            exit = true;
            binding.navigation.setSelectedItemId(R.id.navigation_home);
            Toast.makeText(getBaseContext(), "Press Back Again To Exit...",Toast.LENGTH_SHORT).show();
        }
    }
}
