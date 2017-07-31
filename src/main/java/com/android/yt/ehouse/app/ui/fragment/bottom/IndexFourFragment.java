package com.android.yt.ehouse.app.ui.fragment.bottom;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.adapter.BBSListItemAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseFragmentWithSearchConditionFragment;
import com.android.yt.ehouse.app.ui.fragment.decorate.DecorateSearchConditionAreaFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/6/15.
 */

public class IndexFourFragment extends BaseFragmentWithSearchConditionFragment<String> {

    public static IndexFourFragment newInstance() {
        return new IndexFourFragment();
    }

    private DecorateSearchConditionAreaFragment areaFragment;

    @BindView(R.id.id_ll_fragment_bottom_four_area)
    LinearLayout ll_area;
    @BindView(R.id.id_ll_fragment_bottom_four_time)
    LinearLayout ll_time;
    @BindView(R.id.id_ll_fragment_bottom_four_order)
    LinearLayout ll_order;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_bottom_four_layout;
    }

    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new BBSListItemAdapter(R.layout.adapter_bbs_item_layout, mArrayList);
    }

    @Override
    protected int getConditionFragmentContainer() {
        return R.id.id_fl_fragment_bottom_four_condition_container;
    }

    @Override
    protected void addConditionFragments() {
        areaFragment = DecorateSearchConditionAreaFragment.newInstance();
        fragments.add(null);
        fragments.add(areaFragment);
        fragments.add(null);
    }

    @Override
    protected void addLinearLayouts() {
        linearLayouts.add(ll_area);
        linearLayouts.add(ll_time);
        linearLayouts.add(ll_order);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        mRecyclerView.setBackgroundColor(Color.WHITE);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        for (int i = 0; i < 10; i++) {
            mArrayList.add("");
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.id_ll_fragment_bottom_four_area,
            R.id.id_ll_fragment_bottom_four_time,
            R.id.id_ll_fragment_bottom_four_order})
    public void onClickMenu(final LinearLayout view) {
        switch (view.getId()) {
            case R.id.id_ll_fragment_bottom_four_area:
                currentFragment = null;
                break;
            case R.id.id_ll_fragment_bottom_four_time:
                currentFragment = areaFragment;
                break;
            case R.id.id_ll_fragment_bottom_four_order:
                currentFragment = null;
                break;
        }
        managerFragment();
        view.post(new Runnable() {
            @Override
            public void run() {
                refreshTextView(view);
            }
        });
    }

    @OnClick(R.id.id_iv_fragment_bottom_four_crate)
    public void onCreate(){
        FragmentContainerActivity.startFragmentsActivity(mContext,"发帖",FragmentContainerActivity.BBS_CREATE_FLAG);
    }
}
