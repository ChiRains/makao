package com.qcloud.component.publicservice.dao.redis;

import java.util.Calendar;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.qcloud.component.publicservice.dao.SmsMessageLimitDao;
import com.qcloud.component.publicservice.util.RedisKeyUtils;
import com.qcloud.pirates.data.redis.Redis;

@Repository
public class SmsMessageLimitDaoRedisImpl implements SmsMessageLimitDao {

    @Resource(name = "redis-publicservice")
    Redis redis;

    @Override
    public boolean send(String mobile, String templateKey, int limitMinutes) {

        long time = getTime(mobile, templateKey);
        if (time == -1) {
            redis.set(RedisKeyUtils.getSmsMessageLimitTimeKey(mobile + "@" + templateKey), String.valueOf(new Date().getTime()), limitMinutes * 60);
            int number = getNumber(mobile, templateKey);
            Date date = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.set(Calendar.HOUR_OF_DAY, 23);
            c.set(Calendar.MINUTE, 59);
            c.set(Calendar.SECOND, 59);
            int seconds = new Long((c.getTime().getTime() - date.getTime()) / 1000).intValue();
            redis.set(RedisKeyUtils.getSmsMessageLimitNumberKey(mobile + "@" + templateKey), String.valueOf(number + 1), seconds);
            return true;
        }
        return false;
    }

    @Override
    public long getTime(String mobile, String templateKey) {

        String str = redis.get(RedisKeyUtils.getSmsMessageLimitTimeKey(mobile + "@" + templateKey));
        if (str == null) {
            return -1L;
        }
        return Long.parseLong(str);
    }

    @Override
    public int getNumber(String mobile, String templateKey) {

        String str = redis.get(RedisKeyUtils.getSmsMessageLimitNumberKey(mobile + "@" + templateKey));
        if (str == null) {
            return 0;
        }
        return Integer.parseInt(str);
    }
}
