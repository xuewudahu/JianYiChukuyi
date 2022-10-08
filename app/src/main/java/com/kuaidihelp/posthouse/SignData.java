package com.kuaidihelp.posthouse;


import android.util.Log;

import com.kuaibao.sign.Signer;

public class SignData {
    private static final String TAG = "SignData";

    public SignData() {
    }

    public static String getNativeSign(String var0, String var1, String var2, String var3, String var4) {
        StringBuilder var5 = new StringBuilder();
        var5.append(var0);
        var5.append(var1);
        var5.append(var2);
        var5.append(var3);
        var5.append(var4);
        return Signer.sign2(var0, var1, var2, var3, var4, var5.toString().length());
    }

    public static String getSign() {
        String var0 = Signer.sign2("1588909160814", "/v1/push", "10014", "0b9d1b9fe9f9b21fe71cd433724c5ba0", "3910", 56);
        StringBuilder var1 = new StringBuilder();
        var1.append("getSign: ");
        var1.append(var0);
        Log.e("SignData", var1.toString());
        return var1.toString();
    }
}
