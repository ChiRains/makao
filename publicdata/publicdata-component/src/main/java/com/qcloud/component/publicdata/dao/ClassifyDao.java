package com.qcloud.component.publicdata.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.publicdata.model.Classify;
import com.qcloud.component.publicdata.model.query.ClassifyQuery;

public interface ClassifyDao extends ISimpleDao<Classify, Long> {

    public boolean add(Classify classify);

    public Classify get(Long id);

    public boolean delete(Long id);

    public boolean update(Classify classify);

    public List<Classify> list(List<Long> idList);

    public Map<Long, Classify> map(Set<Long> idSet);

    public Page<Classify> page(ClassifyQuery query, int start, int size);

    public List<Classify> listAll(long type);

    public List<Classify> listChildren(long type, Long parentId);

    public List<Classify> listAllChildren(String bsid);

    Classify getByName(long type, String name);
    
    public boolean sort(Long id,int sort);
    
    public boolean enable (Long id,int enable);
    
    public List<Classify> listChildrenToSort(long type, Long parentId);
    
    public List<Classify> listAllChildrenToEnable(String bsid);
}
