package com.rq.net.di;

import com.rq.net.bean.ApiDataYunDaKDCSBean;
import com.rq.net.bean.ApiDataYunDaNewKDCSBean;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.NetWorkUtil;
import com.rq.net.util.ToastSoundUtil;

import retrofit2.*;
//import com.yunpan.common.bean.*;
//import com.yunpan.common.utils.*;
import java.io.*;

public class ApiCallbackYunDaNewKDCS<DATA> implements Callback<ApiDataYunDaNewKDCSBean<DATA>>
{
    private static final String TAG = "ApiCallbackYunDaNewKDCS";
    private HttpCallback callback;
    
    public ApiCallbackYunDaNewKDCS(final HttpCallback callback) {
        this.callback = callback;
    }
    
    public void onFailure(final Call<ApiDataYunDaNewKDCSBean<DATA>> call, final Throwable t) {
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
    
    public void onResponse(final Call<ApiDataYunDaNewKDCSBean<DATA>> call, final Response<ApiDataYunDaNewKDCSBean<DATA>> response) {
        try {
            if (this.callback != null) {
                final ApiDataYunDaNewKDCSBean apiDataYunDaNewKDCSBean = (ApiDataYunDaNewKDCSBean)response.body();
                if (apiDataYunDaNewKDCSBean != null) {
                    if (apiDataYunDaNewKDCSBean.isSuccess()) {
                        this.callback.onSuccess(apiDataYunDaNewKDCSBean.getBody());
                        return;
                    }
                    if (apiDataYunDaNewKDCSBean.getBody() != null) {
                        this.callback.onFailure(-2, apiDataYunDaNewKDCSBean.getMsg());
                        return;
                    }
                    this.callback.onFailure(-2, apiDataYunDaNewKDCSBean.getMsg());
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
