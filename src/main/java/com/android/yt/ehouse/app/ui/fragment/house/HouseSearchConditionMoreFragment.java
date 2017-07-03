package com.android.yt.ehouse.app.ui.fragment.house;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/7/1.
 */

public class HouseSearchConditionMoreFragment extends LroidBaseFragment {

    public static HouseSearchConditionMoreFragment newInstance() {
        return new HouseSearchConditionMoreFragment();
    }

    @BindView(R.id.id_ll_fragment_house_list_search_condition_more_container1)
    LinearLayout ll_container;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_house_list_search_condition_more_layout;
    }

    @Override
    protected void initView(View view) {
    }

    @Override
    protected void setComponent() {

    }

    @OnClick({R.id.id_ll_fragment_house_list_search_condition_more_container, R.id.id_view_house_list_search_condition_empty, R.id.id_bt_fragment_house_list_search_condition_more_reset})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_view_house_list_search_condition_empty:
                ((HouseListFragment) getParentFragment()).onBackPressProcess();
                break;
            case R.id.id_bt_fragment_house_list_search_condition_more_reset:
                resetView(ll_container);
                break;
            case R.id.id_ll_fragment_house_list_search_condition_more_container:
                break;
        }
    }

    /**
     * 递归调用 重置CheckBox的选中状态
     *
     * @param container
     */
    private void resetView(LinearLayout container) {
        int childCount = container.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = container.getChildAt(i);
            if (childAt instanceof LinearLayout) {
                resetView((LinearLayout) childAt);
            } else if (childAt instanceof CheckBox) {
                ((CheckBox) childAt).setChecked(false);
            }
        }
    }

}
