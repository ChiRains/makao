package com.qcloud.component.permission.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.dao.ResourcesDao;
import com.qcloud.component.permission.model.Resources;
import com.qcloud.component.permission.service.ResourcesService;

@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    private ResourcesDao resourcesDao;

    @Override
    public boolean add(Resources resources) {

        return resourcesDao.add(resources);
    }

    @Override
    public Resources get(Long id) {

        return resourcesDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return resourcesDao.delete(id);
    }

    @Override
    public boolean update(Resources resources) {

        return resourcesDao.update(resources);
    }

    @Override
    public Page<Resources> page(int start, int count) {

        return resourcesDao.page(start, count);
    }

    @Override
    public List<Resources> list(List<Long> idList) {

        return resourcesDao.list(idList);
    }

    @Override
    public Resources getByClassifyId(long classifyId) {

        return resourcesDao.getByClassifyId(classifyId);
    }
}
