package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import retrofit2.http.*;
import com.rq.net.bean.*;

public interface RequestApiKDCS
{
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("gateway.do/")
    Call<ApiDataKDCSBean<KDCSCheckResponseBean>> checkGatwwayBillcodeInfor(@Field("data") final String p0, @Header("X-Zop-Name") final String p1, @Header("X-Ca-Version") final String p2, @Header("X-Token") final String p3, @Header("X-Openid") final String p4, @Header("X-Userid") final String p5);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("gateway.do/")
    Call<ApiDataKDCSBean<KDCSOutLibraryResponseBean>> kdcsOutLibrary(@Field("data") final String p0, @Header("X-Zop-Name") final String p1, @Header("X-Ca-Version") final String p2, @Header("X-Token") final String p3, @Header("X-Openid") final String p4, @Header("X-Userid") final String p5);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("gateway.do/")
    Call<ApiDataKDCSBean<KDCSQueryStaffAndStoreResponseBean>> queryStaffAndStoreInfor(@Field("data") final String p0, @Header("X-Zop-Name") final String p1, @Header("X-Ca-Version") final String p2, @Header("X-Token") final String p3, @Header("X-Openid") final String p4, @Header("X-Userid") final String p5);
}
