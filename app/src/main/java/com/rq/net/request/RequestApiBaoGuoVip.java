package com.rq.net.request;

//import kotlin.*;
import retrofit2.*;
import retrofit2.http.*;
import com.rq.net.bean.*;

public interface RequestApiBaoGuoVip
{
    @Headers({ "Content-Type: application/json; charset=UTF-8" })
    @POST("public/user_login")
    Call<LoginResponseBean> login(@Body final LoginRequestBean p0, @Header("apiid") final String p1, @Header("device") final String p2);
    
    @Headers({ "Content-Type: application/json; charset=UTF-8" })
    @POST("agent/put_off_storage_v3")
    Call<OffStorageResponseBean> putOffStorageV3(@Body final OffStorageRequestBean p0, @Header("apiid") final String p1, @Header("device") final String p2, @Header("token") final String p3);
}
