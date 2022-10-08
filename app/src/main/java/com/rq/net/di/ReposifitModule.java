package com.rq.net.di;

import android.content.Context;
import com.rq.net.di.BaseRequestApi;
import com.rq.net.di.HeaderInterceptor;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ReposifitModule {
    private Retrofit advertRetrofit;
    private Retrofit baoGuoVipRetrofit;
    private Retrofit blueShopRetrofit;
    private Retrofit chengZhongDengJiRetrofit;
    private Retrofit courierSmallPoleRetrofit;
    private Retrofit deviceManagerRetrofit;
    private Retrofit duoduoRetrofit;
    private Retrofit emsStationRetrofit;
    private Retrofit fcboxRetrofit;
    private Retrofit fsshRetrofit;
    private Retrofit hylRetrofit;
    private Retrofit jiTuRetrofit;
    private Retrofit jinLinBaoRetrofit;
    private Retrofit joyFinderRetrofit;
    private Retrofit juShuiTanRetrofit;
    private Retrofit kuaibaoRetrofit;
    private Retrofit laiquRetrofit;
    private Retrofit laiquStsRegistRetrofit;
    private Context mContext;
    private StringBuilder mMessage = new StringBuilder();
    private OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;
    private Retrofit mamaOutLibraryRetrofit;
    private Retrofit mamaRetrofit;
    private Retrofit mamayzRetrofit;
    private Retrofit miaozhanRetrofit;
    private Retrofit pandaHarvestRetrofit;
    private Retrofit splaiquRetrofit;
    private Retrofit stageSmallPoleRetrofit;
    private Retrofit stationHelpRetrofit;
    private Retrofit suDiYiRetrofit;
    private Retrofit wjssoRetrofit;
    private Retrofit xbdimgRetrofit;
    private Retrofit xiNiaoGaoPaiRetrofit;
    private Retrofit xiaobinRetrofit;
    private Retrofit xingHuoRetrofit;
    private Retrofit yShouFaRetrofit;
    private Retrofit yundaKDCSRetrofit;
    private Retrofit yundaNewKDCSRetrofit;
    private Retrofit zhongYouRetrofit;
    private Retrofit ztwjgatewayRetrofit;
    private Retrofit zyztRetrofit;

    public ReposifitModule(Context var1, boolean var2, String... var3) {
        try {
            this.mContext = var1;
            HttpLoggingInterceptor var6 = new HttpLoggingInterceptor();
            var6.setLevel(Level.BODY);
            HeaderInterceptor var4 = new HeaderInterceptor(this.mContext);
            this.mOkHttpClient = (new Builder()).addInterceptor(var4).addInterceptor(var6).retryOnConnectionFailure(true).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).sslSocketFactory(SSLSocketClient.getSSLSocketFactory()).hostnameVerifier(SSLSocketClient.getHostnameVerifier()).cache(new Cache(this.mContext.getCacheDir(), 104857600L)).build();
            if (var3.length > 0) {
                this.mRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[0]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 1) {
                this.deviceManagerRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[1]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 2) {
                this.joyFinderRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[2]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 3) {
                this.laiquRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[3]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 4) {
                this.advertRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[4]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 5) {
                this.wjssoRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[5]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 6) {
                this.ztwjgatewayRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[6]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 7) {
                this.kuaibaoRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[7]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 8) {
                this.mamaRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[8]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 9) {
                this.mamaOutLibraryRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[9]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 10) {
                this.yundaKDCSRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[10]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 11) {
                this.mamayzRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[11]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 12) {
                this.splaiquRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[12]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 13) {
                this.fcboxRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[13]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 14) {
                this.xiaobinRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[14]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 15) {
                this.laiquStsRegistRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[15]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 16) {
                this.yundaNewKDCSRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[16]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 17) {
                this.pandaHarvestRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[17]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 18) {
                this.stationHelpRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[18]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 19) {
                this.courierSmallPoleRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[19]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 20) {
                this.stageSmallPoleRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[20]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 21) {
                this.blueShopRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[21]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 22) {
                this.juShuiTanRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[22]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 23) {
                this.xiNiaoGaoPaiRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[23]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 24) {
                this.chengZhongDengJiRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[24]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 25) {
                this.jiTuRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[25]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 26) {
                this.xingHuoRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[26]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 27) {
                this.fsshRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[27]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 28) {
                this.xbdimgRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[28]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 29) {
                this.jinLinBaoRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[29]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 30) {
                this.zhongYouRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[30]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 31) {
                this.hylRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[31]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 32) {
                this.yShouFaRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[32]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 33) {
                this.baoGuoVipRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[33]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 34) {
                this.suDiYiRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[34]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 35) {
                this.emsStationRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[35]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 36) {
                this.miaozhanRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[36]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 37) {
                this.zyztRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[37]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            }

            if (var3.length > 38) {
                this.duoduoRetrofit = (new retrofit2.Retrofit.Builder()).baseUrl(var3[38]).client(this.mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
                return;
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    @Provides
    public Retrofit obtainAdvertRetrofit() {
        return this.advertRetrofit;
    }

    @Provides
    public Retrofit obtainBaoGuoVipRetrofit() {
        return this.baoGuoVipRetrofit;
    }

    @Provides
    public Retrofit obtainBlueShopRetrofit() {
        return this.blueShopRetrofit;
    }

    @Provides
    public Retrofit obtainChengZhongDengJiRetrofit() {
        return this.chengZhongDengJiRetrofit;
    }

    @Provides
    public Retrofit obtainCourierSmallRetrofit() {
        return this.courierSmallPoleRetrofit;
    }

    @Provides
    public Retrofit obtainDeviceManagerRetrofit() {
        return this.deviceManagerRetrofit;
    }

    @Provides
    public Retrofit obtainDuoDuoRetrofit() {
        return this.duoduoRetrofit;
    }

    @Provides
    public Retrofit obtainFcboxRetrofit() {
        return this.fcboxRetrofit;
    }

    @Provides
    public Retrofit obtainFenShiShenHuoRetrofit() {
        return this.fsshRetrofit;
    }

    @Provides
    public Retrofit obtainHylRetrofit() {
        return this.hylRetrofit;
    }

    @Provides
    public Retrofit obtainJiTuRetrofit() {
        return this.jiTuRetrofit;
    }

    @Provides
    public Retrofit obtainJinLinBaoRetrofit() {
        return this.jinLinBaoRetrofit;
    }

    @Provides
    public Retrofit obtainJoyFinderRetrofit() {
        return this.joyFinderRetrofit;
    }

    @Provides
    public Retrofit obtainJuShuiTanRetrofit() {
        return this.juShuiTanRetrofit;
    }

    @Provides
    public Retrofit obtainKuaiBaoRetrofit() {
        return this.kuaibaoRetrofit;
    }

    @Provides
    public Retrofit obtainLaiQuStsRetrofit() {
        return this.laiquStsRegistRetrofit;
    }

    @Provides
    public Retrofit obtainLaiquRetrofit() {
        return this.laiquRetrofit;
    }

    @Provides
    public Retrofit obtainMaMaOutLibraryRetrofit() {
        return this.mamaOutLibraryRetrofit;
    }

    @Provides
    public Retrofit obtainMaMaRetrofit() {
        return this.mamaRetrofit;
    }

    @Provides
    public Retrofit obtainMaMaYZRetrofit() {
        return this.mamayzRetrofit;
    }

    @Provides
    public Retrofit obtainMiaozhanRetrofitRetrofit() {
        return this.miaozhanRetrofit;
    }

    @Provides
    @Singleton
    OkHttpClient obtainOkHttpClient() {
        return this.mOkHttpClient;
    }

    @Provides
    public Retrofit obtainPandaHarvestRetrofit() {
        return this.pandaHarvestRetrofit;
    }

    @Provides
    @Singleton
    BaseRequestApi obtainRequestApi() {
        return (BaseRequestApi)this.obtainRetrofit().create(BaseRequestApi.class);
    }

    @Provides
    public Retrofit obtainRequestApiSuDiYi() {
        return this.suDiYiRetrofit;
    }

    @Provides
    public Retrofit obtainRetrofit() {
        return this.mRetrofit;
    }

    @Provides
    public Retrofit obtainSplaiquRetrofit() {
        return this.splaiquRetrofit;
    }

    @Provides
    public Retrofit obtainStageSmallRetrofit() {
        return this.stageSmallPoleRetrofit;
    }

    @Provides
    public Retrofit obtainWjssoRetrofit() {
        return this.wjssoRetrofit;
    }

    @Provides
    public Retrofit obtainXiNiaoGaoPaiRetrofit() {
        return this.xiNiaoGaoPaiRetrofit;
    }

    @Provides
    public Retrofit obtainXiaoBianDanRetrofit() {
        return this.xbdimgRetrofit;
    }

    @Provides
    public Retrofit obtainXiaoBinRetrofit() {
        return this.xiaobinRetrofit;
    }

    @Provides
    public Retrofit obtainXingHuoRetrofit() {
        return this.xingHuoRetrofit;
    }

    @Provides
    public Retrofit obtainYshouFaRetrofit() {
        return this.yShouFaRetrofit;
    }

    @Provides
    public Retrofit obtainYunDaKDCSRetrofit() {
        return this.yundaKDCSRetrofit;
    }

    @Provides
    public Retrofit obtainYundaNewKDCSRetrofit() {
        return this.yundaNewKDCSRetrofit;
    }

    @Provides
    public Retrofit obtainZhongYouRetrofit() {
        return this.zhongYouRetrofit;
    }

    @Provides
    public Retrofit obtainZhongYouStationRetrofit() {
        return this.emsStationRetrofit;
    }

    @Provides
    public Retrofit obtainZtwjgatewayRetrofit() {
        return this.ztwjgatewayRetrofit;
    }

    @Provides
    public Retrofit obtainZyztRetrofitRetrofit() {
        return this.zyztRetrofit;
    }

    @Provides
    public Retrofit obtainstationHelpRetrofitRetrofit() {
        return this.stationHelpRetrofit;
    }
}