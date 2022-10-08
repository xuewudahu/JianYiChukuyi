package com.rq.net.request;

import retrofit2.*;
import com.google.gson.*;
import com.rq.net.bean.*;
import okhttp3.*;
import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.Headers;

import java.util.*;

public interface RequestApiCourSmallPole
{
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("api/mobile/record/changePullNumThree")
    Call<CourSmallPoleChuKu1> courSmallPoleChuKu1(@Header("token") final String p0, @Field("eid") final String p1, @Field("return_type") final String p2, @Field("ticket_no") final String p3);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("api/mobile/upload/ssmiandan")
    Call<JsonObject> courSmallPoleChuKu1_1(@Header("token") final String p0, @Field("eid") final String p1, @Field("name") final String p2, @Field("return_type") final String p3, @Field("rid") final String p4, @Field("size") final String p5, @Field("stype") final String p6, @Field("ticket_no") final String p7, @Field("type") final String p8);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("api/mobile/upload/ssmiandan")
    Call<JsonObject> courSmallPoleChuKu1_2(@Header("token") final String p0, @Field("eid") final String p1, @Field("name") final String p2, @Field("return_type") final String p3, @Field("size") final String p4, @Field("stype") final String p5, @Field("ticket_no") final String p6, @Field("type") final String p7);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("api/mobile/express/index")
    Call<CompanyListBean> courSmallPoleGetCompanyList(@Header("token") final String p0, @Field("return_type") final String p1);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("api/mobile/auth/login")
    Call<JsonObject> courSmallPoleLogin(@Field("mobile") final String p0, @Field("password") final String p1, @Field("device") final String p2, @Field("return_type") final String p3);
    
    @Headers({ "Content-Type: multipart/form-data; boundary=10f42f9d-a559-49c2-ab49-c5af33330f76" })
    @Multipart
    @POST("/")
    Call<JsonObject> courSmallPoleUpLoadImg(@Header("token") final String p0, @Field("callback") final String p1, @Field("key") final String p2, @Field("OSSAccessKeyId") final String p3, @Field("policy") final String p4, @Field("signature") final String p5, @Part final MultipartBody.Part p6);
    
    @Headers({ "Content-Type: multipart/form-data; boundary=10f42f9d-a559-49c2-ab49-c5af33330f76" })
    @Multipart
    @POST("/")
    Call<JsonObject> courSmallPoleUpLoadImg2(@Header("token") final String p0, @Part final List<MultipartBody.Part> p1);

    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("https://106.kdyxbd.com/api/external/takeout")
    Call<JsonObject> ziCourSmallPoleOutLib(@Field("account") final String p0, @Field("password") final String p1, @Field("ticket_no") final String p2, @Field("version") final String p3);

    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("api/mobile/auth/sublogin")
    Call<JsonObject> ziCourSmallPoleLogin(@Field("account") final String p0, @Field("password") final String p1, @Field("device") final String p2, @Field("return_type") final String p3);
}
