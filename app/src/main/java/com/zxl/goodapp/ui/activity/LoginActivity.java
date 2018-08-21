package com.zxl.goodapp.ui.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;

import com.zxl.baselib.util.window.DisplayHelper;
import com.zxl.goodapp.R;

import butterknife.BindView;

/**
 * @author zxl on 2018/08/19.
 *         discription:
 */
public class LoginActivity extends BaseActivity {


    @BindView(R.id.bt_login)
    Button mBtLogin;
    @BindView(R.id.content)
    LinearLayout mLlRoot;
    private boolean isFirst = true;
    private int mButtonHeight;
    private ViewTreeObserver mTreeObserver;
    private ViewTreeObserver.OnGlobalLayoutListener mListener;
    @Override
    protected void init() {

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        buttonBeyondKeyboardLayout(mLlRoot,mBtLogin);

    }

    @Override
    protected void onDestroy() {
        if (mListener != null && mTreeObserver != null && mTreeObserver.isAlive()) {
            mTreeObserver.removeOnGlobalLayoutListener(mListener);
        }
        super.onDestroy();
    }

    private void buttonBeyondKeyboardLayout(final View root, final View button) {
        // 监听根布局的视图变化
        // 获取内容布局在窗体的可视区域
        // 获取内容布局在窗体的不可视区域高度(被其他View遮挡的区域高度)
        // top = 48 = 24*2 即为去除状态栏之外的区域
        // 若不可视区域高度大于100，则键盘显示
        // 获取须顶上去的控件在窗体的坐标
        // 计算root滚动高度，使scrollToView在可见区域
        /* scrollTo并未改变原来的位置
        *  貌似OnLayout可以
        * */// 键盘隐藏
        mListener = () -> {
            Rect rect = new Rect();
            // 获取内容布局在窗体的可视区域
            root.getWindowVisibleDisplayFrame(rect);
            // 获取内容布局在窗体的不可视区域高度(被其他View遮挡的区域高度)
            // top = 48 = 24*2 即为去除状态栏之外的区域
            int rootInvisibleHeight = root.getHeight() - rect.bottom;
            // 若不可视区域高度大于100，则键盘显示

            // 日志显示
            Log.e("root.getHeight() = ",root.getHeight()+"");
            Log.e("displayMetrics.height",DisplayHelper.getScreenHeight(LoginActivity.this)+"");
            Log.e("displayMetrics.width",DisplayHelper.getScreenWidth(LoginActivity.this)+"");

            if (rootInvisibleHeight > 100) {
                int[] location = new int[2];
                // 获取须顶上去的控件在窗体的坐标
                button.getLocationInWindow(location);
                // 计算root滚动高度，使scrollToView在可见区域
                    /* scrollTo并未改变原来的位置
                    *  貌似OnLayout可以
                    * */
                int buttonHeight = button.getHeight() + location[1];
                // 判断登录按钮是否包含在可是区域内
                if (rect.bottom > buttonHeight){
                    if (mListener != null && mTreeObserver.isAlive()) {
                        mTreeObserver.removeOnGlobalLayoutListener(mListener);
                    }
                    mListener = null;
                } else {
                    if (isFirst) {
                        mButtonHeight = (buttonHeight - rect.bottom + DisplayHelper.px2Dp(20));
                        isFirst = false;
                    }
                    root.scrollTo(0, mButtonHeight);
                }


            } else {
                // 键盘隐藏
                root.scrollTo(0, 0);
                isFirst = true;
            }
        };
        mTreeObserver = root.getViewTreeObserver();
        mTreeObserver.addOnGlobalLayoutListener(mListener);
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

}
