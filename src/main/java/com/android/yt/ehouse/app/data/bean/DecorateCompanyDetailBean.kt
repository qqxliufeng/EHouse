package com.android.yt.ehouse.app.data.bean

/**
 * Created by feng on 2017/8/23.
 */

class DecorateCompanyDetailBean {

    var businessKey: String? = null
        set(businessKey) {
            var businessKey = businessKey
            when (businessKey) {
                "reg_fund" -> {
                    businessKey = "注册资金"
                    this.index = 3
                }
                "legal_person" -> {
                    businessKey = "法定代表人"
                    this.index = 10
                }
                "company_name" -> {
                    businessKey = "公司名称"
                    this.index = 0
                }
                "company_type" -> {
                    businessKey = "企业类型"
                    this.index = 1
                }
                "reg_pos" -> {
                    businessKey = "注册地址"
                    this.index = 2
                }
                "business_range" -> {
                    businessKey = "经营范围"
                    this.index = 7
                }
                "business_term" -> {
                    businessKey = "营业期限"
                    this.index = 4
                }
                "reg_authority" -> {
                    businessKey = "登记机关"
                    this.index = 6
                }
                "establish_time" -> {
                    businessKey = "成立日期"
                    this.index = 5
                }
                "reg_no" -> {
                    businessKey = "注册号"
                    this.index = 9
                }
                "renewal" -> {
                    businessKey = "年检时间"
                    this.index = 8
                }
            }
            field = businessKey
        }
    var introduceKey: String? = null
        set(introduceKey) {
            var introduceKey = introduceKey
            when (introduceKey) {
                "scale" -> {
                    introduceKey = "公司规模"
                    this.index = 0
                }
                "after_service" -> {
                    introduceKey = "售后服务"
                    this.index = 1
                }
                "prime_design" -> {
                    introduceKey = "初期设计/量房"
                    this.index = 2
                }
                "prime_offer" -> {
                    introduceKey = "初期预算/洽谈方式"
                    this.index = 3
                }
                "deepen_design" -> {
                    introduceKey = "深化设计"
                    this.index = 4
                }
                "deepen_offer" -> {
                    introduceKey = "深化预算"
                    this.index = 5
                }
                "material_quality" -> {
                    introduceKey = "材料质量"
                    this.index = 6
                }
                "contract" -> {
                    introduceKey = "合同规范性"
                    this.index = 7
                }
                "special_service" -> {
                    introduceKey = "物色服务"
                    this.index = 8
                }
                "public_deco" -> {
                    introduceKey = "服务专长"
                    this.index = 9
                }
                "range_service" -> {
                    introduceKey = "服务区域"
                    this.index = 10
                }
                "accept_price" -> {
                    introduceKey = "承接价位"
                    this.index = 11
                }
                "focus_style" -> {
                    introduceKey = "专长风格"
                    this.index = 12
                }
                "intro" -> {
                    introduceKey = "公司简介"
                    this.index = 13
                }
            }
            field = introduceKey
        }
    var value: String? = null
    var index: Int = 0
        private set
    var introduce: String? = null
}
