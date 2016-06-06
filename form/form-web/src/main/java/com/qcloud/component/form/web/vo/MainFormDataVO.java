package com.qcloud.component.form.web.vo;

import java.util.List;

public class MainFormDataVO {

    private MainFormVO            mainForm;

    private FormDataVO            formData;

    private List<ChildFormDataVO> children;

    public MainFormVO getMainForm() {

        return mainForm;
    }

    public void setMainForm(MainFormVO mainForm) {

        this.mainForm = mainForm;
    }

    public FormDataVO getFormData() {

        return formData;
    }

    public void setFormData(FormDataVO formData) {

        this.formData = formData;
    }

    public List<ChildFormDataVO> getChildren() {

        return children;
    }

    public void setChildren(List<ChildFormDataVO> children) {

        this.children = children;
    }
}
