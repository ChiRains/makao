package com.qcloud.component.snakerext.service;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.model.ProcessExecutorInterface;
import com.qcloud.component.snakerext.model.query.ProcessExecutorInterfaceQuery;
public interface ProcessExecutorInterfaceService {
    public boolean add(ProcessExecutorInterface processExecutorInterface);

    public ProcessExecutorInterface get(Long id);

    public boolean delete(Long id);

    public boolean update(ProcessExecutorInterface processExecutorInterface);

    public Page<ProcessExecutorInterface> page(ProcessExecutorInterfaceQuery query, int start, int count);

    public List<ProcessExecutorInterface> listAll();

    public List<ProcessExecutorInterface> listAll(Map<String, Object> map);
}
