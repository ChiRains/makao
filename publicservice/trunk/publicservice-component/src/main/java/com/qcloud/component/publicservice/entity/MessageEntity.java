package com.qcloud.component.publicservice.entity;

import java.util.Date;
import com.qcloud.component.publicservice.QMessage;

public class MessageEntity implements QMessage {

    private Long    id;

    // 消息标题
    private String  title;

    // 消息内容
    private String  content;

    // 发送时间
    private Date    time;

    // 发送时间
    private String  timeStr;

    private boolean read;

    private int     classify;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public Date getTime() {

        return time;
    }

    public void setTime(Date time) {

        this.time = time;
    }

    public boolean isRead() {

        return read;
    }

    public void setRead(boolean read) {

        this.read = read;
    }

    public String getTimeStr() {

        return timeStr;
    }

    public void setTimeStr(String timeStr) {

        this.timeStr = timeStr;
    }

    public int getClassify() {

        return classify;
    }

    public void setClassify(int classify) {

        this.classify = classify;
    }
}
