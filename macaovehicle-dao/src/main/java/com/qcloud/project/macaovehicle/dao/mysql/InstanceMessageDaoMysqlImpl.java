package com.qcloud.project.macaovehicle.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.project.macaovehicle.dao.InstanceMessageDao;
import com.qcloud.project.macaovehicle.model.InstanceMessage;
import com.qcloud.project.macaovehicle.model.query.InstanceMessageQuery;

@Repository
public class InstanceMessageDaoMysqlImpl implements InstanceMessageDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(InstanceMessage instanceMessage) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.InstanceMessageMapper.insert", instanceMessage) == 1;
    }

    @Override
    public InstanceMessage get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.InstanceMessageMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.InstanceMessageMapper.delete", id) > 0;
    }

    @Override
    public boolean update(InstanceMessage instanceMessage) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.InstanceMessageMapper.update", instanceMessage) > 0;
    }

    @Override
    public List<InstanceMessage> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, InstanceMessage> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    public List<InstanceMessage> listByFormInstanceId(Long formInstanceId) {

        throw new NotImplementedException();
    }

    public List<InstanceMessage> listByMessageCerkId(Long messageCerkId) {

        throw new NotImplementedException();
    }

    @Override
    public Page<InstanceMessage> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<InstanceMessage> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.InstanceMessageMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.InstanceMessageMapper.count4page", param);
        Page<InstanceMessage> page = new Page<InstanceMessage>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<InstanceMessage> page(InstanceMessageQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("formInstanceId", query.getFormInstanceId());
        param.put("clerkId", query.getClerkId());
        List<InstanceMessage> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.InstanceMessageMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.InstanceMessageMapper.count4query", param);
        Page<InstanceMessage> page = new Page<InstanceMessage>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<InstanceMessage> listAll() {

        List<InstanceMessage> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.InstanceMessageMapper.listAll");
        return list;
    }
}
