package com.qcloud.component.publicservice.core;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.publicservice.PayClient;
import com.qcloud.component.publicservice.WeiXinPayClient;
import com.qcloud.component.publicservice.model.PaySettingConfig;
import com.qcloud.component.publicservice.service.PaySettingConfigService;

@Component
public class PayClientImpl implements PayClient {

    @Autowired
    private WeiXinPayClient         weiXinPayClient;

    @Autowired
    private PaySettingConfigService paySettingConfigService;

    @Override
    public WeiXinPayClient getWeiXinPayClient() {

        return weiXinPayClient;
    }

    @Override
    public int getPayMinutes() {

        PaySettingConfig paySettingConfig = paySettingConfigService.get();
        String value = paySettingConfig.getPaySettingTime();
        int dm = 60;
        if (StringUtils.isNotEmpty(value)) {
            return dm;
        }
        int minutes = Integer.parseInt(value);
        return minutes < dm ? dm : minutes;
    }
}
