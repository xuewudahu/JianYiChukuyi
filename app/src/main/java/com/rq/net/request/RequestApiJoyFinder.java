package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import java.util.*;
import retrofit2.http.*;
import com.rq.net.bean.*;

public interface RequestApiJoyFinder
{
    @GET("app/send_info")
    Call<ApiDataBean<SendInformationBean>> getAllSendInformationData(@Query("page") final int p0, @Query("size") final int p1, @Header("Authorization") final String p2);
    
    @GET
    Call<ApiDataBean<List<QueryBarcodeInforBean>>> getBarcodeTrajectory(@Query("express_no") final String p0, @Header("Authorization") final String p1);
    
    @GET("app/express_company/")
    Call<ApiDataBean<ExpressCompanyListBean>> getExpressCompanyListData(@Header("Authorization") final String p0);
    
    @GET("app/package_type/")
    Call<ApiDataBean<List<GoodsTypeBean>>> getGoodsType(@Header("Authorization") final String p0);
    
    @GET("app/send_info")
    Call<ApiDataBean<SendInformationBean>> getSendInformationData(@Query("search") final String p0, @Header("Authorization") final String p1);
    
    @GET("app/get_qrcode/")
    Call<ApiDataBean<String>> getSendQrCode(@Header("Authorization") final String p0);
    
    @GET("app/site")
    Call<ApiDataBean<SiteListBean>> getSiteList(@Query("page") final int p0, @Query("size") final int p1, @Header("Authorization") final String p2);
    
    @POST("app/outexpress/")
    Call<ApiDataBean<String>> uploadDispatchData(@Body final UploadDispatchBean p0, @Header("Authorization") final String p1);
    
    @POST("app/express_arrive_out/")
    Call<ApiDataBean<String>> uploadEntryStoreData(@Body final UploadEntryStoreBean p0, @Header("Authorization") final String p1);
    
    @POST("app/fetch/")
    Call<ApiDataBean<String>> uploadOutLibraryData(@Body final UploadOutLibraryBean p0, @Header("Authorization") final String p1);
    
    @GET("app/send_info/update_add/")
    Call<ApiDataBean<String>> uploadSendInformationData(@Body final UploadSendPieceDataBean p0, @Header("Authorization") final String p1);
}
