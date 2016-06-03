package com.qcloud.component.form.engine;

import com.qcloud.component.form.FormEvent;
import com.qcloud.component.form.entity.EventContextEntity;
import com.qcloud.component.form.entity.MainFormData;

/**
 * 表单事件
 * 
 * @author admin
 * 
 */
public interface FormEventService {

    void doEvent(String formCode, FormEvent.FormEventType type, EventContextEntity context, MainFormData mainFormData);
}
