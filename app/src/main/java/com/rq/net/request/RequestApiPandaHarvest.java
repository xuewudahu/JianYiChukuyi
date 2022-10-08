package com.rq.net.request;

import java.util.*;
import retrofit2.*;
import retrofit2.http.*;
import com.rq.net.bean.*;

public interface RequestApiPandaHarvest
{
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded;charset=utf-8" })
    @POST("openBmx")
    Call<CameraCheckOutBean<PandToken>> pandaHarvestLogin(@FieldMap final Map<String, String> p0);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded;charset=utf-8" })
    @POST("openBmx")
    Call<PandaOutLibCall> pandaHarvestOutLib(@FieldMap final Map<String, String> p0);
    
    @FormUrlEncoded
    @Headers({ "Content-Type: application/x-www-form-urlencoded;charset=utf-8" })
    @POST("openBmx")
    Call<CameraCheckOutBean> toCameraChectOut(@FieldMap final Map<String, String> p0);
}
