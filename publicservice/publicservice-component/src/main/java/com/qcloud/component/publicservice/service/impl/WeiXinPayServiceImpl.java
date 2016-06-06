package com.qcloud.component.publicservice.service.impl;

import javax.annotation.PostConstruct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.publicservice.dao.WeiXinPayDao;
import com.qcloud.component.publicservice.entity.WeiXinAppRequestPayResultEntity;
import com.qcloud.component.publicservice.entity.WeiXinRequestPayResultEntity;
import com.qcloud.component.publicservice.model.WeiXinConfig;
import com.qcloud.component.publicservice.model.WeiXinPayReqData;
import com.qcloud.component.publicservice.service.WeiXinConfigService;
import com.qcloud.component.publicservice.service.WeiXinPayService;
import com.qcloud.pirates.core.env.ProjectInfo;
import com.tencent.common.Configure;
import com.tencent.common.RandomStringGenerator;

@Service
public class WeiXinPayServiceImpl implements WeiXinPayService {

    @Autowired
    private WeiXinPayDao weiXinPayDao;

    @Autowired
    WeiXinConfigService  weiXinConfigService;

    @Autowired
    ProjectInfo          projectInfo;

    private Log          logger = LogFactory.getLog(getClass());

    @PostConstruct
    public void init() {

        WeiXinConfig weiXinConfig = weiXinConfigService.get();
        String projectCode = projectInfo.getCode();
        Configure.setCertLocalPath("/data/" + projectCode + "/config/apiclient_cert.p12");
        Configure.setAppID(weiXinConfig.getAppId());
        Configure.setMchID(weiXinConfig.getMchID());
        Configure.setCertPassword(weiXinConfig.getCertPassword());
        Configure.setKey(weiXinConfig.getKey());
    }

    @Override
    public WeiXinRequestPayResultEntity request(WeiXinPayReqData data, String notifyUrl, String opneId) {

        WeiXinConfig weiXinConfig = weiXinConfigService.get();
        // prepayId 放redis缓存,有效期2小时
        String prepayId = weiXinPayDao.request(data, notifyUrl, weiXinConfig.getAppId(), weiXinConfig.getAppSecret(), opneId);
        logger.info("wx request pay prepayId ");
        logger.info(prepayId);
        logger.info("");
        // prepayId 放redis缓存,有效期2小时
        WeiXinRequestPayResultEntity weiXinRequestPayResultEntity = new WeiXinRequestPayResultEntity();
        weiXinRequestPayResultEntity.setAppId(weiXinConfig.getAppId());
        weiXinRequestPayResultEntity.setKey(weiXinConfig.getKey());
        weiXinRequestPayResultEntity.setNonceStr(RandomStringGenerator.getRandomStringByLength(32));
        weiXinRequestPayResultEntity.setPrepayId(prepayId);
        return weiXinRequestPayResultEntity;
    }

    @Override
    public String request4Web(WeiXinPayReqData data, String notifyUrl) {

        WeiXinConfig weiXinConfig = weiXinConfigService.get();
        // prepayId 放redis缓存,有效期2小时
        String codeUrl = weiXinPayDao.request4Web(data, notifyUrl, weiXinConfig.getAppId(), weiXinConfig.getAppSecret());
        logger.info("wx request pay codeUrl ");
        logger.info(codeUrl);
        logger.info("");
        return codeUrl;
    }

    @Override
    public WeiXinAppRequestPayResultEntity request4App(WeiXinPayReqData data, String notifyUrl) {

        WeiXinConfig weiXinConfig = weiXinConfigService.get();
        // prepayId 放redis缓存,有效期2小时
        String prepayId = weiXinPayDao.request4App(data, notifyUrl, weiXinConfig.getAppId(), weiXinConfig.getAppSecret());
        logger.info("wx request pay prepayId ");
        logger.info(prepayId);
        logger.info("");
        // prepayId 放redis缓存,有效期2小时
        WeiXinAppRequestPayResultEntity weiXinAppRequestPayResultEntity = new WeiXinAppRequestPayResultEntity();
        weiXinAppRequestPayResultEntity.setAppId(weiXinConfig.getAppId());
        weiXinAppRequestPayResultEntity.setNonceStr(RandomStringGenerator.getRandomStringByLength(32));
        weiXinAppRequestPayResultEntity.setPrepayId(prepayId);
        weiXinAppRequestPayResultEntity.setPartnerId(weiXinConfig.getMchID());
        return weiXinAppRequestPayResultEntity;
    }
    // @Override
    // public String request(WeiXinPayReqData data, String appid, String appsecret, String code) {
    //
    // Configure.setCertLocalPath("G:/data/shuiqi/config/apiclient_cert.p12");
    // Configure.setCertPassword("1234237002");
    // Configure.setAppID("wx3fd5da72655f8c3c");
    // Configure.setMchID("1234237002");
    // Configure.setKey("qcloud");
    // return new WeiXinPayDaoOutSideImpl().request(data, appid, appsecret, code);
    // }
}
