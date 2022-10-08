package com.rq.net.request;

//import kotlin.*;
import retrofit2.*;
import com.rq.net.bean.*;
import retrofit2.http.*;

public interface RequestApiHyl
{
    @Headers({ "Content-Type: application/json; charset=UTF-8" })
    @POST("logistics/return_callback")
    Call<HylResponseBean> barcodeUpload(@Body final HylRequestBean p0);
}
