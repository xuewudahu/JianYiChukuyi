package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import retrofit2.http.*;
import com.rq.net.bean.*;

public interface RequestApiYunDaKDCS
{
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded;charset=utf-8" })
    @POST("appserver/interface.do")
    Call<ApiDataYunDaKDCSBean<String>> yundaKDCSCheckBarcode(@Field("sign_method") final String p0, @Field("req_time") final String p1, @Field("data") final String p2, @Field("action") final String p3, @Field("appver") final String p4, @Field("version") final String p5, @Field("token") final String p6, @Field("sign") final String p7);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded;charset=utf-8" })
    @POST("appserver/interface.do")
    Call<ApiDataYunDaKDCSBean<YunDaKDCSLoginResponseBean>> yundaKDCSLogin(@Field("sign_method") final String p0, @Field("req_time") final String p1, @Field("data") final String p2, @Field("action") final String p3, @Field("appver") final String p4, @Field("version") final String p5, @Field("sign") final String p6);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded;charset=utf-8" })
    @POST("appserver/interface.do")
    Call<ApiDataYunDaKDCSBean<String>> yundaKDCSOutLibrary(@Field("sign_method") final String p0, @Field("req_time") final String p1, @Field("data") final String p2, @Field("action") final String p3, @Field("appver") final String p4, @Field("version") final String p5, @Field("token") final String p6, @Field("sign") final String p7);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded;charset=utf-8" })
    @POST("appserver/interface.do")
    Call<ApiDataYunDaKDCSBean<YunDaKDCSSecretBean>> yundaKDCSRequestSecret(@Field("sign_method") final String p0, @Field("req_time") final String p1, @Field("data") final String p2, @Field("action") final String p3, @Field("token") final String p4, @Field("appver") final String p5, @Field("version") final String p6, @Field("sign") final String p7);
}
