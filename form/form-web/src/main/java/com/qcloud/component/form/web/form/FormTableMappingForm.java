package com.qcloud.component.form.web.form;
public class FormTableMappingForm {
    // 表单id
    private Long mainFormId;
    // 数据库表id
    private Long tableId;

    public Long getMainFormId() {
        return mainFormId;
    }

    public void setMainFormId(Long mainFormId) {
        this.mainFormId = mainFormId;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }
}
