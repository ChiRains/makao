package com.qcloud.component.metadata.dao.cache;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.component.metadata.QField;
import com.qcloud.component.metadata.QTable;
import com.qcloud.component.metadata.dao.MetadataDao;
import com.qcloud.component.metadata.entity.DBTable;
import com.qcloud.component.metadata.entity.DataObject;

@Repository
public class MetadataDaoCacheImpl implements MetadataDao {

    @Autowired
    private MetadataDao metadataDaoMysqlImpl;

    @Override
    public boolean add(DataObject dataObject) {

        return metadataDaoMysqlImpl.add(dataObject);
    }

    @Override
    public boolean update(DataObject dataObject) {

        return metadataDaoMysqlImpl.update(dataObject);
    }

    @Override
    public boolean delete(DataObject dataObject) {

        return metadataDaoMysqlImpl.delete(dataObject);
    }

    @Override
    public Map<String, Object> get(DBTable table, Long Id) {

        return metadataDaoMysqlImpl.get(table, Id);
    }

    @Override
    public List<Map<String, Object>> list(String tableName, Map<String, Object> param) {

        return metadataDaoMysqlImpl.list(tableName, param);
    }

    @Override
    public QField getPrimaryField(QTable table) {

        return metadataDaoMysqlImpl.getPrimaryField(table);
    }
}
