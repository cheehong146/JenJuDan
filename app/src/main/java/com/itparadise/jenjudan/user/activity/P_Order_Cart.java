package com.itparadise.jenjudan.user.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.user.base.BaseActivity;

public class P_Order_Cart extends BaseActivity {

    ImageView back;
    Button placeorder, viewHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_cart);
        uiHelper.setStatusBarTransparent(true);

        back = findViewById(R.id.img_cart_back);
        placeorder = findViewById(R.id.btn_place_order);

        final Intent intent1 = new Intent(this, MainActivity.class);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.order_payment_success);
                back = findViewById(R.id.img_paySuccess_back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(intent1);
                    }
                });
                viewHistory = findViewById(R.id.btn_viewHistory);
                viewHistory.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.order_payment_history);
                        back = findViewById(R.id.img_history_back);
                        back.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(intent1);
                            }
                        });

                    }
                });
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
