package com.rq.net.util;

//import kotlin.*;
//import kotlin.jvm.internal.*;
import android.util.*;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.DecoderException;

import java.security.spec.*;
import java.sql.*;
import java.security.*;

public final class Rsa2Util
{
    public final String rsaDecryptByPublicKey(String decryptByPublicKey, final String s) {
        PublicKey generatePublic = null;
        try {
            generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(new Base64().decode(s.getBytes())));
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        final RSACrypt instance = RSACrypt.INSTANCE;
        decryptByPublicKey = instance.decryptByPublicKey(decryptByPublicKey, generatePublic);
        final StringBuilder sb = new StringBuilder();
        sb.append(decryptByPublicKey);
        sb.append("           ");
        sb.append(decryptByPublicKey.length());
        DriverManager.println(sb.toString());
        return decryptByPublicKey;
    }
}
