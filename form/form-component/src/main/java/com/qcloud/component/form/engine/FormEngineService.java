package com.qcloud.component.form.engine;

import java.util.List;
import com.qcloud.component.form.entity.ChildForm;
import com.qcloud.component.form.entity.EventContextEntity;
import com.qcloud.component.form.entity.FormData;
import com.qcloud.component.form.entity.MainForm;
import com.qcloud.component.form.entity.MainFormData;
import com.qcloud.component.form.model.FormInstance;
import com.qcloud.component.form.model.FormInstanceHist;

/**
 * 表单引擎服务
 * 
 * @author Zoro
 */
public interface FormEngineService {

    MainForm getForm(Long formId);

    boolean save(FormInstance formInstance, MainFormData mainFormData, EventContextEntity context);

    FormInstanceHist submit(FormInstance formInstance, EventContextEntity context);

    MainFormData get(FormInstance formInstance);

    MainFormData get(FormInstanceHist formInstanceHist);

    List<FormData> listChildFormData(ChildForm childForm, long masterId);
}
