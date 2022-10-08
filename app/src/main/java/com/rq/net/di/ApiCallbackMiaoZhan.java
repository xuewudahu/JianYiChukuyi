package com.rq.net.di;

import com.rq.net.bean.ApiDataBean;
import com.rq.net.bean.MiaoZhanBean;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.NetWorkUtil;
import com.rq.net.util.ToastSoundUtil;

import retrofit2.*;
//import com.yunpan.common.bean.*;
//import com.yunpan.common.utils.*;
import java.io.*;

public class ApiCallbackMiaoZhan implements Callback<MiaoZhanBean>
{
    private HttpCallback callback;
    
    public ApiCallbackMiaoZhan(final HttpCallback callback) {
        this.callback = callback;
    }
    
    public void onFailure(final Call<MiaoZhanBean> call, final Throwable t) {
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
    
    public void onResponse(final Call<MiaoZhanBean> call, final Response<MiaoZhanBean> response) {
        if (this.callback != null) {
            final MiaoZhanBean miaoZhanBean = (MiaoZhanBean)response.body();
            if (miaoZhanBean != null) {
                if (miaoZhanBean.getSuccess()) {
                    this.callback.onSuccess(miaoZhanBean);
                    return;
                }
                if (miaoZhanBean.getErrorMsg() != null) {
                    this.callback.onFailure(miaoZhanBean.getErrorCode(), miaoZhanBean.getErrorMsg());
                    return;
                }
                this.callback.onFailure(miaoZhanBean.getErrorCode(), "\u672a\u77e5\u9519\u8bef ");
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
