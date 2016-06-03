package com.qcloud.component.publicdata.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.publicdata.dao.DataDictionaryDao;
import com.qcloud.component.publicdata.model.DataDictionary;
import com.qcloud.component.publicdata.model.query.DataDictionaryQuery;

@Repository
public class DataDictionaryDaoMysqlImpl implements DataDictionaryDao {

    @Resource(name = "sqlOperator-publicdata")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(DataDictionary dataDictionary) {

        return sqlOperator.insert("com.qcloud.component.publicdata.dao.mysql.mapper.DataDictionaryMapper.insert", dataDictionary) == 1;
    }

    @Override
    public DataDictionary get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.DataDictionaryMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.publicdata.dao.mysql.mapper.DataDictionaryMapper.delete", id) > 0;
    }

    @Override
    public boolean update(DataDictionary dataDictionary) {

        return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.DataDictionaryMapper.update", dataDictionary) > 0;
    }

    @Override
    public List<DataDictionary> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, DataDictionary> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DataDictionary> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<DataDictionary> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.DataDictionaryMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.DataDictionaryMapper.count4page", param);
        Page<DataDictionary> page = new Page<DataDictionary>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<DataDictionary> page(DataDictionaryQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("type", query.getType());
        param.put("value", query.getValue());
        List<DataDictionary> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.DataDictionaryMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.DataDictionaryMapper.count4query", param);
        Page<DataDictionary> page = new Page<DataDictionary>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<DataDictionary> listAll(String type) {

        List<DataDictionary> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.DataDictionaryMapper.listAll", type);
        return list;
    }

    @Override
    public DataDictionary getDataDictionaryByKey(String type, Long key) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", 0);
        param.put("count", 1);
        param.put("key", key);
        param.put("type", type);
        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.DataDictionaryMapper.getDataDictionaryByKey", param);
    }
}
