package com.zxl.goodapp;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.xrecyclerview.XRecyclerView;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;
import com.zxl.baselib.widget.LoadingTip;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author zxl on 2018/08/16.
 * discription: 用于各种测试的活动 ------
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
    @BindView(R.id.xRecyclerView)
    XRecyclerView mXRecyclerView;
    private AnimationDrawable mAnimationDrawable;
    private BaseQuickAdapter<String,BaseViewHolder> mAdapter;
    private List<String> mList = new ArrayList<>();

    @Override
    protected void init() {
        for (int i=0;i<20;i++){
            mList.add("数据"+i);
        }
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
        initAdapter();
    }

    private void initAdapter() {
        mXRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_test,mList) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.tv,item);
            }
        };
        mXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                Log.e("刷新","--------- 加载更多------");
            }
        });
        mXRecyclerView.setAdapter(mAdapter);
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


}
