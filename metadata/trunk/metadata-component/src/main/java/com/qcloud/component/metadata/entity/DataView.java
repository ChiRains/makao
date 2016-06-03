package com.qcloud.component.metadata.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.qcloud.component.metadata.QDataObject;
import com.qcloud.component.metadata.QDataView;
import com.qcloud.component.metadata.QField;

public class DataView implements QDataView {

    private DBTable          table;

    private List<DataObject> data = new ArrayList<DataObject>();

    public DBTable getTable() {

        return table;
    }

    public void setTable(DBTable table) {

        this.table = table;
    }

    public List<DataObject> getData() {

        return data;
    }

    public DataObject addDataObject() {

        DataObject objView = new DataObject(table, this);
        objView.setInsert();
        data.add(objView);
        return objView;
    }

    @Override
    public List<QDataObject> select(String field, Object obj) {

        QField qField = null;
        for (QField f : table.getFieldList()) {
            if (f.getName().equals(field)) {
                qField = f;
                break;
            }
        }
        List<QDataObject> list = new ArrayList<QDataObject>();
        if (qField == null) {
            return list;
        }
        for (DataObject dataObject : data) {
            Map<QField, Object> map = dataObject.getData();
            Object value = map.get(qField);
            if (value == null && obj == null || value != null && value.equals(obj)) {
                list.add(dataObject);
            }
        }
        return list;
    }

    @Override
    public DataObject get(Long primaryValue) {

        DBField primaryField = table.getPrimaryField();
        for (DataObject dataObject : data) {
            Map<QField, Object> map = dataObject.getData();
            Object value = map.get(primaryField);
            if (value == null && primaryValue == null || value != null && value.equals(primaryValue)) {
                return dataObject;
            }
        }
        return null;
    }

    @Override
    public List<QDataObject> select() {

        List<QDataObject> list = new ArrayList<QDataObject>();
        for (DataObject dataObject : data) {
            list.add(dataObject);
        }
        return list;
    }

    @Override
    public String toString() {

        return "DataView [table=" + table + ", data=" + data + "]";
    }
}
