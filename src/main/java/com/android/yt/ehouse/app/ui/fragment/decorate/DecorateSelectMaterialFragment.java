package com.android.yt.ehouse.app.ui.fragment.decorate;

import android.view.View;
import android.widget.CheckedTextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.adapter.DecorateArticleItemAdapter;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/7/27.
 */
public class DecorateSelectMaterialFragment extends BaseRecycleViewFragment<String>{

    public static DecorateSelectMaterialFragment newInstance() {
        return  new DecorateSelectMaterialFragment();
    }

    @BindView(R.id.id_ctv_fragment_decorate_select_material_light)
    CheckedTextView tv_light;
    @BindView(R.id.id_ctv_fragment_decorate_select_material_furniture)
    CheckedTextView tv_furniture;
    @BindView(R.id.id_ctv_fragment_decorate_select_material_soft)
    CheckedTextView tv_soft;
    @BindView(R.id.id_ctv_fragment_decorate_select_material_electrical)
    CheckedTextView tv_electrical;

    @Override
    protected BaseQuickAdapter<String, BaseViewHolder> createAdapter() {
        return new DecorateArticleItemAdapter(R.layout.adapter_decorate_article_item_layout,mArrayList);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_decorate_select_material_layout;
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        for (int i = 0; i < 10; i++) {
            mArrayList.add("");
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.id_ll_fragment_decorate_select_material_light,
    R.id.id_ll_fragment_decorate_select_material_furniture,
    R.id.id_ll_fragment_decorate_select_material_soft,
    R.id.id_ll_fragment_decorate_select_material_electrical})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.id_ll_fragment_decorate_select_material_light:
                tv_light.setChecked(true);
                tv_furniture.setChecked(false);
                tv_soft.setChecked(false);
                tv_electrical.setChecked(false);
                break;
            case R.id.id_ll_fragment_decorate_select_material_furniture:
                tv_light.setChecked(false);
                tv_furniture.setChecked(true);
                tv_soft.setChecked(false);
                tv_electrical.setChecked(false);
                break;
            case R.id.id_ll_fragment_decorate_select_material_soft:
                tv_light.setChecked(false);
                tv_furniture.setChecked(false);
                tv_soft.setChecked(true);
                tv_electrical.setChecked(false);
                break;
            case R.id.id_ll_fragment_decorate_select_material_electrical:
                tv_light.setChecked(false);
                tv_furniture.setChecked(false);
                tv_soft.setChecked(false);
                tv_electrical.setChecked(true);
                break;
        }
    }

}
