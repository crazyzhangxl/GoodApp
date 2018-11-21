package com.zxl.goodapp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.TextView;

import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;
import com.zxl.goodapp.R;
import com.zxl.goodapp.TestActivity;

import java.util.Timer;


/**
 * @author crazyZhangxl on 2018-11-16 8:15:09.
 * Describe: 引导页
 */

public class SplashActivity extends BaseActivity implements BaseTimeTaskListener {
    private Timer mTimer;
    private AppCompatTextView mTvTime;
    private int mCount = 6;
    @Override
    protected void init() {

    }

    private void  initTimer(){
        mTimer = new Timer();
        mTimer.schedule(new BaseTimeTask(this),0,1000);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initTimer();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mTvTime = findViewById(R.id.tvTime);
        mTvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimer != null){
                    mTimer.cancel();
                    mTimer = null;
                    doJump();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        // 如果定时器还存在 那么直接返回
        if (mTimer != null){
            return;
        }
        super.onDestroy();
    }

    private void  doJump(){
        finish();
        jumpToActivity(TestActivity.class);
    }

    @Override
    public void doTimeTask() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
               if (mCount > 0){
                   mTvTime.setText(String.format("跳过\n%d秒",mCount));
                   mCount --;
               }else {
                   mTimer.cancel();
                   mTimer = null;
                   doJump();
               }
            }
        });
    }
}
