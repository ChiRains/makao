package com.qcloud.component.publicservice.dao;

public interface WeiXinAPIDao {

    String getAccessToken(String appid, String appsecret);

    String getJsapiTicket(String appid, String appsecret);
}
