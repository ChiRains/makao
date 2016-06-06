package com.qcloud.component.organization.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.SuperiorDao;
import com.qcloud.component.organization.model.Superior;
import com.qcloud.component.organization.model.query.SuperiorQuery;

@Repository
public class SuperiorDaoCacheImpl implements SuperiorDao {

    @Autowired
    private SuperiorDao superiorDaoMysqlImpl;

    // @Autowired
    // private SuperiorDao superiorDaoRedisImpl;
    @Override
    public boolean add(Superior superior) {

        return superiorDaoMysqlImpl.add(superior);
    }

    @Override
    public Superior get(Long id) {

        return superiorDaoMysqlImpl.get(id);
//        return CacheLoader.get(superiorDaoRedisImpl, superiorDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return superiorDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(Superior superior) {

        return superiorDaoMysqlImpl.update(superior);
    }

    @Override
    public List<Superior> list(List<Long> idList) {

        return CacheLoader.list(superiorDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, Superior> map(Set<Long> idSet) {

        return CacheLoader.map(superiorDaoMysqlImpl, idSet);
    }

    @Override
    public Page<Superior> page(int start, int count) {

        return superiorDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<Superior> page(SuperiorQuery query, int start, int count) {

        return superiorDaoMysqlImpl.page(query, start, count);
    }

    public List<Superior> listAll() {

        return superiorDaoMysqlImpl.listAll();
    }

    @Override
    public Superior getByClerk(Long clerkId) {

        return superiorDaoMysqlImpl.getByClerk(clerkId);
    }
}
