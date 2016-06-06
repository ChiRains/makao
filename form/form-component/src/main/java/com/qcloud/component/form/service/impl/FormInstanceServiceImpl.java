package com.qcloud.component.form.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.dao.FormInstanceDao;
import com.qcloud.component.form.model.FormInstance;
import com.qcloud.component.form.service.FormInstanceService;
import com.qcloud.component.form.model.query.FormInstanceQuery;

@Service
public class FormInstanceServiceImpl implements FormInstanceService {

    @Autowired
    private FormInstanceDao     formInstanceDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "form_form_instance";

    @Override
    public boolean add(FormInstance formInstance) {

        long id = autoIdGenerator.get(ID_KEY);
        formInstance.setId(id);
        return formInstanceDao.add(formInstance);
    }

    @Override
    public FormInstance get(Long id) {

        return formInstanceDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return formInstanceDao.delete(id);
    }

    @Override
    public boolean update(FormInstance formInstance) {

        return formInstanceDao.update(formInstance);
    }

    @Override
    public Page<FormInstance> page(FormInstanceQuery query, int start, int count) {

        return formInstanceDao.page(query, start, count);
    }

    public List<FormInstance> listAll() {

        return formInstanceDao.listAll();
    }

    @Override
    public FormInstance getByCode(String code) {

        return formInstanceDao.getByCode(code);
    }
}
