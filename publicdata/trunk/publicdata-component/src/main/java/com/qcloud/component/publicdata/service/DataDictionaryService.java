package com.qcloud.component.publicdata.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.model.DataDictionary;
import com.qcloud.component.publicdata.model.query.DataDictionaryQuery;

public interface DataDictionaryService {

    public boolean add(DataDictionary dataDictionary);

    public DataDictionary get(Long id);

    public boolean delete(Long id);

    public boolean update(DataDictionary dataDictionary);

    public Page<DataDictionary> page(DataDictionaryQuery query, int start, int count);

    public List<DataDictionary> listAll(String type);

    public DataDictionary getDataDictionaryByKey(String type, Long key);
}
