package com.rq.net.bean;


import android.util.Log;

import com.rq.net.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class PinDuoDuoBaseResponseBean {
    private int errorCode;
    private String errorMsg;
    private int error_code;
    private String error_msg;
    private Object result;
    private boolean success;

    public PinDuoDuoBaseResponseBean(int var1, int var2, String var3, String var4, Object var5, boolean var6) {
        super();
        init(var1, var2, var3, var4, var5, var6);
    }

    // $FF: synthetic method
    public PinDuoDuoBaseResponseBean(int var1, int var2, String var3, String var4, Object var5, boolean var6, int var7) {
        if ((var7 & 4) != 0) {
            var3 = "";
        }

        if ((var7 & 8) != 0) {
            var4 = "";
        }

        if ((var7 & 32) != 0) {
            var6 = false;
        }
        init(var1, var2, var3, var4, var5, var6);
    }

    private void init(int var1, int var2, String var3, String var4, Object var5, boolean var6) {
        this.errorCode = var1;
        this.error_code = var2;
        this.errorMsg = var3;
        this.error_msg = var4;
        this.result = var5;
        this.success = var6;
    }

    // $FF: synthetic method
    public static PinDuoDuoBaseResponseBean copy$default(PinDuoDuoBaseResponseBean var0, int var1, int var2, String var3, String var4, Object var5, boolean var6, int var7, Object var8) {
        if ((var7 & 1) != 0) {
            var1 = var0.errorCode;
        }

        if ((var7 & 2) != 0) {
            var2 = var0.error_code;
        }

        if ((var7 & 4) != 0) {
            var3 = var0.errorMsg;
        }

        if ((var7 & 8) != 0) {
            var4 = var0.error_msg;
        }

        if ((var7 & 16) != 0) {
            var5 = var0.result;
        }

        if ((var7 & 32) != 0) {
            var6 = var0.success;
        }

        return var0.copy(var1, var2, var3, var4, var5, var6);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final int component2() {
        return this.error_code;
    }

    public final String component3() {
        return this.errorMsg;
    }

    public final String component4() {
        return this.error_msg;
    }

    public final Object component5() {
        return this.result;
    }

    public final boolean component6() {
        return this.success;
    }

    public final PinDuoDuoBaseResponseBean copy(int var1, int var2, String var3, String var4, Object var5, boolean var6) {
        ////Intrinsics.checkParameterIsNotNull(var3, "errorMsg");
        ////Intrinsics.checkParameterIsNotNull(var4, "error_msg");
        return new PinDuoDuoBaseResponseBean(var1, var2, var3, var4, var5, var6);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (!(var1 instanceof PinDuoDuoBaseResponseBean)) {
                return false;
            }

            PinDuoDuoBaseResponseBean var2 = (PinDuoDuoBaseResponseBean) var1;
            if (this.errorCode != var2.errorCode || this.error_code != var2.error_code || !this.errorMsg.equals(var2.errorMsg) || !this.error_msg.equals(var2.error_msg) || !this.result.equals(var2.result) || this.success != var2.success) {
                return false;
            }
        }

        return true;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final int getError_code() {
        return this.error_code;
    }

    public final String getError_msg() {
        return this.error_msg;
    }

    public final Object getResult() {
        return this.result;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public final void setErrorCode(int var1) {
        this.errorCode = var1;
    }

    public final void setErrorMsg(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.errorMsg = var1;
    }

    public final void setError_code(int var1) {
        this.error_code = var1;
    }

    public final void setError_msg(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.error_msg = var1;
    }

    public final void setResult(Object var1) {
        this.result = var1;
    }

    public final void setSuccess(boolean var1) {
        this.success = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("PinDuoDuoBaseResponseBean(errorCode=");
        var1.append(this.errorCode);
        var1.append(", error_code=");
        var1.append(this.error_code);
        var1.append(", errorMsg=");
        var1.append(this.errorMsg);
        var1.append(", error_msg=");
        var1.append(this.error_msg);
        var1.append(", result=");
        var1.append(this.result);
        var1.append(", success=");
        var1.append(this.success);
        var1.append(")");
        return var1.toString();
    }


    public static PinDuoDuoBaseResponseBean parsetJsonString(String jsonStr){
        if (jsonStr.trim().startsWith("{") && jsonStr.trim().endsWith("}")){
            PinDuoDuoBaseResponseBean pddBRB = null;
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                int errorCode = 0;
                String errorMsg = "";
                String result = "";
                boolean success = false;
                if (jsonObject.has("errorCode"))
                    errorCode = jsonObject.getInt("errorCode");
                if (jsonObject.has("error_code"))
                    errorCode = jsonObject.getInt("error_code");

                if (jsonObject.has("errorMsg"))
                    errorMsg = jsonObject.getString("errorMsg");
                if (jsonObject.has("error_msg"))
                    errorMsg = jsonObject.getString("error_msg");

                if (jsonObject.has("result"))
                    result = jsonObject.getString("result");
                if (jsonObject.has("success"))
                    success = jsonObject.getBoolean("success");


                pddBRB = new PinDuoDuoBaseResponseBean(errorCode,
                        errorCode,
                        errorMsg,
                        errorMsg,
                        result,
                        success);
                return pddBRB;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        Log.i(LoginActivity.TAG,"parse fail ,jsonstr="+jsonStr);

        return null;
    }
}