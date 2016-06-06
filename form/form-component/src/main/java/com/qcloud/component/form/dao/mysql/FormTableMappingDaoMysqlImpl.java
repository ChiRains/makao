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
import com.qcloud.component.form.dao.FormTableMappingDao;
import com.qcloud.component.form.model.FormTableMapping;
import com.qcloud.component.form.model.query.FormTableMappingQuery;
@Repository
public class FormTableMappingDaoMysqlImpl implements FormTableMappingDao {
    @Resource(name = "sqlOperator-form")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(FormTableMapping formTableMapping) {
        return sqlOperator.insert("com.qcloud.component.form.dao.mysql.mapper.FormTableMappingMapper.insert", formTableMapping) == 1;
    }

    @Override
    public FormTableMapping get(Long id) {
        return sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormTableMappingMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {
        return sqlOperator.delete("com.qcloud.component.form.dao.mysql.mapper.FormTableMappingMapper.delete", id) > 0;
    }

    @Override
    public boolean update(FormTableMapping formTableMapping) {
        return sqlOperator.update("com.qcloud.component.form.dao.mysql.mapper.FormTableMappingMapper.update", formTableMapping) > 0;
    }

    @Override
    public List<FormTableMapping> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, FormTableMapping> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<FormTableMapping> page(int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<FormTableMapping> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormTableMappingMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormTableMappingMapper.count4page", param);
        Page<FormTableMapping> page = new Page<FormTableMapping>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<FormTableMapping> page(FormTableMappingQuery query, int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<FormTableMapping> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormTableMappingMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormTableMappingMapper.count4query", param);
        Page<FormTableMapping> page = new Page<FormTableMapping>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<FormTableMapping> listAll() {
        List<FormTableMapping> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormTableMappingMapper.listAll");
        return list;
    }

    @Override
    public List<FormTableMapping> listAll(Map<String, Object> map) {
        List<FormTableMapping> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormTableMappingMapper.listAll2", map);
        return list;
    }

    @Override
    public boolean delete(Map<String, Object> map) {
        return sqlOperator.delete("com.qcloud.component.form.dao.mysql.mapper.FormTableMappingMapper.deleteByMap", map) > 0;
    }

    @Override
    public FormTableMapping getByForm(Long formId) {
        return sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormTableMappingMapper.getByForm", formId);
    }
}
