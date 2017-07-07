package com.android.yt.ehouse.app.data.bean;

import java.util.ArrayList;

/**
 * Created by feng on 2017/7/5.
 */

public class GoodsItemBean {

    private int flag;
    private String title;
    private boolean sectionSelected;
    private boolean itemSelected;
    private int index;
    private Long addTime;

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public boolean isItemSelected() {
        return itemSelected;
    }

    public void setItemSelected(boolean itemSelected) {
        this.itemSelected = itemSelected;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isSectionSelected() {

        return sectionSelected;
    }

    public void setSectionSelected(boolean sectionSelected) {
        this.sectionSelected = sectionSelected;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int index) {
        this.flag = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
