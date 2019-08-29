package com.itparadise.jenjudan.user.activity;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.LinearLayout;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.ActivitySplashBinding;
import com.itparadise.jenjudan.user.adapter.Tutorial.SliderAdapter;
import com.itparadise.jenjudan.user.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity {

    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        uiHelper.setStatusBarTransparent(true);

        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 2000);
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            SplashActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    goLogin();
                }
            });
        }
    }

    private void goLogin(){
        final Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void setupListener() {

    }

    @Override
    public void onClick(View v) {

    }

}
