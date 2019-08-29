package com.itparadise.jenjudan.user.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.user.base.BaseActivity;

public class p_about extends BaseActivity {

    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_about_us);
        uiHelper.setStatusBarTransparent(true);

        back = findViewById(R.id.img_about_back);

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
