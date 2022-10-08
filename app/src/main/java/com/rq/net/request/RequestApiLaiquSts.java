package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import com.rq.net.bean.*;
import retrofit2.http.*;

public interface RequestApiLaiquSts
{
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("sts/common/regist")
    Call<ApiDataBean<LaiquStsRegistResponseBean>> laiquStsRegist(@Field("project") final String p0, @Field("uid") final String p1, @Field("data") final String p2, @Field("key") final String p3);
}
