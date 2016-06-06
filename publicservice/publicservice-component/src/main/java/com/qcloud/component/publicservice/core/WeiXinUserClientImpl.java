package com.qcloud.component.publicservice.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.publicservice.WeiXinUserClient;
import com.qcloud.component.publicservice.service.WeiXinUserService;

@Component
public class WeiXinUserClientImpl implements WeiXinUserClient {

    @Autowired
    WeiXinUserService weiXinUserService;

    @Override
    public String requestOpenId(String code) {

        return weiXinUserService.requestOpenId(code);
    }
}
