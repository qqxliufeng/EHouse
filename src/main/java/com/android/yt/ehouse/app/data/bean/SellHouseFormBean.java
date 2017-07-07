package com.android.yt.ehouse.app.data.bean;

import com.android.yt.ehouse.app.component.Description;

/**
 * Created by feng on 2017/7/7.
 */

public class SellHouseFormBean {

    @Description(index = 0, description = "小区名称")
    private String houseName;

    @Description(index = 1, description = "楼栋号")
    private String houseBuilding;
    @Description(index = 2, description = "楼栋单元号")
    private String houseNo;
    @Description(index = 3, description = "房屋号")
    private String houseRoom;

    @Description(index = 4, description = "房屋间数")
    private String houseRoomNum;
    @Description(index = 5, description = "房屋厅数")
    private String houseHallNum;
    @Description(index = 6, description = "房屋卫生间个数")
    private String houseToiletNum;

    @Description(index = 7, description = "房屋层数")
    private String houseLayer;
    @Description(index = 8, description = "房屋总层数")
    private String houseLayerCount;

    @Description(index = 9, description = "房屋面积大小")
    private String houseAcreage;

    @Description(index = 10, description = "房屋朝向")
    private String houseDirection;

    @Description(index = 11, description = "房屋售价")
    private String housePrice;

    @Description(index = 12, description = "房屋装修类别")
    private String houseDecorate;

    @Description(index = 13, description = "房屋产权类别")
    private String housePropertyRight;

    @Description(index = 14, description = "房屋类型")
    private String houseType;

    @Description(index = 15, description = "房屋描述")
    private String houseDescription;

    @Description(index = 16, description = "房源联系人姓名")
    private String housePersonName;

    @Description(index = 17, description = "房源联系人手机号")
    private String housePersonPhone;

    @Description(index = 18, description = "手机号验证码")
    private String code;


    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseBuilding() {
        return houseBuilding;
    }

    public void setHouseBuilding(String houseBuilding) {
        this.houseBuilding = houseBuilding;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getHouseRoom() {
        return houseRoom;
    }

    public void setHouseRoom(String houseRoom) {
        this.houseRoom = houseRoom;
    }

    public String getHouseRoomNum() {
        return houseRoomNum;
    }

    public void setHouseRoomNum(String houseRoomNum) {
        this.houseRoomNum = houseRoomNum;
    }

    public String getHouseHallNum() {
        return houseHallNum;
    }

    public void setHouseHallNum(String houseHallNum) {
        this.houseHallNum = houseHallNum;
    }

    public String getHouseToiletNum() {
        return houseToiletNum;
    }

    public void setHouseToiletNum(String houseToiletNum) {
        this.houseToiletNum = houseToiletNum;
    }

    public String getHouseLayer() {
        return houseLayer;
    }

    public void setHouseLayer(String houseLayer) {
        this.houseLayer = houseLayer;
    }

    public String getHouseLayerCount() {
        return houseLayerCount;
    }

    public void setHouseLayerCount(String houseLayerCount) {
        this.houseLayerCount = houseLayerCount;
    }

    public String getHouseAcreage() {
        return houseAcreage;
    }

    public void setHouseAcreage(String houseAcreage) {
        this.houseAcreage = houseAcreage;
    }

    public String getHouseDirection() {
        return houseDirection;
    }

    public void setHouseDirection(String houseDirection) {
        this.houseDirection = houseDirection;
    }

    public String getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(String housePrice) {
        this.housePrice = housePrice;
    }

    public String getHouseDecorate() {
        return houseDecorate;
    }

    public void setHouseDecorate(String houseDecorate) {
        this.houseDecorate = houseDecorate;
    }

    public String getHousePropertyRight() {
        return housePropertyRight;
    }

    public void setHousePropertyRight(String housePropertyRight) {
        this.housePropertyRight = housePropertyRight;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseDescription() {
        return houseDescription;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }

    public String getHousePersonName() {
        return housePersonName;
    }

    public void setHousePersonName(String housePersonName) {
        this.housePersonName = housePersonName;
    }

    public String getHousePersonPhone() {
        return housePersonPhone;
    }

    public void setHousePersonPhone(String housePersonPhone) {
        this.housePersonPhone = housePersonPhone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
