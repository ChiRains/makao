package com.qcloud.component.publicservice.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import com.qcloud.component.publicservice.dao.MessageDao;
import com.qcloud.component.publicservice.model.Message;
import com.qcloud.component.publicservice.model.query.MessageQuery;
import com.qcloud.component.publicservice.util.RedisKeyUtils;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;

@Repository
public class MessageDaoRedisImpl implements MessageDao {

    @Resource(name = "redis-publicservice")
    private Redis redis;

    @Override
    public boolean add(Message message) {

        throw new NotImplementedException();
    }

    @Override
    public Message get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(Message message) {

        throw new NotImplementedException();
    }

    @Override
    public List<Message> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Message> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Message> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Message> page(MessageQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<Message> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public boolean add(String typeCode, int tableNumber, Message message) {

        // 暂时把新消息条数放到redis,内容暂时不放
        // 总条数
        String key = RedisKeyUtils.getMessageNewNumberKey(typeCode, message.getReceiver());
        int number = getNewMsgNumber(typeCode, message.getReceiver());
        number += 1;
        redis.set(key, String.valueOf(number));
        return true;
    }

    @Override
    public boolean update(String typeCode, int tableNumber, Message message) {

        String key = RedisKeyUtils.getMessageNewNumberKey(typeCode, message.getReceiver());
        redis.set(key, String.valueOf(0));
        return true;
    }

    @Override
    public Message get(String typeCode, int tableNumber, long receiver, long id) {

        throw new NotImplementedException();
    }

    @Override
    public List<Message> listByReceiver(String typeCode, int classify, int tableNumber, long receiver, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public int countByReceiver(String typeCode, int classify, int tableNumber, long receiver) {

        throw new NotImplementedException();
    }

    @Override
    public int countUnreadByReceiver(String typeCode, int classify, int tableNumber, long receiver) {

        throw new NotImplementedException();
    }

    @Override
    public List<Message> listContentByReceiver(String code, int classify, int tableNumber, long receiver, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public int getNewMsgNumber(String code, long receiver) {

        String key = RedisKeyUtils.getMessageNewNumberKey(code, receiver);
        String value = redis.get(key);
        int number = StringUtils.isEmpty(value) ? 0 : Integer.valueOf(value);
        return number;
    }

    @Override
    public boolean resetNewMsgNumber(String code, long receiver) {

        // 这里按具体情况,分类的按分类走,
        String key = RedisKeyUtils.getMessageNewNumberKey(code, receiver);
        redis.set(key, String.valueOf(0));
        return false;
    }
}
