package com.qcloud.component.publicservice.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.publicservice.model.MessageType;
import com.qcloud.component.publicservice.model.query.MessageTypeQuery;

public interface MessageTypeDao extends ISimpleDao<MessageType, Long> {

    public boolean add(MessageType messageType);

    public MessageType get(Long id);

    MessageType getByCode(String code);

    public boolean delete(Long id);

    public boolean update(MessageType messageType);

    public List<MessageType> list(List<Long> idList);

    public Map<Long, MessageType> map(Set<Long> idSet);

    public Page<MessageType> page(MessageTypeQuery query, int start, int size);

    public List<MessageType> listAll();
}
