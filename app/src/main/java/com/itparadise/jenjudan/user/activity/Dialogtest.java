package com.itparadise.jenjudan.user.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.user.base.BaseActivity;

public class Dialogtest extends BaseActivity {

    public Activity c;
    public Dialog d;
    public Button yes, no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_redeem);


    }

    @Override
    public void setupListener() {

    }

    @Override
    public void onClick(View view) {

    }
}