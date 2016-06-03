package com.qcloud.component.form.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.dao.FormTableMappingDao;
import com.qcloud.component.form.model.FormTableMapping;
import com.qcloud.component.form.service.FormTableMappingService;
import com.qcloud.component.form.model.query.FormTableMappingQuery;

@Service
public class FormTableMappingServiceImpl implements FormTableMappingService {

    @Autowired
    private FormTableMappingDao formTableMappingDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "form_form_table_mapping";

    @Override
    public boolean add(FormTableMapping formTableMapping) {

        long id = autoIdGenerator.get(ID_KEY);
        formTableMapping.setId(id);
        return formTableMappingDao.add(formTableMapping);
    }

    @Override
    public FormTableMapping get(Long id) {

        return formTableMappingDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return formTableMappingDao.delete(id);
    }

    @Override
    public boolean update(FormTableMapping formTableMapping) {

        return formTableMappingDao.update(formTableMapping);
    }

    @Override
    public Page<FormTableMapping> page(FormTableMappingQuery query, int start, int count) {

        return formTableMappingDao.page(query, start, count);
    }

    public List<FormTableMapping> listAll() {

        return formTableMappingDao.listAll();
    }

    @Override
    public List<FormTableMapping> listAll(Map<String, Object> map) {

        return formTableMappingDao.listAll(map);
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return formTableMappingDao.delete(map);
    }

    @Override
    public FormTableMapping getByForm(Long formId) {
        return formTableMappingDao.getByForm(formId);
    }
}
