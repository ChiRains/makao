package com.qcloud.component.metadata.service;
import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.metadata.model.Table;
import com.qcloud.component.metadata.model.query.TableQuery;
public interface TableService {
    public boolean add(Table table);

    public Table get(Long id);

    public boolean delete(Long id);

    public boolean update(Table table);

    public Page<Table> page(TableQuery query, int start, int count);

    public List<Table> listAll();

    public List<Table> getByName(String name);
}
