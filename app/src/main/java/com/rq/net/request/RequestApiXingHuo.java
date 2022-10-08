package com.rq.net.request;

import retrofit2.*;
import retrofit2.http.*;
import com.rq.net.bean.*;
import com.kuaidihelp.posthouse.Response.NotOutLibraryResponse;

public interface RequestApiXingHuo
{
    @GET("security/publicKey")
    Call<PublicKeyBean> getPublicKey();
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("security/login")
    Call<XingHuoResponse> xingHuoLogin(@Field("loginType") final String p0, @Field("rememberMe") final String p1, @Field("userName") final String p2, @Field("password") final String p3, @Header("Cookie") final String p4);
    
    @Headers({ "Content-Type: application/json; charset=UTF-8" })
    @POST("express/waybill/optionalPickup/pc")
    Call<XingHuoOutLibraryReponse> xingHuoOutLibrary(@Header("Cookie") final String p0, @Body final XingHuoOutLibrary p1);
    
    @Headers({ "Content-Type: application/json; charset=UTF-8" })
    @POST("express/waybill/phonePickup")
    Call<NotOutLibraryResponse> xingHuoPhonePickUp(@Header("Cookie") final String p0, @Body final XingHuoNotOutLibrary p1);
}
