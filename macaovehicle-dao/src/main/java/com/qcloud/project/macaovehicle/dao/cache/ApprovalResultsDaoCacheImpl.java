package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.ApprovalResultsDao;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.query.ApprovalResultsQuery;

@Repository
public class ApprovalResultsDaoCacheImpl implements ApprovalResultsDao {

    @Autowired
    private ApprovalResultsDao approvalResultsDaoMysqlImpl;

    @Autowired
    private ApprovalResultsDao approvalResultsDaoRedisImpl;

    @Override
    public boolean add(ApprovalResults approvalResults) {

        return approvalResultsDaoMysqlImpl.add(approvalResults);
    }

    @Override
    public ApprovalResults get(Long id) {

        return approvalResultsDaoMysqlImpl.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return approvalResultsDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(ApprovalResults approvalResults) {

        return approvalResultsDaoMysqlImpl.update(approvalResults);
    }

    @Override
    public List<ApprovalResults> list(List<Long> idList) {

        return CacheLoader.list(approvalResultsDaoRedisImpl, approvalResultsDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, ApprovalResults> map(Set<Long> idSet) {

        return CacheLoader.map(approvalResultsDaoRedisImpl, approvalResultsDaoMysqlImpl, idSet);
    }

    @Override
    public Page<ApprovalResults> page(int start, int count) {

        return approvalResultsDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<ApprovalResults> page(ApprovalResultsQuery query, int start, int count) {

        return approvalResultsDaoMysqlImpl.page(query, start, count);
    }

    public List<ApprovalResults> listAll() {

        return approvalResultsDaoMysqlImpl.listAll();
    }

    @Override
    public boolean updateResultState(Long id, int state) {

        return approvalResultsDaoMysqlImpl.updateResultState(id, state);
    }

    @Override
    public ApprovalResults getResultByCardNumber(String cardNumber, int type) {

        return approvalResultsDaoMysqlImpl.getResultByCardNumber(cardNumber, type);
    }

    @Override
    public ApprovalResults getResultByAppointmentNumber(String appointmentNumber) {

        return approvalResultsDaoMysqlImpl.getResultByAppointmentNumber(appointmentNumber);
    }

    @Override
    public List<ApprovalResults> listByState(int state) {

        return approvalResultsDaoMysqlImpl.listByState(state);
    }

    @Override
    public List<ApprovalResults> getListByFormInstanceId(Long formInstanceId) {

        return approvalResultsDaoMysqlImpl.getListByFormInstanceId(formInstanceId);
    }

    @Override
    public List<ApprovalResults> getListByFormInstCode(String formInstCode) {

        return approvalResultsDaoMysqlImpl.getListByFormInstCode(formInstCode);
    }
}
