package com.qcloud.component.publicservice.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.publicservice.SmsMessageLimitClient;
import com.qcloud.component.publicservice.exception.PublicServiceException;
import com.qcloud.component.publicservice.service.SmsMessageLimitService;

@Component
public class SmsMessageLimitClientImpl implements SmsMessageLimitClient {

    @Autowired
    private SmsMessageLimitService smsMessageLimitService;

    @Override
    public SmsMessageStateType canSend(String mobile, String templateKey) {

        int result = smsMessageLimitService.canSend(mobile, templateKey);
        if (result == 1) {
            return SmsMessageStateType.OK;
        } else if (result == 2) {
            return SmsMessageStateType.NUMBER_LIMIT;
        } else if (result == 3) {
            return SmsMessageStateType.TIME_LIMIT;
        }
        throw new PublicServiceException("发送短信限制约束程序程序内部错误." + result);
    }

    @Override
    public boolean send(String mobile, String templateKey, int minutes) {

        return smsMessageLimitService.send(mobile, templateKey, minutes);
    }
}
