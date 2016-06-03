package com.qcloud.component.publicservice.service;

public interface SmsMessageLimitService {

    // 发送短信.
    int canSend(String mobile, String templateKey);

    //
    boolean send(String mobile, String templateKey, int minutes);
}
