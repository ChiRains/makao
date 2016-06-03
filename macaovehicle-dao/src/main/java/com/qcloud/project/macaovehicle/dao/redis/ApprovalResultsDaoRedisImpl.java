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
import com.qcloud.project.macaovehicle.dao.ApprovalResultsDao;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.query.ApprovalResultsQuery;

@Repository
public class ApprovalResultsDaoRedisImpl implements ApprovalResultsDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(ApprovalResults approvalResults) {

        throw new NotImplementedException();
    }

    @Override
    public ApprovalResults get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(ApprovalResults approvalResults) {

        throw new NotImplementedException();
    }

    @Override
    public List<ApprovalResults> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ApprovalResults> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ApprovalResults> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ApprovalResults> page(ApprovalResultsQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<ApprovalResults> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public boolean updateResultState(Long id, int state) {

        throw new NotImplementedException();
    }

    @Override
    public ApprovalResults getResultByCardNumber(String cardNumber, int type) {

        throw new NotImplementedException();
    }

    @Override
    public ApprovalResults getResultByAppointmentNumber(String appointmentNumber) {

        throw new NotImplementedException();
    }

    @Override
    public List<ApprovalResults> listByState(int type) {

        throw new NotImplementedException();
    }

    @Override
    public List<ApprovalResults> getListByFormInstanceId(Long formInstanceId) {

        throw new NotImplementedException();
    }

    @Override
    public List<ApprovalResults> getListByFormInstCode(String formInstCode) {

        throw new NotImplementedException();
    }
}
