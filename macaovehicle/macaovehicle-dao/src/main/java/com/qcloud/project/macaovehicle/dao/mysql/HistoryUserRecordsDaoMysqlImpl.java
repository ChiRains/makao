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
import com.qcloud.project.macaovehicle.dao.HistoryUserRecordsDao;
import com.qcloud.project.macaovehicle.model.HistoryUserRecords;
import com.qcloud.project.macaovehicle.model.query.HistoryUserRecordsQuery;

@Repository
public class HistoryUserRecordsDaoMysqlImpl implements HistoryUserRecordsDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(HistoryUserRecords historyUserRecords) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryUserRecordsMapper.insert", historyUserRecords) == 1;
    }

    @Override
    public HistoryUserRecords get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryUserRecordsMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryUserRecordsMapper.delete", id) > 0;
    }

    @Override
    public boolean update(HistoryUserRecords historyUserRecords) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryUserRecordsMapper.update", historyUserRecords) > 0;
    }

    @Override
    public List<HistoryUserRecords> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, HistoryUserRecords> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    public List<HistoryUserRecords> listByVehicleId(Long vehicleId) {

        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryUserRecordsMapper.listByVehicleId", vehicleId);
    }

    @Override
    public Page<HistoryUserRecords> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<HistoryUserRecords> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryUserRecordsMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryUserRecordsMapper.count4page", param);
        Page<HistoryUserRecords> page = new Page<HistoryUserRecords>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<HistoryUserRecords> page(HistoryUserRecordsQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("vehicleId", query.getVehicleId());
        List<HistoryUserRecords> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryUserRecordsMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryUserRecordsMapper.count4query", param);
        Page<HistoryUserRecords> page = new Page<HistoryUserRecords>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<HistoryUserRecords> listAll() {

        List<HistoryUserRecords> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryUserRecordsMapper.listAll");
        return list;
    }

    @Override
    public HistoryUserRecords getByFormInstCode(String formInstCode) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.HistoryUserRecordsMapper.getByFormInstCode", formInstCode);
    }
}
