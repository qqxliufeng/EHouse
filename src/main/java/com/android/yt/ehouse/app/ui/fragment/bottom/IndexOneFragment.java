package com.android.yt.ehouse.app.ui.fragment.bottom;

import android.view.View;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseNetFragment;
import com.android.yt.ehouse.app.ui.fragment.index.BannerFragment;
import com.android.yt.ehouse.app.ui.fragment.index.DecorateCaseFragment;
import com.android.yt.ehouse.app.ui.fragment.index.DecorateNoteFragment;
import com.android.yt.ehouse.app.ui.fragment.index.DecorateResultFragment;
import com.android.yt.ehouse.app.ui.fragment.index.DecorateStrategyFragment;
import com.android.yt.ehouse.app.ui.fragment.index.MallSpecialFragment;

/**
 * Created by feng on 2017/6/15.
 */

public class IndexOneFragment extends LroidBaseNetFragment {

    public static IndexOneFragment newInstance() {
        return new IndexOneFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bottom_one_layout;
    }

    @Override
    protected void initView(View view) {
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

    @Override
    protected void setComponent() {
    }
}
