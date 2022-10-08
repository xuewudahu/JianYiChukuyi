package com.rq.net.di;

import okhttp3.Headers;
import retrofit2.*;

import com.rq.net.bean.ApiDataBean;
import com.rq.net.bean.ApiDataFcBoxBean;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.NetWorkUtil;
import com.rq.net.util.ToastSoundUtil;
import java.io.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCallbackFenChaoService<DATA> implements Callback<ApiDataFcBoxBean<DATA>>
{
    public static String FC_COOKIE;
    public static String FC_TOKEN;
    private static final String TAG = "ApiCallbackFenChaoServi";
    private HttpCallback callback;
    
    public ApiCallbackFenChaoService(final HttpCallback callback) {
        this.callback = callback;
    }
    
    public void onFailure(final Call<ApiDataFcBoxBean<DATA>> call, final Throwable t) {
        if (this.callback != null) {
            if (!NetWorkUtil.isNetworkAvailable()) {
                ToastSoundUtil.wrongSoundToast("\u6ca1\u6709\u7f51\u7edc\uff01");
                this.callback.onFailure(-1, "");
                return;
            }
            if (t.getMessage() != null) {
                this.callback.onFailure(-2, t.getMessage());
                return;
            }
            this.callback.onFailure(-1, "\u670d\u52a1\u5668\u8fd4\u56de\u672a\u77e5\u9519\u8bef\uff01");
        }
    }
    
    public void onResponse(final Call<ApiDataFcBoxBean<DATA>> call, final Response<ApiDataFcBoxBean<DATA>> response) {
        if (this.callback != null) {
            final Headers headers = response.headers();
            for (int i = 0; i < headers.size(); ++i) {
                final String name = headers.name(i);
                if (name != null && name.equals("Fc_authenticated_token")) {
                    ApiCallbackFenChaoService.FC_TOKEN = headers.value(i);
                }
                else if (name != null && name.equals("Set-Cookie")) {
                    final String value = headers.value(i);
                    if (value.contains("_5ee03")) {
                        ApiCallbackFenChaoService.FC_COOKIE = value.replace("; Path=/", "");
                    }
                }
            }
            final ApiDataFcBoxBean apiDataFcBoxBean = (ApiDataFcBoxBean)response.body();
            if (apiDataFcBoxBean != null) {
                if (apiDataFcBoxBean.getCode() == 0) {
                    this.callback.onSuccess(apiDataFcBoxBean.getData());
                    return;
                }
                if (apiDataFcBoxBean.getChnDesc() != null) {
                    this.callback.onFailure(apiDataFcBoxBean.getCode(), apiDataFcBoxBean.getChnDesc());
                    return;
                }
                this.callback.onFailure(apiDataFcBoxBean.getCode(), "\u672a\u77e5\u9519\u8bef ");
            }
            else {
                try {
                    final ApiDataBean apiDataBean = (ApiDataBean) JsonUtil.getClazzByGson(response.errorBody().string(), ApiDataBean.class);
                    this.callback.onFailure(apiDataBean.getCode(), apiDataBean.getMsg());
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    this.callback.onFailure(500, "\u672a\u77e5\u9519\u8bef");
                }
            }
        }
    }
    
    public interface HttpCallback<T>
    {
        void onFailure(final int p0, final String p1);
        
        void onSuccess(final T p0);
    }
}
