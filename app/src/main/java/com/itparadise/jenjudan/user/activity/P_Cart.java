package com.itparadise.jenjudan.user.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.OrderCartBinding;
import com.itparadise.jenjudan.databinding.OrderPaymentSuccessBinding;
import com.itparadise.jenjudan.user.adapter.Menu.AdapterCart;
import com.itparadise.jenjudan.user.adapter.Menu.AdapterMenu;
import com.itparadise.jenjudan.user.base.BaseActivity;

import java.util.ArrayList;

public class P_Cart extends BaseActivity {

    private OrderCartBinding binding;
    private ArrayList<String> cartAmount = new ArrayList<>();
    private ArrayList<String> cartName = new ArrayList<>();
    private ArrayList<String> cartPrice = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_cart);
        binding = DataBindingUtil.setContentView(this, R.layout.order_cart);
        uiHelper.setStatusBarTransparent(true);
        uiHelper.setPaddingTopBelowStatusBar(binding.llCart1);

        initCartContent();

        LinearLayoutManager lm_cart = new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL, false);
        RecyclerView rvCart = binding.rvCart;
        rvCart.setLayoutManager(lm_cart);
        AdapterCart adapterCart = new AdapterCart(cartAmount, cartName, cartPrice, getBaseContext());
        rvCart.setAdapter(adapterCart);

        binding.imgCartBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), P_Payment_Success.class);
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

    private void initCartContent() {

        cartAmount.add("1x");
        cartName.add("Brown Sugar Flavor Fresh Milk Tea");
        cartPrice.add(" AUD");

        cartAmount.add("1x");
        cartName.add("Red Sugar Flavor Fresh Milk Tea");
        cartPrice.add(" AUD7.00");

        cartAmount.add("1x");
        cartName.add("Purple Sugar Flavor Fresh Milk Tea");
        cartPrice.add(" AU");

    }

}
