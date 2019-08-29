package com.itparadise.jenjudan.user.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.DataBindingUtil;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.ProfileProductBinding;
import com.itparadise.jenjudan.databinding.ProfileStoreBinding;
import com.itparadise.jenjudan.user.base.BaseActivity;

/**
 * Created by itparadise on 23/8/2019
 **/
public class P_Store extends BaseActivity {
    ProfileStoreBinding binding;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_store);
        binding = DataBindingUtil.setContentView(this, R.layout.profile_store);
        uiHelper.setStatusBarTransparent(true);
        uiHelper.setPaddingTopBelowStatusBar(binding.llToolbar);

        back = findViewById(R.id.img_store_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void setupListener() {

    }

    @Override
    public void onClick(View view) {

    }
}
