package com.itparadise.jenjudan.user.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.OrderPaymentHistoryBinding;
import com.itparadise.jenjudan.databinding.OrderPaymentSuccessBinding;
import com.itparadise.jenjudan.user.adapter.Menu.AdapterCart;
import com.itparadise.jenjudan.user.adapter.Menu.AdapterPaymentHistory;
import com.itparadise.jenjudan.user.base.BaseActivity;

import java.util.ArrayList;

public class P_Payment_History extends BaseActivity {

    OrderPaymentHistoryBinding binding;
    private ArrayList<String> payAmount = new ArrayList<>();
    private ArrayList<String> payName = new ArrayList<>();
    private ArrayList<String> payDetails = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_payment_history);
        binding = DataBindingUtil.setContentView(this, R.layout.order_payment_history);
        uiHelper.setStatusBarTransparent(true);
        uiHelper.setPaddingTopBelowStatusBar(binding.llToolbar);

        initHistoryContent();
        binding.imgHistoryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        LinearLayoutManager lm_payHistory = new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL, false);
        RecyclerView rvPaymentHistory = binding.rvPaymentHistory;
        rvPaymentHistory.setLayoutManager(lm_payHistory);
        AdapterPaymentHistory adapterPaymentHistory = new AdapterPaymentHistory(payName, payDetails, payAmount, getBaseContext());
        rvPaymentHistory.setAdapter(adapterPaymentHistory);
    }

    @Override
    public void setupListener() {

    }

    @Override
    public void onClick(View view) {

    }

    private void initHistoryContent() {

        payName.add("Jenjudan Melbourne");
        payDetails.add("16 June 2019 - Receipt ID: 0088-0755");
        payAmount.add("AUD45.00");

        payName.add("Jenjudan Melbourne");
        payDetails.add("16 June 2019 - Receipt ID: 0088-0755");
        payAmount.add("AUD35.50");

        payName.add("Top-Up of RM30");
        payDetails.add("16 June 2019 - Receipt ID: 0088-0755");
        payAmount.add("AUR30.00");

    }

}
