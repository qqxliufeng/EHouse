package com.android.yt.ehouse.app.ui.fragment.base;


import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

/**
 * Created by feng on 2017/7/3.
 */

public abstract class BaseFragmentWithSearchConditionFragment<T> extends BaseRecycleViewFragment<T> {

    protected ArrayList<LroidBaseFragment> fragments = new ArrayList<>();
    protected ArrayList<LinearLayout> linearLayouts = new ArrayList<>();

    protected LroidBaseFragment currentFragment;

    protected abstract BaseQuickAdapter<T, BaseViewHolder> createAdapter();

    protected abstract int getConditionFragmentContainer();

    protected abstract void addConditionFragments();

    protected abstract void addLinearLayouts();

    @Override
    public void initView(View view) {
        super.initView(view);
        addConditionFragments();
        addLinearLayouts();
    }

    /**
     * 刷新选择条件的文本颜色
     *
     * @param view
     */
    protected void refreshTextView(LinearLayout view) {
        for (LinearLayout ll : linearLayouts) {
            if (ll == view) {
                if (currentFragment == null){
                    ((CheckedTextView) ll.getChildAt(0)).setChecked(true);
                }else {
                    if (currentFragment.isAdded()) {
                        ((CheckedTextView) ll.getChildAt(0)).setChecked(true);
                    } else {
                        ((CheckedTextView) ll.getChildAt(0)).setChecked(false);
                    }
                }
            } else {
                ((CheckedTextView) ll.getChildAt(0)).setChecked(false);
            }
        }
    }

    protected void managerFragment() {
        removeAllFragment();
        if (currentFragment != null) {
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            if (currentFragment.isAdded()) {
                fragmentTransaction.remove(currentFragment);
            } else {
                fragmentTransaction.add(getConditionFragmentContainer(), currentFragment);
            }
            fragmentTransaction.commit();
        }
    }

    protected void removeAllFragment() {
        for (LroidBaseFragment fragment : fragments) {
            if (fragment != null) {
                if (fragment != currentFragment) {
                    if (fragment.isAdded()) {
                        getChildFragmentManager().beginTransaction().remove(fragment).commit();
                    }
                }
            }
        }
    }

    public boolean onBackPress() {
        return true;
    }

    @Override
    public void onBackPressProcess() {
        if (currentFragment != null && currentFragment.isAdded()) {
            getChildFragmentManager().beginTransaction().remove(currentFragment).commit();
            currentFragment = null;
            refreshTextView(null);
        } else {
            finishActivity();
        }
    }
}
