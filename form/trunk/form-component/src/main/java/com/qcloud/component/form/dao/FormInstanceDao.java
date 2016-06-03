package com.qcloud.component.form.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.form.model.FormInstance;
import com.qcloud.component.form.model.query.FormInstanceQuery;

public interface FormInstanceDao extends ISimpleDao<FormInstance, Long> {

    public boolean add(FormInstance formInstance);

    public FormInstance get(Long id);

    public boolean delete(Long id);

    public boolean update(FormInstance formInstance);

    public List<FormInstance> list(List<Long> idList);

    public Map<Long, FormInstance> map(Set<Long> idSet);

    public Page<FormInstance> page(FormInstanceQuery query, int start, int size);

    public List<FormInstance> listAll();

    public FormInstance getByCode(String code);
}
