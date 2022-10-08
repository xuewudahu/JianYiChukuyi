package com.kuaidihelp.posthouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserAgreementActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_agreement);
        TextView textView = findViewById(R.id.tv_back);
        TextView textView1 = findViewById(R.id.tv_title);
        WebView webView = findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/useragremment.htm");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_back = new Intent(UserAgreementActivity.this, SettingsActivity.class);
                startActivity(intent_back);
            }
        });
    }
}