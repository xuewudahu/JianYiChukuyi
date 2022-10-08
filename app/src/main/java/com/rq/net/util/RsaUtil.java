package com.rq.net.util;

import java.security.interfaces.*;
import javax.crypto.*;

import android.os.Build;
import android.util.*;

import androidx.annotation.RequiresApi;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.DecoderException;

import java.security.*;
import java.security.spec.*;

public class RsaUtil
{
    public static byte[] decrypt(final RSAPrivateKey rsaPrivateKey, final byte[] array) throws Exception {
        if (rsaPrivateKey == null) {
            //goto Label_0071;
            return null;
        }
        while (true) {
            while (true) {
                try {
                    final Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    instance.init(2, rsaPrivateKey);
                    return instance.doFinal(array);
                    //throw new Exception("\u5bc6\u6587\u6570\u636e\u5df2\u635f\u574f");
                }
                catch (NoSuchPaddingException ex) {
                    ex.printStackTrace();
                    return null;
                }
                catch (NoSuchAlgorithmException ex2) {}
                catch (InvalidKeyException ex3) {}
                catch (IllegalBlockSizeException ex4) {}
                catch (BadPaddingException ex5) {}
                continue;
            }
        }
    }
    
    public static byte[] decryptByPublicKey(final String s, final byte[] array) {
        try {
            final PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(new Base64().decode(s.getBytes())));
            final Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, generatePublic);
            return instance.doFinal(array);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static byte[] decryptByRSA1(final String s, final byte[] array) {
        try {
            final PublicKey keyStrToPublicKey = keyStrToPublicKey(s);
            final Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, keyStrToPublicKey);
            return instance.doFinal(array);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static byte[] encrypt(final PrivateKey privateKey, final byte[] array) throws Exception {
        if (privateKey == null) {
            //goto Label_0071;
            return null;
        }
        while (true) {
            while (true) {
                try {
                    final Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    instance.init(1, privateKey);
                    return instance.doFinal(array);
                    //throw new Exception("\u660e\u6587\u6570\u636e\u5df2\u635f\u574f");
                }
                catch (NoSuchPaddingException ex) {
                    ex.printStackTrace();
                    return null;
                }
                catch (NoSuchAlgorithmException ex2) {}
                catch (InvalidKeyException ex3) {}
                catch (IllegalBlockSizeException ex4) {}
                catch (BadPaddingException ex5) {}
                continue;
            }
        }
    }
    
    public static byte[] encrypt(final PublicKey publicKey, final byte[] array) throws Exception {
        if (publicKey == null) {
            //goto Label_0071;
            return null;
        }
        try {
            final Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, publicKey);
            return instance.doFinal(array);
            //throw new Exception("\u660e\u6587\u6570\u636e\u5df2\u635f\u574f");
        }
        catch (NoSuchPaddingException ex) {
            ex.printStackTrace();
            return null;
        }
        catch (NoSuchAlgorithmException ex2) {}
        catch (InvalidKeyException ex3) {}
        catch (IllegalBlockSizeException ex4) {}
        catch (BadPaddingException ex5) {}
        return null;
    }
    
    public static String encryptDataByPrivateKey(String encodeToString, final byte[] array) {
        try {
            final PrivateKey keyStrToPrivate = keyStrToPrivate(encodeToString);
            if (keyStrToPrivate != null) {
                encodeToString = new String(encrypt(keyStrToPrivate, array), 0);
                return encodeToString;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String encryptDataByPublicKey(String encodeToString, final byte[] array) {
        try {
            final PublicKey keyStrToPublicKey = keyStrToPublicKey(encodeToString);
            if (keyStrToPublicKey != null) {
                encodeToString = java.util.Base64.getEncoder().encodeToString(encrypt(keyStrToPublicKey, array));
                return encodeToString;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static PrivateKey keyStrToPrivate(final String s) {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(new Base64().decode(s.getBytes()));
        try {
            return KeyFactory.getInstance("RSA").generatePrivate(x509EncodedKeySpec);
        }
        catch (InvalidKeySpecException ex) {
            ex.printStackTrace();
        }
        catch (NoSuchAlgorithmException ex2) {
            ex2.printStackTrace();
        }
        return null;
    }
    
    public static PublicKey keyStrToPublicKey(final String s) {
        final X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(new Base64().decode(s.getBytes()));
        try {
            return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
        }
        catch (InvalidKeySpecException ex) {
            ex.printStackTrace();
        }
        catch (NoSuchAlgorithmException ex2) {
            ex2.printStackTrace();
        }
        return null;
    }
}
