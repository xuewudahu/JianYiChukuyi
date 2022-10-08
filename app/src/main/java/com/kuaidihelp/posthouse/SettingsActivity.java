package com.kuaidihelp.posthouse;


import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.rq.barcode.RqEngineer;
import com.rq.net.MyApplication;

@SuppressLint("UseSwitchCompatOrMaterialCode")
public class SettingsActivity extends AppCompatActivity {
    private static final String TAG = "ScanTestActivity";
    private boolean DEBUG = true;
    private RqEngineer mRqEngineer;
    private long lastonclickTime = 0;
    private long lastToastTime = 0;
    /**
     * 静态属性
     */
    //开关
    private final static String FRONT_CAMERA_OPENED = "front_camera_opened";
    private final static String SCAN_CAMERA_OPENED = "scan_camera_opened";
    private final static String FILL_LIGHT_OPENED = "fill_light_opened";
    private final static String START_DECODE_OPEND = "start_Decode_opend";
    private final static String GAMMA_ON = "gamma_on";
    private final static String SCAN_SOUND_OPENED = "scan_sound_opened";
    private final static String SCAN_SCAN_TEST = "scan_scan_test";
    private final static String SCAN_SCAN_TIME = "scan_scan_time";

    /**
     * 关键属性
     */
    private SharedPreferences pullPreference;
    private Handler mMainHandler;
    private TextView textViewVersion;

    /**
     * 开关状态
     */
    private Switch switchLightswitch;
    private Switch switchDecodemode;
    private Switch switchFacecamera;
    private Switch switchScancamera;
    private Switch switchGamaimage;
    private Switch switchSound;
    private RelativeLayout relaScanTest;
    TextView duplicateBarcodeText;
    TextView lightProgressText;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setting);
        /**
         *声明相对布局
         */
        RelativeLayout relativeLayoutyizhan = findViewById(R.id.yizhan);
        RelativeLayout relativeLayoutPhotosearch = findViewById(R.id.photo_search);
        RelativeLayout relativeLayoutWifiSettings = findViewById(R.id.wifi_settings);
        RelativeLayout relativeLayoutBrowerSettings = findViewById(R.id.settings_browser);
        RelativeLayout relativeLayoutSystemSettings = findViewById(R.id.system_settings);
        RelativeLayout relativeLayoutweight = findViewById(R.id.weight);
        RelativeLayout relativeLayoutcamera = findViewById(R.id.camera);
        RelativeLayout relativeLayoutTemplateselection = findViewById(R.id.template_selection);
        RelativeLayout relativeLayoutCameraexchange = findViewById(R.id.camera_exchange);
        RelativeLayout relativeLayoutSpeedtest = findViewById(R.id.speed_test);
        RelativeLayout relativeLayoutReportupdate = findViewById(R.id.report_update);
        RelativeLayout relativeLayoutupdate = findViewById(R.id.update);
        RelativeLayout relativeLayoutUseragreement = findViewById(R.id.user_agreement);
        RelativeLayout relativeLayoutclose = findViewById(R.id.close);
        /**
         *声明图片
         */
        RelativeLayout imageViewBackmain = findViewById(R.id.back_main_relative);
        RelativeLayout imageViewAddbtn = findViewById(R.id.time_add_icon);
        RelativeLayout imageViewLessbtn = findViewById(R.id.time_less_icon);
        RelativeLayout imageViewLightAddbtn = findViewById(R.id.light_add_icon);
        RelativeLayout imageViewLightLessbtn = findViewById(R.id.light_less_icon);
        duplicateBarcodeText = findViewById(R.id.duplicateBarcodeTime);
        lightProgressText = findViewById(R.id.light_progress);
        /**
         *声明开关
         */
        switchDecodemode = findViewById(R.id.decode_mode);
        switchFacecamera = findViewById(R.id.face_camera_switch);
        switchScancamera = findViewById(R.id.scan_camera_switch);
        switchGamaimage = findViewById(R.id.gama_image);
        switchSound = findViewById(R.id.sw_sdCardSwt);
        relaScanTest = findViewById(R.id.scanTest_mode);
        textViewVersion = findViewById(R.id.tv_version);
        textViewVersion.setText(MyApplication.getLocalVersionName(this));
        /**
         *设置单击监听
         */
        relativeLayoutcamera.setOnClickListener(new listener());
        relativeLayoutclose.setOnClickListener(new listener());
        relativeLayoutCameraexchange.setOnClickListener(new listener());
        relativeLayoutPhotosearch.setOnClickListener(new listener());
        relativeLayoutWifiSettings.setOnClickListener(new listener());
        relativeLayoutSystemSettings.setOnClickListener(new listener());
        relativeLayoutBrowerSettings.setOnClickListener(new listener());
        relativeLayoutReportupdate.setOnClickListener(new listener());
        relativeLayoutSpeedtest.setOnClickListener(new listener());
        relativeLayoutTemplateselection.setOnClickListener(new listener());
        relativeLayoutupdate.setOnClickListener(new listener());
        relativeLayoutUseragreement.setOnClickListener(new listener());
        relativeLayoutweight.setOnClickListener(new listener());
        relativeLayoutyizhan.setOnClickListener(new listener());
        relaScanTest.setOnClickListener(new listener());
        imageViewBackmain.setOnClickListener(new listener());
        imageViewAddbtn.setOnClickListener(new listener());
        imageViewLessbtn.setOnClickListener(new listener());
        imageViewLightAddbtn.setOnClickListener(new listener());
        imageViewLightLessbtn.setOnClickListener(new listener());

        /**
         * 保持屏幕常亮
         */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);     // for keeping screen on
        /**
         * 关键属性初始化
         */
        mRqEngineer = RqEngineer.getInstence(this);
        mMainHandler = new Handler(Looper.getMainLooper());
        pullPreference = getSharedPreferences("state", 0);
        /**
         * 前置相机开启开关
         */
        switchFacecamera.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                SharedPreferences.Editor e = pullPreference.edit();
                e.putBoolean(FRONT_CAMERA_OPENED, isChecked);
                e.apply();
            }
        });
        /**
         * 灯光开启开关
         */
/*        switchLightswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                SharedPreferences.Editor e = pullPreference.edit();
                e.putBoolean(FILL_LIGHT_OPENED, isChecked);
                e.apply();
            }
        });*/
        /**
         * 扫码相机开启开关
         */
        switchScancamera.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                SharedPreferences.Editor e = pullPreference.edit();
                e.putBoolean(SCAN_CAMERA_OPENED, isChecked);
                e.apply();
            }
        });
        /**
         * 读码模式开启开关
         */
        switchDecodemode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                SharedPreferences.Editor e = pullPreference.edit();
                e.putBoolean(START_DECODE_OPEND, isChecked);
                e.apply();
            }
        });
        /**
         * 图像伽马开启开关
         */
        switchGamaimage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                SharedPreferences.Editor e = pullPreference.edit();
                e.putBoolean(GAMMA_ON, isChecked);
                e.apply();
            }
        });

        /**
         * 扫描声音开启开关
         */
        switchSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                SharedPreferences.Editor e = pullPreference.edit();
                e.putBoolean(SCAN_SOUND_OPENED, isChecked);
                e.apply();
            }
        });
    }

    /**
     * 单击事件监听
     */
    private class listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.camera:
                    Long time_button_camera = SystemClock.uptimeMillis();
                    if (time_button_camera - lastonclickTime >= 1500) {
                        Intent intent_cammera = new Intent(SettingsActivity.this, SymbologiesActivity.class);
                        startActivity(intent_cammera);
                        lastonclickTime = time_button_camera;
                    }
                    break;
                case R.id.close:
                    Toast.makeText(SettingsActivity.this, "关闭软件", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.camera_exchange:
                    Toast.makeText(SettingsActivity.this, "相机切换", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.photo_search:
                    Long time_button = SystemClock.uptimeMillis();
                    if (time_button - lastonclickTime >= 1500) {
                        Intent intent_photo_search = new Intent(SettingsActivity.this, PhotoSearchActivity.class);
                        startActivity(intent_photo_search);
                        lastonclickTime = time_button;
                    }
                    break;
                case R.id.wifi_settings:
                    Long time_button_wifi = SystemClock.uptimeMillis();
                    if (time_button_wifi - lastonclickTime >= 1500) {
                        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        lastonclickTime = time_button_wifi;
                    }
                    break;
                case R.id.settings_browser:
                    Long time_button_browser = SystemClock.uptimeMillis();
                    if (time_button_browser - lastonclickTime >= 1500) {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName("com.android.browser","com.android.browser.BrowserActivity"));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        lastonclickTime = time_button_browser;
                    }
                    break;
                case R.id.system_settings:
                    Long time_button_system = SystemClock.uptimeMillis();
                    if (time_button_system - lastonclickTime >= 1500) {
                        Intent intent = new Intent(Settings.ACTION_SETTINGS);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        lastonclickTime = time_button_system;
                    }
                    break;
                case R.id.report_update:
                    Intent intent_report_update = new Intent(SettingsActivity.this, ReportUpdateActivity.class);
                    startActivity(intent_report_update);
                    break;
                case R.id.update:
                    Intent intent_update = new Intent(SettingsActivity.this, UpdateActivity.class);
                    startActivity(intent_update);
                    break;
                case R.id.speed_test:
                    Intent intent_speed_test = new Intent(SettingsActivity.this, SpeedTestActivity.class);
                    startActivity(intent_speed_test);
                    break;
                case R.id.template_selection:
                    Toast.makeText(SettingsActivity.this, "模板选择", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.user_agreement:
                    Intent intent_user_agreement = new Intent(SettingsActivity.this, UserAgreementActivity.class);
                    startActivity(intent_user_agreement);
                    break;
                case R.id.weight:
                    Intent intent_weight = new Intent(SettingsActivity.this, WeightActivity.class);
                    startActivity(intent_weight);
                    break;
                case R.id.yizhan:
                    Long time_button_yizhan = SystemClock.uptimeMillis();
                    if (time_button_yizhan - lastonclickTime >= 1500) {
                        Intent intent_yizhan = new Intent(SettingsActivity.this, ExpressListActivity.class);
                        startActivity(intent_yizhan);
                        lastonclickTime = time_button_yizhan;
                    }
                    break;
                case R.id.back_main_relative:
                    Long time = SystemClock.uptimeMillis();
                    if (time - lastonclickTime >= 1500) {
                        /*Intent intent_back_main = new Intent(SettingActivity.this, MainActivity.class);
                        startActivity(intent_back_main);*/
                        finish();
                        lastonclickTime = time;
                    }
                    break;
                case R.id.time_add_icon:
                    if (pullPreference.getInt(SCAN_SCAN_TIME, 8) < 20) {
                        duplicateBarcodeText.setText(String.valueOf(pullPreference.getInt(SCAN_SCAN_TIME, 8) + 1) + "秒");
                        SharedPreferences.Editor e = pullPreference.edit();
                        e.putInt(SCAN_SCAN_TIME, pullPreference.getInt(SCAN_SCAN_TIME, 8) + 1);
                        e.apply();
                    } else {
                        Long time2 = SystemClock.uptimeMillis();
                        if (time2 - lastToastTime >= 2000) {
                            Toast.makeText(SettingsActivity.this, "超时时间最长为 20 秒", Toast.LENGTH_SHORT).show();
                            lastToastTime = time2;
                        }
                    }
                    break;
                case R.id.time_less_icon:
                    if (pullPreference.getInt(SCAN_SCAN_TIME, 8) > 5) {
                        duplicateBarcodeText.setText(String.valueOf(pullPreference.getInt(SCAN_SCAN_TIME, 8) - 1) + "秒");
                        SharedPreferences.Editor e2 = pullPreference.edit();
                        e2.putInt(SCAN_SCAN_TIME, pullPreference.getInt(SCAN_SCAN_TIME, 8) - 1);
                        e2.apply();
                    } else {
                        Long time2 = SystemClock.uptimeMillis();
                        if (time2 - lastToastTime >= 2000) {
                            Toast.makeText(SettingsActivity.this, "超时时间最短为 5 秒", Toast.LENGTH_SHORT).show();
                            lastToastTime = time2;
                        }
                    }

                    break;
                case R.id.light_add_icon:
                    if (pullPreference.getInt(FILL_LIGHT_OPENED, 10) < 10) {
                        lightProgressText.setText(String.valueOf(pullPreference.getInt(FILL_LIGHT_OPENED, 8) + 1) );
                        SharedPreferences.Editor e = pullPreference.edit();
                        e.putInt(FILL_LIGHT_OPENED, pullPreference.getInt(FILL_LIGHT_OPENED, 10) + 1);
                        e.apply();
                        mRqEngineer.setIllState(pullPreference.getInt(FILL_LIGHT_OPENED, 10));
                    } else {
                        Long time2 = SystemClock.uptimeMillis();
                        if (time2 - lastToastTime >= 2000) {
                            Toast.makeText(SettingsActivity.this, "最大亮度为 10", Toast.LENGTH_SHORT).show();
                            lastToastTime = time2;
                        }
                    }
                    break;
                case R.id.light_less_icon:
                    if (pullPreference.getInt(FILL_LIGHT_OPENED, 10) > 0) {
                        lightProgressText.setText(String.valueOf(pullPreference.getInt(FILL_LIGHT_OPENED, 10) - 1) );
                        SharedPreferences.Editor e2 = pullPreference.edit();
                        e2.putInt(FILL_LIGHT_OPENED, pullPreference.getInt(FILL_LIGHT_OPENED, 10) - 1);
                        e2.apply();
                        mRqEngineer.setIllState(pullPreference.getInt(FILL_LIGHT_OPENED, 10));
                    } else {
                        Long time2 = SystemClock.uptimeMillis();
                        if (time2 - lastToastTime >= 2000) {
                            Toast.makeText(SettingsActivity.this, "最小亮度为 0", Toast.LENGTH_SHORT).show();
                            lastToastTime = time2;
                        }
                    }
                    break;
                case R.id.scanTest_mode:

                        Long time2 = SystemClock.uptimeMillis();
                        if (time2 - lastToastTime >= 1500) {
                            SharedPreferences.Editor e = pullPreference.edit();
                            e.putBoolean("scan_scan_test", true);
                            e.commit();
                            Intent intent = new Intent();
                            intent.setClass(SettingsActivity.this, MainActivity.class);
                            intent.putExtra("scan_scan_test","true");
                            startActivity(intent);
                            lastToastTime = time2;
                        }
                    break;
            }
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getSharedPreferences("state", 0);
        boolean scanState = sharedPreferences.getBoolean(SCAN_CAMERA_OPENED, true);
        boolean faceState = sharedPreferences.getBoolean(FRONT_CAMERA_OPENED, true);
        boolean decodeState = sharedPreferences.getBoolean(START_DECODE_OPEND, true);
        boolean gammaState = sharedPreferences.getBoolean(GAMMA_ON, false);
        boolean soundState = sharedPreferences.getBoolean(SCAN_SOUND_OPENED, false);
        //boolean scanTestState = sharedPreferences.getBoolean(SCAN_SCAN_TEST, false);
        //switchLightswitch.setChecked(lightState);
        switchDecodemode.setChecked(decodeState);
        switchScancamera.setChecked(scanState);
        switchGamaimage.setChecked(gammaState);
        switchSound.setChecked(soundState);
        switchFacecamera.setChecked(faceState);
        /*switchScanTest.setChecked(scanTestState);*/
        duplicateBarcodeText.setText(String.valueOf(pullPreference.getInt(SCAN_SCAN_TIME, 8)) + "秒");
        lightProgressText.setText(String.valueOf(pullPreference.getInt(FILL_LIGHT_OPENED, 10)));
    }

}

