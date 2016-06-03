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
import com.qcloud.component.organization.dao.ClerkPostDao;
import com.qcloud.component.organization.model.ClerkPost;
import com.qcloud.component.organization.model.query.ClerkPostQuery;

@Repository
public class ClerkPostDaoRedisImpl implements ClerkPostDao {

    // @Resource(name = "redis-organization")
    // private Redis redis;
    @Override
    public boolean add(ClerkPost clerkPost) {

        throw new NotImplementedException();
    }

    @Override
    public ClerkPost get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(ClerkPost clerkPost) {

        throw new NotImplementedException();
    }

    @Override
    public List<ClerkPost> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ClerkPost> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ClerkPost> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ClerkPost> page(ClerkPostQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<ClerkPost> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<ClerkPost> listByClerk(long clerkId) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        throw new NotImplementedException();
    }

    @Override
    public List<ClerkPost> listByPost(Long postId) {

        throw new NotImplementedException();
    }
}
