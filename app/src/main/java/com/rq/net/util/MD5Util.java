package com.rq.net.util;

import android.text.TextUtils;
import android.util.Log;

import java.security.*;
import java.lang.reflect.*;
import java.io.*;

public class MD5Util
{
    public static String MD5SLAT = "*Yp**88210970***";
    private static final String TAG = "MD5Util";
    public static String decodeMd5(String hascode) {
        StringBuffer sb = new StringBuffer();
        if (hascode.length() != 32) {
            Log.i(TAG,"decodeMd5: fail,length not 32");
            return "";
        }
        for (int i = 0;i < hascode.length();i += 2){
            char c = (char)Integer.parseInt(hascode.substring(i,i+2));
            sb.append(c);
        }
        return sb.toString();
    }
    public static String encodeMd5(String upperCase) {
        int n = 0;
        final StringBuilder sb = new StringBuilder();
        byte[] digest = null;
        try {
            digest = MessageDigest.getInstance("MD5").digest(upperCase.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        while (true) {
            final int length = digest.length;
            Log.i(TAG,"encodeMd5: length="+length+" n ="+n);
            if (n >= length) {
                upperCase = sb.toString().toUpperCase();
                return upperCase;
            }
            final String hexString = Integer.toHexString(digest[n] & 0xFF);
            if (hexString.length() == 1) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("0");
                sb2.append(hexString);
                sb.append(sb2.toString());
            }
            else {
                sb.append(hexString);
            }
            ++n;
        }
    }
    
    public static String encodeMd5(String lowerCase, final String s) {
        int n = 0;
        final StringBuilder sb2 = new StringBuilder();
        MessageDigest instance = null;
        try {
            instance = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(lowerCase);
        final byte[] digest = instance.digest(sb.toString().getBytes());
        while (true) {
            if (n >= digest.length) {
                lowerCase = sb2.toString().toLowerCase();
                return lowerCase;
            }
            final String hexString = Integer.toHexString(digest[n] & 0xFF);
            if (hexString.length() == 1) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("0");
                sb3.append(hexString);
                sb2.append(sb3.toString());
            }
            else {
                sb2.append(hexString);
            }
            ++n;
        }
    }
    
    public static byte[] encodeMd5ToByte(final String s) {
        MessageDigest instance;
        try {
            instance = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            instance = null;
        }
        return instance.digest(s.getBytes());
    }
    
    public static String getEncryptMD5Class(final Class clazz, final long n) {
        final Field[] declaredFields = clazz.getDeclaredFields();
        String s = "";
        String string;
        for (int i = 0; i < declaredFields.length; ++i, s = string) {
            string = s;
            if (!declaredFields[i].getName().equals("sign")) {
                final StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append(declaredFields[i].getName());
                string = sb.toString();
            }
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s);
        sb2.append(n);
        final String string2 = sb2.toString();
        final StringBuilder sb3 = new StringBuilder();
        sb3.append(MD5Util.MD5SLAT);
        sb3.append(n);
        return encodeMd5(string2, sb3.toString());
    }
    
    public static String getEncryptMD5Class(final Class clazz, final long n, final String s) {
        final Field[] declaredFields = clazz.getDeclaredFields();
        String s2 = "";
        String string;
        for (int i = 0; i < declaredFields.length; ++i, s2 = string) {
            string = s2;
            if (!declaredFields[i].getName().equals("sign")) {
                final StringBuilder sb = new StringBuilder();
                sb.append(s2);
                sb.append(declaredFields[i].getName());
                string = sb.toString();
            }
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s2);
        sb2.append(n);
        final String string2 = sb2.toString();
        final StringBuilder sb3 = new StringBuilder();
        sb3.append(MD5Util.MD5SLAT);
        sb3.append(s);
        return encodeMd5(string2, sb3.toString());
    }
    
    public static String getEncryptMD5ClassToTimestamp(final Class clazz, final long n) {
        final Field[] declaredFields = clazz.getDeclaredFields();
        int i = 0;
        String s = "";
        while (i < declaredFields.length) {
            String string = s;
            if (!declaredFields[i].getName().equals("sign")) {
                final StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append(declaredFields[i].getName());
                string = sb.toString();
            }
            ++i;
            s = string;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(n);
        return encodeMd5(s, sb2.toString());
    }
    
    public static String getMD5Str(String string) {
        int n = 0;
        try {
            final MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(string.getBytes("UTF-8"));
            final byte[] digest = instance.digest();
            final StringBuffer sb = new StringBuffer();
            while (true) {
                if (n >= digest.length) {
                    string = sb.toString();
                    return string;
                }
                if (Integer.toHexString(digest[n] & 0xFF).length() == 1) {
                    sb.append("0");
                    sb.append(Integer.toHexString(digest[n] & 0xFF));
                } else {
                    sb.append(Integer.toHexString(digest[n] & 0xFF));
                }
                ++n;
            }
        }
        catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        catch (NoSuchAlgorithmException ex2) {}
        return null;
    }

    public static String md5(String string){
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result.append(temp);
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static byte[] getMd5byte(final String s) {
        return encodeMd5(s, "").getBytes();
    }
}
