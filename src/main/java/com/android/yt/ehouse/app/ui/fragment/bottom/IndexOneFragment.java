package com.android.yt.ehouse.app.ui.fragment.bottom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.ui.fragment.base.TypeHallFragment;
import com.android.yt.ehouse.app.ui.fragment.house.HouseHallFragment;
import com.android.yt.ehouse.app.ui.fragment.index.BannerFragment;
import com.android.yt.ehouse.app.ui.fragment.index.DecorateCaseFragment;
import com.android.yt.ehouse.app.ui.fragment.index.DecorateNoteFragment;
import com.android.yt.ehouse.app.ui.fragment.index.DecorateResultFragment;
import com.android.yt.ehouse.app.ui.fragment.index.DecorateStrategyFragment;
import com.android.yt.ehouse.app.ui.fragment.index.MallSpecialFragment;
import com.android.yt.ehouse.app.utils.RequestParamsHelper;

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

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser) {
//            if (nestedScrollView!=null && nestedScrollView.getScrollY() == 0) {
//                nestedScrollView.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        nestedScrollView.fullScroll(NestedScrollView.FOCUS_UP);
//                    }
//                });
//            }
//        }
//    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mGetDataFromNetPresenter.getData(0x0, RequestParamsHelper.RequestMod_COMMON.getCommonIndex());
    }

    @Override
    public <T> void onRequestSuccess(int requestID, T result) {
        super.onRequestSuccess(requestID, result);
        Log.e("TAG",result.toString());
    }

    @OnClick({R.id.id_tv_fragment_bottom_one_jiancai,
            R.id.id_tv_fragment_bottom_one_fcdt,
            R.id.id_tv_fragment_bottom_one_decorate,
            R.id.id_tv_fragment_bottom_one_jiaju,
            R.id.id_tv_fragment_bottom_one_jiazheng,
            R.id.id_tv_fragment_bottom_one_licai,
            R.id.id_tv_fragment_bottom_one_zhanhui,
            R.id.id_tv_fragment_bottom_one_tsjy,
            R.id.id_ll_fragment_bottom_one_fengshui
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_tv_fragment_bottom_one_fcdt:
                FragmentContainerActivity.startFragmentsActivity(mContext, HouseHallFragment.TITLE, FragmentContainerActivity.HOUSE_HALL_FLAG);
                break;
            case R.id.id_tv_fragment_bottom_one_jiancai:
                Bundle bundle = new Bundle();
                bundle.putInt(TypeHallFragment.CURRENT_TYPE_FLAG, TypeHallFragment.MATERIALS_FLAG);
                FragmentContainerActivity.startFragmentsActivity(mContext, getString(R.string.string_empty), FragmentContainerActivity.TYPE_HALL_FLAG, bundle);
                break;
            case R.id.id_tv_fragment_bottom_one_jiaju:
                Bundle bundle1 = new Bundle();
                bundle1.putInt(TypeHallFragment.CURRENT_TYPE_FLAG, TypeHallFragment.HOUSE_HOME_FLAG);
                FragmentContainerActivity.startFragmentsActivity(mContext, getString(R.string.string_empty), FragmentContainerActivity.TYPE_HALL_FLAG, bundle1);
                break;
            case R.id.id_tv_fragment_bottom_one_jiazheng:
                Bundle bundle2 = new Bundle();
                bundle2.putInt(TypeHallFragment.CURRENT_TYPE_FLAG, TypeHallFragment.HOUSEKEEPING_FLAG);
                FragmentContainerActivity.startFragmentsActivity(mContext, getString(R.string.string_empty), FragmentContainerActivity.TYPE_HALL_FLAG, bundle2);
                break;
            case R.id.id_tv_fragment_bottom_one_decorate:
                FragmentContainerActivity.startFragmentsActivity(mContext, getString(R.string.string_decorate), FragmentContainerActivity.DECORATE_INDEX_FLAG);
                break;
            case R.id.id_tv_fragment_bottom_one_licai:
//                FragmentContainerActivity.startFragmentsActivity(mContext, "购物车", FragmentContainerActivity.SHOPPING_CAR_FLAG);
                FragmentContainerActivity.startFragmentsActivity(mContext, "理财", FragmentContainerActivity.FINANCING_LIST_FLAG);
                break;
            case R.id.id_tv_fragment_bottom_one_zhanhui:
                FragmentContainerActivity.startFragmentsActivity(mContext, "购物车", FragmentContainerActivity.SHOPPING_CAR_EMPTY_FLAG);
                break;
            case R.id.id_tv_fragment_bottom_one_tsjy:
                FragmentContainerActivity.startFragmentsActivity(mContext, "", FragmentContainerActivity.LOGIN_FLAG);
                break;
            case R.id.id_ll_fragment_bottom_one_fengshui:
                FragmentContainerActivity.startFragmentsActivity(mContext, "", FragmentContainerActivity.NOTE_DECORATE_STEP_FLAG);
                break;
        }
    }
}
