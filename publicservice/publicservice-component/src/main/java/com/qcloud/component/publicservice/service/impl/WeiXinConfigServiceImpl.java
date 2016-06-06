package com.qcloud.component.publicservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.parameter.ParamType;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.publicservice.model.WeiXinConfig;
import com.qcloud.component.publicservice.service.WeiXinConfigService;
import com.qcloud.pirates.util.StringUtil;

@Component
public class WeiXinConfigServiceImpl implements WeiXinConfigService {

    @Autowired
    private ParameterClient     parameterClientImpl;

    private final static String WEIXIN_APPID            = "weixin-appId";

    private final static String WEIXIN_APPSECRET        = "weixin-appSecret";

    private final static String WEIXIN_PAY_MCHID        = "weixin-pay-mchID";

    private final static String WEIXIN_PAY_CERTPASSWORD = "weixin-pay-certPassword";

    private final static String WEIXIN_PAY_KEY          = "weixin-pay-key";

    @Override
    public WeiXinConfig get() {

        String appId = parameterClientImpl.get(WEIXIN_APPID);
        String appSecret = parameterClientImpl.get(WEIXIN_APPSECRET);
        String mchID = parameterClientImpl.get(WEIXIN_PAY_MCHID);
        String certPassword = parameterClientImpl.get(WEIXIN_PAY_CERTPASSWORD);
        String key = parameterClientImpl.get(WEIXIN_PAY_KEY);
        WeiXinConfig weiXinConfig = new WeiXinConfig();
        weiXinConfig.setAppId(StringUtil.nullToEmpty(appId));
        weiXinConfig.setAppSecret(StringUtil.nullToEmpty(appSecret));
        weiXinConfig.setMchID(StringUtil.nullToEmpty(mchID));
        weiXinConfig.setCertPassword(StringUtil.nullToEmpty(certPassword));
        weiXinConfig.setKey(StringUtil.nullToEmpty(key));
        return weiXinConfig;
    }

    @Override
    public boolean set(WeiXinConfig config) {

        String appId = StringUtil.nullToEmpty(config.getAppId());
        String appSecret = StringUtil.nullToEmpty(config.getAppSecret());
        String mchID = StringUtil.nullToEmpty(config.getMchID());
        String certPassword = StringUtil.nullToEmpty(config.getCertPassword());
        String key = StringUtil.nullToEmpty(config.getKey());
        parameterClientImpl.reg(WEIXIN_APPID, appId, ParamType.STRING);
        parameterClientImpl.reg(WEIXIN_APPSECRET, appSecret, ParamType.STRING);
        parameterClientImpl.reg(WEIXIN_PAY_MCHID, mchID, ParamType.STRING);
        parameterClientImpl.reg(WEIXIN_PAY_CERTPASSWORD, certPassword, ParamType.STRING);
        parameterClientImpl.reg(WEIXIN_PAY_KEY, key, ParamType.STRING);
        return true;
    }
}
