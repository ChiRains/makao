package com.qcloud.component.snakerext.service;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.model.TaskFormAccess;
import com.qcloud.component.snakerext.model.query.TaskFormAccessQuery;
import com.qcloud.component.form.ProcessActivityFormElementMappingExtend.ActivityElementMapping;
public interface TaskFormAccessService {
    public boolean add(TaskFormAccess taskFormAccess);

    public TaskFormAccess get(Long id);

    public boolean delete(Long id);

    public boolean update(TaskFormAccess taskFormAccess);

    public Page<TaskFormAccess> page(TaskFormAccessQuery query, int start, int count);

    public List<TaskFormAccess> listAll();

    public boolean delete(Map<String, Object> map);

    public Map<Long, Integer> mapAllElementStatus(TaskFormAccessQuery query);

    public List<ActivityElementMapping> listAllActivityElementMapping(TaskFormAccessQuery query);
}
