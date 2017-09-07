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


    private String price;
    private String title;
    private String community_name;
    private String id;
    private String area;
    private String compose;
    private String house_type_str;
    private String house_direction_str;
    private String pic;
    private String decoration_str;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCompose() {
        return compose;
    }

    public void setCompose(String compose) {
        this.compose = compose;
    }

    public String getHouse_type_str() {
        return house_type_str;
    }

    public void setHouse_type_str(String house_type_str) {
        this.house_type_str = house_type_str;
    }

    public String getHouse_direction_str() {
        return house_direction_str;
    }

    public void setHouse_direction_str(String house_direction_str) {
        this.house_direction_str = house_direction_str;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDecoration_str() {
        return decoration_str;
    }

    public void setDecoration_str(String decoration_str) {
        this.decoration_str = decoration_str;
    }
}
