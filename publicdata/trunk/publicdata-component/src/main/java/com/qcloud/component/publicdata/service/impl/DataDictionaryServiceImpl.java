package com.qcloud.component.publicdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.DataDictionaryDao;
import com.qcloud.component.publicdata.model.DataDictionary;
import com.qcloud.component.publicdata.service.DataDictionaryService;
import com.qcloud.component.publicdata.model.query.DataDictionaryQuery;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Autowired
    private DataDictionaryDao   dataDictionaryDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "publicdata_data_dictionary";

    // private static final String KEY_KEY = "publicdata_data_dictionary_key";
    @Override
    public boolean add(DataDictionary dataDictionary) {

        long id = autoIdGenerator.get(ID_KEY);
        dataDictionary.setId(id);
        // dataDictionary.setKey(autoIdGenerator.get(KEY_KEY));
        return dataDictionaryDao.add(dataDictionary);
    }

    @Override
    public DataDictionary get(Long id) {

        return dataDictionaryDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return dataDictionaryDao.delete(id);
    }

    @Override
    public boolean update(DataDictionary dataDictionary) {

        return dataDictionaryDao.update(dataDictionary);
    }

    @Override
    public Page<DataDictionary> page(DataDictionaryQuery query, int start, int count) {

        return dataDictionaryDao.page(query, start, count);
    }

    @Override
    public List<DataDictionary> listAll(String type) {

        return dataDictionaryDao.listAll(type);
    }

    @Override
    public DataDictionary getDataDictionaryByKey(String type, Long key) {

        return dataDictionaryDao.getDataDictionaryByKey(type, key);
    }
}
