package com.android.yt.ehouse.app.ui.fragment.house;

import android.view.View;
import android.widget.CompoundButton;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by feng on 2017/7/1.
 */

public class HouseSearchConditionAreaFragment extends LroidBaseFragment {

    public static HouseSearchConditionAreaFragment newInstance() {
        return new HouseSearchConditionAreaFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_house_list_search_condition_area_layout;
    }

    @Override
    protected void initView(View view) {
    }

    @Override
    protected void setComponent() {
    }

    @OnCheckedChanged({R.id.id_tv_fragment_house_area_condition_near})
    public void onCheckChange(CompoundButton radioButton) {
        switch (radioButton.getId()) {
            case R.id.id_tv_fragment_house_area_condition_near:
                break;
            case R.id.id_tv_fragment_house_area_condition_area:
                break;
        }
    }

    @OnClick({R.id.id_view_house_list_search_condition_empty,R.id.id_ll_fragment_house_list_search_condition_area_container})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_view_house_list_search_condition_empty:
                ((HouseListFragment) getParentFragment()).onBackPressProcess();
                break;
            case R.id.id_ll_fragment_house_list_search_condition_area_container:
                break;
        }
    }

}
