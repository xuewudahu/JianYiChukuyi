package com.kuaidihelp.posthouse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kuaidihelp.posthouse.util.AdroidUtil;

public class SplashActivity extends AppCompatActivity {
    private final static String SCAN_SCAN_TEST = "scan_scan_test";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("wxw_界面","---进入欢迎界面-onResume");
        SharedPreferences sharedPreferences = getSharedPreferences("state", 0);
        if (sharedPreferences.getBoolean("isfirst_open_app", true)) {
            Intent  Intent_backOnly_key = new Intent("com.android.intent.action.NAVIGATIONBUTTON_BACKONLY");
            Intent_backOnly_key.putExtra("BackOnly_KEY",1);
            sendBroadcast(Intent_backOnly_key);
            Intent intent_statusbar = new Intent("com.kaicom.disable_statusbar_expand");
            intent_statusbar.putExtra("com.kaicom.disable_statusbar_expand", true);
            sendBroadcast(intent_statusbar);
            SharedPreferences.Editor editor1 = sharedPreferences.edit();
            editor1.putBoolean("isfirst_open_app", true);
            editor1.commit();
        }

        if (!AdroidUtil.isConnectedToInternet(this)) {
            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else if (sharedPreferences.getBoolean(SCAN_SCAN_TEST, false)) {
            Intent intent = new Intent();
            intent.setClass(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {

            Intent intent = new Intent();
            intent.setClass(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

