package com.qcloud.component.form.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.query.ElementDefQuery;

public interface ElementDefDao extends ISimpleDao<ElementDef, Long> {

    public boolean add(ElementDef elementDef);

    public ElementDef get(Long id);

    public boolean delete(Long id);

    public boolean update(ElementDef elementDef);

    public List<ElementDef> list(List<Long> idList);

    public Map<Long, ElementDef> map(Set<Long> idSet);

    public Page<ElementDef> page(ElementDefQuery query, int start, int size);

    public List<ElementDef> listAll();

    public List<ElementDef> listAll(Map<String, Object> map);

    List<ElementDef> listByForm(Long formId);

    public boolean delete(Map<String, Object> map);
}
