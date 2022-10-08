package com.kuaidihelp.posthouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SpeedTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_test);
        Button button_service_test = findViewById(R.id.bt_server);
        Button button_oos_test = findViewById(R.id.bt_oos);
        TextView imageView_close = findViewById(R.id.btn_back);
        button_oos_test.setOnClickListener(new listener());
        button_service_test.setOnClickListener(new listener());
        imageView_close.setOnClickListener(new listener());
    }

    private class listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_oos:
                    Toast.makeText(SpeedTestActivity.this, "开始OOS测试！！", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bt_server:
                    Toast.makeText(SpeedTestActivity.this, "开始服务测试！！", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_back:
                    Intent intent_close = new Intent(SpeedTestActivity.this, SettingsActivity.class);
                    startActivity(intent_close);
                    break;
            }
        }
    }
}