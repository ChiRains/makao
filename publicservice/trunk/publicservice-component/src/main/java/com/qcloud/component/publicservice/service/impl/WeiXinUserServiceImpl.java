package com.qcloud.component.publicservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.publicservice.dao.WeiXinUserDao;
import com.qcloud.component.publicservice.model.WeiXinConfig;
import com.qcloud.component.publicservice.service.WeiXinConfigService;
import com.qcloud.component.publicservice.service.WeiXinUserService;

@Service
public class WeiXinUserServiceImpl implements WeiXinUserService {

    @Autowired
    WeiXinUserDao       weiXinUserDao;

    @Autowired
    WeiXinConfigService weiXinConfigService;

    @Override
    public String requestOpenId(String code) {

        WeiXinConfig weiXinConfig = weiXinConfigService.get();
        return weiXinUserDao.requestOpenId(weiXinConfig.getAppId(), weiXinConfig.getAppSecret(), code);
    }
}
