package com.qcloud.component.organization.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.SuperiorDao;
import com.qcloud.component.organization.model.Superior;
import com.qcloud.component.organization.service.SuperiorService;
import com.qcloud.component.organization.model.query.SuperiorQuery;

@Service
public class SuperiorServiceImpl implements SuperiorService {

    @Autowired
    private SuperiorDao         superiorDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "organization_superior";

    @Override
    public boolean add(Superior superior) {

        long id = autoIdGenerator.get(ID_KEY);
        superior.setId(id);
        return superiorDao.add(superior);
    }

    @Override
    public Superior get(Long id) {

        return superiorDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return superiorDao.delete(id);
    }

    @Override
    public boolean update(Superior superior) {

        return superiorDao.update(superior);
    }

    @Override
    public Page<Superior> page(SuperiorQuery query, int start, int count) {

        return superiorDao.page(query, start, count);
    }

    public List<Superior> listAll() {

        return superiorDao.listAll();
    }

    @Override
    public Superior getByClerk(Long clerkId) {

        return superiorDao.getByClerk(clerkId);
    }
}
