package com.android.yt.ehouse.app.ui.fragment.bottom;

import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;
import com.android.yt.ehouse.app.ui.fragment.decorate.DecorateBottomVideoFragment;

import butterknife.OnClick;

/**
 * Created by feng on 2017/6/15.
 */

public class IndexThreeFragment extends LroidBaseFragment {

    public static IndexThreeFragment newInstance() {
        return new IndexThreeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bottom_three_layout;
    }

    @Override
    protected void initView(View view) {
        getChildFragmentManager().beginTransaction().replace(R.id.id_fl_fragment_bottom_three_video_container, DecorateBottomVideoFragment.newInstance()).commit();
    }

    @Override
    protected void setComponent() {
    }

    @OnClick(R.id.id_tv_fragment_bottom_three_more_video)
    public void onMoreVideo(){
        FragmentContainerActivity.startFragmentsActivity(mContext,"视频学装修",FragmentContainerActivity.DECORATE_VIDEO_LIST_FLAG);
    }

    @OnClick(R.id.id_rl_fragment_bottom_three_feng_shui)
    public void onFengShui(){
        FragmentContainerActivity.startFragmentsActivity(mContext,"",FragmentContainerActivity.DECORATE_FENG_SHUI_FLAG);
    }

    @OnClick(R.id.id_rl_fragment_bottom_three_xcsc)
    public void onXCSC(){
        FragmentContainerActivity.startFragmentsActivity(mContext,"",FragmentContainerActivity.DECORATE_SELECT_MATERIAL_ARTICLE_FLAG);
    }

}
