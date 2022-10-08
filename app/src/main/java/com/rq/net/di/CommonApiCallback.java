package com.rq.net.di;

import com.rq.net.bean.PinDuoDuoBaseResponseBean;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.NetWorkUtil;
import com.rq.net.util.ToastSoundUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonApiCallback<DATA> implements Callback<DATA> {
    private CommonApiCallback.HttpCallback callback;

    public CommonApiCallback(CommonApiCallback.HttpCallback var1) {
        this.callback = var1;
    }

    public void onFailure(Call<DATA> var1, Throwable var2) {
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

    public void onResponse(Call<DATA> var1, Response<DATA> var2) {
        if (this.callback != null) {
            //Object var6 = (Object) var2;
            if (var2 != null) {
                this.callback.onSuccess(var2.body());
                return;
            }

            if (var2.code() == 401) {
                this.callback.onFailure(401, "登录过期,请重新登录");
                return;
            }

            try {
                String var7 = var2.errorBody().string();
                CommonApiCallback.HttpCallback var8 = this.callback;
                StringBuilder var3 = new StringBuilder();
                var3.append("数据解析失败 ");
                var3.append(var7);
                var8.onFailure(-100, var3.toString());
                return;
            } catch (IOException var4) {
                var4.printStackTrace();
                this.callback.onFailure(500, "未知错误");
            } catch (Exception var5) {
                var5.printStackTrace();
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