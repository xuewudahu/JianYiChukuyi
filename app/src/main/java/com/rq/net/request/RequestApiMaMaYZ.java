package com.rq.net.request;

import retrofit2.*;
import retrofit2.http.*;
import com.rq.net.bean.*;

public interface RequestApiMaMaYZ
{
    @Headers({ "Content-Type: application/json" })
    @POST("yiapp-server-portal-new/package/listV1")
    Call<MaMaNoOutLibraryResponseBean> mamaCheckBarcode(@Body final MaMaCheckInforBean p0, @Header("pdaDeviceNo") final String p1, @Header("pdaVersionNo") final String p2, @Header("pdaVersionCode") final String p3, @Header("pdaDeviceType") final String p4, @Header("deviceModel") final String p5, @Header("token") final String p6, @Header("orgCode") final String p7, @Header("serialNo") final String p8);
    
    @Headers({ "Content-Type: application/json" })
    @POST("yiapp-server-portal-new/listBaseOptions")
    Call<MaMaCheckExpressCompanyResponseBean> mamaCheckExpressCompanyInfor(@Body final MaMaCheckInforBean p0, @Header("pdaDeviceNo") final String p1, @Header("pdaVersionNo") final String p2, @Header("pdaVersionCode") final String p3, @Header("pdaDeviceType") final String p4, @Header("deviceModel") final String p5, @Header("token") final String p6, @Header("orgCode") final String p7, @Header("serialNo") final String p8);
    
    @Headers({ "Content-Type: application/json" })
    @POST("yiapp-server-portal-new/listBaseOptions")
    Call<MaMaCheckHuoJiaResponseBean> mamaCheckHuoJiaInfor(@Body final MaMaCheckInforBean p0, @Header("pdaDeviceNo") final String p1, @Header("pdaVersionNo") final String p2, @Header("pdaVersionCode") final String p3, @Header("pdaDeviceType") final String p4, @Header("deviceModel") final String p5, @Header("token") final String p6, @Header("orgCode") final String p7, @Header("serialNo") final String p8);
    
    @Headers({ "Content-Type: application/json" })
    @POST("opYZAppPackage/package/list")
    Call<MaMaNoOutLibraryResponseBean> mamaCheckNoOutLibrary(@Body final MaMaCheckInforBean p0, @Header("pdaDeviceNo") final String p1, @Header("pdaVersionNo") final String p2, @Header("pdaVersionCode") final String p3, @Header("pdaDeviceType") final String p4, @Header("token") final String p5, @Header("orgCode") final String p6, @Header("stationCode") final String p7, @Header("userCode") final String p8, @Header("userName") final String p9, @Header("serialNo") final String p10, @Header("time") final String p11);
}
