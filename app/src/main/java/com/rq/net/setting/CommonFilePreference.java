package com.rq.net.setting;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.rq.net.MyApplication;

public class CommonFilePreference {
    public static final String COMMON_FILE_SYNCHRONIZED = "common_file_synchronized";
    private static final String KEY_BULETOOTH = "key_bluetooth";
    public static CommonFilePreference mCommonFilePreference;
    private final String FILE_PREFERENCE_NAME = "cobaAI_file_name";
    private final String KEY_BARCODE_CAMERA_AUTO_EXPOSURE = "key_barcode_camera_auto_exposure";
    private final String KEY_DEVICE_RUN_TIME = "key_device_run_time";
    private final String KEY_IS_SPECIAL_EDITION = "key_is_special_edition";
    private final String KEY_MIX_SELECT_SYSTEM_TYPE = "key_mix_select_system_type";
    private final String KEY_SCALE_FILTER_COUNT = "key_scale_filter_count";
    private final String KEY_SELECT_EXPRESS_SYSTEM = "key_select_express_system";
    private final String KEY_SELECT_EXPRESS_SYSTEM_TITLE = "key_select_express_system_title";
    private final String KEY_STABILITY_ACCURACY = "key_stability_accuracy";
    private final String KEY_STABILITY_NUMBER = "key_stability_number";
    private final String KEY_TODAY_DATE = "key_today_date";
    private final String KEY_TODAY_SCANCOUNT = "key_today_scancount";
    private final String KEY_UUID = "key_uuid";
    private SharedPreferences preferences;
    private Editor preferencesEditor;

    public CommonFilePreference() {
        try {
            this.preferences = FactoryConfigurationFilePreference.getSelfSharedPreferences(MyApplication.baseApp, MyApplication.baseApp.getFilesDir().getAbsolutePath(), "cobaAI_file_name");
            this.preferencesEditor = this.preferences.edit();
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }

    public static CommonFilePreference getInstance() {
        synchronized("common_file_synchronized"){}

        Throwable var10000;
        boolean var10001;
        label122: {
            try {
                if (mCommonFilePreference == null) {
                    mCommonFilePreference = new CommonFilePreference();
                }
            } catch (Throwable var12) {
                var10000 = var12;
                var10001 = false;
                break label122;
            }

            label119:
            try {
                CommonFilePreference var13 = mCommonFilePreference;
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

    public void clearPreferencesALL() {
        this.preferencesEditor.clear().commit();
    }

    public boolean getBarcodeCameraAutoExposure() {
        return this.getBool("key_barcode_camera_auto_exposure", true);
    }

    public String getBlueTooth() {
        return this.getString("key_bluetooth", "");
    }

    public boolean getBool(String var1, boolean var2) {
        SharedPreferences var3 = this.preferences;
        return var3 == null ? var2 : var3.getBoolean(var1, var2);
    }

    public long getDeviceRunTime() {
        return this.getLong("key_device_run_time", 0L);
    }

    public float getFloat(String var1, float var2) {
        SharedPreferences var3 = this.preferences;
        return var3 == null ? var2 : var3.getFloat(var1, var2);
    }

    public int getInt(String var1, int var2) {
        SharedPreferences var3 = this.preferences;
        return var3 == null ? var2 : var3.getInt(var1, var2);
    }

    public boolean getIsSpecialEdition() {
        return this.getBool("key_is_special_edition", true);
    }

    public long getLong(String var1, long var2) {
        SharedPreferences var4 = this.preferences;
        return var4 == null ? var2 : var4.getLong(var1, var2);
    }

    public long getMixSelectSystemType() {
        try {
            this.getLong("key_mix_select_system_type", -1L);
        } catch (ClassCastException var2) {
            return (long)this.getInt("key_mix_select_system_type", -1);
        }

        return this.getLong("key_mix_select_system_type", -1L);
    }

    public int getScaleFilterCount() {
        return this.getInt("key_scale_filter_count", 15);
    }

    public int getSelectExpressSystemFlag() {
        return this.getInt("key_select_express_system", -1);
    }

    public String getSelectExpressSystemTitle() {
        return this.getString("key_select_express_system_title", " ");
    }

    public int getStabilityAccuracy() {
        return this.getInt("key_stability_accuracy", 2);
    }

    public int getStabilityNumber() {
        return this.getInt("key_stability_number", 2);
    }

    public String getString(String var1, String var2) {
        SharedPreferences var3 = this.preferences;
        return var3 == null ? var2 : var3.getString(var1, var2);
    }

    public String getTodayDate() {
        return this.getString("key_today_date", "");
    }

    public int getTodayScanCount() {
        return this.getInt("key_today_scancount", 0);
    }

    public String getUUID() {
        return this.getString("key_uuid", "");
    }

    public void setBarcodeCameraAutoExposure(boolean var1) {
        this.setBool("key_barcode_camera_auto_exposure", var1);
    }

    public void setBlueTooth(String var1) {
        this.setString("key_bluetooth", var1);
    }

    public void setBool(String var1, boolean var2) {
        Editor var3 = this.preferencesEditor;
        if (var3 != null) {
            var3.putBoolean(var1, var2).commit();
        }
    }

    public void setDeviceRunTime(long var1) {
        this.setLong("key_device_run_time", var1);
    }

    public void setFloat(String var1, float var2) {
        Editor var3 = this.preferencesEditor;
        if (var3 != null) {
            var3.putFloat(var1, var2).commit();
        }
    }

    public void setInt(String var1, int var2) {
        Editor var3 = this.preferencesEditor;
        if (var3 != null) {
            var3.putInt(var1, var2).commit();
        }
    }

    public void setIsSpecialEdition(Boolean var1) {
        this.setBool("key_is_special_edition", var1);
    }

    public void setLong(String var1, long var2) {
        Editor var4 = this.preferencesEditor;
        if (var4 != null) {
            var4.putLong(var1, var2).commit();
        }
    }

    public void setMixSelectSystemType(long var1) {
        this.setLong("key_mix_select_system_type", var1);
    }

    public void setScaleFilterCount(int var1) {
        this.setInt("key_scale_filter_count", var1);
    }

    public void setSelectExpressSystemFlag(int var1) {
        this.setInt("key_select_express_system", var1);
    }

    public void setSelectExpressSystemTitle(String var1) {
        this.setString("key_select_express_system_title", var1);
    }

    public void setStabilityAccuracy(int var1) {
        this.setInt("key_stability_accuracy", var1);
    }

    public void setStabilityNumber(int var1) {
        this.setInt("key_stability_number", var1);
    }

    public void setString(String var1, String var2) {
        Editor var3 = this.preferencesEditor;
        if (var3 != null) {
            var3.putString(var1, var2).commit();
        }
    }

    public void setTodayDate(String var1) {
        this.setString("key_today_date", var1);
    }

    public void setTodayScanCount(int var1) {
        this.setInt("key_today_scancount", var1);
    }

    public void setUUID(String var1) {
        this.setString("key_uuid", var1);
    }
}
