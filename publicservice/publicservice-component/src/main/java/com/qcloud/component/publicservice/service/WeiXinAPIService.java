package com.qcloud.component.publicservice.service;

public interface WeiXinAPIService {

    public String getAccessToken(String appid, String appsecret);
    
    public String getJsapiTicket(String appid, String appsecret);
}
