package com.rq.net.util;

import android.os.*;

import androidx.annotation.RequiresApi;

public class SdCard
{
    public static long getAvailableInternalMemorySize() {
        Environment.getDataDirectory();
        final StatFs statFs = new StatFs("/cache/");
        return statFs.getAvailableBlocks() * (long)statFs.getBlockSize();
    }
    
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static long getExternalCapacity() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            final StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockSizeLong() * statFs.getBlockCountLong() / 1048576L;
        }
        return 0L;
    }
    
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static long getFreeSpace() {
        final StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }
    
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static long getInternalCapacity() {
        final StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong() / 1048576L;
    }
    
    public static long getTotalExternalMemorySize() {
        if (isSDCardEnable()) {
            final StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * (long)statFs.getBlockSize();
        }
        return -1L;
    }
    
    public static long getTotalInternalMemorySize() {
        Environment.getDataDirectory();
        final StatFs statFs = new StatFs("/cache/");
        return statFs.getBlockCount() * (long)statFs.getBlockSize();
    }
    
    public static boolean isSDCardEnable() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
