package com.kuaidihelp.posthouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReportUpdateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_update);
        TextView btn_log_get = findViewById(R.id.btn_log_get);
        TextView btn_update_log = findViewById(R.id.btn_update_log);
        TextView btn_back = findViewById(R.id.btn_back);
        btn_update_log.setOnClickListener(new listener());
        btn_log_get.setOnClickListener(new listener());
        btn_back.setOnClickListener(new listener());
    }

    private class listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_log_get:
                    Toast.makeText(ReportUpdateActivity.this, "开始抓取日志", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_update_log:
                    Toast.makeText(ReportUpdateActivity.this, "开始上传日志", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_back:
                    Intent intent_back = new Intent(ReportUpdateActivity.this, SettingsActivity.class);
                    startActivity(intent_back);
                    break;
            }
        }
    }
}