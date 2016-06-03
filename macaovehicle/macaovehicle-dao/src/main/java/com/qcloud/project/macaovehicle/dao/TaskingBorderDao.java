package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.query.TaskingBorderQuery;

public interface TaskingBorderDao extends ISimpleDao<TaskingBorder, Long> {

    public boolean add(TaskingBorder taskingBorder);

    public TaskingBorder get(Long id);

    public boolean delete(Long id);

    public boolean update(TaskingBorder taskingBorder);

    public List<TaskingBorder> list(List<Long> idList);

    public Map<Long, TaskingBorder> map(Set<Long> idSet);

    public Page<TaskingBorder> page(TaskingBorderQuery query, int start, int size);

    public List<TaskingBorder> listAll();

    public TaskingBorder getByFormInstanceId(Long formInstanceId);

    public List<TaskingBorder> listAllByState(int status);
}
