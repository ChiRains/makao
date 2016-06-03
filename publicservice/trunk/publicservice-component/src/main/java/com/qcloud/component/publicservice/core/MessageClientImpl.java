package com.qcloud.component.publicservice.core;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.publicdata.IntKeyValue;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.component.publicservice.MessageClient;
import com.qcloud.component.publicservice.QMessage;
import com.qcloud.component.publicservice.entity.MessageEntity;
import com.qcloud.component.publicservice.entity.MessageTypeClassify;
import com.qcloud.component.publicservice.exception.PublicServiceException;
import com.qcloud.component.publicservice.model.Message;
import com.qcloud.component.publicservice.model.MessageType;
import com.qcloud.component.publicservice.model.key.TypeEnum.MessageStateType;
import com.qcloud.component.publicservice.service.MessageService;
import com.qcloud.component.publicservice.service.MessageTypeService;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.StringUtil;

@Component
public class MessageClientImpl implements MessageClient {

    @Autowired
    MessageTypeService messageTypeService;

    @Autowired
    MessageService     messageService;

    @Autowired
    PublicdataClient   publicdataClient;

    @Override
    public List<QMessage> listByReceiver(String typeCode, int classify, long receiver, int start, int count) {

        MessageType type = messageTypeService.getByCode(typeCode);
        AssertUtil.assertNotNull(type, "消息类型不存在." + typeCode);
        AssertUtil.assertTrue(classify < 0 || checkClassify(type, classify), "消息分类尚未定义." + classify + " " + type.getClassify());
        List<Message> list = messageService.listByReceiver(type, classify, receiver, start, count);
        List<QMessage> entityList = new ArrayList<QMessage>();
        for (Message message : list) {
            MessageEntity me = new MessageEntity();
            me.setId(message.getId());
            me.setTitle(message.getTitle());
            me.setContent(message.getContent());
            me.setTime(message.getTime());
            me.setRead(MessageStateType.READ.getKey() == message.getState());
            me.setClassify(message.getClassify());
            entityList.add(me);
        }
        return entityList;
    }

    @Override
    public boolean sendMsg(String typeCode, int classify, long receiver, String title, String content) {

        MessageType type = messageTypeService.getByCode(typeCode);
        AssertUtil.assertNotNull(type, "消息类型不存在." + typeCode);
        AssertUtil.assertTrue(checkClassify(type, classify), "消息分类尚未定义." + classify + " " + type.getClassify());
        Message message = new Message();
        message.setContent(content);
        message.setTitle(title);
        message.setTypeId(type.getId());
        message.setReceiver(receiver);
        message.setClassify(classify);
        return messageService.add(type, message);
    }

    @Override
    public QMessage get(String typeCode, long receiver, long id) {

        MessageType type = messageTypeService.getByCode(typeCode);
        AssertUtil.assertNotNull(type, "消息类型不存在." + typeCode);
        Message message = messageService.get(type, receiver, id);
        if (receiver != message.getReceiver()) {
            throw new PublicServiceException("不能获取其他用户消息.");
        }
        if (MessageStateType.DELETE.getKey() == message.getState()) {
            throw new PublicServiceException("消息不存在." + id);
        }
        MessageEntity me = new MessageEntity();
        me.setId(message.getId());
        me.setTitle(message.getTitle());
        me.setContent(message.getContent());
        me.setTime(message.getTime());
        me.setTimeStr(DateUtil.date2String(message.getTime()));
        me.setRead(MessageStateType.READ.getKey() == message.getState());
        me.setClassify(message.getClassify());
        return me;
    }

    @Override
    public boolean read(String typeCode, long receiver, long id) {

        MessageType type = messageTypeService.getByCode(typeCode);
        AssertUtil.assertNotNull(type, "消息类型不存在." + typeCode);
        Message message = messageService.get(type, receiver, id);
        AssertUtil.assertNotNull(message, "消息不存在." + id);
        if (receiver != message.getReceiver()) {
            throw new PublicServiceException("不能获取其他用户消息.");
        }
        if (message.getState() == MessageStateType.UNREAD.getKey()) {
            message.setState(MessageStateType.READ.getKey());
            return messageService.update(type, message);
        } else {
            throw new PublicServiceException("消息状态不是未读状态");
        }
    }

    @Override
    public boolean delete(String typeCode, long receiver, long id) {

        MessageType type = messageTypeService.getByCode(typeCode);
        AssertUtil.assertNotNull(type, "消息类型不存在." + typeCode);
        Message message = messageService.get(type, receiver, id);
        AssertUtil.assertNotNull(message, "消息不存在." + id);
        if (receiver != message.getReceiver()) {
            throw new PublicServiceException("不能删除其他用户消息.");
        }
        message.setState(MessageStateType.DELETE.getKey());
        return messageService.update(type, message);
    }

    @Override
    public int countByReceiver(String typeCode, int classify, long receiver) {

        MessageType type = messageTypeService.getByCode(typeCode);
        AssertUtil.assertNotNull(type, "消息类型不存在." + typeCode);
        AssertUtil.assertTrue(classify < 0 || checkClassify(type, classify), "消息分类尚未定义." + classify + " " + type.getClassify());
        return messageService.countByReceiver(type, classify, receiver);
    }

    @Override
    public int countUnreadByReceiver(String typeCode, int classify, long receiver) {

        MessageType type = messageTypeService.getByCode(typeCode);
        AssertUtil.assertNotNull(type, "消息类型不存在." + typeCode);
        AssertUtil.assertTrue(classify < 0 || checkClassify(type, classify), "消息分类尚未定义." + classify + " " + type.getClassify());
        return messageService.countUnreadByReceiver(type, classify, receiver);
    }

    @Override
    public List<QMessage> listContentByReceiver(String typeCode, int classify, long receiver, int start, int count) {

        MessageType type = messageTypeService.getByCode(typeCode);
        AssertUtil.assertNotNull(type, "消息类型不存在." + typeCode);
        AssertUtil.assertTrue(classify < 0 || checkClassify(type, classify), "消息分类尚未定义." + classify + " " + type.getClassify());
        List<Message> list = messageService.listContentByReceiver(type, classify, receiver, start, count);
        List<QMessage> entityList = new ArrayList<QMessage>();
        for (Message message : list) {
            MessageEntity me = new MessageEntity();
            me.setId(message.getId());
            me.setTitle(message.getTitle());
            me.setContent(message.getContent());
            me.setTime(message.getTime());
            me.setRead(MessageStateType.READ.getKey() == message.getState());
            me.setClassify(message.getClassify());
            entityList.add(me);
        }
        return entityList;
    }

    private boolean checkClassify(MessageType type, int classify) {

        List<MessageTypeClassify> classifyList = parseMessageTypeClassify(type.getClassify());
        for (MessageTypeClassify messageTypeClassify : classifyList) {
            if (messageTypeClassify.getClassify() == classify) {
                return true;
            }
        }
        return false;
    }

    private List<MessageTypeClassify> parseMessageTypeClassify(String classifyStr) {

        List<MessageTypeClassify> list = new ArrayList<MessageTypeClassify>();
        String[] classifys = StringUtil.nullToEmpty(classifyStr).split(";");
        for (String strItem : classifys) {
            String[] items = strItem.split(":");
            int classify = Integer.parseInt(items[0]);
            String name = items[1];
            MessageTypeClassify messageTypeClassify = new MessageTypeClassify();
            messageTypeClassify.setClassify(classify);
            messageTypeClassify.setName(name);
            list.add(messageTypeClassify);
        }
        return list;
    }

    @Override
    public List<IntKeyValue> listMessageClassify(String typeCode) {

        MessageType type = messageTypeService.getByCode(typeCode);
        AssertUtil.assertNotNull(type, "消息类型不存在." + typeCode);
        List<MessageTypeClassify> list = parseMessageTypeClassify(type.getClassify());
        List<IntKeyValue> ikvList = new ArrayList<IntKeyValue>(list);
        return ikvList;
    }

    @Override
    public int getNewMsgNumber(String typeCode, long receiver) {

        MessageType type = messageTypeService.getByCode(typeCode);
        AssertUtil.assertNotNull(type, "消息类型不存在." + typeCode);
        return messageService.getNewMsgNumber(type, receiver);
    }

    @Override
    public boolean resetNewMsgNumber(String typeCode, long receiver) {

        MessageType type = messageTypeService.getByCode(typeCode);
        AssertUtil.assertNotNull(type, "消息类型不存在." + typeCode);
        return messageService.resetNewMsgNumber(type, receiver);
    }

    @Override
    public Long sendMsgForId(String typeCode, int classify, long receiver, String title, String content) {

        MessageType type = messageTypeService.getByCode(typeCode);
        AssertUtil.assertNotNull(type, "消息类型不存在." + typeCode);
        AssertUtil.assertTrue(checkClassify(type, classify), "消息分类尚未定义." + classify + " " + type.getClassify());
        Message message = new Message();
        message.setContent(content);
        message.setTitle(title);
        message.setTypeId(type.getId());
        message.setReceiver(receiver);
        message.setClassify(classify);
        return messageService.add(type, message) ? message.getId() : 0;
    }
}
