package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import retrofit2.http.*;
import com.rq.net.bean.*;

public interface RequestApiYundaNewKDCS
{
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("gateway/interface")
    Call<ApiDataYunDaNewKDCSBean<YunDa1781KDCSNoPicketResponseBean>> yunda1781KDCSCheckNoPicket(@Body final YunDa1781KDCSNoPicketBean p0);
    
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("gateway/interface")
    Call<ApiDataYunDaNewKDCSBean<YunDaNewKDCSCheckResponseBean>> yundaNewKDCSCheckBarcode(@Body final YunDaNewKDCSCheckData p0);
    
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("gateway/interface")
    Call<ApiDataYunDaNewKDCSBean<YunDaNewKDCSNoPicketResponseBean>> yundaNewKDCSCheckNoPicket(@Body final YunDaNewKDCSNoPicketBean p0);
    
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("gateway/interface")
    Call<ApiDataYunDaNewKDCSBean<YunDaKDCSLoginResponseBean>> yundaNewKDCSLogin(@Body final YunDaKDCSNewLoginBean p0);
    
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("gateway/interface")
    Call<ApiDataYunDaNewKDCSBean<YunDaKDCSBodyResponseBean>> yundaNewKDCSOutLibrary(@Body final YunDaNewKDCSOutLibraryBean p0);
}
