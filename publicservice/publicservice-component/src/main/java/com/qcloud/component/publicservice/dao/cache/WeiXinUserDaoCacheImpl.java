package com.qcloud.component.publicservice.dao.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.component.publicservice.dao.WeiXinUserDao;

@Repository
public class WeiXinUserDaoCacheImpl implements WeiXinUserDao {

    @Autowired
    private WeiXinUserDao weiXinUserDaoOutsideImpl;

    @Override
    public String requestOpenId(String appid, String appsecret, String code) {

        return weiXinUserDaoOutsideImpl.requestOpenId(appid, appsecret, code);
    }
}
