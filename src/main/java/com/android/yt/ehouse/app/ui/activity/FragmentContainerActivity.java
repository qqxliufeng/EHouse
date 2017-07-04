package com.android.yt.ehouse.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.ClassifySearchFragment;
import com.android.yt.ehouse.app.ui.fragment.base.LroidBaseFragment;
import com.android.yt.ehouse.app.ui.fragment.base.TypeHallFragment;
import com.android.yt.ehouse.app.ui.fragment.decorate.DecorateCompanyListFragment;
import com.android.yt.ehouse.app.ui.fragment.decorate.DecorateIndexFragment;
import com.android.yt.ehouse.app.ui.fragment.house.HouseHallFragment;
import com.android.yt.ehouse.app.ui.fragment.house.HouseInfoFragment;
import com.android.yt.ehouse.app.ui.fragment.house.HouseListFragment;
import com.android.yt.ehouse.app.ui.fragment.materials.MaterialsListFragment;

import butterknife.BindView;

/**
 * Created by feng on 2016/9/13.
 */

public class FragmentContainerActivity extends BaseActivity {

    public static final String TITLE_FLAG = "title_flag";
    public static final String FRAGMENT_FLAG = "fragment_flag";
    public static final String EXTRA_FLAG = "extra_flag";

    public static final int WEB_CONTENT_CONTAINER_FLAG = 0x0;
    public static final int CLASSIFY_SEARCH_FLAG = 0x1;
    public static final int HOUSE_HALL_FLAG = 0x2;
    public static final int TYPE_HALL_FLAG = 0x3;
    public static final int DECORATE_INDEX_FLAG = 0x4;
    public static final int HOUSE_LIST_FLAG = 0x5;
    public static final int DECORATE_COMPANY_LIST_FLAG = 0x6;
    public static final int MATERIALS_LIST_FLAG = 0x7;
    public static final int HOUSE_INFO_FLAG = 0x8;


    @BindView(R.id.id_tl_home_tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.id_abl_home_tool_bar_container)
    AppBarLayout mAppBarLayout;

    @BindView(R.id.id_fl_activity_fragment_container)
    FrameLayout fl_container;

    private LroidBaseFragment currentFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_fragment_container_layout;
    }

    public void setAppBarVisibility(int visibility) {
        mAppBarLayout.setVisibility(visibility);
        setSupportActionBar(null);
    }

    @Override
    public void setPresentComponent() {
    }

    @Override
    public void initView() {
        initFragment();
    }

    private void initFragment() {
        mToolBar.setTitle(getIntent().getStringExtra(TITLE_FLAG));
        mToolBar.setTitleTextColor(Color.parseColor("#666666"));
        setSupportActionBar(mToolBar);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(true);
        }
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollToFinishActivity();
            }
        });
        int fragmentId = getIntent().getIntExtra(FRAGMENT_FLAG, 0x0);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (fragmentId) {
            case WEB_CONTENT_CONTAINER_FLAG:
                break;
            case CLASSIFY_SEARCH_FLAG:
                fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, ClassifySearchFragment.newInstance());
                break;
            case HOUSE_HALL_FLAG:
                fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, HouseHallFragment.newInstance());
                break;
            case TYPE_HALL_FLAG:
                fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, TypeHallFragment.newInstance(getIntent().getBundleExtra(EXTRA_FLAG)));
                break;
            case DECORATE_INDEX_FLAG:
                fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, DecorateIndexFragment.newInstance());
                break;
            case HOUSE_LIST_FLAG:
                HouseListFragment houseListFragment = HouseListFragment.newInstance();
                currentFragment = houseListFragment;
                fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, houseListFragment);
                break;
            case DECORATE_COMPANY_LIST_FLAG:
                DecorateCompanyListFragment decorateCompanyListFragment = DecorateCompanyListFragment.newInstance();
                currentFragment = decorateCompanyListFragment;
                fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, decorateCompanyListFragment);
                break;
            case MATERIALS_LIST_FLAG:
                fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, MaterialsListFragment.newInstance());
                break;
            case HOUSE_INFO_FLAG:
                fragmentTransaction.replace(R.id.id_fl_activity_fragment_container, HouseInfoFragment.newInstance());
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }


    public static void startFragmentsActivity(Context context, String title, int id, Bundle extra) {
        Intent intent = new Intent(context, FragmentContainerActivity.class);
        intent.putExtra(FragmentContainerActivity.FRAGMENT_FLAG, id);
        intent.putExtra(FragmentContainerActivity.TITLE_FLAG, title);
        intent.putExtra(FragmentContainerActivity.EXTRA_FLAG, extra);
        context.startActivity(intent);
    }

    public static void startFragmentsActivity(Context context, String title, int id) {
        Intent intent = new Intent(context, FragmentContainerActivity.class);
        intent.putExtra(FragmentContainerActivity.FRAGMENT_FLAG, id);
        intent.putExtra(FragmentContainerActivity.TITLE_FLAG, title);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (currentFragment != null) {
            if (currentFragment.onBackPress()) {
                currentFragment.onBackPressProcess();
                return;
            }
        }
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (currentFragment != null) {
            currentFragment = null;
        }
    }
}
