package com.qcloud.component.organization.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.organization.model.Superior;
import com.qcloud.component.organization.model.query.SuperiorQuery;

public interface SuperiorDao extends ISimpleDao<Superior, Long> {

    public boolean add(Superior superior);

    public Superior get(Long id);

    public boolean delete(Long id);

    public boolean update(Superior superior);

    public List<Superior> list(List<Long> idList);

    public Map<Long, Superior> map(Set<Long> idSet);

    public Page<Superior> page(SuperiorQuery query, int start, int size);

    public List<Superior> listAll();

    Superior getByClerk(Long clerkId);
}
