package com.qcloud.component.form.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.form.dao.ElementFieldMappingDao;
import com.qcloud.component.form.model.ElementFieldMapping;
import com.qcloud.component.form.model.query.ElementFieldMappingQuery;

@Repository
public class ElementFieldMappingDaoMysqlImpl implements ElementFieldMappingDao {

    @Resource(name = "sqlOperator-form")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(ElementFieldMapping elementFieldMapping) {

        return sqlOperator.insert("com.qcloud.component.form.dao.mysql.mapper.ElementFieldMappingMapper.insert", elementFieldMapping) == 1;
    }

    @Override
    public ElementFieldMapping get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.ElementFieldMappingMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.form.dao.mysql.mapper.ElementFieldMappingMapper.delete", id) > 0;
    }

    @Override
    public boolean update(ElementFieldMapping elementFieldMapping) {

        return sqlOperator.update("com.qcloud.component.form.dao.mysql.mapper.ElementFieldMappingMapper.update", elementFieldMapping) > 0;
    }

    @Override
    public List<ElementFieldMapping> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ElementFieldMapping> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ElementFieldMapping> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ElementFieldMapping> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.ElementFieldMappingMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.ElementFieldMappingMapper.count4page", param);
        Page<ElementFieldMapping> page = new Page<ElementFieldMapping>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<ElementFieldMapping> page(ElementFieldMappingQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ElementFieldMapping> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.ElementFieldMappingMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.ElementFieldMappingMapper.count4query", param);
        Page<ElementFieldMapping> page = new Page<ElementFieldMapping>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<ElementFieldMapping> listAll() {

        List<ElementFieldMapping> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.ElementFieldMappingMapper.listAll");
        return list;
    }

    @Override
    public List<ElementFieldMapping> listAll(Map<String, Object> map) {

        List<ElementFieldMapping> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.ElementFieldMappingMapper.listAll2", map);
        return list;
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return sqlOperator.delete("com.qcloud.component.form.dao.mysql.mapper.ElementFieldMappingMapper.deleteByMap", map) > 0;
    }

    @Override
    public ElementFieldMapping getByElement(long elementId) {

        return sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.ElementFieldMappingMapper.getByElement", elementId);
    }

    @Override
    public List<ElementFieldMapping> listByForm(long formId) {

        throw new NotImplementedException();
    }
}
