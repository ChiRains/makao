package com.qcloud.component.publicservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.parameter.ParamType;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.publicservice.model.PaySettingConfig;
import com.qcloud.component.publicservice.model.key.TypeEnum.ParamPaySettingType;
import com.qcloud.component.publicservice.service.PaySettingConfigService;

@Component
public class PaySettingConfigServiceImpl implements PaySettingConfigService {

    @Autowired
    private ParameterClient     parameterClientImpl;

    private final static String WEIXIN_PAY_SETTING = "weixin-pay-setting";

    private final static String ALIPAY_PAY_SETTING = "alipay-pay-setting";

    private final static String UNION_PAY_SETTING  = "union-pay-setting";

    private final static String PAY_SETTING_TIME   = "pay-setting-time";

    private final static String REFUND_TIME        = "refund-time";

    private final String        DOMAIN_KEY         = "domain-key";

    private final static String AUTO_SIGN_TIME     = "auto-sign-time";

    @Override
    public boolean wxEnable() {

        // return false;
        return parameterClientImpl.reg(WEIXIN_PAY_SETTING, String.valueOf(ParamPaySettingType.OPEN.getKey()), ParamType.STRING);
    }

    @Override
    public boolean wxDisable() {

        // return false;
        return parameterClientImpl.reg(WEIXIN_PAY_SETTING, String.valueOf(ParamPaySettingType.CLOSE.getKey()), ParamType.STRING);
    }

    @Override
    public boolean aliEnable() {

        // return false;
        return parameterClientImpl.reg(ALIPAY_PAY_SETTING, String.valueOf(ParamPaySettingType.OPEN.getKey()), ParamType.STRING);
    }

    @Override
    public boolean aliDisable() {

        // return false;
        return parameterClientImpl.reg(ALIPAY_PAY_SETTING, String.valueOf(ParamPaySettingType.CLOSE.getKey()), ParamType.STRING);
    }

    @Override
    public boolean unionEnable() {

        // return false;
        return parameterClientImpl.reg(UNION_PAY_SETTING, String.valueOf(ParamPaySettingType.OPEN.getKey()), ParamType.STRING);
    }

    @Override
    public boolean unionDisable() {

        // return false;
        return parameterClientImpl.reg(UNION_PAY_SETTING, String.valueOf(ParamPaySettingType.CLOSE.getKey()), ParamType.STRING);
    }

    @Override
    public PaySettingConfig get() {

        PaySettingConfig config = new PaySettingConfig();
        String wxPaySetting = String.valueOf(parameterClientImpl.get(WEIXIN_PAY_SETTING));
        String aliPaySetting = String.valueOf(parameterClientImpl.get(ALIPAY_PAY_SETTING));
        String unionPaySetting = String.valueOf(parameterClientImpl.get(UNION_PAY_SETTING));
        String paySettingTime = String.valueOf(parameterClientImpl.get(PAY_SETTING_TIME));
        String refundTime = String.valueOf(parameterClientImpl.get(REFUND_TIME));
        String domain = String.valueOf(parameterClientImpl.get(DOMAIN_KEY));
        String autoSignTime = String.valueOf(parameterClientImpl.get(AUTO_SIGN_TIME));
        config.setWxPaySetting(wxPaySetting);
        config.setAliPaySetting(aliPaySetting);
        config.setUnionPaySetting(unionPaySetting);
        config.setPaySettingTime(paySettingTime);
        config.setRefundTime(refundTime);
        config.setDomain(domain);
        config.setAutoSignTime(autoSignTime);
        return config;
    }

    @Override
    public void set(PaySettingConfig config) {

        String paySettingTime = config.getPaySettingTime();
        parameterClientImpl.reg(PAY_SETTING_TIME, paySettingTime, ParamType.STRING);
        String refundTime = config.getRefundTime();
        parameterClientImpl.reg(REFUND_TIME, refundTime, ParamType.STRING);
        String domain = config.getDomain();
        parameterClientImpl.reg(DOMAIN_KEY, domain, ParamType.STRING);
        String autoSignTime = config.getAutoSignTime();
        parameterClientImpl.reg(AUTO_SIGN_TIME, autoSignTime, ParamType.STRING);
    }
}
