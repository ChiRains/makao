package com.qcloud.component.form.web.handler;

import com.qcloud.component.form.entity.MainFormData;
import com.qcloud.component.form.web.vo.MainFormDataVO;

public interface FormHandler {

    MainFormDataVO toVO(MainFormData mainFormData);
}
