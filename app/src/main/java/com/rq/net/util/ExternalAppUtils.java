package com.rq.net.util;

import android.content.*;
import android.content.pm.*;
import java.util.*;

public class ExternalAppUtils
{
    public static final String PACK_NAME = "com.dmss.electronic.app";
    
    public static boolean isInstallNaKeApp(final Context context) {
        final List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); ++i) {
                if (installedPackages.get(i).packageName.toLowerCase(Locale.ENGLISH).equals("com.dmss.electronic.app")) {
                    return true;
                }
            }
        }
        return false;
    }
}
