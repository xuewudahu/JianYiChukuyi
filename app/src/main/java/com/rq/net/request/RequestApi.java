package com.rq.net.request;

import retrofit2.*;
import okhttp3.*;
import retrofit2.Call;
import retrofit2.http.*;
import com.rq.net.bean.*;

public interface RequestApi
{
    @GET
    @Streaming
    Call<ResponseBody> downloadApkFile(@Url final String p0);
    
    @GET("soft")
    Call<ApiDataBean<GetSoftUpdateVersionBean>> getUpdateVersion(@Query("id") final int p0, @Query("search") final String p1);
}
