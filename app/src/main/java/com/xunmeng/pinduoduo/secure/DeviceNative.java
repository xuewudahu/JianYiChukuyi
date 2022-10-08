package com.xunmeng.pinduoduo.secure;

import android.content.Context;
import android.util.Log;

public class DeviceNative {
    private static final String TAG = "DeviceNative";

    static {
        System.loadLibrary("c++_shared");
        System.loadLibrary("pdd_secure");
        System.loadLibrary("UserEnv");
    }

    public DeviceNative() {
    }

    public static String getSecure(Context var0) {
        synchronized(DeviceNative.class){}

        String var4;
        try {
            var4 = info2(var0, System.currentTimeMillis());
            StringBuilder var1 = new StringBuilder();
            var1.append("getSecure: ");
            var1.append(var4);
            Log.e("DeviceNative", var1.toString());
        } finally {

        }

        return var4;
    }

    public static native String info2(Context var0, long var1);
}
