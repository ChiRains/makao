package com.qcloud.component.form.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.qcloud.component.form.QChildFormData;
import com.qcloud.component.form.QFormData;

public class ChildFormData implements QChildFormData {

    private MainFormData   mainFormData;

    private ChildForm      childForm;

    private List<FormData> formDataList = new ArrayList<FormData>();

    public ChildFormData(MainFormData mainFormData, ChildForm childForm) {

        super();
        this.mainFormData = mainFormData;
        this.childForm = childForm;
    }

    public MainFormData getMainFormData() {

        return mainFormData;
    }

    public ChildForm getChildForm() {

        return childForm;
    }

    public void remove(FormData formData) {

        formDataList.remove(formData);
    }

    public List<FormData> getFormDataList() {

        return Collections.unmodifiableList(formDataList);
    }

    public void setFormDataList(List<FormData> formDataList) {

        this.formDataList = formDataList;
    }

    @Override
    public List<QFormData> listFormData() {

        List<FormData> list = getFormDataList();
        List<QFormData> dataList = new ArrayList<QFormData>();
        for (FormData formData : list) {
            dataList.add(formData);
        }
        return dataList;
    }
}
