package com.qcloud.component.organization.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.PostRoleDao;
import com.qcloud.component.organization.model.PostRole;
import com.qcloud.component.organization.service.PostRoleService;
import com.qcloud.component.organization.model.query.PostRoleQuery;

@Service
public class PostRoleServiceImpl implements PostRoleService {

    @Autowired
    private PostRoleDao         postRoleDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "organization_post_role";

    @Override
    public boolean add(PostRole postRole) {

        long id = autoIdGenerator.get(ID_KEY);
        postRole.setId(id);
        return postRoleDao.add(postRole);
    }

    @Override
    public PostRole get(Long id) {

        return postRoleDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return postRoleDao.delete(id);
    }

    @Override
    public boolean update(PostRole postRole) {

        return postRoleDao.update(postRole);
    }

    @Override
    public Page<PostRole> page(PostRoleQuery query, int start, int count) {

        return postRoleDao.page(query, start, count);
    }

    public List<PostRole> listAll() {

        return postRoleDao.listAll();
    }

    @Override
    public List<PostRole> listAll(Map<String, Object> map) {

        return postRoleDao.listAll(map);
    }

    @Override
    public List<PostRole> listByPost(long postId) {

        return postRoleDao.listByPost(postId);
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return postRoleDao.delete(map);
    }
}
