package com.qcloud.component.form.dao;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.model.query.FormDefQuery;
public interface FormDefDao extends ISimpleDao<FormDef, Long> {
    public boolean add(FormDef formDef);

    public FormDef get(Long id);

    public boolean delete(Long id);

    public boolean update(FormDef formDef);

    public List<FormDef> list(List<Long> idList);

    public Map<Long, FormDef> map(Set<Long> idSet);

    public Page<FormDef> page(FormDefQuery query, int start, int size);

    public List<FormDef> listAll();

    public List<FormDef> listAll(FormDefQuery query);
    
    List<FormDef> listChildren(Long id);
}
