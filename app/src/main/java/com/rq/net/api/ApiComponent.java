package com.rq.net.api;


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
public interface ApiComponent {
    RequestApi getRequestApi();

    RequestApiAdvert getRequestApiAdvert();

    RequestApiJuShuiTan getRequestApiApiJuShuiTan();

    RequestApiBlueShop getRequestApiBlueShop();

    RequestApiCourSmallPole getRequestApiCourSmallPole();

    RequestApiDeviceManager getRequestApiDeviceManager();

    RequestApiPinDuoDuo getRequestApiDuoDuoStation();

    RequestApiFcbox getRequestApiFcbox();

    RequestApiFssh getRequestApiFenShiShenHuo();

    RequestApiBaoGuoVip getRequestApiGuoGuoYiZhan();

    RequestApiHyl getRequestApiHyl();

    RequestApiJinLinBao getRequestApiJinLinBao();

    RequestApiJoyFinder getRequestApiJoyFinder();

    RequestApiKDCS getRequestApiKDCS();

    RequestApiKuaibao getRequestApiKuaiBao();

    RequestApiLaiqu getRequestApiLaiqu();

    RequestApiLaiquSts getRequestApiLaiquSts();

    RequestApiLoginKDCS getRequestApiLoginKDCS();

    RequestApiMaMa getRequestApiMaMa();

    RequestApiMaMaOutLibrary getRequestApiMaMaOutLibrary();

    RequestApiMaMaYZ getRequestApiMaMaYZ();

    RequestApiMiaoZhan getRequestApiMiaoZhanStation();

    RequestApiPandaHarvest getRequestApiPandaHarvest();

    RequestApiSplaiqu getRequestApiSplaiqu();

    RequestApiStageSmallPole getRequestApiStageSmallPole();

    RequestApiStationHelper getRequestApiStationHelper();

    RequestApiSuDiYi getRequestApiSuDiYi();

    RequestApiXiNiaoGaoPai getRequestApiXiNiaoGaoPai();

    RequestApiXbdUploadPicture getRequestApiXiaoBianDan();

    RequestApiXiaoBin getRequestApiXiaoBin();

    RequestApiYshouFa getRequestApiYshouFa();

    RequestApiYunDaKDCS getRequestApiYunDaKDCS();

    RequestApiYundaNewKDCS getRequestApiYundaNewKDCS();

    RequestApiZhongYouKT getRequestApiZhongYou();

    RequestApiZhongYouStation getRequestApiZhongYouStation();

    RequestApiZyzt getRequestApiZyztStation();

    RequestApiChengZhongDengJi getRequestChengZhongDengJi();

    RequestApiJiTu getRequestJiTu();

    RequestApiXingHuo getXingHuo();
}