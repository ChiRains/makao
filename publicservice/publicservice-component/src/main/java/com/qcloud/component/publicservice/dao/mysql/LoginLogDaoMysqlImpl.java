package com.qcloud.component.publicservice.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.publicservice.dao.LoginLogDao;
import com.qcloud.component.publicservice.model.LoginLog;
import com.qcloud.component.publicservice.model.query.LoginLogQuery;

@Repository
public class LoginLogDaoMysqlImpl implements LoginLogDao {

    @Resource(name = "sqlOperator-publicservice")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(LoginLog loginLog) {

        return sqlOperator.insert("com.qcloud.component.publicservice.dao.mysql.mapper.LoginLogMapper.insert", loginLog) == 1;
    }

    @Override
    public LoginLog get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.publicservice.dao.mysql.mapper.LoginLogMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.publicservice.dao.mysql.mapper.LoginLogMapper.delete", id) > 0;
    }

    @Override
    public boolean update(LoginLog loginLog) {

        return sqlOperator.update("com.qcloud.component.publicservice.dao.mysql.mapper.LoginLogMapper.update", loginLog) > 0;
    }

    @Override
    public List<LoginLog> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, LoginLog> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<LoginLog> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<LoginLog> list = sqlOperator.selectList("com.qcloud.component.publicservice.dao.mysql.mapper.LoginLogMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicservice.dao.mysql.mapper.LoginLogMapper.count4page", param);
        Page<LoginLog> page = new Page<LoginLog>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<LoginLog> page(LoginLogQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<LoginLog> list = sqlOperator.selectList("com.qcloud.component.publicservice.dao.mysql.mapper.LoginLogMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicservice.dao.mysql.mapper.LoginLogMapper.count4query", param);
        Page<LoginLog> page = new Page<LoginLog>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<LoginLog> listAll() {

        List<LoginLog> list = sqlOperator.selectList("com.qcloud.component.publicservice.dao.mysql.mapper.LoginLogMapper.listAll");
        return list;
    }

    @Override
    public List<LoginLog> list(long consumerId, int consumerType, int operate) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("consumerId", consumerId);
        param.put("consumerType", consumerType);
        param.put("operate", operate);
        List<LoginLog> list = sqlOperator.selectList("com.qcloud.component.publicservice.dao.mysql.mapper.LoginLogMapper.list", param);
        return list;
    }
}
