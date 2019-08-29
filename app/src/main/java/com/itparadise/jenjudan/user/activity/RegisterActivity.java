package com.itparadise.jenjudan.user.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.ActivityRegisterBinding;
import com.itparadise.jenjudan.user.base.BaseActivity;

public class RegisterActivity extends BaseActivity {

    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        uiHelper.setStatusBarTransparent(true);
        uiHelper.setPaddingTopBelowStatusBar(binding.regToolbar);

        final Intent intent = new Intent(this, MainActivity.class);
        binding.btnFbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.dialog_email_verification);
                Button ev_verify = findViewById(R.id.ev_verify);

                ev_verify.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.dialog_email_verification_success);

                        Button ev_continue = findViewById(R.id.ev_continue);
                        ev_continue.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.dialog_email_verification);
                Button ev_verify = findViewById(R.id.ev_verify);

                ev_verify.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.dialog_email_verification_success);

                        Button ev_continue = findViewById(R.id.ev_continue);
                        ev_continue.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        });

        binding.imgRegisterBack.setOnClickListener(new View.OnClickListener() {
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
