package com.qcloud.component.organization.service;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.model.PostRole;
import com.qcloud.component.organization.model.query.PostRoleQuery;

public interface PostRoleService {

    public boolean add(PostRole postRole);

    public PostRole get(Long id);

    public boolean delete(Long id);

    public boolean update(PostRole postRole);

    public Page<PostRole> page(PostRoleQuery query, int start, int count);

    public List<PostRole> listAll();

    public List<PostRole> listAll(Map<String, Object> map);

    List<PostRole> listByPost(long postId);

    public boolean delete(Map<String, Object> map);
}
