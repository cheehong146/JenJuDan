package com.itparadise.jenjudan.user.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.ActivityLoginBinding;
import com.itparadise.jenjudan.user.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    LinearLayout fblogin;
    Button login;
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uiHelper.setStatusBarTransparent(true);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        uiHelper.setPaddingTopBelowStatusBar(binding.llToolbar);

        fblogin = findViewById(R.id.btn_fb_login);
        login = findViewById(R.id.btn_login);

        setupListener();
    }

    @Override
    public void onClick(View v) {    }

    @Override
    public void setupListener() {

        final Intent intent = new Intent(this, MainActivity.class);
        final Intent intent2 = new Intent(this, RegisterActivity.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent.putExtras(args);
                startActivity(intent);
            }
        });

        fblogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent.putExtras(args);
                startActivity(intent);
            }
        });

        binding.registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });

    }
}
