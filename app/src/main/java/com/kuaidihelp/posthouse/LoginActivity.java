package com.kuaidihelp.posthouse;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.alibaba.fastjson.JSON;
import com.dou361.dialogui.DialogUIUtils;
import com.kuaidihelp.posthouse.util.AdroidUtil;
import com.rq.net.MyApplication;
import com.rq.net.bean.JiTuLoginBean;
import com.rq.net.bean.KDCSLoginResponseBean;
import com.rq.net.bean.KuaiBaoLoginBean;
import com.rq.net.bean.LaiquLoginResponseBean;
import com.rq.net.bean.LaiquSiteLoginResponseBean;
import com.rq.net.bean.PandaBeanKt;
import com.rq.net.bean.PandaLoginBean;
import com.rq.net.bean.PinDuoDuoBaseResponseBean;
import com.rq.net.bean.Ref;
import com.rq.net.bean.ShowMuchPackageNoPickBean;
import com.rq.net.manager.MixScanMamager;
import com.rq.net.manager.OkHttpPinDuoDuoManager;
import com.rq.net.manager.OkhttpManager;
import com.rq.net.setting.RqFilePreference;
import com.rq.net.util.Base64Util;
import com.rq.net.util.ExpressStationEnum;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.MD5Util;
import com.rq.net.util.StringUtil;
import com.rq.net.util.SystemUtil;
import com.rq.net.util.ToastSoundUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.widget.Toast;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Charsets;
import com.rq.net.bean.BlueShopLoginBean;
import com.rq.net.bean.GaoPaiYiRequest;
import com.rq.net.bean.JinLinBaoLoginResponseBean;
import com.rq.net.bean.MaMaLoginBean;
import com.rq.net.bean.MiaoZhanLoginBean;
import com.rq.net.bean.PublicKeyBean;
import com.rq.net.bean.XingHuoLoginBean;
import com.rq.net.manager.OkhttpMoxiManager;
import com.rq.net.setting.CommonFilePreference;
import com.rq.net.util.RsaUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.Charset;

public class LoginActivity extends AppCompatActivity implements OkhttpManager.OnOkhttpCallback,
        OkhttpManager.OnOkhttpCallbackError, OkhttpManager.OnHttpErrorCallback, MixScanMamager.OkhttpCallbackStationManager {
    private TextView loginButton;
    private ImageView settingsButton;
    private TextView loginProtocol;
    private TextView loginqrText;
    private Spinner loginServeSpinner;
    private LinearLayout loginpasswordLinearLayout;
    private LinearLayout loginqrLinearLayout;
    private ImageView loginpasswordImageView;
    private ImageView loginqrImageView;
    private long lastonclickTime = 0;
    private ImageView loginprotocolImage;
    private ImageView loginprotocolNoselectImage;
    private ImageView loginAccoutDelectImage;
    private ImageView loginPasswordDelectImage;
    private EditText loginAccountEdit;
    private EditText loginPasswordEdit;
    private EditText loginBranchEdit;
    ;

    private ImageView verityCode;
    private EditText verityCodeText;
    public static final String TAG = "MainActivity";
    private Boolean accountFlag = true;
    private Boolean passwordFlag = true;
    private Dialog dialog;
    public static String ANDROID_ID;
    private Thread loginthread;
    private String duoduoVerify = "";
    public static SharedPreferences preferDataList;
    public Boolean isSingle;
    public ArrayList<Integer> multiList;
    public int num;
    private final static String SCAN_SCAN_TEST = "scan_scan_test";
    private RelativeLayout loginBranchRela;
    private Dialog mFactRstPwsCheckDialog;
    private TextView cancelButton;
    private TextView okButton;
    private EditText pswEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("wxw_界面", "---进入登录界面-onCreate");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login2);
        num = MyApplication.getNum();
        Log.e("wxw_login", "----num" + num);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        DialogUIUtils.init(this);
        preferDataList = getSharedPreferences("state", Activity.MODE_PRIVATE);
        isSingle = preferDataList.getBoolean("isSingle", true);
        multiList = MyApplication.getselectedPositionMulti();
        OkhttpManager.setOnhttpErrorCallback((OkhttpManager.OnHttpErrorCallback) LoginActivity.this);
        OkhttpManager.setOnhttpErrorCallback((OkhttpManager.OnOkhttpCallbackError) LoginActivity.this);
        OkhttpManager.setOnOkhttpCallback((OkhttpManager.OnOkhttpCallback) LoginActivity.this);
        initView();
        initListener();
        requestPermission();

    }


    private void requestPermission() {
        Log.e("wxww", "---" + Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // 先判断有没有权限
            if (Environment.isExternalStorageManager()) {
                //writeFile();
            } else {
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                //intent.setData(Uri.parse("package:" + LoginActivity.getPackageName()));
                //startActivityForResult(intent, REQUEST_CODE);
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 先判断有没有权限
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                //writeFile();
                Log.e("wxww222", "---" + Build.VERSION.SDK_INT);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
            }
        } else {
            //writeFile();
        }
    }

    private void initListener() {
        loginAccountEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                accountFlag = s.length() > 0;
                Log.e("accountFlagFlagwxwwww", "----passwordFlag--" + passwordFlag + "--accountFlag-" + accountFlag);
                if (accountFlag && passwordFlag) {
                    loginButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_login_bg));
                    loginButton.setEnabled(true);
                } else {
                    loginButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_grey));
                    loginButton.setEnabled(false);
                }
                if (accountFlag) {
                    loginAccoutDelectImage.setVisibility(View.VISIBLE);
                } else {
                    loginAccoutDelectImage.setVisibility(View.GONE);
                }
            }
        });
        loginAccountEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    if (!loginAccountEdit.getText().toString().isEmpty()) {
                        loginAccoutDelectImage.setVisibility(View.VISIBLE);
                    }
                } else {
                    loginAccoutDelectImage.setVisibility(View.GONE);
                }
            }
        });

        loginAccoutDelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginAccountEdit.setText("");
            }
        });
        loginPasswordDelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPasswordEdit.setText("");
            }
        });
        loginprotocolNoselectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginprotocolNoselectImage.setVisibility(View.INVISIBLE);
                loginprotocolImage.setVisibility(View.VISIBLE);
            }
        });
        loginprotocolImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginprotocolImage.setVisibility(View.INVISIBLE);
                loginprotocolNoselectImage.setVisibility(View.VISIBLE);
            }
        });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFactoryResetPwdDialog();
                // finish();
            }
        });
        loginPasswordEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                passwordFlag = s.length() > 0;
                Log.e("passwordFlagwxwwww", "----passwordFlag--" + passwordFlag + "--accountFlag-" + accountFlag);
                if (accountFlag && passwordFlag) {
                    loginButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_login_bg));
                    loginButton.setEnabled(true);
                } else {
                    loginButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_grey));
                    loginButton.setEnabled(false);
                }
                if (passwordFlag) {
                    loginPasswordDelectImage.setVisibility(View.VISIBLE);
                } else {
                    loginPasswordDelectImage.setVisibility(View.GONE);
                }
            }
        });

        loginPasswordEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    if (!loginPasswordEdit.getText().toString().isEmpty()) {
                        loginPasswordDelectImage.setVisibility(View.VISIBLE);
                    }
                } else {
                    loginPasswordDelectImage.setVisibility(View.GONE);
                }
            }
        });

        loginprotocolImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginprotocolImage.setVisibility(View.INVISIBLE);
                loginprotocolNoselectImage.setVisibility(View.VISIBLE);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Long time_button = SystemClock.uptimeMillis();
                if (time_button - lastonclickTime >= 3500) {
                    if (loginprotocolImage.getVisibility() == View.INVISIBLE) {

                        DialogUIUtils.showToastCenter("请先勾选协议");
                    } else if (!AdroidUtil.isConnectedToInternet(LoginActivity.this)) {
                        DialogUIUtils.showToastCenter("请检查网络连接");
                    } else {

                        if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.DUODUOYIZHAN) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.DUODUOYIZHAN)) {
                            duoduoLoginVerify(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.KUAIBAO) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.KUAIBAO)) {
                            kuaibaoLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.STAGESMALLPOLE) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.STAGESMALLPOLE)) {
                            stageSmallPoleLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.STATIONHELPER) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.STATIONHELPER)) {
                            stationHelperLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.LAIQU) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.LAIQU)) {
                            laiquLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.KUAIDICAOSHI) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.KUAIDICAOSHI)) {
                            tuxikdcsLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.COURIERSMALLPOLE) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.COURIERSMALLPOLE)) {
                            ziCourierSmallPoleLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.JITU) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.JITU)) {
                            jiTuLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.YSHOUFA) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.YSHOUFA)) {
                            yishoufaLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.YUNDAKDCS) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.YUNDAKDCS)) {
                            yundaKDCSLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.PANDAHARVEST) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.PANDAHARVEST)) {
                            pandaHarvestLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.MOXIGUANJIA) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.MOXIGUANJIA)) {
                            //  moxiLogin(loginBranchEdit.getText().toString().trim(), loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                            moxiLogin("1234", loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());

                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.ZYZT) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.ZYZT)) {
                            zyztLogin(RqFilePreference.getInstance().getZyztSiteCode());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.ZHONGYOUSTATION) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.ZHONGYOUSTATION)) {
                            zhongYouStationLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.MAMASTATION) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.MAMASTATION)) {
                            mamaStaionLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.BLUESHOP) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.BLUESHOP)) {
                            blueShopLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.FENGCHAOSERVICE) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.FENGCHAOSERVICE)) {
                            fcboxLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.FENSHISHENGHUO) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.FENSHISHENGHUO)) {
                            fsshLogin(loginAccountEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.GUOGUOYIZHAN) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.GUOGUOYIZHAN)) {
                            guoGuoYiZhanLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOGAOPAIYI
                                || MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOQIANSHOU
                                || MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOKUAIDIQUJIAN
                                || MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOOCRJIEBO) || (!isSingle && (MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.JINLINBAOGAOPAIYI
                                || MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.JINLINBAOQIANSHOU
                                || MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.JINLINBAOKUAIDIQUJIAN
                                || MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.JINLINBAOOCRJIEBO))) {
                            jinlinbaoLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.SUDIYIGONGPEI) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.SUDIYIGONGPEI)) {
                            sudiyiLogin();
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.JUSHUITAN) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.JUSHUITAN)) {
                            juShuiTanLogin(loginAccountEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.XINGHUO) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.XINGHUO)) {
                            xingHuoLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.XINIAOGAOPAIYI) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.XINIAOGAOPAIYI)) {
                            xiNiaoGaoPaiLogin();
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.XIAOBINGSTATION) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.XIAOBINGSTATION)) {
                            xiaobingLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.NETMANAGER) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.NETMANAGER)) {
                            netManagerLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim());
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.MIAOZHAN) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.MIAOZHAN)) {
                            miaoZhanLogin();
                        } else if ((isSingle && MyApplication.getStationEnum() == ExpressStationEnum.ZHONGYOUCHENGZHONG) || (!isSingle && MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.ZHONGYOUCHENGZHONG)) {
                            zhongyouLogin();
                        }

                        lastonclickTime = time_button;
                    }

                }

            }
        });
    }

    private void createFactoryResetPwdDialog() {
        mFactRstPwsCheckDialog = new Dialog(this, R.style.dialog);
        //mFactRstPwsCheckDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mFactRstPwsCheckDialog.setCanceledOnTouchOutside(false);
        mFactRstPwsCheckDialog.setCancelable(false);
        mFactRstPwsCheckDialog.setContentView(R.layout.factory_rst_pwd_dialog);
        //  mFactRstPwsCheckDialog.setTitle("please input password:");
        pswEdit = (EditText) mFactRstPwsCheckDialog.findViewById(R.id.FactRstDialogPsw);
        pswEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (pswEdit.getText().toString().equals("654321")) {
                    mFactRstPwsCheckDialog.dismiss();
                    Intent intent = new Intent(LoginActivity.this, SettingsActivity.class);
                    startActivity(intent);
                }
            }
        });
        cancelButton = (TextView) mFactRstPwsCheckDialog.findViewById(R.id.FactRstDialogCancel);
        okButton = (TextView) mFactRstPwsCheckDialog.findViewById(R.id.FactRstDialogCertain);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                //finish();
                mFactRstPwsCheckDialog.dismiss();//finish();
            }
        });
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                android.util.Log.d("wxw", "password" + Settings.Global.getString(getContentResolver(), "h200.administrator.password"));
                if (pswEdit.getText().toString().equals("654321")) {
                    Intent intent = new Intent(LoginActivity.this, SettingsActivity.class);
                    startActivity(intent);
                    mFactRstPwsCheckDialog.dismiss();//finish();

                }/*else if(pswEdit.getText().toString().equals("87654321")){
                    Intent intent =new Intent();
                    ComponentName componentName = new ComponentName("com.android.launcher3","com.android.launcher3.Launcher");
                    intent.setComponent(componentName);
                    startActivity(intent);
                    mFactRstPwsCheckDialog.dismiss();
                }*/ else {
                    Toast.makeText(LoginActivity.this, "密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                    pswEdit.setText("");
                }
            }
        });
        mFactRstPwsCheckDialog.show();
//        pswEdit.setFocusableInTouchMode(true);
//        pswEdit.requestFocus();

        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pswEdit.setFocusable(true);
                pswEdit.setFocusableInTouchMode(true);
                pswEdit.requestFocus();
                InputMethodManager inputManager =
                        (InputMethodManager)pswEdit.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(pswEdit, 0);

            }
        },100);

    }




    @SuppressLint("UseCompatLoadingForDrawables")
    private void initView() {

        verityCode = (ImageView) findViewById(R.id.verify_code);
        loginProtocol = findViewById(R.id.login_protocol);
        loginServeSpinner = findViewById(R.id.login_serve);
        loginpasswordLinearLayout = findViewById(R.id.login_password_linear);
        loginprotocolImage = findViewById(R.id.login_protocol_image);
        loginprotocolNoselectImage = findViewById(R.id.login_protocol_noselect_image);
        loginAccountEdit = findViewById(R.id.loginAccount);
        loginAccoutDelectImage = findViewById(R.id.account_delect);
        loginPasswordDelectImage = findViewById(R.id.password_delect);
        verityCodeText = (EditText) findViewById(R.id.loginverityCode);
        settingsButton = findViewById(R.id.tiaozhuan_settings);
        loginBranchRela = findViewById(R.id.branch_RelativeLayout);
        SpannableString s = new SpannableString("请输入账号");
        AbsoluteSizeSpan textSize = new AbsoluteSizeSpan(24, true);
        s.setSpan(textSize, 0, s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        loginAccountEdit.setHint(s);
        loginPasswordEdit = findViewById(R.id.loginPassword);
        loginBranchEdit = (EditText) findViewById(R.id.loginBranch);
        SpannableString s2 = new SpannableString("请输入密码");
        AbsoluteSizeSpan textSize2 = new AbsoluteSizeSpan(24, true);
        s2.setSpan(textSize2, 0, s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        loginPasswordEdit.setHint(s2);
        //loginServeText.setText("-"+MyApplication.getStationEnum().getName());
        loginButton = findViewById(R.id.login_go);
        if (!TextUtils.isEmpty(loginPasswordEdit.getText().toString()) && !TextUtils.isEmpty(loginAccountEdit.getText().toString())) {
            loginButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_login_bg));
            loginButton.setEnabled(true);
        } else {
            loginButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_grey));
            loginButton.setEnabled(false);
        }

        verityCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MyApplication.getStationEnum() == ExpressStationEnum.DUODUOYIZHAN || MyApplication.getExpressStationEnum(multiList.get(num)) == ExpressStationEnum.DUODUOYIZHAN) {
                    getDuoDuoVerify(duoduoVerify);
                }
            }
        });
        loginProtocol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ProtocolActivity.class);
                startActivity(intent);
            }
        });
        if (isSingle) {
            loginServeSpinner.setSelection(MyApplication.getStationEnum().getCode());
            loginServeSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Log.e("wxw", "----" + parent.getItemAtPosition(position).toString());
                    MyApplication.setStationEnum(MyApplication.getExpressStationEnum(position));
                    getExpressStationNum(position);
                    if (position == 11) {
                        //loginBranchRela.setVisibility(View.VISIBLE);
                        loginBranchRela.setVisibility(View.GONE);
                    } else {
                        loginBranchRela.setVisibility(View.GONE);
                    }
                    findViewById(R.id.verify_continer).setVisibility(View.GONE);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } else {
            loginServeSpinner.setSelection(multiList.get(num));
            getExpressStationNum(multiList.get(num));
            loginServeSpinner.setEnabled(false);
            loginprotocolNoselectImage.setVisibility(View.INVISIBLE);
            loginprotocolImage.setVisibility(View.VISIBLE);
        }

    }


    private void getExpressStationNum(int num) {
        RqFilePreference rqFilePreference = RqFilePreference.getInstance();
        if (num == 0) {
            loginAccountEdit.setText(rqFilePreference.getDUODUOYIZHANAccount());
            loginPasswordEdit.setText(rqFilePreference.getDUODUOYIZHANPwd());
/*            loginAccountEdit.setText("18605896467");
            loginPasswordEdit.setText("wy123456D");*/
        } else if (num == 1) {
            loginAccountEdit.setText(rqFilePreference.getKUAIBAOAccount());
            loginPasswordEdit.setText(rqFilePreference.getKUAIBAOPwd());
//            loginAccountEdit.setText("15665795702");
//            loginPasswordEdit.setText("sll123456");
        } else if (num == 2) {
            loginAccountEdit.setText(rqFilePreference.getSTAGESMALLPOLEAccount());
            loginPasswordEdit.setText(rqFilePreference.getSTAGESMALLPOLEPwd());
/*            loginAccountEdit.setText("18272856509");
            loginPasswordEdit.setText("1314520");*/
        } else if (num == 3) {
            loginAccountEdit.setText(rqFilePreference.getSTATIONHELPERAccount());
            loginPasswordEdit.setText(rqFilePreference.getSTATIONHELPERPwd());
/*            loginAccountEdit.setText("18622865956GPY");
            loginPasswordEdit.setText("gpy888");*/
        } else if (num == 4) {
            loginAccountEdit.setText(rqFilePreference.getLAIQUAccount());
            loginPasswordEdit.setText(rqFilePreference.getLAIQUPwd());
/*            loginAccountEdit.setText("18302274339");
            loginPasswordEdit.setText("linan21057577");*/
        } else if (num == 5) {
            loginAccountEdit.setText(rqFilePreference.getKUAIDICAOSHIAccount());
            loginPasswordEdit.setText(rqFilePreference.getKUAIDICAOSHIPwd());
/*            loginAccountEdit.setText("13164605963");
            loginPasswordEdit.setText("qq852631");*/
        } else if (num == 6) {
            loginAccountEdit.setText(rqFilePreference.getCOURIERSMALLPOLEAccount());
            loginPasswordEdit.setText(rqFilePreference.getCOURIERSMALLPOLEPwd());
/*            loginAccountEdit.setText("15106033173");
            loginPasswordEdit.setText("123456789");*/
        } else if (num == 7) {
            loginAccountEdit.setText(rqFilePreference.getJITUAccount());
            if (!TextUtils.isEmpty(rqFilePreference.getJITUAccount())) {
                loginPasswordEdit.setText(rqFilePreference.getJITUPwd());
            } else {
                loginPasswordEdit.setText("");
            }
/*            loginAccountEdit.setText("yuan004");
            loginPasswordEdit.setText("JT4730921");*/
        } else if (num == 8) {
            loginAccountEdit.setText(rqFilePreference.getMOXIGUANJIAAccount());
            loginPasswordEdit.setText(rqFilePreference.getMOXIGUANJIAPwd());
            // loginBranchEdit.setText(rqFilePreference.getMoxiBranch());
        } else if (num == 9) {
            loginAccountEdit.setText(rqFilePreference.getFENGCHAOSERVICEAccount());
            loginPasswordEdit.setText(rqFilePreference.getFENGCHAOSERVICEPwd());

        } else if (num == 10) {
            loginAccountEdit.setText(rqFilePreference.getMAMASTATIONAccount());
            loginPasswordEdit.setText(rqFilePreference.getMAMASTATIONPwd());

/*            loginAccountEdit.setText("12341234440");
            loginPasswordEdit.setText("abc123");*/
        }else if (num == 11) {
            loginAccountEdit.setText(rqFilePreference.getYSHOUFAAccount());
            loginPasswordEdit.setText(rqFilePreference.getYSHOUFAPwd());
/*            loginAccountEdit.setText("15855227222");
            loginPasswordEdit.setText("123456");*/

        }else if (num == 12) {
            loginAccountEdit.setText(rqFilePreference.getZYZTAccount());
            loginPasswordEdit.setText(rqFilePreference.getZYZTPwd());
        }else if (num == 13) {
            loginAccountEdit.setText(rqFilePreference.getZHONGYOUSTATIONAccount());
            loginPasswordEdit.setText(rqFilePreference.getZHONGYOUSTATIONPwd());
        }else if (num == 14) {
            loginAccountEdit.setText(rqFilePreference.getPANDAHARVESTAccount());
            loginPasswordEdit.setText(rqFilePreference.getPANDAHARVESTPwd());
        }else if (num == 15) {
            loginAccountEdit.setText(rqFilePreference.getBLUESHOPAccount());
            loginPasswordEdit.setText(rqFilePreference.getBLUESHOPPwd());
        }else if (num == 16) {
            loginAccountEdit.setText(rqFilePreference.getYUNDAKDCSAccount());
            loginPasswordEdit.setText(rqFilePreference.getYUNDAKDCSPwd());
/*            loginAccountEdit.setText("18983148303");
            loginPasswordEdit.setText("A123456");*/
        }else if (num == 17) {
            loginAccountEdit.setText(rqFilePreference.getFENSHISHENGHUOAccount());
            loginPasswordEdit.setText(rqFilePreference.getFENSHISHENGHUOPwd());
        }else if (num == 18) {
            loginAccountEdit.setText(rqFilePreference.getGUOGUOYIZHANAccount());
            loginPasswordEdit.setText(rqFilePreference.getGUOGUOYIZHANPwd());
        }else if (num == 19) {
            loginAccountEdit.setText(rqFilePreference.getJINLINBAOGAOPAIYIAccount());
            loginPasswordEdit.setText(rqFilePreference.getJINLINBAOGAOPAIYIPwd());
        }else if (num == 20) {
            loginAccountEdit.setText(rqFilePreference.getJINLINBAOGAOPAIYIAccount());
            loginPasswordEdit.setText(rqFilePreference.getJINLINBAOGAOPAIYIPwd());
        }else if (num == 21) {
            loginAccountEdit.setText(rqFilePreference.getJINLINBAOGAOPAIYIAccount());
            loginPasswordEdit.setText(rqFilePreference.getJINLINBAOGAOPAIYIPwd());
        }else if (num == 22) {
            loginAccountEdit.setText(rqFilePreference.getJINLINBAOGAOPAIYIAccount());
            loginPasswordEdit.setText(rqFilePreference.getJINLINBAOGAOPAIYIPwd());
        }else if (num == 23) {
            loginAccountEdit.setText(rqFilePreference.getSUDIYIGONGPEIAccount());
            loginPasswordEdit.setText(rqFilePreference.getSUDIYIGONGPEIPwd());
        }else if (num == 24) {
            loginAccountEdit.setText(rqFilePreference.getJUSHUITANAccount());
            loginPasswordEdit.setText(rqFilePreference.getJUSHUITANPwd());
        }else if (num == 25) {
            loginAccountEdit.setText(rqFilePreference.getXINGHUOAccount());
            loginPasswordEdit.setText(rqFilePreference.getXINGHUOPwd());
        }else if (num == 26) {
            loginAccountEdit.setText(rqFilePreference.getXINIAOGAOPAIYIAccount());
            loginPasswordEdit.setText(rqFilePreference.getXINIAOGAOPAIYIPwd());
        }else if (num == 27) {
            loginAccountEdit.setText(rqFilePreference.getXIAOBINGSTATIONAccount());
            loginPasswordEdit.setText(rqFilePreference.getXIAOBINGSTATIONPwd());
        }else if (num == 28) {
            loginAccountEdit.setText(rqFilePreference.getNETMANAGERAccount());
            loginPasswordEdit.setText(rqFilePreference.getNETMANAGERPwd());
        }else if (num == 29) {
            loginAccountEdit.setText(rqFilePreference.getMIAOZHANAccount());
            loginPasswordEdit.setText(rqFilePreference.getMIAOZHANPwd());
        }else if (num == 30) {
            loginAccountEdit.setText(rqFilePreference.getZHONGYOUCHENGZHONGAccount());
            loginPasswordEdit.setText(rqFilePreference.getZHONGYOUCHENGZHONGPwd());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("wxw_界面", "---进入登录界面-onResume");
        if (!isSingle&&!TextUtils.isEmpty(loginPasswordEdit.getText().toString())) {
            loginButton.performClick();
        }
    }

    public final void duoduoLoginVerify(final String var1, final String var2) {
        if (findViewById(R.id.verify_continer).getVisibility() == View.VISIBLE) {
            OkHttpPinDuoDuoManager.userVerify(LoginActivity.this, duoduoVerify, String.valueOf(verityCodeText.getText()), (OkhttpManager.OnHttpCallback) (new OkhttpManager.OnHttpCallback() {
                public void onError(int var1x, String var2x) {
                    Log.d(TAG, "userVerify onError: ================================================");
                    getDuoDuoVerify(duoduoVerify);
                    //ToastSoundUtil.displayToast("验证码错误");
                    DialogUIUtils.showToastCenter("验证码错误");
                }

                public void onSuccess(String var1x) {
                    Log.d(TAG, "userVerify onSuccess: ================================================");
                    duoduoLogin(var1, var2, duoduoVerify);
                }
            }));
            return;
        }
        this.duoduoLogin(var1, var2, duoduoVerify);
    }

    public final void duoduoLogin(final String var1, final String var2, final String var3) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "username");
        //Intrinsics.checkParameterIsNotNull(var2, "passoword");
        //Intrinsics.checkParameterIsNotNull(var3, "verifyauthtoken");*/
        OkHttpPinDuoDuoManager.getPasswordPublicKey(LoginActivity.this, var3, new OkhttpManager.OnOkhttpCallback() {
            public void onSuccess(PinDuoDuoBaseResponseBean var1x) {
                if (var1x == null) {
                    Log.e(TAG, "getPasswordPublicKey  success, but var is null");
                    return;
                } else {
                    Log.e(TAG, "getPasswordPublicKey  var1x:" + var1x.toString());
                }

                if (var1x.getSuccess()) {
                    Log.d(TAG, "onSuccess: =====================================");
                    OkHttpPinDuoDuoManager.loginByMobile(LoginActivity.this, var3, var1, var2, (String) var1x.getResult(), LoginActivity.this, new OkhttpManager.OnHttpErrorCallback() {
                        public final void onError(int var1x, String var2x) {
                            Log.e(TAG, "loginByMobile error,code=" + var1x + " new verify code:" + var2x);
                            if (var1x == 54001) {
                                duoduoVerify = var2x;
                                getDuoDuoVerify(var2x);
                                Log.e(TAG, "loginByMobile error,new verify code:" + var2x);
                            }

                        }
                    });
                } else {
                    Log.d(TAG, "onSuccess geterror");
                    var1x.getErrorCode();
                    var1x.getResult();
                    StringBuilder var2x = new StringBuilder();
                    var2x.append(var1x.getErrorMsg());
                    var2x.append(var1x.getError_msg());
                    ToastSoundUtil.wrongSoundToast(var2x.toString());
                }
            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1x) {
                this.onSuccess((PinDuoDuoBaseResponseBean) var1x);
            }
        });
    }

    public final void getDuoDuoVerify(String var1) {
        findViewById(R.id.verify_continer).setVisibility(View.VISIBLE);
        loginButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_login_bg));
        loginButton.setEnabled(true);
        OkHttpPinDuoDuoManager.getPicVerification(LoginActivity.this, true, var1, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
            public void onSuccess(Object var1) {
                if ("error".equals((String) var1)) {
                    LoginActivity.this.duoduoLogin(loginAccountEdit.getText().toString().trim(), loginPasswordEdit.getText().toString().trim(), (String) var1);
                }else{
                    this.onSuccess((String) var1);
                }

            }

            public final void onSuccess(String var1) {
                try {
                    verityCode.setImageBitmap(Base64Util.base64StringtoBitmap(var1));
                    return;
                } catch (Exception var3) {
                    var3.printStackTrace();
                }
            }
        }));
    }

    private int laiquIndex;

    public final void laiquLogin(String var1, String var2) {
        OkhttpManager.getLaiquRsaPublicKey(var1, var2, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(LaiquLoginResponseBean var1) {
                Exception var10000;
                label99:
                {
                    StringBuilder var5;
                    String var16;
                    Object var17;
                    boolean var10001;
                    final Ref.ObjectRef var21;
                    try {
                        ////Intrinsics.checkExpressionValueIsNotNull(var1, "data");
                        var16 = JsonUtil.getJsonStringByGson(var1.getServiceSites());
                        //String var4 = MixScanMamager.this.getTAG();
                        var5 = new StringBuilder();
                        var5.append("laiqu result:");
                        var5.append(var16);
                        Log.e(TAG, var5.toString());
                        if (!StringUtil.isNotEmpty(var16) || var16.length() <= 20) {
                            return;
                        }

                        var21 = new Ref.ObjectRef();
                        var17 = JsonUtil.getClazzByGson(var16, LaiquLoginResponseBean.ServiceSitesBean.class);
                    } catch (Exception var14) {
                        var10000 = var14;
                        var10001 = false;
                        break label99;
                    }

                    if (var17 != null) {
                        label101:
                        {
                            int var2;
                            try {
                                var21.element = (ArrayList) var17;
                                //var16 = MixScanMamager.this.getTAG();
                                var5 = new StringBuilder();
                                var5.append("laiqu net station count:");
                                var5.append(((ArrayList) var21.element).size());
                                Log.e(TAG, var5.toString());
                                var2 = ((ArrayList) var21.element).size();
                            } catch (Exception var13) {
                                var10000 = var13;
                                var10001 = false;
                                break label101;
                            }

                            RqFilePreference var18;
                            if (var2 <= 1) {
                                try {
                                    var17 = ((ArrayList) var21.element).get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var17, "resultList[0]");
                                    OkhttpManager.laiquSiteLogin(((LaiquLoginResponseBean.ServiceSitesBean) var17).getServiceSiteCode(), (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
                                        public final void onSuccess(LaiquSiteLoginResponseBean var1) {
                                            MixScanMamager.OkhttpCallbackStationManager var2 = LoginActivity.this;
                                            if (var2 != null) {
                                                var2.onLoginSuccess(ExpressStationEnum.LAIQU, "来取登录成功");
                                            }

                                        }

                                        // $FF: synthetic method
                                        // $FF: bridge method
                                        public void onSuccess(Object var1) {
                                            this.onSuccess((LaiquSiteLoginResponseBean) var1);
                                        }
                                    }));
                                    var18 = RqFilePreference.getInstance();
                                    ////Intrinsics.checkExpressionValueIsNotNull(var18, "RqFilePreference.getInstance()");
                                    Object var23 = ((ArrayList) var21.element).get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var23, "resultList[0]");
                                    var18.setLoginLaiQuServiceStaionCode(((LaiquLoginResponseBean.ServiceSitesBean) var23).getServiceSiteCode());
                                    return;
                                } catch (Exception var7) {
                                    var10000 = var7;
                                    var10001 = false;
                                }
                            } else {
                                label103:
                                {
                                    try {
                                        var18 = RqFilePreference.getInstance();
                                        ////Intrinsics.checkExpressionValueIsNotNull(var18, "RqFilePreference.getInstance()");
                                        if (StringUtil.isNotEmpty(var18.getLoginLaiQuServiceStaionCode())) {
                                            var18 = RqFilePreference.getInstance();
                                            ////Intrinsics.checkExpressionValueIsNotNull(var18, "RqFilePreference.getInstance()");
                                            OkhttpManager.laiquSiteLogin(var18.getLoginLaiQuServiceStaionCode(), (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
                                                public final void onSuccess(LaiquSiteLoginResponseBean var1) {
                                                    MixScanMamager.OkhttpCallbackStationManager var2 = LoginActivity.this;
                                                    if (var2 != null) {
                                                        var2.onLoginSuccess(ExpressStationEnum.LAIQU, "来取登录成功");
                                                    }

                                                }

                                                // $FF: synthetic method
                                                // $FF: bridge method
                                                public void onSuccess(Object var1) {
                                                    this.onSuccess((LaiquSiteLoginResponseBean) var1);
                                                }
                                            }));
                                            return;
                                        }
                                    } catch (Exception var15) {
                                        var10000 = var15;
                                        var10001 = false;
                                        break label103;
                                    }

                                    int var3;
                                    String[] var24;
                                    try {
                                        var24 = new String[((ArrayList) var21.element).size()];
                                        var3 = ((ArrayList) var21.element).size();
                                    } catch (Exception var12) {
                                        var10000 = var12;
                                        var10001 = false;
                                        break label103;
                                    }

                                    for (var2 = 0; var2 < var3; ++var2) {
                                        try {
                                            var17 = ((ArrayList) var21.element).get(var2);
                                            ////Intrinsics.checkExpressionValueIsNotNull(var17, "resultList[i]");
                                            var24[var2] = ((LaiquLoginResponseBean.ServiceSitesBean) var17).getServiceSiteName();
                                        } catch (Exception var11) {
                                            var10000 = var11;
                                            var10001 = false;
                                            break label103;
                                        }
                                    }


                                    try {
                                        (new AlertDialog.Builder(LoginActivity.this)).setTitle((CharSequence) "请选择门店").setIcon(R.mipmap.setting_laiqu_uploadpic_icon).setSingleChoiceItems((CharSequence[]) var24, 0, (DialogInterface.OnClickListener) (new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface var1, int var2) {
                                                laiquIndex = var2;
                                            }
                                        })).setCancelable(false).setPositiveButton((CharSequence) "确定", (DialogInterface.OnClickListener) (new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface var1, int var2) {
                                                StringBuilder var4 = new StringBuilder();
                                                var4.append("");
                                                var4.append(laiquIndex);
                                                var4.append("    ");
                                                Object var5 = ((ArrayList) var21.element).get(laiquIndex);
                                                ////Intrinsics.checkExpressionValueIsNotNull(var5, "resultList[laiquIndex]");
                                                var4.append(((LaiquLoginResponseBean.ServiceSitesBean) var5).getServiceSiteName());
                                                var4.append("=======");
                                                var5 = ((ArrayList) var21.element).get(laiquIndex);
                                                ////Intrinsics.checkExpressionValueIsNotNull(var5, "resultList[laiquIndex]");
                                                var4.append(((LaiquLoginResponseBean.ServiceSitesBean) var5).getServiceSiteCode());
                                                Log.e(TAG, var4.toString());
                                                Object var6 = ((ArrayList) var21.element).get(laiquIndex);
                                                ////Intrinsics.checkExpressionValueIsNotNull(var6, "resultList[laiquIndex]");
                                                String var3 = ((LaiquLoginResponseBean.ServiceSitesBean) var6).getServiceSiteCode();
                                                RqFilePreference var7 = RqFilePreference.getInstance();
                                                ////Intrinsics.checkExpressionValueIsNotNull(var7, "RqFilePreference.getInstance()");
                                                var7.setLoginLaiQuServiceStaionCode(var3);
                                                OkhttpManager.laiquSiteLogin(var3, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
                                                    public final void onSuccess(LaiquSiteLoginResponseBean var1) {
                                                        MixScanMamager.OkhttpCallbackStationManager var2 = LoginActivity.this;
                                                        if (var2 != null) {
                                                            var2.onLoginSuccess(ExpressStationEnum.LAIQU, "来取登录成功");
                                                        }
                                                    }

                                                    // $FF: synthetic method
                                                    // $FF: bridge method
                                                    public void onSuccess(Object var1) {
                                                        this.onSuccess((LaiquSiteLoginResponseBean) var1);
                                                    }
                                                }));
                                                var1.dismiss();
                                            }
                                        })).setNegativeButton((CharSequence) "取消", (DialogInterface.OnClickListener) null).show();
                                        return;
                                    } catch (Exception var8) {
                                        var10000 = var8;
                                        var10001 = false;
                                    }
                                }
                            }
                        }
                    } else {
//                        try {
//                            throw new Exception("null cannot be cast to non-null type kotlin.collections.ArrayList<com.rq.net.bean.LaiquLoginResponseBean.ServiceSitesBean> /* = java.util.ArrayList<com.rq.net.bean.LaiquLoginResponseBean.ServiceSitesBean> */");
//                        } catch (Exception var6) {
//                            var10000 = var6;
//                            var10001 = false;
//                        }
                    }
                }

               /* Exception var22 = var10000;
                var22.printStackTrace();*/
            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((LaiquLoginResponseBean) var1);
            }
        }));
    }

    public final void kuaibaoLogin(String var1, String var2) {
        KuaiBaoLoginBean var3 = new KuaiBaoLoginBean();
        var3.setPass(var2);
        var3.setData(JsonUtil.getJsonStringByGson(new KuaiBaoLoginBean.LoginData(var1, var2)));
        OkhttpManager.kuaibaoLoginApi(var3, var3.getSession_id(), LoginActivity.this);
    }

    public final void yundaKDCSLogin(String var1, String var2) {
        OkhttpManager.yundaKDCSNewLoginApi(var1, var2, LoginActivity.this);
    }

    public final void stationHelperLogin(String var2, String var3) {
        OkhttpManager.stationHelperLogin(LoginActivity.this, var2, var3, LoginActivity.this);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public final void tuxikdcsLogin(String var1, String var2) {
        ////Intrinsics.checkParameterIsNotNull(var1, "username");
        ////Intrinsics.checkParameterIsNotNull(var2, "passoword");
        OkhttpManager.kdcsLogin(var1, var2, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(KDCSLoginResponseBean var1) {
                MixScanMamager.OkhttpCallbackStationManager var2 = LoginActivity.this;
                if (var2 != null) {
                    var2.onLoginSuccess(ExpressStationEnum.KUAIDICAOSHI, "兔喜快递超市登录成功");
                }

            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((KDCSLoginResponseBean) var1);
            }
        }), (OkhttpManager.OnOkhttpCallbackError) null);
    }

    private void yishoufaLogin(String username, String paswrord) {
        OkhttpManager.yShouFaLogin(username, paswrord, LoginActivity.this);
    }

    public final void jiTuLogin(String var1, String var2) {
        RqFilePreference.getInstance().setJITUPwd(var2);
        String var3 = SystemUtil.getAppUUID(LoginActivity.this);
        var3 = var3.replace("-", "");
        var2 = MD5Util.getMD5Str(var2);
        StringBuilder var4 = new StringBuilder();
        var4.append("WA-");
        if (var3 != null) {
            String var5 = var3.substring(0, 14);
            var4.append(var5);
            OkhttpManager.JiTuLogin(new JiTuLoginBean(var4.toString(), var1, var2, var3), this);
        } else {
            Log.e(TAG, "null cannot be cast to non-null type java.lang.String");
        }
    }


    public final void ziCourierSmallPoleLogin(String var1, String var2) {
        OkhttpManager.couriersmallpoleLogin(var1, var2, new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(Object var1) {
                onLoginSuccess(ExpressStationEnum.COURIERSMALLPOLE, "快递员小扁担登录成功");
            }
        });
    }

    public final void stageSmallPoleLogin(String var1, String var2) {
        OkhttpManager.stagesmallpoleLogin(var1, var2, new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(Object var1) {
                onLoginSuccess(ExpressStationEnum.STAGESMALLPOLE, "驿站小扁担登录成功");
            }
        });
    }

    public final void pandaHarvestLogin(String var1, String var2) {
        String var6;
        label34:
        {
            ////Intrinsics.checkParameterIsNotNull(var1, "username");
            ////Intrinsics.checkParameterIsNotNull(var2, "loginPasswordEdit");
            Log.d(this.TAG, "pandaHarvestLogin: ========================");
            var6 = PandaBeanKt.getBluetoothAddress();
            if (var6 != null) {
                var6 = var6.replace(":", "");
                if (var6 != null) {
                    if (var6 == null) {
                        //throw new Exception("null cannot be cast to non-null type java.lang.String");
                        break label34;
                    }

                    var6 = var6.toLowerCase();
                    ////Intrinsics.checkExpressionValueIsNotNull(var6, "(this as java.lang.String).toLowerCase()");
                    break label34;
                }
            }

            var6 = null;
        }

        CharSequence var7 = (CharSequence) var6;
        boolean var3;
        if (var7 != null && var7.length() != 0) {
            var3 = false;
        } else {
            var3 = true;
        }

        if (var3) {
            ToastSoundUtil.displayToast("蓝牙地址获取异常，请检查蓝牙");
        } else {
            PandaLoginBean var8 = new PandaLoginBean(var1, var2, var6);
            RqFilePreference var9 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var9, "RqFilePreference.getInstance()");
            var9.setPandaHarvestInforTwo(var8);
            long var4 = System.currentTimeMillis();
            String jsonString = JSON.toJSONString(var8);
            StringBuilder var10 = new StringBuilder();
            var10.append(jsonString);
            var10.append("YP75838571"/*ApiPandaHarvestActvity.Companion.getAccountName()*/);
            var10.append("GET_TOKEN");
            var10.append("openbmx");
            var10.append(var4);
            var10.append(/*ApiPandaHarvestActvity.Companion.getAccountPassword()*/"yRLgecjAxVi9gLXx");
            var2 = var10.toString();
            ////Intrinsics.checkExpressionValueIsNotNull(var12, "Charset.forName(charsetName)");
            if (var2 != null) {
                ////Intrinsics.checkExpressionValueIsNotNull(var11, "(this as java.lang.String).getBytes(charset)");
                var2 = MD5Util.md5(var2);
                Map var13 = (Map) (new HashMap());
                ////Intrinsics.checkExpressionValueIsNotNull(var1, "data");
                var13.put("bizData", jsonString);
                var13.put("timestamp", String.valueOf(var4));
                var13.put("accountName", "YP75838571"/*ApiPandaHarvestActvity.Companion.getAccountName()*/);
                var13.put("apiName", "GET_TOKEN");
                var13.put("token", "openbmx");
                ////Intrinsics.checkExpressionValueIsNotNull(var2, "md5Str");
                var13.put("sign", var2);
                OkhttpManager.pandaHarvestLogin(var13, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
                    public final void onSuccess(Object var1x) {
                        if (var1x != null) {
                            MixScanMamager.OkhttpCallbackStationManager var2 = LoginActivity.this;
                            if (var2 != null) {
                                var2.onLoginSuccess(ExpressStationEnum.PANDAHARVEST, "熊猫快收登录成功");
                            }
                        }

                    }
                }));
            } else {
                //throw new Exception("null cannot be cast to non-null type java.lang.String");
            }
        }
    }

    private void moxiLogin(String branch, String account, String password) {
        OkhttpMoxiManager.login(branch, account, password, new OkhttpMoxiManager.OkhttpCallback() {
            @Override
            public void onError(int var1, String var2) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastSoundUtil.wrongSoundToast(var2);
                    }
                });

            }

            @Override
            public void onSuccess(String var1) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LoginActivity.this.onSuccess(var1);
                    }
                });
            }
        });
    }

    public final void zyztLogin(String var1) {
        RqFilePreference var2 = RqFilePreference.getInstance();
        var2.setZyJdSiteCode(var1);
        JSONObject var4 = new JSONObject();
        try {
            var4.put("V_MARK", "6038092285577617761");
            var4.put("V_JGBH", var1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        var1 = var4.toString();
        Charset var5 = Charset.forName("UTF-8");
        if (var1 != null) {
            byte[] var3 = var1.getBytes(var5);
            OkhttpManager.zyztHkGpy(Base64Util.encode(var3), "getConnectionCheck", LoginActivity.this);
        } else {
            ToastSoundUtil.wrongSoundToast("login name is null.");
        }
    }

    public final void zhongYouStationLogin(String var1, String var2) {
        KuaiBaoLoginBean var3 = new KuaiBaoLoginBean();
        var3.setPass(var2);
        var3.setAccount(var1);
        var3.setData(JsonUtil.getJsonStringByGson(new KuaiBaoLoginBean.LoginData(var1, var2)));
        OkhttpManager.zhongYouStationLoginApi(var3, var3.getSession_id(), LoginActivity.this);
    }

    public final void mamaStaionLogin(String var1, String var2) {
        MaMaLoginBean var3 = new MaMaLoginBean();
        var3.setPassword_save(var2);
        var3.setModelNo(SystemUtil.getSystemModel());
        if (StringUtil.isEmpty(CommonFilePreference.getInstance().getUUID())) {
            CommonFilePreference.getInstance().setUUID(SystemUtil.getAppUUID((Context) MyApplication.baseApp));
        }

        var3.setUsername(var1);
        var1 = Base64Util.getBaseString(MD5Util.encodeMd5ToByte(var2));
        var3.setPassword(var1.replace("\n", ""));
        OkhttpManager.mamaLoginApi(var3, this);
    }

    public final void blueShopLogin(String var1, String var2) {
        OkhttpManager.blueShopLogin(new BlueShopLoginBean("android", var1, var2), this);
    }

    public final void fcboxLogin(String var1, String var2) {
        OkhttpManager.fengchaoServiceLoginApi(var1, var2, this);
    }

    public final void fsshLogin(String var1) {
        RqFilePreference var2 = RqFilePreference.getInstance();
        var2.setFsshAppSID(var1);
        var2.setFENSHISHENGHUOAccount(var1);
        onSuccess(true);
    }

    public final void guoGuoYiZhanLogin(String var1, String var2) {
        OkhttpManager.guoGuoYiZhanLogin(var1, var2, this);
    }

    public final void jinlinbaoLogin(String var1, String var2) {
        OkhttpManager.jinLinBaoLogin(var1, var2, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(JinLinBaoLoginResponseBean var1) {
                JinLinBaoLoginResponseBean.BodyBean var2 = var1.getBody();
                JinLinBaoLoginResponseBean.BodyBean.SessionBean var5 = var2.getSession();
                var5.getSid();
                JinLinBaoLoginResponseBean.BodyBean var3 = var1.getBody();
                Object var4 = var3.getLogis_list().get(0);
                OkhttpManager.jinLinBaoLogin2(String.valueOf(((JinLinBaoLoginResponseBean.BodyBean.LogisListBean) var4).getId()), this);
            }

            public void onSuccess(Object var1) {
                this.onSuccess((JinLinBaoLoginResponseBean) var1);
            }
        }));
    }

    public final void juShuiTanLogin(String var1) {
        OkhttpManager.juShuiTan(var1, this);
    }

    private final void sudiyiLogin() {
        EditText var6 = (EditText) findViewById(R.id.et_app_id);
        String var7 = var6.getText().toString();
        EditText var8 = (EditText) findViewById(R.id.et_secretKey);
        String var9 = var8.getText().toString();
        EditText var10 = (EditText) findViewById(R.id.et_source);
        String var11 = var10.getText().toString();
        EditText var12 = (EditText) findViewById(R.id.et_target);
        String var13 = var12.getText().toString();
        EditText var14 = (EditText) findViewById(R.id.et_device_id);
        String var15 = var14.getText().toString();
        if (StringUtil.isNotEmpty(var7) && StringUtil.isNotEmpty(var9) && StringUtil.isNotEmpty(var11) && StringUtil.isNotEmpty(var15) && StringUtil.isNotEmpty(var13)) {
            RqFilePreference.getInstance().setSdyAppId(var7);
            RqFilePreference.getInstance().setSdySecretKey(var9);
            RqFilePreference.getInstance().setSdySource(var11);
            RqFilePreference.getInstance().setSdyTarget(var13);
            RqFilePreference.getInstance().setSdyDeviceId(var15);
            onSuccess(true);
        } else {
            ToastSoundUtil.wrongSoundToast("请输入完整");
        }
    }

    public final void xiNiaoGaoPaiLogin() {
        EditText et_station = (EditText) findViewById(R.id.et_station);
        String var1 = et_station.getText().toString();
        EditText var8 = (EditText) findViewById(R.id.et_code);
        String var2 = var8.getText().toString();
        EditText var10 = (EditText) findViewById(R.id.et_key);
        String var3 = var10.getText().toString();
        GaoPaiYiRequest var4 = new GaoPaiYiRequest();
        var4.setWaybillNo("4310942876056");
        var4.setUnionCode(var1);
        var4.setDeviceCode(var2);
        var4.setTimestamp(String.valueOf(System.currentTimeMillis()));
        StringBuilder var5 = new StringBuilder();
        var5.append(var4.getWaybillNo());
        var5.append(var4.getUnionCode());
        var5.append(var4.getDeviceCode());
        var5.append(var4.getTimestamp());
        var5.append(var3);
        var1 = var5.toString();
        Charset var7 = Charsets.UTF_8;
        if (var1 != null) {
            byte[] var6 = var1.getBytes(var7);
            var4.setSignature(Base64Util.getBaseString(var6));
            OkhttpManager.xiNiaoGaoPaiLogin(var4, var3, this);
        }
    }

    public final void xiaobingLogin(String var1, String var2) {
        OkhttpManager.xiaobinLogin(var1, var2, this);
    }

    public final void xingHuoLogin(final String var1, final String var2) {
        OkhttpManager.xingHuoPublicKye(this, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            public final void onSuccess(PublicKeyBean var1x) {
                String var3 = var1x.getCookie();
                PublicKeyBean.ResultBean var6 = var1x.getResult();
                String var7 = var6.getPublicKey();
                String var4 = var2;
                Charset var5 = Charsets.UTF_8;
                if (var4 != null) {
                    byte[] var8 = var4.getBytes(var5);
                    RqFilePreference.getInstance().setXINGHUOAccount(var1);
                    RqFilePreference.getInstance().setXINGHUOPwd(var2);
                    RqFilePreference.getInstance().setXIAOBINGSTATIONAccount(var1);
                    RqFilePreference.getInstance().setXIAOBINGSTATIONPwd(var2);
                    OkhttpManager.xingHuoLogin(LoginActivity.this, var3, new XingHuoLoginBean(RsaUtil.encryptDataByPublicKey(var7, var8), var1, "false", "pwd"), this);
                } else {
                    Log.e(TAG, "null cannot be cast to non-null type java.lang.String");
                }
            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1x) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    this.onSuccess((PublicKeyBean) var1x);
                }
            }
        }));
    }

    public final void netManagerLogin(String var1, String var2) {
        OkhttpManager.netManagerLogin(var1, var2, this);
    }

    public final void miaoZhanLogin() {
        EditText var5 = (EditText) findViewById(R.id.et_stationId);
        String var6 = var5.getText().toString();
        EditText var2 = (EditText) findViewById(R.id.et_deviceNo);
        String var8 = var2.getText().toString();
        EditText var3 = (EditText) findViewById(R.id.et_checkCode);
        String var10x = var3.getText().toString();
        EditText var4 = (EditText) findViewById(R.id.et_brand);
        String var11 = var4.getText().toString();
        if (var6.length() > 0 && var8.length() > 0 && var10x.length() > 0 && var11.length() > 0) {
            MiaoZhanLoginBean miaoZhanLoginBean = new MiaoZhanLoginBean(var6, var8, var10x, var11, "");
            RqFilePreference.getInstance().setMiaoZhanLoginInfor(miaoZhanLoginBean);
            OkhttpManager.miaoZhanLoginApi(miaoZhanLoginBean, this);
        }
    }

    public final void zhongyouLogin() {
        EditText var8 = (EditText) findViewById(R.id.et_opeUserId);
        String var9 = var8.getText().toString();
        EditText var10x = (EditText) findViewById(R.id.et_opeUserName);
        String var12 = var10x.getText().toString();
        EditText var13 = (EditText) findViewById(R.id.et_opeSiteId);
        String var14 = var13.getText().toString();
        EditText var15 = (EditText) findViewById(R.id.et_opeSiteName);
        String var16 = var15.getText().toString();
        EditText var17 = (EditText) findViewById(R.id.et_jdsignature);
        String var18 = var17.getText().toString();
        EditText var19 = (EditText) findViewById(R.id.et_machineCode);
        String var20 = var19.getText().toString();
        if (StringUtil.isNotEmpty(var9) && StringUtil.isNotEmpty(var12) && StringUtil.isNotEmpty(var14) && StringUtil.isNotEmpty(var20) && StringUtil.isNotEmpty(var18) && StringUtil.isNotEmpty(var16)) {
            RqFilePreference var7 = RqFilePreference.getInstance();
            var7.setZyOpeUserId(var9);
            var7.setZyOpeUserName(var12);
            var7.setZyOpeSiteId(var14);
            var7.setZyOpeSitenName(var16);
            var7.setZyJdSiteCode(var18);
            var7.setZyMachineCode(var20);
            onSuccess(true);
        } else {
            ToastSoundUtil.wrongSoundToast("请输入完整");
        }
    }

    @Override
    public void onSuccess(Object o) {
        //
        Log.e("wxw_成功登录", "---");
        if (isSingle || multiList.size() == num + 1) {
            if (isSingle) {
                //ToastSoundUtil.displayToast("登录成功!");
                DialogUIUtils.showToastCenter("登录成功!");
            } else {
                //ToastSoundUtil.displayToast("混扫登录成功!");
                DialogUIUtils.showToastCenter("混扫登录成功!");
            }
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            MyApplication.setNum(0);
            OkhttpManager.setOnhttpErrorCallback((OkhttpManager.OnHttpErrorCallback) null);
            OkhttpManager.setOnhttpErrorCallback((OkhttpManager.OnHttpErrorCallback) null);
            OkhttpManager.setOnOkhttpCallback((OkhttpManager.OnOkhttpCallback) null);
        } else {
            // ToastSoundUtil.displayToast(MyApplication.getExpressStationEnum(multiList.get(num)).getName() + "-登录成功!");
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this, LoginActivity.class);
            num = num + 1;
            MyApplication.setNum(num);
            startActivity(intent);
            //finish();
        }


        lastonclickTime = 0;//防止登录按钮无效
//
    }


    @Override
    public void onError(String p0) {
        Log.e(TAG, "login error msg:" + p0);
        // ToastSoundUtil.wrongSoundToast(p0);
        DialogUIUtils.showToastCenter(p0);
    }

    @Override
    public void onError(int p0, String p1) {
        Log.e("wxw_登录失败", "login error msg:p0=" + p0 + " p1=" + p1);
        //ToastSoundUtil.wrongSoundToast(p1);
        DialogUIUtils.showToastCenter(p1);
        if (!isSingle) {
            settingsButton.setVisibility(View.VISIBLE);
        }
        lastonclickTime = 0;//防止登录按钮无效
    }


    @Override
    public void onLoginSuccess(ExpressStationEnum var1, String var2) {
        //       Log.e("wxw_login", "onLoginSuccess" + var2);
//        if (MyApplication.getStationEnum() == ExpressStationEnum.LAIQU
//                || MyApplication.getStationEnum() == ExpressStationEnum.KUAIDICAOSHI
//                || MyApplication.getStationEnum() == ExpressStationEnum.COURIERSMALLPOLE
//                || MyApplication.getStationEnum() == ExpressStationEnum.STAGESMALLPOLE
//                || MyApplication.getStationEnum() == ExpressStationEnum.PANDAHARVEST) {
//            ToastSoundUtil.displayToast("login success!");
//            Intent intent = new Intent();
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            intent.setClass(LoginActivity.this, MainActivity.class);
//            startActivity(intent);
//        }
//        Log.e(LoginActivity.TAG, "onLoginSuccess station=" + var1.getName() + " var2:" + var2);
        lastonclickTime = 0;//防止登录按钮无效
    }

    @Override
    public void onOkhttpError(int var1, String var2) {
        Log.e(LoginActivity.TAG, "onOkhttpError station=" + var1 + " var2:" + var2);
        ToastSoundUtil.wrongSoundToast("onOkhttpError:" + var1 + " msg:" + var2);
    }

    @Override
    public void onOkhttpMuchPackageShow(List var1) {
        StringBuffer stringBuffer = new StringBuffer();
        if (MyApplication.getStationEnum() == ExpressStationEnum.DUODUOYIZHAN) {
            if (var1.size() > 0) {
                // tips.setText("包裹:\n\r");
                for (Object v : var1) {
                    if (v instanceof ShowMuchPackageNoPickBean) {
                        ShowMuchPackageNoPickBean bean = (ShowMuchPackageNoPickBean) v;
                        stringBuffer.append(bean.getBarcode() + "\t");
                        stringBuffer.append(bean.getPhone() + "\t");
                        stringBuffer.append(bean.getPickUpCode() + "\t");
                        stringBuffer.append(bean.getReceviePerson() + "\t");
                        stringBuffer.append(bean.getInStorageTime() + "\n\r");
                    }
                }
                //  tips.setText(stringBuffer.toString());
            } else {
                //  tips.setText("无包裹:\n\r");
            }
        }
        Log.e(LoginActivity.TAG, "onOkhttpError station=" + var1 + " var2:" + stringBuffer.toString());
    }

    @Override
    public void onOkhttpOutLibrarySuccess(ExpressStationEnum var1, String var2) {
        ToastSoundUtil.scanSuccessToast(var2);
        Log.e(LoginActivity.TAG, "onOkhttpError station=" + var1.getName() + " message:" + var2);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
//        Intent mIntent = new Intent(Intent.ACTION_MAIN);
//        mIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        mIntent.addCategory(Intent.CATEGORY_HOME);
//        startActivity(mIntent);
    }
}