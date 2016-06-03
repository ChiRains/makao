package com.qcloud.component.publicservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.parameter.ParamType;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.publicservice.model.AboutusConfig;
import com.qcloud.component.publicservice.service.AboutusConfigService;

@Service
public class AboutusConfigServiceImpl implements AboutusConfigService {
    @Autowired
    private ParameterClient parameterClientImpl;
    
    private final static String APP_ABOUTUS_SETTING="app-aboutus-setting";

    @Override
    public AboutusConfig get() {
        AboutusConfig cfg=new AboutusConfig();
        String aboutusSetting=parameterClientImpl.get(APP_ABOUTUS_SETTING);
        cfg.setAboutusSetting(aboutusSetting);
        return cfg;
    }

    @Override
    public void set(AboutusConfig aboutusConfig) {
        parameterClientImpl.reg(APP_ABOUTUS_SETTING, aboutusConfig.getAboutusSetting(), ParamType.STRING);

    }
}
