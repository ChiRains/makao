package com.qcloud.project.macaovehicle.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.autoid.UniqueCodeGenerator;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.VehicleLoss;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.LossType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.VehicleLossQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;
import com.qcloud.project.macaovehicle.service.VehicleLossService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.VehicleLossHandler;
import com.qcloud.project.macaovehicle.web.vo.VehicleLossVO;

@Controller
@RequestMapping(value = VehicleLossController.DIR)
public class VehicleLossController {

    public static final String     DIR = "/vehicleLoss";

    @Autowired
    private VehicleLossService     vehicleLossService;

    @Autowired
    private VehicleLossHandler     vehicleLossHandler;

    @Autowired
    private VehicleService         vehicleService;

    @Autowired
    private CarOwnerService        carOwnerService;

    @Autowired
    private ClerkHelper            clerkHelper;

    @Autowired
    private UniqueCodeGenerator    uniqueCodeGenerator;

    @Autowired
    private ProcessProgressService processProgressService;

    /**
    * 挂失电子车卡
    * @return
    */
    @RequestMapping
    public FrontAjaxView lossVehicle(HttpServletRequest request, Long vehicleId) {

        AssertUtil.greatZero(vehicleId, "车辆id不能为空.");
        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        Vehicle vehicle = vehicleService.get(vehicleId);
        AssertUtil.assertNotNull(vehicle, "此车辆不存在." + vehicleId);
        if (vehicle.getRicState() != EnableType.ENABLE.getKey()) {
            throw new MacaovehicleException("该车辆还未拥有可用的电子车卡.");
        }
        // TODO 交通物联网标记车卡挂失,定时器推
        VehicleLoss v = vehicleLossService.getByVehicleId(vehicleId);
        if (v != null) {
            if (v.getType() != LossType.DONE.getKey()) {
                throw new MacaovehicleException("该车卡已在处理中...");
            }
            v.setOldRic(vehicle.getRic());
            v.setLossTime(new Date());
            v.setType(LossType.GS.getKey());
            vehicleLossService.update(v);
        } else {
            VehicleLoss vehicleLoss = new VehicleLoss();
            vehicleLoss.setFormInstCode(uniqueCodeGenerator.generate("pirates-form-loss-code", new HashMap<String, String>()));
            vehicleLoss.setCarOwnerId(carOwner.getId());
            vehicleLoss.setVehicleId(vehicleId);
            vehicleLoss.setOldRic(vehicle.getRic());
            vehicleLoss.setLossTime(new Date());
            vehicleLoss.setType(LossType.GS.getKey());
            vehicleLossService.add(vehicleLoss);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("挂失电子车卡成功");
        return view;
    }

    /**
     * 电子车卡补卡
     * @return
     */
    @RequestMapping
    public FrontAjaxView fillVehicle(HttpServletRequest request, Long vehicleId) {

        AssertUtil.greatZero(vehicleId, "车辆id不能为空.");
        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        Vehicle vehicle = vehicleService.get(vehicleId);
        AssertUtil.assertNotNull(vehicle, "此车辆不存在." + vehicleId);
        if (carOwner != null) {
            AssertUtil.assertTrue(vehicle.getCarOwnerId() == carOwner.getId(), "该车辆不属于你." + vehicleId);
        } else {
            carOwner = carOwnerService.get(vehicle.getCarOwnerId());
        }
        if (vehicle.getRicState() != EnableType.ENABLE.getKey()) {
            throw new MacaovehicleException("该车辆还未拥有可用的电子车卡.");
        }
        // 交通物联网标记车卡挂失,定时器推
        VehicleLoss v = vehicleLossService.getByVehicleId(vehicleId);
        String formInstCode = uniqueCodeGenerator.generate("pirates-form-loss-code", new HashMap<String, String>());
        if (v != null) {
            if (v.getType() != LossType.DONE.getKey()) {
                throw new MacaovehicleException("该车卡已在处理中...");
            }
            // TODO 交通物联网给的数据,同时更新车辆表
            v.setNewRic("1000001");
            v.setOldRic(vehicle.getRic());
            v.setLossTime(new Date());
            vehicleLossService.update(v);
        } else {
            VehicleLoss vehicleLoss = new VehicleLoss();
            vehicleLoss.setFormInstCode(formInstCode);
            vehicleLoss.setCarOwnerId(carOwner.getId());
            vehicleLoss.setVehicleId(vehicleId);
            // TODO 交通物联网给的数据,同时更新车辆表
            vehicleLoss.setNewRic("100001");
            vehicleLoss.setOldRic(vehicle.getRic());
            vehicleLoss.setLossTime(new Date());
            vehicleLoss.setType(LossType.BB.getKey());
            vehicleLoss.setPlateNumber(vehicle.getPlateNumber());
            vehicleLossService.add(vehicleLoss);
        }
        ProcessProgress processProgress = new ProcessProgress();
        processProgress.setFormInstanceId(-1);
        processProgress.setFormInstCode(formInstCode);
        processProgress.setCarOwnerId(carOwner.getId());
        processProgress.setActivity("补办电子车卡");
        processProgress.setState(ApplyType.PASS.getKey());
        processProgress.setDateStr(DateUtil.date2String(new Date()));
        processProgress.setProgressState(ProgressState.SHENGQIN.getKey());
        processProgress.setType(ProgressType.BBDZCK.getKey());
        processProgress.setVehicleId(vehicleId);
        processProgressService.add(processProgress);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("补办电子车卡成功");
        return view;
    }

    /**
     * 已标记
     * @return
     */
    @RequestMapping
    public FrontAjaxView sign(HttpServletRequest request, Long id) {

        AssertUtil.greatZero(id, "id不能为空.");
        VehicleLoss vehicleLoss = vehicleLossService.get(id);
        vehicleLoss.setType(LossType.DONE.getKey());
        vehicleLossService.update(vehicleLoss);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("标记车辆卡成功.");
        return view;
    }

    @RequestMapping
    public FrontPagingView list(VehicleLossQuery query, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<VehicleLoss> pages = vehicleLossService.page(query, start, PAGE_SIZE);
        List<VehicleLossVO> voList = vehicleLossHandler.toVOList(pages.getData());
        FrontPagingView view = new FrontPagingView(pageNum, pageSize, pages.getCount());
        view.addObject("result", voList);
        return view;
    }
}
