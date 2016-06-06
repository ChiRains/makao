package com.qcloud.component.publicservice.dao;

public interface SmsMessageLimitDao {

    boolean send(String mobile, String templateKey, int limitMinutes);

    // 获取发送次数
    int getNumber(String mobile, String templateKey);

    // 获取上次发送时间
    long getTime(String mobile, String templateKey);
}
