package com.android.yt.ehouse.app.ui.fragment.note;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/7/29.
 */

public class NoteInfoFragment extends LroidBaseFragment {

    public static NoteInfoFragment newInstance() {
        return new NoteInfoFragment();
    }

    @BindView(R.id.id_dl_fragment_note_info_container)
    DrawerLayout dl_container;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_note_info_layout;
    }

    @Override
    protected void initView(View view) {
        getChildFragmentManager().beginTransaction().replace(R.id.id_fl_fragment_note_info_menu_container,NoteInfoStepFragment.newInstance()).commit();
    }

    @Override
    protected void setComponent() {
    }

    @OnClick(R.id.id_fab_fragment_note_info_step)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_fab_fragment_note_info_step:
                if (dl_container.isDrawerOpen(GravityCompat.END))
                    dl_container.closeDrawer(GravityCompat.END);
                else dl_container.openDrawer(GravityCompat.END);
                break;
        }
    }

}
