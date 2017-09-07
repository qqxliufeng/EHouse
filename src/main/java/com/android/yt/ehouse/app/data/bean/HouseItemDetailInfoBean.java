package com.android.yt.ehouse.app.data.bean;

import java.util.ArrayList;

/**
 * Created by feng on 2017/9/6.
 */

public class HouseItemDetailInfoBean {

    private HouseItemDetailInfoForInfoBean info;
    private HouseItemDetailInfoForCommunityBean community;
    private HouseItemDetailInfoForCommunityBeanDescription description;

    public HouseItemDetailInfoForInfoBean getInfo() {
        return info;
    }

    public void setInfo(HouseItemDetailInfoForInfoBean info) {
        this.info = info;
    }

    public HouseItemDetailInfoForCommunityBean getCommunity() {
        return community;
    }

    public void setCommunity(HouseItemDetailInfoForCommunityBean community) {
        this.community = community;
    }

    public HouseItemDetailInfoForCommunityBeanDescription getDescription() {
        return description;
    }

    public void setDescription(HouseItemDetailInfoForCommunityBeanDescription description) {
        this.description = description;
    }

    public static class HouseItemDetailInfoForInfoBean {
        private String address;
        private String price;
        private String title;
        private String floor_num;
        private String area;
        private String floor_max;
        private String unitprice;
        private String compose;
        private String house_direction_str;
        private ArrayList<String> picList;
        private String area_name;

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public String getAddress() {

            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

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

        public String getFloor_num() {
            return floor_num;
        }

        public void setFloor_num(String floor_num) {
            this.floor_num = floor_num;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getFloor_max() {
            return floor_max;
        }

        public void setFloor_max(String floor_max) {
            this.floor_max = floor_max;
        }

        public String getUnitprice() {
            return unitprice;
        }

        public void setUnitprice(String unitprice) {
            this.unitprice = unitprice;
        }

        public String getCompose() {
            return compose;
        }

        public void setCompose(String compose) {
            this.compose = compose;
        }

        public String getHouse_direction_str() {
            return house_direction_str;
        }

        public void setHouse_direction_str(String house_direction_str) {
            this.house_direction_str = house_direction_str;
        }

        public ArrayList<String> getPicList() {
            return picList;
        }

        public void setPicList(ArrayList<String> picList) {
            this.picList = picList;
        }
    }

    public static class HouseItemDetailInfoForCommunityBean {
        private String address;
        private String greening_rate;
        private String floor_area;
        private String pos;
        private String plot_ratio;
        private String households_num;
        private String parking_space;
        private String property_fee;
        private String owner_mobile;

        public String getProperty_fee() {
            return property_fee;
        }

        public void setProperty_fee(String property_fee) {
            this.property_fee = property_fee;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getGreening_rate() {
            return greening_rate;
        }

        public void setGreening_rate(String greening_rate) {
            this.greening_rate = greening_rate;
        }

        public String getFloor_area() {
            return floor_area;
        }

        public void setFloor_area(String floor_area) {
            this.floor_area = floor_area;
        }

        public String getPos() {
            return pos;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        public String getPlot_ratio() {
            return plot_ratio;
        }

        public void setPlot_ratio(String plot_ratio) {
            this.plot_ratio = plot_ratio;
        }

        public String getHouseholds_num() {
            return households_num;
        }

        public void setHouseholds_num(String households_num) {
            this.households_num = households_num;
        }

        public String getOwner_mobile() {
            return owner_mobile;
        }

        public void setOwner_mobile(String owner_mobile) {
            this.owner_mobile = owner_mobile;
        }

        public String getParking_space() {
            return parking_space;
        }

        public void setParking_space(String parking_space) {
            this.parking_space = parking_space;
        }
    }

    public static class HouseItemDetailInfoForCommunityBeanDescription {
        private String building_time;
        private String property_rights;
        private String decoration_str;
        private String house_type_str;
        private String describe;

        public String getProperty_rights() {
            return property_rights;
        }

        public void setProperty_rights(String property_rights) {
            this.property_rights = property_rights;
        }

        public String getDecoration_str() {
            return decoration_str;
        }

        public void setDecoration_str(String decoration_str) {
            this.decoration_str = decoration_str;
        }

        public String getBuilding_time() {
            return building_time;
        }

        public void setBuilding_time(String building_time) {
            this.building_time = building_time;
        }

        public String getHouse_type_str() {
            return house_type_str;
        }

        public void setHouse_type_str(String house_type_str) {
            this.house_type_str = house_type_str;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }
    }
}
