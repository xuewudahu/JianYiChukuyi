package com.rq.net.request;

import retrofit2.*;
import retrofit2.http.*;
import java.util.*;
import com.rq.net.bean.*;

public interface RequestApiJiTu
{
    @Headers({ "devicefrom: android", "device-version: Android-25", "app-version: 2.0.20", "app-channel: Internal Deliver", "app-platform: Android_com.yunlu.salesman", "Content-Type: application/json; charset=UTF-8" })
    @POST("bc/out/login")
    Call<JiTuResponse> jiTuLogin(@Body final JiTuLoginBean p0);
    
    @Headers({ "devicefrom: android", "device-version: Android-25", "app-version: 2.0.20", "app-channel: Internal Deliver", "app-platform: Android_com.yunlu.salesman", "Content-Type: application/json; charset=UTF-8" })
    @POST("bc/scanList/uploadSigningData")
    Call<JiTuOutLibraryResponse> outLibrary(@Header("authToken") final String p0, @Header("timeepoch") final Long p1, @Body final List<RequestJiTuOutlibrary> p2);
}
