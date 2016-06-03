package com.qcloud.project.macaovehicle.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.common.Constant;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.DriverVehicleQuery;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.service.ProfilesSuccessService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.DriverHandler;
import com.qcloud.project.macaovehicle.web.handler.ProfilesSuccessHandler;
import com.qcloud.project.macaovehicle.web.handler.VehicleHandler;
import com.qcloud.project.macaovehicle.web.helper.CarOwnerHelper;
import com.qcloud.project.macaovehicle.web.vo.ProfilesSuccessVO;
import com.qcloud.project.macaovehicle.web.vo.VehicleVO;

@Controller
@RequestMapping(value = ProfilesSuccessController.DIR)
public class ProfilesSuccessController {

    public static final String     DIR = "/profilesSuccess";

    @Autowired
    private ProfilesSuccessService profilesSuccessService;

    @Autowired
    private ProfilesSuccessHandler profilesSuccessHandler;

    @Autowired
    private DriverService          driverService;

    @Autowired
    private VehicleService         vehicleService;

    @Autowired
    private CarOwnerService        carOwnerService;

    @Autowired
    private DriverVehicleService   driverVehicleService;

    @Autowired
    private DriverHandler          driverHandler;

    @Autowired
    private CarOwnerHelper         carOwnerHelper;

    @Autowired
    private ClerkHelper            clerkHelper;

    @Autowired
    private VehicleHandler         vehicleHandler;

    /**
     * 入境资格驾驶员列表(审批端)
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontPagingView listDriver(ProfilesSuccessQuery query, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        query.setGroupByStr("driverId");
        query.setdEnable(EnableType.ENABLE.getKey());
        Page<ProfilesSuccess> page = profilesSuccessService.page(query, start, PAGE_SIZE);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (ProfilesSuccess profilesSuccess : page.getData()) {
            Driver driver = driverService.get(profilesSuccess.getDriverId());
            AssertUtil.assertNotNull(driver, "驾驶员不存在." + profilesSuccess.getDriverId());
            Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
            returnMap.put("driverId", driver.getId());
            returnMap.put("nation", driver.getNation());// 国籍(1,境内；2，境外)
            returnMap.put("driverName", driver.getDriverName());// 驾驶员姓名
            returnMap.put("sex", driver.getSex());// 性别
            returnMap.put("driverPhone", driver.getDriverPhone());// 联系电话
            returnMap.put("driverIdCard", driver.getDriverIdCard());// 驾驶员身份证
            returnMap.put("licenseNumber", driver.getLicenseNumber());// 驾驶证号码
            mapList.add(returnMap);
        }
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.addObject("result", mapList);
        return view;
    }

    /**
     * 入境驾驶员详情(审批端)
     * @param request
     * @param formInstCode
     * @return
     */
    @RequestMapping
    public FrontAjaxView getDriver(HttpServletRequest request, Long driverId) {

        AssertUtil.greatZero(driverId, "驾驶员id不能为空.");
        Driver driver = driverService.get(driverId);
        AssertUtil.assertNotNull(driver, "驾驶员信息不存在.");
        ProfilesSuccessQuery query = new ProfilesSuccessQuery();
        query.setGroupByStr("driverId");
        query.setdEnable(EnableType.ENABLE.getKey());
        query.setvEnable(EnableType.ENABLE.getKey());
        query.setDriverId(driverId);
        List<ProfilesSuccess> profilesList = profilesSuccessService.listByQuery(query);
        List<Map<String, Object>> bindVehicleList = new ArrayList<Map<String, Object>>();
        Date curDate = new Date();
        for (ProfilesSuccess profilesSuccess : profilesList) {
            Vehicle vehicle = vehicleService.get(profilesSuccess.getVehicleId());
            AssertUtil.assertNotNull(vehicle, "车辆信息 不存在." + profilesSuccess.getVehicleId());
            Map<String, Object> bindVehicleMap = new HashMap<String, Object>();
            // 临时号牌
            bindVehicleMap.put("plateNumber", vehicle.getPlateNumber());
            bindVehicleMap.put("temporaryplate", vehicle.getTemporaryplate());
            if (vehicle.getApproveTime() != null) {
                Date validDate = DateUtils.addDays(vehicle.getApproveTime(), Constant.VEHICLE_VALID_TIME);
                bindVehicleMap.put("validityDate", DateUtil.date2String(validDate));
                bindVehicleMap.put("remainDays", DateUtil.getDayCount(validDate, curDate));
            } else {
                bindVehicleMap.put("validityDate", "--");
                bindVehicleMap.put("remainDays", "--");
            }
            bindVehicleMap.put("state", "可入境");
            bindVehicleList.add(bindVehicleMap);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("bindVehicleList", bindVehicleList);
        view.addObject("driver", driverHandler.toVO(driver));
        return view;
    }

    /**
     * 入境资格车辆列表(审批端)
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontPagingView listVehicle(ProfilesSuccessQuery query, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        query.setGroupByStr("vehicleId");
        query.setvEnable(EnableType.ENABLE.getKey());
        Page<ProfilesSuccess> page = profilesSuccessService.page(query, start, PAGE_SIZE);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (ProfilesSuccess profilesSuccess : page.getData()) {
            Vehicle vehicle = vehicleService.get(profilesSuccess.getVehicleId());
            AssertUtil.assertNotNull(vehicle, "车辆不存在." + profilesSuccess.getVehicleId());
            CarOwner carOwner = carOwnerService.get(profilesSuccess.getCarOwnerId());
            Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
            AssertUtil.assertNotNull(carOwner, "申请人信息不存在." + profilesSuccess.getCarOwnerId());
            returnMap.put("idcardNumber", carOwner.getIdcardNumber());// 单牌车列表-查询字段-身份证号码
            returnMap.put("plateNumber", vehicle.getPlateNumber());// 境外车牌号码
            returnMap.put("licenseNumber", vehicle.getLicenseNumber());// 行驶证号码
            returnMap.put("models", vehicle.getModels());// 车辆类型
            returnMap.put("brand", vehicle.getBrand());// 品牌名字
            returnMap.put("specification", vehicle.getSpecification());// 车辆规格型号
            returnMap.put("ownerPhone", vehicle.getOwnerPhone());// 车主电话
            returnMap.put("models", vehicle.getModels());// 车辆型号
            returnMap.put("idcardNumber", carOwner.getIdcardNumber());// 身份证号码
            returnMap.put("formInstanceId", profilesSuccess.getFormInstanceId());// 表单实例id
            returnMap.put("vehicleId", vehicle.getId());
            returnMap.put("carOwnerId", profilesSuccess.getCarOwnerId());
            mapList.add(returnMap);
        }
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.addObject("result", mapList);
        return view;
    }

    /**
     * 申请人列表(审批端)
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontPagingView listCarOwner(ProfilesSuccessQuery query, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        query.setGroupByStr("carOwnerId");
        query.setvEnable(EnableType.ENABLE.getKey());
        Page<Object[]> page = profilesSuccessService.pageByGroup(query, start, PAGE_SIZE);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (Object[] obj : page.getData()) {
            ProfilesSuccess profilesSuccess = (ProfilesSuccess) obj[0];
            CarOwner carOwner = carOwnerService.get(profilesSuccess.getCarOwnerId());
            Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
            returnMap.put("formInstanceId", profilesSuccess.getFormInstanceId());// 表单实例id
            returnMap.put("clerkType", carOwner.getClerkType());// 角色。1：个人；2：企业
            returnMap.put("carOwnerId", carOwner.getId());
            returnMap.put("type", carOwner.getType());// 类型。1：务工；2：在住；3.企业：4人才；5：购地
            returnMap.put("name", carOwner.getName());// 名字。车主姓名？
            returnMap.put("idcardNumber", carOwner.getIdcardNumber());// 身份证号码
            returnMap.put("enterCount", obj[1]);// 入境车辆数量
            returnMap.put("remainCount", carOwnerHelper.getAvailVehicle(carOwner.getClerkType(), carOwner.getType()) - Integer.valueOf(obj[1].toString()));// 剩余可申请数量
            mapList.add(returnMap);
        }
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.addObject("result", mapList);
        return view;
    }

    @RequestMapping
    public FrontAjaxView getAvailCar(ProfilesSuccessQuery query, Long carOwnerId) {

        AssertUtil.greatZero(carOwnerId, "车主id不能为空.");
        FrontAjaxView view = new FrontAjaxView();
        query.setCarOwnerId(carOwnerId);
        query.setGroupByStr("vehicleId");
        query.setvEnable(EnableType.ENABLE.getKey());
        List<ProfilesSuccess> profilesSuccesses = profilesSuccessService.listByQuery(query);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
        for (ProfilesSuccess profilesSuccess : profilesSuccesses) {
            Long vehicleId = profilesSuccess.getVehicleId();
            List<DriverVehicle> driverVehicles = driverVehicleService.getListByVehicleId(vehicleId, ProgressType.APPLY);
            AssertUtil.assertNotNull(driverVehicles, "请检查车辆关系表." + vehicleId);
            Vehicle vehicle = vehicleService.get(vehicleId);
            AssertUtil.assertNotNull(vehicle, "车辆不存在." + vehicleId);
            DriverVehicle driverVehicle = driverVehicles.get(0);
            returnMap.put("vehicleId", vehicle.getId());
            returnMap.put("indicatorsNo", driverVehicle.getIndicatorsNo());
            returnMap.put("plateNumber", vehicle.getPlateNumber());
            returnMap.put("temporaryPlate", vehicle.getTemporaryplate());
            Date endDate = DateUtil.addDate(vehicle.getApproveTime(), Constant.VEHICLE_VALID_TIME);
            returnMap.put("validityTime", DateUtil.date2String(endDate));
            returnMap.put("remainDay", DateUtil.getDayCount(endDate, new Date()));
            returnMap.put("state", "可入境");
            mapList.add(returnMap);
        }
        view.addObject("result", mapList);
        return view;
    }

    /**
     * 入境车辆列表(门户网)
     * @param request
     * @param pageSize
     * @param pageNum
     * @param query
     * @return
     */
    @RequestMapping
    public FrontPagingView listEntryVehicle(HttpServletRequest request, Integer pageSize, Integer pageNum) {

        QClerk clerk = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        ProfilesSuccessQuery query = new ProfilesSuccessQuery();
        query.setGroupByStr("vehicleId");
        query.setCarOwnerId(carOwner.getId());
        query.setvEnable(EnableType.ENABLE.getKey());
        Page<ProfilesSuccess> page = profilesSuccessService.page(query, start, PAGE_SIZE);
        List<ProfilesSuccessVO> voList = profilesSuccessHandler.toVehicleVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.setMessage("查询成功");
        view.addObject("result", voList);
        return view;
    }

    /**
     * 入境车辆详情(门户网)
     * @param request
     * @param formInstCode
     * @return
     */
    @RequestMapping
    public FrontAjaxView getEntryVehicle(HttpServletRequest request, Long vehicleId) {

        AssertUtil.greatZero(vehicleId, "车辆id不能为空.");
        QClerk clerk = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        ProfilesSuccessQuery query = new ProfilesSuccessQuery();
        query.setVehicleId(vehicleId);
        query.setGroupByStr("driverId");
        query.setCarOwnerId(carOwner.getId());
        query.setvEnable(EnableType.ENABLE.getKey());
        query.setdEnable(EnableType.ENABLE.getKey());
        List<ProfilesSuccess> profilesSuccesses = profilesSuccessService.listByQuery(query);
        List<Driver> driverList = new ArrayList<Driver>();
        for (ProfilesSuccess profilesSuccess : profilesSuccesses) {
            Driver driver = driverService.get(profilesSuccess.getDriverId());
            driverList.add(driver);
        }
        Vehicle vehicle = vehicleService.get(vehicleId);
        AssertUtil.assertNotNull(vehicle, "车辆不存在." + vehicleId);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("vehicle", vehicle);
        view.addObject("driverList", driverList);
        return view;
    }

    /**
     * 入境司机列表(门户网)
     * @param request
     * @param pageSize
     * @param pageNum
     * @param query
     * @return
     */
    @RequestMapping
    public FrontPagingView listEntryDriver(HttpServletRequest request, Integer pageSize, Integer pageNum) {

        QClerk clerk = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        AssertUtil.assertNotNull(carOwner, "车主不存在.");
        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        ProfilesSuccessQuery query = new ProfilesSuccessQuery();
        query.setGroupByStr("driverId");
        query.setCarOwnerId(carOwner.getId());
        query.setdEnable(EnableType.ENABLE.getKey());
        Page<ProfilesSuccess> page = profilesSuccessService.page(query, start, PAGE_SIZE);
        List<ProfilesSuccessVO> voList = profilesSuccessHandler.toDriverVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.setMessage("查询成功");
        view.addObject("result", voList);
        return view;
    }

    /**
     * 入境司机详情(门户网)
     * @param request
     * @param formInstCode
     * @return
     */
    @RequestMapping
    public FrontAjaxView getEntryDriver(HttpServletRequest request, Long driverId) {

        AssertUtil.greatZero(driverId, "驾驶员id不能为空.");
        Driver driver = driverService.get(driverId);
        AssertUtil.assertNotNull(driver, "驾驶员信息不能为空.");
        ProfilesSuccessQuery query = new ProfilesSuccessQuery();
        query.setDriverId(driverId);
        query.setGroupByStr("vehicleId");
        query.setdEnable(EnableType.ENABLE.getKey());
        query.setvEnable(EnableType.ENABLE.getKey());
        List<ProfilesSuccess> profilesSuccesses = profilesSuccessService.listByQuery(query);
        List<VehicleVO> vehicleList = new ArrayList<VehicleVO>();
        for (ProfilesSuccess profilesSuccess : profilesSuccesses) {
            Vehicle vehicle = vehicleService.get(profilesSuccess.getVehicleId());
            VehicleVO vo = vehicleHandler.toVO(vehicle);
            Date validDate = DateUtils.addDays(vehicle.getApproveTime(), Constant.VEHICLE_VALID_TIME);
            vo.setValidDateStr(DateUtil.date2String(validDate, "yyyy-MM-dd"));
            vehicleList.add(vo);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("vehicleList", vehicleList);
        view.addObject("driver", driver);
        return view;
    }

    /**
     * 挂失驾驶员卡
     * @return
     */
    @RequestMapping
    public FrontAjaxView lossDriver(HttpServletRequest request, Long driverId) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        List<Vehicle> list = vehicleService.listByCarOwner(carOwner.getId());
        // List<VehicleListVO> listVO = vehicleHandler.listToVOList(list);
        List<VehicleVO> volist = vehicleHandler.toVOList(list);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("result", volist);
        view.setMessage("查询成功");
        return view;
    }

    /**
     * 入境某车主车辆详情(审批端)
     * @param request
     * @param formInstCode
     * @return
     */
    @RequestMapping
    public FrontAjaxView listEntry4CarOwner(HttpServletRequest request, Long carOwnerId) {

        AssertUtil.greatZero(carOwnerId, "车主id不能为空.");
        CarOwner carOwner = carOwnerService.get(carOwnerId);
        AssertUtil.assertNotNull(carOwner, "车主不存在." + carOwnerId);
        ProfilesSuccessQuery query = new ProfilesSuccessQuery();
        query.setCarOwnerId(carOwnerId);
        query.setvEnable(EnableType.ENABLE.getKey());
        query.setGroupByStr("vehicleId");
        List<ProfilesSuccess> profilesSuccessList = profilesSuccessService.listByQuery(query);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (ProfilesSuccess profilesSuccess : profilesSuccessList) {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Long vehicleId = profilesSuccess.getVehicleId();
            Vehicle vehicle = vehicleService.get(vehicleId);
            AssertUtil.assertNotNull(vehicle, "车辆不存在." + vehicleId);
            Date approveTime = vehicle.getApproveTime();
            if (approveTime == null) {
                continue;
            }
            Date endTime = DateUtil.addDate(approveTime, Constant.VEHICLE_VALID_TIME);
            returnMap.put("plateNumber", vehicle.getPlateNumber());
            returnMap.put("temporaryplate", vehicle.getTemporaryplate());
            returnMap.put("endTime", DateUtil.date2String(endTime));
            returnMap.put("remainDay", DateUtil.getDayCount(endTime, new Date()));
            returnMap.put("type", "可入境");
            mapList.add(returnMap);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("mapList", mapList);
        return view;
    }

    @RequestMapping
    public FrontAjaxView unbindDriver(HttpServletRequest request, Long driverId, Long vehicleId) {

        AssertUtil.greatZero(driverId, "驾驶员id不能为空.");
        AssertUtil.greatZero(vehicleId, "车辆id不能为空.");
        Driver driver = driverService.get(driverId);
        Vehicle vehicle = vehicleService.get(vehicleId);
        AssertUtil.assertNotNull(driver, "驾驶员不存在." + driverId);
        AssertUtil.assertNotNull(vehicle, "车辆不存在." + vehicleId);
        ProfilesSuccessQuery query = new ProfilesSuccessQuery();
        query.setDriverId(driverId);
        query.setVehicleId(vehicleId);
        query.setdEnable(EnableType.ENABLE.getKey());
        List<ProfilesSuccess> profilesSuccessList = profilesSuccessService.listByQuery(query);
        for (ProfilesSuccess profilesSuccess : profilesSuccessList) {
            profilesSuccess.setdEnable(EnableType.DISABLE.getKey());
            profilesSuccessService.update(profilesSuccess);
            DriverVehicleQuery dvQuery = new DriverVehicleQuery();
            dvQuery.setDriverId(driverId);
            dvQuery.setVehicleId(vehicleId);
            List<DriverVehicle> driverVehicles = driverVehicleService.listByQuery(dvQuery);
            for (DriverVehicle driverVehicle : driverVehicles) {
                // 解除绑定关系
                driverVehicleService.delete(driverVehicle.getId());
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("解除绑定成功.");
        return view;
    }
}
