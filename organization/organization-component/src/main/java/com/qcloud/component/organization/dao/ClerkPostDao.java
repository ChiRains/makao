package com.qcloud.component.organization.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.organization.model.ClerkPost;
import com.qcloud.component.organization.model.query.ClerkPostQuery;

public interface ClerkPostDao extends ISimpleDao<ClerkPost, Long> {

    public boolean add(ClerkPost clerkPost);

    public ClerkPost get(Long id);

    public boolean delete(Long id);

    public boolean update(ClerkPost clerkPost);

    public List<ClerkPost> list(List<Long> idList);

    public Map<Long, ClerkPost> map(Set<Long> idSet);

    public Page<ClerkPost> page(ClerkPostQuery query, int start, int size);

    public List<ClerkPost> listAll();

    List<ClerkPost> listByClerk(long clerkId);

    public boolean delete(Map<String, Object> map);
    
    public List<ClerkPost> listByPost(Long postId);
}
