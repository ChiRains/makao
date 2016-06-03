package com.qcloud.component.form.entity;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.component.form.QChildForm;
import com.qcloud.component.form.QFormElement;
import com.qcloud.component.form.QMainForm;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.FormDef;

public class MainForm implements QMainForm {

    private FormDef          formDef;

    private List<ElementDef> elementList;

    private List<ChildForm>  children;

    private String           pcApplyViewUrl;

    private String           pcTaskingViewUrl;

    private String           pcTaskedViewUrl;

    private String           mobileApplyViewUrl;

    private String           mobileTaskingViewUrl;

    private String           mobileTaskedViewUrl;

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

    public List<ChildForm> getChildren() {

        return children;
    }

    public void setChildren(List<ChildForm> children) {

        this.children = children;
    }

    public String getName() {

        return formDef.getName();
    }

    public String getCode() {

        return formDef.getCode();
    }

    @Override
    public List<QChildForm> children() {

        List<ChildForm> list = getChildren();
        List<QChildForm> children = new ArrayList<QChildForm>();
        for (ChildForm childForm : list) {
            children.add(childForm);
        }
        return children;
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

    @Override
    public Long getId() {

        return formDef.getId();
    }

    public String getPcApplyViewUrl() {

        return pcApplyViewUrl;
    }

    public void setPcApplyViewUrl(String pcApplyViewUrl) {

        this.pcApplyViewUrl = pcApplyViewUrl;
    }

    public String getPcTaskingViewUrl() {

        return pcTaskingViewUrl;
    }

    public void setPcTaskingViewUrl(String pcTaskingViewUrl) {

        this.pcTaskingViewUrl = pcTaskingViewUrl;
    }

    public String getPcTaskedViewUrl() {

        return pcTaskedViewUrl;
    }

    public void setPcTaskedViewUrl(String pcTaskedViewUrl) {

        this.pcTaskedViewUrl = pcTaskedViewUrl;
    }

    public String getMobileApplyViewUrl() {

        return mobileApplyViewUrl;
    }

    public void setMobileApplyViewUrl(String mobileApplyViewUrl) {

        this.mobileApplyViewUrl = mobileApplyViewUrl;
    }

    public String getMobileTaskingViewUrl() {

        return mobileTaskingViewUrl;
    }

    public void setMobileTaskingViewUrl(String mobileTaskingViewUrl) {

        this.mobileTaskingViewUrl = mobileTaskingViewUrl;
    }

    public String getMobileTaskedViewUrl() {

        return mobileTaskedViewUrl;
    }

    public void setMobileTaskedViewUrl(String mobileTaskedViewUrl) {

        this.mobileTaskedViewUrl = mobileTaskedViewUrl;
    }
}
