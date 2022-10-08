package com.rq.net.request;

//import kotlin.*;
import retrofit2.*;
import retrofit2.http.*;
import com.rq.net.bean.*;

public interface RequestApiYshouFa
{
    @Headers({ "Content-Type: application/json" })
    @POST("ant-escrow/warehouse/out/normal")//@POST("ant-escrow/external/warehouse/out/normal")
    Call<YXDHttpCallBack<YXDOrderResBean>> batchsignOrder(@Body final YXDOrderReqBean p0,
                                                          @Header("X-Ca-Sign-Type") final String p1,
                                                          @Header("X-Ca-Nonce") final String p2,
                                                          @Header("X-Ca-Timestamp") final String p3,
                                                          @Header("X-Ca-Signature") final String p4,
                                                          @Header("DeviceType") final String DeviceType,
                                                          @Header("YJY-Auth") final String YJY_Auth,
                                                          @Header("OS_VERSION") final String OS_VERSION,
                                                          @Header("DEVICE_NUM") final String DEVICE_NUM,
                                                          @Header("APP_VERSION") final String APP_VERSION,
                                                          @Header("MOBILE_MODEL") final String MOBILE_MODEL,
                                                          @Header("DIST_CHANNEL") final String DIST_CHANNEL,
                                                          @Header("OPERATE_CANTON") final String OPERATE_CANTON) ;
    //Call<YXDHttpCallBack<YXDOrderResBean>> batchsignOrder(@Body final YXDOrderReqBean p0, @Header("X-Ca-Sign-Type") final String p1, @Header("X-Ca-Nonce") final String p2, @Header("X-Ca-Timestamp") final String p3, @Header("X-Ca-Signature") final String p4, @Header("Authorization") final String p5, @Header("clientId") final String p6);

    @Headers({ "Content-Type: application/json", "devicetype: eshoufa" })
    @POST("send-order/wx/sendorder/batchsignOrder")
    Call<BatchsignOrderResponseBean> faceSheetOutLib(@Body final BatchsignOrderRequestBean p0, @Header("authorization") final String p1, @Header("versionno") final String p2);
    
    @GET("send-order/wx/sendorder/getNeedPayment")
    @Headers({ "Content-Type: application/json", "devicetype: eshoufa" })
    Call<GetNeedPaymentResponseBean> getNeedPayment(@Query("orderId") final String p0, @Header("authorization") final String p1, @Header("versionno") final String p2);
    
    @GET("usersystem/device/version/getDeviceVersion")
    @Headers({ "Content-Type: application/json", "devicetype: eshoufa" })
    Call<BatchsignVersionResponseBean> getVersion(@Query("deviceVersion") final String p0, @Query("deviceType") final String p1, @Header("versionno") final String p2);

    @Headers({ "Content-Type: application/json" })
    @POST("e-uc/oauth/login")
    Call<YXDHttpCallBack<YXDLoginResBean>> login(@Body final YXDLoginBean p0, @Header("X-Ca-Sign-Type") final String p1, @Header("X-Ca-Nonce") final String p2, @Header("X-Ca-Timestamp") final String p3, @Header("X-Ca-Signature") final String p4, @Header("Authorization") final String p5, /*@Header("clientId") final String p6,*/
                                                 @Header("NotNeedToken") final String NotNeedToken, @Header("Connection") final String Connection, @Header("DeviceType") final String DeviceType, @Header("OS_VERSION") final String OS_VERSION,
                                                 @Header("APP_VERSION") final String APP_VERSION,  @Header("DEVICE_NUM") final String DEVICE_NUM,  @Header("MOBILE_MODEL") final String MOBILE_MODEL,
                                                 @Header("DIST_CHANNEL") final String DIST_CHANNEL,
                                                 @Header("Content-Type") final String Content_Type);

    @Headers({ "Content-Type: application/json", "devicetype: eshoufa" })
    @POST("send-order/wx/sendorder/querySendOrder")
    Call<QuerySendOrderResponseBean> querySendOrder(@Body final QuerySendOrderRequestBean p0, @Header("authorization") final String p1, @Header("versionno") final String p2);
    
    @Headers({ "Content-Type: application/json" })
    @POST("e-storage/cos/getCosUploadUrl")
    Call<YXDHttpCallBack<YXDOrderUpPicResBean>> uploadCospublicImage(@Body final YXDOrderUpPicReqBean p0, @Header("X-Ca-Sign-Type") final String p1, @Header("X-Ca-Nonce") final String p2, @Header("X-Ca-Timestamp") final String p3, @Header("X-Ca-Signature") final String p4, @Header("Authorization") final String p5, @Header("clientId") final String p6);
}
