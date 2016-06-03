package com.qcloud.component.metadata.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.qcloud.component.metadata.ObjectType;
import com.qcloud.component.metadata.QDataObject;
import com.qcloud.component.metadata.QField;
import com.qcloud.component.metadata.exception.MetadataException;
import com.qcloud.component.metadata.model.key.TypeEnum.DataObjectStateType;
import com.qcloud.pirates.util.AssertUtil;

public class DataObject implements QDataObject {

    private DataView             dataView;

    private DBTable              table;

    private DataObjectStateType  state;

    private Map<DBField, Object> data = new HashMap<DBField, Object>();

    public DataObject(DBTable table, DataView dataView) {

        super();
        this.dataView = dataView;
        this.table = table;
        this.state = DataObjectStateType.SELECT;
    }

    public DataObject setDataAttr(String fieldName, Object obj) {

        for (DBField field : table.fieldList) {
            if (field.getName().equals(fieldName)) {
                if (obj == null) {
                    data.put(field, getDefaultValue(field.getType()));
                } else if (isMatchingObj(field.getType(), obj)) {
                    data.put(field, obj);
                    if (DataObjectStateType.SELECT.getKey() == state.getKey()) {
                        state = DataObjectStateType.UPDATE;
                    }
                } else {
                    throw new MetadataException("字段" + fieldName + "值类型不对." + table.getName() + "." + field.getType().getName());
                }
                return this;
            }
        }
        throw new MetadataException("字段" + fieldName + "在表定义" + table.getName() + "不存在.");
    }

    private Object getDefaultValue(ObjectType type) {

        if (ObjectType.INTEGER.getKey() == type.getKey()) {
            return 0;
        } else if (ObjectType.LONG.getKey() == type.getKey()) {
            return 0L;
        } else if (ObjectType.DOUBLE.getKey() == type.getKey()) {
            return 0.0;
        } else {
            return null;
        }
    }

    public DBTable getTable() {

        return table;
    }

    private boolean isMatchingObj(ObjectType type, Object obj) {

        return ObjectType.STRING.getKey() == type.getKey() && (obj instanceof String || obj == null) || ObjectType.INTEGER.getKey() == type.getKey() && obj instanceof Integer || ObjectType.LONG.getKey() == type.getKey() && obj instanceof Long || ObjectType.DOUBLE.getKey() == type.getKey() && obj instanceof Double || ObjectType.DATE.getKey() == type.getKey() && obj instanceof Date || ObjectType.BYTEARRAY.getKey() == type.getKey() && (obj instanceof byte[] || obj == null);
    }

    public DataObjectStateType getState() {

        return state;
    }

    public void setDelete() {

        this.state = DataObjectStateType.DELETE;
    }

    public void setInsert() {

        this.state = DataObjectStateType.INSERT;
    }

    public void setSelect() {

        this.state = DataObjectStateType.SELECT;
    }

    public Map<QField, Object> getData() {

        Map<QField, Object> map = new HashMap<QField, Object>();
        for (Map.Entry<DBField, Object> entry : data.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    public Long getPrimaryValue() {

        DBTable table = getTable();
        QField primaryField = table.getPrimaryField();
        AssertUtil.assertNotNull(primaryField, "表主键字段未定义." + table.getName());
        Map<QField, Object> data = getData();
        return (Long) data.get(primaryField);
    }

    public void setPrimaryValue(Long value) {

        DBTable table = getTable();
        QField primaryField = table.getPrimaryField();
        AssertUtil.assertNotNull(primaryField, "表主键字段未定义." + table.getName());
        setDataAttr(primaryField.getName(), value);
    }

    public DataView getDataView() {

        return dataView;
    }

    @Override
    public String toString() {

        return "DataObject [state=" + state + ", table=" + table.getName() + ", data=" + data + "]";
    }

    @Override
    public Object getObjectAttr(String fieldName) {

        for (DBField field : table.fieldList) {
            if (field.getName().equals(fieldName)) {
                return data.get(field);
            }
        }
        return null;
    }
}
