package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.DriverTemplate;
import com.qcloud.project.macaovehicle.model.query.DriverTemplateQuery;

public interface DriverTemplateService {

    public boolean add(DriverTemplate driverTemplate);

    public DriverTemplate get(Long id);

    public boolean delete(Long id);

    public boolean update(DriverTemplate driverTemplate);

    public Page<DriverTemplate> page(DriverTemplateQuery query, int start, int count);

    public List<DriverTemplate> listAll();

    public List<DriverTemplate> listByClerkId(Long clerkId);

    public boolean deleteByClerkId(Long clerkId);
}
