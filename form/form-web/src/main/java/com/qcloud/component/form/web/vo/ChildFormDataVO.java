package com.qcloud.component.form.web.vo;

import java.util.ArrayList;
import java.util.List;

public class ChildFormDataVO {

    private ChildFormVO      childForm;

    private List<FormDataVO> formDataList = new ArrayList<FormDataVO>();

    public ChildFormVO getChildForm() {

        return childForm;
    }

    public void setChildForm(ChildFormVO childForm) {

        this.childForm = childForm;
    }

    public List<FormDataVO> getFormDataList() {

        return formDataList;
    }

    public void setFormDataList(List<FormDataVO> formDataList) {

        this.formDataList = formDataList;
    }
}
