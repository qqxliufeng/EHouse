package com.android.yt.ehouse.app.ui.fragment.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by feng on 2017/7/10.
 */

public abstract class BaseBottomSheetDialogFragment extends BottomSheetDialogFragment {

    protected Context mContext;

    protected View rootView;
    protected BottomSheetBehavior mBehavior;
    private BottomSheetDialog mDialog;

    protected boolean isShowAllHeight = false;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        if (rootView == null) {
            rootView = View.inflate(mContext, getLayoutResId(), null);
            initView(rootView);
        }
        resetView();
        mDialog.setContentView(rootView);
        mBehavior = BottomSheetBehavior.from((View) rootView.getParent());
        mBehavior.setHideable(true);
        if (isShowAllHeight) {
            rootView.post(new Runnable() {
                @Override
                public void run() {
                    /**
                     * PeekHeight默认高度256dp 会在该高度上悬浮
                     * 设置等于view的高 就不会卡住
                     */
                    mBehavior.setPeekHeight(rootView.getHeight());
                }
            });
        }
        return mDialog;
    }

    public abstract int getLayoutResId();

    /**
     * 初始化View和设置数据等操作的方法
     */
    public abstract void initView(View rootView);

    /**
     * 重置的View和数据的空方法 子类可以选择实现
     * 为避免多次inflate 父类缓存rootView
     * 所以不会每次打开都调用{@link #initView(View)}方法
     * 但是每次都会调用该方法 给子类能够重置View和数据
     */
    public void resetView() {

    }

    public boolean isShowing() {
        return mDialog != null && mDialog.isShowing();
    }

    /**
     * 使用关闭弹框 是否使用动画可选
     * 使用动画 同时切换界面Aty会卡顿 建议直接关闭
     *
     * @param isAnimation
     */
    public void close(boolean isAnimation) {
        if (isAnimation) {
            if (mBehavior != null)
                mBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        } else {
            dismiss();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((ViewGroup) (rootView.getParent())).removeView(rootView);
    }
}
