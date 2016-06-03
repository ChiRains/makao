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
import com.qcloud.project.macaovehicle.dao.ResultRecordsDao;
import com.qcloud.project.macaovehicle.model.ResultRecords;
import com.qcloud.project.macaovehicle.model.query.ResultRecordsQuery;

@Repository
public class ResultRecordsDaoMysqlImpl implements ResultRecordsDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(ResultRecords resultRecords) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.ResultRecordsMapper.insert", resultRecords) == 1;
    }

    @Override
    public ResultRecords get(Integer macaovehicleResultRecordsId) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ResultRecordsMapper.get", macaovehicleResultRecordsId);
    }

    @Override
    public boolean delete(Integer macaovehicleResultRecordsId) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.ResultRecordsMapper.delete", macaovehicleResultRecordsId) > 0;
    }

    @Override
    public boolean update(ResultRecords resultRecords) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.ResultRecordsMapper.update", resultRecords) > 0;
    }

    @Override
    public List<ResultRecords> list(List<Integer> macaovehicleResultRecordsIdList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Integer, ResultRecords> map(Set<Integer> macaovehicleResultRecordsIdSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ResultRecords> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ResultRecords> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ResultRecordsMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ResultRecordsMapper.count4page", param);
        Page<ResultRecords> page = new Page<ResultRecords>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<ResultRecords> page(ResultRecordsQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ResultRecords> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ResultRecordsMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ResultRecordsMapper.count4query", param);
        Page<ResultRecords> page = new Page<ResultRecords>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<ResultRecords> listAll() {

        List<ResultRecords> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ResultRecordsMapper.listAll");
        return list;
    }
}
