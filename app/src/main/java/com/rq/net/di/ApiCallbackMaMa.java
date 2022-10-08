package com.rq.net.di;

import com.rq.net.bean.ApiDataBean;
import com.rq.net.bean.ApiDataMaMaBean;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.NetWorkUtil;
import com.rq.net.util.ToastSoundUtil;

import retrofit2.*;
import java.io.*;

public class ApiCallbackMaMa<DATA> implements Callback<ApiDataMaMaBean<DATA>>
{
    private HttpCallback callback;
    
    public ApiCallbackMaMa(final HttpCallback callback) {
        this.callback = callback;
    }
    
    public void onFailure(final Call<ApiDataMaMaBean<DATA>> call, final Throwable t) {
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
    
    public void onResponse(final Call<ApiDataMaMaBean<DATA>> call, final Response<ApiDataMaMaBean<DATA>> response) {
        try {
            if (this.callback != null) {
                final ApiDataMaMaBean apiDataMaMaBean = (ApiDataMaMaBean)response.body();
                if (apiDataMaMaBean != null) {
                    if (apiDataMaMaBean.getCode().equals("200") || apiDataMaMaBean.getCode().equals("712")) {
                        this.callback.onSuccess(apiDataMaMaBean.getData());
                        return;
                    }
                    if (apiDataMaMaBean.getCode() != null && apiDataMaMaBean.getCode().length() > 2) {
                        apiDataMaMaBean.setCode(apiDataMaMaBean.getCode().substring(2));
                    }
                    else {
                        apiDataMaMaBean.setCode("-100");
                    }
                    if (apiDataMaMaBean.getMessage() != null) {
                        this.callback.onFailure(Integer.parseInt(apiDataMaMaBean.getCode()), apiDataMaMaBean.getMessage());
                        return;
                    }
                    this.callback.onFailure(Integer.parseInt(apiDataMaMaBean.getCode()), "\u672a\u77e5\u9519\u8bef ");
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
        catch (Exception ex3) {
            ex3.printStackTrace();
        }
    }
    
    public interface HttpCallback<T>
    {
        void onFailure(final int p0, final String p1);
        
        void onSuccess(final T p0);
    }
}
