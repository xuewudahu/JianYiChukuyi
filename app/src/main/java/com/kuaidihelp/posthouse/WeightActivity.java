package com.kuaidihelp.posthouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WeightActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        TextView btn_connect_weight = findViewById(R.id.btn_connect_weight);
        TextView btn_save = findViewById(R.id.btn_save);
        TextView btn_back = findViewById(R.id.btn_back);
        Button btn_free = findViewById(R.id.btn_free);
        Button btn_cancle_free = findViewById(R.id.btn_cancle_free);
        Button btn_calibration = findViewById(R.id.btn_calibration);
        Button btn_set_zero = findViewById(R.id.btn_set_zero);
        btn_calibration.setOnClickListener(new listener());
        btn_connect_weight.setOnClickListener(new listener());
        btn_back.setOnClickListener(new listener());
        btn_cancle_free.setOnClickListener(new listener());
        btn_free.setOnClickListener(new listener());
        btn_save.setOnClickListener(new listener());
        btn_set_zero.setOnClickListener(new listener());
    }

    private class listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_calibration:
                    Toast.makeText(WeightActivity.this, "标定", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_connect_weight:
                    Toast.makeText(WeightActivity.this, "连接电子秤", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_cancle_free:
                    Toast.makeText(WeightActivity.this, "取消去皮", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_free:
                    Toast.makeText(WeightActivity.this, "设置去皮", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_set_zero:
                    Toast.makeText(WeightActivity.this, "标零", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_save:
                    Toast.makeText(WeightActivity.this, "设置内容保存成功", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_back:
                    Intent intent_speed_test = new Intent(WeightActivity.this, SettingsActivity.class);
                    startActivity(intent_speed_test);
                    break;
            }
        }
    }
}