package com.kuaibao.sign;


public class Signer {
    static {
        System.loadLibrary("SignLib");
    }

    public Signer() {
    }
    public static native String sign(String var0, String var1, String var2, String var3, String var4, int var5);
    public static native String sign2(String var0, String var1, String var2, String var3, String var4, int var5);
}

