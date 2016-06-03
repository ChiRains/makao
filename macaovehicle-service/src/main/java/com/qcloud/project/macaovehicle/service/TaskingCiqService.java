package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.StatusType;
import com.qcloud.project.macaovehicle.model.query.TaskingCiqQuery;

public interface TaskingCiqService {

    public boolean add(TaskingCiq taskingCiq);

    public TaskingCiq get(Long id);

    public boolean delete(Long id);

    public boolean update(TaskingCiq taskingCiq);

    public Page<TaskingCiq> page(TaskingCiqQuery query, int start, int count);

    public List<TaskingCiq> listAll();

    public TaskingCiq getByFormInstanceId(Long formInstanceId);

    public boolean changeStatus(Long formInstanceId, StatusType statusType);

    public List<TaskingCiq> listAllByState(int status);
}
