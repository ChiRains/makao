package com.qcloud.component.publicservice.entity;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.component.publicservice.QWeiXinRequestPayResult;
import com.tencent.common.Signature;

public class WeiXinAppRequestPayResultEntity implements QWeiXinRequestPayResult {

    private String appId;

    private String partnerId;

    private String prepayId;

    private String nonceStr;

    private String timeStamp;

    public String getAppId() {

        return appId;
    }

    public void setAppId(String appId) {

        this.appId = appId;
    }

    public String getPartnerId() {

        return partnerId;
    }

    public void setPartnerId(String partnerId) {

        this.partnerId = partnerId;
    }

    public String getPrepayId() {

        return prepayId;
    }

    public void setPrepayId(String prepayId) {

        this.prepayId = prepayId;
    }

    public String getNonceStr() {

        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {

        this.nonceStr = nonceStr;
    }

    public String getTimeStamp() {

        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {

        this.timeStamp = timeStamp;
    }

    @Override
    public Map<String, Object> map() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("appid", getAppId());
        map.put("partnerid", getPartnerId());
        map.put("prepayid", getPrepayId());
        map.put("package", "Sign=WXPay");
        map.put("noncestr", getNonceStr());
        map.put("timestamp", getTimeStamp());
        String sign = Signature.getSign(map);
        map.put("paySign", sign);
        return map;
    }
}
