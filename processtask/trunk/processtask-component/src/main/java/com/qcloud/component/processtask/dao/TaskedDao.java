package com.qcloud.component.processtask.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.processtask.model.Tasked;
import com.qcloud.component.processtask.model.query.TaskedQuery;

public interface TaskedDao extends ISimpleDao<Tasked, Long> {

    public boolean add(Tasked tasked);

    public Tasked get(Long id);

    Tasked getByWorkitem(String workitemId);

    public boolean delete(Long id);

    public boolean update(Tasked tasked);

    public List<Tasked> list(List<Long> idList);

    public Map<Long, Tasked> map(Set<Long> idSet);

    public Page<Tasked> page(TaskedQuery query, int myApply, int start, int size);

    public List<Tasked> listAll();

    List<Tasked> listTaskedByProcessInst(String processInstId);
}
