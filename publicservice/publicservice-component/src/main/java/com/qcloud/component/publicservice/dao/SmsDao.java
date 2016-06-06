package com.qcloud.component.publicservice.dao;

import com.qcloud.component.publicservice.model.SmsResult;
import com.qcloud.component.publicservice.model.Ums86Config;

public interface SmsDao {

    SmsResult[] send(Ums86Config config, String content, String... receivers);
}
