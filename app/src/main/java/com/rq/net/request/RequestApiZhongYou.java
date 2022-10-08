package com.rq.net.request;

import com.rq.net.bean.*;
import retrofit2.http.*;

public interface RequestApiZhongYou
{
    @Headers({ "Content-Type: application/json" })
    @POST("services/deviceCommand/execute")
    void uploadWeightData(@Header("Authorization") final String p0, @Body final DeviceOnlineState p1);
}
