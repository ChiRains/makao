package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.model.query.TaskingCustomsQuery;

public interface TaskingCustomsDao extends ISimpleDao<TaskingCustoms, Long> {

    public boolean add(TaskingCustoms taskingCustoms);

    public TaskingCustoms get(Long id);

    public boolean delete(Long id);

    public boolean update(TaskingCustoms taskingCustoms);

    public List<TaskingCustoms> list(List<Long> idList);

    public Map<Long, TaskingCustoms> map(Set<Long> idSet);

    public Page<TaskingCustoms> page(TaskingCustomsQuery query, int start, int size);

    public List<TaskingCustoms> listAll();

    public TaskingCustoms getByFormInstanceId(Long formInstanceId);

    public List<TaskingCustoms> listAllByState(int status);
}
