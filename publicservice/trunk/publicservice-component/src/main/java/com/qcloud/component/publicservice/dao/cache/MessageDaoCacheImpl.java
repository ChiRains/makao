package com.qcloud.component.publicservice.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicservice.dao.MessageDao;
import com.qcloud.component.publicservice.model.Message;
import com.qcloud.component.publicservice.model.query.MessageQuery;

@Repository
public class MessageDaoCacheImpl implements MessageDao {

    @Autowired
    private MessageDao messageDaoMysqlImpl;

    @Autowired
    private MessageDao messageDaoRedisImpl;

    @Override
    public boolean add(Message message) {

        return messageDaoMysqlImpl.add(message);
    }

    @Override
    public Message get(Long id) {

        return messageDaoMysqlImpl.get(id);
        // return CacheLoader.get(messageDaoRedisImpl, messageDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return messageDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(Message message) {

        return messageDaoMysqlImpl.update(message);
    }

    @Override
    public List<Message> list(List<Long> idList) {

        return CacheLoader.list(messageDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, Message> map(Set<Long> idSet) {

        return CacheLoader.map(messageDaoMysqlImpl, idSet);
    }

    @Override
    public Page<Message> page(int start, int count) {

        return messageDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<Message> page(MessageQuery query, int start, int count) {

        return messageDaoMysqlImpl.page(query, start, count);
    }

    public List<Message> listAll() {

        return messageDaoMysqlImpl.listAll();
    }

    @Override
    public boolean add(String typeCode, int tableNumber, Message message) {

        boolean result = messageDaoMysqlImpl.add(typeCode, tableNumber, message);
        if (result) {
            messageDaoRedisImpl.add(typeCode, tableNumber, message);
        }
        return result;
    }

    @Override
    public boolean update(String typeCode, int tableNumber, Message message) {

        boolean result = messageDaoMysqlImpl.update(typeCode, tableNumber, message);
        if (result) {
            messageDaoRedisImpl.update(typeCode, tableNumber, message);
        }
        return result;
    }

    @Override
    public List<Message> listByReceiver(String typeCode, int classify, int tableNumber, long receiver, int start, int count) {

        return messageDaoMysqlImpl.listByReceiver(typeCode, classify, tableNumber, receiver, start, count);
    }

    @Override
    public Message get(String typeCode, int tableNumber, long receiver, long id) {

        return messageDaoMysqlImpl.get(typeCode, tableNumber, receiver, id);
    }

    @Override
    public int countByReceiver(String typeCode, int classify, int tableNumber, long receiver) {

        return messageDaoMysqlImpl.countByReceiver(typeCode, classify, tableNumber, receiver);
    }

    @Override
    public int countUnreadByReceiver(String typeCode, int classify, int tableNumber, long receiver) {

        return messageDaoMysqlImpl.countUnreadByReceiver(typeCode, classify, tableNumber, receiver);
    }

    @Override
    public List<Message> listContentByReceiver(String typeCode, int classify, int tableNumber, long receiver, int start, int count) {

        return messageDaoMysqlImpl.listContentByReceiver(typeCode, classify, tableNumber, receiver, start, count);
    }

    @Override
    public int getNewMsgNumber(String code, long receiver) {

        return messageDaoRedisImpl.getNewMsgNumber(code, receiver);
    }

    @Override
    public boolean resetNewMsgNumber(String code, long receiver) {

        return messageDaoRedisImpl.resetNewMsgNumber(code, receiver);
    }
}
