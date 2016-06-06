package com.qcloud.component.snakerext.web.handler.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.snaker.engine.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.form.QMainForm;
import com.qcloud.component.snaker.web.FormGetter;
import com.qcloud.component.snakerext.model.ProcessForm;
import com.qcloud.component.snakerext.service.ProcessFormService;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class FormGetterImpl implements FormGetter {

    @Autowired
    private ProcessFormService processFormService;

    @Autowired
    private FormClient         formClient;

    @Override
    public Long getForm(Process process) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("processId", process.getId());
        List<ProcessForm> list = processFormService.list(map);
        if (list.size() > 0) {
            return list.get(0).getMainFormId();
        }
        return null;
    }

    @Override
    public String getPcApplyUrl(Long formId) {

        QMainForm mainForm = formClient.getForm(formId);
        AssertUtil.assertNotNull(mainForm, "表单定义不存在." + formId);
        return mainForm.getPcApplyViewUrl();
    }

    @Override
    public String getMobileApplyUrl(Long formId) {

        QMainForm mainForm = formClient.getForm(formId);
        AssertUtil.assertNotNull(mainForm, "表单定义不存在." + formId);
        return mainForm.getMobileApplyViewUrl();
    }

    @Override
    public String getMobileDomain() {

        return formClient.getMobileDomain();
    }
}
