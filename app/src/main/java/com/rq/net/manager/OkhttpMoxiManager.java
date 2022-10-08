package com.rq.net.manager;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonObject;
import com.rq.net.setting.RqFilePreference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpMoxiManager {
    private static OkhttpManager okhttpManager;

    public static OkhttpManager getOkhttpManager() {
        return okhttpManager;
    }

    public static void setOkhttpManager(OkhttpManager okhttpManager) {
        OkhttpMoxiManager.okhttpManager = okhttpManager;
    }


    public static void outLib(final String barcode,final OkhttpCallback outLibCallback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                RqFilePreference rqFilePreference = RqFilePreference.getInstance();
                String branch = rqFilePreference.getMoxiBranch();
                String account = rqFilePreference.getMoxiAccount();
                String pwd = rqFilePreference.getMoxiPwd();
                String sData = null;
                try {
                    sData = requestService(barcode,branch,account,pwd);
                    Log.e("wwww","------"+sData);
                    String s = sData.substring(sData.indexOf("{"));
                    JSONObject jsonObject = new JSONObject(s);
                    String object = jsonObject.getString("code");
                    String message = jsonObject.getString("message");
                    String data = jsonObject.getString("data");
                    if (object.equals("200")&&data.equals("[]")) {
                        if (outLibCallback != null) {
                            outLibCallback.onSuccess(message);
                        }
                    } else if (object.equals("200")&&!data.equals("[]")) {
                        if (outLibCallback != null) {
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            outLibCallback.onSuccess(message+",还有"+jsonArray.length()+"个包裹!");
                        }
                    } else {
                        if (outLibCallback != null) {
                            outLibCallback.onError(Integer.parseInt(object), message);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("wwww", "-response--Exception");
                }
            }
        }).start();
    }
//added by wxw start ----------摩西登录界面客户没有提供，按客户要求提供虚拟登录。账号密码匹配即可登录。
/*    public static void login(final String branch,final String account,final String password,OkhttpCallback loginCallback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sData = null;
                final String md5Pwd = md5(password);
                try {
                    sData = requestService("9988776655443322110",branch,account,md5Pwd);
                    String s = sData.substring(sData.indexOf("{"));
                    JSONObject jsonObject = new JSONObject(s);
                    String object = jsonObject.getString("code");
                    String message = jsonObject.getString("message");
                    String data = jsonObject.getString("data");
                    if (object.equals("1002") ||object.equals("1003")
                            ||object.equals("1004") ||object.equals("1011")
                            ||object.equals("1012") ||object.equals("1014")) {
                        if (loginCallback != null) {
                            loginCallback.onError(Integer.parseInt(object),message);
                        }
                    }  else { //login success
                        RqFilePreference.getInstance().setMoxiAccount(account);
                        RqFilePreference.getInstance().setMoxiBranch(branch);
                        RqFilePreference.getInstance().setMoxiPwd(password);
                        if (loginCallback != null) {
                            //added by wxw
                            if (OkhttpManager.mOnOkhttpCallback != null) {
                                OkhttpManager.mOnOkhttpCallback.onSuccess(null);
                            }
                            loginCallback.onSuccess("Login success!");
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }*/

    public static void login(final String branch,final String account,final String password,OkhttpCallback loginCallback){
        if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(password) && account.equals("3101000205") && password.equals("123456")) {
            if (loginCallback != null) {
                Log.e("wwww","--3101000205--");
                RqFilePreference.getInstance().setMOXIGUANJIAAccount("3101000205");
                RqFilePreference.getInstance().setMOXIGUANJIAPwd("123456");
                loginCallback.onSuccess(null);
            }
        } else {
            if (OkhttpManager.onErrorCallback != null) {
                OkhttpManager.onErrorCallback.onError(2, "登录失败");
            }
        }
    }
    //added by wxw end
    public static String requestService(String ticket,String branch,String account,String pwd) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(getUrl(ticket,branch,account,pwd))
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }




    /**
     * base64编码
     * str 内容
     * charset 编码方式
     *
     * @throws UnsupportedEncodingException
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private String base64(String str, String charset) throws UnsupportedEncodingException {
        String encoded = Base64.getEncoder().encodeToString((str.getBytes(charset)));
        return encoded;
    }

    private static String getUrl(String code,String branch,String account,String pwd) {
        String sign = md5("ZmJjNjU2NDM3ODFjZWFmZDM4M2Q0NDUyMTU0YjJhNWQ=" +
                "actionmx.sign_by_gpyappid8581905921branch_code71000207funcindex" +
                "mailno" + code + "s_numberA10000126D9596user_code7100020701" +
                "user_pw21b95a0f90138767b0fd324e6be3457bZmJjNjU2NDM3ODFjZWFmZDM4M2Q0NDUyMTU0YjJhNWQ=");
        Log.e("wwww","-----sign-----"+sign.toUpperCase());
        String url = "http://dev.fsmoses.net/cbs/weixin/interface/interface.php?" +
                "action=mx.sign_by_gpy&appid=8581905921&branch_code=71000207&func=index&" +
                "mailno=" + code + "&s_number=A10000126D9596&user_code=7100020701&" +
                "user_pw=21b95a0f90138767b0fd324e6be3457b&sign="+sign.toUpperCase();
        Log.e("wwww","-----sign-----"+url);
        return url;
    }

    public static String md5(String string){
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result.append(temp);
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public interface OkhttpCallback{
        void onError(int var1, String var2);

        void onSuccess(String var1);
    }

}
