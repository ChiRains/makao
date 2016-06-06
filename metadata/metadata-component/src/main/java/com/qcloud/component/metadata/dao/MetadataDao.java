package com.qcloud.component.metadata.dao;

import java.util.List;
import java.util.Map;
import com.qcloud.component.metadata.QField;
import com.qcloud.component.metadata.QTable;
import com.qcloud.component.metadata.entity.DBTable;
import com.qcloud.component.metadata.entity.DataObject;

public interface MetadataDao {

    boolean add(DataObject dataObject);

    boolean update(DataObject dataObject);

    boolean delete(DataObject dataObject);

    Map<String, Object> get(DBTable table, Long Id);

    List<Map<String, Object>> list(String tableName, Map<String, Object> param);

    QField getPrimaryField(QTable table);
}
