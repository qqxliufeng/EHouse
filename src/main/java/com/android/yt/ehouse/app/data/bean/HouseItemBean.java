package com.android.yt.ehouse.app.data.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by feng on 2017/6/23.
 */

public class HouseItemBean implements MultiItemEntity {

    private int itemType;

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
