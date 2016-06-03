package com.qcloud.component.organization.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.ClerkPostDao;
import com.qcloud.component.organization.model.ClerkPost;
import com.qcloud.component.organization.model.query.ClerkPostQuery;

@Repository
public class ClerkPostDaoCacheImpl implements ClerkPostDao {

    @Autowired
    private ClerkPostDao clerkPostDaoMysqlImpl;

    // @Autowired
    // private ClerkPostDao clerkPostDaoRedisImpl;
    @Override
    public boolean add(ClerkPost clerkPost) {

        return clerkPostDaoMysqlImpl.add(clerkPost);
    }

    @Override
    public ClerkPost get(Long id) {

        return clerkPostDaoMysqlImpl.get(id);
        // return CacheLoader.get(clerkPostDaoRedisImpl, clerkPostDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return clerkPostDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(ClerkPost clerkPost) {

        return clerkPostDaoMysqlImpl.update(clerkPost);
    }

    @Override
    public List<ClerkPost> list(List<Long> idList) {

        return CacheLoader.list(clerkPostDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, ClerkPost> map(Set<Long> idSet) {

        return CacheLoader.map(clerkPostDaoMysqlImpl, idSet);
    }

    @Override
    public Page<ClerkPost> page(int start, int count) {

        return clerkPostDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<ClerkPost> page(ClerkPostQuery query, int start, int count) {

        return clerkPostDaoMysqlImpl.page(query, start, count);
    }

    public List<ClerkPost> listAll() {

        return clerkPostDaoMysqlImpl.listAll();
    }

    @Override
    public List<ClerkPost> listByClerk(long clerkId) {

        return clerkPostDaoMysqlImpl.listByClerk(clerkId);
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return clerkPostDaoMysqlImpl.delete(map);
    }

    @Override
    public List<ClerkPost> listByPost(Long postId) {

        return clerkPostDaoMysqlImpl.listByPost(postId);
    }
}
