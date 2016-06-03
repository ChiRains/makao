package com.qcloud.component.form.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.form.model.ElementFieldMapping;
import com.qcloud.component.form.model.query.ElementFieldMappingQuery;

public interface ElementFieldMappingDao extends ISimpleDao<ElementFieldMapping, Long> {

    public boolean add(ElementFieldMapping elementFieldMapping);

    public ElementFieldMapping get(Long id);

    public boolean delete(Long id);

    public boolean update(ElementFieldMapping elementFieldMapping);

    public List<ElementFieldMapping> list(List<Long> idList);

    public Map<Long, ElementFieldMapping> map(Set<Long> idSet);

    public Page<ElementFieldMapping> page(ElementFieldMappingQuery query, int start, int size);

    public List<ElementFieldMapping> listAll();

    public List<ElementFieldMapping> listAll(Map<String, Object> map);

    public boolean delete(Map<String, Object> map);

    ElementFieldMapping getByElement(long elementId);

    List<ElementFieldMapping> listByForm(long formId);
}
