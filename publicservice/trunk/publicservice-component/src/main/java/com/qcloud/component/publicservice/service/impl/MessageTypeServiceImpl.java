package com.qcloud.component.publicservice.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicservice.dao.MessageTypeDao;
import com.qcloud.component.publicservice.model.MessageType;
import com.qcloud.component.publicservice.service.MessageTypeService;
import com.qcloud.component.publicservice.model.query.MessageTypeQuery;

@Service
public class MessageTypeServiceImpl implements MessageTypeService {

    @Autowired
    private MessageTypeDao      messageTypeDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "publicservice_message_type";

    @Override
    public boolean add(MessageType messageType) {

        long id = autoIdGenerator.get(ID_KEY);
        messageType.setId(id);
        return messageTypeDao.add(messageType);
    }

    @Override
    public MessageType get(Long id) {

        return messageTypeDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return messageTypeDao.delete(id);
    }

    @Override
    public boolean update(MessageType messageType) {

        return messageTypeDao.update(messageType);
    }

    @Override
    public Page<MessageType> page(MessageTypeQuery query, int start, int count) {

        return messageTypeDao.page(query, start, count);
    }

    public List<MessageType> listAll() {

        return messageTypeDao.listAll();
    }

    @Override
    public MessageType getByCode(String code) {

        return messageTypeDao.getByCode(code);
    }
}
