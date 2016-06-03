package com.qcloud.component.snakerext.dao;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.component.snakerext.model.ProcessExecutorInterface;
import com.qcloud.component.snakerext.model.query.ProcessExecutorInterfaceQuery;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
public interface ProcessExecutorInterfaceDao extends ISimpleDao<ProcessExecutorInterface, Long> {
    public boolean add(ProcessExecutorInterface processExecutorInterface);

    public ProcessExecutorInterface get(Long id);

    public boolean delete(Long id);

    public boolean update(ProcessExecutorInterface processExecutorInterface);

    public List<ProcessExecutorInterface> list(List<Long> idList);

    public Map<Long, ProcessExecutorInterface> map(Set<Long> idSet);

    public Page<ProcessExecutorInterface> page(ProcessExecutorInterfaceQuery query, int start, int size);

    public List<ProcessExecutorInterface> listAll();

    public List<ProcessExecutorInterface> listAll(Map<String, Object> map);
}
