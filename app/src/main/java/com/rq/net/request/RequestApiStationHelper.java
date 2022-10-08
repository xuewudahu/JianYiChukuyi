package com.rq.net.request;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import com.rq.net.bean.*;
import retrofit2.http.Headers;

public interface RequestApiStationHelper
{
    @Headers({ "Content-Type: application/json;charset=UTF-8" })
    @POST("mossapi/mossp.expressj/quickQueryExpressForOutV2")
    Call<StationHelperResponseBarcodeBean> stationHelperCheckBarcode(@Header("Authorication") final String p0, @Body final StationHelperRequestBean p1);

    @Headers({ "Content-Type: application/json;charset=UTF-8" })
    @POST("mossapi/mossp.expressj/takeExpressPackV6")
    Call<StationHelperResponseChuKuBean> stationHelperChuKu(@Header("Authorication") final String p0, @Body final StationHelperRequestChuKuBean p1);

    @Headers({ "Content-Type: application/json;charset=UTF-8" })
    @POST("mossapi/mossp.expressj/ezpcourierLogin")
    Call<ResponseBody> stationHelperLogin(@Body final StationHelperLoginBean p0);
}
