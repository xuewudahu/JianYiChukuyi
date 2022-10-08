package com.rq.net.request;

import okhttp3.*;
import retrofit2.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface RequestApiXbdUploadPicture
{
    @POST("/")
    Call<Object> courSmallPoleUpLoadImg(@Header("token") final String p0, @Body final MultipartBody p1);
}
