package com.qcloud.component.publicservice.dao;

import com.qcloud.component.publicservice.model.MailSenderInfo;

public interface MailSenderDao {

    public boolean sendTextMail(MailSenderInfo mailInfo);

    public boolean sendHtmlMail(MailSenderInfo mailInfo);
}
