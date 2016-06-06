package com.qcloud.component.snakerext.service.impl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.dao.ProcessExecutorInterfaceDao;
import com.qcloud.component.snakerext.model.ProcessExecutorInterface;
import com.qcloud.component.snakerext.service.ProcessExecutorInterfaceService;
import com.qcloud.component.snakerext.model.query.ProcessExecutorInterfaceQuery;
@Service
public class ProcessExecutorInterfaceServiceImpl implements ProcessExecutorInterfaceService {
    @Autowired
    private ProcessExecutorInterfaceDao processExecutorInterfaceDao;
    @Autowired
    private AutoIdGenerator             autoIdGenerator;
    private static final String         ID_KEY = "snakerext_process_executor_interface";

    @Override
    public boolean add(ProcessExecutorInterface processExecutorInterface) {
        long id = autoIdGenerator.get(ID_KEY);
        processExecutorInterface.setId(id);
        return processExecutorInterfaceDao.add(processExecutorInterface);
    }

    @Override
    public ProcessExecutorInterface get(Long id) {
        return processExecutorInterfaceDao.get(id);
    }

    @Override
    public boolean delete(Long id) {
        return processExecutorInterfaceDao.delete(id);
    }

    @Override
    public boolean update(ProcessExecutorInterface processExecutorInterface) {
        return processExecutorInterfaceDao.update(processExecutorInterface);
    }

    @Override
    public Page<ProcessExecutorInterface> page(ProcessExecutorInterfaceQuery query, int start, int count) {
        return processExecutorInterfaceDao.page(query, start, count);
    }

    public List<ProcessExecutorInterface> listAll() {
        return processExecutorInterfaceDao.listAll();
    }

    @Override
    public List<ProcessExecutorInterface> listAll(Map<String, Object> map) {
        return processExecutorInterfaceDao.listAll(map);
    }
}
