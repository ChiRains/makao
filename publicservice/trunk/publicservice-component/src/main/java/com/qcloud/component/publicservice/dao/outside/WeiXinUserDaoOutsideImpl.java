package com.qcloud.component.publicservice.dao.outside;

import org.springframework.stereotype.Repository;
import com.qcloud.component.publicservice.dao.WeiXinUserDao;
import com.tencent.WXUtil;

@Repository
public class WeiXinUserDaoOutsideImpl implements WeiXinUserDao {

    @Override
    public String requestOpenId(String appid, String appsecret, String code) {

        return WXUtil.getOpenId(appid, appsecret, code);
    }
}
