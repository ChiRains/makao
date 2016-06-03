package com.qcloud.project.macaovehicle.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.project.macaovehicle.dao.ApprovalResultsDao;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.ResultRecords;
import com.qcloud.project.macaovehicle.model.key.TypeEnum;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalResultState;
import com.qcloud.project.macaovehicle.model.query.ApprovalResultsQuery;
import com.qcloud.project.macaovehicle.service.ApprovalResultsService;
import com.qcloud.project.macaovehicle.service.ResultRecordsService;

@Service
public class ApprovalResultsServiceImpl implements ApprovalResultsService {

    @Autowired
    private ApprovalResultsDao   approvalResultsDao;

    @Autowired
    private AutoIdGenerator      autoIdGenerator;

    @Autowired
    private ResultRecordsService resultRecordsService;

    private static final String  ID_KEY = "macaovehicle_approval_results";

    @Override
    public boolean add(ApprovalResults approvalResults) {

        long id = autoIdGenerator.get(ID_KEY);
        approvalResults.setId(id);
        approvalResults.setTime(new Date());
        approvalResults.setState(ApprovalResultState.APPLY_SUCCESS.getKey());
        return approvalResultsDao.add(approvalResults);
    }

    @Override
    public ApprovalResults get(Long id) {

        return approvalResultsDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return approvalResultsDao.delete(id);
    }

    @Override
    public boolean update(ApprovalResults approvalResults) {

        ApprovalResults ar = get(approvalResults.getId());
        AssertUtil.assertNotNull(ar, "记录不存在" + approvalResults.getId());
        ResultRecords resultRecords = new ResultRecords();
        resultRecords.setState(ar.getState());
        resultRecords.setNewState(approvalResults.getState());
        resultRecords.setResultsId(approvalResults.getId());
        resultRecords.setTime(new Date());
        resultRecordsService.add(resultRecords);
        return approvalResultsDao.update(approvalResults);
    }

    @Override
    public Page<ApprovalResults> page(ApprovalResultsQuery query, int start, int count) {

        return approvalResultsDao.page(query, start, count);
    }

    public List<ApprovalResults> listAll() {

        return approvalResultsDao.listAll();
    }

    @Override
    public boolean updateResultState(Long id, int state) {

        int sum = TypeEnum.STATE_CONSTANT + TypeEnum.RecordStateType.country.getKey() + TypeEnum.RecordStateType.border.getKey() + TypeEnum.RecordStateType.haikwan.getKey();
        if (state == sum) {
            state = TypeEnum.ApprovalResultState.RECORD_SUCCESS.getKey();
        }
        return approvalResultsDao.updateResultState(id, state);
    }

    @Override
    public ApprovalResults getResultByCardNumber(String cardNumber, int type) {

        return approvalResultsDao.getResultByCardNumber(cardNumber, type);
    }

    @Override
    public ApprovalResults getResultByAppointmentNumber(String appointmentNumber) {

        return approvalResultsDao.getResultByAppointmentNumber(appointmentNumber);
    }

    @Override
    public List<ApprovalResults> listByState(int type) {

        return approvalResultsDao.listByState(type);
    }

    @Override
    public List<ApprovalResults> getListByFormInstanceId(Long formInstanceId) {

        return approvalResultsDao.getListByFormInstanceId(formInstanceId);
    }

    @Override
    public boolean checkAllReceive(Long formInstanceId, ApprovalResultState approvalResultState) {

        boolean isOK = true;
        List<ApprovalResults> approvalResultsList = approvalResultsDao.getListByFormInstanceId(formInstanceId);
        for (ApprovalResults approvalResults : approvalResultsList) {
            if (approvalResults.getState() != approvalResultState.getKey()) {
                isOK = false;
            }
        }
        return isOK;
    }

    @Override
    public List<ApprovalResults> getListByFormInstCode(String formInstCode) {

        return approvalResultsDao.getListByFormInstCode(formInstCode);
    }
}
