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
import com.qcloud.component.publicdata.dao.PopularSearchesDao;
import com.qcloud.component.publicdata.model.PopularSearches;
import com.qcloud.component.publicdata.model.query.PopularSearchesQuery;

@Repository
public class PopularSearchesDaoMysqlImpl implements PopularSearchesDao {

    @Resource(name = "sqlOperator-publicdata")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(PopularSearches popularSearches) {

        return sqlOperator.insert("com.qcloud.component.publicdata.dao.mysql.mapper.PopularSearchesMapper.insert", popularSearches) == 1;
    }

    @Override
    public PopularSearches get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.PopularSearchesMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.publicdata.dao.mysql.mapper.PopularSearchesMapper.delete", id) > 0;
    }

    @Override
    public boolean update(PopularSearches popularSearches) {

        return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.PopularSearchesMapper.update", popularSearches) > 0;
    }

    @Override
    public List<PopularSearches> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, PopularSearches> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<PopularSearches> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<PopularSearches> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.PopularSearchesMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.PopularSearchesMapper.count4page", param);
        Page<PopularSearches> page = new Page<PopularSearches>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<PopularSearches> page(PopularSearchesQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<PopularSearches> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.PopularSearchesMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.PopularSearchesMapper.count4query", param);
        Page<PopularSearches> page = new Page<PopularSearches>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<PopularSearches> listAll() {

        List<PopularSearches> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.PopularSearchesMapper.listAll");
        return list;
    }

    @Override
    public List<PopularSearches> listTop(int type, int number) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("type", type);
        param.put("number", number);
        List<PopularSearches> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.PopularSearchesMapper.listTop", param);
        return list;
    }

    @Override
    public PopularSearches get(int type, String keywords) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("type", type);
        param.put("keywords", keywords);
        PopularSearches ps = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.PopularSearchesMapper.getByKeywords", param);
        return ps;
    }
}
