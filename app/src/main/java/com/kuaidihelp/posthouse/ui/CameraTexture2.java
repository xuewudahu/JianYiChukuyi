package com.kuaidihelp.posthouse.ui;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import com.rq.barcode.RqEngineer;
import com.rq.misc.MiscUtil;

import java.io.File;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class CameraTexture2 extends TextureView implements  RqEngineer.Listener{
    private static final String TAG = "CameraPreview";
    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();//????????????????????????JPEG?????? ???????????????????????? ????????????
    private static final int MAX_PREVIEW_WIDTH = 1280;//Camera2 API ???????????????????????????
    private static final int MAX_PREVIEW_HEIGHT = 720;
    private static final int STATE_PREVIEW = 0;//??????????????????
    private static final int STATE_WAITING_LOCK = 1;//???????????????
    private static final int STATE_WAITING_PRE_CAPTURE = 2;//?????????
    private static final int STATE_WAITING_NON_PRE_CAPTURE = 3;//????????????
    private static final int STATE_PICTURE_TAKEN = 4;//????????????
    private int mState = STATE_PREVIEW;
    private int mRatioWidth = 0, mRatioHeight = 0;
    private int mSensorOrientation;
    private boolean mFlashSupported;
    private Semaphore mCameraOpenCloseLock = new Semaphore(1);//??????????????? Semaphore ???????????????????????????
    private Activity activity;
    private HandlerThread mBackgroundThread;
    private Handler mBackgroundHandler;
    private Size mPreviewSize;
    private String mCameraId;
    private CameraDevice mCameraDevice;
    private CaptureRequest.Builder mPreviewRequestBuilder;
    private CaptureRequest mPreviewRequest;
    private CameraCaptureSession mCaptureSession;
    private MediaRecorder mMediaRecorder;
    private Context mContext;
    private int fps;
    private Long time;
    private ImageReader mImageReader;
    public  Bitmap bitmapImage;
    public  Bitmap bitmapDecode;
    private String mFolderPath; //????????????,????????????????????????
    private RqEngineer mRqEngineer;
    private String orderId;
    private String arriveTime;
    private String parcelId;
    private String path1;
    private String arriveTime2;
    private String parcelId2;
    private String path2;
    private String arriveTime3;
    private String parcelId3;
    private String path3;
    private Bitmap bitmap_decode;
    static {
        ORIENTATIONS.append(Surface.ROTATION_90, 0);//0
        ORIENTATIONS.append(Surface.ROTATION_0, 90);//1
        ORIENTATIONS.append(Surface.ROTATION_180, 270);//2
        ORIENTATIONS.append(Surface.ROTATION_270, 180);//3
    }

    public CameraTexture2(Context context) {
        this(context, null);
    }

    public CameraTexture2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CameraTexture2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        MiscUtil.setListener(new MiscUtil.Listener() {
            @Override
            public void savePicture(Bitmap bitmap,String s) {
                bitmapDecode=bitmap;
                orderId=s;
            }
        });
         int width = getMeasuredWidth(); //
          int height = getMeasuredHeight(); //
/*        int width = 160;
        int height = 120;*/
        if (0 == mRatioWidth || 0 == mRatioHeight) {
            setMeasuredDimension(width, height);//?????????????????????????????????
        } else {
            if (width < height * mRatioWidth / mRatioHeight) {
                setMeasuredDimension(width, height);
            } else {
                // setMeasuredDimension(height * mRatioWidth / mRatioHeight, height);
                setMeasuredDimension(width, height);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void onResume(Activity activity) {
        mCode = " ";//????????????????????????????????????????????????????????????????????????????????????
        this.activity = activity;
        startBackgroundThread(); //???Activity???Fragment OnResume()???,?????????????????????????????????????????????,??????,??????Surface??????????????????
        if (this.isAvailable()) {
            openCamera(this.getWidth(), this.getHeight());
        } else {
            this.setSurfaceTextureListener(mSurfaceTextureListener);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("BROADCAST_ACTION");
        activity.registerReceiver(MyBroadcastReceiver, intentFilter);
        mRqEngineer = RqEngineer.getInstence(activity);
        mRqEngineer.setListenerFace(this);
    }

    private final BroadcastReceiver MyBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
           //Log.d("logcat_wwww","--------????????????????????????");
          lockFocus();
        }
    };

    public void onStop() {

        closeCamera();
        stopBackgroundThread();
        if (mMediaRecorder != null) {
            mMediaRecorder.release();
        }
    }



    public void setAspectRatio(int width, int height) {

        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Size can't be negative");
        }
        mRatioWidth = width;
        mRatioHeight = height;
        requestLayout();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setAutoFlash(CaptureRequest.Builder requestBuilder) {

        if (mFlashSupported) {
            requestBuilder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AE_MODE_ON_AUTO_FLASH);
        }
    }


    private void startBackgroundThread() {

        mBackgroundThread = new HandlerThread("CameraBackground");
        mBackgroundThread.start();
        mBackgroundHandler = new Handler(mBackgroundThread.getLooper());


    }

    /**
     * ??????preCapture???????????????????????????
     */
    private void runPreCaptureSequence() {
        try {
            // ????????????????????????
            mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER,
                    CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER_START);
            mState = STATE_WAITING_PRE_CAPTURE;
            mCaptureSession.capture(mPreviewRequestBuilder.build(), mCaptureCallback, mBackgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }


    private void stopBackgroundThread() {
        if (mBackgroundThread != null) {
            mBackgroundThread.quitSafely();
            try {
                mBackgroundThread.join();
                mBackgroundThread = null;
                mBackgroundHandler = null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     *
     */
    private final SurfaceTextureListener mSurfaceTextureListener = new SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture texture, int width, int height) {
            openCamera(width, height);
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture texture, int width, int height) {
            configureTransform(width, height);
        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture texture) {
            return true;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture texture) {

        }
    };
    /**
     * ????????????????????????
     */
    private final CameraDevice.StateCallback mStateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            mCameraOpenCloseLock.release();
            mCameraDevice = cameraDevice;
            createCameraPreviewSession();
        }

        @Override
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            mCameraOpenCloseLock.release();
            cameraDevice.close();
            mCameraDevice = null;
        }

        @Override
        public void onError(@NonNull CameraDevice cameraDevice, int error) {
            mCameraOpenCloseLock.release();
            cameraDevice.close();
            mCameraDevice = null;
            if (null != activity) {
                activity.finish();
            }
        }
    };
    /**
     * ??????????????????????????????????????????
     */
    private CameraCaptureSession.CaptureCallback mCaptureCallback = new CameraCaptureSession.CaptureCallback() {

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private void process(CaptureResult result) {
            switch (mState) {
                case STATE_PREVIEW://??????????????????
                    break;

                case STATE_WAITING_LOCK: {//???????????????
                    Integer afState = 4;

                    if (afState == null ) {
                        captureStillPicture();
                    } else if (CaptureResult.CONTROL_AF_STATE_FOCUSED_LOCKED == afState ||
                            CaptureResult.CONTROL_AF_STATE_NOT_FOCUSED_LOCKED == afState) {
                        Integer aeState = 2;

                        if (aeState == null || aeState == CaptureResult.CONTROL_AE_STATE_CONVERGED) {
                            mState = STATE_PICTURE_TAKEN;
                            captureStillPicture();
                        } else {
                            runPreCaptureSequence();
                        }
                    }
                    break;
                }
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onCaptureProgressed(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request,
                                        @NonNull CaptureResult partialResult) {
            process(partialResult);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onCaptureCompleted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request,
                                       @NonNull TotalCaptureResult result) {
            process(result);
            Face faces[]=result.get(CaptureResult.STATISTICS_FACES);



        }

    };


    /**
     * ????????????????????????????????????????????????
     *
     * @param viewWidth  ???
     * @param viewHeight ???
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void configureTransform(int viewWidth, int viewHeight) {
        if (null == mPreviewSize || null == activity) {
            return;
        }
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation()+1;//????????????????????????
        Matrix matrix = new Matrix();
        RectF viewRect = new RectF(0, 0, viewWidth, viewHeight);

        RectF bufferRect = new RectF(0, 0, mPreviewSize.getHeight(), mPreviewSize.getWidth());
        float centerX = viewRect.centerX();
        float centerY = viewRect.centerY();

        if (Surface.ROTATION_90 == rotation || Surface.ROTATION_270 == rotation) {
            bufferRect.offset(centerX - bufferRect.centerX(), centerY - bufferRect.centerY());
            matrix.setRectToRect(viewRect, bufferRect, Matrix.ScaleToFit.FILL);
            float scale = Math.max((float) viewHeight / mPreviewSize.getHeight(),
                    (float) viewWidth / mPreviewSize.getWidth());
            matrix.postScale(scale, scale, centerX, centerY);
            matrix.postRotate(90 * (rotation - 2), centerX, centerY);

        } else if (Surface.ROTATION_180 == rotation) {

            matrix.postRotate(180, centerX, centerY);
        }

        this.setTransform(matrix);
    }

    /**
     * ??????mCameraId????????????
     */

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void openCamera(int width, int height) {

        setUpCameraOutputs(width, height);
        configureTransform(width, height);
        CameraManager manager = (CameraManager) getContext().getSystemService(Context.CAMERA_SERVICE);
        try {

            if (mCameraOpenCloseLock.tryAcquire(2500, TimeUnit.MILLISECONDS)) {

                if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                manager.openCamera(mCameraId, mStateCallback, mBackgroundHandler);
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while trying to lock camera opening.", e);
        }
    }

    /**
     * ????????????
     */
    private void closeCamera() {

        try {
            mCameraOpenCloseLock.acquire();
            if (null != mCaptureSession) {
                mCaptureSession.close();
                mCaptureSession = null;
            }
            if (null != mCameraDevice) {
                mCameraDevice.close();
                mCameraDevice = null;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while trying to lock camera closing.", e);
        } finally {
            mCameraOpenCloseLock.release();
        }

    }


    /**
     * ????????????????????????????????????
     *
     * @param width  ????????????????????????????????????
     * @param height ????????????????????????????????????
     */
    @SuppressWarnings("SuspiciousNameCombination")
    public void setUpCameraOutputs(int width, int height) {

        CameraManager manager = (CameraManager) getContext().getSystemService(Context.CAMERA_SERVICE);
        try {
            for (String cameraId : manager.getCameraIdList()) {
                CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraId);
                //?????????????????????
                Integer facing = characteristics.get(CameraCharacteristics.LENS_FACING);
                Size cPixelSize = characteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);//???????????????????????????

                //Log.d("wxwII","----"+cPixelSize.getHeight()+"---"+cPixelSize.getWidth());
                if (facing != null && facing == CameraCharacteristics.LENS_FACING_FRONT) {
                    continue;//???????????????,?????????????????????
                }
                StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (map == null) {
                    continue;
                }
                //????????????????????????, ???????????????????????????
                Size largest = Collections.max(
                        Arrays.asList(map.getOutputSizes(ImageFormat.JPEG)),
                        new CompareSizesByArea()
                );
                //Log.e("wwwwwwwwwww","--"+largest.getWidth()+"----"+largest.getHeight());
                mImageReader = ImageReader.newInstance(largest.getWidth(), largest.getHeight(), ImageFormat.JPEG, 2);
                mImageReader.setOnImageAvailableListener(mOnImageAvailableListener, mBackgroundHandler);
                //???????????????????????????????????????????????????

                int displayRotation = activity.getWindowManager().getDefaultDisplay().getRotation();
                mSensorOrientation = characteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                //Log.e("qqq", "displayRotation:" + displayRotation + " mSensorOrientation: " + mSensorOrientation);
                boolean swappedDimensions = false;

                switch (displayRotation) {
                    case Surface.ROTATION_0://0
                    case Surface.ROTATION_180://2
                        //??????
                        if (mSensorOrientation == 90 || mSensorOrientation == 270) {
                            swappedDimensions = true;
                        }
                        break;
                    case Surface.ROTATION_90://1
                    case Surface.ROTATION_270://3
                        //??????
                        if (mSensorOrientation == 0 || mSensorOrientation == 180) {
                            swappedDimensions = true;
                        }
                        break;
                    default:
                        Log.e(TAG, "Display rotation is invalid: " + displayRotation);
                }

                Point displaySize = new Point();
                activity.getWindowManager().getDefaultDisplay().getSize(displaySize);
                int rotatedPreviewWidth = width;
                int rotatedPreviewHeight = height;
                int maxPreviewWidth = displaySize.x;
                int maxPreviewHeight = displaySize.y;

                if (swappedDimensions) {
                    rotatedPreviewWidth = height;
                    rotatedPreviewHeight = width;
                    maxPreviewWidth = displaySize.y;
                    maxPreviewHeight = displaySize.x;
                    Log.d("qqq", "rotatedPreviewWidth" + rotatedPreviewWidth + " " + rotatedPreviewHeight + " " + maxPreviewWidth + " " + maxPreviewHeight);
                }

                if (maxPreviewWidth > MAX_PREVIEW_WIDTH) {
                    maxPreviewWidth = MAX_PREVIEW_WIDTH;
                }

                if (maxPreviewHeight > MAX_PREVIEW_HEIGHT) {
                    maxPreviewHeight = MAX_PREVIEW_HEIGHT;
                }

                DisplayMetrics displayMetrics = new DisplayMetrics();
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int widthPixels = displayMetrics.widthPixels;
                int heightPixels = displayMetrics.heightPixels;

                //????????????????????????????????????????????????????????????????????????
                mPreviewSize = chooseOptimalSize(map.getOutputSizes(SurfaceTexture.class),
                        rotatedPreviewWidth, rotatedPreviewHeight, maxPreviewWidth,
                        maxPreviewHeight, largest);
                for (Size i : map.getOutputSizes(SurfaceTexture.class)) {
                    //Log.e("wwwwwww1","---"+i.getHeight()+"---"+i.getWidth());
                }
                int orientation = getResources().getConfiguration().orientation;
                if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setAspectRatio(1280, 720);
                } else {
                    setAspectRatio(1280, 720);
                }
                Boolean available = characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                mFlashSupported = available == null ? false : available;
                mCameraId = "1";
                mMediaRecorder = new MediaRecorder();
                return;
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
        }
    }

    /**
     * ???????????????????????????????????????
     *
     * @param choices           ???????????????????????????
     * @param textureViewWidth  ????????????
     * @param textureViewHeight ????????????
     * @param maxWidth          ???????????????????????????
     * @param maxHeight         ???????????????????????????
     * @param aspectRatio       ?????????
     * @return ??????????????????
     */
    private static Size chooseOptimalSize(Size[] choices, int textureViewWidth, int textureViewHeight, int maxWidth,
                                          int maxHeight, Size aspectRatio) {

        List<Size> bigEnough = new ArrayList<>();
        List<Size> notBigEnough = new ArrayList<>();
        int w = aspectRatio.getWidth();
        int h = aspectRatio.getHeight();
        for (Size option : choices) {
            if (option.getWidth() <= maxWidth && option.getHeight() <= maxHeight && option.getHeight() == option.getWidth() * h / w) {
                if (option.getWidth() >= textureViewWidth && option.getHeight() >= textureViewHeight) {
                    bigEnough.add(option);
                } else {
                    notBigEnough.add(option);
                }
            }
        }
        if (bigEnough.size() > 0) {
            return Collections.min(bigEnough, new CompareSizesByArea());
        } else if (notBigEnough.size() > 0) {
            return Collections.max(notBigEnough, new CompareSizesByArea());
        } else {
            return choices[0];
        }
    }


    int[] faceDetectModes;
    private int getFaceDetectMode(){
        if(faceDetectModes == null){
            return CaptureRequest.STATISTICS_FACE_DETECT_MODE_FULL;
        }else{
            return faceDetectModes[faceDetectModes.length-1];
        }
    }
    /**
     * ?????????????????????CameraCaptureSession
     */
    private void createCameraPreviewSession() {

        try {
            SurfaceTexture texture = this.getSurfaceTexture();
            assert texture != null; // ??????????????????????????????????????????????????????????????????
            //??????TextureView??????????????????
            texture.setDefaultBufferSize(1280, 720);
            //??????Surface??????????????????
            Surface surface = new Surface(texture);
            mPreviewRequestBuilder = mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
            mPreviewRequestBuilder.addTarget(surface); // ?????????????????? CameraCaptureSession ?????????????????????
            mCameraDevice.createCaptureSession(Arrays.asList(surface, mImageReader.getSurface()), new CameraCaptureSession.StateCallback() {//modified by xss
                @Override
                public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
                    if (null == mCameraDevice) {
                        return;
                    } // ?????????????????????????????????????????????
                    mCaptureSession = cameraCaptureSession;
                    try {
                        mPreviewRequestBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
                        mPreviewRequestBuilder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE,getFaceDetectMode());//????????????????????????
                        setAutoFlash(mPreviewRequestBuilder);
                        mPreviewRequest = mPreviewRequestBuilder.build();
                        time = System.currentTimeMillis();
                        mCaptureSession.setRepeatingRequest(mPreviewRequest, mCaptureCallback, mBackgroundHandler);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onConfigureFailed(
                        @NonNull CameraCaptureSession cameraCaptureSession) {
                }
            }, null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }


    /**
     * ??????????????????
     */
    private File getVideoFilePath() {

        return new File(activity.getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".mp4");
    }
    private String mCode;
    @Override
    public void savePictureState(Bitmap bitmap, String code) {
        if (mCode==null || !mCode.equals(code)) {
            mCode = code;
            lockFocus();
        }
    }

    /**
     * ??????????????????
     */
    private static class CompareSizesByArea implements Comparator<Size> {
        @Override
        public int compare(Size lhs, Size rhs) {
            return Long.signum((long) lhs.getWidth() * lhs.getHeight() - (long) rhs.getWidth() * rhs.getHeight());
        }
    }


    /**
     * ??????????????????????????????????????????
     *
     * @param path
     */
    public void setFolderPath(String path) {
        this.mFolderPath = path;
        File mFolder = new File(path);
        if (!mFolder.exists()) {
            mFolder.mkdirs();
            Log.d(TAG, "???????????????????????????");
        } else {
            Log.d(TAG, "??????????????????");
        }
    }

    public String getFolderPath() {
        return mFolderPath;
    }

    /**
     * ??????????????????,????????????????????????
     */
    private String getNowDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

    private void lockFocus() {

        //????????????
        try {
            if (mPreviewRequestBuilder != null) {

                mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER,
                        CameraMetadata.CONTROL_AF_TRIGGER_START);
            }
            mState = STATE_WAITING_LOCK;
            if (mCaptureSession != null) {

                mCaptureSession.capture(mPreviewRequestBuilder.build(), mCaptureCallback,
                        mBackgroundHandler);

            }

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }


    private ImageReader.OnImageAvailableListener mOnImageAvailableListener
            = new ImageReader.OnImageAvailableListener() {
        @Override
        public void onImageAvailable(ImageReader reader) {
            //???????????????????????????????????????????????????
            Image image = reader.acquireNextImage();
            ByteBuffer buffer = image.getPlanes()[0].getBuffer();
            byte[] bytes = new byte[buffer.capacity()];
            buffer.get(bytes);
            bitmapImage = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, null);
            mLinstenerBitmapImage.saveBitmapImage(bitmapImage,mCode);

 /*           Bitmap bitmap_face1=AdroidUtil.setImgSize(bitmapImage,480,640);
            Log.d("picture------2","--");
            Bitmap bitmap_face=AdroidUtil.adjustPhotoRotation(bitmap_face1,90);

            Log.d("picture------4","--");
            Bitmap bitmap1 = Bitmap.createBitmap(
                    bitmap_decode.getWidth(),
                    bitmap_decode.getHeight(),
                    bitmap_decode.getConfig()
            );
            Log.d("picture------5","--");
            Canvas canvas = new Canvas(bitmap1);
            canvas.drawBitmap(bitmap_decode, 0, 0, null);
            canvas.drawBitmap(bitmap_face, bitmap_decode.getWidth()-bitmap_face.getWidth()-64,64, null);

             path1 =mContext.getExternalFilesDir(null)+"/"+orderId+".jpg";
            Log.d("picture------6","--"+mContext.getExternalFilesDir(null)+"/"+path1);
            AdroidUtil.rgbSave(bitmap1, path1);

            if (bitmap1 != null) {
                bitmap1.recycle();
            }
            if (bitmap_decode != null) {
                bitmap_decode.recycle();
            }*/
//            if (bitmapImage != null) {
//                bitmapImage.recycle();
//            }
            image.close();
        }
    };

    private int getOrientation(int rotation) {
        return (ORIENTATIONS.get(rotation) + mSensorOrientation) % 360;
    }

    /**
     * ????????????
     */
    private void unlockFocus() {

        try {
            // ??????????????????
            mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER,
                    CameraMetadata.CONTROL_AF_TRIGGER_CANCEL);
            setAutoFlash(mPreviewRequestBuilder);
            mCaptureSession.capture(mPreviewRequestBuilder.build(), mCaptureCallback,
                    mBackgroundHandler);
            // ???????????????????????????????????????
            mState = STATE_PREVIEW;
            // ????????????????????????
            mCaptureSession.setRepeatingRequest(mPreviewRequest, mCaptureCallback,
                    mBackgroundHandler);

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * ?????????????????????
     */
    private void captureStillPicture() {

        try {
            if (null == mCameraDevice) {
                return;
            }
            // ???????????????????????????CaptureRequest.Builder???
            final CaptureRequest.Builder captureBuilder =
                    mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
            captureBuilder.addTarget(mImageReader.getSurface());

            // ???????????????AE???AF?????????????????????
            captureBuilder.set(CaptureRequest.CONTROL_AF_MODE,
                    CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE);
            setAutoFlash(captureBuilder);

            // ??????
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            captureBuilder.set(CaptureRequest.JPEG_ORIENTATION, getOrientation(rotation));

            CameraCaptureSession.CaptureCallback CaptureCallback
                    = new CameraCaptureSession.CaptureCallback() {

                @Override
                public void onCaptureCompleted(@NonNull CameraCaptureSession session,
                                               @NonNull CaptureRequest request,
                                               @NonNull TotalCaptureResult result) {
                    unlockFocus();
                    Face faces[]=result.get(CaptureResult.STATISTICS_FACES);

                }
            };
            //??????????????????
            mCaptureSession.stopRepeating();
            //????????????
            mCaptureSession.capture(captureBuilder.build(), CaptureCallback, null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
    public   void  setBitmapImageListener(Listener listener) {
        //???????????? listener ????????? mLinstener
        mLinstenerBitmapImage = listener;
    }
    public static Listener mLinstenerBitmapImage;
    public interface Listener {
        //????????????
        void saveBitmapImage(Bitmap bitmap,String code);
    }

}