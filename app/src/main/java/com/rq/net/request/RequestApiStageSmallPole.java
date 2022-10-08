package com.rq.net.request;

import retrofit2.*;
import com.google.gson.*;
import retrofit2.http.*;
import com.rq.net.bean.*;

public interface RequestApiStageSmallPole
{
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("api/mobile/stage/changePull")
    Call<JsonObject> stageSmallPoleChuKu1(@Header("token") final String p0, @Field("return_type") final String p1, @Field("stype") final String p2, @Field("ticket_no") final String p3, @Field("type") final String p4);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("api/mobile/upload/ymiandan")
    Call<CourSmallPoleChuKuBean> stageSmallPoleChuKu2_1(@Header("token") final String p0, @Field("name") final String p1, @Field("return_type") final String p2, @Field("size") final String p3, @Field("type") final String p4, @Field("yid") final String p5);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("/")
    Call<JsonObject> stageSmallPoleChuKu2_2(@Header("token") final String p0, @Field("device") final String p1, @Field("return_type") final String p2, @Field("username") final String p3, @Field("password") final String p4);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("api/mobile/auth/login")
    Call<JsonObject> stageSmallPoleLogin(@Field("device") final String p0, @Field("return_type") final String p1, @Field("mobile") final String p2, @Field("password") final String p3);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("api/mobile/auth/subLogin")
    Call<JsonObject> stageSmallPoleSubLogin(@Field("device") final String p0, @Field("return_type") final String p1, @Field("account") final String p2, @Field("password") final String p3);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("api/mobile/auth/subLogin")
    Call<JsonObject> ziStageSmallPoleLogin(@Field("device") final String p0, @Field("return_type") final String p1, @Field("account") final String p2, @Field("password") final String p3);
}
