package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.TaskingBorderDao;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.service.TaskingBorderService;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.StatusType;
import com.qcloud.project.macaovehicle.model.query.TaskingBorderQuery;

@Service
public class TaskingBorderServiceImpl implements TaskingBorderService {

    @Autowired
    private TaskingBorderDao    taskingBorderDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "macaovehicle_tasking_border";

    @Override
    public boolean add(TaskingBorder taskingBorder) {

        long id = autoIdGenerator.get(ID_KEY);
        taskingBorder.setId(id);
        return taskingBorderDao.add(taskingBorder);
    }

    @Override
    public TaskingBorder get(Long id) {

        return taskingBorderDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return taskingBorderDao.delete(id);
    }

    @Override
    public boolean update(TaskingBorder taskingBorder) {

        return taskingBorderDao.update(taskingBorder);
    }

    @Override
    public Page<TaskingBorder> page(TaskingBorderQuery query, int start, int count) {

        return taskingBorderDao.page(query, start, count);
    }

    public List<TaskingBorder> listAll() {

        return taskingBorderDao.listAll();
    }

    @Override
    public TaskingBorder getByFormInstanceId(Long formInstanceId) {

        return taskingBorderDao.getByFormInstanceId(formInstanceId);
    }

    @Override
    public boolean changeStatus(Long formInstanceId, StatusType statusType) {

        TaskingBorder taskingBorder = taskingBorderDao.getByFormInstanceId(formInstanceId);
        taskingBorder.setStatus(statusType.getKey());
        return taskingBorderDao.update(taskingBorder);
    }

    @Override
    public List<TaskingBorder> listAllByState(int status) {

        return taskingBorderDao.listAllByState(status);
    }
}
