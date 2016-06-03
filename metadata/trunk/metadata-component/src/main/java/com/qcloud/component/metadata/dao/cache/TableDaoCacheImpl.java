package com.qcloud.component.metadata.dao.cache;
import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.metadata.dao.TableDao;
import com.qcloud.component.metadata.model.Table;
import com.qcloud.component.metadata.model.query.TableQuery;
@Repository
public class TableDaoCacheImpl implements TableDao {
    @Autowired
    private TableDao tableDaoMysqlImpl;
    @Autowired
    private TableDao tableDaoRedisImpl;

    @Override
    public boolean add(Table table) {
        return tableDaoMysqlImpl.add(table);
    }

    @Override
    public Table get(Long id) {
        return tableDaoMysqlImpl.get(id);
    }

    @Override
    public boolean delete(Long id) {
        return tableDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(Table table) {
        return tableDaoMysqlImpl.update(table);
    }

    @Override
    public List<Table> list(List<Long> idList) {
        return CacheLoader.list(tableDaoRedisImpl, tableDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, Table> map(Set<Long> idSet) {
        return CacheLoader.map(tableDaoRedisImpl, tableDaoMysqlImpl, idSet);
    }

    @Override
    public Page<Table> page(int start, int count) {
        return tableDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<Table> page(TableQuery query, int start, int count) {
        return tableDaoMysqlImpl.page(query, start, count);
    }

    public List<Table> listAll() {
        return tableDaoMysqlImpl.listAll();
    }

    @Override
    public List<Table> getByName(String name) {
        return tableDaoMysqlImpl.getByName(name);
    }
}
