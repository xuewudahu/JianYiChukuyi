package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import retrofit2.http.*;

public interface RequestApiChengZhongDengJi
{
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("open/openapi/do")
    Call<ResponseChenZhongDdengJi> chenZhongDengJi(@Field("method") final String p0, @Field("appkey") final String p1, @Field("version") final String p2, @Field("contenttype") final String p3, @Field("timestamp") final String p4, @Field("bizcontent") final String p5, @Field("sign") final String p6);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("open/openapi/do")
    Call<ResponseChenZhongDdengJi> chenZhongDengJiPicture(@Field("method") final String p0, @Field("appkey") final String p1, @Field("version") final String p2, @Field("contenttype") final String p3, @Field("timestamp") final String p4, @Field("bizcontent") final String p5, @Field("sign") final String p6);
}
