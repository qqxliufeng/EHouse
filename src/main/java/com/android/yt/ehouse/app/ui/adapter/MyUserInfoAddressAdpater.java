package com.android.yt.ehouse.app.ui.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.MyUserAddressBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by feng on 2017/8/23.
 */

public class MyUserInfoAddressAdpater extends BaseQuickAdapter<MyUserAddressBean, BaseViewHolder> {

    public MyUserInfoAddressAdpater(int layoutResId, List<MyUserAddressBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final MyUserAddressBean item) {
        CheckBox cb_default = helper.getView(R.id.id_cb_adapter_my_user_info_address_item_default);
        helper.setChecked(R.id.id_cb_adapter_my_user_info_address_item_default, item.isDefault());
        cb_default.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (MyUserAddressBean bean : mData) {
                    bean.setDefault(bean == item);
                }
                notifyDataSetChanged();
            }
        });
    }
}
