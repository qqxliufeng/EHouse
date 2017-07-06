package com.android.yt.ehouse.app.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;

import com.android.yt.ehouse.app.R;
import com.android.yt.ehouse.app.ui.fragment.base.WebContentFragment;
import com.android.yt.ehouse.app.ui.view.SlideDetailsLayout;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by feng on 2017/7/3.
 */

public class TestActivity extends BaseActivity {

    @BindView(R.id.slidedetails_behind)
    WebView webView;

//    @BindView(R.id.sliding_container)
//    SlideDetailsLayout slideDetailsLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_layout;
    }

    @Override
    public void setPresentComponent() {
    }

    @Override
    public void initView() {
        setSwipeBackEnable(false);
//        slideDetailsLayout.smoothClose(true);
//        slideDetailsLayout.smoothOpen(true);
        final WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("http://www.cnbleu.com");
            }
        });

//        ListFragment listFragment = new ListFragment();
//        ArrayList<String> arrayList = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            arrayList.add("item" + i);
//        }
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayList);
//        listFragment.setListAdapter(arrayAdapter);
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.slidedetails_front, listFragment)
//                .commit();
    }
}
