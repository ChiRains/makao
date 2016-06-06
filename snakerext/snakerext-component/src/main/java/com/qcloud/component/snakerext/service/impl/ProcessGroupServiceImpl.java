package com.qcloud.component.snakerext.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.component.snakerext.dao.ProcessGroupDao;
import com.qcloud.component.snakerext.model.ProcessGroup;
import com.qcloud.component.snakerext.service.ProcessGroupService;
import com.qcloud.component.snakerext.model.query.ProcessGroupQuery;

@Service
public class ProcessGroupServiceImpl implements ProcessGroupService {

    @Autowired
    private ProcessGroupDao     processGroupDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "snaker_ext_process_group";

    @Override
    public boolean add(ProcessGroup processGroup) {
        ProcessGroup temp=getByName(processGroup.getName());
        AssertUtil.assertTrue(temp==null, "名称不能重复."+processGroup.getName());
        long id = autoIdGenerator.get(ID_KEY);
        processGroup.setId(id);
        return processGroupDao.add(processGroup);
    }

    @Override
    public ProcessGroup get(Long id) {

        return processGroupDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return processGroupDao.delete(id);
    }

    @Override
    public boolean update(ProcessGroup processGroup) {
        ProcessGroup temp=getByName(processGroup.getName());
        AssertUtil.assertTrue(temp==null, "名称不能重复."+processGroup.getName());
        return processGroupDao.update(processGroup);
    }

    @Override
    public Page<ProcessGroup> page(ProcessGroupQuery query, int start, int count) {

        return processGroupDao.page(query, start, count);
    }

    public List<ProcessGroup> listAll() {

        return processGroupDao.listAll();
    }

    @Override
    public List<ProcessGroup> listByName(String name) {

        return processGroupDao.listByName(name);
    }

    @Override
    public ProcessGroup getByName(String name) {

        return processGroupDao.getByName(name);
    }
}
