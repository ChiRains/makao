package com.qcloud.component.publicservice.web.form;

import java.util.List;
import com.qcloud.component.publicservice.model.SmsTemplate;


public class SmsTemplateForm {
    
    List<SmsTemplate> smsTemplates;

    
    public List<SmsTemplate> getSmsTemplates() {
    
        return smsTemplates;
    }

    
    public void setSmsTemplates(List<SmsTemplate> smsTemplates) {
    
        this.smsTemplates = smsTemplates;
    }
    
}
