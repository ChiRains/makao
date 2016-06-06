package com.qcloud.component.publicservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.publicservice.dao.SmsMessageLimitDao;
import com.qcloud.component.publicservice.exception.PublicServiceException;
import com.qcloud.component.publicservice.service.SmsMessageLimitService;

@Service
public class SmsMessageLimitServiceImpl implements SmsMessageLimitService {

    @Autowired
    private SmsMessageLimitDao smsMessageLimitDao;

    // 走系统参数
    private int                MAX_TIMES_PER_DAY = 20;

    private static final int   MAX_MINUTES       = 30;

    @Override
    public int canSend(String mobile, String templateKey) {

        long time = smsMessageLimitDao.getTime(mobile, templateKey);
        int number = smsMessageLimitDao.getNumber(mobile, templateKey);
        if (number > MAX_TIMES_PER_DAY) {
            return 2;
        }
        if (time != -1) {
            return 3;
        }
        return 1;
    }

    @Override
    public boolean send(String mobile, String templateKey, int minutes) {

        if (minutes <= 0) {
            throw new PublicServiceException("发送短信时间分钟间隔不能小于零." + minutes);
        }
        if (minutes > MAX_MINUTES) {
            throw new PublicServiceException("发送短信时间分钟间隔不能大于" + MAX_MINUTES + "." + minutes);
        }
        return smsMessageLimitDao.send(mobile, templateKey, minutes);
    }
}
