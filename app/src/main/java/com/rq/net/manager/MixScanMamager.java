package com.rq.net.manager;


import static okhttp3.internal.Util.UTF_8;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.rq.net.MyApplication;
import com.kuaidihelp.posthouse.R;
import com.rq.net.bean.KDCSQueryStaffAndStoreResponseBean;
import com.rq.net.bean.PinDuoDuoBaseResponseBean;
import com.rq.net.bean.Ref;
import com.rq.net.bean.XiNiaoGaoPaiLoginBean;
import com.rq.net.bean.XiaoBinLoginResponseBean;
import com.rq.net.setting.CommonFilePreference;
import com.rq.net.setting.RqFilePreference;
import com.rq.net.util.Base64Util;
import com.rq.net.util.DateUtil;
import com.rq.net.util.ExpressStationEnum;
import com.rq.net.util.ImageSaveUtil;
import com.rq.net.util.Intrinsics;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.StringUtil;
import com.rq.net.util.SystemUtil;
import com.rq.net.util.ToastSoundUtil;

import com.rq.net.BaseActivity;
import com.rq.net.bean.BoundDetailList;
import com.rq.net.bean.CurrentParcel;
import com.rq.net.bean.FcboxCheckBarcodeResponseBean;
import com.rq.net.bean.FcboxQueryPackageBean;
import com.rq.net.bean.FcboxSignBean;
import com.rq.net.bean.FcboxStationInforResponseBean;
import com.rq.net.bean.GaoPaiYiRequest;
import com.rq.net.bean.KDCSCheckOutLibraryBillCodeInforBean;
import com.rq.net.bean.KDCSCheckResponseBean;
import com.rq.net.bean.KDCSLoginResponseBean;
import com.rq.net.bean.KDCSOutLibraryData;
import com.rq.net.bean.KDCSQueryStaffAndStoreResponseBean;
import com.rq.net.bean.KuaiBaoDeliveryStorageBean;
import com.rq.net.bean.KuaiBaoGetUserUnPickUpListsBean;
import com.rq.net.bean.KuaiBaoGetUserUnPickUpListsResponseBean;
import com.rq.net.bean.KuaiBaoLoginBean;
import com.rq.net.bean.KuaiBaoLoginResponseBean;
import com.rq.net.bean.KuaiBaoQueryBillcodeInforBean;
import com.rq.net.bean.KuaiBaoQueryBillcodeInforResponseBean;
import com.rq.net.bean.LaiquLoginResponseBean;
import com.rq.net.bean.LaiquOutLibraryBean;
import com.rq.net.bean.LaiquOutLibraryResponseBean;
import com.rq.net.bean.LaiquSiteLoginResponseBean;
import com.rq.net.bean.MaMaCheckInforBean;
import com.rq.net.bean.MaMaLoginBean;
import com.rq.net.bean.MaMaLoginResponseBean;
import com.rq.net.bean.MaMaOutLibraryBean;
import com.rq.net.bean.MaMaQueryBarcodeBean;
import com.rq.net.bean.MaMaQueryBarcodeResponseBean;
import com.rq.net.bean.PandaBeanKt;
import com.rq.net.bean.PandaLoginBean;
import com.rq.net.bean.PandaOutData;
import com.rq.net.bean.PandaOutLibCall;
import com.rq.net.bean.PinDuoDuoBaseResponseBean;
import com.rq.net.bean.PinDuoDuoOutLibraryAioResponseBean;
import com.rq.net.bean.QuerySendOrderDataResponseBean;
import com.rq.net.bean.QuerySendOrderResponseBean;
import com.rq.net.bean.ShowMuchPackageNoPickBean;
import com.rq.net.bean.XiNiaoGaoPaiLoginBean;
import com.rq.net.bean.XiaoBinLoginResponseBean;
import com.rq.net.bean.XiaoBingUploadResponseBean;
import com.rq.net.bean.YshouFaLoginResponseBean;
import com.rq.net.bean.YunDaKDCSLoginResponseBean;
import com.rq.net.bean.YunDaKDCSUploadBean;
import com.rq.net.bean.YunDaNewKDCSCheckResponseBean;
import com.rq.net.bean.FcboxSignBean.ExpressInfosBean;
import com.rq.net.bean.KDCSCheckResponseBean.Items;
import com.rq.net.bean.KDCSOutLibraryData.OutLibraryData;
import com.rq.net.bean.KuaiBaoGetUserUnPickUpListsResponseBean.ResultBean;
import com.rq.net.bean.KuaiBaoLoginBean.LoginData;
import com.rq.net.bean.KuaiBaoQueryBillcodeInforBean.BillcodeInforData;
import com.rq.net.bean.LaiquLoginResponseBean.ServiceSitesBean;
import com.rq.net.bean.LaiquOutLibraryResponseBean.GoodsListBean;
import com.rq.net.bean.LaiquOutLibraryResponseBean.WaybillsRelatedBean;
import com.rq.net.bean.XiaoBinLoginResponseBean.DataBean;
import com.rq.net.bean.YunDaKDCSUploadBean.ItemsBean;
import com.rq.net.bean.YunDaKDCSUploadBean.MyAgentInfoBean;
import com.rq.net.util.ExpressStationEnum;
import com.rq.net.manager.OkHttpPinDuoDuoManager;
import com.rq.net.manager.OkhttpManager;
import com.rq.net.manager.OkHttpPinDuoDuoManager.OnHttpCallback;
import com.rq.net.manager.OkhttpManager.OnHttpErrorCallback;
import com.rq.net.manager.OkhttpManager.OnOkhttpCallback;
import com.rq.net.manager.OkhttpManager.OnOkhttpCallbackError;
import com.rq.net.util.MD5Util;
import com.rq.net.util.Md5InputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class MixScanMamager {
    private String TAG;
    private final Context context;
    private ArrayList errorList;
    private int laiquIndex;
    private String mBarcode;
    private MixScanMamager.OkhttpCallbackStationManager mOkhttpStaionCallback;
    private OkhttpManager.OnHttpErrorCallback onHttpErrorCallback;
    private int querySelectItem;
    private WeakReference referenceContext;
    private KDCSQueryStaffAndStoreResponseBean staffAndStore;
    private KDCSQueryStaffAndStoreResponseBean storeResponseBean;
    private String token;
    private XiaoBinLoginResponseBean xbLoginResponseBean;
    private XiNiaoGaoPaiLoginBean xnLoginResponseBean;

    public MixScanMamager(Context var1) {

        this.context = var1;
        this.TAG = "MixScanMamager";
        this.errorList = new ArrayList();
        this.referenceContext = new WeakReference(this.context);
        this.token = "";
    }

    public final void duoduoLogin(final String var1, final String var2, final String var3, final MixScanMamager.OkhttpCallBackDuoDuo var4) {
        String var5 = this.TAG;
        StringBuilder var6 = new StringBuilder();
        var6.append("verifyauthtoken: ===================================");
        var6.append(var3);
        Log.d(var5, var6.toString());
        OkHttpPinDuoDuoManager.getPasswordPublicKey(this.context, var3, (OkhttpManager.OnOkhttpCallback)(new OnOkhttpCallback() {
            public void onSuccess(PinDuoDuoBaseResponseBean var1x) {
                if (var1x == null) {
                    ////Intrinsics.throwNpe();
                    return;
                }

                if (var1x.getSuccess()) {
                    String var4x = MixScanMamager.this.getTAG();
                    StringBuilder var3x = new StringBuilder();
                    var3x.append("onSuccess: ===================================");
                    var3x.append(var3);
                    Log.d(var4x, var3x.toString());
                    OkHttpPinDuoDuoManager.loginByMobile(MixScanMamager.this.getContext(), var3, var1, var2, (String)var1x.getResult(), (OnOkhttpCallback)(new OnOkhttpCallback() {
                        public final void onSuccess(Object var1x) {
                            Log.d(MixScanMamager.this.getTAG(), "多多登录成功: =====================");
                            MixScanMamager.OkhttpCallbackStationManager var2x = MixScanMamager.this.getMOkhttpStaionCallback();
                            if (var2x != null) {
                                var2x.onLoginSuccess(ExpressStationEnum.DUODUOYIZHAN, "多多登录成功");
                            }

                        }
                    }), (OkhttpManager.OnHttpErrorCallback)(new OkhttpManager.OnHttpErrorCallback() {
                        public final void onError(int var1x, String var2x) {
                            Log.d(MixScanMamager.this.getTAG(), "多多登录失败: =====================");
                            MixScanMamager.OkhttpCallBackDuoDuo var3x = var4;
                            //////Intrinsics.checkExpressionValueIsNotNull(var2x, "verify");
                            var3x.onOkhttpError(var1x, var2x);
                        }
                    }));
                } else {
                    var1x.getErrorCode();
                    var1x.getResult();
                    StringBuilder var2x = new StringBuilder();
                    var2x.append(var1x.getErrorMsg());
                    var2x.append(var1x.getError_msg());
                    ToastSoundUtil.wrongSoundToast(var2x.toString());
                }
            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1x) {
                this.onSuccess((PinDuoDuoBaseResponseBean)var1x);
            }
        }));
    }

    public final void fcboxLogin(String var1, String var2) {
        /*////Intrinsics.checkParameterIsNotNull(var1, "username");
        ////Intrinsics.checkParameterIsNotNull(var2, "passoword");*/
        OkhttpManager.fengchaoServiceLoginApi(var1, var2, (OnOkhttpCallback)(new OnOkhttpCallback() {
            public final void onSuccess(Object var1) {
                MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                if (var2 != null) {
                    var2.onLoginSuccess(ExpressStationEnum.FENGCHAOSERVICE, "丰巢服务站登录成功");
                }

            }
        }));
    }

    public final Context getContext() {
        return this.context;
    }

    public final ArrayList getErrorList() {
        return this.errorList;
    }

    public final int getLaiquIndex() {
        return this.laiquIndex;
    }

    public final String getMBarcode() {
        return this.mBarcode;
    }

    public final MixScanMamager.OkhttpCallbackStationManager getMOkhttpStaionCallback() {
        return this.mOkhttpStaionCallback;
    }

    public final OnHttpErrorCallback getOnHttpErrorCallback() {
        return this.onHttpErrorCallback;
    }

    public final int getQuerySelectItem() {
        return this.querySelectItem;
    }

    public final WeakReference getReferenceContext() {
        return this.referenceContext;
    }

    public final KDCSQueryStaffAndStoreResponseBean getStaffAndStore() {
        return this.staffAndStore;
    }

    public final KDCSQueryStaffAndStoreResponseBean getStoreResponseBean() {
        return this.storeResponseBean;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final String getToken() {
        return this.token;
    }

    public final XiaoBinLoginResponseBean getXbLoginResponseBean() {
        return this.xbLoginResponseBean;
    }

    public final XiNiaoGaoPaiLoginBean getXnLoginResponseBean() {
        return this.xnLoginResponseBean;
    }

    public final void kdcsLogin(String var1, String var2) {
        ////Intrinsics.checkParameterIsNotNull(var1, "username");
        ////Intrinsics.checkParameterIsNotNull(var2, "passoword");
        OkhttpManager.kdcsLogin(var1, var2, (OnOkhttpCallback)(new OnOkhttpCallback() {
            public final void onSuccess(KDCSLoginResponseBean var1) {
                MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                if (var2 != null) {
                    var2.onLoginSuccess(ExpressStationEnum.KUAIDICAOSHI, "兔喜快递超市登录成功");
                }

            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((KDCSLoginResponseBean)var1);
            }
        }), (OnOkhttpCallbackError)null);
    }

    public final void kuaibaoLogin(String var1, String var2) {
        ////Intrinsics.checkParameterIsNotNull(var1, "username");
        ////Intrinsics.checkParameterIsNotNull(var2, "passoword");
        KuaiBaoLoginBean var3 = new KuaiBaoLoginBean();
        var3.setData(JsonUtil.getJsonStringByGson(new LoginData(var1, var2)));
        OkhttpManager.kuaibaoLoginApi(var3, var3.getSession_id(), (OnOkhttpCallback)(new OnOkhttpCallback() {
            public final void onSuccess(KuaiBaoLoginResponseBean var1) {
                MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                if (var2 != null) {
                    var2.onLoginSuccess(ExpressStationEnum.KUAIBAO, "快宝登录成功");
                }

            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((KuaiBaoLoginResponseBean)var1);
            }
        }));
    }

    public final void laiquLogin(String var1, String var2) {
        ////Intrinsics.checkParameterIsNotNull(var1, "username");
        ////Intrinsics.checkParameterIsNotNull(var2, "passoword");
        OkhttpManager.getLaiquRsaPublicKey(var1, var2, (OnOkhttpCallback)(new OnOkhttpCallback() {
            public final void onSuccess(LaiquLoginResponseBean var1) {
                Exception var10000;
                label99: {
                    StringBuilder var5;
                    String var16;
                    Object var17;
                    boolean var10001;
                    final Ref.ObjectRef var21;
                    try {
                        ////Intrinsics.checkExpressionValueIsNotNull(var1, "data");
                        var16 = JsonUtil.getJsonStringByGson(var1.getServiceSites());
                        String var4 = MixScanMamager.this.getTAG();
                        var5 = new StringBuilder();
                        var5.append("laiqu result:");
                        var5.append(var16);
                        Log.e(var4, var5.toString());
                        if (!StringUtil.isNotEmpty(var16) || var16.length() <= 20) {
                            return;
                        }

                        var21 = new Ref.ObjectRef();
                        var17 = JsonUtil.getClazzByGson(var16, ServiceSitesBean.class);
                    } catch (Exception var14) {
                        var10000 = var14;
                        var10001 = false;
                        break label99;
                    }

                    if (var17 != null) {
                        label101: {
                            int var2;
                            try {
                                var21.element = (ArrayList)var17;
                                var16 = MixScanMamager.this.getTAG();
                                var5 = new StringBuilder();
                                var5.append("laiqu net station count:");
                                var5.append(((ArrayList)var21.element).size());
                                Log.e(var16, var5.toString());
                                var2 = ((ArrayList)var21.element).size();
                            } catch (Exception var13) {
                                var10000 = var13;
                                var10001 = false;
                                break label101;
                            }

                            RqFilePreference var18;
                            if (var2 <= 1) {
                                try {
                                    var17 = ((ArrayList)var21.element).get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var17, "resultList[0]");
                                    OkhttpManager.laiquSiteLogin(((ServiceSitesBean)var17).getServiceSiteCode(), (OnOkhttpCallback)(new OnOkhttpCallback() {
                                        public final void onSuccess(LaiquSiteLoginResponseBean var1) {
                                            MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                                            if (var2 != null) {
                                                var2.onLoginSuccess(ExpressStationEnum.LAIQU, "来取登录成功");
                                            }

                                        }

                                        // $FF: synthetic method
                                        // $FF: bridge method
                                        public void onSuccess(Object var1) {
                                            this.onSuccess((LaiquSiteLoginResponseBean)var1);
                                        }
                                    }));
                                    var18 = RqFilePreference.getInstance();
                                    ////Intrinsics.checkExpressionValueIsNotNull(var18, "RqFilePreference.getInstance()");
                                    Object var23 = ((ArrayList)var21.element).get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var23, "resultList[0]");
                                    var18.setLoginLaiQuServiceStaionCode(((ServiceSitesBean)var23).getServiceSiteCode());
                                    return;
                                } catch (Exception var7) {
                                    var10000 = var7;
                                    var10001 = false;
                                }
                            } else {
                                label103: {
                                    try {
                                        var18 = RqFilePreference.getInstance();
                                        ////Intrinsics.checkExpressionValueIsNotNull(var18, "RqFilePreference.getInstance()");
                                        if (StringUtil.isNotEmpty(var18.getLoginLaiQuServiceStaionCode())) {
                                            var18 = RqFilePreference.getInstance();
                                            ////Intrinsics.checkExpressionValueIsNotNull(var18, "RqFilePreference.getInstance()");
                                            OkhttpManager.laiquSiteLogin(var18.getLoginLaiQuServiceStaionCode(), (OnOkhttpCallback)(new OnOkhttpCallback() {
                                                public final void onSuccess(LaiquSiteLoginResponseBean var1) {
                                                    MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                                                    if (var2 != null) {
                                                        var2.onLoginSuccess(ExpressStationEnum.LAIQU, "来取登录成功");
                                                    }

                                                }

                                                // $FF: synthetic method
                                                // $FF: bridge method
                                                public void onSuccess(Object var1) {
                                                    this.onSuccess((LaiquSiteLoginResponseBean)var1);
                                                }
                                            }));
                                            return;
                                        }
                                    } catch (Exception var15) {
                                        var10000 = var15;
                                        var10001 = false;
                                        break label103;
                                    }

                                    int var3;
                                    String[] var24;
                                    try {
                                        var24 = new String[((ArrayList)var21.element).size()];
                                        var3 = ((ArrayList)var21.element).size();
                                    } catch (Exception var12) {
                                        var10000 = var12;
                                        var10001 = false;
                                        break label103;
                                    }

                                    for(var2 = 0; var2 < var3; ++var2) {
                                        try {
                                            var17 = ((ArrayList)var21.element).get(var2);
                                            ////Intrinsics.checkExpressionValueIsNotNull(var17, "resultList[i]");
                                            var24[var2] = ((ServiceSitesBean)var17).getServiceSiteName();
                                        } catch (Exception var11) {
                                            var10000 = var11;
                                            var10001 = false;
                                            break label103;
                                        }
                                    }

                                    WeakReference var19;
                                    try {
                                        var19 = MixScanMamager.this.getReferenceContext();
                                    } catch (Exception var10) {
                                        var10000 = var10;
                                        var10001 = false;
                                        break label103;
                                    }

                                    Context var20;
                                    if (var19 != null) {
                                        try {
                                            var20 = (Context)var19.get();
                                        } catch (Exception var9) {
                                            var10000 = var9;
                                            var10001 = false;
                                            break label103;
                                        }
                                    } else {
                                        var20 = null;
                                    }

                                    try {
                                        (new Builder(var20)).setTitle((CharSequence)"请选择门店").setIcon(R.mipmap.setting_laiqu_uploadpic_icon).setSingleChoiceItems((CharSequence[])var24, 0, (OnClickListener)(new OnClickListener() {
                                            public final void onClick(DialogInterface var1, int var2) {
                                                MixScanMamager.this.setLaiquIndex(var2);
                                            }
                                        })).setCancelable(false).setPositiveButton((CharSequence)"确定", (OnClickListener)(new OnClickListener() {
                                            public final void onClick(DialogInterface var1, int var2) {
                                                String var3 = MixScanMamager.this.getTAG();
                                                StringBuilder var4 = new StringBuilder();
                                                var4.append("");
                                                var4.append(MixScanMamager.this.getLaiquIndex());
                                                var4.append("    ");
                                                Object var5 = ((ArrayList)var21.element).get(MixScanMamager.this.getLaiquIndex());
                                                ////Intrinsics.checkExpressionValueIsNotNull(var5, "resultList[laiquIndex]");
                                                var4.append(((ServiceSitesBean)var5).getServiceSiteName());
                                                var4.append("=======");
                                                var5 = ((ArrayList)var21.element).get(MixScanMamager.this.getLaiquIndex());
                                                ////Intrinsics.checkExpressionValueIsNotNull(var5, "resultList[laiquIndex]");
                                                var4.append(((ServiceSitesBean)var5).getServiceSiteCode());
                                                Log.e(var3, var4.toString());
                                                Object var6 = ((ArrayList)var21.element).get(MixScanMamager.this.getLaiquIndex());
                                                ////Intrinsics.checkExpressionValueIsNotNull(var6, "resultList[laiquIndex]");
                                                var3 = ((ServiceSitesBean)var6).getServiceSiteCode();
                                                RqFilePreference var7 = RqFilePreference.getInstance();
                                                ////Intrinsics.checkExpressionValueIsNotNull(var7, "RqFilePreference.getInstance()");
                                                var7.setLoginLaiQuServiceStaionCode(var3);
                                                OkhttpManager.laiquSiteLogin(var3, (OnOkhttpCallback)(new OnOkhttpCallback() {
                                                    public final void onSuccess(LaiquSiteLoginResponseBean var1) {
                                                        MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                                                        if (var2 != null) {
                                                            var2.onLoginSuccess(ExpressStationEnum.LAIQU, "来取登录成功");
                                                        }

                                                    }

                                                    // $FF: synthetic method
                                                    // $FF: bridge method
                                                    public void onSuccess(Object var1) {
                                                        this.onSuccess((LaiquSiteLoginResponseBean)var1);
                                                    }
                                                }));
                                                var1.dismiss();
                                            }
                                        })).setNegativeButton((CharSequence)"取消", (OnClickListener)null).show();
                                        return;
                                    } catch (Exception var8) {
                                        var10000 = var8;
                                        var10001 = false;
                                    }
                                }
                            }
                        }
                    } else {
//                        try {
//                            throw new Exception("null cannot be cast to non-null type kotlin.collections.ArrayList<com.rq.net.bean.LaiquLoginResponseBean.ServiceSitesBean> /* = java.util.ArrayList<com.rq.net.bean.LaiquLoginResponseBean.ServiceSitesBean> */");
//                        } catch (Exception var6) {
//                            var10000 = var6;
//                            var10001 = false;
//                        }
                    }
                }

               /* Exception var22 = var10000;
                var22.printStackTrace();*/
            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((LaiquLoginResponseBean)var1);
            }
        }));
    }

    public final void mamaLogin(String var1, String var2) {
        ////Intrinsics.checkParameterIsNotNull(var1, "username");
        ////Intrinsics.checkParameterIsNotNull(var2, "passoword");
        MaMaLoginBean var3 = new MaMaLoginBean();
        var3.setVersionNo("v-6.6.22.4");
        var3.setModelNo(SystemUtil.getSystemModel());
        CommonFilePreference var4 = CommonFilePreference.getInstance();
        ////Intrinsics.checkExpressionValueIsNotNull(var4, "CommonFilePreference.getInstance()");
        if (StringUtil.isEmpty(var4.getUUID())) {
            var4 = CommonFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var4, "CommonFilePreference.getInstance()");
            var4.setUUID(SystemUtil.getAppUUID((Context) MyApplication.baseApp));
        }

        var4 = CommonFilePreference.getInstance();
        ////Intrinsics.checkExpressionValueIsNotNull(var4, "CommonFilePreference.getInstance()");
        var3.setSerialNo(var4.getUUID());
        var3.setUsername(var1);
        var1 = Base64Util.getBaseString(MD5Util.encodeMd5ToByte(var2));
        ////Intrinsics.checkExpressionValueIsNotNull(var1, "Base64Util.getBaseString…codeMd5ToByte(passoword))");
        var3.setPassword(var1.replace("\n", ""));
        OkhttpManager.mamaLoginApi(var3, (OnOkhttpCallback)(new OnOkhttpCallback() {
            public final void onSuccess(MaMaLoginResponseBean var1) {
                MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                if (var2 != null) {
                    var2.onLoginSuccess(ExpressStationEnum.MAMASTATION, "妈妈驿站登录成功");
                }

            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((MaMaLoginResponseBean)var1);
            }
        }));
    }

    public final void mixGetNotTakenPackage(ExpressStationEnum var1, Object var2) {
        // $FF: Couldn't be decompiled
    }

    public final long mixLoginAll() {
        long var3;
        long var5;
        RqFilePreference var8;
        RqFilePreference var11;
        String var13;
        String var14;
        label146: {
            label145: {
                this.querySelectItem = 0;
                CommonFilePreference var7 = CommonFilePreference.getInstance();
                ////Intrinsics.checkExpressionValueIsNotNull(var7, "CommonFilePreference.getInstance()");
                var5 = var7.getMixSelectSystemType();
                ExpressStationEnum.CAINIAO.getItem();
                if ((ExpressStationEnum.KUAIBAO.getItem() & var5) > 0L) {
                    var11 = RqFilePreference.getInstance();
                    ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
                    KuaiBaoLoginResponseBean var12 = var11.getKuaibaoLoginInfor();
                    if (var12 == null || !StringUtil.isNotEmpty(var12.getSession_id())) {
                        break label145;
                    }

                    var11 = RqFilePreference.getInstance();
                    ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
                    if (!StringUtil.isNotEmpty(var11.getLoginUsername())) {
                        break label145;
                    }

                    var11 = RqFilePreference.getInstance();
                    ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
                    var14 = var11.getLoginKuaiBaoUsername();
                    var8 = RqFilePreference.getInstance();
                    ////Intrinsics.checkExpressionValueIsNotNull(var8, "RqFilePreference.getInstance()");
                    var13 = var8.getLoginKuaiBaoPassword();
                    ////Intrinsics.checkExpressionValueIsNotNull(var14, "kuaibaoUserName");
                    ////Intrinsics.checkExpressionValueIsNotNull(var13, "kuaibaoPassword");
                    this.kuaibaoLogin(var14, var13);
                }

                var3 = 0L;
                break label146;
            }

            var3 = ExpressStationEnum.KUAIBAO.getItem() + 0L;
        }

        long var1 = var3;
        if ((ExpressStationEnum.KUAIDICAOSHI.getItem() & var5) > 0L) {
            label133: {
                var11 = RqFilePreference.getInstance();
                ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
                var14 = var11.getLoginKDCSUsername();
                var8 = RqFilePreference.getInstance();
                ////Intrinsics.checkExpressionValueIsNotNull(var8, "RqFilePreference.getInstance()");
                var8.getLoginKDCSPassword();
                var8 = RqFilePreference.getInstance();
                ////Intrinsics.checkExpressionValueIsNotNull(var8, "RqFilePreference.getInstance()");
                if (var8.getKDCSLoginInfor() != null) {
                    var8 = RqFilePreference.getInstance();
                    ////Intrinsics.checkExpressionValueIsNotNull(var8, "RqFilePreference.getInstance()");
                    KDCSLoginResponseBean var16 = var8.getKDCSLoginInfor();
                    ////Intrinsics.checkExpressionValueIsNotNull(var16, "RqFilePreference.getInstance().kdcsLoginInfor");
                    if (StringUtil.isNotEmpty(var16.getRefresh_token()) && StringUtil.isNotEmpty(var14)) {
                        OkhttpManager.kdcsRefreshToken((OnOkhttpCallback)(new OnOkhttpCallback() {
                            public final void onSuccess(KDCSLoginResponseBean var1) {
                                if (MixScanMamager.this.getStoreResponseBean() == null) {
                                    MixScanMamager var3 = MixScanMamager.this;
                                    RqFilePreference var2 = RqFilePreference.getInstance();
                                    ////Intrinsics.checkExpressionValueIsNotNull(var2, "RqFilePreference.getInstance()");
                                    var3.setStoreResponseBean(var2.getKDCSQueryStaffAndStore());
                                }

                                if (MixScanMamager.this.getStoreResponseBean() == null) {
                                    OkhttpManager.kdcsQueryStaffAndStoreInfor();
                                }

                                if (MixScanMamager.this.getMOkhttpStaionCallback() != null) {
                                    MixScanMamager.OkhttpCallbackStationManager var4 = MixScanMamager.this.getMOkhttpStaionCallback();
                                    if (var4 != null) {
                                        var4.onLoginSuccess(ExpressStationEnum.KUAIDICAOSHI, "兔喜登录成功");
                                    }
                                }

                            }

                            // $FF: synthetic method
                            // $FF: bridge method
                            public void onSuccess(Object var1) {
                                this.onSuccess((KDCSLoginResponseBean)var1);
                            }
                        }));
                        var1 = var3;
                        break label133;
                    }
                }

                var1 = var3 + ExpressStationEnum.KUAIDICAOSHI.getItem();
            }
        }

        var3 = var1;
        RqFilePreference var9;
        if ((ExpressStationEnum.MAMASTATION.getItem() & var5) > 0L) {
            var11 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
            var14 = var11.getLoginMaMaUsername();
            var8 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var8, "RqFilePreference.getInstance()");
            var13 = var8.getLoginMaMaPassword();
            var9 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var9, "RqFilePreference.getInstance()");
            MaMaLoginResponseBean var15 = var9.getMaMaLoginInfor();
            if (var15 != null && StringUtil.isNotEmpty(var15.getOrgCode()) && StringUtil.isNotEmpty(var14)) {
                ////Intrinsics.checkExpressionValueIsNotNull(var14, "mamaUserName");
                ////Intrinsics.checkExpressionValueIsNotNull(var13, "mamaPassword");
                this.mamaLogin(var14, var13);
                var3 = var1;
            } else {
                var3 = var1 + ExpressStationEnum.MAMASTATION.getItem();
            }
        }

        var1 = var3;
        if ((ExpressStationEnum.LAIQU.getItem() & var5) > 0L) {
            var11 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
            var14 = var11.getLoginLaiQuUsername();
            var8 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var8, "RqFilePreference.getInstance()");
            var13 = var8.getLoginLaiQuPassword();
            var9 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var9, "RqFilePreference.getInstance()");
            LaiquLoginResponseBean var17 = var9.getLaiquLoginInfor();
            if (var17 != null && StringUtil.isNotEmpty(var17.getToken()) && StringUtil.isNotEmpty(var14)) {
                ////Intrinsics.checkExpressionValueIsNotNull(var14, "laiquUserName");
                ////Intrinsics.checkExpressionValueIsNotNull(var13, "laiquPassword");
                this.laiquLogin(var14, var13);
                var1 = var3;
            } else {
                var1 = var3 + ExpressStationEnum.LAIQU.getItem();
            }
        }

        var3 = var1;
        if ((ExpressStationEnum.YUNDAKDCS.getItem() & var5) > 0L) {
            var11 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
            var14 = var11.getLoginYunDaKDCSUsername();
            var8 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var8, "RqFilePreference.getInstance()");
            var13 = var8.getLoginYunDaKDCSPassword();
            var9 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var9, "RqFilePreference.getInstance()");
            YunDaKDCSLoginResponseBean var18 = var9.getYunDaKDCSLoginInfor();
            if (var18 != null && StringUtil.isNotEmpty(var18.getToken()) && StringUtil.isNotEmpty(var14)) {
                ////Intrinsics.checkExpressionValueIsNotNull(var14, "yundakdcsUserName");
                ////Intrinsics.checkExpressionValueIsNotNull(var13, "yundakdcsPassword");
                this.yundaKdcsLogin(var14, var13);
                var3 = var1;
            } else {
                var3 = var1 + ExpressStationEnum.YUNDAKDCS.getItem();
            }
        }

        var1 = var3;
        if ((ExpressStationEnum.FENGCHAOSERVICE.getItem() & var5) > 0L) {
            var11 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
            var14 = var11.getLoginFcboxUsername();
            var8 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var8, "RqFilePreference.getInstance()");
            var13 = var8.getLoginFcboxPassword();
            var9 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var9, "RqFilePreference.getInstance()");
            FcboxStationInforResponseBean var19 = var9.getFcboxStationInfor();
            if (var19 != null && StringUtil.isNotEmpty(var19.getDetailAddress()) && StringUtil.isNotEmpty(var14)) {
                ////Intrinsics.checkExpressionValueIsNotNull(var14, "fcboxUserName");
                ////Intrinsics.checkExpressionValueIsNotNull(var13, "fcboxPassword");
                this.fcboxLogin(var14, var13);
                var1 = var3;
            } else {
                var1 = var3 + ExpressStationEnum.FENGCHAOSERVICE.getItem();
            }
        }

        var3 = var1;
        if ((ExpressStationEnum.XIAOBINGSTATION.getItem() & var5) > 0L) {
            label98: {
                var11 = RqFilePreference.getInstance();
                ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
                var14 = var11.getLoginXiaoBinUsername();
                var8 = RqFilePreference.getInstance();
                ////Intrinsics.checkExpressionValueIsNotNull(var8, "RqFilePreference.getInstance()");
                var13 = var8.getLoginXiaoBinPassword();
                var9 = RqFilePreference.getInstance();
                ////Intrinsics.checkExpressionValueIsNotNull(var9, "RqFilePreference.getInstance()");
                XiaoBinLoginResponseBean var20 = var9.getXiaoBingLoginInfor();
                if (var20 != null && var20.getData() != null) {
                    DataBean var10 = var20.getData();
                    ////Intrinsics.checkExpressionValueIsNotNull(var10, "stationResponseBean.data");
                    if (StringUtil.isNotEmpty(var10.getToken())) {
                        DataBean var21 = var20.getData();
                        ////Intrinsics.checkExpressionValueIsNotNull(var21, "stationResponseBean.data");
                        if (StringUtil.isNotEmpty(var21.getAppKey())) {
                            ////Intrinsics.checkExpressionValueIsNotNull(var14, "xiaobinUserName");
                            ////Intrinsics.checkExpressionValueIsNotNull(var13, "xiaobinPassword");
                            this.xiaoBinLogin(var14, var13);
                            var3 = var1;
                            break label98;
                        }
                    }
                }

                var3 = var1 + ExpressStationEnum.XIAOBINGSTATION.getItem();
            }
        }

        var1 = var3;
        if ((ExpressStationEnum.XINIAOGAOPAIYI.getItem() & var5) > 0L) {
            label90: {
                var11 = RqFilePreference.getInstance();
                ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
                XiNiaoGaoPaiLoginBean var23 = var11.getXiNiaoGaoPaiLoginInfor();
                if (var23 != null && var23.getDeviceCode() != null && var23.getKey() != null) {
                    var8 = RqFilePreference.getInstance();
                    ////Intrinsics.checkExpressionValueIsNotNull(var8, "RqFilePreference.getInstance()");
                    if (StringUtil.isNotEmpty(var8.getLoginUsername())) {
                        var13 = var23.getUnionCode();
                        ////Intrinsics.checkExpressionValueIsNotNull(var13, "loginResponseBean!!.unionCode");
                        String var22 = var23.getDeviceCode();
                        ////Intrinsics.checkExpressionValueIsNotNull(var22, "loginResponseBean!!.deviceCode");
                        var14 = var23.getKey();
                        ////Intrinsics.checkExpressionValueIsNotNull(var14, "loginResponseBean!!.key");
                        this.xiNiaoGaoPaiLogin(var13, var22, var14);
                        var1 = var3;
                        break label90;
                    }
                }

                var1 = var3 + ExpressStationEnum.XINIAOGAOPAIYI.getItem();
            }
        }

        var3 = var1;
        if ((ExpressStationEnum.YSHOUFA.getItem() & var5) > 0L) {
            label82: {
                var11 = RqFilePreference.getInstance();
                ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
                if (var11.getYshouFaLoginRes() != null) {
                    var11 = RqFilePreference.getInstance();
                    ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
                    if (var11.getAutoLogin()) {
                        var11 = RqFilePreference.getInstance();
                        ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
                        if (StringUtil.isNotEmpty(var11.getYshouFaUserName())) {
                            var11 = RqFilePreference.getInstance();
                            ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
                            if (StringUtil.isNotEmpty(var11.getYshouFaUserType())) {
                                var11 = RqFilePreference.getInstance();
                                ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
                                var14 = var11.getYshouFaUserName();
                                var8 = RqFilePreference.getInstance();
                                ////Intrinsics.checkExpressionValueIsNotNull(var8, "RqFilePreference.getInstance()");
                                var13 = var8.getYshouFaPassWord();
                                var9 = RqFilePreference.getInstance();
                                ////Intrinsics.checkExpressionValueIsNotNull(var9, "RqFilePreference.getInstance()");
                                var9.getYshouFaUserType();
                                OkhttpManager.yShouFaLogin(var14, var13, (OnOkhttpCallback)(new OnOkhttpCallback() {
                                    public final void onSuccess(Object var1) {
                                        MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                                        if (var2 != null) {
                                            var2.onLoginSuccess(ExpressStationEnum.YSHOUFA, "驿收发登录成功");
                                        }

                                    }
                                }));
                                var3 = var1;
                                break label82;
                            }
                        }
                    }
                }

                var3 = var1 + ExpressStationEnum.YSHOUFA.getItem();
            }
        }

        var1 = var3;
        if ((var5 & ExpressStationEnum.PANDAHARVEST.getItem()) > 0L) {
            var11 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var11, "RqFilePreference.getInstance()");
            PandaLoginBean var24 = var11.getPandaHarvestInforTwo();
            if (var24 != null) {
                var8 = RqFilePreference.getInstance();
                ////Intrinsics.checkExpressionValueIsNotNull(var8, "RqFilePreference.getInstance()");
                if (var8.getAutoLogin() && StringUtil.isNotEmpty(var24.getUserName()) && StringUtil.isNotEmpty(var24.getUserPwd())) {
                    this.pandaHarvestLogin(var24.getUserName(), var24.getUserPwd());
                    return var3;
                }
            }

            var1 = var3 + ExpressStationEnum.PANDAHARVEST.getItem();
        }

        return var1;
    }

    public final void mixQueryCompanyBarcode(final String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "barcode");
        this.querySelectItem = 0;
        this.errorList.clear();
        CommonFilePreference var4 = CommonFilePreference.getInstance();
        ////Intrinsics.checkExpressionValueIsNotNull(var4, "CommonFilePreference.getInstance()");
        long var2 = var4.getMixSelectSystemType();
        if ((ExpressStationEnum.CAINIAO.getItem() & var2) > 0L) {
            WeakReference var9 = this.referenceContext;
            Context var10;
            if (var9 != null) {
                var10 = (Context)var9.get();
            } else {
                var10 = null;
            }

            if (var10 == null) {
                //throw new Exception("null cannot be cast to non-null type com.kuaidihelp.posthouse.activity.BaseActivity");
                return;
            }

            ((BaseActivity)var10).saveData(var1, "", ExpressStationEnum.CAINIAO.getTitle(), "");
        }

        if ((ExpressStationEnum.KUAIBAO.getItem() & var2) > 0L) {
            ++this.querySelectItem;
            KuaiBaoQueryBillcodeInforBean var12 = new KuaiBaoQueryBillcodeInforBean();
            var12.setData(JsonUtil.getJsonStringByGson(new BillcodeInforData("1", "1", var1, "")));
            OkhttpManager.kuaibaoQueryBillcodeInforApi(var12, (OnOkhttpCallback)(new OnOkhttpCallback() {
                public final void onSuccess(final KuaiBaoQueryBillcodeInforResponseBean var1x) {
                    if (var1x != null && StringUtil.isNotEmpty(var1x.getWaybillNo())) {
                        WeakReference var2 = MixScanMamager.this.getReferenceContext();
                        Context var3;
                        if (var2 != null) {
                            var3 = (Context)var2.get();
                        } else {
                            var3 = null;
                        }

                        if (var3 != null) {
                            ((BaseActivity)var3).saveData(var1x.getWaybillNo(), var1x.getBrand_cn(), ExpressStationEnum.KUAIBAO.getTitle(), var1x.getPhone());
                            KuaiBaoGetUserUnPickUpListsBean var4 = new KuaiBaoGetUserUnPickUpListsBean();
                            var4.setData(JsonUtil.getJsonStringByGson(new com.rq.net.bean.KuaiBaoGetUserUnPickUpListsBean.DataBean(var1x.getWaybillNo(), var1x.getPhone())));
                            OkhttpManager.kuaibaoGetUserUnPickUpListsApi(var4, (OnOkhttpCallback)(new OnOkhttpCallback() {
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

                                                var12 = JsonUtil.getClazzByGson(var2, ResultBean.class);
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

                                                            ResultBean var3 = (ResultBean)var17.next();
                                                            //////Intrinsics.checkExpressionValueIsNotNull(var3, "resultBean");
                                                            if (!var3.getWaybill_no().equals(var1)) {
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

                                                        var18 = MixScanMamager.this.getMOkhttpStaionCallback();
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
                                    MixScanMamager.this.mixUploadOutLibrary(ExpressStationEnum.KUAIBAO, var15);
                                }

                                // $FF: synthetic method
                                // $FF: bridge method
                                public void onSuccess(Object var1xx) {
                                    this.onSuccess((KuaiBaoGetUserUnPickUpListsResponseBean)var1xx);
                                }
                            }));
                        } else {
                            //throw new Exception("null cannot be cast to non-null type com.kuaidihelp.posthouse.activity.BaseActivity");
                        }
                    }
                }

                // $FF: synthetic method
                // $FF: bridge method
                public void onSuccess(Object var1x) {
                    this.onSuccess((KuaiBaoQueryBillcodeInforResponseBean)var1x);
                }
            }));
        }

        StringBuilder var5;
        final String var14;
        RqFilePreference var16;
        if ((ExpressStationEnum.KUAIDICAOSHI.getItem() & var2) > 0L) {
            ++this.querySelectItem;
            var14 = this.TAG;
            var5 = new StringBuilder();
            var5.append("混扫出库: ===============兔喜驿站======");
            var5.append(this.querySelectItem);
            Log.d(var14, var5.toString());
            var16 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var16, "RqFilePreference.getInstance()");
            KDCSQueryStaffAndStoreResponseBean var18 = var16.getKDCSQueryStaffAndStore();
            if (var18 != null && StringUtil.isNotEmpty(var18.getDepotCode())) {
                KDCSCheckOutLibraryBillCodeInforBean var11 = new KDCSCheckOutLibraryBillCodeInforBean();
                var11.setBillCode(var1);
                var11.setDepotCode(var18.getDepotCode());
                var11.setCompanyCode((String)null);
                OkhttpManager.kdcsCheckGatwwayBillcodeInfor(var11, (OnOkhttpCallback)(new OnOkhttpCallback() {
                    public final void onSuccess(KDCSCheckResponseBean var1x) {
                        if (var1x != null) {
                            if (MixScanMamager.this.getMOkhttpStaionCallback() != null) {
                                ArrayList var2 = new ArrayList();
                                Iterator var3;
                                Items var4;
                                ShowMuchPackageNoPickBean var5;
                                if (var1x.getItems() != null && var1x.getItems().size() > 0) {
                                    var3 = var1x.getItems().iterator();

                                    while(var3.hasNext()) {
                                        var4 = (Items)var3.next();
                                        ////Intrinsics.checkExpressionValueIsNotNull(var4, "waybillsRelated");
                                        if (!var4.getBillCode().equals(var1)) {
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
                                        var4 = (Items)var3.next();
                                        ////Intrinsics.checkExpressionValueIsNotNull(var4, "item");
                                        if (!var4.getBillCode().equals(var1)) {
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
                                    MixScanMamager.OkhttpCallbackStationManager var6 = MixScanMamager.this.getMOkhttpStaionCallback();
                                    if (var6 != null) {
                                        var6.onOkhttpMuchPackageShow((List)var2);
                                    }
                                }
                            }

                            MixScanMamager.this.mixUploadOutLibrary(ExpressStationEnum.KUAIDICAOSHI, var1x);
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

        RqFilePreference var13;
        if ((ExpressStationEnum.YSHOUFA.getItem() & var2) > 0L) {
            ++this.querySelectItem;
            StringBuilder var21 = new StringBuilder();
            var21.append("Bearer ");
            var13 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var13, "RqFilePreference.getInstance()");
            YshouFaLoginResponseBean var15 = var13.getYshouFaLoginRes();
            if (var15 == null) {
                ////Intrinsics.throwNpe();
            }

            var21.append(var15.getData().getToken());
            //var14 = var21.toString();
            ImageSaveUtil.getInstance().setSavePictureByteCallback((ImageSaveUtil.SavePictureByteCallback)(new ImageSaveUtil.SavePictureByteCallback() {
                public final void onGetPictureByte(byte[] var1x) {
                    OkhttpManager.yShouFaQuerySendOrder(var1, var21.toString(), (OnOkhttpCallback)(new OnOkhttpCallback() {
                        public final void onSuccess(QuerySendOrderResponseBean var1x) {
                            if (var1x.getTotal() >= 1) {
                                Object var2 = var1x.getData().get(0);
                                if (var2 == null) {
                                   // //Intrinsics.throwNpe();
                                }

                                OkhttpManager.yShouFaGetNeedPayment(((QuerySendOrderDataResponseBean)var2).getOrderId(), var21.toString(), null);
                            }

                        }

                        // $FF: synthetic method
                        // $FF: bridge method
                        public void onSuccess(Object var1x) {
                            this.onSuccess((QuerySendOrderResponseBean)var1x);
                        }
                    }));
                }
            }));
        }

        if ((ExpressStationEnum.MAMASTATION.getItem() & var2) > 0L) {
            label132: {
                Exception var10000;
                label130: {
                    boolean var10001;
                    MaMaLoginResponseBean var19;
                    MaMaQueryBarcodeBean var22;
                    try {
                        ++this.querySelectItem;
                        var22 = new MaMaQueryBarcodeBean();
                        var22.setWaybillNo(var1);
                        this.mBarcode = var1;
                        var13 = RqFilePreference.getInstance();
                        ////Intrinsics.checkExpressionValueIsNotNull(var13, "RqFilePreference.getInstance()");
                        var19 = var13.getMaMaLoginInfor();
                    } catch (Exception var8) {
                        var10000 = var8;
                        var10001 = false;
                        break label130;
                    }

                    if (var19 == null) {
                        return;
                    }

                    try {
                        var22.setStationCode(var19.getStationCode());
                        OkhttpManager.mamaQueryBarcodeInfor(var22, var19, (OnOkhttpCallback)(new OnOkhttpCallback() {
                            // $FF: synthetic method
                            // $FF: bridge method
                            public void onSuccess(Object var1) {
                                this.onSuccess((List)var1);
                            }

                            public void onSuccess(List var1) {
                                ////Intrinsics.checkParameterIsNotNull(var1, "data");
                                if (Intrinsics.areEqual(((MaMaQueryBarcodeResponseBean)var1.get(0)).getStatusCode(), "45")) {
                                    ToastSoundUtil.baoGuoYiChuToast("快递已签收出库");
                                } else {
                                    MixScanMamager.this.mixUploadOutLibrary(ExpressStationEnum.MAMASTATION, var1);
                                }
                            }
                        }));
                        break label132;
                    } catch (Exception var7) {
                        var10000 = var7;
                        var10001 = false;
                    }
                }

                Exception var24 = var10000;
                var24.printStackTrace();
            }
        }

        if ((ExpressStationEnum.LAIQU.getItem() & var2) > 0L) {
            ++this.querySelectItem;
            this.mixUploadOutLibrary(ExpressStationEnum.LAIQU, var1);
        }

        if ((ExpressStationEnum.YUNDAKDCS.getItem() & var2) > 0L) {
            ++this.querySelectItem;
            OkhttpManager.yundaNewKDCSCheckBarcodeInfor(var1, (OnOkhttpCallback)(new OnOkhttpCallback() {
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
                        MixScanMamager.this.mixUploadOutLibrary(ExpressStationEnum.YUNDAKDCS, var4);
                    }

                }

                // $FF: synthetic method
                // $FF: bridge method
                public void onSuccess(Object var1x) {
                    this.onSuccess((YunDaNewKDCSCheckResponseBean)var1x);
                }
            }));
        }

        if ((ExpressStationEnum.FENGCHAOSERVICE.getItem() & var2) > 0L) {
            ++this.querySelectItem;
            OkhttpManager.fengchaoServiceCheckBarcode(var1, (OnOkhttpCallback)(new OnOkhttpCallback() {
                // $FF: synthetic method
                // $FF: bridge method
                public void onSuccess(Object var1x) {
                    this.onSuccess((List)var1x);
                }

                public final void onSuccess(List var1x) {
                    if (var1x != null && var1x.size() > 0) {
                        ExpressInfosBean var3 = new ExpressInfosBean();
                        var3.setBoxThrowLocation("");
                        Object var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setEntryTime(((FcboxCheckBarcodeResponseBean)var2).getEntryTime());
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setExpressCompanyId(((FcboxCheckBarcodeResponseBean)var2).getExpressCompanyId());
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setExpressCompanyName(((FcboxCheckBarcodeResponseBean)var2).getExpressCompanyName());
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setExpressNo(((FcboxCheckBarcodeResponseBean)var2).getExpressNo());
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setFetchCode(((FcboxCheckBarcodeResponseBean)var2).getFetchCode());
                        var3.setLocalState("0");
                        var3.setLocalType("0");
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setPaymentAmount(((FcboxCheckBarcodeResponseBean)var2).getPaymentAmount());
                        StringBuilder var9 = new StringBuilder();
                        var9.append("");
                        Object var4 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var4, "data[0]");
                        var9.append(((FcboxCheckBarcodeResponseBean)var4).getPaymentStatus());
                        var3.setPaymentStatus(var9.toString());
                        var9 = new StringBuilder();
                        var9.append("");
                        var4 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var4, "data[0]");
                        var9.append(((FcboxCheckBarcodeResponseBean)var4).getPaymentType());
                        var3.setPaymentType(var9.toString());
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setPaymentTypeName(((FcboxCheckBarcodeResponseBean)var2).getPaymentTypeName());
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setSubOrderStatusStr(((FcboxCheckBarcodeResponseBean)var2).getSubOrderStatusStr());
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setPostStatusName(((FcboxCheckBarcodeResponseBean)var2).getPostStatusName());
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setReceiverMobile(((FcboxCheckBarcodeResponseBean)var2).getReceiverMobile());
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setReceiverName(((FcboxCheckBarcodeResponseBean)var2).getReceiverName());
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setShelfTime(((FcboxCheckBarcodeResponseBean)var2).getShelfTime());
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        String var11 = ((FcboxCheckBarcodeResponseBean)var2).getPostStatus();
                        ////Intrinsics.checkExpressionValueIsNotNull(var11, "data[0].postStatus");
                        var3.setPostStatus(Integer.parseInt(var11));
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var11 = ((FcboxCheckBarcodeResponseBean)var2).getPostId();
                        ////Intrinsics.checkExpressionValueIsNotNull(var11, "data[0].postId");
                        var3.setPostId(Integer.parseInt(var11));
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setNeedPay(((FcboxCheckBarcodeResponseBean)var2).isNeedPay());
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setIsStatusSatisfied(((FcboxCheckBarcodeResponseBean)var2).isIsStatusSatisfied());
                        var2 = var1x.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "data[0]");
                        var3.setIncludServiceFee(((FcboxCheckBarcodeResponseBean)var2).isIncludeServiceFee());
                        FcboxSignBean var10 = new FcboxSignBean();
                        var10.getExpressInfos().add(var3);
                        WeakReference var12 = MixScanMamager.this.getReferenceContext();
                        Context var13;
                        if (var12 != null) {
                            var13 = (Context)var12.get();
                        } else {
                            var13 = null;
                        }

                        if (var13 != null) {
                            BaseActivity var14 = (BaseActivity)var13;
                            String var5 = var1;
                            String var8 = var3.getExpressCompanyName();
                            String var6 = ExpressStationEnum.FENGCHAOSERVICE.getTitle();
                            Object var7 = var1x.get(0);
                            ////Intrinsics.checkExpressionValueIsNotNull(var7, "data[0]");
                            var14.saveData(var5, var8, var6, ((FcboxCheckBarcodeResponseBean)var7).getReceiverMobile());
                            MixScanMamager.this.mixUploadOutLibrary(ExpressStationEnum.FENGCHAOSERVICE, var10);
                        } else {
                            //throw new Exception("null cannot be cast to non-null type com.kuaidihelp.posthouse.activity.BaseActivity");
                        }
                    }
                }
            }));
        }

        if ((ExpressStationEnum.XIAOBINGSTATION.getItem() & var2) > 0L) {
            ++this.querySelectItem;
            //var14 = this.TAG;
            var5 = new StringBuilder();
            var5.append("混扫出库: ===============小兵驿站======");
            var5.append(this.querySelectItem);
            //Log.d(var14, var5.toString());
            if (this.xbLoginResponseBean == null) {
                var16 = RqFilePreference.getInstance();
                ////Intrinsics.checkExpressionValueIsNotNull(var16, "RqFilePreference.getInstance()");
                this.xbLoginResponseBean = var16.getXiaoBingLoginInfor();
            }

            ImageSaveUtil.getInstance().setSavePictureCallback((ImageSaveUtil.SavePictureCallback)(new ImageSaveUtil.SavePictureCallback() {
                public final void onGetPictureBitmap(Bitmap var1x) {
                    if (MixScanMamager.this.getXbLoginResponseBean() != null) {
                        XiaoBinLoginResponseBean var2 = MixScanMamager.this.getXbLoginResponseBean();
                        DataBean var3;
                        if (var2 != null) {
                            var3 = var2.getData();
                        } else {
                            var3 = null;
                        }

                        if (var3 != null) {
                            var2 = MixScanMamager.this.getXbLoginResponseBean();
                            if (var2 != null) {
                                var3 = var2.getData();
                            } else {
                                var3 = null;
                            }

                            if (var3 == null) {
                                //Intrinsics.throwNpe();
                            }

                            if (StringUtil.isNotEmpty(var3.getToken())) {
                                var2 = MixScanMamager.this.getXbLoginResponseBean();
                                if (var2 != null) {
                                    var3 = var2.getData();
                                } else {
                                    var3 = null;
                                }

                                if (var3 == null) {
                                    //Intrinsics.throwNpe();
                                }

                                OkhttpManager.xiaobinUploadBarcodeImage(var3.getToken(), (String)null, var1, var1x, (OnOkhttpCallback)(new OnOkhttpCallback() {
                                    public final void onSuccess(XiaoBingUploadResponseBean var1x) {
                                        WeakReference var2 = MixScanMamager.this.getReferenceContext();
                                        Context var8;
                                        if (var2 != null) {
                                            var8 = (Context)var2.get();
                                        } else {
                                            var8 = null;
                                        }

                                        if (var8 == null) {
                                            Exception var10 = new Exception("null cannot be cast to non-null type com.kuaidihelp.posthouse.activity.BaseActivity");
                                            //throw var10;
                                            return;
                                        } else {
                                            ((BaseActivity)var8).saveData(var1, "", ExpressStationEnum.XIAOBINGSTATION.getTitle(), "");
                                            ////Intrinsics.checkExpressionValueIsNotNull(var1x, "data");
                                            String var5 = JsonUtil.getJsonStringByGson(var1x.getData());
                                            if (StringUtil.isNotEmpty(var5) && var5.length() > 20) {
                                                Object var7 = JsonUtil.getClazzByGson(var5, com.rq.net.bean.XiaoBingUploadResponseBean.DataBean.class);
                                                if (var7 == null) {
                                                    return;
                                                    //throw new Exception("null cannot be cast to non-null type kotlin.collections.ArrayList<com.rq.net.bean.XiaoBingUploadResponseBean.DataBean> /* = java.util.ArrayList<com.rq.net.bean.XiaoBingUploadResponseBean.DataBean> */");
                                                }

                                                ArrayList var11 = (ArrayList)var7;
                                                ArrayList var9 = new ArrayList();
                                                Iterator var12 = var11.iterator();

                                                while(var12.hasNext()) {
                                                    com.rq.net.bean.XiaoBingUploadResponseBean.DataBean var3 = (com.rq.net.bean.XiaoBingUploadResponseBean.DataBean)var12.next();
                                                    ////Intrinsics.checkExpressionValueIsNotNull(var3, "resultBean");
                                                    if (!var3.getRecipient_no().equals(var1)) {
                                                        ShowMuchPackageNoPickBean var4 = new ShowMuchPackageNoPickBean();
                                                        var4.setBarcode(var3.getRecipient_no());
                                                        var4.setPickUpCode(var3.getTake_code_final());
                                                        var4.setInStorageTime(var3.getRec_mobile());
                                                        var9.add(var4);
                                                    }
                                                }

                                                if (var9.size() > 0) {
                                                    MixScanMamager.OkhttpCallbackStationManager var13 = MixScanMamager.this.getMOkhttpStaionCallback();
                                                    if (var13 != null) {
                                                        var13.onOkhttpMuchPackageShow((List)var9);
                                                        return;
                                                    }
                                                }
                                            } else if (MixScanMamager.this.getMOkhttpStaionCallback() != null) {
                                                MixScanMamager.OkhttpCallbackStationManager var6 = MixScanMamager.this.getMOkhttpStaionCallback();
                                                if (var6 != null) {
                                                    var6.onOkhttpOutLibrarySuccess(ExpressStationEnum.XIAOBINGSTATION, "出库成功");
                                                }
                                            }

                                        }
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
            }));
        }

        if ((ExpressStationEnum.DUODUOYIZHAN.getItem() & var2) > 0L) {
            ++this.querySelectItem;
            //var14 = this.TAG;
            var5 = new StringBuilder();
            var5.append("混扫出库: ====多多驿站======");
            Thread var6 = Thread.currentThread();
            ////Intrinsics.checkExpressionValueIsNotNull(var6, "Thread.currentThread()");
            var5.append(var6.getName());
            //Log.d(var14, var5.toString());
            OkHttpPinDuoDuoManager.outLibraryAio(this.context, var1, (OnHttpCallback)(new OnHttpCallback() {
                public void onError(int var1x, String var2) {
                    OnHttpErrorCallback var3 = MixScanMamager.this.getOnHttpErrorCallback();
                    if (var3 != null) {
                        var3.onError(-2, var2);
                    }

                    //Logger.e(var2);
                }

                public void onSuccess(PinDuoDuoBaseResponseBean var1x) {
                    BoundDetailList var3 = null;
                    String var2;
                    if (var1x != null) {
                        var2 = var1x.getErrorMsg();
                    } else {
                        var2 = null;
                    }

                    //Logger.i(var2);
                    if (var1x != null && var1x.getSuccess()) {
                        PinDuoDuoOutLibraryAioResponseBean var7 = (PinDuoDuoOutLibraryAioResponseBean)var1x.getResult();
                        if (var7 != null) {
                            var2 = var7.getImage_name();
                            if (var2 != null) {
                                //((Map)ApiDuoDuoActivity.Companion.getDataMap()).put(var1, var2);
                            }
                        }

                        MixScanMamager.OkhttpCallbackStationManager var9;
                        if (MixScanMamager.this.getMOkhttpStaionCallback() != null) {
                            var9 = MixScanMamager.this.getMOkhttpStaionCallback();
                            if (var9 != null) {
                                var9.onOkhttpOutLibrarySuccess(ExpressStationEnum.DUODUOYIZHAN, "出库成功");
                            }
                        }

                        PinDuoDuoOutLibraryAioResponseBean var5 = (PinDuoDuoOutLibraryAioResponseBean)var1x.getResult();
                        if (var5 != null) {
                            List var10 = var5.getTo_out_bound_detail_d_t_o_list();
                            if (var10 != null) {
                                ArrayList var6 = new ArrayList();
                                Iterator var11 = ((Iterable)var10).iterator();

                                while(var11.hasNext()) {
                                    var3 = (BoundDetailList)var11.next();
                                    ShowMuchPackageNoPickBean var8 = new ShowMuchPackageNoPickBean();
                                    var8.setBarcode(var3.getWaybill_code());
                                    var8.setPickUpCode(var3.getPickup_code());
                                    var6.add(var8);
                                }

                                if (var6.size() > 0) {
                                    var9 = MixScanMamager.this.getMOkhttpStaionCallback();
                                    if (var9 != null) {
                                        var9.onOkhttpMuchPackageShow((List)var6);
                                        return;
                                    }
                                }
                            }
                        }
                    } else {
                        Log.d(MixScanMamager.this.getTAG(), "多多出库失败: ============");
                        OnHttpErrorCallback var4 = MixScanMamager.this.getOnHttpErrorCallback();
                        if (var4 != null) {
                            //var2 = var3;
                            if (var1x != null) {
                                var2 = var1x.getErrorMsg();
                            }

                            var4.onError(-2, var2);
                        }
                    }

                }

                // $FF: synthetic method
                // $FF: bridge method
                public void onSuccess(Object var1x) {
                    this.onSuccess((PinDuoDuoBaseResponseBean)var1x);
                }
            }));
        }

        if ((ExpressStationEnum.XINIAOGAOPAIYI.getItem() & var2) > 0L) {
            label93: {
                ++this.querySelectItem;
                XiNiaoGaoPaiLoginBean var27 = this.xnLoginResponseBean;
                if (var27 != null) {
                    if (var27 == null) {
                        //Intrinsics.throwNpe();
                    }

                    if (var27.getKey() != null) {
                        break label93;
                    }
                }

                var16 = RqFilePreference.getInstance();
                ////Intrinsics.checkExpressionValueIsNotNull(var16, "RqFilePreference.getInstance()");
                this.xnLoginResponseBean = var16.getXiNiaoGaoPaiLoginInfor();
            }

            GaoPaiYiRequest var28 = new GaoPaiYiRequest();
            var28.setWaybillNo(var1);
            XiNiaoGaoPaiLoginBean var23 = this.xnLoginResponseBean;
            if (var23 == null) {
                //Intrinsics.throwNpe();
            }

            var28.setUnionCode(var23.getUnionCode());
            var23 = this.xnLoginResponseBean;
            if (var23 == null) {
                //Intrinsics.throwNpe();
            }

            var28.setDeviceCode(var23.getDeviceCode());
            var28.setTimestamp(String.valueOf(System.currentTimeMillis()));
            var5 = new StringBuilder();
            var5.append(var28.getWaybillNo());
            var5.append(var28.getUnionCode());
            var5.append(var28.getDeviceCode());
            var5.append(var28.getTimestamp());
            XiNiaoGaoPaiLoginBean var17 = this.xnLoginResponseBean;
            if (var17 == null) {
                //Intrinsics.throwNpe();
            }

            var5.append(var17.getKey());
            String var25 = var5.toString();
            Charset var20 = UTF_8;
            if (var25 == null) {
                //throw new Exception("null cannot be cast to non-null type java.lang.String");
                return;
            }

            byte[] var26 = var25.getBytes(var20);
            ////Intrinsics.checkExpressionValueIsNotNull(var26, "(this as java.lang.String).getBytes(charset)");
            var28.setSignature(Base64Util.getBaseString(var26));
            OkhttpManager.xiNiaoGaoPai(var28, (OnOkhttpCallback)(new OnOkhttpCallback() {
                public final void onSuccess(Object var1) {
                    if (MixScanMamager.this.getMOkhttpStaionCallback() != null) {
                        MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                        if (var2 != null) {
                            var2.onOkhttpOutLibrarySuccess(ExpressStationEnum.XINIAOGAOPAIYI, "出库成功");
                        }
                    }

                }
            }));
        }

        if ((var2 & ExpressStationEnum.PANDAHARVEST.getItem()) > 0L) {
            ++this.querySelectItem;
            this.mixUploadOutLibrary(ExpressStationEnum.PANDAHARVEST, var1);
        }

    }

    public final void mixUploadOutLibrary(ExpressStationEnum var1, Object var2) {
        ////Intrinsics.checkParameterIsNotNull(var1, "expressStation");
        int var3 = MixScanMamager$WhenMappings.$EnumSwitchMapping$1[var1.ordinal()];
        RqFilePreference var4 = null;
        Context var23 = null;
        final Ref.ObjectRef var24;
        switch(var3) {
            case 1:
                if (var2 != null) {
                    OkhttpManager.kuaibaoDeliveryStorageApi((KuaiBaoDeliveryStorageBean)var2, (OnOkhttpCallback)(new OnOkhttpCallback() {
                        public final void onSuccess(Object var1) {
                            if (MixScanMamager.this.getMOkhttpStaionCallback() != null) {
                                MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                                if (var2 != null) {
                                    var2.onOkhttpOutLibrarySuccess(ExpressStationEnum.KUAIBAO, "出库成功");
                                }
                            }

                        }
                    }));
                    return;
                } else {
                    //throw new Exception("null cannot be cast to non-null type com.rq.net.bean.KuaiBaoDeliveryStorageBean");
                }
            case 2:
                MixScanMamager.OkhttpCallbackStationManager var46 = this.mOkhttpStaionCallback;
                if (var46 != null && var46 != null) {
                    var46.onOkhttpOutLibrarySuccess(ExpressStationEnum.KUAIBAO, "出库成功");
                    return;
                }
                break;
            case 3:
                Log.d(this.TAG, "mixUploadOutLibrary: ================兔喜出库==========");
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
                            break;
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

                        label191: {
                            KDCSQueryStaffAndStoreResponseBean var37;
                            OutLibraryData var42;
                            Items var43;
                            try {
                                Iterator var34 = var41.getItems().iterator();
                                if (!var34.hasNext()) {
                                    break label191;
                                }

                                var43 = (Items)var34.next();
                                var42 = new OutLibraryData();
                                ////Intrinsics.checkExpressionValueIsNotNull(var43, "item");
                                var42.setBillCode(var43.getBillCode());
                                var42.setBillCodeScanTime((String)null);
                                var42.setCourierCode((String)null);
                                var42.setCourierExpCompanyCode((String)null);
                                var42.setTakeCode(var43.getTakeCode());
                                var37 = this.staffAndStore;
                            } catch (Exception var17) {
                                var10000 = var17;
                                var10001 = false;
                                break label190;
                            }

                            if (var37 == null) {
                                try {
                                    //Intrinsics.throwNpe();
                                } catch (Exception var16) {
                                    var10000 = var16;
                                    var10001 = false;
                                    break label190;
                                }
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
                                var42.setExtraInfo((String)null);
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
                                var49 = this.referenceContext;
                            } catch (Exception var13) {
                                var10000 = var13;
                                var10001 = false;
                                break label190;
                            }

                            //var23 = var4;
                            if (var49 != null) {
                                try {
                                    var23 = (Context)var49.get();
                                } catch (Exception var12) {
                                    var10000 = var12;
                                    var10001 = false;
                                    break label190;
                                }
                            }

                            if (var23 == null) {
                                try {
                                    throw new Exception("null cannot be cast to non-null type com.kuaidihelp.posthouse.activity.BaseActivity");
                                } catch (Exception var9) {
                                    var10000 = var9;
                                    var10001 = false;
                                    break label190;
                                }
                            }

                            try {
                                ((BaseActivity)var23).saveData(var42.getBillCode(), var43.getCompanyName(), ExpressStationEnum.KUAIDICAOSHI.getTitle(), var43.getReceiveManMobile());
                            } catch (Exception var11) {
                                var10000 = var11;
                                var10001 = false;
                                break label190;
                            }
                        }

                        try {
                            OkhttpManager.kdcsOutLibrary(var28, (OnOkhttpCallback)(new OnOkhttpCallback() {
                                public final void onSuccess(Object var1) {
                                    if (MixScanMamager.this.getMOkhttpStaionCallback() != null) {
                                        MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                                        if (var2 != null) {
                                            var2.onOkhttpOutLibrarySuccess(ExpressStationEnum.KUAIDICAOSHI, "出库成功");
                                        }
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
                    try {
                        throw new Exception("null cannot be cast to non-null type com.rq.net.bean.KDCSCheckResponseBean");
                    } catch (Exception var20) {
                        var10000 = var20;
                        var10001 = false;
                    }
                }

                Exception var44 = var10000;
                var44.printStackTrace();
                return;
            case 4:
                if (var2 == null) {
                    return;
                    //throw new Exception("null cannot be cast to non-null type kotlin.collections.List<com.rq.net.bean.MaMaQueryBarcodeResponseBean>");
                }

                List var27 = (List)var2;
                final Ref.ObjectRef var35 = new Ref.ObjectRef();
                var35.element = new MaMaOutLibraryBean();
                if (var27 != null && var27.size() > 0) {
                    ((MaMaOutLibraryBean)var35.element).setEmpCode(((MaMaQueryBarcodeResponseBean)var27.get(0)).getEmpCode());
                    ((MaMaOutLibraryBean)var35.element).setEmpName(((MaMaQueryBarcodeResponseBean)var27.get(0)).getEmpName());
                    ((MaMaOutLibraryBean)var35.element).setId(((MaMaQueryBarcodeResponseBean)var27.get(0)).getId());
                    ((MaMaOutLibraryBean)var35.element).setLogisticsCode(((MaMaQueryBarcodeResponseBean)var27.get(0)).getLogisticsCode());
                    ((MaMaOutLibraryBean)var35.element).setOrgCode(((MaMaQueryBarcodeResponseBean)var27.get(0)).getOrgCode());
                    ((MaMaOutLibraryBean)var35.element).setRecieverPhone(((MaMaQueryBarcodeResponseBean)var27.get(0)).getDestPhone());
                    ((MaMaOutLibraryBean)var35.element).setStationCode(((MaMaQueryBarcodeResponseBean)var27.get(0)).getStationCode());
                    ((MaMaOutLibraryBean)var35.element).setWaybillNo(((MaMaQueryBarcodeResponseBean)var27.get(0)).getWaybillNo());
                    MaMaOutLibraryBean var38 = (MaMaOutLibraryBean)var35.element;
                    RqFilePreference var39 = RqFilePreference.getInstance();
                    ////Intrinsics.checkExpressionValueIsNotNull(var39, "RqFilePreference.getInstance()");
                    var38.setUsername(var39.getLoginUsername());
                    ((MaMaOutLibraryBean)var35.element).setRecieverSignoff("本人签收");
                    ((MaMaOutLibraryBean)var35.element).setDestPhone(((MaMaQueryBarcodeResponseBean)var27.get(0)).getDestPhone());
                    WeakReference var40 = this.referenceContext;
                    if (var40 != null) {
                        var23 = (Context)var40.get();
                    }

                    if (var23 != null) {
                        ((BaseActivity)var23).saveData(((MaMaOutLibraryBean)var35.element).getWaybillNo(), ((MaMaQueryBarcodeResponseBean)var27.get(0)).getLogisticsName(), ExpressStationEnum.MAMASTATION.getTitle(), ((MaMaOutLibraryBean)var35.element).getRecieverPhone());
                        OkhttpManager.mamaUploadOutLibraryData((MaMaOutLibraryBean)var35.element, (OnOkhttpCallback)(new OnOkhttpCallback() {
                            public final void onSuccess(Object var1) {
                                String var5 = ((MaMaOutLibraryBean)var35.element).getRecieverPhone();
                                ////Intrinsics.checkExpressionValueIsNotNull(var5, "body.recieverPhone");
                                int var2 = ((MaMaOutLibraryBean)var35.element).getRecieverPhone().length();
                                if (var5 != null) {
                                    var5 = var5.substring(var2 - 4);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var5, "(this as java.lang.String).substring(startIndex)");
                                    StringBuilder var3 = new StringBuilder();
                                    var3.append("{\"pageSize\":\"15\",\"ifSign\":\"0\",\"parameterType\":\"3\",\"searchValue\":\"");
                                    var3.append(var5);
                                    var3.append("\",\"pageIndex\":\"0\"}");
                                    String var7 = var3.toString();
                                    MaMaCheckInforBean var6 = new MaMaCheckInforBean();
                                    RqFilePreference var4 = RqFilePreference.getInstance();
                                    ////Intrinsics.checkExpressionValueIsNotNull(var4, "RqFilePreference.getInstance()");
                                    var6.setUsername(var4.getLoginMaMaUsername());
                                    var6.setData(var7);
                                    if (MixScanMamager.this.getMOkhttpStaionCallback() != null) {
                                        MixScanMamager.OkhttpCallbackStationManager var8 = MixScanMamager.this.getMOkhttpStaionCallback();
                                        if (var8 != null) {
                                            var8.onOkhttpOutLibrarySuccess(ExpressStationEnum.MAMASTATION, "出库成功");
                                        }
                                    }

                                    RqFilePreference var9 = RqFilePreference.getInstance();
                                    ////Intrinsics.checkExpressionValueIsNotNull(var9, "RqFilePreference.getInstance()");
                                    if (var9.getShowMuchPackage()) {
                                        MixScanMamager.this.mixGetNotTakenPackage(ExpressStationEnum.MAMASTATION, var6);
                                    }

                                } else {
                                    //throw new Exception("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                        }));
                        return;
                    }

                    //throw new Exception("null cannot be cast to non-null type com.kuaidihelp.posthouse.activity.BaseActivity");
                }
                break;
            case 5:
                LaiquOutLibraryBean var25 = new LaiquOutLibraryBean();
                var25.setBillCode((String)var2);
                OkhttpManager.laiquOutLibrary(var25, (OnOkhttpCallback)(new OnOkhttpCallback() {
                    public final void onSuccess(LaiquOutLibraryResponseBean var1) {
                        if (var1 != null) {
                            Exception var10000;
                            label92: {
                                boolean var10001;
                                label87: {
                                    MixScanMamager.OkhttpCallbackStationManager var2;
                                    try {
                                        if (var1.getResultCode() != 1) {
                                            return;
                                        }

                                        if (MixScanMamager.this.getMOkhttpStaionCallback() == null) {
                                            break label87;
                                        }

                                        var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                                    } catch (Exception var15) {
                                        var10000 = var15;
                                        var10001 = false;
                                        break label92;
                                    }

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

                                WeakReference var19;
                                try {
                                    var19 = MixScanMamager.this.getReferenceContext();
                                } catch (Exception var13) {
                                    var10000 = var13;
                                    var10001 = false;
                                    break label92;
                                }

                                Context var20;
                                if (var19 != null) {
                                    try {
                                        var20 = (Context)var19.get();
                                    } catch (Exception var12) {
                                        var10000 = var12;
                                        var10001 = false;
                                        break label92;
                                    }
                                } else {
                                    var20 = null;
                                }

                                if (var20 != null) {
                                    label94: {
                                        Iterator var16;
                                        ArrayList var24;
                                        try {
                                            BaseActivity var22 = (BaseActivity)var20;
                                            Object var3 = var1.getGoodsList().get(0);
                                            ////Intrinsics.checkExpressionValueIsNotNull(var3, "data.goodsList[0]");
                                            String var21 = ((GoodsListBean)var3).getBillCode();
                                            Object var4 = var1.getGoodsList().get(0);
                                            ////Intrinsics.checkExpressionValueIsNotNull(var4, "data.goodsList[0]");
                                            String var25 = ((GoodsListBean)var4).getExpressCompanyCode();
                                            String var5 = ExpressStationEnum.LAIQU.getTitle();
                                            Object var6 = var1.getGoodsList().get(0);
                                            ////Intrinsics.checkExpressionValueIsNotNull(var6, "data.goodsList[0]");
                                            var22.saveData(var21, var25, var5, ((GoodsListBean)var6).getReceiverPhone());
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

                                                WaybillsRelatedBean var23 = (WaybillsRelatedBean)var16.next();
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

                                            var17 = MixScanMamager.this.getMOkhttpStaionCallback();
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
                return;
            case 6:
                var24 = new Ref.ObjectRef();
                var4 = RqFilePreference.getInstance();
                ////Intrinsics.checkExpressionValueIsNotNull(var4, "RqFilePreference.getInstance()");
                var24.element = var4.getYunDaKDCSLoginInfor();
                if ((YunDaKDCSLoginResponseBean)var24.element != null) {
                    if (((YunDaKDCSLoginResponseBean)var24.element).getData() == null) {
                        return;
                    }

                    if (var2 != null) {
                        ArrayList var5 = (ArrayList)var2;
                        var2 = var5.get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "dataList[0]");
                        final String var26 = (String)var2;
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
                        ItemsBean var8 = new ItemsBean();
                        var8.setCompany(var7);
                        var8.setPickCode("");
                        var8.setRecePhone(var32);
                        var8.setShipId(var26);
                        var8.setYdUserId(var36);
                        var6.getItems().add(var8);
                        var6.setMyAgentInfo(new MyAgentInfoBean());
                        MyAgentInfoBean var45 = var6.getMyAgentInfo();
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
                        OkhttpManager.yundaOutLibrary1781(var6, (OnOkhttpCallback)(new OnOkhttpCallback() {
                            public final void onSuccess(Object var1) {
                                if (var1 != null && MixScanMamager.this.getMOkhttpStaionCallback() != null) {
                                    MixScanMamager.OkhttpCallbackStationManager var3 = MixScanMamager.this.getMOkhttpStaionCallback();
                                    if (var3 != null) {
                                        var3.onOkhttpOutLibrarySuccess(ExpressStationEnum.YUNDAKDCS, "出库成功");
                                    }

                                    RqFilePreference var4 = RqFilePreference.getInstance();
                                    ////Intrinsics.checkExpressionValueIsNotNull(var4, "RqFilePreference.getInstance()");
                                    if (var4.getShowMuchPackage()) {
                                        com.rq.net.bean.YunDa1781KDCSNoPicketBean.DataBean var5 = new com.rq.net.bean.YunDa1781KDCSNoPicketBean.DataBean();
                                        com.rq.net.bean.YunDaKDCSLoginResponseBean.DataBean var2 = ((YunDaKDCSLoginResponseBean)var24.element).getData();
                                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "kdcsLoginInfor.data");
                                        var5.setAgentId(var2.getAgentId());
                                        var5.setRecePhone(var32);
                                        var5.setShipId(var26);
                                        var5.setYdUserId(var36);
                                        MixScanMamager.this.mixGetNotTakenPackage(ExpressStationEnum.YUNDAKDCS, var5);
                                    }
                                }

                            }
                        }));
                        return;
                    }

                    //throw new Exception("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
                }

                return;
            case 7:
                var24 = new Ref.ObjectRef();
                var24.element = (FcboxSignBean)var2;
                OkhttpManager.fengchaoServiceOutLibrary((FcboxSignBean)var24.element, (OnOkhttpCallback)(new OnOkhttpCallback() {
                    // $FF: synthetic method
                    // $FF: bridge method
                    public void onSuccess(Object var1) {
                        this.onSuccess((List)var1);
                    }

                    public final void onSuccess(List var1) {
                        FcboxQueryPackageBean var3 = new FcboxQueryPackageBean();
                        var3.setPageNo("1");
                        var3.setPageSize("200");
                        FcboxSignBean var2 = (FcboxSignBean)var24.element;
                        if (var2 == null) {
                            //Intrinsics.throwNpe();
                        }

                        Object var5 = var2.getExpressInfos().get(0);
                        ////Intrinsics.checkExpressionValueIsNotNull(var5, "signBean!!.expressInfos[0]");
                        var3.setReceiverMobile(((ExpressInfosBean)var5).getReceiverMobile());
                        var3.setTimeRangeType(0);
                        RqFilePreference var6 = RqFilePreference.getInstance();
                        ////Intrinsics.checkExpressionValueIsNotNull(var6, "RqFilePreference.getInstance()");
                        if (var6.getShowMuchPackage()) {
                            MixScanMamager.this.mixGetNotTakenPackage(ExpressStationEnum.FENGCHAOSERVICE, var3);
                        }

                        if (MixScanMamager.this.getMOkhttpStaionCallback() != null) {
                            MixScanMamager.OkhttpCallbackStationManager var4 = MixScanMamager.this.getMOkhttpStaionCallback();
                            if (var4 != null) {
                                var4.onOkhttpOutLibrarySuccess(ExpressStationEnum.FENGCHAOSERVICE, "出库成功");
                            }
                        }

                    }
                }));
                return;
            case 8:
                var24 = new Ref.ObjectRef();
                if (var2 != null) {
                    var24.element = (String)var2;
                    //XLog.d(this.TAG, "===============熊猫快收_出库==");
                    ImageSaveUtil.getInstance().setSavePictureByteCallback((ImageSaveUtil.SavePictureByteCallback)(new ImageSaveUtil.SavePictureByteCallback() {
                        public final void onGetPictureByte(byte[] var1) {
                            MixScanMamager var2 = MixScanMamager.this;
                            if (var1 != null) {
                                var2.uploadOutLibrary(var1, (String)var24.element);
                            } else {
                                //throw new Exception("null cannot be cast to non-null type kotlin.ByteArray");
                            }
                        }
                    }));
                    return;
                }

               // throw new Exception("null cannot be cast to non-null type kotlin.String");
            default:
                return;
        }

    }

    public final void pandaHarvestLogin(final String var1, String var2) {
        String var6;
        label34: {
            ////Intrinsics.checkParameterIsNotNull(var1, "username");
            ////Intrinsics.checkParameterIsNotNull(var2, "password");
            Log.d(this.TAG, "pandaHarvestLogin: ========================");
            var6 = PandaBeanKt.getBluetoothAddress();
            if (var6 != null) {
                var6 = var6.replace(":", "");
                if (var6 != null) {
                    if (var6 == null) {
                        //throw new Exception("null cannot be cast to non-null type java.lang.String");
                        break label34;
                    }

                    var6 = var6.toLowerCase();
                    ////Intrinsics.checkExpressionValueIsNotNull(var6, "(this as java.lang.String).toLowerCase()");
                    break label34;
                }
            }

            var6 = null;
        }

        CharSequence var7 = (CharSequence)var6;
        boolean var3;
        if (var7 != null && var7.length() != 0) {
            var3 = false;
        } else {
            var3 = true;
        }

        if (var3) {
            ToastSoundUtil.displayToast("蓝牙地址获取异常，请检查蓝牙");
        } else {
            PandaLoginBean var8 = new PandaLoginBean(var1, var2, var6);
            RqFilePreference var9 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var9, "RqFilePreference.getInstance()");
            var9.setPandaHarvestInforTwo(var8);
            long var4 = System.currentTimeMillis();
            String jsonString = JSON.toJSONString(var8);
            StringBuilder var10 = new StringBuilder();
            var10.append(jsonString);
            var10.append("YP75838571"/*ApiPandaHarvestActvity.Companion.getAccountName()*/);
            var10.append("GET_TOKEN");
            var10.append("openbmx");
            var10.append(var4);
            var10.append(/*ApiPandaHarvestActvity.Companion.getAccountPassword()*/"yRLgecjAxVi9gLXx");
            var2 = var10.toString();
            Charset var12 = Charset.forName("utf-8");
            ////Intrinsics.checkExpressionValueIsNotNull(var12, "Charset.forName(charsetName)");
            if (var2 != null) {
                byte[] var11 = var2.getBytes(var12);
                ////Intrinsics.checkExpressionValueIsNotNull(var11, "(this as java.lang.String).getBytes(charset)");
                var2 = Md5InputStream.md5((InputStream)(new ByteArrayInputStream(var11)));
                Map var13 = (Map)(new HashMap());
                ////Intrinsics.checkExpressionValueIsNotNull(var1, "data");
                var13.put("bizData", var1);
                var13.put("timestamp", String.valueOf(var4));
                var13.put("accountName", "YP75838571"/*ApiPandaHarvestActvity.Companion.getAccountName()*/);
                var13.put("apiName", "GET_TOKEN");
                var13.put("token", "openbmx");
                ////Intrinsics.checkExpressionValueIsNotNull(var2, "md5Str");
                var13.put("sign", var2);
                OkhttpManager.pandaHarvestLogin(var13, (OnOkhttpCallback)(new OnOkhttpCallback() {
                    public final void onSuccess(Object var1x) {
                        if (var1x != null) {
                            MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                            if (var2 != null) {
                                var2.onLoginSuccess(ExpressStationEnum.PANDAHARVEST, "熊猫快收登录成功");
                            }
                        }

                    }
                }));
            } else {
                //throw new Exception("null cannot be cast to non-null type java.lang.String");
            }
        }
    }

    public final void setErrorList(ArrayList var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.errorList = var1;
    }

    public final void setLaiquIndex(int var1) {
        this.laiquIndex = var1;
    }

    public final void setMBarcode(String var1) {
        this.mBarcode = var1;
    }

    public final void setMOkhttpStaionCallback(MixScanMamager.OkhttpCallbackStationManager var1) {
        this.mOkhttpStaionCallback = var1;
    }

    public final void setOnHttpErrorCallback(OnHttpErrorCallback var1) {
        this.onHttpErrorCallback = var1;
    }

    public final void setOnOkhttpCallback(MixScanMamager.OkhttpCallbackStationManager var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "okhttpStaionCallback");
        this.mOkhttpStaionCallback = var1;
        this.onHttpErrorCallback = (OnHttpErrorCallback)(new OnHttpErrorCallback() {
            public final void onError(int var1, String var2) {
                String var3 = MixScanMamager.this.getTAG();
                StringBuilder var4 = new StringBuilder();
                var4.append("setOnOkhttpCallback: ===============");
                var4.append(var1);
                Log.d(var3, var4.toString());
                var3 = MixScanMamager.this.getTAG();
                var4 = new StringBuilder();
                var4.append("setOnOkhttpCallback: ===============");
                var4.append(var2);
                Log.d(var3, var4.toString());
                MixScanMamager.OkhttpCallbackStationManager var9;
                if (var1 == -1) {
                    var9 = MixScanMamager.this.getMOkhttpStaionCallback();
                    if (var9 != null) {
                        ////Intrinsics.checkExpressionValueIsNotNull(var2, "error");
                        var9.onOkhttpError(var1, var2);
                    }

                } else {
                    MixScanMamager.this.getErrorList().add(var2);
                    if (MixScanMamager.this.getQuerySelectItem() > 0) {
                        MixScanMamager var5 = MixScanMamager.this;
                        var5.setQuerySelectItem(var5.getQuerySelectItem() - 1);
                        if (var5.getQuerySelectItem() <= 0) {
                            if (MixScanMamager.this.getMOkhttpStaionCallback() != null) {
                                Iterator var6 = MixScanMamager.this.getErrorList().iterator();

                                label51: {
                                    CharSequence var8;
                                    do {
                                        if (!var6.hasNext()) {
                                            var3 = "";
                                            break label51;
                                        }

                                        String var7 = (String)var6.next();
                                        ////Intrinsics.checkExpressionValueIsNotNull(var7, "errorMsg");
                                        var8 = (CharSequence)var7;
                                    } while(!var8.toString().contains("出库完结") && !var8.toString().contains("已出库")
                                            && !var8.toString().contains("出库完结")&& !var8.toString().contains("已经出库") && !var8.toString().contains("已完结"));

                                    var3 = "未入库或已出库";
                                }

                                if (StringUtil.isEmpty(var3)) {
                                    ////Intrinsics.checkExpressionValueIsNotNull(var2, "error");
                                } else {
                                    var2 = var3;
                                }

                                var9 = MixScanMamager.this.getMOkhttpStaionCallback();
                                if (var9 != null) {
                                    var9.onOkhttpError(var1, var2);
                                }
                            }

                            MixScanMamager.this.setQuerySelectItem(0);
                            return;
                        }
                    } else {
                        if (MixScanMamager.this.getMOkhttpStaionCallback() != null) {
                            var9 = MixScanMamager.this.getMOkhttpStaionCallback();
                            if (var9 != null) {
                                ////Intrinsics.checkExpressionValueIsNotNull(var2, "error");
                                var9.onOkhttpError(var1, var2);
                            }
                        }

                        MixScanMamager.this.setQuerySelectItem(0);
                    }

                }
            }
        });
        OkhttpManager.setOnhttpErrorCallback(this.onHttpErrorCallback);
    }

    public final void setQuerySelectItem(int var1) {
        this.querySelectItem = var1;
    }

    public final void setReferenceContext(WeakReference var1) {
        this.referenceContext = var1;
    }

    public final void setStaffAndStore(KDCSQueryStaffAndStoreResponseBean var1) {
        this.staffAndStore = var1;
    }

    public final void setStoreResponseBean(KDCSQueryStaffAndStoreResponseBean var1) {
        this.storeResponseBean = var1;
    }

    public final void setTAG(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.TAG = var1;
    }

    public final void setToken(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.token = var1;
    }

    public final void setXbLoginResponseBean(XiaoBinLoginResponseBean var1) {
        this.xbLoginResponseBean = var1;
    }

    public final void setXnLoginResponseBean(XiNiaoGaoPaiLoginBean var1) {
        this.xnLoginResponseBean = var1;
    }

    public final void uploadImage(Bitmap var1, String var2) {
        if (var2 != null && var1 != null) {
            final Ref.ObjectRef var3 = new Ref.ObjectRef();
            var3.element = var2;
            OkHttpPinDuoDuoManager.uploadImage(this.context, var2, var1, (OnHttpCallback)(new OnHttpCallback() {
                public void onError(int var1, String var2) {
                    //Logger.e(var2);
                }

                public void onSuccess(PinDuoDuoBaseResponseBean var1) {
                    String var3x = null;
                    String var2;
                    if (var1 != null) {
                        var2 = (String)var1.getResult();
                    } else {
                        var2 = null;
                    }

                    //Logger.i(var2);
                    var2 = var3x;
                    if (var1 != null) {
                        var2 = (String)var1.getResult();
                    }

                    if (var2 == null) {
                        //Intrinsics.throwNpe();
                    }

                    if (StringUtil.isNotEmpty(var2) && (String)var3.element != null) {
                        MixScanMamager var6 = MixScanMamager.this;
                        Object var4 = var1.getResult();
                        if (var4 == null) {
                            //Intrinsics.throwNpe();
                        }

                        String var5 = (String)var4;
                        var3x = (String)var3.element;
                        if (var3x == null) {
                            //Intrinsics.throwNpe();
                        }

                        var6.uploadImageFlag(var5, var3x);
                    }

                }

                // $FF: synthetic method
                // $FF: bridge method
                public void onSuccess(Object var1) {
                    this.onSuccess((PinDuoDuoBaseResponseBean)var1);
                }
            }));
        }

    }

    public final void uploadImageFlag(String var1, String var2) {
        ////Intrinsics.checkParameterIsNotNull(var1, "imageHttpUrl");
        ////Intrinsics.checkParameterIsNotNull(var2, "imageName");
        OkHttpPinDuoDuoManager.uploadSaveImageFlag(this.context, var1, var2, (OnHttpCallback)(new OnHttpCallback() {
            public void onError(int var1, String var2) {
                //Logger.e(var2);
            }

            public void onSuccess(PinDuoDuoBaseResponseBean var1) {
            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((PinDuoDuoBaseResponseBean)var1);
            }
        }));
    }

    public final void uploadOutLibrary(byte[] var1, final String var2) {
        ////Intrinsics.checkParameterIsNotNull(var1, "array");
        ////Intrinsics.checkParameterIsNotNull(var2, "barcode");
        boolean var3;
        if (((CharSequence)this.token).length() == 0) {
            var3 = true;
        } else {
            var3 = false;
        }

        String var9;
        if (var3) {
            RqFilePreference var8 = RqFilePreference.getInstance();
            ////Intrinsics.checkExpressionValueIsNotNull(var8, "RqFilePreference.getInstance()");
            var9 = var8.getPandaHarvestInfoToken();
            ////Intrinsics.checkExpressionValueIsNotNull(var9, "RqFilePreference.getIn…e().pandaHarvestInfoToken");
            this.token = var9;
        }

        long var4 = System.currentTimeMillis();
        StringBuilder var10 = new StringBuilder();
        var10.append("{\"mailNo\":\"");
        var10.append(var2);
        var10.append("\"}");
        var9 = var10.toString();
        StringBuilder var6 = new StringBuilder();
        var6.append(var9);
        var6.append(/*ApiPandaHarvestActvity.Companion.getAccountName()*/"YP75838571");
        var6.append("OUTPUT_PARCEL");
        var6.append(this.token);
        var6.append(var4);
        var6.append(/*ApiPandaHarvestActvity.Companion.getAccountPassword()*/"yRLgecjAxVi9gLXx");
        String var11 = var6.toString();
        Charset var7 = Charset.forName("utf-8");
        ////Intrinsics.checkExpressionValueIsNotNull(var7, "Charset.forName(charsetName)");
        if (var11 != null) {
            byte[] var12 = var11.getBytes(var7);
            ////Intrinsics.checkExpressionValueIsNotNull(var12, "(this as java.lang.String).getBytes(charset)");
            var11 = Md5InputStream.md5((InputStream)(new ByteArrayInputStream(var12)));
            Map var13 = (Map)(new HashMap());
            var13.put("bizData", var9);
            var13.put("timestamp", String.valueOf(var4));
            var13.put("accountName", /*ApiPandaHarvestActvity.Companion.getAccountName()*/"YP75838571");
            var13.put("apiName", "OUTPUT_PARCEL");
            var13.put("token", this.token);
            ////Intrinsics.checkExpressionValueIsNotNull(var11, "md5Str");
            var13.put("sign", var11);
            OkhttpManager.pandaHarvestOutLib(var13, (OnOkhttpCallback)(new OnOkhttpCallback() {
                public final void onSuccess(PandaOutLibCall var1) {
                    PandaOutData var3 = (PandaOutData)JSON.parseObject(var1.getD(), PandaOutData.class);
                    CurrentParcel var2x = var3.getCurrentParcel();
                    if (var2x == null) {
                        //Intrinsics.throwNpe();
                    }

                    PandaBeanKt.upPic(Integer.parseInt(var2x.getParcelId()), var3.getCurrentParcel().getArriveTime(), var2, MixScanMamager.this.getToken());
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ////Intrinsics.checkParameterIsNotNull(var1, "$receiver");
                            if (MixScanMamager.this.getMOkhttpStaionCallback() != null) {
                                OkhttpCallbackStationManager var2x = MixScanMamager.this.getMOkhttpStaionCallback();
                                if (var2x != null) {
                                    var2x.onOkhttpOutLibrarySuccess(ExpressStationEnum.PANDAHARVEST, "出库成功");
                                }
                            }
                        }
                    }).start();
                    /*MixScanMamager.this.getContext().runOnUiThread(MixScanMamager.this.getContext(), (Function1)(new Function1() {
                        // $FF: synthetic method
                        // $FF: bridge method
                        public Object invoke(Object var1) {
                            this.invoke((Context)var1);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Context var1) {
                            ////Intrinsics.checkParameterIsNotNull(var1, "$receiver");
                            if (MixScanMamager.this.getMOkhttpStaionCallback() != null) {
                                OkhttpCallbackStationManager var2x = MixScanMamager.this.getMOkhttpStaionCallback();
                                if (var2x != null) {
                                    var2x.onOkhttpOutLibrarySuccess(ExpressStationEnum.PANDAHARVEST, "出库成功");
                                }
                            }

                        }
                    }));*/
                }

                // $FF: synthetic method
                // $FF: bridge method
                public void onSuccess(Object var1) {
                    this.onSuccess((PandaOutLibCall)var1);
                }
            }));
        } else {
            //throw new Exception("null cannot be cast to non-null type java.lang.String");
        }
    }

    public final void xiNiaoGaoPaiLogin(String var1, String var2, String var3) {
        ////Intrinsics.checkParameterIsNotNull(var1, "station");
        ////Intrinsics.checkParameterIsNotNull(var2, "code");
        ////Intrinsics.checkParameterIsNotNull(var3, "key");
        GaoPaiYiRequest var4 = new GaoPaiYiRequest();
        var4.setWaybillNo("4310942876056");
        var4.setUnionCode(var1);
        var4.setDeviceCode(var2);
        var4.setTimestamp(String.valueOf(System.currentTimeMillis()));
        StringBuilder var5 = new StringBuilder();
        var5.append(var4.getWaybillNo());
        var5.append(var4.getUnionCode());
        var5.append(var4.getDeviceCode());
        var5.append(var4.getTimestamp());
        var5.append(var3);
        var1 = var5.toString();
        Charset var7 = UTF_8;
        if (var1 != null) {
            byte[] var6 = var1.getBytes(var7);
            ////Intrinsics.checkExpressionValueIsNotNull(var6, "(this as java.lang.String).getBytes(charset)");
            var4.setSignature(Base64Util.getBaseString(var6));
            OkhttpManager.xiNiaoGaoPaiLogin(var4, var3, (OnOkhttpCallback)(new OnOkhttpCallback() {
                public final void onSuccess(Object var1) {
                    if (var1 != null) {
                        MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                        if (var2 != null) {
                            var2.onLoginSuccess(ExpressStationEnum.XINIAOGAOPAIYI, "溪鸟登录成功");
                        }
                    }

                }
            }));
        } else {
            //throw new Exception("null cannot be cast to non-null type java.lang.String");
        }
    }

    public final void xiaoBinLogin(String var1, String var2) {
        ////Intrinsics.checkParameterIsNotNull(var1, "username");
        ////Intrinsics.checkParameterIsNotNull(var2, "passoword");
        OkhttpManager.xiaobinLogin(var1, var2, (OnOkhttpCallback)(new OnOkhttpCallback() {
            public final void onSuccess(Object var1) {
                if (var1 != null) {
                    MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                    if (var2 != null) {
                        var2.onLoginSuccess(ExpressStationEnum.XIAOBINGSTATION, "小兵驿站登录成功");
                    }
                }

            }
        }));
    }

    public final void yishoufaLogin(String var1, String var2, String var3) {
        ////Intrinsics.checkParameterIsNotNull(var1, "username");
        ////Intrinsics.checkParameterIsNotNull(var2, "password");
        ////Intrinsics.checkParameterIsNotNull(var3, "userType");
        OkhttpManager.yShouFaLogin(var1, var2, (OnOkhttpCallback)(new OnOkhttpCallback() {
            public final void onSuccess(Object var1) {
                if (var1 != null) {
                    MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                    if (var2 != null) {
                        var2.onLoginSuccess(ExpressStationEnum.YSHOUFA, "驿收发登录成功");
                    }
                }

            }
        }));
    }

    public final void yundaKdcsLogin(String var1, String var2) {
        ////Intrinsics.checkParameterIsNotNull(var1, "username");
        ////Intrinsics.checkParameterIsNotNull(var2, "passoword");
        OkhttpManager.yundaKDCSNewLoginApi(var1, var2, (OnOkhttpCallback)(new OnOkhttpCallback() {
            public final void onSuccess(Object var1) {
                MixScanMamager.OkhttpCallbackStationManager var2 = MixScanMamager.this.getMOkhttpStaionCallback();
                if (var2 != null) {
                    var2.onLoginSuccess(ExpressStationEnum.YUNDAKDCS, "韵达快递超市登录成功");
                }

            }
        }));
    }
    public interface OkhttpCallBackDuoDuo {
        void onOkhttpError(int var1, String var2);
    }

    public interface OkhttpCallbackStationManager {
        void onLoginSuccess(ExpressStationEnum var1, String var2);

        void onOkhttpError(int var1, String var2);

        void onOkhttpMuchPackageShow(List var1);

        void onOkhttpOutLibrarySuccess(ExpressStationEnum var1, String var2);
    }
}

class MixScanMamager$WhenMappings {
    // $FF: synthetic field
    public static final int[] $EnumSwitchMapping$0 = new int[ExpressStationEnum.values().length];
    // $FF: synthetic field
    public static final int[] $EnumSwitchMapping$1;

    static {
        $EnumSwitchMapping$0[ExpressStationEnum.CAINIAO.ordinal()] = 1;
        $EnumSwitchMapping$0[ExpressStationEnum.KUAIBAO.ordinal()] = 2;
        $EnumSwitchMapping$0[ExpressStationEnum.KUAIDICAOSHI.ordinal()] = 3;
        $EnumSwitchMapping$0[ExpressStationEnum.MAMASTATION.ordinal()] = 4;
        $EnumSwitchMapping$0[ExpressStationEnum.LAIQU.ordinal()] = 5;
        $EnumSwitchMapping$0[ExpressStationEnum.YUNDAKDCS.ordinal()] = 6;
        $EnumSwitchMapping$0[ExpressStationEnum.FENGCHAOSERVICE.ordinal()] = 7;
        $EnumSwitchMapping$1 = new int[ExpressStationEnum.values().length];
        $EnumSwitchMapping$1[ExpressStationEnum.KUAIBAO.ordinal()] = 1;
        $EnumSwitchMapping$1[ExpressStationEnum.YSHOUFA.ordinal()] = 2;
        $EnumSwitchMapping$1[ExpressStationEnum.KUAIDICAOSHI.ordinal()] = 3;
        $EnumSwitchMapping$1[ExpressStationEnum.MAMASTATION.ordinal()] = 4;
        $EnumSwitchMapping$1[ExpressStationEnum.LAIQU.ordinal()] = 5;
        $EnumSwitchMapping$1[ExpressStationEnum.YUNDAKDCS.ordinal()] = 6;
        $EnumSwitchMapping$1[ExpressStationEnum.FENGCHAOSERVICE.ordinal()] = 7;
        $EnumSwitchMapping$1[ExpressStationEnum.PANDAHARVEST.ordinal()] = 8;
    }
}