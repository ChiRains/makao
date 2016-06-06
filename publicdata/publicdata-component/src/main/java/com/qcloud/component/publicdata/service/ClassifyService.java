package com.qcloud.component.publicdata.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.model.Classify;
import com.qcloud.component.publicdata.model.query.ClassifyQuery;

public interface ClassifyService {

    public boolean add(Classify classify);

    public Classify get(Long id);

    public boolean delete(Long id);

    public boolean update(Classify classify);

    public Page<Classify> page(ClassifyQuery query, int start, int count);

    public List<Classify> listAll(long type);

    public boolean sort(Long id, int sort);

    public boolean enable(Long id, int enable);
    
    public boolean withoutDelete(Long id );
}
