package com.rq.net.bean;

import java.io.ByteArrayOutputStream;
import java.util.*;
//import com.yunpan.common.utils.*;
import android.text.TextUtils;
import android.util.*;
import android.util.Base64;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.StringUtils;
import com.rq.net.util.Base64Util;

import javax.crypto.*;
import java.security.spec.*;
import java.security.*;

public class YXDUtil
{
    public static final String ECB_PKCS1_PADDING = "RSA/ECB/PKCS1Padding";
    public static final String RSA = "RSA";
    public static String clientId = "e_ant_android";//""caixun_aio";
    public static String clientSecret = "VMnINXNTHW9ij3Il";//h4o81dviFuHNrDm5";//""VEvULSFvB70tpM2N";



    public static String buildArgs(final SortedMap<String, String> sortedMap, final String s) {
        final Iterator<Map.Entry<String, String>> iterator = sortedMap.entrySet().iterator();
        final ArrayList<String> list = new ArrayList<String>();
        while (iterator.hasNext()) {
            final Map.Entry<String, String> entry = iterator.next();
            final String value = String.valueOf(entry.getKey());
            final String value2 = String.valueOf(entry.getValue());
            if (TextUtils.isEmpty((CharSequence)value2) && entry.getValue() != null && !"sign".equals(value) && !"key".equals(value)) {
                final StringBuilder sb = new StringBuilder();
                sb.append(value);
                sb.append("=");
                sb.append(value2);
                list.add(sb.toString());
            }
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("key=");
        sb2.append(s);
        list.add(sb2.toString());

        return TextUtils.join("&",(Iterable)list);
    }
    
    public static String generateLoginAuthorization() {
        final StringBuilder sb = new StringBuilder();
        sb.append(YXDUtil.clientId);
        sb.append(":");
        sb.append("h4o81dviFuHNrDm5"/*YXDUtil.clientSecret*/);//modified by lzp for yshoufa new interface
        return Base64Util.getBaseString(sb.toString().getBytes());
    }
    
    public static String publicKeyEncrypt(String encodeToString) {
        try {
            final PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDJUGaA5s85nEsiQxuksyZpwJkWRzg8oKIfwxSkzcYhWZbPeY06GW2WHdmXoFjC2CWKTPJXXyb0kqMgvuUtjeVV4MDsl/8i0XXO0Q1JNrhK8io5E+ivsPgey0uTtq98ITVn9Sk0HwNVNs06Vr6gV7CjwdVtOjefEHxprkItOq6K9QIDAQAB".getBytes(), 0)));
            final Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(Cipher.ENCRYPT_MODE, generatePublic);
            encodeToString = Base64.encodeToString(instance.doFinal(((String)encodeToString).getBytes()), 0);
            return (String)encodeToString;
        }
        catch (IllegalBlockSizeException e1) {}
        catch (BadPaddingException e2) {}
        catch (InvalidKeyException e3) {}
        catch (NoSuchPaddingException e4) {}
        catch (InvalidKeySpecException e5) {}
        catch (NoSuchAlgorithmException ex) {}
        //((Throwable)encodeToString).printStackTrace();
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDJUGaA5s85nEsiQxuksyZpwJkWRzg8oKIfwxSkzcYhWZbPeY06GW2WHdmXoFjC2CWKTPJXXyb0kqMgvuUtjeVV4MDsl/8i0XXO0Q1JNrhK8io5E+ivsPgey0uTtq98ITVn9Sk0HwNVNs06Vr6gV7CjwdVtOjefEHxprkItOq6K9QIDAQAB";
    }

    /**Begin:added by lzp for new yshoufa interface **/
    public static String generateFinalKey(String var0, PublicKey var1) throws Exception {
        Cipher var2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        var2.init(1, var1);
        int var3 = var0.getBytes().length;
        ByteArrayOutputStream var4 = new ByteArrayOutputStream();
        int var5 = 0;
        int var6 = 0;

        while(true) {
            int var7 = var3 - var5;
            if (var7 <= 0) {
                byte[] var8 = var4.toByteArray();
                var4.close();
                return new String(Base64.encode(var8, 2));
            }

            byte[] var9;
            if (var7 > 117) {
                var9 = var2.doFinal(var0.getBytes(), var5, 117);
            } else {
                var9 = var2.doFinal(var0.getBytes(), var5, var7);
            }

            var4.write(var9, 0, var9.length);
            ++var6;
            var5 = var6 * 117;
        }
    }

    public static PublicKey generatePublicKey(String var0) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(var0, 0)));
    }
    public static String getFinalSecurityPwd(String var0) {
        try {
            var0 = generateFinalKey(var0, generatePublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDJUGaA5s85nEsiQxuksyZpwJkWRzg8oKIfwxSkzcYhWZbPeY06GW2WHdmXoFjC2CWKTPJXXyb0kqMgvuUtjeVV4MDsl/8i0XXO0Q1JNrhK8io5E+ivsPgey0uTtq98ITVn9Sk0HwNVNs06Vr6gV7CjwdVtOjefEHxprkItOq6K9QIDAQAB"));
            return var0;
        } catch (Exception var1) {
            var1.printStackTrace();
            return "";
        }
    }
    public static String publicKeyEncryptN(String encodeToString) {
        return String.format("{encrypt}%s", getFinalSecurityPwd(encodeToString));
    }

    public static String buildArgsN(SortedMap<String, String> var0, String var1) {
        if (!TextUtils.isEmpty(var1)) {
            Iterator var2 = var0.entrySet().iterator();
            ArrayList var7 = new ArrayList();

            while(var2.hasNext()) {
                Map.Entry var3 = (Map.Entry)var2.next();
                String var4 = String.valueOf(var3.getKey());
                String var5 = String.valueOf(var3.getValue());
                if (!TextUtils.isEmpty(var5) && var3.getValue() != null && !"sign".equals(var4) && !"key".equals(var4)) {
                    StringBuilder var8 = new StringBuilder();
                    var8.append(var4);
                    var8.append("=");
                    var8.append(var5);
                    var7.add(var8.toString());
                }
            }

            StringBuilder var9 = new StringBuilder();
            var9.append("key=");
            var9.append(var1);
            var7.add(var9.toString());
            Log.i("test","b="+TextUtils.join("&",var7));
            return md5(TextUtils.join("&",var7));
        } else {
            RuntimeException var6 = new RuntimeException("签名key不能为空");
            throw var6;
        }
    }


    public static String toHexString(byte[] var0) {
        StringBuffer var1 = new StringBuffer();

        for(int var2 = 0; var2 < var0.length; ++var2) {
            var1.append("0123456789abcdef".charAt(var0[var2] >>> 4 & 15));
            var1.append("0123456789abcdef".charAt(var0[var2] & 15));
        }

        return var1.toString();
    }

    public static String md5(String var0) {
        try {
            var0 = toHexString(MessageDigest.getInstance("MD5").digest(var0.getBytes("utf-8")));
            return var0;
        } catch (Exception var1) {
            throw new RuntimeException(var1);
        }
    }
    /**End**/
}
