package com.rq.net.bean;

import static okhttp3.internal.Util.UTF_8;


import android.util.Log;

import com.rq.net.util.Base64;

import java.nio.charset.*;
import java.security.*;

public class MiaoZhans
{
    public static String doSign(String s, final String s2) {
        while (true) {
            if (s2 != null) {
                final StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append(s2);
                s = sb.toString();
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("doSign: ========================");
                sb2.append(s);
                Log.d("TAG", sb2.toString());
                try {
                    s = Base64.encodeBase64String(MessageDigest.getInstance("MD5").digest(s.getBytes(UTF_8)));
                    return s;
                }
                catch (NoSuchAlgorithmException ex) {}
                return "";
            }
            continue;
        }
    }
}
