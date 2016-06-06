package com.qcloud.component.metadata.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.metadata.dao.TableDao;
import com.qcloud.component.metadata.model.Table;
import com.qcloud.component.metadata.service.TableService;
import com.qcloud.component.metadata.model.query.TableQuery;
@Service
public class TableServiceImpl implements TableService {
    @Autowired
    private TableDao            tableDao;
    @Autowired
    private AutoIdGenerator     autoIdGenerator;
    
    private static final String ID_KEY = "metadata_table";

    @Override
    public boolean add(Table table) {
        long id = autoIdGenerator.get(ID_KEY);
        table.setId(id);
        return tableDao.add(table);
    }

    @Override
    public Table get(Long id) {
        return tableDao.get(id);
    }

    @Override
    public boolean delete(Long id) {
        return tableDao.delete(id);
    }

    @Override
    public boolean update(Table table) {
        return tableDao.update(table);
    }

    @Override
    public Page<Table> page(TableQuery query, int start, int count) {
        return tableDao.page(query, start, count);
    }

    public List<Table> listAll() {
        return tableDao.listAll();
    }

    @Override
    public List<Table> getByName(String name) {
        return tableDao.getByName(name);
    }
}
