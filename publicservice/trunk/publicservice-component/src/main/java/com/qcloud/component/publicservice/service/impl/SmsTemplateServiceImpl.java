package com.qcloud.component.publicservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.parameter.ParamType;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.publicservice.model.SmsTemplate;
import com.qcloud.component.publicservice.service.SmsTemplateService;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.util.StringUtil;

@Service
public class SmsTemplateServiceImpl implements SmsTemplateService {

    @Autowired
    private ParameterClient parameterClient;

    @Override
    public List<SmsTemplate> list() {

        Xml xml = XmlFactory.get("publicservice-sms-template");
        if (xml == null) {
            return new ArrayList<SmsTemplate>();
        }
        List<SmsTemplate> stList = new ArrayList<SmsTemplate>();
        List<XmlItem> list = xml.getItemList();
        for (XmlItem xmlItem : list) {
            SmsTemplate smsTemplate = new SmsTemplate();
            smsTemplate.setName(StringUtil.nullToEmpty(xmlItem.getAttrMap().get("name")).trim());
            smsTemplate.setCode(StringUtil.nullToEmpty(xmlItem.getAttrMap().get("code")).trim());
            String value = parameterClient.get(smsTemplate.getCode());
            if (value == null) {
                parameterClient.reg(smsTemplate.getCode(), "", ParamType.STRING);
            }
            smsTemplate.setValue(value);
            stList.add(smsTemplate);
        }
        return stList;
    }

    @Override
    public String getByCode(String code) {

        return parameterClient.get(code);
    }

    @Override
    public boolean save(SmsTemplate smsTemplate) {

        if (smsTemplate != null && StringUtils.isNotEmpty(smsTemplate.getCode())) {
            return parameterClient.reg(smsTemplate.getCode(), smsTemplate.getValue(), ParamType.STRING);
        }
        return false;
    }
}
