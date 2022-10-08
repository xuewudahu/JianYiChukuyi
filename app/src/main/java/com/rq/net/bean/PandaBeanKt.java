package com.rq.net.bean;

import android.bluetooth.*;
//import kotlin.jvm.internal.*;
import java.lang.reflect.*;
//import com.kuaidihelp.posthouse.activity.*;
import java.nio.charset.*;
//import com.kuaidihelp.posthouse.util.*;
import java.io.*;

import com.rq.net.manager.OkhttpManager;
import com.rq.net.request.*;
import com.rq.net.util.Md5InputStream;

import java.util.*;
//import kotlin.*;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\u001a&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001¨\u0006\t" }, d2 = { "getBluetoothAddress", "", "upPic", "", "parcelId", "", "outTime", "barcode", "token", "app_CoBaAIRelease" }, k = 2, mv = { 1, 1, 16 })
public final class PandaBeanKt
{
    public static final String getBluetoothAddress() {
        final String s = null;
        try {
            final BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            final Field declaredField = defaultAdapter.getClass().getDeclaredField("mService");
            defaultAdapter.enable();
            //Intrinsics.checkExpressionValueIsNotNull(declaredField, "field");
            declaredField.setAccessible(true);
            final Object value = declaredField.get(defaultAdapter);
            String s2 = s;
            if (value != null) {
                final Object invoke = value.getClass().getMethod("getAddress", (Class<?>[])new Class[0]).invoke(value, new Object[0]);
                s2 = s;
                if (invoke != null) {
                    s2 = s;
                    if (invoke instanceof String) {
                        s2 = (String)invoke;
                    }
                }
            }
            return s2;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static final void upPic(final int n, String string, final String s, final String s2) {
        //Intrinsics.checkParameterIsNotNull(string, "outTime");
        //Intrinsics.checkParameterIsNotNull(s, "barcode");
        //Intrinsics.checkParameterIsNotNull(s2, "token");
        final long currentTimeMillis = System.currentTimeMillis();
        final StringBuilder sb = new StringBuilder();
        sb.append("{parcelId:");
        sb.append(n);
        sb.append(",arriveTime:");
        sb.append(string);
        sb.append('}');
        string = sb.toString();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(string);
        sb2.append("YP75838571"/*ApiPandaHarvestActvity.Companion.getAccountName()*/);
        sb2.append("UPLOAD_PARCEL_PIC");
        sb2.append(s2);
        sb2.append(currentTimeMillis);
        sb2.append("yRLgecjAxVi9gLXx"/*ApiPandaHarvestActvity.Companion.getAccountPassword()*/);
        final String string2 = sb2.toString();
        final Charset forName = Charset.forName("utf-8");
        //Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(charsetName)");
        if (string2 != null) {
            final byte[] bytes = string2.getBytes(forName);
            //Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            final String md5 = Md5InputStream.md5(new ByteArrayInputStream(bytes));
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("bizData", string);
            hashMap.put("timestamp", String.valueOf(currentTimeMillis));
            hashMap.put("accountName", "YP75838571"/*ApiPandaHarvestActvity.Companion.getAccountName()*/);
            hashMap.put("apiName", "UPLOAD_PARCEL_PIC");
            hashMap.put("token", s2);
            //Intrinsics.checkExpressionValueIsNotNull(md5, "md5Str");
            hashMap.put("sign", md5);
            hashMap.put("barcode", s);
            OkhttpManager.pandaHarvestUpPic(hashMap);
            return;
        }
        //throw new Exception("null cannot be cast to non-null type java.lang.String");
    }
}
