package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.TaskingCustomsDao;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.service.TaskingCustomsService;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.StatusType;
import com.qcloud.project.macaovehicle.model.query.TaskingCustomsQuery;

@Service
public class TaskingCustomsServiceImpl implements TaskingCustomsService {

    @Autowired
    private TaskingCustomsDao   taskingCustomsDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "macaovehicle_tasking_customs";

    @Override
    public boolean add(TaskingCustoms taskingCustoms) {

        long id = autoIdGenerator.get(ID_KEY);
        taskingCustoms.setId(id);
        return taskingCustomsDao.add(taskingCustoms);
    }

    @Override
    public TaskingCustoms get(Long id) {

        return taskingCustomsDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return taskingCustomsDao.delete(id);
    }

    @Override
    public boolean update(TaskingCustoms taskingCustoms) {

        return taskingCustomsDao.update(taskingCustoms);
    }

    @Override
    public Page<TaskingCustoms> page(TaskingCustomsQuery query, int start, int count) {

        return taskingCustomsDao.page(query, start, count);
    }

    public List<TaskingCustoms> listAll() {

        return taskingCustomsDao.listAll();
    }

    @Override
    public TaskingCustoms getByFormInstanceId(Long formInstanceId) {

        return taskingCustomsDao.getByFormInstanceId(formInstanceId);
    }

    @Override
    public boolean changeStatus(Long formInstanceId, StatusType statusType) {

        TaskingCustoms taskingCustoms = taskingCustomsDao.getByFormInstanceId(formInstanceId);
        taskingCustoms.setStatus(statusType.getKey());
        return taskingCustomsDao.update(taskingCustoms);
    }

    @Override
    public List<TaskingCustoms> listAllByState(int status) {

        return taskingCustomsDao.listAllByState(status);
    }
}
