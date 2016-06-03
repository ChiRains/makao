package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.DriverTemplate;
import com.qcloud.project.macaovehicle.model.query.DriverTemplateQuery;

public interface DriverTemplateDao extends ISimpleDao<DriverTemplate, Long> {

    public boolean add(DriverTemplate driverTemplate);

    public DriverTemplate get(Long id);

    public boolean delete(Long id);

    public boolean update(DriverTemplate driverTemplate);

    public List<DriverTemplate> list(List<Long> idList);

    public Map<Long, DriverTemplate> map(Set<Long> idSet);

    public Page<DriverTemplate> page(DriverTemplateQuery query, int start, int size);

    public List<DriverTemplate> listAll();

    public List<DriverTemplate> listByClerkId(Long clerkId);

    public boolean deleteByClerkId(Long clerkId);
}
