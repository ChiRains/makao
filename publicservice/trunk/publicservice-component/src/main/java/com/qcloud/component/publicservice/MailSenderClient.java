package com.qcloud.component.publicservice;

import com.qcloud.component.publicservice.model.MailSenderInfo;

public interface MailSenderClient {
    
    public MailSenderInfo init();

    public boolean sendTextMail(String receiveEmail,String content);

    public boolean sendHtmlMail(String receiveEmail,String content);
}
