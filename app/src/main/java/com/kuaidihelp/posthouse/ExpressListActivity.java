package com.kuaidihelp.posthouse;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rq.net.MyApplication;
import com.rq.net.util.ExpressStationEnum;

import java.util.ArrayList;
import java.util.List;

public class ExpressListActivity extends AppCompatActivity {
    SharedPreferences settings;
    Context mContext;

    LinearLayout singleScan;
    LinearLayout multiScan;
    ArrayList<Switch> arrayList_Switch;
    ExpressAdapter adapter;
    private List<Express> expressList = new ArrayList<>();
    private List<Express> expressListMulti = new ArrayList<>();
    private long lastonclickTime = 0;
    public  Boolean isSingle;
    public RecyclerView recyclerView;
    private final static String SCAN_SCAN_TEST = "scan_scan_test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("wxww_生命周期","--ExpressListActivity--onCreate");
        setContentView(R.layout.activity_express_list);
        mContext = getApplicationContext();
        RelativeLayout btn_back = findViewById(R.id.rl_back_stationtype);
        ImageView iv_restart_app = findViewById(R.id.iv_restart_app);
        singleScan = findViewById(R.id.singleScan);
        multiScan = findViewById(R.id.multiScan);
        btn_back.setOnClickListener(new lisenter());
        iv_restart_app.setOnClickListener(new lisenter());

        settings = getSharedPreferences("state", 0);
        SharedPreferences.Editor editor = settings.edit();
        isSingle = settings.getBoolean("isSingle", true);
        initExpress();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Log.e("wxw_shu","---"+expressList.size());

        if (isSingle) {
            adapter = new ExpressAdapter(expressList,this);
        } else {
            adapter = new ExpressAdapter(expressListMulti,this);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //给layoutManager 的展示方式设置为竖直方向
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        singleScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter = new ExpressAdapter(expressList,ExpressListActivity.this);
                recyclerView.setAdapter(adapter);
                singleScan.setBackgroundResource(R.drawable.text_select_orange);
                multiScan.setBackground(null);
                adapter.isSingle = true;


                adapter.notifyDataSetChanged();
            }
        });
        multiScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adapter = new ExpressAdapter(expressListMulti,ExpressListActivity.this);
                recyclerView.setAdapter(adapter);
                multiScan.setBackgroundResource(R.drawable.text_select_orange);
                singleScan.setBackground(null);
                adapter.isSingle = false;


                adapter.notifyDataSetChanged();
            }
        });
        if (!settings.getBoolean("isSingle", true)) {
            multiScan.setBackgroundResource(R.drawable.text_select_orange);
            singleScan.setBackground(null);
        } else {
            singleScan.setBackgroundResource(R.drawable.text_select_orange);
            multiScan.setBackground(null);
        }


    }

    private void initExpress() {
        Express duoduo = new Express(R.mipmap.duoduo_cion,"多多驿站");
        expressList.add(duoduo);
        expressListMulti.add(duoduo);
        Express kuaibao = new Express(R.mipmap.kuaibao_icon,"快宝驿站");
        expressList.add(kuaibao);
        expressListMulti.add(kuaibao);
        Express yizhanxiao = new Express(R.mipmap.ic_stage,"驿站小扁担");
        expressList.add(yizhanxiao);
        expressListMulti.add(yizhanxiao);

        Express yizhanzhushou = new Express(R.mipmap.ic_station,"驿站助手");
        expressList.add(yizhanzhushou);
        expressListMulti.add(yizhanzhushou);
        Express baishilaiqu = new Express(R.mipmap.best_lin_li_icon,"百世邻里");
        expressList.add(baishilaiqu);
        expressListMulti.add(baishilaiqu);
        Express kuaidichaoshi = new Express(R.mipmap.kuaidicaoshi_icon,"兔喜快递超市");
        expressList.add(kuaidichaoshi);
        expressListMulti.add(kuaidichaoshi);
        Express kuaidiyuanxiao = new Express(R.mipmap.ic_courier,"快递员小扁担");
        expressList.add(kuaidiyuanxiao);
        expressListMulti.add(kuaidiyuanxiao);
        Express jitu = new Express(R.mipmap.jt_icon,"极兔");
        expressList.add(jitu);
        expressListMulti.add(jitu);

        Express moxiguanjia = new Express(R.mipmap.moxi,"摩西管家");
        expressList.add(moxiguanjia);
        expressListMulti.add(moxiguanjia);
        Express fengchaoservice = new Express(R.mipmap.fcbox_icon,"丰巢服务站");
        expressList.add(fengchaoservice);
        expressListMulti.add(fengchaoservice);
        Express mamastation = new Express(R.mipmap.mama_icon,"妈妈驿站");
        expressList.add(mamastation);
        expressListMulti.add(mamastation);

        Express yishoufa = new Express(R.mipmap.yshoufalogo,"驿收发");
        expressList.add(yishoufa);
        expressListMulti.add(yishoufa);
        Express zyzt = new Express(R.mipmap.zhongyouziti,"中邮自提");
        expressList.add(zyzt);
        Express zhongyoustation = new Express(R.mipmap.zhongyouyizhan,"中邮驿站");
        expressList.add(zhongyoustation);
        Express xiongmaokuaihsou = new Express(R.mipmap.ic_panda,"熊猫快收");
        expressList.add(xiongmaokuaihsou);
        Express blueshop = new Express(R.mipmap.ic_blueshop,"蓝店");
        expressList.add(blueshop);
        Express yundachaoshi = new Express(R.mipmap.yunda_icon,"韵达快递");
        expressList.add(yundachaoshi);
        Express fenshishenghuo = new Express(R.mipmap.fssh_icon,"粉丝生活");
        expressList.add(fenshishenghuo);
        Express guoguoyizhan = new Express(R.mipmap.guoguoyizhan,"果果驿站");
        expressList.add(guoguoyizhan);
        Express jinlinbaogaopaiyi = new Express(R.mipmap.jlbgpy_ic_launcher,"近邻宝高拍仪");
        expressList.add(jinlinbaogaopaiyi);
        Express jinlinbaokuaidiqujian = new Express(R.mipmap.kdqj_ic_launcher,"近邻宝快递取件");
        expressList.add(jinlinbaokuaidiqujian);
        Express jinlinbaoocrjiebo = new Express(R.mipmap.jinlinbao_ic_launcher,"近邻宝OCR接驳");
        expressList.add(jinlinbaoocrjiebo);
        Express jinlinbaoqianshou = new Express(R.mipmap.pjqs_ic_launcher,"近邻宝取件签收");
        expressList.add(jinlinbaoqianshou);
        Express sudiyigongpei = new Express(R.mipmap.ic_sdy,"速递易共配");
        expressList.add(sudiyigongpei);
        Express jushuitan = new Express(R.mipmap.ic_jushuitan,"聚水潭");
        expressList.add(jushuitan);
        Express xinghuo = new Express(R.mipmap.xinhuo_icon,"星火");
        expressList.add(xinghuo);
        Express xiniaogaopaiyi = new Express(R.mipmap.xiniao_icon,"溪鸟高拍仪");
        expressList.add(xiniaogaopaiyi);
        Express xiaobingstation = new Express(R.mipmap.xiao_bing_icon,"小兵驿站");
        expressList.add(xiaobingstation);
        Express netmanager = new Express(R.mipmap.jikeyun_icon,"吉客云");
        expressList.add(netmanager);
        Express miaozhan = new Express(R.mipmap.miaozhan_icon,"喵站");
        expressList.add(miaozhan);
        Express zhongyouchengzhong = new Express(R.mipmap.zhongyou_ic_launcher,"众邮称重");
        expressList.add(zhongyouchengzhong);

    }

    @Override
    protected void onResume() {
        super.onResume();
        lastonclickTime = 0;
    }

    private class lisenter implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_restart_app:
                    SharedPreferences.Editor e = settings.edit();
                    e.putBoolean(SCAN_SCAN_TEST, false);
                    e.commit();

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("isSingle",adapter.isSingle);
                    editor.commit();



                    //MyApplication.setNum(mContext.getSharedPreferences("expressMulti", Activity.MODE_PRIVATE).getInt("DATA", 1));
                    MyApplication.setNum(0);
                    Intent intent_login = new Intent(ExpressListActivity.this, LoginActivity.class);
                    intent_login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent_login);
                    finish();
/*                    final Intent intent = ExpressListActivity.this.getPackageManager().getLaunchIntentForPackage(ExpressListActivity.this.getPackageName());
                    if (intent != null) {
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        ExpressListActivity.this.startActivity(intent);
                    }
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(0);*/
                    break;
                case R.id.rl_back_stationtype:
                    Long time = SystemClock.uptimeMillis();
                    if (time - lastonclickTime >= 2000) {
/*                        Intent intent_back = new Intent(ExpressListActivity.this, SettingActivity.class);
                        startActivity(intent_back);*/
                        finish();
                        lastonclickTime = time;
                    }
                    break;
            }
        }
    }

    private void closeSwitch(Switch s_switch) {
        for (Switch s : arrayList_Switch) {
            if (s != s_switch) {
                s.setChecked(false);
            }
        }
    }


}