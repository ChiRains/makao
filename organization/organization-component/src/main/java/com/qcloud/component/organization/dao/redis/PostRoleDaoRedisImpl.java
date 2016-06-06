package com.qcloud.component.organization.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.organization.dao.PostRoleDao;
import com.qcloud.component.organization.model.PostRole;
import com.qcloud.component.organization.model.query.PostRoleQuery;

@Repository
public class PostRoleDaoRedisImpl implements PostRoleDao {

    // @Resource(name = "redis-organization")
    // private Redis redis;
    @Override
    public boolean add(PostRole postRole) {

        throw new NotImplementedException();
    }

    @Override
    public PostRole get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(PostRole postRole) {

        throw new NotImplementedException();
    }

    @Override
    public List<PostRole> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, PostRole> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<PostRole> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<PostRole> page(PostRoleQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<PostRole> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<PostRole> listAll(Map<String, Object> map) {

        throw new NotImplementedException();
    }

    @Override
    public List<PostRole> listByPost(long postId) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        throw new NotImplementedException();
    }
}
