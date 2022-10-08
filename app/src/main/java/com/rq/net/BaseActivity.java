package com.rq.net;

import java.io.*;
import androidx.appcompat.app.*;
import android.content.*;
import android.util.*;
import java.util.*;
import android.os.*;
import androidx.core.content.*;
import android.view.*;

import com.rq.net.bean.ScanBarcodeBean;
import com.rq.net.bean.ScanBarcodeBeanIn;
import com.rq.net.manager.FragmentViewManager;
import com.rq.net.manager.LitePalManager;
import com.rq.net.setting.CommonFilePreference;
import com.rq.net.setting.RqFilePreference;
import com.rq.net.util.DateUtil;
import com.rq.net.util.ExpressStationEnum;
import com.rq.net.util.FileUtil;
import com.rq.net.util.StringUtil;
import com.rq.net.util.SystemUtil;
import com.rq.net.util.ToastSoundUtil;

import java.text.*;
import java.net.*;

public abstract class BaseActivity extends AppCompatActivity
{
    private static final String TAG = "BaseActivity";
    public static int startActivityCount;
    public List<String> advertPicList;
    //protected BarcodeCameraView barcodeCameraView;
    public int barcodeEmptyCount;
    public final int cacheCount;
    private BaseActivity context;
    public String currentWeiht;
    int delCount;
    //protected FaceCameraView faceCameraView;
    public int heightPixels;
    public boolean isOutlibrarySuccess;
    public Boolean isShowMuchPackage;
    public boolean isUplaodPicture;
    public Boolean loginSuccess;
    protected String mBarcode;
    protected String mBarcodePhotoName;
    protected String mFacePhotoName;
    FragmentViewManager mFragmentManager;
    protected Handler mHandler;
    protected List<String> oldBarcodeList;
    public String picPath;
    protected byte[] saveBarcodeFrame;
    protected int selectExpressFlag;
    public OnSettingCallback settingCallback;
    public Boolean startScan;
    Timer timer;
    Date today;
    protected int todayScanCount;
    public int widthPixels;
    
    public BaseActivity() {
        this.context = this;
        this.mFragmentManager = null;
        this.mBarcode = null;
        this.mBarcodePhotoName = "";
        this.mFacePhotoName = "";
        this.selectExpressFlag = ExpressStationEnum.OTHER.getCode();
        this.oldBarcodeList = new ArrayList<String>();
        this.mHandler = new Handler();
        final Boolean value = false;
        this.isOutlibrarySuccess = false;
        this.cacheCount = 3;
        this.currentWeiht = "";
        this.todayScanCount = 0;
        this.isUplaodPicture = false;
        this.barcodeEmptyCount = 0;
        this.advertPicList = new ArrayList<String>();
        this.startScan = value;
        this.picPath = "";
        this.isShowMuchPackage = true;
        this.loginSuccess = value;
        this.settingCallback = null;
        this.timer = new Timer();
        this.delCount = 0;
        this.today = new Date();
    }
    
    private List<String> deleteEmptyDirectory(final List<String> list) {
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            final String s = iterator.next();
            final StringBuilder sb = new StringBuilder();
            sb.append(RqService.savePath);
            sb.append(s);
            final File file = new File(sb.toString());
            if (file.isDirectory() && Objects.requireNonNull(file.listFiles()).length < 1) {
                file.delete();
                iterator.remove();
            }
        }
        return list;
    }
    
    private void getDisplayPixels() {
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.widthPixels = displayMetrics.widthPixels;
        this.heightPixels = displayMetrics.heightPixels;
    }
    
    private void getTodayScanCount() {
        if (!StringUtil.isEmpty(CommonFilePreference.getInstance().getTodayDate()) && DateUtil.getToday().equals(CommonFilePreference.getInstance().getTodayDate())) {
            this.todayScanCount = CommonFilePreference.getInstance().getTodayScanCount();
            return;
        }
        CommonFilePreference.getInstance().setTodayDate(DateUtil.getToday());
        CommonFilePreference.getInstance().setTodayScanCount(0);
        CommonFilePreference.getInstance().setDeviceRunTime(0L);
    }
    
    private List<String> removeLatelyThirtyDay(final List<String> list) {
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            final String s = iterator.next();
            final StringBuilder sb = new StringBuilder();
            sb.append(RqService.savePath);
            sb.append(s);
            final File file = new File(sb.toString());
            final long lastModified = file.lastModified();
            final Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(lastModified);
            final Date time = instance.getTime();
            if (file.isDirectory() && DateUtil.getDistDates(this.today, time) <= 20L) {
                iterator.remove();
            }
        }
        return list;
    }
    
    private String savePic(final String photoPathName) {
        final String currentDateTime = DateUtil.getCurrentDateTime();
        final StringBuilder sb = new StringBuilder();
        sb.append("\u5355\u53f7:");
        sb.append(this.mBarcodePhotoName);
        sb.append("\r\n\u91cd\u91cf:");
        sb.append(this.currentWeiht);
        sb.append("kg\r\n\u65f6\u95f4:");
        sb.append(currentDateTime);
        final String string = sb.toString();
        if (!FileUtil.isFolderExist(RqService.savePathDay)) {
            ToastSoundUtil.wrongSoundToast("\u627e\u4e0d\u5230\u4fdd\u5b58\u56fe\u7247\u7684\u76ee\u5f55");
        }
        /*if (MVIDCameraManager.getInstance().hikBarcodeCameraRunning) {
            MVIDCameraManager.getInstance().saveBarcodeImage(this.saveBarcodeFrame, photoPathName, string);
        }
        else {
            final BarcodeCameraView barcodeCameraView = this.barcodeCameraView;
            if (barcodeCameraView != null && barcodeCameraView.getCoboAidlService() != null && this.barcodeCameraView.getCobaBarcodeCamera() != null) {
                this.barcodeCameraView.saveBarcodeImage(photoPathName, string);
            }
        }
        final FaceCameraView faceCameraView = this.faceCameraView;
        if (faceCameraView != null) {
            faceCameraView.setImageText(string);
            this.faceCameraView.setPhotoPathName(photoPathName);
            this.faceCameraView.setSaveFaceImageStatus(true);
        }*/
        return photoPathName;
    }
    
    private void timeCalibration(final String s) {
        if (Math.abs(DateUtil.getMilliseByDateTimeFormat(s) - System.currentTimeMillis()) > 3600000L) {
            this.runOnUiThread((Runnable)new Runnable() {
                @Override
                public void run() {
                    final AlertDialog.Builder builder = new AlertDialog.Builder((Context)BaseActivity.this);
                    builder.setTitle((CharSequence)"\u8b66\u544a\u63d0\u793a");
                    builder.setMessage((CharSequence)"\u68c0\u6d4b\u5230\u8bbe\u5907\u7684\u65f6\u95f4\u6709\u5f02\u5e38,\u8bf7\u70b9\u51fb\u4fee\u590d\u65f6\u95f4\uff01");
                    builder.setPositiveButton((CharSequence)"\u786e\u5b9a", new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialogInterface, final int n) {
                            BaseActivity.this.startActivity(new Intent("android.settings.DATE_SETTINGS"));
                        }
                    });
                    builder.show();
                }
            });
        }
    }
    
    protected void changDataState(final String s, final int n) {
        try {
            ScanBarcodeBean scanBarcodeBean;
            //if ((scanBarcodeBean = LitePalManager.findFirstByConditions(ScanBarcodeBean.class, "barcode = ? and outState = ?", s, "0")) == null) {
            scanBarcodeBean = new ScanBarcodeBean();
            //}
            scanBarcodeBean.setBarcode(s);
            scanBarcodeBean.setWeight(this.currentWeiht);
            scanBarcodeBean.setLength(0);
            scanBarcodeBean.setHeight(0);
            scanBarcodeBean.setWidth(0);
            final StringBuilder sb = new StringBuilder();
            sb.append(RqService.savePathDay);
            sb.append(s);
            sb.append("_out.jpg");
            scanBarcodeBean.setImageBarcodePath(sb.toString());
            scanBarcodeBean.setImageFacePath("");
            scanBarcodeBean.setImageName(s);
            scanBarcodeBean.setOutState(n);
            //scanBarcodeBean.setBackOne(BarcodeRegexManager.getInstance().checkRuleBarcodeToExpress(s));
            scanBarcodeBean.setDateTime(DateUtil.getCurrentDateTime());
            if (n == 0) {
                scanBarcodeBean.setOutCount(scanBarcodeBean.getOutCount() + 1);
            }
            if (scanBarcodeBean.getOutCount() >= 12) {
                scanBarcodeBean.setOutState(1);
            }
            else {
                scanBarcodeBean.setOutState(n);
            }
            scanBarcodeBean.setBackTwo(ExpressStationEnum.getName(CommonFilePreference.getInstance().getSelectExpressSystemFlag()));
            ////LitePalManager.saveOrUpdate(scanBarcodeBean, "barcode = ?", s);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void checkDiskSpaceToDelete7Photo() {
        try {
            final long freeDiskSpace = SystemUtil.getFreeDiskSpace();
            final StringBuilder sb = new StringBuilder();
            sb.append("checkDiskSpaceToDelete7Photo: ==");
            sb.append(freeDiskSpace);
            Log.e("BaseActivity", sb.toString());
            if (freeDiskSpace < 2000L) {
                final AlertDialog.Builder setTitle = new AlertDialog.Builder((Context)this).setTitle((CharSequence)"\u5220\u9664\u56fe\u7247");
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("\u5b58\u50a8\u7a7a\u95f4\u4e0d\u8db3,\u70b9\u51fb\u786e\u5b9a\u5c06\u5220\u9664\u8fd120\u5929\u4ee5\u5916\u7684\u6240\u6709\u6570\u636e,\u91ca\u653e\u5b58\u50a8\u7a7a\u95f4!\n\u5269\u4f59\u7a7a\u95f4 ");
                sb2.append(freeDiskSpace);
                sb2.append(" M");
                setTitle.setMessage((CharSequence)sb2.toString()).setCancelable(false)/*.setIcon(2131624029)*/.setPositiveButton((CharSequence)"\u786e\u5b9a", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                final StringBuilder sb = new StringBuilder();
                                sb.append(Environment.getExternalStorageDirectory().getPath());
                                sb.append("/cobaAi/pic");
                                final List<String> dirNameList = FileUtil.getDirNameList(sb.toString());
                                dirNameList.remove(DateUtil.getToday());
                                final List access$100 = BaseActivity.this.removeLatelyThirtyDay(BaseActivity.this.deleteEmptyDirectory(dirNameList));
                                if (access$100.size() == 0) {
                                    return;
                                }
                                Looper.prepare();
                                BaseActivity.this.deleteFileTask(access$100);
                                Looper.loop();
                            }
                        }).start();
                    }
                }).setNegativeButton((CharSequence)"\u53d6\u6d88", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                    }
                }).create().show();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void checkSystemTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                BaseActivity.this.visitDateURL("https://www.taobao.com/");
            }
        }).start();
    }
    
    protected void clearBarcodeList() {
        try {
            this.oldBarcodeList.clear();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void closeCamera() {
        /*final BarcodeCameraView barcodeCameraView = this.barcodeCameraView;
        if (barcodeCameraView != null) {
            barcodeCameraView.closeBarcodeCamera();
            this.barcodeCameraView = null;
        }
        final FaceCameraView faceCameraView = this.faceCameraView;
        if (faceCameraView != null) {
            faceCameraView.closeFaceCamera();
            this.faceCameraView = null;
        }*/
    }
    
    public void deleteFileTask(final List<String> list) {
        /*final DeleteFileDialog deleteFileDialog = new DeleteFileDialog((Context)this.context, list.size());
        deleteFileDialog.show();
        deleteFileDialog.onBtCallBack((Function0<Unit>)new Function0<Unit>() {
            public Unit invoke() {
                Log.d("BaseActivity", "invoke: ========================");
                AppUtil.INSTANCE.closApp();
                return null;
            }
        });*/
        try {
            this.timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Log.d("BaseActivity", "run: ============================1===");
                    for (final String s : list) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append(RqService.savePath);
                        sb.append(s);
                        final String string = sb.toString();
                        if (new File(string).exists()) {
                            FileUtil.deleteAllFile(string);
                        }
                        else {
                            Log.d("BaseActivity", "run: ============================2===");
                            final BaseActivity this$0 = BaseActivity.this;
                            ++this$0.delCount;
                            //deleteFileDialog.setDeleteLoadProgress(BaseActivity.this.delCount);
                        }
                        if (list.size() == BaseActivity.this.delCount) {
                            Log.d("BaseActivity", "run: ============================3===");
                            BaseActivity.this.runOnUiThread((Runnable)new Runnable() {
                                @Override
                                public void run() {
                                    ToastSoundUtil.displayToast("\u5220\u9664\u5b8c\u6210");
                                }
                            });
                            BaseActivity.this.timer.cancel();
                        }
                    }
                }
            }, 500L, 2000L);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            this.timer.cancel();
        }
    }
    
    public void deleteHistoryData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final String dateTimeFromMillis = DateUtil.getDateTimeFromMillis(DateUtil.getZeroOtherDayMillise(-90));
                    //LitePalManager.deleteByConditions(ScanBarcodeBean.class, "dateTime <= ?", dateTimeFromMillis);
                    //LitePalManager.deleteByConditions(ScanBarcodeBeanIn.class, "dateTime <= ?", dateTimeFromMillis);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
    
    public void onBackPressed() {
        final Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//268435456
        intent.addCategory("android.intent.category.HOME");
        this.startActivity(intent);
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.getSupportActionBar().hide();
        final Window window = this.getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        //window.setStatusBarColor(ContextCompat.getColor((Context)this, 2131099723));
        this.getDisplayPixels();
        this.selectExpressFlag = CommonFilePreference.getInstance().getSelectExpressSystemFlag();
        final StringBuilder sb = new StringBuilder();
        sb.append("selectExpressFlag:");
        sb.append(this.selectExpressFlag);
        Log.d("BaseActivity", sb.toString());
        if (this.selectExpressFlag <= 0) {
            this.selectExpressFlag = ExpressStationEnum.OTHER.getCode();
        }
        this.getTodayScanCount();
    }
    
    protected void onDestroy() {
        final Handler mHandler = this.mHandler;
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages((Object)null);
        }
        this.closeCamera();
        super.onDestroy();
    }
    
    protected void onStart() {
        super.onStart();
        ++BaseActivity.startActivityCount;
    }
    
    protected void onStop() {
        super.onStop();
        --BaseActivity.startActivityCount;
        CommonFilePreference.getInstance().setTodayScanCount(this.todayScanCount);
        Log.d("BaseActivity", "onStop: =================");
    }
    
    protected void saveData(final String s) {
        try {
            if (false/*LitePalManager.findFirstByConditions(ScanBarcodeBean.class, "barcode = ? and uploadStatus = ?", s, "1") != null*/) {
                return;
            }
            final String currentDateTime = DateUtil.getCurrentDateTime();
            final ScanBarcodeBean scanBarcodeBean = new ScanBarcodeBean();
            scanBarcodeBean.setBarcode(s);
            scanBarcodeBean.setWeight(this.currentWeiht);
            scanBarcodeBean.setLength(0);
            scanBarcodeBean.setHeight(0);
            scanBarcodeBean.setWidth(0);
            final StringBuilder sb = new StringBuilder();
            sb.append(RqService.savePathDay);
            sb.append(s);
            sb.append("_out.jpg");
            scanBarcodeBean.setImageBarcodePath(sb.toString());
            scanBarcodeBean.setImageFacePath("");
            scanBarcodeBean.setImageName(s);
            scanBarcodeBean.setDateTime(currentDateTime);
            //scanBarcodeBean.setBackOne(BarcodeRegexManager.getInstance().checkRuleBarcodeToExpress(s));
            ////LitePalManager.saveOrUpdate(scanBarcodeBean, "barcode = ?", s);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void saveData(final String s, String currentDateTime, final String backTwo, final String remarks) {
        try {
            if (false/*LitePalManager.findFirstByConditions(ScanBarcodeBean.class, "barcode = ? and uploadStatus = ?", s, "1") != null*/) {
                return;
            }
            String checkRuleBarcodeToExpress = currentDateTime;
           /* if (StringUtil.isEmpty(currentDateTime)) {
                checkRuleBarcodeToExpress = BarcodeRegexManager.getInstance().checkRuleBarcodeToExpress(s);
            }*/
            currentDateTime = DateUtil.getCurrentDateTime();
            final ScanBarcodeBean scanBarcodeBean = new ScanBarcodeBean();
            scanBarcodeBean.setBarcode(s);
            scanBarcodeBean.setWeight(this.currentWeiht);
            scanBarcodeBean.setLength(0);
            scanBarcodeBean.setHeight(0);
            scanBarcodeBean.setWidth(0);
            final StringBuilder sb = new StringBuilder();
            sb.append(RqService.savePathDay);
            sb.append(s);
            sb.append("_out.jpg");
            scanBarcodeBean.setImageBarcodePath(sb.toString());
            scanBarcodeBean.setImageFacePath("");
            scanBarcodeBean.setRemarks(remarks);
            scanBarcodeBean.setImageName(s);
            scanBarcodeBean.setDateTime(currentDateTime);
            scanBarcodeBean.setBackOne(checkRuleBarcodeToExpress);
            scanBarcodeBean.setBackTwo(backTwo);
            ////LitePalManager.saveOrUpdate(scanBarcodeBean, "barcode = ?", s);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    protected void saveDataIn(final String barcode) {
        try {
            if (false/*LitePalManager.findFirstByConditions(ScanBarcodeBeanIn.class, "barcode = ? and uploadStatus = ?", barcode, "1") != null*/) {
                return;
            }
            final String currentDateTime = DateUtil.getCurrentDateTime();
            final ScanBarcodeBeanIn scanBarcodeBeanIn = new ScanBarcodeBeanIn();
            scanBarcodeBeanIn.setBarcode(barcode);
            scanBarcodeBeanIn.setWeight(this.currentWeiht);
            scanBarcodeBeanIn.setLength(0);
            scanBarcodeBeanIn.setHeight(0);
            scanBarcodeBeanIn.setWidth(0);
            final StringBuilder sb = new StringBuilder();
            sb.append(RqService.savePathDay);
            sb.append(this.mBarcodePhotoName);
            sb.append("_in.jpg");
            scanBarcodeBeanIn.setImageBarcodePath(sb.toString());
            scanBarcodeBeanIn.setImageFacePath("");
            scanBarcodeBeanIn.setImageName(this.mBarcodePhotoName);
            scanBarcodeBeanIn.setDateTime(currentDateTime);
            //scanBarcodeBeanIn.setToDefault("inCode");
            scanBarcodeBeanIn.setBackTwo(ExpressStationEnum.getName(CommonFilePreference.getInstance().getSelectExpressSystemFlag()));
            ////LitePalManager.saveOrUpdate(scanBarcodeBeanIn, "barcode = ?", barcode);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public String savePicture() {
        String s;
        if (FileUtil.getStoragePath((Context)this, true) != null && RqFilePreference.getInstance().getExternalStorage()) {
            final StringBuilder sb = new StringBuilder();
            sb.append(FileUtil.getStoragePath((Context)this, true));
            sb.append("/Android/data/com.kuaidihelp.posthouse/");
            sb.append(DateUtil.getToday());
            sb.append("/");
            final String string = sb.toString();
            final File file = new File(string);
            if (!file.exists()) {
                file.mkdirs();
            }
            RqService.savePathDay = string;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(this.mBarcodePhotoName);
            sb2.append("_out.jpg");
            s = sb2.toString();
        }
        else {
            if (!RqService.savePathDay.contains(DateUtil.getToday())) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(RqService.savePath);
                sb3.append(DateUtil.getToday());
                sb3.append("/");
                RqService.savePathDay = sb3.toString();
                final File file2 = new File(RqService.savePathDay);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(RqService.savePathDay);
            sb4.append(this.mBarcodePhotoName);
            sb4.append("_out.jpg");
            s = sb4.toString();
        }
        return this.savePic(s);
    }
    
    public String savePictureIn() {
        if (!RqService.savePathDay.contains(DateUtil.getToday())) {
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
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(RqService.savePathDay);
        sb2.append(this.mBarcodePhotoName);
        sb2.append("_in.jpg");
        final String string = sb2.toString();
        final String currentDateTime = DateUtil.getCurrentDateTime();
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("\u5355\u53f7:");
        sb3.append(this.mBarcodePhotoName);
        sb3.append("\r\n\u91cd\u91cf:");
        sb3.append(this.currentWeiht);
        sb3.append("kg\r\n\u65f6\u95f4:");
        sb3.append(currentDateTime);
        final String string2 = sb3.toString();
        if (!FileUtil.isFolderExist(RqService.savePathDay)) {
            ToastSoundUtil.wrongSoundToast("\u627e\u4e0d\u5230\u4fdd\u5b58\u56fe\u7247\u7684\u76ee\u5f55");
        }
        /*if (MVIDCameraManager.getInstance().hikBarcodeCameraRunning) {
            MVIDCameraManager.getInstance().saveBarcodeImage(this.saveBarcodeFrame, string, string2);
        }
        else {
            final BarcodeCameraView barcodeCameraView = this.barcodeCameraView;
            if (barcodeCameraView != null && barcodeCameraView.getCoboAidlService() != null && this.barcodeCameraView.getCobaBarcodeCamera() != null) {
                this.barcodeCameraView.saveBarcodeImage(string, string2);
            }
        }
        final FaceCameraView faceCameraView = this.faceCameraView;
        if (faceCameraView != null) {
            faceCameraView.setImageText(string2);
            this.faceCameraView.setPhotoPathName(string);
            this.faceCameraView.setSaveFaceImageStatus(true);
        }*/
        return string;
    }
    
    protected Class<?> seleteWebExpressStationActivity() {
        /*if (CommonFilePreference.getInstance().getMixSelectSystemType() > 0L) {
            return ApiMixOutLibraryActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.KUAIBAO.getCode()) {
            return ApiKuaiBaoActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.KUAIDICAOSHI.getCode()) {
            return ApiKDCSActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.MAMASTATION.getCode()) {
            return ApiMaMaActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.LAIQU.getCode()) {
            return ApiLaiquActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.XINIAO.getCode()) {
            return XiNiaoWebActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.DIYIBOX.getCode()) {
            return DiYiWebActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.YUNDAKDCS.getCode()) {
            return ApiYunDaKDCSActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.MIAOZHAN.getCode()) {
            return ApiMiaoZhanActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.FENGCHAOSERVICE.getCode()) {
            return ApiFengChaoServiceActvity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.XIAOBINGSTATION.getCode()) {
            return ApiXiaoBinActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.PANDAHARVEST.getCode()) {
            return ApiPandaHarvestActvity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.STATIONHELPER.getCode()) {
            return ApiStationHelperActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.COURIERSMALLPOLE.getCode()) {
            return CourierSmallPoleActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.BLUESHOP.getCode()) {
            return ApiBlueShopActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.STAGESMALLPOLE.getCode()) {
            return StageSmallPoleActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.JUSHUITAN.getCode()) {
            return ApiJuShuiTanActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.XINIAOGAOPAIYI.getCode()) {
            return ApiXiNiaoGaoPaiActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.NETMANAGER.getCode()) {
            return ApiNetManagerActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.JITU.getCode()) {
            return ApiJiTuActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.FENSHISHENGHUO.getCode()) {
            return ApiFSSHActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.MSWMS.getCode()) {
            return ApiSMWMSActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.JINLINBAOOCRJIEBO.getCode()) {
            return ApiJinLinBaoOCRJieBoActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.JINLINBAOQIANSHOU.getCode()) {
            return ApiJinLinBaoQianShouActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.JINLINBAOKUAIDIQUJIAN.getCode()) {
            return ApiJinLinBaoKuaiDiQuJianActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.JINLINBAOGAOPAIYI.getCode()) {
            return ApiJinLinBaoGaoPaiYiActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.HAOYUNLAI.getCode()) {
            return ApiHylActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.YSHOUFA.getCode()) {
            return ApiYshouFaActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.GUOGUOYIZHAN.getCode()) {
            return ApiGuoGuoYiZhanActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.XINGHUO.getCode()) {
            return ApiXingHuoActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.ZHONGYOUCHENGZHONG.getCode()) {
            return ApiZhongYouActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.SUDIYIGONGPEI.getCode()) {
            return ApiSdygpActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.YIXIAODIAN.getCode()) {
            return YiXiaoDianWebActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.ZYZT.getCode()) {
            return BgztWebActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.ZHONGYOUSTATION.getCode()) {
            return ApiZhongYouStationActivity.class;
        }
        if (this.selectExpressFlag == ExpressStationEnum.DUODUOYIZHAN.getCode()) {
            Log.d("BaseActivity", "seleteWebExpressStationActivity: ========================");
            return ApiDuoDuoActivity.class;
        }
        return BarcodeCameraActivity.class;*/
        return null;
    }
    
    void setOnSettingCallback(final OnSettingCallback settingCallback) {
        this.settingCallback = settingCallback;
    }
    
    public void setStatusBarColor(final int n) {
        //this.getWindow().setStatusBarColor(ContextCompat.getColor((Context)this, n));
    }
    
    public void startActivity(final Class clazz) {
        this.startActivity(new Intent((Context)this, clazz));
    }
    
    public String visitDateURL(String s) {
        String format;
        final String s2 = format = null;
        try {
            final URLConnection openConnection = new URL(s).openConnection();
            format = s2;
            openConnection.connect();
            format = s2;
            final Date date = new Date(openConnection.getDate());
            format = s2;
            s = (format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
            this.timeCalibration(s);
            return s;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return format;
        }
    }
    
    public interface OnSettingCallback
    {
        void onSetting();
    }
}
