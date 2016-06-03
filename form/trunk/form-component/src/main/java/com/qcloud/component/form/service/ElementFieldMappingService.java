package com.qcloud.component.form.service;

import java.util.List;
import java.util.Map;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.model.ElementFieldMapping;
import com.qcloud.component.form.model.query.ElementFieldMappingQuery;

public interface ElementFieldMappingService {

    public boolean add(ElementFieldMapping elementFieldMapping);

    public ElementFieldMapping get(Long id);

    public boolean delete(Long id);

    public boolean update(ElementFieldMapping elementFieldMapping);

    public Page<ElementFieldMapping> page(ElementFieldMappingQuery query, int start, int count);

    public List<ElementFieldMapping> listAll();

    public List<ElementFieldMapping> listAll(Map<String, Object> map);

    public boolean delete(Map<String, Object> map);

    List<ElementFieldMapping> listByForm(Long formId);
}
