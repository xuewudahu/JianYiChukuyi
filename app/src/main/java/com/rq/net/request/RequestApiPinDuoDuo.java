package com.rq.net.request;

//import kotlin.*;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.*;
import java.util.*;

import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.Headers;

import com.rq.net.bean.*;

public interface RequestApiPinDuoDuo
{
    @GET("api/orion/op/package/mobile")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Referer: Android", "p-appname: DDStore" })
    Call<PinDuoDuoBaseResponseBean> checkNotOutLibraryMuchPackage(@Header("anti-content") final String p0, @Header("ETag") final String p1, @Header("User-Agent") final String p2, @Header("cookie") final String p3, @Header("AccessToken") final String p4, @Query("mobile") final String p5);
    
    @GET("api/orion/op/package/reverse")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Referer: Android", "p-appname: DDStore" })
    Call<PinDuoDuoBaseResponseBean> getDuoDuoRevers(@Header("anti-content") final String p0, @Header("ETag") final String p1, @Header("User-Agent") final String p2, @Header("cookie") final String p3, @Header("AccessToken") final String p4, @Query("package_id") final String p5);
    
    @Headers({ "Content-Type: application/json; charset=utf-8", "Referer: Android" })
    @POST("sixers/api/user/loginByMobile")
    Call<ResponseBody> getLoginByMobile(@Header("verifyauthtoken") final String p0, @Header("anti-content") final String p1, @Header("ETag") final String p2, @Header("User-Agent") final String p3, @Body final PinDuoDuoLoginRequestBean p4);
    
    @Headers({ "Content-Type: application/json; charset=utf-8", "Referer: Android", "p-appname: DDStore" })
    @POST("https://api.pinduoduo.com/api/phantom/obtain_captcha")
    Call<ResponseBody> getObtainCaptcha(@Header("verifyauthtoken") final String p0, @Header("anti-content") final String p1, @Header("ETag") final String p2, @Header("User-Agent") final String p3, @Body final ObtainCaptchaRequestBean p4);
    
    @GET("sixers/api/user/getPasswordPublicKey")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Referer: Android" })
    Call<PinDuoDuoBaseResponseBean> getPasswordPublicKey(@Header("verifyauthtoken") final String p0, @Header("anti-content") final String p1, @Header("ETag") final String p2, @Header("User-Agent") final String p3);
    
    @Headers({ "Content-Type: application/json; charset=utf-8", "Referer: Android" })
    @POST("api/orion/op/cabinet/out/wb")
    Call<ResponseBody> outLibrary(@Header("anti-content") final String p0, @Header("ETag") final String p1, @Header("User-Agent") final String p2, @Header("cookie") final String p3, @Header("AccessToken") final String p4, @Body final PinDuoDuoOutLibraryRequestBean p5);
    
    @Headers({ "Content-Type: application/json; charset=utf-8", "Referer: Android" })
    @POST("api/orion/op/cabinet/out/scan/aio")
    Call<PinDuoDuoBaseResponseBean> outLibraryAio(@Header("anti-content") final String p0, @Header("ETag") final String p1, @Header("User-Agent") final String p2, @Header("cookie") final String p3, @Header("AccessToken") final String p4, @Body final PinDuoDuoOutLibraryRequestBean p5);
    
    @GET("sixers/api/token/refreshToken")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Referer: Android" })
    Call<PinDuoDuoBaseResponseBean> refreshToken(@Header("anti-content") final String p0, @Header("ETag") final String p1, @Header("User-Agent") final String p2, @Header("cookie") final String p3, @Header("AccessToken") final String p4);
    
    @Headers({ "Content-Type: application/json; charset=utf-8", "Referer: Android", "p-appname: DDStore" })
    @POST("api/orion/op/image/save/aio")
    Call<PinDuoDuoBaseResponseBean> saveImageToServerFlag(@Header("anti-content") final String p0, @Header("ETag") final String p1, @Header("User-Agent") final String p2, @Header("cookie") final String p3, @Header("AccessToken") final String p4, @Body final PinDuoDuoSaveImageRequestBean p5);
    
    @Headers({ "Referer: Android", "p-appname: DDStore" })
    @POST("api/orion/op/image/upload/aio")
    Call<PinDuoDuoBaseResponseBean> uploadImg(@Header("anti-content") final String p0, @Header("ETag") final String p1, @Header("User-Agent") final String p2, @Header("cookie") final String p3, @Header("AccessToken") final String p4, @Body final MultipartBody p5);
    
    @Headers({ "Content-Type: application/json; charset=utf-8", "Referer: Android", "p-appname: DDStore" })
    @POST("https://api.pinduoduo.com/api/phantom/user_verify")
    Call<PinDuoDuoBaseResponseBean> userVerify(@Header("verifyauthtoken") final String p0, @Header("anti-content") final String p1, @Header("ETag") final String p2, @Header("User-Agent") final String p3, @Body final UserVerifyRequestBean p4);
}
