package com.qcloud.component.publicservice.model;

public class WeiXinConfig {

    private String appId;

    private String appSecret;

    private String mchID;

    private String certPassword;

    private String key;

    public String getAppId() {

        return appId;
    }

    public void setAppId(String appId) {

        this.appId = appId;
    }

    public String getAppSecret() {

        return appSecret;
    }

    public void setAppSecret(String appSecret) {

        this.appSecret = appSecret;
    }

    public String getMchID() {

        return mchID;
    }

    public void setMchID(String mchID) {

        this.mchID = mchID;
    }

    public String getCertPassword() {

        return certPassword;
    }

    public void setCertPassword(String certPassword) {

        this.certPassword = certPassword;
    }

    public String getKey() {

        return key;
    }

    public void setKey(String key) {

        this.key = key;
    }
}
