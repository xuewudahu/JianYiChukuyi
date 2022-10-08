package com.rq.net.util;


import android.widget.Toast;

import com.rq.net.MyApplication;
import com.rq.net.manager.SoundManager;

public class ToastSoundUtil {
    public ToastSoundUtil() {
    }

    public static void baoGuoYiChangToast(String var0) {
        if (!StringUtil.isEmpty(var0)) {
            if (MyApplication.baseApp == null) {
                return;
            }

/*            Toast.makeText(MyApplication.baseApp, var0, Toast.LENGTH_LONG).show();
            SoundManager.getInstance().playBaoGuoYiChangSound();*/
        }

    }

    public static void baoGuoYiChuToast(String var0) {
        if (!StringUtil.isEmpty(var0)) {
            if (MyApplication.baseApp == null) {
                return;
            }

/*            Toast.makeText(MyApplication.baseApp, var0, Toast.LENGTH_LONG).show();
            SoundManager.getInstance().playOutLibraryed();*/
        }

    }

    public static void displayToast(String var0) {
        if (!StringUtil.isEmpty(var0)) {
            if (MyApplication.baseApp == null) {
                return;
            }

            //Toast.makeText(MyApplication.baseApp, var0, Toast.LENGTH_LONG).show();
        }

    }

    public static void scanSuccessToast(String var0) {
        if (!StringUtil.isEmpty(var0)) {
            if (MyApplication.baseApp == null) {
                return;
            }

/*            Toast.makeText(MyApplication.baseApp, var0, Toast.LENGTH_LONG).show();
            SoundManager.getInstance().playSuccessOutLibrarySound();*/
        }

    }

    public static void wrongInlibrarySoundToast(String var0) {
        if (!StringUtil.isEmpty(var0)) {
            if (MyApplication.baseApp == null) {
                return;
            }

/*            Toast.makeText(MyApplication.baseApp, var0, Toast.LENGTH_LONG).show();
            SoundManager.getInstance().playInLibraryErrorSound();*/
        }

    }

    public static void wrongSoundToast(String var0) {
        if (!StringUtil.isEmpty(var0)) {
            if (MyApplication.baseApp == null) {
                return;
            }

/*            Toast.makeText(MyApplication.baseApp, var0, Toast.LENGTH_LONG).show();
            SoundManager.getInstance().playErrorSound();*/
        }

    }

    public static void wrongTelIsEmptyToast(String var0) {
        if (!StringUtil.isEmpty(var0)) {
            if (MyApplication.baseApp == null) {
                return;
            }

/*            Toast.makeText(MyApplication.baseApp, var0, Toast.LENGTH_LONG).show();
            SoundManager.getInstance().playErrorGetTelSound();*/
        }

    }
}