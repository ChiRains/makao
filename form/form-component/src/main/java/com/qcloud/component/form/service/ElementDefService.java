package com.qcloud.component.form.service;

import java.util.List;
import java.util.Map;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.model.query.ElementDefQuery;

public interface ElementDefService {

    public boolean add(ElementDef elementDef);

    public ElementDef get(Long id);

    public boolean delete(Long id);

    public boolean update(ElementDef elementDef);

    public Page<ElementDef> page(ElementDefQuery query, int start, int count);

    public List<ElementDef> listAll();

    public List<ElementDef> listAll(Map<String, Object> map);

    List<ElementDef> listByForm(Long formId);

    public boolean delete(Map<String, Object> map);

    boolean initNotionElements(FormDef formDef);
}
