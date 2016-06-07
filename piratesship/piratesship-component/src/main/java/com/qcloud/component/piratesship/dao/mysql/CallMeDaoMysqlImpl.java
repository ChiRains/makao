package com.qcloud.component.piratesship.dao.mysql;

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
import com.qcloud.component.piratesship.dao.CallMeDao;
import com.qcloud.component.piratesship.model.CallMe;
import com.qcloud.component.piratesship.model.query.CallMeQuery;

@Repository
public class CallMeDaoMysqlImpl implements CallMeDao {

    @Resource(name = "sqlOperator-piratesship")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(CallMe callMe) {

        return sqlOperator.insert("com.qcloud.component.piratesship.dao.mysql.mapper.CallMeMapper.insert", callMe) == 1;
    }

    @Override
    public CallMe get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.piratesship.dao.mysql.mapper.CallMeMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.piratesship.dao.mysql.mapper.CallMeMapper.delete", id) > 0;
    }

    @Override
    public boolean update(CallMe callMe) {

        return sqlOperator.update("com.qcloud.component.piratesship.dao.mysql.mapper.CallMeMapper.update", callMe) > 0;
    }

    @Override
    public List<CallMe> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, CallMe> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CallMe> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CallMe> list = sqlOperator.selectList("com.qcloud.component.piratesship.dao.mysql.mapper.CallMeMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.piratesship.dao.mysql.mapper.CallMeMapper.count4page", param);
        Page<CallMe> page = new Page<CallMe>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<CallMe> page(CallMeQuery query, int start, int count) {

        Map<String, Object> param = BeanUtils.transBean2Map(query);
        param.put("start", start);
        param.put("count", count);
        List<CallMe> list = sqlOperator.selectList("com.qcloud.component.piratesship.dao.mysql.mapper.CallMeMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.piratesship.dao.mysql.mapper.CallMeMapper.count4query", param);
        Page<CallMe> page = new Page<CallMe>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<CallMe> listAll() {

        List<CallMe> list = sqlOperator.selectList("com.qcloud.component.piratesship.dao.mysql.mapper.CallMeMapper.listAll");
        return list;
    }
}
