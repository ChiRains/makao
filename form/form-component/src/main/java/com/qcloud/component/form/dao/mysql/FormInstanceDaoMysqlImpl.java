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
import com.qcloud.component.form.dao.FormInstanceDao;
import com.qcloud.component.form.model.FormInstance;
import com.qcloud.component.form.model.query.FormInstanceQuery;

@Repository
public class FormInstanceDaoMysqlImpl implements FormInstanceDao {

    @Resource(name = "sqlOperator-form")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(FormInstance formInstance) {

        return sqlOperator.insert("com.qcloud.component.form.dao.mysql.mapper.FormInstanceMapper.insert", formInstance) == 1;
    }

    @Override
    public FormInstance get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormInstanceMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.form.dao.mysql.mapper.FormInstanceMapper.delete", id) > 0;
    }

    @Override
    public boolean update(FormInstance formInstance) {

        return sqlOperator.update("com.qcloud.component.form.dao.mysql.mapper.FormInstanceMapper.update", formInstance) > 0;
    }

    @Override
    public List<FormInstance> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, FormInstance> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<FormInstance> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<FormInstance> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormInstanceMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormInstanceMapper.count4page", param);
        Page<FormInstance> page = new Page<FormInstance>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<FormInstance> page(FormInstanceQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<FormInstance> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormInstanceMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormInstanceMapper.count4query", param);
        Page<FormInstance> page = new Page<FormInstance>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<FormInstance> listAll() {

        List<FormInstance> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormInstanceMapper.listAll");
        return list;
    }

    @Override
    public FormInstance getByCode(String code) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", 0);
        param.put("count", 1);
        param.put("code", code);
        return sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormInstanceMapper.getByCode", param);
    }
}
