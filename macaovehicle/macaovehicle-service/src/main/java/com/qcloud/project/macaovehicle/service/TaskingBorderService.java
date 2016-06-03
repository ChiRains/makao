package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.StatusType;
import com.qcloud.project.macaovehicle.model.query.TaskingBorderQuery;

public interface TaskingBorderService {

    public boolean add(TaskingBorder taskingBorder);

    public TaskingBorder get(Long id);

    public boolean delete(Long id);

    public boolean update(TaskingBorder taskingBorder);

    public Page<TaskingBorder> page(TaskingBorderQuery query, int start, int count);

    public List<TaskingBorder> listAll();

    public TaskingBorder getByFormInstanceId(Long formInstanceId);

    public boolean changeStatus(Long formInstanceId, StatusType statusType);

    public List<TaskingBorder> listAllByState(int status);
}
