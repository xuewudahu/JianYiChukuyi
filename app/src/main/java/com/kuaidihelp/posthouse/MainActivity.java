package com.kuaidihelp.posthouse;
//git
import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import com.alibaba.fastjson.JSON;
import com.dou361.dialogui.DialogUIUtils;
import com.google.gson.JsonObject;
import com.kuaidihelp.posthouse.ui.CameraTexture2;
import com.kuaidihelp.posthouse.util.AdroidUtil;
import com.kuaidihelp.posthouse.util.SecurityUtil;
import com.rq.barcode.RqDecoder;
import com.rq.barcode.RqEngineer;
import com.rq.barcode.RqSymbologyType;
import com.rq.camera.FrameSaver;
import com.kuaidihelp.posthouse.util.SystemTTS;
import com.rq.misc.MiscUtil;
import com.rq.net.LoginActivity;
import com.rq.net.MyApplication;
import com.rq.net.bean.CurrentParcel;
import com.rq.net.bean.JiTuOutLibraryResponse;
import com.rq.net.bean.JiTuResponse;
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
import com.rq.net.bean.MaMaCheckInforBean;
import com.rq.net.bean.MaMaLoginResponseBean;
import com.rq.net.bean.MaMaNoOutLibraryResponseBean;
import com.rq.net.bean.MaMaOutLibraryBean;
import com.rq.net.bean.MaMaQueryBarcodeBean;
import com.rq.net.bean.MaMaQueryBarcodeResponseBean;
import com.rq.net.bean.PandaOutData;
import com.rq.net.bean.PandaOutLibCall;
import com.rq.net.bean.PinDuoDuoBaseResponseBean;
import com.rq.net.bean.RequestJiTuOutlibrary;
import com.rq.net.bean.SatgeChuKu1;
import com.rq.net.bean.ShowMuchPackageNoPickBean;
import com.rq.net.bean.StageLoginRequestBean;
import com.rq.net.bean.StationHelperRequestBean;
import com.rq.net.bean.StationHelperRequestChuKuBean;
import com.rq.net.bean.StationHelperResponseBarcodeBean;
import com.rq.net.bean.StationHelperResponseChuKuBean;
import com.rq.net.manager.MixScanMamager;
import com.rq.net.manager.OkHttpPinDuoDuoManager;
import com.rq.net.manager.OkhttpManager;
import com.rq.net.manager.OkhttpMoxiManager;
import com.rq.net.manager.SoundManager;
import com.rq.net.setting.RqFilePreference;
import com.rq.net.util.DateUtil;
import com.rq.net.util.ExpressStationEnum;
import com.rq.net.util.Intrinsics;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.Md5InputStream;
import com.rq.net.util.StringUtil;
import com.rq.net.util.ToastSoundUtil;
import com.rq.view.RqDecodeComponent;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends Activity implements RqDecoder.ResultCallback, MixScanMamager.OkhttpCallbackStationManager,
        OkhttpManager.OnHttpErrorCallback, OkhttpManager.OnOkhttpCallback, RqEngineer.Listener, CameraTexture2.Listener {
    private RqEngineer mRqEngineer;
    private RqDecodeComponent rqDecodeComponent;
    public CameraTexture2 cameraView;
    private SoundPool sp = null;
    private int ringId;
    private ImageView buttonSetting;
    private TextView textViewId;
    //private TextView textState;
    private TextView textViewSum;
    private TextView textViewResult;
    private TextView textViewState;
    private String codeId = " ";
    private boolean soundState;
    private SystemTTS systemTTS;
    private long lastonclickTime = 0;
    private String onetime;
    private long time;
    public static final int SHOWCODEID = 0x9;
    public static final int CHUKUING = 0x1;
    public static final int CHUKUED = 0x2;
    public static final int RESULT = 0x3;
    public static final int NOTLIBRARY = 0x4;
    public static final int NONET = 0x5;
    public static final int NORESULT = 0x6;
    public static final int NOEDIT = 0x7;
    public static final int CHUKUING_MORE = 0x8;
    public static final int CHUKUING_STATE = 0x10;
    //开关
    private final static String FRONT_CAMERA_OPENED = "front_camera_opened";
    private final static String SCAN_CAMERA_OPENED = "scan_camera_opened";
    private final static String FILL_LIGHT_OPENED = "fill_light_opened";
    private final static String SCAN_SOUND_OPENED = "scan_sound_opened";
    private final static String START_DECODE_OPEND = "start_Decode_opend";
    private final static String SCAN_SCAN_TIME = "scan_scan_time";
    private final static String GAMMA_ON = "gamma_on";
    private Bitmap bitmapDecode;
    private String codeDecode;
    private String codeFace;
    private Bitmap bitmapFace;
    private SharedPreferences sharedPreferences;
    public  Boolean isSingle;
    public  ArrayList<Integer> multiList;
    public  Map<String, String> signMap;
    public  long time_token = 0;
    String token = null;
    boolean isShowMuchPackage = false;//妈妈驿站
    private Dialog mFactRstPwsCheckDialog;
    private TextView cancelButton;
    private TextView okButton;
    private EditText pswEdit;
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        requestCameraPermission();
        buttonSetting = findViewById(R.id.iv_menu);
        textViewId = findViewById(R.id.scan_orderID);
        textViewState = findViewById(R.id.scan_state);
        textViewSum = findViewById(R.id.scan_sum);
        textViewResult = findViewById(R.id.scan_result);
        rqDecodeComponent = (RqDecodeComponent) findViewById(R.id.cam_scanner_view);
        cameraView = (CameraTexture2) findViewById(R.id.scan_face_camera);
        rqDecodeComponent.transformRotation(Surface.ROTATION_270);
        mRqEngineer = RqEngineer.getInstence(this);
        mRqEngineer.setContinueScanMode(true);
        mRqEngineer.getRqDecoder().addResultCallback(this);
        mRqEngineer.setListenerDecode(this);
        cameraView.setBitmapImageListener(this);
        mRqEngineer.getRqDecoder().getNumberOfBarcodesToDecode();
        FrameSaver f = mRqEngineer.getFrameSaver();
        f.setFrameSaveType(0);
        f.setFrameSaveFormat(2);
        sharedPreferences = getSharedPreferences("state", 0);
        isSingle = sharedPreferences.getBoolean("isSingle", true);
        if (getIntent().getStringExtra("scan_scan_test")!=null && getIntent().getStringExtra("scan_scan_test").equals("true")) {
            SharedPreferences.Editor e = sharedPreferences.edit();
            Log.e("wxww","00000");
            e.putBoolean("scan_scan_test", true);
            e.commit();
        }
        multiList = MyApplication.getselectedPositionMulti();
        OkhttpManager.setOnhttpErrorCallback((OkhttpManager.OnHttpErrorCallback) MainActivity.this);
        OkhttpManager.setOnOkhttpCallback((OkhttpManager.OnOkhttpCallback) MainActivity.this);
        if (sp == null) {
            sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
            ringId = sp.load(this, R.raw.di, 1);//扫描提示音对象初始化
        }
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long time_button = SystemClock.uptimeMillis();
                if (time_button - lastonclickTime >= 2000) {
                    createFactoryResetPwdDialog();
                    lastonclickTime = time_button;
                }
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        systemTTS = SystemTTS.getInstance(MainActivity.this);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onStart() {
        super.onStart();

    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("wwww","----Main_onPause-------");
        if (mRqEngineer.stopDecode() == MiscUtil.NO_ERROR) {
        }
        systemTTS.stopSpeak();
        //退出时关闭扫码相机、扫光灯和伽马
        if (mRqEngineer != null) {
            mRqEngineer.closeScanner();
            mRqEngineer.setIllState(0);
            // mRqEngineer.setGammaOn(false);
        }
        if (cameraView != null) {
            cameraView.onStop();
        }
    }

    /**
     * 退出app 销毁Engineer对象
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onDestroy() {
        Log.e("wwww","----Main_onDestroy-------");
        super.onDestroy();
        if (mRqEngineer != null)
            mRqEngineer.destory();
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onResume() {
        super.onResume();
        if (sharedPreferences.getBoolean("scan_scan_test", false)) {
            Log.e("wxw_界面","---进入扫码测试界面-onResume");
            textViewState.setText("测试模式");
        }else {
            Log.e("wxw_界面", "--进入扫码界面-onResume");
            textViewState.setText("");
        }
        Log.e("wwww","----Main_onstart-------");
        boolean scanState = sharedPreferences.getBoolean(SCAN_CAMERA_OPENED, true);
        boolean decodeState = sharedPreferences.getBoolean(START_DECODE_OPEND, true);
        int lightState = sharedPreferences.getInt(FILL_LIGHT_OPENED, 10);
        boolean gammaState = sharedPreferences.getBoolean(GAMMA_ON, true);
        boolean frontCamera = sharedPreferences.getBoolean(FRONT_CAMERA_OPENED, true);
        soundState = sharedPreferences.getBoolean(SCAN_SOUND_OPENED, false);
        int delayTime =MyApplication.getDelayTime();
        if (scanState) {
            new Handler().postDelayed(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.Q)
                @Override
                public void run() {
                    rqDecodeComponent.setVisibility(View.VISIBLE);
                    if (mRqEngineer.openScannner() == MiscUtil.NO_ERROR) {
                        // Toast.makeText(MainActivity.this, "扫码相机无法打开,请重新启动", Toast.LENGTH_SHORT).show();
                        Log.d("www", "openScannner_NO_ERROR");
                    }
                }
            }, delayTime);
        } else {
            rqDecodeComponent.setVisibility(View.VISIBLE);
            mRqEngineer.closeScanner();
        }
        //开始扫码开关
        if (decodeState) {
            new Handler().postDelayed(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.Q)
                @Override
                public void run() {
                    if (mRqEngineer != null) {
                        if (mRqEngineer.startDecode() == MiscUtil.NO_ERROR) {
                            // Toast.makeText(MainActivity.this, "无法打开扫码,请重新启动", Toast.LENGTH_SHORT).show();
                            Log.d("www", "startDecode_NO_ERROR");
                        }
                    }
                }
            }, delayTime+500);
        } else {
            mRqEngineer.stopDecode();
        }
        //补光灯开关
        mRqEngineer.setIllState(lightState);
        //伽马开关
        if (gammaState) {
            mRqEngineer.setGammaOn(true);
        } else {
            mRqEngineer.setGammaOn(false);
        }

        //前摄开关
        if (frontCamera) {
            cameraView.setVisibility(View.VISIBLE);
            cameraView.onResume(MainActivity.this);
        }else {
            cameraView.onStop();
            cameraView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onResultCallback(String s, RqSymbologyType symbologyType, int[] corner) {
      if (soundState) {
            playSound();
        }
          if (codeId != null && !codeId.equals(s))
            codeId = s;
        Message msg = new Message();
        msg.what = SHOWCODEID;
        msg.obj = s;
        handler.sendMessage(msg);//异步操作需要handler来改变UI
        if ((onetime != null && !onetime.isEmpty() && onetime.equals(s)
                && System.currentTimeMillis() - time < sharedPreferences.getInt(SCAN_SCAN_TIME, 8) * 1000L)||
                sharedPreferences.getBoolean("scan_scan_test",false)) {
            return;
        }
        onetime = s;//第二次回调无法进入
        time = System.currentTimeMillis();
        Log.e("wwwtt","You have "+MyApplication.getStationEnum()+" packages !");
        if (!AdroidUtil.isConnectedToInternet(MainActivity.this)) {
            DialogUIUtils.showToastCenter("请检查网络连接");
            return;
        }
        if (isSingle) {
            if (MyApplication.getStationEnum() == ExpressStationEnum.DUODUOYIZHAN) {
                duoduoOutLib(s);
            } else if (MyApplication.getStationEnum() == ExpressStationEnum.KUAIBAO) {
                kuaibaoUnpack(s);
            } else if (MyApplication.getStationEnum() == ExpressStationEnum.STATIONHELPER) {
                stationHelperOutLib(s);
            } else if (MyApplication.getStationEnum() == ExpressStationEnum.LAIQU) {
                laiquQuery(s);
            } else if (MyApplication.getStationEnum() == ExpressStationEnum.KUAIDICAOSHI) {
                tuxikdcsQueryAndOutLib(s, false);
            } else if (MyApplication.getStationEnum() == ExpressStationEnum.JITU) {
                jituOutLib(s);
            } else if (MyApplication.getStationEnum() == ExpressStationEnum.COURIERSMALLPOLE) {
                courSmailPoleOutLib(s);
            } else if (MyApplication.getStationEnum() == ExpressStationEnum.STAGESMALLPOLE) {
                yizhanxiaobiandaOutLib(s);
            } else if (MyApplication.getStationEnum() == ExpressStationEnum.PANDAHARVEST) {
                uploadOutLibrary(s);
            } else if (MyApplication.getStationEnum() == ExpressStationEnum.FENGCHAOSERVICE) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            postRequest(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }else if (MyApplication.getStationEnum() == ExpressStationEnum.MOXIGUANJIA) {

                moxiOutLib(s);
            }else if (MyApplication.getStationEnum() == ExpressStationEnum.MAMASTATION) {
                mamayizhanQueryBarcodeAndOutLib(s,false);
            }else if (MyApplication.getStationEnum() == ExpressStationEnum.YSHOUFA) {
                yishoufaOutLib(s);
            }
        } else {
            errorTimes=0;
            for (int i = 0; i < multiList.size(); i++) {
                if (MyApplication.getExpressStationEnum(multiList.get(i)) == ExpressStationEnum.DUODUOYIZHAN) {

                    duoduoOutLib(s);
                } else if (MyApplication.getExpressStationEnum(multiList.get(i)) == ExpressStationEnum.KUAIBAO) {

                    kuaibaoUnpack(s);
                } else if (MyApplication.getExpressStationEnum(multiList.get(i)) == ExpressStationEnum.STATIONHELPER) {

                    stationHelperOutLib(s);
                } else if (MyApplication.getExpressStationEnum(multiList.get(i)) == ExpressStationEnum.LAIQU) {

                    laiquQuery(s);
                } else if (MyApplication.getExpressStationEnum(multiList.get(i)) == ExpressStationEnum.KUAIDICAOSHI) {

                    tuxikdcsQueryAndOutLib(s, false);
                } else if (MyApplication.getExpressStationEnum(multiList.get(i)) == ExpressStationEnum.JITU) {

                    jituOutLib(s);
                } else if (MyApplication.getExpressStationEnum(multiList.get(i)) == ExpressStationEnum.COURIERSMALLPOLE) {

                    courSmailPoleOutLib(s);
                } else if (MyApplication.getExpressStationEnum(multiList.get(i)) == ExpressStationEnum.STAGESMALLPOLE) {

                    yizhanxiaobiandaOutLib(s);
                } else if (MyApplication.getExpressStationEnum(multiList.get(i)) == ExpressStationEnum.PANDAHARVEST) {

                    uploadOutLibrary(s);
                }else if (MyApplication.getExpressStationEnum(multiList.get(i)) == ExpressStationEnum.FENGCHAOSERVICE) {
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            try {
                                postRequest(s);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                }else if (MyApplication.getExpressStationEnum(multiList.get(i)) == ExpressStationEnum.MOXIGUANJIA) {
                    moxiOutLib(s);
                }else if (MyApplication.getExpressStationEnum(multiList.get(i)) == ExpressStationEnum.MAMASTATION) {
                    mamayizhanQueryBarcodeAndOutLib(s,false);
                }else if (MyApplication.getExpressStationEnum(multiList.get(i)) == ExpressStationEnum.YSHOUFA) {
                    yishoufaOutLib(s);
                }
            }
        }
    }

    @Override
    public void onMultipleResultCallback(String[] strings, RqSymbologyType[] symbologyTypes, List<int[]> corners) {
    }

    @Override
    public void onDecodeError(int errorCode) {
    }

    /**
     * 播放扫描提示音
     */
    private void playSound() {
        AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        float audioMaxVolumn = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float audioCurrentVolumn = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        final float volumnRatio = audioCurrentVolumn / audioMaxVolumn;
        am.setStreamVolume(AudioManager.STREAM_MUSIC, (int) audioCurrentVolumn, 0);
        sp.play(ringId, volumnRatio, volumnRatio, 1, 0, 1f);
    }



    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result.append(temp);
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @SuppressLint({"ResourceAsColor", "SetTextI18n"})
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SHOWCODEID:
                    String message = msg.obj.toString();
                    textViewId.setText(message);
                    break;
                case CHUKUING:
                    SharedPreferences settings = getSharedPreferences("Express_count", 0);
                    int count = settings.getInt("Express_count", 0);
                    count++;
                    textViewSum.setText(Integer.toString(count));
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("Express_count", count);
                    editor.commit();
                    textViewResult.setText("出库成功!");
                    systemTTS.stopSpeak();
                    systemTTS.playText("出库成功");
                    break;
                case CHUKUING_MORE:
                    SharedPreferences settings1 = getSharedPreferences("Express_count", 0);
                    int count2 = settings1.getInt("Express_count", 0);
                    count2++;
                    textViewSum.setText(Integer.toString(count2));
                    SharedPreferences.Editor editor1 = settings1.edit();
                    editor1.putInt("Express_count", count2);
                    editor1.commit();
                    textViewResult.setText("还有未取包裹,请及时领取!");
                    systemTTS.stopSpeak();
                    systemTTS.playText("您当前还有未取包裹，请及时领取");
                    break;
                case CHUKUED:
                    textViewResult.setText("已经出库!");
                    systemTTS.stopSpeak();
                    systemTTS.playText("已出库");
                    break;
                case RESULT:
                    String result = msg.obj.toString();
                    break;
                case NOTLIBRARY:
                    String mes = msg.obj.toString();
                    textViewResult.setText(mes);
                    systemTTS.stopSpeak();
                    systemTTS.playText("出库失败");
                    break;
                case NONET:
                    textViewResult.setText("无法出库，请检查网络连接!");
                    break;
                case NORESULT:
                    textViewResult.setText(" ");
                    textViewResult.setText("请将单个包裹运单面朝上放置在扫描区");
                   // textState.setText(" ");
                    break;
                case CHUKUING_STATE:
                    String msg_state = msg.obj.toString();
                  //  textState.setText(msg_state);
                    break;
            }
        }
    };

    /**
     * 运行时权限验证
     */
    private boolean requestCameraPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try { //检测是否有写的权限
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED
                        || ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED
                        || ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) { // 没有写的权限，去申请写的权限，会弹出对话框
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.CAMERA,
                                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                                    Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            221);
                    System.exit(0);
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private void duoduoOutLib(String barcode) {
        OkHttpPinDuoDuoManager.outLibraryAio(MainActivity.this, barcode, new OkHttpPinDuoDuoManager.OnHttpCallback() {
            @Override
            public void onError(int var1, String var2) {
                Log.d(com.rq.net.LoginActivity.TAG, "outLibrary onError: ===var1=" + var1 + " var2=" + var2);
                //  ToastSoundUtil.displayToast("outLibrary error===");
                //tips.setText("out lib error, error message:"+var2);

            }

            @Override
            public void onSuccess(Object var1) {
                PinDuoDuoBaseResponseBean pddbr = (PinDuoDuoBaseResponseBean) var1;
                Log.d(com.rq.net.LoginActivity.TAG, "outLibrary onSuccess pddbr =" + pddbr);

                //tips.setText("out lib success,result:"+pddbr.getResult().toString());
            }
        });
    }
    //妈妈驿站
    public final void mamayizhanQueryBarcodeAndOutLib(String var1,boolean queryOnly) {
        Log.e("wwwtt","You have packagesmamayizhanQueryBarcodeAndOutLib !");
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
                    Log.e("wwwtt","You have packages !");
                    this.onSuccess((List)var1);
                }

                public void onSuccess(List var1) {
                    if (queryOnly) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //tips.setText("You have "+var1.size()+" packages !");
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
        Log.e("mama","You have "+var1.size()+" packages !");
        if (Intrinsics.areEqual(((MaMaQueryBarcodeResponseBean)var1.get(0)).getStatusCode(), "45")) {
            //ToastSoundUtil.baoGuoYiChuToast("快递已签收出库");
            MainActivity.this.onError(2,"快递已签收出库");
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
                               // tips.setText(((MaMaQueryBarcodeResponseBean)var1.get(0)).getWaybillNo()+" out lib success!!");
                                Log.e("mama","MainActivity You have  packages !");
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
                                    //tips.append(var23.toString());
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
    private void kuaibaoOutLib(KuaiBaoDeliveryStorageBean var2) {
        OkhttpManager.kuaibaoDeliveryStorageApi((KuaiBaoDeliveryStorageBean) var2, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(Object var1) {

                MixScanMamager.OkhttpCallbackStationManager var2 = MainActivity.this;
                if (var2 != null) {
                    var2.onOkhttpOutLibrarySuccess(ExpressStationEnum.KUAIBAO, "出库成功");
                }
            }
        }));
    }

    private void kuaibaoUnpack(String barcode) {
        KuaiBaoQueryBillcodeInforBean var12 = new KuaiBaoQueryBillcodeInforBean();
        var12.setData(JsonUtil.getJsonStringByGson(new KuaiBaoQueryBillcodeInforBean.BillcodeInforData("1", "1", barcode, "")));
        OkhttpManager.kuaibaoQueryBillcodeInforApi(var12, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
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
                    OkhttpManager.kuaibaoGetUserUnPickUpListsApi(var4, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
                        public final void onSuccess(KuaiBaoGetUserUnPickUpListsResponseBean var1xx) {
                            label66:
                            {
                                Exception var10000;
                                label65:
                                {
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
                                        label69:
                                        {
                                            ArrayList var13;
                                            Iterator var17;
                                            try {
                                                ArrayList var16 = (ArrayList) var12;
                                                var13 = new ArrayList();
                                                var17 = var16.iterator();
                                            } catch (Exception var9) {
                                                var10000 = var9;
                                                var10001 = false;
                                                break label69;
                                            }
                                            while (true) {
                                                try {
                                                    if (!var17.hasNext()) {
                                                        break;
                                                    }
                                                    KuaiBaoGetUserUnPickUpListsResponseBean.ResultBean var3 = (KuaiBaoGetUserUnPickUpListsResponseBean.ResultBean) var17.next();
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
                                                var18 = MainActivity.this;
                                            } catch (Exception var8) {
                                                var10000 = var8;
                                                var10001 = false;
                                                break label69;
                                            }
                                            if (var18 == null) {
                                                break label66;
                                            }
                                            try {
                                                var18.onOkhttpMuchPackageShow((List) var13);
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
                            Map var20 = (Map) var19;
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
                            this.onSuccess((KuaiBaoGetUserUnPickUpListsResponseBean) var1xx);
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
                this.onSuccess((KuaiBaoQueryBillcodeInforResponseBean) var1x);
            }
        }));
    }

    public void stationHelperOutLib(String barcode) {
        StationHelperRequestChuKuBean chuKuBean = new StationHelperRequestChuKuBean(
                RqFilePreference.getInstance().getStationHelperLoginInfor().getUserId(),
                barcode);
        OkhttpManager.stationHelperUploadOutLibrary(RqFilePreference.getInstance().getStationHelperLoginInfor().getAuthorication(), chuKuBean, new OkhttpManager.OnOkhttpCallback() {
            @Override
            public void onSuccess(Object p0) {
                if (p0 instanceof StationHelperResponseChuKuBean) {
                    StationHelperResponseChuKuBean stationHelperResponseChuKuBean = (StationHelperResponseChuKuBean) p0;
                    Log.e(com.rq.net.LoginActivity.TAG, "result getErrMsg:" + stationHelperResponseChuKuBean.getErrMsg() + "/getRetCode:" + stationHelperResponseChuKuBean.getRetCode()
                            + "/getExpressPackInfo:" + stationHelperResponseChuKuBean.getExpressPackInfo().toString() + "/getMergeOutExpressInfoLst().size"
                            + stationHelperResponseChuKuBean.getMergeOutExpressInfoLst().size());
                    ToastSoundUtil.scanSuccessToast(barcode + " out lib success!");
                } else {
                    ToastSoundUtil.wrongSoundToast(barcode + " return data format error!");
                }
            }
        });
    }

    public void stationHelperQuery(String barcode) {
        StationHelperRequestBean queryBean = new StationHelperRequestBean(
                RqFilePreference.getInstance().getStationHelperLoginInfor().getUserId(),
                RqFilePreference.getInstance().getStationHelperLoginInfor().getPhoneNum());
        OkhttpManager.stationHelperBarCode(RqFilePreference.getInstance().getStationHelperLoginInfor().getAuthorication(), queryBean, new OkhttpManager.OnOkhttpCallback() {
            @Override
            public void onSuccess(Object p0) {
                if (p0 instanceof StationHelperResponseBarcodeBean) {
                    StationHelperResponseBarcodeBean stationHelperResponseBean = (StationHelperResponseBarcodeBean) p0;
                    Log.e(com.rq.net.LoginActivity.TAG, "result getErrMsg:" + stationHelperResponseBean.getErrMsg() + "/getRetCode:" + stationHelperResponseBean.getRetCode()
                            + "/getExpressPackInfo:" + stationHelperResponseBean.getExpressPackLst().toString() + "/getMergeOutExpressInfoLst().size");
                    ToastSoundUtil.scanSuccessToast(barcode + " out query success!");
                }
            }
        });
    }

    public void laiquQuery(String barcode) {
        LaiquOutLibraryBean var25 = new LaiquOutLibraryBean();
        var25.setBillCode(barcode);
        OkhttpManager.laiquOutLibrary(var25, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(LaiquOutLibraryResponseBean var1) {
                if (var1 != null) {
                    Exception var10000;
                    label92:
                    {
                        boolean var10001;
                        label87:
                        {
                            MixScanMamager.OkhttpCallbackStationManager var2 = MainActivity.this;
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
                            label94:
                            {
                                Iterator var16;
                                ArrayList var24;
                                try {
                                    //BaseActivity var22 = (BaseActivity)var20;
                                    Object var3 = var1.getGoodsList().get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var3, "data.goodsList[0]");
                                    String var21 = ((LaiquOutLibraryResponseBean.GoodsListBean) var3).getBillCode();
                                    Object var4 = var1.getGoodsList().get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var4, "data.goodsList[0]");
                                    String var25 = ((LaiquOutLibraryResponseBean.GoodsListBean) var4).getExpressCompanyCode();
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
                                while (true) {
                                    try {
                                        if (!var16.hasNext()) {
                                            break;
                                        }
                                        LaiquOutLibraryResponseBean.WaybillsRelatedBean var23 = (LaiquOutLibraryResponseBean.WaybillsRelatedBean) var16.next();
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
                                    var17 = MainActivity.this;
                                } catch (Exception var9) {
                                    var10000 = var9;
                                    var10001 = false;
                                    break label94;
                                }
                                if (var17 == null) {
                                    return;
                                }
                                try {
                                    var17.onOkhttpMuchPackageShow((List) var24);
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
                this.onSuccess((LaiquOutLibraryResponseBean) var1);
            }
        }));
    }

    public void laiquOutLib(String barcode) {
        LaiquOutLibraryBean var25 = new LaiquOutLibraryBean();
        var25.setBillCode(barcode);
        OkhttpManager.laiquOutLibrary(var25, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(LaiquOutLibraryResponseBean var1) {
                if (var1 != null) {
                    Exception var10000;
                    label92:
                    {
                        boolean var10001;
                        label87:
                        {
                            MixScanMamager.OkhttpCallbackStationManager var2 = MainActivity.this;
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
                            label94:
                            {
                                Iterator var16;
                                ArrayList var24;
                                try {
                                    //BaseActivity var22 = (BaseActivity)var20;
                                    Object var3 = var1.getGoodsList().get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var3, "data.goodsList[0]");
                                    String var21 = ((LaiquOutLibraryResponseBean.GoodsListBean) var3).getBillCode();
                                    Object var4 = var1.getGoodsList().get(0);
                                    ////Intrinsics.checkExpressionValueIsNotNull(var4, "data.goodsList[0]");
                                    String var25 = ((LaiquOutLibraryResponseBean.GoodsListBean) var4).getExpressCompanyCode();
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
                                while (true) {
                                    try {
                                        if (!var16.hasNext()) {
                                            break;
                                        }
                                        LaiquOutLibraryResponseBean.WaybillsRelatedBean var23 = (LaiquOutLibraryResponseBean.WaybillsRelatedBean) var16.next();
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
                                    var17 = MainActivity.this;
                                } catch (Exception var9) {
                                    var10000 = var9;
                                    var10001 = false;
                                    break label94;
                                }
                                if (var17 == null) {
                                    return;
                                }
                                try {
                                    var17.onOkhttpMuchPackageShow((List) var24);
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
                this.onSuccess((LaiquOutLibraryResponseBean) var1);
            }
        }));
    }

    /*=============================kuaidichaoshi===========================*/
    private KDCSCheckResponseBean kdcsCheckResponseBean = null;
    private KDCSQueryStaffAndStoreResponseBean staffAndStore;
    private KDCSQueryStaffAndStoreResponseBean storeResponseBean;

    private void tuxikdcsQueryAndOutLib(String barcode, boolean queryOnly) {
        ////Intrinsics.checkExpressionValueIsNotNull(var16, "RqFilePreference.getInstance()");
        KDCSQueryStaffAndStoreResponseBean var18 = RqFilePreference.getInstance().getKDCSQueryStaffAndStore();
        if (var18 != null && StringUtil.isNotEmpty(var18.getDepotCode())) {
            KDCSCheckOutLibraryBillCodeInforBean var11 = new KDCSCheckOutLibraryBillCodeInforBean();
            var11.setBillCode(barcode);
            var11.setDepotCode(var18.getDepotCode());
            var11.setCompanyCode((String) null);
            OkhttpManager.kdcsCheckGatwwayBillcodeInfor(var11, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
                public final void onSuccess(KDCSCheckResponseBean var1x) {
                    if (var1x != null) {
                        ArrayList var2 = new ArrayList();
                        Iterator var3;
                        KDCSCheckResponseBean.Items var4;
                        ShowMuchPackageNoPickBean var5;
                        if (var1x.getItems() != null && var1x.getItems().size() > 0) {
                            var3 = var1x.getItems().iterator();
                            while (var3.hasNext()) {
                                var4 = (KDCSCheckResponseBean.Items) var3.next();
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
                            while (var3.hasNext()) {
                                var4 = (KDCSCheckResponseBean.Items) var3.next();
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
                            MixScanMamager.OkhttpCallbackStationManager var6 = MainActivity.this;
                            if (var6 != null) {
                                var6.onOkhttpMuchPackageShow((List) var2);
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
                    this.onSuccess((KDCSCheckResponseBean) var1x);
                }
            }));
        }
    }

    public void tuxikdcsOutLibOnly(KDCSCheckResponseBean var2) {
        Exception var10000;
        boolean var10001;
        if (var2 != null) {
            label190:
            {
                KDCSCheckResponseBean var41;
                try {
                    var41 = (KDCSCheckResponseBean) var2;
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
                    OkhttpManager.kdcsOutLibrary(var28, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
                        public final void onSuccess(Object var1) {
                            MixScanMamager.OkhttpCallbackStationManager var2 = MainActivity.this;
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
    private void jituOutLib(String barcode) {
        JiTuResponse var2 = RqFilePreference.getInstance().getJiTuLoginResponseInfor();
        if (var2 == null) {
            Log.e(LoginActivity.TAG, "jituOutLib  JiTuResponse is null, return");
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
        OkhttpManager.JiTuOutlibrary(var7.getToken(), (List) var3, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
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
                this.onSuccess((JiTuOutLibraryResponse) var1);
            }
        }));
    }

    private void courSmailPoleOutLib(final String barcode) {
        String account = RqFilePreference.getInstance().getCourierSmallPoleLoginforAccount();
        String password = RqFilePreference.getInstance().getCourierSmallPoleLoginforPassword();
        OkhttpManager.couriersmallpoleOutLib(account, password, barcode, new OkhttpManager.OnOkhttpCallback() {
            @Override
            public void onSuccess(Object p0) {
                if (p0 instanceof JsonObject) {
                    com.alibaba.fastjson.JSONObject courSmallPoleOutLibBean = com.alibaba.fastjson.JSONObject.parseObject(p0.toString());
                    com.alibaba.fastjson.JSONObject dataPackage = courSmallPoleOutLibBean.getJSONObject("data").getJSONObject("other_package");
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

    private final void yizhanxiaobiandaOutLib(String barcode) {
        final StageLoginRequestBean loginResponseBean = RqFilePreference.getInstance().getStagePoleLoginInfor();
        if (loginResponseBean == null) {
            return;
        }
        final StageLoginRequestBean.DataBean data = loginResponseBean.getData();
        OkhttpManager.stagesmallpoleChuKu1(data.getToken(), barcode, new OkhttpManager.OnOkhttpCallback() {
            @Override
            public void onSuccess(Object p0) {
                if (p0 instanceof SatgeChuKu1) {
                    SatgeChuKu1 satgeChuKu1 = (SatgeChuKu1) p0;
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
            var11 = Md5InputStream.md5((InputStream) (new ByteArrayInputStream(var12)));
            Map var13 = (Map) (new HashMap());
            var13.put("bizData", var9);
            var13.put("timestamp", String.valueOf(var4));
            var13.put("accountName", /*ApiPandaHarvestActvity.Companion.getAccountName()*/"YP75838571");
            var13.put("apiName", "OUTPUT_PARCEL");
            var13.put("token", token);
            ////Intrinsics.checkExpressionValueIsNotNull(var11, "md5Str");
            var13.put("sign", var11);
            OkhttpManager.pandaHarvestOutLib(var13, (OkhttpManager.OnOkhttpCallback) (new OkhttpManager.OnOkhttpCallback() {
                public final void onSuccess(PandaOutLibCall var1) {
                    PandaOutData var3 = (PandaOutData) JSON.parseObject(var1.getD(), PandaOutData.class);
                    CurrentParcel var2x = var3.getCurrentParcel();
                    if (var2x == null) {
                        return;
                    }
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            MixScanMamager.OkhttpCallbackStationManager var2x = MainActivity.this;
                            if (var2x != null) {
                                var2x.onOkhttpOutLibrarySuccess(ExpressStationEnum.PANDAHARVEST, "出库成功");
                            }
                        }
                    }).start();
                }

                // $FF: synthetic method
                // $FF: bridge method
                public void onSuccess(Object var1) {
                    this.onSuccess((PandaOutLibCall) var1);
                }
            }));
        }
    }
    private void moxiOutLib(String barcode){
        OkhttpMoxiManager.outLib(barcode, new OkhttpMoxiManager.OkhttpCallback() {
            @Override
            public void onError(int var1, String var2) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("wwww","-----onError-----"+var2);
                        MainActivity.this.onError(2,var2);
                    }
                });
            }

            @Override
            public void onSuccess(String var1) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("wwww","-----onSuccess-----"+var1);
                        MainActivity.this.onSuccess(var1);
                    }
                });
            }
        });
    }

    public void yishoufaOutLib(final String var) {
        /*OkhttpManager.yShouFaQuerySendOrder(var, OkhttpManager.YIXIAODIAN_TOKEN, (OkhttpManager.OnOkhttpCallback)(new OkhttpManager.OnOkhttpCallback() {
            public final void onSuccess(QuerySendOrderResponseBean var1x) {
                if (var1x.getTotal() >= 1) {
                    Object var2 = var1x.getData().get(0);
                    if (var2 == null) {
                        // //Intrinsics.throwNpe();
                    }

                    OkhttpManager.yShouFaGetNeedPayment(((QuerySendOrderDataResponseBean)var2).getOrderId(), OkhttpManager.YIXIAODIAN_TOKEN, null);
                }

            }

            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1x) {
                this.onSuccess((QuerySendOrderResponseBean)var1x);
            }
        }));*/
        OkhttpManager.yiXiaoDianBatchsignOrder(var, "", MainActivity.this);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
//        Intent mIntent = new Intent(Intent.ACTION_MAIN);
//        mIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        mIntent.addCategory(Intent.CATEGORY_HOME);
//        startActivity(mIntent);
       // finish();
    }

    @Override
    public void onLoginSuccess(ExpressStationEnum var1, String var2) {

    }

    @Override
    public void onOkhttpError(int var1, String var2) {

        ToastSoundUtil.wrongSoundToast("onOkhttpError:" + var1 + " msg:" + var2);
    }

    @Override
    public void onOkhttpMuchPackageShow(List var1) {

        StringBuffer stringBuffer = new StringBuffer();
        if (MyApplication.getStationEnum() == ExpressStationEnum.DUODUOYIZHAN) {
            if (var1.size() > 0) {
                //tips.setText("包裹:\n\r");
                for (Object v : var1) {
                    if (v instanceof ShowMuchPackageNoPickBean) {
                        ShowMuchPackageNoPickBean bean = (ShowMuchPackageNoPickBean) v;
                        stringBuffer.append(bean.getBarcode() + "\t");
                        stringBuffer.append(bean.getPhone() + "\t");
                        stringBuffer.append(bean.getPickUpCode() + "\t");
                        stringBuffer.append(bean.getReceviePerson() + "\t");
                        stringBuffer.append(bean.getInStorageTime() + "\n\r");
                    }
                }
                //tips.setText(stringBuffer.toString());
            } else {
                //tips.setText("无包裹:\n\r");
            }
        }
        Log.e(LoginActivity.TAG, "onOkhttpError station=" + var1 + " var2:" + stringBuffer.toString());
    }

    @Override
    public void onOkhttpOutLibrarySuccess(ExpressStationEnum var1, String var2) {
       // Log.e("wxw_出库", "onOkhttpOutLibrarySuccess-----"+var2);
    }

    @Override
    public void onError(int p0, String p1) {
        if (isSingle) {
            Log.e("wxw_出库失败", "---" + p0 + "----" + p1);
            handler.removeMessages(NORESULT);
            Message msg = new Message();
            msg.what = NOTLIBRARY;
            msg.obj = p1;
            handler.sendMessage(msg);//异步操作需要handler来改变UI
            handler.sendEmptyMessageDelayed(NORESULT, 4000);
        } else {
            multiResult(false);
        }

    }

    @Override
    public void onSuccess(Object p0) {
        if (isSingle) {
            Log.e("wxw_出库成功", "onSuccess-----" + p0);
            handler.removeMessages(NORESULT);
            handler.sendEmptyMessage(CHUKUING);//异步操作需要handler来改变UI
            handler.sendEmptyMessageDelayed(NORESULT, 4000);
        } else {
            multiResult(true);
        }

    }
    int errorTimes=0;
    private void multiResult(boolean isSuccess) {

        if (isSuccess) {
            Log.e("wxw_出库成功", "onSuccess-----");
            handler.removeMessages(NORESULT);
            handler.sendEmptyMessage(CHUKUING);//异步操作需要handler来改变UI
            handler.sendEmptyMessageDelayed(NORESULT, 4000);
            errorTimes=0;
        } else {
            errorTimes++;
            if (errorTimes == multiList.size()) {
                Log.e("wxw_出库失败", "onError---");
                handler.removeMessages(NORESULT);
                Message msg = new Message();
                msg.what = NOTLIBRARY;
                msg.obj = "出库失败";
                handler.sendMessage(msg);//异步操作需要handler来改变UI
                handler.sendEmptyMessageDelayed(NORESULT, 4000);
                errorTimes=0;
            }
        }
    }


    //丰巢出库方法
    public void postRequest(String ticket) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json;charset=utf-8");
        JSONObject json = new JSONObject();
        try {
            //json.put("fetchCode", "A-5-2021");
            json.put("apparatusNo", Settings.Secure.getString(getApplicationContext().getContentResolver(), "android_id"));
            json.put("expressNo", ticket);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        StringBuilder url = new StringBuilder("https://open.fcbox.com/openapi/express/checkStatusAndSignV2");
        String appkey = "T8gwWM19nR";
        String appSecret = "WNcptGdtr17A1qjZ-urDQuNn5dUkwceM";
        String signMethod = "md5";
        if (System.currentTimeMillis() - time_token >1200000) {
            token = getToken(appkey, appSecret);
        }
        Map<String,String> commonRequest = createCommonRequest(appkey, token,signMethod,signMap);
        String sign = SecurityUtil.signTopRequest(commonRequest,appSecret,signMethod);
        commonRequest.put("sign",sign);
        String commparameter = getPathByMap(commonRequest);
        url.append("?").append(commparameter);
        Log.e("wwwww","----"+url.toString());
        RequestBody requestBody = RequestBody.create(JSON,String.valueOf(json));
        Request request = new Request.Builder()
                .url(url.toString())
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //DialogUtils.showPopMsgInHandleThread(Release_Fragment.this.getContext(), mHandler, "数据获取失败，请重新尝试！");
                if (isSingle) {
                    handler.removeMessages(NORESULT);
                    Message msg = new Message();
                    msg.what = NOTLIBRARY;
                    msg.obj = "出库失败";
                    handler.sendMessage(msg);//异步操作需要handler来改变UI
                    handler.sendEmptyMessageDelayed(NORESULT, 4000);
                } else {
                    multiResult(false);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("wwww_onResponse",string+"");
                try {
                    JSONObject json = new JSONObject(string);

                    if (json.optString("engDesc").equals("success")) {
                        if (isSingle) {
                            Log.e("wxw_出库成功", "onSuccess-----" + json.optString("detail"));
                            handler.removeMessages(NORESULT);
                            handler.sendEmptyMessage(CHUKUING);//异步操作需要handler来改变UI
                            handler.sendEmptyMessageDelayed(NORESULT, 4000);
                        } else {
                            multiResult(true);
                        }
                    } else {
                        if (isSingle) {
                            handler.removeMessages(NORESULT);
                            Message msg = new Message();
                            msg.what = NOTLIBRARY;
                            msg.obj = json.optString("chnDesc");
                            handler.sendMessage(msg);//异步操作需要handler来改变UI
                            handler.sendEmptyMessageDelayed(NORESULT, 4000);
                        } else {
                            multiResult(false);
                        }
                    }
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_launcher);
                    if (bitmapDecode != null && ticket == codeDecode) {
                        postRequestSignImage(ticket,base64String(bitmapDecode),base64String(bitmap));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public void postRequestSignImage(String expressNo,String signImageBase64,String signOffImageBase64) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json;charset=utf-8");
        JSONObject json = new JSONObject();
        try {
            //json.put("fetchCode", "A-5-2021");
            json.put("expressNo", expressNo);
            json.put("signImageBase64", signImageBase64);
            json.put("signOffImageBase64", signOffImageBase64);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        StringBuilder url = new StringBuilder("https://open.fcbox.com/openapi/express/signCallBack");
        String appkey = "T8gwWM19nR";
        String appSecret = "WNcptGdtr17A1qjZ-urDQuNn5dUkwceM";
        String signMethod = "md5";
        if (System.currentTimeMillis() - time_token >1200000) {
            token = getToken(appkey, appSecret);
        }
        Map<String,String> commonRequest = createCommonRequest(appkey, token,signMethod,signMap);
        String sign = SecurityUtil.signTopRequest(commonRequest,appSecret,signMethod);
        commonRequest.put("sign",sign);
        String commparameter = getPathByMap(commonRequest);
        url.append("?").append(commparameter);
        Log.e("wwwww","----"+url.toString());
        RequestBody requestBody = RequestBody.create(JSON,String.valueOf(json));
        Request request = new Request.Builder()
                .url(url.toString())
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("wwww_onFailure","");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("wwww_onResponse",string+"");
            }
        });
    }
    private void createFactoryResetPwdDialog() {

        mFactRstPwsCheckDialog = new Dialog(this,R.style.dialog);
        //mFactRstPwsCheckDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mFactRstPwsCheckDialog.setCanceledOnTouchOutside(false);
        mFactRstPwsCheckDialog.setCancelable(false);
        mFactRstPwsCheckDialog.setContentView(R.layout.factory_rst_pwd_dialog);
        //  mFactRstPwsCheckDialog.setTitle("please input password:");
        pswEdit = (EditText)mFactRstPwsCheckDialog.findViewById(R.id.FactRstDialogPsw);
        pswEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (pswEdit.getText().toString().equals("654321")) {
                    mFactRstPwsCheckDialog.dismiss();
                    Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(intent);
                }
            }
        });
        cancelButton = (TextView)mFactRstPwsCheckDialog.findViewById(R.id.FactRstDialogCancel);
        okButton = (TextView)mFactRstPwsCheckDialog.findViewById(R.id.FactRstDialogCertain);
        cancelButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View source)
            {
                mFactRstPwsCheckDialog.dismiss();//finish();
            }
        });
        okButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View source)
            {
                if(pswEdit.getText().toString().equals("654321")){
                    mFactRstPwsCheckDialog.dismiss();
                    Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(intent);
                }/*else if(pswEdit.getText().toString().equals("87654321")){
                    mFactRstPwsCheckDialog.dismiss();
                    Intent intent =new Intent();
                    ComponentName componentName = new ComponentName("com.android.launcher3","com.android.launcher3.Launcher");
                    intent.setComponent(componentName);
                    startActivity(intent);
                }*/else{
                    Toast.makeText(MainActivity.this, "密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                    pswEdit.setText("");
                }
            }
        });
        mFactRstPwsCheckDialog.show();
        pswEdit.setFocusable(true);
        pswEdit.setFocusableInTouchMode(true);
        pswEdit.findFocus();
        pswEdit.requestFocus();
        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pswEdit.setFocusable(true);
                pswEdit.setFocusableInTouchMode(true);
                pswEdit.requestFocus();
                InputMethodManager inputManager =
                        (InputMethodManager)pswEdit.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(pswEdit, 0);

            }
        },100);
    }
    private String base64String(Bitmap bitmap) {
        String string = null;
        ByteArrayOutputStream btString = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, btString);

        byte[] bytes = btString.toByteArray();

        string = new String(android.util.Base64.encodeToString(bytes, Base64.DEFAULT));

        return string;
    }

    private String getToken(String appkey, String appSecret) {
        String result = null;
        OkHttpClient okHttpClient = new OkHttpClient();
        //创建请求连接，url里面存放请求连接，get表示其实get请求
        StringBuilder sb = new StringBuilder("https://open.fcbox.com");
        sb.append("/openapi/oauth2/token?app_key=");
        sb.append(appkey).append("&app_secret=").append(appSecret);
        Request request = new
                Request.Builder().url(sb.toString()).get().build();
        try {
            //使用execute()方法执行请求
            Response response = okHttpClient.newCall(request).execute();
            //定义字符串接收请求信息
            final String string = response.body().string();
            Log.e("wwww","-----token----"+string);
            //要想与主UI交互需要使用runOnUiThread这个方法实现Runnable的抽象类，进行交互
            JSONObject jsonObject = new JSONObject(string);
            if(jsonObject != null){
                result = jsonObject.getString("access_token");
            }
            time_token = System.currentTimeMillis();
            Log.e("wwww","-----token----"+result);
            return result;
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            Log.e("wwww","-----token----"+e.toString());
            time_token = System.currentTimeMillis();
            return result;
        }
    }
    private Map createCommonRequest(String appKey,String token,String signMethod,Map<String, String> signMap){
        if(signMap == null){
            signMap = new HashMap<>();
        }
        signMap.put("app_key", appKey);
        signMap.put("access_token", token);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String timestamp = df.format(new Date());
        signMap.put("timestamp", timestamp);
        String random = new Random().nextInt(100) + "";
        signMap.put("random", random);
        signMap.put("sign_method", signMethod);
        return signMap;
    }
    private  String getPathByMap(Map<String,String> com){
        StringBuilder sb = new StringBuilder();
        int count =0;
        int size = com.size() -1;
        for(Map.Entry<String,String> entry :com.entrySet()){
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            if(count ++ != size){
                sb.append("&");
            }
        }
        return sb.toString();
    }
    String savePictured="";
    @Override
    public void savePictureState(Bitmap bitmap,String code) {
        Log.e("wwww","----条码到达-");
        Log.e("wwww","-----"+bitmap.toString()+"---code----"+code);
        bitmapDecode = bitmap;
        codeDecode = code;
        String path =getExternalFilesDir(null)+"/"+code+".jpg";


        Log.e("wwww","----条码到达-baocun人脸"+codeFace+"--解码-"+codeDecode);
        if (codeDecode.equals(codeFace) && !savePictured.equals(code)) {
            Log.e("wwww","----条码到达-baocun---保存中。。。。。。。。。。"+path);
            AdroidUtil.savePicture(bitmapFace,bitmapDecode,path);
            savePictured=code;
        }
    }

    @Override
    public void saveBitmapImage(Bitmap bitmap, String code) {
        Log.e("wwww","----人脸到达-");
        bitmapFace = bitmap;
        codeFace = code;
        String path =getExternalFilesDir(null)+"/"+code+".jpg";


        Log.e("wwww","----人脸到达-baocun人脸"+codeFace+"--解码-"+codeDecode);
        if (codeFace.equals(codeDecode) && !savePictured.equals(code)) {
            Log.e("wwww","----人脸到达-baocun---保存中。。。。。。。。。。"+path);
            AdroidUtil.savePicture(bitmapFace,bitmapDecode,path);
            savePictured=code;
        }
    }
}