package com.qcloud.component.mvprocesstask.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.mvprocesstask.dao.TaskingDao;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.mvprocesstask.model.query.TaskingQuery;
import com.qcloud.component.mvprocesstask.service.TaskingService;
import com.qcloud.pirates.data.Page;

@Service
public class TaskingServiceImpl implements TaskingService {

    @Autowired
    private TaskingDao          taskingDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "processtask_tasking";

    @Override
    public boolean add(Tasking tasking) {

        long id = autoIdGenerator.get(ID_KEY);
        tasking.setId(id);
        tasking.setReceiveTime(new Date());
        return taskingDao.add(tasking);
    }

    @Override
    public Tasking get(Long id) {

        return taskingDao.get(id);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {

        return taskingDao.delete(id);
    }

    @Override
    public boolean update(Tasking tasking) {

        return taskingDao.update(tasking);
    }

    @Override
    public Page<Tasking> page(TaskingQuery query, int start, int count) {

        return taskingDao.page(query, start, count);
    }

    public List<Tasking> listAll() {

        return taskingDao.listAll();
    }

    @Override
    public Tasking getByWorkitem(String workitemId) {

        return taskingDao.getByWorkitem(workitemId);
    }

    @Override
    public Tasking getByFormInstanceId(Long formInstanceId) {

        return taskingDao.getByFormInstanceId(formInstanceId);
    }
}
