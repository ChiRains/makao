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
import com.qcloud.project.macaovehicle.dao.HistoryRecordsDao;
import com.qcloud.project.macaovehicle.model.HistoryRecords;
import com.qcloud.project.macaovehicle.model.query.HistoryRecordsQuery;

@Repository
public class HistoryRecordsDaoMysqlImpl implements HistoryRecordsDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(HistoryRecords historyRecords) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryRecordsMapper.insert", historyRecords) == 1;
    }

    @Override
    public HistoryRecords get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryRecordsMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryRecordsMapper.delete", id) > 0;
    }

    @Override
    public boolean update(HistoryRecords historyRecords) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryRecordsMapper.update", historyRecords) > 0;
    }

    @Override
    public List<HistoryRecords> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, HistoryRecords> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<HistoryRecords> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<HistoryRecords> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryRecordsMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryRecordsMapper.count4page", param);
        Page<HistoryRecords> page = new Page<HistoryRecords>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<HistoryRecords> page(HistoryRecordsQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("type", query.getType());
        List<HistoryRecords> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryRecordsMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryRecordsMapper.count4query", param);
        Page<HistoryRecords> page = new Page<HistoryRecords>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<HistoryRecords> listAll() {

        List<HistoryRecords> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryRecordsMapper.listAll");
        return list;
    }
}
