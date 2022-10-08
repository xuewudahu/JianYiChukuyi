package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import retrofit2.http.*;
import java.util.*;
import com.rq.net.bean.*;

public interface RequestApiDeviceManager
{
    @POST("device/auth_code/v2/")
    Call<ApiDataBean<PurchaseAuthCodeV2ResBean<AlipayPayResBean>>> alipayPay(@Body final PurchaseAuthCodeV2ReqBean p0, @Header("Authorization") final String p1);
    
    @PUT("device/auth_code/v2/")
    Call<ApiDataBean<String>> cleanOrder(@Body final CleanOrderReqBean p0, @Header("Authorization") final String p1);
    
    @HTTP(hasBody = true, method = "DELETE", path = "device/cloud/")
    Call<ApiDataBean<String>> deleteDeviceCloudSpace(@Body final DeleteDeviceCloudBean p0, @Header("Authorization") final String p1);
    
    @HTTP(hasBody = true, method = "DELETE", path = "device/auth_code/v2/")
    Call<ApiDataBean<String>> deleteOrder(@Body final DeleteOrderReqBean p0, @Header("Authorization") final String p1);
    
    @POST("device/activation/")
    Call<ApiDataBean<DeviceLoginBean>> deviceActivation(@Body final DeviceActivationBodyBean p0);
    
    @POST("device/login/")
    Call<ApiDataBean<DeviceLoginBean>> deviceLogin(@Body final DeviceLoginBodyBean p0);
    
    @POST("device/usearea/")
    Call<ApiDataBean<DeviceUserareaBean>> deviceUserareaAddress(@Body final DeviceUserareaBodyBean p0);
    
    @GET("verify/smscode/")
    Call<ApiDataBean<String>> getActivationVerificationCode(@Query("mobile") final String p0, @Query("flag") final String p1);
    
    @GET("advertisement/device/{serial_number}/")
    Call<ApiDataBean<List<AdvertisementResponseBean>>> getAdvertisement(@Path("serial_number") final String p0, @Header("Authorization") final String p1);
    
    @GET("device/auth_code/v2/")
    Call<ApiDataBean<AuthorizationStationInfoResBean>> getAuthCodeV2(@Query("sn") final String p0, @Header("Authorization") final String p1);
    
    @GET("device/cloud/")
    Call<ApiDataBean<DeviceCloudResponseBean>> getDeviceCloudSize(@Query("sn") final String p0, @Header("Authorization") final String p1);
    
    @POST("device/state/")
    Call<ApiDataBean<String>> getDeviceOnlineState(@Body final DeviceOnlineState p0, @Header("Authorization") final String p1);
    
    @GET("device/station_package/v2/")
    Call<ApiDataBean<StationPackageV2ResBean>> getStationPackageV2(@Query("sn") final String p0, @Header("Authorization") final String p1);
    
    @POST("device/sts/")
    Call<ApiDataBean<GetStsResponseTokenBean>> getStsToken(@Body final DeviceStsTokenBean p0, @Header("Authorization") final String p1);
    
    @GET("device/trial/")
    Call<ApiDataBean<TrialResponseBean>> getTrial(@Query("sn") final String p0, @Query("order_number") final String p1, @Header("Authorization") final String p2);
    
    @GET("device/trial_getpay/")
    Call<ApiDataBean<Payment<WXPayment>>> getWXTrialGetpay(@Query("order_id") final int p0, @Query("payment_type") final String p1, @Header("Authorization") final String p2);
    
    @GET("device/trial_getpay/")
    Call<ApiDataBean<Payment<ZFBPayment>>> getZFBTrialGetpay(@Query("order_id") final int p0, @Query("payment_type") final String p1, @Header("Authorization") final String p2);
    
    @GET("device/auth_flow/v2/")
    Call<ApiDataBean<List<AuthFlowsBean>>> inspectPayment(@Query("sn") final String p0, @Query("order_number") final String p1, @Header("Authorization") final String p2);
    
    @POST("device/auth_code/v2/")
    Call<ApiDataBean<PurchaseAuthCodeV2ResBean<String>>> purchaseAuthCodeV2(@Body final PurchaseAuthCodeV2ReqBean p0, @Header("Authorization") final String p1);
    
    @GET("device/auth_flow/v2/")
    Call<ApiDataBean<List<AuthFlowsBean>>> purchaseRecord(@Query("sn") final String p0, @Header("Authorization") final String p1);
    
    @POST("user/device/refresh/")
    Call<ApiDataBean<TokenRefreshBean>> tokenRefresh(@Body final TokenRefreshBean p0);
    
    @HTTP(hasBody = true, method = "DELETE", path = "device/trial/")
    Call<ApiDataBean<String>> trialDelete(@Body final TrialtoDelete p0, @Header("Authorization") final String p1);
    
    @PUT("device/trial/")
    Call<ApiDataBean<String>> trialtoVoid(@Body final TrialtoVoid p0, @Header("Authorization") final String p1);
    
    @POST("device/station/")
    Call<ApiDataBean<String>> uploadData(@Body final OutLibraryCensus p0, @Header("Authorization") final String p1);
    
    @POST("device/station/")
    Call<ApiDataBean<String>> uploadDeviceMixType(@Body final DeviceMixTypeBean p0, @Header("Authorization") final String p1);
    
    @POST("device/duration/")
    Call<ApiDataBean<String>> uploadDeviceRuntime(@Body final DeviceRuntimeBean p0, @Header("Authorization") final String p1);
    
    @POST("device/problem/")
    Call<ApiDataBean<String>> uploadPeoblem(@Body final Peoblem p0, @Header("Authorization") final String p1);
    
    @POST("device/auth_code/v2/")
    Call<ApiDataBean<PurchaseAuthCodeV2ResBean<WechatPayResBean>>> wechatPay(@Body final PurchaseAuthCodeV2ReqBean p0, @Header("Authorization") final String p1);
    
    @POST("device/trial/")
    Call<ApiDataBean<Payment<WXPayment>>> wxTrialRenew(@Body final TrialRenew p0, @Header("Authorization") final String p1);
    
    @POST("device/trial/")
    Call<ApiDataBean<Payment<ZFBPayment>>> zfbTrialRenew(@Body final TrialRenew p0, @Header("Authorization") final String p1);
}
