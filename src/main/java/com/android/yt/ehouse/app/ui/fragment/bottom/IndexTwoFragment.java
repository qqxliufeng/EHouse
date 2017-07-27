package com.android.yt.ehouse.app.ui.fragment.bottom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;
import com.android.yt.ehouse.app.ui.fragment.images.GeneralImageFragment;
import com.android.yt.ehouse.app.ui.fragment.images.MapImageFragment;
import com.android.yt.ehouse.app.ui.fragment.images.SingleImageFragment;

import butterknife.BindView;
import butterknife.OnCheckedChanged;

/**
 * Created by feng on 2017/6/15.
 */

public class IndexTwoFragment extends LroidBaseFragment implements ViewPager.OnPageChangeListener {

    public static IndexTwoFragment newInstance() {
        return new IndexTwoFragment();
    }

    @BindView(R.id.id_view_fragment_bottom_two_top_sliding)
    View view_sliding;
    @BindView(R.id.id_vp_fragment_bottom_two_container)
    ViewPager vp_container;
    @BindView(R.id.id_rg_fragment_bottom_two_top_container)
    RadioGroup rg_container;

    private int slidingViewWidth = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bottom_two_layout;
    }

    @Override
    protected void initView(View view) {
        view_sliding.post(new Runnable() {
            @Override
            public void run() {
                slidingViewWidth = view_sliding.getWidth();
            }
        });
        vp_container.setAdapter(new BottomTwoContainerAdapter(getChildFragmentManager()));
        vp_container.setOffscreenPageLimit(1);
        vp_container.addOnPageChangeListener(this);
        ((RadioButton) rg_container.getChildAt(0)).setChecked(true);
    }

    @OnCheckedChanged({R.id.id_rb_fragment_bottom_two_general_image,
    R.id.id_rb_fragment_bottom_two_map_image,
    R.id.id_rb_fragment_bottom_two_single_image})
    public void onChecked(CompoundButton button,boolean isChecked){
        if (isChecked) {
            switch (button.getId()) {
                case R.id.id_rb_fragment_bottom_two_general_image:
                    vp_container.setCurrentItem(0,true);
                    break;
                case R.id.id_rb_fragment_bottom_two_map_image:
                    vp_container.setCurrentItem(1,true);
                    break;
                case R.id.id_rb_fragment_bottom_two_single_image:
                    vp_container.setCurrentItem(2,true);
                    break;
            }
        }
    }


    @Override
    protected void setComponent() {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset != 0) {
            view_sliding.setTranslationX(slidingViewWidth * positionOffset + slidingViewWidth * position);
        }
    }

    @Override
    public void onPageSelected(int position) {
        ((RadioButton) rg_container.getChildAt(position)).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    static class BottomTwoContainerAdapter extends FragmentStatePagerAdapter {

        public BottomTwoContainerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return GeneralImageFragment.newInstance();
                case 1:
                    return MapImageFragment.newInstance();
                case 2:
                    return SingleImageFragment.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
