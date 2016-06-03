package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.project.macaovehicle.dao.ApplyVehicleNumberDao;
import com.qcloud.project.macaovehicle.dao.ApprovalResultsDao;
import com.qcloud.project.macaovehicle.dao.BookingVehicleNumberDao;
import com.qcloud.project.macaovehicle.dao.EportDao;
import com.qcloud.project.macaovehicle.dao.NoticeOnFailureKeepOnRecordDao;
import com.qcloud.project.macaovehicle.dao.TaskingBorderDao;
import com.qcloud.project.macaovehicle.dao.TaskingCiqDao;
import com.qcloud.project.macaovehicle.dao.TaskingCustomsDao;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.model.VehicleNetResult;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalResultState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.StatusType;
import com.qcloud.project.macaovehicle.service.ApprovalResultsService;
import com.qcloud.project.macaovehicle.service.ApprovalVehicleThirdPartyService;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;

@Service
public class ApprovalVehicleThirdPartyServiceImpl implements ApprovalVehicleThirdPartyService {

    private Log                    logger = LogFactory.getLog(getClass());

    @Autowired
    ApprovalResultsService         approvalResultsService;

    @Autowired
    ApplyVehicleNumberDao          applyVehicleNumberDao;

    @Autowired
    BookingVehicleNumberDao        bookingVehicleNumberDao;

    @Autowired
    NoticeOnFailureKeepOnRecordDao noticeOnFailureKeepOnRecordDao;

    @Autowired
    ApprovalResultsDao             approvalResultsDao;

    @Autowired
    TaskingBorderDao               taskingBorderDao;

    @Autowired
    TaskingCiqDao                  taskingCiqDao;

    @Autowired
    TaskingCustomsDao              taskingCustomsDao;

    @Autowired
    EportDao                       eportDao;

    @Autowired
    ProcessProgressService         processProgressService;

    @Override
    public boolean applyForCardNumber() {

        List<ApprovalResults> list = approvalResultsDao.listByState(ApprovalResultState.APPLY_SUCCESS.getKey());
        for (ApprovalResults approvalResults : list) {
            VehicleNetResult result = applyVehicleNumberDao.applyVehicleNumber(approvalResults);
            if (result != null && result.isSuccess()) {
                approvalResults.setState(ApprovalResultState.APPLY_FOR_CARDNUMBER.getKey());
                approvalResultsService.update(approvalResults);
            } else {
                // TODO: 失败记录日志
                logger.info("申请卡号 " + approvalResults.getAppointmentNumber() + " " + result.getErrorMsg());
            }
            logger.info("申请卡号 " + approvalResults.getAppointmentNumber() + " " + result);
        }
        return true;
    }

    @Override
    public boolean keepOnRecord() {

        // 已取司机卡、车卡id,三家单位确认备案
        List<ApprovalResults> list = approvalResultsService.listByState(ApprovalResultState.RECORD_SUCCESS.getKey());
        for (ApprovalResults approvalResults : list) {
            try {
                // 等待10秒
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TaskingCiq taskingCiq = taskingCiqDao.getByFormInstanceId(approvalResults.getFormInstanceId());
            // 国检备案
            if (taskingCiq.getStatus() == StatusType.PASSED.getKey() && taskingCiq.getCiqStatus() != StatusType.PASSED.getKey()) {
                eportDao.ciqPost(approvalResults.getVehicleId(), approvalResults.getDriverId(), approvalResults.getFormInstCode());
            }
            // 海关备案
            eportDao.customsPost(approvalResults.getVehicleId(), approvalResults.getDriverId(), approvalResults.getFormInstCode());
        }
        logger.info("备案.");
        return true;
    }

    // private void ciqRecordPost() {
    //
    // List<ApprovalResults> ciqList = approvalResultsService.listByState(ApprovalResultState.TAKE_CARD.getKey());
    // for (ApprovalResults approvalResults : ciqList) {
    // TaskingCiq taskingCiq = taskingCiqDao.getByFormInstanceId(approvalResults.getFormInstanceId());
    // TaskingBorder taskingBorder = taskingBorderDao.getByFormInstanceId(approvalResults.getFormInstanceId());
    // AssertUtil.assertNotNull(taskingCiq, "国检备案信息不存在." + approvalResults.getFormInstanceId());
    // AssertUtil.assertNotNull(taskingBorder, "边检备案信息不存在." + approvalResults.getFormInstanceId());
    // if (taskingCiq.getStatus() == StatusType.PASSED.getKey() && taskingBorder.getBorderStatus() == StatusType.PASSED.getKey()) {
    // // 推国检数据到电子口岸
    // // TODO
    // eportDao.ciqPost(approvalResults.getVehicleId(), approvalResults.getDriverId(), approvalResults.getFormInstCode());
    // approvalResults.setState(ApprovalResultState.CIQ_RECORD.getKey());
    // approvalResultsService.update(approvalResults);
    // }
    // }
    // }
    //
    // private void customsRecordPost() {
    //
    // List<ApprovalResults> ciqList = approvalResultsService.listByState(ApprovalResultState.CIQ_RECORD.getKey());
    // for (ApprovalResults approvalResults : ciqList) {
    // TaskingCustoms taskingCustoms = taskingCustomsDao.getByFormInstanceId(approvalResults.getFormInstanceId());
    // TaskingBorder taskingBorder = taskingBorderDao.getByFormInstanceId(approvalResults.getFormInstanceId());
    // AssertUtil.assertNotNull(taskingCustoms, "海关备案信息不存在." + approvalResults.getFormInstanceId());
    // AssertUtil.assertNotNull(taskingBorder, "边检备案信息不存在." + approvalResults.getFormInstanceId());
    // if (taskingCustoms.getStatus() == StatusType.PASSED.getKey() && taskingBorder.getBorderStatus() == StatusType.PASSED.getKey()) {
    // // 推海关数据到电子口岸
    // // TODO
    // eportDao.ciqPost(approvalResults.getVehicleId(), approvalResults.getDriverId(), approvalResults.getFormInstCode());
    // approvalResults.setState(ApprovalResultState.CUSTOMS_RECORD.getKey());
    // approvalResultsService.update(approvalResults);
    // }
    // }
    // }
    //
    // private void borderRecordPost() {
    //
    // List<ApprovalResults> ciqList = approvalResultsService.listByState(ApprovalResultState.CUSTOMS_RECORD.getKey());
    // for (ApprovalResults approvalResults : ciqList) {
    // TaskingBorder taskingBorder = taskingBorderDao.getByFormInstanceId(approvalResults.getFormInstanceId());
    // if (taskingBorder.getStatus() == StatusType.PASSED.getKey()) {
    // if (taskingBorder.getBorderStatus() == StatusType.PASSED.getKey()) {
    // // 边检手动导出表格形式,不访问接口
    // approvalResults.setState(ApprovalResultState.RECORD_SUCCESS.getKey());
    // } else if (taskingBorder.getBorderStatus() == StatusType.REJECT.getKey()) {
    // approvalResults.setState(ApprovalResultState.RECORD_FAILED.getKey());
    // }
    // approvalResultsService.update(approvalResults);
    // }
    // }
    // }
    @Override
    public boolean bookingOnSuccessKeepOnRecord() {

        List<ApprovalResults> list = approvalResultsService.listByState(ApprovalResultState.RECORD_INPUT_SUCCESS.getKey());
        for (ApprovalResults approvalResults : list) {
            VehicleNetResult result = bookingVehicleNumberDao.booking(approvalResults);
            if (result != null && result.isSuccess()) {
                logger.info("备案成功,排期预约装卡   " + approvalResults.getAppointmentNumber() + " " + approvalResults.getCardNumber());
                approvalResults.setState(ApprovalResultState.APPOINTMENT.getKey());
                approvalResultsService.update(approvalResults);
                //
                processProgressService.changeState(approvalResults.getFormInstanceId(), ApplyType.PASS.getKey(), ProgressState.PQZK.getKey());
            } else {
                // TODO: 失败记录日志
                logger.info("备案失败,预约装卡 " + approvalResults.getAppointmentNumber() + " " + result.getErrorMsg());
            }
        }
        return true;
    }

    @Override
    public boolean noticeOnFailureKeepOnRecord() {

        List<ApprovalResults> list = approvalResultsService.listByState(ApprovalResultState.RECORD_FAILED.getKey());
        for (ApprovalResults approvalResults : list) {
            logger.info("备案失败,销卡   " + approvalResults.getAppointmentNumber() + " " + approvalResults.getCardNumber());
            VehicleNetResult result = noticeOnFailureKeepOnRecordDao.noticeOnFailureKeepOnRecord(approvalResults);
            if (result != null && result.isSuccess()) {
                approvalResults.setState(ApprovalResultState.CANCEL_SET_CARD.getKey());
                approvalResultsService.update(approvalResults);
                //
                processProgressService.changeState(approvalResults.getFormInstanceId(), ApplyType.REJECT.getKey(), ProgressState.PQZK.getKey());
            } else {
                // TODO: 失败记录日志
                logger.info("备案失败,销卡 " + approvalResults.getAppointmentNumber() + " " + result.getErrorMsg());
            }
        }
        return true;
    }
}
