package com.rq.net.di;

import com.rq.net.bean.ApiDataBean;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.NetWorkUtil;
import com.rq.net.util.ToastSoundUtil;
import retrofit2.*;
import java.io.*;

public class ApiCallback<DATA> implements Callback<ApiDataBean<DATA>>
{
    private HttpCallback callback;
    
    public ApiCallback(final HttpCallback callback) {
        this.callback = callback;
    }
    
    public void onFailure(final Call<ApiDataBean<DATA>> call, final Throwable t) {
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
    
    public void onResponse(final Call<ApiDataBean<DATA>> call, final Response<ApiDataBean<DATA>> response) {
        if (this.callback != null) {
            final ApiDataBean apiDataBean = (ApiDataBean)response.body();
            if (apiDataBean != null) {
                if (apiDataBean.getCode() == 200 || apiDataBean.getCode() == 1 || apiDataBean.getCode() == 4) {
                    this.callback.onSuccess(apiDataBean.getData());
                    return;
                }
                if (apiDataBean.getMsg() != null) {
                    this.callback.onFailure(apiDataBean.getCode(), apiDataBean.getMsg());
                    return;
                }
                this.callback.onFailure(apiDataBean.getCode(), "\u672a\u77e5\u9519\u8bef");
            }
            else {
                try {
                    final ApiDataBean apiDataBean2 = (ApiDataBean) JsonUtil.getClazzByGson(response.errorBody().string(), ApiDataBean.class);
                    this.callback.onFailure(apiDataBean2.getCode(), apiDataBean2.getMsg());
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
