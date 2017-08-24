package com.android.yt.ehouse.app.data.bean;

/**
 * Created by feng on 2017/8/23.
 */

public class DecorateCompanyDetailBean {

    private String businessKey;
    private String introduceKey;
    private String value;
    private int index;
    private String introduce;


    public int getIndex() {
        return index;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getIntroduceKey() {
        return introduceKey;
    }

    public void setIntroduceKey(String introduceKey) {
        switch (introduceKey) {
            case "scale":
                introduceKey = "公司规模";
                this.index = 0;
                break;
            case "after_service":
                introduceKey = "售后服务";
                this.index = 1;
                break;
            case "prime_design":
                introduceKey = "初期设计/量房";
                this.index = 2;
                break;
            case "prime_offer":
                introduceKey = "初期预算/洽谈方式";
                this.index = 3;
                break;
            case "deepen_design":
                introduceKey = "深化设计";
                this.index = 4;
                break;
            case "deepen_offer":
                introduceKey = "深化预算";
                this.index = 5;
                break;
            case "material_quality":
                introduceKey = "材料质量";
                this.index = 6;
                break;
            case "contract":
                introduceKey = "合同规范性";
                this.index = 7;
                break;
            case "special_service":
                introduceKey = "物色服务";
                this.index = 8;
                break;
            case "public_deco":
                introduceKey = "服务专长";
                this.index = 9;
                break;
            case "range_service":
                introduceKey = "服务区域";
                this.index = 10;
                break;
            case "accept_price":
                introduceKey = "承接价位";
                this.index = 11;
                break;
            case "focus_style":
                introduceKey = "专长风格";
                this.index = 12;
                break;
            case "intro":
                introduceKey = "公司简介";
                this.index = 13;
                break;
        }
        this.introduceKey = introduceKey;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        switch (businessKey) {
            case "reg_fund":
                businessKey = "注册资金";
                this.index = 3;
                break;
            case "legal_person":
                businessKey = "法定代表人";
                this.index = 10;
                break;
            case "company_name":
                businessKey = "公司名称";
                this.index = 0;
                break;
            case "company_type":
                businessKey = "企业类型";
                this.index = 1;
                break;
            case "reg_pos":
                businessKey = "注册地址";
                this.index = 2;
                break;
            case "business_range":
                businessKey = "经营范围";
                this.index = 7;
                break;
            case "business_term":
                businessKey = "营业期限";
                this.index = 4;
                break;
            case "reg_authority":
                businessKey = "登记机关";
                this.index = 6;
                break;
            case "establish_time":
                businessKey = "成立日期";
                this.index = 5;
                break;
            case "reg_no":
                businessKey = "注册号";
                this.index = 9;
                break;
            case "renewal":
                businessKey = "年检时间";
                this.index = 8;
                break;
        }
        this.businessKey = businessKey;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
