package com.qcloud.component.form.web.form;
public class ElementFieldMappingForm {
    // 元素id
    private Long[] elementIds;
    // 属性id
    private Long[] fieldIds;

    public Long[] getElementIds() {
        return elementIds;
    }

    public void setElementIds(Long[] elementIds) {
        this.elementIds = elementIds;
    }

    public Long[] getFieldIds() {
        return fieldIds;
    }

    public void setFieldIds(Long[] fieldIds) {
        this.fieldIds = fieldIds;
    }
}
