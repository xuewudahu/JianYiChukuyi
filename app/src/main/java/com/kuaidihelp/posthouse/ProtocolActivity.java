package com.kuaidihelp.posthouse;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.kuaidihelp.posthouse.util.AdroidUtil;


public class ProtocolActivity extends AppCompatActivity {
   private LinearLayout quitLinear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protocol);
      //  AdroidUtil.setStatusBarMode(this,true, R.color.white);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        quitLinear =findViewById(R.id.protocol_quit);
        quitLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent =new Intent(ProtocolActivity.this,LoginActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }
}