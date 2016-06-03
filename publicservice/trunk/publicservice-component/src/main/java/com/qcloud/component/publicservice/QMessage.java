package com.qcloud.component.publicservice;

import java.util.Date;

// 消息
public interface QMessage {

    // id
    Long getId();

    // 消息标题
    String getTitle();

    // 消息内容
    String getContent();

    // 消息发送时间
    Date getTime();

    String getTimeStr();

    boolean isRead();
    
    int getClassify();
}
