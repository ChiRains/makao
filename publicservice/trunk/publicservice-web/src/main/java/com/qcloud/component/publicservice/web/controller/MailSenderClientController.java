package com.qcloud.component.publicservice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.publicdata.exception.PublicdataException;
import com.qcloud.component.publicservice.MailSenderClient;
import com.qcloud.component.publicservice.SmsMessageLimitClient;
import com.qcloud.component.publicservice.VerificationCodeClient;
import com.qcloud.component.publicservice.SmsMessageLimitClient.SmsMessageStateType;
import com.qcloud.pirates.mvc.FrontAjaxView;

@Controller
@RequestMapping(value = MailSenderClientController.DIR)
public class MailSenderClientController {

    public final static String     DIR = "/mailSender";

    @Autowired
    private MailSenderClient       mailSenderClient;

    @Autowired
    private SmsMessageLimitClient  smsMessageLimitClient;

    @Autowired
    private VerificationCodeClient verificationCodeClient;

    @RequestMapping
    public FrontAjaxView sendMail(String email) {

        // String title="横琴通关系统";
        SmsMessageStateType type = smsMessageLimitClient.canSend(email, "email");
        if (SmsMessageStateType.NUMBER_LIMIT.equals(type)) {
            throw new PublicdataException("短信发送失败,已经超出今天发送最大数量.");
        }
        if (SmsMessageStateType.TIME_LIMIT.equals(type)) {
            throw new PublicdataException("短信发送失败,发送太频繁,请稍等.");
        }
        // Hello, your email registration verification code is 30, the effective time is 594410 minutes
        String content = "Hello, your email registration verification code is {code},the effective time is{minute} minutes";
        String code = verificationCodeClient.create(email, 30);
        content = content.replaceAll("\\{code\\}", code);
        content = content.replaceAll("\\{minute\\}", "30");
        FrontAjaxView view = new FrontAjaxView();
        try {
            // if (mailSenderClient.sendTextMail(email, content)) {
            // smsMessageLimitClient.send(email, 1);
            // view.setMessage("发送成功");
            // }
            if (mailSenderClient.sendHtmlMail(email, content)) {
                smsMessageLimitClient.send(email, "email", 1);
                view.setMessage("发送成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            view.setMessage("发送失败");
            throw new PublicdataException("邮箱验证码发送失败");
        }
        // view.addObject("code",code);
        return view;
    }
}
