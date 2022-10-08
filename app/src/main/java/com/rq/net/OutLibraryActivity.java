package com.rq.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Charsets;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.HashFunction;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.Hashing;
import com.google.gson.JsonObject;
import com.kuaidihelp.posthouse.Response.NotOutLibraryResponse;
import com.rq.net.bean.BizBean;
import com.rq.net.bean.BlueShopCookieBean;
import com.rq.net.bean.BlueShopLoginBean;
import com.rq.net.bean.BlueShopLoginRequestBean;
import com.rq.net.bean.CourSmallPoleChuKu1;
import com.rq.net.bean.CourSmallPoleChuKuBean;
import com.rq.net.bean.CourSmallPoleOutLibBean;
import com.rq.net.bean.CourierSmallPoleLogin;
import com.rq.net.bean.CurrentParcel;
import com.rq.net.bean.DataBean;
import com.rq.net.bean.FcboxCheckBarcodeResponseBean;
import com.rq.net.bean.FcboxMuchPackageResponseBean;
import com.rq.net.bean.FcboxQueryPackageBean;
import com.rq.net.bean.FcboxQueryPackageResponseBean;
import com.rq.net.bean.FcboxSignBean;
import com.rq.net.bean.FsshOutLibraryBodyBean;
import com.rq.net.bean.FsshOutLibraryResponseBean;
import com.rq.net.bean.GaoPaiResponse;
import com.rq.net.bean.GaoPaiYiRequest;
import com.rq.net.bean.JiTuOutLibraryResponse;
import com.rq.net.bean.JiTuResponse;
import com.rq.net.bean.JinLinBaoJieBoPictureUploadResponseBean;
import com.rq.net.bean.JinLinBaoLoginResponseBean;
import com.rq.net.bean.JuShuiTanRequest;
import com.rq.net.bean.JuShuiTanResponseBean;
import com.rq.net.bean.KDCSCheckOutLibraryBillCodeInforBean;
import com.rq.net.bean.KDCSCheckResponseBean;
import com.rq.net.bean.KDCSOutLibraryData;
import com.rq.net.bean.KDCSQueryStaffAndStoreResponseBean;
import com.rq.net.bean.KuaiBaoDeliveryStorageBean;
import com.rq.net.bean.KuaiBaoGetUserUnPickUpListsBean;
import com.rq.net.bean.KuaiBaoGetUserUnPickUpListsResponseBean;
import com.rq.net.bean.KuaiBaoQueryBillcodeInforBean;
import com.rq.net.bean.KuaiBaoQueryBillcodeInforResponseBean;
import com.rq.net.bean.LaiquOutLibraryBean;
import com.rq.net.bean.LaiquOutLibraryResponseBean;
import com.rq.net.bean.LoginResponseBean;
import com.rq.net.bean.LoginResponseDataBean;
import com.rq.net.bean.MSwmsReq;
import com.rq.net.bean.MaMaCheckExpressCompanyResponseBean;
import com.rq.net.bean.MaMaCheckInforBean;
import com.rq.net.bean.MaMaLoginResponseBean;
import com.rq.net.bean.MaMaNoOutLibraryResponseBean;
import com.rq.net.bean.MaMaOutLibraryBean;
import com.rq.net.bean.MaMaQueryBarcodeBean;
import com.rq.net.bean.MaMaQueryBarcodeResponseBean;
import com.rq.net.bean.MiaoZhanBean;
import com.rq.net.bean.MiaoZhanLoginBean;
import com.rq.net.bean.NetManagerLoginBean;
import com.rq.net.bean.OffStorageResponseBean;
import com.rq.net.bean.PackageBean;
import com.rq.net.bean.PackageDataBean;
import com.rq.net.bean.PandaBeanKt;
import com.rq.net.bean.PandaOutData;
import com.rq.net.bean.PandaOutLibCall;
import com.rq.net.bean.PinDuoDuoBaseResponseBean;
import com.rq.net.bean.PubkeyAndCookie;
import com.rq.net.bean.QueryBarCodeBean;
import com.rq.net.bean.Ref;
import com.rq.net.bean.RequestJiTuOutlibrary;
import com.rq.net.bean.ResponseChenZhongDdengJi;
import com.rq.net.bean.ResultData;
import com.rq.net.bean.ResultDataBean;
import com.rq.net.bean.SatgeChuKu1;
import com.rq.net.bean.ScanBarcodeBeanIn;
import com.rq.net.bean.ShowMuchPackageNoPickBean;
import com.rq.net.bean.StageLoginRequestBean;
import com.rq.net.bean.StationHelperRequestBean;
import com.rq.net.bean.StationHelperRequestChuKuBean;
import com.rq.net.bean.StationHelperResponseBarcodeBean;
import com.rq.net.bean.StationHelperResponseChuKuBean;
import com.rq.net.bean.SuDiYiResponseBean;
import com.rq.net.bean.XiNiaoGaoPaiLoginBean;
import com.rq.net.bean.XiaoBinLoginResponseBean;
import com.rq.net.bean.XiaoBingUploadResponseBean;
import com.rq.net.bean.XingHuoNotOutLibrary;
import com.rq.net.bean.XingHuoOutLibrary;
import com.rq.net.bean.XingHuoOutLibraryReponse;
import com.rq.net.bean.YunDaKDCSLoginResponseBean;
import com.rq.net.bean.YunDaKDCSUploadBean;
import com.rq.net.bean.YunDaNewKDCSCheckResponseBean;
import com.rq.net.bean.YunDaNewKDCSNoPicketResponseBean;
import com.rq.net.bean.ZhongYouUploadWeightResponseBean;
import com.rq.net.bean.jinLinBaoOcrTranshipDetailResponseBean;
import com.rq.net.bean.jinLinBaoPickUpFreeConfirmResponseBean;
import com.rq.net.bean.jinLinBaoPickUpResponseBean;
import com.rq.net.bean.jinLinBaoPickupBatchPickupResponseBean;
import com.rq.net.bean.jinLinBaoPickupSearchResponseBean;
import com.rq.net.bean.jinLinBaoPickupUnPickupResponseBean;
import com.rq.net.manager.FragmentViewManager;
import com.rq.net.manager.MixScanMamager;
import com.rq.net.manager.OkHttpPinDuoDuoManager;
import com.rq.net.manager.OkhttpManager;
import com.rq.net.manager.OkhttpMoxiManager;
import com.rq.net.manager.SoundManager;
import com.rq.net.setting.RqFilePreference;
import com.rq.net.util.Base64Util;
import com.rq.net.util.DateUtil;
import com.rq.net.util.ExpressStationEnum;
import com.rq.net.util.ImageSaveUtil;
import com.rq.net.util.Intrinsics;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.MD5Util;
import com.rq.net.util.Md5InputStream;
import com.rq.net.util.StringUtil;
import com.rq.net.util.SystemUtil;
import com.rq.net.util.ToastSoundUtil;
import com.kuaidihelp.posthouse.R;

import org.json.JSONException;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OutLibraryActivity extends AppCompatActivity implements MixScanMamager.OkhttpCallbackStationManager{

    EditText barcode = null;
    TextView tips = null;
    boolean isShowMuchPackage = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outlib);
        barcode = findViewById(R.id.barcode);
        tips = findViewById(R.id.tips);
        findViewById(R.id.outlib).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String barcodeToOutLib = barcode.getText().toString();
                if (MyApplication.getStationEnum() == ExpressStationEnum.DUODUOYIZHAN) {
                    duoduoOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.KUAIBAO) {
                    kuaibaoUnpack(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.STATIONHELPER){
                    stationHelperOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.LAIQU){
                    laiquQuery(barcodeToOutLib);
                } else if(MyApplication.getStationEnum() == ExpressStationEnum.KUAIDICAOSHI){
                    tuxikdcsQueryAndOutLib(barcodeToOutLib,false);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.JITU) {
                    jituOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.COURIERSMALLPOLE) {
                    courSmailPoleOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.STAGESMALLPOLE) {
                    yizhanxiaobiandaOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.PANDAHARVEST) {
                    uploadOutLibrary(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.MOXIGUANJIA){
                    moxiOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.YUNDAKDCS) {
                    yundachaoshiCheckAndOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.ZHONGYOUSTATION) {
                    zhongyouStationQueryAndOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.ZYZT) {
                    zyytUploadOutLibrary(barcodeToOutLib,null);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.MAMASTATION) {
                    mamayizhanQueryBarcodeAndOutLib(barcodeToOutLib,false);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.BLUESHOP) {
                    landianCheckBarcodeAndOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.FENGCHAOSERVICE) {
                    fengchaoOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.FENSHISHENGHUO) {
                    fsshUploadOutLibrary(barcodeToOutLib,null);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.GUOGUOYIZHAN) {
                    guoguoyizhanUploadOutLibrary(barcodeToOutLib,null);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOGAOPAIYI){
                    jinlinbaoGaopaiyiOutLib(barcodeToOutLib,"","");
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOOCRJIEBO){
                    jinlinbaoOcrjieboInLibrary(barcodeToOutLib,"","",null);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOQIANSHOU){
                    jinlinbaoQianshouOutLibrary(barcodeToOutLib,null);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.JINLINBAOKUAIDIQUJIAN){
                    jinlinbaoKuaidiqujianOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.SUDIYIGONGPEI) {
                    sudiyiOutLib(barcodeToOutLib,null,null);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.JUSHUITAN) {
                    jushuitanOutLib(barcodeToOutLib,"1.0");
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.XINGHUO) {
                    xinghuoOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.XINIAOGAOPAIYI) {
                    xiniaogaopaiyiOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.XIAOBINGSTATION) {
                    uploadOutLibrary(barcodeToOutLib,null,null);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.NETMANAGER) {
                    jikeyunOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.MIAOZHAN) {
                    miaozhanOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.MSWMS) {
                    misengOutLib(barcodeToOutLib);
                } else if (MyApplication.getStationEnum() == ExpressStationEnum.ZHONGYOUCHENGZHONG) {
                    zhongyouOutLib(barcodeToOutLib,null);
                }
            }
        });

        findViewById(R.id.queryLib).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String barcodeToQuery = barcode.getText().toString();
                if (MyApplication.getStationEnum() == ExpressStationEnum.STATIONHELPER) {
                    stationHelperQuery(barcodeToQuery);
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.LAIQU) {
                    laiquQuery(barcodeToQuery);
                } else if(MyApplication.getStationEnum() == ExpressStationEnum.KUAIDICAOSHI){
                    tuxikdcsQueryAndOutLib(barcodeToQuery,true);
                }else if (MyApplication.getStationEnum() == ExpressStationEnum.MAMASTATION) {
                    mamayizhanQueryBarcodeAndOutLib(barcodeToQuery,true);
                }
            }
        });
    }


    private void duoduoOutLib(String barcode){
        OkHttpPinDuoDuoManager.outLibraryAio(OutLibraryActivity.this, barcode, new OkHttpPinDuoDuoManager.OnHttpCallback() {
            @Override
            public void onError(int var1, String var2) {
                Log.d(LoginActivity.TAG, "outLibrary onError: ===var1="+var1+" var2="+var2);
                ToastSoundUtil.displayToast("outLibrary error===");
                tips.setText("out lib error, error message:"+var2);
            }

            @Override
            public void onSuccess(Object var1) {
                PinDuoDuoBaseResponseBean pddbr = (PinDuoDuoBaseResponseBean)var1;
                Log.d(LoginActivity.TAG, "outLibrary onSuccess pddbr ="+pddbr);
                tips.setText("out lib success,result:"+pddbr.getResult().toString());
            }
        });
    }


    private void kuaibaoOutLib(KuaiBaoDeliveryStorageBean var2){
        OkhttpManager.kuaibaoDeliveryStorageApi((KuaiBaoDeliveryStorageBean)var2, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(Object var1) {
                MixScanMamager.OkhttpCallbackStationManager var2 = OutLibraryActivity.this;
                if (var2 != null) {
                    var2.onOkhttpOutLibrarySuccess(ExpressStationEnum.KUAIBAO, "出库成功");
                }
            }
        }));
    }

    private void kuaibaoUnpack(String barcode){
        KuaiBaoQueryBillcodeInforBean var12 = new KuaiBaoQueryBillcodeInforBean();
        var12.setData(JsonUtil.getJsonStringByGson(new KuaiBaoQueryBillcodeInforBean.BillcodeInforData("1", "1", barcode, "")));
        OkhttpManager.kuaibaoQueryBillcodeInforApi(var12, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(final KuaiBaoQueryBillcodeInforResponseBean var1x) {
                if (var1x != null && StringUtil.isNotEmpty(var1x.getWaybillNo())) {
                    /*WeakReference var2 = MixScanMamager.this.getReferenceContext();
                    Context var3;
                    if (var2 != null) {
                        var3 = (Context)var2.get();
                    } else {
                        var3 = null;
                    }*/

                    //if (var3 != null) {
                        //((BaseActivity)var3).saveData(var1x.getWaybillNo(), var1x.getBrand_cn(), ExpressStationEnum.KUAIBAO.getTitle(), var1x.getPhone());
                    KuaiBaoGetUserUnPickUpListsBean var4 = new KuaiBaoGetUserUnPickUpListsBean();
                    var4.setData(JsonUtil.getJsonStringByGson(new com.rq.net.bean.KuaiBaoGetUserUnPickUpListsBean.DataBean(var1x.getWaybillNo(), var1x.getPhone())));
                    OkhttpManager.kuaibaoGetUserUnPickUpListsApi(var4, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                        public final void onSuccess(KuaiBaoGetUserUnPickUpListsResponseBean var1xx) {
                            label66: {
                                Exception var10000;
                                label65: {
                                    Object var12;
                                    boolean var10001;
                                    try {
                                        //////Intrinsics.checkExpressionValueIsNotNull(var1xx, "it");
                                        String var2 = JsonUtil.getJsonStringByGson(var1xx.getResult());
                                        if (var1xx.getNum() <= 1 || !StringUtil.isNotEmpty(var1xx.getResult().toString())) {
                                            break label66;
                                        }

                                        var12 = JsonUtil.getClazzByGson(var2, KuaiBaoGetUserUnPickUpListsResponseBean.ResultBean.class);
                                    } catch (Exception var11) {
                                        var10000 = var11;
                                        var10001 = false;
                                        break label65;
                                    }

                                    if (var12 != null) {
                                        label69: {
                                            ArrayList var13;
                                            Iterator var17;
                                            try {
                                                ArrayList var16 = (ArrayList)var12;
                                                var13 = new ArrayList();
                                                var17 = var16.iterator();
                                            } catch (Exception var9) {
                                                var10000 = var9;
                                                var10001 = false;
                                                break label69;
                                            }

                                            while(true) {
                                                try {
                                                    if (!var17.hasNext()) {
                                                        break;
                                                    }

                                                    KuaiBaoGetUserUnPickUpListsResponseBean.ResultBean var3 = (KuaiBaoGetUserUnPickUpListsResponseBean.ResultBean)var17.next();
                                                    //////Intrinsics.checkExpressionValueIsNotNull(var3, "resultBean");
                                                    if (!var3.getWaybill_no().equals(barcode)) {
                                                        ShowMuchPackageNoPickBean var4 = new ShowMuchPackageNoPickBean();
                                                        var4.setBarcode(var3.getWaybill_no());
                                                        var4.setPickUpCode(var3.getPickup_code());
                                                        var4.setInStorageTime(var3.getCreated_time());
                                                        var13.add(var4);
                                                    }
                                                } catch (Exception var10) {
                                                    var10000 = var10;
                                                    var10001 = false;
                                                    break label69;
                                                }
                                            }

                                            MixScanMamager.OkhttpCallbackStationManager var18;
                                            try {
                                                if (var13.size() <= 0) {
                                                    break label66;
                                                }

                                                var18 = OutLibraryActivity.this;
                                            } catch (Exception var8) {
                                                var10000 = var8;
                                                var10001 = false;
                                                break label69;
                                            }

                                            if (var18 == null) {
                                                break label66;
                                            }

                                            try {
                                                var18.onOkhttpMuchPackageShow((List)var13);
                                                break label66;
                                            } catch (Exception var7) {
                                                var10000 = var7;
                                                var10001 = false;
                                            }
                                        }
                                    } else {
//                                                try {
//                                                //    throw new Exception("null cannot be cast to non-null type kotlin.collections.ArrayList<com.rq.net.bean.KuaiBaoGetUserUnPickUpListsResponseBean.ResultBean> /* = java.util.ArrayList<com.rq.net.bean.KuaiBaoGetUserUnPickUpListsResponseBean.ResultBean> */");
//                                                } catch (Exception var6) {
//                                                    var10000 = var6;
//                                                    var10001 = false;
//                                                }
                                    }
                                }

                                   /* Exception var14 = var10000;
                                    var14.printStackTrace();*/
                            }
                            KuaiBaoDeliveryStorageBean var15 = new KuaiBaoDeliveryStorageBean();
                            HashMap var19 = new HashMap();
                            Map var20 = (Map)var19;
                            String var21 = var1x.getWaybillNo();
                            //////Intrinsics.checkExpressionValueIsNotNull(var21, "data.waybillNo");
                            String var5 = DateUtil.getCurrentDateTime();
                            //////Intrinsics.checkExpressionValueIsNotNull(var5, "DateUtil.getCurrentDateTime()");
                            var20.put(var21, var5);
                            var15.setData(JsonUtil.getJsonStringByGson(new com.rq.net.bean.KuaiBaoDeliveryStorageBean.DataBean(JsonUtil.getJsonStringByGson(var19), var1x.getPhone(), "1", var1x.getBrand(), var1x.getWaybillNo())));
                            ////XLog.d(MixScanMamager.this.getTAG(), "==快宝出库查询===============");
                            kuaibaoOutLib(var15);
                        }

                        // $FF: synthetic method
                        // $FF: bridge method
                        public void onSuccess(Object var1xx) {
                            this.onSuccess((KuaiBaoGetUserUnPickUpListsResponseBean)var1xx);
                        }
                    }));
                    /*} else {
                        //throw new Exception("null cannot be cast to non-null type com.kuaidihelp.posthouse.activity.BaseActivity");
                    }*/
                }
            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1x) {
                this.onSuccess((KuaiBaoQueryBillcodeInforResponseBean)var1x);
            }
        }));
    }


    public void stationHelperOutLib(String barcode){
        StationHelperRequestChuKuBean chuKuBean = new StationHelperRequestChuKuBean(
                RqFilePreference.getInstance().getStationHelperLoginInfor().getUserId(),
                barcode);
        OkhttpManager.stationHelperUploadOutLibrary(RqFilePreference.getInstance().getStationHelperLoginInfor().getAuthorication(), chuKuBean, new OkhttpManager.OnOkhttpCallback() {
            @Override
            public void onSuccess(Object p0) {
                if (p0 instanceof StationHelperResponseChuKuBean){
                    StationHelperResponseChuKuBean stationHelperResponseChuKuBean = (StationHelperResponseChuKuBean)p0;
                    Log.e(LoginActivity.TAG,"result getErrMsg:"+stationHelperResponseChuKuBean.getErrMsg()+"/getRetCode:"+stationHelperResponseChuKuBean.getRetCode()
                            +"/getExpressPackInfo:"+stationHelperResponseChuKuBean.getExpressPackInfo().toString()+"/getMergeOutExpressInfoLst().size"
                            +stationHelperResponseChuKuBean.getMergeOutExpressInfoLst().size());
                    ToastSoundUtil.scanSuccessToast(barcode+" out lib success!");
                } else {
                    ToastSoundUtil.wrongSoundToast(barcode+" return data format error!");
                }
            }
        });
    }

    public void stationHelperQuery(String barcode){
        StationHelperRequestBean queryBean = new StationHelperRequestBean(
                RqFilePreference.getInstance().getStationHelperLoginInfor().getUserId(),
                RqFilePreference.getInstance().getStationHelperLoginInfor().getPhoneNum());
        OkhttpManager.stationHelperBarCode(RqFilePreference.getInstance().getStationHelperLoginInfor().getAuthorication(), queryBean, new OkhttpManager.OnOkhttpCallback() {
            @Override
            public void onSuccess(Object p0) {
                if (p0 instanceof StationHelperResponseBarcodeBean){
                    StationHelperResponseBarcodeBean stationHelperResponseBean = (StationHelperResponseBarcodeBean)p0;
                    Log.e(LoginActivity.TAG,"result getErrMsg:"+stationHelperResponseBean.getErrMsg()+"/getRetCode:"+stationHelperResponseBean.getRetCode()
                            +"/getExpressPackInfo:"+stationHelperResponseBean.getExpressPackLst().toString()+"/getMergeOutExpressInfoLst().size");
                    ToastSoundUtil.scanSuccessToast(barcode+" out query success!");
                }
            }
        });
    }


    public void laiquQuery(String barcode){
        LaiquOutLibraryBean var25 = new LaiquOutLibraryBean();
        var25.setBillCode(barcode);
        OkhttpManager.laiquOutLibrary(var25, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(LaiquOutLibraryResponseBean var1) {
                if (var1 != null) {
                    Exception var10000;
                    label92: {
                        boolean var10001;
                        label87: {
                            MixScanMamager.OkhttpCallbackStationManager var2 = OutLibraryActivity.this;

                            if (var2 != null) {
                                try {
                                    var2.onOkhttpOutLibrarySuccess(ExpressStationEnum.LAIQU, "出库成功");
                                } catch (Exception var14) {
                                    var10000 = var14;
                                    var10001 = false;
                                    break label92;
                                }
                            }
                        }


                        if (true) {
                            label94: {
                                Iterator var16;
                                ArrayList var24;
                                try {
                                    //BaseActivity var22 = (BaseActivity)var20;
                                    Object var3 = var1.getGoodsList().get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var3, "data.goodsList[0]");
                                    String var21 = ((LaiquOutLibraryResponseBean.GoodsListBean)var3).getBillCode();
                                    Object var4 = var1.getGoodsList().get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var4, "data.goodsList[0]");
                                    String var25 = ((LaiquOutLibraryResponseBean.GoodsListBean)var4).getExpressCompanyCode();
                                    String var5 = ExpressStationEnum.LAIQU.getTitle();
                                    Object var6 = var1.getGoodsList().get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var6, "data.goodsList[0]");
                                    //var22.saveData(var21, var25, var5, ((LaiquOutLibraryResponseBean.GoodsListBean)var6).getReceiverPhone());
                                    var24 = new ArrayList();
                                    var16 = var1.getWaybillsRelated().iterator();
                                } catch (Exception var10) {
                                    var10000 = var10;
                                    var10001 = false;
                                    break label94;
                                }

                                while(true) {
                                    try {
                                        if (!var16.hasNext()) {
                                            break;
                                        }

                                        LaiquOutLibraryResponseBean.WaybillsRelatedBean var23 = (LaiquOutLibraryResponseBean.WaybillsRelatedBean)var16.next();
                                        ShowMuchPackageNoPickBean var26 = new ShowMuchPackageNoPickBean();
                                        ////Intrinsics.checkExpressionValueIsNotNull(var23, "resultBean");
                                        var26.setBarcode(var23.getBillCode());
                                        var26.setPickUpCode(var23.getGoodsNumber());
                                        var26.setInStorageTime(DateUtil.getDateTimeFromMillis(var23.getInstorageTime()));
                                        var26.setReceviePerson(var23.getReceiverName());
                                        var24.add(var26);
                                    } catch (Exception var11) {
                                        var10000 = var11;
                                        var10001 = false;
                                        break label94;
                                    }
                                }

                                MixScanMamager.OkhttpCallbackStationManager var17;
                                try {
                                    if (var24.size() <= 0) {
                                        return;
                                    }

                                    var17 = OutLibraryActivity.this;
                                } catch (Exception var9) {
                                    var10000 = var9;
                                    var10001 = false;
                                    break label94;
                                }

                                if (var17 == null) {
                                    return;
                                }

                                try {
                                    var17.onOkhttpMuchPackageShow((List)var24);
                                    return;
                                } catch (Exception var7) {
                                    var10000 = var7;
                                    var10001 = false;
                                }
                            }
                        } else {
                            try {
                                throw new Exception("null cannot be cast to non-null type com.kuaidihelp.posthouse.activity.BaseActivity");
                            } catch (Exception var8) {
                                var10000 = var8;
                                var10001 = false;
                            }
                        }
                    }

                    Exception var18 = var10000;
                    var18.printStackTrace();
                }

            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((LaiquOutLibraryResponseBean)var1);
            }
        }));
    }

    public void laiquOutLib(String barcode){
        LaiquOutLibraryBean var25 = new LaiquOutLibraryBean();
        var25.setBillCode(barcode);
        OkhttpManager.laiquOutLibrary(var25, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(LaiquOutLibraryResponseBean var1) {
                if (var1 != null) {
                    Exception var10000;
                    label92: {
                        boolean var10001;
                        label87: {
                            MixScanMamager.OkhttpCallbackStationManager var2 = OutLibraryActivity.this;


                            if (var2 != null) {
                                try {
                                    var2.onOkhttpOutLibrarySuccess(ExpressStationEnum.LAIQU, "出库成功");
                                } catch (Exception var14) {
                                    var10000 = var14;
                                    var10001 = false;
                                    break label92;
                                }
                            }
                        }



                        if (true) {
                            label94: {
                                Iterator var16;
                                ArrayList var24;
                                try {
                                    //BaseActivity var22 = (BaseActivity)var20;
                                    Object var3 = var1.getGoodsList().get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var3, "data.goodsList[0]");
                                    String var21 = ((LaiquOutLibraryResponseBean.GoodsListBean)var3).getBillCode();
                                    Object var4 = var1.getGoodsList().get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var4, "data.goodsList[0]");
                                    String var25 = ((LaiquOutLibraryResponseBean.GoodsListBean)var4).getExpressCompanyCode();
                                    String var5 = ExpressStationEnum.LAIQU.getTitle();
                                    Object var6 = var1.getGoodsList().get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var6, "data.goodsList[0]");
                                    //var22.saveData(var21, var25, var5, ((LaiquOutLibraryResponseBean.GoodsListBean)var6).getReceiverPhone());
                                    var24 = new ArrayList();
                                    var16 = var1.getWaybillsRelated().iterator();
                                } catch (Exception var10) {
                                    var10000 = var10;
                                    var10001 = false;
                                    break label94;
                                }

                                while(true) {
                                    try {
                                        if (!var16.hasNext()) {
                                            break;
                                        }

                                        LaiquOutLibraryResponseBean.WaybillsRelatedBean var23 = (LaiquOutLibraryResponseBean.WaybillsRelatedBean)var16.next();
                                        ShowMuchPackageNoPickBean var26 = new ShowMuchPackageNoPickBean();
                                        ////Intrinsics.checkExpressionValueIsNotNull(var23, "resultBean");
                                        var26.setBarcode(var23.getBillCode());
                                        var26.setPickUpCode(var23.getGoodsNumber());
                                        var26.setInStorageTime(DateUtil.getDateTimeFromMillis(var23.getInstorageTime()));
                                        var26.setReceviePerson(var23.getReceiverName());
                                        var24.add(var26);
                                    } catch (Exception var11) {
                                        var10000 = var11;
                                        var10001 = false;
                                        break label94;
                                    }
                                }

                                MixScanMamager.OkhttpCallbackStationManager var17;
                                try {
                                    if (var24.size() <= 0) {
                                        return;
                                    }

                                    var17 = OutLibraryActivity.this;
                                } catch (Exception var9) {
                                    var10000 = var9;
                                    var10001 = false;
                                    break label94;
                                }

                                if (var17 == null) {
                                    return;
                                }

                                try {
                                    var17.onOkhttpMuchPackageShow((List)var24);
                                    return;
                                } catch (Exception var7) {
                                    var10000 = var7;
                                    var10001 = false;
                                }
                            }
                        } else {
                            try {
                                throw new Exception("null cannot be cast to non-null type com.kuaidihelp.posthouse.activity.BaseActivity");
                            } catch (Exception var8) {
                                var10000 = var8;
                                var10001 = false;
                            }
                        }
                    }

                    Exception var18 = var10000;
                    var18.printStackTrace();
                }

            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((LaiquOutLibraryResponseBean)var1);
            }
        }));
    }

    /*=============================kuaidichaoshi===========================*/
    private KDCSCheckResponseBean kdcsCheckResponseBean = null;
    private KDCSQueryStaffAndStoreResponseBean staffAndStore;
    private KDCSQueryStaffAndStoreResponseBean storeResponseBean;
    private void tuxikdcsQueryAndOutLib(String barcode,boolean queryOnly){
        ////Intrinsics.checkExpressionValueIsNotNull(var16, "RqFilePreference.getInstance()");
        KDCSQueryStaffAndStoreResponseBean var18 = RqFilePreference.getInstance().getKDCSQueryStaffAndStore();
        if (var18 != null && StringUtil.isNotEmpty(var18.getDepotCode())) {
            KDCSCheckOutLibraryBillCodeInforBean var11 = new KDCSCheckOutLibraryBillCodeInforBean();
            var11.setBillCode(barcode);
            var11.setDepotCode(var18.getDepotCode());
            var11.setCompanyCode((String)null);
            OkhttpManager.kdcsCheckGatwwayBillcodeInfor(var11, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                public final void onSuccess(KDCSCheckResponseBean var1x) {
                    if (var1x != null) {
                        ArrayList var2 = new ArrayList();
                        Iterator var3;
                        KDCSCheckResponseBean.Items var4;
                        ShowMuchPackageNoPickBean var5;
                        if (var1x.getItems() != null && var1x.getItems().size() > 0) {
                            var3 = var1x.getItems().iterator();

                            while(var3.hasNext()) {
                                var4 = (KDCSCheckResponseBean.Items)var3.next();
                                ////Intrinsics.checkExpressionValueIsNotNull(var4, "waybillsRelated");
                                if (!var4.getBillCode().equals(barcode)) {
                                    var5 = new ShowMuchPackageNoPickBean();
                                    var5.setBarcode(var4.getBillCode());
                                    var5.setPhone(var4.getReceiveManMobile());
                                    var5.setPickUpCode(var4.getTakeCode());
                                    var5.setReceviePerson(var4.getReceiveMan());
                                    var2.add(var5);
                                }
                            }
                        }

                        if (var1x.getSuspectedItems() != null && var1x.getSuspectedItems().size() > 0) {
                            var3 = var1x.getSuspectedItems().iterator();

                            while(var3.hasNext()) {
                                var4 = (KDCSCheckResponseBean.Items)var3.next();
                                ////Intrinsics.checkExpressionValueIsNotNull(var4, "item");
                                if (!var4.getBillCode().equals(barcode)) {
                                    var5 = new ShowMuchPackageNoPickBean();
                                    var5.setBarcode(var4.getBillCode());
                                    var5.setPickUpCode(var4.getTakeCode());
                                    var5.setInStorageTime(var4.getReceiveManMobile());
                                    var5.setReceviePerson(var4.getReceiveMan());
                                    var2.add(var5);
                                }
                            }
                        }

                        if (var2.size() > 0) {
                            MixScanMamager.OkhttpCallbackStationManager var6 = OutLibraryActivity.this;
                            if (var6 != null) {
                                var6.onOkhttpMuchPackageShow((List)var2);
                            }
                        }
                    }
                    kdcsCheckResponseBean = var1x;
                    if (!queryOnly) {
                        tuxikdcsOutLibOnly(kdcsCheckResponseBean);
                    }
                }

                // $FF: synthetic method
                // $FF: bridge method
                public void onSuccess(Object var1x) {
                    this.onSuccess((KDCSCheckResponseBean)var1x);
                }
            }));
        }
    }

    public void tuxikdcsOutLibOnly(KDCSCheckResponseBean var2){
        Exception var10000;
        boolean var10001;
        if (var2 != null) {
            label190: {
                KDCSCheckResponseBean var41;
                try {
                    var41 = (KDCSCheckResponseBean)var2;
                } catch (Exception var22) {
                    var10000 = var22;
                    var10001 = false;
                    break label190;
                }

                List var29;
                if (var41 != null) {
                    try {
                        var29 = var41.getItems();
                    } catch (Exception var21) {
                        var10000 = var21;
                        var10001 = false;
                        break label190;
                    }
                } else {
                    var29 = null;
                }

                if (var29 == null) {
                    return;
                }

                KDCSOutLibraryData var28;
                RqFilePreference var31;
                try {
                    var28 = new KDCSOutLibraryData();
                    if (this.staffAndStore == null) {
                        var31 = RqFilePreference.getInstance();
                        ////Intrinsics.checkExpressionValueIsNotNull(var31, "RqFilePreference.getInstance()");
                        this.staffAndStore = var31.getKDCSQueryStaffAndStore();
                    }
                } catch (Exception var19) {
                    var10000 = var19;
                    var10001 = false;
                    break label190;
                }

                try {
                    if (this.storeResponseBean == null) {
                        var31 = RqFilePreference.getInstance();
                        ////Intrinsics.checkExpressionValueIsNotNull(var31, "RqFilePreference.getInstance()");
                        this.storeResponseBean = var31.getKDCSQueryStaffAndStore();
                    }
                } catch (Exception var18) {
                    var10000 = var18;
                    var10001 = false;
                    break label190;
                }

                label191:
                {
                    KDCSQueryStaffAndStoreResponseBean var37;
                    KDCSOutLibraryData.OutLibraryData var42;
                    KDCSCheckResponseBean.Items var43;
                    try {
                        Iterator var34 = var41.getItems().iterator();
                        if (!var34.hasNext()) {
                            break label191;
                        }

                        var43 = (KDCSCheckResponseBean.Items) var34.next();
                        var42 = new KDCSOutLibraryData.OutLibraryData();
                        ////Intrinsics.checkExpressionValueIsNotNull(var43, "item");
                        var42.setBillCode(var43.getBillCode());
                        var42.setBillCodeScanTime((String) null);
                        var42.setCourierCode((String) null);
                        var42.setCourierExpCompanyCode((String) null);
                        var42.setTakeCode(var43.getTakeCode());
                        var37 = this.staffAndStore;
                    } catch (Exception var17) {
                        var10000 = var17;
                        var10001 = false;
                        break label190;
                    }


                    try {
                        var42.setDepotCode(var37.getDepotCode());
                        var42.setEdiUdf2("UNKNOW");
                        var42.setEdiUdf3("");
                        var42.setExpressComapnyCode(var43.getExpressCompanyCode());
                        var37 = this.storeResponseBean;
                    } catch (Exception var15) {
                        var10000 = var15;
                        var10001 = false;
                        break label190;
                    }

                    if (var37 == null) {
                        try {
                            //Intrinsics.throwNpe();
                        } catch (Exception var14) {
                            var10000 = var14;
                            var10001 = false;
                            break label190;
                        }
                    }

                    WeakReference var49;
                    try {
                        var42.setStaffCode(var37.getStaffCode());
                        var42.setExpressUserCode("");
                        var42.setExpressUserMobile("");
                        var42.setExtraInfo((String) null);
                        var42.setFileImgPath("");
                        var42.setScanDate(DateUtil.getCurrentDateTime());
                        var42.setLeaveRemark(var43.getLeaveRemark());
                        var42.setReceiveManMobile(var43.getReceiveManMobile());
                        var42.setReceiveMan(var43.getReceiveMan());
                        var42.setParcelCount(1);
                        var42.setMobileChannel(0);
                        var42.setIsNewUser(0);
                        var42.setScanType(2);
                        var42.setExpressType(0);
                        var42.setChannel(0);
                        var42.setTakeType(0);
                        var42.setTaobao_type(0);
                        var28.getData().add(var42);
                        //var49 = this.referenceContext;
                    } catch (Exception var13) {
                        var10000 = var13;
                        var10001 = false;
                        break label190;
                    }
                }
                    //var23 = var4;

                try {
                    OkhttpManager.kdcsOutLibrary(var28, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                        public final void onSuccess(Object var1) {
                            MixScanMamager.OkhttpCallbackStationManager var2 = OutLibraryActivity.this;
                            if (var2 != null) {
                                var2.onOkhttpOutLibrarySuccess(ExpressStationEnum.KUAIDICAOSHI, "出库成功");
                            }
                        }
                    }));
                    return;
                } catch (Exception var10) {
                    var10000 = var10;
                    var10001 = false;
                }
            }
        } else {
            ToastSoundUtil.wrongSoundToast("need query fast!");
        }
    }

    /**
     * @param barcode
     */
    private void jituOutLib(String barcode){
        JiTuResponse var2 = RqFilePreference.getInstance().getJiTuLoginResponseInfor();
        if (var2 == null) {
            Log.e(LoginActivity.TAG,"jituOutLib  JiTuResponse is null, return");
            return;
        }

        JiTuResponse.DataBean var7 = var2.getData();
        ArrayList var3 = new ArrayList();
        String var4 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
        String var5 = var7.getMobile();
        StringBuilder var6 = new StringBuilder();
        var6.append(var7.getNetworkCode());
        var6.append(DateUtil.getCurrentDateSecond());
        var3.add(new RequestJiTuOutlibrary(var5, var6.toString(), var7.getCityDesc(), var7.getLoginNetworkMobile(), var7.getProviderDesc(), var7.getLoginNetworkTypeId(), var7.getLoginNetworkTypeDesc(), var7.getMacAddr(), var4, "", "70", "本人签收", var7.getLoginNetworkMobile(), barcode));
        OkhttpManager.JiTuOutlibrary(var7.getToken(), (List)var3, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(JiTuOutLibraryResponse var1) {
                if (var1.getCode() == 1) {
                    onOkhttpOutLibrarySuccess(ExpressStationEnum.JITU, "出库成功");
                } else if (var1.getCode() == 135010037) {
                    ToastSoundUtil.displayToast("login timeout!");
                }
            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((JiTuOutLibraryResponse)var1);
            }
        }));
    }

    private void courSmailPoleOutLib(final String barcode){
        String account = RqFilePreference.getInstance().getCourierSmallPoleLoginforAccount();
        String password = RqFilePreference.getInstance().getCourierSmallPoleLoginforPassword();
        OkhttpManager.couriersmallpoleOutLib(account, password, barcode, new OkhttpManager.OnOkhttpCallback() {
            @Override
            public void onSuccess(Object p0) {
                if (p0 instanceof JsonObject) {
                    JSONObject courSmallPoleOutLibBean = JSONObject.parseObject(p0.toString());
                    JSONObject dataPackage = courSmallPoleOutLibBean.getJSONObject("data").getJSONObject("other_package");
                    int lastPackageNums = dataPackage.getIntValue("total_nums");
                    if (lastPackageNums > 0) {
                        ToastSoundUtil.displayToast("包裹出库成功,还有" + lastPackageNums + "个包裹");
                    } else {
                        ToastSoundUtil.displayToast("包裹出库成功!");
                    }
                }
            }
        });
    }

    private final void yizhanxiaobiandaOutLib(String barcode){
        final StageLoginRequestBean loginResponseBean = RqFilePreference.getInstance().getStagePoleLoginInfor();
        if (loginResponseBean == null) {
            return;
        }
        final StageLoginRequestBean.DataBean data = loginResponseBean.getData();
        OkhttpManager.stagesmallpoleChuKu1(data.getToken(), barcode, new OkhttpManager.OnOkhttpCallback() {
            @Override
            public void onSuccess(Object p0) {
                if(p0 instanceof SatgeChuKu1){
                    SatgeChuKu1 satgeChuKu1 = (SatgeChuKu1)p0;
                    ToastSoundUtil.displayToast(satgeChuKu1.getMessage());
                }
            }
        });
    }


    public final void uploadOutLibrary(final String var2) {
        String token = RqFilePreference.getInstance().getPandaHarvestInfoToken();

        long var4 = System.currentTimeMillis();
        StringBuilder var10 = new StringBuilder();
        var10.append("{\"mailNo\":\"");
        var10.append(var2);
        var10.append("\"}");
        String var9 = var10.toString();
        StringBuilder var6 = new StringBuilder();
        var6.append(var9);
        var6.append(/*ApiPandaHarvestActvity.Companion.getAccountName()*/"YP75838571");
        var6.append("OUTPUT_PARCEL");
        var6.append(token);
        var6.append(var4);
        var6.append(/*ApiPandaHarvestActvity.Companion.getAccountPassword()*/"yRLgecjAxVi9gLXx");
        String var11 = var6.toString();
        Charset var7 = Charset.forName("utf-8");
        if (var11 != null) {
            byte[] var12 = var11.getBytes(var7);
            var11 = Md5InputStream.md5((InputStream)(new ByteArrayInputStream(var12)));
            Map var13 = (Map)(new HashMap());
            var13.put("bizData", var9);
            var13.put("timestamp", String.valueOf(var4));
            var13.put("accountName", /*ApiPandaHarvestActvity.Companion.getAccountName()*/"YP75838571");
            var13.put("apiName", "OUTPUT_PARCEL");
            var13.put("token", token);
            ////Intrinsics.checkExpressionValueIsNotNull(var11, "md5Str");
            var13.put("sign", var11);
            OkhttpManager.pandaHarvestOutLib(var13, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                public final void onSuccess(PandaOutLibCall var1) {
                    PandaOutData var3 = (PandaOutData) JSON.parseObject(var1.getD(), PandaOutData.class);
                    CurrentParcel var2x = var3.getCurrentParcel();
                    if (var2x == null) {
                       return;
                    }

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            MixScanMamager.OkhttpCallbackStationManager var2x = OutLibraryActivity.this;
                            if (var2x != null) {
                                var2x.onOkhttpOutLibrarySuccess(ExpressStationEnum.PANDAHARVEST, "出库成功");
                            }
                        }
                    }).start();
                }

                // $FF: synthetic method
                // $FF: bridge method
                public void onSuccess(Object var1) {
                    this.onSuccess((PandaOutLibCall)var1);
                }
            }));
        }
    }


    public final void yundachaoshiCheckAndOutLib(final String var1) {
        OkhttpManager.yundaNewKDCSCheckBarcodeInfor(var1, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(YunDaNewKDCSCheckResponseBean var1x) {
                if (var1x != null) {
                    com.rq.net.bean.YunDaNewKDCSCheckResponseBean.DataBean var2 = var1x.getData();
                    ////Intrinsics.checkExpressionValueIsNotNull(var2, "data.data");
                    String var7 = var2.getCompany();
                    com.rq.net.bean.YunDaNewKDCSCheckResponseBean.DataBean var3 = var1x.getData();
                    ////Intrinsics.checkExpressionValueIsNotNull(var3, "data.data");
                    String var8 = var3.getRecePhone();
                    com.rq.net.bean.YunDaNewKDCSCheckResponseBean.DataBean var5 = var1x.getData();
                    ////Intrinsics.checkExpressionValueIsNotNull(var5, "data.data");
                    String var6 = var5.getYdUserId();
                    ArrayList var4 = new ArrayList();
                    var4.add(var1);
                    var4.add(var7);
                    var4.add(var8);
                    var4.add(var6);
                    yundachaoshiOutLib(var4);
                }

            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1x) {
                this.onSuccess((YunDaNewKDCSCheckResponseBean)var1x);
            }
        }));
    }

    private void yundachaoshiOutLib(ArrayList data){
        Ref.ObjectRef var24 = new Ref.ObjectRef();
        ////Intrinsics.checkExpressionValueIsNotNull(var4, "RqFilePreference.getInstance()");
        var24.element = RqFilePreference.getInstance().getYunDaKDCSLoginInfor();
        if ((YunDaKDCSLoginResponseBean)var24.element != null) {
            if (((YunDaKDCSLoginResponseBean)var24.element).getData() == null) {
                return;
            }

            if (data != null) {
                ArrayList var5 = (ArrayList)data;
                ////Intrinsics.checkExpressionValueIsNotNull(var2, "dataList[0]");
                final String var26 = (String)var5.get(0);
                Object var30 = var5.get(1);
                ////Intrinsics.checkExpressionValueIsNotNull(var30, "dataList[1]");
                String var7 = (String)var30;
                var30 = var5.get(2);
                ////Intrinsics.checkExpressionValueIsNotNull(var30, "dataList[2]");
                final String var32 = (String)var30;
                Object var33 = var5.get(3);
                ////Intrinsics.checkExpressionValueIsNotNull(var33, "dataList[3]");
                final String var36 = (String)var33;
                YunDaKDCSUploadBean var6 = new YunDaKDCSUploadBean();
                YunDaKDCSUploadBean.ItemsBean var8 = new YunDaKDCSUploadBean.ItemsBean();
                var8.setCompany(var7);
                var8.setPickCode("");
                var8.setRecePhone(var32);
                var8.setShipId(var26);
                var8.setYdUserId(var36);
                var6.getItems().add(var8);
                var6.setMyAgentInfo(new YunDaKDCSUploadBean.MyAgentInfoBean());
                YunDaKDCSUploadBean.MyAgentInfoBean var45 = var6.getMyAgentInfo();
                ////Intrinsics.checkExpressionValueIsNotNull(var45, "uploadBean.myAgentInfo");
                RqFilePreference var47 = RqFilePreference.getInstance();
                ////Intrinsics.checkExpressionValueIsNotNull(var47, "RqFilePreference.getInstance()");
                var45.setAccountPhone(var47.getLoginYunDaKDCSUsername());
                var45 = var6.getMyAgentInfo();
                ////Intrinsics.checkExpressionValueIsNotNull(var45, "uploadBean.myAgentInfo");
                com.rq.net.bean.YunDaKDCSLoginResponseBean.DataBean var48 = ((YunDaKDCSLoginResponseBean)var24.element).getData();
                ////Intrinsics.checkExpressionValueIsNotNull(var48, "kdcsLoginInfor.data");
                var45.setAgentAddress(var48.getAddress());
                var45 = var6.getMyAgentInfo();
                ////Intrinsics.checkExpressionValueIsNotNull(var45, "uploadBean.myAgentInfo");
                var48 = ((YunDaKDCSLoginResponseBean)var24.element).getData();
                ////Intrinsics.checkExpressionValueIsNotNull(var48, "kdcsLoginInfor.data");
                var45.setAgentId(var48.getAgentId());
                var45 = var6.getMyAgentInfo();
                ////Intrinsics.checkExpressionValueIsNotNull(var45, "uploadBean.myAgentInfo");
                var48 = ((YunDaKDCSLoginResponseBean)var24.element).getData();
                ////Intrinsics.checkExpressionValueIsNotNull(var48, "kdcsLoginInfor.data");
                var45.setAgentName(var48.getAgentName());
                var45 = var6.getMyAgentInfo();
                ////Intrinsics.checkExpressionValueIsNotNull(var45, "uploadBean.myAgentInfo");
                var48 = ((YunDaKDCSLoginResponseBean)var24.element).getData();
                ////Intrinsics.checkExpressionValueIsNotNull(var48, "kdcsLoginInfor.data");
                var45.setAgentPhone(var48.getAgentPhone());
                var45 = var6.getMyAgentInfo();
                ////Intrinsics.checkExpressionValueIsNotNull(var45, "uploadBean.myAgentInfo");
                var45.setKdyId("");
                var45 = var6.getMyAgentInfo();
                ////Intrinsics.checkExpressionValueIsNotNull(var45, "uploadBean.myAgentInfo");
                var45.setSource("1");
                var45 = var6.getMyAgentInfo();
                ////Intrinsics.checkExpressionValueIsNotNull(var45, "uploadBean.myAgentInfo");
                var48 = ((YunDaKDCSLoginResponseBean)var24.element).getData();
                ////Intrinsics.checkExpressionValueIsNotNull(var48, "kdcsLoginInfor.data");
                var45.setUserId(var48.getUserId());
                OkhttpManager.yundaOutLibrary1781(var6, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                    public final void onSuccess(Object var1) {
                        MixScanMamager.OkhttpCallbackStationManager var2x = OutLibraryActivity.this;
                        if (var2x != null) {
                            var2x.onOkhttpOutLibrarySuccess(ExpressStationEnum.YUNDAKDCS, "出库成功");
                        }

                        ////Intrinsics.checkExpressionValueIsNotNull(var4, "RqFilePreference.getInstance()");
                        if (RqFilePreference.getInstance().getShowMuchPackage()) {
                            com.rq.net.bean.YunDaNewKDCSNoPicketBean.DataBean var5 = new com.rq.net.bean.YunDaNewKDCSNoPicketBean.DataBean();
                            com.rq.net.bean.YunDaKDCSLoginResponseBean.DataBean var2 = ((YunDaKDCSLoginResponseBean)var24.element).getData();
                            ////Intrinsics.checkExpressionValueIsNotNull(var2, "kdcsLoginInfor.data");
                            var5.setAgentId(var2.getAgentId());
                            var5.setShipId(var26);
                            OkhttpManager.yundaNewKDCSCheckNoPicket(var5, new OkhttpManager.OnOkhttpCallback<YunDaNewKDCSNoPicketResponseBean>() {
                                @Override
                                public void onSuccess(YunDaNewKDCSNoPicketResponseBean p0) {
                                    if (p0.getData() != null && p0.getData().getContent() != null && p0.getData().getContent().size() > 0) {
                                        if (var2x != null) {
                                            var2x.onOkhttpOutLibrarySuccess(ExpressStationEnum.YUNDAKDCS, "出库成功,您还有"+p0.getData().getContent().size()+" 个包裹未取!");
                                        }
                                    }
                                }
                            });
                        }

                    }
                }));
                return;
            }

            //throw new Exception("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
        }
    }


    private void moxiOutLib(String barcode){
        OkhttpMoxiManager.outLib(barcode, new OkhttpMoxiManager.OkhttpCallback() {
            @Override
            public void onError(int var1, String var2) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastSoundUtil.wrongSoundToast(var2);
                    }
                });
            }

            @Override
            public void onSuccess(String var1) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastSoundUtil.scanSuccessToast(var1);
                    }
                });
            }
        });
    }

    private final void zhongyouStationQueryAndOutLib(String mBarcode) {
        KuaiBaoQueryBillcodeInforBean var1 = new KuaiBaoQueryBillcodeInforBean();
        var1.setData(JsonUtil.getJsonStringByGson(new KuaiBaoQueryBillcodeInforBean.BillcodeInforData("1", "1", mBarcode, "")));
        OkhttpManager.zhongYouStationQueryBillcodeInforApi(var1, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(KuaiBaoQueryBillcodeInforResponseBean var1) {
                final Ref.ObjectRef var2 = new Ref.ObjectRef();
                //Intrinsics.checkExpressionValueIsNotNull(var1, "data");
                var2.element = var1.getPhone();
                final Ref.ObjectRef var3 = new Ref.ObjectRef();
                var3.element = var1.getBrand();
                final Ref.ObjectRef var4 = new Ref.ObjectRef();
                var4.element = var1.getWaybillNo();
                KuaiBaoGetUserUnPickUpListsBean var5 = new KuaiBaoGetUserUnPickUpListsBean();
                var5.setData(JsonUtil.getJsonStringByGson(new KuaiBaoGetUserUnPickUpListsBean.DataBean(var1.getWaybillNo(), var1.getPhone())));
                OkhttpManager.zhongYouStationGetUserUnPickUpListsApi(var5, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                    public final void onSuccess(final KuaiBaoGetUserUnPickUpListsResponseBean var1) {
                        final Ref.BooleanRef var2x = new Ref.BooleanRef();
                        var2x.element = true;
                        Boolean var3x = true;//show much package
                        if (var3x) {
                            runOnUiThread((Runnable)(new Runnable() {
                                public final void run() {
                                        try {
                                            StringBuilder var3x = new StringBuilder();
                                            var3x.append("您还有");
                                            KuaiBaoGetUserUnPickUpListsResponseBean var4x = var1;
                                            var3x.append(var4x.getNum() - 1);
                                            var3x.append(" 个包裹未取!");//【点击全部出库】
                                            tips.setText(var3x.toString());
                                            SoundManager.getInstance().playPackageNotDelivered();
                                        } catch (Exception var18) {
                                            var18.printStackTrace();
                                        }
                                    }
                            }));
                        }


                        String var7 = (String)var2.element;
                        String var4x = (String)var3.element;
                        String var5 = (String)var4.element;
                        zhongyouStationUploadOutLibrary(var7, var4x, var5, var2x.element);
                    }

                    // $FF: synthetic method
                    // $FF: bridge method
                    public void onSuccess(Object var1) {
                        this.onSuccess((KuaiBaoGetUserUnPickUpListsResponseBean)var1);
                    }
                }));
            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((KuaiBaoQueryBillcodeInforResponseBean)var1);
            }
        }));
    }

    public final void zhongyouStationUploadOutLibrary(String phone, String brand, String waybillNo, final boolean var4) {
        KuaiBaoDeliveryStorageBean var5 = new KuaiBaoDeliveryStorageBean();
        HashMap var6 = new HashMap();
        Map var7 = (Map)var6;
        String var8 = DateUtil.getCurrentDateTime();
        var7.put(waybillNo, var8);
        var5.setData(JsonUtil.getJsonStringByGson(new  KuaiBaoDeliveryStorageBean.DataBean(JsonUtil.getJsonStringByGson(var6), phone, "1", brand, waybillNo)));
        OkhttpManager.zhongYouStationDeliveryStorageApi(var5, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(Object var1) {
                runOnUiThread((Runnable)(new Runnable() {
                    public final void run() {
                        if (var4) {
                            onOkhttpOutLibrarySuccess(ExpressStationEnum.ZHONGYOUSTATION,waybillNo);
                        }

                    }
                }));
            }
        }));
    }


    public final void zyytUploadOutLibrary(String var1, Bitmap var2) {
        org.json.JSONObject var4 = new org.json.JSONObject();
        try {
            var4.put("V_MARK", "6038092285577617761");
            var4.put("V_YJHM", var1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        var1 = var4.toString();
        Charset var5 = Charset.forName("UTF-8");
        if (var1 != null) {
            byte[] var3 = var1.getBytes(var5);
            OkhttpManager.zyztHkGpy(Base64Util.encode(var3), "getMailDeliveryInfo", (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                public final void onSuccess(Boolean var1) {
                    if (var1) {
                        OutLibraryActivity.this.runOnUiThread((Runnable)(new Runnable() {
                            public final void run() {
                                tips.setText(""+var1+" out lib success!!");
                            }
                        }));
                    }

                }

                // $FF: synthetic method
                // $FF: bridge method
                public void onSuccess(Object var1) {
                    this.onSuccess((Boolean)var1);
                }
            }));
        } else {
            Log.e(LoginActivity.TAG,"zyytUploadOutLibrary  barcode is null.");
        }
    }


    public final void mamayizhanQueryBarcodeAndOutLib(String var1,boolean queryOnly) {

        try {
            MaMaQueryBarcodeBean var2 = new MaMaQueryBarcodeBean();
            var2.setWaybillNo(var1);
            RqFilePreference var4 = RqFilePreference.getInstance();
            MaMaLoginResponseBean var5 = var4.getMaMaLoginInfor();
            var2.setStationCode(var5.getStationCode());
            OkhttpManager.mamaQueryBarcodeInfor(var2, var5, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                // $FF: synthetic method
                // $FF: bridge method
                public void onSuccess(Object var1) {
                    this.onSuccess((List)var1);
                }

                public void onSuccess(List var1) {
                    if (queryOnly) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tips.setText("You have "+var1.size()+" packages !");
                            }
                        });
                    } else {
                        mamayizhanUploadOutLibrary(var1);
                    }
                }
            }));
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }


    public final void mamayizhanUploadOutLibrary(final List var1) {
        if (Intrinsics.areEqual(((MaMaQueryBarcodeResponseBean)var1.get(0)).getStatusCode(), "45")) {
            ToastSoundUtil.baoGuoYiChuToast("快递已签收出库");
        } else {
            MaMaOutLibraryBean var2 = new MaMaOutLibraryBean();
            if (var1.size() > 0) {
                var2.setEmpCode(((MaMaQueryBarcodeResponseBean)var1.get(0)).getEmpCode());
                var2.setEmpName(((MaMaQueryBarcodeResponseBean)var1.get(0)).getEmpName());
                var2.setId(((MaMaQueryBarcodeResponseBean)var1.get(0)).getId());
                var2.setLogisticsCode(((MaMaQueryBarcodeResponseBean)var1.get(0)).getLogisticsCode());
                var2.setOrgCode(((MaMaQueryBarcodeResponseBean)var1.get(0)).getOrgCode());
                var2.setRecieverPhone(((MaMaQueryBarcodeResponseBean)var1.get(0)).getDestPhone());
                var2.setStationCode(((MaMaQueryBarcodeResponseBean)var1.get(0)).getStationCode());
                var2.setWaybillNo(((MaMaQueryBarcodeResponseBean)var1.get(0)).getWaybillNo());
                RqFilePreference var3 = RqFilePreference.getInstance();
                var2.setUsername(var3.getLoginUsername());
                var2.setRecieverSignoff("本人签收");
                var2.setDestPhone(((MaMaQueryBarcodeResponseBean)var1.get(0)).getDestPhone());
                OkhttpManager.mamaUploadOutLibraryData(var2, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                    public final void onSuccess(Object var1x) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tips.setText(((MaMaQueryBarcodeResponseBean)var1.get(0)).getWaybillNo()+" out lib success!!");
                            }
                        });


                        Boolean var4 = isShowMuchPackage;
                        if (var4) {
                            String var5 = ((MaMaQueryBarcodeResponseBean)var1.get(0)).getDestPhone();
                            String var3 = ((MaMaQueryBarcodeResponseBean)var1.get(0)).getWaybillNo();
                            mamayizhanCheckNoOutLibrary(var3, var5);
                        }

                    }
                }));
            }

        }
    }

    public final void mamayizhanCheckNoOutLibrary(final String var1, String var2) {
        StringBuilder var5 = new StringBuilder();
        var5.append("{\"pageSize\":\"15\",\"ifSign\":\"0\",\"parameterType\":\"3\",\"searchValue\":\"");
        var2 = var2.substring(var2.length() - 4);
        var5.append(var2);
        var5.append("\",\"pageIndex\":\"0\"}");
        var2 = var5.toString();
        MaMaCheckInforBean var6 = new MaMaCheckInforBean();
        var6.setData(var2);
        OkhttpManager.mamaCheckNoOutLibraryData(var6, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(final MaMaNoOutLibraryResponseBean var1x) {
                runOnUiThread((Runnable)(new Runnable() {
                    public final void run() {
                        Exception var10000;
                        label124: {
                            ArrayList var1xx;
                            boolean var10001;
                            Iterator var19;
                            try {
                                if (var1x == null || !var1x.getCode().equals("200") || var1x.getData() == null) {
                                    return;
                                }

                                List var2 = var1x.getData();
                                var1xx = new ArrayList();
                                var19 = var2.iterator();
                            } catch (Exception var16) {
                                var10000 = var16;
                                var10001 = false;
                                break label124;
                            }

                            while(true) {
                                try {
                                    while(var19.hasNext()) {
                                        MaMaNoOutLibraryResponseBean.DataBean var3 = (MaMaNoOutLibraryResponseBean.DataBean)var19.next();
                                        if (StringUtil.isEmpty(var3.getSignatureTime())) {
                                            ShowMuchPackageNoPickBean var4 = new ShowMuchPackageNoPickBean();
                                            var4.setBarcode(var3.getWaybillNo());
                                            var4.setPickUpCode(var3.getTakeCode());
                                            var4.setInStorageTime(var3.getIncomeTime());
                                            var4.setReceviePerson(var3.getDestName());
                                            var1xx.add(var4);
                                        }
                                    }
                                } catch (Exception var17) {
                                    var10000 = var17;
                                    var10001 = false;
                                    break;
                                }

                                try {
                                    var19 = var1xx.iterator();
                                } catch (Exception var14) {
                                    var10000 = var14;
                                    var10001 = false;
                                    break;
                                }

                                try {
                                    while(var19.hasNext()) {
                                        ShowMuchPackageNoPickBean var21 = (ShowMuchPackageNoPickBean)var19.next();
                                        if (var21.getBarcode().equals(var1)) {
                                            var1xx.remove(var21);
                                            break;
                                        }
                                    }
                                } catch (Exception var15) {
                                    var10000 = var15;
                                    var10001 = false;
                                    break;
                                }

                                try {
                                    StringBuilder var23 = new StringBuilder();
                                    var23.append("您还有");
                                    var23.append(var1xx.size());
                                    var23.append(" 个包裹未取");
                                    tips.append(var23.toString());
                                    SoundManager.getInstance().playPackageNotDelivered();
                                } catch (Exception var9) {
                                    var10000 = var9;
                                    var10001 = false;
                                    break;
                                }
                            }
                        }

                        Exception var18 = var10000;
                        var18.printStackTrace();
                    }
                }));
            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1x) {
                this.onSuccess((MaMaNoOutLibraryResponseBean)var1x);
            }
        }));
    }

    private final void landianCheckBarcodeAndOutLib(String var1) {
        BlueShopCookieBean blueShopCookieBean = RqFilePreference.getInstance().getBlueShopLoginCache();
        final String var6 = blueShopCookieBean.getUsername();
        final String var7 = blueShopCookieBean.getPassword();
        final String var8 = RqFilePreference.getInstance().getBlueShopCookie();
        StringBuilder var5 = new StringBuilder();
        var5.append("username=");
        var5.append(var6);
        var5.append(";");
        var5.append("password=");
        var5.append(var7);
        var5.append(";");
        var5.append(var8);
        OkhttpManager.queryBarCode(var5.toString(), var1, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(QueryBarCodeBean var1) {
                QueryBarCodeBean.DataBean var4 = (QueryBarCodeBean.DataBean)var1.getDatas().get(0);
                long var2 = var4.getId();
                String var6x = var4.getCheckCode();
                final String var7x = var4.getReceiverMobile();
                StringBuilder var5 = new StringBuilder();
                var5.append("username=");
                var5.append(var6);
                var5.append(";");
                var5.append("password=");
                var5.append(var7);
                var5.append(";");
                var5.append(var8);
                OkhttpManager.ChuKu(var5.toString(), String.valueOf(var2), var6x, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                    public final void onSuccess(JsonObject var1) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tips.setText(var1+" out lib success!");
                            }
                        });

                        StringBuilder var2 = new StringBuilder();
                        var2.append("username=");
                        var2.append(var6);
                        var2.append(";");
                        var2.append("password=");
                        var2.append(var7);
                        var2.append(";");
                        var2.append(var8);
                        OkhttpManager.queryNotGetCode(var2.toString(), var7x, this);
                    }

                    // $FF: synthetic method
                    // $FF: bridge method
                    public void onSuccess(Object var1) {
                        this.onSuccess((JsonObject)var1);
                    }
                }));
            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((QueryBarCodeBean)var1);
            }
        }));
    }


    public final void fengchaoOutLib(final String var1) {
        OkhttpManager.fengchaoServiceCheckBarcode(var1, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public void onSuccess(Object var1x) {
                this.onSuccess((List)var1x);
            }

            public final void onSuccess(List var1x) {
                if (var1x != null) {
                    try {
                        if (var1x.size() > 0) {
                            final Ref.ObjectRef var2 = new Ref.ObjectRef();
                            var2.element = new FcboxSignBean.ExpressInfosBean();
                            ((FcboxSignBean.ExpressInfosBean)var2.element).setBoxThrowLocation("");
                            FcboxSignBean.ExpressInfosBean var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            Object var4 = var1x.get(0);
                            var3.setEntryTime(((FcboxCheckBarcodeResponseBean)var4).getEntryTime());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var3.setExpressCompanyId(((FcboxCheckBarcodeResponseBean)var4).getExpressCompanyId());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var3.setExpressCompanyName(((FcboxCheckBarcodeResponseBean)var4).getExpressCompanyName());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var3.setExpressNo(((FcboxCheckBarcodeResponseBean)var4).getExpressNo());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var3.setFetchCode(((FcboxCheckBarcodeResponseBean)var4).getFetchCode());
                            ((FcboxSignBean.ExpressInfosBean)var2.element).setLocalState("0");
                            ((FcboxSignBean.ExpressInfosBean)var2.element).setLocalType("0");
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var3.setPaymentAmount(((FcboxCheckBarcodeResponseBean)var4).getPaymentAmount());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            StringBuilder var11 = new StringBuilder();
                            var11.append("");
                            Object var5 = var1x.get(0);
                            var11.append(((FcboxCheckBarcodeResponseBean)var5).getPaymentStatus());
                            var3.setPaymentStatus(var11.toString());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var11 = new StringBuilder();
                            var11.append("");
                            var5 = var1x.get(0);
                            var11.append(((FcboxCheckBarcodeResponseBean)var5).getPaymentType());
                            var3.setPaymentType(var11.toString());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var3.setPaymentTypeName(((FcboxCheckBarcodeResponseBean)var4).getPaymentTypeName());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var3.setSubOrderStatusStr(((FcboxCheckBarcodeResponseBean)var4).getSubOrderStatusStr());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var3.setPostStatusName(((FcboxCheckBarcodeResponseBean)var4).getPostStatusName());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var3.setReceiverMobile(((FcboxCheckBarcodeResponseBean)var4).getReceiverMobile());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var3.setReceiverName(((FcboxCheckBarcodeResponseBean)var4).getReceiverName());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var3.setShelfTime(((FcboxCheckBarcodeResponseBean)var4).getShelfTime());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            String var12 = ((FcboxCheckBarcodeResponseBean)var4).getPostStatus();
                            var3.setPostStatus(Integer.parseInt(var12));
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var12 = ((FcboxCheckBarcodeResponseBean)var4).getPostId();
                            var3.setPostId(Integer.parseInt(var12));
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var3.setNeedPay(((FcboxCheckBarcodeResponseBean)var4).isNeedPay());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var3.setIsStatusSatisfied(((FcboxCheckBarcodeResponseBean)var4).isIsStatusSatisfied());
                            var3 = (FcboxSignBean.ExpressInfosBean)var2.element;
                            var4 = var1x.get(0);
                            var3.setIncludServiceFee(((FcboxCheckBarcodeResponseBean)var4).isIncludeServiceFee());
                            var12 = var1;
                            String var10 = ((FcboxSignBean.ExpressInfosBean)var2.element).getExpressCompanyName();
                            String var6 = ExpressStationEnum.FENGCHAOSERVICE.getTitle();
                            Object var8 = var1x.get(0);
                            FcboxSignBean var9 = new FcboxSignBean();
                            var9.getExpressInfos().add((FcboxSignBean.ExpressInfosBean)var2.element);
                            OkhttpManager.fengchaoServiceOutLibrary(var9, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                                public void onSuccess(Object var1x) {
                                    this.onSuccess((List)var1x);
                                }

                                public final void onSuccess(List var1x) {
                                    runOnUiThread((Runnable)(new Runnable() {
                                        public final void run() {
                                            tips.setText(var1 +" out lib success!");

                                        }
                                    }));
                                    FcboxQueryPackageBean var2x = new FcboxQueryPackageBean();
                                    var2x.setPageNo("1");
                                    var2x.setPageSize("200");
                                    var2x.setReceiverMobile(((FcboxSignBean.ExpressInfosBean)var2.element).getReceiverMobile());
                                    var2x.setTimeRangeType(0);
                                    OkhttpManager.fengchaoServiceQueryOtherPackage(var2x, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                                        public final void onSuccess(final FcboxQueryPackageResponseBean var1x) {
                                            runOnUiThread((Runnable)(new Runnable() {
                                                public final void run() {
                                                    try {
                                                        StringBuilder var3 = new StringBuilder();
                                                        var3.append("您还有");
                                                        var3.append(var1x.getTotalCount());
                                                        var3.append(" 个包裹未取");
                                                        tips.append(var3.toString());
                                                        SoundManager.getInstance().playPackageNotDelivered();

                                                    } catch (Exception var12) {
                                                        var12.printStackTrace();
                                                    }
                                                }
                                            }));
                                        }

                                        public void onSuccess(Object var1x) {
                                            this.onSuccess((FcboxQueryPackageResponseBean)var1x);
                                        }
                                    }));
                                }
                            }));
                            return;
                        }
                    } catch (Exception var7) {
                        var7.printStackTrace();
                    }
                }
            }
        }));
    }


    public final void fsshUploadOutLibrary(final String var1, final Bitmap var2) {
        String fsshsid = RqFilePreference.getInstance().getFsshAppSID();
        String appKey = "yunpan";
        String appSecret = "ed7f9ba964404ab6ba314539a070581d";
        if (StringUtil.isNotEmpty(appSecret)) {
            final Ref.ObjectRef var3 = new Ref.ObjectRef();
            var3.element = new FsshOutLibraryBodyBean();
            FsshOutLibraryBodyBean var4;
            if (StringUtil.isEmpty(fsshsid)) {
                var4 = (FsshOutLibraryBodyBean)var3.element;
                var4.setEquipmentId(fsshsid);
            } else {
                ((FsshOutLibraryBodyBean)var3.element).setEquipmentId(fsshsid);
            }

            ((FsshOutLibraryBodyBean)var3.element).setData(var1);
            ((FsshOutLibraryBodyBean)var3.element).setAppkey(appKey);
            ((FsshOutLibraryBodyBean)var3.element).setAppNotic(SystemUtil.getAppUUID((Context)this));
            var4 = (FsshOutLibraryBodyBean)var3.element;
            String var6 = String.valueOf(System.currentTimeMillis());
            if (var6 != null) {
                var6 = var6.substring(0, 10);
                var4.setAppTimestamp(var6);
                var4 = (FsshOutLibraryBodyBean)var3.element;
                StringBuilder var7 = new StringBuilder();
                var7.append(appKey);
                var7.append('@');
                var7.append(appSecret);
                var7.append('@');
                var7.append(((FsshOutLibraryBodyBean)var3.element).getAppNotic());
                var7.append('@');
                var7.append(((FsshOutLibraryBodyBean)var3.element).getAppTimestamp());
                var4.setAppSign(MD5Util.encodeMd5(var7.toString()));
                OkhttpManager.equipmentOutData((FsshOutLibraryBodyBean)var3.element, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                    public final void onSuccess(FsshOutLibraryResponseBean var1x) {
                        ArrayList var2x = new ArrayList();
                        if (var1x.getData() != null && var1x.getData().size() > 0) {
                            Iterator var5 = var1x.getData().iterator();

                            while(var5.hasNext()) {
                                FsshOutLibraryResponseBean.DataBean var3x = (FsshOutLibraryResponseBean.DataBean)var5.next();
                                if (!var3x.getBillCode().equals(var1)) {
                                    ShowMuchPackageNoPickBean var4 = new ShowMuchPackageNoPickBean();
                                    var4.setBarcode(var3x.getBillCode());
                                    var4.setPickUpCode(var3x.getGoodCodes());
                                    var4.setInStorageTime("");
                                    var4.setReceviePerson("");
                                    var2x.add(var4);
                                }
                            }
                        }
                        tips.setText(var1+" out lib success!! ");
                        if (var2x.size() > 0) {

                            StringBuilder var9 = new StringBuilder();
                            var9.append("您还有");
                            var9.append(var2x.size());
                            var9.append(" 个包裹未取!");
                            tips.append(var9.toString());
                            SoundManager.getInstance().playPackageNotDelivered();
                        }
                        if (var2 != null)
                            fsshUploadOutLibraryPicture(var1, var2, (FsshOutLibraryBodyBean)var3.element);
                    }

                    // $FF: synthetic method
                    // $FF: bridge method
                    public void onSuccess(Object var1x) {
                        this.onSuccess((FsshOutLibraryResponseBean)var1x);
                    }
                }));
            } else {
                Log.e(LoginActivity.TAG,"null cannot be cast to non-null type java.lang.String");
            }
        }
    }

    public final void fsshUploadOutLibraryPicture(String var1, Bitmap var2, FsshOutLibraryBodyBean var3) {
        OkhttpManager.fsshUploadBarcodeImage(var1, var2, var3, null);
    }

    public final void guoguoyizhanUploadOutLibrary(String var1, byte[] var2) {
        String var5 = "";
        LoginResponseBean var3 = RqFilePreference.getInstance().getGuoGuoYiZhanLoginRes();
        if (var3 != null) {
            LoginResponseDataBean var4 = var3.getData();
            if (var4 != null) {
                var5 = var4.getToken();
            }
        }

        OkhttpManager.guoGuoPutOffStorageV3(var1, var5, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(OffStorageResponseBean var1) {
                if (Intrinsics.areEqual(var1.getCode(), "0")) {
                    PackageDataBean var2 = var1.getData();
                    ArrayList var8;
                    if (var2 != null) {
                        var8 = var2.getPackage_list();
                    } else {
                        var8 = null;
                    }
                    if (var8 == null) {
                        return;
                    }
                    if (var8.size() != 0) {
                        var8 = new ArrayList();
                        Iterator var5 = var1.getData().getPackage_list().iterator();

                        while(var5.hasNext()) {
                            PackageBean var3 = (PackageBean)var5.next();
                            ShowMuchPackageNoPickBean var4 = new ShowMuchPackageNoPickBean();
                            var4.setBarcode(var3.getExpress_num());
                            var4.setPickUpCode(var3.getPcode());
                            var4.setReceviePerson(var3.getClient_name());
                            var8.add(var4);
                        }

                        if (var8.size() > 0) {

                            StringBuilder var10 = new StringBuilder();
                            var10.append("您还有");
                            var10.append(var8.size());
                            var10.append(" 个包裹未取!");
                            tips.append(var10.toString());
                            SoundManager.getInstance().playPackageNotDelivered();

                            return;
                        }
                    } else {
                        tips.setText(var1+" out lib success!");
                    }
                }

            }
            public void onSuccess(Object var1) {
                this.onSuccess((OffStorageResponseBean)var1);
            }
        }));
    }

    public final void jinlinbaoGaopaiyiOutLib(String var1, String var2, String var3) {
        JinLinBaoLoginResponseBean var8 = RqFilePreference.getInstance().getJinLinBaoLoginRes();
        JinLinBaoLoginResponseBean.BodyBean var9;
        if (var8 != null) {
            var9 = var8.getBody();
        } else {
            var9 = null;
        }
        if (var9 == null) {
            Log.e(LoginActivity.TAG,"not login yet1!");
            return;
        }
        Object var10 = var9.getLogis_list().get(0);
        int var4 = ((JinLinBaoLoginResponseBean.BodyBean.LogisListBean)var10).getId();

        OkhttpManager.jinLinBaoPickUpBatchPickUp(String.valueOf(var4), var1, String.valueOf(var9.getId()), var2, var3, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(jinLinBaoPickupBatchPickupResponseBean var1) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tips.setText(var1 + " out lib success!");
                    }
                });

            }
            public void onSuccess(Object var1) {
                this.onSuccess((jinLinBaoPickupBatchPickupResponseBean)var1);
            }
        }));
    }


    public final void jinlinbaoKuaidiqujianOutLib(final String var1) {
        JinLinBaoLoginResponseBean var4 = RqFilePreference.getInstance().getJinLinBaoLoginRes();
        Object var5 = null;
        JinLinBaoLoginResponseBean.BodyBean var8;
        if (var4 != null) {
            var8 = var4.getBody();
        } else {
            var8 = null;
        }
        if (var8 == null) {
            Log.e(LoginActivity.TAG,"not login yet2!");
            return;
        }
        Object var9 = var8.getLogis_list().get(0);
        final int var2 = ((JinLinBaoLoginResponseBean.BodyBean.LogisListBean)var9).getId();

        JinLinBaoLoginResponseBean.BodyBean.SessionBean var10 = var8.getSession();
        final String var6 = var10.getSid();

        final int var3 = var8.getId();
        OkhttpManager.jinLinBaoPickUpSearch(String.valueOf(var2), var1, var6, String.valueOf(var3), (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(jinLinBaoPickupSearchResponseBean var1x) {
                if (var1x.getCode() == 0) {
                    List var2x = var1x.getBody();
                    if (((Collection)var2x).isEmpty() ^ true) {
                        OkhttpManager.jinLinBaoPickupUnPickup(String.valueOf(var2), var1, var6, String.valueOf(var3), (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                            public final void onSuccess(final jinLinBaoPickupUnPickupResponseBean var1x) {
                                jinLinBaoPickupUnPickupResponseBean.Body var4 = var1x.getBody();
                                final int var2x = var4.getCount();
                                var4 = var1x.getBody();
                                Iterator var6x = var4.getList().iterator();

                                while(var6x.hasNext()) {
                                    jinLinBaoPickupUnPickupResponseBean.Body.BarcodeInfo var5 = (jinLinBaoPickupUnPickupResponseBean.Body.BarcodeInfo)var6x.next();
                                    if (Intrinsics.areEqual(var5.getExp_code(), var1)) {
                                        int var3x = var5.getId();
                                        OkhttpManager.jinLinBaoPickUpFreeConfirm(String.valueOf(var2), String.valueOf(var2x), String.valueOf(var3x), var6, String.valueOf(var3), String.valueOf(var3),
                                                (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                                            public final void onSuccess(jinLinBaoPickUpFreeConfirmResponseBean var1xx) {
                                                if (var2x > 1) {
                                                    ArrayList var5 = new ArrayList();
                                                    jinLinBaoPickupUnPickupResponseBean var2xx = var1x;
                                                    jinLinBaoPickupUnPickupResponseBean.Body var6x = var2xx.getBody();
                                                    Iterator var7 = var6x.getList().iterator();

                                                    while(var7.hasNext()) {
                                                        jinLinBaoPickupUnPickupResponseBean.Body.BarcodeInfo var3x = (jinLinBaoPickupUnPickupResponseBean.Body.BarcodeInfo)var7.next();
                                                        if (Intrinsics.areEqual(var3x.getExp_code(), var1) ^ true) {
                                                            ShowMuchPackageNoPickBean var4 = new ShowMuchPackageNoPickBean();
                                                            var4.setBarcode(var3x.getExp_code());
                                                            var4.setPickUpCode("");
                                                            var4.setInStorageTime(var3x.getCreate_time());
                                                            var5.add(var4);
                                                        }
                                                    }

                                                    if (var5.size() > 0) {

                                                        StringBuilder var10 = new StringBuilder();
                                                        var10.append("您还有");
                                                        var10.append(var5.size());
                                                        var10.append(" 个包裹未取!");
                                                        tips.append(var10.toString());
                                                        SoundManager.getInstance().playPackageNotDelivered();

                                                        return;
                                                    }
                                                } else {
                                                    tips.setText(var1+" out lib success!");
                                                }

                                            }
                                            public void onSuccess(Object var1xx) {
                                                this.onSuccess((jinLinBaoPickUpFreeConfirmResponseBean)var1xx);
                                            }
                                        }));
                                    }
                                }

                            }

                            public void onSuccess(Object var1x) {
                                this.onSuccess((jinLinBaoPickupUnPickupResponseBean)var1x);
                            }
                        }));
                    }
                }

            }

            public void onSuccess(Object var1x) {
                this.onSuccess((jinLinBaoPickupSearchResponseBean)var1x);
            }
        }));
    }


    public final void jinlinbaoOcrjieboInLibrary(String var1, String var2, String var3, byte[] var4) {
        JinLinBaoLoginResponseBean var7 = RqFilePreference.getInstance().getJinLinBaoLoginRes();
        Object var8 = null;
        JinLinBaoLoginResponseBean.BodyBean var11;
        if (var7 != null) {
            var11 = var7.getBody();
        } else {
            var11 = null;
        }

        if (var8 == null) {
            Log.e(LoginActivity.TAG,"not login yet2!");
            return;
        }

        Object var12 = var11.getLogis_list().get(0);
        int var5 = ((JinLinBaoLoginResponseBean.BodyBean.LogisListBean)var12).getId();

        int var6 = var11.getId();

        JinLinBaoLoginResponseBean.BodyBean.SessionBean var10 = var11.getSession();
        OkhttpManager.jinLinBaoJieBoPictureUpload("2", String.valueOf(var5), var2, var10.getSid(), String.valueOf(var6), var3, var1, var4,
                (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(JinLinBaoJieBoPictureUploadResponseBean var1) {
                if (var1.getCode() == 0) {
                    tips.setText(var1 +" in Lib success!");
                }
            }

            public void onSuccess(Object var1) {
                this.onSuccess((JinLinBaoJieBoPictureUploadResponseBean)var1);
            }
        }));
    }

    public final void jinlinbaoQianshouOutLibrary(final String var1, final byte[] var2) {
        JinLinBaoLoginResponseBean var5 = RqFilePreference.getInstance().getJinLinBaoLoginRes();
        Object var6 = null;
        JinLinBaoLoginResponseBean.BodyBean var9;
        if (var5 != null) {
            var9 = var5.getBody();
        } else {
            var9 = null;
        }

        if (var9 == null) {
            Log.e(LoginActivity.TAG,"not login yet2!");
            return;
        }

        Object var10 = var9.getLogis_list().get(0);
        final int var3 = ((JinLinBaoLoginResponseBean.BodyBean.LogisListBean)var10).getId();

        JinLinBaoLoginResponseBean.BodyBean.SessionBean var11 = var9.getSession();
        final String var7 = var11.getSid();

        final int var4 = var9.getId();
        OkhttpManager.jinLinBaoOcrTranshipDetail(String.valueOf(var3), var1, var7, String.valueOf(var4), (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(jinLinBaoOcrTranshipDetailResponseBean var1x) {
                if (var1x.getCode() == 0 && !var1x.getBody().isEmpty()) {
                    Object var4x = var1x.getBody().get(0);
                    long var2x = ((jinLinBaoOcrTranshipDetailResponseBean.BodyBean)var4x).getId();
                    String var6 = var7;
                    Object var5 = var1x.getBody().get(0);
                    OkhttpManager.jinlinbaoPickUp(String.valueOf(var2x), var6, ((jinLinBaoOcrTranshipDetailResponseBean.BodyBean)var5).getConsignee_phone(), String.valueOf(var4), String.valueOf(var3), var1, var2,
                            (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                        public final void onSuccess(jinLinBaoPickUpResponseBean var1x) {
                            if (var1x.getCode() == 0) {
                                tips.setText(var1 +" out Lib success!");
                            }
                        }
                        public void onSuccess(Object var1x) {
                            this.onSuccess((jinLinBaoPickUpResponseBean)var1x);
                        }
                    }));
                }
            }

            public void onSuccess(Object var1x) {
                this.onSuccess((jinLinBaoOcrTranshipDetailResponseBean)var1x);
            }
        }));
    }

    public final void sudiyiOutLib(final String var1, byte[] var2, byte[] var3) {
        final long var4 = (new Date()).getTime();
        ImageSaveUtil var6 = null;
        StringBuilder var7 = null;
        File var8 = null;
        final File var9;
        final File var10;
        if (var2 != null) {
            var6 = ImageSaveUtil.getInstance();
            var7 = new StringBuilder();
            var8 = Environment.getExternalStorageDirectory();
            var7.append(var8.getPath());
            var7.append("/sdy/");
            var7.append(var1);
            var7.append("/barcode.jpg");

            var9 = var6.saveBitmapFile(var2, var7.toString());
        } else {
            var9 = null;
        }
        if (var3 != null) {
            var6 = ImageSaveUtil.getInstance();
            var7 = new StringBuilder();
            var8 = Environment.getExternalStorageDirectory();
            var7.append(var8.getPath());
            var7.append("/sdy/");
            var7.append(var1);
            var7.append("/user.jpg");
            var10 = var6.saveBitmapFile(var3, var7.toString());
        } else {
            var10 = null;
        }
        RqFilePreference var11 = RqFilePreference.getInstance();
        String var12 = var11.getSdyAppId();
        String var14 = var11.getSdySecretKey();
        var12 = StringUtil.getSudiyiAuth(var4, "POST", "/open-delivery-platform/order/self/sign/submit/v2", var12, var14);
        OkhttpManager.suDiYiUpload(var4, var1, var12, var11.getSdyAppId(), (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(SuDiYiResponseBean var1x) {
                if (var1x.getCode() == 200) {
                    tips.setText(var1 +" out Lib success!");

                    String var9x = var1;
                    File var4x = var9;
                    File var5 = var10;
                    long var2 = var4;
                    String sdyAppId = var11.getSdyAppId();
                    String var12 = var11.getSdySecretKey();
                    String var10x = StringUtil.getSudiyiAuth(var2, "POST", "/open-delivery-platform/order/self/sign/upload", sdyAppId, var12);
                    if (var4x != null &&  var5 != null) {
                        OkhttpManager.suDiYiImageUpload(var9x, var4x, var5, var10x, var11.getSdyAppId(), var4, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
                            public final void onSuccess(SuDiYiResponseBean var1x) {
                                if (var1x.getCode() == 200) {
                                    tips.append(var1 +" picture upload success!");
                                }

                            }

                            // $FF: synthetic method
                            // $FF: bridge method
                            public void onSuccess(Object var1x) {
                                this.onSuccess((SuDiYiResponseBean) var1x);
                            }
                        }));
                    }
                }
            }

            public void onSuccess(Object var1x) {
                this.onSuccess((SuDiYiResponseBean)var1x);
            }
        }));
    }

    public final void jushuitanOutLib(String var1, String var2) {
        ArrayList var4 = new ArrayList();
        int operationType = 1;
        var4.add(new JuShuiTanRequest(var1, Float.parseFloat(var2), operationType));
        int var3 = (int)(System.currentTimeMillis() / 1000L);
        String token = "18a61c18caa13c43dbdcf6034bedde45";
        StringBuilder var5 = new StringBuilder();
        var5.append("orders.weight.send.upload");
        var5.append("1205afda743538ecda76b0ecb6de8cfa");
        var5.append("token");
        var5.append(token);
        var5.append("ts");
        var5.append(var3);
        var5.append("c784c59cf980514d3139a30799b7da54");
        var1 = MD5Util.getMD5Str(var5.toString());
        OkhttpManager.deliverGoods((List)var4, token, "1205afda743538ecda76b0ecb6de8cfa", var3, var1, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(JuShuiTanResponseBean var1) {
                StringBuilder var12;
                if (var1 != null && var1.isIssuccess() && var1.getCode() == 0) {
                    ToastSoundUtil.displayToast(var1.getMsg());
                    tips.setText(var1+ " out Lib scuccess!!");
                } else {
                    int var2 = var1.getCode();
                    JuShuiTanResponseBean.DataBean var7 = null;
                    Context var8;
                    if (var2 != 120 && var1.getCode() != 100) {
                        List var5 = var1.getDatas();
                        if (var5 != null) {
                            var7 = (JuShuiTanResponseBean.DataBean)var5.get(0);
                        }

                        if (var7 != null) {
                            Object var11 = var1.getDatas().get(0);
                            ToastSoundUtil.displayToast(((JuShuiTanResponseBean.DataBean)var11).getMsg());
                        }


                        if (var1.getDatas() != null && var1.getDatas().size() > 0) {
                            var12 = new StringBuilder();
                            var12.append("发货失败");
                            var12.append(var1.getMsg());
                            ToastSoundUtil.wrongSoundToast(var12.toString());
                            return;
                        }

                        var12 = new StringBuilder();
                        var12.append("发货失败");
                        var12.append(var1.getMsg());
                        ToastSoundUtil.wrongSoundToast(var12.toString());
                        return;
                    }


                    var12 = new StringBuilder();
                    var12.append("发货失败");
                    var12.append(var1.getMsg());
                    ToastSoundUtil.wrongSoundToast(var12.toString());
                    List var10 = var1.getDatas();
                    if (var10 != null) {
                        var7 = (JuShuiTanResponseBean.DataBean)var10.get(0);
                    }

                    if (var7 != null) {
                        Object var6 = var1.getDatas().get(0);
                        ToastSoundUtil.wrongSoundToast(((JuShuiTanResponseBean.DataBean)var6).getMsg());
                    }
                }

            }

            public void onSuccess(Object var1) {
                this.onSuccess((JuShuiTanResponseBean)var1);
            }
        }));
    }

    public final void xinghuoOutLib(final String var1) {
        RqFilePreference var2 = RqFilePreference.getInstance();
        final PubkeyAndCookie keyAndCookie = var2.getKeyAndCookie();

        if (keyAndCookie == null) {
            Log.e(LoginActivity.TAG,"xinghuo out lib fail, keyandcookie is null");
            return;
        }

        OkhttpManager.xingHuoOutLibrary(keyAndCookie.getCookie(), new XingHuoOutLibrary("code", var1),
                (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(XingHuoOutLibraryReponse var1x) {

                String var5 = keyAndCookie.getCookie();
                XingHuoOutLibraryReponse.ResultBean var3 = var1x.getResult();
                Object var4 = var3.getWaybills().get(0);
                OkhttpManager.xingHuoNotOutSearch(var5,
                        new XingHuoNotOutLibrary(((XingHuoOutLibraryReponse.ResultBean.Bills)var4).getReceiverPhone()),
                        (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                    public final void onSuccess(com.kuaidihelp.posthouse.Response.NotOutLibraryResponse var1x) {
                        if (var1x != null && var1x.getResult() != null && var1x.getResult().size() > 0) {
                            Boolean var2 = isShowMuchPackage;
                            if (var2) {
                                ArrayList var9 = new ArrayList();
                                Iterator var6 = var1x.getResult().iterator();

                                while(var6.hasNext()) {
                                    NotOutLibraryResponse.NotOuBean var3 = (NotOutLibraryResponse.NotOuBean)var6.next();
                                    if (!var3.getBillCode().equals(var1)) {
                                        ShowMuchPackageNoPickBean var4 = new ShowMuchPackageNoPickBean();
                                        var4.setBarcode(var3.getBillCode());
                                        StringBuilder var5 = new StringBuilder();
                                        var5.append(var3.getShelfName());
                                        var5.append("-");
                                        var5.append(var3.getShelfNum());
                                        var4.setPickUpCode(var5.toString());
                                        var4.setInStorageTime(DateUtil.getDateTimeFromMillis(var3.getInstorageTime()));
                                        var9.add(var4);
                                    }
                                }

                                if (var9.size() > 0) {
                                    StringBuilder var11 = new StringBuilder();
                                    var11.append("您还有");
                                    var11.append(var9.size());
                                    var11.append(" 个包裹未取!");
                                    tips.append(var11.toString());
                                    SoundManager.getInstance().playPackageNotDelivered();
                                    return;
                                }

                                return;
                            }
                        }

                        tips.setText("xinghuo out lib success!");

                    }

                    // $FF: synthetic method
                    // $FF: bridge method
                    public void onSuccess(Object var1x) {
                        this.onSuccess((com.kuaidihelp.posthouse.Response.NotOutLibraryResponse)var1x);
                    }
                }));
            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1x) {
                this.onSuccess((XingHuoOutLibraryReponse)var1x);
            }
        }));
    }

    public final void xiniaogaopaiyiOutLib(String var1) {
        XiNiaoGaoPaiLoginBean var2 = RqFilePreference.getInstance().getXiNiaoGaoPaiLoginInfor();
        if (var2 != null) {
            Log.e(LoginActivity.TAG,"xinghuo no login yet!");
            return;
        }


        GaoPaiYiRequest var7 = new GaoPaiYiRequest();
        var7.setWaybillNo(var1);


        var7.setUnionCode(var2.getUnionCode());
        var7.setDeviceCode(var2.getDeviceCode());
        var7.setTimestamp(String.valueOf(System.currentTimeMillis()));
        StringBuilder var5 = new StringBuilder();
        var5.append(var7.getWaybillNo());
        var5.append(var7.getUnionCode());
        var5.append(var7.getDeviceCode());
        var5.append(var7.getTimestamp());
        var5.append(var2.getKey());
        var1 = var5.toString();
        Charset var9 = Charsets.UTF_8;
        if (var1 != null) {
            byte[] var8 = var1.getBytes(var9);
            var7.setSignature(Base64Util.getBaseString(var8));
            OkhttpManager.xiNiaoGaoPai(var7, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                public final void onSuccess(GaoPaiResponse var1) {
                    tips.setText("xiniao out lib success!!");
                }

                // $FF: synthetic method
                // $FF: bridge method
                public void onSuccess(Object var1) {
                    this.onSuccess((GaoPaiResponse)var1);
                }
            }));
        }
    }


    public final void uploadOutLibrary(final String var1, String var2, Bitmap var3) {
        XiaoBinLoginResponseBean var4 = RqFilePreference.getInstance().getXiaoBingLoginInfor();
        if (var4 != null) {
            Object var5 = null;
            XiaoBinLoginResponseBean.DataBean var7;
            if (var4 != null) {
                var7 = var4.getData();
            } else {
                var7 = null;
            }

            if (var7 != null) {

                if (StringUtil.isNotEmpty(var7.getToken())) {

                    OkhttpManager.xiaobinUploadBarcodeImage(var7.getToken(), var2, var1, var3,
                            (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                        public final void onSuccess(XiaoBingUploadResponseBean var1x) {
                            String var5 = JsonUtil.getJsonStringByGson(var1x.getData());
                            if (StringUtil.isNotEmpty(var5) && var5.length() > 20) {
                                Boolean var2 = isShowMuchPackage;
                                if (var2) {
                                    Object var6 = JsonUtil.getClazzByGson(var5, XiaoBingUploadResponseBean.DataBean.class);
                                    if (var6 != null) {
                                        ArrayList var8 = (ArrayList)var6;


                                        StringBuilder var3 = new StringBuilder();
                                        var3.append("您还有");
                                        var3.append(var8.size());
                                        var3.append(" 个包裹未取!");
                                        tips.append(var3.toString());
                                        SoundManager.getInstance().playPackageNotDelivered();
                                        ArrayList var10 = new ArrayList();
                                        Iterator var11 = var8.iterator();


                                        return;
                                    }

                                }
                            }

                            tips.setText(var1+" xiaobing out lib success!!");

                        }

                        // $FF: synthetic method
                        // $FF: bridge method
                        public void onSuccess(Object var1x) {
                            this.onSuccess((XiaoBingUploadResponseBean)var1x);
                        }
                    }));
                }
            }
        }

    }


    public final void jikeyunOutLib(String var1) {
        NetManagerLoginBean loginResponseBean = RqFilePreference.getInstance().getNetManagerLoginInfor();
        String weight = "1";
        BizBean var4 = new BizBean(var1, (int)(Float.parseFloat(weight) * (float)1000), "");

        String var6 = loginResponseBean.getAppkey();

        OkhttpManager.chengZhongDengJi(var6, loginResponseBean.getAppSecret(), var4, (OkhttpManager.OnOkhttpCallbackJKY)(new OkhttpManager.OnOkhttpCallbackJKY() {
            public void onError(int var1, String var2) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tips.setText("Out lib error:"+var2);
                    }
                });

            }

            public void onSuccess(final ResponseChenZhongDdengJi var1) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Button var2;
                        String var5 = "";
                        if (var1 != null) {
                            ResultData var3 = var1.getResult();
                            if (var3 != null) {
                                ResultDataBean var4 = var3.getData();
                                if (var4 != null) {
                                    var5 = var4.getExpressName();
                                }
                            }
                        }
                        tips.setText((CharSequence)var5+" out lib success!!");
                    }
                });

            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((ResponseChenZhongDdengJi)var1);
            }
        }));
    }

    public void miaozhanOutLib(final String var1) {
        ImageSaveUtil.getInstance().setSavePictureByteCallback2((ImageSaveUtil.SavePictureByteCallback2)(new ImageSaveUtil.SavePictureByteCallback2() {
            public final void onGetBarcodeByteAndFaceByte(final byte[] var1x, final byte[] var2) {
                final MiaoZhanLoginBean miaoZhanLoginBean = RqFilePreference.getInstance().getMiaoZhanLoginInfor();
                try {
                    OkhttpManager.miaoZhanOutLibApi(miaoZhanLoginBean, var1, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
                        public final void onSuccess(MiaoZhanBean var1xx) {
                            Boolean var2x = var1xx.getSuccess();
                            if (var2x) {
                                tips.setText(var1 + " out lib success!");
                                OkhttpManager.miaoZhanCheckOutApi(miaoZhanLoginBean, var1, var1x, var2, null);
                            }

                        }
                        public void onSuccess(Object var1xx) {
                            this.onSuccess((MiaoZhanBean)var1xx);
                        }
                    }));
                } catch (Exception var2x) {
                    var2x.printStackTrace();
                }
            }
        }));
    }
    Handler mHandler = new Handler();
    public final void misengOutLib(final String var1) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                String jsonString = JSON.toJSONString(new MSwmsReq(var1, "1.0", (String)null, (String)null, (String)null, (String)null, (String)null, false));
                RequestBody var2 = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonString);
                final Request var3 = (new Request.Builder()).url("http://119.45.7.237:8088/SCANCODE_WEIGHTING/DataExchange/Scancodeweighing/WmsServices.ashx").post(var2).build();
                Response response = null;
                try {
                    response = client.newCall(var3).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (response == null){
                    runOnUiThread((Runnable)(new Runnable() {
                        public final void run() {
                            ToastSoundUtil.wrongSoundToast("some thing is wrong, response is null.");
                        }
                    }));
                    return;
                }
                final String msg = response.message();
                if (response.code() == 200) {
                    runOnUiThread((Runnable)(new Runnable() {
                        public final void run() {
                            tips.setText(var1+" out lib success!!");
                        }
                    }));
                } else {
                    runOnUiThread((Runnable)(new Runnable() {
                        public final void run() {
                            ToastSoundUtil.wrongSoundToast("out lib fail:"+msg);
                        }
                    }));
                }
            }
        }).start();

    }


    public final void zhongyouOutLib(final String var1, final byte[] var2) {
        OkhttpManager.zhongYouWeight(var1, "1.0", (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(ZhongYouUploadWeightResponseBean var1x) {
                if (var1x.getCode() == 200) {
                    tips.setText(var1+" out lib success!");

                    byte[] var2x = var2;
                    if (var2x != null) {
                        OkhttpManager.zhongYouImageUpload(var1, var2x, null);
                    }
                } else {
                    tips.setText(var1+" out lib fail!");
                }

            }
            public void onSuccess(Object var1x) {
                this.onSuccess((ZhongYouUploadWeightResponseBean)var1x);
            }
        }));
    }


    @Override
    public void onLoginSuccess(ExpressStationEnum var1, String var2) {
        Log.e(LoginActivity.TAG,"onLoginSuccess station="+var1.getName()+" var2:"+var2);
    }

    @Override
    public void onOkhttpError(int var1, String var2) {
        Log.e(LoginActivity.TAG,"onOkhttpError station="+var1+" var2:"+var2);
        ToastSoundUtil.wrongSoundToast("onOkhttpError:"+var1+" msg:"+var2);
    }

    @Override
    public void onOkhttpMuchPackageShow(List var1) {
        StringBuffer stringBuffer = new StringBuffer();
        if(MyApplication.getStationEnum() == ExpressStationEnum.DUODUOYIZHAN) {
            if (var1.size() > 0) {
                tips.setText("包裹:\n\r");
                for (Object v : var1) {
                    if (v instanceof ShowMuchPackageNoPickBean) {
                        ShowMuchPackageNoPickBean bean = (ShowMuchPackageNoPickBean) v;
                        stringBuffer.append(bean.getBarcode()+"\t");
                        stringBuffer.append(bean.getPhone()+"\t");
                        stringBuffer.append(bean.getPickUpCode()+"\t");
                        stringBuffer.append(bean.getReceviePerson()+"\t");
                        stringBuffer.append(bean.getInStorageTime()+"\n\r");
                    }
                }
                tips.setText(stringBuffer.toString());
            } else {
                tips.setText("无包裹:\n\r");
            }
        }
        Log.e(LoginActivity.TAG,"onOkhttpError station="+var1+" var2:"+stringBuffer.toString());
    }

    @Override
    public void onOkhttpOutLibrarySuccess(ExpressStationEnum var1, String var2) {
        ToastSoundUtil.scanSuccessToast(var2);
        Log.e(LoginActivity.TAG,"onOkhttpError station="+var1.getName()+" message:"+var2);
    }
}
