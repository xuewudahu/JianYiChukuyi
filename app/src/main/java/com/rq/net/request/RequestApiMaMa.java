package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import okhttp3.*;
import java.util.*;

import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.Headers;

import com.rq.net.bean.*;

public interface RequestApiMaMa
{
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("opYZUpload/stage/check/inStage")
    Call<ApiDataMaMaBean<MaMaCheckBarcodeResponseBean>> mamaCheckBarcodeInfor(@Body final MaMaCheckBarcodeInforBean p0, @Header("pdaDeviceNo") final String p1, @Header("pdaVersionNo") final String p2, @Header("pdaVersionCode") final String p3, @Header("pdaDeviceType") final String p4, @Header("deviceModel") final String p5, @Header("token") final String p6, @Header("orgCode") final String p7, @Header("stationCode") final String p8);
    
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("opYZUpload/stage/op/inStage")
    Call<ResponseBody> mamaInLibrary(@Body final MaMaInLibraryBean p0, @Header("pdaDeviceNo") final String p1, @Header("pdaVersionNo") final String p2, @Header("pdaVersionCode") final String p3, @Header("pdaDeviceType") final String p4, @Header("deviceModel") final String p5, @Header("token") final String p6, @Header("orgCode") final String p7, @Header("loginUserCode") final String p8);
    
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("opYZUpload/stage/async/outBoundCheck")
    Call<ApiDataMaMaBean<List<MaMaQueryBarcodeResponseBean>>> mamaQueryBarcode(@Body final MaMaQueryBarcodeBean p0, @Header("pdaDeviceNo") final String p1, @Header("pdaVersionNo") final String p2, @Header("pdaVersionCode") final String p3, @Header("pdaDeviceType") final String p4, @Header("deviceModel") final String p5, @Header("token") final String p6, @Header("orgCode") final String p7, @Header("stationCode") final String p8, @Header("userCode") final String p9, @Header("userName") final String p10, @Header("serialNo") final String p11, @Header("time") final String p12);
    
    @GET("opYZUpload/stage/query/queryWaybillRegularInfo")
    Call<ApiDataMaMaBean<List<MaMaQueryBillRegularResponseBean>>> mamaQueryWaybillRegularInfo(@Header("token") final String p0);
    
    @POST("yiapp-server-portal-new/yuanDing/refreshToken")
    Call<ApiDataMaMaBean<MaMaLoginResponseBean>> mamaRefreshToken(@Body final MaMaLoginBean p0, @Header("token ") final String p1);
    
    @POST("opYZUpload/stage/loginNew")
    Call<ApiDataMaMaBean<MaMaLoginResponseBean>> mamaStationLogin(@Body final MaMaLoginBean p0, @Header("pdaDeviceNo") final String p1, @Header("pdaVersionNo") final String p2, @Header("pdaVersionCode") final String p3, @Header("pdaDeviceType") final String p4, @Header("deviceModel") final String p5, @Header("userName") final String p6, @Header("serialNo") final String p7, @Header("time") final String p8);
}
