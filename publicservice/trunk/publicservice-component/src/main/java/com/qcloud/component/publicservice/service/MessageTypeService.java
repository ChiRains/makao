package com.qcloud.component.publicservice.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicservice.model.MessageType;
import com.qcloud.component.publicservice.model.query.MessageTypeQuery;

public interface MessageTypeService {

    public boolean add(MessageType messageType);

    public MessageType get(Long id);

    MessageType getByCode(String code);

    public boolean delete(Long id);

    public boolean update(MessageType messageType);

    public Page<MessageType> page(MessageTypeQuery query, int start, int count);

    public List<MessageType> listAll();
}
