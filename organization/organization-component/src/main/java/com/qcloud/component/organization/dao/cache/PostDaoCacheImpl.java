package com.qcloud.component.organization.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.PostDao;
import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.model.query.PostQuery;

@Repository
public class PostDaoCacheImpl implements PostDao {

    @Autowired
    private PostDao postDaoMysqlImpl;

    @Autowired
    private PostDao postDaoRedisImpl;

    @Override
    public boolean add(Post post) {

        return postDaoMysqlImpl.add(post);
    }

    @Override
    public Post get(Long id) {

        return postDaoMysqlImpl.get(id);
        // return CacheLoader.get(postDaoRedisImpl, postDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return postDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(Post post) {

        return postDaoMysqlImpl.update(post);
    }

    @Override
    public List<Post> list(List<Long> idList) {

        return CacheLoader.list(postDaoRedisImpl, postDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, Post> map(Set<Long> idSet) {

        return CacheLoader.map(postDaoRedisImpl, postDaoMysqlImpl, idSet);
    }

    @Override
    public Page<Post> page(int start, int count) {

        return postDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<Post> page(PostQuery query, int start, int count) {

        return postDaoMysqlImpl.page(query, start, count);
    }

    public List<Post> listAll() {

        return postDaoMysqlImpl.listAll();
    }
}
