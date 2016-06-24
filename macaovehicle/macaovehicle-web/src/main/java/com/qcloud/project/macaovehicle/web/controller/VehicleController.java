package com.qcloud.project.macaovehicle.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.autoid.UniqueCodeGenerator;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.OnestopCarRecord;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.VehicleCancel;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.CancelType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.CarModels;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.FuelType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.SteeringWheel;
import com.qcloud.project.macaovehicle.model.query.DriverVehicleQuery;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;
import com.qcloud.project.macaovehicle.model.query.VehicleQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.service.OnestopCarRecordService;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;
import com.qcloud.project.macaovehicle.service.ProfilesSuccessService;
import com.qcloud.project.macaovehicle.service.VehicleCancelService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.VehicleHandler;
import com.qcloud.project.macaovehicle.web.helper.StateHelper;
import com.qcloud.project.macaovehicle.web.vo.VehicleKeyValueVO;
import com.qcloud.project.macaovehicle.web.vo.VehicleVO;

@Controller
@RequestMapping(value = VehicleController.DIR)
public class VehicleController {

    public static final String      DIR = "/vehicle";

    @Autowired
    private VehicleService          vehicleService;

    @Autowired
    private VehicleHandler          vehicleHandler;

    @Autowired
    private CarOwnerService         carOwnerService;

    @Autowired
    private ClerkHelper             clerkHelper;

    @Autowired
    private ProfilesSuccessService  profilesSuccessService;

    @Autowired
    private DriverVehicleService    driverVehicleService;

    @Autowired
    private VehicleCancelService    vehicleCancelService;

    @Autowired
    private UniqueCodeGenerator     uniqueCodeGenerator;

    @Autowired
    private OnestopCarRecordService onestopCarRecordService;

    @Autowired
    private StateHelper             stateHelper;

    @Autowired
    private ProcessProgressService  processProgressService;

    @RequestMapping
    public FrontAjaxView list(HttpServletRequest request, VehicleQuery query) {

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

    @RequestMapping
    public FrontAjaxView listAvail(HttpServletRequest request, Integer type) {

        AssertUtil.greatZero(type, "流程类型不能为空.");
        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        List<Vehicle> list = vehicleService.listByCarOwner(carOwner.getId());
        Iterator<Vehicle> it = list.iterator();
        switch (type) {
        case 1: // 入境申请
            while (it.hasNext()) {
                Vehicle vehicle = it.next();
                DriverVehicleQuery query = new DriverVehicleQuery();
                query.setVehicleId(vehicle.getId());
                List<DriverVehicle> driverVehicles = driverVehicleService.listByQuery(query);
                for (DriverVehicle dv : driverVehicles) {
                    ProcessProgress pp = processProgressService.getByFormInstanceId(dv.getFormInstanceId());
                    AssertUtil.assertNotNull(pp, "流程不存在." + dv.getFormInstanceId());
                    // 流程状态为“申请”并且状态为“通过”的车辆，不能再次申请入境
                    if (pp.getType() == ProgressState.SHENGQIN.getKey() && pp.getState() == ApplyType.PASS.getKey()) {
                        it.remove();
                        break;
                    }
                }
            }
            break;
        case 2: // 添加驾驶员
            break;
        default:
            throw new MacaovehicleException("流程类型非法.");
        }
        List<VehicleVO> volist = vehicleHandler.toVOList(list);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("result", volist);
        view.setMessage("查询成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView add(HttpServletRequest request, Vehicle vehicle) {

        AssertUtil.assertNotEmpty(vehicle.getPlateNumber(), "录入的车牌号不能为空");
        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        Vehicle temp = vehicleService.getByPlateNumber(vehicle.getPlateNumber());
        AssertUtil.assertTrue(temp == null, "车牌号已存在." + vehicle.getPlateNumber());
        vehicle.setCarOwnerId(carOwner.getId());
        vehicleService.add(vehicle);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加车辆信息成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView delete(HttpServletRequest request, long vehicleId) {

        AssertUtil.assertNotNull(vehicleId, "ID不能为空");
        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        Vehicle vehicle = vehicleService.get(vehicleId);
        AssertUtil.assertNotNull(vehicle, "车辆信息不存在." + vehicleId);
        AssertUtil.assertTrue(carOwner.getId() == vehicle.getCarOwnerId(), "只能删除自己的资料");
        if (carOwner.getId() != vehicle.getCarOwnerId()) {
            throw new MacaovehicleException("只能删除自己的资料");
        }
        DriverVehicleQuery query = new DriverVehicleQuery();
        query.setVehicleId(vehicleId);
        List<DriverVehicle> driverVehicles = driverVehicleService.listByQuery(query);
        if (driverVehicles.size() > 0) {
            throw new MacaovehicleException("该车辆已申请过资料，无法删除.");
        }
        vehicleService.delete(vehicleId);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("删除成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView edit(HttpServletRequest request, Vehicle vehicle) {

        AssertUtil.greatZero(vehicle.getId(), "ID不能为空");
        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        Vehicle temp = vehicleService.get(vehicle.getId());
        AssertUtil.assertTrue(temp.getCarOwnerId() == carOwner.getId(), "只能修改自己的资料");
        // 不允许修改车牌号
        vehicle.setCarOwnerId(carOwner.getId());
        // vehicle.setPlateNumber(temp.getPlateNumber());
        vehicleService.update(vehicle);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("修改成功 !!");
        return view;
    }

    @RequestMapping
    public FrontAjaxView get(long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        Vehicle vehicle = vehicleService.get(id);
        VehicleVO vo = vehicleHandler.toVO(vehicle);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("详情信息");
        view.addObject("result", vo);
        return view;
    }

    // 准驾车型
    @RequestMapping
    public FrontAjaxView carModels() {

        CarModels carModels[] = CarModels.values();
        List<KeyValueVO> keyValueVOs = new ArrayList<KeyValueVO>();
        for (CarModels models : carModels) {
            KeyValueVO vo = new KeyValueVO();
            vo.setKey(String.valueOf(models.getKey()));
            vo.setValue(models.getName());
            keyValueVOs.add(vo);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("carModels", keyValueVOs);
        return view;
    }

    // 燃油类型
    @RequestMapping
    public FrontAjaxView FuelType() {

        FuelType fuelTypes[] = FuelType.values();
        List<KeyValueVO> keyValueVOs = new ArrayList<KeyValueVO>();
        for (FuelType type : fuelTypes) {
            KeyValueVO vo = new KeyValueVO();
            vo.setKey(String.valueOf(type.getKey()));
            vo.setValue(type.getName());
            keyValueVOs.add(vo);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("fuelTypes", keyValueVOs);
        return view;
    }

    // 方向盘左/右
    @RequestMapping
    public FrontAjaxView SteeringWheel() {

        SteeringWheel steeringWheels[] = SteeringWheel.values();
        List<KeyValueVO> keyValueVOs = new ArrayList<KeyValueVO>();
        for (SteeringWheel wheels : steeringWheels) {
            KeyValueVO vo = new KeyValueVO();
            vo.setKey(String.valueOf(wheels.getKey()));
            vo.setValue(wheels.getName());
            keyValueVOs.add(vo);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("steeringWheels", keyValueVOs);
        return view;
    }

    @RequestMapping
    public FrontAjaxView listAll() {

        List<Vehicle> list = vehicleService.listAll();
        List<VehicleKeyValueVO> keyValueVOs = new ArrayList<VehicleKeyValueVO>();
        for (Vehicle vehicle : list) {
            VehicleKeyValueVO vo = new VehicleKeyValueVO();
            vo.setId(vehicle.getId());
            vo.setPlateNumber(vehicle.getPlateNumber());
            keyValueVOs.add(vo);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("list", keyValueVOs);
        return view;
    }

    /**
     * 注销车辆
     * @param request
     * @param vehicleId
     * @return
     */
    @RequestMapping
    public FrontAjaxView cancellation(HttpServletRequest request, Long vehicleId) {

        AssertUtil.greatZero(vehicleId, "车辆id不能为空.");
        Vehicle vehicle = vehicleService.get(vehicleId);
        AssertUtil.assertNotNull(vehicle, "车辆不存在." + vehicleId);
        if (!stateHelper.checkAvailType(Long.valueOf(vehicleId), ProgressType.ZXCL)) {
            throw new MacaovehicleException("当前车辆您已不能注销.");
        }
        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        if (carOwner != null) {
            AssertUtil.assertTrue(vehicle.getCarOwnerId() == carOwner.getId(), "此车辆不属于你.");
        } else {
            carOwner = carOwnerService.get(vehicle.getCarOwnerId());
        }
        String formInstCode = uniqueCodeGenerator.generate("pirates-form-loss-code", new HashMap<String, String>());
        vehicle.setRicState(EnableType.DISABLE.getKey());
        // 注销车辆卡id
        if (vehicleService.update(vehicle)) {
            ProfilesSuccessQuery query = new ProfilesSuccessQuery();
            query.setVehicleId(vehicleId);
            query.setvEnable(EnableType.ENABLE.getKey());
            //
            List<ProfilesSuccess> profilesSuccesses = profilesSuccessService.listByQuery(query);
            for (ProfilesSuccess profilesSuccess : profilesSuccesses) {
                profilesSuccess.setvEnable(EnableType.DISABLE.getKey());
                profilesSuccessService.update(profilesSuccess);
            }
        }
        // 注销车辆列表
        VehicleCancel vehicleCancel = new VehicleCancel();
        vehicleCancel.setFormInstCode(formInstCode);
        vehicleCancel.setCarOwnerId(vehicle.getCarOwnerId());
        vehicleCancel.setVehicleId(vehicleId);
        vehicleCancel.setRic(vehicle.getRic());
        vehicleCancel.setPlateNumber(vehicle.getPlateNumber());
        vehicleCancel.setTemporaryplate(vehicle.getTemporaryplate());
        vehicleCancel.setRecordTime(new Date());
        vehicleCancel.setState(CancelType.UNDO.getKey());
        vehicleCancelService.add(vehicleCancel);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("注销车辆成功.");
        return view;
    }

    /**
     * 车辆入境记录（交警续期 - 未审批 - 审批管理 - 续期申请 - 操作：审批）
     * Xxx.do?carOwnerId=xyz
     * @author Kuina.黄嘉明
     * @date 2016-04-29
     */
    @RequestMapping
    public FrontPagingView entryRecord(VehicleQuery query, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Vehicle> page = vehicleService.page(query, start, PAGE_SIZE);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (Vehicle v : page.getData()) {
            Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
            returnMap.put("plateNumber", v.getPlateNumber());// 境外车牌号
            returnMap.put("temporaryplate", v.getTemporaryplate());// 临时号码牌
            mapList.add(returnMap);
        }
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.addObject("result", mapList);
        return view;
    }
}
