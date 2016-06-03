package com.qcloud.component.publicservice;

import com.qcloud.component.publicservice.model.WeiXinConfig;
import com.tencent.entity.WXUserEntity;

public interface WeiXinConfigClient {

    WeiXinConfig getWeiXinConfig();

    String getJSSDKSign(String nonceStr, Long timestamp, String url);

    WXUserEntity getUserEntity(String openId);
}
