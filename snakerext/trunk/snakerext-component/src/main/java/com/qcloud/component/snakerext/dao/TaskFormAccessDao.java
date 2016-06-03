package com.qcloud.component.snakerext.dao;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.component.snakerext.model.TaskFormAccess;
import com.qcloud.component.snakerext.model.query.TaskFormAccessQuery;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
public interface TaskFormAccessDao extends ISimpleDao<TaskFormAccess, Long> {
    public boolean add(TaskFormAccess taskFormAccess);

    public TaskFormAccess get(Long id);

    public boolean delete(Long id);

    public boolean update(TaskFormAccess taskFormAccess);

    public List<TaskFormAccess> list(List<Long> idList);

    public Map<Long, TaskFormAccess> map(Set<Long> idSet);

    public Page<TaskFormAccess> page(TaskFormAccessQuery query, int start, int size);

    public List<TaskFormAccess> listAll();

    public boolean delete(Map<String, Object> map);

    public List<TaskFormAccess> listAll(Map<String, Object> map);
}
