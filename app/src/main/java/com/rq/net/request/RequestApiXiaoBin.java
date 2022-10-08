package com.rq.net.request;

import retrofit2.*;
import okhttp3.*;
import com.rq.net.bean.*;

import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.Headers;

public interface RequestApiXiaoBin
{
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("index.php/api_v1/api.app.login/login?v=240")
    Call<XiaoBinLoginResponseBean> xiaobinLogin(@Field("username") final String p0, @Field("password") final String p1);
    
    @Multipart
    @POST("index.php/api_v1/api.app.station_p2/uploadWaybill")
    Call<XiaoBingUploadResponseBean> xiaobinUploadBarcodePicture(@Query("recipientNo") final String p0, @Query("token") final String p1, @Part final MultipartBody.Part p2);
}
