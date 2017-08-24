package com.android.yt.ehouse.app.ui.fragment.user;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.data.bean.MyUserAddressBean;
import com.android.yt.ehouse.app.ui.adapter.MyUserInfoAddressAdpater;
import com.android.yt.ehouse.app.ui.fragment.base.BaseRecycleViewFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by feng on 2017/8/23.
 */

public class MyUserInfoAddressFragment extends BaseRecycleViewFragment<MyUserAddressBean> {

    public static MyUserInfoAddressFragment newInstance() {
        return new MyUserInfoAddressFragment();
    }

    @Override
    protected BaseQuickAdapter<MyUserAddressBean, BaseViewHolder> createAdapter() {
        return new MyUserInfoAddressAdpater(R.layout.adapter_my_user_info_address_item_layout, mArrayList);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        for (int i = 0; i < 20; i++) {
            mArrayList.add(new MyUserAddressBean());
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }
}
