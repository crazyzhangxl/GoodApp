package com.zxl.baselib.util.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author zxl on 2018/8/23.
 *         discription:
 */

public class AnimateHelper {

    public static AnimateHelper getInstance(){
        return AnimateHelperHolder.M_INSTANCE;
    }

    private AnimateHelper(){

    }

    private static class AnimateHelperHolder{
        private static final AnimateHelper M_INSTANCE  = new AnimateHelper();
    }


    /**
     * 展示或者隐藏某个特定的View
     * 样例: AnimateHelper.getInstance().hideOrShowDetailView(mTvTest,mTvHeight,false);
     */
    public void  hideOrShowDetailView(final View view, int height, boolean isShow){
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ValueAnimator valueAnimator;
        ObjectAnimator alpha;
        if(!isShow){
            valueAnimator = ValueAnimator.ofInt(height, 0);
            alpha = ObjectAnimator.ofFloat(view, "alpha", 1, 0);
        }else{
            valueAnimator = ValueAnimator.ofInt(0, height);
            alpha = ObjectAnimator.ofFloat(view, "alpha", 0, 1);
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height= (int) valueAnimator.getAnimatedValue();
                view.setLayoutParams(layoutParams);
            }
        });
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.playTogether(valueAnimator,alpha);
        animatorSet.start();

    }

}
