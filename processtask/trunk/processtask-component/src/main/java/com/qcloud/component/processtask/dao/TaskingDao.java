package com.qcloud.component.processtask.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.processtask.model.Tasking;
import com.qcloud.component.processtask.model.query.TaskingQuery;

public interface TaskingDao extends ISimpleDao<Tasking, Long> {

    public boolean add(Tasking tasking);

    public Tasking get(Long id);

    Tasking getByWorkitem(String workitemId);

    public boolean delete(Long id);

    public boolean update(Tasking tasking);

    public List<Tasking> list(List<Long> idList);

    public Map<Long, Tasking> map(Set<Long> idSet);

    public Page<Tasking> page(TaskingQuery query, int myApply, int start, int size);

    public List<Tasking> listAll();

    public List<Tasking> getNextExecutor(Long formInstId);
}
