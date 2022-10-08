package com.rq.net.request;

import retrofit2.*;
import okhttp3.*;
import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.Headers;

import com.rq.net.bean.*;

public interface RequestApiJinLinBao
{
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("cabzoo/szoo2/user/login")
    Call<JinLinBaoLoginResponseBean> jinLinBaoLogin(@Field("name") final String p0, @Field("password") final String p1, @Field("sn") final String p2, @Field("check_money") final String p3, @Field("ts") final String p4, @Field("sign_type") final String p5, @Field("sign") final String p6);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("cabzoo/szoo2/user/check_logis_allow")
    Call<JinLinBaoLogin2ResponseBean> jinLinBaoLogin2(@Field("logis_id") final String p0, @Field("ts") final String p1, @Field("sign_type") final String p2, @Field("sign") final String p3);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("cabzoo/szoo2/batch/add")
    Call<jinLinBaoOcrJieBoAddResponseBean> jinLinBaoOcrJieBoBatchAdd(@Field("sign") final String p0, @Field("logis_id") final String p1, @Field("sn") final String p2, @Field("batch_date") final String p3, @Field("ts") final String p4, @Field("sid") final String p5, @Field("seq_no") final String p6, @Field("uid") final String p7, @Field("express_id") final String p8, @Field("sign_type") final String p9);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("cabzoo/szoo2/batch/pre_add")
    Call<jinLinBaoOcrJieBoPreeAddResponseBean> jinLinBaoOcrJieBoBatchPreeAdd(@Field("sign") final String p0, @Field("logis_id") final String p1, @Field("sn") final String p2, @Field("ts") final String p3, @Field("sid") final String p4, @Field("uid") final String p5, @Field("express_id") final String p6, @Field("sign_type") final String p7);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("cabzoo/szoo2/express/list")
    Call<jinLinBaoOcrJieBoExpressListResponseBean> jinLinBaoOcrJieBoExpressList(@Field("sign") final String p0, @Field("logis_id") final String p1, @Field("sn") final String p2, @Field("ts") final String p3, @Field("sid") final String p4, @Field("uid") final String p5, @Field("sign_type") final String p6);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("cabzoo/szoo2/batch/getlist")
    Call<JinLinBaoJieBoBatchListResponseBean> jinLinBaoOcrJieBoGetBatchList(@Field("sign") final String p0, @Field("logis_id") final String p1, @Field("sn") final String p2, @Field("ts") final String p3, @Field("sid") final String p4, @Field("uid") final String p5, @Field("express_id") final String p6, @Field("sign_type") final String p7);
    
    @Multipart
    @POST("horus/scanapp/tranship/submit")
    Call<JinLinBaoJieBoPictureUploadResponseBean> jinLinBaoOcrJieBoPictureUpload(@Query("delivery_mode") final String p0, @Query("sign") final String p1, @Query("logis_id") final String p2, @Query("payment") final String p3, @Query("sn") final String p4, @Query("ts") final String p5, @Query("sid") final String p6, @Query("batch_id") final String p7, @Query("uid") final String p8, @Query("express_id") final String p9, @Query("storage_type") final String p10, @Query("sign_type") final String p11, @Part final MultipartBody.Part p12);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("cabzoo/szoo2/tranship/detail")
    Call<jinLinBaoOcrTranshipDetailResponseBean> jinLinBaoOcrTranshipDetail(@Field("sign") final String p0, @Field("logis_id") final String p1, @Field("sn") final String p2, @Field("exp_code") final String p3, @Field("ts") final String p4, @Field("sid") final String p5, @Field("uid") final String p6, @Field("sign_type") final String p7);
    
    @Multipart
    @POST("cabzoo/szoo2/pickup/manual")
    Call<jinLinBaoPickUpResponseBean> jinLinBaoPickUp(@Query("sign") final String p0, @Query("logis_id") final String p1, @Query("sn") final String p2, @Query("order_id") final String p3, @Query("ts") final String p4, @Query("sid") final String p5, @Query("consignee_phone") final String p6, @Query("uid") final String p7, @Query("sign_type") final String p8, @Part final MultipartBody.Part p9);
    
    @Multipart
    @POST("cabzoo/szoo2/pickup/confirm")
    Call<jinLinBaoPickUpConfirmResponseBean> jinLinBaoPickUpConfirm(@Query("sign") final String p0, @Query("logis_id") final String p1, @Query("sn") final String p2, @Query("order_id") final String p3, @Query("ts") final String p4, @Query("amount") final String p5, @Query("sid") final String p6, @Query("uid") final String p7, @Query("charge_way") final String p8, @Query("note") final String p9, @Query("sign_type") final String p10, @Part final MultipartBody.Part p11);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("cabzoo/assistant/pickup/free_confirm")
    Call<jinLinBaoPickUpFreeConfirmResponseBean> jinLinBaoPickUpFreeConfirm(@Field("sign") final String p0, @Field("logis_id") final String p1, @Field("sn") final String p2, @Field("count") final String p3, @Field("image_data") final String p4, @Field("order_ids") final String p5, @Field("ts") final String p6, @Field("uid") final String p7, @Field("sid") final String p8, @Field("sign_type") final String p9, @Field("courier_uid") final String p10);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("cabzoo/highbeatmeter/pickup/batch_pickup")
    Call<jinLinBaoPickupBatchPickupResponseBean> jinLinBaoPickupBatchPickup(@Field("uid") final String p0, @Field("logis_id") final String p1, @Field("data") final String p2);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("cabzoo/szoo2/pickup/search")
    Call<jinLinBaoPickupSearchResponseBean> jinLinBaoPickupSearch(@Field("sign") final String p0, @Field("logis_id") final String p1, @Field("sn") final String p2, @Field("exp_code") final String p3, @Field("ts") final String p4, @Field("sid") final String p5, @Field("uid") final String p6, @Field("sign_type") final String p7);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded" })
    @POST("cabzoo/assistant/pickup/unpickup")
    Call<jinLinBaoPickupUnPickupResponseBean> jinLinBaoPickupUnPickup(@Field("sign") final String p0, @Field("logis_id") final String p1, @Field("sn") final String p2, @Field("exp_code") final String p3, @Field("ts") final String p4, @Field("sid") final String p5, @Field("psize") final String p6, @Field("uid") final String p7, @Field("page") final String p8, @Field("sign_type") final String p9);
}
