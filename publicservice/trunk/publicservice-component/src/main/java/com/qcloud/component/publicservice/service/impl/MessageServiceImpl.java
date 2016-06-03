package com.qcloud.component.publicservice.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.publicservice.dao.MessageDao;
import com.qcloud.component.publicservice.model.Message;
import com.qcloud.component.publicservice.model.MessageType;
import com.qcloud.component.publicservice.model.key.TypeEnum.MessageStateType;
import com.qcloud.component.publicservice.model.query.MessageQuery;
import com.qcloud.component.publicservice.service.MessageService;
import com.qcloud.pirates.data.Page;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao          messageDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "publicservice_message";

    // @Override
    // public boolean add(Message message) {
    //
    // long id = autoIdGenerator.get(ID_KEY);
    // message.setId(id);
    // message.setTime(new Date());
    // message.setState(MessageStateType.UNREAD.getKey());
    // return messageDao.add(message);
    // }
    @Override
    public Message get(Long id) {

        return messageDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return messageDao.delete(id);
    }

    // @Override
    // public boolean update(Message message) {
    //
    // return messageDao.update(message);
    // }
    @Override
    public Page<Message> page(MessageQuery query, int start, int count) {

        return messageDao.page(query, start, count);
    }

    public List<Message> listAll() {

        return messageDao.listAll();
    }

    @Override
    public List<Message> listByReceiver(MessageType type, int classify, long receiver, int start, int count) {

        return messageDao.listByReceiver(type.getCode(), classify, type.getTableNumber(), receiver, start, count);
    }

    @Override
    public Message get(MessageType type, long receiver, long id) {

        return messageDao.get(type.getCode(), type.getTableNumber(), receiver, id);
    }

    @Override
    public boolean add(MessageType type, Message message) {

        long id = autoIdGenerator.get(ID_KEY);
        message.setId(id);
        message.setTime(new Date());
        message.setState(MessageStateType.UNREAD.getKey());
        return messageDao.add(type.getCode(), type.getTableNumber(), message);
    }

    @Override
    public boolean update(MessageType type, Message message) {

        return messageDao.update(type.getCode(), type.getTableNumber(), message);
    }

    @Override
    public int countByReceiver(MessageType type, int classify, long receiver) {

        return messageDao.countByReceiver(type.getCode(), classify, type.getTableNumber(), receiver);
    }

    @Override
    public int countUnreadByReceiver(MessageType type, int classify, long receiver) {

        return messageDao.countUnreadByReceiver(type.getCode(), classify, type.getTableNumber(), receiver);
    }

    @Override
    public List<Message> listContentByReceiver(MessageType type, int classify, long receiver, int start, int count) {

        return messageDao.listContentByReceiver(type.getCode(), classify, type.getTableNumber(), receiver, start, count);
    }

    @Override
    public int getNewMsgNumber(MessageType type, long receiver) {

        return messageDao.getNewMsgNumber(type.getCode(), receiver);
    }

    @Override
    public boolean resetNewMsgNumber(MessageType type, long receiver) {

        return messageDao.resetNewMsgNumber(type.getCode(), receiver);
    }
}
