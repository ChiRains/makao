package com.qcloud.component.mvprocesstask.service;

import java.util.List;
import com.qcloud.component.mvprocesstask.model.Tasked;
import com.qcloud.component.mvprocesstask.model.query.TaskedQuery;
import com.qcloud.pirates.data.Page;

public interface TaskedService {

    public boolean add(Tasked tasked);

    public Tasked get(Long id);

    public boolean delete(Long id);

    public boolean update(Tasked tasked);

    public Page<Tasked> page(TaskedQuery query, int start, int count);

    public List<Tasked> listAll();

    public Tasked getByWorkitem(String workitemId);

    public List<Tasked> listTaskedByProcessInst(String processInstId);

    public List<Tasked> listTaskedByFormInstanceId(Long formInstanceId);
}
