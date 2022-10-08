package com.rq.net.di;

import retrofit2.*;

import com.rq.net.bean.ApiDataBean;
import com.rq.net.bean.ApiDataLaiquBean;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.NetWorkUtil;
import com.rq.net.util.ToastSoundUtil;
import java.io.*;

public class ApiCallbackLaiqu<DATA> implements Callback<ApiDataLaiquBean<DATA>>
{
    private HttpCallback callback;
    
    public ApiCallbackLaiqu(final HttpCallback callback) {
        this.callback = callback;
    }
    
    public void onFailure(final Call<ApiDataLaiquBean<DATA>> call, final Throwable t) {
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
    
    public void onResponse(final Call<ApiDataLaiquBean<DATA>> call, final Response<ApiDataLaiquBean<DATA>> response) {
        try {
            if (this.callback != null) {
                final ApiDataLaiquBean apiDataLaiquBean = (ApiDataLaiquBean)response.body();
                if (apiDataLaiquBean != null) {
                    if (apiDataLaiquBean.getStatus() == 200 || apiDataLaiquBean.getStatus() == 1) {
                        this.callback.onSuccess(apiDataLaiquBean.getResult());
                        return;
                    }
                    if (apiDataLaiquBean.getErrorMsg() != null) {
                        this.callback.onFailure(-2, apiDataLaiquBean.getErrorMsg());
                        return;
                    }
                    this.callback.onFailure(-100, "\u672a\u77e5\u9519\u8bef ");
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
