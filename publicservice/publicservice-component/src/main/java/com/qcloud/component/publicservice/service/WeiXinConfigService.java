package com.qcloud.component.publicservice.service;

import com.qcloud.component.publicservice.model.WeiXinConfig;

public interface WeiXinConfigService {

    WeiXinConfig get();

    boolean set(WeiXinConfig config);
}
