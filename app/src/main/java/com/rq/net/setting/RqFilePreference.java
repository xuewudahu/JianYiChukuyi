package com.rq.net.setting;


import com.rq.net.bean.BlueShopCookieBean;
import com.rq.net.bean.BlueShopLoginRequestBean;
import com.rq.net.bean.CourierSmallPoleLogin;
import com.rq.net.bean.FcboxStationInforResponseBean;
import com.rq.net.bean.GetStsResponseTokenBean;
import com.rq.net.bean.GoodsTypeBean;
import com.rq.net.bean.GuoGuoInfo;
import com.rq.net.bean.HylLoginBean;
import com.rq.net.bean.JiTuLoginBean;
import com.rq.net.bean.JiTuResponse;
import com.rq.net.bean.JinLinBaoLoginResponseBean;
import com.rq.net.bean.KDCSLoginResponseBean;
import com.rq.net.bean.KDCSQueryStaffAndStoreResponseBean;
import com.rq.net.bean.KuaiBaoGetStationInforResponseBean;
import com.rq.net.bean.KuaiBaoLoginResponseBean;
import com.rq.net.bean.LaiquLoginResponseBean;
import com.rq.net.bean.LaiquSiteLoginResponseBean;
import com.rq.net.bean.LaiquStsRegistResponseBean;
import com.rq.net.bean.LoginResponseBean;
import com.rq.net.bean.MaMaLoginResponseBean;
import com.rq.net.bean.MiaoZhanLoginBean;
import com.rq.net.bean.NetManagerLoginBean;
import com.rq.net.bean.PandaHarvestRequestBean;
import com.rq.net.bean.PandaLoginBean;
import com.rq.net.bean.PubkeyAndCookie;
import com.rq.net.bean.StageLoginRequestBean;
import com.rq.net.bean.StationHelperRequestLoginBean;
import com.rq.net.bean.XiNiaoGaoPaiLoginBean;
import com.rq.net.bean.XiaoBinLoginResponseBean;
import com.rq.net.bean.XingHuoLoginBean;
import com.rq.net.bean.YshouFaLoginResponseBean;
import com.rq.net.bean.YunDaChaoShiLoginResponseBean;
import com.rq.net.bean.YunDaKDCSLoginResponseBean;
import com.rq.net.bean.ExpressCompanyListBean.ExpressCompany;
import com.rq.net.bean.SiteListBean.SiteInformation;
import com.rq.net.bean.DeviceLoginBean;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.StringUtil;
import java.util.List;

public class RqFilePreference extends CommonFilePreference {
    private static final String KEY_BLUE_SHOP_COOKIE = "key_blue_shop_cookie";
    private static final String KEY_BLUE_SHOP_LOGIN_INFOR = "key_blue_shop_login_info";
    private static final String KEY_COURIERSMALLPOLE_LOGIN_INFOR = "key_courier_small_pole";
    private static final String KEY_COURIERSMALLPOLE_LOGIN_INFOR_ACCOUNT = "key_courier_small_pole_account";
    private static final String KEY_COURIERSMALLPOLE_LOGIN_INFOR_PASSWORD = "key_courier_small_pole_password";
    private static final String KEY_COURIERSMALLPOLE_LOGIN_ZI_INFOR = "key_couriersmallpole_zi";
    private static final String KEY_GUOGUO_URL = "key_guoguo_url";
    private static final String KEY_JITU = "key_jitu";
    private static final String KEY_JITU_RESPONSE = "key_jitu_reponse";
    private static final String KEY_JUSHUITAN_TOKEN = "key_jushuitan_token";
    private static final String KEY_KEY_COOKIE = "key_key_cookie";
    private static final String KEY_MIAO_ZHAN = "key_miaozhan";
    private static final String KEY_STAGE_LOGIN_INFOR = "key_stage_info";
    private static final String KEY_XINGHUO_LOGIN = "key_xinghuo_login";
    private static final String KEY_XINIAO_GAOPAIYI = "key_xiniao_gaopaiyi";
    private static RqFilePreference mRqFilePreference;
    private final String KEY_ADVERTISE_TEMPLATE = "key_advertise_template";
    private final String KEY_AUTO_LOGIN = "key_auto_login";
    private final String KEY_BARCODE_EXPOSURE_TIME = "key_barcode_exposure_time";
    private final String KEY_BARCODE_FRAMERATE = "key_barcode_framerate";
    private final String KEY_BARCODE_GAIN = "key_barcode_gain";
    private final String KEY_BARCODE_GAMMA = "key_barcode_gamma";
    private final String KEY_BARCODE_TYPE = "key_barcode_type";
    private final String KEY_CHANGE_CEMERA_LOCAL = "key_change_cemera_local";
    private final String KEY_CLOSE_WEIGHT = "key_close_weight";
    private final String KEY_COMPANY_NAME = "key_company_name";
    private final String KEY_DUODUO_PASSWORD = "key_duoduo_password";
    private final String KEY_DUODUO_TOKEN = "key_duoduo_token";
    private final String KEY_DUODUO_USERNAME = "key_duoduo_username";
    private final String KEY_EXTERNAL_STORAGE = "key_external_storage";
    private final String KEY_FACE_CAMERA_SWT = "key_face_camera_swt";
    private final String KEY_FACE_EXPOSURE_TIME = "key_face_exposure_time";
    private final String KEY_FACE_FRAMERATE = "key_face_framerate";
    private final String KEY_FACE_GAIN = "key_face_gain";
    private final String KEY_FACE_GAMMA = "key_face_gamma";
    private final String KEY_FAST_SCAN = "key_fast_scan";
    private final String KEY_FCBOX_STATION_INFOR = "key_fcbox_station_infor";
    private final String KEY_FIRST_UPLOAD_DATA_DATE = "key_first_upload_data_date";
    private final String KEY_FSSH_APPSID = "key_fssh_appsid";
    private final String KEY_GOODS_TYPE = "key_goods_type";
    private final String KEY_GUOGUOYIZHAN = "key_guoguoyizhan";
    private final String KEY_GUOGUOYIZHAN_LOGIN_RES = "key_guoguoyizhan_login_res";
    private final String KEY_HYL_LOGIN_INFOR = "key_hyl_login_infor";
    private final String KEY_JINLINBAO_LOGIN_RES = "key_jinlinbao_login_res";
    private final String KEY_KDCS_LOGIN_INFOR = "key_kdcs_login_infor";
    private final String KEY_KUAIBAO_LOGIN_INFOR = "key_kuaibao_login_infor";
    private final String KEY_KUAIBAO_SESSION_ID = "key_kuaibao_session_id";
    private final String KEY_KUAIBAO_STATION_INFOR = "key_kuaibao_station_infor";
    private final String KEY_LAIQU_LOGIN_INFOR = "key_laiqu_login_infor";
    private final String KEY_LAIQU_SITE_LOGIN_INFOR = "key_laiqu_site_login_infor";
    private final String KEY_LAIQU_STS_REGIST = "key_laiqu_sts_regist";
    private final String KEY_LED_SWT = "key_led_swt";
    private final String KEY_LOGIN_DUODUO_PASSWORD = "key_login_duoduo_password";
    private final String KEY_LOGIN_DUODUO_USERNAME = "key_login_duoduo_username";
    private final String KEY_LOGIN_FCBOX_PASSWORD = "key_login_ycbox_password";
    private final String KEY_LOGIN_FCBOX_USERNAME = "key_login_ycbox_username";
    private final String KEY_LOGIN_INFORMATION = "key_login_information";
    private final String KEY_LOGIN_KDCS_PASSWORD = "key_login_kdcs_password";
    private final String KEY_LOGIN_KDCS_USERNAME = "key_login_kdcs_username";
    private final String KEY_LOGIN_KUAIBAO_PASSWORD = "key_login_kuaibao_password";
    private final String KEY_LOGIN_KUAIBAO_USERNAME = "key_login_kuaibao_username";
    private final String KEY_LOGIN_LAIQU_PASSWORD = "key_login_laiqu_password";
    private final String KEY_LOGIN_LAIQU_SERVICE_STAION_CODE = "key_login_laiqu_service_staion_code";
    private final String KEY_LOGIN_LAIQU_USERNAME = "key_login_laiqu_username";
    private final String KEY_LOGIN_MAMA_PASSWORD = "key_login_mama_password";
    private final String KEY_LOGIN_MAMA_USERNAME = "key_login_mama_username";
    private final String KEY_LOGIN_PASSWORD = "key_login_password";
    private final String KEY_LOGIN_USERNAME = "key_login_username";
    private final String KEY_LOGIN_XBD_EXPRESS_TYPE = "key_login_xbd_express_type";
    private final String KEY_LOGIN_XIAOBIN_PASSWORD = "key_login_xiaobin_password";
    private final String KEY_LOGIN_XIAOBIN_USERNAME = "key_login_xiaobin_username";
    private final String KEY_LOGIN_YUNDAKDCS_PASSWORD = "key_login_yundakdcs_password";
    private final String KEY_LOGIN_YUNDAKDCS_USERNAME = "key_login_yundakdcs_username";
    private final String KEY_MAMA_LOGIN_INFOR = "key_mama_login_infor";
    private final String KEY_NET_MANAGER = "key_net_manager";
    private final String KEY_OPEN_LOG = "key_open_log";
    private final String KEY_PANDAHARVEST_LOGIN_INFOR = "key_pandaharvest_login_infor";
    private final String KEY_PANDAHARVEST_LOGIN_TOKEN = "key_pandaharvest_login_token";
    private final String KEY_PANDAHARVEST_LOGIN_TWO = "key_pandaharvest_login_two";
    private final String KEY_PANDA_HARVEST_CLIENT_CODE = "key_panda_harvest_client_code";
    private final String KEY_PANDA_HARVEST_LOGIN_USER = "key_panda_harvest_login_user";
    private final String KEY_QUERY_STAFF_AND_STORE = "key_query_staff_and_store";
    private final String KEY_REFRESH_TOKEN_DATE = "key_refresh_token_date";
    private final String KEY_SAVE_PICTURE_PATH = "key_save_picture_path";
    private final String KEY_SCAN_TIMEOUT_TIME = "key_scan_timeout_time";
    private final String KEY_SHOW_MUCH_PACKAGE = "key_show_much_package";
    private final String KEY_SITE_LIST_DATA = "key_site_list_data";
    private final String KEY_STATIONHELPER_EXPRESSID_INFOR = "key_stationhelper_expressid_info";
    private final String KEY_STATIONHELPER_LOGIN_INFOR = "key_stationhelper_login_info";
    private final String KEY_STATION_UPLOAD_PICTURE = "key_station_upload_picture";
    private final String KEY_STS_RESPONSE_TOKEN = "key_sts_response_token";
    private final String KEY_TODAY_DATE = "key_today_date";
    private final String KEY_WEIGHT_DEV_TTY_PORT = "key_weight_dev_tty_port";
    private final String KEY_XIAOBING_LOGIN_INFOR = "key_xiaobing_login_infor";
    private final String KEY_YSHOUFA_LOGIN_PASSWORD = "key_yshoufa_login_password";
    private final String KEY_YSHOUFA_LOGIN_RES = "key_yshoufa_login_res";
    private final String KEY_YSHOUFA_LOGIN_USERNAME = "key_yshoufa_login_username";
    private final String KEY_YSHOUFA_LOGIN_USERTYPE = "key_yshoufa_login_usertype";
    private final String KEY_YSHOUFA_LOGIN_VERSION = "key_yshoufa_login_version";
    private final String KEY_YUNDA_CHAOSHI_LOGIN_INFOR = "key_yunda_chaoshi_login_infor";
    private final String KEY_YUNDA_KDCS_LOGIN_INFOR = "key_yunda_kdcs_login_infor";
    private final String KEY_ZYZT_SITE_CODE = "KEY_ZYZT_SITE_CODE";
    private final String ZY_JD_SITE_CODE = "zy_jd_site_code";
    private final String ZY_MACHINE_CODE = "zy_machine_code";
    private final String ZY_OPE_SITE_ID = "zy_ope_site_id";
    private final String ZY_OPE_SITE_NAME = "zy_ope_site_name";
    private final String ZY_OPE_USER_ID = "zy_ope_user_id";
    private final String ZY_OPE_USER_NAME = "zy_ope_user_name";
    private final String KEY_MOXI_BRANCH_CODE = "key_moxi_branch";
    private final String KEY_MOXI_ACCOUNT = "key_moxi_account";
    private final String KEY_MOXI_PWD = "key_moxi_pwd";
    private final String KEY_DUODUOYIZHAN_ACCOUNT = "key_duoduoyizhan_account";
    private final String KEY_DUODUOYIZHAN_PWD = "key_duoduoyizhan_pwd";
    private final String KEY_KUAIBAO_ACCOUNT = "key_kuaibao_account";
    private final String KEY_KUAIBAO_PWD = "key_kuaibao_pwd";
    private final String KEY_STAGESMALLPOLE_ACCOUNT = "key_stagesmallpole_account";
    private final String KEY_STAGESMALLPOLE_PWD = "key_stagesmallpole_pwd";
    private final String KEY_STATIONHELPER_ACCOUNT = "key_stationhelper_account";
    private final String KEY_STATIONHELPER_PWD = "key_stationhelper_pwd";
    private final String KEY_LAIQU_ACCOUNT = "key_laiqu_account";
    private final String KEY_LAIQU_PWD = "key_laiqu_pwd";
    private final String KEY_KUAIDICAOSHI_ACCOUNT = "key_kuaidicaoshi_account";
    private final String KEY_KUAIDICAOSHI_PWD = "key_kuaidicaoshi_pwd";
    private final String KEY_COURIERSMALLPOLE_ACCOUNT = "key_couriersmallpole_account";
    private final String KEY_COURIERSMALLPOLE_PWD = "key_couriersmallpole_pwd";
    private final String KEY_JITU_ACCOUNT = "key_jitu_account";
    private final String KEY_JITU_PWD = "key_jitu_pwd";
    private final String KEY_YSHOUFA_ACCOUNT = "key_yshoufa_account";
    private final String KEY_YSHOUFA_PWD = "key_yshoufa_pwd";
    private final String KEY_YUNDAKDCS_ACCOUNT = "key_yundakdcs_account";
    private final String KEY_YUNDAKDCS_PWD = "key_yundakdcs_pwd";
    private final String KEY_PANDAHARVEST_ACCOUNT = "key_pandaharvest_account";
    private final String KEY_PANDAHARVEST_PWD = "key_pandaharvest_pwd";
    private final String KEY_MOXIGUANJIA_ACCOUNT = "key_moxiguanjia_account";
    private final String KEY_MOXIGUANJIA_PWD = "key_moxiguanjia_pwd";
    private final String KEY_ZYZT_ACCOUNT = "key_zyzt_account";
    private final String KEY_ZYZT_PWD = "key_zyzt_pwd";
    private final String KEY_ZHONGYOUSTATION_ACCOUNT = "key_zhongyoustation_account";
    private final String KEY_ZHONGYOUSTATION_PWD = "key_zhongyoustation_pwd";
    private final String KEY_MAMASTATION_ACCOUNT = "key_mamastation_account";
    private final String KEY_MAMASTATION_PWD = "key_mamastation_pwd";
    private final String KEY_BLUESHOP_ACCOUNT = "key_blueshop_account";
    private final String KEY_BLUESHOP_PWD = "key_blueshop_pwd";
    private final String KEY_FENGCHAOSERVICE_ACCOUNT = "key_fengchaoservice_account";
    private final String KEY_FENGCHAOSERVICE_PWD = "key_fengchaoservice_pwd";
    private final String KEY_FENSHISHENGHUO_ACCOUNT = "key_fenshishenghuo_account";
    private final String KEY_FENSHISHENGHUO_PWD = "key_fenshishenghuo_pwd";
    private final String KEY_GUOGUOYIZHAN_ACCOUNT = "key_guoguoyizhan_account";
    private final String KEY_GUOGUOYIZHAN_PWD = "key_guoguoyizhan_pwd";
    private final String KEY_JINLINBAOGAOPAIYI_ACCOUNT = "key_jinlinbaogaopaiyi_account";
    private final String KEY_JINLINBAOGAOPAIYI_PWD = "key_jinlinbaogaopaiyi_pwd";
    private final String KEY_JINLINBAOKUAIDIQUJIAN_ACCOUNT = "key_jinlinbaokuaidiqujian_account";
    private final String KEY_JINLINBAOKUAIDIQUJIAN_PWD = "key_jinlinbaokuaidiqujian_pwd";
    private final String KEY_JINLINBAOOCRJIEBO_ACCOUNT = "key_jinlinbaoocrjiebo_account";
    private final String KEY_JINLINBAOOCRJIEBO_PWD = "key_jinlinbaoocrjiebo_pwd";
    private final String KEY_JINLINBAOQIANSHOU_ACCOUNT = "key_jinlinbaoqianshou_account";
    private final String KEY_JINLINBAOQIANSHOU_PWD = "key_jinlinbaoqianshou_pwd";
    private final String KEY_SUDIYIGONGPEI_ACCOUNT = "key_sudiyigongpei_account";
    private final String KEY_SUDIYIGONGPEI_PWD = "key_sudiyigongpei_pwd";
    private final String KEY_JUSHUITAN_ACCOUNT = "key_jushuitan_account";
    private final String KEY_JUSHUITAN_PWD = "key_jushuitan_pwd";
    private final String KEY_XINGHUO_ACCOUNT = "key_xinghuo_account";
    private final String KEY_XINGHUO_PWD = "key_xinghuo_pwd";
    private final String KEY_XINIAOGAOPAIYI_ACCOUNT = "key_xiniaogaopaiyi_account";
    private final String KEY_XINIAOGAOPAIYI_PWD = "key_xiniaogaopaiyi_pwd";
    private final String KEY_XIAOBINGSTATION_ACCOUNT = "key_xiaobingstation_account";
    private final String KEY_XIAOBINGSTATION_PWD = "key_xiaobingstation_pwd";
    private final String KEY_NETMANAGER_ACCOUNT = "key_netmanager_account";
    private final String KEY_NETMANAGER_PWD = "key_netmanager_pwd";
    private final String KEY_MIAOZHAN_ACCOUNT = "key_miaozhan_account";
    private final String KEY_MIAOZHAN_PWD = "key_miaozhan_pwd";
    private final String KEY_ZHONGYOUCHENGZHONG_ACCOUNT = "key_zhongyouchengzhong_account";
    private final String KEY_ZHONGYOUCHENGZHONG_PWD = "key_zhongyouchengzhong_pwd";


    public RqFilePreference() {
    }

    public static RqFilePreference getInstance() {
        synchronized("common_file_synchronized"){}

        Throwable var10000;
        boolean var10001;
        label122: {
            try {
                if (mRqFilePreference == null) {
                    mRqFilePreference = new RqFilePreference();
                }
            } catch (Throwable var12) {
                var10000 = var12;
                var10001 = false;
                break label122;
            }

            label119:
            try {
                RqFilePreference var13 = mRqFilePreference;
                return var13;
            } catch (Throwable var11) {
                var10000 = var11;
                var10001 = false;
                break label119;
            }
        }

        while(true) {
            Throwable var0 = var10000;

            try {
                throw var0;
            } catch (Throwable var10) {
                var10000 = var10;
                var10001 = false;
                continue;
            }
        }
    }

    public boolean getAdvertiseTemplate() {
        return this.getBool("key_advertise_template", true);
    }

    public boolean getAutoLogin() {
        return this.getBool("key_auto_login", false);
    }

    public int getBarcodeExposureTime() {
        return this.getInt("key_barcode_exposure_time", 350);
    }

    public int getBarcodeFramerate() {
        return this.getInt("key_barcode_framerate", 10);
    }

    public int getBarcodeGain() {
        return this.getInt("key_barcode_gain", 12);
    }

    public float getBarcodeGamma() {
        return this.getFloat("key_barcode_gamma", 0.5F);
    }

    public int getBarcodeType() {
        return this.getInt("key_barcode_type", 1);
    }

    public String getBlueShopCookie() {
        return this.getString("key_blue_shop_cookie", "");
    }

    public BlueShopLoginRequestBean getBlueShopLoginInfor() {
        String var1 = this.getString("key_blue_shop_login_info", "");
        return StringUtil.isEmpty(var1) ? null : (BlueShopLoginRequestBean)JsonUtil.getClazzByGson(var1, BlueShopLoginRequestBean.class);
    }

    public BlueShopCookieBean getBlueShopLoginCache() {
        String var1 = this.getString("key_blue_shop_login_cache", "");
        return StringUtil.isEmpty(var1) ? null : (BlueShopCookieBean)JsonUtil.getClazzByGson(var1, BlueShopCookieBean.class);
    }

    public boolean getChangeCameraLocal() {
        return this.getBool("key_change_cemera_local", true);
    }

    public boolean getCloseWeightStatus() {
        return this.getBool("key_close_weight", false);
    }

    public CourierSmallPoleLogin getCourierSmallPoleLogin() {
        String var1 = this.getString("key_courier_small_pole", "");
        return StringUtil.isEmpty(var1) ? null : (CourierSmallPoleLogin)JsonUtil.getClazzByGson(var1, CourierSmallPoleLogin.class);
    }
    public String getCourierSmallPoleLoginforAccount() {
        return this.getString("key_courier_small_pole_account", "");
    }

    public String getCourierSmallPoleLoginforPassword() {
        return this.getString("key_courier_small_pole_password", "");
    }

    public int getCourierSmallPoleLoginIsZiAccount() {
        return this.getInt("key_couriersmallpole_zi", 0);
    }

    public String getDuoDuoPassword() {
        return this.getString("key_duoduo_password", "");
    }

    public String getDuoDuoToken() {
        return this.getString("key_duoduo_token", "");
    }

    public String getDuoDuoUsername() {
        return this.getString("key_duoduo_username", "");
    }

    public List<ExpressCompany> getExpressCompany() {
        String var1 = this.getString("key_company_name", "");
        return StringUtil.isEmpty(var1) ? null : (List)JsonUtil.getClazzByGson(var1, ExpressCompany.class);
    }

    public boolean getExternalStorage() {
        return this.getBool("key_external_storage", false);
    }

    public boolean getFaceCameraSwt() {
        return this.getBool("key_face_camera_swt", true);
    }

    public int getFaceExposureTime() {
        return this.getInt("key_face_exposure_time", 0);
    }

    public int getFaceFramerate() {
        return this.getInt("key_face_framerate", 30);
    }

    public int getFaceGain() {
        return this.getInt("key_face_gain", 12);
    }

    public float getFaceGamma() {
        return this.getFloat("key_face_gamma", 0.5F);
    }

    public boolean getFastScan() {
        return this.getBool("key_fast_scan", false);
    }

    public FcboxStationInforResponseBean getFcboxStationInfor() {
        String var1 = this.getString("key_fcbox_station_infor", "");
        return StringUtil.isEmpty(var1) ? null : (FcboxStationInforResponseBean)JsonUtil.getClazzByGson(var1, FcboxStationInforResponseBean.class);
    }

    public String getFirstUploadDataDate() {
        return this.getString("key_first_upload_data_date", "");
    }

    public String getFsshAppSID() {
        return this.getString("key_fssh_appsid", "");
    }

    public List<GoodsTypeBean> getGoogsType() {
        String var1 = this.getString("key_goods_type", "");
        return StringUtil.isEmpty(var1) ? null : (List)JsonUtil.getClazzByGson(var1, GoodsTypeBean.class);
    }

    public String getGuoGuoURL() {
        return this.getString("key_guoguo_url", "https://api.baoguovip.com/");
    }

    public GuoGuoInfo getGuoGuoYiZhan() {
        String var1 = this.getString("key_guoguoyizhan", "");
        return StringUtil.isEmpty(var1) ? null : (GuoGuoInfo)JsonUtil.getClazzByGson(var1, GuoGuoInfo.class);
    }

    public LoginResponseBean getGuoGuoYiZhanLoginRes() {
        String var1 = this.getString("key_guoguoyizhan_login_res", "");
        return StringUtil.isEmpty(var1) ? null : (LoginResponseBean)JsonUtil.getClazzByGson(var1, LoginResponseBean.class);
    }

    public HylLoginBean getHylInfor() {
        String var1 = this.getString("key_hyl_login_infor", "");
        return StringUtil.isEmpty(var1) ? null : (HylLoginBean)JsonUtil.getClazzByGson(var1, HylLoginBean.class);
    }

    public JiTuLoginBean getJiTuLoginInfor() {
        String var1 = this.getString("key_jitu", "");
        return StringUtil.isEmpty(var1) ? null : (JiTuLoginBean)JsonUtil.getClazzByGson(var1, JiTuLoginBean.class);
    }

    public JiTuResponse getJiTuLoginResponseInfor() {
        String var1 = this.getString("key_jitu_reponse", "");
        return StringUtil.isEmpty(var1) ? null : (JiTuResponse)JsonUtil.getClazzByGson(var1, JiTuResponse.class);
    }

    public JinLinBaoLoginResponseBean getJinLinBaoLoginRes() {
        String var1 = this.getString("key_jinlinbao_login_res", "");
        return StringUtil.isEmpty(var1) ? null : (JinLinBaoLoginResponseBean)JsonUtil.getClazzByGson(var1, JinLinBaoLoginResponseBean.class);
    }

    public String getJuShuiTanToken() {
        return this.getString("key_jushuitan_token", "");
    }

    public KDCSLoginResponseBean getKDCSLoginInfor() {
        String var1 = this.getString("key_kdcs_login_infor", "");
        return StringUtil.isEmpty(var1) ? null : (KDCSLoginResponseBean)JsonUtil.getClazzByGson(var1, KDCSLoginResponseBean.class);
    }

    public KDCSQueryStaffAndStoreResponseBean getKDCSQueryStaffAndStore() {
        String var1 = this.getString("key_query_staff_and_store", "");
        return StringUtil.isEmpty(var1) ? null : (KDCSQueryStaffAndStoreResponseBean)JsonUtil.getClazzByGson(var1, KDCSQueryStaffAndStoreResponseBean.class);
    }

    public PubkeyAndCookie getKeyAndCookie() {
        String var1 = this.getString("key_key_cookie", "");
        return StringUtil.isEmpty(var1) ? null : (PubkeyAndCookie)JsonUtil.getClazzByGson(var1, PubkeyAndCookie.class);
    }

    public KuaiBaoLoginResponseBean getKuaibaoLoginInfor() {
        String var1 = this.getString("key_kuaibao_login_infor", "");
        return StringUtil.isEmpty(var1) ? null : (KuaiBaoLoginResponseBean)JsonUtil.getClazzByGson(var1, KuaiBaoLoginResponseBean.class);
    }

    public String getKuaibaoSessionId() {
        return this.getString("key_kuaibao_session_id", "0b9d1b9fe9f9b21fe71cd433724c5ba0");
    }

    public KuaiBaoGetStationInforResponseBean getKuaibaoStationInfor() {
        String var1 = this.getString("key_kuaibao_station_infor", "");
        return StringUtil.isEmpty(var1) ? null : (KuaiBaoGetStationInforResponseBean)JsonUtil.getClazzByGson(var1, KuaiBaoGetStationInforResponseBean.class);
    }

    public LaiquLoginResponseBean getLaiquLoginInfor() {
        String var1 = this.getString("key_laiqu_login_infor", "");
        return StringUtil.isEmpty(var1) ? null : (LaiquLoginResponseBean)JsonUtil.getClazzByGson(var1, LaiquLoginResponseBean.class);
    }

    public LaiquSiteLoginResponseBean getLaiquSiteLoginInfor() {
        String var1 = this.getString("key_laiqu_site_login_infor", "");
        return StringUtil.isEmpty(var1) ? null : (LaiquSiteLoginResponseBean)JsonUtil.getClazzByGson(var1, LaiquSiteLoginResponseBean.class);
    }

    public LaiquStsRegistResponseBean getLaiquStsRegistBean() {
        String var1 = this.getString("key_laiqu_sts_regist", "");
        return StringUtil.isEmpty(var1) ? null : (LaiquStsRegistResponseBean)JsonUtil.getClazzByGson(var1, LaiquStsRegistResponseBean.class);
    }

    public boolean getLedSwt() {
        return this.getBool("key_led_swt", true);
    }

    public DeviceLoginBean getLoginBean() {
        String var1 = this.getString("key_login_information", "");
        return StringUtil.isEmpty(var1) ? null : (DeviceLoginBean)JsonUtil.getClazzByGson(var1, DeviceLoginBean.class);
    }

    public String getLoginDuoDuoPassword() {
        return this.getString("key_login_duoduo_password", "");
    }

    public String getLoginDuoDuoUsername() {
        return this.getString("key_login_duoduo_username", "");
    }

    public String getLoginFcboxPassword() {
        return this.getString("key_login_ycbox_password", "");
    }

    public String getLoginFcboxUsername() {
        return this.getString("key_login_ycbox_username", "");
    }

    public String getLoginKDCSPassword() {
        return this.getString("key_login_kdcs_password", "");
    }

    public String getLoginKDCSUsername() {
        return this.getString("key_login_kdcs_username", "");
    }

    public String getLoginKuaiBaoPassword() {
        return this.getString("key_login_kuaibao_password", "");
    }

    public String getLoginKuaiBaoUsername() {
        return this.getString("key_login_kuaibao_username", "");
    }

    public String getLoginLaiQuPassword() {
        return this.getString("key_login_laiqu_password", "");
    }

    public String getLoginLaiQuServiceStaionCode() {
        return this.getString("key_login_laiqu_service_staion_code", "");
    }

    public String getLoginLaiQuUsername() {
        return this.getString("key_login_laiqu_username", "");
    }

    public String getLoginMaMaPassword() {
        return this.getString("key_login_mama_password", "");
    }

    public String getLoginMaMaUsername() {
        return this.getString("key_login_mama_username", "");
    }

    public String getLoginPandaHarvestClientCode() {
        return this.getString("key_panda_harvest_client_code", "");
    }

    public String getLoginPassword() {
        return this.getString("key_login_password", "");
    }

    public String getLoginUsername() {
        return this.getString("key_login_username", "");
    }

    public String getLoginXBDExpressType() {
        return this.getString("key_login_xbd_express_type", "");
    }

    public String getLoginXiaoBinPassword() {
        return this.getString("key_login_xiaobin_password", "");
    }

    public String getLoginXiaoBinUsername() {
        return this.getString("key_login_xiaobin_username", "");
    }

    public String getLoginYunDaKDCSPassword() {
        return this.getString("key_login_yundakdcs_password", "");
    }

    public String getLoginYunDaKDCSUsername() {
        return this.getString("key_login_yundakdcs_username", "");
    }

    public MaMaLoginResponseBean getMaMaLoginInfor() {
        String var1 = this.getString("key_mama_login_infor", "");
        return StringUtil.isEmpty(var1) ? null : (MaMaLoginResponseBean)JsonUtil.getClazzByGson(var1, MaMaLoginResponseBean.class);
    }

    public MiaoZhanLoginBean getMiaoZhanLoginInfor() {
        String var1 = this.getString("key_miaozhan", "");
        return StringUtil.isEmpty(var1) ? null : (MiaoZhanLoginBean)JsonUtil.getClazzByGson(var1, MiaoZhanLoginBean.class);
    }

    public NetManagerLoginBean getNetManagerLoginInfor() {
        String var1 = this.getString("key_net_manager", "");
        return StringUtil.isEmpty(var1) ? null : (NetManagerLoginBean)JsonUtil.getClazzByGson(var1, NetManagerLoginBean.class);
    }

    public boolean getOpenLog() {
        return this.getBool("key_open_log", false);
    }

    public String getPandaHarvestInfoToken() {
        return this.getString("key_pandaharvest_login_token", "");
    }

    public PandaHarvestRequestBean getPandaHarvestInfor() {
        String var1 = this.getString("key_pandaharvest_login_infor", "");
        return StringUtil.isEmpty(var1) ? null : (PandaHarvestRequestBean)JsonUtil.getClazzByGson(var1, PandaHarvestRequestBean.class);
    }

    public PandaLoginBean getPandaHarvestInforTwo() {
        String var1 = this.getString("key_pandaharvest_login_two", "");
        return StringUtil.isEmpty(var1) ? null : (PandaLoginBean)JsonUtil.getClazzByGson(var1, PandaLoginBean.class);
    }

    public String getPandaHarvestUser() {
        return this.getString("key_panda_harvest_login_user", "");
    }

    public String getRefreshTokenDate() {
        return this.getString("key_refresh_token_date", "");
    }

    public String getSavePicturePath() {
        return this.getString("key_save_picture_path", "");
    }

    public int getScanTimeoutTime() {
        return this.getInt("key_scan_timeout_time", 15);
    }

    public String getSdyAppId() {
        return this.getString("SDY_APP_ID", "");
    }

    public String getSdyDeviceId() {
        return this.getString("SDY_DEVICEID", "");
    }

    public String getSdySecretKey() {
        return this.getString("SDY_SECRET_KEY", "");
    }

    public String getSdySource() {
        return this.getString("SDY_SOURCE", "");
    }

    public String getSdyTarget() {
        return this.getString("SDY_TARGET", "");
    }

    public boolean getShowMuchPackage() {
        return this.getBool("key_show_much_package", true);
    }

    public List<SiteInformation> getSiteListData() {
        String var1 = this.getString("key_site_list_data", "");
        return StringUtil.isEmpty(var1) ? null : (List)JsonUtil.getClazzByGson(var1, SiteInformation.class);
    }

    public StageLoginRequestBean getStagePoleLoginInfor() {
        String var1 = this.getString("key_stage_info", "");
        return StringUtil.isEmpty(var1) ? null : (StageLoginRequestBean)JsonUtil.getClazzByGson(var1, StageLoginRequestBean.class);
    }

    public StationHelperRequestLoginBean getStationHelperLoginInfor() {
        String var1 = this.getString("key_stationhelper_login_info", "");
        return StringUtil.isEmpty(var1) ? null : (StationHelperRequestLoginBean)JsonUtil.getClazzByGson(var1, StationHelperRequestLoginBean.class);
    }

    public String getStationInfor() {
        return this.getString("key_stationhelper_expressid_info", "");
    }

    public boolean getStationPictureUpload() {
        return this.getBool("key_station_upload_picture", false);
    }

    public GetStsResponseTokenBean getStsResponseToken() {
        String var1 = this.getString("key_sts_response_token", "");
        return StringUtil.isEmpty(var1) ? null : (GetStsResponseTokenBean)JsonUtil.getClazzByGson(var1, GetStsResponseTokenBean.class);
    }

    public String getTodayDate() {
        return this.getString("key_today_date", "");
    }

    public String getWeightDevTtyPort() {
        return this.getString("key_weight_dev_tty_port", "");
    }

    public XiNiaoGaoPaiLoginBean getXiNiaoGaoPaiLoginInfor() {
        String var1 = this.getString("key_xiniao_gaopaiyi", "");
        return StringUtil.isEmpty(var1) ? null : (XiNiaoGaoPaiLoginBean)JsonUtil.getClazzByGson(var1, XiNiaoGaoPaiLoginBean.class);
    }

    public XiaoBinLoginResponseBean getXiaoBingLoginInfor() {
        String var1 = this.getString("key_xiaobing_login_infor", "");
        return StringUtil.isEmpty(var1) ? null : (XiaoBinLoginResponseBean)JsonUtil.getClazzByGson(var1, XiaoBinLoginResponseBean.class);
    }

    public XingHuoLoginBean getXingHuoLoginBean() {
        String var1 = this.getString("key_xinghuo_login", "");
        return StringUtil.isEmpty(var1) ? null : (XingHuoLoginBean)JsonUtil.getClazzByGson(var1, XingHuoLoginBean.class);
    }

    public YshouFaLoginResponseBean getYshouFaLoginRes() {
        String var1 = this.getString("key_yshoufa_login_res", "");
        return StringUtil.isEmpty(var1) ? null : (YshouFaLoginResponseBean)JsonUtil.getClazzByGson(var1, YshouFaLoginResponseBean.class);
    }

    public String getYshouFaPassWord() {
        return this.getString("key_yshoufa_login_password", "");
    }

    public String getYshouFaUserName() {
        return this.getString("key_yshoufa_login_username", "");
    }

    public String getYshouFaUserType() {
        return this.getString("key_yshoufa_login_usertype", "");
    }

    public String getYshouFaVersion() {
        return this.getString("key_yshoufa_login_version", "1.1.0");
    }

    public YunDaChaoShiLoginResponseBean getYunDaChaoShiLoginInfor() {
        String var1 = this.getString("key_yunda_chaoshi_login_infor", "");
        return StringUtil.isEmpty(var1) ? null : (YunDaChaoShiLoginResponseBean)JsonUtil.getClazzByGson(var1, YunDaChaoShiLoginResponseBean.class);
    }

    public YunDaKDCSLoginResponseBean getYunDaKDCSLoginInfor() {
        String var1 = this.getString("key_yunda_kdcs_login_infor", "");
        return StringUtil.isEmpty(var1) ? null : (YunDaKDCSLoginResponseBean)JsonUtil.getClazzByGson(var1, YunDaKDCSLoginResponseBean.class);
    }

    public String getZyJdSiteCode() {
        return this.getString("zy_jd_site_code", "");
    }

    public String getZyMachineCode() {
        return this.getString("zy_machine_code", "");
    }

    public String getZyOpeSiteId() {
        return this.getString("zy_ope_site_id", "");
    }

    public String getZyOpeSitenName() {
        return this.getString("zy_ope_site_name", "");
    }

    public String getZyOpeUserId() {
        return this.getString("zy_ope_user_id", "");
    }

    public String getZyOpeUserName() {
        return this.getString("zy_ope_user_name", "");
    }

    public String getZyztSiteCode() {
        return this.getString("KEY_ZYZT_SITE_CODE", "");
    }

    public void setAdvertiseTemplate(boolean var1) {
        this.setBool("key_advertise_template", var1);
    }

    public void setAutoLogin(boolean var1) {
        this.setBool("key_auto_login", var1);
    }

    public void setBarcodeExposureTime(int var1) {
        this.setInt("key_barcode_exposure_time", var1);
    }

    public void setBarcodeFramerate(int var1) {
        this.setInt("key_barcode_framerate", var1);
    }

    public void setBarcodeGain(int var1) {
        this.setInt("key_barcode_gain", var1);
    }

    public void setBarcodeGamma(float var1) {
        this.setFloat("key_barcode_gamma", var1);
    }

    public void setBarcodeType(int var1) {
        this.setInt("key_barcode_type", var1);
    }

    public void setBlueShopCookie(String var1) {
        this.setString("key_blue_shop_cookie", var1);
    }

    public void setBlueShopLoginInfor(BlueShopLoginRequestBean var1) {
        this.setString("key_blue_shop_login_info", JsonUtil.getJsonStringByGson(var1));
    }

    public void setBlueShopLoginCache(BlueShopCookieBean var1) {
        this.setString("key_blue_shop_login_cache", JsonUtil.getJsonStringByGson(var1));
    }

    public void setChangeCameraLocal(boolean var1) {
        this.setBool("key_change_cemera_local", var1);
    }

    public void setCloseWeightStatus(boolean var1) {
        this.setBool("key_close_weight", var1);
    }

    public void setCourierSmallPoleLoginIsZiAccount(int var1) {
        this.setInt("key_couriersmallpole_zi", var1);
    }

    public void setCourierSmallPoleLoginfor(CourierSmallPoleLogin var1) {
        this.setString("key_courier_small_pole", JsonUtil.getJsonStringByGson(var1));
    }

    public void setCourierSmallPoleLoginforAccount(String account) {
        this.setString("key_courier_small_pole_account", account);
    }

    public void setCourierSmallPoleLoginforPassword(String password) {
        this.setString("key_courier_small_pole_password", password);
    }

    public void setDuoDuoPassword(String var1) {
        this.setString("key_duoduo_password", var1);
    }

    public void setDuoDuoToken(String var1) {
        this.setString("key_duoduo_token", var1);
    }

    public void setDuoDuoUsername(String var1) {
        this.setString("key_duoduo_username", var1);
    }

    public void setExpressCompany(List<ExpressCompany> var1) {
        this.setString("key_company_name", JsonUtil.getJsonStringByGson(var1));
    }

    public void setExternalStorage(boolean var1) {
        this.setBool("key_external_storage", var1);
    }

    public void setFaceCameraSwt(boolean var1) {
        this.setBool("key_face_camera_swt", var1);
    }

    public void setFaceExposureTime(int var1) {
        this.setInt("key_barcode_exposure_time", var1);
    }

    public void setFaceFramerate(int var1) {
        this.setInt("key_face_framerate", var1);
    }

    public void setFaceGain(int var1) {
        this.setInt("key_face_gain", var1);
    }

    public void setFaceGamma(float var1) {
        this.setFloat("key_face_gamma", var1);
    }

    public void setFastScan(boolean var1) {
        this.setBool("key_fast_scan", var1);
    }

    public void setFcboxStationInfor(FcboxStationInforResponseBean var1) {
        this.setString("key_fcbox_station_infor", JsonUtil.getJsonStringByGson(var1));
    }

    public void setFirstUploadDataDate(String var1) {
        this.setString("key_first_upload_data_date", var1);
    }

    public void setFsshAppSID(String var1) {
        this.setString("key_fssh_appsid", var1);
    }

    public void setGoodsType(List<GoodsTypeBean> var1) {
        this.setString("key_goods_type", JsonUtil.getJsonStringByGson(var1));
    }

    public void setGuoGuoURL(String var1) {
        this.setString("key_guoguo_url", var1);
    }

    public void setGuoGuoYiZhan(GuoGuoInfo var1) {
        this.setString("key_guoguoyizhan", JsonUtil.getJsonStringByGson(var1));
    }

    public void setGuoGuoYiZhanLoginRes(LoginResponseBean var1) {
        this.setString("key_guoguoyizhan_login_res", JsonUtil.getJsonStringByGson(var1));
    }

    public void setHylLogin(HylLoginBean var1) {
        this.setString("key_hyl_login_infor", JsonUtil.getJsonStringByGson(var1));
    }

    public void setJiTuLoginInfor(JiTuLoginBean var1) {
        this.setString("key_jitu", JsonUtil.getJsonStringByGson(var1));
    }

    public void setJiTuLoginResponseInfor(JiTuResponse var1) {
        this.setString("key_jitu_reponse", JsonUtil.getJsonStringByGson(var1));
    }

    public void setJinLinBaoLoginRes(JinLinBaoLoginResponseBean var1) {
        this.setString("key_jinlinbao_login_res", JsonUtil.getJsonStringByGson(var1));
    }

    public void setJuShuiTanToken(String var1) {
        this.setString("key_jushuitan_token", var1);
    }

    public void setKDCSLoginInfor(KDCSLoginResponseBean var1) {
        this.setString("key_kdcs_login_infor", JsonUtil.getJsonStringByGson(var1));
    }

    public void setKDCSQueryStaffAndStore(KDCSQueryStaffAndStoreResponseBean var1) {
        this.setString("key_query_staff_and_store", JsonUtil.getJsonStringByGson(var1));
    }

    public void setKeyAndCookie(PubkeyAndCookie var1) {
        this.setString("key_key_cookie", JsonUtil.getJsonStringByGson(var1));
    }

    public void setKuaibaoLoginInfor(KuaiBaoLoginResponseBean var1) {
        this.setString("key_kuaibao_login_infor", JsonUtil.getJsonStringByGson(var1));
    }

    public void setKuaibaoSessionId(String var1) {
        this.setString("key_kuaibao_session_id", var1);
    }

    public void setKuaibaoStationInfor(KuaiBaoGetStationInforResponseBean var1) {
        this.setString("key_kuaibao_station_infor", JsonUtil.getJsonStringByGson(var1));
    }

    public void setLaiquLoginInfor(LaiquLoginResponseBean var1) {
        this.setString("key_laiqu_login_infor", JsonUtil.getJsonStringByGson(var1));
    }

    public void setLaiquSiteLoginInfor(LaiquSiteLoginResponseBean var1) {
        this.setString("key_laiqu_site_login_infor", JsonUtil.getJsonStringByGson(var1));
    }

    public void setLaiquStsRegistBean(LaiquStsRegistResponseBean var1) {
        this.setString("key_laiqu_sts_regist", JsonUtil.getJsonStringByGson(var1));
    }

    public void setLedSwt(boolean var1) {
        this.setBool("key_led_swt", var1);
    }

    public void setLoginDuoDuoPassword(String var1) {
        this.setString("key_login_duoduo_password", var1);
    }

    public void setLoginDuoDuoUsername(String var1) {
        this.setString("key_login_duoduo_username", var1);
    }

    public void setLoginFcboxPassword(String var1) {
        this.setString("key_login_ycbox_password", var1);
    }

    public void setLoginFcboxUsername(String var1) {
        this.setString("key_login_ycbox_username", var1);
    }

    public void setLoginInformation(DeviceLoginBean var1) {
        this.setString("key_login_information", JsonUtil.getJsonStringByGson(var1));
    }

    public void setLoginKDCSPassword(String var1) {
        this.setString("key_login_kdcs_password", var1);
    }

    public void setLoginKDCSUsername(String var1) {
        this.setString("key_login_kdcs_username", var1);
    }

    public void setLoginKuaiBaoPassword(String var1) {
        this.setString("key_login_kuaibao_password", var1);
    }

    public void setLoginKuaiBaoUsername(String var1) {
        this.setString("key_login_kuaibao_username", var1);
    }

    public void setLoginLaiQuPassword(String var1) {
        this.setString("key_login_laiqu_password", var1);
    }

    public void setLoginLaiQuServiceStaionCode(String var1) {
        this.setString("key_login_laiqu_service_staion_code", var1);
    }

    public void setLoginLaiQuUsername(String var1) {
        this.setString("key_login_laiqu_username", var1);
    }

    public void setLoginMaMaPassword(String var1) {
        this.setString("key_login_mama_password", var1);
    }

    public void setLoginMaMaUsername(String var1) {
        this.setString("key_login_mama_username", var1);
    }

    public void setLoginPandaHarvestClientCode(String var1) {
        this.setString("key_panda_harvest_client_code", var1);
    }

    public void setLoginPassword(String var1) {
        this.setString("key_login_password", var1);
    }

    public void setLoginUsername(String var1) {
        this.setString("key_login_username", var1);
    }

    public void setLoginXBDExpressType(String var1) {
        this.setString("key_login_xbd_express_type", var1);
    }

    public void setLoginXiaoBinPassword(String var1) {
        this.setString("key_login_xiaobin_password", var1);
    }

    public void setLoginXiaoBinUsername(String var1) {
        this.setString("key_login_xiaobin_username", var1);
    }

    public void setLoginYunDaKDCSPassword(String var1) {
        this.setString("key_login_yundakdcs_password", var1);
    }

    public void setLoginYunDaKDCSUsername(String var1) {
        this.setString("key_login_yundakdcs_username", var1);
    }

    public void setMaMaLoginInfor(MaMaLoginResponseBean var1) {
        this.setString("key_mama_login_infor", JsonUtil.getJsonStringByGson(var1));
    }

    public void setMiaoZhanLoginInfor(MiaoZhanLoginBean var1) {
        this.setString("key_miaozhan", JsonUtil.getJsonStringByGson(var1));
    }

    public void setNetManagerLoginInfor(NetManagerLoginBean var1) {
        this.setString("key_net_manager", JsonUtil.getJsonStringByGson(var1));
    }

    public void setOpenLog(boolean var1) {
        this.setBool("key_open_log", var1);
    }

    public void setPandaHarvestInfoToken(String var1) {
        this.setString("key_pandaharvest_login_token", var1);
    }

    public void setPandaHarvestInfor(PandaHarvestRequestBean var1) {
        this.setString("key_pandaharvest_login_infor", JsonUtil.getJsonStringByGson(var1));
    }

    public void setPandaHarvestInforTwo(PandaLoginBean var1) {
        this.setString("key_pandaharvest_login_two", JsonUtil.getJsonStringByGson(var1));
    }

    public void setPandaHarvestUser(String var1) {
        this.setString("key_panda_harvest_login_user", var1);
    }

    public void setRefreshTokenDate(String var1) {
        this.setString("key_refresh_token_date", var1);
    }

    public void setSavePicturePath(String var1) {
        this.setString("key_save_picture_path", var1);
    }

    public void setScanTimeoutTime(int var1) {
        this.setInt("key_scan_timeout_time", var1);
    }

    public void setSdyAppId(String var1) {
        this.setString("SDY_APP_ID", var1);
    }

    public void setSdyDeviceId(String var1) {
        this.setString("SDY_DEVICEID", var1);
    }

    public void setSdySecretKey(String var1) {
        this.setString("SDY_SECRET_KEY", var1);
    }

    public void setSdySource(String var1) {
        this.setString("SDY_SOURCE", var1);
    }

    public void setSdyTarget(String var1) {
        this.setString("SDY_TARGET", var1);
    }

    public void setShowMuchPackage(boolean var1) {
        this.setBool("key_show_much_package", var1);
    }

    public void setSiteListData(List<SiteInformation> var1) {
        this.setString("key_site_list_data", JsonUtil.getJsonStringByGson(var1));
    }

    public void setStageSmallPoleLoginInfor(StageLoginRequestBean var1) {
        this.setString("key_stage_info", JsonUtil.getJsonStringByGson(var1));
    }

    public void setStationHelperLoginfor(StationHelperRequestLoginBean var1) {
        this.setString("key_stationhelper_login_info", JsonUtil.getJsonStringByGson(var1));
    }

    public void setStationInfor(String var1) {
        this.setString("key_stationhelper_expressid_info", var1);
    }

    public void setStationPictureUpload(boolean var1) {
        this.setBool("key_station_upload_picture", var1);
    }

    public void setStsResponseToken(GetStsResponseTokenBean var1) {
        this.setString("key_sts_response_token", JsonUtil.getJsonStringByGson(var1));
    }

    public void setTodayDate(String var1) {
        this.setString("key_today_date", var1);
    }

    public void setWeightDevTtyPort(String var1) {
        this.setString("key_weight_dev_tty_port", var1);
    }

    public void setXiNiaoGaoPaiLoginInfor(XiNiaoGaoPaiLoginBean var1) {
        this.setString("key_xiniao_gaopaiyi", JsonUtil.getJsonStringByGson(var1));
    }

    public void setXiaoBingLoginInfor(XiaoBinLoginResponseBean var1) {
        this.setString("key_xiaobing_login_infor", JsonUtil.getJsonStringByGson(var1));
    }

    public void setXingHuoLogininfo(XingHuoLoginBean var1) {
        this.setString("key_xinghuo_login", JsonUtil.getJsonStringByGson(var1));
    }

    public void setYshouFaLoginRes(YshouFaLoginResponseBean var1) {
        this.setString("key_yshoufa_login_res", JsonUtil.getJsonStringByGson(var1));
    }

    public void setYshouFaPassWord(String var1) {
        this.setString("key_yshoufa_login_password", var1);
    }

    public void setYshouFaUserName(String var1) {
        this.setString("key_yshoufa_login_username", var1);
    }

    public void setYshouFaUserType(String var1) {
        this.setString("key_yshoufa_login_usertype", var1);
    }

    public void setYshouFaUserVersiong(String var1) {
        this.setString("key_yshoufa_login_version", var1);
    }

    public void setYunDaChaoShiLoginInfor(YunDaChaoShiLoginResponseBean var1) {
        this.setString("key_yunda_chaoshi_login_infor", JsonUtil.getJsonStringByGson(var1));
    }

    public void setYunDaKDCSLoginInfor(YunDaKDCSLoginResponseBean var1) {
        this.setString("key_yunda_kdcs_login_infor", JsonUtil.getJsonStringByGson(var1));
    }

    public void setZyJdSiteCode(String var1) {
        this.setString("zy_jd_site_code", var1);
    }

    public void setZyMachineCode(String var1) {
        this.setString("zy_machine_code", var1);
    }

    public void setZyOpeSiteId(String var1) {
        this.setString("zy_ope_site_id", var1);
    }

    public void setZyOpeSitenName(String var1) {
        this.setString("zy_ope_site_name", var1);
    }

    public void setZyOpeUserId(String var1) {
        this.setString("zy_ope_user_id", var1);
    }

    public void setZyOpeUserName(String var1) {
        this.setString("zy_ope_user_name", var1);
    }

    public void setZyztSiteCode(String var1) {
        this.setString("KEY_ZYZT_SITE_CODE", var1);
    }

    public void setMoxiAccount(String account){
        setString(KEY_MOXI_ACCOUNT,account);
    }

    public void setMoxiPwd(String pwd){
        setString(KEY_MOXI_PWD,pwd);
    }
    public void setMoxiBranch(String pwd){
        setString(KEY_MOXI_BRANCH_CODE,pwd);
    }

    public String getMoxiBranch(){
        return this.getString(KEY_MOXI_BRANCH_CODE,"");
    }
    public String getMoxiAccount(){
        return this.getString(KEY_MOXI_ACCOUNT,"");
    }

    public String getMoxiPwd(){
        return this.getString(KEY_MOXI_PWD,"");
    }

    public void setDUODUOYIZHANAccount(String account){ setString(KEY_DUODUOYIZHAN_ACCOUNT,account);}
    public void setDUODUOYIZHANPwd(String pwd){
        setString(KEY_DUODUOYIZHAN_PWD,pwd);
    }
    public String getDUODUOYIZHANAccount(){
        return this.getString(KEY_DUODUOYIZHAN_ACCOUNT,"");
    }
    public String getDUODUOYIZHANPwd(){
        return this.getString(KEY_DUODUOYIZHAN_PWD,"");
    }

    public void setKUAIBAOAccount(String account){ setString(KEY_KUAIBAO_ACCOUNT,account);}
    public void setKUAIBAOPwd(String pwd){
        setString(KEY_KUAIBAO_PWD,pwd);
    }
    public String getKUAIBAOAccount(){
        return this.getString(KEY_KUAIBAO_ACCOUNT,"");
    }
    public String getKUAIBAOPwd(){
        return this.getString(KEY_KUAIBAO_PWD,"");
    }

    public void setSTAGESMALLPOLEAccount(String account){ setString(KEY_STAGESMALLPOLE_ACCOUNT,account);}
    public void setSTAGESMALLPOLEPwd(String pwd){
        setString(KEY_STAGESMALLPOLE_PWD,pwd);
    }
    public String getSTAGESMALLPOLEAccount(){
        return this.getString(KEY_STAGESMALLPOLE_ACCOUNT,"");
    }
    public String getSTAGESMALLPOLEPwd(){
        return this.getString(KEY_STAGESMALLPOLE_PWD,"");
    }

    public void setSTATIONHELPERAccount(String account){ setString(KEY_STATIONHELPER_ACCOUNT,account);}
    public void setSTATIONHELPERPwd(String pwd){
        setString(KEY_STATIONHELPER_PWD,pwd);
    }
    public String getSTATIONHELPERAccount(){
        return this.getString(KEY_STATIONHELPER_ACCOUNT,"");
    }
    public String getSTATIONHELPERPwd(){
        return this.getString(KEY_STATIONHELPER_PWD,"");
    }

    public void setLAIQUAccount(String account){ setString(KEY_LAIQU_ACCOUNT,account);}
    public void setLAIQUPwd(String pwd){
        setString(KEY_LAIQU_PWD,pwd);
    }
    public String getLAIQUAccount(){
        return this.getString(KEY_LAIQU_ACCOUNT,"");
    }
    public String getLAIQUPwd(){
        return this.getString(KEY_LAIQU_PWD,"");
    }

    public void setKUAIDICAOSHIAccount(String account){ setString(KEY_KUAIDICAOSHI_ACCOUNT,account);}
    public void setKUAIDICAOSHIPwd(String pwd){
        setString(KEY_KUAIDICAOSHI_PWD,pwd);
    }
    public String getKUAIDICAOSHIAccount(){
        return this.getString(KEY_KUAIDICAOSHI_ACCOUNT,"");
    }
    public String getKUAIDICAOSHIPwd(){
        return this.getString(KEY_KUAIDICAOSHI_PWD,"");
    }

    public void setCOURIERSMALLPOLEAccount(String account){ setString(KEY_COURIERSMALLPOLE_ACCOUNT,account);}
    public void setCOURIERSMALLPOLEPwd(String pwd){
        setString(KEY_COURIERSMALLPOLE_PWD,pwd);
    }
    public String getCOURIERSMALLPOLEAccount(){
        return this.getString(KEY_COURIERSMALLPOLE_ACCOUNT,"");
    }
    public String getCOURIERSMALLPOLEPwd(){
        return this.getString(KEY_COURIERSMALLPOLE_PWD,"");
    }

    public void setJITUAccount(String account){ setString(KEY_JITU_ACCOUNT,account);}
    public void setJITUPwd(String pwd){
        setString(KEY_JITU_PWD,pwd);
    }
    public String getJITUAccount(){
        return this.getString(KEY_JITU_ACCOUNT,"");
    }
    public String getJITUPwd(){
        return this.getString(KEY_JITU_PWD,"");
    }

    public void setYSHOUFAAccount(String account){ setString(KEY_YSHOUFA_ACCOUNT,account);}
    public void setYSHOUFAPwd(String pwd){
        setString(KEY_YSHOUFA_PWD,pwd);
    }
    public String getYSHOUFAAccount(){
        return this.getString(KEY_YSHOUFA_ACCOUNT,"");
    }
    public String getYSHOUFAPwd(){
        return this.getString(KEY_YSHOUFA_PWD,"");
    }

    public void setYUNDAKDCSAccount(String account){ setString(KEY_YUNDAKDCS_ACCOUNT,account);}
    public void setYUNDAKDCSPwd(String pwd){
        setString(KEY_YUNDAKDCS_PWD,pwd);
    }
    public String getYUNDAKDCSAccount(){
        return this.getString(KEY_YUNDAKDCS_ACCOUNT,"");
    }
    public String getYUNDAKDCSPwd(){
        return this.getString(KEY_YUNDAKDCS_PWD,"");
    }

    public void setPANDAHARVESTAccount(String account){ setString(KEY_PANDAHARVEST_ACCOUNT,account);}
    public void setPANDAHARVESTPwd(String pwd){
        setString(KEY_PANDAHARVEST_PWD,pwd);
    }
    public String getPANDAHARVESTAccount(){
        return this.getString(KEY_PANDAHARVEST_ACCOUNT,"");
    }
    public String getPANDAHARVESTPwd(){
        return this.getString(KEY_PANDAHARVEST_PWD,"");
    }

    public void setMOXIGUANJIAAccount(String account){ setString(KEY_MOXIGUANJIA_ACCOUNT,account);}
    public void setMOXIGUANJIAPwd(String pwd){
        setString(KEY_MOXIGUANJIA_PWD,pwd);
    }
    public String getMOXIGUANJIAAccount(){
        return this.getString(KEY_MOXIGUANJIA_ACCOUNT,"");
    }
    public String getMOXIGUANJIAPwd(){
        return this.getString(KEY_MOXIGUANJIA_PWD,"");
    }

    public void setZYZTAccount(String account){ setString(KEY_ZYZT_ACCOUNT,account);}
    public void setZYZTPwd(String pwd){
        setString(KEY_ZYZT_PWD,pwd);
    }
    public String getZYZTAccount(){
        return this.getString(KEY_ZYZT_ACCOUNT,"");
    }
    public String getZYZTPwd(){
        return this.getString(KEY_ZYZT_PWD,"");
    }

    public void setZHONGYOUSTATIONAccount(String account){ setString(KEY_ZHONGYOUSTATION_ACCOUNT,account);}
    public void setZHONGYOUSTATIONPwd(String pwd){
        setString(KEY_ZHONGYOUSTATION_PWD,pwd);
    }
    public String getZHONGYOUSTATIONAccount(){
        return this.getString(KEY_ZHONGYOUSTATION_ACCOUNT,"");
    }
    public String getZHONGYOUSTATIONPwd(){
        return this.getString(KEY_ZHONGYOUSTATION_PWD,"");
    }

    public void setMAMASTATIONAccount(String account){ setString(KEY_MAMASTATION_ACCOUNT,account);}
    public void setMAMASTATIONPwd(String pwd){
        setString(KEY_MAMASTATION_PWD,pwd);
    }
    public String getMAMASTATIONAccount(){
        return this.getString(KEY_MAMASTATION_ACCOUNT,"");
    }
    public String getMAMASTATIONPwd(){
        return this.getString(KEY_MAMASTATION_PWD,"");
    }

    public void setBLUESHOPAccount(String account){ setString(KEY_BLUESHOP_ACCOUNT,account);}
    public void setBLUESHOPPwd(String pwd){
        setString(KEY_BLUESHOP_PWD,pwd);
    }
    public String getBLUESHOPAccount(){
        return this.getString(KEY_BLUESHOP_ACCOUNT,"");
    }
    public String getBLUESHOPPwd(){
        return this.getString(KEY_BLUESHOP_PWD,"");
    }

    public void setFENGCHAOSERVICEAccount(String account){ setString(KEY_FENGCHAOSERVICE_ACCOUNT,account);}
    public void setFENGCHAOSERVICEPwd(String pwd){
        setString(KEY_FENGCHAOSERVICE_PWD,pwd);
    }
    public String getFENGCHAOSERVICEAccount(){
        return this.getString(KEY_FENGCHAOSERVICE_ACCOUNT,"");
    }
    public String getFENGCHAOSERVICEPwd(){
        return this.getString(KEY_FENGCHAOSERVICE_PWD,"");
    }

    public void setFENSHISHENGHUOAccount(String account){ setString(KEY_FENSHISHENGHUO_ACCOUNT,account);}
    public void setFENSHISHENGHUOPwd(String pwd){
        setString(KEY_FENSHISHENGHUO_PWD,pwd);
    }
    public String getFENSHISHENGHUOAccount(){
        return this.getString(KEY_FENSHISHENGHUO_ACCOUNT,"");
    }
    public String getFENSHISHENGHUOPwd(){
        return this.getString(KEY_FENSHISHENGHUO_PWD,"");
    }

    public void setGUOGUOYIZHANAccount(String account){ setString(KEY_GUOGUOYIZHAN_ACCOUNT,account);}
    public void setGUOGUOYIZHANPwd(String pwd){
        setString(KEY_GUOGUOYIZHAN_PWD,pwd);
    }
    public String getGUOGUOYIZHANAccount(){
        return this.getString(KEY_GUOGUOYIZHAN_ACCOUNT,"");
    }
    public String getGUOGUOYIZHANPwd(){
        return this.getString(KEY_GUOGUOYIZHAN_PWD,"");
    }

    public void setJINLINBAOGAOPAIYIAccount(String account){ setString(KEY_JINLINBAOGAOPAIYI_ACCOUNT,account);}
    public void setJINLINBAOGAOPAIYIPwd(String pwd){
        setString(KEY_JINLINBAOGAOPAIYI_PWD,pwd);
    }
    public String getJINLINBAOGAOPAIYIAccount(){
        return this.getString(KEY_JINLINBAOGAOPAIYI_ACCOUNT,"");
    }
    public String getJINLINBAOGAOPAIYIPwd(){
        return this.getString(KEY_JINLINBAOGAOPAIYI_PWD,"");
    }

    public void setJINLINBAOKUAIDIQUJIANAccount(String account){ setString(KEY_JINLINBAOKUAIDIQUJIAN_ACCOUNT,account);}
    public void setJINLINBAOKUAIDIQUJIANPwd(String pwd){
        setString(KEY_JINLINBAOKUAIDIQUJIAN_PWD,pwd);
    }
    public String getJINLINBAOKUAIDIQUJIANAccount(){
        return this.getString(KEY_JINLINBAOKUAIDIQUJIAN_ACCOUNT,"");
    }
    public String getJINLINBAOKUAIDIQUJIANPwd(){
        return this.getString(KEY_JINLINBAOKUAIDIQUJIAN_PWD,"");
    }

    public void setJINLINBAOOCRJIEBOAccount(String account){ setString(KEY_JINLINBAOOCRJIEBO_ACCOUNT,account);}
    public void setJINLINBAOOCRJIEBOPwd(String pwd){
        setString(KEY_JINLINBAOOCRJIEBO_PWD,pwd);
    }
    public String getJINLINBAOOCRJIEBOAccount(){
        return this.getString(KEY_JINLINBAOOCRJIEBO_ACCOUNT,"");
    }
    public String getJINLINBAOOCRJIEBOPwd(){
        return this.getString(KEY_JINLINBAOOCRJIEBO_PWD,"");
    }

    public void setJINLINBAOQIANSHOUAccount(String account){ setString(KEY_JINLINBAOQIANSHOU_ACCOUNT,account);}
    public void setJINLINBAOQIANSHOUPwd(String pwd){
        setString(KEY_JINLINBAOQIANSHOU_PWD,pwd);
    }
    public String getJINLINBAOQIANSHOUAccount(){
        return this.getString(KEY_JINLINBAOQIANSHOU_ACCOUNT,"");
    }
    public String getJINLINBAOQIANSHOUPwd(){
        return this.getString(KEY_JINLINBAOQIANSHOU_PWD,"");
    }

    public void setSUDIYIGONGPEIAccount(String account){ setString(KEY_SUDIYIGONGPEI_ACCOUNT,account);}
    public void setSUDIYIGONGPEIPwd(String pwd){
        setString(KEY_SUDIYIGONGPEI_PWD,pwd);
    }
    public String getSUDIYIGONGPEIAccount(){
        return this.getString(KEY_SUDIYIGONGPEI_ACCOUNT,"");
    }
    public String getSUDIYIGONGPEIPwd(){
        return this.getString(KEY_SUDIYIGONGPEI_PWD,"");
    }

    public void setJUSHUITANAccount(String account){ setString(KEY_JUSHUITAN_ACCOUNT,account);}
    public void setJUSHUITANPwd(String pwd){
        setString(KEY_JUSHUITAN_PWD,pwd);
    }
    public String getJUSHUITANAccount(){
        return this.getString(KEY_JUSHUITAN_ACCOUNT,"");
    }
    public String getJUSHUITANPwd(){
        return this.getString(KEY_JUSHUITAN_PWD,"");
    }

    public void setXINGHUOAccount(String account){ setString(KEY_XINGHUO_ACCOUNT,account);}
    public void setXINGHUOPwd(String pwd){
        setString(KEY_XINGHUO_PWD,pwd);
    }
    public String getXINGHUOAccount(){
        return this.getString(KEY_XINGHUO_ACCOUNT,"");
    }
    public String getXINGHUOPwd(){
        return this.getString(KEY_XINGHUO_PWD,"");
    }

    public void setXINIAOGAOPAIYIAccount(String account){ setString(KEY_XINIAOGAOPAIYI_ACCOUNT,account);}
    public void setXINIAOGAOPAIYIPwd(String pwd){
        setString(KEY_XINIAOGAOPAIYI_PWD,pwd);
    }
    public String getXINIAOGAOPAIYIAccount(){
        return this.getString(KEY_XINIAOGAOPAIYI_ACCOUNT,"");
    }
    public String getXINIAOGAOPAIYIPwd(){
        return this.getString(KEY_XINIAOGAOPAIYI_PWD,"");
    }

    public void setXIAOBINGSTATIONAccount(String account){ setString(KEY_XIAOBINGSTATION_ACCOUNT,account);}
    public void setXIAOBINGSTATIONPwd(String pwd){
        setString(KEY_XIAOBINGSTATION_PWD,pwd);
    }
    public String getXIAOBINGSTATIONAccount(){
        return this.getString(KEY_XIAOBINGSTATION_ACCOUNT,"");
    }
    public String getXIAOBINGSTATIONPwd(){
        return this.getString(KEY_XIAOBINGSTATION_PWD,"");
    }

    public void setNETMANAGERAccount(String account){ setString(KEY_NETMANAGER_ACCOUNT,account);}
    public void setNETMANAGERPwd(String pwd){
        setString(KEY_NETMANAGER_PWD,pwd);
    }
    public String getNETMANAGERAccount(){
        return this.getString(KEY_NETMANAGER_ACCOUNT,"");
    }
    public String getNETMANAGERPwd(){
        return this.getString(KEY_NETMANAGER_PWD,"");
    }

    public void setMIAOZHANAccount(String account){ setString(KEY_MIAOZHAN_ACCOUNT,account);}
    public void setMIAOZHANPwd(String pwd){
        setString(KEY_MIAOZHAN_PWD,pwd);
    }
    public String getMIAOZHANAccount(){
        return this.getString(KEY_MIAOZHAN_ACCOUNT,"");
    }
    public String getMIAOZHANPwd(){
        return this.getString(KEY_MIAOZHAN_PWD,"");
    }

    public void setZHONGYOUCHENGZHONGAccount(String account){ setString(KEY_ZHONGYOUCHENGZHONG_ACCOUNT,account);}
    public void setZHONGYOUCHENGZHONGPwd(String pwd){
        setString(KEY_ZHONGYOUCHENGZHONG_PWD,pwd);
    }
    public String getZHONGYOUCHENGZHONGAccount(){
        return this.getString(KEY_ZHONGYOUCHENGZHONG_ACCOUNT,"");
    }
    public String getZHONGYOUCHENGZHONGPwd(){
        return this.getString(KEY_ZHONGYOUCHENGZHONG_PWD,"");
    }
}
