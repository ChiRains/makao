package com.qcloud.project.macaovehicle.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.autoid.UniqueCodeGenerator;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.DriverCancel;
import com.qcloud.project.macaovehicle.model.DriverLoss;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.CancelType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.LossType;
import com.qcloud.project.macaovehicle.model.query.DriverVehicleQuery;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.DriverCancelService;
import com.qcloud.project.macaovehicle.service.DriverLossService;
import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.service.ProfilesSuccessService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.util.StringUtil;
import com.qcloud.project.macaovehicle.web.handler.DriverHandler;
import com.qcloud.project.macaovehicle.web.vo.DriverVO;

@Controller
@RequestMapping(value = DriverController.DIR)
public class DriverController {

    public static final String     DIR = "/driver";

    @Autowired
    private DriverService          driverService;

    @Autowired
    private DriverHandler          driverHandler;

    // @Autowired
    // private UserHelper userHelper;
    @Autowired
    private CarOwnerService        carOwnerService;

    @Autowired
    private ClerkHelper            clerkHelper;

    @Autowired
    private DriverVehicleService   driverVehicleService;

    @Autowired
    private ProfilesSuccessService profilesSuccessService;

    @Autowired
    private DriverCancelService    driverCancelService;

    @Autowired
    private UniqueCodeGenerator    uniqueCodeGenerator;

    @Autowired
    private VehicleService         vehicleService;

    @Autowired
    private DriverLossService      driverLossService;

    @RequestMapping
    public FrontAjaxView add(HttpServletRequest request, Driver driver) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        Driver temp = driverService.getByName(driver.getDriverName(), carOwner.getId());
        AssertUtil.assertTrue(temp == null, "驾驶员已存在." + driver.getDriverName());
        //
        driver.setSeconddrivername(StringUtil.emptyToData(driver.getSeconddrivername()));
        driver.setSecondbirthday(StringUtil.emptyToData(driver.getSecondbirthday()));
        driver.setCarOwnerId(carOwner.getId());
        driverService.add(driver);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加驾驶员信息成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView get(HttpServletRequest request, Long id) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        Driver driver = driverService.get(id);
        AssertUtil.assertNotNull(driver, "用户驾驶员信息不存在." + id);
        AssertUtil.assertTrue(carOwner.getId() == driver.getCarOwnerId(), "只能获取自己的资料");
        DriverVO driverVo = driverHandler.toVO(driver);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("driver", driverVo);
        view.setMessage("获取驾驶员信息成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView edit(HttpServletRequest request, Driver driver) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        Driver oldDriver = driverService.get(driver.getId());
        AssertUtil.assertNotNull(oldDriver, "用户驾驶员信息不存在." + driver.getId());
        AssertUtil.assertTrue(carOwner.getId() == oldDriver.getCarOwnerId(), "只能修改自己的资料");
        //
        Driver temp = driverService.getByName(driver.getDriverName(), carOwner.getId());
        //
        if (temp != null) {
            if (temp.getId() != driver.getId()) {
                throw new MacaovehicleException("驾驶员已存在." + driver.getDriverName());
            }
        }
        driver.setCarOwnerId(carOwner.getId());
        driverService.update(driver);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("编辑驾驶员信息成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView list(HttpServletRequest request, Integer state) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        List<Driver> drivers = new ArrayList<Driver>();
        // 0入境申请 1添加驾驶员
        switch (state) {
        case 0:
            drivers = driverService.listByCarOwner(carOwner.getId());
            break;
        case 1:
            drivers = driverService.listByCarOwner(carOwner.getId());
            break;
        default:
            throw new MacaovehicleException("非法的流程业务类型");
        }
        List<DriverVO> driverVOs = driverHandler.toVOList(drivers);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("result", driverVOs);
        view.setMessage("获取驾驶员信息成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView listAvail(HttpServletRequest request, Long vehicleId, Integer type) {

        AssertUtil.greatZero(type, "流程类型不能为空.");
        // AssertUtil.greatZero(vehicleId, "车辆id不能为空.");
        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        List<Driver> drivers = driverService.listByCarOwner(carOwner.getId());
        Iterator<Driver> it = drivers.iterator();
        switch (type) {
        case 1: // 入境申请-驾驶员列表
            while (it.hasNext()) {
                if (vehicleId <= 0) break;
                DriverVehicleQuery query = new DriverVehicleQuery();
                query.setVehicleId(vehicleId);
                it.next();
                List<DriverVehicle> driverVehicles = driverVehicleService.listByQuery(query);
                if (driverVehicles.size() > 0) {
                    // drivers.clear();
                    break;
                }
            }
            break;
        case 2: // 添加驾驶员-驾驶员列表
            while (it.hasNext()) {
                Driver driver = it.next();
                DriverVehicleQuery query = new DriverVehicleQuery();
                query.setDriverId(driver.getId());
                query.setVehicleId(vehicleId);
                List<DriverVehicle> driverVehicles = driverVehicleService.listByQuery(query);
                if (driverVehicles.size() > 0) {
                    it.remove();
                }
            }
            break;
        default:
            throw new MacaovehicleException("流程类型非法.");
        }
        List<DriverVO> driverVOs = driverHandler.toVOList(drivers);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("查询成功.");
        view.addObject("result", driverVOs);
        return view;
    }

    @RequestMapping
    public FrontAjaxView delete(HttpServletRequest request, Long driverId) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        Driver oldDriver = driverService.get(driverId);
        AssertUtil.assertNotNull(oldDriver, "用户驾驶员信息不存在." + driverId);
        if (carOwner.getId() != oldDriver.getCarOwnerId()) {
            throw new MacaovehicleException("只能删除自己的资料");
        }
        DriverVehicleQuery query = new DriverVehicleQuery();
        query.setDriverId(driverId);
        List<DriverVehicle> driverVehicles = driverVehicleService.listByQuery(query);
        if (driverVehicles.size() > 0) {
            throw new MacaovehicleException("该驾驶员已申请过资料，无法删除.");
        }
        driverService.delete(driverId);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("删除驾驶员信息成功");
        return view;
    }

    // @RequestMapping
    // public ModelAndView list(PPage pPage)
    // {
    // ProcessProgressQuery processProgressQuery=new ProcessProgressQuery();
    // List<ProcessProgress> processProgresses=processProgressService.listByQuery(processProgressQuery);
    // List<String> formInstCodes=new ArrayList<String>();
    // List<Driver> driverList=new ArrayList<Driver>();
    // for (ProcessProgress processProgress : processProgresses) {
    // formInstCodes.add(processProgress.getFormInstCode());
    // }
    // DriverVehicleQuery driverVehicleQuery=new DriverVehicleQuery();
    // List<DriverVehicle> driverVehicles=null;
    // for (String formInstCode : formInstCodes) {
    // driverVehicleQuery.setFormInstCode(formInstCode);
    // driverVehicles=driverVehicleService.listByQuery(driverVehicleQuery);
    // }
    // for (DriverVehicle driverVehicle : driverVehicles) {
    // driverList.add(driverService.get(driverVehicle.getDriverId()));
    // }
    // FrontPagingView frontPagingView=new FrontPagingView(pPage.getPageNum(),
    // pPage.getPageSize(), driverList.size());
    // frontPagingView.addObject("result", driverList);
    // return frontPagingView;
    // }
    //
    /**
     * 注销驾驶员
     * @param request
     * @param driverId
     * @return
     */
    @RequestMapping
    public FrontAjaxView cancellation(HttpServletRequest request, Long driverId) {

        AssertUtil.greatZero(driverId, "驾驶员id不能为空.");
        Driver driver = driverService.get(driverId);
        AssertUtil.assertNotNull(driver, "驾驶员不存在." + driverId);
        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        if (carOwner != null) {
            AssertUtil.assertTrue(driver.getCarOwnerId() == carOwner.getId(), "此车辆不属于你.");
        } else {
            carOwner = carOwnerService.get(driver.getCarOwnerId());
        }
        // 补办驾驶员卡
        List<DriverLoss> driverLosses = driverLossService.listByDriver(driverId);
        for (DriverLoss driverLoss : driverLosses) {
            if (driverLoss.getType() == LossType.BB.getKey()) {
                throw new MacaovehicleException("该司机卡在处理中，注销申请失败.");
            }
        }
        // 注销驾驶员
        List<DriverCancel> driverCancels = driverCancelService.listByDriver(driverId);
        for (DriverCancel driverCancel : driverCancels) {
            if (driverCancel.getState() == CancelType.UNDO.getKey()) {
                throw new MacaovehicleException("该驾驶员已申请注销.");
            }
        }
        String formInstCode = uniqueCodeGenerator.generate("pirates-form-loss-code", new HashMap<String, String>());
        // driver.setDriverIcState(EnableType.DISABLE.getKey());
        Date nowDate = new Date();
        // 注销驾驶员卡id
        if (driverService.update(driver)) {
            ProfilesSuccessQuery query = new ProfilesSuccessQuery();
            query.setDriverId(driverId);
            query.setdEnable(EnableType.ENABLE.getKey());
            //
            List<ProfilesSuccess> profilesSuccesses = profilesSuccessService.listByQuery(query);
            for (ProfilesSuccess profilesSuccess : profilesSuccesses) {
                Vehicle vehicle = vehicleService.get(profilesSuccess.getVehicleId());
                // profilesSuccess.setdEnable(EnableType.DISABLE.getKey());
                // profilesSuccessService.update(profilesSuccess);
                // 注销驾驶员列表
                DriverCancel driverCancel = new DriverCancel();
                driverCancel.setFormInstCode(formInstCode);
                driverCancel.setCarOwnerId(driver.getCarOwnerId());
                driverCancel.setVehicleId(profilesSuccess.getVehicleId());
                driverCancel.setDriverId(driverId);
                driverCancel.setDriverName(driver.getDriverName());
                driverCancel.setCertificateType(driver.getCertificateType());
                driverCancel.setCertificateNo(driver.getCertificateNo());
                driverCancel.setPlateNumber(vehicle.getPlateNumber());
                driverCancel.setTemporaryplate(vehicle.getTemporaryplate());
                driverCancel.setRecordTime(nowDate);
                driverCancel.setDriverIc(driver.getDriverIc());
                driverCancel.setState(CancelType.UNDO.getKey());
                driverCancelService.add(driverCancel);
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("申请注销驾驶员成功.");
        return view;
    }
}
