package com.android.yt.ehouse.app.ui.fragment.bottom;

import android.support.v4.widget.NestedScrollView;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.ui.fragment.house.HouseHallFragment;
import com.android.yt.ehouse.app.ui.fragment.index.BannerFragment;
import com.android.yt.ehouse.app.ui.fragment.index.DecorateCaseFragment;
import com.android.yt.ehouse.app.ui.fragment.index.DecorateNoteFragment;
import com.android.yt.ehouse.app.ui.fragment.index.DecorateResultFragment;
import com.android.yt.ehouse.app.ui.fragment.index.DecorateStrategyFragment;
import com.android.yt.ehouse.app.ui.fragment.index.MallSpecialFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/6/15.
 */

public class IndexOneFragment extends LroidBaseNetFragment {

    public static IndexOneFragment newInstance() {
        return new IndexOneFragment();
    }

    @BindView(R.id.id_sv_fragment_bottom_one_container)
    NestedScrollView nestedScrollView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bottom_one_layout;
    }

    @Override
    protected void initView(View view) {
        nestedScrollView.post(new Runnable() {
            @Override
            public void run() {
                nestedScrollView.fullScroll(NestedScrollView.FOCUS_UP);
            }
        });
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.id_fl_fragment_index_banner_layout, BannerFragment.newInstance())
                .replace(R.id.id_fl_fragment_index_zxal_container, DecorateCaseFragment.newInstance())
                .replace(R.id.id_fl_fragment_index_zxxg_container, DecorateResultFragment.newInstance())
                .replace(R.id.id_fl_fragment_index_zxrj_container, DecorateNoteFragment.newInstance())
                .replace(R.id.id_fl_fragment_index_zxgl_container, DecorateStrategyFragment.newInstance())
                .replace(R.id.id_fl_fragment_index_sctm_container, MallSpecialFragment.newInstance())
                .commit();
    }

    @Override
    protected void setComponent() {
    }

    @OnClick({R.id.id_tv_fragment_bottom_one_jiancai,R.id.id_tv_fragment_bottom_one_fcdt})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.id_tv_fragment_bottom_one_fcdt:
                FragmentContainerActivity.startFragmentsActivity(mContext, HouseHallFragment.TITLE,FragmentContainerActivity.HOUSE_HALL_FLAG);
                break;
            case R.id.id_tv_fragment_bottom_one_jiancai:
                FragmentContainerActivity.startFragmentsActivity(mContext, "",FragmentContainerActivity.TYPE_HALL_FLAG);
                break;
        }
    }
}