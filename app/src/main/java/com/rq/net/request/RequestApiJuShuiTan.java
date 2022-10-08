package com.rq.net.request;

import java.util.*;
import retrofit2.*;
import com.rq.net.bean.*;
import retrofit2.http.*;

public interface RequestApiJuShuiTan
{
    @POST("api/open/query.aspx")
    Call<JuShuiTanResponseBean> deliverGoods(@Body final List<JuShuiTanRequest> p0, @Query("method") final String p1, @Query("partnerid") final String p2, @Query("token") final String p3, @Query("ts") final int p4, @Query("sign") final String p5);
}
