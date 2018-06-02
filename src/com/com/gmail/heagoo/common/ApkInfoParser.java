package com.gmail.heagoo.common;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;

public class ApkInfoParser {

    public static class AppInfo {
        public String label;
        public String packageName;
        public Drawable icon;
    }

    public static AppInfo parse(Context ctx, String apkPath) throws Exception {
        AppInfo apkInfo = null;

        PackageManager packageManager = ctx.getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageArchiveInfo(apkPath, 0);
        if (packageInfo != null) {
            apkInfo = new AppInfo();
            packageInfo.applicationInfo.sourceDir = apkPath;
            packageInfo.applicationInfo.publicSourceDir = apkPath;
            apkInfo.label = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            apkInfo.packageName = packageInfo.packageName;
            apkInfo.icon = packageInfo.applicationInfo.loadIcon(packageManager);
        }

        return apkInfo;
    }
}
