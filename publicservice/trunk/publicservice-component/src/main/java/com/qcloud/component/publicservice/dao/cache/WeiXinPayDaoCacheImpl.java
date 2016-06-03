package com.qcloud.component.publicservice.dao.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.component.publicservice.dao.WeiXinPayDao;
import com.qcloud.component.publicservice.model.WeiXinPayReqData;

@Repository
public class WeiXinPayDaoCacheImpl implements WeiXinPayDao {

    @Autowired
    private WeiXinPayDao weiXinPayDaoOutSideImpl;

    @Override
    public String request(WeiXinPayReqData data, String notifyUrl, String appid, String appsecret, String opneId) {

        return weiXinPayDaoOutSideImpl.request(data, notifyUrl, appid, appsecret, opneId);
    }

    @Override
    public String request4App(WeiXinPayReqData data, String notifyUrl, String appid, String appsecret) {

        return weiXinPayDaoOutSideImpl.request4App(data, notifyUrl, appid, appsecret);
    }

    @Override
    public String request4Web(WeiXinPayReqData data, String notifyUrl, String appid, String appsecret) {

        return weiXinPayDaoOutSideImpl.request4Web(data, notifyUrl, appid, appsecret);
    }
}
