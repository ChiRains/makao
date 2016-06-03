package com.qcloud.component.publicservice;

public interface SmsMessageLimitClient {

    // 发送短信.
    SmsMessageStateType canSend(String mobile, String templateKey);

    boolean send(String mobile, String templateKey, int minutes);
    //
    enum SmsMessageStateType {
        OK, TIME_LIMIT, NUMBER_LIMIT
    }
}
