package com.rq.net;

import static com.rq.net.util.ExpressStationEnum.DUODUOYIZHAN;
import static com.rq.net.util.ExpressStationEnum.KUAIBAO;
import static com.rq.net.util.ExpressStationEnum.STATIONHELPER;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;



import com.rq.net.api.ApiComponent;
import com.rq.net.api.imp.DaggerApiComponent;
import com.rq.net.di.ApiModule;
import com.rq.net.setting.RqFilePreference;
import com.rq.net.util.ExpressStationEnum;

import java.util.ArrayList;


public class MyApplication extends Application {
    private static ApiComponent mDaggerApiComponent;
    public static MyApplication baseApp;
    private static ExpressStationEnum stationEnum = KUAIBAO;
    public static SharedPreferences pullPreference;
    public static SharedPreferences preferDataList;
    private static ArrayList<Integer> selectedPosition_multi;
    private static int num= 0;
    private static int delayTime= 1000;

    public static int getDelayTime() {
        if (pullPreference.getInt("delayTime", 1) == 1) {
            SharedPreferences.Editor e = pullPreference.edit();
            e.putInt("delayTime", 0);
            e.apply();
            return 5000;
        }
        return delayTime;
    }

    public static String getLocalVersionName(Context ctx) {
        String localVersion = "";
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionName;//版本号名称
            //localVersion = packageInfo.versionCode;//版本号
            Log.d("TAG", "当前版本名称：" + localVersion);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }
    public MyApplication() {
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        MyApplication.num = num;
        Log.e("wxw_login","--MyApplication--"+num);
    }

    public static ApiComponent getDaggerReposifitComponent() {
        return mDaggerApiComponent;
    }
    public static ArrayList getselectedPositionMulti() {

        int environNums = preferDataList.getInt("DATA", 1);
        selectedPosition_multi = new ArrayList<>();
        for (int i = 0; i < environNums; i++) {
            int environItem = preferDataList.getInt("item_" + i, 0);
            selectedPosition_multi.add(environItem);
        }
        return selectedPosition_multi;
    }

    public void onCreate() {
        super.onCreate();
        Log.e("wxw_界面", "--进入MyApplication-onCreate"+getPackageName()+"--"+getCurrentProcessName());
        if (!getPackageName().equals(getCurrentProcessName())) {
            return;
        }

        baseApp = this;
        pullPreference = getSharedPreferences("state", 0);
        preferDataList = getSharedPreferences("expressMulti", Activity.MODE_PRIVATE);
        try {
            mDaggerApiComponent = DaggerApiComponent.builder().apiModule(new ApiModule(this, false, new String[]{"http://soft.joyfinder.com.cn/", "http://dm.console.joyfinder.com.cn/", "http://logistics.joyfinder.com.cn/", "https://laiqu.800best.com/", "http://advert.joyfinder.com.cn/", "https:/kdcssso.zt-express.com/oauth2/", "https://kdcsgateway.zt-express.com/", "http://api.kuaidihelp.com/", "http://pdanew.yto56.com.cn:9195/", "http://pdanew.yto56.com.cn:9195/", "http://aapp.yundasys.com:10149/", "http://yizhan.mamayz.com:9197/", "https://splaiquapp.800best.com/", "https://epsp.fcbox.com/", "http://api.xtgyl.cn/", "https://appstslog.best-inc.com/", "https://180.97.199.25:32426/", "http://openapi.pandabg.cn:20099/v3/", "https://yzzs.kdy100.com:1991/", "http://xbd.linyu106.com", "http://yizhan.kdyxbd.com/", "https://sh.ulandian.com/", "https://open.erp321.com/", "http://gateway.56xiniao.com/", "http://open.jackyun.com/", "https://bc.jtexpress.com.cn/", "http://ling.800best.com/", "https://signapi2.fanssh.com", "http://xbdimg.linyu106.com/", "https://api.jinlb.cn/", "http://dmsver.etms.jd.com/", "https://api.vloop.cc/", "https://ant.yshoufa.com", RqFilePreference.getInstance().getGuoGuoURL(), "https://codelivery-open.cnpost-sposter.com/", "http://api5.kuaidihelp.com/", "https://miaozhan-3rdpartydeviceadmin.sto.cn", "http://218.104.231.2:20069/selfSend/HkGpy/", "https://mdkd-api.pinduoduo.com/"})).build();
        } catch (Exception var2) {
            var2.printStackTrace();
        }
        Log.e("wxw_界面", "--进入MyApplication2");
    }

    public static ExpressStationEnum getStationEnum() {
        int stationEnumCode = pullPreference.getInt("stationEnum", 1);

        return getExpressStationEnum(stationEnumCode);
    }

    public static void setStationEnum(ExpressStationEnum station) {
        stationEnum = station;
        SharedPreferences.Editor e = pullPreference.edit();
        e.putInt("stationEnum", station.getCode());
        e.apply();
    }
    /**
     * 获取当前进程名
     */
    private String getCurrentProcessName() {
        int pid = android.os.Process.myPid();
        String processName = "";
        ActivityManager manager = (ActivityManager) getApplicationContext().getSystemService
                (Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo process : manager.getRunningAppProcesses()) {
            if (process.pid == pid) {
                processName = process.processName;
            }
        }
        return processName;
    }
    public static ExpressStationEnum getExpressStationEnum(int i) {
        switch (i) {
            case 0:
                return DUODUOYIZHAN;
            case 1:
                return KUAIBAO;
            case 2:
                return ExpressStationEnum.STAGESMALLPOLE;
            case 3:
                return STATIONHELPER;
            case 4:
                return ExpressStationEnum.LAIQU;
            case 5:
                return ExpressStationEnum.KUAIDICAOSHI;
            case 6:
                return ExpressStationEnum.COURIERSMALLPOLE;
            case 7:
                return ExpressStationEnum.JITU;
            case 8:
                return ExpressStationEnum.MOXIGUANJIA;
            case 9:
                return ExpressStationEnum.FENGCHAOSERVICE;
            case 10:
                return ExpressStationEnum.MAMASTATION;
            case 11:
                return ExpressStationEnum.YSHOUFA;
            case 12:
                return ExpressStationEnum.ZYZT;
            case 13:
                return ExpressStationEnum.ZHONGYOUSTATION;
            case 14:
                return ExpressStationEnum.PANDAHARVEST;
            case 15:
                return ExpressStationEnum.BLUESHOP;
            case 16:
                return ExpressStationEnum.YUNDAKDCS;
            case 17:
                return ExpressStationEnum.FENSHISHENGHUO;
            case 18:
                return ExpressStationEnum.GUOGUOYIZHAN;
            case 19:
                return ExpressStationEnum.JINLINBAOGAOPAIYI;
            case 20:
                return ExpressStationEnum.JINLINBAOKUAIDIQUJIAN;
            case 21:
                return ExpressStationEnum.JINLINBAOOCRJIEBO;
            case 22:
                return ExpressStationEnum.JINLINBAOQIANSHOU;
            case 23:
                return ExpressStationEnum.SUDIYIGONGPEI;
            case 24:
                return ExpressStationEnum.JUSHUITAN;
            case 25:
                return ExpressStationEnum.XINGHUO;
            case 26:
                return ExpressStationEnum.XINIAOGAOPAIYI;
            case 27:
                return ExpressStationEnum.XIAOBINGSTATION;
            case 28:
                return ExpressStationEnum.NETMANAGER;
            case 29:
                return ExpressStationEnum.MIAOZHAN;
            case 30:
                return ExpressStationEnum.ZHONGYOUCHENGZHONG;
        }
        return KUAIBAO;
    }
}
