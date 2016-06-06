package com.qcloud.component.form.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.model.query.FormDefQuery;

public interface FormDefService {

    public boolean add(FormDef formDef);

    public boolean addNotionFormDef(FormDef formDef);

    public FormDef get(Long id);

    public boolean delete(Long id);

    public boolean update(FormDef formDef);

    public Page<FormDef> page(FormDefQuery query, int start, int count);

    public List<FormDef> listAll();

    public List<FormDef> listAll(FormDefQuery query);

    List<FormDef> listChildren(Long id);
}
