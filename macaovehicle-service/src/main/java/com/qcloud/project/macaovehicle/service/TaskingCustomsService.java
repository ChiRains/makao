package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.StatusType;
import com.qcloud.project.macaovehicle.model.query.TaskingCustomsQuery;

public interface TaskingCustomsService {

    public boolean add(TaskingCustoms taskingCustoms);

    public TaskingCustoms get(Long id);

    public boolean delete(Long id);

    public boolean update(TaskingCustoms taskingCustoms);

    public Page<TaskingCustoms> page(TaskingCustomsQuery query, int start, int count);

    public List<TaskingCustoms> listAll();

    public TaskingCustoms getByFormInstanceId(Long formInstanceId);

    public boolean changeStatus(Long formInstanceId, StatusType statusType);

    public List<TaskingCustoms> listAllByState(int status);
}
