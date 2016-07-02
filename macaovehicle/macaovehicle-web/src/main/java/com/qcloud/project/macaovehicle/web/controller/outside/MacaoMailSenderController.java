package com.qcloud.project.macaovehicle.web.controller.outside;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.publicdata.exception.PublicdataException;
import com.qcloud.component.publicservice.SmsMessageLimitClient;
import com.qcloud.component.publicservice.SmsMessageLimitClient.SmsMessageStateType;
import com.qcloud.component.publicservice.VerificationCodeClient;
import com.qcloud.component.publicservice.model.MailSenderInfo;
import com.qcloud.component.publicservice.model.MyAuthenticator;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.Base64;
import com.qcloud.pirates.util.DateUtil;

@Controller
@RequestMapping(value = "/" + MacaoMailSenderController.DIR)
public class MacaoMailSenderController {

    private final String           MAIL_SENDER_INFO = "mailSenderInfo";

    public final static String     DIR              = "/macaoMail";

    @Autowired
    private SmsMessageLimitClient  smsMessageLimitClient;

    @Autowired
    private VerificationCodeClient verificationCodeClient;

    @RequestMapping
    public FrontAjaxView sendMail(String email) {

        // String title="横琴通关系统";
        SmsMessageStateType type = smsMessageLimitClient.canSend(email, "macao-email");
        if (SmsMessageStateType.NUMBER_LIMIT.equals(type)) {
            throw new PublicdataException("短信发送失败,已经超出今天发送最大数量.");
        }
        if (SmsMessageStateType.TIME_LIMIT.equals(type)) {
            throw new PublicdataException("短信发送失败,发送太频繁,请稍等.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("您好！您正在註冊通關門戶網帳號，本次請求的驗證碼為：{code}（請在{minute}分鐘內完成驗證，逾時該驗證碼失效。）");
        sb.append("<br/><br/><br/><br/>");
        sb.append("橫琴新區管委會");
        sb.append("<br/>");
        sb.append("{time}");
        String content = sb.toString();
        String code = verificationCodeClient.create(email, 30);
        content = content.replaceAll("\\{code\\}", code);
        content = content.replaceAll("\\{minute\\}", "30");
        content = content.replaceAll("\\{time\\}", DateUtil.date2String(new Date(), "yyyy年MM月dd日"));
        FrontAjaxView view = new FrontAjaxView();
        try {
            if (this.sendHtmlMail(email, "註冊通關門戶網帳號", content)) {
                smsMessageLimitClient.send(email, "macao-email", 1);
                view.setMessage("发送成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            view.setMessage("发送失败");
            throw new PublicdataException("邮箱验证码发送失败");
        }
        // view.addObject("code", code);
        return view;
    }

    @RequestMapping
    public FrontAjaxView sendMail4Reset(String email) {

        // String title="横琴通关系统";
        SmsMessageStateType type = smsMessageLimitClient.canSend(email, "macao-email");
        if (SmsMessageStateType.NUMBER_LIMIT.equals(type)) {
            throw new PublicdataException("短信发送失败,已经超出今天发送最大数量.");
        }
        if (SmsMessageStateType.TIME_LIMIT.equals(type)) {
            throw new PublicdataException("短信发送失败,发送太频繁,请稍等.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("您好！您申請重置通關門戶網帳號密碼，本次請求的驗證碼為：{code}（請在{minute}分鐘內完成驗證，逾時該驗證碼失效。）");
        sb.append("<br/><br/><br/><br/>");
        sb.append("橫琴新區管委會");
        sb.append("<br/>");
        sb.append("{time}");
        String content = sb.toString();
        String code = verificationCodeClient.create(email, 30);
        content = content.replaceAll("\\{code\\}", code);
        content = content.replaceAll("\\{minute\\}", "30");
        content = content.replaceAll("\\{time\\}", DateUtil.date2String(new Date(), "yyyy年MM月dd日"));
        FrontAjaxView view = new FrontAjaxView();
        try {
            if (this.sendHtmlMail(email, "重置通關門戶網帳號", content)) {
                smsMessageLimitClient.send(email, "macao-email", 1);
                view.setMessage("发送成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            view.setMessage("发送失败");
            throw new PublicdataException("邮箱验证码发送失败");
        }
        // view.addObject("code", code);
        return view;
    }

    private MailSenderInfo init() {

        MailSenderInfo info = new MailSenderInfo();
        Xml xml = XmlFactory.get(MAIL_SENDER_INFO);
        AssertUtil.assertNotNull(xml, "请初始化参数：" + MAIL_SENDER_INFO);
        List<XmlItem> itemList = xml.getItemList();
        // Map<String, Object> map=new HashMap<String, Object>();
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
                info.setPassword(Base64.decode(xmlItem.getText()).replace("@qi-cloud.com", ""));
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
            // map.put(xmlItem.getAttrMap().get("key"), xmlItem.getText());
        }
        // BeanUtils.transMap2Bean(map, info);
        return info;
    }

    private boolean sendTextMail(String receiveEmail, String content) {

        MailSenderInfo info = init();
        info.setToAddress(receiveEmail);
        info.setContent(content);
        info.setSubject("");
        return this.sendTextMail(info);
    }

    private boolean sendHtmlMail(String receiveEmail, String subject, String content) {

        MailSenderInfo info = init();
        info.setToAddress(receiveEmail);
        info.setContent(content);
        info.setSubject(subject);
        return this.sendHtmlMail(info);
    }

    private synchronized boolean sendTextMail(MailSenderInfo mailInfo) {

        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if (mailInfo.isValidate()) {
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        if (sendMailSession == null) {
            return false;
        }
        try {
            // sendMailSession.setDebug(true);
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(mailInfo.getToAddress());
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // 设置邮件消息的主要内容
            String mailContent = mailInfo.getContent();
            mailMessage.setText(mailContent);
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
            return false;
        }
        // return false;
    }

    /** 
     * 以HTML格式发送邮件 
     * @param mailInfo 待发送的邮件信息 
     * @throws UnsupportedEncodingException 
     */
    private synchronized boolean sendHtmlMail(MailSenderInfo mailInfo) {

        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        // 如果需要身份认证，则创建一个密码验证器
        if (mailInfo.isValidate()) {
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(mailInfo.getToAddress());
            // Message.RecipientType.TO属性表示接收者的类型为TO
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 发送附件
            // MimeBodyPart mailArchieve = new MimeBodyPart();
            // String filename = this.getClass().getClassLoader().getResource("logo.png").getPath();
            // filename=filename.substring(1);
            // System.out.println(filename);
            // FileDataSource fds = new FileDataSource(filename);
            // mailArchieve.setDataHandler(new DataHandler(fds));
            // mailArchieve.setFileName(MimeUtility.encodeText(fds.getName(), "GBK", "B"));
            // mainPart.addBodyPart(mailArchieve);
            // mailArchieve.setHeader("Content-ID", "<image>");
            // 设置HTML内容
            html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            // 将MiniMultipart对象设置为邮件内容
            mailMessage.setContent(mainPart);
            // 发送邮件
            Transport.send(mailMessage);
            // Transport transport = sendMailSession.getTransport("smtp");
            // transport.connect(mailInfo.getMailServerHost(), mailInfo.getUserName(), mailInfo.getPassword());
            // transport.sendMessage(mailInfo.getContent(),mailInfo.getToAddress());
            // transport.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
