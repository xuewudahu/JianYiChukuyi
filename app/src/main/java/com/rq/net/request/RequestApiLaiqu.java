package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import retrofit2.http.*;
import com.rq.net.bean.*;

public interface RequestApiLaiqu
{
    @POST("lqapi/Security/GetRsaPublicKey")
    Call<ApiDataLaiquBean<LaiquRsaPublicKeyBean>> getRsaPublicKey();
    
    @POST("lq/api/getBillInfo")
    Call<ApiDataLaiquBean<LaiquBillInfoResponseBean>> laiquGetBillInfo(@Body final LaiquBillInfoBean p0, @Header("Authorization") final String p1);
    
    @POST("lqapi/Security/LoginServiceSiteEx")
    Call<ApiDataLaiquBean<LaiquSiteLoginResponseBean>> laiquSiteLogin(@Body final LaiquSiteBean p0, @Header("Authorization") final String p1);
    
    @POST("lqapi/Security/UserLogin")
    Call<ApiDataLaiquBean<LaiquLoginResponseBean>> laiquUserLogin(@Body final LaiquUserLoginBean p0, @Header("Authorization") final String p1);
}
