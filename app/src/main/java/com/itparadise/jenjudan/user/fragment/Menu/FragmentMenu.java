package com.itparadise.jenjudan.user.fragment.Menu;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.FragmentMenuBinding;
import com.itparadise.jenjudan.user.adapter.Menu.AdapterCategory;
import com.itparadise.jenjudan.user.adapter.Menu.AdapterMenu;
import com.itparadise.jenjudan.user.adapter.Redemption.AdapterRedemption;
import com.itparadise.jenjudan.user.base.BaseFragment;
import com.itparadise.jenjudan.user.fragment.Home.FragmentHome;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Chee Hong on 26/8/2019
 **/
public class FragmentMenu  extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    private FragmentMenuBinding binding;
    private ArrayList<String> menucategoryUrl = new ArrayList<>();
    private ArrayList<String> menucategoryName = new ArrayList<>();
    private ArrayList<String> menuUrl = new ArrayList<>();
    private ArrayList<String> menuName = new ArrayList<>();
    private ArrayList<String> menuPrice = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        initMenuContent();
        initCategoryContent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_menu, container, false);

        uiHelper.setStatusBarTransparent(true);
        uiHelper.setPaddingTopBelowStatusBar(binding.llToolbar);

        binding.imgMenuBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().onBackPressed();
            }
        });


        //setupListener();

        LinearLayoutManager lm_category = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView rvMenuCategory = binding.rvMenu;
        rvMenuCategory.setLayoutManager(lm_category);
        AdapterCategory adapterCategory = new AdapterCategory(menucategoryName, menucategoryUrl, getContext());
        rvMenuCategory.setAdapter(adapterCategory);

        LinearLayoutManager lm_menu = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        RecyclerView rvMenu = binding.rvMenu2;
        rvMenu.setLayoutManager(lm_menu);
        AdapterMenu adapterMenu = new AdapterMenu(menuName, menuPrice, menuUrl, getContext());
        rvMenu.setAdapter(adapterMenu);

        return binding.getRoot();


    }


    @Override
    public void onRefresh() {

    }

    @Override
    public void setupListener() {

    }

    @Override
    public void onClick(View view) {

    }

    private void initCategoryContent(){

        menucategoryUrl.add("https://pickledplum.com/wp-content/uploads/2019/02/homemade-bubble-tea-4OPTM.jpg");
        menucategoryName.add("Cheese Foam Tea Series");

        menucategoryUrl.add("https://images.says.com/uploads/story_source/source_image/696069/0a76.jpg");
        menucategoryName.add("Nugget Foam Tea Series");

        menucategoryUrl.add("https://ichef.bbci.co.uk/news/660/cpsprodpb/17872/production/_107407369_tea.png");
        menucategoryName.add("Mocha Foam Tea Series");

        menucategoryUrl.add("https://www.vitamix.com/media/other/images/500xNxIced-Matcha-Bubble-Tea-470-449.jpg.pagespeed.ic.20R5IQCOGA.jpg");
        menucategoryName.add("Chocolate Foam Tea Series");

        menucategoryUrl.add("https://hoodline.imgix.net/uploads/story/image/34081/17523251_1418625778201394_279125323341231461_n.jpg");
        menucategoryName.add("Honey Foam Tea Series");

        menucategoryUrl.add("https://trademe.tmcdn.co.nz/photoserver/plus/933715986.jpg");
        menucategoryName.add("Cheese Foam Tea Series");

        menucategoryUrl.add("https://d1dxs113ar9ebd.cloudfront.net/225batonrouge/2019/01/43-Teatery-1024x683.jpg");
        menucategoryName.add("Cheese Foam Tea Series");

    }

    private void initMenuContent() {

        menuUrl.add("https://hoodline.imgix.net/uploads/story/image/34081/17523251_1418625778201394_279125323341231461_n.jpg");
        menuName.add("Brown Sugar Flavor Fresh Milk Tea");
        menuPrice.add(" AUD6.00");

        menuUrl.add("https://trademe.tmcdn.co.nz/photoserver/plus/933715986.jpg");
        menuName.add("Red Sugar Flavor Fresh Milk Tea");
        menuPrice.add(" AUD7.00");

        menuUrl.add("https://d1dxs113ar9ebd.cloudfront.net/225batonrouge/2019/01/43-Teatery-1024x683.jpg");
        menuName.add("Purple Sugar Flavor Fresh Milk Tea");
        menuPrice.add(" AUD10.00");

        menuUrl.add("https://d1dxs113ar9ebd.cloudfront.net/225batonrouge/2019/01/43-Teatery-1024x683.jpg");
        menuName.add("Black Sugar Flavor Fresh Milk Tea");
        menuPrice.add(" AUD6.00");
    }

    private void loadFragment(Fragment fragment) {

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.vp_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
