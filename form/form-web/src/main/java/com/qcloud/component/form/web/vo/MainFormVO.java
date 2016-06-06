package com.qcloud.component.form.web.vo;

import java.util.List;

public class MainFormVO {

    private long              formId;

    private String            formCode;

    private String            formName;

    private List<String>      attributeList;

    private List<ChildFormVO> children;

    public long getFormId() {

        return formId;
    }

    public void setFormId(long formId) {

        this.formId = formId;
    }

    public String getFormName() {

        return formName;
    }

    public void setFormName(String formName) {

        this.formName = formName;
    }

    public List<String> getAttributeList() {

        return attributeList;
    }

    public void setAttributeList(List<String> attributeList) {

        this.attributeList = attributeList;
    }

    public List<ChildFormVO> getChildren() {

        return children;
    }

    public void setChildren(List<ChildFormVO> children) {

        this.children = children;
    }

    public String getFormCode() {

        return formCode;
    }

    public void setFormCode(String formCode) {

        this.formCode = formCode;
    }
}
