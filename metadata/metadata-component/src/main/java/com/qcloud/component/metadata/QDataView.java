package com.qcloud.component.metadata;

import java.util.List;

public interface QDataView {

    QTable getTable();

    QDataObject addDataObject();

    QDataObject get(Long primaryValue);

    List<QDataObject> select(String field, Object obj);

    List<QDataObject> select();
}
