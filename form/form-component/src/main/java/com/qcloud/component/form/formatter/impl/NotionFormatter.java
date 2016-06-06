package com.qcloud.component.form.formatter.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.ProcessGetter;
import com.qcloud.component.form.entity.ChildForm;
import com.qcloud.component.form.entity.ChildFormData;
import com.qcloud.component.form.entity.FormData;
import com.qcloud.component.form.entity.MainFormData;
import com.qcloud.component.form.formatter.Formatter;
import com.qcloud.component.form.formatter.FormatterContext;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.key.TypeEnum;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.StringUtil;

@Component
public class NotionFormatter implements Formatter {

    @Autowired(required = false)
    ProcessGetter processGetter;

    private Log   logger = LogFactory.getLog(getClass());

    @Override
    public void format4Save(FormatterContext context, MainFormData mainFormData) {

        for (ChildFormData childFormData : mainFormData.getChildren()) {
            ChildForm childForm = childFormData.getChildForm();
            if (childForm.getCode().startsWith(TypeEnum.QC_NOTION_)) {
                List<FormData> notSaveList = new ArrayList<FormData>();
                for (FormData formData : childFormData.getFormDataList()) {
                    format4Save(context, childForm, formData, notSaveList);
                }
                for (FormData formData : notSaveList) {
                    childFormData.remove(formData);
                }
            }
        }
    }

    private void format4Save(FormatterContext context, ChildForm childForm, FormData formData, List<FormData> notSaveList) {

        List<ElementDef> list = childForm.getElementList();
        ElementDef clerkIdEle = null;
        ElementDef clerkNameEle = null;
        ElementDef departmentIdEle = null;
        ElementDef departmentNameEle = null;
        ElementDef postIdEle = null;
        ElementDef postNameEle = null;
        ElementDef workitemIdEle = null;
        ElementDef workitemNameEle = null;
        ElementDef taskEle = null;
        ElementDef timeEle = null;
        for (ElementDef elementDef : list) {
            if (elementDef.getCode().equals(TypeEnum.QC_NOTION_CLERK_ID_)) {
                clerkIdEle = elementDef;
                continue;
            } else if (elementDef.getCode().equals(TypeEnum.QC_NOTION_CLERK_NAME_)) {
                clerkNameEle = elementDef;
                continue;
            } else if (elementDef.getCode().equals(TypeEnum.QC_NOTION_DEPARDMENT_ID_)) {
                departmentIdEle = elementDef;
                continue;
            } else if (elementDef.getCode().equals(TypeEnum.QC_NOTION_DEPARDMENT_NAME_)) {
                departmentNameEle = elementDef;
                continue;
            } else if (elementDef.getCode().equals(TypeEnum.QC_NOTION_POST_ID_)) {
                postIdEle = elementDef;
                continue;
            } else if (elementDef.getCode().equals(TypeEnum.QC_NOTION_POST_NAME_)) {
                postNameEle = elementDef;
                continue;
            } else if (elementDef.getCode().equals(TypeEnum.QC_NOTION_WORKITEM_ID_)) {
                workitemIdEle = elementDef;
                continue;
            } else if (elementDef.getCode().equals(TypeEnum.QC_NOTION_WORKITEM_NAME_)) {
                workitemNameEle = elementDef;
                continue;
            } else if (elementDef.getCode().equals(TypeEnum.QC_NOTION_TASK_)) {
                taskEle = elementDef;
                continue;
            } else if (elementDef.getCode().equals(TypeEnum.QC_NOTION_TIME_)) {
                timeEle = elementDef;
                continue;
            }
        }
        AssertUtil.assertNotNull(clerkIdEle, "意见审核元素未定义." + TypeEnum.QC_NOTION_CLERK_ID_);
        AssertUtil.assertNotNull(clerkNameEle, "意见审核元素未定义." + TypeEnum.QC_NOTION_CLERK_NAME_);
        AssertUtil.assertNotNull(departmentIdEle, "意见审核元素未定义." + TypeEnum.QC_NOTION_DEPARDMENT_ID_);
        AssertUtil.assertNotNull(departmentNameEle, "意见审核元素未定义." + TypeEnum.QC_NOTION_DEPARDMENT_NAME_);
        AssertUtil.assertNotNull(postIdEle, "意见审核元素未定义." + TypeEnum.QC_NOTION_POST_ID_);
        AssertUtil.assertNotNull(postNameEle, "意见审核元素未定义." + TypeEnum.QC_NOTION_POST_NAME_);
        AssertUtil.assertNotNull(workitemIdEle, "意见审核元素未定义." + TypeEnum.QC_NOTION_WORKITEM_ID_);
        AssertUtil.assertNotNull(workitemNameEle, "意见审核元素未定义." + TypeEnum.QC_NOTION_WORKITEM_NAME_);
        AssertUtil.assertNotNull(taskEle, "意见审核元素未定义." + TypeEnum.QC_NOTION_TASK_);
        AssertUtil.assertNotNull(timeEle, "意见审核元素未定义." + TypeEnum.QC_NOTION_TIME_);
        String workitem = (String) formData.getDataMap().get(workitemIdEle);
        if (workitem != null && !workitem.equals(context.getWorkitemId())) {
            //
            notSaveList.add(formData);
            return;
        }
        // change
        formData.put(clerkIdEle, String.valueOf(context.getClerkId()));
        formData.put(clerkNameEle, context.getClerkName());
        formData.put(departmentIdEle, String.valueOf(context.getDepartmentId()));
        formData.put(departmentNameEle, context.getDepartmentName());
        formData.put(postIdEle, String.valueOf(context.getPostId()));
        formData.put(postNameEle, context.getPostName());
        formData.put(workitemIdEle, context.getWorkitemId());
        formData.put(taskEle, String.valueOf(context.getTaskId()));
        if (processGetter == null) {
            logger.info("process getter can not found implement");
            formData.put(workitemNameEle, "");
        } else {
            String workitemName = processGetter.getWorkitemName(context.getWorkitemId());
            workitemName = StringUtil.nullToEmpty(workitemName);
            formData.put(workitemNameEle, workitemName);
        }
        formData.put(timeEle, DateUtil.date2String(context.getSystemUnifiedDate()));
    }

    @Override
    public void format4View(MainFormData mainFormData) {

    }
}
