package com.qcloud.component.organization.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.model.query.PostQuery;

public interface PostDao extends ISimpleDao<Post, Long> {

    public boolean add(Post post);

    public Post get(Long id);

    public boolean delete(Long id);

    public boolean update(Post post);

    public List<Post> list(List<Long> idList);

    public Map<Long, Post> map(Set<Long> idSet);

    public Page<Post> page(PostQuery query, int start, int size);

    public List<Post> listAll();  
}
