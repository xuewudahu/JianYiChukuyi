package com.rq.net.request;

//import kotlin.*;
import okhttp3.*;
import retrofit2.*;
import com.rq.net.bean.*;

import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.Headers;

public interface RequestApiZhongYouKT
{
    @Multipart
    @POST("services/upload/image")
    Call<ZhongYouUploadWeightResponseBean> uploadImageData(@Body final MultipartBody p0);
    
    @Headers({ "Content-Type: application/json" })
    @POST("services/deviceCommand/execute")
    Call<ZhongYouUploadWeightResponseBean> uploadWeightData(@Body final ZhongYouUploadWeightRequestBean p0, @Header("JD-RegisterNo") final String p1, @Header("JD-Signature") final String p2, @Header("JD-SiteCode") final String p3, @Header("JD-Authorization") final String p4, @Header("JD-Date") final String p5, @Header("JD-OpCode") final String p6);
}
