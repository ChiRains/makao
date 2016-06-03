package com.qcloud.component.publicservice.core;

import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.publicservice.SmsClient;
import com.qcloud.component.publicservice.SmsMessageLimitClient;
import com.qcloud.component.publicservice.SmsMessageLimitClient.SmsMessageStateType;
import com.qcloud.component.publicservice.exception.PublicServiceException;
import com.qcloud.component.publicservice.model.SmsResult;
import com.qcloud.component.publicservice.service.SmsService;
import com.qcloud.component.publicservice.service.SmsTemplateService;
import com.qcloud.pirates.util.StringUtil;

@Component
public class SmsClientImpl implements SmsClient {

    @Autowired
    private SmsService            smsService;

    @Autowired
    private SmsTemplateService    smsTemplateService;

    private Log                   logger = LogFactory.getLog(getClass());

    @Autowired
    private SmsMessageLimitClient smsMessageLimitClient;

    @Override
    public boolean[] send(String content, String... receivers) {

        SmsResult[] smsResult = smsService.send(content, receivers);
        boolean[] result = new boolean[smsResult.length];
        for (int index = 0; index < smsResult.length; index++) {
            logger.info("发送短信：" + smsResult[index].getReceiver() + " " + smsResult[index].isSuccess());
            result[index] = smsResult[index].isSuccess();
        }
        return result;
    }

    @Override
    public boolean send(String code, String receiver, Map<String, String> map) {

        SmsMessageStateType type = smsMessageLimitClient.canSend(receiver, code);
        if (SmsMessageStateType.NUMBER_LIMIT.equals(type)) {
            throw new PublicServiceException("短信发送失败,已经超出今天发送最大数量.");
        }
        if (SmsMessageStateType.TIME_LIMIT.equals(type)) {
            throw new PublicServiceException("短信发送失败,发送太频繁,请稍等.");
        }
        String content = smsTemplateService.getByCode(code);
        content = StringUtil.nullToEmpty(content);
        for (Entry<String, String> e : map.entrySet()) {
            content = content.replaceAll("\\{" + e.getKey() + "\\}", StringUtil.nullToEmpty(e.getValue()));
        }
        boolean[] result = send(content, receiver);
        if (result[0]) {
            smsMessageLimitClient.send(receiver, code, 1);
        }
        return result[0];
    }
}
