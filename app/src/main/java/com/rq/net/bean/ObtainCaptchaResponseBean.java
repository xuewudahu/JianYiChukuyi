package com.rq.net.bean;

import android.util.Log;

import com.rq.net.LoginActivity;
import com.rq.net.util.Intrinsics;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ObtainCaptchaResponseBean {
    private String code;
    private String mobile;
    private List pictures;

    public ObtainCaptchaResponseBean(String var1, String var2, List var3) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "code");
        //Intrinsics.checkParameterIsNotNull(var2, "mobile");
        //Intrinsics.checkParameterIsNotNull(var3, "pictures");*/
        super();
        this.code = var1;
        this.mobile = var2;
        this.pictures = var3;
    }

    // $FF: synthetic method
    public static ObtainCaptchaResponseBean copy$default(ObtainCaptchaResponseBean var0, String var1, String var2, List var3, int var4, Object var5) {
        if ((var4 & 1) != 0) {
            var1 = var0.code;
        }

        if ((var4 & 2) != 0) {
            var2 = var0.mobile;
        }

        if ((var4 & 4) != 0) {
            var3 = var0.pictures;
        }

        return var0.copy(var1, var2, var3);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.mobile;
    }

    public final List component3() {
        return this.pictures;
    }

    public final ObtainCaptchaResponseBean copy(String var1, String var2, List var3) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "code");
        //Intrinsics.checkParameterIsNotNull(var2, "mobile");
        //Intrinsics.checkParameterIsNotNull(var3, "pictures");*/
        return new ObtainCaptchaResponseBean(var1, var2, var3);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (!(var1 instanceof ObtainCaptchaResponseBean)) {
                return false;
            }

            ObtainCaptchaResponseBean var2 = (ObtainCaptchaResponseBean)var1;
            if (!Intrinsics.areEqual(this.code, var2.code) || !Intrinsics.areEqual(this.mobile, var2.mobile) || !Intrinsics.areEqual(this.pictures, var2.pictures)) {
                return false;
            }
        }

        return true;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final List getPictures() {
        return this.pictures;
    }

    public int hashCode() {
        String var4 = this.code;
        int var3 = 0;
        int var1;
        if (var4 != null) {
            var1 = var4.hashCode();
        } else {
            var1 = 0;
        }

        var4 = this.mobile;
        int var2;
        if (var4 != null) {
            var2 = var4.hashCode();
        } else {
            var2 = 0;
        }

        List var5 = this.pictures;
        if (var5 != null) {
            var3 = var5.hashCode();
        }

        return (var1 * 31 + var2) * 31 + var3;
    }

    public final void setCode(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.code = var1;
    }

    public final void setMobile(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.mobile = var1;
    }

    public final void setPictures(List var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.pictures = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("ObtainCaptchaResponseBean(code=");
        var1.append(this.code);
        var1.append(", mobile=");
        var1.append(this.mobile);
        var1.append(", pictures=");
        var1.append(this.pictures);
        var1.append(")");
        return var1.toString();
    }

    /**
     *     private String code;
     *     private String mobile;
     *     private List pictures;
     * @param jsonStr
     * @return
     */
    public static ObtainCaptchaResponseBean parsetJsonString(String jsonStr){
        if (jsonStr.trim().startsWith("{") && jsonStr.trim().endsWith("}")){
            ObtainCaptchaResponseBean ocrb = null;
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                ArrayList list = new ArrayList();
                JSONArray pictures = null;
                String code = "";
                String mobile = "";

                if (jsonObject.has("code"))
                    code = jsonObject.getString("code");
                if (jsonObject.has("mobile"))
                    mobile = jsonObject.getString("mobile");
                if (jsonObject.has("pictures"))
                    pictures = jsonObject.getJSONArray("pictures");
                if(pictures != null && pictures.length() > 0)
                    list.add(pictures.getString(0));
                ocrb = new ObtainCaptchaResponseBean(code,
                        mobile,
                        list);
                return ocrb;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        Log.i(LoginActivity.TAG,"parse fail ,jsonstr="+jsonStr);

        return null;
    }

}
