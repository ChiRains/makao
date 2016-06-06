package com.qcloud.component.publicservice.service;

import com.qcloud.component.publicservice.entity.WeiXinAppRequestPayResultEntity;
import com.qcloud.component.publicservice.entity.WeiXinRequestPayResultEntity;
import com.qcloud.component.publicservice.model.WeiXinPayReqData;

public interface WeiXinPayService {

    WeiXinRequestPayResultEntity request(WeiXinPayReqData data, String notifyUrl, String opneId);

    WeiXinAppRequestPayResultEntity request4App(WeiXinPayReqData data, String notifyUrl);

    String request4Web(WeiXinPayReqData data, String notifyUrl);
}
