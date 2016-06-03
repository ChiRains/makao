package com.qcloud.component.publicservice.service;

import java.util.List;
import com.qcloud.component.publicservice.model.Message;
import com.qcloud.component.publicservice.model.MessageType;
import com.qcloud.component.publicservice.model.query.MessageQuery;
import com.qcloud.pirates.data.Page;

public interface MessageService {

    // public boolean add(Message message);
    boolean add(MessageType type, Message message);

    public Message get(Long id);

    public boolean delete(Long id);

    // public boolean update(Message message);
    boolean update(MessageType type, Message message);

    public Page<Message> page(MessageQuery query, int start, int count);

    public List<Message> listAll();

    List<Message> listByReceiver(MessageType type, int classify, long receiver, int start, int count);

    Message get(MessageType type, long receiver, long id);

    int countByReceiver(MessageType type, int classify, long receiver);

    int countUnreadByReceiver(MessageType type, int classify, long receiver);

    public List<Message> listContentByReceiver(MessageType type, int classify, long receiver, int start, int count);

    int getNewMsgNumber(MessageType type, long receiver);

    boolean resetNewMsgNumber(MessageType type, long receiver);
}
