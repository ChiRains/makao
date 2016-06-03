package com.qcloud.component.form.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.component.form.QFormData;
import com.qcloud.component.form.QFormElement;
import com.qcloud.component.form.model.ElementDef;

public class FormData implements QFormData {

    private List<ElementDef>         elementList;

    // map 暂时是String String
    private Map<ElementDef, Object>  dataMap = new HashMap<ElementDef, Object>();

    // map
    private Map<ElementDef, Boolean> saveMap = new HashMap<ElementDef, Boolean>();

    // map
    private boolean                  delete  = false;

    public FormData(List<ElementDef> elementList) {

        super();
        this.elementList = elementList;
        for (ElementDef elementDef : elementList) {
            saveMap.put(elementDef, false);
        }
    }

    public List<ElementDef> getElementList() {

        return Collections.unmodifiableList(elementList);
    }

    public Map<ElementDef, Object> getDataMap() {

        return Collections.unmodifiableMap(dataMap);
    }

    public void put(ElementDef def, Object val) {

        for (ElementDef ele : elementList) {
            if (ele.equals(def)) {
                dataMap.put(def, val);
                saveMap.put(def, true);
            }
        }
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

    public Map<ElementDef, Boolean> getSaveMap() {

        return Collections.unmodifiableMap(saveMap);
    }

    public Boolean isSave(ElementDef def) {

        return saveMap.get(def) == null ? Boolean.FALSE : saveMap.get(def);
    }

    public void setSaveMap(Map<ElementDef, Boolean> saveMap) {

        this.saveMap = saveMap;
    }

    // @Override
    // public Map<ElementDef, Object> toDataMap() {
    //
    // // TODO Auto-generated method stub
    // return null;
    // }
    public boolean isDelete() {

        return delete;
    }

    public void setDelete() {

        this.delete = true;
    }
}
