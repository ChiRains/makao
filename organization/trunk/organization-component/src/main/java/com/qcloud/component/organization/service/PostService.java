package com.qcloud.component.organization.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.model.query.PostQuery;

public interface PostService {

    public boolean add(Post post);

    public Post get(Long id);

    public boolean delete(Long id);

    public boolean update(Post post);

    public Page<Post> page(PostQuery query, int start, int count);

    public List<Post> listAll();
}
