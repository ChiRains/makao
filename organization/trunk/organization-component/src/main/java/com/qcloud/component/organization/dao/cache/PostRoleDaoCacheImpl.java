package com.qcloud.component.organization.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.PostRoleDao;
import com.qcloud.component.organization.model.PostRole;
import com.qcloud.component.organization.model.query.PostRoleQuery;

@Repository
public class PostRoleDaoCacheImpl implements PostRoleDao {

    @Autowired
    private PostRoleDao postRoleDaoMysqlImpl;

    @Autowired
    private PostRoleDao postRoleDaoRedisImpl;

    // @Autowired
    // private PostRoleDao postRoleDaoRedisImpl;
    @Override
    public boolean add(PostRole postRole) {

        return postRoleDaoMysqlImpl.add(postRole);
    }

    @Override
    public PostRole get(Long id) {

        return postRoleDaoMysqlImpl.get(id);
        // return CacheLoader.get(postRoleDaoRedisImpl, postRoleDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return postRoleDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(PostRole postRole) {

        return postRoleDaoMysqlImpl.update(postRole);
    }

    @Override
    public List<PostRole> list(List<Long> idList) {

        return CacheLoader.list(postRoleDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, PostRole> map(Set<Long> idSet) {

        return CacheLoader.map(postRoleDaoMysqlImpl, idSet);
    }

    @Override
    public Page<PostRole> page(int start, int count) {

        return postRoleDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<PostRole> page(PostRoleQuery query, int start, int count) {

        return postRoleDaoMysqlImpl.page(query, start, count);
    }

    public List<PostRole> listAll() {

        return postRoleDaoMysqlImpl.listAll();
    }

    @Override
    public List<PostRole> listByPost(long postId) {

        return postRoleDaoMysqlImpl.listByPost(postId);
    }

    @Override
    public List<PostRole> listAll(Map<String, Object> map) {

        return postRoleDaoMysqlImpl.listAll(map);
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return postRoleDaoMysqlImpl.delete(map);
    }
}
