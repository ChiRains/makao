package com.qcloud.component.metadata.service.impl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.metadata.dao.FieldDao;
import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.service.FieldService;
import com.qcloud.component.metadata.model.query.FieldQuery;
@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    private FieldDao            fieldDao;
    @Autowired
    private AutoIdGenerator     autoIdGenerator;
    private static final String ID_KEY = "metadata_field";

    @Override
    public boolean add(Field field) {
        long id = autoIdGenerator.get(ID_KEY);
        field.setId(id);
        return fieldDao.add(field);
    }

    @Override
    public Field get(Long id) {
        return fieldDao.get(id);
    }

    @Override
    public boolean delete(Long id) {
        return fieldDao.delete(id);
    }

    @Override
    public boolean update(Field field) {
        return fieldDao.update(field);
    }

    @Override
    public Page<Field> page(FieldQuery query, int start, int count) {
        return fieldDao.page(query, start, count);
    }

    public List<Field> listAll() {
        return fieldDao.listAll();
    }

    @Override
    public List<Field> listAll(FieldQuery query) {
        return fieldDao.listAll(query);
    }

    @Override
    public List<Field> listByTable(Long tableId) {
        return fieldDao.listByTable(tableId);
    }

    @Override
    public List<Field> listByMap(Map<String, Object> map) {
        return fieldDao.listByMap(map);
    }
}
