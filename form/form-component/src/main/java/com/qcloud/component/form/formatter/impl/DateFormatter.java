package com.qcloud.component.form.formatter.impl;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.entity.ChildFormData;
import com.qcloud.component.form.entity.FormData;
import com.qcloud.component.form.entity.MainFormData;
import com.qcloud.component.form.formatter.Formatter;
import com.qcloud.component.form.formatter.FormatterContext;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.key.TypeEnum;
import com.qcloud.component.form.model.key.TypeEnum.ElementType;
import com.qcloud.pirates.util.DateUtil;

@Component
public class DateFormatter implements Formatter {

    @Override
    public void format4Save(FormatterContext context, MainFormData mainFormData) {

    }

    @Override
    public void format4View(MainFormData mainFormData) {

        List<ElementDef> list = mainFormData.getMainForm().getElementList();
        format4View(list, mainFormData.getFormData());
        for (ChildFormData childFormData : mainFormData.getChildren()) {
            for (FormData formData : childFormData.getFormDataList()) {
                format4View(childFormData.getChildForm().getElementList(), formData);
            }
        }
    }

    private void format4View(List<ElementDef> list, FormData formData) {

        for (ElementDef elementDef : list) {
            if (elementDef.getCode().startsWith(TypeEnum.QC_CURRENT_TIME_)) {
                formData.put(elementDef, DateUtil.date2String(new Date()));
            } else {
                if (ElementType.DATE.getKey() == elementDef.getType()) {
                    Date date = (Date) formData.getDataMap().get(elementDef);
                    if (date != null) {
                        formData.put(elementDef, DateUtil.date2String(date));
                    }
                }
            }
        }
    }
}
