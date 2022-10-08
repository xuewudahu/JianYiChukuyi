package com.rq.net.di;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SSLSocketClient {
    public SSLSocketClient() {
    }

    public static HostnameVerifier getHostnameVerifier() {
        return new HostnameVerifier() {
            public boolean verify(String var1, SSLSession var2) {
                return true;
            }
        };
    }

    public static SSLSocketFactory getSSLSocketFactory() {
        try {
            SSLContext var0 = SSLContext.getInstance("SSL");
            var0.init((KeyManager[])null, getTrustManager(), new SecureRandom());
            SSLSocketFactory var2 = var0.getSocketFactory();
            return var2;
        } catch (Exception var1) {
            throw new RuntimeException(var1);
        }
    }

    private static TrustManager[] getTrustManager() {
        return new TrustManager[]{new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] var1, String var2) {
            }

            public void checkServerTrusted(X509Certificate[] var1, String var2) {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
    }
}