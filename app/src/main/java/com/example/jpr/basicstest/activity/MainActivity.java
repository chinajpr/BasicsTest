package com.example.jpr.basicstest.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import com.example.jpr.basicstest.R;

/**
 * 类描述:
 * 创建日期:2017/11/21 on 15:51
 * 作者:JiaoPeiRong
 */

public class MainActivity extends BaseActivity {

    private static final String SCHEME = "package";
    /**
     * 调用系统InstalledAppDetails界面所需的Extra名称(用于Android 2.1及之前版本)
     */
    private static final String APP_PKG_NAME_21 = "com.android.settings.ApplicationPkgName";
    /**
     * 调用系统InstalledAppDetails界面所需的Extra名称(用于Android 2.2)
     */
    private static final String APP_PKG_NAME_22 = "pkg";
    /**
     * InstalledAppDetails所在包名
     */
    private static final String APP_DETAILS_PACKAGE_NAME = "com.android.settings";
    /**
     * InstalledAppDetails类名
     */
    private static final String APP_DETAILS_CLASS_NAME = "com.android.settings.InstalledAppDetails";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void arrayList(View view){
        Intent i = new Intent(this , ArrayAdapterTest.class);
        startActivity(i);
    }

    public void pop(View view){
//        Intent i = new Intent(this , PopWindowActivity.class);
//        startActivity(i);
//        Intent localIntent = new Intent();
//        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        if (Build.VERSION.SDK_INT >= 9) {
////            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
//            localIntent.setAction("ACTION_NOTIFICATION_LISTENER_SETTINGS");
//            localIntent.setData(Uri.fromParts("package", getPackageName(), null));
//        } else if (Build.VERSION.SDK_INT <= 8) {
//            localIntent.setAction(Intent.ACTION_VIEW);
//            localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
//            localIntent.putExtra("com.android.settings.ApplicationPkgName", getPackageName());
//        }
//        startActivity(localIntent);

//        Intent localIntent = new Intent();
//        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        if (Build.VERSION.SDK_INT >= 9) {
//            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
//            localIntent.setData(Uri.fromParts("package", getPackageName(), null));
//        } else if (Build.VERSION.SDK_INT <= 8) {
//            localIntent.setAction(Intent.ACTION_VIEW);
//            localIntent.setClassName("com.android.settings", "com.android.setting.InstalledAppDetails");
//            localIntent.putExtra("com.android.settings.ApplicationPkgName", getPackageName());
//        }
//        startActivity(localIntent);

//        Intent intent = new Intent();
//        intent.setAction("android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS");
//        Uri uri = Uri.fromParts(SCHEME, getPackageName(), null);
//        intent.setData(uri);
//        startActivity(intent);


        Intent intent = new Intent();
        final int apiLevel = Build.VERSION.SDK_INT;
        if (apiLevel >= 9) { // 2.3（ApiLevel 9）以上，使用SDK提供的接口
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts(SCHEME, getPackageName(), null);
            intent.setData(uri);
        } else { // 2.3以下，使用非公开的接口（查看InstalledAppDetails源码）
            // 2.2和2.1中，InstalledAppDetails使用的APP_PKG_NAME不同。
            final String appPkgName = (apiLevel == 8 ? APP_PKG_NAME_22
                    : APP_PKG_NAME_21);
            intent.setAction(Intent.ACTION_VIEW);
            intent.setClassName(APP_DETAILS_PACKAGE_NAME,
                    APP_DETAILS_CLASS_NAME);
            intent.putExtra(appPkgName, getPackageName());
        }
        startActivity(intent);
    }
    //test
    //我是dev
}
