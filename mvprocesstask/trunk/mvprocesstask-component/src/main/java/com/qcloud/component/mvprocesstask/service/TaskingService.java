package com.qcloud.component.mvprocesstask.service;

import java.util.List;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.mvprocesstask.model.query.TaskingQuery;
import com.qcloud.pirates.data.Page;

public interface TaskingService {

    public boolean add(Tasking tasking);

    public Tasking get(Long id);

    public boolean delete(Long id);

    public boolean update(Tasking tasking);

    public Page<Tasking> page(TaskingQuery query, int start, int count);

    public List<Tasking> listAll();

    public Tasking getByWorkitem(String workitemId);

    public Tasking getByFormInstanceId(Long formInstanceId);
}
