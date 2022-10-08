package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import retrofit2.http.*;

public interface RequestApiLoginKDCS
{
    @GET("authorize?appid=zt-oNKHuI_ViWtkBdmbiIk1w&response_type=token&scope=userinfo")
    Call<KDCSLoginResponseBean> loginKDCS(@Header("Authorization") final String p0, @Header("Content-Type") final String p1, @Header("X-Device-Id") final String p2);
    
    @GET("token?appid=zt-oNKHuI_ViWtkBdmbiIk1w&scope=userinfo&grant_type=refresh_token")
    Call<KDCSLoginResponseBean> refreshToken(@Query("refresh_token") final String p0);
}
