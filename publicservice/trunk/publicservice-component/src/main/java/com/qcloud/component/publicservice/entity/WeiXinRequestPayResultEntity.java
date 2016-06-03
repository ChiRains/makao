package com.qcloud.component.publicservice.entity;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.component.publicservice.QWeiXinRequestPayResult;
import com.tencent.common.Signature;

public class WeiXinRequestPayResultEntity implements QWeiXinRequestPayResult {

    private String appId;

    private String nonceStr;

    private String prepayId;

    private String timeStamp;

    private String key;

    public String getAppId() {

        return appId;
    }

    public void setAppId(String appId) {

        this.appId = appId;
    }

    public String getNonceStr() {

        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {

        this.nonceStr = nonceStr;
    }

    public String getPrepayId() {

        return prepayId;
    }

    public void setPrepayId(String prepayId) {

        this.prepayId = prepayId;
    }

    public String getTimeStamp() {

        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {

        this.timeStamp = timeStamp;
    }

    public String getKey() {

        return key;
    }

    public void setKey(String key) {

        this.key = key;
    }

    @Override
    public Map<String, Object> map() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("appId", getAppId());
        map.put("nonceStr", getNonceStr());
        map.put("package", "prepay_id=" + getPrepayId());
        map.put("signType", "MD5");
        map.put("timeStamp", getTimeStamp());
        String sign = Signature.getSign(map);
        map.put("paySign", sign);
        // map.put("packageStr", "prepay_id=" + getPrepayId());
        // map.put("prepayId", getPrepayId());
        return map;
    }
}
