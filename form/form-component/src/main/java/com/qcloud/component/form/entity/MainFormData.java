package com.qcloud.component.form.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.component.form.QChildFormData;
import com.qcloud.component.form.QMainFormData;
import com.qcloud.component.form.model.ElementDef;

public class MainFormData implements QMainFormData {

    private MainForm            mainForm;

    private FormData            formData;

    private List<ChildFormData> children;

    public MainFormData(MainForm mainForm) {

        super();
        this.mainForm = mainForm;
    }

    public MainForm getMainForm() {

        return mainForm;
    }

    public FormData getFormData() {

        return formData;
    }

    public void setFormData(FormData formData) {

        this.formData = formData;
    }

    public List<ChildFormData> getChildren() {

        return children;
    }

    public void setChildren(List<ChildFormData> children) {

        this.children = children;
    }

    public Map<String, Object> toMap() {

        Map<String, Object> map = new HashMap<String, Object>();
        Map<ElementDef, Object> mainDataMap = this.formData.getDataMap();
        for (Map.Entry<ElementDef, Object> entry : mainDataMap.entrySet()) {
            map.put(entry.getKey().getCode(), entry.getValue());
        }
        List<ChildFormData> childFormDataList = getChildren();
        for (ChildFormData childFormData : childFormDataList) {
            ChildForm childForm = childFormData.getChildForm();
            if (childFormData.getFormDataList().size() == 0) {
                continue;
            }
            int index = 0;
            map.put(childForm.getCode() + ".qc_inner_number", childFormData.getFormDataList().size());
            for (FormData formData : childFormData.getFormDataList()) {
                Map<ElementDef, Object> childDataMap = formData.getDataMap();
                for (Map.Entry<ElementDef, Object> entry : childDataMap.entrySet()) {
                    map.put(childForm.getCode() + "[" + index + "]." + entry.getKey().getCode(), entry.getValue());
                }
                index++;
            }
        }
        return map;
    }

    @Override
    public List<QChildFormData> children() {

        List<ChildFormData> list = getChildren();
        List<QChildFormData> dataList = new ArrayList<QChildFormData>();
        for (ChildFormData childFormData : list) {
            dataList.add(childFormData);
        }
        return dataList;
    }
}
