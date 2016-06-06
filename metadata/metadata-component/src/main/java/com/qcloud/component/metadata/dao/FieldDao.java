package com.qcloud.component.metadata.dao;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.model.query.FieldQuery;
public interface FieldDao extends ISimpleDao<Field, Long> {
    public boolean add(Field field);

    public Field get(Long id);

    public boolean delete(Long id);

    public boolean update(Field field);

    public List<Field> list(List<Long> idList);

    public Map<Long, Field> map(Set<Long> idSet);

    public Page<Field> page(FieldQuery query, int start, int size);

    public List<Field> listAll();

    public List<Field> listAll(FieldQuery query);

    List<Field> listByTable(Long tableId);

    public List<Field> listByMap(Map<String, Object> map);
}
