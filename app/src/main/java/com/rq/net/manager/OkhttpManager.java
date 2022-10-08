package com.rq.net.manager;

import static okhttp3.internal.Util.UTF_8;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSON;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.entity.UrlEncodedFormEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpPost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.HttpClients;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.rq.net.ApiCallbackFenChaoService;
import com.rq.net.RqService;
import com.rq.net.MyApplication;
import com.rq.net.bean.*;
import com.rq.net.di.ApiCallback;
import com.rq.net.di.ApiCallbackKuaibao;
import com.rq.net.di.ApiCallbackLaiqu;
import com.rq.net.di.ApiCallbackMaMa;
import com.rq.net.di.ApiCallbackMiaoZhan;
import com.rq.net.di.ApiCallbackYunDaKDCS;
import com.rq.net.di.ApiCallbackYunDaNewKDCS;
import com.rq.net.di.ApiFileCallback;
import com.rq.net.di.ApiPostStationCallback;
import com.rq.net.di.ApiVideoCallback;
import com.rq.net.di.CommonApiCallback;
import com.rq.net.di.SSLSocketClient;
import com.rq.net.request.RequestApiCourSmallPole;
import com.rq.net.request.RequestApiDeviceManager;
import com.rq.net.request.RequestApiMaMa;
import com.rq.net.request.RequestApiMaMaOutLibrary;
import com.rq.net.request.RequestApiMaMaYZ;
import com.kuaidihelp.posthouse.Response.NotOutLibraryResponse;
import com.rq.net.setting.CommonFilePreference;
import com.rq.net.setting.FactoryConfigurationFilePreference;
import com.rq.net.setting.RqFilePreference;
import com.rq.net.util.ApkUtil;
import com.rq.net.util.Base64Util;
import com.rq.net.util.DESedeUtil;
import com.rq.net.util.DateUtil;
import com.rq.net.util.EncryptUtils;
import com.rq.net.util.ExpressStationEnum;
import com.rq.net.util.FwrBase64;
import com.rq.net.util.ImageSaveUtil;
import com.rq.net.util.JinLinBaoSign;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.MD5Util;
import com.rq.net.util.Rsa2Util;
import com.rq.net.util.RsaUtil;
import com.rq.net.util.SdCard;
import com.kuaidihelp.posthouse.SignData;
import com.rq.net.util.StringUtil;
import com.rq.net.util.SystemUtil;
import com.rq.net.util.ToastSoundUtil;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;
import org.apache.http.message.BasicNameValuePair;
import java.lang.reflect.Method;
import java.util.SortedMap;
public class OkhttpManager {

    public static String BLE_ADDRESS;
    static String JWTTOKEN;
    static String KEY;
    private static final String TAG = "OkhttpManager";
    public static String YIXIAODIAN_TOKEN;
    private static String appversion;
    static final OkHttpClient.Builder client;
    static String company;
    static String deviceModel;
    static String divicesId;
    private static String grayToken;
    static Map<String, Object> header;
    public static boolean isMixOutLibrary;
    public static Boolean isTokenAvailable;
    private static boolean kdcsResetLogin;
    static final List list;
    private static OnOkhttpCallbackError mOnOkhttpCallbackError;
    public static OnOkhttpCallback mOnOkhttpCallback;
    static final OkHttpClient okHttpClient;
    public static OnHttpErrorCallback onErrorCallback;

    static String pdaDeviceNo;
    static String pdaDeviceType;
    static String pdaVersionCode;
    static String pdaVersionNo;
    private static String pname;
    static String serialNo;
    static String sn;
    static String username;
    private static String version;
    public static String yishoufaVersion;
    private static String yundaKDCS_SECRET;

    static {
        client = new OkHttpClient.Builder().retryOnConnectionFailure(true).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).sslSocketFactory(SSLSocketClient.getSSLSocketFactory()).hostnameVerifier(SSLSocketClient.getHostnameVerifier()).followRedirects(false);
        okHttpClient = OkhttpManager.client.build();
        OkhttpManager.isTokenAvailable = true;
        OkhttpManager.JWTTOKEN = "";
        OkhttpManager.sn = "";
        OkhttpManager.username = "";
        OkhttpManager.kdcsResetLogin = false;
        OkhttpManager.version = "3.9.1";
        OkhttpManager.appversion = "3910";
        OkhttpManager.pname = "yz_android";
        OkhttpManager.pdaDeviceNo = "";
        OkhttpManager.pdaVersionNo = "6.6.40";
        OkhttpManager.pdaVersionCode = "873";
        OkhttpManager.pdaDeviceType = "YZ-AND";
        OkhttpManager.deviceModel = "nova 5z";
        OkhttpManager.serialNo = "";
        OkhttpManager.yishoufaVersion = RqFilePreference.getInstance().getYshouFaVersion();
        OkhttpManager.YIXIAODIAN_TOKEN = "";
        list = new ArrayList();
        OkhttpManager.yundaKDCS_SECRET = "";
        OkhttpManager.grayToken = "";
        OkhttpManager.KEY = " A801C860DD05418F";
        OkhttpManager.company = "12F0889318321F81";
        OkhttpManager.divicesId = "6038092285577617761";
        (OkhttpManager.header = new HashMap<String, Object>()).put("type", 1);
    }

    public static void ChuKu(final String s, final String s2, final String s3, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiBlueShop().ChuKu(s, s2, s3).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JsonObject>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u84dd\u5e97\u51fa\u5e93\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final JsonObject jsonObject) {
                if (jsonObject != null) {
                    try {
                        final JSONObject jsonObject2 = new JSONObject(jsonObject.toString());
                        if (jsonObject2.has("status")) {
                            final String string = jsonObject2.getString("status");
                            if (string != null && string.equals("200")) {
                                if (onOkhttpCallback != null) {
                                    onOkhttpCallback.onSuccess(jsonObject);
                                }
                                return;
                            }
                            else {
                                if (OkhttpManager.onErrorCallback != null) {
                                    OkhttpManager.onErrorCallback.onError(-2, "\u51fa\u5e93\u5931\u8d25");
                                }
                                return;
                            }
                        }
                        else {
                            if (OkhttpManager.onErrorCallback != null) {
                                OkhttpManager.onErrorCallback.onError(-2, "\u51fa\u5e93\u5931\u8d25");
                            }
                            return;
                        }
                    }
                    catch (JSONException ex) {
                        ex.printStackTrace();
                        return;
                    }
                }
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, "\u51fa\u5e93\u5931\u8d25");
                }
            }
        }));
    }

    public static void JiTuLogin(final JiTuLoginBean jiTuLoginBean, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestJiTu().jiTuLogin(jiTuLoginBean).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JiTuResponse>() {
            @Override
            public void onFailure(final int n, final String s) {
                if (OkhttpManager.onErrorCallback != null) {
                    RqFilePreference.getInstance().setJITUPwd("");
                    OkhttpManager.onErrorCallback.onError(-2, s);
                }
            }

            public void onSuccess(final JiTuResponse jiTuLoginResponseInfor) {
                if (jiTuLoginResponseInfor != null && jiTuLoginResponseInfor.getCode() == 1) {
                    RqFilePreference.getInstance().setJiTuLoginResponseInfor(jiTuLoginResponseInfor);
                    RqFilePreference.getInstance().setJITUAccount(jiTuLoginBean.getAccount());

                    onOkhttpCallback.onSuccess(jiTuLoginResponseInfor);
                    return;
                }
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, jiTuLoginResponseInfor.getMsg());

                }
            }
        }));
    }

    public static void JiTuOutlibrary(final String s, final List<RequestJiTuOutlibrary> list, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestJiTu().outLibrary(s, System.currentTimeMillis(), list).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JiTuOutLibraryResponse>() {
            @Override
            public void onFailure(final int n, final String s) {
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, s);
                }
            }

            public void onSuccess(final JiTuOutLibraryResponse jiTuOutLibraryResponse) {
                if (jiTuOutLibraryResponse != null) {
                    if (jiTuOutLibraryResponse.getCode() == 1 || jiTuOutLibraryResponse.getCode() == 135010037) {
                        onOkhttpCallback.onSuccess(jiTuOutLibraryResponse);

                    }
                    //added by wxw
                    if (mOnOkhttpCallback != null&&(jiTuOutLibraryResponse.getCode() == 1 || jiTuOutLibraryResponse.getCode() == 135010037)) {
                        mOnOkhttpCallback.onSuccess(jiTuOutLibraryResponse);
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, jiTuOutLibraryResponse.getMsg());
                }
            }
        }));
    }

    public static void alipayPay(final List<String> list, final OnOkhttpCallback<PurchaseAuthCodeV2ResBean<AlipayPayResBean>> onOkhttpCallback) {
        if (OkhttpManager.JWTTOKEN.isEmpty()) {
            OkhttpManager.JWTTOKEN = getDeviceLoginToken();
        }
        if (OkhttpManager.sn.isEmpty()) {
            OkhttpManager.sn = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number();
        }
        if (OkhttpManager.username.isEmpty()) {
            OkhttpManager.username = RqFilePreference.getInstance().getLoginBean().getUsername();
        }
        final Long value = System.currentTimeMillis();
        final PurchaseAuthCodeV2ReqBean purchaseAuthCodeV2ReqBean = new PurchaseAuthCodeV2ReqBean(OkhttpManager.sn, list, 1, 1, String.valueOf(value), "");
        purchaseAuthCodeV2ReqBean.setSign(MD5Util.getEncryptMD5Class(purchaseAuthCodeV2ReqBean.getClass(), value, OkhttpManager.username));
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().alipayPay(purchaseAuthCodeV2ReqBean, OkhttpManager.JWTTOKEN).enqueue((Callback)new ApiPostStationCallback((ApiPostStationCallback.HttpCallback)new ApiPostStationCallback.HttpCallback<PurchaseAuthCodeV2ResBean<AlipayPayResBean>>() {
            @Override
            public void onFailure(final int n, final String s) {
                ToastSoundUtil.displayToast(s);
            }

            public void onSuccess(final PurchaseAuthCodeV2ResBean<AlipayPayResBean> purchaseAuthCodeV2ResBean) {
                onOkhttpCallback.onSuccess(purchaseAuthCodeV2ResBean);
            }
        }));
    }

    public static void blueShopLogin(final BlueShopLoginBean blueShopLoginBean, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiBlueShop().blueShopLogin(new Gson().toJson((Object)blueShopLoginBean)).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JsonObject>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u84dd\u5e97\u767b\u5f55\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final JsonObject jsonObject) {
                final RqFilePreference instance = RqFilePreference.getInstance();
                final String s = null;
                instance.setBlueShopLoginInfor((BlueShopLoginRequestBean)null);
                JSONObject jsonObject2;
                try {
                    jsonObject2 = new JSONObject(jsonObject.toString());
                    try {
                        final int int1 = jsonObject2.getInt("status");
                    }
                    catch (JSONException ex) {}
                }
                catch (JSONException ex) {
                    jsonObject2 = null;
                }
                /*final JSONException ex;
                ex.printStackTrace();*/
                final int int1 = 0;
                if (int1 == 200) {
                    RqFilePreference.getInstance().setBlueShopLoginInfor((BlueShopLoginRequestBean)new Gson().fromJson(jsonObject.toString(), (Class)BlueShopLoginRequestBean.class));
                    BlueShopCookieBean blueShopCookieBean = new BlueShopCookieBean(blueShopLoginBean.getUsername(), blueShopLoginBean.getPassword());
                    RqFilePreference.getInstance().setBlueShopLoginCache(blueShopCookieBean);
                    OkhttpManager.getCookie(blueShopCookieBean, onOkhttpCallback);
                    if(onOkhttpCallback !=null){
                        RqFilePreference.getInstance().setBLUESHOPAccount(blueShopLoginBean.getUsername());
                        RqFilePreference.getInstance().setBLUESHOPPwd(blueShopLoginBean.getPassword());
                        onOkhttpCallback.onSuccess(blueShopCookieBean);
                    }
                    return;
                }
                String string;
                try {
                    string = jsonObject2.getString("info");
                }
                catch (JSONException ex2) {
                    ex2.printStackTrace();
                    string = s;
                }
                if (OkhttpManager.onErrorCallback != null) {
                    final OnHttpErrorCallback access$000 = OkhttpManager.onErrorCallback;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(string);
                    access$000.onError(-2, sb.toString());
                }
            }
        }));
    }

    public static void chengZhongDengJi(final String s, String md5Str, final BizBean bizBean, final OnOkhttpCallbackJKY<ResponseChenZhongDdengJi> onOkhttpCallbackJKY) {
        System.out.println("\u5409\u5ba2\u4e91\u79f0\u91cd\u63a5\u53e3==============================");
        final String currentDateTime = DateUtil.getCurrentDateTime();
        final StringBuilder sb = new StringBuilder();
        sb.append("appkey");
        sb.append(s);
        sb.append("bizcontent");
        sb.append(new Gson().toJson((Object)bizBean));
        sb.append("contenttypejsonmethodwms-wos.order.weighingtimestamp");
        sb.append(currentDateTime);
        sb.append("version1.0");
        final String string = sb.toString();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(md5Str);
        sb2.append(string);
        sb2.append(md5Str);
        md5Str = MD5Util.getMD5Str(sb2.toString().toLowerCase());
        MyApplication.getDaggerReposifitComponent().getRequestChengZhongDengJi().chenZhongDengJi("wms-wos.order.weighing", s, "1.0", "json", currentDateTime, new Gson().toJson((Object)bizBean), md5Str).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<ResponseChenZhongDdengJi>() {
            @Override
            public void onFailure(final int n, final String s) {
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, s);
                }
                onOkhttpCallbackJKY.onError(-2, s);
            }

            public void onSuccess(final ResponseChenZhongDdengJi responseChenZhongDdengJi) {
                if (responseChenZhongDdengJi.getCode() == 200 && responseChenZhongDdengJi.getSubCode().isEmpty()) {
                    if (onOkhttpCallbackJKY != null) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("onSuccess: ========================");
                        sb.append(responseChenZhongDdengJi.getResult().getData().getExpressName());
                        Log.d("OkhttpManager", sb.toString());
                        onOkhttpCallbackJKY.onSuccess(responseChenZhongDdengJi);
                    }
                }
                else {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, responseChenZhongDdengJi.getMsg());
                    }
                    onOkhttpCallbackJKY.onError(-2, responseChenZhongDdengJi.getMsg());
                }
            }
        }));
    }

    public static void cleanOrder(final String s, final OnOkhttpCallback<String> onOkhttpCallback) {
        if (OkhttpManager.JWTTOKEN.isEmpty()) {
            OkhttpManager.JWTTOKEN = getDeviceLoginToken();
        }
        if (OkhttpManager.sn.isEmpty()) {
            OkhttpManager.sn = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number();
        }
        if (OkhttpManager.username.isEmpty()) {
            OkhttpManager.username = RqFilePreference.getInstance().getLoginBean().getUsername();
        }
        final Long value = System.currentTimeMillis();
        final CleanOrderReqBean cleanOrderReqBean = new CleanOrderReqBean(s, String.valueOf(value), "");
        cleanOrderReqBean.setSign(MD5Util.getEncryptMD5Class(cleanOrderReqBean.getClass(), value, OkhttpManager.username));
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().cleanOrder(cleanOrderReqBean, OkhttpManager.JWTTOKEN).enqueue((Callback)new ApiPostStationCallback((ApiPostStationCallback.HttpCallback)new ApiPostStationCallback.HttpCallback<String>() {
            @Override
            public void onFailure(final int n, final String s) {
            }

            public void onSuccess(final String s) {
                onOkhttpCallback.onSuccess(s);
            }
        }));
    }

    public static void courSmallPoleChuKu1(final String s, final String s2, final String s3, final OnOkhttpCallback onOkhttpCallback) {
        try {
            MyApplication.getDaggerReposifitComponent().getRequestApiCourSmallPole().courSmallPoleChuKu1(s, s2, "1", s3).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<CourSmallPoleChuKu1>() {
                @Override
                public void onFailure(final int n, final String s) {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, s);
                    }
                }

                public void onSuccess(final CourSmallPoleChuKu1 courSmallPoleChuKu1) {
                    if (courSmallPoleChuKu1 != null) {
                        if (courSmallPoleChuKu1.getCode() == 403) {
                            if (OkhttpManager.onErrorCallback != null) {
                                OkhttpManager.onErrorCallback.onError(courSmallPoleChuKu1.getCode(), courSmallPoleChuKu1.getMessage());
                            }
                        }
                        else {
                            final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                            if (val$okhttpCallback != null) {
                                val$okhttpCallback.onSuccess(courSmallPoleChuKu1);
                            }
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(courSmallPoleChuKu1.getCode(), courSmallPoleChuKu1.getMessage());
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void couriersmallpoleGetcompanyList(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiCourSmallPole().courSmallPoleGetCompanyList(s, s2).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<CompanyListBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u83b7\u53d6\u5feb\u9012\u516c\u53f8\u5217\u8868\u5931\u8d25\uff1a");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final CompanyListBean companyListBean) {
                if (companyListBean != null) {
                    if (companyListBean.getCode() == 200) {
                        final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                        if (val$okhttpCallback != null) {
                            val$okhttpCallback.onSuccess(companyListBean);
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, companyListBean.getMessage());
                    }
                }
            }
        }));
    }

    public static void couriersmallpoleLogin(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback/*, final CourierSmallPoleActivity.IsSuccess isSuccess*/) {
        MyApplication.getDaggerReposifitComponent().getRequestApiCourSmallPole().courSmallPoleLogin(s, s2, "android", "1").enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JsonObject>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u5feb\u9012\u5458\u767b\u5f55\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u5feb\u9012\u5458\u767b\u5f55\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final JsonObject jsonObject) {
                RqFilePreference.getInstance().setCourierSmallPoleLoginfor((CourierSmallPoleLogin)null);
                int int1;
                String string = "";
                try {
                    final JSONObject jsonObject2 = new JSONObject(jsonObject.toString());
                    int1 = jsonObject2.getInt("code");
                    string = jsonObject2.getString("message");
                }
                catch (JSONException ex) {
                    int1 = 0;
                }
                /*final JSONException ex;
                ex.printStackTrace();*/
                if (int1 == 200) {
                    RqFilePreference.getInstance().setCourierSmallPoleLoginIsZiAccount(0);
                    RqFilePreference.getInstance().setCourierSmallPoleLoginfor((CourierSmallPoleLogin)new Gson().fromJson(jsonObject.toString(), (Class)CourierSmallPoleLogin.class));
                    if (onOkhttpCallback != null) {
                        //isSuccess.result(true);
                        RqFilePreference.getInstance().setCOURIERSMALLPOLEAccount(s);
                        RqFilePreference.getInstance().setCOURIERSMALLPOLEPwd(s2);
                        onOkhttpCallback.onSuccess(jsonObject);
                        mOnOkhttpCallback.onSuccess(jsonObject);
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    //isSuccess.result(false);
                    OkhttpManager.onErrorCallback.onError(-2, string);
                }
            }
        }));
    }

    public static void couriersmallpoleOutLib(final String s, final String s2, String barcode,final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiCourSmallPole().ziCourSmallPoleOutLib(s, s2, barcode, "1.1").enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JsonObject>() {
            @Override
            public void onFailure(final int n, final String s) {
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final JsonObject jsonObject) {
                if (jsonObject == null) {
                    Log.e(TAG,"out lib success, but jsonObject is null");
                    return;
                }

                try {
                    final JSONObject jsonObject2 = new JSONObject(jsonObject.toString());
                    String string  = jsonObject2.getString("msg");
                    if (jsonObject2.getInt("code") == 0) {

                        if (onOkhttpCallback != null) {
                            //isSuccess.result(true);
                            onOkhttpCallback.onSuccess(jsonObject);

                        }
                        //added by wxw
                        if (mOnOkhttpCallback != null) {
                            mOnOkhttpCallback.onSuccess(jsonObject);
                        }
                    }
                    else {
                        //isSuccess.result(false);
                        OkhttpManager.onErrorCallback.onError(-2, string);
                        //ToastSoundUtil.wrongSoundToast(string);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }));
    }

    public static void deleteCobaDeviceCloudSpace(final OnOkhttpCallback<String> onOkhttpCallback) {
        try {
            final DeviceLoginBean loginBean = RqFilePreference.getInstance().getLoginBean();
            final DeleteDeviceCloudBean deleteDeviceCloudBean = new DeleteDeviceCloudBean();
            final long currentTimeMillis = System.currentTimeMillis();
            deleteDeviceCloudBean.setSn(FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number());
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(currentTimeMillis);
            deleteDeviceCloudBean.setTimestamp(sb.toString());
            deleteDeviceCloudBean.setSign(MD5Util.getEncryptMD5Class(deleteDeviceCloudBean.getClass(), currentTimeMillis, loginBean.getUsername()));
            MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().deleteDeviceCloudSpace(deleteDeviceCloudBean, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<String>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u5220\u9664\u4e91\u7a7a\u95f4\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                }

                public void onSuccess(final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u5220\u9664\u4e91\u7a7a\u95f4\u6210\u529f:");
                    sb.append(s);
                    //XLog.e(sb.toString());
                    final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(s);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void deleteOrder() {
        if (OkhttpManager.JWTTOKEN.isEmpty()) {
            OkhttpManager.JWTTOKEN = getDeviceLoginToken();
        }
        if (OkhttpManager.sn.isEmpty()) {
            OkhttpManager.sn = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number();
        }
        if (OkhttpManager.username.isEmpty()) {
            OkhttpManager.username = RqFilePreference.getInstance().getLoginBean().getUsername();
        }
        final Long value = System.currentTimeMillis();
        final DeleteOrderReqBean deleteOrderReqBean = new DeleteOrderReqBean(OkhttpManager.sn, String.valueOf(value), "");
        deleteOrderReqBean.setSign(MD5Util.getEncryptMD5Class(deleteOrderReqBean.getClass(), value, OkhttpManager.username));
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().deleteOrder(deleteOrderReqBean, getDeviceLoginToken());
    }

    public static void deliverGoods(final List<JuShuiTanRequest> list, final String s, final String s2, final int n, final String s3, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiApiJuShuiTan().deliverGoods(list, "orders.weight.send.upload", s2, s, n, s3).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JuShuiTanResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u53d1\u8d27\u5931\u8d25");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final JuShuiTanResponseBean juShuiTanResponseBean) {
                onOkhttpCallback.onSuccess(juShuiTanResponseBean);
            }
        }));
    }

    public static void deviceActivation(final DeviceActivationBodyBean deviceActivationBodyBean, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().deviceActivation(deviceActivationBodyBean).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<DeviceLoginBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u83b7\u53d6\u6fc0\u6d3b\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                ToastSoundUtil.displayToast(s);
            }

            public void onSuccess(final DeviceLoginBean deviceLoginBean) {
                //XLog.e("\u83b7\u53d6\u6fc0\u6d3b\u6210\u529f");
                final OnOkhttpCallback val$onOkhttpCallback = onOkhttpCallback;
                if (val$onOkhttpCallback != null) {
                    val$onOkhttpCallback.onSuccess(deviceLoginBean);
                }
            }
        }));
    }

    public static void deviceLogin(final DeviceLoginBodyBean deviceLoginBodyBean, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().deviceLogin(deviceLoginBodyBean).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<DeviceLoginBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u767b\u5165\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                ToastSoundUtil.wrongSoundToast(s);
            }

            public void onSuccess(final DeviceLoginBean deviceLoginBean) {
                //XLog.e("\u767b\u5165\u6210\u529f");
                final OnOkhttpCallback val$onOkhttpCallback = onOkhttpCallback;
                if (val$onOkhttpCallback != null) {
                    val$onOkhttpCallback.onSuccess(deviceLoginBean);
                }
            }
        }));
    }

    public static void downloadVideoFile(final AdVideoTableBean adVideoTableBean, final OnOkhttpCallback onOkhttpCallback) {
        final StringBuilder sb = new StringBuilder();
        sb.append("downloadVideoFile: =================");
        sb.append(adVideoTableBean.getOssImageUrl());
        Log.d("OkhttpManager", sb.toString());
        if (StringUtil.isEmpty(adVideoTableBean.getOssImageUrl())) {
            return;
        }
        MyApplication.getDaggerReposifitComponent().getRequestApi().downloadApkFile(adVideoTableBean.getOssImageUrl()).enqueue((Callback)new ApiVideoCallback((ApiVideoCallback.HttpVideoCallback)new ApiVideoCallback.HttpVideoCallback() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("onFailure: \u4e0b\u8f7d\u89c6\u9891===");
                sb.append(n);
                sb.append("    ");
                sb.append(s);
                Log.e("OkhttpManager", sb.toString());
            }

            @Override
            public void onSuccess(final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("video \u4e0b\u8f7d\u6210\u529f");
                sb.append(s);
                Log.e("OkhttpManager", sb.toString());
                onOkhttpCallback.onSuccess("");
            }
        }, adVideoTableBean));
    }

    public static void equipmentOutData(final FsshOutLibraryBodyBean fsshOutLibraryBodyBean, final OnOkhttpCallback<FsshOutLibraryResponseBean> onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiFenShiShenHuo().equipmentOutData(fsshOutLibraryBodyBean).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<FsshOutLibraryResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u7c89\u4e1d\u751f\u6d3b\u4e0a\u4f20\u6570\u636e\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u7c89\u4e1d\u751f\u6d3b\u4e0a\u4f20\u6570\u636e\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.displayToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final FsshOutLibraryResponseBean fsshOutLibraryResponseBean) {
                if (fsshOutLibraryResponseBean != null) {
                    if (fsshOutLibraryResponseBean.isStatus()) {
                        //XLog.e("\u7c89\u4e1d\u751f\u6d3b\u4e0a\u4f20\u6570\u636e\u6210\u529f");
                        final OnOkhttpCallback val$okhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                        if (val$okhttpCallback != null) {
                            val$okhttpCallback.onSuccess(fsshOutLibraryResponseBean);
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, fsshOutLibraryResponseBean.getStatusMessage());
                    }
                }
            }
        }));
    }


    public static void fengchaoServiceCheckBarcode(final String expressNo, final OnOkhttpCallback<List<FcboxCheckBarcodeResponseBean>> onOkhttpCallback) {
        final FcboxCheckBarcodeBean fcboxCheckBarcodeBean = new FcboxCheckBarcodeBean();
        fcboxCheckBarcodeBean.setExpressNo(expressNo);
        MyApplication.getDaggerReposifitComponent().getRequestApiFcbox().fcboxCheckBarcode(fcboxCheckBarcodeBean, ApiCallbackFenChaoService.FC_TOKEN, OkhttpManager.grayToken, ApiCallbackFenChaoService.FC_COOKIE).enqueue((Callback)new ApiCallbackFenChaoService((ApiCallbackFenChaoService.HttpCallback)new ApiCallbackFenChaoService.HttpCallback<List<FcboxCheckBarcodeResponseBean>>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e30\u5de2\u670d\u52a1\u7ad9\u5355\u53f7\u6821\u9a8c\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final List<FcboxCheckBarcodeResponseBean> list) {
                //////XLog.e("\u4e30\u5de2\u670d\u52a1\u7ad9\u5355\u53f7\u6821\u9a8c\u6210\u529f");
                final OnOkhttpCallback val$okhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(list);
                }
            }
        }));
    }

    public static void fengchaoServiceGetUserInfo(final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiFcbox().fcboxGetUserInfor(ApiCallbackFenChaoService.FC_TOKEN).enqueue((Callback)new ApiCallbackFenChaoService((ApiCallbackFenChaoService.HttpCallback)new ApiCallbackFenChaoService.HttpCallback<FcboxUserInforResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e30\u5de2\u670d\u52a1\u7ad9\u83b7\u53d6\u7528\u6237\u4fe1\u606f\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u4e30\u5de2\u670d\u52a1\u7ad9\u83b7\u53d6\u7528\u6237\u4fe1\u606f\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final FcboxUserInforResponseBean fcboxUserInforResponseBean) {
                //////XLog.e("\u4e30\u5de2\u670d\u52a1\u7ad9\u83b7\u53d6\u7528\u6237\u4fe1\u606f\u6210\u529f");
                OkhttpManager.fengchaoServiceLoginLog(fcboxUserInforResponseBean, onOkhttpCallback);
            }
        }));
    }
//added by wxw start ----------丰巢登录界面客户没有提供，按客户要求提供虚拟登录。账号密码匹配即可登录。
/*    public static void fengchaoServiceLoginApi(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiFcbox().fcboxLogin(false, s, s2).enqueue((Callback)new ApiCallbackFenChaoService((ApiCallbackFenChaoService.HttpCallback)new ApiCallbackFenChaoService.HttpCallback<Object>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e30\u5de2\u670d\u52a1\u7ad9\u767b\u5f55\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u4e30\u5de2\u670d\u52a1\u7ad9\u767b\u5f55\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            @Override
            public void onSuccess(final Object o) {
                //////XLog.e("\u4e30\u5de2\u670d\u52a1\u7ad9\u767b\u5f55\u6210\u529f");
                OkhttpManager.fengchaoServiceGetUserInfo(onOkhttpCallback);
                if (onOkhttpCallback != null) {
                    RqFilePreference.getInstance().setFENGCHAOSERVICEAccount(s);
                    RqFilePreference.getInstance().setFENGCHAOSERVICEPwd(s2);
                    onOkhttpCallback.onSuccess(null);
                }
            }
        }));
    }*/

    public static void fengchaoServiceLoginApi(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s2) && s.equals("FC001") && s2.equals("FC001")) {
            if (onOkhttpCallback != null) {
                RqFilePreference.getInstance().setFENGCHAOSERVICEAccount(s);
                RqFilePreference.getInstance().setFENGCHAOSERVICEPwd(s2);
                onOkhttpCallback.onSuccess(null);
            }
        } else {
            if (OkhttpManager.onErrorCallback != null) {
                OkhttpManager.onErrorCallback.onError(2, "登录失败");
            }
        }
    }
    //added by wxw end
    public static void fengchaoServiceLoginLog(final FcboxUserInforResponseBean fcboxUserInforResponseBean, final OnOkhttpCallback onOkhttpCallback) {
        OkhttpManager.grayToken = String.format("sId=%s,uId=%s", fcboxUserInforResponseBean.getCurrentNetWork(), fcboxUserInforResponseBean.getUserId());
        final String format = String.format("sId=%s,uId=0", fcboxUserInforResponseBean.getCurrentNetWork());
        final FcboxDeviceTokenBean fcboxDeviceTokenBean = new FcboxDeviceTokenBean();
        final FactoryRegistrationBean factoryRegistration = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration();
        if (FactoryConfigurationFilePreference.getInstance().getFactoryRegistration() != null) {
            fcboxDeviceTokenBean.setDeviceId(factoryRegistration.getIMEI());
            fcboxDeviceTokenBean.setMac(factoryRegistration.getBluetooth());
        }
        else {
            fcboxDeviceTokenBean.setDeviceId("2387098109129");
            fcboxDeviceTokenBean.setMac("c0:84:7d:1f:37:c5");
        }
        fcboxDeviceTokenBean.setIp(SystemUtil.getIPAddress((Context)MyApplication.baseApp));
        fcboxDeviceTokenBean.setVersionCode("61");
        fcboxDeviceTokenBean.setVersionName("3.1.1");
        MyApplication.getDaggerReposifitComponent().getRequestApiFcbox().fcboxLoginLog(ApiCallbackFenChaoService.FC_TOKEN, format, ApiCallbackFenChaoService.FC_COOKIE, JsonUtil.getJsonStringByGson(fcboxDeviceTokenBean)).enqueue((Callback)new ApiCallbackFenChaoService((ApiCallbackFenChaoService.HttpCallback)new ApiCallbackFenChaoService.HttpCallback<Object>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e30\u5de2\u670d\u52a1\u7ad9\u767b\u5f55\u65e5\u5fd7\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u4e30\u5de2\u670d\u52a1\u7ad9\u767b\u5f55\u65e5\u5fd7\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            @Override
            public void onSuccess(final Object o) {
                //////XLog.e("\u4e30\u5de2\u670d\u52a1\u7ad9\u767b\u5f55\u65e5\u5fd7\u6210\u529f");
                OkhttpManager.fengchaoServiceStationInfo(OkhttpManager.grayToken, onOkhttpCallback);
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(o);
                }
            }
        }));
    }

    public static void fengchaoServiceOutLibrary(final FcboxSignBean fcboxSignBean, final OnOkhttpCallback<List<FcboxSignResponseBean>> onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiFcbox().fcboxSign(fcboxSignBean, ApiCallbackFenChaoService.FC_TOKEN, OkhttpManager.grayToken, ApiCallbackFenChaoService.FC_COOKIE).enqueue((Callback)new ApiCallbackFenChaoService((ApiCallbackFenChaoService.HttpCallback)new ApiCallbackFenChaoService.HttpCallback<List<FcboxSignResponseBean>>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e30\u5de2\u670d\u52a1\u7ad9\u51fa\u5e93\u7b7e\u6536\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final List<FcboxSignResponseBean> list) {
                //////XLog.e("\u4e30\u5de2\u670d\u52a1\u7ad9\u51fa\u5e93\u7b7e\u6536\u6210\u529f");
                final OnOkhttpCallback val$okhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(list);
                }
            }
        }));
    }

    public static void fengchaoServicePoint(final String s) {
        final FcboxServicePointBean fcboxServicePointBean = new FcboxServicePointBean();
        fcboxServicePointBean.setLatitude(-1.0f);
        fcboxServicePointBean.setLongitude(-1.0f);
        MyApplication.getDaggerReposifitComponent().getRequestApiFcbox().fcboxServicePoint(fcboxServicePointBean, ApiCallbackFenChaoService.FC_TOKEN, s, ApiCallbackFenChaoService.FC_COOKIE).enqueue((Callback)new ApiCallbackFenChaoService((ApiCallbackFenChaoService.HttpCallback)new ApiCallbackFenChaoService.HttpCallback<List<FcboxServicePointResponseBean>>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e30\u5de2\u670d\u52a1\u7ad9\u670d\u52a1\u7ba1\u7406\u63a5\u53e3\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u4e30\u5de2\u670d\u52a1\u7ad9\u670d\u52a1\u7ba1\u7406\u63a5\u53e3\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final List<FcboxServicePointResponseBean> list) {
                //////XLog.e("\u4e30\u5de2\u670d\u52a1\u7ad9\u670d\u52a1\u7ba1\u7406\u63a5\u53e3\u6210\u529f");
            }
        }));
    }

    public static void fengchaoServiceQueryOtherPackage(final FcboxQueryPackageBean fcboxQueryPackageBean, final OnOkhttpCallback<FcboxQueryPackageResponseBean> onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiFcbox().fcboxQueryByMobilePhone(fcboxQueryPackageBean, ApiCallbackFenChaoService.FC_TOKEN, OkhttpManager.grayToken, ApiCallbackFenChaoService.FC_COOKIE).enqueue((Callback)new ApiCallbackFenChaoService((ApiCallbackFenChaoService.HttpCallback)new ApiCallbackFenChaoService.HttpCallback<FcboxQueryPackageResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e30\u5de2\u670d\u52a1\u7ad9\u67e5\u8be2\u5269\u4f59\u5305\u88f9\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u4e30\u5de2\u670d\u52a1\u7ad9\u67e5\u8be2\u5269\u4f59\u5305\u88f9\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final FcboxQueryPackageResponseBean fcboxQueryPackageResponseBean) {
                //////XLog.e("\u4e30\u5de2\u670d\u52a1\u7ad9\u67e5\u8be2\u5269\u4f59\u5305\u88f9\u6210\u529f");
                final OnOkhttpCallback val$okhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(fcboxQueryPackageResponseBean);
                }
            }
        }));
    }

    public static void fengchaoServiceStationInfo(final String s, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiFcbox().fcboxStationInfor(ApiCallbackFenChaoService.FC_TOKEN, s, ApiCallbackFenChaoService.FC_COOKIE).enqueue((Callback)new ApiCallbackFenChaoService((ApiCallbackFenChaoService.HttpCallback)new ApiCallbackFenChaoService.HttpCallback<FcboxStationInforResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e30\u5de2\u670d\u52a1\u7ad9\u7ad9\u70b9\u4fe1\u606f\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u4e30\u5de2\u670d\u52a1\u7ad9\u7ad9\u70b9\u4fe1\u606f\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final FcboxStationInforResponseBean fcboxStationInfor) {
                //////XLog.e("\u4e30\u5de2\u670d\u52a1\u7ad9\u7ad9\u70b9\u4fe1\u606f\u6210\u529f");
                RqFilePreference.getInstance().setFcboxStationInfor(fcboxStationInfor);
                OkhttpManager.fengchaoServicePoint(s);
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(fcboxStationInfor);
                }
            }
        }));
    }

    public static void fsshUploadBarcodeImage(final String s, final Bitmap bitmap, final FsshOutLibraryBodyBean fsshOutLibraryBodyBean, final OnOkhttpCallback<FsshUploadPictureResponseBean> onOkhttpCallback) {
        try {
            final MultipartBody.Builder addPart = new MultipartBody.Builder().setType(MultipartBody.FORM).addPart(Headers.of(new String[] { "Content-Disposition", "form-data; name=\"equipmentId\"" }), RequestBody.create((MediaType)null, fsshOutLibraryBodyBean.getEquipmentId())).addPart(Headers.of(new String[] { "Content-Disposition", "form-data;name=\"billCode\"" }), RequestBody.create((MediaType)null, fsshOutLibraryBodyBean.getData())).addPart(Headers.of(new String[] { "Content-Disposition", "form-data;name=\"appkey\"" }), RequestBody.create((MediaType)null, fsshOutLibraryBodyBean.getAppkey())).addPart(Headers.of(new String[] { "Content-Disposition", "form-data;name=\"appNotic\"" }), RequestBody.create((MediaType)null, fsshOutLibraryBodyBean.getAppNotic())).addPart(Headers.of(new String[] { "Content-Disposition", "form-data;name=\"appTimestamp\"" }), RequestBody.create((MediaType)null, fsshOutLibraryBodyBean.getAppTimestamp())).addPart(Headers.of(new String[] { "Content-Disposition", "form-data;name=\"systemCode\"" }), RequestBody.create((MediaType)null, "signEquipment")).addPart(Headers.of(new String[] { "Content-Disposition", "form-data;name=\"appSign\"" }), RequestBody.create((MediaType)null, fsshOutLibraryBodyBean.getAppSign()));
            final StringBuilder sb = new StringBuilder();
            sb.append("form-data;name=\"file\";filename=\"");
            sb.append(s);
            sb.append(".jpg\"");
            final MultipartBody build = addPart.addPart(Headers.of(new String[] { "Content-Disposition", sb.toString() }), RequestBody.create(MediaType.parse("image/jpeg"), ImageSaveUtil.getInstance().bitmapToBytes(bitmap))).build();
            if (build == null) {
                return;
            }
            MyApplication.getDaggerReposifitComponent().getRequestApiFenShiShenHuo().fsshUploadBarcodePicture(build).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<FsshUploadPictureResponseBean>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u7c89\u4e1d\u751f\u6d3b\u4e0a\u4f20\u56fe\u7247\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("\u7c89\u4e1d\u751f\u6d3b\u4e0a\u4f20\u56fe\u7247\u5931\u8d25 ");
                    sb2.append(s);
                    ToastSoundUtil.displayToast(sb2.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, s);
                    }
                }

                public void onSuccess(final FsshUploadPictureResponseBean fsshUploadPictureResponseBean) {
                    if (fsshUploadPictureResponseBean != null) {
                        if (fsshUploadPictureResponseBean.isStatus()) {
                            //XLog.e("\u7c89\u4e1d\u751f\u6d3b\u4e0a\u4f20\u56fe\u7247\u6210\u529f");
                            final OnOkhttpCallback val$okhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                            if (val$okhttpCallback != null) {
                                val$okhttpCallback.onSuccess(fsshUploadPictureResponseBean);
                            }
                        }
                        else if (OkhttpManager.onErrorCallback != null) {
                            OkhttpManager.onErrorCallback.onError(-2, fsshUploadPictureResponseBean.getStatusMessage());
                        }
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void getAdvertInfo(final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiAdvert().getAdvertInfo("15372439911").enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<List<AdvertInfoBean>>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u83b7\u53d6\u5e7f\u544a\u6570\u636e\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final List<AdvertInfoBean> list) {
                //XLog.e("\u83b7\u53d6\u5e7f\u544a\u6570\u636e\u6210\u529f");
                if (list != null && list.size() > 0) {
                    final OnOkhttpCallback val$onOkhttpCallback = onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(list);
                    }
                }
            }
        }));
    }

    public static void getAllSendInformationData(final int n, final int n2, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiJoyFinder().getAllSendInformationData(n, n2, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<SendInformationBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u62c9\u53d6\u5bc4\u4ef6\u4fe1\u606f\u6570\u636e\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final SendInformationBean sendInformationBean) {
                //XLog.e("\u62c9\u53d6\u5bc4\u4ef6\u4fe1\u606f\u6570\u636e\u6210\u529f");
                if (sendInformationBean != null && sendInformationBean.getResults() != null && sendInformationBean.getResults().size() > 0) {
                    final OnOkhttpCallback val$onOkhttpCallback = onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(sendInformationBean.getResults());
                    }
                }
            }
        }));
    }

    public static void getAuthCodeV2(final OnOkhttpCallback<AuthorizationStationInfoResBean> onOkhttpCallback) {
        if (OkhttpManager.JWTTOKEN.isEmpty()) {
            OkhttpManager.JWTTOKEN = getDeviceLoginToken();
        }
        if (OkhttpManager.sn.isEmpty()) {
            OkhttpManager.sn = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number();
        }
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().getAuthCodeV2(OkhttpManager.sn, OkhttpManager.JWTTOKEN).enqueue((Callback)new ApiPostStationCallback((ApiPostStationCallback.HttpCallback)new ApiPostStationCallback.HttpCallback<AuthorizationStationInfoResBean>() {
            @Override
            public void onFailure(final int n, final String s) {
            }

            public void onSuccess(final AuthorizationStationInfoResBean authorizationStationInfoResBean) {
                onOkhttpCallback.onSuccess(authorizationStationInfoResBean);
            }
        }));
    }

    public static void getCobaAdvertisement(final OnOkhttpCallback<List<AdvertisementResponseBean>> onOkhttpCallback) {
        try {
            MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().getAdvertisement(FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number(), getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<List<AdvertisementResponseBean>>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u83b7\u53d6\u5e7f\u544a\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                    //OkhttpManager.onErrorCallback;
                }

                public void onSuccess(final List<AdvertisementResponseBean> list) {
                    //XLog.e("\u83b7\u53d6\u5e7f\u544a\u6210\u529f");
                    final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(list);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void getCobaDeviceCloudSize(final OnOkhttpCallback<DeviceCloudResponseBean> onOkhttpCallback) {
        try {
            MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().getDeviceCloudSize(FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number(), getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<DeviceCloudResponseBean>() {
                DeviceCloudResponseBean dataBean;

                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u83b7\u53d6\u5f53\u524d\u8bbe\u5907\u4e91\u7a7a\u95f4\u5927\u5c0f\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                }

                public void onSuccess(final DeviceCloudResponseBean dataBean) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u83b7\u53d6\u5f53\u524d\u8bbe\u5907\u4e91\u7a7a\u95f4\u5927\u5c0f\u6210\u529f");
                    sb.append(dataBean.getCloud_limit());
                    sb.append("     ");
                    sb.append(dataBean.getCloud_current());
                    sb.append("    ");
                    sb.append(536870912);
                    sb.append("       ");
                    sb.append(dataBean.getCloud_deadline());
                    //XLog.e(sb.toString());
                    final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(dataBean);
                        this.dataBean = dataBean;
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void getCookie(final BlueShopCookieBean blueShopCookieBean, final OnOkhttpCallback onOkhttpCallback) {
        new OkHttpClient.Builder().retryOnConnectionFailure(true).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).sslSocketFactory(SSLSocketClient.getSSLSocketFactory()).hostnameVerifier(SSLSocketClient.getHostnameVerifier()).followRedirects(false).build().newCall(new Request.Builder().url("http://sh.ulandian.com/login2.htm").post((RequestBody)new FormBody.Builder().add("username", blueShopCookieBean.getUsername()).add("password", blueShopCookieBean.getPassword()).build()).build()).enqueue((okhttp3.Callback)new okhttp3.Callback() {

            public void onFailure(final okhttp3.Call call, final IOException ex) {
                if (OkhttpManager.onErrorCallback != null) {
                    final OnHttpErrorCallback access$000 = OkhttpManager.onErrorCallback;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(ex.getMessage());
                    access$000.onError(-2, sb.toString());
                }
            }


            public void onResponse(final okhttp3.Call call, final okhttp3.Response response) throws IOException {
                final Headers headers = response.headers();
                final int size = headers.size();
                String blueShopCookie = "";
                String string;
                for (int i = 0; i < size; ++i, blueShopCookie = string) {
                    final String name = headers.name(i);
                    final String value = headers.value(i);
                    string = blueShopCookie;
                    if (name.equals("Set-Cookie")) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append(blueShopCookie);
                        sb.append(value);
                        sb.append(",");
                        string = sb.toString();
                    }
                }
                RqFilePreference.getInstance().setBlueShopCookie(blueShopCookie);
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(new JsonObject());
                }
            }
        });
    }

    public static String getDeviceLoginToken() {
        final DeviceLoginBean loginBean = RqFilePreference.getInstance().getLoginBean();
        if (loginBean != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("JWT ");
            sb.append(loginBean.getToken());
            return sb.toString();
        }
        return null;
    }

    public static void getDeviceOnlineState(final DeviceOnlineState deviceOnlineState, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().getDeviceOnlineState(deviceOnlineState, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<String>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e0a\u4f20\u6587\u4ef6\u5927\u5c0f\u53ca\u56fe\u7247\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (n == 0) {
                    return;
                }
                //OkhttpManager.onErrorCallback;
            }

            public void onSuccess(final String s) {
                //XLog.e("\u4e0a\u4f20\u6587\u4ef6\u5927\u5c0f\u53ca\u56fe\u7247\u6570\u636e\u6210\u529f");
                final OnOkhttpCallback val$onOkhttpCallback = onOkhttpCallback;
                if (val$onOkhttpCallback != null) {
                    val$onOkhttpCallback.onSuccess(s);
                }
            }
        }));
    }

    public static void getDeviceUserarea(final DeviceUserareaBodyBean deviceUserareaBodyBean, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().deviceUserareaAddress(deviceUserareaBodyBean).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<DeviceUserareaBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u83b7\u53d6\u9700\u8981\u6fc0\u6d3b\u7684\u5730\u5740\u4fe1\u606f\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                ToastSoundUtil.displayToast(s);
            }

            public void onSuccess(final DeviceUserareaBean deviceUserareaBean) {
                //XLog.e("\u83b7\u53d6\u9700\u8981\u6fc0\u6d3b\u7684\u5730\u5740\u4fe1\u606f\u6210\u529f");
                final OnOkhttpCallback val$onOkhttpCallback = onOkhttpCallback;
                if (val$onOkhttpCallback != null) {
                    val$onOkhttpCallback.onSuccess(deviceUserareaBean);
                }
            }
        }));
    }

    public static void getExpressCompanyListData() {
        MyApplication.getDaggerReposifitComponent().getRequestApiJoyFinder().getExpressCompanyListData(getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<ExpressCompanyListBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u83b7\u53d6\u5feb\u9012\u516c\u53f8\u5217\u8868\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final ExpressCompanyListBean expressCompanyListBean) {
                //XLog.e("\u83b7\u53d6\u5feb\u9012\u516c\u53f8\u5217\u8868\u6210\u529f");
                RqFilePreference.getInstance().setExpressCompany((List)expressCompanyListBean.getResults());
            }
        }));
    }

    public static String getGuoGuoSign(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(MD5Util.encodeMd5(s, ""));
        //sb.append(ApiGuoGuoYiZhanActivity.Companion.getKey());
        return MD5Util.encodeMd5(sb.toString(), "");
    }

    public static <T> String getJinLinBaoSign(final T t) {
        final String get_sign = new JinLinBaoSign().get_sign(t);
        final StringBuilder sb = new StringBuilder();
        sb.append("getJinLinBaoSign: ");
        sb.append(get_sign);
        Log.d("OkhttpManager", sb.toString());
        return MD5Util.encodeMd5(get_sign, "");
    }
    private static String getLaiquLoginToken() {
        final LaiquLoginResponseBean laiquLoginInfor = RqFilePreference.getInstance().getLaiquLoginInfor();
        if (laiquLoginInfor != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Bearer ");
            sb.append(laiquLoginInfor.getToken());
            return sb.toString();
        }
        return null;
    }
    public static  String laiqu_pass;
    public static void getLaiquRsaPublicKey(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        laiqu_pass = s2;
        MyApplication.getDaggerReposifitComponent().getRequestApiLaiqu().getRsaPublicKey().enqueue((Callback)new ApiCallbackLaiqu((ApiCallbackLaiqu.HttpCallback)new ApiCallbackLaiqu.HttpCallback<LaiquRsaPublicKeyBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u6765\u53d6rsa\u516c\u94a5\u63a5\u53e3\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            public void onSuccess(final LaiquRsaPublicKeyBean laiquRsaPublicKeyBean) {
                //////XLog.e("\u6765\u53d6rsa\u516c\u94a5\u63a5\u53e3\u6210\u529f");
                if (laiquRsaPublicKeyBean != null && laiquRsaPublicKeyBean.getPublicKey() != null) {
                    OkhttpManager.laiquUserLogin(s, RsaUtil.encryptDataByPublicKey(laiquRsaPublicKeyBean.getPublicKey(), s2.getBytes()), onOkhttpCallback);
                }
            }
        }));
    }

    public static void getNewVersionApk(final Context context, final String s) {
        MyApplication.getDaggerReposifitComponent().getRequestApi().downloadApkFile(s).enqueue((Callback)new ApiFileCallback((ApiFileCallback.HttpCallback)new ApiFileCallback.HttpCallback() {
            //DownLoadDialog downLoadDialog = new DownLoadDialog(context);

            @Override
            public void onFailure(final int n, final String s) {
                //this.downLoadDialog.dismiss();
            }

            @Override
            public void onProgress(final Float n) {
                //this.downLoadDialog.setDownLoadProgress(n);
            }

            @Override
            public void onStart() {
                //this.downLoadDialog.show();
            }

            @Override
            public void onSuccess(final String s) {
                //this.downLoadDialog.dismiss();
                final StringBuilder sb = new StringBuilder();
                sb.append("\u66f4\u65b0apk\u8def\u5f84: ============================================");
                sb.append(s);
                Log.d("OkhttpManager", sb.toString());
                ApkUtil.installApk(context, s);
            }
        }));
    }

    public static void getPackageType() {
        MyApplication.getDaggerReposifitComponent().getRequestApiJoyFinder().getGoodsType(getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<List<GoodsTypeBean>>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u83b7\u53d6\u5305\u88f9\u7c7b\u578b\u63a5\u53e3\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final List<GoodsTypeBean> goodsType) {
                //XLog.e("\u83b7\u53d6\u5305\u88f9\u7c7b\u578b\u63a5\u53e3\u6210\u529f");
                RqFilePreference.getInstance().setGoodsType((List)goodsType);
            }
        }));
    }

    public static void getSendInformationData(final String s) {
        MyApplication.getDaggerReposifitComponent().getRequestApiJoyFinder().getSendInformationData(s, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<SendInformationBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u62c9\u53d6\u5bc4\u4ef6\u4fe1\u606f\u6570\u636e\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final SendInformationBean sendInformationBean) {
                //XLog.e("\u62c9\u53d6\u5bc4\u4ef6\u4fe1\u606f\u6570\u636e\u6210\u529f");
                if (sendInformationBean != null && sendInformationBean.getResults() != null && sendInformationBean.getResults().size() > 0) {
                    ////LitePalManager.saveSendInformationList(sendInformationBean.getResults());
                }
            }
        }));
    }

    public static void getSendQrCode(final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiJoyFinder().getSendQrCode(getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<String>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u83b7\u53d6\u5bc4\u4ef6\u4e8c\u7ef4\u7801\u63a5\u53e3\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final String s) {
                //XLog.e("\u83b7\u53d6\u5bc4\u4ef6\u4e8c\u7ef4\u7801\u63a5\u53e3\u6210\u529f");
                final OnOkhttpCallback val$onOkhttpCallback = onOkhttpCallback;
                if (val$onOkhttpCallback != null) {
                    val$onOkhttpCallback.onSuccess(s);
                }
            }
        }));
    }

    public static void getSiteListData(final int n, final int n2, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiJoyFinder().getSiteList(n, n2, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<SiteListBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u540c\u7ea7\u7ad9\u70b9\u4fe1\u606f\u5217\u8868\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final SiteListBean siteListBean) {
                //XLog.e("\u540c\u7ea7\u7ad9\u70b9\u4fe1\u606f\u5217\u8868\u6210\u529f");
                if (siteListBean != null && siteListBean.getResults() != null && siteListBean.getResults().size() > 0) {
                    final OnOkhttpCallback val$onOkhttpCallback = onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(siteListBean.getResults());
                    }
                }
            }
        }));
    }

    public static void getStationPackageV2(final OnOkhttpCallback<StationPackageV2ResBean> onOkhttpCallback) {
        if (OkhttpManager.JWTTOKEN.isEmpty()) {
            OkhttpManager.JWTTOKEN = getDeviceLoginToken();
        }
        if (OkhttpManager.sn.isEmpty()) {
            OkhttpManager.sn = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number();
        }
        if (OkhttpManager.username.isEmpty()) {
            OkhttpManager.username = RqFilePreference.getInstance().getLoginBean().getUsername();
        }
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().getStationPackageV2(OkhttpManager.sn, OkhttpManager.JWTTOKEN).enqueue((Callback)new ApiPostStationCallback((ApiPostStationCallback.HttpCallback)new ApiPostStationCallback.HttpCallback<StationPackageV2ResBean>() {
            @Override
            public void onFailure(final int n, final String s) {
            }

            public void onSuccess(final StationPackageV2ResBean stationPackageV2ResBean) {
                onOkhttpCallback.onSuccess(stationPackageV2ResBean);
            }
        }));
    }

    public static void getStsToken(final OnOkhttpCallback<GetStsResponseTokenBean> onOkhttpCallback) {
        try {
            final DeviceLoginBean loginBean = RqFilePreference.getInstance().getLoginBean();
            if (loginBean == null) {
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            final DeviceStsTokenBean deviceStsTokenBean = new DeviceStsTokenBean();
            deviceStsTokenBean.setSn(FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number());
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(currentTimeMillis);
            deviceStsTokenBean.setTn(sb.toString());
            deviceStsTokenBean.setSign(MD5Util.getEncryptMD5Class(deviceStsTokenBean.getClass(), currentTimeMillis, loginBean.getUsername()));
            MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().getStsToken(deviceStsTokenBean, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<GetStsResponseTokenBean>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u83b7\u53d6sts token\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                    //OkhttpManager.onErrorCallback;
                }

                public void onSuccess(final GetStsResponseTokenBean stsResponseToken) {
                    RqFilePreference.getInstance().setStsResponseToken(stsResponseToken);
                    //XLog.e("\u83b7\u53d6sts token\u6210\u529f");
                    final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(stsResponseToken);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void getTrial(final String s, final OnOkhttpCallback<TrialResponseBean> onOkhttpCallback) {
        try {
            MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().getTrial(FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number(), s, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<TrialResponseBean>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u83b7\u53d6\u8bd5\u7528\u65f6\u95f4\u9519\u8bef:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                }

                public void onSuccess(final TrialResponseBean trialResponseBean) {
                    final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(trialResponseBean);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void getUpdateExpressVersion(final Context context) {
        final PrintStream out = System.out;
        final StringBuilder sb = new StringBuilder();
        sb.append("\u5f53\u524d\u9009\u62e9\u7684\u9a7f\u7ad9\uff1a");
        sb.append(CommonFilePreference.getInstance().getSelectExpressSystemTitle());
        out.println(sb.toString());
        MyApplication.getDaggerReposifitComponent().getRequestApi().getUpdateVersion(1, CommonFilePreference.getInstance().getSelectExpressSystemTitle()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<GetSoftUpdateVersionBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("onFailure: ");
                sb.append(n);
                sb.append("    ");
                sb.append(s);
                Log.e("OkhttpManager", sb.toString());
            }

            public void onSuccess(final GetSoftUpdateVersionBean getSoftUpdateVersionBean) {
                try {
                    final PrintStream out = System.out;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u5f53\u524d\u9009\u62e9\u7684\u9a7f\u7ad9\u7684\u7248\u672c\uff1a");
                    sb.append(Integer.parseInt(getSoftUpdateVersionBean.getVersion()));
                    out.println(sb.toString());
                    if (ApkUtil.getVersionCode() < Integer.parseInt(getSoftUpdateVersionBean.getVersion())) {
                        /*final UpdataDialog updataDialog = new UpdataDialog(context, 2131558513, new int[] { 2131362012 }, getSoftUpdateVersionBean.getVersion(), getSoftUpdateVersionBean.getUpdate_info(), getSoftUpdateVersionBean.getMust_upgrade());
                        updataDialog.show();
                        updataDialog.setOnCenterItemClickListener((UpdataDialog.OnCenterItemClickListener)new UpdataDialog.OnCenterItemClickListener() {
                            @Override
                            public void OnCenterItemClick(final UpdataDialog updataDialog, final View view) {
                                OkhttpManager.getNewVersionApk(context, getSoftUpdateVersionBean.getLink());
                            }
                        });*/
                        return;
                    }
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("\u5f53\u524d\u5df2\u662f\u6700\u65b0\u7248\u672c:");
                    sb2.append(Integer.parseInt(getSoftUpdateVersionBean.getVersion()));
                    ToastSoundUtil.displayToast(sb2.toString());
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }));
    }

    public static void getUpdateVersion(final Context context) {
        int n = 1;
        if (ExpressStationEnum.KUAIBAO.getCode() == CommonFilePreference.getInstance().getSelectExpressSystemFlag()) {
            n = 32;
        }
        MyApplication.getDaggerReposifitComponent().getRequestApi().getUpdateVersion(n, null).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<GetSoftUpdateVersionBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("onFailure: ");
                sb.append(n);
                sb.append("    ");
                sb.append(s);
                Log.e("OkhttpManager", sb.toString());
            }

            public void onSuccess(final GetSoftUpdateVersionBean getSoftUpdateVersionBean) {
                try {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("onSuccess: =======\u672c\u5730\u7248\u672c=====");
                    sb.append(ApkUtil.getVersionCode());
                    sb.append("=======\u76ee\u6807\u7248\u672c===");
                    sb.append(getSoftUpdateVersionBean.getVersion());
                    Log.d("OkhttpManager", sb.toString());
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("onSuccess: =======\u672c\u5730\u7248\u672c=====");
                    sb2.append(Integer.parseInt(getSoftUpdateVersionBean.getVersion()));
                    Log.d("OkhttpManager", sb2.toString());
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("getUpdateExpressVersion: ===============================");
                    sb3.append(CommonFilePreference.getInstance().getSelectExpressSystemTitle());
                    Log.d("OkhttpManager", sb3.toString());
                    if (ApkUtil.getVersionCode() < Integer.parseInt(getSoftUpdateVersionBean.getVersion())) {
                        /*final UpdataDialog updataDialog = new UpdataDialog(context, 2131558513, new int[] { 2131362012 }, getSoftUpdateVersionBean.getVersion(), getSoftUpdateVersionBean.getUpdate_info(), getSoftUpdateVersionBean.getMust_upgrade());
                        updataDialog.show();
                        updataDialog.setOnCenterItemClickListener((UpdataDialog.OnCenterItemClickListener)new UpdataDialog.OnCenterItemClickListener() {
                            @Override
                            public void OnCenterItemClick(final UpdataDialog updataDialog, final View view) {
                                OkhttpManager.getNewVersionApk(context, getSoftUpdateVersionBean.getLink());
                            }
                        });*/
                        return;
                    }
                    System.out.println("\u68c0\u67e5\u5f53\u524d\u9a7f\u7ad9\u7248\u672c\u662f\u5426\u6709\u66f4\u65b0");
                    OkhttpManager.getUpdateExpressVersion(context);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }));
    }

    public static void getVerificationCode(final String s, final int n) {
        final RequestApiDeviceManager requestApiDeviceManager = MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager();
        final StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.append("");
        requestApiDeviceManager.getActivationVerificationCode(s, sb.toString()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<String>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u83b7\u53d6\u9a8c\u8bc1\u7801\u5931\u8d25: ");
                sb.append(n);
                sb.append(" ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u83b7\u53d6\u9a8c\u8bc1\u7801\u5931\u8d25: ");
                sb2.append(n);
                sb2.append(" ");
                sb2.append(s);
                ToastSoundUtil.displayToast(sb2.toString());
            }

            public void onSuccess(final String s) {
                //XLog.e("\u83b7\u53d6\u9a8c\u8bc1\u7801\u6210\u529f");
                ToastSoundUtil.displayToast("\u83b7\u53d6\u9a8c\u8bc1\u7801\u6210\u529f");
            }
        }));
    }

    public static String getYunDaKDCSSign(final YunDaKDCSRequestBean yunDaKDCSRequestBean) {
        final Field[] declaredFields = yunDaKDCSRequestBean.getClass().getDeclaredFields();
        int i = 0;
        String s = "";
        while (i < declaredFields.length) {
            String string2;
            while (true) {
                while (true) {
                    Label_0169: {
                        try {
                            if (declaredFields[i].get(yunDaKDCSRequestBean) == null) {
                                break Label_0169;
                            }
                            final String string = declaredFields[i].get(yunDaKDCSRequestBean).toString();
                            string2 = s;
                            if (StringUtil.isNotEmpty(string)) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append(s);
                                sb.append(declaredFields[i].getName());
                                sb.append(string);
                                string2 = sb.toString();
                            }
                        }
                        catch (IllegalAccessException ex) {
                            ex.printStackTrace();
                            string2 = s;
                        }
                        break;
                    }
                    final String string = "";
                    continue;
                }
            }
            /*++i;
            s = string2;*/
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("getYunDaKDCSSign: ");
        sb2.append(s);
        Log.e("OkhttpManager", sb2.toString());
        if (s.length() > 0) {
            return MD5Util.encodeMd5(s);
        }
        return s;
    }

    public static void guoGuoPutOffStorageV3(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        final StringBuilder sb = new StringBuilder();
        sb.append("express_num=");
        sb.append(s);
        MyApplication.getDaggerReposifitComponent().getRequestApiGuoGuoYiZhan().putOffStorageV3(new OffStorageRequestBean(s, getGuoGuoSign(sb.toString())), "DSQQOdwT"/*ApiGuoGuoYiZhanActivity.Companion.getApiId()*/, GuoGuoYiZhan.INSTANCE.getDevice(), s2).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<OffStorageResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u679c\u679c\u9a7f\u7ad9\u51fa\u5e93\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final OffStorageResponseBean offStorageResponseBean) {
                if (offStorageResponseBean.getCode().equals("0")) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(offStorageResponseBean);
                    }
                }
                else if (offStorageResponseBean.getCode().equals("203")) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u5305\u88f9\u5f02\u5e38: ");
                    sb.append(offStorageResponseBean.getMsg());
                    ToastSoundUtil.baoGuoYiChangToast(sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, offStorageResponseBean.getMsg());
                    }
                }
                else if (offStorageResponseBean.getCode().equals("202")) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("\u5df2\u51fa\u5e93: ");
                    sb2.append(offStorageResponseBean.getMsg());
                    ToastSoundUtil.baoGuoYiChuToast(sb2.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, offStorageResponseBean.getMsg());
                    }
                }
                else {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("\u51fa\u5e93\u5931\u8d25: ");
                    sb3.append(offStorageResponseBean.getMsg());
                    ToastSoundUtil.wrongSoundToast(sb3.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, offStorageResponseBean.getMsg());
                    }
                }
            }
        }));
    }

    public static void guoGuoYiZhanLogin(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        final StringBuilder sb = new StringBuilder();
        sb.append("password=");
        sb.append(s2);
        sb.append("&tel=");
        sb.append(s);
        sb.append("&type=agent");
        MyApplication.getDaggerReposifitComponent().getRequestApiGuoGuoYiZhan().login(new LoginRequestBean("agent", s, s2, getGuoGuoSign(sb.toString())), "DSQQOdwT"/*ApiGuoGuoYiZhanActivity.Companion.getApiId()*/, GuoGuoYiZhan.INSTANCE.getDevice()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<LoginResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u679c\u679c\u9a7f\u7ad9\u767b\u5f55\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final LoginResponseBean guoGuoYiZhanLoginRes) {
                if (guoGuoYiZhanLoginRes.getCode().equals("0")) {
                    RqFilePreference.getInstance().setGuoGuoYiZhanLoginRes(guoGuoYiZhanLoginRes);
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        RqFilePreference.getInstance().setGUOGUOYIZHANAccount(s);
                        RqFilePreference.getInstance().setGUOGUOYIZHANPwd(s2);
                        val$okhttpCallback.onSuccess(guoGuoYiZhanLoginRes);
                    }
                }
                else {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u679c\u679c\u9a7f\u7ad9\u767b\u5f55\u5931\u8d25: ");
                    sb.append(guoGuoYiZhanLoginRes.getMsg());
                    ToastSoundUtil.wrongSoundToast(sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, guoGuoYiZhanLoginRes.getMsg());
                    }
                }
            }
        }));
    }

    public static void hylBarcodeUpload(final String s, final String s2, final String s3, final String s4, final OnOkhttpCallback onOkhttpCallback) {
        final StringBuilder sb = new StringBuilder();
        sb.append("/logistics/return_callback?bag_id=");
        sb.append(s);
        sb.append("&device_id=");
        sb.append(s2);
        sb.append("&nonce_str=");
        sb.append(s4);
        sb.append("&timestamp=");
        sb.append(s3);
        sb.append("3bdaab1e-c055-11ea-ae0b-00163e0c");
        MyApplication.getDaggerReposifitComponent().getRequestApiHyl().barcodeUpload(new HylRequestBean(s, s2, s3, s4, MD5Util.encodeMd5(sb.toString(), ""))).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<HylResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u851a\u8def\u5faa\u73af ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final HylResponseBean hylResponseBean) {
                if (hylResponseBean.getResult().equals("SUCCESS")) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(hylResponseBean);
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, hylResponseBean.getReason());
                }
            }
        }));
    }

    public static void hylLogin(final String s, final OnOkhttpCallback onOkhttpCallback) {
        final HylLoginBean hylLogin = new HylLoginBean(s);
        RqFilePreference.getInstance().setHylLogin(hylLogin);
        onOkhttpCallback.onSuccess(hylLogin);
    }

    public static void inspectPayment(final String s, final OnOkhttpCallback<List<AuthFlowsBean>> onOkhttpCallback) {
        if (OkhttpManager.JWTTOKEN.isEmpty()) {
            OkhttpManager.JWTTOKEN = getDeviceLoginToken();
        }
        if (OkhttpManager.sn.isEmpty()) {
            OkhttpManager.sn = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number();
        }
        if (OkhttpManager.username.isEmpty()) {
            OkhttpManager.username = RqFilePreference.getInstance().getLoginBean().getUsername();
        }
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().inspectPayment(OkhttpManager.sn, s, OkhttpManager.JWTTOKEN).enqueue((Callback)new ApiPostStationCallback((ApiPostStationCallback.HttpCallback)new ApiPostStationCallback.HttpCallback<List<AuthFlowsBean>>() {
            @Override
            public void onFailure(final int n, final String s) {
            }

            public void onSuccess(final List<AuthFlowsBean> list) {
                onOkhttpCallback.onSuccess(list);
            }
        }));
    }

    public static void jackYunUploadPictrue(final String s, String md5Str, final JackYunPictureBean jackYunPictureBean, final OnOkhttpCallback<ResponseChenZhongDdengJi> onOkhttpCallback) {
        System.out.println("\u5409\u5ba2\u4e91\u56fe\u7247\u4e0a\u4f20\u63a5\u53e3==============================");
        final String currentDateTime = DateUtil.getCurrentDateTime();
        final String jsonStringByGson = JsonUtil.getJsonStringByGson(jackYunPictureBean);
        final StringBuilder sb = new StringBuilder();
        sb.append("appkey");
        sb.append(s);
        sb.append("bizcontent");
        sb.append(jsonStringByGson);
        sb.append("contenttypejsonmethodwms.order.upload-stockout-picturetimestamp");
        sb.append(currentDateTime);
        sb.append("version1.0");
        final String string = sb.toString();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(md5Str);
        sb2.append(string);
        sb2.append(md5Str);
        md5Str = MD5Util.getMD5Str(sb2.toString().toLowerCase());
        MyApplication.getDaggerReposifitComponent().getRequestChengZhongDengJi().chenZhongDengJiPicture("wms.order.upload-stockout-picture", s, "1.0", "json", currentDateTime, jsonStringByGson, md5Str).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<ResponseChenZhongDdengJi>() {
            @Override
            public void onFailure(final int n, final String s) {
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, s);
                }
            }

            public void onSuccess(final ResponseChenZhongDdengJi responseChenZhongDdengJi) {
                try {
                    if (responseChenZhongDdengJi.getCode() == 200) {
                        if (onOkhttpCallback != null) {
                            onOkhttpCallback.onSuccess(responseChenZhongDdengJi);
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, responseChenZhongDdengJi.getMsg());
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }));
    }

    public static void jinLinBaoJieBoBatchAdd(String jinLinBaoSign, final String batch_date, final String seq_no, final String sid, final String uid, final String express_id, final OnOkhttpCallback onOkhttpCallback) {
        final JinLinBaoJieBoBatchAddRequestBean jinLinBaoJieBoBatchAddRequestBean = new JinLinBaoJieBoBatchAddRequestBean();
        jinLinBaoJieBoBatchAddRequestBean.setLogis_id(jinLinBaoSign);
        jinLinBaoJieBoBatchAddRequestBean.setSid(sid);
        jinLinBaoJieBoBatchAddRequestBean.setUid(uid);
        jinLinBaoJieBoBatchAddRequestBean.setExpress_id(express_id);
        jinLinBaoJieBoBatchAddRequestBean.setBatch_date(batch_date);
        jinLinBaoJieBoBatchAddRequestBean.setSeq_no(seq_no);
        jinLinBaoSign = getJinLinBaoSign(jinLinBaoJieBoBatchAddRequestBean);
        MyApplication.getDaggerReposifitComponent().getRequestApiJinLinBao().jinLinBaoOcrJieBoBatchAdd(jinLinBaoSign, jinLinBaoJieBoBatchAddRequestBean.getLogis_id(), jinLinBaoJieBoBatchAddRequestBean.getSn(), jinLinBaoJieBoBatchAddRequestBean.getBatch_date(), jinLinBaoJieBoBatchAddRequestBean.getTs(), jinLinBaoJieBoBatchAddRequestBean.getSid(), jinLinBaoJieBoBatchAddRequestBean.getSeq_no(), jinLinBaoJieBoBatchAddRequestBean.getUid(), jinLinBaoJieBoBatchAddRequestBean.getExpress_id(), jinLinBaoJieBoBatchAddRequestBean.getSign_type()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<jinLinBaoOcrJieBoAddResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("OCR\u63a5\u9a73-\u65b0\u5efa\u6279\u6b21\u63a5\u53e32\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final jinLinBaoOcrJieBoAddResponseBean jinLinBaoOcrJieBoAddResponseBean) {
                if (jinLinBaoOcrJieBoAddResponseBean.getCode() == 0) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(jinLinBaoOcrJieBoAddResponseBean);
                    }
                }
                else if (jinLinBaoOcrJieBoAddResponseBean.getCode() == 20018) {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, jinLinBaoOcrJieBoAddResponseBean.getMsg());
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, jinLinBaoOcrJieBoAddResponseBean.getMsg());
                }
            }
        }));
    }

    public static void jinLinBaoJieBoBatchList(String jinLinBaoSign, final String sid, final String uid, final String express_id, final OnOkhttpCallback onOkhttpCallback) {
        final JinLinBaoJieBoBatchListRequestBean jinLinBaoJieBoBatchListRequestBean = new JinLinBaoJieBoBatchListRequestBean();
        jinLinBaoJieBoBatchListRequestBean.setLogis_id(jinLinBaoSign);
        jinLinBaoJieBoBatchListRequestBean.setSid(sid);
        jinLinBaoJieBoBatchListRequestBean.setUid(uid);
        jinLinBaoJieBoBatchListRequestBean.setExpress_id(express_id);
        jinLinBaoSign = getJinLinBaoSign(jinLinBaoJieBoBatchListRequestBean);
        MyApplication.getDaggerReposifitComponent().getRequestApiJinLinBao().jinLinBaoOcrJieBoGetBatchList(jinLinBaoSign, jinLinBaoJieBoBatchListRequestBean.getLogis_id(), jinLinBaoJieBoBatchListRequestBean.getSn(), jinLinBaoJieBoBatchListRequestBean.getTs(), jinLinBaoJieBoBatchListRequestBean.getSid(), jinLinBaoJieBoBatchListRequestBean.getUid(), jinLinBaoJieBoBatchListRequestBean.getExpress_id(), jinLinBaoJieBoBatchListRequestBean.getSign_type()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JinLinBaoJieBoBatchListResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("OCR\u63a5\u9a73-\u83b7\u53d6\u63a5\u9a73\u6279\u6b21\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final JinLinBaoJieBoBatchListResponseBean jinLinBaoJieBoBatchListResponseBean) {
                if (jinLinBaoJieBoBatchListResponseBean.getCode() == 0) {
                    //XLog.e("\u8fd1\u90bb\u5b9dOCR\u63a5\u9a73-\u83b7\u53d6\u63a5\u9a73\u6279\u6b21\u63a5\u53e3\u6210\u529f");
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(jinLinBaoJieBoBatchListResponseBean);
                    }
                }
                else if (jinLinBaoJieBoBatchListResponseBean.getCode() == 20018) {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, jinLinBaoJieBoBatchListResponseBean.getMsg());
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, jinLinBaoJieBoBatchListResponseBean.getMsg());
                }
            }
        }));
    }

    public static void jinLinBaoJieBoBatchPreAdd(String jinLinBaoSign, final String sid, final String uid, final String express_id, final OnOkhttpCallback onOkhttpCallback) {
        final JinLinBaoJieBoBatchPreAddRequestBean jinLinBaoJieBoBatchPreAddRequestBean = new JinLinBaoJieBoBatchPreAddRequestBean();
        jinLinBaoJieBoBatchPreAddRequestBean.setLogis_id(jinLinBaoSign);
        jinLinBaoJieBoBatchPreAddRequestBean.setSid(sid);
        jinLinBaoJieBoBatchPreAddRequestBean.setUid(uid);
        jinLinBaoJieBoBatchPreAddRequestBean.setExpress_id(express_id);
        jinLinBaoSign = getJinLinBaoSign(jinLinBaoJieBoBatchPreAddRequestBean);
        MyApplication.getDaggerReposifitComponent().getRequestApiJinLinBao().jinLinBaoOcrJieBoBatchPreeAdd(jinLinBaoSign, jinLinBaoJieBoBatchPreAddRequestBean.getLogis_id(), jinLinBaoJieBoBatchPreAddRequestBean.getSn(), jinLinBaoJieBoBatchPreAddRequestBean.getTs(), jinLinBaoJieBoBatchPreAddRequestBean.getSid(), jinLinBaoJieBoBatchPreAddRequestBean.getUid(), jinLinBaoJieBoBatchPreAddRequestBean.getExpress_id(), jinLinBaoJieBoBatchPreAddRequestBean.getSign_type()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<jinLinBaoOcrJieBoPreeAddResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("OCR\u63a5\u9a73-\u65b0\u5efa\u6279\u6b21\u63a5\u53e31\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final jinLinBaoOcrJieBoPreeAddResponseBean jinLinBaoOcrJieBoPreeAddResponseBean) {
                if (jinLinBaoOcrJieBoPreeAddResponseBean.getCode() == 0) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(jinLinBaoOcrJieBoPreeAddResponseBean);
                    }
                }
                else if (jinLinBaoOcrJieBoPreeAddResponseBean.getCode() == 20018) {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, jinLinBaoOcrJieBoPreeAddResponseBean.getMsg());
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, jinLinBaoOcrJieBoPreeAddResponseBean.getMsg());
                }
            }
        }));
    }

    public static void jinLinBaoJieBoExpressList(String jinLinBaoSign, final String sid, final String uid, final OnOkhttpCallback onOkhttpCallback) {
        final JinLinBaoJieBoExpressListRequestBean jinLinBaoJieBoExpressListRequestBean = new JinLinBaoJieBoExpressListRequestBean();
        jinLinBaoJieBoExpressListRequestBean.setLogis_id(jinLinBaoSign);
        jinLinBaoJieBoExpressListRequestBean.setSid(sid);
        jinLinBaoJieBoExpressListRequestBean.setUid(uid);
        jinLinBaoSign = getJinLinBaoSign(jinLinBaoJieBoExpressListRequestBean);
        MyApplication.getDaggerReposifitComponent().getRequestApiJinLinBao().jinLinBaoOcrJieBoExpressList(jinLinBaoSign, jinLinBaoJieBoExpressListRequestBean.getLogis_id(), jinLinBaoJieBoExpressListRequestBean.getSn(), jinLinBaoJieBoExpressListRequestBean.getTs(), jinLinBaoJieBoExpressListRequestBean.getSid(), jinLinBaoJieBoExpressListRequestBean.getUid(), jinLinBaoJieBoExpressListRequestBean.getSign_type()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<jinLinBaoOcrJieBoExpressListResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final jinLinBaoOcrJieBoExpressListResponseBean jinLinBaoOcrJieBoExpressListResponseBean) {
                if (jinLinBaoOcrJieBoExpressListResponseBean.getCode() == 0) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(jinLinBaoOcrJieBoExpressListResponseBean);
                    }
                }
                else if (jinLinBaoOcrJieBoExpressListResponseBean.getCode() == 20018) {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, jinLinBaoOcrJieBoExpressListResponseBean.getMsg());
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, jinLinBaoOcrJieBoExpressListResponseBean.getMsg());
                }
            }
        }));
    }

    public static void jinLinBaoJieBoPictureUpload(String jinLinBaoSign, final String logis_id, final String batch_id, final String sid, final String uid, final String express_id, final String s, final byte[] array, final OnOkhttpCallback onOkhttpCallback) {
        try {
            final RequestBody create = RequestBody.create(MediaType.parse("image/png"), array);
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(s);
            sb.append(".jpg");
            final MultipartBody.Part formData = MultipartBody.Part.createFormData("image", sb.toString(), create);
            final JinLinBaoJieBoPictureUploadRequestBean jinLinBaoJieBoPictureUploadRequestBean = new JinLinBaoJieBoPictureUploadRequestBean();
            jinLinBaoJieBoPictureUploadRequestBean.setDelivery_mode(jinLinBaoSign);
            jinLinBaoJieBoPictureUploadRequestBean.setLogis_id(logis_id);
            jinLinBaoJieBoPictureUploadRequestBean.setPayment("0");
            jinLinBaoJieBoPictureUploadRequestBean.setSid(sid);
            jinLinBaoJieBoPictureUploadRequestBean.setBatch_id(batch_id);
            jinLinBaoJieBoPictureUploadRequestBean.setUid(uid);
            jinLinBaoJieBoPictureUploadRequestBean.setExpress_id(express_id);
            jinLinBaoJieBoPictureUploadRequestBean.setStorage_type("0");
            jinLinBaoSign = getJinLinBaoSign(jinLinBaoJieBoPictureUploadRequestBean);
            MyApplication.getDaggerReposifitComponent().getRequestApiJinLinBao().jinLinBaoOcrJieBoPictureUpload(jinLinBaoJieBoPictureUploadRequestBean.getDelivery_mode(), jinLinBaoSign, jinLinBaoJieBoPictureUploadRequestBean.getLogis_id(), jinLinBaoJieBoPictureUploadRequestBean.getPayment(), jinLinBaoJieBoPictureUploadRequestBean.getSn(), jinLinBaoJieBoPictureUploadRequestBean.getTs(), jinLinBaoJieBoPictureUploadRequestBean.getSid(), jinLinBaoJieBoPictureUploadRequestBean.getBatch_id(), jinLinBaoJieBoPictureUploadRequestBean.getUid(), jinLinBaoJieBoPictureUploadRequestBean.getExpress_id(), jinLinBaoJieBoPictureUploadRequestBean.getStorage_type(), jinLinBaoJieBoPictureUploadRequestBean.getSign_type(), formData).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JinLinBaoJieBoPictureUploadResponseBean>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("OCR\u63a5\u9a73-\u62cd\u7167\u63a5\u9a73\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("OCR\u63a5\u9a73-\u62cd\u7167\u63a5\u9a73\u5931\u8d25 ");
                    sb2.append(s);
                    ToastSoundUtil.wrongSoundToast(sb2.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, s);
                    }
                }

                public void onSuccess(final JinLinBaoJieBoPictureUploadResponseBean jinLinBaoJieBoPictureUploadResponseBean) {
                    if (jinLinBaoJieBoPictureUploadResponseBean.getCode() == 0) {
                        final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                        if (val$okhttpCallback != null) {
                            val$okhttpCallback.onSuccess(jinLinBaoJieBoPictureUploadResponseBean);
                        }
                    }
                    else if (jinLinBaoJieBoPictureUploadResponseBean.getCode() == 20018) {
                        if (OkhttpManager.onErrorCallback != null) {
                            OkhttpManager.onErrorCallback.onError(-1, jinLinBaoJieBoPictureUploadResponseBean.getMsg());
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, jinLinBaoJieBoPictureUploadResponseBean.getMsg());
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void jinLinBaoLogin(String jinLinBaoSign, final String password, final OnOkhttpCallback onOkhttpCallback) {
        final JinLinBaoUserLoginRequestBean jinLinBaoUserLoginRequestBean = new JinLinBaoUserLoginRequestBean();
        jinLinBaoUserLoginRequestBean.setName(jinLinBaoSign);
        jinLinBaoUserLoginRequestBean.setPassword(password);
        jinLinBaoSign = getJinLinBaoSign(jinLinBaoUserLoginRequestBean);
        new JinLinBaoSign().get_sign(jinLinBaoUserLoginRequestBean);
        MyApplication.getDaggerReposifitComponent().getRequestApiJinLinBao().jinLinBaoLogin(jinLinBaoUserLoginRequestBean.getName(), jinLinBaoUserLoginRequestBean.getPassword(), jinLinBaoUserLoginRequestBean.getSn(), jinLinBaoUserLoginRequestBean.getCheck_money(), jinLinBaoUserLoginRequestBean.getTs(), jinLinBaoUserLoginRequestBean.getSign_type(), jinLinBaoSign).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JinLinBaoLoginResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u8fd1\u90bb\u5b9d\u767b\u5f55\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u8fd1\u90bb\u5b9d\u767b\u5f55\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final JinLinBaoLoginResponseBean jinLinBaoLoginRes) {
                if (jinLinBaoLoginRes.getCode() == 0) {
                    //XLog.e("\u8fd1\u90bb\u5b9d\u767b\u5f55\u6210\u529f");
                    RqFilePreference.getInstance().setJinLinBaoLoginRes(jinLinBaoLoginRes);
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        RqFilePreference.getInstance().setJINLINBAOGAOPAIYIAccount(jinLinBaoUserLoginRequestBean.getName());
                        RqFilePreference.getInstance().setJINLINBAOGAOPAIYIPwd(jinLinBaoUserLoginRequestBean.getPassword());
                        val$okhttpCallback.onSuccess(jinLinBaoLoginRes);
                    }
                }
                else {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u8fd1\u90bb\u5b9d\u767b\u5f55\u5931\u8d25: ");
                    sb.append(jinLinBaoLoginRes.getMsg());
                    ToastSoundUtil.wrongSoundToast(sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, jinLinBaoLoginRes.getMsg());
                    }
                }
            }
        }));
    }

    public static void jinLinBaoLogin2(String jinLinBaoSign, final OnOkhttpCallback onOkhttpCallback) {
        final JinLinBaoUserLogin2RequestBean jinLinBaoUserLogin2RequestBean = new JinLinBaoUserLogin2RequestBean();
        jinLinBaoUserLogin2RequestBean.setLogis_id(jinLinBaoSign);
        jinLinBaoSign = getJinLinBaoSign(jinLinBaoUserLogin2RequestBean);
        MyApplication.getDaggerReposifitComponent().getRequestApiJinLinBao().jinLinBaoLogin2(jinLinBaoUserLogin2RequestBean.getLogis_id(), jinLinBaoUserLogin2RequestBean.getTs(), jinLinBaoUserLogin2RequestBean.getSign_type(), jinLinBaoSign).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JinLinBaoLogin2ResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u8fd1\u90bb\u5b9d\u767b\u5f55\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final JinLinBaoLogin2ResponseBean jinLinBaoLogin2ResponseBean) {
                if (jinLinBaoLogin2ResponseBean.getCode() == 0) {
                    //XLog.e("\u8fd1\u90bb\u5b9d\u767b\u5f55\u6210\u529f");
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(jinLinBaoLogin2ResponseBean);
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-1, jinLinBaoLogin2ResponseBean.getMsg());
                }
            }
        }));
    }

    public static void jinLinBaoOcrTranshipDetail(String jinLinBaoSign, final String exp_code, final String sid, final String uid, final OnOkhttpCallback onOkhttpCallback) {
        final jinLinBaoOcrTranshipDetailRequestBean jinLinBaoOcrTranshipDetailRequestBean = new jinLinBaoOcrTranshipDetailRequestBean();
        jinLinBaoOcrTranshipDetailRequestBean.setLogis_id(jinLinBaoSign);
        jinLinBaoOcrTranshipDetailRequestBean.setSid(sid);
        jinLinBaoOcrTranshipDetailRequestBean.setUid(uid);
        jinLinBaoOcrTranshipDetailRequestBean.setExp_code(exp_code);
        jinLinBaoSign = getJinLinBaoSign(jinLinBaoOcrTranshipDetailRequestBean);
        MyApplication.getDaggerReposifitComponent().getRequestApiJinLinBao().jinLinBaoOcrTranshipDetail(jinLinBaoSign, jinLinBaoOcrTranshipDetailRequestBean.getLogis_id(), jinLinBaoOcrTranshipDetailRequestBean.getSn(), jinLinBaoOcrTranshipDetailRequestBean.getExp_code(), jinLinBaoOcrTranshipDetailRequestBean.getTs(), jinLinBaoOcrTranshipDetailRequestBean.getSid(), jinLinBaoOcrTranshipDetailRequestBean.getUid(), jinLinBaoOcrTranshipDetailRequestBean.getSign_type()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<jinLinBaoOcrTranshipDetailResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u6d3e\u4ef6\u7b7e\u6536-\u67e5\u8be2\u5355\u53f7\u4fe1\u606f ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final jinLinBaoOcrTranshipDetailResponseBean jinLinBaoOcrTranshipDetailResponseBean) {
                if (jinLinBaoOcrTranshipDetailResponseBean.getCode() == 0) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(jinLinBaoOcrTranshipDetailResponseBean);
                    }
                }
                else if (jinLinBaoOcrTranshipDetailResponseBean.getCode() == 20018) {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, jinLinBaoOcrTranshipDetailResponseBean.getMsg());
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, jinLinBaoOcrTranshipDetailResponseBean.getMsg());
                }
            }
        }));
    }

    public static void jinLinBaoPickUpBatchPickUp(final String logis_id, final String s, final String uid, final String s2, final String s3, final OnOkhttpCallback onOkhttpCallback) {
        final jinLinBaoPickupBatchPickupRequestBean jinLinBaoPickupBatchPickupRequestBean = new jinLinBaoPickupBatchPickupRequestBean();
        jinLinBaoPickupBatchPickupRequestBean.setLogis_id(logis_id);
        jinLinBaoPickupBatchPickupRequestBean.setUid(uid);
        jinLinBaoPickupBatchPickupRequestBean.setData(String.format("[{\"exp_code\":\"%s\",\"order_pic\":\"%s\",\"face_pic\": \"%s\"}]", s, s2, s3));
        MyApplication.getDaggerReposifitComponent().getRequestApiJinLinBao().jinLinBaoPickupBatchPickup(jinLinBaoPickupBatchPickupRequestBean.getUid(), jinLinBaoPickupBatchPickupRequestBean.getLogis_id(), jinLinBaoPickupBatchPickupRequestBean.getData()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<jinLinBaoPickupBatchPickupResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u8fd1\u90bb\u5b9d\u9ad8\u62cd\u4eea\u53d6\u4ef6\u4fe1\u606f ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final jinLinBaoPickupBatchPickupResponseBean jinLinBaoPickupBatchPickupResponseBean) {
                if (jinLinBaoPickupBatchPickupResponseBean.getCode() == 0 && ((jinLinBaoPickupBatchPickupResponseBean.BodyBean)jinLinBaoPickupBatchPickupResponseBean.getBody().get(0)).getCode() == 0) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(jinLinBaoPickupBatchPickupResponseBean);
                    }
                }
                else if (jinLinBaoPickupBatchPickupResponseBean.getCode() == 20018) {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, jinLinBaoPickupBatchPickupResponseBean.getMsg());
                    }
                }
                else if (((jinLinBaoPickupBatchPickupResponseBean.BodyBean)jinLinBaoPickupBatchPickupResponseBean.getBody().get(0)).getCode() != 0) {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, ((jinLinBaoPickupBatchPickupResponseBean.BodyBean)jinLinBaoPickupBatchPickupResponseBean.getBody().get(0)).getDesc());
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, jinLinBaoPickupBatchPickupResponseBean.getMsg());
                }
            }
        }));
    }

    public static void jinLinBaoPickUpFreeConfirm(String jinLinBaoSign, final String count, final String s, final String sid, final String uid, final String courier_uid, final OnOkhttpCallback onOkhttpCallback) {
        final jinLinBaoPickUpFreeConfirmRequestBean jinLinBaoPickUpFreeConfirmRequestBean = new jinLinBaoPickUpFreeConfirmRequestBean();
        jinLinBaoPickUpFreeConfirmRequestBean.setLogis_id(jinLinBaoSign);
        jinLinBaoPickUpFreeConfirmRequestBean.setCount(count);
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(",");
        jinLinBaoPickUpFreeConfirmRequestBean.setOrder_ids(sb.toString());
        jinLinBaoPickUpFreeConfirmRequestBean.setSid(sid);
        jinLinBaoPickUpFreeConfirmRequestBean.setUid(uid);
        jinLinBaoPickUpFreeConfirmRequestBean.setCourier_uid(courier_uid);
        jinLinBaoSign = getJinLinBaoSign(jinLinBaoPickUpFreeConfirmRequestBean);
        MyApplication.getDaggerReposifitComponent().getRequestApiJinLinBao().jinLinBaoPickUpFreeConfirm(jinLinBaoSign, jinLinBaoPickUpFreeConfirmRequestBean.getLogis_id(), jinLinBaoPickUpFreeConfirmRequestBean.getSn(), jinLinBaoPickUpFreeConfirmRequestBean.getCount(), jinLinBaoPickUpFreeConfirmRequestBean.getImage_data(), jinLinBaoPickUpFreeConfirmRequestBean.getOrder_ids(), jinLinBaoPickUpFreeConfirmRequestBean.getTs(), jinLinBaoPickUpFreeConfirmRequestBean.getUid(), jinLinBaoPickUpFreeConfirmRequestBean.getSid(), jinLinBaoPickUpFreeConfirmRequestBean.getSign_type(), jinLinBaoPickUpFreeConfirmRequestBean.getCourier_uid()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<jinLinBaoPickUpFreeConfirmResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u6d3e\u4ef6\u7b7e\u6536-\u67e5\u8be2\u5355\u53f7\u4fe1\u606f ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final jinLinBaoPickUpFreeConfirmResponseBean jinLinBaoPickUpFreeConfirmResponseBean) {
                if (jinLinBaoPickUpFreeConfirmResponseBean.getCode() == 0) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(jinLinBaoPickUpFreeConfirmResponseBean);
                    }
                }
                else if (jinLinBaoPickUpFreeConfirmResponseBean.getCode() == 20018) {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, jinLinBaoPickUpFreeConfirmResponseBean.getMsg());
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, jinLinBaoPickUpFreeConfirmResponseBean.getMsg());
                }
            }
        }));
    }

    public static void jinLinBaoPickUpSearch(String jinLinBaoSign, final String exp_code, final String sid, final String uid, final OnOkhttpCallback onOkhttpCallback) {
        final jinLinBaoPickUpSearchRequestBean jinLinBaoPickUpSearchRequestBean = new jinLinBaoPickUpSearchRequestBean();
        jinLinBaoPickUpSearchRequestBean.setLogis_id(jinLinBaoSign);
        jinLinBaoPickUpSearchRequestBean.setSid(sid);
        jinLinBaoPickUpSearchRequestBean.setUid(uid);
        jinLinBaoPickUpSearchRequestBean.setExp_code(exp_code);
        jinLinBaoSign = getJinLinBaoSign(jinLinBaoPickUpSearchRequestBean);
        MyApplication.getDaggerReposifitComponent().getRequestApiJinLinBao().jinLinBaoPickupSearch(jinLinBaoSign, jinLinBaoPickUpSearchRequestBean.getLogis_id(), jinLinBaoPickUpSearchRequestBean.getSn(), jinLinBaoPickUpSearchRequestBean.getExp_code(), jinLinBaoPickUpSearchRequestBean.getTs(), jinLinBaoPickUpSearchRequestBean.getSid(), jinLinBaoPickUpSearchRequestBean.getUid(), jinLinBaoPickUpSearchRequestBean.getSign_type()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<jinLinBaoPickupSearchResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u6d3e\u4ef6\u7b7e\u6536-\u67e5\u8be2\u5355\u53f7\u4fe1\u606f ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final jinLinBaoPickupSearchResponseBean jinLinBaoPickupSearchResponseBean) {
                if (jinLinBaoPickupSearchResponseBean.getCode() == 0) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(jinLinBaoPickupSearchResponseBean);
                    }
                }
                else if (jinLinBaoPickupSearchResponseBean.getCode() == 20018) {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, jinLinBaoPickupSearchResponseBean.getMsg());
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, jinLinBaoPickupSearchResponseBean.getMsg());
                }
            }
        }));
    }

    public static void jinLinBaoPickupUnPickup(String jinLinBaoSign, final String exp_code, final String sid, final String uid, final OnOkhttpCallback onOkhttpCallback) {
        final jinLinBaoPickupUnPickupRequestBean jinLinBaoPickupUnPickupRequestBean = new jinLinBaoPickupUnPickupRequestBean();
        jinLinBaoPickupUnPickupRequestBean.setLogis_id(jinLinBaoSign);
        jinLinBaoPickupUnPickupRequestBean.setSid(sid);
        jinLinBaoPickupUnPickupRequestBean.setUid(uid);
        jinLinBaoPickupUnPickupRequestBean.setExp_code(exp_code);
        jinLinBaoSign = getJinLinBaoSign(jinLinBaoPickupUnPickupRequestBean);
        MyApplication.getDaggerReposifitComponent().getRequestApiJinLinBao().jinLinBaoPickupUnPickup(jinLinBaoSign, jinLinBaoPickupUnPickupRequestBean.getLogis_id(), jinLinBaoPickupUnPickupRequestBean.getSn(), jinLinBaoPickupUnPickupRequestBean.getExp_code(), jinLinBaoPickupUnPickupRequestBean.getTs(), jinLinBaoPickupUnPickupRequestBean.getSid(), jinLinBaoPickupUnPickupRequestBean.getPsize(), jinLinBaoPickupUnPickupRequestBean.getUid(), jinLinBaoPickupUnPickupRequestBean.getPage(), jinLinBaoPickupUnPickupRequestBean.getSign_type()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<jinLinBaoPickupUnPickupResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u6d3e\u4ef6\u7b7e\u6536-\u67e5\u8be2\u5355\u53f7\u4fe1\u606f ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final jinLinBaoPickupUnPickupResponseBean jinLinBaoPickupUnPickupResponseBean) {
                if (jinLinBaoPickupUnPickupResponseBean.getCode() == 0) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(jinLinBaoPickupUnPickupResponseBean);
                    }
                }
                else if (jinLinBaoPickupUnPickupResponseBean.getCode() == 20018) {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, jinLinBaoPickupUnPickupResponseBean.getMsg());
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, jinLinBaoPickupUnPickupResponseBean.getMsg());
                }
            }
        }));
    }

    public static void jinlinbaoPickUp(String jinLinBaoSign, final String sid, final String consignee_phone, final String uid, final String logis_id, final String s, final byte[] array, final OnOkhttpCallback<jinLinBaoPickUpResponseBean> onOkhttpCallback) {
        Label_0071: {
            if (array == null) {
                break Label_0071;
            }
            while (true) {
                try {
                    final RequestBody create = RequestBody.create(MediaType.parse("image/png"), array);
                    final StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(s);
                    sb.append(".jpg");
                    MultipartBody.Part part  = MultipartBody.Part.createFormData("file", sb.toString(), create);
                    while (true) {
                        final jinLinBaoPickUpRequestBean jinLinBaoPickUpRequestBean = new jinLinBaoPickUpRequestBean();
                        jinLinBaoPickUpRequestBean.setLogis_id(logis_id);
                        jinLinBaoPickUpRequestBean.setOrder_id(jinLinBaoSign);
                        jinLinBaoPickUpRequestBean.setSid(sid);
                        jinLinBaoPickUpRequestBean.setConsignee_phone(consignee_phone);
                        jinLinBaoPickUpRequestBean.setUid(uid);
                        jinLinBaoSign = getJinLinBaoSign(jinLinBaoPickUpRequestBean);
                        MyApplication.getDaggerReposifitComponent().getRequestApiJinLinBao().jinLinBaoPickUp(jinLinBaoSign, jinLinBaoPickUpRequestBean.getLogis_id(), jinLinBaoPickUpRequestBean.getSn(), jinLinBaoPickUpRequestBean.getOrder_id(), jinLinBaoPickUpRequestBean.getTs(), jinLinBaoPickUpRequestBean.getSid(), jinLinBaoPickUpRequestBean.getConsignee_phone(), jinLinBaoPickUpRequestBean.getUid(), jinLinBaoPickUpRequestBean.getSign_type(), part).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<jinLinBaoPickUpResponseBean>() {
                            @Override
                            public void onFailure(final int n, final String s) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("\u6d3e\u4ef6\u7b7e\u6536-\u7b7e\u6536\u5931\u8d25:");
                                sb.append(n);
                                sb.append("  ");
                                sb.append(s);
                                //XLog.e(sb.toString());
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("\u6d3e\u4ef6\u7b7e\u6536-\u7b7e\u6536\u5931\u8d25:");
                                sb2.append(s);
                                ToastSoundUtil.wrongSoundToast(sb2.toString());
                                if (OkhttpManager.onErrorCallback != null) {
                                    OkhttpManager.onErrorCallback.onError(n, s);
                                }
                            }

                            public void onSuccess(final jinLinBaoPickUpResponseBean jinLinBaoPickUpResponseBean) {
                                if (jinLinBaoPickUpResponseBean.getCode() == 0) {
                                    //XLog.e("\u8fd1\u90bb\u5b9d\u6d3e\u4ef6\u7b7e\u6536-\u7b7e\u6536\u6210\u529f");
                                    final OnOkhttpCallback val$okhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                                    if (val$okhttpCallback != null) {
                                        val$okhttpCallback.onSuccess(jinLinBaoPickUpResponseBean);
                                    }
                                }
                                else {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("\u6d3e\u4ef6\u7b7e\u6536-\u7b7e\u6536\u5931\u8d25: ");
                                    sb.append(jinLinBaoPickUpResponseBean.getMsg());
                                    ToastSoundUtil.wrongSoundToast(sb.toString());
                                    if (OkhttpManager.onErrorCallback != null) {
                                        OkhttpManager.onErrorCallback.onError(-1, jinLinBaoPickUpResponseBean.getMsg());
                                    }
                                }
                            }
                        }));
                        return;
                        /*final Exception ex;
                        ex.printStackTrace();
                        return;
                        MultipartBody.Part part1 = MultipartBody.Part.createFormData("", "");
                        continue;*/
                    }
                }
                catch (Exception ex) {
                    continue;
                }
                //break;
            }
        }
    }

    public static void jinlinbaoPickUpConfirm(String jinLinBaoSign, final String sid, final String amount, final String charge_way, final String note, final String uid, final String logis_id, final String s, final byte[] array, final OnOkhttpCallback<jinLinBaoPickUpConfirmResponseBean> onOkhttpCallback) {
        Label_0071: {
            if (array == null) {
                break Label_0071;
            }
            while (true) {
                try {
                    final RequestBody create = RequestBody.create(MediaType.parse("image/png"), array);
                    final StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(s);
                    sb.append(".jpg");
                    MultipartBody.Part part = MultipartBody.Part.createFormData("file", sb.toString(), create);
                    while (true) {
                        final jinLinBaoPickUpConfirmRequestBean jinLinBaoPickUpConfirmRequestBean = new jinLinBaoPickUpConfirmRequestBean();
                        jinLinBaoPickUpConfirmRequestBean.setAmount(amount);
                        jinLinBaoPickUpConfirmRequestBean.setCharge_way(charge_way);
                        jinLinBaoPickUpConfirmRequestBean.setLogis_id(logis_id);
                        jinLinBaoPickUpConfirmRequestBean.setNote(note);
                        jinLinBaoPickUpConfirmRequestBean.setOrder_id(jinLinBaoSign);
                        jinLinBaoPickUpConfirmRequestBean.setSid(sid);
                        jinLinBaoPickUpConfirmRequestBean.setUid(uid);
                        jinLinBaoSign = getJinLinBaoSign(jinLinBaoPickUpConfirmRequestBean);
                        MyApplication.getDaggerReposifitComponent().getRequestApiJinLinBao().jinLinBaoPickUpConfirm(jinLinBaoSign, jinLinBaoPickUpConfirmRequestBean.getLogis_id(), jinLinBaoPickUpConfirmRequestBean.getSn(), jinLinBaoPickUpConfirmRequestBean.getOrder_id(), jinLinBaoPickUpConfirmRequestBean.getTs(), jinLinBaoPickUpConfirmRequestBean.getAmount(), jinLinBaoPickUpConfirmRequestBean.getSid(), jinLinBaoPickUpConfirmRequestBean.getUid(), jinLinBaoPickUpConfirmRequestBean.getCharge_way(), jinLinBaoPickUpConfirmRequestBean.getNote(), jinLinBaoPickUpConfirmRequestBean.getSign_type(), part).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<jinLinBaoPickUpConfirmResponseBean>() {
                            @Override
                            public void onFailure(final int n, final String s) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("\u5feb\u9012\u53d6\u4ef6-\u7b7e\u6536\u5931\u8d25:");
                                sb.append(n);
                                sb.append("  ");
                                sb.append(s);
                                //XLog.e(sb.toString());
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("\u5feb\u9012\u53d6\u4ef6-\u7b7e\u6536\u5931\u8d25:");
                                sb2.append(s);
                                ToastSoundUtil.wrongSoundToast(sb2.toString());
                                if (OkhttpManager.onErrorCallback != null) {
                                    OkhttpManager.onErrorCallback.onError(n, s);
                                }
                            }

                            public void onSuccess(final jinLinBaoPickUpConfirmResponseBean jinLinBaoPickUpConfirmResponseBean) {
                                if (jinLinBaoPickUpConfirmResponseBean.getCode() == 0) {
                                    //XLog.e("\u8fd1\u90bb\u5b9d\u6d3e\u4ef6\u7b7e\u6536-\u7b7e\u6536\u6210\u529f");
                                    final OnOkhttpCallback val$okhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                                    if (val$okhttpCallback != null) {
                                        val$okhttpCallback.onSuccess(jinLinBaoPickUpConfirmResponseBean);
                                    }
                                }
                                else {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("\u5feb\u9012\u53d6\u4ef6-\u7b7e\u6536\u5931\u8d25: ");
                                    sb.append(jinLinBaoPickUpConfirmResponseBean.getMsg());
                                    ToastSoundUtil.wrongSoundToast(sb.toString());
                                    if (OkhttpManager.onErrorCallback != null) {
                                        OkhttpManager.onErrorCallback.onError(-1, jinLinBaoPickUpConfirmResponseBean.getMsg());
                                    }
                                }
                            }
                        }));
                        return;
                        /*MultipartBody.Part = MultipartBody.Part.createFormData("", "");
                        continue;*/
                    }
                   /* final Exception ex;
                    ex.printStackTrace();*/
                }
                catch (Exception ex) {
                    continue;
                }
                //break;
            }
        }
    }

    public static void juShuiTan(final String juShuiTanToken, final OnOkhttpCallback onOkhttpCallback) {
        RqFilePreference.getInstance().setJuShuiTanToken(juShuiTanToken);
        RqFilePreference.getInstance().setJUSHUITANAccount(juShuiTanToken);
        onOkhttpCallback.onSuccess(juShuiTanToken);
    }

    public static void kdcsCheckGatwwayBillcodeInfor(final KDCSCheckOutLibraryBillCodeInforBean kdcsCheckOutLibraryBillCodeInforBean, final OnOkhttpCallback onOkhttpCallback) {
        final KDCSLoginResponseBean kdcsLoginInfor = RqFilePreference.getInstance().getKDCSLoginInfor();
        MyApplication.getDaggerReposifitComponent().getRequestApiKDCS().checkGatwwayBillcodeInfor(JsonUtil.getJsonStringByGson(kdcsCheckOutLibraryBillCodeInforBean), "getOutEnterBillInfo", "1", kdcsLoginInfor.getAccess_token(), kdcsLoginInfor.getOpenid(), kdcsLoginInfor.getUser_id()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<ApiDataKDCSBean<KDCSCheckResponseBean>>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u5feb\u9012\u8d85\u5e02\u67e5\u8be2\u51fa\u5e93\u5355\u53f7\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u5feb\u9012\u8d85\u5e02\u67e5\u8be2\u51fa\u5e93\u5355\u53f7\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.displayToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, s);
                }
            }

            public void onSuccess(final ApiDataKDCSBean<KDCSCheckResponseBean> apiDataKDCSBean) {
                if (onOkhttpCallback != null && apiDataKDCSBean != null) {
                    //added by wxw
                    if (mOnOkhttpCallback != null&&apiDataKDCSBean.isStatus() && apiDataKDCSBean.getStatusCode().equals("200")) {
                        mOnOkhttpCallback.onSuccess(apiDataKDCSBean.getResult());
                    }
                    if (apiDataKDCSBean.isStatus() && apiDataKDCSBean.getStatusCode().equals("200")) {
                        //XLog.e("\u5feb\u9012\u8d85\u5e02\u67e5\u8be2\u51fa\u5e93\u5355\u53f7\u6210\u529f:");
                        onOkhttpCallback.onSuccess(apiDataKDCSBean.getResult());
                        return;
                    }
                    if (OkhttpManager.onErrorCallback != null) {
                        if (apiDataKDCSBean.getStatusCode().equals("S205")) {
                            OkhttpManager.kdcsRefreshToken((OnOkhttpCallback)new OnOkhttpCallback() {
                                @Override
                                public void onSuccess(final Object o) {
                                    OkhttpManager.kdcsCheckGatwwayBillcodeInfor(kdcsCheckOutLibraryBillCodeInforBean, onOkhttpCallback);
                                }
                            });
                            return;
                        }
                        OkhttpManager.onErrorCallback.onError(-2, apiDataKDCSBean.getMessage());
                    }
                }
            }
        }));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void kdcsLogin(String s, String imei, final OnOkhttpCallback onOkhttpCallback, final OnOkhttpCallbackError onOkhttpCallbackError) {
        String tuxiAccount =s;
        String tuxiPass =imei;
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(":");
        sb.append(imei);
        s = RsaUtil.encryptDataByPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1urQo4aFS7kIuCsHSnAr\nGYftEVoXTBosCQG+sCPDv6owvITvaMy5usPiI5r155iYt/PLqE823nT5OqEgTW6Y\n1zhLHWrEkf2TR003+moIoF8st5iOhSZvsGwHOciL5tur9ur0xoXhxukK4YjZliHY\npZVJrV7PPvmjoUbdIr1IjQf8YTXtwGYh4Ic5tEARejSfxDFDSs5V5kcVRoLXCPFt\nTResWg2CseO0RoxCM/uBQp4ZTBRbuKDQxUrsX0BfvzL85OaYDSKZeoFNrDkeji6v\nGhFjRRD4IMdGuLImhC8IvcsCA9GFcgX3zy55UYLterdwgBSHueSTrwq4psp9DLu/\nAQIDAQAB\n", sb.toString().getBytes());
        if (StringUtil.isNotEmpty(s)) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Secret ");
            sb2.append(s.replace("\n", ""));
            s = sb2.toString();
            imei = SystemUtil.getIMEI((Context)MyApplication.baseApp);
            MyApplication.getDaggerReposifitComponent().getRequestApiLoginKDCS().loginKDCS(s, "application/json", imei).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<KDCSLoginResponseBean>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u5feb\u9012\u8d85\u5e02\u767b\u5f55\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("\u5feb\u9012\u8d85\u5e02\u767b\u5f55\u5931\u8d25 ");
                    sb2.append(s);
                    ToastSoundUtil.wrongSoundToast(sb2.toString());
                }

                public void onSuccess(final KDCSLoginResponseBean kdcsLoginInfor) {
                    if (onOkhttpCallback != null && kdcsLoginInfor != null) {
                        RqFilePreference.getInstance().setKDCSLoginInfor(kdcsLoginInfor);
                        final StringBuilder sb = new StringBuilder();
                        sb.append("\u5feb\u9012\u8d85\u5e02\u767b\u5f55\u6210\u529f:");
                        sb.append(kdcsLoginInfor.getAccess_token());
                        //XLog.e(sb.toString());
                        onOkhttpCallback.onSuccess(kdcsLoginInfor);
                        OkhttpManager.kdcsQueryStaffAndStoreInfor();
                        //added by wxw
                        if (mOnOkhttpCallback != null) {
                            RqFilePreference.getInstance().setKUAIDICAOSHIAccount(tuxiAccount);
                            RqFilePreference.getInstance().setKUAIDICAOSHIPwd(tuxiPass);
                            mOnOkhttpCallback.onSuccess(kdcsLoginInfor);
                        }
                    } else {
                        if (OkhttpManager.onErrorCallback != null) {
                            OkhttpManager.onErrorCallback.onError(-2, "登录失败");
                        }
                    }
                }
            }));
        }
    }

    public static void kdcsOutLibrary(final KDCSOutLibraryData kdcsOutLibraryData, final OnOkhttpCallback onOkhttpCallback) {
        final KDCSLoginResponseBean kdcsLoginInfor = RqFilePreference.getInstance().getKDCSLoginInfor();
        MyApplication.getDaggerReposifitComponent().getRequestApiKDCS().kdcsOutLibrary(JsonUtil.getJsonStringNull(kdcsOutLibraryData.getData()), "orderSaveService", "3", kdcsLoginInfor.getAccess_token(), kdcsLoginInfor.getOpenid(), kdcsLoginInfor.getUser_id()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<ApiDataKDCSBean<KDCSOutLibraryResponseBean>>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u5feb\u9012\u8d85\u5e02\u51fa\u5e93\u5355\u53f7\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u51fa\u5e93\u5355\u53f7\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    if (s.contains("\u7528\u6237\u4fe1\u606f") && !OkhttpManager.kdcsResetLogin) {
                        OkhttpManager.kdcsResetLogin = true;
                        OkhttpManager.kdcsLogin(RqFilePreference.getInstance().getLoginUsername(), RqFilePreference.getInstance().getLoginPassword(), (OnOkhttpCallback)new OnOkhttpCallback() {
                            @Override
                            public void onSuccess(final Object o) {
                                OkhttpManager.kdcsOutLibrary(kdcsOutLibraryData, onOkhttpCallback);
                            }
                        }, null);
                        return;
                    }
                    OkhttpManager.onErrorCallback.onError(-1, s);
                }
            }

            public void onSuccess(final ApiDataKDCSBean<KDCSOutLibraryResponseBean> apiDataKDCSBean) {
                if (onOkhttpCallback != null && apiDataKDCSBean != null) {
                    if (apiDataKDCSBean.isStatus() && apiDataKDCSBean.getStatusCode().equals("200")) {
                        //XLog.e("\u5feb\u9012\u8d85\u5e02\u51fa\u5e93\u6210\u529f:");
                        onOkhttpCallback.onSuccess(apiDataKDCSBean.getResult());
                        OkhttpManager.kdcsResetLogin = false;
                        return;
                    }
                    if (OkhttpManager.onErrorCallback != null && apiDataKDCSBean.getStatusCode().equals("S205")) {
                        OkhttpManager.kdcsRefreshToken((OnOkhttpCallback)new OnOkhttpCallback() {
                            @Override
                            public void onSuccess(final Object o) {
                                OkhttpManager.kdcsOutLibrary(kdcsOutLibraryData, onOkhttpCallback);
                            }
                        });
                    }
                }
            }
        }));
    }

    public static void kdcsQueryStaffAndStoreInfor() {
        final KDCSLoginResponseBean kdcsLoginInfor = RqFilePreference.getInstance().getKDCSLoginInfor();
        MyApplication.getDaggerReposifitComponent().getRequestApiKDCS().queryStaffAndStoreInfor(JsonUtil.getJsonStringByGson(new KDCSQueryStaffAndStoreBean(kdcsLoginInfor.getStaff_code())), "queryStaffAndStoreByStaffCode", "2", kdcsLoginInfor.getAccess_token(), kdcsLoginInfor.getOpenid(), kdcsLoginInfor.getUser_id()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<ApiDataKDCSBean<KDCSQueryStaffAndStoreResponseBean>>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u5feb\u9012\u8d85\u5e02\u67e5\u8be2\u7ad9\u70b9\u4fe1\u606f\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u67e5\u8be2\u7ad9\u70b9\u4fe1\u606f\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, s);
                }
            }

            public void onSuccess(final ApiDataKDCSBean<KDCSQueryStaffAndStoreResponseBean> apiDataKDCSBean) {
                if (apiDataKDCSBean != null) {
                    if (apiDataKDCSBean.isStatus() && apiDataKDCSBean.getStatusCode().equals("200") && apiDataKDCSBean.getResult() != null) {
                        RqFilePreference.getInstance().setKDCSQueryStaffAndStore((KDCSQueryStaffAndStoreResponseBean)apiDataKDCSBean.getResult());
                        //XLog.e("\u5feb\u9012\u8d85\u5e02\u67e5\u8be2\u7ad9\u70b9\u4fe1\u606f\u6210\u529f:");
                        return;
                    }
                    if (OkhttpManager.onErrorCallback != null) {
                        if (apiDataKDCSBean.getStatusCode().equals("S205")) {
                            OkhttpManager.onErrorCallback.onError(-1, apiDataKDCSBean.getMessage());
                            return;
                        }
                        OkhttpManager.onErrorCallback.onError(-2, apiDataKDCSBean.getMessage());
                    }
                }
            }
        }));
    }

    public static void kdcsRefreshToken(final OnOkhttpCallback onOkhttpCallback) {
        final KDCSLoginResponseBean kdcsLoginInfor = RqFilePreference.getInstance().getKDCSLoginInfor();
        if (kdcsLoginInfor != null && StringUtil.isNotEmpty(kdcsLoginInfor.getRefresh_token())) {
            MyApplication.getDaggerReposifitComponent().getRequestApiLoginKDCS().refreshToken(kdcsLoginInfor.getRefresh_token()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<KDCSLoginResponseBean>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u5feb\u9012\u8d85\u5e02\u5237\u65b0token\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("\u5237\u65b0token\u5931\u8d25 ");
                    sb2.append(s);
                    ToastSoundUtil.wrongSoundToast(sb2.toString());
                    OkhttpManager.mOnOkhttpCallbackError.onError("\u5feb\u9012\u8d85\u5e02\u5237\u65b0token \u5931\u8d25");
                    if (OkhttpManager.onErrorCallback != null) {
                        if (StringUtil.isNotEmpty(s) && s.contains("\u65e0\u6548\u7684\u8bb8\u53ef")) {
                            OkhttpManager.onErrorCallback.onError(-1, "\u65e0\u6548\u7684\u8bb8\u53ef");
                            return;
                        }
                        OkhttpManager.onErrorCallback.onError(-2, s);
                    }
                }

                public void onSuccess(final KDCSLoginResponseBean kdcsLoginInfor) {
                    if (onOkhttpCallback != null && kdcsLoginInfor != null && kdcsLoginInfor.getAccess_token() != null) {
                        RqFilePreference.getInstance().setKDCSLoginInfor(kdcsLoginInfor);
                        final StringBuilder sb = new StringBuilder();
                        sb.append("\u5feb\u9012\u8d85\u5e02\u5237\u65b0token\u6210\u529f:");
                        sb.append(kdcsLoginInfor.getAccess_token());
                        //XLog.e(sb.toString());
                        onOkhttpCallback.onSuccess(kdcsLoginInfor);
                        return;
                    }
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, "\u5feb\u9012\u8d85\u5e02\u5237\u65b0token \u5931\u8d25");
                    }
                }
            }));
        }
    }
    public static void kuaibaoDeliveryStorageApi(final KuaiBaoDeliveryStorageBean kuaiBaoDeliveryStorageBean, final OnOkhttpCallback onOkhttpCallback) {
        final StringBuilder sb = new StringBuilder();
        sb.append("session_id=");
        sb.append(kuaiBaoDeliveryStorageBean.getSession_id());
        final String string = sb.toString();
        String sign = SignData.getNativeSign(kuaiBaoDeliveryStorageBean.getTs(), "/v1/dak/ScanCode/deliveryStorage", kuaiBaoDeliveryStorageBean.getApp_id(), kuaiBaoDeliveryStorageBean.getSession_id(), OkhttpManager.appversion);
        kuaiBaoDeliveryStorageBean.setSign(sign);
        MyApplication.getDaggerReposifitComponent().getRequestApiKuaiBao().kuaibaoDeliveryStorage(kuaiBaoDeliveryStorageBean.getApp_id(), kuaiBaoDeliveryStorageBean.getTs(), kuaiBaoDeliveryStorageBean.getSign(), kuaiBaoDeliveryStorageBean.getData(), OkhttpManager.version, OkhttpManager.appversion, kuaiBaoDeliveryStorageBean.getApp_id(), OkhttpManager.pname, string).enqueue((Callback)new ApiCallbackKuaibao((ApiCallbackKuaibao.HttpCallback)new ApiCallbackKuaibao.HttpCallback<ApiDataKuaibaoBean<Object>>() {
            @Override
            public void onFailure(int n, final String s) {
                try {
                        /*final StringBuilder sb = new StringBuilder();
                        sb.append("\u5feb\u5b9d\u51fa\u5e93\u5931\u8d25:");
                        sb.append(n);
                        sb.append("  ");
                        sb.append(s);*/
                    //////XLog.e(sb.toString());
                    if (OkhttpManager.onErrorCallback == null) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("\u5feb\u5b9d\u51fa\u5e93\u5931\u8d25 ");//快宝出库失败
                        sb2.append(s);
                        ToastSoundUtil.wrongSoundToast(sb2.toString());
                        return;
                    }
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    return;
                }
            }

            @Override
            public void onSuccess(final ApiDataKuaibaoBean<Object> o) {
                Log.e(TAG,"kuaibaoDeliveryStorageApi onSuccess");
                //////XLog.e("\u5feb\u5b9d\u51fa\u5e93\u6210\u529f");
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(o);
                }
            }
        }));
    }

    public static void kuaibaoGetStationInforApi(final KuaiBaoGetStationInforBean kuaiBaoGetStationInforBean, String string) {
        final StringBuilder sb = new StringBuilder();
        sb.append("session_id=");
        sb.append(string);
        string = sb.toString();
        kuaiBaoGetStationInforBean.setSign(SignData.getNativeSign(kuaiBaoGetStationInforBean.getTs(), "/v1/YzApp/getInfo", kuaiBaoGetStationInforBean.getApp_id(), kuaiBaoGetStationInforBean.getSession_id(), OkhttpManager.appversion));
        MyApplication.getDaggerReposifitComponent().getRequestApiKuaiBao().kuaibaoGetStationInfor(kuaiBaoGetStationInforBean.getDid(), kuaiBaoGetStationInforBean.getApp_id(), kuaiBaoGetStationInforBean.getTs(), kuaiBaoGetStationInforBean.getSign(), kuaiBaoGetStationInforBean.getData(), OkhttpManager.version, OkhttpManager.appversion, OkhttpManager.pname, string).enqueue((Callback)new ApiCallbackKuaibao((ApiCallbackKuaibao.HttpCallback)new ApiCallbackKuaibao.HttpCallback<KuaiBaoGetStationInforResponseBean>() {
            @Override
            public void onFailure(int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u5feb\u5b9d\u83b7\u53d6\u7ad9\u70b9\u4fe1\u606f\u5931\u8d25:");//快宝获取站点信息失败
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    if (n == 1005) {
                        n = -1;
                    }
                    else {
                        n = -2;
                    }
                    OkhttpManager.onErrorCallback.onError(n, s);
                    return;
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u5feb\u5b9d\u83b7\u53d6\u7ad9\u70b9\u4fe1\u606f\u5931\u8d25 ");//快宝获取站点信息失败
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
            }

            public void onSuccess(final KuaiBaoGetStationInforResponseBean kuaibaoStationInfor) {
                //////XLog.e("\u5feb\u5b9d\u83b7\u53d6\u7ad9\u70b9\u4fe1\u606f\u6210\u529f");
                RqFilePreference.getInstance().setKuaibaoStationInfor(kuaibaoStationInfor);
            }
        }));
    }

    public static void kuaibaoGetUserUnPickUpListsApi(final KuaiBaoGetUserUnPickUpListsBean kuaiBaoGetUserUnPickUpListsBean, final OnOkhttpCallback onOkhttpCallback) {
        final StringBuilder sb = new StringBuilder();
        sb.append("session_id=");
        sb.append(kuaiBaoGetUserUnPickUpListsBean.getSession_id());
        final String string = sb.toString();
        kuaiBaoGetUserUnPickUpListsBean.setSign(SignData.getNativeSign(kuaiBaoGetUserUnPickUpListsBean.getTs(), "/v1/dak/ScanCode/getUserUnPickUpLists", kuaiBaoGetUserUnPickUpListsBean.getApp_id(), kuaiBaoGetUserUnPickUpListsBean.getSession_id(), OkhttpManager.appversion));
        MyApplication.getDaggerReposifitComponent().getRequestApiKuaiBao().kuaibaoGetUserUnPickUpLists(kuaiBaoGetUserUnPickUpListsBean.getApp_id(), kuaiBaoGetUserUnPickUpListsBean.getTs(), kuaiBaoGetUserUnPickUpListsBean.getSign(), kuaiBaoGetUserUnPickUpListsBean.getData(), OkhttpManager.version, OkhttpManager.appversion, kuaiBaoGetUserUnPickUpListsBean.getApp_id(), OkhttpManager.pname, string).enqueue((Callback)new ApiCallbackKuaibao((ApiCallbackKuaibao.HttpCallback)new ApiCallbackKuaibao.HttpCallback<KuaiBaoGetUserUnPickUpListsResponseBean>() {
            @Override
            public void onFailure(int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u5feb\u5b9d\u67e5\u8be2\u7528\u6237\u672a\u53d6\u5305\u88f9\u5217\u8868\u5931\u8d25:");//快宝查询用户未取包裹列表失败
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    if (n == 1005) {
                        n = -1;
                    }
                    else {
                        n = -2;
                    }
                    OkhttpManager.onErrorCallback.onError(n, s);
                    return;
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u5feb\u5b9d\u67e5\u8be2\u7528\u6237\u672a\u53d6\u5305\u88f9\u5217\u8868\u5931\u8d25 ");//快宝查询用户未取包裹列表失败
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
            }

            public void onSuccess(final KuaiBaoGetUserUnPickUpListsResponseBean kuaiBaoGetUserUnPickUpListsResponseBean) {
                //////XLog.e("\u5feb\u5b9d\u67e5\u8be2\u7528\u6237\u672a\u53d6\u5305\u88f9\u5217\u8868\u6210\u529f");
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {

                    val$okhttpCallback.onSuccess(kuaiBaoGetUserUnPickUpListsResponseBean);
                }


            }
        }));
    }

    public static void kuaibaoLoginApi(final KuaiBaoLoginBean kuaiBaoLoginBean, String string, final OnOkhttpCallback onOkhttpCallback) {
        final StringBuilder sb = new StringBuilder();
        sb.append("session_id=");
        sb.append(string);
        string = sb.toString();
        String sign = SignData.getNativeSign(kuaiBaoLoginBean.getTs(), "/v1/YzApp/phoneLogin", kuaiBaoLoginBean.getApp_id(), kuaiBaoLoginBean.getSession_id(), OkhttpManager.appversion);
        Log.e(TAG,"sign:"+sign);
        kuaiBaoLoginBean.setSign(sign);
        MyApplication.getDaggerReposifitComponent().getRequestApiKuaiBao().kuaibaoLogin(kuaiBaoLoginBean.getApp_id(), kuaiBaoLoginBean.getTs(), kuaiBaoLoginBean.getSign(), kuaiBaoLoginBean.getData(), OkhttpManager.version, OkhttpManager.appversion, OkhttpManager.pname, string).enqueue((Callback)new ApiCallbackKuaibao((ApiCallbackKuaibao.HttpCallback)new ApiCallbackKuaibao.HttpCallback<KuaiBaoLoginResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Failure:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Failure:");
                sb2.append(s);
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, s);
                }
                //ToastSoundUtil.wrongSoundToast(sb2.toString());
            }

            public void onSuccess(final KuaiBaoLoginResponseBean kuaibaoLoginInfor) {
                //////XLog.e("\u5feb\u5b9d\u767b\u5f55\u6210\u529f");
                RqFilePreference.getInstance().setKuaibaoLoginInfor(kuaibaoLoginInfor);
                RqFilePreference.getInstance().setKuaibaoSessionId(kuaibaoLoginInfor.getSession_id());
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    Log.e("wxwwww","--快宝--");
                    RqFilePreference.getInstance().setKUAIBAOAccount(kuaibaoLoginInfor.getConcat_phone());
                    RqFilePreference.getInstance().setKUAIBAOPwd(kuaiBaoLoginBean.getPass());
                    val$okhttpCallback.onSuccess(kuaibaoLoginInfor);
                }
                OkhttpManager.kuaibaoGetStationInforApi(new KuaiBaoGetStationInforBean(SystemUtil.getAppUUID((Context)MyApplication.baseApp), JsonUtil.getJsonStringByGson(new KuaiBaoGetStationInforBean.StationInforData(kuaibaoLoginInfor.getSession_id()))), kuaibaoLoginInfor.getSession_id());
            }
        }));
    }

    public static void kuaibaoQueryBillcodeInforApi(final KuaiBaoQueryBillcodeInforBean kuaiBaoQueryBillcodeInforBean, final OnOkhttpCallback onOkhttpCallback) {
        final StringBuilder sb = new StringBuilder();
        sb.append("session_id=");
        sb.append(kuaiBaoQueryBillcodeInforBean.getSession_id());
        final String string = sb.toString();
        kuaiBaoQueryBillcodeInforBean.setSign(SignData.getNativeSign(kuaiBaoQueryBillcodeInforBean.getTs(), "/v1/dak/ScanCode/expressV2", kuaiBaoQueryBillcodeInforBean.getApp_id(), kuaiBaoQueryBillcodeInforBean.getSession_id(), OkhttpManager.appversion));
        MyApplication.getDaggerReposifitComponent().getRequestApiKuaiBao().kuaibaoQueryBillcodeInfor(kuaiBaoQueryBillcodeInforBean.getApp_id(), kuaiBaoQueryBillcodeInforBean.getTs(), kuaiBaoQueryBillcodeInforBean.getSign(), kuaiBaoQueryBillcodeInforBean.getData(), OkhttpManager.version, OkhttpManager.appversion, kuaiBaoQueryBillcodeInforBean.getApp_id(), "androids", string).enqueue((Callback)new ApiCallbackKuaibao((ApiCallbackKuaibao.HttpCallback)new ApiCallbackKuaibao.HttpCallback<KuaiBaoQueryBillcodeInforResponseBean>() {
            @Override
            public void onFailure(int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u5feb\u5b9d\u67e5\u8be2\u5355\u53f7\u8be6\u7ec6\u4fe1\u606f\u5931\u8d25:");//快宝查询单号详细信息失败
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    if (n == 1005) {
                        n = -1;
                    }
                    else {
                        n = -2;
                    }
                    OkhttpManager.onErrorCallback.onError(n, s);
                    return;
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u5feb\u5b9d\u67e5\u8be2\u5355\u53f7\u8be6\u7ec6\u4fe1\u606f\u5931\u8d25 ");//快宝查询单号详细信息失败
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
            }

            public void onSuccess(final KuaiBaoQueryBillcodeInforResponseBean kuaiBaoQueryBillcodeInforResponseBean) {
                //////XLog.e("\u5feb\u5b9d\u67e5\u8be2\u5355\u53f7\u8be6\u7ec6\u4fe1\u606f\u6210\u529f");
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(kuaiBaoQueryBillcodeInforResponseBean);
                }

            }
        }));
    }


    public static void laiquGetBillInformation(final LaiquBillInfoBean laiquBillInfoBean, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiLaiqu().laiquGetBillInfo(laiquBillInfoBean, getLaiquLoginToken()).enqueue((Callback)new ApiCallbackLaiqu((ApiCallbackLaiqu.HttpCallback)new ApiCallbackLaiqu.HttpCallback<LaiquBillInfoResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u6765\u53d6\u5355\u53f7\u83b7\u53d6\u6536\u8d27\u4eba\u4fe1\u606f\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                ////XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final LaiquBillInfoResponseBean laiquBillInfoResponseBean) {
                //////XLog.e("\u6765\u53d6\u5355\u53f7\u83b7\u53d6\u6536\u8d27\u4eba\u4fe1\u606f\u6210\u529f");
                if (laiquBillInfoResponseBean != null) {
                    final OnOkhttpCallback val$onOkhttpCallback = onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(laiquBillInfoResponseBean);
                    }
                }
            }
        }));
    }

    public static void laiquOutLibrary(final LaiquOutLibraryBean laiquOutLibraryBean, final OnOkhttpCallback<LaiquOutLibraryResponseBean> onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiSplaiqu().laiquOutLibrary(laiquOutLibraryBean, getLaiquLoginToken()).enqueue((Callback)new ApiCallbackLaiqu((ApiCallbackLaiqu.HttpCallback)new ApiCallbackLaiqu.HttpCallback<LaiquOutLibraryResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                //ToastSoundUtil.displayToast("\u5305\u88f9\u51fa\u5e93\u5931\u8d25");//包裹出库失败
                final StringBuilder sb = new StringBuilder();
                sb.append("\u6765\u53d6\u51fa\u5e93\u63a5\u53e3\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u6765\u53d6\u51fa\u5e93\u63a5\u53e3\u5931\u8d25:");
                sb2.append(n);
                sb2.append("  ");
                sb2.append(s);
                // ToastSoundUtil.displayToast(sb2.toString());
                OkhttpManager.onErrorCallback.onError(n, s);
            }

            public void onSuccess(final LaiquOutLibraryResponseBean laiquOutLibraryResponseBean) {
                //////XLog.e("\u6765\u53d6\u5355\u51fa\u5e93\u63a5\u53e3\u6210\u529f");
                ToastSoundUtil.displayToast("\u5305\u88f9\u51fa\u5e93\u6210\u529f");//包裹出库成功
                if (laiquOutLibraryResponseBean != null) {
                    final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(laiquOutLibraryResponseBean);
                    }
                    //added by wxw
                    if (mOnOkhttpCallback != null) {
                        mOnOkhttpCallback.onSuccess(laiquOutLibraryResponseBean);
                    }
                }
                else {
                    ToastSoundUtil.displayToast("\u5305\u88f9\u51fa\u5e93\u5f02\u5e38");//包裹出库异常
                    OkhttpManager.onErrorCallback.onError(-1, "\u672a\u77e5\u9519\u8bef");
                }
            }
        }));
    }

    public static void laiquOutLibrary(final LaiquOutLibraryBean laiquOutLibraryBean, final OnOkhttpCallback<LaiquOutLibraryResponseBean> onOkhttpCallback, final OnOkhttpCallbackError onOkhttpCallbackError, final boolean b) {
        MyApplication.getDaggerReposifitComponent().getRequestApiSplaiqu().laiquOutLibrary(laiquOutLibraryBean, getLaiquLoginToken()).enqueue((Callback)new ApiCallbackLaiqu((ApiCallbackLaiqu.HttpCallback)new ApiCallbackLaiqu.HttpCallback<LaiquOutLibraryResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u767e\u4e8b\u51fa\u5e93\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                ToastSoundUtil.displayToast(sb.toString());
            }

            public void onSuccess(final LaiquOutLibraryResponseBean laiquOutLibraryResponseBean) {
                //////XLog.e("\u767e\u4e8b\u51fa\u5e93\u6210\u529f");
                if (laiquOutLibraryResponseBean != null) {
                    final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(laiquOutLibraryResponseBean);
                    }
                }
            }
        }));
    }

    public static void laiquPictureOutLibrary(final LaiquOutLibraryPictureBean laiquOutLibraryPictureBean, final OnOkhttpCallback<List<LaiquOutLibraryResponseBean>> onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiSplaiqu().laiquOutLibraryPicture(laiquOutLibraryPictureBean, getLaiquLoginToken()).enqueue((Callback)new ApiCallbackLaiqu((ApiCallbackLaiqu.HttpCallback)new ApiCallbackLaiqu.HttpCallback<List<LaiquOutLibraryResponseBean>>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u6765\u53d6\u56fe\u7247\u51fa\u5e93\u63a5\u53e3\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                ToastSoundUtil.displayToast("\u56fe\u7247\u4e0a\u4f20\u5f02\u5e38");
            }

            public void onSuccess(final List<LaiquOutLibraryResponseBean> list) {
                //////XLog.e("\u6765\u53d6\u56fe\u7247\u51fa\u5e93\u63a5\u53e3\u6210\u529f");
                ToastSoundUtil.displayToast("\u56fe\u7247\u4e0a\u4f20\u6210\u529f");
                if (list != null) {
                    final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(list);
                    }
                }
            }
        }));
    }

    public static void laiquQueryPhone(final String queryInfo, final OnOkhttpCallback<LaiquCheckBarcodeResponseBean> onOkhttpCallback) {
        final LaiquCheckBarcodeBean laiquCheckBarcodeBean = new LaiquCheckBarcodeBean();
        laiquCheckBarcodeBean.setQueryInfo(queryInfo);
        laiquCheckBarcodeBean.setQueryType("phone");
        final LaiquLoginResponseBean laiquLoginInfor = RqFilePreference.getInstance().getLaiquLoginInfor();
        if (laiquLoginInfor != null) {
            MyApplication.getDaggerReposifitComponent().getRequestApiSplaiqu().laiquCheckBarcode(laiquCheckBarcodeBean, getLaiquLoginToken(), laiquLoginInfor.getUserId(), RqFilePreference.getInstance().getLoginLaiQuServiceStaionCode()).enqueue((Callback)new ApiCallbackLaiqu((ApiCallbackLaiqu.HttpCallback)new ApiCallbackLaiqu.HttpCallback<LaiquCheckBarcodeResponseBean>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u6765\u53d6\u5355\u53f7\u67e5\u8be2\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    ////XLog.e(sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, s);
                    }
                }

                public void onSuccess(final LaiquCheckBarcodeResponseBean laiquCheckBarcodeResponseBean) {
                    ////XLog.e("\u6765\u53d6\u5355\u53f7\u67e5\u8be2\u6210\u529f");
                    if (laiquCheckBarcodeResponseBean != null) {
                        final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                        if (val$onOkhttpCallback != null) {
                            val$onOkhttpCallback.onSuccess(laiquCheckBarcodeResponseBean);
                        }
                    }
                }
            }));
        }
    }

    public static void laiquSiteLogin(final String s, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiLaiqu().laiquSiteLogin(new LaiquSiteBean("laiqu", s), getLaiquLoginToken()).enqueue((Callback)new ApiCallbackLaiqu((ApiCallbackLaiqu.HttpCallback)new ApiCallbackLaiqu.HttpCallback<LaiquSiteLoginResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u6765\u53d6\u7ad9\u70b9\u767b\u5f55\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final LaiquSiteLoginResponseBean laiquSiteLoginInfor) {
                //////XLog.e("\u6765\u53d6\u7ad9\u70b9\u767b\u5f55\u6210\u529f");
                if (laiquSiteLoginInfor != null && laiquSiteLoginInfor.isSuccessed()) {
                    RqFilePreference.getInstance().setLaiquSiteLoginInfor(laiquSiteLoginInfor);
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(laiquSiteLoginInfor);
                    }
                }
            }
        }));
    }

    public static void laiquStoreGoodsnew(final LaiquStoreGoodsNewBean laiquStoreGoodsNewBean, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiSplaiqu().laiquStoreGoodsNew(laiquStoreGoodsNewBean, getLaiquLoginToken()).enqueue((Callback)new ApiCallbackLaiqu((ApiCallbackLaiqu.HttpCallback)new ApiCallbackLaiqu.HttpCallback<LaiquStoreGoodsResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u6765\u53d6\u5165\u5e93\u63a5\u53e3\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final LaiquStoreGoodsResponseBean laiquStoreGoodsResponseBean) {
                //////XLog.e("\u6765\u53d6\u5355\u5165\u5e93\u63a5\u53e3\u6210\u529f");
                if (laiquStoreGoodsResponseBean != null) {
                    final OnOkhttpCallback val$onOkhttpCallback = onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(laiquStoreGoodsResponseBean);
                    }
                }
            }
        }));
    }

    public static void laiquStsRegist() {
        if (RqFilePreference.getInstance().getLaiquLoginInfor() != null) {
            final String loginLaiQuServiceStaionCode = RqFilePreference.getInstance().getLoginLaiQuServiceStaionCode();
            final String laiquLoginToken = getLaiquLoginToken();
            final StringBuilder sb = new StringBuilder();
            sb.append("best-laiqu");
            sb.append(loginLaiQuServiceStaionCode);
            sb.append(MD5Util.encodeMd5(laiquLoginToken, ""));
            final String encodeMd5 = MD5Util.encodeMd5(sb.toString(), "");
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("laiquStsRegist key :");
            sb2.append(encodeMd5);
            //////XLog.e(sb2.toString());
            MyApplication.getDaggerReposifitComponent().getRequestApiLaiquSts().laiquStsRegist("best-laiqu", loginLaiQuServiceStaionCode, laiquLoginToken, encodeMd5).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<LaiquStsRegistResponseBean>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u6765\u53d6\u83b7\u53d6STS TOKEN\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //////XLog.e(sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, s);
                    }
                }

                public void onSuccess(final LaiquStsRegistResponseBean laiquStsRegistBean) {
                    if (laiquStsRegistBean != null) {
                        RqFilePreference.getInstance().setLaiquStsRegistBean(laiquStsRegistBean);
                        final StringBuilder sb = new StringBuilder();
                        sb.append("\u6765\u53d6\u83b7\u53d6STS TOKEN\u6210\u529f");
                        sb.append(JsonUtil.getJsonStringByGson(laiquStsRegistBean));
                        //////XLog.e(sb.toString());
                    }
                }
            }));
        }
    }

    public static void laiquUserLogin(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiLaiqu().laiquUserLogin(new LaiquUserLoginBean(s, s2), getLaiquLoginToken()).enqueue((Callback)new ApiCallbackLaiqu((ApiCallbackLaiqu.HttpCallback)new ApiCallbackLaiqu.HttpCallback<LaiquLoginResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u6765\u53d6\u7528\u6237\u767b\u5f55\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //////XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final LaiquLoginResponseBean laiquLoginInfor) {
                //////XLog.e("\u6765\u53d6\u7528\u6237\u767b\u5f55\u6210\u529f");
                if (laiquLoginInfor != null && laiquLoginInfor.getToken() != null) {
                    RqFilePreference.getInstance().setLaiquLoginInfor(laiquLoginInfor);
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(laiquLoginInfor);
                    }
                    //added by wxw
                    if (mOnOkhttpCallback != null) {
                        RqFilePreference.getInstance().setLAIQUAccount(s);
                        RqFilePreference.getInstance().setLAIQUPwd(laiqu_pass);
                        mOnOkhttpCallback.onSuccess(laiquLoginInfor);
                    }
                }
            }
        }));
    }
    public static void mamaCheckExpressCompanyData(final MaMaCheckInforBean maMaCheckInforBean, final OnOkhttpCallback onOkhttpCallback) {
        try {
            if (StringUtil.isEmpty(OkhttpManager.pdaDeviceNo)) {
                OkhttpManager.pdaDeviceNo = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getIMEI();
            }
            final MaMaLoginResponseBean maMaLoginInfor = RqFilePreference.getInstance().getMaMaLoginInfor();
            maMaCheckInforBean.setDeviceType("YZ-AND");
            maMaCheckInforBean.setStationCode(maMaLoginInfor.getStationCode());
            maMaCheckInforBean.setOrgCode(maMaLoginInfor.getOrgCode());
            if (StringUtil.isEmpty(maMaCheckInforBean.getUsername())) {
                maMaCheckInforBean.setUsername(RqFilePreference.getInstance().getLoginUsername());
            }
            maMaCheckInforBean.setSerialNo(OkhttpManager.serialNo);
            final StringBuilder sb = new StringBuilder();
            sb.append(maMaCheckInforBean.getData());
            sb.append(maMaCheckInforBean.getSerialNo());
            sb.append(maMaCheckInforBean.getOrgCode());
            sb.append(maMaCheckInforBean.getStationCode());
            sb.append(maMaCheckInforBean.getUsername());
            sb.append(maMaCheckInforBean.getDeviceType());
            sb.append(maMaLoginInfor.getKey());
            maMaCheckInforBean.setDigest(URLEncoder.encode(Base64Util.getBaseString(MD5Util.encodeMd5ToByte(sb.toString()))));
            MyApplication.getDaggerReposifitComponent().getRequestApiMaMaYZ().mamaCheckExpressCompanyInfor(maMaCheckInforBean, OkhttpManager.pdaDeviceNo, OkhttpManager.pdaVersionNo, OkhttpManager.pdaVersionCode, OkhttpManager.pdaDeviceType, OkhttpManager.deviceModel, maMaLoginInfor.getToken(), maMaLoginInfor.getOrgCode(), maMaLoginInfor.getEmpCode()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<MaMaCheckExpressCompanyResponseBean>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u5988\u5988\u9a7f\u7ad9\u67e5\u8be2\u5feb\u9012\u516c\u53f8\u4fe1\u606f\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, s);
                    }
                }

                public void onSuccess(final MaMaCheckExpressCompanyResponseBean maMaCheckExpressCompanyResponseBean) {
                    //XLog.e("\u5988\u5988\u9a7f\u7ad9\u67e5\u8be2\u5feb\u9012\u516c\u53f8\u4fe1\u606f\u6210\u529f:");
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(maMaCheckExpressCompanyResponseBean);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void mamaCheckHuoJiaData(final MaMaCheckInforBean maMaCheckInforBean, final OnOkhttpCallback onOkhttpCallback) {
        try {
            if (StringUtil.isEmpty(OkhttpManager.pdaDeviceNo)) {
                OkhttpManager.pdaDeviceNo = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getIMEI();
            }
            if (StringUtil.isEmpty(OkhttpManager.serialNo)) {
                OkhttpManager.serialNo = CommonFilePreference.getInstance().getUUID();
            }
            final MaMaLoginResponseBean maMaLoginInfor = RqFilePreference.getInstance().getMaMaLoginInfor();
            maMaCheckInforBean.setDeviceType("YZ-AND");
            maMaCheckInforBean.setStationCode(maMaLoginInfor.getStationCode());
            maMaCheckInforBean.setOrgCode(maMaLoginInfor.getOrgCode());
            if (StringUtil.isEmpty(maMaCheckInforBean.getUsername())) {
                maMaCheckInforBean.setUsername(RqFilePreference.getInstance().getLoginUsername());
            }
            maMaCheckInforBean.setSerialNo(OkhttpManager.serialNo);
            final StringBuilder sb = new StringBuilder();
            sb.append(maMaCheckInforBean.getData());
            sb.append(maMaCheckInforBean.getSerialNo());
            sb.append(maMaCheckInforBean.getOrgCode());
            sb.append(maMaCheckInforBean.getStationCode());
            sb.append(maMaCheckInforBean.getUsername());
            sb.append(maMaCheckInforBean.getDeviceType());
            sb.append(maMaLoginInfor.getKey());
            maMaCheckInforBean.setDigest(URLEncoder.encode(Base64Util.getBaseString(MD5Util.encodeMd5ToByte(sb.toString()))));
            MyApplication.getDaggerReposifitComponent().getRequestApiMaMaYZ().mamaCheckHuoJiaInfor(maMaCheckInforBean, OkhttpManager.pdaDeviceNo, OkhttpManager.pdaVersionNo, OkhttpManager.pdaVersionCode, OkhttpManager.pdaDeviceType, OkhttpManager.deviceModel, maMaLoginInfor.getToken(), maMaLoginInfor.getOrgCode(), maMaLoginInfor.getEmpCode()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<MaMaCheckHuoJiaResponseBean>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u5988\u5988\u9a7f\u7ad9\u67e5\u8be2\u8d27\u67b6\u4fe1\u606f\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, s);
                    }
                }

                public void onSuccess(final MaMaCheckHuoJiaResponseBean maMaCheckHuoJiaResponseBean) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u5988\u5988\u9a7f\u7ad9\u67e5\u8be2\u8d27\u67b6\u4fe1\u606f\u6210\u529f:");
                    sb.append(maMaCheckHuoJiaResponseBean.toString());
                    //XLog.e(sb.toString());
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(maMaCheckHuoJiaResponseBean);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void mamaCheckNoOutLibraryData(final MaMaCheckInforBean maMaCheckInforBean, final OnOkhttpCallback onOkhttpCallback) {
        try {
            if (StringUtil.isEmpty(OkhttpManager.pdaDeviceNo)) {
                OkhttpManager.pdaDeviceNo = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getIMEI();
            }
            final MaMaLoginResponseBean maMaLoginInfor = RqFilePreference.getInstance().getMaMaLoginInfor();
            maMaCheckInforBean.setDeviceType("YZ-AND");
            maMaCheckInforBean.setStationCode(maMaLoginInfor.getStationCode());
            maMaCheckInforBean.setOrgCode(maMaLoginInfor.getOrgCode());
            if (StringUtil.isEmpty(maMaCheckInforBean.getUsername())) {
                maMaCheckInforBean.setUsername(RqFilePreference.getInstance().getLoginUsername());
            }
            maMaCheckInforBean.setSerialNo(OkhttpManager.serialNo);
            final StringBuilder sb = new StringBuilder();
            sb.append(maMaCheckInforBean.getData());
            sb.append(maMaCheckInforBean.getSerialNo());
            sb.append(maMaCheckInforBean.getOrgCode());
            sb.append(maMaCheckInforBean.getStationCode());
            sb.append(maMaCheckInforBean.getUsername());
            sb.append(maMaCheckInforBean.getDeviceType());
            sb.append(maMaLoginInfor.getKey());
            final String string = sb.toString();
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("mamaCheckNoOutLibraryData: =============");
            sb2.append(maMaCheckInforBean.getDeviceType());
            Log.d("OkhttpManager", sb2.toString());
            maMaCheckInforBean.setDigest(URLEncoder.encode(Base64Util.getBaseString(MD5Util.encodeMd5ToByte(string))));
            final String token = maMaLoginInfor.getToken();
            final String orgCode = maMaLoginInfor.getOrgCode();
            final String stationCode = maMaLoginInfor.getStationCode();
            final String empCode = maMaLoginInfor.getEmpCode();
            final String userName = maMaLoginInfor.getUserName();
            final RequestApiMaMaYZ requestApiMaMaYZ = MyApplication.getDaggerReposifitComponent().getRequestApiMaMaYZ();
            final String pdaDeviceNo = OkhttpManager.pdaDeviceNo;
            final String pdaVersionNo = OkhttpManager.pdaVersionNo;
            final String pdaVersionCode = OkhttpManager.pdaVersionCode;
            final String pdaDeviceType = OkhttpManager.pdaDeviceType;
            final String serialNo = OkhttpManager.serialNo;
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(System.currentTimeMillis());
            sb3.append("");
            requestApiMaMaYZ.mamaCheckNoOutLibrary(maMaCheckInforBean, pdaDeviceNo, pdaVersionNo, pdaVersionCode, pdaDeviceType, token, orgCode, stationCode, empCode, userName, serialNo, sb3.toString()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<MaMaNoOutLibraryResponseBean>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u5988\u5988\u9a7f\u7ad9\u67e5\u8be2\u672a\u51fa\u5e93\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, s);
                    }
                }

                public void onSuccess(final MaMaNoOutLibraryResponseBean maMaNoOutLibraryResponseBean) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("onSuccess: ====================");
                    sb.append(maMaNoOutLibraryResponseBean.getData());
                    Log.d("OkhttpManager", sb.toString());
                    //XLog.e("\u5988\u5988\u9a7f\u7ad9\u67e5\u8be2\u672a\u51fa\u5e93\u6210\u529f:");
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(maMaNoOutLibraryResponseBean);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void mamaLoginApi(final MaMaLoginBean maMaLoginBean, final OnOkhttpCallback onOkhttpCallback) {
        if (StringUtil.isEmpty(OkhttpManager.serialNo)) {
            if (FactoryConfigurationFilePreference.getInstance().getFactoryRegistration() != null) {
                OkhttpManager.serialNo = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getIMEI();
            }
            else {
                final StringBuilder sb = new StringBuilder();
                sb.append("86");
                sb.append(System.currentTimeMillis());
                OkhttpManager.serialNo = sb.toString();
            }
        }
        maMaLoginBean.setSerialNo(OkhttpManager.serialNo);
        maMaLoginBean.setVersionNo(OkhttpManager.pdaVersionNo);
        final RequestApiMaMa requestApiMaMa = MyApplication.getDaggerReposifitComponent().getRequestApiMaMa();
        final String pdaDeviceNo = OkhttpManager.pdaDeviceNo;
        final String pdaVersionNo = OkhttpManager.pdaVersionNo;
        final String pdaVersionCode = OkhttpManager.pdaVersionCode;
        final String pdaDeviceType = OkhttpManager.pdaDeviceType;
        final String deviceModel = OkhttpManager.deviceModel;
        final String username = maMaLoginBean.getUsername();
        final String serialNo = OkhttpManager.serialNo;
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        sb2.append("");
        requestApiMaMa.mamaStationLogin(maMaLoginBean, pdaDeviceNo, pdaVersionNo, pdaVersionCode, pdaDeviceType, deviceModel, username, serialNo, sb2.toString()).enqueue((Callback)new ApiCallbackMaMa((ApiCallbackMaMa.HttpCallback)new ApiCallbackMaMa.HttpCallback<MaMaLoginResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u5988\u5988\u9a7f\u7ad9\u767b\u5f55\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u5988\u5988\u9a7f\u7ad9\u767b\u5f55\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final MaMaLoginResponseBean maMaLoginInfor) {
                if (maMaLoginInfor != null) {
                    RqFilePreference.getInstance().setMaMaLoginInfor(maMaLoginInfor);
                }
                //XLog.e("\u5988\u5988\u9a7f\u7ad9\u767b\u5f55\u6210\u529f");
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    RqFilePreference.getInstance().setMAMASTATIONAccount(maMaLoginBean.getUsername());
                    RqFilePreference.getInstance().setMAMASTATIONPwd(maMaLoginBean.getPassword_save());
                    val$okhttpCallback.onSuccess(maMaLoginInfor);
                }
            }
        }));
    }

    public static void mamaQueryBarcodeInfor(final MaMaQueryBarcodeBean maMaQueryBarcodeBean, final MaMaLoginResponseBean maMaLoginResponseBean, final OnOkhttpCallback onOkhttpCallback) {
        if (StringUtil.isEmpty(OkhttpManager.pdaDeviceNo)) {
            if (FactoryConfigurationFilePreference.getInstance().getFactoryRegistration() != null) {
                OkhttpManager.pdaDeviceNo = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getIMEI();
            }
            else {
                final StringBuilder sb = new StringBuilder();
                sb.append("86");
                sb.append(System.currentTimeMillis());
                OkhttpManager.pdaDeviceNo = sb.toString();
            }
        }
        final String token = maMaLoginResponseBean.getToken();
        final String orgCode = maMaLoginResponseBean.getOrgCode();
        final String stationCode = maMaLoginResponseBean.getStationCode();
        final String empCode = maMaLoginResponseBean.getEmpCode();
        final String userName = maMaLoginResponseBean.getUserName();
        final RequestApiMaMa requestApiMaMa = MyApplication.getDaggerReposifitComponent().getRequestApiMaMa();
        final String pdaDeviceNo = OkhttpManager.pdaDeviceNo;
        final String pdaVersionNo = OkhttpManager.pdaVersionNo;
        final String pdaVersionCode = OkhttpManager.pdaVersionCode;
        final String pdaDeviceType = OkhttpManager.pdaDeviceType;
        final String deviceModel = OkhttpManager.deviceModel;
        final String serialNo = OkhttpManager.serialNo;
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        sb2.append("");
        requestApiMaMa.mamaQueryBarcode(maMaQueryBarcodeBean, pdaDeviceNo, pdaVersionNo, pdaVersionCode, pdaDeviceType, deviceModel, token, orgCode, stationCode, empCode, userName, serialNo, sb2.toString()).enqueue((Callback)new ApiCallbackMaMa((ApiCallbackMaMa.HttpCallback)new ApiCallbackMaMa.HttpCallback<List<MaMaQueryBarcodeResponseBean>>() {
            @Override
            public void onFailure(int n, final String s) {
                Log.e("mama","OkhttpManager mamaQueryBarcodeInfor onFailure!"+s+"--n--"+n);
                final StringBuilder sb = new StringBuilder();
                sb.append("\u5988\u5988\u9a7f\u7ad9\u5355\u53f7\u67e5\u8be2\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    final int n2 = 1;
                    OkhttpManager.onErrorCallback.onError(n, s);
                    n = n2;
                }
                else {
                    n = 0;
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u5988\u5988\u9a7f\u7ad9\u5355\u53f7\u67e5\u8be2\u5931\u8d25 ");
                sb2.append(s);
                sb2.append("  ");
                sb2.append(n);
                //ToastSoundUtil.displayToast(sb2.toString());
            }

            public void onSuccess(final List<MaMaQueryBarcodeResponseBean> list) {
                Log.e("mama","OkhttpManager  mamaQueryBarcodeInfor    onSuccess"+list.size());
                Log.e("mama","OkhttpManager  mamaQueryBarcodeInfor    onSuccess"+list.get(0).toString());
                //XLog.e("\u5988\u5988\u9a7f\u7ad9\u5355\u53f7\u67e5\u8be2\u6210\u529f");
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(list);
                }
            }
        }));
    }

    public static void mamaQueryInLibraryBarcodeInfor(final MaMaCheckBarcodeInforBean maMaCheckBarcodeInforBean, final MaMaLoginResponseBean maMaLoginResponseBean, final OnOkhttpCallback onOkhttpCallback) {
        if (StringUtil.isEmpty(OkhttpManager.pdaDeviceNo)) {
            if (FactoryConfigurationFilePreference.getInstance().getFactoryRegistration() != null) {
                OkhttpManager.pdaDeviceNo = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getIMEI();
            }
            else {
                final StringBuilder sb = new StringBuilder();
                sb.append("88");
                sb.append(System.currentTimeMillis());
                OkhttpManager.pdaDeviceNo = sb.toString();
            }
        }
        MyApplication.getDaggerReposifitComponent().getRequestApiMaMa().mamaCheckBarcodeInfor(maMaCheckBarcodeInforBean, OkhttpManager.pdaDeviceNo, OkhttpManager.pdaVersionNo, OkhttpManager.pdaVersionCode, OkhttpManager.pdaDeviceType, OkhttpManager.deviceModel, maMaLoginResponseBean.getToken(), maMaLoginResponseBean.getOrgCode(), maMaLoginResponseBean.getEmpCode()).enqueue((Callback)new ApiCallbackMaMa((ApiCallbackMaMa.HttpCallback)new ApiCallbackMaMa.HttpCallback<MaMaCheckBarcodeResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(s);
                Log.e("qinkangccc", sb.toString());
                if ("\u83b7\u53d6\u624b\u673a\u53f7\u7801\u5931\u8d25".equals(s)) {
                    ToastSoundUtil.wrongTelIsEmptyToast(s);
                }
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final MaMaCheckBarcodeResponseBean maMaCheckBarcodeResponseBean) {
                //XLog.e("\u5988\u5988\u9a7f\u7ad9\u5165\u5e93\u5355\u53f7\u67e5\u8be2\u6210\u529f");
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(maMaCheckBarcodeResponseBean);
                }
            }
        }));
    }

    public static void mamaQueryWaybillRegularInfo(final String s, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiMaMa().mamaQueryWaybillRegularInfo(s).enqueue((Callback)new ApiCallbackMaMa((ApiCallbackMaMa.HttpCallback)new ApiCallbackMaMa.HttpCallback<List<MaMaQueryBillRegularResponseBean>>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u5988\u5988\u9a7f\u7ad9\u67e5\u8be2\u5404\u5feb\u9012\u516c\u53f8\u5355\u53f7\u6b63\u5219\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final List<MaMaQueryBillRegularResponseBean> list) {
                //XLog.e("\u5988\u5988\u9a7f\u7ad9\u67e5\u8be2\u5404\u5feb\u9012\u516c\u53f8\u5355\u53f7\u6b63\u5219\u6210\u529f");
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(list);
                }
            }
        }));
    }

    public static void mamaUploadInLibraryBarcode(final Context context, final MaMaInLibraryBean maMaInLibraryBean, final MaMaLoginResponseBean maMaLoginResponseBean, final OnOkhttpCallback onOkhttpCallback) {
        if (StringUtil.isEmpty(OkhttpManager.pdaDeviceNo)) {
            if (FactoryConfigurationFilePreference.getInstance().getFactoryRegistration() != null) {
                OkhttpManager.pdaDeviceNo = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getIMEI();
            }
            else {
                final StringBuilder sb = new StringBuilder();
                sb.append("88");
                sb.append(System.currentTimeMillis());
                OkhttpManager.pdaDeviceNo = sb.toString();
            }
        }
        new Thread(new Runnable() {
            final /* synthetic */ String val$loginUserCode = maMaLoginResponseBean.getEmpCode();
            final /* synthetic */ String val$orgCode = maMaLoginResponseBean.getOrgCode();
            final /* synthetic */ String val$token = maMaLoginResponseBean.getToken();

            @Override
            public void run() {
                try {
                    final retrofit2.Response execute = MyApplication.getDaggerReposifitComponent().getRequestApiMaMa().mamaInLibrary(maMaInLibraryBean, OkhttpManager.pdaDeviceNo, OkhttpManager.pdaVersionNo, OkhttpManager.pdaVersionCode, OkhttpManager.pdaDeviceType, OkhttpManager.deviceModel, this.val$token, this.val$orgCode, this.val$loginUserCode).execute();
                    ((Activity)context).runOnUiThread((Runnable)new Runnable() {
                        final /* synthetic */ String val$body = ((ResponseBody)execute.body()).string();
                        final /* synthetic */ int val$code = execute.code();

                        @Override
                        public void run() {
                            if (this.val$code == 200) {
                                if (onOkhttpCallback != null) {
                                    onOkhttpCallback.onSuccess(this.val$body);
                                }
                            }
                            else if (OkhttpManager.onErrorCallback != null) {
                                OkhttpManager.onErrorCallback.onError(-2, execute.message());
                            }
                        }
                    });
                }
                catch (IOException ex) {
                    ((Activity)context).runOnUiThread((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (OkhttpManager.onErrorCallback != null) {
                                OkhttpManager.onErrorCallback.onError(-2, ex.getMessage());
                            }
                        }
                    });
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    public static void mamaUploadOutLibraryData(final MaMaOutLibraryBean maMaOutLibraryBean, final OnOkhttpCallback onOkhttpCallback) {
        final MaMaLoginResponseBean maMaLoginInfor = RqFilePreference.getInstance().getMaMaLoginInfor();
        final String token = maMaLoginInfor.getToken();
        final String orgCode = maMaLoginInfor.getOrgCode();
        final String stationCode = maMaLoginInfor.getStationCode();
        final String empCode = maMaLoginInfor.getEmpCode();
        final String userName = maMaLoginInfor.getUserName();
        final RequestApiMaMaOutLibrary requestApiMaMaOutLibrary = MyApplication.getDaggerReposifitComponent().getRequestApiMaMaOutLibrary();
        final String pdaDeviceNo = OkhttpManager.pdaDeviceNo;
        final String pdaVersionNo = OkhttpManager.pdaVersionNo;
        final String pdaVersionCode = OkhttpManager.pdaVersionCode;
        final String pdaDeviceType = OkhttpManager.pdaDeviceType;
        final String deviceModel = OkhttpManager.deviceModel;
        final String serialNo = OkhttpManager.serialNo;
        final StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append("");
        requestApiMaMaOutLibrary.mamaOutLibrary(maMaOutLibraryBean, pdaDeviceNo, pdaVersionNo, pdaVersionCode, pdaDeviceType, deviceModel, token, orgCode, stationCode, empCode, userName, serialNo, sb.toString()).enqueue((Callback)new ApiCallbackMaMa((ApiCallbackMaMa.HttpCallback)new ApiCallbackMaMa.HttpCallback<Object>() {
            @Override
            public void onFailure(final int n, final String s) {
                Log.e("mama","-OkhttpManager-onFailure--"+s);
                final StringBuilder sb = new StringBuilder();
                sb.append("\u5988\u5988\u9a7f\u7ad9\u51fa\u5e93\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    String s2 = s;
                    if (s.contains("\u9a7f\u7ad9\u6b63\u5e38\u7b7e\u6536\u6216\u9000\u56de\u6279\u91cf\u5168\u90e8\u5904\u7406\u5931\u8d25")) {
                        s2 = "\u5305\u88f9\u5df2\u51fa\u5e93";
                    }
                    OkhttpManager.onErrorCallback.onError(n, s2);
                }
            }

            @Override
            public void onSuccess(final Object o) {
                Log.e("mama","-OkhttpManager-onSuccess--");
                //XLog.e("\u5988\u5988\u9a7f\u7ad9\u51fa\u5e93\u6210\u529f");
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    mOnOkhttpCallback.onSuccess(o);
                    val$okhttpCallback.onSuccess(o);
                }
            }
        }));
    }

    public static void mcourSmallPoleChuKu1_1(final String s, final String s2, final String s3, final String s4, final String s5, final OnOkhttpCallback onOkhttpCallback) {
        try {
            final RequestApiCourSmallPole requestApiCourSmallPole = MyApplication.getDaggerReposifitComponent().getRequestApiCourSmallPole();
            final StringBuilder sb = new StringBuilder();
            sb.append(s5);
            sb.append(".jpg");
            requestApiCourSmallPole.courSmallPoleChuKu1_1(s, s2, sb.toString(), "1", s3, s4, "1", s5, "image/jpeg").enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JsonObject>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u6570\u636e2\uff1a");
                    sb.append(s);
                    Log.e("courierSmallPole", sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, s);
                    }
                }

                public void onSuccess(final JsonObject jsonObject) {
                    int int1 = 0;
                    String string;
                    try {
                        final JSONObject jsonObject2 = new JSONObject(jsonObject.toString());
                        int1 = int1;
                        final int n = int1 = jsonObject2.getInt("code");
                        string = jsonObject2.getString("message");
                        int1 = n;
                    }
                    catch (JSONException ex) {
                        ex.printStackTrace();
                        string = "";
                    }
                    if (int1 == 200) {
                        if (onOkhttpCallback != null) {
                            onOkhttpCallback.onSuccess(new Gson().fromJson((JsonElement)jsonObject, (Class)CourSmallPoleChuKuBean.class));
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, string);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void mcourSmallPoleChuKu1_2(final String s, final String s2, final String s3, final String s4, final OnOkhttpCallback onOkhttpCallback) {
        try {
            final RequestApiCourSmallPole requestApiCourSmallPole = MyApplication.getDaggerReposifitComponent().getRequestApiCourSmallPole();
            final StringBuilder sb = new StringBuilder();
            sb.append(s4);
            sb.append(".jpg");
            requestApiCourSmallPole.courSmallPoleChuKu1_2(s, s2, sb.toString(), "1", s3, "2", s4, "image/jpeg").enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JsonObject>() {
                @Override
                public void onFailure(final int n, final String s) {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, s);
                    }
                }

                public void onSuccess(final JsonObject jsonObject) {
                    int int1 = 0;
                    String string;
                    try {
                        final JSONObject jsonObject2 = new JSONObject(jsonObject.toString());
                        int1 = int1;
                        final int n = int1 = jsonObject2.getInt("code");
                        string = jsonObject2.getString("message");
                        int1 = n;
                    }
                    catch (JSONException ex) {
                        ex.printStackTrace();
                        string = "";
                    }
                    if (int1 == 200) {
                        if (onOkhttpCallback != null) {
                            onOkhttpCallback.onSuccess(new Gson().fromJson((JsonElement)jsonObject, (Class)CourSmallPoleChuKuBean.class));
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, string);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void mcourSmallPoleUpLoad(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final MultipartBody.Part part, final OnOkhttpCallback onOkhttpCallback) {
        try {
            MyApplication.getDaggerReposifitComponent().getRequestApiCourSmallPole().courSmallPoleUpLoadImg(s, s2, s3, s4, s5, s6, part).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JsonObject>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u9519\u8bef11\uff1a");
                    sb.append(s);
                    Log.e("courierSmallPole", sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, s);
                    }
                }

                public void onSuccess(final JsonObject jsonObject) {
                    final String s = "";
                    final boolean b = false;
                    int int1 = 0;
                    int n = b ? 1 : 0;
                    String string;
                    try {
                        final JSONObject jsonObject2 = new JSONObject(jsonObject.toString());
                        n = (b ? 1 : 0);
                        if (jsonObject2.has("code")) {
                            n = (b ? 1 : 0);
                            int1 = jsonObject2.getInt("code");
                        }
                        n = int1;
                        if (jsonObject2.has("status")) {
                            n = int1;
                            string = jsonObject2.getString("status");
                        }
                        else {
                            string = "";
                        }
                        try {
                            final String string2 = jsonObject2.getString("message");
                        }
                        catch (JSONException ex) {}
                    }
                    catch (JSONException ex) {
                        string = "";
                        int1 = n;
                    }
                    /*final StringBuilder sb = new StringBuilder();
                    sb.append("\u9519\u8bef\uff1a");
                    final JSONException ex;
                    sb.append(ex.getMessage());
                    Log.e("courierSmallPole", sb.toString());
                    ex.printStackTrace();*/
                    final String string2 = s;
                    if (string.equals("ok")) {
                        final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                        if (val$okhttpCallback != null) {
                            val$okhttpCallback.onSuccess(jsonObject);
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(int1, string2);
                    }
                }
            }));
        }
        catch (Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("\u9519\u8bef\uff1a\u300b\u300b\u300b\uff1a");
            sb.append(ex.getMessage());
            Log.e("courierSmallPole", sb.toString());
            ex.printStackTrace();
        }
    }

    public static void mcourSmallPoleUpLoad2(final String s, final List<MultipartBody.Part> list, final OnOkhttpCallback onOkhttpCallback) {
        try {
            MyApplication.getDaggerReposifitComponent().getRequestApiCourSmallPole().courSmallPoleUpLoadImg2(s, list).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JsonObject>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u9519\u8bef11\uff1a");
                    sb.append(s);
                    Log.e("courierSmallPole", sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, s);
                    }
                }

                public void onSuccess(final JsonObject jsonObject) {
                    final String s = "";
                    Log.e("courierSmallPole", "-----------------------------------");
                    final boolean b = false;
                    int int1 = 0;
                    int n = b ? 1 : 0;
                    String string;
                    try {
                        final JSONObject jsonObject2 = new JSONObject(jsonObject.toString());
                        n = (b ? 1 : 0);
                        if (jsonObject2.has("code")) {
                            n = (b ? 1 : 0);
                            int1 = jsonObject2.getInt("code");
                        }
                        n = int1;
                        if (jsonObject2.has("status")) {
                            n = int1;
                            string = jsonObject2.getString("status");
                        }
                        else {
                            string = "";
                        }
                        try {
                            final String string2 = jsonObject2.getString("message");
                        }
                        catch (JSONException ex) {}
                    }
                    catch (JSONException ex) {
                        string = "";
                        int1 = n;
                    }
                    /*final StringBuilder sb = new StringBuilder();
                    sb.append("\u9519\u8bef\uff1a");
                    final JSONException ex;
                    sb.append(ex.getMessage());
                    Log.e("courierSmallPole", sb.toString());
                    ex.printStackTrace();*/
                    final String string2 = s;
                    if (string.equals("ok")) {
                        final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                        if (val$okhttpCallback != null) {
                            val$okhttpCallback.onSuccess(jsonObject);
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(int1, string2);
                    }
                }
            }));
        }
        catch (Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("\u9519\u8bef\uff1a\u300b\u300b\u300b\uff1a");
            sb.append(ex.getMessage());
            Log.e("courierSmallPole", sb.toString());
            ex.printStackTrace();
        }
    }

    public static void miaoZhanCheckOutApi(final MiaoZhanLoginBean miaoZhanLoginBean, final String s, final byte[] array, final byte[] array2, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiMiaoZhanStation().miaoZhanCheckOut(new MiaoZhan(miaoZhanLoginBean.getBrand(), MiaoZhanUtil.INSTANCE.doSign(JSON.toJSONString((Object)new MiaoZhanOutLib(s, miaoZhanLoginBean.getDeviceNo())), miaoZhanLoginBean.getSecret()), new MiaoZhanOutLibPhoto(s, miaoZhanLoginBean.getDeviceNo(), FwrBase64.INSTANCE.encode(array), FwrBase64.INSTANCE.encode(array2)))).enqueue((Callback)new ApiCallbackMiaoZhan((ApiCallbackMiaoZhan.HttpCallback)new ApiCallbackMiaoZhan.HttpCallback<MiaoZhanBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                ToastSoundUtil.displayToast("\u56fe\u7247\u4e0a\u4f20\u5931\u8d25");
            }

            public void onSuccess(final MiaoZhanBean miaoZhanBean) {
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(miaoZhanBean);
                }
            }
        }));
    }

    public static void miaoZhanLoginApi(final MiaoZhanLoginBean miaoZhanLoginBean, final OnOkhttpCallback onOkhttpCallback) {
        final MiaoZhanLogin miaoZhanLogin = new MiaoZhanLogin(miaoZhanLoginBean.getStationId(), miaoZhanLoginBean.getDeviceNo(), miaoZhanLoginBean.getCheckCode());
        MyApplication.getDaggerReposifitComponent().getRequestApiMiaoZhanStation().miaoZhanLogin(new MiaoZhan(miaoZhanLoginBean.getBrand(), MiaoZhanUtil.INSTANCE.doSign(JSON.toJSONString(miaoZhanLogin), miaoZhanLoginBean.getSecret()), miaoZhanLogin)).enqueue((Callback)new ApiCallbackMiaoZhan((ApiCallbackMiaoZhan.HttpCallback)new ApiCallbackMiaoZhan.HttpCallback<MiaoZhanBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, s);
                }
            }

            public void onSuccess(final MiaoZhanBean miaoZhanBean) {
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(miaoZhanBean);
                }
            }
        }));
    }

    public static void miaoZhanOutLibApi(final MiaoZhanLoginBean miaoZhanLoginBean, final String s, final OnOkhttpCallback onOkhttpCallback) {
        final MiaoZhanOutLib miaoZhanOutLib = new MiaoZhanOutLib(s, miaoZhanLoginBean.getDeviceNo());
        MyApplication.getDaggerReposifitComponent().getRequestApiMiaoZhanStation().miaoZhanOutLib(new MiaoZhan(miaoZhanLoginBean.getBrand(), MiaoZhanUtil.INSTANCE.doSign(JSON.toJSONString((Object)miaoZhanOutLib), miaoZhanLoginBean.getSecret()), miaoZhanOutLib)).enqueue((Callback)new ApiCallbackMiaoZhan((ApiCallbackMiaoZhan.HttpCallback)new ApiCallbackMiaoZhan.HttpCallback<MiaoZhanBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, s);
                }
            }

            public void onSuccess(final MiaoZhanBean miaoZhanBean) {
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(miaoZhanBean);
                }
            }
        }));
    }

    public static void netManagerLogin(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        final String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        final StringBuilder sb = new StringBuilder();
        sb.append("appkey");
        sb.append(s);
        sb.append("bizcontent{\"logisticNo\":\"1111111111111\",\"weight\":10}contenttypejsonmethodwms-wos.order.weighingtimestamp");
        sb.append(format);
        sb.append("version1.0");
        final String string = sb.toString();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s2);
        sb2.append(string);
        sb2.append(s2);
        MyApplication.getDaggerReposifitComponent().getRequestChengZhongDengJi().chenZhongDengJi("wms-wos.order.weighing", s, "1.0", "json", format, "{\"logisticNo\":\"1111111111111\",\"weight\":10}", MD5Util.getMD5Str(sb2.toString().toLowerCase())).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<ResponseChenZhongDdengJi>() {
            @Override
            public void onFailure(final int n, final String s) {
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, s);
                }
            }

            public void onSuccess(final ResponseChenZhongDdengJi responseChenZhongDdengJi) {
                if (!responseChenZhongDdengJi.getMsg().contains("\u7b7e\u540d\u9519\u8bef")) {
                    RqFilePreference.getInstance().setNetManagerLoginInfor(new NetManagerLoginBean(s, s2));
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {

                        RqFilePreference.getInstance().setNETMANAGERAccount(s);
                        RqFilePreference.getInstance().setNETMANAGERPwd(s2);
                        val$okhttpCallback.onSuccess(responseChenZhongDdengJi);
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, "appkey\u6216\u8005appSecret\u8f93\u5165\u9519\u8bef");
                }
            }
        }));
    }

    public static void pandaHarvest(final String clientCode, final OnOkhttpCallback onOkhttpCallback) {
        final PandaHarvestRequestBean pandaHarvestInfor = new PandaHarvestRequestBean();
        pandaHarvestInfor.setClientCode(clientCode);
        RqFilePreference.getInstance().setPandaHarvestInfor(pandaHarvestInfor);
        onOkhttpCallback.onSuccess(pandaHarvestInfor);
    }

    public static void pandaHarvestLogin(final Map<String, String> map, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiPandaHarvest().pandaHarvestLogin(map).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<CameraCheckOutBean<PandToken>>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u718a\u732b\u5feb\u6536\u767b\u5f55\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    if (s.contains("java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING")) {
                        OkhttpManager.onErrorCallback.onError(n, "login fail!");
                    }
                }
            }

            public void onSuccess(final CameraCheckOutBean<PandToken> cameraCheckOutBean) {
                if (cameraCheckOutBean != null) {
                    if (cameraCheckOutBean.isSuccess()) {
                        //XLog.e("\u718a\u732b\u5feb\u6536\u767b\u5f55\u6210\u529f");
                        RqFilePreference.getInstance().setPandaHarvestInfoToken(cameraCheckOutBean.getD().getToken());
                        final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                        if (val$okhttpCallback != null) {
                            val$okhttpCallback.onSuccess(cameraCheckOutBean);
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, cameraCheckOutBean.getM());
                    }
                }
            }
        }));
    }

    public static void pandaHarvestOutLib(final Map<String, String> map, final OnOkhttpCallback<PandaOutLibCall> onOkhttpCallback) {
        final FormBody.Builder builder = new FormBody.Builder();
        builder.add("bizData", (String)map.get("bizData"));
        builder.add("timestamp", (String)map.get("timestamp"));
        builder.add("accountName", (String)map.get("accountName"));
        builder.add("apiName", (String)map.get("apiName"));
        builder.add("token", (String)map.get("token"));
        builder.add("sign", (String)map.get("sign"));
        builder.build();
        OkhttpManager.okHttpClient.newCall(new Request.Builder().url("http://openapi.pandabg.cn:20099/v3/openBmx"/*ApiPandaHarvestActvity.Companion.getUrl()*/).post((RequestBody)builder.build()).build()).enqueue((okhttp3.Callback)new okhttp3.Callback() {
            public void onFailure(final okhttp3.Call call, final IOException ex) {
                if (OkhttpManager.onErrorCallback != null) {
                    final OnHttpErrorCallback access$000 = OkhttpManager.onErrorCallback;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(ex.getMessage());
                    access$000.onError(-2, sb.toString());
                    OkhttpManager.onErrorCallback.onError(-2,sb.toString());
                }
            }

            public void onResponse(final okhttp3.Call call, final okhttp3.Response response) throws IOException {
                if (response.code() == 200) {
                    final String string = response.body().string();
                    final StringBuilder sb = new StringBuilder();
                    sb.append("onResponse: ======\u718a\u732b\u51fa\u5e93\u6210\u529f==");//熊猫出库成功
                    sb.append(string);
                    //XLog.d("OkhttpManager", sb.toString());
                    final PandaOutLibCall pandaOutLibCall = (PandaOutLibCall)JSON.parseObject(string, (Class)PandaOutLibCall.class);
                    if (pandaOutLibCall.getSuccess()) {
                        onOkhttpCallback.onSuccess(pandaOutLibCall);
                        //added by wxw
                        if (mOnOkhttpCallback != null) {
                            mOnOkhttpCallback.onSuccess(pandaOutLibCall);
                        }
                        return;
                    }
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("onSuccess: =======================2==");
                    sb2.append(pandaOutLibCall.getM());
                    //XLog.d("OkhttpManager", sb2.toString());
                    OkhttpManager.onErrorCallback.onError(-2, pandaOutLibCall.getM());
                }
            }
        });
    }

    public static void pandaHarvestUpPic(final Map<String, String> map) {
        final MediaType parse = MediaType.parse("image/jpg");
        final StringBuilder sb = new StringBuilder();
        sb.append(RqService.savePathDay);
        sb.append(map.get("barcode"));
        sb.append("_out.jpg");
        OkhttpManager.okHttpClient.newCall(new Request.Builder().url("http://openapi.pandabg.cn:20099/v3/openBmx"/*ApiPandaHarvestActvity.Companion.getUrl()*/).post((RequestBody)new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("timestamp", (String)map.get("timestamp")).addFormDataPart("accountName", (String)map.get("accountName")).addFormDataPart("apiName", (String)map.get("apiName")).addFormDataPart("token", (String)map.get("token")).addFormDataPart("sign", (String)map.get("sign")).addFormDataPart("bizData", (String)map.get("bizData")).addFormDataPart("picData", "file", RequestBody.create(parse, new File(sb.toString()))).build()).build()).enqueue((okhttp3.Callback)new okhttp3.Callback() {
            public void onFailure(final okhttp3.Call call, final IOException ex) {
            }

            public void onResponse(final okhttp3.Call call, final okhttp3.Response response) throws IOException {
                if (response.code() == 200) {
                    final String string = response.body().string();
                    final StringBuilder sb = new StringBuilder();
                    sb.append("onResponse: =========================");
                    sb.append(string);
                    Log.d("OkhttpManager", sb.toString());
                    final PandaBeanCall pandaBeanCall = (PandaBeanCall)JSON.parseObject(string, (Class)PandaBeanCall.class);
                    if (!pandaBeanCall.getSuccess()) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("\u718a\u732b\u5feb\u6536\u56fe\u7247\u4e0a\u4f20\u6210\u529f:");
                        sb2.append(response.code());
                        sb2.append(pandaBeanCall.getM());
                        //XLog.e(sb2.toString());
                    }
                }
            }
        });
    }

    public static void pandaHarvestUploadBarcodeImage(final Map<String, String> map, final OnOkhttpCallback<CameraCheckOutBean> onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiPandaHarvest().toCameraChectOut(map).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<CameraCheckOutBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u718a\u732b\u5feb\u6536\u6570\u636e\u4e0a\u4f20\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u718a\u732b\u5feb\u6536\u6570\u636e\u4e0a\u4f20\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final CameraCheckOutBean cameraCheckOutBean) {
                if (cameraCheckOutBean != null) {
                    if (cameraCheckOutBean.isSuccess()) {
                        //XLog.e("\u718a\u732b\u5feb\u6536\u6570\u636e\u4e0a\u4f20\u6210\u529f");
                        final OnOkhttpCallback val$okhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                        if (val$okhttpCallback != null) {
                            val$okhttpCallback.onSuccess(cameraCheckOutBean);
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, cameraCheckOutBean.getM());
                    }
                }
            }
        }));
    }

    public static void purchaseAuthCodeV2(final List<String> list, final int n, final int n2, final OnOkhttpCallback<PurchaseAuthCodeV2ResBean<String>> onOkhttpCallback) {
        if (OkhttpManager.JWTTOKEN.isEmpty()) {
            OkhttpManager.JWTTOKEN = getDeviceLoginToken();
        }
        if (OkhttpManager.sn.isEmpty()) {
            OkhttpManager.sn = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number();
        }
        if (OkhttpManager.username.isEmpty()) {
            OkhttpManager.username = RqFilePreference.getInstance().getLoginBean().getUsername();
        }
        final Long value = System.currentTimeMillis();
        final PurchaseAuthCodeV2ReqBean purchaseAuthCodeV2ReqBean = new PurchaseAuthCodeV2ReqBean(OkhttpManager.sn, list, n, n2, String.valueOf(value), "");
        purchaseAuthCodeV2ReqBean.setSign(MD5Util.getEncryptMD5Class(purchaseAuthCodeV2ReqBean.getClass(), value, OkhttpManager.username));
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().purchaseAuthCodeV2(purchaseAuthCodeV2ReqBean, OkhttpManager.JWTTOKEN).enqueue((Callback)new ApiPostStationCallback((ApiPostStationCallback.HttpCallback)new ApiPostStationCallback.HttpCallback<PurchaseAuthCodeV2ResBean<String>>() {
            @Override
            public void onFailure(final int n, final String s) {
            }

            public void onSuccess(final PurchaseAuthCodeV2ResBean<String> purchaseAuthCodeV2ResBean) {
                final StringBuilder sb = new StringBuilder();
                sb.append("onSuccess: ===============");
                sb.append(purchaseAuthCodeV2ResBean.getData());
                Log.d("OkhttpManager", sb.toString());
                onOkhttpCallback.onSuccess(purchaseAuthCodeV2ResBean);
            }
        }));
    }

    public static void purchaseRecord(final OnOkhttpCallback<List<AuthFlowsBean>> onOkhttpCallback) {
        if (OkhttpManager.JWTTOKEN.isEmpty()) {
            OkhttpManager.JWTTOKEN = getDeviceLoginToken();
        }
        if (OkhttpManager.sn.isEmpty()) {
            OkhttpManager.sn = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number();
        }
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().purchaseRecord(OkhttpManager.sn, OkhttpManager.JWTTOKEN).enqueue((Callback)new ApiPostStationCallback((ApiPostStationCallback.HttpCallback)new ApiPostStationCallback.HttpCallback<List<AuthFlowsBean>>() {
            @Override
            public void onFailure(final int n, final String s) {
            }

            public void onSuccess(final List<AuthFlowsBean> list) {
                final StringBuilder sb = new StringBuilder();
                sb.append("onSuccess: =============================");
                sb.append(list);
                Log.d("OkhttpManager", sb.toString());
                onOkhttpCallback.onSuccess(list);
            }
        }));
    }

    public static void queryBarCode(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiBlueShop().queryBarCode(s, 1, 1, 1, "", s2).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<QueryBarCodeBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u84dd\u5e97\u67e5\u8be2\u5355\u53f7\u5931\u8d25 ");//蓝店查询单号失败
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final QueryBarCodeBean queryBarCodeBean) {
                if (queryBarCodeBean != null) {
                    if (queryBarCodeBean.getDatas() != null && queryBarCodeBean.getDatas().size() > 0) {
                        final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                        if (val$okhttpCallback != null) {
                            val$okhttpCallback.onSuccess(queryBarCodeBean);
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, "\u5355\u53f7\u672a\u5165\u5e93");//单号未入库
                    }
                }
            }
        }));
    }

    public static void queryNotGetCode(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiBlueShop().queryBarCode(s, 1, 1, 1, "", s2).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<QueryBarCodeBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u84dd\u5e97\u67e5\u8be2\u672a\u53d6\u5305\u88f9\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final QueryBarCodeBean queryBarCodeBean) {
                if (queryBarCodeBean != null) {
                    if (queryBarCodeBean.getDatas() != null && queryBarCodeBean.getDatas().size() > 0) {
                        final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                        if (val$okhttpCallback != null) {
                            val$okhttpCallback.onSuccess(queryBarCodeBean);
                            ToastSoundUtil.displayToast("\u4f60\u8fd8\u6709\u672a\u53d6\u5305\u88f9");//你还有未取包裹
                        }
                    }
                    else {
                        ToastSoundUtil.displayToast("\u4f60\u6ca1\u6709\u672a\u53d6\u5305\u88f9");//你没有未取包裹
                    }
                }
            }
        }));
    }

    public static void setOnhttpErrorCallback(final OnHttpErrorCallback onErrorCallback) {
        OkhttpManager.onErrorCallback = onErrorCallback;
    }

    public static void setOnhttpErrorCallback(final OnOkhttpCallbackError mOnOkhttpCallbackError) {
        OkhttpManager.mOnOkhttpCallbackError = mOnOkhttpCallbackError;
    }

    public static void setOnOkhttpCallback(final OnOkhttpCallback mOnOkhttpCallback) {
        OkhttpManager.mOnOkhttpCallback = mOnOkhttpCallback;
    }

    public static void stagesmallpoleChuKu1(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiStageSmallPole().stageSmallPoleChuKu1(s, "1", "1", s2, "1").enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JsonObject>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u9a7f\u7ad9\u5c0f\u6241\u51fa\u5e93\u63a5\u53e31\u5931\u8d25 ");//驿站小扁出库接口1失败
                sb.append(s);
                ToastSoundUtil.displayToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final JsonObject jsonObject) {
                int int1 = 0;
                String string;
                try {
                    final JSONObject jsonObject2 = new JSONObject(jsonObject.toString());
                    int1 = int1;
                    final int n = int1 = jsonObject2.getInt("code");
                    string = jsonObject2.getString("message");
                    int1 = n;
                }
                catch (JSONException ex) {
                    ex.printStackTrace();
                    string = "";
                }
                if (int1 == 200) {
                    final SatgeChuKu1 satgeChuKu1 = (SatgeChuKu1)new Gson().fromJson(jsonObject.toString(), (Class)SatgeChuKu1.class);
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(satgeChuKu1);
                    }
                    //added by wxw
                    if (mOnOkhttpCallback != null) {
                        mOnOkhttpCallback.onSuccess(satgeChuKu1);
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, string);
                }
            }
        }));
    }

    public static void stagesmallpoleChuKu2_1(final String s, final String s2, final String s3, final String s4, final OnOkhttpCallback<CourSmallPoleChuKuBean> onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiStageSmallPole().stageSmallPoleChuKu2_1(s, s2, "1", s3, "image/jpeg", s4).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<CourSmallPoleChuKuBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u9a7f\u7ad9\u5c0f\u6241\u62c5\u51fa\u5e93\u5931\u8d25 ");//驿站小扁担出库失败
                sb.append(s);
                ToastSoundUtil.displayToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final CourSmallPoleChuKuBean courSmallPoleChuKuBean) {
                if (courSmallPoleChuKuBean != null) {
                    if (courSmallPoleChuKuBean.getCode() == 200) {
                        final OnOkhttpCallback val$okhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                        if (val$okhttpCallback != null) {
                            val$okhttpCallback.onSuccess(courSmallPoleChuKuBean);
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, courSmallPoleChuKuBean.getMessage());
                    }
                }
            }
        }));
    }

    public static void stagesmallpoleLogin(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiStageSmallPole().stageSmallPoleLogin("android", "1", s, s2).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JsonObject>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u9a7f\u7ad9\u5c0f\u6241\u62c5\u767b\u5f55\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final JsonObject jsonObject) {
                RqFilePreference.getInstance().setStageSmallPoleLoginInfor((StageLoginRequestBean)null);
                int int1;
                String string = "";
                try {
                    final JSONObject jsonObject2 = new JSONObject(jsonObject.toString());
                    int1 = jsonObject2.getInt("code");
                    string = jsonObject2.getString("message");
                }
                catch (JSONException ex) {
                    int1 = 0;
                }
                /*final JSONException ex;
                ex.printStackTrace();*/

                if (int1 == 200) {
                    RqFilePreference.getInstance().setCourierSmallPoleLoginIsZiAccount(0);
                    RqFilePreference.getInstance().setStageSmallPoleLoginInfor((StageLoginRequestBean)new Gson().fromJson(jsonObject.toString(), (Class)StageLoginRequestBean.class));
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(jsonObject);
                    }
                    //added by wxw
                    if (mOnOkhttpCallback != null) {
                        RqFilePreference.getInstance().setSTAGESMALLPOLEAccount(s);
                        RqFilePreference.getInstance().setSTAGESMALLPOLEPwd(s2);
                        mOnOkhttpCallback.onSuccess(jsonObject);
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, string);
                }
            }
        }));
    }

    public static void stagesmallpoleUploadPicture(final CourSmallPoleChuKuBean.DataBean.DataFig dataFig, final String s, final String s2, final Bitmap bitmap, final OnOkhttpCallback<Object> onOkhttpCallback) {
        final MultipartBody.Builder addFormDataPart = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("callback", dataFig.getCallback());
        final StringBuilder sb = new StringBuilder();
        sb.append(dataFig.getDir());
        sb.append(dataFig.getSavefile());
        final MultipartBody build = addFormDataPart.addFormDataPart("key", sb.toString()).addFormDataPart("OSSAccessKeyId", dataFig.getAccessid()).addFormDataPart("policy", dataFig.getPolicy()).addFormDataPart("signature", dataFig.getSignature()).addFormDataPart("file", s2, RequestBody.create(MediaType.parse("application/octet-stream"), ImageSaveUtil.getInstance().bitmapToBytes(bitmap))).build();
        if (build == null) {
            return;
        }
        MyApplication.getDaggerReposifitComponent().getRequestApiXiaoBianDan().courSmallPoleUpLoadImg(s, build).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<Object>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u9a7f\u7ad9\u5c0f\u6241\u62c5\u4e0a\u4f20\u56fe\u7247\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u9a7f\u7ad9\u5c0f\u6241\u62c5\u4e0a\u4f20\u56fe\u7247\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.displayToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            @Override
            public void onSuccess(final Object o) {
                if (o != null) {
                    //XLog.e("\u9a7f\u7ad9\u5c0f\u6241\u62c5\u4e0a\u4f20\u56fe\u7247\u6210\u529f");
                    final OnOkhttpCallback val$okhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(o);
                    }
                }
            }
        }));
    }

    public static void stationHelperBarCode(final String s, final StationHelperRequestBean stationHelperRequestBean, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiStationHelper().stationHelperCheckBarcode(s, stationHelperRequestBean).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<StationHelperResponseBarcodeBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u67e5\u8be2\u8ba2\u5355\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final StationHelperResponseBarcodeBean stationHelperResponseBarcodeBean) {
                if (stationHelperResponseBarcodeBean != null) {
                    if (stationHelperResponseBarcodeBean.getRetCode() == 0) {
                        if (onOkhttpCallback != null) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("");
                            sb.append(stationHelperResponseBarcodeBean.getExpressPackLst().get(0).getExpressId());
                            Log.d("qinkang", sb.toString());
                            RqFilePreference.getInstance().setStationInfor(stationHelperResponseBarcodeBean.getExpressPackLst().get(0).getExpressId());
                            onOkhttpCallback.onSuccess(stationHelperResponseBarcodeBean);
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, stationHelperResponseBarcodeBean.getErrMsg());
                    }
                }
            }
        }));
    }

    public static void stationHelperLogin(final Context context, final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG,"stationHelperLogin begin:password="+MD5Util.encodeMd5(s2));
                final /* synthetic */ StationHelperLoginBean bean = new StationHelperLoginBean(s, MD5Util.encodeMd5(s2));
                try {
                    Log.e(TAG,"stationHelperLogin 11111:");
                    final retrofit2.Response execute = MyApplication.getDaggerReposifitComponent().getRequestApiStationHelper().stationHelperLogin(bean).execute();
                    final String value = execute.headers().get("Authorication");
                    Log.e(TAG,"stationHelperLogin value:"+value);
                    final StationHelperRequestLoginBean stationHelperLoginfor = (StationHelperRequestLoginBean)new Gson().fromJson(((ResponseBody)execute.body()).string(), (Class)StationHelperRequestLoginBean.class);
                    stationHelperLoginfor.setAuthorication(value);
                    Log.e(TAG,"stationHelperLogin 2222:");
                    RqFilePreference.getInstance().setStationHelperLoginfor(stationHelperLoginfor);
                    Log.e(TAG,"stationHelperLogin 33333:");
                    ((Activity)context).runOnUiThread((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            Log.e(TAG,"stationHelperLogin 44444:");
                            final StationHelperRequestLoginBean val$data = stationHelperLoginfor;
                            if (val$data != null) {
                                Log.e(TAG,"stationHelperLogin 4444455:"+val$data.getRetCode());
                                if (val$data.getRetCode() == 0) {
                                    //XLog.e("\u9a7f\u7ad9\u52a9\u624b\u767b\u5f55\u6210\u529f");
                                    if (onOkhttpCallback != null) {
                                        Log.e(TAG,"stationHelperLogin 55555:");
                                        RqFilePreference.getInstance().setSTATIONHELPERAccount(s);
                                        RqFilePreference.getInstance().setSTATIONHELPERPwd(s2);

                                        onOkhttpCallback.onSuccess(stationHelperLoginfor);
                                    }
                                }
                                else if (OkhttpManager.onErrorCallback != null) {
                                    Log.e(TAG,"stationHelperLogin 6666:");
                                    OkhttpManager.onErrorCallback.onError(-2, stationHelperLoginfor.getErrMsg());
                                }
                            }
                            else if (OkhttpManager.onErrorCallback != null) {
                                Log.e(TAG,"stationHelperLogin 7777:");
                                OkhttpManager.onErrorCallback.onError(-2, stationHelperLoginfor.getErrMsg());
                            }
                        }
                    });
                    Log.e(TAG,"stationHelperLogin 888888:");
                }
                catch (IOException ex) {
                    ((Activity)context).runOnUiThread((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (OkhttpManager.onErrorCallback != null) {
                                Log.e(TAG,"stationHelperLogin 999999:");
                                OkhttpManager.onErrorCallback.onError(-2, ex.getMessage());
                            }
                        }
                    });
                    ex.printStackTrace();
                }
                Log.e(TAG,"stationHelperLogin end:");
            }
        }).start();

    }

    public static void stationHelperUploadOutLibrary(final String s, final StationHelperRequestChuKuBean stationHelperRequestChuKuBean, final OnOkhttpCallback onOkhttpCallback) {
        try {
            MyApplication.getDaggerReposifitComponent().getRequestApiStationHelper().stationHelperChuKu(s, stationHelperRequestChuKuBean).enqueue(new CommonApiCallback(new CommonApiCallback.HttpCallback<StationHelperResponseChuKuBean>() {
                @Override
                public void onFailure(final int n, final String s) {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, s);
                    }
                }

                public void onSuccess(final StationHelperResponseChuKuBean stationHelperResponseChuKuBean) {
                        /*try {
                            Log.i(TAG, ((ResponseBody)response.body()).string().toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }*/



                    /*StationHelperResponseChuKuBean stationHelperResponseChuKuBean = null;*/
                    if (stationHelperResponseChuKuBean != null) {
                        if (stationHelperResponseChuKuBean.getRetCode() == 0) {
                            final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                            //added by wxw
                            if (OkhttpManager.mOnOkhttpCallback != null) {
                                OkhttpManager.mOnOkhttpCallback.onSuccess(stationHelperResponseChuKuBean);
                            }
                            if (val$okhttpCallback != null) {
                                val$okhttpCallback.onSuccess(stationHelperResponseChuKuBean);
                                return;
                            }
                            if (OkhttpManager.onErrorCallback != null) {
                                OkhttpManager.onErrorCallback.onError(-2, stationHelperResponseChuKuBean.getErrMsg());
                            }
                        }
                        else if (OkhttpManager.onErrorCallback != null) {
                            OkhttpManager.onErrorCallback.onError(-2, stationHelperResponseChuKuBean.getErrMsg());
                        }
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void suDiYiImageUpload(final String s, final File file, final File file2, final String s2, final String s3, final Long n, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiSuDiYi().uploadImageData(n.toString(), s2, s3, (RequestBody)new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("expressImage", "1", RequestBody.create(MediaType.parse("image/jpg"), file)).addFormDataPart("userImage", "2", RequestBody.create(MediaType.parse("image/jpg"), file2)).addFormDataPart("expressNo", s).build()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<SuDiYiResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u56fe\u7247\u4e0a\u4f20\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final SuDiYiResponseBean suDiYiResponseBean) {
                if (suDiYiResponseBean.getCode() == 200) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(suDiYiResponseBean);
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, suDiYiResponseBean.getMessage());
                }
            }
        }));
    }

    public static void suDiYiUpload(final Long n, final String s, final String s2, final String s3, final OnOkhttpCallback onOkhttpCallback) {
        final HashMap<String, HashMap<String, String>> hashMap = new HashMap<String, HashMap<String, String>>();
        OkhttpManager.header.put("time", n);
        OkhttpManager.header.put("source", RqFilePreference.getInstance().getSdySource());
        OkhttpManager.header.put("target", RqFilePreference.getInstance().getSdyTarget());
        final HashMap<String, String> hashMap2 = new HashMap<String, String>();
        hashMap2.put("expressNo", s);
        hashMap2.put("deviceId", RqFilePreference.getInstance().getSdyDeviceId());
        hashMap2.put("expressImage", "tupian");
        hashMap2.put("userImage", "tupian");
        hashMap.put("body", hashMap2);
        //hashMap.put("header", (HashMap<String, String>)OkhttpManager.header);
        MyApplication.getDaggerReposifitComponent().getRequestApiSuDiYi().suDiYiuploadData(n.toString(), s2, s3, RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson((Object)hashMap))).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<SuDiYiResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u901f\u9012\u6613\u4e0a\u4f20\u9519\u8bef");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final SuDiYiResponseBean suDiYiResponseBean) {
                if (suDiYiResponseBean.getCode() == 200) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(suDiYiResponseBean);
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, suDiYiResponseBean.getMessage());
                }
            }
        }));
    }

    public static void tokenRefresh(final TokenRefreshBean tokenRefreshBean) {
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().tokenRefresh(tokenRefreshBean).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<TokenRefreshBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                OkhttpManager.isTokenAvailable = false;
                final StringBuilder sb = new StringBuilder();
                sb.append("onFailure: =============\u5237\u65b0TOKEN\u5931\u8d25==============");
                sb.append(n);
                Log.d("OkhttpManager", sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u5237\u65b0TOKEN\u5931\u8d25:");
                sb2.append(n);
                sb2.append("  ");
                sb2.append(s);
                //XLog.e(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final TokenRefreshBean tokenRefreshBean) {
                OkhttpManager.isTokenAvailable = true;
                Log.d("OkhttpManager", "onSuccess: =============\u5237\u65b0TOKEN\u6210\u529f==============");
                //XLog.e("\u5237\u65b0TOKEN\u6210\u529f");
                final DeviceLoginBean loginBean = RqFilePreference.getInstance().getLoginBean();
                loginBean.setToken(tokenRefreshBean.getToken());
                RqFilePreference.getInstance().setLoginInformation(loginBean);
                RqFilePreference.getInstance().setRefreshTokenDate(DateUtil.getToday());
            }
        }));
    }

    public static void trialDelete(final OnOkhttpCallback<String> onOkhttpCallback) {
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            final TrialtoDelete trialtoDelete = new TrialtoDelete(FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number(), Long.toString(currentTimeMillis), "");
            trialtoDelete.setSign(MD5Util.getEncryptMD5Class(trialtoDelete.getClass(), currentTimeMillis, RqFilePreference.getInstance().getLoginBean().getUsername()));
            MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().trialDelete(trialtoDelete, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<String>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u6e05\u7406\u672a\u652f\u4ed8\u8ba2\u5355\u5f02\u5e38:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                }

                public void onSuccess(final String s) {
                    final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(s);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void trialtoVoid(final String s, final OnOkhttpCallback<String> onOkhttpCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        final TrialtoVoid trialtoVoid = new TrialtoVoid(s, Long.toString(currentTimeMillis), "");
        trialtoVoid.setSign(MD5Util.getEncryptMD5Class(trialtoVoid.getClass(), currentTimeMillis, RqFilePreference.getInstance().getLoginBean().getUsername()));
        try {
            MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().trialtoVoid(trialtoVoid, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<String>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u5f85\u4ed8\u6b3e\u8ba2\u5355\u4f5c\u5e9f\u5f02\u5e38:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                }

                public void onSuccess(final String s) {
                    final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(s);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void uploadArrivePieceData(final UploadEntryStoreBean uploadEntryStoreBean) {
        MyApplication.getDaggerReposifitComponent().getRequestApiJoyFinder().uploadEntryStoreData(uploadEntryStoreBean, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<String>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e0a\u4f20\u5bc4\u4ef6\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final String s) {
                //XLog.e("\u4e0a\u4f20\u5bc4\u4ef6\u6210\u529f");
                final ContentValues contentValues = new ContentValues();
                contentValues.put("uploadStatus", Integer.valueOf(1));
                //LitePalManager.updateByConditions(ScanArrivePieceTableBean.class, contentValues, "barcode = ?", uploadEntryStoreBean.getExpress_no());
            }
        }));
    }

    public static void uploadDeviceMixType(final DeviceMixTypeBean deviceMixTypeBean) {
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().uploadDeviceMixType(deviceMixTypeBean, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<String>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e0a\u4f20\u8bbe\u5907\u7684\u9a7f\u7ad9\u7c7b\u578b\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
            }

            public void onSuccess(final String s) {
                //XLog.e("\u4e0a\u4f20\u8bbe\u5907\u7684\u9a7f\u7ad9\u7c7b\u578b\u6210\u529f");
            }
        }));
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static void uploadDeviceRuntime(final long n) {
        try {
            final long totalExternalMemorySize = SdCard.getTotalExternalMemorySize();
            final long freeSpace = SdCard.getFreeSpace();
            final long currentTimeMillis = System.currentTimeMillis();
            final DeviceRuntimeBean deviceRuntimeBean = new DeviceRuntimeBean();
            deviceRuntimeBean.setCount_date(DateUtil.getToday());
            deviceRuntimeBean.setDuration((int)n);
            deviceRuntimeBean.setCurrent_space(totalExternalMemorySize - freeSpace);
            deviceRuntimeBean.setNative_space(totalExternalMemorySize);
            deviceRuntimeBean.setSerial_number(FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number());
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(currentTimeMillis);
            deviceRuntimeBean.setTimestamp(sb.toString());
            deviceRuntimeBean.setSign(MD5Util.getEncryptMD5Class(deviceRuntimeBean.getClass(), currentTimeMillis, RqFilePreference.getInstance().getLoginBean().getUsername()));
            MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().uploadDeviceRuntime(deviceRuntimeBean, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<String>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u4e0a\u4f20\u8fd0\u884c\u65f6\u957f\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                    //OkhttpManager.onErrorCallback;
                }

                public void onSuccess(final String s) {
                    //XLog.e("\u4e0a\u4f20\u8fd0\u884c\u65f6\u957f\u6210\u529f");
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void uploadDispatchPieceData(final UploadDispatchBean uploadDispatchBean) {
        MyApplication.getDaggerReposifitComponent().getRequestApiJoyFinder().uploadDispatchData(uploadDispatchBean, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<String>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e0a\u4f20\u6d3e\u4ef6\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final String s) {
                //XLog.e("\u4e0a\u4f20\u6d3e\u4ef6\u6210\u529f");
                final ContentValues contentValues = new ContentValues();
                contentValues.put("uploadStatus", Integer.valueOf(1));
                //LitePalManager.updateByConditions(ScanDispatchPieceTableBean.class, contentValues, "barcode = ?", uploadDispatchBean.getExpress_no());
            }
        }));
    }

    public static void uploadOutLibraryData(final OutLibraryCensus outLibraryCensus) {
        try {
            MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().uploadData(outLibraryCensus, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<String>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u4e0a\u4f20\u51fa\u5e93\u7edf\u8ba1\u6570\u636e\u6210\u529f:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, s);
                    }
                }

                public void onSuccess(final String s) {
                    //XLog.e("\u4e0a\u4f20\u51fa\u5e93\u7edf\u8ba1\u6570\u636e\u6210\u529f");
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void uploadOutlibraryPieceData(final UploadOutLibraryBean uploadOutLibraryBean) {
        MyApplication.getDaggerReposifitComponent().getRequestApiJoyFinder().uploadOutLibraryData(uploadOutLibraryBean, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<String>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e0a\u4f20\u53d6\u4ef6\u51fa\u5e93\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final String s) {
                //XLog.e("\u4e0a\u4f20\u53d6\u4ef6\u51fa\u5e93\u6210\u529f");
                final ContentValues contentValues = new ContentValues();
                contentValues.put("uploadStatus", Integer.valueOf(1));
                //LitePalManager.updateByConditions(ScanOutLibraryPieceTableBean.class, contentValues, "barcode = ?", uploadOutLibraryBean.getExpress_no());
            }
        }));
    }

    public static void uploadPeoblem(final Peoblem peoblem, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().uploadPeoblem(peoblem, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<String>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u767b\u5165\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                ToastSoundUtil.wrongSoundToast(s);
            }

            public void onSuccess(final String s) {
                //XLog.e("\u8fd0\u884c\u65e5\u5fd7\u4e0a\u4f20\u6210\u529f");
                final OnOkhttpCallback val$onOkhttpCallback = onOkhttpCallback;
                if (val$onOkhttpCallback != null) {
                    val$onOkhttpCallback.onSuccess(s);
                }
            }
        }));
    }

    public static void uploadSendPieceData(final UploadSendPieceDataBean uploadSendPieceDataBean) {
        MyApplication.getDaggerReposifitComponent().getRequestApiJoyFinder().uploadSendInformationData(uploadSendPieceDataBean, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<String>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e0a\u4f20\u5bc4\u4ef6\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final String s) {
                //XLog.e("\u4e0a\u4f20\u5bc4\u4ef6\u6210\u529f");
                final ContentValues contentValues = new ContentValues();
                contentValues.put("uploadStatus", Integer.valueOf(1));
                //LitePalManager.updateByConditions(ScanSendPieceTableBean.class, contentValues, "barcode = ?", uploadSendPieceDataBean.getExpress_no());
            }
        }));
    }

    public static void wechatPay(final List<String> list, final OnOkhttpCallback<PurchaseAuthCodeV2ResBean<WechatPayResBean>> onOkhttpCallback) {
        if (OkhttpManager.JWTTOKEN.isEmpty()) {
            OkhttpManager.JWTTOKEN = getDeviceLoginToken();
        }
        if (OkhttpManager.sn.isEmpty()) {
            OkhttpManager.sn = FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number();
        }
        if (OkhttpManager.username.isEmpty()) {
            OkhttpManager.username = RqFilePreference.getInstance().getLoginBean().getUsername();
        }
        final Long value = System.currentTimeMillis();
        final StringBuilder sb = new StringBuilder();
        sb.append("wechatPay: =====================");
        sb.append(OkhttpManager.username);
        Log.d("OkhttpManager", sb.toString());
        final PurchaseAuthCodeV2ReqBean purchaseAuthCodeV2ReqBean = new PurchaseAuthCodeV2ReqBean(OkhttpManager.sn, list, 0, 1, String.valueOf(value), "");
        purchaseAuthCodeV2ReqBean.setSign(MD5Util.getEncryptMD5Class(purchaseAuthCodeV2ReqBean.getClass(), value, OkhttpManager.username));
        MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().wechatPay(purchaseAuthCodeV2ReqBean, OkhttpManager.JWTTOKEN).enqueue((Callback)new ApiPostStationCallback((ApiPostStationCallback.HttpCallback)new ApiPostStationCallback.HttpCallback<PurchaseAuthCodeV2ResBean<WechatPayResBean>>() {
            @Override
            public void onFailure(final int n, final String s) {
            }

            public void onSuccess(final PurchaseAuthCodeV2ResBean<WechatPayResBean> purchaseAuthCodeV2ResBean) {
                onOkhttpCallback.onSuccess(purchaseAuthCodeV2ResBean);
            }
        }));
    }

    public static void wxTrialGetpay(final int n, final OnOkhttpCallback<Payment<WXPayment>> onOkhttpCallback) {
        try {
            MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().getWXTrialGetpay(n, "0", getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<Payment<WXPayment>>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u5fae\u4fe1\u652f\u4ed8\u83b7\u53d6\u5f02\u5e38:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                }

                public void onSuccess(final Payment<WXPayment> payment) {
                    final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(payment);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void wxTrialRenew(final String s, final int n, final OnOkhttpCallback<Payment<WXPayment>> onOkhttpCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        final TrialRenew trialRenew = new TrialRenew(FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number(), s, n, 1.0f, "0", Long.toString(currentTimeMillis), "");
        trialRenew.setSign(MD5Util.getEncryptMD5Class(trialRenew.getClass(), currentTimeMillis, RqFilePreference.getInstance().getLoginBean().getUsername()));
        try {
            MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().wxTrialRenew(trialRenew, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<Payment<WXPayment>>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u79df\u7528\u5230\u671f\u7eed\u5f02\u5e38:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                }

                public void onSuccess(final Payment<WXPayment> payment) {
                    final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(payment);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void xiNiaoGaoPai(final GaoPaiYiRequest gaoPaiYiRequest, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiXiNiaoGaoPai().xiNiaoGaoPai(gaoPaiYiRequest.getWaybillNo(), gaoPaiYiRequest.getUnionCode(), gaoPaiYiRequest.getDeviceCode(), gaoPaiYiRequest.getTimestamp(), gaoPaiYiRequest.getSignature(), gaoPaiYiRequest.getPhotoSignLink(), gaoPaiYiRequest.getManufacturer(), gaoPaiYiRequest.getDeviceNumber(), gaoPaiYiRequest.getVersion()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<GaoPaiResponse>() {
            @Override
            public void onFailure(final int n, final String s) {
                if (OkhttpManager.onErrorCallback != null) {
                    final OnHttpErrorCallback access$000 = OkhttpManager.onErrorCallback;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(s);
                    access$000.onError(-2, sb.toString());
                }
            }

            public void onSuccess(final GaoPaiResponse gaoPaiResponse) {
                if (gaoPaiResponse != null && gaoPaiResponse.isSuccess() && "40".equals(gaoPaiResponse.getErrorCode())) {
                    onOkhttpCallback.onSuccess(gaoPaiResponse);
                    return;
                }
                if (OkhttpManager.onErrorCallback != null) {
                    final OnHttpErrorCallback access$000 = OkhttpManager.onErrorCallback;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(gaoPaiResponse.getErrorMsg());
                    access$000.onError(-2, sb.toString());
                }
            }
        }));
    }

    public static void xiNiaoGaoPaiLogin(final GaoPaiYiRequest gaoPaiYiRequest, final String s, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiXiNiaoGaoPai().xiNiaoGaoPai(gaoPaiYiRequest.getWaybillNo(), gaoPaiYiRequest.getUnionCode(), gaoPaiYiRequest.getDeviceCode(), gaoPaiYiRequest.getTimestamp(), gaoPaiYiRequest.getSignature(), gaoPaiYiRequest.getPhotoSignLink(), gaoPaiYiRequest.getManufacturer(), gaoPaiYiRequest.getDeviceNumber(), gaoPaiYiRequest.getVersion()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<GaoPaiResponse>() {
            @Override
            public void onFailure(final int n, final String s) {
                if (OkhttpManager.onErrorCallback != null) {
                    final OnHttpErrorCallback access$000 = OkhttpManager.onErrorCallback;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(s);
                    access$000.onError(-2, sb.toString());
                }
            }

            public void onSuccess(final GaoPaiResponse gaoPaiResponse) {
                if (gaoPaiResponse != null && gaoPaiResponse.isSuccess()) {
                    final XiNiaoGaoPaiLoginBean xiNiaoGaoPaiLoginInfor = new XiNiaoGaoPaiLoginBean();
                    xiNiaoGaoPaiLoginInfor.setDeviceCode(gaoPaiYiRequest.getDeviceCode());
                    xiNiaoGaoPaiLoginInfor.setKey(s);
                    xiNiaoGaoPaiLoginInfor.setUnionCode(gaoPaiYiRequest.getUnionCode());
                    RqFilePreference.getInstance().setLoginUsername("xiniaogaopai");
                    RqFilePreference.getInstance().setXiNiaoGaoPaiLoginInfor(xiNiaoGaoPaiLoginInfor);
                    onOkhttpCallback.onSuccess(gaoPaiResponse);
                    return;
                }
                if (OkhttpManager.onErrorCallback != null) {
                    final OnHttpErrorCallback access$000 = OkhttpManager.onErrorCallback;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(gaoPaiResponse.getErrorMsg());
                    access$000.onError(-2, sb.toString());
                }
            }
        }));
    }

    public static void xiaobinLogin(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiXiaoBin().xiaobinLogin(s, s2).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<XiaoBinLoginResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u5c0f\u5175\u767b\u5f55\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u5c0f\u5175\u767b\u5f55\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final XiaoBinLoginResponseBean xiaoBingLoginInfor) {
                RqFilePreference.getInstance().setXiaoBingLoginInfor(xiaoBingLoginInfor);
                if (xiaoBingLoginInfor != null) {
                    if (xiaoBingLoginInfor.isCode()) {
                        final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                        if (val$okhttpCallback != null) {
                            RqFilePreference.getInstance().setXIAOBINGSTATIONAccount(s);
                            RqFilePreference.getInstance().setXIAOBINGSTATIONPwd(s2);
                            val$okhttpCallback.onSuccess(xiaoBingLoginInfor);
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, xiaoBingLoginInfor.getMsg());
                    }
                }
            }
        }));
    }

    public static void xiaobinUploadBarcodeImage(final String s, final String s2, final String s3, final Bitmap bitmap, final OnOkhttpCallback<XiaoBingUploadResponseBean> onOkhttpCallback) {
        final RequestBody requestBody = null;
        /*while (true) {
            if (bitmap != null) {
                Block_1: {
                    break Block_1;
                    Label_0146:
                    while (true) {
                        RequestBody requestBody2;
                        do {
                            Label_0060: {
                                break Label_0060;
                                try {
                                    requestBody2 = RequestBody.create(MediaType.parse("image/png"), ImageSaveUtil.getInstance().bitmapToBytes(bitmap));
                                    continue Label_0146;
                                    // iftrue(Label_0146:, !StringUtil.isNotEmpty(s2))
                                    while (true) {
                                        requestBody2 = RequestBody.create(MediaType.parse("image/png"), new File(s2));
                                        continue Label_0146;
                                        requestBody2 = requestBody;
                                        continue;
                                    }
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append(" ");
                                    sb.append(s3);
                                    sb.append(".jpg");
                                    MyApplication.getDaggerReposifitComponent().getRequestApiXiaoBin().xiaobinUploadBarcodePicture(s3, s, MultipartBody.Part.createFormData(" waybillImage", sb.toString(), requestBody2)).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<XiaoBingUploadResponseBean>() {
                                        @Override
                                        public void onFailure(final int n, final String s) {
                                            final StringBuilder sb = new StringBuilder();
                                            sb.append("\u5c0f\u5175\u6570\u636e\u4e0a\u4f20\u5931\u8d25:");
                                            sb.append(n);
                                            sb.append("  ");
                                            sb.append(s);
                                            //XLog.e(sb.toString());
                                            final StringBuilder sb2 = new StringBuilder();
                                            sb2.append("\u5c0f\u5175\u6570\u636e\u4e0a\u4f20\u5931\u8d25 ");
                                            sb2.append(s);
                                            ToastSoundUtil.wrongSoundToast(sb2.toString());
                                            if (OkhttpManager.onErrorCallback != null) {
                                                OkhttpManager.onErrorCallback.onError(n, s);
                                            }
                                        }

                                        public void onSuccess(final XiaoBingUploadResponseBean xiaoBingUploadResponseBean) {
                                            if (xiaoBingUploadResponseBean != null) {
                                                if (xiaoBingUploadResponseBean.isCode()) {
                                                    //XLog.e("\u5c0f\u5175\u6570\u636e\u4e0a\u4f20\u6210\u529f");
                                                    final OnOkhttpCallback val$okhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                                                    if (val$okhttpCallback != null) {
                                                        val$okhttpCallback.onSuccess(xiaoBingUploadResponseBean);
                                                    }
                                                }
                                                else if (OkhttpManager.onErrorCallback != null) {
                                                    OkhttpManager.onErrorCallback.onError(-2, xiaoBingUploadResponseBean.getMsg());
                                                }
                                            }
                                        }
                                    }));
                                    return;
                                }
                                catch (Exception ex) {
                                    ex.printStackTrace();
                                    return;
                                }
                            }
                            continue Label_0146;
                        } while (requestBody2 != null);
                        break;
                    }
                }
                return;
            }
            continue;
        }*/
    }

    public static void xingHuoLogin(final Context context, final String s, final XingHuoLoginBean xingHuoLoginBean, final OnOkhttpCallback onOkhttpCallback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ((Activity)context).runOnUiThread((Runnable)new Runnable() {
                        final /* synthetic */ retrofit2.Response val$execute = MyApplication.getDaggerReposifitComponent().getXingHuo().xingHuoLogin(xingHuoLoginBean.getLoginType(), xingHuoLoginBean.getRememberMe(), xingHuoLoginBean.getUserName(), xingHuoLoginBean.getPassword(), s).execute();

                        @Override
                        public void run() {
                            if (this.val$execute.code() != 200) {
                                OkhttpManager.onErrorCallback.onError(this.val$execute.code(), this.val$execute.message());
                                return;
                            }
                            final XingHuoResponse xingHuoResponse = (XingHuoResponse)JsonUtil.getClazzByGson(JsonUtil.getJsonStringByGson(this.val$execute.body()), XingHuoResponse.class);
                            RqFilePreference.getInstance().setKeyAndCookie(new PubkeyAndCookie("", this.val$execute.headers().get("Set-Cookie")));
                            if (xingHuoResponse.isSuccess()) {
                                onOkhttpCallback.onSuccess(xingHuoResponse);
                                return;
                            }
                            OkhttpManager.onErrorCallback.onError(xingHuoResponse.getErrorCode(), xingHuoResponse.getErrorMsg());
                        }
                    });
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                    ((Activity)context).runOnUiThread((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            OkhttpManager.onErrorCallback.onError(-2, ex.getMessage());
                        }
                    });
                }
            }
        }).start();
    }

    public static void xingHuoNotOutSearch(final String s, final XingHuoNotOutLibrary xingHuoNotOutLibrary, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getXingHuo().xingHuoPhonePickUp(s, xingHuoNotOutLibrary).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<NotOutLibraryResponse>() {
            @Override
            public void onFailure(final int n, final String s) {
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, s);
                }
            }

            public void onSuccess(final NotOutLibraryResponse notOutLibraryResponse) {
                if (notOutLibraryResponse.isSuccess()) {
                    onOkhttpCallback.onSuccess(notOutLibraryResponse);
                    return;
                }
                OkhttpManager.onErrorCallback.onError(-2, notOutLibraryResponse.getErrorMsg());
            }
        }));
    }

    public static void xingHuoOutLibrary(final String s, final XingHuoOutLibrary xingHuoOutLibrary, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getXingHuo().xingHuoOutLibrary(s, xingHuoOutLibrary).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<XingHuoOutLibraryReponse>() {
            @Override
            public void onFailure(final int n, final String s) {
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, s);
                }
            }

            public void onSuccess(final XingHuoOutLibraryReponse xingHuoOutLibraryReponse) {
                if (!xingHuoOutLibraryReponse.isSuccess()) {
                    OkhttpManager.onErrorCallback.onError(-2, xingHuoOutLibraryReponse.getErrorMsg());
                    return;
                }
                if (xingHuoOutLibraryReponse.getResult().getResultCode() == 1) {
                    onOkhttpCallback.onSuccess(xingHuoOutLibraryReponse);
                    return;
                }
                OkhttpManager.onErrorCallback.onError(-2, xingHuoOutLibraryReponse.getResult().getResultDesc());
            }
        }));
    }

    public static void xingHuoPublicKye(final Context context, final OnOkhttpCallback onOkhttpCallback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ((Activity)context).runOnUiThread((Runnable)new Runnable() {
                        final /* synthetic */ retrofit2.Response val$execute = MyApplication.getDaggerReposifitComponent().getXingHuo().getPublicKey().execute();

                        @Override
                        public void run() {
                            if (this.val$execute.code() != 200) {
                                OkhttpManager.onErrorCallback.onError(this.val$execute.code(), this.val$execute.message());
                                return;
                            }
                            final String value = this.val$execute.headers().get("Set-Cookie");
                            final PublicKeyBean publicKeyBean = (PublicKeyBean)JsonUtil.getClazzByGson(JsonUtil.getJsonStringByGson(this.val$execute.body()), PublicKeyBean.class);
                            publicKeyBean.setCookie(value);
                            if (publicKeyBean.isSuccess()) {
                                onOkhttpCallback.onSuccess(publicKeyBean);
                                return;
                            }
                            OkhttpManager.onErrorCallback.onError(-2, publicKeyBean.getErrorMsg());
                        }
                    });
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                    ((Activity)context).runOnUiThread((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            OkhttpManager.onErrorCallback.onError(-2, ex.getMessage());
                        }
                    });
                }
            }
        }).start();
    }

    public static void yShouFaGetNeedPayment(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiYshouFa().getNeedPayment(s, s2, OkhttpManager.yishoufaVersion).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<GetNeedPaymentResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u9a7f\u6536\u53d1\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final GetNeedPaymentResponseBean getNeedPaymentResponseBean) {
                if (getNeedPaymentResponseBean.getCode() == 200) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(getNeedPaymentResponseBean);
                    }
                }
                else {
                    ToastSoundUtil.wrongSoundToast(getNeedPaymentResponseBean.getMsg());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(100, JsonUtil.getJsonStringByGson(getNeedPaymentResponseBean));
                    }
                }
            }
        }));
    }
    public static String get(String key, String defValue) {
        // android.os.SystemProperties
        // public static String get(String key, String def)
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("get", String.class, String.class);
            return (String) method.invoke(null, key, defValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e("yyyyy","------"+defValue);
        return defValue;
    }
    public static void yShouFaLogin(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        try {
//            final String bluetoothAddress = PandaBeanKt.getBluetoothAddress();
//            if (bluetoothAddress != null) {
//
//            }
            //OkhttpManager.BLE_ADDRESS = "f64046000058";
            //OkhttpManager.BLE_ADDRESS = "38fbd30ec49a";

            OkhttpManager.BLE_ADDRESS = get("boogoob.kaicom.bt.mac","f64046000058").replace(":", "").toLowerCase();
            Log.e("yyyyy","------"+OkhttpManager.BLE_ADDRESS);
            final YXDLoginBean yxdLoginBean = new YXDLoginBean(s, YXDUtil.publicKeyEncryptN(s2), "password", "all", OkhttpManager.BLE_ADDRESS);
            final TreeMap<String, String> treeMap = new TreeMap<String, String>();
            treeMap.put("BODY", YXDUtil.md5(new String(JSON.toJSONString((Object)yxdLoginBean).getBytes())));
            treeMap.put("METHOD", "POST");
            treeMap.put("X-Ca-Nonce", UUID.randomUUID().toString());
            treeMap.put("X-Ca-Sign-Type", "MD5");
            treeMap.put("X-Ca-Timestamp", String.valueOf(System.currentTimeMillis()));
            final StringBuilder sb = new StringBuilder();
            sb.append("Basic ");
            sb.append(YXDUtil.generateLoginAuthorization());

            MyApplication.getDaggerReposifitComponent().getRequestApiYshouFa().login(yxdLoginBean, (String)treeMap.get("X-Ca-Sign-Type"),
                    (String)treeMap.get("X-Ca-Nonce"), (String)treeMap.get("X-Ca-Timestamp"),
                    YXDUtil.buildArgsN((SortedMap<String, String>)treeMap, YXDUtil.clientSecret),
                    sb.toString() ,
                    "true","Keep-Alive","Android",Build.VERSION.RELEASE,"4.7.0",OkhttpManager.BLE_ADDRESS
                    ,Build.MODEL,"Android","application/json;charset=UTF-8").enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<YXDHttpCallBack<YXDLoginResBean>>() {
                @Override
                public void onFailure(final int n, final String s) {
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, "登录失败");
                    }
                }

                public void onSuccess(final YXDHttpCallBack<YXDLoginResBean> yxdHttpCallBack) {
                    if (yxdHttpCallBack != null) {
                        if (yxdHttpCallBack.getSuccess()) {
                            OkhttpManager.YIXIAODIAN_TOKEN = yxdHttpCallBack.getData().getAccessToken();
                            final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                            if (val$okhttpCallback != null) {
                                val$okhttpCallback.onSuccess(yxdHttpCallBack.getData());
                                RqFilePreference.getInstance().setYSHOUFAAccount(s);
                                RqFilePreference.getInstance().setYSHOUFAPwd(s2);
                                //RqFilePreference.getInstance().setYShoufaToken(y);
                            }
                        } else {
                            Log.e("yyyyy","----"+yxdHttpCallBack.getMsg());
                            OkhttpManager.onErrorCallback.onError(0, yxdHttpCallBack.getMsg());
                        }
                    } else {
                        OkhttpManager.onErrorCallback.onError(0, "Login fail, something wrong!");
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void yShouFaQuerySendOrder(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiYshouFa().querySendOrder(new QuerySendOrderRequestBean(1, s), s2, OkhttpManager.yishoufaVersion).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<QuerySendOrderResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u9a7f\u6536\u53d1\u67e5\u8be2\u5355\u53f7\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final QuerySendOrderResponseBean querySendOrderResponseBean) {
                if (querySendOrderResponseBean.getCode() == 200) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(querySendOrderResponseBean);
                        if (querySendOrderResponseBean.getTotal() < 0) {
                            OkhttpManager.onErrorCallback.onError(100, "\u672a\u67e5\u8be2\u5230\u51fa\u5e93\u5355\u53f7");
                        }
                    }
                }
                else {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u9a7f\u6536\u53d1\u67e5\u8be2\u5355\u53f7\u5931\u8d25: ");
                    sb.append(querySendOrderResponseBean.getMsg());
                    ToastSoundUtil.wrongSoundToast(sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(100, JsonUtil.getJsonStringByGson(querySendOrderResponseBean));
                    }
                }
            }
        }));
    }

    public static void yiXiaoDianBatchsignOrder(String value, final String s, final OnOkhttpCallback onOkhttpCallback) {
        OkhttpManager.list.clear();
        OkhttpManager.list.add(value);
        String timestamp = String.valueOf(System.currentTimeMillis());
        final YXDOrderReqBean yxdOrderReqBean = new YXDOrderReqBean(OkhttpManager.list, value, "APP", timestamp, s);
        final TreeMap<String, String> treeMap = new TreeMap<String, String>();
        treeMap.put("BODY", YXDUtil.md5(new String(JSON.toJSONString((Object)yxdOrderReqBean).getBytes())));
        treeMap.put("METHOD", "POST");
        treeMap.put("X-Ca-Nonce", UUID.randomUUID().toString());
        treeMap.put("X-Ca-Sign-Type", "MD5");
        treeMap.put("X-Ca-Timestamp", timestamp);
        treeMap.put("YJY-Auth", OkhttpManager.YIXIAODIAN_TOKEN);
        MyApplication.getDaggerReposifitComponent().getRequestApiYshouFa().batchsignOrder(yxdOrderReqBean,
                (String)treeMap.get("X-Ca-Sign-Type"),
                (String)treeMap.get("X-Ca-Nonce"),
                (String)treeMap.get("X-Ca-Timestamp"),
                YXDUtil.buildArgsN((SortedMap<String, String>)treeMap, YXDUtil.clientSecret),
                "Android",
                OkhttpManager.YIXIAODIAN_TOKEN,
                Build.VERSION.RELEASE,
                BLE_ADDRESS,
                "4.7.0",
                Build.MODEL,
                "Android",
                "%E6%B1%9F%E8%8B%8F%E7%9C%81%7C%E5%AE%BF%E8%BF%81%E5%B8%82%7C%E5%AE%BF%E5%9F%8E%E5%8C%BA"
        ).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<YXDHttpCallBack<YXDOrderResBean>>() {
            @Override
            public void onFailure(final int n, final String s) {
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final YXDHttpCallBack<YXDOrderResBean> yxdHttpCallBack) {
                if (yxdHttpCallBack != null && yxdHttpCallBack.getSuccess()) {
                    onOkhttpCallback.onSuccess(yxdHttpCallBack.getData() == null?"鍑哄簱鎴愬姛!":yxdHttpCallBack.getData());
                    return;
                }
                OkhttpManager.onErrorCallback.onError(0, yxdHttpCallBack == null ? "some thing wrong!":yxdHttpCallBack.getMsg());
            }
        }));
    }

    public static void yiXiaoDianUploadCospublicImage(final String s, final OnOkhttpCallback onOkhttpCallback) {
        try {
            final YXDOrderUpPicReqBean yxdOrderUpPicReqBean = new YXDOrderUpPicReqBean(false, "e-ant", s);
            final TreeMap<Object, String> treeMap = new TreeMap<Object, String>();
            treeMap.put("METHOD", "POST");
            treeMap.put("X-Ca-Sign-Type", "MD5");
            treeMap.put("X-Ca-Nonce", UUID.randomUUID().toString());
            treeMap.put("X-Ca-Timestamp", String.valueOf(System.currentTimeMillis()));
            final StringBuilder sb = new StringBuilder();
            sb.append("bearer ");
            sb.append(OkhttpManager.YIXIAODIAN_TOKEN);
            treeMap.put("Authorization", sb.toString());
            treeMap.put("BODY", MD5Util.encodeMd5(new String(JSON.toJSONString((Object)yxdOrderUpPicReqBean).getBytes())).toLowerCase(Locale.ROOT));
            MyApplication.getDaggerReposifitComponent().getRequestApiYshouFa().uploadCospublicImage(yxdOrderUpPicReqBean, (String)treeMap.get("X-Ca-Sign-Type"), (String)treeMap.get("X-Ca-Nonce"), (String)treeMap.get("X-Ca-Timestamp"), ""/*MD5Util.encodeMd5(YXDUtil.buildArgs((SortedMap<String, String>)treeMap, YXDUtil.clientSecret)).toLowerCase()*/, (String)treeMap.get("Authorization"), YXDUtil.clientId).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<YXDHttpCallBack<YXDOrderUpPicResBean>>() {
                @Override
                public void onFailure(final int n, final String s) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }

                public void onSuccess(final YXDHttpCallBack<YXDOrderUpPicResBean> yxdHttpCallBack) {
                    if (yxdHttpCallBack.getSuccess()) {
                        onOkhttpCallback.onSuccess(yxdHttpCallBack.getData());
                        return;
                    }
                    OkhttpManager.onErrorCallback.onError(0, yxdHttpCallBack.getMsg());
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void yundaCheckNoPick1781(final YunDa1781KDCSNoPicketBean.DataBean data, final OnOkhttpCallback<YunDa1781KDCSNoPicketResponseBean> onOkhttpCallback) {
        try {
            final YunDaKDCSLoginResponseBean yunDaKDCSLoginInfor = RqFilePreference.getInstance().getYunDaKDCSLoginInfor();
            if (yunDaKDCSLoginInfor != null) {
                final YunDa1781KDCSNoPicketBean yunDa1781KDCSNoPicketBean = new YunDa1781KDCSNoPicketBean();
                yunDa1781KDCSNoPicketBean.setAction("appMarket.appMarket.ship.queryOnePersonShips");
                yunDa1781KDCSNoPicketBean.setAppid("88ibnoktffyc88r4");
                yunDa1781KDCSNoPicketBean.setAppver("1.7.8.1");
                yunDa1781KDCSNoPicketBean.setOption("false");
                yunDa1781KDCSNoPicketBean.setReq_time(System.currentTimeMillis());
                yunDa1781KDCSNoPicketBean.setSign_method("yd_md5");
                yunDa1781KDCSNoPicketBean.setToken(yunDaKDCSLoginInfor.getToken());
                yunDa1781KDCSNoPicketBean.setVersion("V1.0");
                yunDa1781KDCSNoPicketBean.setData(data);
                MyApplication.getDaggerReposifitComponent().getRequestApiYundaNewKDCS().yunda1781KDCSCheckNoPicket(yunDa1781KDCSNoPicketBean).enqueue((Callback)new ApiCallbackYunDaNewKDCS((ApiCallbackYunDaNewKDCS.HttpCallback)new ApiCallbackYunDaNewKDCS.HttpCallback<YunDa1781KDCSNoPicketResponseBean>() {
                    @Override
                    public void onFailure(final int n, final String s) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u51fa\u5e93\u6570\u636e\u4e0a\u4f20\u5931\u8d25:");
                        sb.append(n);
                        sb.append("  ");
                        sb.append(s);
                        //XLog.e(sb.toString());
                        if (!s.contains("token\u5df2\u8fc7\u671f") && !s.contains("TOKEN")) {
                            if (OkhttpManager.onErrorCallback != null) {
                                OkhttpManager.onErrorCallback.onError(n, s);
                            }
                        }
                        else if (OkhttpManager.onErrorCallback != null) {
                            OkhttpManager.onErrorCallback.onError(-1, s);
                        }
                    }

                    public void onSuccess(final YunDa1781KDCSNoPicketResponseBean yunDa1781KDCSNoPicketResponseBean) {
                        try {
                            if (yunDa1781KDCSNoPicketResponseBean.isResult()) {
                                if (onOkhttpCallback != null) {
                                    onOkhttpCallback.onSuccess(yunDa1781KDCSNoPicketResponseBean);
                                }
                            }
                            else if (OkhttpManager.onErrorCallback != null) {
                                OkhttpManager.onErrorCallback.onError(-2, yunDa1781KDCSNoPicketResponseBean.getMessage());
                            }
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void yundaKDCSLoginApi(String format, String md5Str, final OnOkhttpCallback onOkhttpCallback) {
        md5Str = MD5Util.getMD5Str(Base64Util.getBaseString(md5Str.getBytes()));
        format = String.format("{\n  \"password\": \"%s\",\n  \"phone\": \"%s\"\n}", md5Str, format);
        final YunDaKDCSRequestBean yunDaKDCSRequestBean = new YunDaKDCSRequestBean();
        yunDaKDCSRequestBean.setData(format);
        yunDaKDCSRequestBean.setAction("market.appMarket.login");
        final String yunDaKDCSSign = getYunDaKDCSSign(yunDaKDCSRequestBean);
        final StringBuilder sb = new StringBuilder();
        sb.append("yundaKDCSLoginApi: ===========");
        sb.append(md5Str);
        sb.append("   ");
        sb.append(yunDaKDCSSign);
        sb.append("   ");
        sb.append(format);
        Log.e("OkhttpManager", sb.toString());
        MyApplication.getDaggerReposifitComponent().getRequestApiYunDaKDCS().yundaKDCSLogin(yunDaKDCSRequestBean.getSign_method(), yunDaKDCSRequestBean.getReq_time(), yunDaKDCSRequestBean.getData(), yunDaKDCSRequestBean.getAction(), yunDaKDCSRequestBean.getAppver(), yunDaKDCSRequestBean.getVersion(), yunDaKDCSSign).enqueue((Callback)new ApiCallbackYunDaKDCS((ApiCallbackYunDaKDCS.HttpCallback)new ApiCallbackYunDaKDCS.HttpCallback<YunDaKDCSLoginResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u767b\u5f55\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u767b\u5f55\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            public void onSuccess(final YunDaKDCSLoginResponseBean yunDaKDCSLoginInfor) {
                if (yunDaKDCSLoginInfor.isResult()) {
                    //XLog.e("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u767b\u5f55\u6210\u529f");
                    RqFilePreference.getInstance().setYunDaKDCSLoginInfor(yunDaKDCSLoginInfor);
                    OkhttpManager.yundaKDCSRequestSecret();
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(yunDaKDCSLoginInfor);
                    }
                }
                else {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u767b\u5f55\u5931\u8d25: ");
                    sb.append(yunDaKDCSLoginInfor.getMessage());
                    ToastSoundUtil.wrongSoundToast(sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, yunDaKDCSLoginInfor.getMessage());
                    }
                }
            }
        }));
    }

    public static void yundaKDCSNewLoginApi(final String s, String md5Str, final OnOkhttpCallback onOkhttpCallback) {
        String yunda_pass=md5Str;
        md5Str = MD5Util.getMD5Str(Base64Util.getBaseString(md5Str.getBytes()));
        final YunDaKDCSNewLoginBean yunDaKDCSNewLoginBean = new YunDaKDCSNewLoginBean();
        yunDaKDCSNewLoginBean.setAction("appMarket.appMarket.appLogin");
        yunDaKDCSNewLoginBean.setAppid("88ibnoktffyc88r4");
        yunDaKDCSNewLoginBean.setAppver("1.7.8.1");
        yunDaKDCSNewLoginBean.setOption("true");
        yunDaKDCSNewLoginBean.setReq_time(System.currentTimeMillis());
        yunDaKDCSNewLoginBean.setSign_method("yd_md5");
        yunDaKDCSNewLoginBean.setToken("");
        yunDaKDCSNewLoginBean.setVersion("V1.0");
        final YunDaKDCSNewLoginBean.DataBean data = new YunDaKDCSNewLoginBean.DataBean();
        data.setMobile(s);
        data.setPhone(s);
        data.setPassword(md5Str);
        yunDaKDCSNewLoginBean.setData(data);
        MyApplication.getDaggerReposifitComponent().getRequestApiYundaNewKDCS().yundaNewKDCSLogin(yunDaKDCSNewLoginBean).enqueue((Callback)new ApiCallbackYunDaNewKDCS((ApiCallbackYunDaNewKDCS.HttpCallback)new ApiCallbackYunDaNewKDCS.HttpCallback<YunDaKDCSLoginResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u767b\u5f55\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u767b\u5f55\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.displayToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final YunDaKDCSLoginResponseBean yunDaKDCSLoginInfor) {
                if (yunDaKDCSLoginInfor != null && yunDaKDCSLoginInfor.isResult()) {
                    //XLog.e("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u767b\u5f55\u6210\u529f");
                    RqFilePreference.getInstance().setYunDaKDCSLoginInfor(yunDaKDCSLoginInfor);
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        RqFilePreference.getInstance().setYUNDAKDCSAccount(s);
                        RqFilePreference.getInstance().setYUNDAKDCSPwd(yunda_pass);
                        val$okhttpCallback.onSuccess(yunDaKDCSLoginInfor);
                    }
                }
                else {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u767b\u5f55\u5931\u8d25: ");
                    sb.append(yunDaKDCSLoginInfor.getMessage());
                    ToastSoundUtil.wrongSoundToast(sb.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-1, yunDaKDCSLoginInfor.getMessage());
                    }
                }
            }
        }));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void yundaKDCSRequestSecret() {
        final YunDaKDCSLoginResponseBean yunDaKDCSLoginInfor = RqFilePreference.getInstance().getYunDaKDCSLoginInfor();
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(System.currentTimeMillis());
        final String substring = sb.toString().substring(1);
        final String encryptDataByPublicKey = RsaUtil.encryptDataByPublicKey(yunDaKDCSLoginInfor.getPublicKey(), substring.getBytes());
        final YunDaKDCSRequestBean yunDaKDCSRequestBean = new YunDaKDCSRequestBean();
        yunDaKDCSRequestBean.setData(encryptDataByPublicKey);
        yunDaKDCSRequestBean.setToken(yunDaKDCSLoginInfor.getToken());
        yunDaKDCSRequestBean.setAction("create.secretkey");
        MyApplication.getDaggerReposifitComponent().getRequestApiYunDaKDCS().yundaKDCSRequestSecret(yunDaKDCSRequestBean.getSign_method(), yunDaKDCSRequestBean.getReq_time(), yunDaKDCSRequestBean.getData(), yunDaKDCSRequestBean.getAction(), yunDaKDCSRequestBean.getToken(), yunDaKDCSRequestBean.getAppver(), yunDaKDCSRequestBean.getVersion(), getYunDaKDCSSign(yunDaKDCSRequestBean)).enqueue((Callback)new ApiCallbackYunDaKDCS((ApiCallbackYunDaKDCS.HttpCallback)new ApiCallbackYunDaKDCS.HttpCallback<YunDaKDCSSecretBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u7533\u8bf7\u79d8\u94a5\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u767b\u7533\u8bf7\u79d8\u94a5\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final YunDaKDCSSecretBean yunDaKDCSSecretBean) {
                final String rsaDecryptByPublicKey = new Rsa2Util().rsaDecryptByPublicKey(yunDaKDCSSecretBean.getServerPart(), yunDaKDCSLoginInfor.getPublicKey());
                final StringBuilder sb = new StringBuilder();
                sb.append(substring);
                sb.append(rsaDecryptByPublicKey);
                OkhttpManager.yundaKDCS_SECRET = sb.toString();
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u7533\u8bf7\u79d8\u94a5\u6210\u529f:");
                sb2.append(yunDaKDCSSecretBean.getServerPart());
                sb2.append("     ");
                sb2.append(OkhttpManager.yundaKDCS_SECRET);
                //XLog.e(sb2.toString());
            }
        }));
    }

    public static void yundaKDCSUploadOutLibrary(final YunDaKDCSUploadBean yunDaKDCSUploadBean, final OnOkhttpCallback onOkhttpCallback) {
        try {
            final YunDaKDCSLoginResponseBean yunDaKDCSLoginInfor = RqFilePreference.getInstance().getYunDaKDCSLoginInfor();
            final String prettyFormat = JsonUtil.toPrettyFormat(JsonUtil.getJsonStringByGson(yunDaKDCSUploadBean));
            final StringBuilder sb = new StringBuilder();
            sb.append("yundaKDCSUploadOutLibrary: ");
            sb.append(prettyFormat);
            Log.e("OkhttpManager", sb.toString());
            final String replace = DESedeUtil.encrypt3DES(prettyFormat, OkhttpManager.yundaKDCS_SECRET).replace("+", " ");
            final YunDaKDCSRequestBean yunDaKDCSRequestBean = new YunDaKDCSRequestBean();
            yunDaKDCSRequestBean.setData(replace);
            yunDaKDCSRequestBean.setToken(yunDaKDCSLoginInfor.getToken());
            yunDaKDCSRequestBean.setAction("market.appMarket.signShip");
            yunDaKDCSRequestBean.setVersion("V1.0");
            MyApplication.getDaggerReposifitComponent().getRequestApiYunDaKDCS().yundaKDCSOutLibrary(yunDaKDCSRequestBean.getSign_method(), yunDaKDCSRequestBean.getReq_time(), yunDaKDCSRequestBean.getData(), yunDaKDCSRequestBean.getAction(), yunDaKDCSRequestBean.getAppver(), yunDaKDCSRequestBean.getVersion(), yunDaKDCSRequestBean.getToken(), getYunDaKDCSSign(yunDaKDCSRequestBean)).enqueue((Callback)new ApiCallbackYunDaKDCS((ApiCallbackYunDaKDCS.HttpCallback)new ApiCallbackYunDaKDCS.HttpCallback<String>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u51fa\u5e93\u6570\u636e\u4e0a\u4f20\u5931\u8d25:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u51fa\u5e93\u6570\u636e\u4e0a\u4f20\u5931\u8d25 ");
                    sb2.append(s);
                    ToastSoundUtil.displayToast(sb2.toString());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(n, s);
                    }
                }

                public void onSuccess(final String s) {
                    final String decrypt3DES = DESedeUtil.decrypt3DES(s, OkhttpManager.yundaKDCS_SECRET);
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u51fa\u5e93\u6570\u636e\u4e0a\u4f20\u6210\u529f:");
                    sb.append(decrypt3DES);
                    //XLog.e(sb.toString());
                    final YunDaKDCSBodyResponseBean yunDaKDCSBodyResponseBean = (YunDaKDCSBodyResponseBean)JsonUtil.getClazzByGson(decrypt3DES, YunDaKDCSBodyResponseBean.class);
                    if (yunDaKDCSBodyResponseBean != null && yunDaKDCSBodyResponseBean.getCode() == 0 && yunDaKDCSBodyResponseBean.isResult()) {
                        final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                        if (val$okhttpCallback != null) {
                            val$okhttpCallback.onSuccess(decrypt3DES);
                        }
                    }
                    else if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, yunDaKDCSBodyResponseBean.getMessage());
                    }
                    final OnOkhttpCallback val$okhttpCallback2 = onOkhttpCallback;
                    if (val$okhttpCallback2 != null) {
                        val$okhttpCallback2.onSuccess(s);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void yundaNewKDCSCheckBarcodeInfor(final String shipId, final OnOkhttpCallback<YunDaNewKDCSCheckResponseBean> onOkhttpCallback) {
        final YunDaKDCSLoginResponseBean yunDaKDCSLoginInfor = RqFilePreference.getInstance().getYunDaKDCSLoginInfor();
        if (yunDaKDCSLoginInfor != null) {
            final YunDaNewKDCSCheckData yunDaNewKDCSCheckData = new YunDaNewKDCSCheckData();
            yunDaNewKDCSCheckData.setAction("appMarket.appMarket.ship.signShipCheck");
            yunDaNewKDCSCheckData.setAppid("88ibnoktffyc88r4");
            yunDaNewKDCSCheckData.setAppver("1.7.8.1");
            yunDaNewKDCSCheckData.setOption("false");
            yunDaNewKDCSCheckData.setReq_time(System.currentTimeMillis());
            yunDaNewKDCSCheckData.setSign_method("yd_md5");
            yunDaNewKDCSCheckData.setToken(yunDaKDCSLoginInfor.getToken());
            yunDaNewKDCSCheckData.setVersion("V1.0");
            final YunDaNewKDCSCheckData.DataBean data = new YunDaNewKDCSCheckData.DataBean();
            data.setAgentId(yunDaKDCSLoginInfor.getData().getAgentId());
            data.setCompany("");
            data.setShipId(shipId);
            yunDaNewKDCSCheckData.setData(data);
            MyApplication.getDaggerReposifitComponent().getRequestApiYundaNewKDCS().yundaNewKDCSCheckBarcode(yunDaNewKDCSCheckData).enqueue((Callback)new ApiCallbackYunDaNewKDCS((ApiCallbackYunDaNewKDCS.HttpCallback)new ApiCallbackYunDaNewKDCS.HttpCallback<YunDaNewKDCSCheckResponseBean>() {
                @Override
                public void onFailure(final int n, final String s) {
                    try {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u67e5\u8be2\u5355\u53f7\u4fe1\u606f\u5931\u8d25:");
                        sb.append(n);
                        sb.append("  ");
                        sb.append(s);
                        //XLog.e(sb.toString());
                        if (!s.contains("token\u5df2\u8fc7\u671f") && !s.contains("TOKEN")) {
                            if (OkhttpManager.onErrorCallback != null) {
                                OkhttpManager.onErrorCallback.onError(n, s);
                            }
                        }
                        else if (OkhttpManager.onErrorCallback != null) {
                            OkhttpManager.onErrorCallback.onError(-1, s);
                        }
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                public void onSuccess(final YunDaNewKDCSCheckResponseBean yunDaNewKDCSCheckResponseBean) {
                    if (yunDaNewKDCSCheckResponseBean != null) {
                        try {
                            if (yunDaNewKDCSCheckResponseBean.isResult()) {
                                //XLog.e("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u67e5\u8be2\u5355\u53f7\u4fe1\u606f\u6210\u529f");
                                if (onOkhttpCallback != null) {
                                    onOkhttpCallback.onSuccess(yunDaNewKDCSCheckResponseBean);
                                }
                            }
                            else {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u67e5\u8be2\u5355\u53f7\u4fe1\u606f\u5931\u8d25: ");
                                sb.append(yunDaNewKDCSCheckResponseBean.getMessage());
                                ToastSoundUtil.displayToast(sb.toString());
                                if (OkhttpManager.onErrorCallback != null) {
                                    OkhttpManager.onErrorCallback.onError(-2, yunDaNewKDCSCheckResponseBean.getMessage());
                                }
                            }
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }));
        }
    }

    public static void yundaNewKDCSCheckNoPicket(final YunDaNewKDCSNoPicketBean.DataBean data, final OnOkhttpCallback<YunDaNewKDCSNoPicketResponseBean> onOkhttpCallback) {
        try {
            final YunDaKDCSLoginResponseBean yunDaKDCSLoginInfor = RqFilePreference.getInstance().getYunDaKDCSLoginInfor();
            if (yunDaKDCSLoginInfor != null) {
                final YunDaNewKDCSNoPicketBean yunDaNewKDCSNoPicketBean = new YunDaNewKDCSNoPicketBean();
                yunDaNewKDCSNoPicketBean.setAction("appMarket.appMarket.ship.queryShipByPhone130");
                yunDaNewKDCSNoPicketBean.setAppid("88ibnoktffyc88r4");
                yunDaNewKDCSNoPicketBean.setAppver("1.7.8.1");
                yunDaNewKDCSNoPicketBean.setOption("false");
                yunDaNewKDCSNoPicketBean.setReq_time(System.currentTimeMillis());
                yunDaNewKDCSNoPicketBean.setSign_method("yd_md5");
                yunDaNewKDCSNoPicketBean.setToken(yunDaKDCSLoginInfor.getToken());
                yunDaNewKDCSNoPicketBean.setVersion("V1.0");
                yunDaNewKDCSNoPicketBean.setData(data);
                MyApplication.getDaggerReposifitComponent().getRequestApiYundaNewKDCS().yundaNewKDCSCheckNoPicket(yunDaNewKDCSNoPicketBean).enqueue((Callback)new ApiCallbackYunDaNewKDCS((ApiCallbackYunDaNewKDCS.HttpCallback)new ApiCallbackYunDaNewKDCS.HttpCallback<YunDaNewKDCSNoPicketResponseBean>() {
                    @Override
                    public void onFailure(final int n, final String s) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u67e5\u8be2\u591a\u4e2a\u5305\u88f9\u5931\u8d25:");
                        sb.append(n);
                        sb.append("  ");
                        sb.append(s);
                        //XLog.e(sb.toString());
                        if (!s.contains("token\u5df2\u8fc7\u671f") && !s.contains("TOKEN")) {
                            if (OkhttpManager.onErrorCallback != null) {
                                OkhttpManager.onErrorCallback.onError(n, s);
                            }
                        }
                        else if (OkhttpManager.onErrorCallback != null) {
                            OkhttpManager.onErrorCallback.onError(-1, s);
                        }
                    }

                    public void onSuccess(final YunDaNewKDCSNoPicketResponseBean yunDaNewKDCSNoPicketResponseBean) {
                        //XLog.e("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u67e5\u8be2\u591a\u4e2a\u5305\u88f9\u6210\u529f:");
                        while (true) {
                            if (yunDaNewKDCSNoPicketResponseBean != null) {
                                try {
                                    if (yunDaNewKDCSNoPicketResponseBean.getCode() == 0 && yunDaNewKDCSNoPicketResponseBean.isResult()) {
                                        if (onOkhttpCallback != null) {
                                            onOkhttpCallback.onSuccess(yunDaNewKDCSNoPicketResponseBean);
                                        }
                                    }
                                    else if (OkhttpManager.onErrorCallback != null) {
                                        OkhttpManager.onErrorCallback.onError(-2, yunDaNewKDCSNoPicketResponseBean.getMessage());
                                    }
                                }
                                catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                return;
                            }
                            continue;
                        }
                    }
                }));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void yundaNewKDCSUploadOutLibrary(final YunDaKDCSUploadBean data, final OnOkhttpCallback onOkhttpCallback) {
        try {
            final YunDaKDCSLoginResponseBean yunDaKDCSLoginInfor = RqFilePreference.getInstance().getYunDaKDCSLoginInfor();
            if (yunDaKDCSLoginInfor != null) {
                final YunDaNewKDCSOutLibraryBean yunDaNewKDCSOutLibraryBean = new YunDaNewKDCSOutLibraryBean();
                yunDaNewKDCSOutLibraryBean.setAction("appMarket.appMarket.ship.signShip");
                yunDaNewKDCSOutLibraryBean.setAppid("88ibnoktffyc88r4");
                yunDaNewKDCSOutLibraryBean.setAppver("1.7.8.1");
                yunDaNewKDCSOutLibraryBean.setOption("false");
                yunDaNewKDCSOutLibraryBean.setReq_time(System.currentTimeMillis());
                yunDaNewKDCSOutLibraryBean.setSign_method("yd_md5");
                yunDaNewKDCSOutLibraryBean.setToken(yunDaKDCSLoginInfor.getToken());
                yunDaNewKDCSOutLibraryBean.setVersion("V1.0");
                yunDaNewKDCSOutLibraryBean.setData(data);
                MyApplication.getDaggerReposifitComponent().getRequestApiYundaNewKDCS().yundaNewKDCSOutLibrary(yunDaNewKDCSOutLibraryBean).enqueue((Callback)new ApiCallbackYunDaNewKDCS((ApiCallbackYunDaNewKDCS.HttpCallback)new ApiCallbackYunDaNewKDCS.HttpCallback<YunDaKDCSBodyResponseBean>() {
                    @Override
                    public void onFailure(final int n, final String s) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u51fa\u5e93\u6570\u636e\u4e0a\u4f20\u5931\u8d25:");
                        sb.append(n);
                        sb.append("  ");
                        sb.append(s);
                        //XLog.e(sb.toString());
                        if (!s.contains("token\u5df2\u8fc7\u671f") && !s.contains("TOKEN")) {
                            if (OkhttpManager.onErrorCallback != null) {
                                OkhttpManager.onErrorCallback.onError(n, s);
                            }
                        }
                        else if (OkhttpManager.onErrorCallback != null) {
                            OkhttpManager.onErrorCallback.onError(-1, s);
                        }
                    }

                    public void onSuccess(final YunDaKDCSBodyResponseBean yunDaKDCSBodyResponseBean) {
                        //XLog.e("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u51fa\u5e93\u6570\u636e\u4e0a\u4f20\u6210\u529f:");
                        while (true) {
                            if (yunDaKDCSBodyResponseBean != null) {
                                try {
                                    if (yunDaKDCSBodyResponseBean.getCode() == 0 && yunDaKDCSBodyResponseBean.isResult()) {
                                        if (onOkhttpCallback != null) {
                                            onOkhttpCallback.onSuccess(yunDaKDCSBodyResponseBean);
                                        }
                                    }
                                    else if (OkhttpManager.onErrorCallback != null) {
                                        OkhttpManager.onErrorCallback.onError(-2, yunDaKDCSBodyResponseBean.getMessage());
                                    }
                                }
                                catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                return;
                            }
                            continue;
                        }
                    }
                }));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void yundaOutLibrary1781(final YunDaKDCSUploadBean data, final OnOkhttpCallback onOkhttpCallback) {
        try {
            final YunDaKDCSLoginResponseBean yunDaKDCSLoginInfor = RqFilePreference.getInstance().getYunDaKDCSLoginInfor();
            if (yunDaKDCSLoginInfor != null) {
                final YunDaNewKDCSOutLibraryBean yunDaNewKDCSOutLibraryBean = new YunDaNewKDCSOutLibraryBean();
                yunDaNewKDCSOutLibraryBean.setAction("appMarket.appMarket.ship.outShip");
                yunDaNewKDCSOutLibraryBean.setAppid("88ibnoktffyc88r4");
                yunDaNewKDCSOutLibraryBean.setAppver("1.7.8.1");
                yunDaNewKDCSOutLibraryBean.setOption("false");
                yunDaNewKDCSOutLibraryBean.setReq_time(System.currentTimeMillis());
                yunDaNewKDCSOutLibraryBean.setSign_method("yd_md5");
                yunDaNewKDCSOutLibraryBean.setToken(yunDaKDCSLoginInfor.getToken());
                yunDaNewKDCSOutLibraryBean.setVersion("V1.0");
                yunDaNewKDCSOutLibraryBean.setData(data);
                MyApplication.getDaggerReposifitComponent().getRequestApiYundaNewKDCS().yundaNewKDCSOutLibrary(yunDaNewKDCSOutLibraryBean).enqueue((Callback)new ApiCallbackYunDaNewKDCS((ApiCallbackYunDaNewKDCS.HttpCallback)new ApiCallbackYunDaNewKDCS.HttpCallback<YunDaKDCSBodyResponseBean>() {
                    @Override
                    public void onFailure(final int n, final String s) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("\u97f5\u8fbe\u5feb\u9012\u8d85\u5e02\u51fa\u5e93\u6570\u636e\u4e0a\u4f20\u5931\u8d25:");
                        sb.append(n);
                        sb.append("  ");
                        sb.append(s);
                        //XLog.e(sb.toString());
                        if (!s.contains("token\u5df2\u8fc7\u671f") && !s.contains("TOKEN")) {
                            if (OkhttpManager.onErrorCallback != null) {
                                OkhttpManager.onErrorCallback.onError(n, s);
                            }
                        }
                        else if (OkhttpManager.onErrorCallback != null) {
                            OkhttpManager.onErrorCallback.onError(-1, s);
                        }
                    }

                    public void onSuccess(final YunDaKDCSBodyResponseBean yunDaKDCSBodyResponseBean) {
                        try {
                            if (yunDaKDCSBodyResponseBean.isResult()) {
                                if (onOkhttpCallback != null) {
                                    onOkhttpCallback.onSuccess(yunDaKDCSBodyResponseBean);
                                }
                            }
                            else if (OkhttpManager.onErrorCallback != null) {
                                OkhttpManager.onErrorCallback.onError(-2, yunDaKDCSBodyResponseBean.getMessage());
                            }
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void zfbTrialGetpay(final int n, final OnOkhttpCallback<Payment<ZFBPayment>> onOkhttpCallback) {
        try {
            MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().getZFBTrialGetpay(n, "1", getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<Payment<ZFBPayment>>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u652f\u4ed8\u5b9d\u652f\u4ed8\u83b7\u53d6\u5f02\u5e38:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                }

                public void onSuccess(final Payment<ZFBPayment> payment) {
                    final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(payment);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void zfbTrialRenew(final String s, final int n, final OnOkhttpCallback<Payment<ZFBPayment>> onOkhttpCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        final TrialRenew trialRenew = new TrialRenew(FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number(), s, n, 1.0f, "1", Long.toString(currentTimeMillis), "");
        trialRenew.setSign(MD5Util.getEncryptMD5Class(trialRenew.getClass(), currentTimeMillis, RqFilePreference.getInstance().getLoginBean().getUsername()));
        try {
            MyApplication.getDaggerReposifitComponent().getRequestApiDeviceManager().zfbTrialRenew(trialRenew, getDeviceLoginToken()).enqueue((Callback)new ApiCallback((ApiCallback.HttpCallback)new ApiCallback.HttpCallback<Payment<ZFBPayment>>() {
                @Override
                public void onFailure(final int n, final String s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u79df\u7528\u5230\u671f\u7eed\u5f02\u5e38:");
                    sb.append(n);
                    sb.append("  ");
                    sb.append(s);
                    //XLog.e(sb.toString());
                }

                public void onSuccess(final Payment<ZFBPayment> payment) {
                    final OnOkhttpCallback val$onOkhttpCallback = (OnOkhttpCallback)onOkhttpCallback;
                    if (val$onOkhttpCallback != null) {
                        val$onOkhttpCallback.onSuccess(payment);
                    }
                }
            }));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void zhongYouImageUpload(final String s, final byte[] array, final OnOkhttpCallback onOkhttpCallback) {
        final MultipartBody.Builder addPart = new MultipartBody.Builder().setType(MultipartBody.FORM).addPart(Headers.of(new String[] { "Content-Disposition", "form-data; name=\"operateTime\"" }), RequestBody.create((MediaType)null, Long.valueOf(System.currentTimeMillis()).toString())).addPart(Headers.of(new String[] { "Content-Disposition", "form-data;name=\"machineCode\"" }), RequestBody.create((MediaType)null, RqFilePreference.getInstance().getZyMachineCode())).addPart(Headers.of(new String[] { "Content-Disposition", "form-data;name=\"siteCode\"" }), RequestBody.create((MediaType)null, RqFilePreference.getInstance().getZyOpeSiteId()));
        final StringBuilder sb = new StringBuilder();
        sb.append("form-data;name=\"image\";filename=\"");
        sb.append(s);
        sb.append(".jpg\"");
        MyApplication.getDaggerReposifitComponent().getRequestApiZhongYou().uploadImageData(addPart.addPart(Headers.of(new String[] { "Content-Disposition", sb.toString() }), RequestBody.create(MediaType.parse("image/jpeg"), array)).build()).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<ZhongYouUploadWeightResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u56fe\u7247\u4e0a\u4f20\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final ZhongYouUploadWeightResponseBean zhongYouUploadWeightResponseBean) {
                if (zhongYouUploadWeightResponseBean.getCode() == 200) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(zhongYouUploadWeightResponseBean);
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, zhongYouUploadWeightResponseBean.getMessage());
                }
            }
        }));
    }

    public static void zhongYouLogin(final String s, final String s2, final String s3, final String s4, final OnOkhttpCallback onOkhttpCallback) {
        new ZhongYouBaseBean(s, s2, s3, s4);
    }

    public static void zhongYouStationDeliveryStorageApi(final KuaiBaoDeliveryStorageBean kuaiBaoDeliveryStorageBean, final OnOkhttpCallback onOkhttpCallback) {
        final StringBuilder sb = new StringBuilder();
        sb.append("session_id=");
        sb.append(kuaiBaoDeliveryStorageBean.getSession_id());
        final String string = sb.toString();
        kuaiBaoDeliveryStorageBean.setSign(SignData.getNativeSign(kuaiBaoDeliveryStorageBean.getTs(), "/v1/dak/ScanCode/deliveryStorage", kuaiBaoDeliveryStorageBean.getApp_id(), kuaiBaoDeliveryStorageBean.getSession_id(), OkhttpManager.appversion));
        MyApplication.getDaggerReposifitComponent().getRequestApiZhongYouStation().kuaibaoDeliveryStorage(kuaiBaoDeliveryStorageBean.getApp_id(), kuaiBaoDeliveryStorageBean.getTs(), kuaiBaoDeliveryStorageBean.getSign(), kuaiBaoDeliveryStorageBean.getData(), OkhttpManager.version, OkhttpManager.appversion, kuaiBaoDeliveryStorageBean.getApp_id(), OkhttpManager.pname, string).enqueue((Callback)new ApiCallbackKuaibao((ApiCallbackKuaibao.HttpCallback)new ApiCallbackKuaibao.HttpCallback<Object>() {
            @Override
            public void onFailure(int n, final String s) {
                while (true) {
                    while (true) {
                        try {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("\u4e2d\u90ae\u9a7f\u7ad9\u51fa\u5e93\u5931\u8d25:");
                            sb.append(n);
                            sb.append("  ");
                            sb.append(s);
                            //XLog.e(sb.toString());
                            if (OkhttpManager.onErrorCallback == null) {
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("\u4e2d\u90ae\u9a7f\u7ad9\u51fa\u5e93\u5931\u8d25 ");
                                sb2.append(s);
                                ToastSoundUtil.wrongSoundToast(sb2.toString());
                                return;
                            }
                            if (n == 1005) {
                                n = -1;
                                OkhttpManager.onErrorCallback.onError(n, s);
                                return;
                            }
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                            return;
                        }
                        n = -5;
                        continue;
                    }
                }
            }

            @Override
            public void onSuccess(final Object o) {
                //XLog.e("\u4e2d\u90ae\u9a7f\u7ad9\u51fa\u5e93\u6210\u529f");
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(o);
                }
            }
        }));
    }

    public static void zhongYouStationGetStationInforApi(final KuaiBaoGetStationInforBean kuaiBaoGetStationInforBean, String string) {
        final StringBuilder sb = new StringBuilder();
        sb.append("session_id=");
        sb.append(string);
        string = sb.toString();
        String sign = SignData.getNativeSign(kuaiBaoGetStationInforBean.getTs(), "/v1/YzApp/getInfo", kuaiBaoGetStationInforBean.getApp_id(), kuaiBaoGetStationInforBean.getSession_id(), OkhttpManager.appversion);
        kuaiBaoGetStationInforBean.setSign(sign);
        MyApplication.getDaggerReposifitComponent().getRequestApiZhongYouStation().kuaibaoGetStationInfor(kuaiBaoGetStationInforBean.getDid(), kuaiBaoGetStationInforBean.getApp_id(), kuaiBaoGetStationInforBean.getTs(), kuaiBaoGetStationInforBean.getSign(), kuaiBaoGetStationInforBean.getData(), OkhttpManager.version, OkhttpManager.appversion, OkhttpManager.pname, string).enqueue((Callback)new ApiCallbackKuaibao((ApiCallbackKuaibao.HttpCallback)new ApiCallbackKuaibao.HttpCallback<KuaiBaoGetStationInforResponseBean>() {
            @Override
            public void onFailure(int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e2d\u90ae\u9a7f\u7ad9\u83b7\u53d6\u7ad9\u70b9\u4fe1\u606f\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    if (n == 1005) {
                        n = -1;
                    }
                    else {
                        n = -2;
                    }
                    OkhttpManager.onErrorCallback.onError(n, s);
                    return;
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u4e2d\u90ae\u9a7f\u7ad9\u83b7\u53d6\u7ad9\u70b9\u4fe1\u606f\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
            }

            public void onSuccess(final KuaiBaoGetStationInforResponseBean kuaibaoStationInfor) {
                //XLog.e("\u4e2d\u90ae\u9a7f\u7ad9\u83b7\u53d6\u7ad9\u70b9\u4fe1\u606f\u6210\u529f");
                RqFilePreference.getInstance().setKuaibaoStationInfor(kuaibaoStationInfor);
            }
        }));
    }

    public static void zhongYouStationGetUserUnPickUpListsApi(final KuaiBaoGetUserUnPickUpListsBean kuaiBaoGetUserUnPickUpListsBean, final OnOkhttpCallback onOkhttpCallback) {
        final StringBuilder sb = new StringBuilder();
        sb.append("session_id=");
        sb.append(kuaiBaoGetUserUnPickUpListsBean.getSession_id());
        final String string = sb.toString();
        kuaiBaoGetUserUnPickUpListsBean.setSign(SignData.getNativeSign(kuaiBaoGetUserUnPickUpListsBean.getTs(), "/v1/dak/ScanCode/getUserUnPickUpLists", kuaiBaoGetUserUnPickUpListsBean.getApp_id(), kuaiBaoGetUserUnPickUpListsBean.getSession_id(), OkhttpManager.appversion));
        MyApplication.getDaggerReposifitComponent().getRequestApiZhongYouStation().kuaibaoGetUserUnPickUpLists(kuaiBaoGetUserUnPickUpListsBean.getApp_id(), kuaiBaoGetUserUnPickUpListsBean.getTs(), kuaiBaoGetUserUnPickUpListsBean.getSign(), kuaiBaoGetUserUnPickUpListsBean.getData(), OkhttpManager.version, OkhttpManager.appversion, kuaiBaoGetUserUnPickUpListsBean.getApp_id(), OkhttpManager.pname, string).enqueue((Callback)new ApiCallbackKuaibao((ApiCallbackKuaibao.HttpCallback)new ApiCallbackKuaibao.HttpCallback<KuaiBaoGetUserUnPickUpListsResponseBean>() {
            @Override
            public void onFailure(int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e2d\u90ae\u9a7f\u7ad9\u67e5\u8be2\u7528\u6237\u672a\u53d6\u5305\u88f9\u5217\u8868\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    if (n == 1005) {
                        n = -1;
                    }
                    else {
                        n = -2;
                    }
                    OkhttpManager.onErrorCallback.onError(n, s);
                    return;
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u4e2d\u90ae\u9a7f\u7ad9\u67e5\u8be2\u7528\u6237\u672a\u53d6\u5305\u88f9\u5217\u8868\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
            }

            public void onSuccess(final KuaiBaoGetUserUnPickUpListsResponseBean kuaiBaoGetUserUnPickUpListsResponseBean) {
                //XLog.e("\u4e2d\u90ae\u9a7f\u7ad9\u67e5\u8be2\u7528\u6237\u672a\u53d6\u5305\u88f9\u5217\u8868\u6210\u529f");
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(kuaiBaoGetUserUnPickUpListsResponseBean);
                }
            }
        }));
    }

    public static void zhongYouStationLoginApi(final KuaiBaoLoginBean kuaiBaoLoginBean, String string, final OnOkhttpCallback onOkhttpCallback) {
        final StringBuilder sb = new StringBuilder();
        sb.append("session_id=");
        sb.append(string);
        string = sb.toString();
        kuaiBaoLoginBean.setSign(SignData.getNativeSign(kuaiBaoLoginBean.getTs(), "/v1/YzApp/phoneLogin", kuaiBaoLoginBean.getApp_id(), kuaiBaoLoginBean.getSession_id(), OkhttpManager.appversion));
        MyApplication.getDaggerReposifitComponent().getRequestApiZhongYouStation().kuaibaoLogin(kuaiBaoLoginBean.getApp_id(), kuaiBaoLoginBean.getTs(), kuaiBaoLoginBean.getSign(), kuaiBaoLoginBean.getData(), OkhttpManager.version, OkhttpManager.appversion, OkhttpManager.pname, string).enqueue((Callback)new ApiCallbackKuaibao((ApiCallbackKuaibao.HttpCallback)new ApiCallbackKuaibao.HttpCallback<KuaiBaoLoginResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e2d\u90ae\u9a7f\u7ad9\u767b\u5f55\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u4e2d\u90ae\u9a7f\u7ad9\u767b\u5f55\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
            }

            public void onSuccess(final KuaiBaoLoginResponseBean kuaibaoLoginInfor) {
                //XLog.e("\u4e2d\u90ae\u9a7f\u7ad9\u767b\u5f55\u6210\u529f");
                RqFilePreference.getInstance().setKuaibaoLoginInfor(kuaibaoLoginInfor);
                RqFilePreference.getInstance().setKuaibaoSessionId(kuaibaoLoginInfor.getSession_id());
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    RqFilePreference.getInstance().setZHONGYOUSTATIONAccount(kuaiBaoLoginBean.getAccount());
                    RqFilePreference.getInstance().setZHONGYOUSTATIONPwd(kuaiBaoLoginBean.getPass());
                    val$okhttpCallback.onSuccess(kuaibaoLoginInfor);
                }
                OkhttpManager.zhongYouStationGetStationInforApi(new KuaiBaoGetStationInforBean(SystemUtil.getAppUUID((Context)MyApplication.baseApp), JsonUtil.getJsonStringByGson(new KuaiBaoGetStationInforBean.StationInforData(kuaibaoLoginInfor.getSession_id()))), kuaibaoLoginInfor.getSession_id());
            }
        }));
    }

    public static void zhongYouStationQueryBillcodeInforApi(final KuaiBaoQueryBillcodeInforBean kuaiBaoQueryBillcodeInforBean, final OnOkhttpCallback onOkhttpCallback) {
        final StringBuilder sb = new StringBuilder();
        sb.append("session_id=");
        sb.append(kuaiBaoQueryBillcodeInforBean.getSession_id());
        final String string = sb.toString();
        kuaiBaoQueryBillcodeInforBean.setSign(SignData.getNativeSign(kuaiBaoQueryBillcodeInforBean.getTs(), "/v1/dak/ScanCode/expressV2", kuaiBaoQueryBillcodeInforBean.getApp_id(), kuaiBaoQueryBillcodeInforBean.getSession_id(), OkhttpManager.appversion));
        MyApplication.getDaggerReposifitComponent().getRequestApiZhongYouStation().kuaibaoQueryBillcodeInfor(kuaiBaoQueryBillcodeInforBean.getApp_id(), kuaiBaoQueryBillcodeInforBean.getTs(), kuaiBaoQueryBillcodeInforBean.getSign(), kuaiBaoQueryBillcodeInforBean.getData(), OkhttpManager.version, OkhttpManager.appversion, kuaiBaoQueryBillcodeInforBean.getApp_id(), "androids", string).enqueue((Callback)new ApiCallbackKuaibao((ApiCallbackKuaibao.HttpCallback)new ApiCallbackKuaibao.HttpCallback<KuaiBaoQueryBillcodeInforResponseBean>() {
            @Override
            public void onFailure(int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4e2d\u90ae\u9a7f\u7ad9\u67e5\u8be2\u5355\u53f7\u8be6\u7ec6\u4fe1\u606f\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    if (n == 1005) {
                        n = -1;
                    }
                    else {
                        n = -2;
                    }
                    OkhttpManager.onErrorCallback.onError(n, s);
                    return;
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u4e2d\u90ae\u9a7f\u7ad9\u67e5\u8be2\u5355\u53f7\u8be6\u7ec6\u4fe1\u606f\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
            }

            public void onSuccess(final KuaiBaoQueryBillcodeInforResponseBean kuaiBaoQueryBillcodeInforResponseBean) {
                //XLog.e("\u4e2d\u90ae\u9a7f\u7ad9\u67e5\u8be2\u5355\u53f7\u8be6\u7ec6\u4fe1\u606f\u6210\u529f");
                final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                if (val$okhttpCallback != null) {
                    val$okhttpCallback.onSuccess(kuaiBaoQueryBillcodeInforResponseBean);
                }
            }
        }));
    }

    public static void zhongYouUploadWeight(final String s, final Float n, final OnOkhttpCallback onOkhttpCallback) {
    }

    public static void zhongYouWeight(final String s, String zyJdSiteCode, final OnOkhttpCallback onOkhttpCallback) {
        final float float1 = Float.parseFloat(zyJdSiteCode);
        final Float value = 0.0f;
        zyJdSiteCode = RqFilePreference.getInstance().getZyJdSiteCode();
        final String zyMachineCode = RqFilePreference.getInstance().getZyMachineCode();
        final String zyOpeUserId = RqFilePreference.getInstance().getZyOpeUserId();
        final String zyOpeUserName = RqFilePreference.getInstance().getZyOpeUserName();
        final String zyOpeSiteId = RqFilePreference.getInstance().getZyOpeSiteId();
        final String zyOpeSitenName = RqFilePreference.getInstance().getZyOpeSitenName();
        final String dateTimeFormat = DateUtil.getDateTimeFormat(new Date());
        final ArrayList<ZhongYouUploadWeightDataOperBody> list = new ArrayList<ZhongYouUploadWeightDataOperBody>();
        list.add(new ZhongYouUploadWeightDataOperBody(s, zyMachineCode, float1, value, value, value, value, zyOpeUserId, zyOpeUserName, zyOpeSiteId, zyOpeSitenName, dateTimeFormat));
        final String jsonStringByGson = JsonUtil.getJsonStringByGson(new ZhongYouUploadWeightData(2, "", 0, list));
        final ZhongYouUploadWeightRequestBean zhongYouUploadWeightRequestBean = new ZhongYouUploadWeightRequestBean(1001, 100102, jsonStringByGson);
        final StringBuilder sb = new StringBuilder();
        sb.append(zyMachineCode);
        sb.append("\nhttp\ndmsver.etms.jd.com:80\nPOST\nservices/deviceCommand/execute\napplication/json\n");
        sb.append(zyOpeSiteId);
        sb.append("\n");
        sb.append(zyMachineCode);
        sb.append("\npackageWeightSquareInfo\n");
        sb.append(dateTimeFormat);
        sb.append("\n");
        sb.append(jsonStringByGson);
        MyApplication.getDaggerReposifitComponent().getRequestApiZhongYou().uploadWeightData(zhongYouUploadWeightRequestBean, zyMachineCode, zyJdSiteCode, zyOpeSiteId, EncryptUtils.encryptHmacSHA512ToString(sb.toString(), zyMachineCode), dateTimeFormat, "packageWeightSquareInfo").enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<ZhongYouUploadWeightResponseBean>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u4f17\u90ae\u4e0a\u4f20\u91cd\u91cf\u9519\u8bef");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final ZhongYouUploadWeightResponseBean zhongYouUploadWeightResponseBean) {
                if (zhongYouUploadWeightResponseBean.getCode() == 200) {
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(zhongYouUploadWeightResponseBean);
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, zhongYouUploadWeightResponseBean.getMessage());
                }
            }
        }));
    }

    public static void ziCouriersmallpoleLogin(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback/*, final CourierSmallPoleActivity.IsSuccess isSuccess*/) {
        MyApplication.getDaggerReposifitComponent().getRequestApiCourSmallPole().ziCourSmallPoleLogin(s, s2, "android", "1").enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JsonObject>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u5feb\u9012\u5458\u767b\u5f55\u5931\u8d25:");
                sb.append(n);
                sb.append("  ");
                sb.append(s);
                //XLog.e(sb.toString());
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u5feb\u9012\u5458\u767b\u5f55\u5931\u8d25 ");
                sb2.append(s);
                ToastSoundUtil.wrongSoundToast(sb2.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final JsonObject jsonObject) {
                RqFilePreference.getInstance().setCourierSmallPoleLoginfor((CourierSmallPoleLogin)null);
                int int1;
                try {
                    final JSONObject jsonObject2 = new JSONObject(jsonObject.toString());
                    int1 = jsonObject2.getInt("code");
                    try {
                        final String string = jsonObject2.getString("message");
                    }
                    catch (JSONException ex) {}
                }
                catch (JSONException ex) {
                    int1 = 0;
                }
                /*final JSONException ex;
                ex.printStackTrace();*/
                final String string = "";
                if (int1 == 200) {
                    RqFilePreference.getInstance().setCourierSmallPoleLoginIsZiAccount(1);
                    RqFilePreference.getInstance().setCourierSmallPoleLoginfor((CourierSmallPoleLogin)new Gson().fromJson(jsonObject.toString(), (Class)CourierSmallPoleLogin.class));
                    RqFilePreference.getInstance().setCourierSmallPoleLoginforAccount(s);
                    RqFilePreference.getInstance().setCourierSmallPoleLoginforPassword(Base64Util.getBaseString(s2.getBytes()));
                    if (onOkhttpCallback != null) {
                        //isSuccess.result(true);
                        onOkhttpCallback.onSuccess(jsonObject);
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    //isSuccess.result(false);
                    OkhttpManager.onErrorCallback.onError(-2, string);
                }
            }
        }));
    }

    public static void ziStagesmallpoleLogin(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        MyApplication.getDaggerReposifitComponent().getRequestApiStageSmallPole().stageSmallPoleSubLogin("android", "1", s, s2).enqueue((Callback)new CommonApiCallback((CommonApiCallback.HttpCallback)new CommonApiCallback.HttpCallback<JsonObject>() {
            @Override
            public void onFailure(final int n, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append("\u9a7f\u7ad9\u5c0f\u6241\u62c5\u767b\u5f55\u5931\u8d25 ");
                sb.append(s);
                ToastSoundUtil.wrongSoundToast(sb.toString());
                if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(n, s);
                }
            }

            public void onSuccess(final JsonObject jsonObject) {
                RqFilePreference.getInstance().setStageSmallPoleLoginInfor((StageLoginRequestBean)null);
                int int1 = 0;
                String string;
                try {
                    final JSONObject jsonObject2 = new JSONObject(jsonObject.toString());
                    int1 = int1;
                    final int n = int1 = jsonObject2.getInt("code");
                    string = jsonObject2.getString("message");
                    int1 = n;
                }
                catch (JSONException ex) {
                    ex.printStackTrace();
                    string = "";
                }
                if (int1 == 200) {
                    RqFilePreference.getInstance().setCourierSmallPoleLoginIsZiAccount(1);
                    RqFilePreference.getInstance().setStageSmallPoleLoginInfor((StageLoginRequestBean)new Gson().fromJson(jsonObject.toString(), (Class)StageLoginRequestBean.class));
                    final OnOkhttpCallback val$okhttpCallback = onOkhttpCallback;
                    if (val$okhttpCallback != null) {
                        val$okhttpCallback.onSuccess(jsonObject);
                    }
                }
                else if (OkhttpManager.onErrorCallback != null) {
                    OkhttpManager.onErrorCallback.onError(-2, string);
                }
            }
        }));
    }

    public static void zyztHkGpy(final String s, final String s2, final OnOkhttpCallback onOkhttpCallback) {
        Log.d("OkhttpManager", "run: ===================================================");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(s.getBytes(UTF_8));
                    sb.append(OkhttpManager.KEY);
                    sb.append(OkhttpManager.company);
                    final String encodeMd5 = MD5Util.encodeMd5(sb.toString());
                    final ArrayList<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
                    list.add(new BasicNameValuePair("data", s));
                    list.add(new BasicNameValuePair("sign", encodeMd5));
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("http://211.156.200.95:8082/selfSend/HkGpy/");
                    sb2.append(s2);
                    final HttpPost httpPost = new HttpPost(sb2.toString());
                    httpPost.setEntity((HttpEntity) new UrlEncodedFormEntity((Iterable)list, UTF_8));
                    final int code = HttpClients.createDefault().execute(httpPost).getStatusLine().getStatusCode();
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("run: ==============================");
                    sb3.append(code);
                    Log.d("OkhttpManager", sb3.toString());
                    if (code == 200) {
                        onOkhttpCallback.onSuccess(true);
                        return;
                    }
                    onOkhttpCallback.onSuccess(false);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    public interface OnHttpCallback
    {
        void onError(final int p0, final String p1);

        void onSuccess(final String p0);
    }

    public interface OnHttpErrorCallback
    {
        void onError(final int p0, final String p1);
    }

    public interface OnOkhttpCallback<T>
    {
        void onSuccess(final T p0);
    }

    public interface OnOkhttpCallbackError
    {
        void onError(final String p0);
    }

    public interface OnOkhttpCallbackJKY<T>
    {
        void onError(final int p0, final String p1);

        void onSuccess(final T p0);
    }
}
