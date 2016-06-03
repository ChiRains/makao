package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.TaskingCiqDao;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.service.TaskingCiqService;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.StatusType;
import com.qcloud.project.macaovehicle.model.query.TaskingCiqQuery;

@Service
public class TaskingCiqServiceImpl implements TaskingCiqService {

    @Autowired
    private TaskingCiqDao       taskingCiqDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "macaovehicle_tasking_ciq";

    @Override
    public boolean add(TaskingCiq taskingCiq) {

        long id = autoIdGenerator.get(ID_KEY);
        taskingCiq.setId(id);
        return taskingCiqDao.add(taskingCiq);
    }

    @Override
    public TaskingCiq get(Long id) {

        return taskingCiqDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return taskingCiqDao.delete(id);
    }

    @Override
    public boolean update(TaskingCiq taskingCiq) {

        return taskingCiqDao.update(taskingCiq);
    }

    @Override
    public Page<TaskingCiq> page(TaskingCiqQuery query, int start, int count) {

        return taskingCiqDao.page(query, start, count);
    }

    public List<TaskingCiq> listAll() {

        return taskingCiqDao.listAll();
    }

    @Override
    public TaskingCiq getByFormInstanceId(Long formInstanceId) {

        return taskingCiqDao.getByFormInstanceId(formInstanceId);
    }

    @Override
    public boolean changeStatus(Long formInstanceId, StatusType statusType) {

        TaskingCiq taskingCiq = taskingCiqDao.getByFormInstanceId(formInstanceId);
        taskingCiq.setStatus(statusType.getKey());
        return taskingCiqDao.update(taskingCiq);
    }

    @Override
    public List<TaskingCiq> listAllByState(int status) {

        return taskingCiqDao.listAllByState(status);
    }
}
