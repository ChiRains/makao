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
import com.qcloud.component.form.dao.FormInstanceCodeNumberDao;
import com.qcloud.component.form.model.FormInstanceCodeNumber;
import com.qcloud.component.form.model.query.FormInstanceCodeNumberQuery;

@Repository
public class FormInstanceCodeNumberDaoMysqlImpl implements FormInstanceCodeNumberDao {

    @Resource(name = "sqlOperator-form")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(FormInstanceCodeNumber formInstanceCodeNumber) {

        return sqlOperator.insert("com.qcloud.component.form.dao.mysql.mapper.FormInstanceCodeNumberMapper.insert", formInstanceCodeNumber) == 1;
    }

    @Override
    public FormInstanceCodeNumber get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormInstanceCodeNumberMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.form.dao.mysql.mapper.FormInstanceCodeNumberMapper.delete", id) > 0;
    }

    @Override
    public boolean update(FormInstanceCodeNumber formInstanceCodeNumber) {

        return sqlOperator.update("com.qcloud.component.form.dao.mysql.mapper.FormInstanceCodeNumberMapper.update", formInstanceCodeNumber) > 0;
    }

    @Override
    public List<FormInstanceCodeNumber> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, FormInstanceCodeNumber> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<FormInstanceCodeNumber> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<FormInstanceCodeNumber> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormInstanceCodeNumberMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormInstanceCodeNumberMapper.count4page", param);
        Page<FormInstanceCodeNumber> page = new Page<FormInstanceCodeNumber>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<FormInstanceCodeNumber> page(FormInstanceCodeNumberQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<FormInstanceCodeNumber> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormInstanceCodeNumberMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormInstanceCodeNumberMapper.count4query", param);
        Page<FormInstanceCodeNumber> page = new Page<FormInstanceCodeNumber>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<FormInstanceCodeNumber> listAll() {

        List<FormInstanceCodeNumber> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormInstanceCodeNumberMapper.listAll");
        return list;
    }

    @Override
    public FormInstanceCodeNumber getByCode(String code) {

        return sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormInstanceCodeNumberMapper.getByCode", code);
    }

    @Override
    public boolean incr(Long id, long number) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        param.put("number", number);
        return sqlOperator.update("com.qcloud.component.form.dao.mysql.mapper.FormInstanceCodeNumberMapper.incr", param) > 0;
    }
}
