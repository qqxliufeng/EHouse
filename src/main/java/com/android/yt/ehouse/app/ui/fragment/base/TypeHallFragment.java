package com.android.yt.ehouse.app.ui.fragment.base;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.application.EHouseApplication;
import com.android.yt.ehouse.app.data.bean.BaseTypeItemBean;
import com.android.yt.ehouse.app.data.bean.TypeHallSellBean;
import com.android.yt.ehouse.app.interfaces.OnClassifySearchContentClickListener;
import com.android.yt.ehouse.app.ui.activity.KtFragmentContainerActivity;
import com.android.yt.ehouse.app.ui.adapter.TypeHallFragmentAdapter;
import com.android.yt.ehouse.app.ui.adapter.TypeHallHotSellAdapter;
import com.android.yt.ehouse.app.ui.fragment.index.BannerFragment;
import com.android.yt.ehouse.app.ui.view.MyLinearLayoutManager;
import com.android.yt.ehouse.app.utils.PaletteUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by feng on 2017/6/23.
 */
public class TypeHallFragment extends BaseRecycleViewFragment<BaseTypeItemBean> implements AppBarLayout.OnOffsetChangedListener, OnClassifySearchContentClickListener {

    public static final String CURRENT_TYPE_FLAG = "current_type_flag";

    public static final int MATERIALS_FLAG = 0x0;
    public static final int HOUSE_HOME_FLAG = 0x1;
    public static final int HOUSEKEEPING_FLAG = 0x2;

    private int currentFlag = 0x0;


    private RecyclerView rv_hot_sell;
    private ArrayList<TypeHallSellBean> hotList = new ArrayList<>();

    @BindView(R.id.id_abl_home_tool_bar_container)
    AppBarLayout al_container;
    @BindView(R.id.id_cv_fragment_type_hall_search)
    CardView cv_search;
    @BindView(R.id.id_iv_fragment_type_hall_message)
    ImageView iv_message;
    @BindView(R.id.id_iv_fragment_type_hall_back)
    ImageView iv_back;
    @BindView(R.id.id_et_fragment_type_hall_search_content)
    EditText et_search_content;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        currentFlag = getArguments().getInt(CURRENT_TYPE_FLAG);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((KtFragmentContainerActivity) mContext).setAppBarVisibility(View.GONE);
    }

    public static TypeHallFragment newInstance(Bundle args) {
        TypeHallFragment fragment = new TypeHallFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_type_hall_layout;
    }

    @Override
    protected BaseQuickAdapter<BaseTypeItemBean, BaseViewHolder> createAdapter() {
        return new TypeHallFragmentAdapter(mArrayList);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        al_container.addOnOffsetChangedListener(this);
        for (int i = 0; i < 5; i++) {
            BaseTypeItemBean typeItemBean = new BaseTypeItemBean();
            if (i % 2 == 0) {
                typeItemBean.setItemType(0);
            } else {
                typeItemBean.setItemType(1);
            }
            mArrayList.add(typeItemBean);
            hotList.add(new TypeHallSellBean());
        }
        View headerView = View.inflate(mContext, R.layout.fragment_small_house_header_layout, null);
        initDifferentFlagView(headerView);
        rv_hot_sell = (RecyclerView) headerView.findViewById(R.id.id_rv_fragment_type_hall);
        rv_hot_sell.setNestedScrollingEnabled(false);
        rv_hot_sell.setLayoutManager(new MyLinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rv_hot_sell.setAdapter(new TypeHallHotSellAdapter(R.layout.adapter_type_hall_hot_sell_item_layout, hotList));
        mBaseQuickAdapter.addHeaderView(headerView);
        mSwipeRefreshLayout.setEnabled(false);
        onRequestEnd(-1);
        getChildFragmentManager().beginTransaction().replace(R.id.id_fl_fragment_index_banner_layout, BannerFragment.newInstance()).commit();
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    private void initDifferentFlagView(View headerView) {
        TextView tv_one_flag = (TextView) headerView.findViewById(R.id.id_tv_fragment_type_hall_header_one_flag);
        TextView tv_two_flag = (TextView) headerView.findViewById(R.id.id_tv_fragment_type_hall_header_two_flag);
        TextView tv_three_flag = (TextView) headerView.findViewById(R.id.id_tv_fragment_type_hall_header_three_flag);
        tv_one_flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyClick(v);
            }
        });
        final TextView tv_sell_title = (TextView) headerView.findViewById(R.id.id_tv_fragment_type_hall_header_sell_title);
        int currentOneTop = 0;
        int currentTwoTop = 0;
        int currentThreeTop = 0;
        String twoFlagTitle = "";
        int currentSellTitleLeft = 0;
        String currentSellTitle = "";
        String searchContentHint = "";
        switch (currentFlag) {
            case MATERIALS_FLAG:
                currentOneTop = R.drawable.img_jc_flcx_icon;
                currentTwoTop = R.drawable.img_jc_tmsp_icon;
                currentThreeTop = R.drawable.img_jc_gwc_icon;
                currentSellTitleLeft = R.drawable.img_jc_rxsp_icon;
                currentSellTitle = "热销商品";
                twoFlagTitle = "特卖商品";
                searchContentHint = "搜索建材商品";
                break;
            case HOUSE_HOME_FLAG:
                currentOneTop = R.drawable.img_jj_flcx_icon;
                currentTwoTop = R.drawable.img_jj_tmsp_icon;
                currentThreeTop = R.drawable.img_jj_gwc_icon;
                currentSellTitleLeft = R.drawable.img_jj_rxsp_icon;
                currentSellTitle = "热销商品";
                twoFlagTitle = "特卖商品";
                searchContentHint = "搜索家居商品";
                break;
            case HOUSEKEEPING_FLAG:
                currentOneTop = R.drawable.img_jz_flcx_icon;
                currentTwoTop = R.drawable.img_jz_tmfw_icon;
                currentThreeTop = R.drawable.img_jz_gwc_icon;
                currentSellTitleLeft = R.drawable.img_jz_rxsp_icon;
                currentSellTitle = "热门服务";
                twoFlagTitle = "特卖服务";
                searchContentHint = "搜索服务类别";
                break;
        }
        tv_one_flag.setCompoundDrawablesRelativeWithIntrinsicBounds(0, currentOneTop, 0, 0);
        tv_two_flag.setCompoundDrawablesRelativeWithIntrinsicBounds(0, currentTwoTop, 0, 0);
        tv_three_flag.setCompoundDrawablesRelativeWithIntrinsicBounds(0, currentThreeTop, 0, 0);
        tv_sell_title.setCompoundDrawablesRelativeWithIntrinsicBounds(currentSellTitleLeft, 0, 0, 0);
        tv_two_flag.setText(twoFlagTitle);
        tv_sell_title.setText(currentSellTitle);
        et_search_content.setHint(searchContentHint);
        PaletteUtil.getInstance().init(getResources(), currentSellTitleLeft, new PaletteUtil.PatternCallBack() {
            @Override
            public void onCallBack(Drawable drawable, int titleColor, int bgColor) {
                tv_sell_title.setTextColor(bgColor);
            }
        });
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        float alpha = ((float) Math.abs(verticalOffset)) / (float) appBarLayout.getTotalScrollRange();
        cv_search.setAlpha(alpha);
        if (Math.abs(verticalOffset) > appBarLayout.getTotalScrollRange() / 2) {
            iv_message.setColorFilter(Color.GRAY);
            iv_back.setColorFilter(Color.GRAY);
        } else {
            iv_message.setColorFilter(Color.WHITE);
            iv_back.setColorFilter(Color.WHITE);
        }
    }

    @OnClick({R.id.id_iv_fragment_type_hall_back,
            R.id.id_et_fragment_type_hall_search_content})
    public void onMyClick(View view) {
        switch (view.getId()) {
            case R.id.id_iv_fragment_type_hall_back:
                finishActivity();
                break;
            case R.id.id_et_fragment_type_hall_search_content:
                EHouseApplication.getInstance().setOnClassifySearchContentClickListener(this);
                KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext, "", KtFragmentContainerActivity.Companion.getCLASSIFY_SEARCH_FLAG());
                break;
            case R.id.id_tv_fragment_type_hall_header_one_flag:
                switch (currentFlag){
                    case MATERIALS_FLAG:
                        KtFragmentContainerActivity.Companion.startFragmentsActivity(mContext,"",KtFragmentContainerActivity.Companion.getMATERIALS_LIST_FLAG());
                        break;
                }
                break;
            case R.id.id_tv_fragment_type_hall_header_two_flag:
                break;
            case R.id.id_tv_fragment_type_hall_header_three_flag:
                break;
        }
    }

    @Override
    public void onItemViewChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (currentFlag) {
            case MATERIALS_FLAG:
                break;
            case HOUSE_HOME_FLAG:
                break;
            case HOUSEKEEPING_FLAG:
                break;
        }
    }

    @Override
    public <T> void onSearchContentClick(T t) {
        Toast.makeText(mContext, t + "" + this.toString(), Toast.LENGTH_SHORT).show();
    }
}
