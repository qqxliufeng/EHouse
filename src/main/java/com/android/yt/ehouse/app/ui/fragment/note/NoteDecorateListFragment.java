package com.android.yt.ehouse.app.ui.fragment.note;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by feng on 2017/7/28.
 */

public class NoteDecorateListFragment extends LroidBaseFragment implements ViewPager.OnPageChangeListener {

    public static NoteDecorateListFragment newInstance() {
        return new NoteDecorateListFragment();
    }

    @BindView(R.id.id_rb_fragment_note_decorate_list_left)
    RadioButton rb_left;
    @BindView(R.id.id_rb_fragment_note_decorate_list_right)
    RadioButton rb_right;
    @BindView(R.id.id_vp_fragment_note_decorate_list_container)
    ViewPager vp_container;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_note_decorate_list_container_layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((KtFragmentContainerActivity) mContext).setAppBarVisibility(View.GONE);
    }

    @Override
    protected void initView(View view) {
        rb_left.setChecked(true);
        vp_container.setAdapter(new NoteDecorateAdapter(getChildFragmentManager()));
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


    @OnClick(R.id.id_fab_fragment_note_decorate_edit)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.id_fab_fragment_note_decorate_edit:
                KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext,"写日记",KtFragmentContainerActivity.Companion.getNOTE_EDIT_FlAG());
                break;
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

    static class NoteDecorateAdapter extends FragmentStatePagerAdapter {

        public NoteDecorateAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return position == 0 ? NoteDecorateRecommendFragment.newInstance() : NoteDecorateListAllFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
