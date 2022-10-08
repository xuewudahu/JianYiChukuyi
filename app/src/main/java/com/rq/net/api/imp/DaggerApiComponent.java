package com.rq.net.api.imp;

import com.rq.net.api.ApiComponent;
import com.rq.net.di.*;
import com.rq.net.request.RequestApi;
import com.rq.net.request.RequestApiAdvert;
import com.rq.net.request.RequestApiBaoGuoVip;
import com.rq.net.request.RequestApiBlueShop;
import com.rq.net.request.RequestApiChengZhongDengJi;
import com.rq.net.request.RequestApiCourSmallPole;
import com.rq.net.request.RequestApiDeviceManager;
import com.rq.net.request.RequestApiFcbox;
import com.rq.net.request.RequestApiFssh;
import com.rq.net.request.RequestApiHyl;
import com.rq.net.request.RequestApiJiTu;
import com.rq.net.request.RequestApiJinLinBao;
import com.rq.net.request.RequestApiJoyFinder;
import com.rq.net.request.RequestApiJuShuiTan;
import com.rq.net.request.RequestApiKDCS;
import com.rq.net.request.RequestApiKuaibao;
import com.rq.net.request.RequestApiLaiqu;
import com.rq.net.request.RequestApiLaiquSts;
import com.rq.net.request.RequestApiLoginKDCS;
import com.rq.net.request.RequestApiMaMa;
import com.rq.net.request.RequestApiMaMaOutLibrary;
import com.rq.net.request.RequestApiMaMaYZ;
import com.rq.net.request.RequestApiMiaoZhan;
import com.rq.net.request.RequestApiPandaHarvest;
import com.rq.net.request.RequestApiPinDuoDuo;
import com.rq.net.request.RequestApiSplaiqu;
import com.rq.net.request.RequestApiStageSmallPole;
import com.rq.net.request.RequestApiStationHelper;
import com.rq.net.request.RequestApiSuDiYi;
import com.rq.net.request.RequestApiXbdUploadPicture;
import com.rq.net.request.RequestApiXiNiaoGaoPai;
import com.rq.net.request.RequestApiXiaoBin;
import com.rq.net.request.RequestApiXingHuo;
import com.rq.net.request.RequestApiYshouFa;
import com.rq.net.request.RequestApiYunDaKDCS;
import com.rq.net.request.RequestApiYundaNewKDCS;
import com.rq.net.request.RequestApiZhongYouKT;
import com.rq.net.request.RequestApiZhongYouStation;
import com.rq.net.request.RequestApiZyzt;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerApiComponent implements ApiComponent {
    private Provider<RequestApiPinDuoDuo> getRequestApiDuoDuoStationProvider;
    private Provider<RequestApiMiaoZhan> getRequestApiMiaoZhanStationProvider;
    private Provider<RequestApiSuDiYi> getRequestApiSuDiYiProvider;
    private Provider<RequestApiZhongYouStation> getRequestApiZhongYouStationProvider;
    private Provider<RequestApiZyzt> getRequestApiZyztStationProvider;
    private Provider<RequestApiAdvert> obtainAdvertRequestApiProvider;
    private Provider<RequestApiPandaHarvest> obtainApiPandaHarvestApiProvider;
    private Provider<RequestApiBaoGuoVip> obtainBaoGuoVipRequestApiProvider;
    private Provider<RequestApiBlueShop> obtainBlueShopRequestApiProvider;
    private Provider<RequestApiChengZhongDengJi> obtainChengZhongDengJiRequestApiProvider;
    private Provider<RequestApiCourSmallPole> obtainCourierSmallPoleRequestApiProvider;
    private Provider<RequestApiDeviceManager> obtainDeviceManagerRequestApiProvider;
    private Provider<RequestApiFcbox> obtainFcboxRequestApiProvider;
    private Provider<RequestApiFssh> obtainFenShiShengHuoRequestApiProvider;
    private Provider<RequestApiHyl> obtainHylRequestApiProvider;
    private Provider<RequestApiJiTu> obtainJiTuRequestApiProvider;
    private Provider<RequestApiJinLinBao> obtainJinLinBaoRequestApiProvider;
    private Provider<RequestApiJoyFinder> obtainJoyFinderRequestApiProvider;
    private Provider<RequestApiJuShuiTan> obtainJuShuiTanRequestApiProvider;
    private Provider<RequestApiKuaibao> obtainKuaiBaoRequestApiProvider;
    private Provider<RequestApiLaiquSts> obtainLaiQuStsRequestApiProvider;
    private Provider<RequestApiLaiqu> obtainLaiquRequestApiProvider;
    private Provider<RequestApiMaMaOutLibrary> obtainMaMaOutLibraryRequestApiProvider;
    private Provider<RequestApiMaMa> obtainMaMaRequestApiProvider;
    private Provider<RequestApiMaMaYZ> obtainMaMaYZRequestApiProvider;
    private Provider<RequestApi> obtainRequestApiProvider;
    private Provider<RequestApiSplaiqu> obtainSplaiquRequestApiProvider;
    private Provider<RequestApiStageSmallPole> obtainStageSmallPoleRequestApiProvider;
    private Provider<RequestApiStationHelper> obtainStationHelperRequestApiProvider;
    private Provider<RequestApiLoginKDCS> obtainWjssoRequestApiProvider;
    private Provider<RequestApiXiNiaoGaoPai> obtainXiNiaoGaoPaiRequestApiProvider;
    private Provider<RequestApiXbdUploadPicture> obtainXiaoBianDanRequestApiProvider;
    private Provider<RequestApiXiaoBin> obtainXiaoBinRequestApiProvider;
    private Provider<RequestApiXingHuo> obtainXingHuoRequestApiProvider;
    private Provider<RequestApiYshouFa> obtainYshouFaRequestApiProvider;
    private Provider<RequestApiYunDaKDCS> obtainYunDaKDCSRequestApiProvider;
    private Provider<RequestApiYundaNewKDCS> obtainYundaNewKDCSRequestApiProvider;
    private Provider<RequestApiZhongYouKT> obtainZhongYouRequestApiProvider;
    private Provider<RequestApiKDCS> obtainZtwjgatewayRequestApiProvider;

    private DaggerApiComponent(DaggerApiComponent.Builder var1) {
        this.initialize(var1);
    }

    public static DaggerApiComponent.Builder builder() {
        return new DaggerApiComponent.Builder();
    }

    private void initialize(DaggerApiComponent.Builder var1) {
        this.obtainRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainRequestApiFactory.create(var1.apiModule));
        this.obtainDeviceManagerRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainDeviceManagerRequestApiFactory.create(var1.apiModule));
        this.obtainJoyFinderRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainJoyFinderRequestApiFactory.create(var1.apiModule));
        this.obtainLaiquRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainLaiquRequestApiFactory.create(var1.apiModule));
        this.obtainAdvertRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainAdvertRequestApiFactory.create(var1.apiModule));
        this.obtainWjssoRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainWjssoRequestApiFactory.create(var1.apiModule));
        this.obtainZtwjgatewayRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainZtwjgatewayRequestApiFactory.create(var1.apiModule));
        this.obtainKuaiBaoRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainKuaiBaoRequestApiFactory.create(var1.apiModule));
        this.obtainMaMaRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainMaMaRequestApiFactory.create(var1.apiModule));
        this.obtainMaMaOutLibraryRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainMaMaOutLibraryRequestApiFactory.create(var1.apiModule));
        this.obtainYunDaKDCSRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainYunDaKDCSRequestApiFactory.create(var1.apiModule));
        this.obtainMaMaYZRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainMaMaYZRequestApiFactory.create(var1.apiModule));
        this.obtainSplaiquRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainSplaiquRequestApiFactory.create(var1.apiModule));
        this.obtainFcboxRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainFcboxRequestApiFactory.create(var1.apiModule));
        this.obtainXiaoBinRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainXiaoBinRequestApiFactory.create(var1.apiModule));
        this.obtainLaiQuStsRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainLaiQuStsRequestApiFactory.create(var1.apiModule));
        this.obtainYundaNewKDCSRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainYundaNewKDCSRequestApiFactory.create(var1.apiModule));
        this.obtainApiPandaHarvestApiProvider = DoubleCheck.provider(ApiModule_ObtainApiPandaHarvestApiFactory.create(var1.apiModule));
        this.obtainStationHelperRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainStationHelperRequestApiFactory.create(var1.apiModule));
        this.obtainCourierSmallPoleRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainCourierSmallPoleRequestApiFactory.create(var1.apiModule));
        this.obtainStageSmallPoleRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainStageSmallPoleRequestApiFactory.create(var1.apiModule));
        this.obtainBlueShopRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainBlueShopRequestApiFactory.create(var1.apiModule));
        this.obtainJuShuiTanRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainJuShuiTanRequestApiFactory.create(var1.apiModule));
        this.obtainXiNiaoGaoPaiRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainXiNiaoGaoPaiRequestApiFactory.create(var1.apiModule));
        this.obtainJinLinBaoRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainJinLinBaoRequestApiFactory.create(var1.apiModule));
        this.obtainYshouFaRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainYshouFaRequestApiFactory.create(var1.apiModule));
        this.obtainBaoGuoVipRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainBaoGuoVipRequestApiFactory.create(var1.apiModule));
        this.obtainHylRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainHylRequestApiFactory.create(var1.apiModule));
        this.obtainZhongYouRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainZhongYouRequestApiFactory.create(var1.apiModule));
        this.getRequestApiSuDiYiProvider = DoubleCheck.provider(ApiModule_GetRequestApiSuDiYiFactory.create(var1.apiModule));
        this.obtainChengZhongDengJiRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainChengZhongDengJiRequestApiFactory.create(var1.apiModule));
        this.obtainJiTuRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainJiTuRequestApiFactory.create(var1.apiModule));
        this.obtainXingHuoRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainXingHuoRequestApiFactory.create(var1.apiModule));
        this.obtainFenShiShengHuoRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainFenShiShengHuoRequestApiFactory.create(var1.apiModule));
        this.obtainXiaoBianDanRequestApiProvider = DoubleCheck.provider(ApiModule_ObtainXiaoBianDanRequestApiFactory.create(var1.apiModule));
        this.getRequestApiZhongYouStationProvider = DoubleCheck.provider(ApiModule_GetRequestApiZhongYouStationFactory.create(var1.apiModule));
        this.getRequestApiMiaoZhanStationProvider = DoubleCheck.provider(ApiModule_GetRequestApiMiaoZhanStationFactory.create(var1.apiModule));
        this.getRequestApiZyztStationProvider = DoubleCheck.provider(ApiModule_GetRequestApiZyztStationFactory.create(var1.apiModule));
        this.getRequestApiDuoDuoStationProvider = DoubleCheck.provider(ApiModule_GetRequestApiDuoDuoStationFactory.create(var1.apiModule));
    }

    public RequestApi getRequestApi() {
        return (RequestApi)this.obtainRequestApiProvider.get();
    }

    public RequestApiAdvert getRequestApiAdvert() {
        return (RequestApiAdvert)this.obtainAdvertRequestApiProvider.get();
    }

    public RequestApiJuShuiTan getRequestApiApiJuShuiTan() {
        return (RequestApiJuShuiTan)this.obtainJuShuiTanRequestApiProvider.get();
    }

    public RequestApiBlueShop getRequestApiBlueShop() {
        return (RequestApiBlueShop)this.obtainBlueShopRequestApiProvider.get();
    }

    public RequestApiCourSmallPole getRequestApiCourSmallPole() {
        return (RequestApiCourSmallPole)this.obtainCourierSmallPoleRequestApiProvider.get();
    }

    public RequestApiDeviceManager getRequestApiDeviceManager() {
        return (RequestApiDeviceManager)this.obtainDeviceManagerRequestApiProvider.get();
    }

    public RequestApiPinDuoDuo getRequestApiDuoDuoStation() {
        return (RequestApiPinDuoDuo)this.getRequestApiDuoDuoStationProvider.get();
    }

    public RequestApiFcbox getRequestApiFcbox() {
        return (RequestApiFcbox)this.obtainFcboxRequestApiProvider.get();
    }

    public RequestApiFssh getRequestApiFenShiShenHuo() {
        return (RequestApiFssh)this.obtainFenShiShengHuoRequestApiProvider.get();
    }

    public RequestApiBaoGuoVip getRequestApiGuoGuoYiZhan() {
        return (RequestApiBaoGuoVip)this.obtainBaoGuoVipRequestApiProvider.get();
    }

    public RequestApiHyl getRequestApiHyl() {
        return (RequestApiHyl)this.obtainHylRequestApiProvider.get();
    }

    public RequestApiJinLinBao getRequestApiJinLinBao() {
        return (RequestApiJinLinBao)this.obtainJinLinBaoRequestApiProvider.get();
    }

    public RequestApiJoyFinder getRequestApiJoyFinder() {
        return (RequestApiJoyFinder)this.obtainJoyFinderRequestApiProvider.get();
    }

    public RequestApiKDCS getRequestApiKDCS() {
        return (RequestApiKDCS)this.obtainZtwjgatewayRequestApiProvider.get();
    }

    public RequestApiKuaibao getRequestApiKuaiBao() {
        return (RequestApiKuaibao)this.obtainKuaiBaoRequestApiProvider.get();
    }

    public RequestApiLaiqu getRequestApiLaiqu() {
        return (RequestApiLaiqu)this.obtainLaiquRequestApiProvider.get();
    }

    public RequestApiLaiquSts getRequestApiLaiquSts() {
        return (RequestApiLaiquSts)this.obtainLaiQuStsRequestApiProvider.get();
    }

    public RequestApiLoginKDCS getRequestApiLoginKDCS() {
        return (RequestApiLoginKDCS)this.obtainWjssoRequestApiProvider.get();
    }

    public RequestApiMaMa getRequestApiMaMa() {
        return (RequestApiMaMa)this.obtainMaMaRequestApiProvider.get();
    }

    public RequestApiMaMaOutLibrary getRequestApiMaMaOutLibrary() {
        return (RequestApiMaMaOutLibrary)this.obtainMaMaOutLibraryRequestApiProvider.get();
    }

    public RequestApiMaMaYZ getRequestApiMaMaYZ() {
        return (RequestApiMaMaYZ)this.obtainMaMaYZRequestApiProvider.get();
    }

    public RequestApiMiaoZhan getRequestApiMiaoZhanStation() {
        return (RequestApiMiaoZhan)this.getRequestApiMiaoZhanStationProvider.get();
    }

    public RequestApiPandaHarvest getRequestApiPandaHarvest() {
        return (RequestApiPandaHarvest)this.obtainApiPandaHarvestApiProvider.get();
    }

    public RequestApiSplaiqu getRequestApiSplaiqu() {
        return (RequestApiSplaiqu)this.obtainSplaiquRequestApiProvider.get();
    }

    public RequestApiStageSmallPole getRequestApiStageSmallPole() {
        return (RequestApiStageSmallPole)this.obtainStageSmallPoleRequestApiProvider.get();
    }

    public RequestApiStationHelper getRequestApiStationHelper() {
        return (RequestApiStationHelper)this.obtainStationHelperRequestApiProvider.get();
    }

    public RequestApiSuDiYi getRequestApiSuDiYi() {
        return (RequestApiSuDiYi)this.getRequestApiSuDiYiProvider.get();
    }

    public RequestApiXiNiaoGaoPai getRequestApiXiNiaoGaoPai() {
        return (RequestApiXiNiaoGaoPai)this.obtainXiNiaoGaoPaiRequestApiProvider.get();
    }

    public RequestApiXbdUploadPicture getRequestApiXiaoBianDan() {
        return (RequestApiXbdUploadPicture)this.obtainXiaoBianDanRequestApiProvider.get();
    }

    public RequestApiXiaoBin getRequestApiXiaoBin() {
        return (RequestApiXiaoBin)this.obtainXiaoBinRequestApiProvider.get();
    }

    public RequestApiYshouFa getRequestApiYshouFa() {
        return (RequestApiYshouFa)this.obtainYshouFaRequestApiProvider.get();
    }

    public RequestApiYunDaKDCS getRequestApiYunDaKDCS() {
        return (RequestApiYunDaKDCS)this.obtainYunDaKDCSRequestApiProvider.get();
    }

    public RequestApiYundaNewKDCS getRequestApiYundaNewKDCS() {
        return (RequestApiYundaNewKDCS)this.obtainYundaNewKDCSRequestApiProvider.get();
    }

    public RequestApiZhongYouKT getRequestApiZhongYou() {
        return (RequestApiZhongYouKT)this.obtainZhongYouRequestApiProvider.get();
    }

    public RequestApiZhongYouStation getRequestApiZhongYouStation() {
        return (RequestApiZhongYouStation)this.getRequestApiZhongYouStationProvider.get();
    }

    public RequestApiZyzt getRequestApiZyztStation() {
        return (RequestApiZyzt)this.getRequestApiZyztStationProvider.get();
    }

    public RequestApiChengZhongDengJi getRequestChengZhongDengJi() {
        return (RequestApiChengZhongDengJi)this.obtainChengZhongDengJiRequestApiProvider.get();
    }

    public RequestApiJiTu getRequestJiTu() {
        return (RequestApiJiTu)this.obtainJiTuRequestApiProvider.get();
    }

    public RequestApiXingHuo getXingHuo() {
        return (RequestApiXingHuo)this.obtainXingHuoRequestApiProvider.get();
    }

    public static final class Builder {
        private ApiModule apiModule;

        private Builder() {
        }

        public DaggerApiComponent.Builder apiModule(ApiModule var1) {
            this.apiModule = (ApiModule)Preconditions.checkNotNull(var1);
            return this;
        }

        public ApiComponent build() {
            if (this.apiModule != null) {
                return new DaggerApiComponent(this);
            } else {
                StringBuilder var1 = new StringBuilder();
                var1.append(ApiModule.class.getCanonicalName());
                var1.append(" must be set");
                throw new IllegalStateException(var1.toString());
            }
        }
    }
}
