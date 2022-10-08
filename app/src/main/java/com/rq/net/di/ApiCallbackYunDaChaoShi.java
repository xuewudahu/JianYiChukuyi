package com.rq.net.di;

import com.rq.net.bean.ApiDataYunDaChaoShiBean;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.NetWorkUtil;
import com.rq.net.util.ToastSoundUtil;

import retrofit2.*;
import java.io.*;

public class ApiCallbackYunDaChaoShi<DATA> implements Callback<ApiDataYunDaChaoShiBean<DATA>>
{
    private static final String TAG = "ApiCallbackYunDaKDCS";
    private HttpCallback callback;
    
    public ApiCallbackYunDaChaoShi(final HttpCallback callback) {
        this.callback = callback;
    }
    
    public void onFailure(final Call<ApiDataYunDaChaoShiBean<DATA>> call, final Throwable t) {
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
    
    public void onResponse(final Call<ApiDataYunDaChaoShiBean<DATA>> call, final Response<ApiDataYunDaChaoShiBean<DATA>> response) {
        if (this.callback != null) {
            final ApiDataYunDaChaoShiBean apiDataYunDaChaoShiBean = (ApiDataYunDaChaoShiBean)response.body();
            if (apiDataYunDaChaoShiBean != null) {
                if (apiDataYunDaChaoShiBean.isResult()) {
                    this.callback.onSuccess(apiDataYunDaChaoShiBean);
                    return;
                }
                if (apiDataYunDaChaoShiBean != null) {
                    this.callback.onFailure(-2, apiDataYunDaChaoShiBean.getMessage());
                    return;
                }
                this.callback.onFailure(-2, apiDataYunDaChaoShiBean.getMessage());
            }
            else {
                try {
                    this.callback.onFailure(-2, ((ApiDataYunDaChaoShiBean) JsonUtil.getClazzByGson(response.errorBody().string(), ApiDataYunDaChaoShiBean.class)).getMessage());
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
