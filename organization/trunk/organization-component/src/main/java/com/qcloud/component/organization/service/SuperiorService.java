package com.qcloud.component.organization.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.model.Superior;
import com.qcloud.component.organization.model.query.SuperiorQuery;

public interface SuperiorService {

    public boolean add(Superior superior);

    public Superior get(Long id);

    public Superior getByClerk(Long clerkId);

    public boolean delete(Long id);

    public boolean update(Superior superior);

    public Page<Superior> page(SuperiorQuery query, int start, int count);

    public List<Superior> listAll();
}
