package com.qcloud.component.form.service;

import java.util.List;
import java.util.Map;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.model.FormTableMapping;
import com.qcloud.component.form.model.query.FormTableMappingQuery;

public interface FormTableMappingService {

    public boolean add(FormTableMapping formTableMapping);

    public FormTableMapping get(Long id);

    public boolean delete(Long id);

    public boolean update(FormTableMapping formTableMapping);

    public Page<FormTableMapping> page(FormTableMappingQuery query, int start, int count);

    public List<FormTableMapping> listAll();

    public List<FormTableMapping> listAll(Map<String, Object> map);

    public boolean delete(Map<String, Object> map);

    FormTableMapping getByForm(Long formId);
}
