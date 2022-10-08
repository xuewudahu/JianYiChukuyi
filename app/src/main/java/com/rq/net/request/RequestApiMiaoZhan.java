package com.rq.net.request;

import com.rq.net.bean.*;
import retrofit2.*;
import com.rq.net.bean.*;
import retrofit2.http.*;

public interface RequestApiMiaoZhan
{
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("delivery/uploadCheckOutPic")
    Call<MiaoZhanBean> miaoZhanCheckOut(@Body final MiaoZhan p0);
    
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("delivery/stationBind")
    Call<MiaoZhanBean> miaoZhanLogin(@Body final MiaoZhan p0);
    
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("delivery/stationCheckOut")
    Call<MiaoZhanBean> miaoZhanOutLib(@Body final MiaoZhan p0);
}
