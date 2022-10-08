package com.rq.net;

//import com.kuaidihelp.posthouse.broadcast.*;
//import com.yunpan.cobabarcode.*;
//import com.stub.*;
//import com.kuaidihelp.posthouse.net.*;
//import com.kuaidihelp.posthouse.activity.*;
//import com.blankj.utilcode.util.*;
import java.io.*;
//import com.kuaidihelp.posthouse.view.*;
import android.content.*;
import java.util.*;
//import com.kuaidihelp.posthouse.emue.*;
//import com.kuaidihelp.posthouse.bean.*;
//import com.yunpan.common.manager.*;
//import com.kuaidihelp.posthouse.manager.*;
import android.os.Process;
import android.view.*;
import android.provider.*;
import android.app.*;
import android.util.*;
//import com.yunpan.hikcodereader.manager.*;
//import com.licheedev.modbus4android.*;
//import com.yunpan.common.utils.*;
//import com.kuaidihelp.posthouse.util.*;
//import com.yunpan.hikcodereader.interfaces.*;
import android.net.*;
import android.os.*;

import androidx.annotation.RequiresApi;

import com.rq.net.bean.DeviceCloudResponseBean;
import com.rq.net.bean.DeviceMixTypeBean;
import com.rq.net.bean.GetStsResponseTokenBean;
import com.rq.net.manager.OkhttpManager;
import com.rq.net.setting.CommonFilePreference;
import com.rq.net.setting.FactoryConfigurationFilePreference;
import com.rq.net.setting.RqFilePreference;
import com.rq.net.util.DateUtil;
import com.rq.net.util.ExpressStationEnum;
import com.rq.net.util.ImageSaveUtil;
import com.rq.net.util.MD5Util;
import com.rq.net.util.SystemUtil;
//import com.yunpan.cobabarcode.interfaces.*;

public class RqService extends Service
{
    public static final String ONLINE_ACTION = "key_online_action";
    private static final String TAG = "CobaAiService";
    public static RqService cobaAiService;
    public static boolean isCloudSpaceExpiration;
    public static String savePath;
    public static String savePathDay;
    private int barcodeType;
//    private FloatView bottomTitleLayout;
//    private WindowManager$LayoutParams bottomTitleParam;
    private WindowManager bottomTitleWindowManager;
//    private CobaDeviceBroadcast cobaDeviceBroadcast;
//    private FloatView customerService;
    private int exposure;
    private int framerate;
    private int gain;
    private float gamma;
    private boolean isAddBottomTitleWindowManagerView;
    private boolean isAddCustomerServiceWindowManagerView;
    private boolean isAddWindowManagerView;
//    private CobaBarcodeCamera mCobaBarcodeCamera;
//    private IBarcode mIBarcode;
//    private FloatView mLayout;
//    private UploadDataThreadManager mUploadDataThreadManager;
    private WindowManager mUstomerServiceWindowManager;
//    private IWeightCallback mWeightCallback;
    private WindowManager mWindowManager;
    private Timer ossStsTokenTimer;
//    private WindowManager$LayoutParams param;
//    private IBarcode selfIBarcode;
//    private IWeightCallback selfIWeightCallback;
//    private CustomerServiceDialog serviceDialog;
    private TimerTask stsTimerTask;
//    private WindowManager$LayoutParams ustomerServiceParam;
    
    static {
//        StubApp.interface11(12525);
        final StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getPath());
        sb.append("/cobaAi/pic/");
        RqService.savePath = sb.toString();
    }
    
    public RqService() {
//        this.serviceDialog = null;
        this.isAddWindowManagerView = false;
        this.isAddBottomTitleWindowManagerView = false;
        this.isAddCustomerServiceWindowManagerView = false;
        this.exposure = -1;
        this.gain = 12;
        this.framerate = 15;
        this.barcodeType = 1;
        this.gamma = 0.5f;
        this.stsTimerTask = new TimerTask() {
            @Override
            public void run() {
                OkhttpManager.getStsToken((OkhttpManager.OnOkhttpCallback<GetStsResponseTokenBean>)new OkhttpManager.OnOkhttpCallback<GetStsResponseTokenBean>() {
                    public void onSuccess(final GetStsResponseTokenBean getStsResponseTokenBean) {
//                        if (RqService.this.mUploadDataThreadManager == null) {
//                            RqService.this.mUploadDataThreadManager = new UploadDataThreadManager(StubApp.getOrigApplicationContext(RqService.this.getApplicationContext()));
//                            RqService.this.mUploadDataThreadManager.start();
//                            return;
//                        }
//                        RqService.this.mUploadDataThreadManager.setResetStsToken(true);
                    }
                });
                OkhttpManager.trialDelete((OkhttpManager.OnOkhttpCallback<String>)new OkhttpManager.OnOkhttpCallback<String>() {
                    public void onSuccess(final String s) {
                    }
                });
                RqService.this.getCloudSizeAndDelete(false);
            }
        };
//        this.mIBarcode = new IBarcode() {
//            @Override
//            public void getBarcodeList(final List<String> list, final byte[] array) {
//                RqService.this.postSelfAidlBarcodeList(list, array);
//            }
//
//            @Override
//            public void getPreviewFrame(final byte[] array) {
//                if (RqService.this.selfIBarcode != null) {
//                    RqService.this.selfIBarcode.getPreviewFrame(array);
//                }
//            }
//        };
//        this.mWeightCallback = (IWeightCallback)new IWeightCallback() {
//            public void onFailure(final String s) {
//                if (RqService.this.selfIWeightCallback != null) {
//                    RqService.this.selfIWeightCallback.onFailure(s);
//                }
//            }
//
//            public void onWeight(final boolean b, final String s) {
//                if (RqService.this.mLayout != null) {
//                    final FloatView access$600 = RqService.this.mLayout;
//                    final StringBuilder sb = new StringBuilder();
//                    sb.append(s);
//                    sb.append(" kg");
//                    access$600.setText((CharSequence)sb.toString());
//                }
//                if (CobaAidlService.icobaAidlCallback != null) {
//                    try {
//                        CobaAidlService.icobaAidlCallback.getWeight(b, s);
//                    }
//                    catch (RemoteException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//                if (RqService.this.selfIWeightCallback != null) {
//                    RqService.this.selfIWeightCallback.onWeight(b, s);
//                }
//            }
//        };
    }
    
    private void createBottomTitleFloatView() {
//        (this.bottomTitleLayout = new FloatView(StubApp.getOrigApplicationContext(this.getApplicationContext()))).setFocusableInTouchMode(true);
//        this.bottomTitleLayout.setEnabled(true);
//        this.bottomTitleLayout.setFocusable(true);
//        this.bottomTitleLayout.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
//            public void onClick(final View view) {
//                RqService.this.startActivity(new Intent(StubApp.getOrigApplicationContext(RqService.this.getApplicationContext()), (Class)BarcodeCameraActivity.class));
//            }
//        });
//        this.bottomTitleLayout.setTextColor(this.getResources().getColor(2131099998));
//        this.bottomTitleLayout.setTextSize(32.0f);
//        this.bottomTitleLayout.setBackgroundColor(this.getResources().getColor(2131099720));
//        this.bottomTitleWindowManager = this.bottomTitleLayout.windowManager;
//        this.bottomTitleParam = this.bottomTitleLayout.wmParams;
//        if (Build$VERSION.SDK_INT < 26) {
//            this.bottomTitleParam.type = 2003;
//        }
//        else {
//            this.bottomTitleParam.type = 2038;
//        }
//        final WindowManager$LayoutParams bottomTitleParam = this.bottomTitleParam;
//        bottomTitleParam.format = 1;
//        bottomTitleParam.flags = 8;
//        bottomTitleParam.flags |= 0x40000;
//        final WindowManager$LayoutParams bottomTitleParam2 = this.bottomTitleParam;
//        bottomTitleParam2.flags |= 0x200;
//        final WindowManager$LayoutParams bottomTitleParam3 = this.bottomTitleParam;
//        bottomTitleParam3.alpha = 1.0f;
//        bottomTitleParam3.gravity = 81;
//        bottomTitleParam3.x = 0;
//        bottomTitleParam3.y = 0;
//        bottomTitleParam3.width = 600;
//        bottomTitleParam3.height = 80;
    }
    
    private void createCustomerServiceFloatView() {
//        (this.customerService = new FloatView(StubApp.getOrigApplicationContext(this.getApplicationContext()))).setFocusableInTouchMode(true);
//        this.customerService.setEnabled(true);
//        this.customerService.setFocusable(true);
//        this.customerService.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
//            public void onClick(final View view) {
//                if (RqService.this.serviceDialog == null) {
//                    RqService.this.serviceDialog = new CustomerServiceDialog((Context)ActivityUtils.getTopActivity());
//                }
//                RqService.this.serviceDialog.show();
//            }
//        });
//        this.customerService.setTextColor(this.getResources().getColor(2131099998));
//        this.customerService.setTextSize(32.0f);
//        this.customerService.setBackgroundResource(2131624004);
//        this.mUstomerServiceWindowManager = this.customerService.windowManager;
//        this.ustomerServiceParam = this.customerService.wmParams;
//        if (Build$VERSION.SDK_INT < 26) {
//            this.ustomerServiceParam.type = 2003;
//        }
//        else {
//            this.ustomerServiceParam.type = 2038;
//        }
//        final WindowManager$LayoutParams ustomerServiceParam = this.ustomerServiceParam;
//        ustomerServiceParam.format = 1;
//        ustomerServiceParam.flags = 8;
//        ustomerServiceParam.flags |= 0x40000;
//        final WindowManager$LayoutParams ustomerServiceParam2 = this.ustomerServiceParam;
//        ustomerServiceParam2.flags |= 0x200;
//        final WindowManager$LayoutParams ustomerServiceParam3 = this.ustomerServiceParam;
//        ustomerServiceParam3.alpha = 1.0f;
//        ustomerServiceParam3.gravity = 51;
//        ustomerServiceParam3.x = 650;
//        ustomerServiceParam3.y = 1050;
//        ustomerServiceParam3.width = 120;
//        ustomerServiceParam3.height = 120;
    }
    
    private void createFloatView() {
//        (this.mLayout = new FloatView(StubApp.getOrigApplicationContext(this.getApplicationContext()))).setFocusableInTouchMode(true);
//        this.mLayout.setEnabled(true);
//        this.mLayout.setFocusable(true);
//        this.mLayout.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
//            public void onClick(final View view) {
//                RqService.this.startActivity(new Intent(StubApp.getOrigApplicationContext(RqService.this.getApplicationContext()), (Class)BarcodeCameraActivity.class));
//            }
//        });
//        this.mLayout.setTextColor(this.getResources().getColor(2131099998));
//        this.mLayout.setTextSize(32.0f);
//        this.mLayout.setBackgroundColor(this.getResources().getColor(2131099720));
//        this.mWindowManager = this.mLayout.windowManager;
//        this.param = this.mLayout.wmParams;
//        if (Build$VERSION.SDK_INT < 26) {
//            this.param.type = 2003;
//        }
//        else {
//            this.param.type = 2038;
//        }
//        final WindowManager$LayoutParams param = this.param;
//        param.format = 1;
//        param.flags = 8;
//        param.flags |= 0x40000;
//        final WindowManager$LayoutParams param2 = this.param;
//        param2.flags |= 0x200;
//        final WindowManager$LayoutParams param3 = this.param;
//        param3.alpha = 1.0f;
//        param3.gravity = 51;
//        param3.x = 0;
//        param3.y = 0;
//        param3.width = 160;
//        param3.height = 80;
    }
    
    private void createSavePicDir() {
        final StringBuilder sb = new StringBuilder();
        sb.append(RqService.savePath);
        sb.append(DateUtil.getToday());
        sb.append("/");
        RqService.savePathDay = sb.toString();
        final File file = new File(RqService.savePathDay);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
    
    private void getCloudSizeAndDelete(final Boolean b) {
        OkhttpManager.getCobaDeviceCloudSize((OkhttpManager.OnOkhttpCallback<DeviceCloudResponseBean>)new OkhttpManager.OnOkhttpCallback<DeviceCloudResponseBean>() {
            public void onSuccess(final DeviceCloudResponseBean deviceCloudResponseBean) {
                if (deviceCloudResponseBean != null && deviceCloudResponseBean.getCloud_limit() - deviceCloudResponseBean.getCloud_current() <= 536870912L) {
                    OkhttpManager.deleteCobaDeviceCloudSpace((OkhttpManager.OnOkhttpCallback<String>)new OkhttpManager.OnOkhttpCallback<String>() {
                        public void onSuccess(final String s) {
                        }
                    });
                }
                if (!b) {
                    return;
                }
                final long intervalDays = DateUtil.getIntervalDays(DateUtil.getDateFormat(new Date()), DateUtil.getDateFormat(DateUtil.getDateByDateTimeFormat(deviceCloudResponseBean.getCloud_deadline())));
                if (intervalDays <= 7L) {
                    /*if (intervalDays <= 0L) {
                        final Activity topActivity = ActivityUtils.getTopActivity();
                        final StringBuilder sb = new StringBuilder();
                        sb.append("\u5230\u671f\u65f6\u95f4:");
                        sb.append(deviceCloudResponseBean.getCloud_deadline());
                        //new CloudSpaceTiralDialog((Context)topActivity, "\u4e91\u5b58\u50a8\u7a7a\u95f4\u5df2\u5230\u671f\uff0c\u4e3a\u907f\u514d\u5f71\u54cd\u60a8\u7684\u6b63\u5e38\u4f7f\u7528\uff0c\u8bf7\u53ca\u65f6\u5230\u3010\u91c7\u5bfb\u7269\u8054APP\u3011\u7eed\u8d39", sb.toString(), "\u5269\u4f59\u5929\u6570\uff1a0").show();
                        return;
                    }
                    final Activity topActivity2 = ActivityUtils.getTopActivity();
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("\u5230\u671f\u65f6\u95f4:");
                    sb2.append(deviceCloudResponseBean.getCloud_deadline());
                    final String string = sb2.toString();
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("\u5269\u4f59\u5929\u6570\uff1a");
                    sb3.append(intervalDays);*/
//                    new CloudSpaceTiralDialog((Context)topActivity2, "\u4e91\u5b58\u50a8\u7a7a\u95f4\u5373\u5c06\u5230\u671f\uff0c\u4e3a\u907f\u514d\u5f71\u54cd\u60a8\u7684\u6b63\u5e38\u4f7f\u7528\uff0c\u8bf7\u53ca\u65f6\u5230\u3010\u91c7\u5bfb\u7269\u8054APP\u3011\u7eed\u8d39", string, sb3.toString()).show();
                }
            }
        });
    }
    
    private void postSelfAidlBarcodeList(final List<String> list, final byte[] array) {
        /*if (CobaAidlService.icobaAidlCallback != null) {
            try {
                CobaAidlService.icobaAidlCallback.getBarcodeList((List)list);
            }
            catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
        final IBarcode selfIBarcode = this.selfIBarcode;
        if (selfIBarcode != null) {
            selfIBarcode.getBarcodeList(list, array);
        }*/
    }
    
    private void registerBroadcast() {
        /*this.cobaDeviceBroadcast = new CobaDeviceBroadcast();
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("key_online_action");
        this.registerReceiver((BroadcastReceiver)this.cobaDeviceBroadcast, intentFilter);*/
    }
    
    private void uploadDeviceOperationType() {
        final long mixSelectSystemType = CommonFilePreference.getInstance().getMixSelectSystemType();
        final int selectExpressSystemFlag = CommonFilePreference.getInstance().getSelectExpressSystemFlag();
        final ArrayList<String> st = new ArrayList<String>();
        if (selectExpressSystemFlag == ExpressStationEnum.KUAIBAO.getCode() || (ExpressStationEnum.KUAIBAO.getItem() & mixSelectSystemType) != 0x0L) {
            st.add(ExpressStationEnum.KUAIBAO.getTitle());
        }
        if (selectExpressSystemFlag == ExpressStationEnum.KUAIDICAOSHI.getCode() || (ExpressStationEnum.KUAIDICAOSHI.getItem() & mixSelectSystemType) != 0x0L) {
            st.add(ExpressStationEnum.KUAIDICAOSHI.getTitle());
        }
        if (selectExpressSystemFlag == ExpressStationEnum.MAMASTATION.getCode() || (ExpressStationEnum.MAMASTATION.getItem() & mixSelectSystemType) != 0x0L) {
            st.add(ExpressStationEnum.MAMASTATION.getTitle());
        }
        if (selectExpressSystemFlag == ExpressStationEnum.LAIQU.getCode() || (ExpressStationEnum.LAIQU.getItem() & mixSelectSystemType) != 0x0L) {
            st.add(ExpressStationEnum.LAIQU.getTitle());
        }
        if (selectExpressSystemFlag == ExpressStationEnum.XINIAO.getCode() || (ExpressStationEnum.XINIAO.getItem() & mixSelectSystemType) != 0x0L) {
            st.add(ExpressStationEnum.XINIAO.getTitle());
        }
        if (selectExpressSystemFlag == ExpressStationEnum.YUNDAKDCS.getCode() || (ExpressStationEnum.YUNDAKDCS.getItem() & mixSelectSystemType) != 0x0L) {
            st.add(ExpressStationEnum.YUNDAKDCS.getTitle());
        }
        if (selectExpressSystemFlag == ExpressStationEnum.FENGCHAOSERVICE.getCode() || (ExpressStationEnum.FENGCHAOSERVICE.getItem() & mixSelectSystemType) != 0x0L) {
            st.add(ExpressStationEnum.FENGCHAOSERVICE.getTitle());
        }
        if (selectExpressSystemFlag == ExpressStationEnum.XIAOBINGSTATION.getCode() || (mixSelectSystemType & ExpressStationEnum.XIAOBINGSTATION.getItem()) != 0x0L) {
            st.add(ExpressStationEnum.XIAOBINGSTATION.getTitle());
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final DeviceMixTypeBean deviceMixTypeBean = new DeviceMixTypeBean();
        deviceMixTypeBean.setSn(FactoryConfigurationFilePreference.getInstance().getFactoryRegistration().getSerial_number());
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(currentTimeMillis);
        deviceMixTypeBean.setTimestamp(sb.toString());
        deviceMixTypeBean.setSt(st);
        try {
            deviceMixTypeBean.setSign(MD5Util.getEncryptMD5Class(deviceMixTypeBean.getClass(), currentTimeMillis, RqFilePreference.getInstance().getLoginBean().getUsername()));
            OkhttpManager.uploadDeviceMixType(deviceMixTypeBean);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            //XLog.e("\u8bbe\u5907\u672a\u767b\u5f55");
        }
    }
    
    public void addBottomTitleWindowManagerView(final String text) {
        /*final FloatView bottomTitleLayout = this.bottomTitleLayout;
        if (bottomTitleLayout != null) {
            final WindowManager$LayoutParams bottomTitleParam = this.bottomTitleParam;
            if (bottomTitleParam != null && !this.isAddBottomTitleWindowManagerView) {
                this.isAddBottomTitleWindowManagerView = true;
                this.bottomTitleWindowManager.addView((View)bottomTitleLayout, (ViewGroup$LayoutParams)bottomTitleParam);
            }
            this.bottomTitleLayout.setText((CharSequence)text);
        }*/
    }
    
    public void addCSWindowManagerView() {
        /*final FloatView customerService = this.customerService;
        if (customerService != null && !this.isAddCustomerServiceWindowManagerView) {
            this.isAddCustomerServiceWindowManagerView = true;
            this.mUstomerServiceWindowManager.addView((View)customerService, (ViewGroup$LayoutParams)this.ustomerServiceParam);
        }*/
    }
    
    public void addWindowManagerView() {
        if (RqFilePreference.getInstance().getCloseWeightStatus()) {
            return;
        }
        /*final FloatView mLayout = this.mLayout;
        if (mLayout != null) {
            final WindowManager$LayoutParams param = this.param;
            if (param != null && !this.isAddWindowManagerView) {
                this.isAddWindowManagerView = true;
                this.mWindowManager.addView((View)mLayout, (ViewGroup$LayoutParams)param);
            }
        }*/
    }
    
    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean checkFloatPermission(final Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return Settings.canDrawOverlays(context);
        }
        final AppOpsManager appOpsManager = (AppOpsManager)context.getSystemService(Context.APP_OPS_SERVICE);
        boolean b = false;
        if (appOpsManager == null) {
            return false;
        }
        final int checkOpNoThrow = appOpsManager.checkOpNoThrow("android:system_alert_window", Process.myUid(), context.getPackageName());
        if (Settings.canDrawOverlays(context) || checkOpNoThrow == 0 || checkOpNoThrow == 1) {
            b = true;
        }
        return b;
    }
    
    public IBinder onBind(final Intent intent) {
        final String stringExtra = intent.getStringExtra("INTENT_KEY");
        final StringBuilder sb = new StringBuilder();
        sb.append("onBind: =");
        sb.append(stringExtra);
        Log.e("CobaAiService", sb.toString());
        return (IBinder)new SelfBarcodeCameraBinder();
    }
    
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onCreate() {
        super.onCreate();
        try {
            this.createCustomerServiceFloatView();
            this.createFloatView();
            this.createBottomTitleFloatView();
            try {
                this.exposure = RqFilePreference.getInstance().getBarcodeExposureTime();
                this.gain = RqFilePreference.getInstance().getBarcodeGain();
                this.gamma = RqFilePreference.getInstance().getBarcodeGamma();
                this.framerate = RqFilePreference.getInstance().getBarcodeFramerate();
                this.barcodeType = RqFilePreference.getInstance().getBarcodeType();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            this.openModbusScale();
            /*if (!this.openHikCameraBarcode()) {
                (this.mCobaBarcodeCamera = new CobaBarcodeCamera(this.exposure, this.gain, this.gamma, this.framerate, this.barcodeType)).setIBarcode(this.mIBarcode);
            }*/
            this.createSavePicDir();
            this.registerBroadcast();
            RqService.cobaAiService = this;
            (this.ossStsTokenTimer = new Timer()).schedule(this.stsTimerTask, 1000L, 3300000L);
            this.uploadDeviceOperationType();
            if (!this.checkFloatPermission((Context)this)) {
                this.requestFloatPermission();
            }
            else {
                this.addCSWindowManagerView();
            }
            Log.e("CobaAiService", "CobaAiService  ok");
            this.getCloudSizeAndDelete(true);
        }
        catch (Exception ex2) {
            ex2.printStackTrace();
        }
    }
    
    public void onDestroy() {
        super.onDestroy();
        /*if (MVIDCameraManager.getInstance().hikBarcodeCameraRunning) {
            MVIDCameraManager.getInstance().closeCodeReaderCamera();
        }*/
        this.removeWindowManagerView();
        this.removeCSWindowManagerView();
       /* final CobaBarcodeCamera mCobaBarcodeCamera = this.mCobaBarcodeCamera;
        if (mCobaBarcodeCamera != null) {
            mCobaBarcodeCamera.closeBarcodeCamera();
        }
        ModbusManager.getInstance().closeDevices();*/
        ImageSaveUtil.getInstance().threadPoolExecutor.shutdownNow();
        /*final CobaDeviceBroadcast cobaDeviceBroadcast = this.cobaDeviceBroadcast;
        if (cobaDeviceBroadcast != null) {
            this.unregisterReceiver((BroadcastReceiver)cobaDeviceBroadcast);
        }*/
        final Timer ossStsTokenTimer = this.ossStsTokenTimer;
        if (ossStsTokenTimer != null) {
            ossStsTokenTimer.cancel();
        }
        /*if (SystemUtil.getSystemModel().contains("JoyFinder-SK03399")) {
            new XHApiUtils().getInstance().quit();
        }*/
    }
    
    public boolean openHikCameraBarcode() {
        return false/*MVIDCameraManager.getInstance().openCodeReaderCamera(this.exposure, this.gain, this.gamma, this.framerate, this.barcodeType, RqFilePreference.getInstance().getBarcodeCameraAutoExposure(), new IHikBarcode() {
            @Override
            public void getBarcodeList(final List<String> list, final byte[] array) {
                RqService.this.postSelfAidlBarcodeList(list, array);
            }
        })*/;
    }
    
    public void openModbusScale() {
        if (!RqFilePreference.getInstance().getCloseWeightStatus()) {
            //ModbusManager.getInstance().openDevice(RqFilePreference.getInstance().getWeightDevTtyPort(), this.mWeightCallback);
        }
        //ModbusManager.getInstance().createLedSerialPort();
    }
    
    public void removeBottomTitleWindowManagerView() {
        if (Build.VERSION.SDK_INT >= 17) {
            /*final FloatView bottomTitleLayout = this.bottomTitleLayout;
            if (bottomTitleLayout != null && this.isAddBottomTitleWindowManagerView) {
                this.isAddBottomTitleWindowManagerView = false;
                this.bottomTitleWindowManager.removeView((View)bottomTitleLayout);
            }*/
        }
    }
    
    public void removeCSWindowManagerView() {
       /* final FloatView customerService = this.customerService;
        if (customerService != null && this.isAddCustomerServiceWindowManagerView) {
            this.isAddCustomerServiceWindowManagerView = false;
            this.mUstomerServiceWindowManager.removeView((View)customerService);
        }*/
    }
    
    public void removeWindowManagerView() {
        if (Build.VERSION.SDK_INT >= 17) {
            /*final FloatView mLayout = this.mLayout;
            if (mLayout != null && this.isAddWindowManagerView) {
                this.isAddWindowManagerView = false;
                this.mWindowManager.removeView((View)mLayout);
            }*/
        }
    }
    
    public void requestFloatPermission() {
        final Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        final StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(this.getPackageName());
        intent.setData(Uri.parse(sb.toString()));
        this.startActivity(intent);
    }
    
    public class SelfBarcodeCameraBinder extends Binder
    {
        /*public CobaBarcodeCamera getCobaBarcodeCamera() {
            return RqService.this.mCobaBarcodeCamera;
        }*/
        
        public RqService getService() {
            return RqService.this;
        }
        
        /*public void setIBarcode(final IBarcode barcode) {
            RqService.this.selfIBarcode = barcode;
        }
        
        public void setIBarcodeDrawLine(final IBarcodeDrawLine iBarcodeDrawLine) {
            if (RqService.this.mCobaBarcodeCamera != null) {
                Log.e("CobaAiService", "ondMultiBarcodeListener:++++ 22");
                RqService.this.mCobaBarcodeCamera.setIBarcodeDrawLine(iBarcodeDrawLine);
            }
        }
        
        public void setIWeightCallback(final IWeightCallback weightCallback) {
            RqService.this.selfIWeightCallback = weightCallback;
        }*/
    }
}
