package com.qcloud.component.metadata;

import java.util.List;
import java.util.Map;
import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.model.Table;
import com.qcloud.component.metadata.model.query.FieldQuery;

public interface MetadataClient {

    // 服务表单
    public boolean initTable(Table table, List<Field> fieldList);

    public List<Table> listTableAll();

    public Map<Long, Field> listFieldMap(FieldQuery query);

    QDataView newView(Long tableId);

    QDataView newView(String tableName);

    QTable getTableModel(Long tableId);

    QTable getTableModel(String tableName);

    QField getFieldModel(Long fieldId);

    Table getTable(Long tableId);

    QDataView select(Long tableId, QueryParam param);

    QDataView select(String tableName, QueryParam param);

    int update(QDataView view);
}