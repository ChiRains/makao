package com.qcloud.component.mvprocesstask.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.component.mvprocesstask.model.Tasked;
import com.qcloud.component.mvprocesstask.model.query.TaskedQuery;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;

public interface TaskedDao extends ISimpleDao<Tasked, Long> {

    public boolean add(Tasked tasked);

    public Tasked get(Long id);

    public boolean delete(Long id);

    public boolean update(Tasked tasked);

    public List<Tasked> list(List<Long> idList);

    public Map<Long, Tasked> map(Set<Long> idSet);

    public Page<Tasked> page(TaskedQuery query, int start, int size);

    public List<Tasked> listAll();

    public Tasked getByWorkitem(String workitemId);

    public List<Tasked> listTaskedByProcessInst(String processInstId);

    public List<Tasked> listTaskedByFormInstanceId(Long formInstanceId);
}
