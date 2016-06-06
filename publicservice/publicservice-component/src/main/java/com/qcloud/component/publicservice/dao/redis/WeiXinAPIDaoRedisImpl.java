package com.qcloud.component.publicservice.dao.redis;

import java.sql.Timestamp;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import com.qcloud.component.publicservice.dao.WeiXinAPIDao;
import com.qcloud.component.publicservice.util.RedisKeyUtils;
import com.qcloud.component.publicservice.util.RedisValueUtils;
import com.qcloud.pirates.data.redis.Redis;
import com.tencent.WXUtil;

@Repository
public class WeiXinAPIDaoRedisImpl implements WeiXinAPIDao {

    @Resource(name = "redis-publicservice")
    Redis redis;

    @Override
    public String getAccessToken(String appid, String appsecret) {

        Lock lock = new ReentrantLock();
        lock.lock();
        String accessToken = "";
        Timestamp t = new Timestamp(System.currentTimeMillis());
        String accessTokenKey = RedisKeyUtils.getWeixinAccessTokenKey(appid);
        String verificationCode = redis.get(accessTokenKey);
        if (!StringUtils.isEmpty(verificationCode)) {
            String[] str = verificationCode.split("#");
            accessToken = str[0];
            // 7200秒
            if ((t.getTime() - Long.valueOf(str[1])) / 1000 > 5000) {
                accessToken = WXUtil.getAccessToken(appid, appsecret);
                redis.set(accessTokenKey, RedisValueUtils.getWeixinAccessTokenValue(accessToken, t));
            }
        } else {
            accessToken = WXUtil.getAccessToken(appid, appsecret);
            redis.set(accessTokenKey, RedisValueUtils.getWeixinAccessTokenValue(accessToken, t));
        }
        lock.unlock();
        return accessToken;
    }

    @Override
    public String getJsapiTicket(String appid, String appsecret) {

        Lock lock = new ReentrantLock();
        lock.lock();
        String jsapiTicket = "";
        Timestamp t = new Timestamp(System.currentTimeMillis());
        String jsapiTicketKey = RedisKeyUtils.getWeixinJsapiTicketKey(appid);
        String verificationCode = redis.get(jsapiTicketKey);
        if (!StringUtils.isEmpty(verificationCode)) {
            String[] str = verificationCode.split("#");
            jsapiTicket = str[0];
            // 7200秒
            if ((t.getTime() - Long.valueOf(str[1])) / 1000 > 5000) {
                jsapiTicket = WXUtil.getJsapiTicket(getAccessToken(appid, appsecret));
                redis.set(jsapiTicketKey, RedisValueUtils.getWeixinJsapiTicketValue(jsapiTicket, t));
            }
        } else {
            jsapiTicket = WXUtil.getJsapiTicket(getAccessToken(appid, appsecret));
            redis.set(jsapiTicketKey, RedisValueUtils.getWeixinJsapiTicketValue(jsapiTicket, t));
        }
        lock.unlock();
        return jsapiTicket;
    }
}
