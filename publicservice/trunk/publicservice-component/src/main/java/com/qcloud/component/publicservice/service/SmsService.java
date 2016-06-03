package com.qcloud.component.publicservice.service;

import com.qcloud.component.publicservice.model.SmsResult;

public interface SmsService {

    SmsResult[] send(String content, String... receivers);
}
