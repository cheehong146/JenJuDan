package com.itparadise.jenjudan.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.ActivityMainSplashBinding;
import com.itparadise.jenjudan.databinding.ActivitySplashBinding;
import com.itparadise.jenjudan.user.adapter.Tutorial.SliderAdapter;
import com.itparadise.jenjudan.user.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class TutorialActivity extends BaseActivity {

    ActivityMainSplashBinding binding;
    private ViewPager sliderViewPager;
    private LinearLayout dotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] dots;
    private int currentSlide = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splash);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_splash);
        uiHelper.setStatusBarTransparent(true);

        sliderViewPager = (ViewPager)findViewById(R.id.vp_splash);
        dotLayout = (LinearLayout)findViewById(R.id.slider_dots);

        sliderAdapter = new SliderAdapter(this);

        sliderViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        dots[0].setTextColor(getResources().getColor(R.color.colorOrange));
        sliderViewPager.addOnPageChangeListener(viewListener);
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sliderViewPager.setCurrentItem(currentSlide+1);
            }
        });

        binding.skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLogin();
            }
        });

        binding.getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLogin();
            }
        });
    }

    public void addDotsIndicator(int position){

        dots = new TextView[3];

        for(int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorWhite));
            dotLayout.addView(dots[i]);
        }

        dots[position].setTextColor(getResources().getColor(R.color.colorOrange));

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentSlide = position;
            for(int i = 0; i < dots.length; i++){
                dots[i].setText(Html.fromHtml("&#8226;"));
                dots[i].setTextSize(35);
                dots[i].setTextColor(getResources().getColor(R.color.colorWhite));
            }
            dots[position].setTextColor(getResources().getColor(R.color.colorOrange));

            if(currentSlide < 2 ) {
                binding.llBtns.setVisibility(View.VISIBLE);
                binding.getStart.setVisibility(View.INVISIBLE);
            }else {
                binding.llBtns.setVisibility(View.INVISIBLE);
                binding.getStart.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            TutorialActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    goLogin();
                }
            });
        }
    }

    private void goLogin(){
        final Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void setupListener() {

    }

    @Override
    public void onClick(View v) {

    }

}
