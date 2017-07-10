package com.android.yt.ehouse.app.ui.fragment.materials;

import android.view.View;
import android.widget.TextView;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.BaseBottomSheetDialogFragment;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feng on 2017/7/10.
 */

public class MaterialsInfoFormatDialogFragment extends BaseBottomSheetDialogFragment {


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_materials_info_format_layout;
    }

    @Override
    public void initView(View rootView) {
        isShowAllHeight = true;
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            stringArrayList.add("[黄色]+单人+贵妃 布号：YP3417-33");
        }
        TagFlowLayout tfl_container = (TagFlowLayout) rootView.findViewById(R.id.id_tfl_fragment_materials_info_format_type_container);
        tfl_container.setMaxSelectCount(1);
        tfl_container.setAdapter(new MyTagFlowLayout(stringArrayList));
    }

    class MyTagFlowLayout extends TagAdapter<String> {

        public MyTagFlowLayout(List<String> datas) {
            super(datas);
        }

        @Override
        public View getView(FlowLayout parent, int position, String s) {
            View view = View.inflate(mContext, R.layout.adapter_materials_info_formate_tag_item_layout, null);
            ((TextView) view).setText(s);
            return view;
        }
    }

}
