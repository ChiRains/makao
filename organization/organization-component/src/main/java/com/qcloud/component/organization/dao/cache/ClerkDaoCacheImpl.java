package com.qcloud.component.organization.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.ClerkDao;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.query.ClerkQuery;

@Repository
public class ClerkDaoCacheImpl implements ClerkDao {

    @Autowired
    private ClerkDao clerkDaoMysqlImpl;

    // @Autowired
    // private ClerkDao clerkDaoRedisImpl;
    @Override
    public boolean add(Clerk clerk) {

        return clerkDaoMysqlImpl.add(clerk);
    }

    @Override
    public Clerk get(Long id) {

        return clerkDaoMysqlImpl.get(id);
        // return CacheLoader.get(clerkDaoRedisImpl, clerkDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return clerkDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(Clerk clerk) {

        return clerkDaoMysqlImpl.update(clerk);
    }

    @Override
    public List<Clerk> list(List<Long> idList) {

        return CacheLoader.list(clerkDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, Clerk> map(Set<Long> idSet) {

        return CacheLoader.map(clerkDaoMysqlImpl, idSet);
    }

    @Override
    public Page<Clerk> page(int start, int count) {

        return clerkDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<Clerk> page(ClerkQuery query, int start, int count) {

        return clerkDaoMysqlImpl.page(query, start, count);
    }

    public List<Clerk> listAll() {

        return clerkDaoMysqlImpl.listAll();
    }

    @Override
    public List<Clerk> listAll(Map<String, Object> map) {

        return clerkDaoMysqlImpl.listAll(map);
    }

    @Override
    public List<Clerk> listByName(String name) {

        return clerkDaoMysqlImpl.listByName(name);
    }

    @Override
    public boolean editEnable(Long id) {

        return clerkDaoMysqlImpl.editEnable(id);
    }

    @Override
    public Clerk getByMobile(String mobile) {

        return clerkDaoMysqlImpl.getByMobile(mobile);
    }

    @Override
    public Clerk getByIdCard(String idCard) {

        return clerkDaoMysqlImpl.getByIdCard(idCard);
    }

    @Override
    public Clerk getByJobEmail(String email) {

        return clerkDaoMysqlImpl.getByJobEmail(email);
    }
}
