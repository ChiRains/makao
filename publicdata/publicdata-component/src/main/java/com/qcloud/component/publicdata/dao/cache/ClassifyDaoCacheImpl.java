package com.qcloud.component.publicdata.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.ClassifyDao;
import com.qcloud.component.publicdata.model.Classify;
import com.qcloud.component.publicdata.model.query.ClassifyQuery;

@Repository
public class ClassifyDaoCacheImpl implements ClassifyDao {

    @Autowired
    private ClassifyDao classifyDaoMysqlImpl;

    // @Autowired
    // private ClassifyDao classifyDaoRedisImpl;
    @Override
    public boolean add(Classify classify) {

        return classifyDaoMysqlImpl.add(classify);
    }

    @Override
    public Classify get(Long id) {

        return classifyDaoMysqlImpl.get(id);
        // return CacheLoader.get(classifyDaoRedisImpl, classifyDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return classifyDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(Classify classify) {

        return classifyDaoMysqlImpl.update(classify);
    }

    @Override
    public List<Classify> list(List<Long> idList) {

        return CacheLoader.list(classifyDaoMysqlImpl, idList);
        // return CacheLoader.list(classifyDaoRedisImpl, classifyDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, Classify> map(Set<Long> idSet) {

        return CacheLoader.map(classifyDaoMysqlImpl, idSet);
        // return CacheLoader.map(classifyDaoRedisImpl, classifyDaoMysqlImpl, idSet);
    }

    @Override
    public Page<Classify> page(int start, int count) {

        return classifyDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<Classify> page(ClassifyQuery query, int start, int count) {

        return classifyDaoMysqlImpl.page(query, start, count);
    }

    public List<Classify> listAll(long type) {

        return classifyDaoMysqlImpl.listAll(type);
    }

    @Override
    public Classify getByName(long type, String name) {

        return classifyDaoMysqlImpl.getByName(type, name);
    }

    @Override
    public List<Classify> listChildren(long type, Long parentId) {

        return classifyDaoMysqlImpl.listChildren(type, parentId);
    }

    @Override
    public List<Classify> listAllChildren(String bsid) {

        return classifyDaoMysqlImpl.listAllChildren(bsid);
    }

    @Override
    public boolean sort(Long id, int sort) {

        return classifyDaoMysqlImpl.sort(id,sort);
    }

    @Override
    public boolean enable(Long id, int enable) {

        return classifyDaoMysqlImpl.enable(id, enable);
    }

    @Override
    public List<Classify> listChildrenToSort(long type, Long parentId) {

        return classifyDaoMysqlImpl.listChildrenToSort(type, parentId);
    }

    @Override
    public List<Classify> listAllChildrenToEnable(String bsid) {

        return classifyDaoMysqlImpl.listAllChildrenToEnable(bsid);
    }
}
