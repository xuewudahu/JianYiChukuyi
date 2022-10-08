package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import retrofit2.http.*;

public interface RequestApiXiNiaoGaoPai
{
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("gpy/practice/gpy/station/gpyPackageSign")
    Call<GaoPaiResponse> xiNiaoGaoPai(@Field("waybillNo") final String p0, @Field("unionCode") final String p1, @Field("deviceCode") final String p2, @Field("timestamp") final String p3, @Field("signature") final String p4, @Field("photoSignLink") final String p5, @Field("manufacturer") final String p6, @Field("deviceNumber") final String p7, @Field("version") final String p8);
}
