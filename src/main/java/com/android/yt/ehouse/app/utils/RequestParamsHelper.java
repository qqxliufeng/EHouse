package com.android.yt.ehouse.app.utils;

import android.text.TextUtils;

import java.util.HashMap;

/**
 * Created by feng on 2016/10/16.
 */

public class RequestParamsHelper {

    public static final class RequestMod_ORGANIZATION {

        /**
         * mod name
         */
        static final String ORGANIZATION_NAME = "organization";

        /**
         * 装修公司列表
         */
        static final String GET_DECO_COMPANY_LIST = "decoCompanyList";

        public static HashMap<String, Object> getDecoCompanyList(String recommend,
                                                                 String city_id,
                                                                 String service_range,
                                                                 String price,
                                                                 String style,
                                                                 int page) {
            HashMap<String, Object> requestParams = RequestParamsHelper.getRequestParams(ORGANIZATION_NAME, GET_DECO_COMPANY_LIST);
            requestParams.put("recommend", TextUtils.isEmpty(recommend) ? "" : recommend);
            requestParams.put("city_id", TextUtils.isEmpty(city_id) ? "" : city_id);
            requestParams.put("service_range", TextUtils.isEmpty(service_range) ? "" : service_range);
            requestParams.put("price", TextUtils.isEmpty(price) ? "" : price);
            requestParams.put("style", TextUtils.isEmpty(style) ? "" : style);
            requestParams.put("page", page);
            return requestParams;
        }

        /**
         * 装修公司查询条件
         */
        static final String GET_DECO_SEARCH_MAP = "getDecoSearchMap";

        public static HashMap<String, Object> getDecoSearchMap() {
            return RequestParamsHelper.getRequestParams(ORGANIZATION_NAME, GET_DECO_SEARCH_MAP);
        }


        /**
         * 装修公司详情
         */
        static final String DECO_COMPANY_DETAIL = "decoCompanyDetail";

        public static HashMap<String, Object> decoCompanyDetail(String orgId) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(ORGANIZATION_NAME, DECO_COMPANY_DETAIL);
            params.put("org_id", orgId);
            return params;
        }

        /**
         * 装修公司日记列表
         */
        static final String GET_DIARY_LIST = "diaryList";

        public static HashMap<String, Object> getDiaryList(String org_id, String recommend) {
            HashMap<String, Object> requestParams = RequestParamsHelper.getRequestParams(ORGANIZATION_NAME, GET_DIARY_LIST);
            requestParams.put("org_id", org_id);
            requestParams.put("recommend", recommend);
            return requestParams;
        }

        /**
         * 装修公司详情（工商  简介  注册信息）
         */
        static final String GET_BASE_COMPANY_INFO = "baseCompanyInfo";

        public static HashMap<String, Object> getBaseCompanyInfo(String org_id, String action) {
            HashMap<String, Object> requestParams = RequestParamsHelper.getRequestParams(ORGANIZATION_NAME, GET_BASE_COMPANY_INFO);
            requestParams.put("org_id", org_id);
            requestParams.put("method", action);
            return requestParams;
        }

        static final String LAW_SEARCH = "lawSearch";

        public static HashMap<String, Object> getLawSearch(String key) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(ORGANIZATION_NAME, LAW_SEARCH);
            params.put("keyword", key);
            return params;
        }

        static final String GET_ALL_COOPERATION_TYPE = "getAllCooperationType";

        public static HashMap<String, Object> getAllCooperationType() {
            return RequestParamsHelper.getRequestParams(ORGANIZATION_NAME, GET_ALL_COOPERATION_TYPE);
        }

        static final String GET_POLICY_LIST = "getPolicyList";

        public static HashMap<String, Object> getPolicyList(String page) {
            HashMap<String, Object> requestParams = RequestParamsHelper.getRequestParams(ORGANIZATION_NAME, GET_POLICY_LIST);
            requestParams.put("page", page);
            return requestParams;
        }


        static final String CREATE_LITIGATION_INFO = "createLitigationInfo";

        public static HashMap<String, Object> createLitigationInfo(HashMap<String, Object> param) {
            HashMap<String, Object> requestParams = RequestParamsHelper.getRequestParams(ORGANIZATION_NAME, CREATE_LITIGATION_INFO);
            requestParams.put("data", param);
            return requestParams;
        }

        static final String GET_LITIGATION_LIST = "getLitigationList";

        public static HashMap<String, Object> getLitigationList(int type, String typeId, String page) {
            HashMap<String, Object> requestParams = RequestParamsHelper.getRequestParams(ORGANIZATION_NAME, GET_LITIGATION_LIST);
            requestParams.put("page", page);
            switch (type) {
                case 1://债务人
                    requestParams.put("debtorId", typeId);
                    break;
                case 2://债权人
                    requestParams.put("creditorId", typeId);
                    break;
                default:
                    break;
            }
            return requestParams;
        }

        static final String GET_LITIGATION_PERSON_LIST = "getLitigationPersonList";

        public static HashMap<String, Object> getLitigationPersonList(String type, String name, String idcard, String page) {
            HashMap<String, Object> requestParams = RequestParamsHelper.getRequestParams(ORGANIZATION_NAME, GET_LITIGATION_PERSON_LIST);
            requestParams.put("type", type);
            requestParams.put("name", name);
            requestParams.put("idcard", idcard);
            requestParams.put("page", page);
            return requestParams;
        }

        static final String POLICY_FEED_BACK = "policyFeedback";

        public static HashMap<String, Object> policyFeedback(String id, String result, String result_attach_id) {
            HashMap<String, Object> requestParams = RequestParamsHelper.getRequestParams(ORGANIZATION_NAME, POLICY_FEED_BACK);
            requestParams.put("id", id);
            requestParams.put("result", result);
            requestParams.put("result_attach_id", result_attach_id);
            return requestParams;
        }
    }

    public static final class RequestMod_HOUSE {

        static final String MOD_NAME = "house";

        static final String GET_DIARY_LIST = "diaryList";

        public static HashMap<String, Object> getDiaryList(String org_id, String recommend) {
            HashMap<String, Object> requestParams = getRequestParams(MOD_NAME, GET_DIARY_LIST);
            requestParams.put("recommend", TextUtils.isEmpty(recommend) ? "" : recommend);
            requestParams.put("org_id", TextUtils.isEmpty(org_id) ? "" : org_id);
            return requestParams;
        }

        static final String GEN_DESIGN_DETAIL = "diaryDetail";

        public static HashMap<String, Object> getDiaryDetail(String id) {
            HashMap<String, Object> requestParams = getRequestParams(MOD_NAME, GEN_DESIGN_DETAIL);
            requestParams.put("id", TextUtils.isEmpty(id) ? "" : id);
            return requestParams;
        }

        static final String GEN_DESIGN_LIST = "designList";

        public static HashMap<String, Object> getDesignList(String org_id, String recommend) {
            HashMap<String, Object> requestParams = getRequestParams(MOD_NAME, GEN_DESIGN_LIST);
            requestParams.put("recommend", TextUtils.isEmpty(recommend) ? "" : recommend);
            requestParams.put("org_id", TextUtils.isEmpty(org_id) ? "" : org_id);
            return requestParams;
        }

        static final String GET_EVALUATE_LIST = "evaluateList";

        public static HashMap<String, Object> getEvaluateList(String org_id, String recommend) {
            HashMap<String, Object> requestParams = getRequestParams(MOD_NAME, GET_EVALUATE_LIST);
            requestParams.put("recommend", TextUtils.isEmpty(recommend) ? "" : recommend);
            requestParams.put("org_id", TextUtils.isEmpty(org_id) ? "" : org_id);
            return requestParams;
        }

        /**
         * 房产大厅列表
         */
        static final String GET_HOUSE_LIST = "houseList";

        public static HashMap<String, Object> getHouseList(int page) {
            HashMap<String, Object> requestParams = getRequestParams(MOD_NAME, GET_HOUSE_LIST);
            requestParams.put("page", String.valueOf(page));
            return requestParams;
        }

        /**
         * 房产楼盘详情
         */
        static final String GET_HOUSE_DETAIL = "houseDetail";

        public static HashMap<String, Object> getHouseDetail(String id) {
            HashMap<String, Object> requestParams = getRequestParams(MOD_NAME, GET_HOUSE_DETAIL);
            requestParams.put("id", id);
            return requestParams;
        }


    }

    public static final class RequestMod_USER {

        static final String MOD_NAME = "user";

        static final String GET_CONTACTS_LIST = "getContactsList";

        public static HashMap<String, Object> getUserContactsListParams() {
            return getRequestParams(MOD_NAME, GET_CONTACTS_LIST);
        }

        static final String LOGIN = "login";

        public static HashMap<String, Object> login(String... args) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(MOD_NAME, LOGIN);
            params.put("username", args[0]);
            params.put("password", args[1]);
            return params;
        }

        static final String GET_PDLOG_LIST = "getPdLogList";

        public static HashMap<String, Object> getPdLogList(String type, String value, String page) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(MOD_NAME, GET_PDLOG_LIST);
            if ("maxAmount".equals(type)) {
                params.put("maxAmount", value);
            } else {
                params.put("minAmount", value);
            }
            params.put("page", page);
            return params;
        }

        static final String GET_BP_LOG_LIST = "getBPLogList";

        public static HashMap<String, Object> getBPLogList(String type, String value, String page) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(MOD_NAME, GET_BP_LOG_LIST);
            if ("maxAmount".equals(type)) {
                params.put("maxAmount", value);
            } else {
                params.put("minAmount", value);
            }
            params.put("page", page);
            return params;
        }

        static final String PD_RECHARGE = "pdRecharge";

        public static HashMap<String, Object> pdRecharge(String amount, String payCode) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(MOD_NAME, PD_RECHARGE);
            params.put("amount", amount);
            params.put("pay_code", payCode);
            return params;
        }

        static final String GET_MY_SHIPPING_ADDRESS_LIST = "getMyShippingAddressList";

        public static HashMap<String, Object> getMyShippingAddressList(String page) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(MOD_NAME, GET_MY_SHIPPING_ADDRESS_LIST);
            params.put("page", page);
            return params;
        }

        static final String CREATE_SHIPPING_ADDRESS = "createShippingAddress";

        public static HashMap<String, Object> createShippingAddress(HashMap<String, Object> data) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(MOD_NAME, CREATE_SHIPPING_ADDRESS);
            params.put("data", data);
            return params;
        }

        static final String EDIT_SHIPPING_ADDRESS_BY_ID = "editShippingAddressById";

        public static HashMap<String, Object> editShippingAddressById(String id, HashMap<String, Object> data) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(MOD_NAME, EDIT_SHIPPING_ADDRESS_BY_ID);
            params.put("id", id);
            params.put("data", data);
            return params;
        }

        static final String DELETE_SHIPPING_ADDRESS_BY_ID = "deleteShippingAddressById";

        public static HashMap<String, Object> deleteShippingAddressById(String id) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(MOD_NAME, DELETE_SHIPPING_ADDRESS_BY_ID);
            params.put("id", id);
            return params;
        }

        static final String SET_DEFAULT_SHIPPING_ADDRESS_BY_ID = "setDefaultShippingAddressById";

        public static HashMap<String, Object> setDefaultShippingAddressById(String id) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(MOD_NAME, SET_DEFAULT_SHIPPING_ADDRESS_BY_ID);
            params.put("id", id);
            return params;
        }

        static final String GET_MY_DEFAULT_SHIPPING_ADDRESS = "getMyDefaultShippingAddress";

        public static HashMap<String, Object> getMyDefaultShippingAddress() {
            return RequestParamsHelper.getRequestParams(MOD_NAME, GET_MY_DEFAULT_SHIPPING_ADDRESS);
        }
    }

    public static final class RequestMod_ORDER {

        static final String MOD_NAME = "order";

        static final String CREATE_ORDER = "create";


        static final String CREATE_DEMAND = "createDemand";


        static final String ACCEPT_DEMAND = "acceptDemand";

        public static HashMap<String, Object> acceptDemand(String orderSN) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(MOD_NAME, ACCEPT_DEMAND);
            params.put("orderSn", orderSN);
            return params;
        }

        static final String REFUND = "refund";

        public static HashMap<String, Object> refund(String orderSN) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(MOD_NAME, REFUND);
            params.put("orderSn", orderSN);
            return params;
        }

        static final String RECEIVER = "receive";

        public static HashMap<String, Object> receiver(String orderSN) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(MOD_NAME, RECEIVER);
            params.put("orderSn", orderSN);
            return params;
        }

        static final String SEND = "SEND";

        public static HashMap<String, Object> send(String orderSN) {
            HashMap<String, Object> params = RequestParamsHelper.getRequestParams(MOD_NAME, SEND);
            params.put("orderSn", orderSN);
            return params;
        }

        static final String PAY = "pay";

        public static HashMap<String, Object> pay(String usePredeposit, String usePredepositAmount, String paySn, String payCode, String addressId) {
            HashMap<String, Object> params = getRequestParams(MOD_NAME, PAY);
            params.put("usePredeposit", usePredeposit);
            params.put("usePredepositAmount", usePredepositAmount);
            params.put("orderSn", paySn);
            params.put("pay_code", payCode);
            params.put("address_id", addressId);
            return params;
        }
    }

    public static final class RequestMod_AD {

        static final String MOD_NAME = "ad";

        static final String GET_AD_LIST = "adList";

        public static HashMap<String, Object> getIndexADList() {
            return RequestParamsHelper.getRequestParams(MOD_NAME, GET_AD_LIST);
        }

    }

    public static final class RequestMod_COMMON {

        static final String MOD_NAME = "common";

        static final String GET_COMMON_INDEX = "commonIndex";

        public static HashMap<String, Object> getCommonIndex() {
            return getRequestParams(MOD_NAME, GET_COMMON_INDEX);
        }

    }


    private static HashMap<String, Object> getRequestParams(String modName, String actName) {
        HashMap<String, Object> params = new HashMap<>();
        params.put(Constants.INSTANCE.MOD, modName);
        params.put(Constants.INSTANCE.ACT, actName);
        return params;
    }

}
