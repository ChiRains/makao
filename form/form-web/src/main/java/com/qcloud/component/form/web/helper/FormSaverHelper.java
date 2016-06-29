package com.qcloud.component.form.web.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.form.FormEvent.FormEventType;
import com.qcloud.component.form.engine.FormEngineService;
import com.qcloud.component.form.engine.FormEventService;
import com.qcloud.component.form.entity.ChildForm;
import com.qcloud.component.form.entity.ChildFormData;
import com.qcloud.component.form.entity.EventContextEntity;
import com.qcloud.component.form.entity.FormData;
import com.qcloud.component.form.entity.MainForm;
import com.qcloud.component.form.entity.MainFormData;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.FormInstance;
import com.qcloud.component.form.web.form.Form;
import com.qcloud.component.form.web.form.NotionForm;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.QDepartment;
import com.qcloud.component.organization.QPost;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class FormSaverHelper {

    @Autowired
    private FormEngineService  formEngineService;

    @Autowired
    private FormEventService   formEventService;

    @Autowired
    private OrganizationClient organizationClient;

    /**
     * 保存表单数据
     * 
     * @param form
     * @return
     */
    public EventContextEntity save(Map<String, String> param, QClerk clerk, Form form, NotionForm notionForm) {

        // 根据formID获取表单定义和子表单定义
        MainForm mainForm = formEngineService.getForm(form.getFormId());
        // 保存页面提交的信息,包含业务上的数据
        Map<String, Object> map = new HashMap<String, Object>(param);
        FormInstance fi = new FormInstance();
        fi.setFormId(form.getFormId());
        if (form.getFormInstanceId() != null && form.getFormInstanceId() > 0) {
            fi.setId(form.getFormInstanceId());
        }
        EventContextEntity context = new EventContextEntity();
        context.setParameterMap(map);
        //
        context.setNotionReason(notionForm.getNotion_reason());
        context.setNotionResult(notionForm.getNotion_result());
        context.setSaveAndSubmit(Boolean.valueOf(form.getSaveAndSubmit()));
        context.setProcessId(form.getProcessId());
        context.setProcessInstId(form.getProcessInstId());
        context.setWorkitemId(form.getWorkitemId());
        context.setTaskId(form.getTaskId());
        context.setMainForm(mainForm);
        context.setFormInstId(form.getFormInstanceId());
        // TODO
        context.setClerkId(clerk.getId());
        context.setDepartmentId(clerk.getDepartmentId());
        context.setPostId(clerk.getPostId());
        //
        // 第一步需要设置执行人的
        context.addParameter(FormEvent.QC_EXECUTOR, String.valueOf(context.getClerkId()));
        context.setClerkName(clerk.getName());
        //
        QDepartment department = organizationClient.getDepartment(context.getDepartmentId());
        AssertUtil.assertNotNull(department, "部门不存在." + context.getDepartmentId());
        context.setDepartmentName(department.getName());
        //
        // QPost post = organizationClient.getPost(context.getPostId());
        // AssertUtil.assertNotNull(post, "岗位不存在." + context.getPostId());
        // context.setPostName(post.getName());
        formEventService.doEvent(context.getFormCode(), FormEventType.FORMAT_BEFORE, context, null);
        Map<String, Object> resultMap = context.getReturnMap();
        //
        MainFormData mainFormData = new MainFormData(mainForm);
        fillFormData(param, mainFormData, resultMap);
        formEngineService.save(fi, mainFormData, context);
        return context;
    }

    // 将表单对象从请求对象转化为模型对象
    private void fillFormData(Map<String, String> param, MainFormData mainFormData, Map<String, Object> eventMap) {

        MainForm mainForm = mainFormData.getMainForm();
        List<ElementDef> elementList = mainForm.getElementList();
        FormData formData = new FormData(elementList);
        for (ElementDef elementDef : elementList) {
            String value = param.get(elementDef.getCode());
            Object rv = eventMap.get(elementDef.getCode());
            if (rv != null && StringUtils.isNotEmpty(rv.toString())) {
                value = rv.toString();
            }
            if (value != null) {
                formData.put(elementDef, value);
            }
        }
        mainFormData.setFormData(formData);
        List<ChildForm> children = mainForm.getChildren();
        List<ChildFormData> childFormDataList = new ArrayList<ChildFormData>();
        for (ChildForm childForm : children) {
            ChildFormData childFormData = new ChildFormData(mainFormData, childForm);
            fillFormData(param, childFormData, eventMap);
            childFormDataList.add(childFormData);
        }
        mainFormData.setChildren(childFormDataList);
    }

    // 将子表单元素从请求对象转化为模型对象
    private void fillFormData(Map<String, String> param, ChildFormData childFormData, Map<String, Object> eventMap) {

        ChildForm childForm = childFormData.getChildForm();
        String nk = childForm.getCode() + ".qc_inner_number";
        String numberStr = param.get(nk);
        Object nrv = eventMap.get(nk);
        if (nrv != null && StringUtils.isNotEmpty(nrv.toString())) {
            numberStr = nrv.toString();
        }
        if (StringUtils.isEmpty(numberStr)) {
            return;
        }
        int number = Integer.parseInt(numberStr);
        List<FormData> formDataList = new ArrayList<FormData>();
        List<ElementDef> elementList = childForm.getElementList();
        for (int index = 0; index < number; index++) {
            FormData formData = new FormData(elementList);
            for (ElementDef elementDef : elementList) {
                String key = childForm.getCode() + "[" + index + "]." + elementDef.getCode();
                String value = param.get(key);
                Object rv = eventMap.get(key);
                if (rv != null && StringUtils.isNotEmpty(rv.toString())) {
                    value = rv.toString();
                }
                if (value != null) {
                    formData.put(elementDef, value);
                }
            }
            String key = childForm.getCode() + "[" + index + "].qc_inner_delete";
            String value = param.get(key);
            Object rv = eventMap.get(key);
            if (rv != null && StringUtils.isNotEmpty(rv.toString())) {
                value = rv.toString();
            }
            if ("1".equals(value)) {
                formData.setDelete();
            }
            formDataList.add(formData);
        }
        childFormData.setFormDataList(formDataList);
    }
}
