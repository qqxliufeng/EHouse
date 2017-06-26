package com.android.yt.ehouse.app.data.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by feng on 2017/6/23.
 */

public class BaseTypeItemBean implements MultiItemEntity{

    public int itemType;

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
