package com.qcloud.component.form.web.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormDataVO {

    private List<String>        attributeList;

    private Map<String, Object> dataMap = new HashMap<String, Object>();

    public List<String> getAttributeList() {

        return attributeList;
    }

    public void setAttributeList(List<String> attributeList) {

        this.attributeList = attributeList;
    }

    public Map<String, Object> getDataMap() {

        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {

        this.dataMap = dataMap;
    }
}
