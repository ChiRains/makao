package com.qcloud.component.organization.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.ClerkPostDao;
import com.qcloud.component.organization.model.ClerkPost;
import com.qcloud.component.organization.service.ClerkPostService;
import com.qcloud.component.organization.model.query.ClerkPostQuery;

@Service
public class ClerkPostServiceImpl implements ClerkPostService {

    @Autowired
    private ClerkPostDao        clerkPostDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "organization_clerk_post";

    @Override
    public boolean add(ClerkPost clerkPost) {

        long id = autoIdGenerator.get(ID_KEY);
        clerkPost.setId(id);
        return clerkPostDao.add(clerkPost);
    }

    @Override
    public ClerkPost get(Long id) {

        return clerkPostDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return clerkPostDao.delete(id);
    }

    @Override
    public boolean update(ClerkPost clerkPost) {

        return clerkPostDao.update(clerkPost);
    }

    @Override
    public Page<ClerkPost> page(ClerkPostQuery query, int start, int count) {

        return clerkPostDao.page(query, start, count);
    }

    public List<ClerkPost> listAll() {

        return clerkPostDao.listAll();
    }

    @Override
    public List<ClerkPost> listByClerk(long clerkId) {

        return clerkPostDao.listByClerk(clerkId);
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return clerkPostDao.delete(map);
    }

    @Override
    public List<ClerkPost> listByPost(Long postId) {

        return clerkPostDao.listByPost(postId);
    }
}
