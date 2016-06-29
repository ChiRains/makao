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
import com.qcloud.project.macaovehicle.dao.OnestopCarRecordDao;
import com.qcloud.project.macaovehicle.model.OnestopCarRecord;
import com.qcloud.project.macaovehicle.model.query.OnestopCarRecordQuery;

@Repository
public class OnestopCarRecordDaoMysqlImpl implements OnestopCarRecordDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(OnestopCarRecord onestopCarRecord) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.OnestopCarRecordMapper.insert", onestopCarRecord) == 1;
    }

    @Override
    public OnestopCarRecord get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.OnestopCarRecordMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.OnestopCarRecordMapper.delete", id) > 0;
    }

    @Override
    public boolean update(OnestopCarRecord onestopCarRecord) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.OnestopCarRecordMapper.update", onestopCarRecord) > 0;
    }

    @Override
    public List<OnestopCarRecord> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, OnestopCarRecord> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<OnestopCarRecord> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<OnestopCarRecord> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.OnestopCarRecordMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.OnestopCarRecordMapper.count4page", param);
        Page<OnestopCarRecord> page = new Page<OnestopCarRecord>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<OnestopCarRecord> page(OnestopCarRecordQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("dCardid", StringUtil.emptyToNull(query.getdCardid()));
        param.put("vCardid", StringUtil.emptyToNull(query.getvCardid()));
        param.put("type", query.getType());
        param.put("groupByStr", query.getGroupByStr());
        param.put("orderBy", StringUtil.emptyToNull(query.getOrderBy()));
        List<OnestopCarRecord> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.OnestopCarRecordMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.OnestopCarRecordMapper.count4query", param);
        Page<OnestopCarRecord> page = new Page<OnestopCarRecord>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<OnestopCarRecord> listAll() {

        List<OnestopCarRecord> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.OnestopCarRecordMapper.listAll");
        return list;
    }

    @Override
    public OnestopCarRecord getByMap(Map<String, Object> map) {

        map.put("start", 0);
        map.put("count", 1);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.OnestopCarRecordMapper.getByMap", map);
    }

    @Override
    public int getCountByMap(OnestopCarRecordQuery query) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("type", query.getType());
        param.put("date", StringUtil.emptyToNull(query.getDate()));
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.OnestopCarRecordMapper.getCountByMap", param);
    }

    @Override
    public List<OnestopCarRecord> listByQuery(OnestopCarRecordQuery query) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("type", query.getType());
        param.put("date", StringUtil.emptyToNull(query.getDate()));
        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.OnestopCarRecordMapper.listByQuery", param);
    }
}
