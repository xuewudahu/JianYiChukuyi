package com.rq.net.manager;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.rq.net.MyApplication;
import com.kuaidihelp.posthouse.R.raw;
import java.util.HashMap;
import java.util.Map;

public class SoundManager {
    private static final int AGEING_TEST_OVER = 16;
    private static final int BAOGUO_YICHANG = 17;
    private static final int BARCODE_CHECK_ERROR = 14;
    public static final int BARCODE_NO_INLIBRARY = 7;
    public static final int BARCODE_OUTLIBRARYED = 6;
    public static final int FACE_CAMERA_ERROR = 9;
    private static final int FAHUO_SUCCESS = 13;
    private static final int GUIHUAN_SUCCESS = 15;
    private static final int INLIBRARY_ERROR = 11;
    private static final int INLIBRARY_NORMAL = 10;
    public static final int OUT_LIBRARY_FAIL = 5;
    public static final int PACKAGE_NOT_DELIVERED = 2;
    public static final int QUERY_NO_BARCODE = 8;
    public static final int REPEAT_SCAN_ABNORMAL = 4;
    public static final int SCAN_NORMAL = 3;
    public static final int SCAN_SUCCESS = 1;
    private static final int TEL_IS_EMPTY = 12;
    private static SoundManager soundManager;
    private SoundPool sp;
    private Map<Integer, Integer> spMap = new HashMap();

    private SoundManager() {
        this.initSoundPool();
    }

    public static SoundManager getInstance() {
        if (soundManager == null) {
            soundManager = new SoundManager();
        }

        return soundManager;
    }

    private void playSound(int var1) {
        if (MyApplication.baseApp != null) {
            AudioManager var3 = (AudioManager) MyApplication.baseApp.getSystemService(Context.AUDIO_SERVICE);
            float var2 = (float) var3.getStreamMaxVolume(3);
            var2 = (float) var3.getStreamVolume(3) / var2;
            this.sp.play((Integer) this.spMap.get(var1), var2, var2, 1, 0, 1.0F);
        }
    }

    public void initSoundPool() {
        try {
            this.sp = new SoundPool(2, 3, 0);
            this.spMap.put(1, this.sp.load(MyApplication.baseApp, raw.play_video_out_libray, 1));
            this.spMap.put(2, this.sp.load(MyApplication.baseApp, raw.package_not_delivered, 1));
            this.spMap.put(3, this.sp.load(MyApplication.baseApp, raw.scan_normal, 1));
            this.spMap.put(4, this.sp.load(MyApplication.baseApp, raw.repeat_scan_abnormal, 1));
            this.spMap.put(5, this.sp.load(MyApplication.baseApp, raw.outlibrary_fail, 1));
            this.spMap.put(6, this.sp.load(MyApplication.baseApp, raw.barcode_outlibraryed, 1));
            this.spMap.put(7, this.sp.load(MyApplication.baseApp, raw.barcode_no_inlibrary, 1));
            this.spMap.put(8, this.sp.load(MyApplication.baseApp, raw.query_no_barcode, 1));
            this.spMap.put(9, this.sp.load(MyApplication.baseApp, raw.face_camera_error, 1));
            this.spMap.put(10, this.sp.load(MyApplication.baseApp, raw.inlibrary_success, 1));
            this.spMap.put(11, this.sp.load(MyApplication.baseApp, raw.inlibrary_error, 1));
            this.spMap.put(12, this.sp.load(MyApplication.baseApp, raw.phone_is_empty, 1));
            this.spMap.put(13, this.sp.load(MyApplication.baseApp, raw.fahuosuccess, 1));
            this.spMap.put(14, this.sp.load(MyApplication.baseApp, raw.barcode_error, 1));
            this.spMap.put(15, this.sp.load(MyApplication.baseApp, raw.guihuan_success, 1));
            this.spMap.put(16, this.sp.load(MyApplication.baseApp, raw.ageing_test_over, 1));
            this.spMap.put(17, this.sp.load(MyApplication.baseApp, raw.baoguoyichang, 1));
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }

    public void playAgeingTestOver() {
        this.playSound(16);
    }

    public void playBaoGuoYiChangSound() {
        this.playSound(17);
    }

    public void playBarcodeCheckErrorSound() {
        this.playSound(14);
    }

    public void playErrorGetTelSound() {
        this.playSound(12);
    }

    public void playErrorSound() {
        this.playSound(4);
    }

    public void playFaceCameraError() {
        this.playSound(9);
    }

    public void playGuiHuanSuccessSound() {
        this.playSound(15);
    }

    public void playInLibraryErrorSound() {
        this.playSound(11);
    }

    public void playInLibrarySuccessSound() {
        this.playSound(10);
    }

    public void playNoInLibrary() {
        this.playSound(7);
    }

    public void playOutLibraryError() {
        this.playSound(5);
    }

    public void playOutLibraryed() {
        this.playSound(6);
    }

    public void playPackageNotDelivered() {
        this.playSound(2);
    }

    public void playQueryNoBarcode() {
        this.playSound(8);
    }

    public void playScanSound() {
        this.playSound(3);
    }

    public void playSuccessOutGoodSound() {
        this.playSound(13);
    }

    public void playSuccessOutLibrarySound() {
        this.playSound(1);
    }

    public void release() {
        SoundPool var1 = this.sp;
        if (var1 != null) {
            var1.release();
        }

    }
}