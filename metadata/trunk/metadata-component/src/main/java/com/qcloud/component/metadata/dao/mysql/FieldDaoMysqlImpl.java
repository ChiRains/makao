package com.qcloud.component.metadata.dao.mysql;
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
import com.qcloud.component.metadata.dao.FieldDao;
import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.model.query.FieldQuery;
@Repository
public class FieldDaoMysqlImpl implements FieldDao {
    @Resource(name = "sqlOperator-metadata")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Field field) {
        return sqlOperator.insert("com.qcloud.component.metadata.dao.mysql.mapper.FieldMapper.insert", field) == 1;
    }

    @Override
    public Field get(Long id) {
        return sqlOperator.selectOne("com.qcloud.component.metadata.dao.mysql.mapper.FieldMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {
        return sqlOperator.delete("com.qcloud.component.metadata.dao.mysql.mapper.FieldMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Field field) {
        return sqlOperator.update("com.qcloud.component.metadata.dao.mysql.mapper.FieldMapper.update", field) > 0;
    }

    @Override
    public List<Field> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Field> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<Field> page(int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Field> list = sqlOperator.selectList("com.qcloud.component.metadata.dao.mysql.mapper.FieldMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.metadata.dao.mysql.mapper.FieldMapper.count4page", param);
        Page<Field> page = new Page<Field>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Field> page(FieldQuery query, int start, int count) {
        Map<String, Object> param = BeanUtils.transBean2Map(query);
        param.put("start", start);
        param.put("count", count);
        List<Field> list = sqlOperator.selectList("com.qcloud.component.metadata.dao.mysql.mapper.FieldMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.metadata.dao.mysql.mapper.FieldMapper.count4query", param);
        Page<Field> page = new Page<Field>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Field> listAll() {
        List<Field> list = sqlOperator.selectList("com.qcloud.component.metadata.dao.mysql.mapper.FieldMapper.listAll");
        return list;
    }

    @Override
    public List<Field> listAll(FieldQuery query) {
        List<Field> list = sqlOperator.selectList("com.qcloud.component.metadata.dao.mysql.mapper.FieldMapper.list4query2", BeanUtils.transBean2Map(query));
        return list;
    }

    @Override
    public List<Field> listByTable(Long tableId) {
        List<Field> list = sqlOperator.selectList("com.qcloud.component.metadata.dao.mysql.mapper.FieldMapper.listByTable", tableId);
        return list;
    }

    @Override
    public List<Field> listByMap(Map<String, Object> map) {
        List<Field> list = sqlOperator.selectList("com.qcloud.component.metadata.dao.mysql.mapper.FieldMapper.listByMap", map);
        return list;
    }
}
