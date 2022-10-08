package com.rq.net.request;

import retrofit2.*;
import retrofit2.http.*;
import com.rq.net.bean.*;
import com.rq.net.bean.*;

public interface RequestApiYundaChaoShi
{
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("openapi/outer/pictureMarket/photo/signShipPhotoN")
    Call<ApiDataYunDaNewKDCSBean<YunDa1781KDCSNoPicketResponseBean>> yunda1781KDCSCheckNoPicket(@Body final YunDa1781KDCSNoPicketBean p0);
    
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("openapi/outer/appMarket/appLogin")
    Call<ApiDataYunDaChaoShiBean<YunDaChaoShiLoginResponseBean>> yundaChaoShiLogin(@Header("app-key") final String p0, @Header("sign") final String p1, @Header("req-time") final long p2, @Body final YunDaChaoShiLoginBean p3);
    
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("openapi/outer/appMarket/ship/outShip")
    Call<ApiDataYunDaNewKDCSBean<YunDaNewKDCSCheckResponseBean>> yundaNewKDCSCheckBarcode(@Body final YunDaNewKDCSCheckData p0);
    
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("openapi/outer/appMarket/ship/signShipCheck")
    Call<ApiDataYunDaNewKDCSBean<YunDaNewKDCSNoPicketResponseBean>> yundaNewKDCSCheckNoPicket(@Body final YunDaNewKDCSNoPicketBean p0);
    
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("https://devkyweixin.yundasys.com/openapi/outer/appMarket/ship/queryOnePersonShips")
    Call<ApiDataYunDaNewKDCSBean<YunDaKDCSBodyResponseBean>> yundaNewKDCSOutLibrary(@Body final YunDaNewKDCSOutLibraryBean p0);
}
