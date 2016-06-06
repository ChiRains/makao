package com.qcloud.component.organization.service;

import java.util.List;
import java.util.Map;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.model.ClerkPost;
import com.qcloud.component.organization.model.query.ClerkPostQuery;

public interface ClerkPostService {

    public boolean add(ClerkPost clerkPost);

    public ClerkPost get(Long id);

    public boolean delete(Long id);

    public boolean update(ClerkPost clerkPost);

    public Page<ClerkPost> page(ClerkPostQuery query, int start, int count);

    public List<ClerkPost> listAll();

    List<ClerkPost> listByClerk(long clerkId);

    public boolean delete(Map<String, Object> map);
    
    public List<ClerkPost> listByPost(Long postId);
}
