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
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.project.macaovehicle.dao.IllegalCarRecordDao;
import com.qcloud.project.macaovehicle.model.IllegalCarRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalCarRecordQuery;

@Repository
public class IllegalCarRecordDaoMysqlImpl implements IllegalCarRecordDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(IllegalCarRecord illegalCarRecord) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalCarRecordMapper.insert", illegalCarRecord) == 1;
    }

    @Override
    public IllegalCarRecord get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalCarRecordMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalCarRecordMapper.delete", id) > 0;
    }

    @Override
    public boolean update(IllegalCarRecord illegalCarRecord) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalCarRecordMapper.update", illegalCarRecord) > 0;
    }

    @Override
    public List<IllegalCarRecord> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, IllegalCarRecord> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<IllegalCarRecord> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<IllegalCarRecord> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalCarRecordMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalCarRecordMapper.count4page", param);
        Page<IllegalCarRecord> page = new Page<IllegalCarRecord>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<IllegalCarRecord> page(IllegalCarRecordQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("plateNumber", StringUtil.emptyToNull(query.getPlateNumber()));
        param.put("departmentId", query.getDepartmentId());
        List<IllegalCarRecord> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalCarRecordMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalCarRecordMapper.count4query", param);
        Page<IllegalCarRecord> page = new Page<IllegalCarRecord>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<IllegalCarRecord> listAll() {

        List<IllegalCarRecord> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalCarRecordMapper.listAll");
        return list;
    }
}
