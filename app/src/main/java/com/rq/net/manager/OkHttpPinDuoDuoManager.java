package com.rq.net.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;

import com.rq.net.LoginActivity;
import com.rq.net.MyApplication;
import com.rq.net.bean.ObtainCaptchaRequestBean;
import com.rq.net.bean.ObtainCaptchaResponseBean;
import com.rq.net.bean.PinDuoDuoBaseResponseBean;
import com.rq.net.bean.PinDuoDuoLoginRequestBean;
import com.rq.net.bean.PinDuoDuoLoginResponseResultBean;
import com.rq.net.bean.PinDuoDuoOutLibraryRequestBean;
import com.rq.net.bean.PinDuoDuoRefreshTokenBean;
import com.rq.net.bean.PinDuoDuoSaveImageRequestBean;
import com.rq.net.bean.UserVerifyRequestBean;
import com.rq.net.di.CommonApiCallback;
import com.rq.net.setting.RqFilePreference;
import com.rq.net.util.ImageSaveUtil;
import com.rq.net.util.ToastSoundUtil;
import com.xunmeng.pinduoduo.secure.DeviceNative;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class OkHttpPinDuoDuoManager {
    static final String model = "X70 Pro";
    static final String userAgent = "Dalvik/2.1.0 (Linux; U; Android 11; X70 Pro Build/LMY48Z)station_android_version/1.5.1 PackegeName/com.xunmeng.station AppVersion/1.5.1 DeviceType/Mobile AppName/DDStore";

    public OkHttpPinDuoDuoManager() {
    }

    public static void checkNotOutLibraryMuchPackage(Context var0, String var1, final OkHttpPinDuoDuoManager.OnHttpCallback var2) {
        String var5 = DeviceNative.getSecure(var0);
        String var3 = "faketoken";//RqFilePreference.getInstance().getDuoDuoToken();
        StringBuilder var4 = new StringBuilder();
        var4.append("SUB_PASS_ID=");
        var4.append(var3);
        String var6 = var4.toString();
        MyApplication.getDaggerReposifitComponent().getRequestApiDuoDuoStation().checkNotOutLibraryMuchPackage(var5, "X70 Pro", "Dalvik/2.1.0 (Linux; U; Android 11; X70 Pro Build/LMY48Z)station_android_version/1.5.1 PackegeName/com.xunmeng.station AppVersion/1.5.1 DeviceType/Mobile AppName/DDStore", var6, var3, var1).enqueue(new CommonApiCallback(new CommonApiCallback.HttpCallback() {//<PinDuoDuoBaseResponseBean<DuoDuoPhone>>
            public void onFailure(int var1, String var2x) {
                StringBuilder var3 = new StringBuilder();
                var3.append("多多查询未出库多包失败:");
                var3.append(var1);
                var3.append("  ");
                var3.append(var2x);
                //XLog.e(var3.toString());
                ToastSoundUtil.wrongSoundToast(var2x);
            }

            public void onSuccess(Object var) {
                PinDuoDuoBaseResponseBean var1 = null;
                if (var instanceof Response) {
                    Log.e(LoginActivity.TAG,"instance pass");
                    if (((Response) var).body() instanceof PinDuoDuoBaseResponseBean) {
                        var1 = (PinDuoDuoBaseResponseBean)((Response) var).body();
                    } else {
                        Log.e(LoginActivity.TAG, "instance pass");
                        String jsonStr = null;
                        try {
                            jsonStr = ((ResponseBody) ((Response) var).body()).string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        var1 = PinDuoDuoBaseResponseBean.parsetJsonString(jsonStr);
                    }
                } else {
                    Log.e(LoginActivity.TAG,"instance fail");
                }
                if (var1 == null){
                    Log.e(LoginActivity.TAG,"getDuoDuoRevers var1 is null");
                    return;
                }
                //PinDuoDuoBaseResponseBean var1 = (PinDuoDuoBaseResponseBean)var;
                OkHttpPinDuoDuoManager.OnHttpCallback var3;
                if (var1.getSuccess()) {
                    //XLog.e("多多查询未出库多包裹成功");
                    var3 = var2;
                    if (var3 != null) {
                        var3.onSuccess(var1);
                        return;
                    }
                } else {
                    var3 = var2;
                    if (var3 != null) {
                        int var2x = var1.getErrorCode();
                        StringBuilder var4 = new StringBuilder();
                        var4.append(var1.getErrorMsg());
                        var4.append(var1.getError_msg());
                        var3.onError(var2x, var4.toString());
                    }

                    StringBuilder var5 = new StringBuilder();
                    var5.append("多多查询未出库多包失败：");
                    var5.append(var1.getErrorMsg());
                    //XLog.e(var5.toString());
                }

            }
        }));
    }

    public static void checkPackagePhone(Context var0, String var1, final OkHttpPinDuoDuoManager.OnHttpCallback var2) {
        String var5 = DeviceNative.getSecure(var0);
        String var3 = "faketoken";//RqFilePreference.getInstance().getDuoDuoToken();
        StringBuilder var4 = new StringBuilder();
        var4.append("SUB_PASS_ID=");
        var4.append(var3);
        String var6 = var4.toString();
        MyApplication.getDaggerReposifitComponent().getRequestApiDuoDuoStation().getDuoDuoRevers(var5, "X70 Pro", "Dalvik/2.1.0 (Linux; U; Android 11; X70 Pro Build/LMY48Z)station_android_version/1.5.1 PackegeName/com.xunmeng.station AppVersion/1.5.1 DeviceType/Mobile AppName/DDStore", var6, var3, var1).enqueue(new CommonApiCallback(new CommonApiCallback.HttpCallback() {//<PinDuoDuoBaseResponseBean<DuoDuoPhone>>
            public void onFailure(int var1, String var2x) {
                StringBuilder var3 = new StringBuilder();
                var3.append("多多查询未出库多包失败:");
                var3.append(var1);
                var3.append("  ");
                var3.append(var2x);
                //XLog.e(var3.toString());
                ToastSoundUtil.wrongSoundToast(var2x);
            }

            public void onSuccess(Object var) {//<DuoDuoPhone>
                PinDuoDuoBaseResponseBean var1 = null;
                if (var instanceof Response) {
                    Log.e(LoginActivity.TAG,"instance pass");
                    if (((Response) var).body() instanceof PinDuoDuoBaseResponseBean) {
                        var1 = (PinDuoDuoBaseResponseBean)((Response) var).body();
                    } else {
                        Log.e(LoginActivity.TAG, "instance pass");
                        String jsonStr = null;
                        try {
                            jsonStr = ((ResponseBody) ((Response) var).body()).string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        var1 = PinDuoDuoBaseResponseBean.parsetJsonString(jsonStr);
                    }
                } else {
                    Log.e(LoginActivity.TAG,"instance fail");
                }
                if (var1 == null){
                    Log.e(LoginActivity.TAG,"getDuoDuoRevers var1 is null");
                    return;
                }
                //PinDuoDuoBaseResponseBean var1 = (PinDuoDuoBaseResponseBean)var;
                OkHttpPinDuoDuoManager.OnHttpCallback var3;

                if (var1.getSuccess()) {
                    //XLog.e("多多客户手机号查询成功");
                    var3 = var2;
                    if (var3 != null) {
                        var3.onSuccess(var1);
                        return;
                    }
                } else {
                    var3 = var2;
                    if (var3 != null) {
                        int var2x = var1.getErrorCode();
                        StringBuilder var4 = new StringBuilder();
                        var4.append(var1.getErrorMsg());
                        var4.append(var1.getError_msg());
                        var3.onError(var2x, var4.toString());
                    }

                    StringBuilder var5 = new StringBuilder();
                    var5.append("多多客户手机号查询失败：");
                    var5.append(var1.getErrorMsg());
                    //XLog.e(var5.toString());
                }

            }
        }));
    }

    public static void getPasswordPublicKey(Context var0, String var1, final OkhttpManager.OnOkhttpCallback var2) {
        String var3 = DeviceNative.getSecure(var0);
        MyApplication.getDaggerReposifitComponent().getRequestApiDuoDuoStation().getPasswordPublicKey(var1, var3, "X70 Pro", "Dalvik/2.1.0 (Linux; U; Android 11; X70 Pro Build/LMY48Z)station_android_version/1.5.1 PackegeName/com.xunmeng.station AppVersion/1.5.1 DeviceType/Mobile AppName/DDStore").enqueue(new CommonApiCallback(new CommonApiCallback.HttpCallback<PinDuoDuoBaseResponseBean>() {//<PinDuoDuoBaseResponseBean>
            public void onFailure(int var1, String var2x) {
                StringBuilder var3 = new StringBuilder();
                var3.append("多多获取公钥失败:");
                var3.append(var1);
                var3.append("  ");
                var3.append(var2x);
                //XLog.e(var3.toString());
                ToastSoundUtil.wrongSoundToast(var2x);
            }

            public void onSuccess(PinDuoDuoBaseResponseBean var) {
                //PinDuoDuoBaseResponseBean var1 = (PinDuoDuoBaseResponseBean)var;
                /*PinDuoDuoBaseResponseBean var = null;
                if (var1 instanceof PinDuoDuoBaseResponseBean) {
                    Log.e(LoginActivity.TAG, "instance pass");
                    var = (PinDuoDuoBaseResponseBean)var1;
                } else {
                    Log.e(LoginActivity.TAG,"instance fail");

                    String jsonStr = null;
                    try {
                        jsonStr = ((ResponseBody) ((Response) var1).body()).string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    var = PinDuoDuoBaseResponseBean.parsetJsonString(jsonStr);
                }*/
                //XLog.e("多多获取公钥成功");
                OkhttpManager.OnOkhttpCallback var2x = var2;
                if (var2x != null) {
                    var2x.onSuccess(var);
                }

            }
        }));
    }

    public static String getPasswordRSAToBase64(String var0, String var1) {
        Cipher var2;
        label27: {
            try {
                var2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                break label27;
            } catch (NoSuchAlgorithmException var6) {
                var6.printStackTrace();
            } catch (NoSuchPaddingException var7) {
                var7.printStackTrace();
            }

            var2 = null;
        }

        try {
            var2.init(1, getPublicKey(var1));
        } catch (InvalidKeyException var5) {
            var5.printStackTrace();
        }

        try {
            var0 = Base64.encodeToString(var2.doFinal(var0.getBytes()), 0);
            return var0;
        } catch (BadPaddingException var3) {
            var3.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static void getPicVerification(Context var0, Boolean var1, String var2, final OkhttpManager.OnOkhttpCallback var3) {
        String var4 = DeviceNative.getSecure(var0);
        MyApplication.getDaggerReposifitComponent().getRequestApiDuoDuoStation().getObtainCaptcha(var2, var4, "X70 Pro", "Dalvik/2.1.0 (Linux; U; Android 11; X70 Pro Build/LMY48Z)station_android_version/1.5.1 PackegeName/com.xunmeng.station AppVersion/1.5.1 DeviceType/Mobile AppName/DDStore", new ObtainCaptchaRequestBean(var1)).enqueue(new CommonApiCallback(new CommonApiCallback.HttpCallback<ResponseBody>() {//<PinDuoDuoBaseResponseBean<ObtainCaptchaResponseBean>>
            public void onFailure(int var1, String var2) {
                StringBuilder var3x = new StringBuilder();
                var3x.append("获取验证码异常:");
                var3x.append(var1);
                var3x.append("  ");
                var3x.append(var2);
                //XLog.e(var3x.toString());
                ToastSoundUtil.wrongSoundToast(var2);
            }

            public void onSuccess(ResponseBody var) {
                PinDuoDuoBaseResponseBean var1 = null;
                String jsonStr = null;
                try {
                    jsonStr = var.string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                var1 = PinDuoDuoBaseResponseBean.parsetJsonString(jsonStr);
                if (var1 == null){
                    Log.e(LoginActivity.TAG,"getPicVerification var1 is null");
                    return;
                }
                //PinDuoDuoBaseResponseBean var1 = (PinDuoDuoBaseResponseBean)var;
                if (var1.getSuccess()) {
                    //XLog.e("获取验证图片成功");
                    Log.e(LoginActivity.TAG,"获取验证图片成功 var1:"+var1);
                    if(var1.getResult() instanceof ObtainCaptchaResponseBean) {
                        var3.onSuccess(((ObtainCaptchaResponseBean)var1.getResult()).getPictures().get(0));
                    } else {
                        var3.onSuccess(ObtainCaptchaResponseBean.parsetJsonString(var1.getResult().toString()).getPictures().get(0));
                    }

                } else {
                    //XLog.e("获取验证图片失败");
                    Log.e(LoginActivity.TAG,"获取验证图片失败 var1:"+var1);
                }
            }
        }));
    }

    public static PublicKey getPublicKey(String var0) {
        try {
            PublicKey var3 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(var0, 0)));
            return var3;
        } catch (InvalidKeySpecException var1) {
            var1.printStackTrace();
        } catch (NoSuchAlgorithmException var2) {
            var2.printStackTrace();
        }

        return null;
    }

    public static void loginByMobile(Context var0, String var1, final String var2, final String var3, String var4, final OkhttpManager.OnOkhttpCallback var5, final OkhttpManager.OnHttpErrorCallback var6) {
        String var7 = DeviceNative.getSecure(var0);
        PinDuoDuoLoginRequestBean var8 = new PinDuoDuoLoginRequestBean("2", getPasswordRSAToBase64(var3, var4), var2);
        MyApplication.getDaggerReposifitComponent().getRequestApiDuoDuoStation().getLoginByMobile(var1, var7, "X70 Pro", "Dalvik/2.1.0 (Linux; U; Android 11; X70 Pro Build/LMY48Z)station_android_version/1.5.1 PackegeName/com.xunmeng.station AppVersion/1.5.1 DeviceType/Mobile AppName/DDStore", var8).enqueue(new CommonApiCallback(new CommonApiCallback.HttpCallback<ResponseBody>() {//<PinDuoDuoBaseResponseBean<PinDuoDuoLoginResponseResultBean>>
            public void onFailure(int var1, String var2x) {
                StringBuilder var3x = new StringBuilder();
                var3x.append("多多登录失败:");
                var3x.append(var1);
                var3x.append("  ");
                var3x.append(var2x);
                //XLog.e(var3x.toString());
                ToastSoundUtil.wrongSoundToast(var2x);

            }

            public void onSuccess(ResponseBody var) {//<PinDuoDuoLoginResponseResultBean>
                PinDuoDuoBaseResponseBean var1 = null;
                if (var != null) {
                    String jsonStr = null;
                    try {
                        jsonStr = var.string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    var1 = PinDuoDuoBaseResponseBean.parsetJsonString(jsonStr);
                } else {
                    var1 = new PinDuoDuoBaseResponseBean(40001014,40001014,"错误的手机号或密码","错误的手机号或密码",null,false);
                }
                if (var1 == null){
                    Log.e(LoginActivity.TAG,"loginByMobile var1 is null");
                    return;
                } else {
                    Log.e(LoginActivity.TAG,"loginByMobile var1:"+var1.toString());
                }
                //PinDuoDuoBaseResponseBean var1 = (PinDuoDuoBaseResponseBean)var;
                if (var1.getSuccess()) {
                    RqFilePreference.getInstance().setLoginDuoDuoUsername(var2);
                    RqFilePreference.getInstance().setLoginDuoDuoPassword(var3);
                    if(var1.getResult() instanceof PinDuoDuoLoginResponseResultBean) {
                        RqFilePreference.getInstance().setDuoDuoToken(((PinDuoDuoLoginResponseResultBean) var1.getResult()).getToken()/*PinDuoDuoLoginResponseResultBean.parsetJsonString(var1.getResult().toString()).getToken()*/);
                    } else {
                        RqFilePreference.getInstance().setDuoDuoToken(PinDuoDuoLoginResponseResultBean.parsetJsonString(var1.getResult().toString()).getToken());
                    }
                    //XLog.d("TAG", "多多登录成功:=== ");
                    OkhttpManager.OnOkhttpCallback var2x = var5;
                    if (var2x != null) {
                        RqFilePreference.getInstance().setDUODUOYIZHANAccount(var2);
                        RqFilePreference.getInstance().setDUODUOYIZHANPwd(var3);
                        var2x.onSuccess(var1);
                        return;
                    }
                } else {
                    if(var1.getResult() instanceof PinDuoDuoLoginResponseResultBean) {
                        var6.onError(var1.getErrorCode(), ((PinDuoDuoLoginResponseResultBean) var1.getResult()).getVerifyAuthToken());
                    } else {
                        if (PinDuoDuoLoginResponseResultBean.parsetJsonString(var1.getResult().toString()) == null) {

                            var6.onError(var1.getErrorCode(), "");
                        } else {
                            Log.e("wxwww","111111"+ var1.getResult() == null?"":PinDuoDuoLoginResponseResultBean.parsetJsonString(var1.getResult().toString()).getVerifyAuthToken());

                            var6.onError(var1.getErrorCode(), var1.getResult() == null?"":PinDuoDuoLoginResponseResultBean.parsetJsonString(var1.getResult().toString()).getVerifyAuthToken());
                        }

                    }
                    StringBuilder var3x = new StringBuilder();
                    var3x.append(var1.getErrorMsg());
                    if (OkhttpManager.onErrorCallback != null) {
                        OkhttpManager.onErrorCallback.onError(-2, var3x.toString());
                    }
                    ToastSoundUtil.wrongSoundToast(var3x.toString());
                }

            }
        }));
    }

    public static void outLibrary(Context var0, String var1, final OkHttpPinDuoDuoManager.OnHttpCallback var2) {
        String var6;
        try {
            var6 = DeviceNative.getSecure(var0);
        } catch (Exception var5) {
            var5.printStackTrace();
            return;
        }

        PinDuoDuoOutLibraryRequestBean var7 = new PinDuoDuoOutLibraryRequestBean("X70 Pro", var1);
        String var3 = RqFilePreference.getInstance().getDuoDuoToken();
        StringBuilder var4 = new StringBuilder();
        var4.append("SUB_PASS_ID=");
        var4.append(var3);
        String var8 = var4.toString();
        MyApplication.getDaggerReposifitComponent().getRequestApiDuoDuoStation().outLibrary(var6, "X70 Pro", "Dalvik/2.1.0 (Linux; U; Android 11; X70 Pro Build/LMY48Z)station_android_version/1.5.1 PackegeName/com.xunmeng.station AppVersion/1.5.1 DeviceType/Mobile AppName/DDStore", var8, var3, var7).enqueue(new CommonApiCallback(new CommonApiCallback.HttpCallback<PinDuoDuoBaseResponseBean>() {//<PinDuoDuoBaseResponseBean<PinDuoDuoOutLibraryResponseBean>>
            public void onFailure(int var1, String var2x) {
                StringBuilder var3 = new StringBuilder();
                var3.append("多多出库失败:");
                var3.append(var1);
                var3.append("  ");
                var3.append(var2x);
                //XLog.e(var3.toString());
                var2.onError(-1, var2x);
            }

            public void onSuccess(PinDuoDuoBaseResponseBean var1 ) {//<PinDuoDuoOutLibraryResponseBean>
                /*PinDuoDuoBaseResponseBean var1 = null;
                if (var instanceof Response) {
                    Log.e(LoginActivity.TAG,"instance pass");
                    if (((Response) var).body() instanceof PinDuoDuoBaseResponseBean) {
                        var1 = (PinDuoDuoBaseResponseBean)((Response) var).body();
                    } else {
                        Log.e(LoginActivity.TAG, "instance pass");
                        String jsonStr = null;
                        try {
                            jsonStr = ((ResponseBody) ((Response) var).body()).string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        var1 = PinDuoDuoBaseResponseBean.parsetJsonString(jsonStr);
                    }
                } else {
                    Log.e(LoginActivity.TAG,"instance fail");
                }*/
                if (var1 == null){
                    Log.e(LoginActivity.TAG,"outLibrary var1 is null");
                    return;
                }

                //PinDuoDuoBaseResponseBean var1 = (PinDuoDuoBaseResponseBean)var;
                OkHttpPinDuoDuoManager.OnHttpCallback var2x;
                if (var1.getSuccess()) {
                    //XLog.e("多多出库成功");
                    var2x = var2;
                    if (var2x != null) {
                        var2x.onSuccess(var1);
                        return;
                    }
                } else {
                    StringBuilder var3 = new StringBuilder();
                    var3.append("多多出库失败：");
                    var3.append(var1.getError_msg());
                    //XLog.e(var3.toString());
                    var2x = var2;
                    if (var2x != null) {
                        var2x.onError(var1.getErrorCode(), var1.getError_msg());
                    }
                }

            }
        }));
    }

    public static void outLibraryAio(Context var0, String var1, final OkHttpPinDuoDuoManager.OnHttpCallback var2) {
        String var6;
        try {
            var6 = DeviceNative.getSecure(var0);
        } catch (Exception var5) {
            var5.printStackTrace();
            return;
        }

        PinDuoDuoOutLibraryRequestBean var7 = new PinDuoDuoOutLibraryRequestBean("X70 Pro", var1);
        String var3 = RqFilePreference.getInstance().getDuoDuoToken();
        StringBuilder var4 = new StringBuilder();
        var4.append("SUB_PASS_ID=");
        var4.append(var3);
        String var8 = var4.toString();
        MyApplication.getDaggerReposifitComponent().getRequestApiDuoDuoStation().outLibraryAio(var6, "X70 Pro", "Dalvik/2.1.0 (Linux; U; Android 11; X70 Pro Build/LMY48Z)station_android_version/1.5.1 PackegeName/com.xunmeng.station AppVersion/1.5.1 DeviceType/Mobile AppName/DDStore", var8, var3, var7).enqueue(new CommonApiCallback(new CommonApiCallback.HttpCallback<PinDuoDuoBaseResponseBean>() {//<PinDuoDuoBaseResponseBean<PinDuoDuoOutLibraryAioResponseBean>>
            public void onFailure(int var1, String var2x) {
                StringBuilder var3 = new StringBuilder();
                var3.append("多多出库失败:");
                var3.append(var1);
                var3.append("  ");
                var3.append(var2x);
                //XLog.e(var3.toString());
                var2.onError(-1, var2x);
                //added by wxw
                if(OkhttpManager.onErrorCallback !=null) {
                    OkhttpManager.onErrorCallback.onError(-1, var2x);
                }

            }

            public void onSuccess(PinDuoDuoBaseResponseBean var1) {//<PinDuoDuoOutLibraryAioResponseBean>
                /*PinDuoDuoBaseResponseBean var1 = null;
                if (var instanceof Response) {
                    Log.e(LoginActivity.TAG,"instance pass");
                    if (((Response) var).body() instanceof PinDuoDuoBaseResponseBean) {
                        var1 = (PinDuoDuoBaseResponseBean)((Response) var).body();
                    } else {
                        Log.e(LoginActivity.TAG, "instance pass");
                        String jsonStr = null;
                        try {
                            jsonStr = ((ResponseBody) ((Response) var).body()).string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        var1 = PinDuoDuoBaseResponseBean.parsetJsonString(jsonStr);
                    }
                } else {
                    Log.e(LoginActivity.TAG,"instance fail");
                }*/
                if (var1 == null){
                    Log.e(LoginActivity.TAG,"outLibraryAio var1 is null");
                    return;
                }
                //PinDuoDuoBaseResponseBean var1 = (PinDuoDuoBaseResponseBean)var;
                OkHttpPinDuoDuoManager.OnHttpCallback var2x;
                if (var1.getSuccess()) {
                    //XLog.e("多多出库成功");
                    var2x = var2;
                    if(OkhttpManager.mOnOkhttpCallback !=null) {
                        OkhttpManager.mOnOkhttpCallback.onSuccess(var1);
                    }
                    if (var2x != null) {
                        var2x.onSuccess(var1);
                        return;
                    }
                } else {
                    StringBuilder var3 = new StringBuilder();
                    var3.append("多多出库失败：");
                    var3.append(var1.getError_msg());
                    //XLog.e(var3.toString());
                    var2x = var2;
                    if (var2x != null) {
                        var2x.onError(var1.getErrorCode(), var1.getError_msg());
                    }
                    //added by wxw
                    if(OkhttpManager.onErrorCallback !=null) {
                        OkhttpManager.onErrorCallback.onError(var1.getErrorCode(), var1.getError_msg());
                    }
                }

            }
        }));
    }

    public static void refreshToken(Context var0, final OkhttpManager.OnOkhttpCallback var1, final OkhttpManager.OnHttpErrorCallback var2) {
        String var5 = DeviceNative.getSecure(var0);
        String var3 = RqFilePreference.getInstance().getDuoDuoToken();
        StringBuilder var4 = new StringBuilder();
        var4.append("SUB_PASS_ID=");
        var4.append(var3);
        String var6 = var4.toString();
        MyApplication.getDaggerReposifitComponent().getRequestApiDuoDuoStation().refreshToken(var5, "X70 Pro", "Dalvik/2.1.0 (Linux; U; Android 11; X70 Pro Build/LMY48Z)station_android_version/1.5.1 PackegeName/com.xunmeng.station AppVersion/1.5.1 DeviceType/Mobile AppName/DDStore", var6, var3).enqueue(new CommonApiCallback(new CommonApiCallback.HttpCallback() {//<PinDuoDuoBaseResponseBean<PinDuoDuoRefreshTokenBean>>
            public void onFailure(int var1x, String var2x) {
                StringBuilder var3 = new StringBuilder();
                var3.append("多多刷新token失败:");
                var3.append(var1x);
                var3.append("  ");
                var3.append(var2x);
               // //XLog.e(var3.toString());
                ToastSoundUtil.wrongSoundToast(var2x);
            }

            public void onSuccess(Object var) {//<PinDuoDuoRefreshTokenBean>
                PinDuoDuoBaseResponseBean var1x = (PinDuoDuoBaseResponseBean)var;
                if (var1x.getSuccess()) {
                    //XLog.e("多多刷新token成功");
                    RqFilePreference.getInstance().setDuoDuoToken(((PinDuoDuoRefreshTokenBean)var1x.getResult()).getToken());
                    OkhttpManager.OnOkhttpCallback var3 = var1;
                    if (var3 != null) {
                        var3.onSuccess(var1x);
                        return;
                    }
                } else {
                    OkhttpManager.OnHttpErrorCallback var5 = var2;
                    if (var5 != null) {
                        int var2x = var1x.getErrorCode();
                        StringBuilder var4 = new StringBuilder();
                        var4.append(var1x.getErrorMsg());
                        var4.append(var1x.getError_msg());
                        var5.onError(var2x, var4.toString());
                    }

                    StringBuilder var6 = new StringBuilder();
                    var6.append("多多刷新token失败：");
                    var6.append(var1x.getErrorMsg());
                    //XLog.e(var6.toString());
                    var6 = new StringBuilder();
                    var6.append(var1x.getErrorMsg());
                    var6.append(var1x.getError_msg());
                    ToastSoundUtil.wrongSoundToast(var6.toString());
                }

            }
        }));
    }

    public static void uploadImage(Context var0, String var1, Bitmap var2, final OkHttpPinDuoDuoManager.OnHttpCallback var3) {
        String var4;
        String var9;
        MultipartBody var10;
        String var11;
        try {
            var9 = "";//DeviceNative.getSecure(var0);
            var4 = RqFilePreference.getInstance().getDuoDuoToken();
            StringBuilder var5 = new StringBuilder();
            var5.append("SUB_PASS_ID=");
            var5.append(var4);
            var11 = var5.toString();
            MultipartBody.Builder var6 = (new MultipartBody.Builder()).setType(MultipartBody.FORM);
            StringBuilder var7 = new StringBuilder();
            var7.append("form-data;name=\"file\";filename=\"");
            var7.append(var1);
            var7.append(".png\"");
            var10 = var6.addPart(Headers.of(new String[]{"Content-Disposition", var7.toString()}), RequestBody.create(MediaType.parse("image/jpeg"), ImageSaveUtil.getInstance().bitmapToBytes(var2))).build();
        } catch (Exception var8) {
            var8.printStackTrace();
            return;
        }

        if (var10 != null) {
            MyApplication.getDaggerReposifitComponent().getRequestApiDuoDuoStation().uploadImg(var9, "X70 Pro", "Dalvik/2.1.0 (Linux; U; Android 11; X70 Pro Build/LMY48Z)station_android_version/1.5.1 PackegeName/com.xunmeng.station AppVersion/1.5.1 DeviceType/Mobile AppName/DDStore", var11, var4, var10).enqueue(new CommonApiCallback(new CommonApiCallback.HttpCallback() {//<PinDuoDuoBaseResponseBean<String>>
                public void onFailure(int var1, String var2) {
                    StringBuilder var3x = new StringBuilder();
                    var3x.append("多多图片上传失败:");
                    var3x.append(var1);
                    var3x.append("  ");
                    var3x.append(var2);
                    //XLog.e(var3x.toString());
                    ToastSoundUtil.displayToast(var2);
                }

                public void onSuccess(Object var) {
                    PinDuoDuoBaseResponseBean var1 = (PinDuoDuoBaseResponseBean)var;
                    OkHttpPinDuoDuoManager.OnHttpCallback var2;
                    if (var1.getSuccess()) {
                        //XLog.e("多多图片上传成功");
                        var2 = var3;
                        if (var2 != null) {
                            var2.onSuccess(var1);
                            return;
                        }
                    } else {
                        StringBuilder var3x = new StringBuilder();
                        var3x.append("多多图片上传失败：");
                        var3x.append(var1.getError_msg());
                        //XLog.e(var3x.toString());
                        var2 = var3;
                        if (var2 != null) {
                            var2.onError(var1.getErrorCode(), var1.getError_msg());
                        }
                    }

                }
            }));
        }
    }

    public static void uploadSaveImageFlag(Context var0, String var1, String var2, final OkHttpPinDuoDuoManager.OnHttpCallback var3) {
        String var7 = DeviceNative.getSecure(var0);
        String var4 = RqFilePreference.getInstance().getDuoDuoToken();
        StringBuilder var5 = new StringBuilder();
        var5.append("SUB_PASS_ID=");
        var5.append(var4);
        String var6 = var5.toString();
        PinDuoDuoSaveImageRequestBean var8 = new PinDuoDuoSaveImageRequestBean(var1, var2);
        MyApplication.getDaggerReposifitComponent().getRequestApiDuoDuoStation().saveImageToServerFlag(var7, "X70 Pro", "Dalvik/2.1.0 (Linux; U; Android 11; X70 Pro Build/LMY48Z)station_android_version/1.5.1 PackegeName/com.xunmeng.station AppVersion/1.5.1 DeviceType/Mobile AppName/DDStore", var6, var4, var8).enqueue(new CommonApiCallback(new CommonApiCallback.HttpCallback() {//<PinDuoDuoBaseResponseBean<String>>
            public void onFailure(int var1, String var2) {
                StringBuilder var3x = new StringBuilder();
                var3x.append("多多图片保存失败:");
                var3x.append(var1);
                var3x.append("  ");
                var3x.append(var2);
                //XLog.e(var3x.toString());
                ToastSoundUtil.displayToast(var2);
            }

            public void onSuccess(Object var) {
                PinDuoDuoBaseResponseBean var1 = (PinDuoDuoBaseResponseBean)var;
                OkHttpPinDuoDuoManager.OnHttpCallback var2;
                if (var1.getSuccess()) {
                    //XLog.e("多多图片保存成功");
                    var2 = var3;
                    if (var2 != null) {
                        var2.onSuccess(var1);
                        return;
                    }
                } else {
                    StringBuilder var3x = new StringBuilder();
                    var3x.append("多多图片保存错误：");
                    var3x.append(var1.getError_msg());
                    //XLog.e(var3x.toString());
                    var2 = var3;
                    if (var2 != null) {
                        var2.onError(var1.getErrorCode(), var1.getError_msg());
                    }
                }

            }
        }));
    }

    public static void userVerify(Context var0, String var1, String var2, final OkhttpManager.OnHttpCallback var3) {
        String var4 = DeviceNative.getSecure(var0);
        MyApplication.getDaggerReposifitComponent().getRequestApiDuoDuoStation().userVerify(var1, var4, "X70 Pro", "Dalvik/2.1.0 (Linux; U; Android 11; X70 Pro Build/LMY48Z)station_android_version/1.5.1 PackegeName/com.xunmeng.station AppVersion/1.5.1 DeviceType/Mobile AppName/DDStore", new UserVerifyRequestBean(true, var2)).enqueue(new CommonApiCallback(new CommonApiCallback.HttpCallback<PinDuoDuoBaseResponseBean>() {//<PinDuoDuoBaseResponseBean<UserVerifyResponseBean>>
            public void onFailure(int var1, String var2) {
                StringBuilder var3x = new StringBuilder();
                var3x.append("获取验证码异常:");
                var3x.append(var1);
                var3x.append("  ");
                var3x.append(var2);
                //XLog.e(var3x.toString());
                ToastSoundUtil.wrongSoundToast(var2);
            }

            public void onSuccess(PinDuoDuoBaseResponseBean var1) {
                /*PinDuoDuoBaseResponseBean var1 = null;
                if (var instanceof Response) {
                    Log.e(LoginActivity.TAG,"instance pass");
                    if (((Response) var).body() instanceof PinDuoDuoBaseResponseBean) {
                        var1 = (PinDuoDuoBaseResponseBean)((Response) var).body();
                    } else {
                        Log.e(LoginActivity.TAG, "instance pass");
                        String jsonStr = null;
                        try {
                            jsonStr = ((ResponseBody) ((Response) var).body()).string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        var1 = PinDuoDuoBaseResponseBean.parsetJsonString(jsonStr);
                    }
                } else {
                    Log.e(LoginActivity.TAG,"instance fail");
                }*/
                if (var1 == null){
                    Log.e(LoginActivity.TAG,"userVerify var1 is null");
                    return;
                }
                if (var1.getSuccess()) {
                    //XLog.e("验证码验证成功");
                    var3.onSuccess("");
                } else {
                    //XLog.e("获取验证码失败");
                    var3.onError(0, "");
                }
            }
        }));
    }

    public interface OnHttpCallback<T> {
        void onError(int var1, String var2);

        void onSuccess(T var1);
    }
}
