package com.qcloud.component.snakerext.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.model.ProcessGroupClerk;
import com.qcloud.component.snakerext.model.query.ProcessGroupClerkQuery;

public interface ProcessGroupClerkService {

    public boolean add(ProcessGroupClerk processGroupClerk);

    public ProcessGroupClerk get(Long id);

    public boolean delete(Long id);

    public boolean update(ProcessGroupClerk processGroupClerk);

    public Page<ProcessGroupClerk> page(ProcessGroupClerkQuery query, int start, int count);

    public List<ProcessGroupClerk> listAll();

    public List<ProcessGroupClerk> listByGroup(Long groupId);

    public boolean deleteByGroupId(Long groupId);
}
