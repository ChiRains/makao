package com.qcloud.component.form.formatter.impl;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.entity.ChildFormData;
import com.qcloud.component.form.entity.FormData;
import com.qcloud.component.form.entity.MainFormData;
import com.qcloud.component.form.formatter.Formatter;
import com.qcloud.component.form.formatter.FormatterContext;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.key.TypeEnum;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.QDepartment;
import com.qcloud.component.organization.QPost;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class OrganizationFormatter implements Formatter {

    @Autowired
    OrganizationClient organizationClient;

    @Override
    public void format4Save(FormatterContext context, MainFormData mainFormData) {

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
            if (elementDef.getCode().startsWith(TypeEnum.QC_ORGANIZATION_CLERK_ID_)) {
                String clerkIdStr = (String) formData.getDataMap().get(elementDef);
                if (StringUtils.isNotEmpty(clerkIdStr)) {
                    Long clerkId = Long.valueOf(clerkIdStr);
                    String suffixCode = elementDef.getCode().substring(TypeEnum.QC_ORGANIZATION_CLERK_ID_.length(), elementDef.getCode().length());
                    if (clerkId != null) {
                        QClerk clerk = organizationClient.getClerk(clerkId);
                        if (clerk != null) {
                            String nameCode = TypeEnum.QC_ORGANIZATION_CLERK_NAME_ + suffixCode;
                            ElementDef nameElementDef = getElementDefByCode(list, TypeEnum.QC_ORGANIZATION_CLERK_NAME_ + suffixCode);
                            AssertUtil.assertNotNull(nameElementDef, "机构职员没有找到对应的用户名元素:" + nameCode + "[" + elementDef.getCode() + "]");
                            formData.put(nameElementDef, clerk.getName());
                        }
                    }
                }
            } else if (elementDef.getCode().startsWith(TypeEnum.QC_ORGANIZATION_DEPARDMENT_ID_)) {
                String departmentIdStr = (String) formData.getDataMap().get(elementDef);
                if (StringUtils.isNotEmpty(departmentIdStr)) {
                    Long departmentId = Long.valueOf(departmentIdStr);
                    String suffixCode = elementDef.getCode().substring(TypeEnum.QC_ORGANIZATION_DEPARDMENT_ID_.length(), elementDef.getCode().length());
                    if (departmentId != null) {
                        QDepartment department = organizationClient.getDepartment(departmentId);
                        if (department != null) {
                            String nameCode = TypeEnum.QC_ORGANIZATION_DEPARDMENT_NAME_ + suffixCode;
                            ElementDef nameElementDef = getElementDefByCode(list, TypeEnum.QC_ORGANIZATION_DEPARDMENT_NAME_ + suffixCode);
                            AssertUtil.assertNotNull(nameElementDef, "机构部门没有找到对应的部门名称元素:" + nameCode + "[" + elementDef.getCode() + "]");
                            formData.put(nameElementDef, department.getName());
                        }
                    }
                }
            } else if (elementDef.getCode().startsWith(TypeEnum.QC_ORGANIZATION_POST_ID_)) {
                String postIdStr = (String) formData.getDataMap().get(elementDef);
                if (StringUtils.isNotEmpty(postIdStr)) {
                    Long postId = Long.valueOf(postIdStr);
                    String suffixCode = elementDef.getCode().substring(TypeEnum.QC_ORGANIZATION_POST_ID_.length(), elementDef.getCode().length());
                    if (postId != null) {
                        QPost post = organizationClient.getPost(postId);
                        if (post != null) {
                            String nameCode = TypeEnum.QC_ORGANIZATION_POST_NAME_ + suffixCode;
                            ElementDef nameElementDef = getElementDefByCode(list, TypeEnum.QC_ORGANIZATION_POST_NAME_ + suffixCode);
                            AssertUtil.assertNotNull(nameElementDef, "机构角色没有找到对应的角色名称元素:" + nameCode + "[" + elementDef.getCode() + "]");
                            formData.put(nameElementDef, post.getName());
                        }
                    }
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

    }
}
