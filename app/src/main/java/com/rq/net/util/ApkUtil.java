package com.rq.net.util;

import java.util.*;

import com.rq.net.MyApplication;
import android.content.pm.*;
import android.os.*;
import android.content.*;
import java.io.*;
import android.net.*;

public final class ApkUtil
{
    private ApkUtil() {
    }
    
    public static boolean checkAppInstalled(final Context context, final String s) {
        if (s != null) {
            if (s.isEmpty()) {
                return false;
            }
            final List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
            if (installedPackages != null) {
                if (installedPackages.isEmpty()) {
                    return false;
                }
                for (int i = 0; i < installedPackages.size(); ++i) {
                    if (s.equals(installedPackages.get(i).packageName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static int getVersionCode() {
        try {
            return MyApplication.baseApp.getPackageManager().getPackageInfo(MyApplication.baseApp.getPackageName(), 0).versionCode;
        }
        catch (PackageManager.NameNotFoundException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
    
    public static String getVersionName() {
        try {
            return MyApplication.baseApp.getPackageManager().getPackageInfo(MyApplication.baseApp.getPackageName(), 0).versionName;
        }
        catch (PackageManager.NameNotFoundException ex) {
            ex.printStackTrace();
            return "";
        }
    }
    
    public static void installApk(final Context context, final String s) {
        if (SystemUtil.getSystemModel().contains("JoyFinder")) {
            final StringBuilder sb = new StringBuilder();
            sb.append("pm install -r ");
            sb.append(s);
            RootShellCmdUtil.setInstallApk(sb.toString());
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        }
        final Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.fromFile(new File(s)), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }
    
    public static boolean isNetworkAvailable() {
        final NetworkInfo[] allNetworkInfo = ((ConnectivityManager)MyApplication.baseApp.getSystemService(Context.CONNECTIVITY_SERVICE)).getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (int i = 0; i < allNetworkInfo.length; ++i) {
                if (allNetworkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }
}
