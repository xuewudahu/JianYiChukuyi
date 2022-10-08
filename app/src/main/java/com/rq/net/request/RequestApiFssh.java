package com.rq.net.request;

import retrofit2.*;
import retrofit2.Call;
import retrofit2.http.*;
import okhttp3.*;
import retrofit2.http.Headers;

import com.rq.net.bean.*;

public interface RequestApiFssh
{
    @Headers({ "Content-Type: application/json" })
    @POST("api/UploadData/EquipmentOutData")
    Call<FsshOutLibraryResponseBean> equipmentOutData(@Body final FsshOutLibraryBodyBean p0);
    
    @POST("api/UploadData/UpdateImageUrl")
    Call<FsshUploadPictureResponseBean> fsshUploadBarcodePicture(@Body final MultipartBody p0);
}
