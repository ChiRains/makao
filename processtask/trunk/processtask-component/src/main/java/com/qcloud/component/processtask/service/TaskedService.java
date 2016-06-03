package com.qcloud.component.processtask.service;

import java.util.List;
import com.qcloud.component.processtask.model.Tasked;
import com.qcloud.component.processtask.model.query.TaskedQuery;
import com.qcloud.pirates.data.Page;

public interface TaskedService {

    public boolean add(Tasked tasked);

    public Tasked get(Long id);

    public Tasked getByWorkitem(String workitemId);

    public boolean delete(Long id);

    public boolean update(Tasked tasked);

    // type 0所有 1我申请的审批中 2我申请的已完成 3我审批的
    public Page<Tasked> page(TaskedQuery query, int myApply, int start, int count);

    public List<Tasked> listAll();

    List<Tasked> listTaskedByProcessInst(String processInstId);
}
