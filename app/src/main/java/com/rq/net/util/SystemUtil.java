package com.rq.net.util;

import android.content.*;
import android.telephony.*;
import android.provider.*;
import android.util.*;
import android.os.*;
import java.net.*;
import android.net.wifi.*;
import android.net.*;
import java.util.*;

public class SystemUtil
{
    private static final String TAG = "SystemUtil";
    
    public static String getAppUUID(final Context context) {
        final TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        //sb.append(telephonyManager.getDeviceId());
        sb.append(Settings.Secure.getString(context.getContentResolver(), "android_id"));
        final String string = sb.toString();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        //sb2.append(telephonyManager.getSimSerialNumber());
        final String string2 = sb2.toString();
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("");
        sb3.append(Settings.Secure.getString(context.getContentResolver(), "android_id"));
        final String string3 = new UUID(sb3.toString().hashCode(), (long)string2.hashCode() | (long)string.hashCode() << 32).toString();
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("uuid=");
        sb4.append(string3);
        Log.d("debug", sb4.toString());
        return string3;
    }
    
    public static String getDeviceBrand() {
        return Build.BRAND;
    }
    
    public static long getFreeDiskSpace() {
        final StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
        if (Build.VERSION.SDK_INT >= 18) {
            return statFs.getAvailableBytes() / 1048576L;
        }
        return -1L;
    }
    
    public static String getIMEI(final Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }
    
    public static String getIPAddress(final Context context) {
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 0) {
                try {
                    Log.e("SystemUtil", "getIPAddress: TYPE_MOBILE");
                    final Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    while (networkInterfaces.hasMoreElements()) {
                        final Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            final InetAddress inetAddress = inetAddresses.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                    return getLocalIp();
                }
                catch (SocketException ex) {
                    ex.printStackTrace();
                    return getLocalIp();
                }
            }
            if (activeNetworkInfo.getType() == 1) {
                Log.e("SystemUtil", "getIPAddress: TYPE_WIFI");
                return intIP2StringIP(((WifiManager)context.getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getIpAddress());
            }
        }
        return getLocalIp();
    }
    
    private static String getLocalIp() {
        Log.e("SystemUtil", "getIPAddress: localip");
        try {
            final Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress inetAddress = null;
            Block_7: {
                while (networkInterfaces.hasMoreElements()) {
                    final NetworkInterface networkInterface = networkInterfaces.nextElement();
                    final String displayName = networkInterface.getDisplayName();
                    final StringBuilder sb = new StringBuilder();
                    sb.append("\u7f51\u7edc\u540d\u5b57");
                    sb.append(displayName);
                    Log.e("SystemUtil", sb.toString());
                    if (displayName.equals("eth0") || displayName.equals("br0")) {
                        final Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            inetAddress = inetAddresses.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                break Block_7;
                            }
                        }
                    }
                }
                return "";
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(inetAddress.getHostAddress());
            sb2.append("   ");
            Log.i("SystemUtil", sb2.toString());
            return inetAddress.getHostAddress();
        }
        catch (SocketException ex) {
            ex.printStackTrace();
        }
        return "";
    }
    
    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }
    
    public static Locale[] getSystemLanguageList() {
        return Locale.getAvailableLocales();
    }
    
    public static String getSystemModel() {
        return Build.MODEL;
    }
    
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }
    
    public static String intIP2StringIP(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(n & 0xFF);
        sb.append(".");
        sb.append(n >> 8 & 0xFF);
        sb.append(".");
        sb.append(n >> 16 & 0xFF);
        sb.append(".");
        sb.append(n >> 24 & 0xFF);
        return sb.toString();
    }
}
