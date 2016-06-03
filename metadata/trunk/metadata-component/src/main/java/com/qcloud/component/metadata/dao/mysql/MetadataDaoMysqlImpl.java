package com.qcloud.component.metadata.dao.mysql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.qcloud.component.metadata.QField;
import com.qcloud.component.metadata.QTable;
import com.qcloud.component.metadata.dao.MetadataDao;
import com.qcloud.component.metadata.entity.DBTable;
import com.qcloud.component.metadata.entity.DataObject;
import com.qcloud.component.metadata.model.query.MetadataParam;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;

@Repository
public class MetadataDaoMysqlImpl implements MetadataDao {

    @Resource(name = "sqlOperator-metadata")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(DataObject dataObject) {

        Map<String, Object> map = new HashMap<String, Object>();
        List<MetadataParam> paramList = toParamList(dataObject);
        map.put("table", dataObject.getTable().getName());
        map.put("paramList", paramList);
        return sqlOperator.insert("com.qcloud.component.metadata.dao.mysql.mapper.MetadataMapper.insert", map) == 1;
    }

    @Override
    public boolean update(DataObject dataObject) {

        Map<String, Object> map = new HashMap<String, Object>();
        List<MetadataParam> paramList = toParamList(dataObject);
        map.put("table", dataObject.getTable().getName());
        map.put("paramList", paramList);
        Long primaryValue = dataObject.getPrimaryValue();
        QField primaryField = getPrimaryField(dataObject.getTable());
        map.put("primaryField", primaryField.getName());
        map.put("primaryValue", primaryValue);
        return sqlOperator.update("com.qcloud.component.metadata.dao.mysql.mapper.MetadataMapper.update", map) > 0;
    }

    @Override
    public boolean delete(DataObject dataObject) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("table", dataObject.getTable().getName());
        Long primaryValue = dataObject.getPrimaryValue();
        QField primaryField = getPrimaryField(dataObject.getTable());
        map.put("primaryField", primaryField.getName());
        map.put("primaryValue", primaryValue);
        return sqlOperator.delete("com.qcloud.component.metadata.dao.mysql.mapper.MetadataMapper.delete", map) > 0;
    }

    @Override
    public Map<String, Object> get(DBTable table, Long Id) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("table", table.getName());
        QField primaryField = getPrimaryField(table);
        map.put("primaryField", primaryField.getName());
        map.put("primaryValue", Id);
        return sqlOperator.selectOne("com.qcloud.component.metadata.dao.mysql.mapper.FieldMapper.get", map);
    }

    @Override
    public List<Map<String, Object>> list(String tableName, Map<String, Object> param) {

        Map<String, Object> map = new HashMap<String, Object>();
        List<MetadataParam> paramList = toParamList(param);
        map.put("paramList", paramList);
        map.put("table", tableName);
        List<Map<String, Object>> list = sqlOperator.selectList("com.qcloud.component.metadata.dao.mysql.mapper.MetadataMapper.list", map);
        return list;
    }

    public QField getPrimaryField(QTable table) {

        List<QField> fieldList = table.getFieldList();
        for (QField field : fieldList) {
            if ("id".equals(field.getName())) {
                return field;
            }
        }
        return null;
    }

    private List<MetadataParam> toParamList(DataObject dataObject) {

        List<MetadataParam> data = new ArrayList<MetadataParam>();
        Map<QField, Object> map = dataObject.getData();
        for (Map.Entry<QField, Object> entry : map.entrySet()) {
            MetadataParam metadataParam = new MetadataParam();
            metadataParam.setName(entry.getKey().getName());
            metadataParam.setValue(entry.getValue());
            data.add(metadataParam);
        }
        return data;
    }

    private List<MetadataParam> toParamList(Map<String, Object> param) {

        List<MetadataParam> data = new ArrayList<MetadataParam>();
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            MetadataParam metadataParam = new MetadataParam();
            metadataParam.setName(entry.getKey());
            metadataParam.setValue(entry.getValue());
            data.add(metadataParam);
        }
        return data;
    }
}
