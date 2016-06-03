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
import com.qcloud.component.form.dao.FormDefDao;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.model.query.FormDefQuery;
@Repository
public class FormDefDaoMysqlImpl implements FormDefDao {
    @Resource(name = "sqlOperator-form")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(FormDef formDef) {
        return sqlOperator.insert("com.qcloud.component.form.dao.mysql.mapper.FormDefMapper.insert", formDef) == 1;
    }

    @Override
    public FormDef get(Long id) {
        return sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormDefMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {
        return sqlOperator.delete("com.qcloud.component.form.dao.mysql.mapper.FormDefMapper.delete", id) > 0;
    }

    @Override
    public boolean update(FormDef formDef) {
        return sqlOperator.update("com.qcloud.component.form.dao.mysql.mapper.FormDefMapper.update", formDef) > 0;
    }

    @Override
    public List<FormDef> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, FormDef> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<FormDef> page(int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<FormDef> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormDefMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormDefMapper.count4page", param);
        Page<FormDef> page = new Page<FormDef>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<FormDef> page(FormDefQuery query, int start, int count) {
        Map<String, Object> param = BeanUtils.transBean2Map(query);
        param.put("start", start);
        param.put("count", count);
        List<FormDef> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormDefMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormDefMapper.count4query", param);
        Page<FormDef> page = new Page<FormDef>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<FormDef> listAll() {
        List<FormDef> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormDefMapper.listAll");
        return list;
    }

    @Override
    public List<FormDef> listAll(FormDefQuery query) {
        List<FormDef> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormDefMapper.listAllByMap", BeanUtils.transBean2Map(query));
        return list;
    }

    @Override
    public List<FormDef> listChildren(Long mainFormId) {
        List<FormDef> list = sqlOperator.selectList("com.qcloud.component.form.dao.mysql.mapper.FormDefMapper.listChildren", mainFormId);
        return list;
    }
}
