package com.rq.net.di;

import android.content.Context;
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
import com.rq.net.di.ReposifitModule;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ApiModule extends ReposifitModule {
    public ApiModule(Context var1, boolean var2, String... var3) {
        super(var1, var2, var3);
    }

    @Provides
    @Singleton
    RequestApiPinDuoDuo getRequestApiDuoDuoStation() {
        return (RequestApiPinDuoDuo)this.obtainDuoDuoRetrofit().create(RequestApiPinDuoDuo.class);
    }

    @Provides
    @Singleton
    RequestApiMiaoZhan getRequestApiMiaoZhanStation() {
        return (RequestApiMiaoZhan)this.obtainMiaozhanRetrofitRetrofit().create(RequestApiMiaoZhan.class);
    }

    @Provides
    @Singleton
    RequestApiSuDiYi getRequestApiSuDiYi() {
        return (RequestApiSuDiYi)this.obtainRequestApiSuDiYi().create(RequestApiSuDiYi.class);
    }

    @Provides
    @Singleton
    RequestApiZhongYouStation getRequestApiZhongYouStation() {
        return (RequestApiZhongYouStation)this.obtainZhongYouStationRetrofit().create(RequestApiZhongYouStation.class);
    }

    @Provides
    @Singleton
    RequestApiZyzt getRequestApiZyztStation() {
        return (RequestApiZyzt)this.obtainZyztRetrofitRetrofit().create(RequestApiZyzt.class);
    }

    @Provides
    @Singleton
    RequestApiAdvert obtainAdvertRequestApi() {
        return (RequestApiAdvert)this.obtainAdvertRetrofit().create(RequestApiAdvert.class);
    }

    @Provides
    @Singleton
    RequestApiPandaHarvest obtainApiPandaHarvestApi() {
        return (RequestApiPandaHarvest)this.obtainPandaHarvestRetrofit().create(RequestApiPandaHarvest.class);
    }

    @Provides
    @Singleton
    RequestApiBaoGuoVip obtainBaoGuoVipRequestApi() {
        return (RequestApiBaoGuoVip)this.obtainBaoGuoVipRetrofit().create(RequestApiBaoGuoVip.class);
    }

    @Provides
    @Singleton
    RequestApiBlueShop obtainBlueShopRequestApi() {
        return (RequestApiBlueShop)this.obtainBlueShopRetrofit().create(RequestApiBlueShop.class);
    }

    @Provides
    @Singleton
    RequestApiChengZhongDengJi obtainChengZhongDengJiRequestApi() {
        return (RequestApiChengZhongDengJi)this.obtainChengZhongDengJiRetrofit().create(RequestApiChengZhongDengJi.class);
    }

    @Provides
    @Singleton
    RequestApiCourSmallPole obtainCourierSmallPoleRequestApi() {
        return (RequestApiCourSmallPole)this.obtainCourierSmallRetrofit().create(RequestApiCourSmallPole.class);
    }

    @Provides
    @Singleton
    RequestApiDeviceManager obtainDeviceManagerRequestApi() {
        return (RequestApiDeviceManager)this.obtainDeviceManagerRetrofit().create(RequestApiDeviceManager.class);
    }

    @Provides
    @Singleton
    RequestApiFcbox obtainFcboxRequestApi() {
        return (RequestApiFcbox)this.obtainFcboxRetrofit().create(RequestApiFcbox.class);
    }

    @Provides
    @Singleton
    RequestApiFssh obtainFenShiShengHuoRequestApi() {
        return (RequestApiFssh)this.obtainFenShiShenHuoRetrofit().create(RequestApiFssh.class);
    }

    @Provides
    @Singleton
    RequestApiHyl obtainHylRequestApi() {
        return (RequestApiHyl)this.obtainHylRetrofit().create(RequestApiHyl.class);
    }

    @Provides
    @Singleton
    RequestApiJiTu obtainJiTuRequestApi() {
        return (RequestApiJiTu)this.obtainJiTuRetrofit().create(RequestApiJiTu.class);
    }

    @Provides
    @Singleton
    RequestApiJinLinBao obtainJinLinBaoRequestApi() {
        return (RequestApiJinLinBao)this.obtainJinLinBaoRetrofit().create(RequestApiJinLinBao.class);
    }

    @Provides
    @Singleton
    RequestApiJoyFinder obtainJoyFinderRequestApi() {
        return (RequestApiJoyFinder)this.obtainJoyFinderRetrofit().create(RequestApiJoyFinder.class);
    }

    @Provides
    @Singleton
    RequestApiJuShuiTan obtainJuShuiTanRequestApi() {
        return (RequestApiJuShuiTan)this.obtainJuShuiTanRetrofit().create(RequestApiJuShuiTan.class);
    }

    @Provides
    @Singleton
    RequestApiKuaibao obtainKuaiBaoRequestApi() {
        return (RequestApiKuaibao)this.obtainKuaiBaoRetrofit().create(RequestApiKuaibao.class);
    }

    @Provides
    @Singleton
    RequestApiLaiquSts obtainLaiQuStsRequestApi() {
        return (RequestApiLaiquSts)this.obtainLaiQuStsRetrofit().create(RequestApiLaiquSts.class);
    }

    @Provides
    @Singleton
    RequestApiLaiqu obtainLaiquRequestApi() {
        return (RequestApiLaiqu)this.obtainLaiquRetrofit().create(RequestApiLaiqu.class);
    }

    @Provides
    @Singleton
    RequestApiMaMaOutLibrary obtainMaMaOutLibraryRequestApi() {
        return (RequestApiMaMaOutLibrary)this.obtainMaMaOutLibraryRetrofit().create(RequestApiMaMaOutLibrary.class);
    }

    @Provides
    @Singleton
    RequestApiMaMa obtainMaMaRequestApi() {
        return (RequestApiMaMa)this.obtainMaMaRetrofit().create(RequestApiMaMa.class);
    }

    @Provides
    @Singleton
    RequestApiMaMaYZ obtainMaMaYZRequestApi() {
        return (RequestApiMaMaYZ)this.obtainMaMaYZRetrofit().create(RequestApiMaMaYZ.class);
    }

    @Provides
    @Singleton
    BaseRequestApi obtainRequestApi() {
        return (BaseRequestApi)this.obtainRetrofit().create(BaseRequestApi.class);
    }

    @Provides
    @Singleton
    RequestApiSplaiqu obtainSplaiquRequestApi() {
        return (RequestApiSplaiqu)this.obtainSplaiquRetrofit().create(RequestApiSplaiqu.class);
    }

    @Provides
    @Singleton
    RequestApiStageSmallPole obtainStageSmallPoleRequestApi() {
        return (RequestApiStageSmallPole)this.obtainStageSmallRetrofit().create(RequestApiStageSmallPole.class);
    }

    @Provides
    @Singleton
    RequestApiStationHelper obtainStationHelperRequestApi() {
        return (RequestApiStationHelper)this.obtainstationHelpRetrofitRetrofit().create(RequestApiStationHelper.class);
    }

    @Provides
    @Singleton
    RequestApiLoginKDCS obtainWjssoRequestApi() {
        return (RequestApiLoginKDCS)this.obtainWjssoRetrofit().create(RequestApiLoginKDCS.class);
    }

    @Provides
    @Singleton
    RequestApiXiNiaoGaoPai obtainXiNiaoGaoPaiRequestApi() {
        return (RequestApiXiNiaoGaoPai)this.obtainXiNiaoGaoPaiRetrofit().create(RequestApiXiNiaoGaoPai.class);
    }

    @Provides
    @Singleton
    RequestApiXbdUploadPicture obtainXiaoBianDanRequestApi() {
        return (RequestApiXbdUploadPicture)this.obtainXiaoBianDanRetrofit().create(RequestApiXbdUploadPicture.class);
    }

    @Provides
    @Singleton
    RequestApiXiaoBin obtainXiaoBinRequestApi() {
        return (RequestApiXiaoBin)this.obtainXiaoBinRetrofit().create(RequestApiXiaoBin.class);
    }

    @Provides
    @Singleton
    RequestApiXingHuo obtainXingHuoRequestApi() {
        return (RequestApiXingHuo)this.obtainXingHuoRetrofit().create(RequestApiXingHuo.class);
    }

    @Provides
    @Singleton
    RequestApiYshouFa obtainYshouFaRequestApi() {
        return (RequestApiYshouFa)this.obtainYshouFaRetrofit().create(RequestApiYshouFa.class);
    }

    @Provides
    @Singleton
    RequestApiYunDaKDCS obtainYunDaKDCSRequestApi() {
        return (RequestApiYunDaKDCS)this.obtainYunDaKDCSRetrofit().create(RequestApiYunDaKDCS.class);
    }

    @Provides
    @Singleton
    RequestApiYundaNewKDCS obtainYundaNewKDCSRequestApi() {
        return (RequestApiYundaNewKDCS)this.obtainYundaNewKDCSRetrofit().create(RequestApiYundaNewKDCS.class);
    }

    @Provides
    @Singleton
    RequestApiZhongYouKT obtainZhongYouRequestApi() {
        return (RequestApiZhongYouKT)this.obtainZhongYouRetrofit().create(RequestApiZhongYouKT.class);
    }

    @Provides
    @Singleton
    RequestApiKDCS obtainZtwjgatewayRequestApi() {
        return (RequestApiKDCS)this.obtainZtwjgatewayRetrofit().create(RequestApiKDCS.class);
    }
}
