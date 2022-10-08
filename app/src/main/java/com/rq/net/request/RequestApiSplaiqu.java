package com.rq.net.request;

import retrofit2.*;
import com.rq.net.bean.*;
import retrofit2.http.*;
import java.util.*;
import com.rq.net.bean.*;

public interface RequestApiSplaiqu
{
    @POST("lq/api/billSearch")
    Call<ApiDataLaiquBean<LaiquCheckBarcodeResponseBean>> laiquCheckBarcode(@Body final LaiquCheckBarcodeBean p0, @Header("Authorization") final String p1, @Header("X-Auth-User") final String p2, @Header("X-Auth-ServiceSite") final String p3);
    
    @POST("lq/api/optionalPickup")
    Call<ApiDataLaiquBean<LaiquOutLibraryResponseBean>> laiquOutLibrary(@Body final LaiquOutLibraryBean p0, @Header("Authorization") final String p1);
    
    @POST("lq/api/batchPhotoPickupGoods")
    Call<ApiDataLaiquBean<List<LaiquOutLibraryResponseBean>>> laiquOutLibraryPicture(@Body final LaiquOutLibraryPictureBean p0, @Header("Authorization") final String p1);
    
    @POST("lq/api/storeGoodsNew")
    Call<ApiDataLaiquBean<LaiquStoreGoodsResponseBean>> laiquStoreGoodsNew(@Body final LaiquStoreGoodsNewBean p0, @Header("Authorization") final String p1);
}
