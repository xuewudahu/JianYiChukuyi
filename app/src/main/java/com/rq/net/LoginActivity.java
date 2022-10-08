package com.rq.net;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Charsets;
import com.rq.net.bean.BlueShopLoginBean;
import com.rq.net.bean.GaoPaiYiRequest;
import com.rq.net.bean.JiTuLoginBean;
import com.rq.net.bean.JinLinBaoLoginResponseBean;
import com.rq.net.bean.KDCSLoginResponseBean;
import com.rq.net.bean.KuaiBaoLoginBean;
import com.rq.net.bean.LaiquLoginResponseBean;
import com.rq.net.bean.LaiquSiteLoginResponseBean;
import com.rq.net.bean.MaMaLoginBean;
import com.rq.net.bean.MiaoZhanLoginBean;
import com.rq.net.bean.PandaBeanKt;
import com.rq.net.bean.PandaLoginBean;
import com.rq.net.bean.PinDuoDuoBaseResponseBean;
import com.rq.net.bean.PublicKeyBean;
import com.rq.net.bean.Ref;
import com.rq.net.bean.ShowMuchPackageNoPickBean;
import com.rq.net.bean.XingHuoLoginBean;
import com.rq.net.manager.MixScanMamager;
import com.rq.net.manager.OkHttpPinDuoDuoManager;
import com.rq.net.manager.OkhttpManager;
import com.rq.net.manager.OkhttpMoxiManager;
import com.rq.net.setting.CommonFilePreference;
import com.rq.net.setting.RqFilePreference;
import com.rq.net.util.Base64Util;
import com.rq.net.util.ExpressStationEnum;
import com.rq.net.util.Intrinsics;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.MD5Util;
import com.rq.net.util.Md5InputStream;
import com.rq.net.util.RsaUtil;
import com.rq.net.util.StringUtil;
import com.rq.net.util.SystemUtil;
import com.rq.net.util.ToastSoundUtil;
import com.kuaidihelp.posthouse.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements OkhttpManager.OnOkhttpCallback,
        OkhttpManager.OnOkhttpCallbackError,OkhttpManager.OnHttpErrorCallback, MixScanMamager.OkhttpCallbackStationManager {
    public static final String TAG = "MainActivity";
    EditText branch = null;
    EditText username = null;
    EditText password = null;
    EditText verityCodeText = null;
    ImageView verityCode = null;
    Button loginButton = null;
    RadioGroup stationSelect = null;
    TextView tips = null;


    private String duoduoVerify = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        branch = (EditText)findViewById(R.id.branch);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        verityCodeText = (EditText) findViewById(R.id.verify_code_text);
        verityCode = (ImageView)findViewById(R.id.verify_code);
        loginButton = (Button)findViewById(R.id.loginButton);
        stationSelect = (RadioGroup)findViewById(R.id.station_select);
        tips = (TextView)findViewById(R.id.tips);
        stationSelect.check(R.id.duoduo);
        verityCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MyApplication.getStationEnum() == ExpressStationEnum.DUODUOYIZHAN) {
                    getDuoDuoVerify(duoduoVerify);
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if (MyApplication.getStationEnum() == ExpressStationEnum.DUODUOYIZHAN) {
                    duoduoLoginVerify(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.KUAIBAO) {
                    kuaibaoLogin(username.getText().toString(), password.getText().toString());
                }else if(MyApplication.getStationEnum() == ExpressStationEnum.YUNDAKDCS) {
                    yundaKDCSLogin(username.getText().toString(), password.getText().toString());
                }else if(MyApplication.getStationEnum() == ExpressStationEnum.STATIONHELPER) {
                    stationHelperLogin(username.getText().toString(), password.getText().toString());
                }else if(MyApplication.getStationEnum() == ExpressStationEnum.LAIQU){
                    laiquLogin(username.getText().toString(), password.getText().toString());
                }else if(MyApplication.getStationEnum() == ExpressStationEnum.KUAIDICAOSHI){
                    tuxikdcsLogin(username.getText().toString(), password.getText().toString());
                }else if(MyApplication.getStationEnum() == ExpressStationEnum.YSHOUFA) {
                    yishoufaLogin(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.JITU) {
                    jiTuLogin(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.COURIERSMALLPOLE){
                    ziCourierSmallPoleLogin(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.STAGESMALLPOLE) {
                    stageSmallPoleLogin(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.PANDAHARVEST) {
                    pandaHarvestLogin(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.MOXIGUANJIA) {
                    moxiLogin(branch.getText().toString(),username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.ZYZT) {
                    zyztLogin(RqFilePreference.getInstance().getZyztSiteCode());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.ZHONGYOUSTATION) {
                    zhongYouStationLogin(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.MAMASTATION) {
                    mamaStaionLogin(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.BLUESHOP) {
                    blueShopLogin(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.FENGCHAOSERVICE) {
                    fcboxLogin(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.FENSHISHENGHUO) {
                    fsshLogin(username.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.GUOGUOYIZHAN) {
                    guoGuoYiZhanLogin(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOGAOPAIYI
                        || MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOQIANSHOU
                        || MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOKUAIDIQUJIAN
                        || MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOOCRJIEBO) {
                    jinlinbaoLogin(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.SUDIYIGONGPEI) {
                    sudiyiLogin();
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.JUSHUITAN) {
                    juShuiTanLogin(username.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.XINGHUO) {
                    xingHuoLogin(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.XINIAOGAOPAIYI) {
                    xiNiaoGaoPaiLogin();
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.XIAOBINGSTATION) {
                    xiaobingLogin(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.NETMANAGER) {
                    netManagerLogin(username.getText().toString(), password.getText().toString());
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.MIAOZHAN) {
                    miaoZhanLogin();
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.ZHONGYOUCHENGZHONG) {
                    zhongyouLogin();
                }
            }
        });


        stationSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i(TAG,"onCheckedChanged checkedId="+checkedId);
                findViewById(R.id.branch_continer).setVisibility(View.GONE);
                findViewById(R.id.sudiyi_container).setVisibility(View.GONE);
                findViewById(R.id.verify_continer).setVisibility(View.GONE);
                findViewById(R.id.xiniao_container).setVisibility(View.GONE);
                findViewById(R.id.miaozhan_container).setVisibility(View.GONE);
                findViewById(R.id.zhongyou_container).setVisibility(View.GONE);
                findViewById(R.id.username_continer).setVisibility(View.VISIBLE);
                findViewById(R.id.password_continer).setVisibility(View.VISIBLE);
                if (checkedId == R.id.duoduo){
                    MyApplication.setStationEnum(ExpressStationEnum.DUODUOYIZHAN);
                } else if (checkedId == R.id.kuaibao){
                    MyApplication.setStationEnum(ExpressStationEnum.KUAIBAO);
                } else if (checkedId == R.id.yundachaoshi){
                    MyApplication.setStationEnum(ExpressStationEnum.YUNDAKDCS);
                } else if (checkedId == R.id.yizhanzhushou){
                    MyApplication.setStationEnum(ExpressStationEnum.STATIONHELPER);
                } else if (checkedId == R.id.laiqu){
                    MyApplication.setStationEnum(ExpressStationEnum.LAIQU);
                } else if(checkedId == R.id.kdcs){
                    MyApplication.setStationEnum(ExpressStationEnum.KUAIDICAOSHI);
                } else if (checkedId == R.id.yishoufa) {
                    MyApplication.setStationEnum(ExpressStationEnum.YSHOUFA);
                } else if(checkedId == R.id.jitu){
                    MyApplication.setStationEnum(ExpressStationEnum.JITU);
                } else if (checkedId == R.id.kuaidiyuanxiaobianda){
                    MyApplication.setStationEnum(ExpressStationEnum.COURIERSMALLPOLE);
                }  else if (checkedId == R.id.yizhanxiaobianda){
                    MyApplication.setStationEnum(ExpressStationEnum.STAGESMALLPOLE);
                } else if (checkedId == R.id.panda) {
                    MyApplication.setStationEnum(ExpressStationEnum.PANDAHARVEST);
                } else if (checkedId == R.id.moxi) {
                    MyApplication.setStationEnum(ExpressStationEnum.MOXIGUANJIA);
                    findViewById(R.id.branch_continer).setVisibility(View.VISIBLE);
                } else if (checkedId == R.id.ZYYZ) {
                    MyApplication.setStationEnum(ExpressStationEnum.ZHONGYOUSTATION);
                } else if (checkedId == R.id.ZYZT) {
                    MyApplication.setStationEnum(ExpressStationEnum.ZYZT);
                } else if (checkedId == R.id.mamayizhan) {
                    MyApplication.setStationEnum(ExpressStationEnum.MAMASTATION);
                } else if (checkedId == R.id.landian) {
                    MyApplication.setStationEnum(ExpressStationEnum.BLUESHOP);
                } else if (checkedId == R.id.fengchaofuwuzhan) {
                    MyApplication.setStationEnum(ExpressStationEnum.FENGCHAOSERVICE);
                } else if (checkedId == R.id.fensishenghuo) {
                    MyApplication.setStationEnum(ExpressStationEnum.FENSHISHENGHUO);
                } else if (checkedId == R.id.guoguoyizhan) {
                    MyApplication.setStationEnum(ExpressStationEnum.GUOGUOYIZHAN);
                } else if (checkedId == R.id.jinlinbaogaopaiyi){
                    MyApplication.setStationEnum(ExpressStationEnum.JINLINBAOGAOPAIYI);
                } else if (checkedId == R.id.jinlinbaokuaidiqujian) {
                    MyApplication.setStationEnum(ExpressStationEnum.JINLINBAOKUAIDIQUJIAN);
                } else if (checkedId == R.id.jinlinbaoocr) {
                    MyApplication.setStationEnum(ExpressStationEnum.JINLINBAOOCRJIEBO);
                } else if (checkedId == R.id.jinlinbaoqujianqianshou) {
                    MyApplication.setStationEnum(ExpressStationEnum.JINLINBAOQIANSHOU);
                } else if (checkedId == R.id.sudiyigongpei) {
                    MyApplication.setStationEnum(ExpressStationEnum.SUDIYIGONGPEI);
                    ((EditText)findViewById(R.id.et_source)).setText((CharSequence)RqFilePreference.getInstance().getSdySource());
                    ((EditText)findViewById(R.id.et_target)).setText((CharSequence)RqFilePreference.getInstance().getSdyTarget());
                    ((EditText)findViewById(R.id.et_app_id)).setText((CharSequence)RqFilePreference.getInstance().getSdyAppId());
                    ((EditText)findViewById(R.id.et_secretKey)).setText((CharSequence)RqFilePreference.getInstance().getSdySecretKey());
                    ((EditText)findViewById(R.id.et_device_id)).setText((CharSequence)RqFilePreference.getInstance().getSdyDeviceId());
                    findViewById(R.id.username_continer).setVisibility(View.GONE);
                    findViewById(R.id.password_continer).setVisibility(View.GONE);
                    findViewById(R.id.sudiyi_container).setVisibility(View.VISIBLE);
                } else if (checkedId == R.id.jushuitan) {
                    MyApplication.setStationEnum(ExpressStationEnum.JUSHUITAN);
                    username.setText("18a61c18caa13c43dbdcf6034bedde45");
                } else if (checkedId == R.id.xiniao) {
                    findViewById(R.id.username_continer).setVisibility(View.GONE);
                    findViewById(R.id.password_continer).setVisibility(View.GONE);
                    findViewById(R.id.xiniao_container).setVisibility(View.VISIBLE);
                    MyApplication.setStationEnum(ExpressStationEnum.XINIAOGAOPAIYI);
                } else if (checkedId == R.id.xinghuo) {
                    MyApplication.setStationEnum(ExpressStationEnum.XINGHUO);
                } else if (checkedId == R.id.xiaobingyizhan) {
                    MyApplication.setStationEnum(ExpressStationEnum.XIAOBINGSTATION);
                } else if (checkedId == R.id.jikeyun) {
                    MyApplication.setStationEnum(ExpressStationEnum.NETMANAGER);
                } else if (checkedId == R.id.miaozhan) {
                    MyApplication.setStationEnum(ExpressStationEnum.MIAOZHAN);
                    findViewById(R.id.username_continer).setVisibility(View.GONE);
                    findViewById(R.id.password_continer).setVisibility(View.GONE);
                    findViewById(R.id.miaozhan_container).setVisibility(View.VISIBLE);
                } else if (checkedId == R.id.misengWms) {
                    MyApplication.setStationEnum(ExpressStationEnum.MSWMS);
                    onSuccess(true);
                } else if (checkedId == R.id.zhongyou) {
                    MyApplication.setStationEnum(ExpressStationEnum.ZHONGYOUCHENGZHONG);
                    findViewById(R.id.username_continer).setVisibility(View.GONE);
                    findViewById(R.id.password_continer).setVisibility(View.GONE);
                    findViewById(R.id.zhongyou_container).setVisibility(View.VISIBLE);
                }
            }
        });
        OkhttpManager.setOnhttpErrorCallback((OkhttpManager.OnHttpErrorCallback) LoginActivity.this);
        OkhttpManager.setOnhttpErrorCallback((OkhttpManager.OnOkhttpCallbackError) LoginActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.verify_continer).setVisibility(View.GONE);
    }

    public final void duoduoLoginVerify(final String var1, final String var2) {
        if (findViewById(R.id.verify_continer).getVisibility() == View.VISIBLE) {
            OkHttpPinDuoDuoManager.userVerify(LoginActivity.this, duoduoVerify, String.valueOf(verityCodeText.getText()), (OkhttpManager.OnHttpCallback) (new OkhttpManager.OnHttpCallback() {
                public void onError(int var1x, String var2x) {
                    Log.d(TAG, "userVerify onError: ================================================");
                    ToastSoundUtil.displayToast("userVerify error");
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
                    Log.e(TAG,"getPasswordPublicKey  success, but var is null");
                    return;
                } else {
                    Log.e(TAG,"getPasswordPublicKey  var1x:"+var1x.toString());
                }

                if (var1x.getSuccess()) {
                    Log.d(TAG, "onSuccess: =====================================");
                    OkHttpPinDuoDuoManager.loginByMobile(LoginActivity.this, var3, var1, var2, (String)var1x.getResult(), LoginActivity.this, new OkhttpManager.OnHttpErrorCallback() {
                        public final void onError(int var1x, String var2x) {
                            Log.e(TAG,"loginByMobile error,code="+var1x+" new verify code:"+var2x);
                            if (var1x == 54001) {
                                duoduoVerify = var2x;
                                getDuoDuoVerify(var2x);
                                Log.e(TAG,"loginByMobile error,new verify code:"+var2x);
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
                this.onSuccess((PinDuoDuoBaseResponseBean)var1x);
            }
        });
    }

    public final void getDuoDuoVerify(String var1) {
        findViewById(R.id.verify_continer).setVisibility(View.VISIBLE);
        OkHttpPinDuoDuoManager.getPicVerification(LoginActivity.this, true, var1, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public void onSuccess(Object var1) {
                this.onSuccess((String)var1);
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
        OkhttpManager.getLaiquRsaPublicKey(var1, var2, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(LaiquLoginResponseBean var1) {
                Exception var10000;
                label99: {
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
                        label101: {
                            int var2;
                            try {
                                var21.element = (ArrayList)var17;
                                //var16 = MixScanMamager.this.getTAG();
                                var5 = new StringBuilder();
                                var5.append("laiqu net station count:");
                                var5.append(((ArrayList)var21.element).size());
                                Log.e(TAG, var5.toString());
                                var2 = ((ArrayList)var21.element).size();
                            } catch (Exception var13) {
                                var10000 = var13;
                                var10001 = false;
                                break label101;
                            }

                            RqFilePreference var18;
                            if (var2 <= 1) {
                                try {
                                    var17 = ((ArrayList)var21.element).get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var17, "resultList[0]");
                                    OkhttpManager.laiquSiteLogin(((LaiquLoginResponseBean.ServiceSitesBean)var17).getServiceSiteCode(), (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                                        public final void onSuccess(LaiquSiteLoginResponseBean var1) {
                                            MixScanMamager.OkhttpCallbackStationManager var2 = LoginActivity.this;
                                            if (var2 != null) {
                                                var2.onLoginSuccess(ExpressStationEnum.LAIQU, "来取登录成功");
                                            }

                                        }

                                        // $FF: synthetic method
                                        // $FF: bridge method
                                        public void onSuccess(Object var1) {
                                            this.onSuccess((LaiquSiteLoginResponseBean)var1);
                                        }
                                    }));
                                    var18 = RqFilePreference.getInstance();
                                    ////Intrinsics.checkExpressionValueIsNotNull(var18, "RqFilePreference.getInstance()");
                                    Object var23 = ((ArrayList)var21.element).get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var23, "resultList[0]");
                                    var18.setLoginLaiQuServiceStaionCode(((LaiquLoginResponseBean.ServiceSitesBean)var23).getServiceSiteCode());
                                    return;
                                } catch (Exception var7) {
                                    var10000 = var7;
                                    var10001 = false;
                                }
                            } else {
                                label103: {
                                    try {
                                        var18 = RqFilePreference.getInstance();
                                        ////Intrinsics.checkExpressionValueIsNotNull(var18, "RqFilePreference.getInstance()");
                                        if (StringUtil.isNotEmpty(var18.getLoginLaiQuServiceStaionCode())) {
                                            var18 = RqFilePreference.getInstance();
                                            ////Intrinsics.checkExpressionValueIsNotNull(var18, "RqFilePreference.getInstance()");
                                            OkhttpManager.laiquSiteLogin(var18.getLoginLaiQuServiceStaionCode(), (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                                                public final void onSuccess(LaiquSiteLoginResponseBean var1) {
                                                    MixScanMamager.OkhttpCallbackStationManager var2 = LoginActivity.this;
                                                    if (var2 != null) {
                                                        var2.onLoginSuccess(ExpressStationEnum.LAIQU, "来取登录成功");
                                                    }

                                                }

                                                // $FF: synthetic method
                                                // $FF: bridge method
                                                public void onSuccess(Object var1) {
                                                    this.onSuccess((LaiquSiteLoginResponseBean)var1);
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
                                        var24 = new String[((ArrayList)var21.element).size()];
                                        var3 = ((ArrayList)var21.element).size();
                                    } catch (Exception var12) {
                                        var10000 = var12;
                                        var10001 = false;
                                        break label103;
                                    }

                                    for(var2 = 0; var2 < var3; ++var2) {
                                        try {
                                            var17 = ((ArrayList)var21.element).get(var2);
                                            ////Intrinsics.checkExpressionValueIsNotNull(var17, "resultList[i]");
                                            var24[var2] = ((LaiquLoginResponseBean.ServiceSitesBean)var17).getServiceSiteName();
                                        } catch (Exception var11) {
                                            var10000 = var11;
                                            var10001 = false;
                                            break label103;
                                        }
                                    }



                                    try {
                                        (new AlertDialog.Builder(LoginActivity.this)).setTitle((CharSequence)"请选择门店").setIcon(R.mipmap.setting_laiqu_uploadpic_icon).setSingleChoiceItems((CharSequence[])var24, 0, (DialogInterface.OnClickListener)(new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface var1, int var2) {
                                                laiquIndex = var2;
                                            }
                                        })).setCancelable(false).setPositiveButton((CharSequence)"确定", (DialogInterface.OnClickListener)(new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface var1, int var2) {
                                                StringBuilder var4 = new StringBuilder();
                                                var4.append("");
                                                var4.append(laiquIndex);
                                                var4.append("    ");
                                                Object var5 = ((ArrayList)var21.element).get(laiquIndex);
                                                ////Intrinsics.checkExpressionValueIsNotNull(var5, "resultList[laiquIndex]");
                                                var4.append(((LaiquLoginResponseBean.ServiceSitesBean)var5).getServiceSiteName());
                                                var4.append("=======");
                                                var5 = ((ArrayList)var21.element).get(laiquIndex);
                                                ////Intrinsics.checkExpressionValueIsNotNull(var5, "resultList[laiquIndex]");
                                                var4.append(((LaiquLoginResponseBean.ServiceSitesBean)var5).getServiceSiteCode());
                                                Log.e(TAG, var4.toString());
                                                Object var6 = ((ArrayList)var21.element).get(laiquIndex);
                                                ////Intrinsics.checkExpressionValueIsNotNull(var6, "resultList[laiquIndex]");
                                                String var3 = ((LaiquLoginResponseBean.ServiceSitesBean)var6).getServiceSiteCode();
                                                RqFilePreference var7 = RqFilePreference.getInstance();
                                                ////Intrinsics.checkExpressionValueIsNotNull(var7, "RqFilePreference.getInstance()");
                                                var7.setLoginLaiQuServiceStaionCode(var3);
                                                OkhttpManager.laiquSiteLogin(var3, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                                                    public final void onSuccess(LaiquSiteLoginResponseBean var1) {
                                                        MixScanMamager.OkhttpCallbackStationManager var2 = LoginActivity.this;
                                                        if (var2 != null) {
                                                            var2.onLoginSuccess(ExpressStationEnum.LAIQU, "来取登录成功");
                                                        }

                                                    }

                                                    // $FF: synthetic method
                                                    // $FF: bridge method
                                                    public void onSuccess(Object var1) {
                                                        this.onSuccess((LaiquSiteLoginResponseBean)var1);
                                                    }
                                                }));
                                                var1.dismiss();
                                            }
                                        })).setNegativeButton((CharSequence)"取消", (DialogInterface.OnClickListener)null).show();
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

                this.onSuccess((LaiquLoginResponseBean)var1);
            }
        }));
    }

    public final void kuaibaoLogin(String var1, String var2) {
        KuaiBaoLoginBean var3 = new KuaiBaoLoginBean();
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
        }), new OkhttpManager.OnOkhttpCallbackError() {
            @Override
            public void onError(String p0) {
                ToastSoundUtil.wrongSoundToast(p0);
            }
        });
    }

    private void yishoufaLogin(String username,String paswrord){
        OkhttpManager.yShouFaLogin(username, paswrord, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(Object var1) {
                MixScanMamager.OkhttpCallbackStationManager var2 = LoginActivity.this;
                if (var2 != null) {
                    var2.onLoginSuccess(ExpressStationEnum.YSHOUFA, "驿收发登录成功");
                }

            }
        }));
    }

    public final void jiTuLogin(String var1, String var2) {
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
            Log.e(TAG,"null cannot be cast to non-null type java.lang.String");
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
        label34: {
            ////Intrinsics.checkParameterIsNotNull(var1, "username");
            ////Intrinsics.checkParameterIsNotNull(var2, "password");
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

        CharSequence var7 = (CharSequence)var6;
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
                Map var13 = (Map)(new HashMap());
                ////Intrinsics.checkExpressionValueIsNotNull(var1, "data");
                var13.put("bizData", jsonString);
                var13.put("timestamp", String.valueOf(var4));
                var13.put("accountName", "YP75838571"/*ApiPandaHarvestActvity.Companion.getAccountName()*/);
                var13.put("apiName", "GET_TOKEN");
                var13.put("token", "openbmx");
                ////Intrinsics.checkExpressionValueIsNotNull(var2, "md5Str");
                var13.put("sign", var2);
                OkhttpManager.pandaHarvestLogin(var13, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
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
        OkhttpMoxiManager.login(branch,account,password, new OkhttpMoxiManager.OkhttpCallback(){
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
        var3.setData(JsonUtil.getJsonStringByGson(new KuaiBaoLoginBean.LoginData(var1, var2)));
        OkhttpManager.zhongYouStationLoginApi(var3, var3.getSession_id(), LoginActivity.this);
    }

    public final void mamaStaionLogin(String var1, String var2) {
        MaMaLoginBean var3 = new MaMaLoginBean();
        var3.setModelNo(SystemUtil.getSystemModel());
        if (StringUtil.isEmpty(CommonFilePreference.getInstance().getUUID())) {
            CommonFilePreference.getInstance().setUUID(SystemUtil.getAppUUID((Context)MyApplication.baseApp));
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
        OkhttpManager.fengchaoServiceLoginApi(var1, var2,this);
    }

    public final void fsshLogin(String var1) {
        RqFilePreference var2 = RqFilePreference.getInstance();
        var2.setFsshAppSID(var1);
        onSuccess(true);
    }
    public final void guoGuoYiZhanLogin(String var1, String var2) {
        OkhttpManager.guoGuoYiZhanLogin(var1, var2, this);
    }

    public final void jinlinbaoLogin(String var1, String var2) {
        OkhttpManager.jinLinBaoLogin(var1, var2, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(JinLinBaoLoginResponseBean var1) {
                JinLinBaoLoginResponseBean.BodyBean var2 = var1.getBody();
                JinLinBaoLoginResponseBean.BodyBean.SessionBean var5 = var2.getSession();
                var5.getSid();
                JinLinBaoLoginResponseBean.BodyBean var3 = var1.getBody();
                Object var4 = var3.getLogis_list().get(0);
                OkhttpManager.jinLinBaoLogin2(String.valueOf(((JinLinBaoLoginResponseBean.BodyBean.LogisListBean)var4).getId()), this);
            }
            public void onSuccess(Object var1) {
                this.onSuccess((JinLinBaoLoginResponseBean)var1);
            }
        }));
    }

    public final void juShuiTanLogin(String var1) {
        OkhttpManager.juShuiTan(var1, this);
    }

    private final void sudiyiLogin(){
        EditText var6 = (EditText)findViewById(R.id.et_app_id);
        String var7 = var6.getText().toString();
        EditText var8 = (EditText)findViewById(R.id.et_secretKey);
        String var9 = var8.getText().toString();
        EditText var10 = (EditText)findViewById(R.id.et_source);
        String var11 = var10.getText().toString();
        EditText var12 = (EditText)findViewById(R.id.et_target);
        String var13 = var12.getText().toString();
        EditText var14 = (EditText)findViewById(R.id.et_device_id);
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
        EditText et_station = (EditText)findViewById(R.id.et_station);
        String var1 = et_station.getText().toString();
        EditText var8 = (EditText)findViewById(R.id.et_code);
        String var2 = var8.getText().toString();
        EditText var10 = (EditText)findViewById(R.id.et_key);
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
        OkhttpManager.xingHuoPublicKye(this, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            public final void onSuccess(PublicKeyBean var1x) {
                String var3 = var1x.getCookie();
                PublicKeyBean.ResultBean var6 = var1x.getResult();
                String var7 = var6.getPublicKey();
                String var4 = var2;
                Charset var5 = Charsets.UTF_8;
                if (var4 != null) {
                    byte[] var8 = var4.getBytes(var5);
                    OkhttpManager.xingHuoLogin(LoginActivity.this, var3, new XingHuoLoginBean(RsaUtil.encryptDataByPublicKey(var7, var8), var1, "false", "pwd"), this);
                } else {
                    Log.e(TAG,"null cannot be cast to non-null type java.lang.String");
                }
            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1x) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    this.onSuccess((PublicKeyBean)var1x);
                }
            }
        }));
    }

    public final void netManagerLogin(String var1, String var2) {
        OkhttpManager.netManagerLogin(var1, var2, this);
    }

    public final void miaoZhanLogin() {
        EditText var5 = (EditText)findViewById(R.id.et_stationId);
        String var6 = var5.getText().toString();
        EditText var2 = (EditText)findViewById(R.id.et_deviceNo);
        String var8 = var2.getText().toString();
        EditText var3 = (EditText)findViewById(R.id.et_checkCode);
        String var10x = var3.getText().toString();
        EditText var4 = (EditText)findViewById(R.id.et_brand);
        String var11 = var4.getText().toString();
        if (var6.length() > 0 && var8.length() > 0 && var10x.length() > 0 && var11.length() > 0) {
            MiaoZhanLoginBean miaoZhanLoginBean = new MiaoZhanLoginBean(var6, var8, var10x, var11, "");
            RqFilePreference.getInstance().setMiaoZhanLoginInfor(miaoZhanLoginBean);
            OkhttpManager.miaoZhanLoginApi(miaoZhanLoginBean, this);
        }
    }

    public final void zhongyouLogin(){
        EditText var8 = (EditText)findViewById(R.id.et_opeUserId);
        String var9 = var8.getText().toString();
        EditText var10x = (EditText)findViewById(R.id.et_opeUserName);
        String var12 = var10x.getText().toString();
        EditText var13 = (EditText)findViewById(R.id.et_opeSiteId);
        String var14 = var13.getText().toString();
        EditText var15 = (EditText)findViewById(R.id.et_opeSiteName);
        String var16 = var15.getText().toString();
        EditText var17 = (EditText)findViewById(R.id.et_jdsignature);
        String var18 = var17.getText().toString();
        EditText var19 = (EditText)findViewById(R.id.et_machineCode);
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
            ToastSoundUtil.wrongSoundToast( "请输入完整");
        }
    }


    @Override
    public void onSuccess(final Object o) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (o instanceof Boolean) {
                    if (!((Boolean)o)){
                        ToastSoundUtil.wrongSoundToast("login fail!");
                        return;
                    }
                }
                Log.e(TAG,"login success msg:"+o.toString());
                ToastSoundUtil.displayToast("login success!");
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,OutLibraryActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public void onError(String p0) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG,"login error msg:"+p0);
                ToastSoundUtil.wrongSoundToast(p0);
            }
        });
    }

    @Override
    public void onError(int p0, String p1) {
        Log.e(TAG,"login error msg:p0="+p0+" p1="+p1);
        ToastSoundUtil.wrongSoundToast(p1);
    }


    @Override
    public void onLoginSuccess(ExpressStationEnum var1, String var2) {
        if(MyApplication.getStationEnum() == ExpressStationEnum.LAIQU
            || MyApplication.getStationEnum() == ExpressStationEnum.KUAIDICAOSHI
            || MyApplication.getStationEnum() == ExpressStationEnum.COURIERSMALLPOLE
            || MyApplication.getStationEnum() == ExpressStationEnum.STAGESMALLPOLE
            || MyApplication.getStationEnum() == ExpressStationEnum.PANDAHARVEST
                || MyApplication.getStationEnum() == ExpressStationEnum.MAMASTATION
                || MyApplication.getStationEnum() == ExpressStationEnum.FENGCHAOSERVICE
                || MyApplication.getStationEnum() == ExpressStationEnum.BLUESHOP
                || MyApplication.getStationEnum() == ExpressStationEnum.GUOGUOYIZHAN
                || MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOKUAIDIQUJIAN
                || MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOGAOPAIYI
                || MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOOCRJIEBO
                || MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOQIANSHOU){
            ToastSoundUtil.displayToast("login success!");
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this,OutLibraryActivity.class);
            startActivity(intent);
        }
        Log.e(LoginActivity.TAG,"onLoginSuccess station="+var1.getName()+" var2:"+var2);
    }

    @Override
    public void onOkhttpError(int var1, String var2) {
        Log.e(LoginActivity.TAG,"onOkhttpError station="+var1+" var2:"+var2);
        ToastSoundUtil.wrongSoundToast("onOkhttpError:"+var1+" msg:"+var2);
    }

    @Override
    public void onOkhttpMuchPackageShow(List var1) {
        StringBuffer stringBuffer = new StringBuffer();
        if(MyApplication.getStationEnum() == ExpressStationEnum.DUODUOYIZHAN) {
            if (var1.size() > 0) {
                tips.setText("包裹:\n\r");
                for (Object v : var1) {
                    if (v instanceof ShowMuchPackageNoPickBean) {
                        ShowMuchPackageNoPickBean bean = (ShowMuchPackageNoPickBean) v;
                        stringBuffer.append(bean.getBarcode()+"\t");
                        stringBuffer.append(bean.getPhone()+"\t");
                        stringBuffer.append(bean.getPickUpCode()+"\t");
                        stringBuffer.append(bean.getReceviePerson()+"\t");
                        stringBuffer.append(bean.getInStorageTime()+"\n\r");
                    }
                }
                tips.setText(stringBuffer.toString());
            } else {
                tips.setText("无包裹:\n\r");
            }
        }
        Log.e(LoginActivity.TAG,"onOkhttpError station="+var1+" var2:"+stringBuffer.toString());
    }

    @Override
    public void onOkhttpOutLibrarySuccess(ExpressStationEnum var1, String var2) {
        ToastSoundUtil.scanSuccessToast(var2);
        Log.e(LoginActivity.TAG,"onOkhttpError station="+var1.getName()+" message:"+var2);
    }
}