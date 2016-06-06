package com.qcloud.component.form.entity;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.component.form.QChildForm;
import com.qcloud.component.form.QFormElement;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.FormDef;

public class ChildForm implements QChildForm {

    private MainForm         mainForm;

    private FormDef          formDef;

    private List<ElementDef> elementList;

    public ChildForm(MainForm mainForm) {

        super();
        this.mainForm = mainForm;
    }

    public FormDef getFormDef() {

        return formDef;
    }

    public void setFormDef(FormDef formDef) {

        this.formDef = formDef;
    }

    public List<ElementDef> getElementList() {

        return elementList;
    }

    public void setElementList(List<ElementDef> elementList) {

        this.elementList = elementList;
    }

    public MainForm getMainForm() {

        return mainForm;
    }

    public String getName() {

        return formDef.getName();
    }

    public String getCode() {

        return formDef.getCode();
    }

    @Override
    public List<QFormElement> elements() {

        List<ElementDef> list = getElementList();
        List<QFormElement> eleList = new ArrayList<QFormElement>();
        for (ElementDef elementDef : list) {
            eleList.add(elementDef);
        }
        return eleList;
    }
}
