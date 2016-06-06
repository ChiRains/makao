package com.qcloud.component.organization.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.PostDao;
import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.service.PostService;
import com.qcloud.component.organization.model.query.PostQuery;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao             postDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "organization_post";

    @Override
    public boolean add(Post post) {

        long id = autoIdGenerator.get(ID_KEY);
        post.setId(id);
        return postDao.add(post);
    }

    @Override
    public Post get(Long id) {

        return postDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return postDao.delete(id);
    }

    @Override
    public boolean update(Post post) {

        return postDao.update(post);
    }

    @Override
    public Page<Post> page(PostQuery query, int start, int count) {

        return postDao.page(query, start, count);
    }

    public List<Post> listAll() {

        return postDao.listAll();
    }    
}
