package com.qcloud.component.snakerext.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.model.ProcessGroup;
import com.qcloud.component.snakerext.model.query.ProcessGroupQuery;

public interface ProcessGroupService {

    public boolean add(ProcessGroup processGroup);

    public ProcessGroup get(Long id);

    public boolean delete(Long id);

    public boolean update(ProcessGroup processGroup);

    public Page<ProcessGroup> page(ProcessGroupQuery query, int start, int count);

    public List<ProcessGroup> listAll();

    public List<ProcessGroup> listByName(String name);
    
    public ProcessGroup getByName(String name);
}
