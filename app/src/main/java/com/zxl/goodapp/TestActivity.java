package com.zxl.goodapp;

import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.EditText;

import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;
import com.zxl.baselib.util.ui.UIUtils;
import com.zxl.baselib.util.window.KeyboardHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author zxl on 2018/08/16.
 *         discription: 用于各种测试的活动 ------
 */
public class TestActivity extends BaseActivity {

    @BindView(R.id.etTest)
    EditText mEtTest;

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
        setViewObserver();
    }

    private void setViewObserver() {
        ViewTreeObserver observer = mEtTest.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (KeyboardHelper.isKeyboardVisible(TestActivity.this)){
                    UIUtils.showToast("可见");
                }else {
                    UIUtils.showToast("隐藏");
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
