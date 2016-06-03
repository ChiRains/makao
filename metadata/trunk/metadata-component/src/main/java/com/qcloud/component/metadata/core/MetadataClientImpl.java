package com.qcloud.component.metadata.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qcloud.component.metadata.MetadataClient;
import com.qcloud.component.metadata.ObjectType;
import com.qcloud.component.metadata.QDataView;
import com.qcloud.component.metadata.QField;
import com.qcloud.component.metadata.QTable;
import com.qcloud.component.metadata.QueryParam;
import com.qcloud.component.metadata.entity.DBField;
import com.qcloud.component.metadata.entity.DBTable;
import com.qcloud.component.metadata.entity.DataObject;
import com.qcloud.component.metadata.entity.DataView;
import com.qcloud.component.metadata.exception.MetadataException;
import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.model.Table;
import com.qcloud.component.metadata.model.query.FieldQuery;
import com.qcloud.component.metadata.service.FieldService;
import com.qcloud.component.metadata.service.MetadataService;
import com.qcloud.component.metadata.service.TableService;
import com.qcloud.pirates.util.AssertUtil;

@Service
public class MetadataClientImpl implements MetadataClient {

    @Autowired
    private TableService tableService;

    @Autowired
    private FieldService fieldService;

    @Override
    public List<Table> listTableAll() {

        return tableService.listAll();
    }

    @Override
    public Map<Long, Field> listFieldMap(FieldQuery query) {

        Map<Long, Field> map = new HashMap<Long, Field>();
        for (Field field : fieldService.listAll(query)) {
            map.put(field.getId(), field);
        }
        return map;
    }

    @Override
    public Table getTable(Long tableId) {

        return tableService.get(tableId);
    }

    @Autowired
    private MetadataService metadataService;

    @Override
    public QDataView newView(Long tableId) {

        DataView dataView = new DataView();
        DBTable qt = getTableDefination(tableId);
        AssertUtil.assertNotNull(qt, "元数据表定义不存在." + tableId);
        dataView.setTable(qt);
        return dataView;
    }

    @Override
    public QDataView newView(String tableName) {

        return newView(nameToId(tableName));
    }

    @Override
    public QDataView select(Long tableId, QueryParam param) {

        AssertUtil.assertNotNull(param, "参数不能为空.");
        DataView dataView = new DataView();
        DBTable qt = getTableDefination(tableId);
        AssertUtil.assertNotNull(qt, "元数据表定义不存在." + tableId);
        dataView.setTable(qt);
        List<Map<String, Object>> list = metadataService.select(qt, param.getMap());
        for (Map<String, Object> map : list) {
            DataObject dataObject = dataView.addDataObject();
            List<QField> fieldList = qt.getFieldList();
            for (QField qField : fieldList) {
                dataObject.setDataAttr(qField.getName(), map.get(qField.getName()));
            }
            dataObject.setSelect();
        }
        // 查询数据
        return dataView;
    }

    @Override
    public QDataView select(String tableName, QueryParam param) {

        return select(nameToId(tableName), param);
    }

    private long nameToId(String tableName) {

        List<Table> tableList = tableService.getByName(tableName);
        if (tableList == null || tableList.isEmpty()) {
            return -1;
        }
        if (tableList.size() > 1) {
            throw new MetadataException("元数据定义有误,找到超过两个以上数据." + tableName);
        }
        return tableList.get(0).getId();
    }

    private DBTable getTableDefination(Long tableId) {

        Table table = tableService.get(tableId);
        if (table == null) {
            return null;
        }
        DBTable qt = new DBTable();
        qt.setTableId(table.getId());
        qt.setName(table.getName());
        List<Field> fieldList = fieldService.listByTable(tableId);
        List<DBField> qFieldList = new ArrayList<DBField>();
        for (Field field : fieldList) {
            DBField qf = exchangeFieldToQField(qt, field);
            qFieldList.add(qf);
        }
        qt.setFieldList(qFieldList);
        QField primaryField = metadataService.getPrimaryField(qt);
        AssertUtil.assertNotNull(primaryField, "表主键字段未定义." + table.getName());
        qt.setPrimaryField((DBField) primaryField);
        return qt;
    }

    @Transactional
    @Override
    public int update(QDataView view) {

        AssertUtil.assertTrue(view instanceof DataView, "更新对象必须从接口创建或者查询:" + MetadataClient.class.getName());
        DataView dataView = (DataView) view;
        return metadataService.update(view.getTable(), dataView.getData());
    }

    @Override
    public QTable getTableModel(Long tableId) {

        return getTableDefination(tableId);
    }

    @Override
    public QField getFieldModel(Long fieldId) {

        Field field = fieldService.get(fieldId);
        if (field == null) {
            return null;
        }
        QTable table = getTableModel(field.getTableId());
        List<QField> fieldList = table.getFieldList();
        for (QField qf : fieldList) {
            if (qf.getId().equals(fieldId)) {
                return qf;
            }
        }
        return null;
    }

    private DBField exchangeFieldToQField(DBTable qt, Field field) {

        DBField qf = new DBField(qt);
        qf.setId(field.getId());
        qf.setName(field.getName());
        ObjectType objectType = null;
        switch (field.getType()) {
        case 1:
            objectType = ObjectType.INTEGER;
            break;
        case 2:
            objectType = ObjectType.INTEGER;
            break;
        case 3:
            objectType = ObjectType.INTEGER;
            break;
        case 4:
            objectType = ObjectType.LONG;
            break;
        case 5:
            objectType = ObjectType.DOUBLE;
            break;
        case 6:
            objectType = ObjectType.STRING;
            break;
        case 7:
            objectType = ObjectType.STRING;
            break;
        case 8:
            objectType = ObjectType.DATE;
            break;
        case 9:
            objectType = ObjectType.DATE;
            break;
        case 10:
            objectType = ObjectType.DATE;
            break;
        case 11:
            objectType = ObjectType.DATE;
            break;
        case 12:
            objectType = ObjectType.BYTEARRAY;
            break;
        case 13:
            objectType = ObjectType.STRING;
            break;
        default:
            throw new MetadataException("不支持的元数据字段定义.");
        }
        qf.setType(objectType);
        return qf;
    }

    @Override
    public boolean initTable(Table table, List<Field> fieldList) {

        tableService.add(table);
        for (Field field : fieldList) {
            field.setTableId(table.getId());
            fieldService.add(field);
        }
        return true;
    }

    @Override
    public QTable getTableModel(String tableName) {

        return getTableModel(nameToId(tableName));
    }
}