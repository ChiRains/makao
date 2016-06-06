package com.qcloud.component.form.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.form.model.FormInstanceCodeNumber;
import com.qcloud.component.form.model.query.FormInstanceCodeNumberQuery;

public interface FormInstanceCodeNumberDao extends ISimpleDao<FormInstanceCodeNumber, Long> {

    public boolean add(FormInstanceCodeNumber formInstanceCodeNumber);

    public FormInstanceCodeNumber get(Long id);

    public FormInstanceCodeNumber getByCode(String code);

    public boolean incr(Long id, long number);

    public boolean delete(Long id);

    public boolean update(FormInstanceCodeNumber formInstanceCodeNumber);

    public List<FormInstanceCodeNumber> list(List<Long> idList);

    public Map<Long, FormInstanceCodeNumber> map(Set<Long> idSet);

    public Page<FormInstanceCodeNumber> page(FormInstanceCodeNumberQuery query, int start, int size);

    public List<FormInstanceCodeNumber> listAll();
}
