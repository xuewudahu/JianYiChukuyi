package com.rq.net.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

import com.rq.net.MyApplication;

public final class NetWorkUtil {
    public NetWorkUtil() {
    }

    public static boolean isNetworkAvailable() {
        NetworkInfo[] var1 = ((ConnectivityManager) MyApplication.baseApp.getSystemService(Context.CONNECTIVITY_SERVICE)).getAllNetworkInfo();
        if (var1 != null) {
            for(int var0 = 0; var0 < var1.length; ++var0) {
                if (var1[var0].getState() == State.CONNECTED) {
                    return true;
                }
            }
        }

        return false;
    }
}
