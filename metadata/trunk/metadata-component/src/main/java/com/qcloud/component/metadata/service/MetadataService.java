package com.qcloud.component.metadata.service;

import java.util.List;
import java.util.Map;
import com.qcloud.component.metadata.QField;
import com.qcloud.component.metadata.QTable;
import com.qcloud.component.metadata.entity.DataObject;

public interface MetadataService {

    List<Map<String, Object>> select(QTable qt, Map<String, Object> map);

    int update(QTable qt, List<DataObject> data);

    QField getPrimaryField(QTable table);
}
