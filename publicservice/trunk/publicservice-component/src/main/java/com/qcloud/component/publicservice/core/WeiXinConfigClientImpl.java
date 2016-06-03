package com.qcloud.component.publicservice.core;

import java.util.Random;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.filesdk.QFile;
import com.qcloud.component.publicservice.WeiXinConfigClient;
import com.qcloud.component.publicservice.model.WeiXinConfig;
import com.qcloud.component.publicservice.service.WeiXinAPIService;
import com.qcloud.component.publicservice.service.WeiXinConfigService;
import com.qcloud.pirates.util.AssertUtil;
import com.tencent.WXUtil;
import com.tencent.entity.WXUserEntity;

@Component
public class WeiXinConfigClientImpl implements WeiXinConfigClient {

    @Autowired
    WeiXinConfigService weiXinConfigService;

    @Autowired
    WeiXinAPIService    weiXinAPIService;

    @Autowired
    FileSDKClient       fileSDKClient;

    @Override
    public WeiXinConfig getWeiXinConfig() {

        return weiXinConfigService.get();
    }

    @Override
    public String getJSSDKSign(String nonceStr, Long timestamp, String url) {

        WeiXinConfig weiXinConfig = weiXinConfigService.get();
        String jsapiTicket = weiXinAPIService.getJsapiTicket(weiXinConfig.getAppId(), weiXinConfig.getAppSecret());
        return WXUtil.getJSSDKSign(jsapiTicket, nonceStr, timestamp, url);
    }

    @Override
    public WXUserEntity getUserEntity(String openId) {

        AssertUtil.assertNotNull(openId, "openId不能为空!");
        WeiXinConfig weiXinConfig = weiXinConfigService.get();
        String appId = weiXinConfig.getAppId();
        String appSecret = weiXinConfig.getAppSecret();
        String accessToken = weiXinAPIService.getAccessToken(appId, appSecret);
        WXUserEntity userEntity = new WXUserEntity();
        try {
            userEntity = WXUtil.getUserInfo(accessToken, openId);
            QFile qFile = WXUtil.getHttpQFile(openId, userEntity.getHeadimgurl());
            userEntity.setNickname(WXUtil.transEncoding4Code(userEntity.getNickname()));
            String url = fileSDKClient.saveToUrl(qFile);
            userEntity.setHeadimgurl(url);
        } catch (Exception e) {
            int number = new Random().nextInt(1000000);
            String nickname = "会员" + StringUtils.leftPad(String.valueOf(number), 6, "0");
            userEntity.setNickname(nickname);
            e.printStackTrace();
        }
        return userEntity;
    }
}
