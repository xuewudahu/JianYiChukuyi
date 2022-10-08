package com.rq.net.bean;

import android.util.Log;

import com.rq.net.LoginActivity;
import com.rq.net.util.Intrinsics;

import org.json.JSONException;
import org.json.JSONObject;

public class PinDuoDuoLoginResponseResultBean {
    private String token;
    private String userId;
    private String verifyAuthToken;

    public PinDuoDuoLoginResponseResultBean(String var1, String var2, String var3) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "token");
        //Intrinsics.checkParameterIsNotNull(var2, "userId");
        //Intrinsics.checkParameterIsNotNull(var3, "verifyAuthToken");*/
        super();
        this.token = var1;
        this.userId = var2;
        this.verifyAuthToken = var3;
    }

    // $FF: synthetic method
    public static PinDuoDuoLoginResponseResultBean copy$default(PinDuoDuoLoginResponseResultBean var0, String var1, String var2, String var3, int var4, Object var5) {
        if ((var4 & 1) != 0) {
            var1 = var0.token;
        }

        if ((var4 & 2) != 0) {
            var2 = var0.userId;
        }

        if ((var4 & 4) != 0) {
            var3 = var0.verifyAuthToken;
        }

        return var0.copy(var1, var2, var3);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.verifyAuthToken;
    }

    public final PinDuoDuoLoginResponseResultBean copy(String var1, String var2, String var3) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "token");
        //Intrinsics.checkParameterIsNotNull(var2, "userId");
        //Intrinsics.checkParameterIsNotNull(var3, "verifyAuthToken");*/
        return new PinDuoDuoLoginResponseResultBean(var1, var2, var3);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (!(var1 instanceof PinDuoDuoLoginResponseResultBean)) {
                return false;
            }

            PinDuoDuoLoginResponseResultBean var2 = (PinDuoDuoLoginResponseResultBean)var1;
            if (!Intrinsics.areEqual(this.token, var2.token) || !Intrinsics.areEqual(this.userId, var2.userId) || !Intrinsics.areEqual(this.verifyAuthToken, var2.verifyAuthToken)) {
                return false;
            }
        }

        return true;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getVerifyAuthToken() {
        return this.verifyAuthToken;
    }

    public int hashCode() {
        String var4 = this.token;
        int var3 = 0;
        int var1;
        if (var4 != null) {
            var1 = var4.hashCode();
        } else {
            var1 = 0;
        }

        var4 = this.userId;
        int var2;
        if (var4 != null) {
            var2 = var4.hashCode();
        } else {
            var2 = 0;
        }

        var4 = this.verifyAuthToken;
        if (var4 != null) {
            var3 = var4.hashCode();
        }

        return (var1 * 31 + var2) * 31 + var3;
    }

    public final void setToken(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.token = var1;
    }

    public final void setUserId(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.userId = var1;
    }

    public final void setVerifyAuthToken(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.verifyAuthToken = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("PinDuoDuoLoginResponseResultBean(token=");
        var1.append(this.token);
        var1.append(", userId=");
        var1.append(this.userId);
        var1.append(", verifyAuthToken=");
        var1.append(this.verifyAuthToken);
        var1.append(")");
        return var1.toString();
    }

    /**
     * PinDuoDuoLoginResponseResultBean {
     *     private String token;
     *     private String userId;
     *     private String verifyAuthToken;
     * @param jsonStr
     * @return
     */
    public static PinDuoDuoLoginResponseResultBean parsetJsonString(String jsonStr){
        if (jsonStr.trim().startsWith("{") && jsonStr.trim().endsWith("}")){
            PinDuoDuoLoginResponseResultBean pddRRB = null;
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                String verifyAuthToken = "";
                String token = "";
                String userId = "";

                if (jsonObject.has("verifyAuthToken"))
                    verifyAuthToken = jsonObject.getString("verifyAuthToken");
                if (jsonObject.has("token"))
                    token = jsonObject.getString("token");
                if (jsonObject.has("userId"))
                    userId = jsonObject.getString("userId");
                pddRRB = new PinDuoDuoLoginResponseResultBean(
                        token,
                        userId,
                        verifyAuthToken);
                return pddRRB;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        Log.i(LoginActivity.TAG,"parse fail ,jsonstr="+jsonStr);

        return null;
    }
}
