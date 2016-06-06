package com.qcloud.component.snakerext.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.component.snakerext.model.ProcessExecutor;
import com.qcloud.component.snakerext.model.query.ProcessExecutorQuery;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;

public interface ProcessExecutorDao extends ISimpleDao<ProcessExecutor, Long> {

    public boolean add(ProcessExecutor processExecutor);

    public ProcessExecutor get(Long id);

    public boolean delete(Long id);

    public boolean update(ProcessExecutor processExecutor);

    public List<ProcessExecutor> list(List<Long> idList);

    public Map<Long, ProcessExecutor> map(Set<Long> idSet);

    public Page<ProcessExecutor> page(ProcessExecutorQuery query, int start, int size);

    public List<ProcessExecutor> listAll();

    public boolean delete(Map<String, Object> map);

    public List<ProcessExecutor> listByProcessIdAndTaskName(String processId, String taskName);
}
