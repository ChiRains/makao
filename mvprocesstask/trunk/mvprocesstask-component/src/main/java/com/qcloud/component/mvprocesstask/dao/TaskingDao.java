package com.qcloud.component.mvprocesstask.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.mvprocesstask.model.query.TaskingQuery;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;

public interface TaskingDao extends ISimpleDao<Tasking, Long> {

    public boolean add(Tasking tasking);

    public Tasking get(Long id);

    public boolean delete(Long id);

    public boolean update(Tasking tasking);

    public List<Tasking> list(List<Long> idList);

    public Map<Long, Tasking> map(Set<Long> idSet);

    public Page<Tasking> page(TaskingQuery query, int start, int size);

    public List<Tasking> listAll();

    public Tasking getByWorkitem(String workitemId);

    public Tasking getByFormInstanceId(Long formInstanceId);
}
