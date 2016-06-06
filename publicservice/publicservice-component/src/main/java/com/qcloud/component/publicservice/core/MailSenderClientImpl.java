package com.qcloud.component.publicservice.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.publicservice.MailSenderClient;
import com.qcloud.component.publicservice.dao.MailSenderDao;
import com.qcloud.component.publicservice.model.MailSenderInfo;
import com.qcloud.pirates.core.reflect.BeanUtils;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class MailSenderClientImpl implements MailSenderClient {

    private final String  MAIL_SENDER_INFO = "mailSenderInfo";

    @Autowired
    private MailSenderDao mailSenderDao;

    @Override
    public MailSenderInfo init() {

        MailSenderInfo info = new MailSenderInfo();
        Xml xml = XmlFactory.get(MAIL_SENDER_INFO);
        AssertUtil.assertNotNull(xml, "请初始化参数：" + MAIL_SENDER_INFO);
        List<XmlItem> itemList = xml.getItemList();
        //Map<String, Object> map=new HashMap<String, Object>();
        for (XmlItem xmlItem : itemList) {
            if (xmlItem.getAttrMap().get("key").equals("mailServerHost")) {
                info.setMailServerHost(xmlItem.getText());
            }
            if (xmlItem.getAttrMap().get("key").equals("mailServerPort")) {
                info.setMailServerPort(xmlItem.getText());
            }
            if (xmlItem.getAttrMap().get("key").equals("username")) {
                info.setUserName(xmlItem.getText());
            }
            if (xmlItem.getAttrMap().get("key").equals("password")) {
                info.setPassword(xmlItem.getText());
            }
            if (xmlItem.getAttrMap().get("key").equals("fromAddress")) {
                info.setFromAddress(xmlItem.getText());
            }
            if (xmlItem.getAttrMap().get("key").equals("mailLocalhost")) {
                info.setLocalhost(xmlItem.getText());
            }
            if (xmlItem.getAttrMap().get("key").equals("mailDebug")) {
                info.setDebug(Boolean.valueOf(xmlItem.getText()));
            }
            //map.put(xmlItem.getAttrMap().get("key"), xmlItem.getText());
        }
        //BeanUtils.transMap2Bean(map, info);
        return info;
    }

    @Override
    public boolean sendTextMail(String receiveEmail, String content) {

        MailSenderInfo info = init();
        info.setToAddress(receiveEmail);
        info.setContent(content);
        info.setSubject("");
        return mailSenderDao.sendTextMail(info);
    }

    @Override
    public boolean sendHtmlMail(String receiveEmail, String content) {

        MailSenderInfo info = init();
        info.setToAddress(receiveEmail);
        info.setContent(content);
        info.setSubject("");
        return mailSenderDao.sendHtmlMail(info);
    }
}
