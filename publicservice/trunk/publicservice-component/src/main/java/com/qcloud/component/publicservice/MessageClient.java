package com.qcloud.component.publicservice;

import java.util.List;
import com.qcloud.component.publicdata.IntKeyValue;

public interface MessageClient {

    // 不含 content,classify == -1 则查全部
    List<QMessage> listByReceiver(String typeCode, int classify, long receiver, int start, int count);

    // 含 content,classify == -1 则查全部
    List<QMessage> listContentByReceiver(String typeCode, int classify, long receiver, int start, int count);

    // 获取所有的条数,classify == -1 则查全部
    int countByReceiver(String typeCode, int classify, long receiver);

    // 获取未读的条数,classify == -1 则查全部
    int countUnreadByReceiver(String typeCode, int classify, long receiver);

    // 获取新短消息,则查全部
    int getNewMsgNumber(String typeCode, long receiver);

    // 重置新短消息
    boolean resetNewMsgNumber(String typeCode, long receiver);

    // 发送消息
    boolean sendMsg(String typeCode, int classify, long receiver, String title, String content);

    // 发送消息,返回id
    Long sendMsgForId(String typeCode, int classify, long receiver, String title, String content);

    // 获取消息
    QMessage get(String typeCode, long receiver, long id);

    // 设置消息已读
    boolean read(String typeCode, long receiver, long id);

    // 假删
    boolean delete(String typeCode, long receiver, long id);

    //
    List<IntKeyValue> listMessageClassify(String typeCode);
}
