package com.qcloud.component.publicservice.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.component.publicservice.model.Message;
import com.qcloud.component.publicservice.model.query.MessageQuery;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;

public interface MessageDao extends ISimpleDao<Message, Long> {

    public boolean add(String typeCode, int tableNumber, Message message);

    public Message get(Long id);

    public boolean delete(Long id);

    public boolean update(String typeCode, int tableNumber, Message message);

    public List<Message> list(List<Long> idList);

    public Map<Long, Message> map(Set<Long> idSet);

    public Page<Message> page(MessageQuery query, int start, int size);

    public List<Message> listAll();

    List<Message> listByReceiver(String typeCode, int classify, int tableNumber, long receiver, int start, int count);

    Message get(String typeCode, int tableNumber, long receiver, long id);

    int countByReceiver(String typeCode, int classify, int tableNumber, long receiver);

    int countUnreadByReceiver(String typeCode, int classify, int tableNumber, long receiver);

    List<Message> listContentByReceiver(String code, int classify, int tableNumber, long receiver, int start, int count);

    int getNewMsgNumber(String code, long receiver);

    boolean resetNewMsgNumber(String code, long receiver);
}
