package com.qcloud.component.form.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.model.FormInstance;
import com.qcloud.component.form.model.query.FormInstanceQuery;

public interface FormInstanceService {

    public boolean add(FormInstance formInstance);

    public FormInstance get(Long id);

    public boolean delete(Long id);

    public boolean update(FormInstance formInstance);

    public Page<FormInstance> page(FormInstanceQuery query, int start, int count);

    public List<FormInstance> listAll();

    public FormInstance getByCode(String code);
}
