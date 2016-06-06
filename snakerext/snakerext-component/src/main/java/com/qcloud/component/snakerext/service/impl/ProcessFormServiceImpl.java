package com.qcloud.component.snakerext.service.impl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.dao.ProcessFormDao;
import com.qcloud.component.snakerext.model.ProcessForm;
import com.qcloud.component.snakerext.service.ProcessFormService;
import com.qcloud.component.snakerext.model.query.ProcessFormQuery;
@Service
public class ProcessFormServiceImpl implements ProcessFormService {
    @Autowired
    private ProcessFormDao      processFormDao;
    @Autowired
    private AutoIdGenerator     autoIdGenerator;
    private static final String ID_KEY = "snakerext_process_form";

    @Override
    public boolean add(ProcessForm processForm) {
        long id = autoIdGenerator.get(ID_KEY);
        processForm.setId(id);
        return processFormDao.add(processForm);
    }

    @Override
    public ProcessForm get(Long id) {
        return processFormDao.get(id);
    }

    @Override
    public boolean delete(Long id) {
        return processFormDao.delete(id);
    }

    @Override
    public boolean update(ProcessForm processForm) {
        return processFormDao.update(processForm);
    }

    @Override
    public Page<ProcessForm> page(ProcessFormQuery query, int start, int count) {
        return processFormDao.page(query, start, count);
    }

    public List<ProcessForm> listAll() {
        return processFormDao.listAll();
    }

    @Override
    public List<ProcessForm> list(Map<String, Object> map) {
        return processFormDao.list(map);
    }
}
