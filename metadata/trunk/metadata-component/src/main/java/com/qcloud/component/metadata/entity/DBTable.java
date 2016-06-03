package com.qcloud.component.metadata.entity;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.component.metadata.QField;
import com.qcloud.component.metadata.QTable;

public class DBTable implements QTable {

    private Long    tableId;

    private String  name;

    List<DBField>   fieldList;

    private DBField primaryField;

    public Long getTableId() {

        return tableId;
    }

    public void setTableId(Long tableId) {

        this.tableId = tableId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<QField> getFieldList() {

        List<QField> list = new ArrayList<QField>();
        for (DBField field : fieldList) {
            list.add(field);
        }
        return list;
    }

    public void setFieldList(List<DBField> fieldList) {

        this.fieldList = fieldList;
    }

    public DBField getPrimaryField() {

        return primaryField;
    }

    public void setPrimaryField(DBField primaryField) {

        this.primaryField = primaryField;
    }

    @Override
    public String toString() {

        return "DBTable [name=" + name + ", primaryField=" + primaryField + ", fieldList=" + fieldList + "]";
    }
}
