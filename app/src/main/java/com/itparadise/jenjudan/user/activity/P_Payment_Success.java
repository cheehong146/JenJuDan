package com.itparadise.jenjudan.user.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.OrderPaymentSuccessBinding;
import com.itparadise.jenjudan.user.base.BaseActivity;

public class P_Payment_Success extends BaseActivity {

    OrderPaymentSuccessBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_payment_success);
        binding = DataBindingUtil.setContentView(this, R.layout.order_payment_success);
        uiHelper.setStatusBarTransparent(true);
        uiHelper.setPaddingTopBelowStatusBar(binding.llToolbar);

        binding.imgPaySuccessBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        binding.btnViewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), P_Payment_History.class);
                startActivity(intent);
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
