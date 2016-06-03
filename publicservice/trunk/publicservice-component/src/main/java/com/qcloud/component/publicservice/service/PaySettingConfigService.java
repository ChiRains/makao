package com.qcloud.component.publicservice.service;

import com.qcloud.component.publicservice.model.PaySettingConfig;

public interface PaySettingConfigService {

    PaySettingConfig get();
    
    void set(PaySettingConfig config);

    boolean wxEnable();

    boolean wxDisable();

    boolean aliEnable();

    boolean aliDisable();

    boolean unionEnable();

    boolean unionDisable();
}
