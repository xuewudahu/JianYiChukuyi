package com.rq.net.util;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.graphics.Bitmap.CompressFormat;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.Layout.Alignment;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ImageSaveUtil {
    public static final String IMAGESAVEUTIL_SYNCHRONIZED = "imagesaveutil_synchronized";
    public static int PICTURE_COMPRESSION_RATIO;
    private static final String TAG = "ImageSaveUtil";
    private static ImageSaveUtil mImageSaveUtil;
    private Bitmap barcodeBitmap = null;
    private Bitmap faceBitmap = null;
    public boolean isUploadImage = false;
    private ImageSaveUtil.SavePictureByteCallback mSavaPictureByteCallback;
    private ImageSaveUtil.SavePictureByteCallback2 mSavaPictureByteCallback2;
    private ImageSaveUtil.SavePictureCallback mSavePictureCallback;
    public ThreadPoolExecutor threadPoolExecutor;

    public ImageSaveUtil() {
        this.threadPoolExecutor = new ThreadPoolExecutor(1, 5, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue());
    }

    private boolean deleteDir(String var1) {
        File var6 = new File(var1);
        boolean var3;
        StringBuilder var7;
        if (!var6.isDirectory()) {
            var3 = var6.delete();
            var7 = new StringBuilder();
            var7.append("删除文件: ");
            var7.append(var3);
            Log.d("ImageSaveUtil", var7.toString());
            return var3;
        } else {
            String[] var4 = var6.list();
            if (var4.length > 0) {
                for(int var2 = 0; var2 < var4.length; ++var2) {
                    StringBuilder var5 = new StringBuilder();
                    var5.append(var6.getPath());
                    var5.append("/");
                    var5.append(var4[var2]);
                    if (!this.deleteDir(var5.toString())) {
                        return false;
                    }
                }
            }

            var3 = var6.delete();
            var7 = new StringBuilder();
            var7.append("删除目录: ");
            var7.append(var3);
            Log.d("ImageSaveUtil", var7.toString());
            return var3;
        }
    }

    public static ImageSaveUtil getInstance() {
        synchronized("imagesaveutil_synchronized"){}

        Throwable var10000;
        boolean var10001;
        label122: {
            try {
                if (mImageSaveUtil == null) {
                    mImageSaveUtil = new ImageSaveUtil();
                }
            } catch (Throwable var12) {
                var10000 = var12;
                var10001 = false;
                break label122;
            }

            label119:
            try {
                ImageSaveUtil var13 = mImageSaveUtil;
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

    private Bitmap mergeBitmap(Bitmap var1, Bitmap var2) {
        synchronized(this){}

        Throwable var10000;
        label133: {
            boolean var10001;
            int var3;
            label126: {
                try {
                    if (var1.getHeight() > var2.getHeight()) {
                        var3 = var1.getHeight();
                        break label126;
                    }
                } catch (Throwable var17) {
                    var10000 = var17;
                    var10001 = false;
                    break label133;
                }

                try {
                    var3 = var2.getHeight();
                } catch (Throwable var16) {
                    var10000 = var16;
                    var10001 = false;
                    break label133;
                }
            }

            label117:
            try {
                Bitmap var4 = Bitmap.createBitmap(var1.getWidth() + var2.getWidth(), var3, var1.getConfig());
                Canvas var5 = new Canvas(var4);
                var5.drawBitmap(var1, new Matrix(), (Paint)null);
                var5.drawBitmap(var2, (float)var1.getWidth(), 0.0F, (Paint)null);
                return var4;
            } catch (Throwable var15) {
                var10000 = var15;
                var10001 = false;
                break label117;
            }
        }

        return null;
    }

    public static void writeImageToDisk(byte[] var0, String var1) {
        try {
            StringBuilder var2 = new StringBuilder();
            var2.append("writeImageToDisk====");
            var2.append(var0.length);
            var2.append("     ");
            var2.append(var1);
           // //XLog.e(var2.toString());
            FileOutputStream var4 = new FileOutputStream(new File(var1));
            BitmapFactory.decodeByteArray(var0, 0, var0.length).compress(CompressFormat.JPEG, PICTURE_COMPRESSION_RATIO, var4);
            var4.flush();
            var4.close();
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    public Bitmap addTextWatermark(Bitmap var1, String var2, int var3, int var4, float var5, float var6, boolean var7) {
        if (var1 != null && var2 != null) {
            Bitmap var8 = var1.copy(var1.getConfig(), true);
            Canvas var9 = new Canvas(var8);
            TextPaint var10 = new TextPaint();
            var10.setColor(-65536);
            var10.setTextSize((float)var3);
            var10.setAntiAlias(true);
            StaticLayout var11 = new StaticLayout(var2, var10, 800, Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
            var9.save();
            var9.translate(var5, var6);
            var11.draw(var9);
            var9.restore();
            if (var7 && !var1.isRecycled()) {
                var1.recycle();
            }

            return var8;
        } else {
            return null;
        }
    }

    public byte[] bitmapToBytes(Bitmap var1) {
        try {
            ByteArrayOutputStream var3 = new ByteArrayOutputStream();
            var1.compress(CompressFormat.JPEG, 50, var3);
            int var2 = var3.toByteArray().length;
            byte[] var5 = new byte[var2 + 1];
            System.arraycopy(var3.toByteArray(), 0, var5, 0, var2);
            var3.close();
            return var5;
        } catch (IOException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public byte[] bitmapToBytes(Bitmap var1, int var2) {
        try {
            ByteArrayOutputStream var3 = new ByteArrayOutputStream();
            var1.compress(CompressFormat.JPEG, var2, var3);
            var2 = var3.toByteArray().length;
            byte[] var5 = new byte[var2 + 1];
            System.arraycopy(var3.toByteArray(), 0, var5, 0, var2);
            var3.close();
            return var5;
        } catch (IOException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public void saveBarcodeAndFaceYuvImageAndText(int param1, byte[] param2, int param3, int param4, String param5, String param6, int param7) {
        // $FF: Couldn't be decompiled
    }

    public File saveBitmapFile(byte[] var1, String var2) {
        Bitmap var5 = BitmapFactory.decodeByteArray(var1, 0, var1.length);
        File var6 = new File(var2);
        File var3 = var6.getParentFile();

        try {
            if (!var3.exists()) {
                var3.mkdirs();
            }

            if (!var6.exists()) {
                var6.createNewFile();
            }

            if (!var6.isFile()) {
                var6.createNewFile();
            }

            BufferedOutputStream var7 = new BufferedOutputStream(new FileOutputStream(var6));
            var5.compress(CompressFormat.JPEG, 100, var7);
            var7.flush();
            var7.close();
            return var6;
        } catch (IOException var4) {
            var4.printStackTrace();
            return var6;
        }
    }

    public void saveBitmapToFile(Bitmap var1, String var2, int var3) {
        File var4 = new File(var2);
        Object var5 = null;
        FileOutputStream var51 = null;

        Exception var58 = null;
        label273: {
            Throwable var10000;
            label268: {
                IOException var59;
                label267: {
                    boolean var10001;
                    FileOutputStream var57;
                    label274: {
                        FileOutputStream var50;
                        Exception var56;
                        label275: {
                            label264: {
                                try {
                                    try {
                                        var57 = new FileOutputStream(var4);
                                        break label264;
                                    } catch (Exception var48) {
                                        var56 = var48;
                                    }
                                } catch (Throwable var49) {
                                    var10000 = var49;
                                    var10001 = false;
                                    break label268;
                                }

                                var50 = (FileOutputStream)var5;
                                break label275;
                            }

                            Exception var53;
                            try {
                                var1.compress(CompressFormat.JPEG, var3, var57);
                                var57.flush();
                                break label274;
                            } catch (Exception var46) {
                                var53 = var46;
                            } finally {
                                ;
                            }

                            var50 = var57;
                            var56 = var53;
                        }

                        var51 = var50;

                        try {
                            var56.printStackTrace();
                        } catch (Throwable var45) {
                            var10000 = var45;
                            var10001 = false;
                            break label268;
                        }

                        try {
                            var50.close();
                            return;
                        } catch (IOException var41) {
                            var59 = var41;
                            var10001 = false;
                            break label267;
                        } catch (Exception var42) {
                            var58 = var42;
                            var10001 = false;
                            break label273;
                        }
                    }

                    try {
                        var57.close();
                        return;
                    } catch (IOException var43) {
                        var59 = var43;
                        var10001 = false;
                    } catch (Exception var44) {
                        var58 = var44;
                        var10001 = false;
                        break label273;
                    }
                }

                IOException var55 = var59;
                var55.printStackTrace();
                return;
            }

            Throwable var52 = var10000;

            try {
                var51.close();
            } catch (IOException var39) {
                var39.printStackTrace();
            } catch (Exception var40) {
                var40.printStackTrace();
            }


        }

        Exception var54 = var58;
        var54.printStackTrace();
    }

    public void saveYuvImageAndText(byte[] var1, int var2, int var3, String var4, String var5, int var6) {
        try {
            YuvImage var7 = new YuvImage(var1, var6, var2, var3, (int[])null);
            ByteArrayOutputStream var9 = new ByteArrayOutputStream();
            var7.compressToJpeg(new Rect(0, 0, var2, var3), PICTURE_COMPRESSION_RATIO, var9);
            Bitmap var10 = BitmapFactory.decodeByteArray(var9.toByteArray(), 0, var9.toByteArray().length);
            if (this.mSavePictureCallback != null) {
                this.mSavePictureCallback.onGetPictureBitmap(var10);
            }

            if (this.mSavaPictureByteCallback != null) {
                this.mSavaPictureByteCallback.onGetPictureByte(var9.toByteArray());
            }

            this.saveBitmapToFile(this.addTextWatermark(var10, var5, 50, Color.RED, 50.0F, 40.0F, true), var4, PICTURE_COMPRESSION_RATIO);
            var9.flush();
            var9.close();
        } catch (IOException var8) {
            var8.printStackTrace();
        }
    }

    public void setSavePictureByteCallback(ImageSaveUtil.SavePictureByteCallback var1) {
        this.mSavaPictureByteCallback = var1;
    }

    public void setSavePictureByteCallback2(ImageSaveUtil.SavePictureByteCallback2 var1) {
        this.mSavaPictureByteCallback2 = var1;
    }

    public void setSavePictureCallback(ImageSaveUtil.SavePictureCallback var1) {
        this.mSavePictureCallback = var1;
    }

    public void writeImage(byte[] var1, int var2, int var3, String var4) {
        try {
            File var7 = new File(var4);
            if (!var7.getParentFile().exists()) {
                var7.getParentFile().mkdirs();
            }

            FileOutputStream var8 = new FileOutputStream(var7);
            (new YuvImage(var1, 17, var2, var3, (int[])null)).compressToJpeg(new Rect(0, 0, var2, var3), PICTURE_COMPRESSION_RATIO, var8);
            var8.close();
        } catch (FileNotFoundException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        }
    }

    public Bitmap yuvImageToBitmapText(byte[] var1, int var2, int var3, String var4, int var5) {
        try {
            YuvImage var6 = new YuvImage(var1, var5, var2, var3, (int[])null);
            ByteArrayOutputStream var8 = new ByteArrayOutputStream();
            var6.compressToJpeg(new Rect(0, 0, var2, var3), PICTURE_COMPRESSION_RATIO, var8);
            Bitmap var9 = this.addTextWatermark(BitmapFactory.decodeByteArray(var8.toByteArray(), 0, var8.size()), var4, 50, Color.RED, 50.0F, 40.0F, true);
            var8.flush();
            var8.close();
            return var9;
        } catch (IOException var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public interface SavePictureByteCallback {
        void onGetPictureByte(byte[] var1);
    }

    public interface SavePictureByteCallback2 {
        void onGetBarcodeByteAndFaceByte(byte[] var1, byte[] var2);
    }

    public interface SavePictureCallback {
        void onGetPictureBitmap(Bitmap var1);
    }
}
