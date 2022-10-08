package com.rq.net.request;

//import kotlin.*;
import okhttp3.*;
import retrofit2.*;
import com.rq.net.bean.*;

import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.Headers;

public interface RequestApiSuDiYi
{
    @Headers({ "Content-Type: application/json; charset=utf-8" })
    @POST("https://codelivery-open.cnpost-sposter.com/open-delivery-platform/order/self/sign/submit/v2")
    Call<SuDiYiResponseBean> suDiYiuploadData(@Header("Date") final String p0, @Header("Authorization") final String p1, @Header("x-uid") final String p2, @Body final RequestBody p3);
    
    @POST("https://codelivery-open.cnpost-sposter.com/open-delivery-platform/order/self/sign/upload")
    Call<SuDiYiResponseBean> uploadImageData(@Header("Date") final String p0, @Header("Authorization") final String p1, @Header("x-uid") final String p2, @Body final RequestBody p3);
}
