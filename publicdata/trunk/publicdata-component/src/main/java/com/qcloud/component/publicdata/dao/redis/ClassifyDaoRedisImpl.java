package com.qcloud.component.publicdata.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.component.publicdata.dao.ClassifyDao;
import com.qcloud.component.publicdata.model.Classify;
import com.qcloud.component.publicdata.model.query.ClassifyQuery;
import com.qcloud.pirates.data.Page;

@Repository
public class ClassifyDaoRedisImpl implements ClassifyDao {

    // @Resource(name = "redis-publicdata")
    // private Redis redis;
    @Override
    public boolean add(Classify classify) {

        throw new NotImplementedException();
    }

    @Override
    public Classify get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(Classify classify) {

        throw new NotImplementedException();
    }

    @Override
    public List<Classify> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Classify> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Classify> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Classify> page(ClassifyQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<Classify> listAll(long type) {

        throw new NotImplementedException();
    }

    @Override
    public List<Classify> listAllChildren(String bsid) {

        throw new NotImplementedException();
    }

    @Override
    public Classify getByName(long type, String name) {

        throw new NotImplementedException();
    }

    @Override
    public List<Classify> listChildren(long type, Long parentId) {

        throw new NotImplementedException();
    }

    @Override
    public boolean sort(Long id, int sort) {

        throw new NotImplementedException();
    }

    @Override
    public boolean enable(Long id, int enable) {

        throw new NotImplementedException();
    }

    @Override
    public List<Classify> listChildrenToSort(long type, Long parentId) {

        throw new NotImplementedException();
    }

    @Override
    public List<Classify> listAllChildrenToEnable(String bsid) {

        throw new NotImplementedException();
    }
}
