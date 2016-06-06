package com.qcloud.component.metadata.dao;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.model.Table;
import com.qcloud.component.metadata.model.query.FieldQuery;
import com.qcloud.component.metadata.model.query.TableQuery;
public interface TableDao extends ISimpleDao<Table, Long> {
    public boolean add(Table table);

    public Table get(Long id);

    public boolean delete(Long id);

    public boolean update(Table table);

    public List<Table> list(List<Long> idList);

    public Map<Long, Table> map(Set<Long> idSet);

    public Page<Table> page(TableQuery query, int start, int size);

    public List<Table> listAll();

    public List<Table> getByName(String name);
}
