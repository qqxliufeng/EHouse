package com.android.yt.ehouse.app.ui.fragment.bottom;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by feng on 2017/6/15.
 */

public class IndexThreeFragment extends Fragment{

    public static IndexThreeFragment newInstance() {
        return  new IndexThreeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(android.R.layout.simple_list_item_1,container,false);
        view.setBackgroundColor(Color.BLACK);
        return view;
    }
}
