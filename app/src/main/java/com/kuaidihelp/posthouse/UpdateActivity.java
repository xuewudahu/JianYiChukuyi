package com.kuaidihelp.posthouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        TextView textView_update = findViewById(R.id.btn_update_sure);
        TextView textView_cancle_update = findViewById(R.id.btn_update_cancel);
        textView_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UpdateActivity.this, "更新准备中，请稍等！！", Toast.LENGTH_SHORT).show();
            }
        });
        textView_cancle_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UpdateActivity.this, "取消更新！！", Toast.LENGTH_SHORT).show();
                Intent intent_cancle = new Intent(UpdateActivity.this, SettingsActivity.class);
                startActivity(intent_cancle);
            }
        });
    }
}