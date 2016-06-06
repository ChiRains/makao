package com.qcloud.component.publicservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.publicservice.dao.SmsDao;
import com.qcloud.component.publicservice.model.SmsResult;
import com.qcloud.component.publicservice.model.Ums86Config;
import com.qcloud.component.publicservice.service.SmsService;
import com.qcloud.component.publicservice.service.Ums86ConfigService;

@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private SmsDao     smsDao;

    @Autowired
    Ums86ConfigService ums86ConfigService;

    // 每天对每个账号可以限量
    @Override
    public SmsResult[] send(String content, String... receivers) {

        Ums86Config ums86Config = ums86ConfigService.get();
        return smsDao.send(ums86Config, content, receivers);
    }
}
