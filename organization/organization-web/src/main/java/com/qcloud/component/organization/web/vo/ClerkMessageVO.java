package com.qcloud.component.organization.web.vo;

import java.util.Date;

public class ClerkMessageVO {

    private long    id;

    // 消息标题
    private String  title;

    // 消息内容
    private String  content;

    // 发送时间
    private Date    time;

    private String  timeStr;

    // true 已读
    private boolean read;

    public ClerkMessageVO() {

    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getTitle() {

        return title;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public String getContent() {

        return content;
    }

    public void setTime(Date time) {

        this.time = time;
    }

    public Date getTime() {

        return time;
    }

    public String getTimeStr() {

        return timeStr;
    }

    public void setTimeStr(String timeStr) {

        this.timeStr = timeStr;
    }

    public boolean isRead() {

        return read;
    }

    public void setRead(boolean read) {

        this.read = read;
    }
}
