package com.kuaidihelp.posthouse.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


import com.rq.camera.FrameSaver;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class AdroidUtil {

    /**
     * 设置状态栏为透明
     * @param activity
     */
    @TargetApi(19)
    public static void setTranslucentStatus(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = activity.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }



    /**
     * 储存空间的百分比数
     * @return  返回的储存空间的百分比数
     */
    public static long getSpace() {
        StatFs state = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long blockSize = state.getBlockSize();
        long blockCount = state.getBlockCount();
        long availableCount = state.getAvailableBlocks();
        long totalSpace = blockCount * blockSize / 1024;       /* 存储空间大小 in KB */
        long freeSpace = availableCount * blockSize*100 / 1024;    /* 可用的存储空间大小 in KB */
        return freeSpace/totalSpace;
    }


    /**
     * 图片添加水印
     * @param context
     * @param bitmap bitmap文件
     * @param text 文字内容
     * @param size 文字大小
     * @param color 文字颜色
     * @return  返回的bitmap文件
     */
    public static Bitmap drawTextToCenter(Context context, Bitmap bitmap, String text, int size, int color) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setTextSize(dp2px(context, size));
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        return drawTextToBitmap(context, bitmap, text, paint, bounds,
                (bitmap.getWidth() - bounds.width()) / 2,
                (bitmap.getHeight() + bounds.height()) / 5*4);
    }
    private static Bitmap drawTextToBitmap(Context context, Bitmap bitmap, String text, Paint paint, Rect bounds, int paddingLeft, int paddingTop) {
        Bitmap.Config bitmapConfig = bitmap.getConfig();

        paint.setDither(true); // 获取跟清晰的图像采样
        paint.setFilterBitmap(true);// 过滤一些
        if (bitmapConfig == null) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }
        bitmap = bitmap.copy(bitmapConfig, true);
        Canvas canvas = new Canvas(bitmap);

        canvas.drawText(text, paddingLeft, paddingTop, paint);
        return bitmap;
    }
    public static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }


    /**
     * 保存bitmap文件
     * @param bitmap  bitmap文件
     * @param path 保存文件的地址
     * @return  保存是否成功
     */
    public static Boolean rgbSave(Bitmap bitmap, String path) {
        Log.e("wwwwwww", "开始保存图片");
        boolean isSuccess=false;
        File imageFile = new File(path);
        Log.e("wxw_w","--"+bitmap.toString());
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(imageFile));
            bitmap.compress(Bitmap.CompressFormat.JPEG, FrameSaver.QUALITY, bos);
            bos.flush();
            bos.close();
            bitmap.recycle();
            isSuccess=true;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                    bos = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bitmap != null) {
                bitmap.recycle();
            }
            imageFile = null;
        }
        Log.e("wwwwwww", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~结束保存图片");
        return isSuccess;
    }

    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }


    public static byte[] getImage(String picturepath) throws Exception {
        URL url = new URL(picturepath);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();// 基于http协议的连接对象
        conn.setConnectTimeout(10000);// 10秒；
        conn.setRequestMethod("GET");// 大写
        if (conn.getResponseCode() == 200) {
            InputStream ins = conn.getInputStream();
            return read(ins);
        }
        return null;
    }

        public static byte[] read(InputStream ins) throws Exception {
            ByteArrayOutputStream outstream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = ins.read(buffer)) > -1) {
                outstream.write(buffer, 0, length);
            }
            outstream.close();
            return outstream.toByteArray();
        }

    public static boolean isConnectedToInternet(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isAvailable();
    }

    public static Bitmap compositePicture(Bitmap firstBitmap, Bitmap secondBitmap) {
        Bitmap bitmap = Bitmap.createBitmap(firstBitmap.getWidth(), firstBitmap
                .getHeight(), firstBitmap.getConfig());
        //生成画布
        Canvas canvas = new Canvas(bitmap);
        //因为我传入的secondBitmap的大小是不固定的，所以我要将传来的secondBitmap调整到和画布一样的大小
        canvas.drawBitmap(firstBitmap, 0, 0, null);
        canvas.drawBitmap(secondBitmap, 0, 0, null);

        return bitmap;

    }
    public static Bitmap setImgSize(Bitmap bm, int newWidth ,int newHeight){
        // 获得图片的宽高.
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 计算缩放比例.
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数.
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片.
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }
    public static Bitmap adjustPhotoRotation(Bitmap bm, final int orientationDegree)
    {

        Matrix m = new Matrix();
        m.setRotate(orientationDegree, (float) bm.getWidth() / 2, (float) bm.getHeight() / 2);

        try {
            Bitmap bm1 = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), m, true);

            return bm1;

        } catch (OutOfMemoryError ex) {
        }
        return null;

    }
    public static void savePicture(Bitmap bitmap_face, Bitmap bitmap_decode,String path1) {
        new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                Log.e("wxwww1","---"+System.currentTimeMillis());
                Bitmap bitmap_face1 = setImgSize(bitmap_face, 480, 640);

                Bitmap bitmap_face2 = adjustPhotoRotation(bitmap_face1, 270);
                Bitmap bitmap_decode2 = adjustPhotoRotation(bitmap_decode, 180);

                Bitmap bitmap1 = Bitmap.createBitmap(
                        bitmap_decode2.getWidth(),
                        bitmap_decode2.getHeight(),
                        bitmap_decode2.getConfig()
                );

                Canvas canvas = new Canvas(bitmap1);
                canvas.drawBitmap(bitmap_decode2, 0, 0, null);
                canvas.drawBitmap(bitmap_face2, bitmap_decode2.getWidth() - bitmap_face2.getWidth() - 64, 64, null);
                Log.e("wxwww2","---"+System.currentTimeMillis());
                rgbSave(bitmap1, path1);
                Log.e("wxwww3","---"+System.currentTimeMillis());
            }
        }).start();
    }



}
