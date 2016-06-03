package com.qcloud.component.publicdata.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.component.publicdata.dao.ClassifyDao;
import com.qcloud.component.publicdata.model.Classify;
import com.qcloud.component.publicdata.model.query.ClassifyQuery;

@Repository
public class ClassifyDaoMysqlImpl implements ClassifyDao {

    @Resource(name = "sqlOperator-publicdata")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Classify classify) {

        return sqlOperator.insert("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.insert", classify) == 1;
    }

    @Override
    public Classify get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Classify classify) {

        return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.update", classify) > 0;
    }

    @Override
    public List<Classify> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Classify> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Classify> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Classify> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.count4page", param);
        Page<Classify> page = new Page<Classify>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Classify> page(ClassifyQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("type", query.getType());
        param.put("name", StringUtil.nullToEmpty(query.getName()));
        List<Classify> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.count4query", param);
        Page<Classify> page = new Page<Classify>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Classify> listAll(long type) {

        List<Classify> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.listAll", type);
        return list;
    }

    @Override
    public Classify getByName(long type, String name) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name", name);
        param.put("type", type);
        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.getByName", param);
    }

    @Override
    public List<Classify> listChildren(long type, Long parentId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("parentId", parentId);
        param.put("type", type);
        List<Classify> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.listChildren", param);
        return list;
    }

    @Override
    public List<Classify> listAllChildren(String bsid) {

        List<Classify> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.listAllChildren", bsid);
        return list;
    }

    @Override
    public boolean sort(Long id, int sort) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("sort", sort);
        param.put("id", id);
        return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.sort", param) > 0;
    }

    @Override
    public boolean enable(Long id, int enable) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("enable", enable);
        param.put("id", id);
        return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.enable", param) > 0;
    }

    @Override
    public List<Classify> listChildrenToSort(long type, Long parentId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("parentId", parentId);
        param.put("type", type);
        List<Classify> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.listChildrenToSort", param);
        return list;
    }

    @Override
    public List<Classify> listAllChildrenToEnable(String bsid) {

        List<Classify> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.ClassifyMapper.listAllChildrenToEnable", bsid);
        return list;
    }
}
