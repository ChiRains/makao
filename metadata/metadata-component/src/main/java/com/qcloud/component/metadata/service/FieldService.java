package com.qcloud.component.metadata.service;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.model.query.FieldQuery;
public interface FieldService {
    public boolean add(Field field);

    public Field get(Long id);

    public boolean delete(Long id);

    public boolean update(Field field);

    public Page<Field> page(FieldQuery query, int start, int count);

    public List<Field> listAll();

    public List<Field> listAll(FieldQuery query);

    public List<Field> listByTable(Long tableId);

    public List<Field> listByMap(Map<String, Object> map);
}
