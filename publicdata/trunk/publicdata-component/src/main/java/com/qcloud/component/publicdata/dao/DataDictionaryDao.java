package com.qcloud.component.publicdata.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.publicdata.model.DataDictionary;
import com.qcloud.component.publicdata.model.query.DataDictionaryQuery;

public interface DataDictionaryDao extends ISimpleDao<DataDictionary, Long> {

    public boolean add(DataDictionary dataDictionary);

    public DataDictionary get(Long id);

    public boolean delete(Long id);

    public boolean update(DataDictionary dataDictionary);

    public List<DataDictionary> list(List<Long> idList);

    public Map<Long, DataDictionary> map(Set<Long> idSet);

    public Page<DataDictionary> page(DataDictionaryQuery query, int start, int size);

    public List<DataDictionary> listAll(String type);

    public DataDictionary getDataDictionaryByKey(String type, Long key);
}
