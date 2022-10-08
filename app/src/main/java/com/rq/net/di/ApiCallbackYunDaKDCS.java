package com.rq.net.di;

import com.rq.net.bean.ApiDataYunDaKDCSBean;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.NetWorkUtil;
import com.rq.net.util.ToastSoundUtil;

import retrofit2.*;
import java.io.*;

public class ApiCallbackYunDaKDCS<DATA> implements Callback<ApiDataYunDaKDCSBean<DATA>>
{
    private static final String TAG = "ApiCallbackYunDaKDCS";
    private HttpCallback callback;
    
    public ApiCallbackYunDaKDCS(final HttpCallback callback) {
        this.callback = callback;
    }
    
    public void onFailure(final Call<ApiDataYunDaKDCSBean<DATA>> call, final Throwable t) {
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
    
    public void onResponse(final Call<ApiDataYunDaKDCSBean<DATA>> call, final Response<ApiDataYunDaKDCSBean<DATA>> response) {
        if (this.callback != null) {
            final ApiDataYunDaKDCSBean apiDataYunDaKDCSBean = (ApiDataYunDaKDCSBean)response.body();
            if (apiDataYunDaKDCSBean != null) {
                if (apiDataYunDaKDCSBean.isSuccess()) {
                    this.callback.onSuccess(apiDataYunDaKDCSBean.getBody());
                    return;
                }
                if (apiDataYunDaKDCSBean.getBody() != null) {
                    this.callback.onFailure(-2, apiDataYunDaKDCSBean.getBody().toString());
                    return;
                }
                this.callback.onFailure(-2, (String)apiDataYunDaKDCSBean.getErrorcode());
            }
            else {
                try {
                    this.callback.onFailure(-2, ((ApiDataYunDaKDCSBean) JsonUtil.getClazzByGson(response.errorBody().string(), ApiDataYunDaKDCSBean.class)).getErrmsg());
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
