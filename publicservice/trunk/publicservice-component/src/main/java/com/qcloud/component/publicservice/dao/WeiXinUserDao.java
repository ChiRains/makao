package com.qcloud.component.publicservice.dao;

public interface WeiXinUserDao {

    String requestOpenId(String appid, String appsecret, String code);
}
