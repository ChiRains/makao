package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DriverTemplateDao;
import com.qcloud.project.macaovehicle.model.DriverTemplate;
import com.qcloud.project.macaovehicle.service.DriverTemplateService;
import com.qcloud.project.macaovehicle.model.query.DriverTemplateQuery;

@Service
public class DriverTemplateServiceImpl implements DriverTemplateService {

    @Autowired
    private DriverTemplateDao   driverTemplateDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "macaovehicle_driver_template";

    @Override
    public boolean add(DriverTemplate driverTemplate) {

        long id = autoIdGenerator.get(ID_KEY);
        driverTemplate.setId(id);
        return driverTemplateDao.add(driverTemplate);
    }

    @Override
    public DriverTemplate get(Long id) {

        return driverTemplateDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return driverTemplateDao.delete(id);
    }

    @Override
    public boolean update(DriverTemplate driverTemplate) {

        return driverTemplateDao.update(driverTemplate);
    }

    @Override
    public Page<DriverTemplate> page(DriverTemplateQuery query, int start, int count) {

        return driverTemplateDao.page(query, start, count);
    }

    public List<DriverTemplate> listAll() {

        return driverTemplateDao.listAll();
    }

    @Override
    public List<DriverTemplate> listByClerkId(Long clerkId) {

        return driverTemplateDao.listByClerkId(clerkId);
    }

    @Override
    public boolean deleteByClerkId(Long clerkId) {

        return driverTemplateDao.deleteByClerkId(clerkId);
    }
}
