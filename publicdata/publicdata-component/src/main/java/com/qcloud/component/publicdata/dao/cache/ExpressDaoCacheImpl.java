package com.qcloud.component.publicdata.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.ExpressDao;
import com.qcloud.component.publicdata.model.Express;
import com.qcloud.component.publicdata.model.query.ExpressQuery;

@Repository
public class ExpressDaoCacheImpl implements ExpressDao {

    @Autowired
    private ExpressDao expressDaoMysqlImpl;

    @Autowired
    private ExpressDao expressDaoRedisImpl;

    @Override
    public boolean add(Express express) {

        return expressDaoMysqlImpl.add(express);
    }

    @Override
    public Express get(Long id) {

        // return CacheLoader.get(expressDaoRedisImpl, expressDaoMysqlImpl, id);
        return expressDaoMysqlImpl.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return expressDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(Express express) {

        return expressDaoMysqlImpl.update(express);
    }

    @Override
    public List<Express> list(List<Long> idList) {

        return CacheLoader.list(expressDaoRedisImpl, expressDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, Express> map(Set<Long> idSet) {

        return CacheLoader.map(expressDaoRedisImpl, expressDaoMysqlImpl, idSet);
    }

    @Override
    public Page<Express> page(int start, int count) {

        return expressDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<Express> page(ExpressQuery query, int start, int count) {

        return expressDaoMysqlImpl.page(query, start, count);
    }

    public List<Express> listAll() {

        return expressDaoMysqlImpl.listAll();
    }

    @Override
    public Express getByCode(String code) {

        return expressDaoMysqlImpl.getByCode(code);
    }
}
