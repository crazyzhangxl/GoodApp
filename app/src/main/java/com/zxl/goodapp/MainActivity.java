package com.zxl.goodapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxl.goodapp.ui.activity.LoginActivity;
import com.zxl.goodapp.ui.photos.PullPhotoDetailActivity;
import com.zxl.baselib.commom.BaseAppConst;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;
import com.zxl.baselib.util.image.GlideLoaderUtils;
import com.zxl.baselib.util.ui.StatusBarHelper;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author zxl on 2018/06/30.
 *         discription:
 */

public class MainActivity extends BaseActivity {
    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.tvTest)
    TextView mTvTest;

    @Override
    protected void init() {

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        StatusBarHelper.setStatusBarLightMode(this);
        GlideLoaderUtils.display(this,mImageView, BaseAppConst.T_IMAGE_URL);
        mTvTest.setText("状态栏高度:"+StatusBarHelper.getStatusBarHeight(this));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PullPhotoDetailActivity.startAction(MainActivity.this,
                        BaseAppConst.T_IMAGE_URL,
                        v);
            }
        });
    }

    @OnClick({R.id.btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                jumpToActivity(LoginActivity.class);
                break;
            default:
                break;
        }
    }

}
