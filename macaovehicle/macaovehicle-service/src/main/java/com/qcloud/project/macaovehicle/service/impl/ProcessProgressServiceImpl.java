package com.qcloud.project.macaovehicle.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.organization.ClerkMessageType;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.project.macaovehicle.dao.ApprovalResultsDao;
import com.qcloud.project.macaovehicle.dao.CarOwnerDao;
import com.qcloud.project.macaovehicle.dao.DriverDao;
import com.qcloud.project.macaovehicle.dao.DriverVehicleDao;
import com.qcloud.project.macaovehicle.dao.HistoryUserRecordsDao;
import com.qcloud.project.macaovehicle.dao.ProcessProgressDao;
import com.qcloud.project.macaovehicle.dao.VehicleDao;
import com.qcloud.project.macaovehicle.entity.MessageEntity;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.HistoryUserRecords;
import com.qcloud.project.macaovehicle.model.InstanceMessage;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalResultState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.MessageType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.ProcessProgressQuery;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;
import com.qcloud.project.macaovehicle.service.HistoryUserRecordsService;
import com.qcloud.project.macaovehicle.service.InstanceMessageService;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;
import com.qcloud.project.macaovehicle.service.ProfilesSuccessService;

@Service
public class ProcessProgressServiceImpl implements ProcessProgressService {

    @Autowired
    private ProcessProgressDao        processProgressDao;

    @Autowired
    private AutoIdGenerator           autoIdGenerator;

    @Autowired
    private ApprovalResultsDao        approvalResultsDao;

    @Autowired
    private DriverVehicleDao          driverVehicleDao;

    @Autowired
    private ProfilesSuccessService    profilesSuccessService;

    @Autowired
    private OrganizationClient        organizationClient;

    @Autowired
    private ParameterClient           parameterClient;

    @Autowired
    private InstanceMessageService    instanceMessageService;

    @Autowired
    private VehicleDao                vehicleDao;

    @Autowired
    private DriverDao                 driverDao;

    @Autowired
    private CarOwnerDao               carOwnerDao;

    private static final String       ID_KEY = "macaovehicle_process_progress";

    @Autowired
    private HistoryUserRecordsService historyUserRecordsService;

    @Autowired
    private HistoryUserRecordsDao     historyUserRecordsDao;

    @Override
    public boolean add(ProcessProgress processProgress) {

        long id = autoIdGenerator.get(ID_KEY);
        processProgress.setId(id);
        processProgressDao.add(processProgress);
        // 历史办理业务
        HistoryUserRecords historyUserRecords = new HistoryUserRecords();
        historyUserRecords.setVehicleId(processProgress.getVehicleId());
        historyUserRecords.setType(processProgress.getType());
        historyUserRecords.setApplyTime(new Date());
        return historyUserRecordsService.add(historyUserRecords);
    }

    @Override
    public ProcessProgress get(Long id) {

        return processProgressDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return processProgressDao.delete(id);
    }

    @Override
    public boolean update(ProcessProgress processProgress) {

        // 历史办理业务完成时间添加
        if (processProgress.getProgressState() == ProgressState.WANCHENG.getKey()) {
            HistoryUserRecords historyUserRecords = historyUserRecordsDao.getByFormInstCode(processProgress.getFormInstCode());
            historyUserRecords.setFinishTime(new Date());
            historyUserRecordsDao.update(historyUserRecords);
        }
        return processProgressDao.update(processProgress);
    }

    @Override
    public Page<ProcessProgress> page(ProcessProgressQuery query, int start, int count) {

        return processProgressDao.page(query, start, count);
    }

    public List<ProcessProgress> listAll() {

        return processProgressDao.listAll();
    }

    @Override
    public List<ProcessProgress> listByCarOwnerId(Long carOwnerId, int start, int count) {

        return processProgressDao.listByCarOwnerId(carOwnerId, start, count);
    }

    @Override
    public List<ProcessProgress> listByCarOwnerId(Long carOwnerId) {

        return processProgressDao.listByCarOwnerId(carOwnerId);
    }
    
    @Override
    public ProcessProgress getMaxByFormInstCode(String formInstCode) {

        return processProgressDao.getMaxByFormInstCode(formInstCode);
    }

    @Override
    public ProcessProgress get(Long carOwnerId, Long formInstanceId, ProgressType progressType) {

        return processProgressDao.get(carOwnerId, formInstanceId, progressType);
    }

    @Override
    public List<ProcessProgress> listByQuery(ProcessProgressQuery query) {

        return processProgressDao.listByQuery(query);
    }

    @Override
    public ProcessProgress getByFormInstanceId(Long formInstanceId) {

        return processProgressDao.getByFormInstanceId(formInstanceId);
    }

    @Override
    public boolean changeState(Long formInstanceId, int applyType, int progressState) {

        ProcessProgress process = processProgressDao.getByFormInstanceId(formInstanceId);
        if (process.getProgressState() == ProgressState.WANCHENG.getKey()) return false;
        // ----入境申请----
        if (process.getType() == ProgressType.APPLY.getKey()) {
            // 备案成功
            if (progressState == ProgressState.BEIAN.getKey()) {
                List<ApprovalResults> approvalResultsList = approvalResultsDao.getListByFormInstanceId(formInstanceId);
                for (ApprovalResults approvalResults : approvalResultsList) {
                    approvalResults.setState(applyType == ApplyType.PASS.getKey() ? ApprovalResultState.RECORD_SUCCESS.getKey() : ApprovalResultState.RECORD_FAILED.getKey());
                    approvalResultsDao.update(approvalResults);
                }
            }
            // 申请成功
            if (progressState == ProgressState.WANCHENG.getKey()) {
                //
                List<DriverVehicle> driverVehiclelist = driverVehicleDao.getListByFormInstanceId(formInstanceId);
                if (driverVehiclelist.size() == 0) {
                    throw new MacaovehicleException("此流程无车辆和驾驶员数据." + formInstanceId);
                }
                // 由于一个流程只能有一辆车
                DriverVehicle driverVehicle = driverVehiclelist.get(0);
                Vehicle vehicle = vehicleDao.get(driverVehicle.getVehicleId());
                AssertUtil.assertNotNull(vehicle, "车辆不存在." + driverVehicle.getVehicleId());
                vehicle.setRic(driverVehicle.getRic());
                vehicle.setApproveTime(new Date());
                vehicle.setRicState(EnableType.ENABLE.getKey());
                vehicle.setTemState(EnableType.ENABLE.getKey());
                vehicleDao.update(vehicle);
                for (DriverVehicle dv : driverVehiclelist) {
                    if (dv.getState() == ProgressState.WANCHENG.getKey()) {
                        continue;
                    }
                    dv.setState(ProgressState.WANCHENG.getKey());
                    driverVehicleDao.update(dv);
                    // 入境车辆、驾驶员档案
                    ProfilesSuccessQuery query = new ProfilesSuccessQuery();
                    query.setDriverId(dv.getDriverId());
                    query.setVehicleId(dv.getVehicleId());
                    List<ProfilesSuccess> datas = profilesSuccessService.listByQuery(query);
                    ProfilesSuccess profilesSuccess = new ProfilesSuccess();
                    // 编辑或者新增
                    if (datas.size() > 0) {
                        profilesSuccess = datas.get(0);
                    } else {
                        profilesSuccess = new ProfilesSuccess();
                    }
                    profilesSuccess.setCarOwnerId(dv.getCarOwnerId());
                    profilesSuccess.setVehicleId(dv.getVehicleId());
                    profilesSuccess.setDriverId(dv.getDriverId());
                    profilesSuccess.setCreateDate(new Date());
                    profilesSuccess.setFormInstanceId(formInstanceId);
                    profilesSuccess.setvEnable(EnableType.ENABLE.getKey());
                    profilesSuccess.setdEnable(EnableType.ENABLE.getKey());
                    profilesSuccess.setPlateNumber(vehicle.getPlateNumber());
                    profilesSuccess.setLicenseNumber(vehicle.getLicenseNumber());
                    profilesSuccess.setModels(vehicle.getModels());
                    // 驾驶员可用卡id
                    Driver driver = driverDao.get(dv.getDriverId());
                    driver.setDriverIc(dv.getDriverIc());
                    driver.setDriverIcState(EnableType.ENABLE.getKey());
//                    CarOwner carOwner = carOwnerDao.get(dv.getCarOwnerId());
//                    profilesSuccess.setIdcardNumber(carOwner.getIdcardNumber());
                    profilesSuccess.setDriverName(driver.getDriverName());
                    profilesSuccess.setDriverIdCard(driver.getDriverIdCard());
                    profilesSuccess.setSex(driver.getSex());
                    profilesSuccess.setNation(driver.getNation());
                    if (datas.size() > 0) {
                        profilesSuccessService.update(profilesSuccess);
                    } else {
                        profilesSuccessService.add(profilesSuccess);
                    }
                    driverDao.update(driver);
                }
            }
            // ----添加驾驶员----
        } else if (process.getType() == ProgressType.TJJSY.getKey()) {
        }
        process.setState(applyType);
        process.setProgressState(progressState);
        return update(process);
    }

    @Override
    public boolean changeState(Long formInstanceId, int applyType, int progressState, Long creator, MessageEntity messageEntity) {

        if (changeState(formInstanceId, applyType, progressState)) {
            long msgId = 0;
            String title = "";
            String content = "";
            // ---------------管委会预审-------------
            if (progressState == ProgressState.GWHYSTG.getKey()) {
                if (applyType == ApplyType.PASS.getKey()) {
                    title = (String) parameterClient.get("message-title-yanche");
                    content = instanceMessageService.getMessageContent(formInstanceId, MessageType.YCTZ);
                } else {
                    title = (String) parameterClient.get("message-title-refuse-gwhck");
                    content = instanceMessageService.getMessageContent(formInstanceId, MessageType.GWH);
                }
            }
            // ---------------车检---------------
            if (progressState == ProgressState.YCTG.getKey()) {
                if (applyType == ApplyType.REJECT.getKey()) {
                    title = (String) parameterClient.get("message-title-refuse-cj");
                    content = instanceMessageService.getMessageContent(formInstanceId, MessageType.CJSP);
                }
            }
            // ---------------管委会现场---------------
            if (progressState == ProgressState.GWHHSYJ.getKey()) {
                if (applyType == ApplyType.REJECT.getKey()) {
                    title = (String) parameterClient.get("message-title-refuse-gwhxc");
                    content = instanceMessageService.getMessageContent(formInstanceId, MessageType.GWHXC);
                }
            }
            // ---------------交警---------------
            if (progressState == ProgressState.JJHSYJ.getKey()) {
                if (applyType == ApplyType.REJECT.getKey()) {
                    title = (String) parameterClient.get("message-title-refuse-jj");
                    content = instanceMessageService.getMessageContent(formInstanceId, MessageType.JJSP);
                }
            }
            // ---------------备案---------------
            if (progressState == ProgressState.BEIAN.getKey()) {
                if (applyType == ApplyType.PASS.getKey()) {
                    title = (String) parameterClient.get("message-title-zhiwen");
                    content = instanceMessageService.getMessageContent(formInstanceId, MessageType.ZWCJ);
                } else {
                    title = (String) parameterClient.get("message-title-refuse-ba");
                    content = instanceMessageService.getMessageContent(formInstanceId, MessageType.BASP);
                }
            }
            // 通知装卡
            if (progressState == ProgressState.TZZK.getKey()) {
                if (StringUtils.isEmpty(messageEntity.getTime())) {
                    messageEntity.setTime("2016-10-01 10:00:00");
                }
                if (StringUtils.isEmpty(messageEntity.getAddress())) {
                    messageEntity.setAddress("横琴大桥下");
                }
                title = (String) parameterClient.get("message-title-paiqi");
                content = instanceMessageService.getMessageContent(formInstanceId, MessageType.PQJG);
                content = content.replaceAll("\\{time\\}", messageEntity.getTime());
                content = content.replaceAll("\\{address\\}", messageEntity.getAddress());
            }
            // 发送站内信
            if (!StringUtils.isEmpty(title) && !StringUtils.isEmpty(content)) {
                // 拒绝原因
                if (applyType == ApplyType.REJECT.getKey()) {
                    content = content.replaceAll("\\{reason\\}", messageEntity.getNotionReason());
                }
                msgId = organizationClient.sendMsgForId(creator, ClerkMessageType.INSIDE_LETTER, title, content);
            }
            if (msgId > 0) {
                // 表单实例id和消息关联表
                InstanceMessage instanceMessage = new InstanceMessage();
                instanceMessage.setFormInstanceId(formInstanceId);
                instanceMessage.setMessageClerkId(msgId);
                instanceMessage.setClerkId(creator);
                instanceMessage.setCreateTime(new Date());
                instanceMessageService.add(instanceMessage);
            }
        }
        return true;
    }

    @Override
    public ProcessProgress get(Long carOwnerId, Long formInstanceId) {

        return processProgressDao.get(carOwnerId, formInstanceId);
    }
}
