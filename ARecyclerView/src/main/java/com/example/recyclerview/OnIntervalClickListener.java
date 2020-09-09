package com.example.recyclerview;

import android.view.View;
import android.view.ViewConfiguration;

/**
 * @author reber
 * <p>
 * 处理view的间隔点击事件
 */
public class OnIntervalClickListener implements View.OnClickListener {
    /**
     * 点击的间隔时间设置
     */
    private final long mIntervalTimeValue;
    private View.OnClickListener mClickListener;

    public OnIntervalClickListener() {
        this(null, ViewConfiguration.getDoubleTapTimeout());
    }

    public OnIntervalClickListener(View.OnClickListener clickListener) {
        this(null, 1000);
    }

    public OnIntervalClickListener(View.OnClickListener clickListener, long intervalTimeValue) {
        this.mClickListener = clickListener;
        this.mIntervalTimeValue = intervalTimeValue;
    }

    @Override
    public void onClick(View v) {
        if (isAppClickEnable(v)) {
            if (mClickListener != null) {
                mClickListener.onClick(v);
            }
        }
    }

    /**
     * 处理间隔时间,防止重复点击
     */
    private boolean isAppClickEnable(View view) {
        Object object = view.getTag(AppRecyclerConstants.KEY_VIEW_INTERNAL_TIME);
        boolean intervalClickEnable = true;
        if (object != null) {
            // 获取上一次点击的时间
            long preClickTime = (long) object;
            intervalClickEnable = preClickTime + mIntervalTimeValue > System.currentTimeMillis();
        }
        if (intervalClickEnable) {
            // 记录当前点击的时间
            view.setTag(AppRecyclerConstants.KEY_VIEW_INTERNAL_TIME, System.currentTimeMillis());
        }
        return intervalClickEnable;
    }
}
