package com.android.yt.ehouse.app.ui.fragment.index;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.activity.FragmentContainerActivity;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.ui.view.MyGridView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/6/15.
 */

public class DecorateCaseFragment extends LroidBaseNetFragment implements AdapterView.OnItemClickListener {

    public static DecorateCaseFragment newInstance() {
        return new DecorateCaseFragment();
    }

    @BindView(R.id.id_gv_decorate_case_container)
    MyGridView mGridView;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index_decorate_case_layout;
    }

    @Override
    protected void initView(View view) {
        mGridView.setFocusable(false);
        mGridView.setAdapter(new MyDecorateCaseGridViewAdapter());
        mGridView.setOnItemClickListener(this);
    }

    @OnClick(R.id.id_tv_fragment_decorate_case_more)
    public void onClick(){
        FragmentContainerActivity.startFragmentsActivity(mContext,"",FragmentContainerActivity.DECORATE_CASE_LIST_FLAG);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mContext, "", Toast.LENGTH_SHORT).show();
    }


    class MyDecorateCaseGridViewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return View.inflate(mContext,R.layout.adapter_index_decorate_case_item_layout,null);
        }
    }
}
