package com.zxl.goodapp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;

import com.zxl.goodapp.BuildConfig;
import com.zxl.goodapp.R;
import com.zxl.goodapp.factory.LaunchFgFactory;
import com.zxl.goodapp.ui.fragment.DetFragment;
import com.zxl.goodapp.ui.fragment.MeFragment;
import com.zxl.goodapp.ui.fragment.MsgFragment;
import com.zxl.goodapp.ui.fragment.NewsFragment;
import com.roughike.bottombar.BottomBar;
import com.zxl.baselib.ui.base.BaseActivity;
import com.zxl.baselib.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author zxl on 2018/08/17.
 *         discription: 启动界面
 */
public class LaunchActivity extends BaseActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;
    @Override
    protected void init() {

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_launch;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(LaunchFgFactory.getFactoryInstance().getDetFgInstance());
        fragmentList.add(LaunchFgFactory.getFactoryInstance().getNewFgInstance());
        fragmentList.add(LaunchFgFactory.getFactoryInstance().getMsgInstance());
        fragmentList.add(LaunchFgFactory.getFactoryInstance().getMeFgInstacne());
        mViewPager.setAdapter(new TestFragmentPagerAdapter(getSupportFragmentManager(),fragmentList));
        mViewPager.setOffscreenPageLimit(fragmentList.size());
        mViewPager.setCurrentItem(0);
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initListener() {
        mBottomBar.setOnTabSelectListener(tabId -> {
            switch (tabId){
                case R.id.tabDet:
                    mViewPager.setCurrentItem(0,false);
                    break;
                case R.id.tabNews:
                    mViewPager.setCurrentItem(1,false);
                    break;
                case R.id.tabMsg:
                    mViewPager.setCurrentItem(2,false);
                    break;
                case R.id.tabMe:
                    mViewPager.setCurrentItem(3,false);
                    break;
                default:
                    break;
            }
        });
    }

    private class TestFragmentPagerAdapter extends FragmentPagerAdapter{
        private List<Fragment> mFragmentList;

        public TestFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
            super(fm);
            this.mFragmentList = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            if (mFragmentList != null){
                return mFragmentList.get(position);
            }
            return null;
        }

        @Override
        public int getCount() {
            if (mFragmentList != null){
                return mFragmentList.size();
            }
            return 0;
        }
    }

}
