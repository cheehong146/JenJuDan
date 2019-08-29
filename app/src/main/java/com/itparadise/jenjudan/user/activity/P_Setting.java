package com.itparadise.jenjudan.user.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.SettingsBinding;
import com.itparadise.jenjudan.user.base.BaseActivity;
import com.itparadise.jenjudan.user.fragment.Home.FragmentHome;

public class P_Setting extends BaseActivity {

    SettingsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        binding = DataBindingUtil.setContentView(this, R.layout.settings);
        uiHelper.setStatusBarTransparent(true);
        uiHelper.setPaddingTopBelowStatusBar(binding.llToolbar);


        final Intent intent1 = new Intent(this, p_about.class);
        final Intent intent2 = new Intent(this, P_terms.class);
        binding.imgSettingBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.imgGoAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });

        binding.imgGoTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
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
