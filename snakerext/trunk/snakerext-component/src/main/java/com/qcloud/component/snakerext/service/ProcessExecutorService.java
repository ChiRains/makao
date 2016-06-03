package com.qcloud.component.snakerext.service;

import java.util.List;
import java.util.Map;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Process;
import org.snaker.engine.entity.Task;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.snakerext.model.Executor;
import com.qcloud.component.snakerext.model.ProcessExecutor;
import com.qcloud.component.snakerext.model.query.ProcessExecutorQuery;
import com.qcloud.pirates.data.Page;

public interface ProcessExecutorService {

    public boolean add(ProcessExecutor processExecutor);

    public ProcessExecutor get(Long id);

    public boolean delete(Long id);

    public boolean update(ProcessExecutor processExecutor);

    public Page<ProcessExecutor> page(ProcessExecutorQuery query, int start, int count);

    public List<ProcessExecutor> listAll();

    public boolean delete(Map<String, Object> map);

    public List<ProcessExecutor> listByProcessIdAndTaskName(String processId, String taskName);

    List<Executor> list(Process process, Order order, Task task, QTask t, QClerk clerk);

    boolean isEndProcessActivity(Process process, Task task, QTask t);
}
