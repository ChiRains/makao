package com.qcloud.component.metadata.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.metadata.QField;
import com.qcloud.component.metadata.QTable;
import com.qcloud.component.metadata.dao.MetadataDao;
import com.qcloud.component.metadata.entity.DataObject;
import com.qcloud.component.metadata.model.key.TypeEnum.DataObjectStateType;
import com.qcloud.component.metadata.service.MetadataService;
import com.qcloud.pirates.util.AssertUtil;

@Service
public class MetadataServiceImpl implements MetadataService {

    @Autowired
    private MetadataDao     metadataDao;

    @Autowired
    private AutoIdGenerator autoIdGenerator;

    private Log             logger      = LogFactory.getLog(getClass());

    private final String    tablePrefix = "";

    @Override
    public List<Map<String, Object>> select(QTable qt, Map<String, Object> map) {

        logger.info("select " + qt.getName() + "(" + qt.getTableId() + ")");
        return metadataDao.list(qt.getName(), map);
    }

    @Override
    public int update(QTable qt, List<DataObject> data) {

        int num = 0;
        for (Iterator<DataObject> iterator = data.iterator(); iterator.hasNext();) {
            DataObject dataObject = iterator.next();
            AssertUtil.assertNotNull(dataObject.getState(), "元数据实例数据状态不能为空.");
            logger.info(dataObject.getState().getName());
            if (DataObjectStateType.INSERT.getKey() == dataObject.getState().getKey()) {
                long id = autoIdGenerator.get(tablePrefix + qt.getName());
                dataObject.setPrimaryValue(id);
                boolean result = metadataDao.add(dataObject);
                if (result) {
                    dataObject.setSelect();
                    num++;
                }
            } else if (DataObjectStateType.DELETE.getKey() == dataObject.getState().getKey()) {
                boolean result = metadataDao.delete(dataObject);
                if (result) {
                    iterator.remove();
                    num++;
                }
            } else if (DataObjectStateType.UPDATE.getKey() == dataObject.getState().getKey()) {
                boolean result = metadataDao.update(dataObject);
                if (result) {
                    dataObject.setSelect();
                    num++;
                }
            }
        }
        logger.info("update " + qt.getName() + "(" + qt.getTableId() + ")");
        return num;
    }

    @Override
    public QField getPrimaryField(QTable table) {

        return metadataDao.getPrimaryField(table);
    }
}
