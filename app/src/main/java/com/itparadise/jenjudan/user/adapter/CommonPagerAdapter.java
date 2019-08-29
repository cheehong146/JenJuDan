package com.itparadise.jenjudan.user.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

//import com.itparadise.jenjudan.user.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by itparadise on 02/01/2018.
 */

public class CommonPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    public CommonPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment) {
        fragmentList.add(fragment);
    }

    public void addFragment(int index, Fragment fragment) {
        fragmentList.add(index, fragment);
    }

    public void addFragments(List<Fragment> fragmentList) {
        fragmentList.addAll(fragmentList);
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }
/*
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (titleList.size() == fragmentList.size()) {
            return titleList.get(position);
        }
        return Constants.EMPTY_TEXT;
    }
    */
}
