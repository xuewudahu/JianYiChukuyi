package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import java.util.*;
import retrofit2.http.*;
import com.rq.net.bean.*;

public interface RequestApiFcbox
{
    @Headers({ "Content-Type: application/json; charset=UTF-8" })
    @POST("bar/post/signVerify")
    Call<ApiDataFcBoxBean<List<FcboxCheckBarcodeResponseBean>>> fcboxCheckBarcode(@Body final FcboxCheckBarcodeBean p0, @Header("FC_AUTHENTICATED_TOKEN") final String p1, @Header("FC_GRAY_TOKE") final String p2, @Header("Cookie") final String p3);
    
    @POST("bar/noshiro/userInfoGet")
    Call<ApiDataFcBoxBean<FcboxUserInforResponseBean>> fcboxGetUserInfor(@Header("FC_AUTHENTICATED_TOKEN") final String p0);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded", "AuthenticationType: FcBarAppLogin" })
    @POST("bar/passport/login")
    Call<ApiDataFcBoxBean<Object>> fcboxLogin(@Field("encry") final boolean p0, @Field("username") final String p1, @Field("password") final String p2);
    
    @Headers({ "Content-Type: application/json; charset=UTF-8" })
    @POST("bar/accountManage/appLoginLog")
    Call<ApiDataFcBoxBean<Object>> fcboxLoginLog(@Header("FC_AUTHENTICATED_TOKEN") final String p0, @Header("FC_GRAY_TOKE") final String p1, @Header("Cookie") final String p2, @Header("FC_DEVICE_TOKEN") final String p3);
    
    @Headers({ "Content-Type: application/json; charset=UTF-8" })
    @POST("bar/post/queryByMobilePhone")
    Call<ApiDataFcBoxBean<FcboxQueryPackageResponseBean>> fcboxQueryByMobilePhone(@Body final FcboxQueryPackageBean p0, @Header("FC_AUTHENTICATED_TOKEN") final String p1, @Header("FC_GRAY_TOKE") final String p2, @Header("Cookie") final String p3);
    
    @Headers({ "Content-Type: application/json; charset=UTF-8" })
    @POST("bar/accountManage/retrieveServiceManagerServicePoint")
    Call<ApiDataFcBoxBean<List<FcboxServicePointResponseBean>>> fcboxServicePoint(@Body final FcboxServicePointBean p0, @Header("FC_AUTHENTICATED_TOKEN") final String p1, @Header("FC_GRAY_TOKE") final String p2, @Header("Cookie") final String p3);
    
    @Headers({ "Content-Type: application/json; charset=UTF-8" })
    @POST("bar/post/sign")
    Call<ApiDataFcBoxBean<List<FcboxSignResponseBean>>> fcboxSign(@Body final FcboxSignBean p0, @Header("FC_AUTHENTICATED_TOKEN") final String p1, @Header("FC_GRAY_TOKE") final String p2, @Header("Cookie") final String p3);
    
    @Headers({ "Content-Type: application/json; charset=UTF-8" })
    @POST("bar/accountManage/getCurrentPointInfo")
    Call<ApiDataFcBoxBean<FcboxStationInforResponseBean>> fcboxStationInfor(@Header("FC_AUTHENTICATED_TOKEN") final String p0, @Header("FC_GRAY_TOKE") final String p1, @Header("Cookie") final String p2);
}
