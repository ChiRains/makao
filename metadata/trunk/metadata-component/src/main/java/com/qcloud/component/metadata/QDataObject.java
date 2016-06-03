package com.qcloud.component.metadata;

import java.util.Map;

public interface QDataObject {

    QDataView getDataView();

    QTable getTable();

    QDataObject setDataAttr(String fieldName, Object obj);

    Object getObjectAttr(String fieldName);

    void setDelete();

    Long getPrimaryValue();

    Map<QField, Object> getData();
}
