package com.qcloud.component.publicservice.core;

import java.util.Calendar;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.publicservice.QWeiXinRequestPayResult;
import com.qcloud.component.publicservice.WeiXinPayClient;
import com.qcloud.component.publicservice.entity.WeiXinAppRequestPayResultEntity;
import com.qcloud.component.publicservice.entity.WeiXinRequestPayResultEntity;
import com.qcloud.component.publicservice.model.WeiXinPayReqData;
import com.qcloud.component.publicservice.service.WeiXinConfigService;
import com.qcloud.component.publicservice.service.WeiXinPayService;
import com.qcloud.pirates.util.DateUtil;

@Component
public class WeiXinPayClientImpl implements WeiXinPayClient {

    @Autowired
    WeiXinPayService    weiXinPayService;

    @Autowired
    WeiXinConfigService weiXinConfigService;

    Log                 logger = LogFactory.getLog(getClass());

    @Override
    public String getWeiXinAppId() {

        return weiXinConfigService.get().getAppId();
    }

    @Override
    public QWeiXinRequestPayResult request(String orderNumber, String attach, String body, String notifyUrl, String ip, int fee, Date orderTime, int expireMinutes, String opneId) {

        logger.info("request wxpay " + orderNumber);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1970);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date beginTime = c.getTime();
        Date endTime = DateUtil.addTime(orderTime, expireMinutes);
        WeiXinPayReqData data = new WeiXinPayReqData(body, attach, orderNumber, fee, "", ip, DateUtil.date2String(orderTime, "yyyyMMddHHmmss"), DateUtil.date2String(endTime, "yyyyMMddHHmmss"), "");
        WeiXinRequestPayResultEntity result = weiXinPayService.request(data, notifyUrl, opneId);
        result.setTimeStamp(String.valueOf((orderTime.getTime() - beginTime.getTime()) / 1000));
        return result;
    }

    // @Override
    // public String request() {
    // WeiXinPayReqData data = null;// new WeiXinPayReqData();
    // return weiXinPayService.request(data);
    // }
    // @Override
    // public String request(String appid, String appsecret, String code) {
    // Date startTime = new Date();
    // Date endTime = DateUtil.addTime(startTime, 180);
    // // WeiXinPayReqData data = new WeiXinPayReqData(authCode, body, attach, outTradeNo, totalFee, deviceInfo, spBillCreateIP, timeStart, timeExpire, goodsTag);
    // WeiXinPayReqData data = new WeiXinPayReqData("", "测试商品1", "abc123456", "", 1, "", "172.16.0.1", DateUtil.date2String(startTime, "yyyyMMddHHmmss"), DateUtil.date2String(endTime, "yyyyMMddHHmmss"), "");
    // return weiXinPayService.request(data, appid, appsecret, code);
    // }
    @Override
    public String request4Web(String orderNumber, String attach, String body, String notifyUrl, String ip, int fee, Date orderTime, int expireMinutes) {

        logger.info("request wxpay " + orderNumber);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1970);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date endTime = DateUtil.addTime(orderTime, expireMinutes);
        WeiXinPayReqData data = new WeiXinPayReqData(body, attach, orderNumber, fee, "", ip, DateUtil.date2String(orderTime, "yyyyMMddHHmmss"), DateUtil.date2String(endTime, "yyyyMMddHHmmss"), "");
        String result = weiXinPayService.request4Web(data, notifyUrl);
        return result;
    }

    @Override
    public QWeiXinRequestPayResult request4App(String orderNumber, String attach, String body, String notifyUrl, String ip, int fee, Date orderTime, int expireMinutes) {

        logger.info("request wxpay " + orderNumber);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1970);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date beginTime = c.getTime();
        Date endTime = DateUtil.addTime(orderTime, expireMinutes);
        WeiXinPayReqData data = new WeiXinPayReqData(body, attach, orderNumber, fee, "", ip, DateUtil.date2String(orderTime, "yyyyMMddHHmmss"), DateUtil.date2String(endTime, "yyyyMMddHHmmss"), "");
        WeiXinAppRequestPayResultEntity result = weiXinPayService.request4App(data, notifyUrl);
        result.setTimeStamp(String.valueOf((orderTime.getTime() - beginTime.getTime()) / 1000));
        return result;
    }
}
