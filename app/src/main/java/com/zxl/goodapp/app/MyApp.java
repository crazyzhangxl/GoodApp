package com.zxl.goodapp.app;
import android.os.Environment;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.zxl.baselib.baseapp.BaseApp;
import com.zxl.goodapp.MainActivity;
import com.zxl.goodapp.R;
import com.zxl.goodapp.util.BuglyHelper;

import org.litepal.LitePal;

/**
 * @author 张先磊
 * @date 2018/4/17
 */

public class MyApp extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();
        // litePal初始化
        LitePal.initialize(this);
        //Bugly.init(getApplicationContext(), "1fd02e67b8", false);
        //CrashReport.initCrashReport(getApplicationContext(), "1fd02e67b8", true);
        BuglyHelper.getInstance().initBuglyApp(this);
    }


}
