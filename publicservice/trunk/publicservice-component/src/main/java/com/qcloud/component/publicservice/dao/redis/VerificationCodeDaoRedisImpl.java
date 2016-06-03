package com.qcloud.component.publicservice.dao.redis;

import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import com.qcloud.component.publicservice.dao.VerificationCodeDao;
import com.qcloud.component.publicservice.model.VerificationCode;
import com.qcloud.component.publicservice.util.RedisKeyUtils;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.pirates.util.StringUtil;

@Repository
public class VerificationCodeDaoRedisImpl implements VerificationCodeDao {

    @Resource(name = "redis-publicservice")
    Redis redis;

    @Override
    public boolean exist(String target, String code) {

        return redis.exists(RedisKeyUtils.getVerificationCodeKey(StringUtil.nullToEmpty(target) + "#" + code));
    }

    @Override
    public boolean add(VerificationCode verificationCode) {

        int seconds = verificationCode.getEffectiveMinutes() * 60;
        redis.set(RedisKeyUtils.getVerificationCodeKey(StringUtil.nullToEmpty(verificationCode.getTarget()) + "#" + verificationCode.getCode()), Json.toJson(verificationCode), seconds);
        return true;
    }

    @Override
    public VerificationCode get(String target, String code) {

        String str = redis.get(RedisKeyUtils.getVerificationCodeKey(StringUtil.nullToEmpty(target) + "#" + code));
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return Json.toObject(str, VerificationCode.class);
    }

    @Override
    public boolean remove(String target, String code) {

        redis.del(RedisKeyUtils.getVerificationCodeKey(StringUtil.nullToEmpty(target) + "#" + code));
        return true;
    }
}
