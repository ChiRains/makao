package com.qcloud.component.publicservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.parameter.ParamType;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.publicservice.model.Ums86Config;
import com.qcloud.component.publicservice.service.Ums86ConfigService;
import com.qcloud.pirates.util.StringUtil;

@Component
public class Ums86ConfigServiceImpl implements Ums86ConfigService {

    @Autowired
    private ParameterClient     parameterClientImpl;

    private final static String ums_enterpriseNumber = "ums-86-enterpriseNumber";

    private final static String ums_adminName        = "ums-86-adminName";

    private final static String sms_adminPsw         = "ums-86-adminPsw";

    private final static String test_mobiles         = "personalcenter-sms-test-mobiles";

    @Override
    public Ums86Config get() {

        String enterpriseNumber = parameterClientImpl.get(ums_enterpriseNumber);
        String adminName = parameterClientImpl.get(ums_adminName);
        String adminPsw = parameterClientImpl.get(sms_adminPsw);
        String testMobiles = parameterClientImpl.get(test_mobiles);
        //
        Ums86Config ums86Config = new Ums86Config();
        ums86Config.setEnterpriseNumber(StringUtil.nullToEmpty(enterpriseNumber));
        ums86Config.setAdminName(StringUtil.nullToEmpty(adminName));
        ums86Config.setAdminPsw(StringUtil.nullToEmpty(adminPsw));
        ums86Config.setTestMobiles(testMobiles);
        return ums86Config;
    }

    @Override
    public boolean set(Ums86Config config) {

        String enterpriseNumber = StringUtil.nullToEmpty(config.getEnterpriseNumber());
        String adminName = StringUtil.nullToEmpty(config.getAdminName());
        String adminPsw = StringUtil.nullToEmpty(config.getAdminPsw());
        String testMobiles = StringUtil.nullToEmpty(config.getTestMobiles());
        //
        parameterClientImpl.reg(ums_enterpriseNumber, enterpriseNumber, ParamType.STRING);
        parameterClientImpl.reg(ums_adminName, adminName, ParamType.STRING);
        parameterClientImpl.reg(sms_adminPsw, adminPsw, ParamType.STRING);
        parameterClientImpl.reg(test_mobiles, testMobiles, ParamType.STRING);
        return true;
    }
}
