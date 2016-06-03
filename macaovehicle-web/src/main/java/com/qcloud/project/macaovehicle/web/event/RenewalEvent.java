package com.qcloud.project.macaovehicle.web.event;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.mvprocesstask.core.MvProcesstaskClient;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.OwnerType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.StatusType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.UserType;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerAcquisitionService;
import com.qcloud.project.macaovehicle.service.CarOwnerEnterprisersService;
import com.qcloud.project.macaovehicle.service.CarOwnerHousersService;
import com.qcloud.project.macaovehicle.service.CarOwnerIndicatorsService;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.CarOwnerTalentService;
import com.qcloud.project.macaovehicle.service.CarOwnerWorkersService;
import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.service.ProfilesSuccessService;
import com.qcloud.project.macaovehicle.service.TaskingBorderService;
import com.qcloud.project.macaovehicle.service.TaskingCiqService;
import com.qcloud.project.macaovehicle.service.TaskingCustomsService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.TaskingBorderHandler;
import com.qcloud.project.macaovehicle.web.handler.TaskingCiqHandler;
import com.qcloud.project.macaovehicle.web.handler.TaskingCustomsHandler;

/**
 * 续期申请
 */
@Component
public class RenewalEvent implements FormEvent {

    private Log                        logger = LogFactory.getLog(getClass());

    @Autowired
    OrganizationClient                 organizationClient;

    @Autowired
    CarOwnerService                    carOwnerService;

    @Autowired
    DriverService                      driverService;

    @Autowired
    VehicleService                     vehicleService;

    @Autowired
    CarOwnerEnterprisersService        carOwnerEnterprisersService;

    @Autowired
    CarOwnerHousersService             carOwnerHousersService;

    @Autowired
    CarOwnerWorkersService             carOwnerWorkersService;

    @Autowired
    CarOwnerTalentService              carOwnerTalentService;

    @Autowired
    private CarOwnerAcquisitionService carOwnerAcquisitionService;

    @Autowired
    private CarOwnerIndicatorsService  carOwnerIndicatorsService;

    @Autowired
    private TaskingBorderService       taskingBorderService;

    @Autowired
    private TaskingCiqService          taskingCiqService;

    @Autowired
    private TaskingCustomsService      taskingCustomsService;

    @Autowired
    private TaskingBorderHandler       taskingBorderHandler;

    @Autowired
    private TaskingCiqHandler          taskingCiqHandler;

    @Autowired
    private TaskingCustomsHandler      taskingCustomsHandler;

    @Autowired
    private MvProcesstaskClient        mvProcesstaskClient;

    @Autowired
    private FileSDKClient              fileSDKClient;

    @Autowired
    private DriverVehicleService       driverVehicleService;

    @Autowired
    private ProfilesSuccessService     profilesSuccessService;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        logger.info("续期事件数据开始处理.");
        logger.info("ProcessId  " + context.getProcessId());
        logger.info("FormId  " + context.getFormId());
        logger.info("ProcessInstId  " + context.getProcessInstId());
        logger.info("FormInstId  " + context.getFormInstId());
        logger.info("TaskId  " + context.getTaskId());
        logger.info("ClerkId  " + context.getClerkId());
        // 流程尚未启动,则从车辆/驾驶员记录选取
        if (StringUtils.isEmpty(context.getProcessInstId()) && StringUtils.isEmpty(context.getWorkitemId())) {
            String vehicleId = (String) context.getParameter("vehicle");
            logger.info("vehicle" + vehicleId);
            AssertUtil.assertTrue(StringUtils.isNotEmpty(vehicleId), "车辆id不能为空.");
            //
            Vehicle v = vehicleService.get(Long.valueOf(vehicleId));
            AssertUtil.assertNotNull(v, "车辆信息不存在." + vehicleId);
            ProfilesSuccessQuery query = new ProfilesSuccessQuery();
            query.setdEnable(EnableType.ENABLE.getKey());
            query.setvEnable(EnableType.ENABLE.getKey());
            query.setVehicleId(Long.valueOf(vehicleId));
            List<ProfilesSuccess> list = profilesSuccessService.listByQuery(query);
            String driverIds = "";
            for (ProfilesSuccess profilesSuccess : list) {
                driverIds = driverIds + profilesSuccess.getDriverId() + ",";
            }
            if (!StringUtils.isEmpty(driverIds)) {
                driverIds = driverIds.substring(0, driverIds.length() - 1);
                context.addReturnResult("drivers", driverIds);
            }
            // TODO 限制
            // 拥有可用的车卡id
            // if (StringUtil.isEmpty(v.getRic())) {
            // throw new MacaovehicleException("此车辆未通过申请入境或者车牌已过期.");
            // }
            // for(String driverId : driverIds.split(",")) {
            // Driver driver = driverService.get(Long.valueOf(driverId));
            // if(StringUtils.isEmpty(driver.getDriverIc())) {
            // }
            // }
            CarOwner carOwner = carOwnerService.getByClerk(context.getClerkId());
            if (carOwner == null) {
                carOwner = carOwnerService.get(Long.valueOf(v.getCarOwnerId()));
                AssertUtil.assertNotNull(carOwner, "车主不存在." + v.getCarOwnerId());
            }
            context.addReturnResult("person.qc_inner_number", "1");
            context.addReturnResult("carOwnerId", String.valueOf(carOwner.getId()));
            context.addReturnResult("type", String.valueOf(carOwner.getType()));
            context.addReturnResult("clerkType", String.valueOf(carOwner.getClerkType()));
            // 添加申请流程
            context.addReturnResult("progressState", String.valueOf(ProgressState.SHENGQIN.getKey()));
            context.addReturnResult("progressType", String.valueOf(ProgressType.XQSQ.getKey()));
            context.addReturnResult("person.qc_inner_number", "1");
            context.addReturnResult("person[0].name", carOwner.getName());
            context.addReturnResult("person[0].idcardNumber", carOwner.getIdcardNumber());
            context.addReturnResult("person[0].sex", String.valueOf(carOwner.getSex()));
            context.addReturnResult("person[0].birthDay", carOwner.getBirthday());
            context.addReturnResult("person[0].phone", carOwner.getMobile());
            context.addReturnResult("person[0].address", carOwner.getAddress());
            context.addReturnResult("person[0].idcardFace", fileSDKClient.urlToUid(carOwner.getIdcardFace()));
            context.addReturnResult("person[0].idCardBack", fileSDKClient.urlToUid(carOwner.getIdcardBack()));
            context.addReturnResult("person[0].certificateType", carOwner.getCertificateType());
            context.addReturnResult("person[0].certificateNo", carOwner.getCertificateNo());
            context.addReturnResult("person[0].certificateDate", DateUtil.date2String(carOwner.getCertificateDate(), "yyyy-MM-dd HH:mm:ss"));
            context.addReturnResult("person[0].certificateUrl", fileSDKClient.urlToUid(carOwner.getCertificateUrl()));
            context.addReturnResult("person[0].idCardValidTime", carOwner.getIdCardValidTime());
            // 务工1
            if (UserType.WORKERS.getKey() == carOwner.getType()) {
                CarOwnerWorkers carOwnerWorkers = carOwnerWorkersService.getByCarOwner(carOwner.getId());
                AssertUtil.assertNotNull(carOwnerWorkers, "务工信息不存在." + carOwner.getName());
                context.addReturnResult("workers.qc_inner_number", "1");
                context.addReturnResult("workers[0].company", carOwnerWorkers.getCompany());
                context.addReturnResult("workers[0].fixedLine", carOwnerWorkers.getFixedLine());
                context.addReturnResult("workers[0].address", carOwnerWorkers.getAddress());
                context.addReturnResult("workers[0].phone", carOwnerWorkers.getPhone());
                context.addReturnResult("workers[0].consignee", carOwnerWorkers.getConsignee());
                context.addReturnResult("workers[0].position", carOwnerWorkers.getPosition());
                context.addReturnResult("workers[0].workCertificate", fileSDKClient.urlToUid(carOwnerWorkers.getWorkCertificate()));
                context.addReturnResult("workers[0].code", carOwnerWorkers.getCode());
                context.addReturnResult("workers[0].time", carOwnerWorkers.getTime());
                context.addReturnResult("workers[0].entryTime", carOwnerWorkers.getEntryTime());
                context.addReturnResult("workers[0].contractUrl", fileSDKClient.urlToUid(carOwnerWorkers.getContractUrl()));
                context.addReturnResult("workers[0].insuranceFeeUrl", fileSDKClient.urlToUid(carOwnerWorkers.getInsuranceFeeUrl()));
            }
            // 购房2
            if (UserType.HOUSERS.getKey() == carOwner.getType()) {
                CarOwnerHousers carOwnerHousers = carOwnerHousersService.getByCarOwner(carOwner.getId());
                AssertUtil.assertNotNull(carOwnerHousers, "购房信息不存在." + carOwner.getName());
                context.addReturnResult("housers.qc_inner_number", "1");
                context.addReturnResult("housers[0].property", carOwnerHousers.getProperty());
                context.addReturnResult("housers[0].application", carOwnerHousers.getApplication());
                // context.addReturnResult("housers[0].ways", carOwnerHousers.get.getProperty());
                context.addReturnResult("housers[0].situation", carOwnerHousers.getSituation());
                context.addReturnResult("housers[0].code", carOwnerHousers.getCode());
                context.addReturnResult("housers[0].time", carOwnerHousers.getTime());
                context.addReturnResult("housers[0].located", carOwnerHousers.getLocated());
                context.addReturnResult("housers[0].structure", carOwnerHousers.getStructure());
                context.addReturnResult("housers[0].floor", String.valueOf(carOwnerHousers.getFloor()));
                context.addReturnResult("housers[0].buildArea", String.valueOf(carOwnerHousers.getBuildArea()));
                context.addReturnResult("housers[0].totalArea", String.valueOf(carOwnerHousers.getTotalArea()));
                context.addReturnResult("housers[0].licenseNo", String.valueOf(carOwnerHousers.getLicenseNo()));
                context.addReturnResult("housers[0].licenseUrl", fileSDKClient.urlToUid(carOwnerHousers.getLicenseUrl()));
                context.addReturnResult("housers[0].method", carOwnerHousers.getMethod());
                // context.addReturnResult("housers[0].houseCertificate", carOwnerHousers.get.getProperty());
            }
            // 企业投资3、企业购地也需要信息
            if (UserType.ENTERPRISERS.getKey() == carOwner.getType() || carOwner.getClerkType() == OwnerType.BUSINESS.getKey()) {
                CarOwnerEnterprisers carOwnerEnterprisers = carOwnerEnterprisersService.getByCarOwner(carOwner.getId());
                AssertUtil.assertNotNull(carOwnerEnterprisers, "投资企业不存在." + carOwner.getName());
                context.addReturnResult("enterprisers.qc_inner_number", "1");
                context.addReturnResult("enterprisers[0].company", carOwnerEnterprisers.getCompany());
                context.addReturnResult("enterprisers[0].code", carOwnerEnterprisers.getCode());
                context.addReturnResult("enterprisers[0].operate", carOwnerEnterprisers.getOperate());
                context.addReturnResult("enterprisers[0].scale", carOwnerEnterprisers.getScale());
                context.addReturnResult("enterprisers[0].represent", carOwnerEnterprisers.getRepresent());
                context.addReturnResult("enterprisers[0].phone", carOwnerEnterprisers.getPhone());
                context.addReturnResult("enterprisers[0].address", carOwnerEnterprisers.getAddress());
                context.addReturnResult("enterprisers[0].time", carOwnerEnterprisers.getTime());
                context.addReturnResult("enterprisers[0].license", fileSDKClient.urlToUid(carOwnerEnterprisers.getLicense()));
                context.addReturnResult("enterprisers[0].operatingPeriod", DateUtil.date2String(carOwnerEnterprisers.getOperatingPeriod(), "yyyy-MM-dd HH:mm:ss"));
                context.addReturnResult("enterprisers[0].organs", carOwnerEnterprisers.getOrgans());
                context.addReturnResult("enterprisers[0].contacts", carOwnerEnterprisers.getContacts());
                context.addReturnResult("enterprisers[0].paymentUrl", fileSDKClient.urlToUid(carOwnerEnterprisers.getPaymentUrl()));
                context.addReturnResult("enterprisers[0].commitmentUrl", fileSDKClient.urlToUid(carOwnerEnterprisers.getCommitmentUrl()));
                context.addReturnResult("enterprisers[0].representID", carOwnerEnterprisers.getRepresentID());
                context.addReturnResult("enterprisers[0].positiveUrl", fileSDKClient.urlToUid(carOwnerEnterprisers.getPositiveUrl()));
                context.addReturnResult("enterprisers[0].oppositeUrl", fileSDKClient.urlToUid(carOwnerEnterprisers.getOppositeUrl()));
            }
            // 高级人才4
            if (UserType.TALENT.getKey() == carOwner.getType()) {
                CarOwnerTalent ownerTalent = carOwnerTalentService.getByCarOwner(carOwner.getId());
                AssertUtil.assertNotNull(ownerTalent, "高新人才不存在." + carOwner.getName());
                context.addReturnResult("talent.qc_inner_number", "1");
                context.addReturnResult("talent[0].company", ownerTalent.getCompany());
                context.addReturnResult("talent[0].fixedLine", ownerTalent.getFixedLine());
                context.addReturnResult("talent[0].address", ownerTalent.getAddress());
                context.addReturnResult("talent[0].phone", ownerTalent.getPhone());
                context.addReturnResult("talent[0].consignee", ownerTalent.getConsignee());
                context.addReturnResult("talent[0].position", ownerTalent.getPosition());
                context.addReturnResult("talent[0].workCertificate", fileSDKClient.urlToUid(ownerTalent.getWorkCertificate()));
                context.addReturnResult("talent[0].code", ownerTalent.getCode());
                context.addReturnResult("talent[0].time", ownerTalent.getTime());
                context.addReturnResult("talent[0].entryTime", ownerTalent.getEntryTime());
                context.addReturnResult("talent[0].contractUrl", fileSDKClient.urlToUid(ownerTalent.getContractUrl()));
                context.addReturnResult("talent[0].insuranceFeeUrl", fileSDKClient.urlToUid(ownerTalent.getInsuranceFeeUrl()));
                context.addReturnResult("talent[0].deptCertificateUrl", fileSDKClient.urlToUid(ownerTalent.getDeptCertificateUrl()));
            }
            // 购地5,个人、企业购地字段一样
            if (UserType.ACQUISITION.getKey() == carOwner.getType()) {
                context.addReturnResult("acquisition.qc_inner_number", "1");
                CarOwnerAcquisition carOwnerAcquisition = carOwnerAcquisitionService.getByCarOwner(carOwner.getId());
                AssertUtil.assertNotNull(carOwnerAcquisition, "购地不存在." + carOwner.getName());
                context.addReturnResult("acquisition[0].application", carOwnerAcquisition.getApplication());
                context.addReturnResult("acquisition[0].deadline", carOwnerAcquisition.getDeadline());
                context.addReturnResult("acquisition[0].buyTime", carOwnerAcquisition.getBuyTime());
                context.addReturnResult("acquisition[0].contractUrl", fileSDKClient.urlToUid(carOwnerAcquisition.getContractUrl()));
            }
            if (StringUtils.isNotEmpty(vehicleId)) {
                context.addReturnResult("vehicle.qc_inner_number", "1");
                // context.addReturnResult("vehicle[0].id", v.getId());
                context.addReturnResult("vehicle[0].vehicleId", v.getId());
                context.addReturnResult("vehicle[0].plateNumber", v.getPlateNumber());
                context.addReturnResult("vehicle[0].licenseNumber", v.getLicenseNumber());
                context.addReturnResult("vehicle[0].models", v.getModels());
                context.addReturnResult("vehicle[0].brand", v.getBrand());
                context.addReturnResult("vehicle[0].specification", v.getSpecification());
                context.addReturnResult("vehicle[0].authority", v.getAuthority());
                context.addReturnResult("vehicle[0].buyTime", v.getBuyTime());
                context.addReturnResult("vehicle[0].color", v.getColor());
                context.addReturnResult("vehicle[0].ownerName", v.getOwnerName());
                context.addReturnResult("vehicle[0].ownerPhone", v.getOwnerPhone());
                context.addReturnResult("vehicle[0].ownerAddress", v.getOwnerAddress());
                context.addReturnResult("vehicle[0].engineNumber", v.getEngineNumber());
                context.addReturnResult("vehicle[0].frameNumber", v.getFrameNumber());
                context.addReturnResult("vehicle[0].steeringWheel", String.valueOf(v.getSteeringWheel()));
                context.addReturnResult("vehicle[0].startTime", v.getStartTime());
                context.addReturnResult("vehicle[0].weight", String.valueOf(v.getWeight()));
                context.addReturnResult("vehicle[0].length", String.valueOf(v.getLength()));
                context.addReturnResult("vehicle[0].height", String.valueOf(v.getHeight()));
                context.addReturnResult("vehicle[0].width", String.valueOf(v.getWidth()));
                context.addReturnResult("vehicle[0].type", String.valueOf(v.getType()));
                context.addReturnResult("vehicle[0].capacity", String.valueOf(v.getCapacity()));
                context.addReturnResult("vehicle[0].seat", String.valueOf(v.getSeat()));
                context.addReturnResult("vehicle[0].backupWheel", String.valueOf(v.getBackupWheel()));
                context.addReturnResult("vehicle[0].faceWheel", String.valueOf(v.getFaceWheel()));
                context.addReturnResult("vehicle[0].backWheel", String.valueOf(v.getBackWheel()));
                context.addReturnResult("vehicle[0].registTime", v.getRegistTime());
                context.addReturnResult("vehicle[0].licenseImage", fileSDKClient.urlToUid(v.getLicenseImage()));
                context.addReturnResult("vehicle[0].faceImage", fileSDKClient.urlToUid(v.getFaceImage()));
                context.addReturnResult("vehicle[0].leftfaceImage", fileSDKClient.urlToUid(v.getLeftfaceImage()));
                context.addReturnResult("vehicle[0].rightfaceImage", fileSDKClient.urlToUid(v.getRightfaceImage()));
                context.addReturnResult("vehicle[0].leftbackImage", fileSDKClient.urlToUid(v.getLeftbackImage()));
                context.addReturnResult("vehicle[0].rightbackImage", fileSDKClient.urlToUid(v.getRightbackImage()));
                //
                context.addReturnResult("vehicle[0].area", v.getArea());
                context.addReturnResult("vehicle[0].engineNo", v.getEngineNo());
                context.addReturnResult("vehicle[0].permittedWeight", v.getPermittedWeight());
                context.addReturnResult("vehicle[0].passengers", v.getPassengers());
                context.addReturnResult("vehicle[0].effectiveDates", v.getEffectiveDates());
                context.addReturnResult("vehicle[0].endDates", v.getEndDates());
                context.addReturnResult("vehicle[0].insuranceUrl", fileSDKClient.urlToUid(v.getInsuranceUrl()));
                context.addReturnResult("vehicle[0].temporaryplate", v.getTemporaryplate());
                context.addReturnResult("vehicle[0].indicators", v.getIndicators());
                context.addReturnResult("vehicle[0].indicatorsTime", DateUtil.date2String(v.getIndicatorsTime()));
            }
            if (StringUtils.isNotEmpty(driverIds)) {
                String[] strs = driverIds.split(",");
                context.addReturnResult("driver.qc_inner_number", "" + strs.length);
                for (int index = 0; index < strs.length; index++) {
                    String str = strs[index];
                    Driver driver = driverService.get(Long.valueOf(str));
                    AssertUtil.assertNotNull(driver, "驾驶员信息不存在." + str);
                    // context.addReturnResult("driver[" + index + "].id", driver.getId());
                    context.addReturnResult("driver[" + index + "].driverId", driver.getId());
                    context.addReturnResult("driver[" + index + "].licenseNumber", driver.getLicenseNumber());
                    context.addReturnResult("driver[" + index + "].licenseStartTime", driver.getLicenseStartTime());
                    context.addReturnResult("driver[" + index + "].licenseImage", fileSDKClient.urlToUid(driver.getLicenseImage()));
                    context.addReturnResult("driver[" + index + "].driverName", driver.getDriverName());
                    context.addReturnResult("driver[" + index + "].seconddrivername", driver.getSeconddrivername());
                    context.addReturnResult("driver[" + index + "].driverPhone", driver.getDriverPhone());
                    context.addReturnResult("driver[" + index + "].driverIdCard", driver.getDriverIdCard());
                    context.addReturnResult("driver[" + index + "].driverAddress", driver.getDriverAddress());
                    context.addReturnResult("driver[" + index + "].idcardValidTime", driver.getIdcardValidTime());
                    context.addReturnResult("driver[" + index + "].licenseValidTime", driver.getLicenseValidTime());
                    context.addReturnResult("driver[" + index + "].quasi", driver.getQuasi());
                    context.addReturnResult("driver[" + index + "].idcardFace", fileSDKClient.urlToUid(driver.getIdcardFace()));
                    context.addReturnResult("driver[" + index + "].idcardBack", fileSDKClient.urlToUid(driver.getIdcardBack()));
                    context.addReturnResult("driver[" + index + "].certificateType", driver.getCertificateType());
                    context.addReturnResult("driver[" + index + "].certificateNo", driver.getCertificateNo());
                    context.addReturnResult("driver[" + index + "].certificateDate", driver.getCertificateDate());
                    context.addReturnResult("driver[" + index + "].certificateUrl", fileSDKClient.urlToUid(driver.getCertificateUrl()));
                    context.addReturnResult("driver[" + index + "].inchImage", fileSDKClient.urlToUid(driver.getInchImage()));
                    context.addReturnResult("driver[" + index + "].birthday", driver.getBirthday());
                    context.addReturnResult("driver[" + index + "].secondbirthday", driver.getSecondbirthday());
                    context.addReturnResult("driver[" + index + "].sex", driver.getSex());
                    context.addReturnResult("driver[" + index + "].nation", driver.getNation());
                    context.addReturnResult("driver[" + index + "].endorsementType", driver.getEndorsementType());
                    context.addReturnResult("driver[" + index + "].endorsementOrgCode", driver.getEndorsementOrgCode());
                    context.addReturnResult("driver[" + index + "].endorsementValidtime", driver.getEndorsementValidtime());
                    context.addReturnResult("driver[" + index + "].endorsementStay", driver.getEndorsementStay());
                    context.addReturnResult("driver[" + index + "].gotoCountry", driver.getGotoCountry());
                    context.addReturnResult("driver[" + index + "].comefromCountry", driver.getComefromCountry());
                    context.addReturnResult("driver[" + index + "].nationCode", driver.getNationCode());
                    context.addReturnResult("driver[" + index + "].endorsementCode", driver.getEndorsementCode());
                    context.addReturnResult("driver[" + index + "].healthCard", driver.getHealthCard());
                    context.addReturnResult("driver[" + index + "].healthCardImg", fileSDKClient.urlToUid(driver.getHealthCardImg()));
                    context.addReturnResult("driver[" + index + "].driverworkplace", driver.getDriverworkplace());
                }
            }
        } else {
            // 交警填写临时车牌之后,三家单位备案信息新增(放在tasked之后,数据库dao查询数据失败,由于处于同一个事务,暂时放在这里)
            // 更新车辆关系表，由于有先后顺序，不用加锁
            // List<DriverVehicle> driverVehicles = driverVehicleService.getListByFormInstanceId(context.getFormInstId());
            // for (DriverVehicle driverVehicle : driverVehicles) {
            // driverVehicle.setTemporaryPlate(temporaryPlatNumber);
            // driverVehicleService.update(driverVehicle);
            // }
            Tasking tasking = mvProcesstaskClient.getTaskingByWorkitem(context.getWorkitemId());
            AssertUtil.assertNotNull(tasking, "活动不存在workitemId." + context.getWorkitemId());
            TaskingBorder taskingBorder = taskingBorderHandler.toEntity(tasking);
            TaskingCiq taskingCiq = taskingCiqHandler.toEntity(tasking);
            TaskingCustoms taskingCustoms = taskingCustomsHandler.toEntity(tasking);
            //
            taskingBorder.setStatus(StatusType.DISABLE.getKey());
            taskingCiq.setStatus(StatusType.DISABLE.getKey());
            taskingCustoms.setStatus(StatusType.DISABLE.getKey());
            //
            taskingBorderService.add(taskingBorder);
            taskingCiqService.add(taskingCiq);
            taskingCustomsService.add(taskingCustoms);
        }
        logger.info("车辆申请选择车辆,驾驶员事件数据处理结束.");
    }
}
