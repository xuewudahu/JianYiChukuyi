package com.rq.net.request;

import retrofit2.*;
import com.google.gson.*;
import okhttp3.*;
import com.rq.net.bean.*;

import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.Headers;

public interface RequestApiBlueShop
{
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("client/express/takeExpress.htm")
    Call<JsonObject> ChuKu(@Header("Cookie") final String p0, @Field("id") final String p1, @Field("checkCode") final String p2);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("app/user/login_new.htm")
    Call<JsonObject> blueShopLogin(@Field("params") final String p0);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("login2.htm")
    Call<ResponseBody> blueShopLoginCookie(@Field("username") final String p0, @Field("password") final String p1);
    
    @GET("client/express/page.htm")
    Call<QueryBarCodeBean> queryBarCode(@Header("Cookie") final String p0, @Query("toPage") final int p1, @Query("type") final int p2, @Query("searchStatus") final int p3, @Query("searchPartnerId") final String p4, @Query("phoneOrNo") final String p5);
}
