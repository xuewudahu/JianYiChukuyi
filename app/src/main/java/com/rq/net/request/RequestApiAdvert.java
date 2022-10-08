package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import java.util.*;
import com.rq.net.bean.*;
import retrofit2.http.*;

public interface RequestApiAdvert
{
    @GET("advert_info")
    Call<ApiDataBean<List<AdvertInfoBean>>> getAdvertInfo(@Query("c_phone") final String p0);
}
