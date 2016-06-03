package com.qcloud.project.macaovehicle.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.project.macaovehicle.dao.AbnormalDao;
import com.qcloud.project.macaovehicle.model.Abnormal;
import com.qcloud.project.macaovehicle.model.query.AbnormalQuery;

@Repository
public class AbnormalDaoRedisImpl implements AbnormalDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(Abnormal abnormal) {

        throw new NotImplementedException();
    }

    @Override
    public Abnormal get(Integer macaovehicleAbnormalId) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Integer macaovehicleAbnormalId) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(Abnormal abnormal) {

        throw new NotImplementedException();
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

        throw new NotImplementedException();
    }

    @Override
    public Page<Abnormal> page(AbnormalQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<Abnormal> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<Abnormal> list(AbnormalQuery query, int start, int size) {

        throw new NotImplementedException();
    }

    @Override
    public int count(AbnormalQuery query) {

        throw new NotImplementedException();
    }

    @Override
    public List<Abnormal> statisticRecord(int type, String startTime, String endTime) {

        throw new NotImplementedException();
    }
    @Override
    public int countToday() {
    	 throw new NotImplementedException();
    }
}
