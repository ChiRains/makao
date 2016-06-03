package com.qcloud.component.processtask.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.processtask.model.Tasking;
import com.qcloud.component.processtask.model.query.TaskingQuery;

public interface TaskingService {

    public boolean add(Tasking tasking);

    public Tasking get(Long id);

    public Tasking getByWorkitem(String workitemId);

    public boolean delete(Long id);

    public boolean update(Tasking tasking);

    // type 0所有 1我申请的 2我审批的
    public Page<Tasking> page(TaskingQuery query, int myApply, int start, int count);

    public List<Tasking> listAll();

    public List<Tasking> getNextExecutor(Long formInstId);
}
