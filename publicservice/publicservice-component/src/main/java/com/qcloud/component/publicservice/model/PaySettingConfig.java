package com.qcloud.component.publicservice.model;

import org.apache.commons.lang.StringUtils;

public class PaySettingConfig {

    private String wxPaySetting;

    private String aliPaySetting;

    private String unionPaySetting;

    private String paySettingTime;

    private String refundTime;     // 退换货时间

    private String domain;

    private String autoSignTime;   // 自动签收时间

    public String getWxPaySetting() {

        return wxPaySetting;
    }

    public void setWxPaySetting(String wxPaySetting) {

        this.wxPaySetting = wxPaySetting;
    }

    public String getAliPaySetting() {

        return aliPaySetting;
    }

    public void setAliPaySetting(String aliPaySetting) {

        this.aliPaySetting = aliPaySetting;
    }

    public String getUnionPaySetting() {

        return unionPaySetting;
    }

    public void setUnionPaySetting(String unionPaySetting) {

        this.unionPaySetting = unionPaySetting;
    }

    public PaySettingConfig(String wxPaySetting, String aliPaySetting, String unionPaySetting) {

        this.wxPaySetting = wxPaySetting;
        this.aliPaySetting = aliPaySetting;
        this.unionPaySetting = unionPaySetting;
    }

    public PaySettingConfig() {

    }

    public String getPaySettingTime() {

        return paySettingTime;
    }

    public void setPaySettingTime(String paySettingTime) {

        this.paySettingTime = paySettingTime;
    }

    public String getRefundTime() {
        if(StringUtils.isEmpty(refundTime)){
            return "7";
        }
        return refundTime;
    }

    public void setRefundTime(String refundTime) {

        this.refundTime = refundTime;
    }

    public String getDomain() {

        return domain;
    }

    public String getAutoSignTime() {
        if(StringUtils.isEmpty(autoSignTime)){
            return "7";
        }
        return autoSignTime;
    }

    public void setDomain(String domain) {

        this.domain = domain;
    }

    public void setAutoSignTime(String autoSignTime) {

        this.autoSignTime = autoSignTime;
    }
}
