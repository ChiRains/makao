package com.qcloud.component.form.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.core.reflect.BeanUtils;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.form.dao.ElementDefDao;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.query.ElementDefQuery;

@Repository
public class ElementDefDaoMysqlImpl implements ElementDefDao {

    @Resource(name = "sqlOperator-form")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(ElementDef elementDef) {

        return sqlOperator.insert("com.qcloud.component.form.dao.mysql.mapper.ElementDefMapper.insert", elementDef) == 1;
    }

    @Override
    public ElementDef get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.ElementDefMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.form.dao.mysql.mapper.ElementDefMapper.delete", id) > 0;
    }

    @Override
    public boolean update(ElementDef elementDef) {

        return sqlOperator.update("com.qcloud.component.form.dao.mysql.mapper.ElementDefMapper.update", elementDef) > 0;
    }

    @Override
    public List<ElementDef> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ElementDef> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ElementDef> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ElementDef> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.ElementDefMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.ElementDefMapper.count4page", param);
        Page<ElementDef> page = new Page<ElementDef>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<ElementDef> page(ElementDefQuery query, int start, int count) {

        Map<String, Object> param = BeanUtils.transBean2Map(query);
        param.put("start", start);
        param.put("count", count);
        List<ElementDef> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.ElementDefMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.ElementDefMapper.count4query", param);
        Page<ElementDef> page = new Page<ElementDef>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<ElementDef> listAll() {

        List<ElementDef> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.ElementDefMapper.listAll");
        return list;
    }

    @Override
    public List<ElementDef> listAll(Map<String, Object> map) {

        List<ElementDef> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.ElementDefMapper.list4query2", map);
        return list;
    }

    @Override
    public List<ElementDef> listByForm(Long formId) {

        List<ElementDef> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.ElementDefMapper.listByForm", formId);
        return list;
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return sqlOperator.delete("com.qcloud.component.form.dao.mysql.mapper.ElementDefMapper.deleteByMap", map) > 0;
    }
}
