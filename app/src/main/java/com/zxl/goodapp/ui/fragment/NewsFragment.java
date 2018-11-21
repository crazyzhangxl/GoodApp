package com.zxl.goodapp.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.zxl.baselib.ui.base.BaseFragment;
import com.zxl.baselib.ui.base.BasePresenter;
import com.zxl.goodapp.R;

import butterknife.BindView;

/**
 * @author zxl on 2018/8/17.
 *         discription:
 */

public class NewsFragment extends LazyFragment {
    private TextView mTv;



    @Override
    public void initViews(View view,Bundle savedInstanceState) {
        mTv = view.findViewById(R.id.tv);
        Log.e("initView"," ----初始化  第二个Fragment-----");
    }

    @Override
    public void lazyInit(View view, Bundle savedInstanceState) {
        mTv.setText(NewsFragment.class.getName());
        Log.e("initData"," ---- 懒加载 第二个Fragment-----");
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_launch;
    }
}
