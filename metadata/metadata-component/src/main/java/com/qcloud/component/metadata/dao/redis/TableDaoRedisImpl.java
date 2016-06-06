package com.qcloud.component.metadata.dao.redis;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.metadata.dao.TableDao;
import com.qcloud.component.metadata.model.Table;
import com.qcloud.component.metadata.model.query.TableQuery;
@Repository
public class TableDaoRedisImpl implements TableDao {
    // @Resource(name = "redis-metadata")
    // private Redis redis;
    @Override
    public boolean add(Table table) {
        throw new NotImplementedException();
    }

    @Override
    public Table get(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean update(Table table) {
        throw new NotImplementedException();
    }

    @Override
    public List<Table> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Table> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<Table> page(int start, int count) {
        throw new NotImplementedException();
    }

    @Override
    public Page<Table> page(TableQuery query, int start, int count) {
        throw new NotImplementedException();
    }

    @Override
    public List<Table> listAll() {
        throw new NotImplementedException();
    }

    @Override
    public List<Table> getByName(String name) {
        throw new NotImplementedException();
    }
}
