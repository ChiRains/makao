package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalResultState;
import com.qcloud.project.macaovehicle.model.query.ApprovalResultsQuery;

public interface ApprovalResultsService {

    public boolean add(ApprovalResults approvalResults);

    public ApprovalResults get(Long id);

    public boolean delete(Long id);

    public boolean update(ApprovalResults approvalResults);

    public Page<ApprovalResults> page(ApprovalResultsQuery query, int start, int count);

    public List<ApprovalResults> listAll();

    public boolean updateResultState(Long id, int state);

    public ApprovalResults getResultByCardNumber(String cardNumber, int type);

    public ApprovalResults getResultByAppointmentNumber(String appointmentNumber);

    public List<ApprovalResults> listByState(int type);

    public List<ApprovalResults> getListByFormInstanceId(Long formInstanceId);

    public boolean checkAllReceive(Long formInstanceId, ApprovalResultState approvalResultState);

    public List<ApprovalResults> getListByFormInstCode(String formInstCode);
}
