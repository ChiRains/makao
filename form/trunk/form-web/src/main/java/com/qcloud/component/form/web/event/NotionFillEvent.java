package com.qcloud.component.form.web.event;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.form.engine.FormEngineService;
import com.qcloud.component.form.entity.ChildForm;
import com.qcloud.component.form.entity.FormData;
import com.qcloud.component.form.entity.MainForm;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.FormInstance;
import com.qcloud.component.form.model.key.TypeEnum;
import com.qcloud.component.form.service.FormInstanceService;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;

@Component
public class NotionFillEvent implements FormEvent {

    @Autowired
    FormEngineService   formEngineService;

    @Autowired
    FormInstanceService formInstanceService;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        if (context.getNotionResult() != null && (context.getNotionResult() == 1 || context.getNotionResult() == 2)) {
            FormInstance formInstance = formInstanceService.get(context.getFormInstId());
            AssertUtil.assertNotNull(formInstance, "表单实例不存在." + context.getFormInstId());
            String taskName = (String) context.getParameter("snaker_task_name");
            AssertUtil.assertNotEmpty(taskName, "流程活动编码不能为空.");
            String formCode = context.getFormCode();
            AssertUtil.assertNotEmpty(formCode, "表单编码不能为空.");
            String code = getNotionName(taskName, formCode);
            AssertUtil.assertNotEmpty(code, "流程环境意见保存子表尚未映射." + formCode + " " + taskName);
            ChildForm childForm = getNotionChildForm(context.getFormId(), code);
            AssertUtil.assertNotNull(childForm, code);
            ElementDef workitemIdEle = getEleDef(childForm, TypeEnum.QC_NOTION_WORKITEM_ID_);
            AssertUtil.assertNotNull(workitemIdEle, "意见审核元素未定义." + TypeEnum.QC_NOTION_WORKITEM_ID_);
            List<FormData> list = formEngineService.listChildFormData(childForm, formInstance.getDataId());
            String id = "";
            for (FormData formData : list) {
                if (context.getWorkitemId().equals(formData.getDataMap().get(workitemIdEle))) {
                    Object obj = formData.getDataMap().get(getEleDef(childForm, TypeEnum.QC_MD_ID));
                    if (obj != null) {
                        id = obj.toString();
                    }
                }
            }
            context.addReturnResult(code + ".qc_inner_number", "1");
            context.addReturnResult(code + "[0].content", context.getNotionReason());
            context.addReturnResult(code + "[0].qc_sw_workitem", context.getWorkitemId());
            context.addReturnResult(code + "[0].result", String.valueOf(context.getNotionResult()));
            context.addReturnResult(code + "[0].id", id);
        }
    }

    public static String getNotionName(String taskName, String formCode) {

        Xml xml = XmlFactory.get("qi-cloud-FormNotionProcessTaskMapping");
        AssertUtil.assertNotNull(xml, "表单意见流程活动映射尚未配置.");
        List<XmlItem> list = xml.getItemList();
        for (XmlItem xmlItem : list) {
            if (formCode.equals(xmlItem.getAttrMap().get("form")) && taskName.equals(xmlItem.getAttrMap().get("acticity"))) {
                return StringUtil.nullToEmpty(xmlItem.getText()).trim();
            }
        }
        return null;
    }

    private ElementDef getEleDef(ChildForm childForm, String code) {

        ElementDef workitemIdEle = null;
        for (ElementDef elementDef : childForm.getElementList()) {
            if (elementDef.getCode().equals(code)) {
                workitemIdEle = elementDef;
                continue;
            }
        }
        return workitemIdEle;
    }

    private ChildForm getNotionChildForm(Long formId, String code) {

        MainForm form = formEngineService.getForm(formId);
        List<ChildForm> list = form.getChildren();
        for (ChildForm childForm : list) {
            if (childForm.getCode().equals(code)) {
                return childForm;
            }
        }
        return null;
    }
}
