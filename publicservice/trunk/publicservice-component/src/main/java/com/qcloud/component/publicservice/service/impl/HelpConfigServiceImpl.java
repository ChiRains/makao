package com.qcloud.component.publicservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.parameter.ParamType;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.publicservice.model.HelpConfig;
import com.qcloud.component.publicservice.service.HelpConfigService;

@Service
public class HelpConfigServiceImpl implements HelpConfigService {
    @Autowired
    private ParameterClient parameterClientImpl;
    
    private final static String APP_HELP_SETTING="app-help-setting";

    @Override
    public HelpConfig get() {
        HelpConfig helpConfig=new HelpConfig();
        String helpSetting=parameterClientImpl.get(APP_HELP_SETTING);
        helpConfig.setHelpSetting(helpSetting);
        return helpConfig;
    }

    @Override
    public void set(HelpConfig helpConfig) {
        parameterClientImpl.reg(APP_HELP_SETTING, helpConfig.getHelpSetting(), ParamType.STRING);

    }
}
