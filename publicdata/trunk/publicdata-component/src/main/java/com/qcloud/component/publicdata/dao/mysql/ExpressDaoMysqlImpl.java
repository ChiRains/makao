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
import com.qcloud.component.publicdata.dao.ExpressDao;
import com.qcloud.component.publicdata.model.Express;
import com.qcloud.component.publicdata.model.query.ExpressQuery;

@Repository
public class ExpressDaoMysqlImpl implements ExpressDao {

    @Resource(name = "sqlOperator-publicdata")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Express express) {

        return sqlOperator.insert("com.qcloud.component.publicdata.dao.mysql.mapper.ExpressMapper.insert", express) == 1;
    }

    @Override
    public Express get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ExpressMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.publicdata.dao.mysql.mapper.ExpressMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Express express) {

        return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.ExpressMapper.update", express) > 0;
    }

    @Override
    public List<Express> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Express> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Express> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Express> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.ExpressMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ExpressMapper.count4page", param);
        Page<Express> page = new Page<Express>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Express> page(ExpressQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Express> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.ExpressMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ExpressMapper.count4query", param);
        Page<Express> page = new Page<Express>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Express> listAll() {

        List<Express> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.ExpressMapper.listAll");
        return list;
    }

    @Override
    public Express getByCode(String code) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("code", code);
        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ExpressMapper.getByCode", param);
    }
}
