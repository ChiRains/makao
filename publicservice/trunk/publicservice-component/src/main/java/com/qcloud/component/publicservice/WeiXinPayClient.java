package com.qcloud.component.publicservice;

import java.util.Date;

public interface WeiXinPayClient {

    QWeiXinRequestPayResult request(String orderNumber, String attach, String body, String notifyUrl, String ip, int fee, Date orderTime, int expireMinutes, String opneId);

    QWeiXinRequestPayResult request4App(String orderNumber, String attach, String body, String notifyUrl, String ip, int fee, Date orderTime, int expireMinutes);

    String request4Web(String orderNumber, String attach, String body, String notifyUrl, String ip, int fee, Date orderTime, int expireMinutes);

    String getWeiXinAppId();
}
