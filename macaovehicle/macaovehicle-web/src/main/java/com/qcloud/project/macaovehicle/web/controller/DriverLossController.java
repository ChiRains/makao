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
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.DriverLoss;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.LossType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.DriverLossQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.DriverLossService;
import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;
import com.qcloud.project.macaovehicle.web.handler.DriverLossHandler;
import com.qcloud.project.macaovehicle.web.vo.DriverLossVO;

@Controller
@RequestMapping(value = DriverLossController.DIR)
public class DriverLossController {

    public static final String     DIR = "/driverLoss";

    @Autowired
    private DriverLossService      driverLossService;

    @Autowired
    private DriverLossHandler      driverLossHandler;

    @Autowired
    private DriverService          driverService;

    @Autowired
    private CarOwnerService        carOwnerService;

    @Autowired
    private ClerkHelper            clerkHelper;

    @Autowired
    private UniqueCodeGenerator    uniqueCodeGenerator;

    @Autowired
    private ProcessProgressService processProgressService;

    /**
     * 挂失驾驶员卡
     * @return
     */
    @RequestMapping
    public FrontAjaxView lossDriver(HttpServletRequest request, Long driverId) {

        AssertUtil.greatZero(driverId, "车辆id不能为空.");
        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        Driver driver = driverService.get(driverId);
        AssertUtil.assertNotNull(driver, "此车辆不存在." + driverId);
        if (driver.getDriverIcState() != EnableType.ENABLE.getKey()) {
            throw new MacaovehicleException("该驾驶员还未拥有可用的司机卡.");
        }
        // TODO 交通物联网标记司机卡挂失,定时器推
        DriverLoss d = driverLossService.getByDriverId(driverId);
        if (d != null) {
            if (d.getType() != LossType.DONE.getKey()) {
                throw new MacaovehicleException("该司机卡已在处理中...");
            }
            d.setOldDriverIc(driver.getDriverIc());
            d.setLossTime(new Date());
            d.setType(LossType.GS.getKey());
            driverLossService.update(d);
        } else {
            DriverLoss driverLoss = new DriverLoss();
            driverLoss.setFormInstCode(uniqueCodeGenerator.generate("pirates-form-loss-code", new HashMap<String, String>()));
            driverLoss.setCarOwnerId(carOwner.getId());
            driverLoss.setDriverId(driverId);
            driverLoss.setOldDriverIc(driver.getDriverIc());
            driverLoss.setLossTime(new Date());
            driverLoss.setType(LossType.GS.getKey());
            driverLossService.add(driverLoss);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("挂失司机卡成功");
        return view;
    }

    /**
     * 司机卡补卡
     * @return
     */
    @RequestMapping
    public FrontAjaxView fillDriver(HttpServletRequest request, Long driverId) {

        AssertUtil.greatZero(driverId, "车辆id不能为空.");
        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        Driver driver = driverService.get(driverId);
        AssertUtil.assertNotNull(driver, "此驾驶员不存在." + driverId);
        if (driver.getCarOwnerId() != carOwner.getId()) {
            throw new MacaovehicleException("该驾驶员不属于你.");
        }
        if (driver.getDriverIcState() != EnableType.ENABLE.getKey()) {
            throw new MacaovehicleException("该驾驶员还未拥有可用的司机卡.");
        }
        // TODO 交通物联网标记司机卡挂失,定时器推
        DriverLoss d = driverLossService.getByDriverId(driverId);
        String formInstCode = uniqueCodeGenerator.generate("pirates-form-loss-code", new HashMap<String, String>());
        if (d != null) {
            if (d.getType() != LossType.DONE.getKey()) {
                throw new MacaovehicleException("该司机卡已在处理中...");
            }
            d.setNewDriverIc("100002");
            d.setOldDriverIc(driver.getDriverIc());
            d.setLossTime(new Date());
            driverLossService.update(d);
        } else {
            DriverLoss driverLoss = new DriverLoss();
            driverLoss.setFormInstCode(formInstCode);
            driverLoss.setCarOwnerId(carOwner.getId());
            driverLoss.setDriverId(driverId);
            driverLoss.setNewDriverIc("100002");
            driverLoss.setOldDriverIc(driver.getDriverIc());
            driverLoss.setLossTime(new Date());
            driverLoss.setType(LossType.BB.getKey());
            // driverLoss.setPlateNumber(vehicle.getPlateNumber());
            driverLossService.add(driverLoss);
        }
        //
        ProcessProgress processProgress = new ProcessProgress();
        processProgress.setFormInstanceId(-1);
        processProgress.setFormInstCode(formInstCode);
        processProgress.setCarOwnerId(carOwner.getId());
        processProgress.setActivity("补办司机车卡");
        processProgress.setState(ApplyType.PASS.getKey());
        processProgress.setDateStr(DateUtil.date2String(new Date()));
        processProgress.setProgressState(ProgressState.SHENGQIN.getKey());
        processProgress.setType(ProgressType.BBSJK.getKey());
        processProgress.setVehicleId(-1);
        processProgressService.add(processProgress);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("补办司机卡成功");
        return view;
    }

    /**
     * 已标记
     * @return
     */
    @RequestMapping
    public FrontAjaxView sign(HttpServletRequest request, Long id) {

        AssertUtil.greatZero(id, "id不能为空.");
        DriverLoss driverLoss = driverLossService.get(id);
        driverLoss.setType(LossType.DONE.getKey());
        driverLossService.update(driverLoss);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("标记驾驶员卡成功");
        return view;
    }

    @RequestMapping
    public FrontPagingView list(DriverLossQuery query, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<DriverLoss> pages = driverLossService.page(query, start, PAGE_SIZE);
        List<DriverLossVO> voList = driverLossHandler.toVOList(pages.getData());
        FrontPagingView view = new FrontPagingView(pageNum, pageSize, pages.getCount());
        view.addObject("result", voList);
        return view;
    }
}
