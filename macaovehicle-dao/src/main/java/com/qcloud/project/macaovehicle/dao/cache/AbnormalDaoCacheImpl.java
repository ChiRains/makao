package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.AbnormalDao;
import com.qcloud.project.macaovehicle.model.Abnormal;
import com.qcloud.project.macaovehicle.model.query.AbnormalQuery;

@Repository
public class AbnormalDaoCacheImpl implements AbnormalDao {

    @Autowired
    private AbnormalDao abnormalDaoMysqlImpl;

    @Autowired
    private AbnormalDao abnormalDaoRedisImpl;

    @Override
    public boolean add(Abnormal abnormal) {

        return abnormalDaoMysqlImpl.add(abnormal);
    }

    @Override
    public Abnormal get(Integer macaovehicleAbnormalId) {

        return abnormalDaoMysqlImpl.get(macaovehicleAbnormalId);
    }

    @Override
    public boolean delete(Integer macaovehicleAbnormalId) {

        return abnormalDaoMysqlImpl.delete(macaovehicleAbnormalId);
    }

    @Override
    public boolean update(Abnormal abnormal) {

        return abnormalDaoMysqlImpl.update(abnormal);
    }

    @Override
    public List<Abnormal> list(List<Integer> macaovehicleAbnormalIdList) {

        return CacheLoader.list(abnormalDaoRedisImpl, abnormalDaoMysqlImpl, macaovehicleAbnormalIdList);
    }

    @Override
    public Map<Integer, Abnormal> map(Set<Integer> macaovehicleAbnormalIdSet) {

        return CacheLoader.map(abnormalDaoRedisImpl, abnormalDaoMysqlImpl, macaovehicleAbnormalIdSet);
    }

    @Override
    public Page<Abnormal> page(int start, int count) {

        return abnormalDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<Abnormal> page(AbnormalQuery query, int start, int count) {

        return abnormalDaoMysqlImpl.page(query, start, count);
    }

    public List<Abnormal> listAll() {

        return abnormalDaoMysqlImpl.listAll();
    }

    @Override
    public List<Abnormal> list(AbnormalQuery query, int start, int size) {

        return abnormalDaoMysqlImpl.list(query, start, size);
    }

    @Override
    public int count(AbnormalQuery query) {

        return abnormalDaoMysqlImpl.count(query);
    }

    @Override
    public List<Abnormal> statisticRecord(int type, String startTime, String endTime) {

        return abnormalDaoMysqlImpl.statisticRecord(type, startTime, endTime);
    }
    
    @Override
    public int countToday() {
    	return abnormalDaoMysqlImpl.countToday();
    }
}
