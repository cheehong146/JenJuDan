package com.itparadise.jenjudan.user.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.ProfileProductBinding;
import com.itparadise.jenjudan.user.adapter.Product.ViewPagerProduct;
import com.itparadise.jenjudan.user.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by itparadise on 22/8/2019
 **/
public class P_Productpage extends BaseActivity {

    ProfileProductBinding binding;
    ImageView back;
    ViewPager viewPager;
    LinearLayout ll_dots;
    private int dot_count;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_product);
        binding = DataBindingUtil.setContentView(this, R.layout.profile_product);
        uiHelper.setStatusBarTransparent(true);
        uiHelper.setPaddingTopBelowStatusBar(binding.llToolbar);

        back = findViewById(R.id.img_product_back);
        viewPager = findViewById(R.id.vp_product);
        ll_dots = findViewById(R.id.slider_dots);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ViewPagerProduct viewPagerProduct = new ViewPagerProduct(this);
        viewPager.setAdapter(viewPagerProduct);


        dot_count = viewPagerProduct.getCount();
        dots = new ImageView[dot_count];

        for(int i = 0; i<dot_count; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dot_nonactive));
            LinearLayout.LayoutParams llparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            llparams.setMargins(8,0,8,0);

            ll_dots.addView(dots[i], llparams);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dot_active));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dot_count; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dot_nonactive));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dot_active));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);

    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            P_Productpage.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });

        }
    }

    @Override
    public void setupListener() {

    }

    @Override
    public void onClick(View view) {

    }
}