package com.rq.net.di;

import retrofit2.*;

import com.rq.net.bean.ApiDataBean;
import com.rq.net.bean.ApiDataKuaibaoBean;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.NetWorkUtil;
import com.rq.net.util.ToastSoundUtil;

import java.io.*;

import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCallbackKuaibao<DATA> implements Callback<ApiDataKuaibaoBean<DATA>> {
    private ApiCallbackKuaibao.HttpCallback callback;

    public ApiCallbackKuaibao(ApiCallbackKuaibao.HttpCallback var1) {
        this.callback = var1;
    }

    public void onFailure(Call<ApiDataKuaibaoBean<DATA>> var1, Throwable var2) {
        if (this.callback != null) {
            if (!NetWorkUtil.isNetworkAvailable()) {
                ToastSoundUtil.wrongSoundToast("没有网络！");
                this.callback.onFailure(-1, "");
                return;
            }

            if (var2.getMessage() != null) {
                this.callback.onFailure(-2, var2.getMessage());
                return;
            }

            this.callback.onFailure(-1, "服务器返回未知错误！");
        }

    }

    public void onResponse(Call<ApiDataKuaibaoBean<DATA>> var1, Response<ApiDataKuaibaoBean<DATA>> var2) {
        if (this.callback != null) {
            ApiDataKuaibaoBean var5 = (ApiDataKuaibaoBean)var2.body();
            if (var5 != null) {
                if (var5.getCode() == 0) {
                    this.callback.onSuccess(var5.getData());
                    return;
                }

                if (var5.getMsg() != null) {
                    this.callback.onFailure(-2, var5.getMsg());
                    return;
                }

                this.callback.onFailure(-100, "未知错误 ");
                return;
            }

            try {
                ApiDataBean var6 = (ApiDataBean) JsonUtil.getClazzByGson(var2.errorBody().string(), ApiDataBean.class);
                this.callback.onFailure(var6.getCode(), var6.getMsg());
                return;
            } catch (IOException var3) {
                var3.printStackTrace();
                this.callback.onFailure(500, "未知错误");
            } catch (Exception var4) {
                var4.printStackTrace();
                this.callback.onFailure(500, "未知错误");
                return;
            }
        }

    }

    public interface HttpCallback<T> {
        void onFailure(int var1, String var2);

        void onSuccess(T var1);
    }
}
