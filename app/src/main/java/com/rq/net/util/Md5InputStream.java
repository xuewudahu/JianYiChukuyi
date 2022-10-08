package com.rq.net.util;

import java.security.*;
import java.io.*;

public class Md5InputStream
{
    private static final char[] hexDigits;
    
    static {
        hexDigits = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    }
    
    private static String byteArrayToHex(final byte[] array) {
        final char[] array2 = new char[array.length * 2];
        final int length = array.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final byte b = array[i];
            final int n2 = n + 1;
            final char[] hexDigits = Md5InputStream.hexDigits;
            array2[n] = hexDigits[b >>> 4 & 0xF];
            n = n2 + 1;
            array2[n2] = hexDigits[b & 0xF];
            ++i;
        }
        return new String(array2);
    }
    
    public static String md5(final File file) {
        try {
            if (!file.isFile()) {
                final PrintStream err = System.err;
                final StringBuilder sb = new StringBuilder();
                sb.append("\u6587\u4ef6");
                sb.append(file.getAbsolutePath());
                sb.append("\u4e0d\u5b58\u5728\u6216\u8005\u4e0d\u662f\u6587\u4ef6");
                err.println(sb.toString());
                return null;
            }
            final FileInputStream fileInputStream = new FileInputStream(file);
            final String md5 = md5(fileInputStream);
            fileInputStream.close();
            return md5;
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static String md5(final InputStream inputStream) {
        try {
            final MessageDigest instance = MessageDigest.getInstance("MD5");
            final byte[] array = new byte[1024];
            while (true) {
                final int read = inputStream.read(array);
                if (read == -1) {
                    break;
                }
                instance.update(array, 0, read);
            }
            inputStream.close();
            return byteArrayToHex(instance.digest());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex3) {
            ex3.printStackTrace();
        }
        return null;
    }
    
    public static String md5(String byteArrayToHex) {
        if (byteArrayToHex == null) {
            return null;
        }
        try {
            final MessageDigest instance = MessageDigest.getInstance("MD5");
            final byte[] array = new byte[0];
            byte[] bytes;
            try {
                bytes = byteArrayToHex.getBytes("utf-8");
            }
            catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
                bytes = array;
            }
            instance.update(bytes);
            byteArrayToHex = byteArrayToHex(instance.digest());
            return byteArrayToHex;
        }
        catch (NoSuchAlgorithmException ex2) {
            return null;
        }
    }
}
