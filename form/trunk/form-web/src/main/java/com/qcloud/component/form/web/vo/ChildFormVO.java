package com.qcloud.component.form.web.vo;

import java.util.List;

public class ChildFormVO {

    private long         formId;

    private String       formName;

    private String       formCode;

    private List<String> attributeList;

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

    public String getFormCode() {

        return formCode;
    }

    public void setFormCode(String formCode) {

        this.formCode = formCode;
    }
}
