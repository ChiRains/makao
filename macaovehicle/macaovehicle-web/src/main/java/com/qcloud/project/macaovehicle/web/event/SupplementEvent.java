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
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.common.Constant;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerEnterprisersService;
import com.qcloud.project.macaovehicle.service.CarOwnerHousersService;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.CarOwnerTalentService;
import com.qcloud.project.macaovehicle.service.CarOwnerWorkersService;
import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.service.ProfilesSuccessService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.helper.StateHelper;

/**
 * 补办临时号牌
 */
@Component
public class SupplementEvent implements FormEvent {

    private Log                    logger = LogFactory.getLog(getClass());

    @Autowired
    OrganizationClient             organizationClient;

    @Autowired
    CarOwnerService                carOwnerService;

    @Autowired
    DriverService                  driverService;

    @Autowired
    VehicleService                 vehicleService;

    @Autowired
    CarOwnerEnterprisersService    carOwnerEnterprisersService;

    @Autowired
    CarOwnerHousersService         carOwnerHousersService;

    @Autowired
    CarOwnerWorkersService         carOwnerWorkersService;

    @Autowired
    CarOwnerTalentService          carOwnerTalentService;

    @Autowired
    private FileSDKClient          fileSDKClient;

    @Autowired
    private ProfilesSuccessService profilesSuccessService;

    @Autowired
    private DriverVehicleService   driverVehicleService;

    @Autowired
    private StateHelper            stateHelper;

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
            if (!stateHelper.checkAvailType(Long.valueOf(vehicleId), ProgressType.BBLSHP)) {
                throw new MacaovehicleException("当前车辆您已不能补办临时号牌.");
            }
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
            AssertUtil.assertNotNull(carOwner, "该车主不存在." + context.getClerkId());
            context.addReturnResult("carOwnerId", String.valueOf(carOwner.getId()));
            context.addReturnResult("type", String.valueOf(carOwner.getType()));
            context.addReturnResult("clerkType", String.valueOf(carOwner.getClerkType()));
            // 添加申请流程
            context.addReturnResult("progressState", String.valueOf(ProgressState.SHENGQIN.getKey()));
            context.addReturnResult("progressType", String.valueOf(ProgressType.BBLSHP.getKey()));
            // context.addReturnResult("person.qc_inner_number", "1");
            // context.addReturnResult("person[0].name", carOwner.getName());
            // context.addReturnResult("person[0].idcardNumber", carOwner.getIdcardNumber());
            // context.addReturnResult("person[0].sex", String.valueOf(clerk.getSex()));
            // context.addReturnResult("person[0].birthDay", carOwner.getBirthday());
            // context.addReturnResult("person[0].phone", carOwner.getMobile());
            // context.addReturnResult("person[0].address", carOwner.getAddress());
            // context.addReturnResult("person[0].idcardFace", fileSDKClient.urlToUid(carOwner.getIdcardFace()));
            // context.addReturnResult("person[0].idCardBack", fileSDKClient.urlToUid(carOwner.getIdcardBack()));
            // context.addReturnResult("person[0].certificateType", carOwner.getCertificateType());
            // context.addReturnResult("person[0].certificateNo", carOwner.getCertificateNo());
            // context.addReturnResult("person[0].certificateDate", DateUtil.date2String(carOwner.getCertificateDate(), "yyyy-MM-dd HH:mm:ss"));
            // context.addReturnResult("person[0].certificateUrl", fileSDKClient.urlToUid(carOwner.getCertificateUrl()));
            // context.addReturnResult("person[0].idCardValidTime", carOwner.getIdCardValidTime());
            if (v.getApproveTime() != null) {
                context.addReturnResult("platNumber", v.getTemporaryplate());
                context.addReturnResult("validityDate", DateUtil.date2String(DateUtil.addDate(v.getApproveTime(), Constant.VEHICLE_VALID_TIME)));
                context.addReturnResult("effectDate", DateUtil.date2String(context.getSystemUnifiedDate()));
                context.addReturnResult("platedNumber", v.getTemporaryplated());
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
        } else {
            String temporaryPlate = (String) context.getParameter("temporaryPlate");
            if (!StringUtils.isEmpty(temporaryPlate) && temporaryPlate.equals("temporaryPlate")) {
                //
                String temporaryPlatNumber = (String) context.getParameter("temporaryPlate[0].platNumber");
                // 更新车辆关系表，由于有先后顺序，不用加锁
                List<DriverVehicle> driverVehicles = driverVehicleService.getListByFormInstanceId(context.getFormInstId());
                for (DriverVehicle driverVehicle : driverVehicles) {
                    driverVehicle.setTemporaryPlate(temporaryPlatNumber);
                    driverVehicleService.update(driverVehicle);
                }
                // 更新车辆临时号牌
                Long vehicleId = driverVehicles.get(0).getVehicleId();
                Vehicle vehicle = vehicleService.get(vehicleId);
                vehicle.setTemporaryplate(temporaryPlatNumber);
                String temporaryplated = vehicle.getTemporaryplated();
                // 曾用临时号牌
                if (!StringUtils.isEmpty(temporaryplated)) {
                    for (String str : temporaryplated.split(",")) {
                        vehicle.setTemporaryplated(str + "," + temporaryplated);
                    }
                }
                vehicleService.update(vehicle);
            }
        }
        logger.info("车辆申请选择车辆,驾驶员事件数据处理结束.");
    }
}
