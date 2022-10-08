package com.rq.net.util;

import javax.crypto.spec.*;
import java.io.*;
import java.security.spec.*;
import java.security.*;
import javax.crypto.*;
import android.util.*;

public class DESedeUtil
{
    public static String decrypt3DES(String s, final String s2) {
        try {
            final SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(s2.getBytes()));
            final Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            instance.init(2, generateSecret);
            s = new String(instance.doFinal(new Base64().decode(s.getBytes())), "utf-8");
            return s;
        }
        catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        catch (IllegalBlockSizeException ex2) {
            ex2.printStackTrace();
        }
        catch (BadPaddingException ex3) {
            ex3.printStackTrace();
        }
        catch (InvalidKeySpecException ex4) {
            ex4.printStackTrace();
        }
        catch (NoSuchPaddingException ex5) {
            ex5.printStackTrace();
        }
        catch (NoSuchAlgorithmException ex6) {
            ex6.printStackTrace();
        }
        catch (InvalidKeyException ex7) {
            ex7.printStackTrace();
        }
        return "";
    }
    
    public static String encrypt3DES(final String s, final String s2) {
        String s3;
        try {
            final SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(s2.getBytes()));
            final Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            instance.init(1, generateSecret);
            s3 = new String(new Base64().encode(instance.doFinal(s.getBytes())));
            try {
                Log.d("3DES", s);
                Log.d("3DES", s2);
                Log.d("3DES", s3);
                return s3;
            }catch (Exception e){}
        }
        catch (IllegalBlockSizeException ex2) {
            s3 = "";
        }
        catch (BadPaddingException ex3) {
            s3 = "";
        }
        catch (InvalidKeySpecException ex4) {
            s3 = "";
        }
        catch (NoSuchPaddingException ex5) {
            s3 = "";
        }
        catch (NoSuchAlgorithmException ex6) {
            s3 = "";
        }
        catch (InvalidKeyException ex) {
            s3 = "";
        }
        return s3;
    }
}
