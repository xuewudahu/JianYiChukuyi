package com.rq.net.di;

//import com.yunpan.common.bean.*;
import com.rq.net.bean.ApiDataBean;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.NetWorkUtil;
import com.rq.net.util.ToastSoundUtil;

import retrofit2.*;
//import com.yunpan.common.utils.*;
import java.io.*;

public class ApiPostStationCallback<DATA> implements Callback<ApiDataBean<DATA>>
{
    private HttpCallback callback;
    
    public ApiPostStationCallback(final HttpCallback callback) {
        this.callback = callback;
    }
    
    public void onFailure(final Call<ApiDataBean<DATA>> call, final Throwable t) {
        t.getMessage();
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
                this.callback.onSuccess(apiDataBean.getData());
                return;
            }
            try {
                final ApiDataBean apiDataBean2 = (ApiDataBean) JsonUtil.getClazzByGson(response.errorBody().string(), ApiDataBean.class);
                this.callback.onFailure(apiDataBean2.getCode(), apiDataBean2.getMsg());
            }
            catch (Exception ex) {
                ex.printStackTrace();
                try {
                    this.callback.onFailure(500, response.errorBody().string());
                }
                catch (IOException ex2) {
                    ex2.printStackTrace();
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
