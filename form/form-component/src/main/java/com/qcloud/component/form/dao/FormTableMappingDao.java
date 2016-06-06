package com.qcloud.component.form.dao;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.form.model.FormTableMapping;
import com.qcloud.component.form.model.query.FormTableMappingQuery;
public interface FormTableMappingDao extends ISimpleDao<FormTableMapping, Long> {
    public boolean add(FormTableMapping formTableMapping);

    public FormTableMapping get(Long id);

    public boolean delete(Long id);

    public boolean update(FormTableMapping formTableMapping);

    public List<FormTableMapping> list(List<Long> idList);

    public Map<Long, FormTableMapping> map(Set<Long> idSet);

    public Page<FormTableMapping> page(FormTableMappingQuery query, int start, int size);

    public List<FormTableMapping> listAll();

    public List<FormTableMapping> listAll(Map<String, Object> map);

    public boolean delete(Map<String, Object> map);
    
    FormTableMapping getByForm(Long formId);
}
