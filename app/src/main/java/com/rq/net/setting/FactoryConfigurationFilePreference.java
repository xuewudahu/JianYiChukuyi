package com.rq.net.setting;


import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;

import com.rq.net.MyApplication;
import com.rq.net.bean.FactoryRegistrationBean;
import com.rq.net.util.JsonUtil;
import com.rq.net.util.StringUtil;

import java.io.File;
import java.lang.reflect.Field;

public class FactoryConfigurationFilePreference {
    private static final String FACTORY_CONFIGURATION_FILE = "factory_configuration_file";
    private static final String FACTORY_FILE_SYNCHRONIZED = "factory_file_synchronized";
    public static final String FILE_PATH;
    public static FactoryConfigurationFilePreference mFactoryConfigurationFilePreference;
    private final String KEY_ACTIVATION_STATE = "key_activation_state";
    private final String KEY_C_PHONE = "key_c_phone";
    private final String KEY_FACTORY_REGISTRATION = "key_factory_registration";
    private final String KEY_FIX_STATION_TYPE = "key_fix_station_type";
    private final String KEY_IDENTIFY = "key_identify";
    private SharedPreferences preferences;
    private Editor preferencesEditor;

    static {
        StringBuilder var0 = new StringBuilder();
        var0.append(Environment.getExternalStorageDirectory().toString());
        var0.append("/cobafactory/");
        FILE_PATH = var0.toString();
    }

    public FactoryConfigurationFilePreference() {
        try {
            this.preferences = getSelfSharedPreferences(MyApplication.baseApp, FILE_PATH, "factory_configuration_file");
            this.preferencesEditor = this.preferences.edit();
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }

    private boolean getBoolean(String var1, boolean var2) {
        SharedPreferences var3 = this.preferences;
        return var3 == null ? false : var3.getBoolean(var1, var2);
    }

    public static FactoryConfigurationFilePreference getInstance() {
        synchronized("factory_file_synchronized"){}

        Throwable var10000;
        boolean var10001;
        label122: {
            try {
                if (mFactoryConfigurationFilePreference == null) {
                    mFactoryConfigurationFilePreference = new FactoryConfigurationFilePreference();
                }
            } catch (Throwable var12) {
                var10000 = var12;
                var10001 = false;
                break label122;
            }

            label119:
            try {
                FactoryConfigurationFilePreference var13 = mFactoryConfigurationFilePreference;
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

    private int getInt(String var1, int var2) {
        SharedPreferences var3 = this.preferences;
        return var3 == null ? 0 : var3.getInt(var1, var2);
    }

    public static SharedPreferences getSelfSharedPreferences(Context var0, String var1, String var2) {
        try {
            Field var3 = ContextWrapper.class.getDeclaredField("mBase");
            var3.setAccessible(true);
            Object var9 = var3.get(var0);
            Field var4 = var9.getClass().getDeclaredField("mPreferencesDir");
            var4.setAccessible(true);
            var4.set(var9, new File(var1));
            SharedPreferences var8 = var0.getSharedPreferences(var2, 0);
            return var8;
        } catch (NoSuchFieldException var5) {
            var5.printStackTrace();
        } catch (IllegalArgumentException var6) {
            var6.printStackTrace();
        } catch (IllegalAccessException var7) {
            var7.printStackTrace();
        }

        return var0.getSharedPreferences(var2, 0);
    }

    private String getString(String var1, String var2) {
        SharedPreferences var3 = this.preferences;
        return var3 == null ? "" : var3.getString(var1, var2);
    }

    private void setBoolean(String var1, boolean var2) {
        this.preferencesEditor.putBoolean(var1, var2).commit();
    }

    private void setInt(String var1, int var2) {
        this.preferencesEditor.putInt(var1, var2).commit();
    }

    private void setString(String var1, String var2) {
        this.preferencesEditor.putString(var1, var2).commit();
    }

    public void clearPreferencesALL() {
        this.preferencesEditor.clear().commit();
    }

    public boolean getActivationState() {
        return this.getBoolean("key_activation_state", false);
    }

    public String getCPhone() {
        return this.getString("key_c_phone", "");
    }

    public FactoryRegistrationBean getFactoryRegistration() {
        String var1 = this.getString("key_factory_registration", "");
        return StringUtil.isEmpty(var1) ? null : (FactoryRegistrationBean) JsonUtil.getClazzByGson(var1, FactoryRegistrationBean.class);
    }

    public String getFixStationType() {
        return this.getString("key_fix_station_type", "");
    }

    public int getIdentify() {
        return this.getInt("key_identify", 3);
    }

    public void setActivationState(boolean var1) {
        this.setBoolean("key_activation_state", var1);
    }

    public void setCPhone(String var1) {
        this.setString("key_c_phone", var1);
    }

    public void setFactoryRegistration(FactoryRegistrationBean var1) {
        this.setString("key_factory_registration", JsonUtil.getJsonStringByGson(var1));
    }

    public void setFixStationType(String var1) {
        this.setString("key_fix_station_type", var1);
    }

    public void setIdentify(int var1) {
        this.setInt("key_identify", var1);
    }
}
