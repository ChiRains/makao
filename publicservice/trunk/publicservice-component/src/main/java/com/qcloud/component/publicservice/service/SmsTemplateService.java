package com.qcloud.component.publicservice.service;

import java.util.List;
import com.qcloud.component.publicservice.model.SmsTemplate;

public interface SmsTemplateService {

    List<SmsTemplate> list();

    boolean save(SmsTemplate smsTemplate);

    String getByCode(String code);
}
