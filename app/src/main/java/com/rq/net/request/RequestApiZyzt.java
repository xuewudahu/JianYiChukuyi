package com.rq.net.request;

import retrofit2.*;
import retrofit2.http.*;
import com.rq.net.bean.*;

public interface RequestApiZyzt
{
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("getConnectionCheck")
    Call<ZyztCallBack> getConnectionCheck(@Body final ZyztConnectReq p0);
    
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("getMailDeliveryInfo")
    Call<ZyztCallBack> getMailDeliveryInfo(@Body final MiaoZhan p0);
    
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("mailTakenCheck")
    Call<ZyztCallBack> mailTakenCheck(@Body final MiaoZhan p0);
}
