package com.zxl.goodapp.util;

import android.content.Context;
import android.os.Environment;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.zxl.goodapp.MainActivity;
import com.zxl.goodapp.R;

/**
 * @author crazyZhangxl on 2018/12/13.
 * Describe:
 */
public class BuglyHelper {
    private static final String TAG = "BuglyHelper";
    public static final String APP_ID = "1fd02e67b8";
    private static  class BuglyHelperHolder{
        private static final BuglyHelper MINSTANCE = new BuglyHelper();
    }

    private BuglyHelper(){

    }

    public static  BuglyHelper getInstance(){
        return BuglyHelperHolder.MINSTANCE;
    }

    /**
     * app中进行初始化以及一些配置
     * @param context
     */
    public void initBuglyApp(Context context){
        /*
         * true表示app启动自动初始化升级模块; false不会自动初始化;
         * 开发者如果担心sdk初始化影响app启动速度，可以设置为false，
         * 在后面某个时刻手动调用
         */
        Beta.autoInit = false;

        /*
         * true表示初始化时自动检查升级; false表示不会自动检查升级,需要手动调用Beta.checkUpgrade()方法;
         */
        Beta.autoCheckUpgrade = false;

        /*
         * 设置升级检查周期为60s(默认检查周期为0s)，60s内SDK不重复向后台请求策略);
         */
        Beta.upgradeCheckPeriod = 60 * 1000;
        /*
         * 设置启动延时为1s（默认延时3s），APP启动1s后初始化SDK，避免影响APP启动速度;
         */
        Beta.initDelay = 1000;
        /*
         * 设置通知栏大图标，largeIconId为项目中的图片资源;
         */
        Beta.largeIconId = R.drawable.ic_launcher_background;
        /*
         * 设置状态栏小图标，smallIconId为项目中的图片资源Id;
         */
        Beta.smallIconId = R.drawable.ic_launcher_background;
        /*
         * 设置更新弹窗默认展示的banner，defaultBannerId为项目中的图片资源Id;
         * 当后台配置的banner拉取失败时显示此banner，默认不设置则展示“loading“;
         */
        Beta.defaultBannerId = R.drawable.ic_launcher_background;
        /*
         * 设置sd卡的Download为更新资源保存目录;
         * 后续更新资源会保存在此目录，需要在manifest中添加WRITE_EXTERNAL_STORAGE权限;
         */
        Beta.storageDir = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        Beta.upgradeDialogLayoutId = R.layout.upgrade_dialog;

        /*
         * 已经确认过的弹窗在APP下次启动自动检查更新时会再次显示;
         */
        Beta.showInterruptedStrategy = true;

        Beta.enableNotification = true;

        /*
         * 只允许在MainActivity上显示更新弹窗，其他activity上不显示弹窗; 不设置会默认所有activity都可以显示弹窗;
         */
        Beta.canShowUpgradeActs.add(MainActivity.class);

        Bugly.init(context, APP_ID, true);
    }

    /**
     * 进行更新
     * @param context
     */
    public void doUpdateNow(Context context){
        Beta.init(context,true);
        Beta.checkUpgrade();
    }
}
