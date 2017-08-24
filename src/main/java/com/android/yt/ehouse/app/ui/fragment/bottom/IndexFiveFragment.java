package com.android.yt.ehouse.app.ui.fragment.bottom;

import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;

import butterknife.OnClick;

/**
 * Created by feng on 2017/6/15.
 */

public class IndexFiveFragment extends LroidBaseNetFragment{

    public static IndexFiveFragment newInstance() {
        return new IndexFiveFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bottom_five_layout;
    }

    @Override
    protected void initView(View view) {
    }

    @OnClick(R.id.id_rl_fragment_bottom_five_step)
    public void onStepClick(){
        FragmentContainerActivity.startFragmentsActivity(mContext,"",FragmentContainerActivity.MY_NEW_HOUSE_STEP_FLAG);
    }

    @OnClick(R.id.id_rl_fragment_bottom_five_message)
    public void onMessageClick(){
        FragmentContainerActivity.startFragmentsActivity(mContext,"消息",FragmentContainerActivity.MY_MESSAGE_FLAG);
    }

    @OnClick(R.id.id_iv_fragment_bottom_five_face)
    public void onFaceClick(){
        FragmentContainerActivity.startFragmentsActivity(mContext,"个人中心",FragmentContainerActivity.MY_INFO_FLAG);
    }
}
