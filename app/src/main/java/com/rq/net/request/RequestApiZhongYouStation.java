package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import retrofit2.http.*;
import com.rq.net.bean.*;

public interface RequestApiZhongYouStation
{
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("v1/dak/ScanCode/deliveryStorage")
    Call<ApiDataKuaibaoBean<Object>> kuaibaoDeliveryStorage(@Field("app_id") final String p0, @Field("ts") final String p1, @Field("sign") final String p2, @Field("data") final String p3, @Header("version") final String p4, @Header("appversion") final String p5, @Header("app_id") final String p6, @Header("pname") final String p7, @Header("Cookie") final String p8);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded;charset=utf8" })
    @POST("v1/YzApp/getInfo")
    Call<ApiDataKuaibaoBean<KuaiBaoGetStationInforResponseBean>> kuaibaoGetStationInfor(@Field("did") final String p0, @Field("app_id") final String p1, @Field("ts") final String p2, @Field("sign") final String p3, @Field("data") final String p4, @Header("version") final String p5, @Header("appversion") final String p6, @Header("pname") final String p7, @Header("Cookie") final String p8);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("v1/dak/ScanCode/getUserUnPickUpLists")
    Call<ApiDataKuaibaoBean<KuaiBaoGetUserUnPickUpListsResponseBean>> kuaibaoGetUserUnPickUpLists(@Field("app_id") final String p0, @Field("ts") final String p1, @Field("sign") final String p2, @Field("data") final String p3, @Header("version") final String p4, @Header("appversion") final String p5, @Header("app_id") final String p6, @Header("pname") final String p7, @Header("Cookie") final String p8);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded;charset=utf8" })
    @POST("v1/YzApp/phoneLogin")
    Call<ApiDataKuaibaoBean<KuaiBaoLoginResponseBean>> kuaibaoLogin(@Field("app_id") final String p0, @Field("ts") final String p1, @Field("sign") final String p2, @Field("data") final String p3, @Header("version") final String p4, @Header("appversion") final String p5, @Header("pname") final String p6, @Header("Cookie") final String p7);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("v1/dak/ScanCode/expressV2")
    Call<ApiDataKuaibaoBean<KuaiBaoQueryBillcodeInforResponseBean>> kuaibaoQueryBillcodeInfor(@Field("app_id") final String p0, @Field("ts") final String p1, @Field("sign") final String p2, @Field("data") final String p3, @Header("version") final String p4, @Header("appVersion") final String p5, @Header("app_id") final String p6, @Header("pname") final String p7, @Header("Cookie") final String p8);
}
