package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.query.ApprovalResultsQuery;

public interface ApprovalResultsDao extends ISimpleDao<ApprovalResults, Long> {

    public boolean add(ApprovalResults approvalResults);

    public ApprovalResults get(Long id);

    public boolean delete(Long id);

    public boolean update(ApprovalResults approvalResults);

    public List<ApprovalResults> list(List<Long> idList);

    public Map<Long, ApprovalResults> map(Set<Long> idSet);

    public Page<ApprovalResults> page(ApprovalResultsQuery query, int start, int size);

    public List<ApprovalResults> listAll();

    public boolean updateResultState(Long id, int state);

    public ApprovalResults getResultByCardNumber(String cardNumber, int type);

    public ApprovalResults getResultByAppointmentNumber(String appointmentNumber);

    public List<ApprovalResults> listByState(int state);

    public List<ApprovalResults> getListByFormInstanceId(Long formInstanceId);

    public List<ApprovalResults> getListByFormInstCode(String formInstCode);
}
