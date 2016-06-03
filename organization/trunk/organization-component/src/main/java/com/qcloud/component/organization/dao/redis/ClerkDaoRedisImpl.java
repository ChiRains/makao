package com.qcloud.component.organization.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.ClerkDao;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.query.ClerkQuery;

@Repository
public class ClerkDaoRedisImpl implements ClerkDao {

    // @Resource(name = "redis-organization")
    // private Redis redis;
    @Override
    public boolean add(Clerk clerk) {

        throw new NotImplementedException();
    }

    @Override
    public Clerk get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(Clerk clerk) {

        throw new NotImplementedException();
    }

    @Override
    public List<Clerk> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Clerk> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Clerk> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Clerk> page(ClerkQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<Clerk> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<Clerk> listAll(Map<String, Object> map) {

        throw new NotImplementedException();
    }

    @Override
    public List<Clerk> listByName(String name) {

        throw new NotImplementedException();
    }

    @Override
    public boolean editEnable(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public Clerk getByMobile(String mobile) {

        throw new NotImplementedException();
    }

    @Override
    public Clerk getByIdCard(String idCard) {

        throw new NotImplementedException();
    }

    @Override
    public Clerk getByJobEmail(String email) {

        throw new NotImplementedException();
    }
}
