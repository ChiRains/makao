package com.qcloud.component.publicservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.publicservice.dao.WeiXinAPIDao;
import com.qcloud.component.publicservice.service.WeiXinAPIService;

@Service
public class WeiXinAPIServiceImpl implements WeiXinAPIService {

    @Autowired
    private WeiXinAPIDao weiXinAPIDao;

    @Override
    public String getAccessToken(String appid, String appsecret) {

        return weiXinAPIDao.getAccessToken(appid, appsecret);
    }

    @Override
    public String getJsapiTicket(String appid, String appsecret) {

        return weiXinAPIDao.getJsapiTicket(appid, appsecret);
    }
}
