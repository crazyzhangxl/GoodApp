package com.zxl.goodapp.app;
import com.zxl.baselib.baseapp.BaseApp;

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
    }
}
