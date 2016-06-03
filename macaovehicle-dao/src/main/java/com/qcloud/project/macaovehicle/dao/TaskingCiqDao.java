package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.query.TaskingCiqQuery;

public interface TaskingCiqDao extends ISimpleDao<TaskingCiq, Long> {

    public boolean add(TaskingCiq taskingCiq);

    public TaskingCiq get(Long id);

    public boolean delete(Long id);

    public boolean update(TaskingCiq taskingCiq);

    public List<TaskingCiq> list(List<Long> idList);

    public Map<Long, TaskingCiq> map(Set<Long> idSet);

    public Page<TaskingCiq> page(TaskingCiqQuery query, int start, int size);

    public List<TaskingCiq> listAll();

    public TaskingCiq getByFormInstanceId(Long formInstanceId);

    public List<TaskingCiq> listAllByState(int status);
}
