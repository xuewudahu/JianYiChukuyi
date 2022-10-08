package com.rq.net.di;


import android.content.Context;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Interceptor.Chain;

public class HeaderInterceptor implements Interceptor {
    private Context mContext;

    public HeaderInterceptor(Context var1) {
        this.mContext = var1;
    }

    public Response intercept(Chain var1) throws IOException {
        Request var2 = var1.request();

        Request var3;
        try {
            var3 = var2.newBuilder().build();
        } catch (Exception var4) {
            var4.printStackTrace();
            return var1.proceed(var2);
        }

        var2 = var3;
        return var1.proceed(var2);
    }
}