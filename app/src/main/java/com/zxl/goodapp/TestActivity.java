package com.zxl.goodapp;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;
import com.zxl.baselib.widget.LoadingTip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author zxl on 2018/08/16.
 *         discription: 用于各种测试的活动 ------
 */
public class TestActivity extends BaseActivity {
    @BindView(R.id.load)
    Button mLoad;
    @BindView(R.id.error)
    Button mError;
    @BindView(R.id.finish)
    Button mFinish;
    @BindView(R.id.netError)
    Button mNetError;
    @BindView(R.id.loadedTip)
    LoadingTip mLoadedTip;
    @BindView(R.id.img_progress)
    ImageView mImgProgress;
    private AnimationDrawable mAnimationDrawable;

    @Override
    protected void init() {

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_test;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mAnimationDrawable = (AnimationDrawable) mImgProgress.getDrawable();
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }


    @OnClick({R.id.load, R.id.error, R.id.finish, R.id.netError})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.load:
                mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.Loading);
                break;
            case R.id.error:
                mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.Error);
                break;
            case R.id.finish:
                mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.Finish);
                break;
            case R.id.netError:
                mLoadedTip.setLoadingTip(LoadingTip.LoadStatus.ServiceError);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();

    }


}
