package com.qcloud.component.publicservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.parameter.ParamType;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.publicservice.model.ProtocolConfig;
import com.qcloud.component.publicservice.service.ProtocolConfigService;

@Service
public class AppProtocolConfigServiceImpl implements ProtocolConfigService{
    
    @Autowired
    private ParameterClient parameterClient;
    
    private final static String APP_APPPROTOCOL_SETTING = "app-appProtocol-setting";

    @Override
    public ProtocolConfig get() {
        ProtocolConfig cfg=new ProtocolConfig();
        String appProtocolSetting=parameterClient.get(APP_APPPROTOCOL_SETTING);
        cfg.setProtocolSetting(appProtocolSetting);
        return cfg;
    }

    @Override
    public void set(ProtocolConfig protocolConfig) {

    	parameterClient.reg(APP_APPPROTOCOL_SETTING, protocolConfig.getProtocolSetting(), ParamType.STRING);
    }
}
