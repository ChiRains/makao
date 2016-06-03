package com.qcloud.component.publicservice.dao;

import com.qcloud.component.publicservice.model.WeiXinPayReqData;

public interface WeiXinPayDao {

    String request(WeiXinPayReqData data, String notifyUrl, String appid, String appsecret, String opneId);

    String request4Web(WeiXinPayReqData data, String notifyUrl, String appid, String appsecret);

    String request4App(WeiXinPayReqData data, String notifyUrl, String appid, String appsecret);
}
