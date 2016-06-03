package com.qcloud.project.macaovehicle.dao.mysql;

import java.util.ArrayList;
import java.util.Date;
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
import com.qcloud.project.macaovehicle.dao.AbnormalDao;
import com.qcloud.project.macaovehicle.model.Abnormal;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.model.query.AbnormalQuery;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;

@Repository
public class AbnormalDaoMysqlImpl implements AbnormalDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Abnormal abnormal) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.AbnormalMapper.insert", abnormal) == 1;
    }

    @Override
    public Abnormal get(Integer macaovehicleAbnormalId) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.AbnormalMapper.get", macaovehicleAbnormalId);
    }

    @Override
    public boolean delete(Integer macaovehicleAbnormalId) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.AbnormalMapper.delete", macaovehicleAbnormalId) > 0;
    }

    @Override
    public boolean update(Abnormal abnormal) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.AbnormalMapper.update", abnormal) > 0;
    }

    @Override
    public List<Abnormal> list(List<Integer> macaovehicleAbnormalIdList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Integer, Abnormal> map(Set<Integer> macaovehicleAbnormalIdSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Abnormal> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Abnormal> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.AbnormalMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.AbnormalMapper.count4page", param);
        Page<Abnormal> page = new Page<Abnormal>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Abnormal> page(AbnormalQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("carCardId", StringUtil.emptyToNull(query.getCarCardId()));
        param.put("ocrPlate", StringUtil.emptyToNull(query.getPlateNumber()));
        List<Abnormal> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.AbnormalMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.AbnormalMapper.count4query", param);
        Page<Abnormal> page = new Page<Abnormal>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Abnormal> listAll() {

        List<Abnormal> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.AbnormalMapper.listAll");
        return list;
    }

    @Override
    public List<Abnormal> list(AbnormalQuery query, int start, int size) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", size);
        List<Abnormal> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.AbnormalMapper.list", param);
        return list;
    }

    @Override
    public int count(AbnormalQuery query) {

        Map<String, Object> param = new HashMap<String, Object>();
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.AbnormalMapper.count", param);
        return total;
    }

    @Override
    public List<Abnormal> statisticRecord(int type, String startTime, String endTime) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("type", type);
        param.put("startTime", startTime);
        param.put("endTime", endTime);
        List<Abnormal> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.AbnormalMapper.statisticRecord", param);
        return list;
    }

    @Override
    public int countToday() {

        Integer total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.AbnormalMapper.countToday");
        return total.intValue();
    }
}
