package com.rq.net.request;

import com.rq.net.bean.*;
import retrofit2.*;
import com.rq.net.bean.*;
import retrofit2.http.*;

public interface RequestApiMaMaOutLibrary
{
    @Headers({ "Content-Type: application/json" })
    @POST("opYZUpload/stage/async/outBoundUpload")
    Call<ApiDataMaMaBean<Object>> mamaOutLibrary(@Body final MaMaOutLibraryBean p0, @Header("pdaDeviceNo") final String p1, @Header("pdaVersionNo") final String p2, @Header("pdaVersionCode") final String p3, @Header("pdaDeviceType") final String p4, @Header("deviceModel") final String p5, @Header("token") final String p6, @Header("orgCode") final String p7, @Header("stationCode") final String p8, @Header("userCode") final String p9, @Header("userName") final String p10, @Header("serialNo") final String p11, @Header("time") final String p12);
}
