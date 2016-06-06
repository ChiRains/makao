package com.qcloud.component.organization.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.query.ClerkQuery;

public interface ClerkDao extends ISimpleDao<Clerk, Long> {

    public boolean add(Clerk clerk);

    public Clerk get(Long id);

    public boolean delete(Long id);

    public boolean update(Clerk clerk);

    public List<Clerk> list(List<Long> idList);

    public Map<Long, Clerk> map(Set<Long> idSet);

    public Page<Clerk> page(ClerkQuery query, int start, int size);

    public List<Clerk> listAll();

    public Clerk getByMobile(String mobile);

    public Clerk getByIdCard(String idCard);

    public Clerk getByJobEmail(String email);

    public List<Clerk> listAll(Map<String, Object> map);

    List<Clerk> listByName(String name);

    public boolean editEnable(Long id);
}
