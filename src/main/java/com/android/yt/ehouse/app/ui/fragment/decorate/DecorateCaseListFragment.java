package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

import butterknife.BindView;
import butterknife.OnCheckedChanged;

/**
 * Created by feng on 2017/7/31.
 */

public class DecorateCaseListFragment extends LroidBaseFragment implements ViewPager.OnPageChangeListener {

    public static DecorateCaseListFragment newInstance() {
        return new DecorateCaseListFragment();
    }

    @BindView(R.id.id_rb_fragment_note_decorate_list_left)
    RadioButton rb_left;
    @BindView(R.id.id_rb_fragment_note_decorate_list_right)
    RadioButton rb_right;
    @BindView(R.id.id_vp_fragment_note_decorate_list_container)
    ViewPager vp_container;
    @BindView(R.id.id_fab_fragment_note_decorate_edit)
    FloatingActionButton fab;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_note_decorate_list_container_layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((FragmentContainerActivity) mContext).setAppBarVisibility(View.GONE);
    }

    @Override
    protected void initView(View view) {
        fab.setVisibility(View.GONE);
        rb_left.setChecked(true);
        vp_container.setAdapter(new DecorateCaseAdapter(getChildFragmentManager()));
        vp_container.addOnPageChangeListener(this);
    }

    @OnCheckedChanged({R.id.id_rb_fragment_note_decorate_list_left, R.id.id_rb_fragment_note_decorate_list_right})
    public void onChecked(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) {
            if (compoundButton.getId() == R.id.id_rb_fragment_note_decorate_list_left) {
                vp_container.setCurrentItem(0);
            } else {
                vp_container.setCurrentItem(1);
            }
        }
    }

    @Override
    protected void setComponent() {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        rb_left.setChecked(position == 0);
        rb_right.setChecked(position == 1);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    static class DecorateCaseAdapter extends FragmentStatePagerAdapter {

        public DecorateCaseAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return position == 0 ? DecorateCaseRecommendFragment.newInstance() : DecorateCaseAllFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
