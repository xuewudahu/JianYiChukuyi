package com.detailsymbologysettings;


import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;

import androidx.annotation.RequiresApi;

import com.rq.barcode.RqDecoder;
import com.rq.barcode.RqEngineer;
import com.rq.barcode.RqSymbologyConfig;
import com.rq.barcode.RqSymbologyConfigValue;
import com.rq.barcode.RqSymbologyType;
import com.kuaidihelp.posthouse.R;


@SuppressWarnings("deprecation")
public class NEC2of5SymbologySettings extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    static final String TAG = NEC2of5SymbologySettings.class.getSimpleName();
    private ListPreference mNEC2o5Checksum;
    /**
     * 定义存储对象
     */
    private RqDecoder rqEngineer;
    private SharedPreferences pullPreference;
    private String key;
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.nec2o5_symbology_settings);
        /**
         * 初始化扫描参数preference
         */
        key = RqSymbologyType.SymbologyType_NEC2of5.getSampleName();
        rqEngineer = RqEngineer.getInstence(this).getRqDecoder();
        pullPreference = rqEngineer.pullBarcodePreference(key);
        //获取checksum
        String checksum = pullPreference.getString(key+RqSymbologyConfig.CHECKSUM_SUFFIX,"");
        mNEC2o5Checksum = (ListPreference) getPreferenceScreen().findPreference("nec2o5_checksum");

        mNEC2o5Checksum.setSummary(get2of5ChecksumEntryForSummary(checksum));
        mNEC2o5Checksum.setValue(checksum);


        if (getResources().getConfiguration().smallestScreenWidthDp < 600) {
            // Lock phone form factor to portrait.
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String tkey) {
        mNEC2o5Checksum.setSummary(mNEC2o5Checksum.getEntry());
        /**
         * 更新设置到条码库
         */
        SharedPreferences.Editor e = pullPreference.edit();
        e.putString(key+ RqSymbologyConfig.CHECKSUM_SUFFIX,mNEC2o5Checksum.getValue());
        e.apply();
        rqEngineer.pushBarcodePreference(key,pullPreference);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    private CharSequence get2of5ChecksumEntryForSummary(String checksum) {
        switch (checksum) {
            case RqSymbologyConfigValue.NormalCheckSum.Checksum_Disabled:
                return mNEC2o5Checksum.getEntries()[0];
            case RqSymbologyConfigValue.NormalCheckSum.Checksum_Enabled:
                return mNEC2o5Checksum.getEntries()[1];
            case RqSymbologyConfigValue.NormalCheckSum.Checksum_EnabledStripCheckCharacter:
                return mNEC2o5Checksum.getEntries()[2];
            default:
                return mNEC2o5Checksum.getEntries()[0];
        }
    }
}

