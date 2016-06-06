package com.qcloud.component.form.formatter.impl;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.ProcessGetter;
import com.qcloud.component.form.entity.ChildFormData;
import com.qcloud.component.form.entity.FormData;
import com.qcloud.component.form.entity.MainFormData;
import com.qcloud.component.form.formatter.Formatter;
import com.qcloud.component.form.formatter.FormatterContext;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.key.TypeEnum;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class ProcessFormatter implements Formatter {

    @Autowired(required = false)
    ProcessGetter processGetter;

    private Log   logger = LogFactory.getLog(getClass());

    @Override
    public void format4Save(FormatterContext context, MainFormData mainFormData) {

        if (processGetter == null) {
            logger.info("process getter can not found implement");
            return;
        }
        List<ElementDef> list = mainFormData.getMainForm().getElementList();
        format4Save(list, mainFormData.getFormData());
        for (ChildFormData childFormData : mainFormData.getChildren()) {
            for (FormData formData : childFormData.getFormDataList()) {
                format4Save(childFormData.getChildForm().getElementList(), formData);
            }
        }
    }

    private void format4Save(List<ElementDef> list, FormData formData) {

        for (ElementDef elementDef : list) {
            if (elementDef.getCode().startsWith(TypeEnum.QC_SNAKER_WORKITEM_ID_)) {
                String workitemId = (String) formData.getDataMap().get(elementDef);
                String workitemName = processGetter.getWorkitemName(workitemId);
                if (StringUtils.isNotEmpty(workitemName)) {
                    String suffixCode = elementDef.getCode().substring(TypeEnum.QC_SNAKER_WORKITEM_ID_.length(), elementDef.getCode().length());
                    String nameCode = TypeEnum.QC_SNAKER_WORKITEM_NAME_ + suffixCode;
                    ElementDef nameElementDef = getElementDefByCode(list, TypeEnum.QC_SNAKER_WORKITEM_NAME_ + suffixCode);
                    AssertUtil.assertNotNull(nameElementDef, "表单元素没有找到对应的任务名称元素:" + nameCode + "[" + elementDef.getCode() + "]");
                    formData.put(nameElementDef, workitemName);
                }
            } else if (elementDef.getCode().startsWith(TypeEnum.QC_SNAKER_PROCESS_ID_)) {
                String processId = (String) formData.getDataMap().get(elementDef);
                String processName = processGetter.getProcessName(processId);
                if (StringUtils.isNotEmpty(processName)) {
                    String suffixCode = elementDef.getCode().substring(TypeEnum.QC_SNAKER_PROCESS_ID_.length(), elementDef.getCode().length());
                    String nameCode = TypeEnum.QC_SNAKER_PROCESS_NAME_ + suffixCode;
                    ElementDef nameElementDef = getElementDefByCode(list, TypeEnum.QC_SNAKER_PROCESS_NAME_ + suffixCode);
                    AssertUtil.assertNotNull(nameElementDef, "表单元素没有找到对应的流程名称元素:" + nameCode + "[" + elementDef.getCode() + "]");
                    formData.put(nameElementDef, processName);
                }
            }
        }
    }

    private ElementDef getElementDefByCode(List<ElementDef> list, String code) {

        for (ElementDef elementDef : list) {
            if (elementDef.getCode().equals(code)) {
                return elementDef;
            }
        }
        return null;
    }

    @Override
    public void format4View(MainFormData mainFormData) {

        if (processGetter == null) {
            logger.info("process getter can not found implement");
            return;
        }
    }
}
