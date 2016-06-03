package com.qcloud.component.organization.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.organization.model.PostRole;
import com.qcloud.component.organization.model.query.PostRoleQuery;

public interface PostRoleDao extends ISimpleDao<PostRole, Long> {

    public boolean add(PostRole postRole);

    public PostRole get(Long id);

    public boolean delete(Long id);

    public boolean update(PostRole postRole);

    public List<PostRole> list(List<Long> idList);

    public Map<Long, PostRole> map(Set<Long> idSet);

    public Page<PostRole> page(PostRoleQuery query, int start, int size);

    public List<PostRole> listAll();

    public List<PostRole> listAll(Map<String, Object> map);

    List<PostRole> listByPost(long postId);

    public boolean delete(Map<String, Object> map);
}
