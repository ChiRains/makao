package com.qcloud.project.macaovehicle.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.mvprocesstask.service.TaskedService;
import com.qcloud.component.mvprocesstask.service.TaskingService;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.InstanceMessage;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.InstanceMessageQuery;
import com.qcloud.project.macaovehicle.model.query.ProcessProgressQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.service.InstanceMessageService;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.InstanceMessageHandler;
import com.qcloud.project.macaovehicle.web.handler.ProcessProgressHandler;
import com.qcloud.project.macaovehicle.web.helper.CarOwnerHelper;
import com.qcloud.project.macaovehicle.web.vo.ProcessProgressVO;

@Controller
@RequestMapping(value = ProcessProgressController.DIR)
public class ProcessProgressController {

    public static final String     DIR = "/processProgress";

    @Autowired
    private ProcessProgressService processProgressService;

    @Autowired
    private ProcessProgressHandler processProgressHandler;

    @Autowired
    private ClerkHelper            clerkHelper;

    @Autowired
    private CarOwnerService        carOwnerService;

    @Autowired
    private DriverVehicleService   driverVehicleService;

    @Autowired
    private VehicleService         vehicleService;

    @Autowired
    private DriverService          driverService;

    @Autowired
    private InstanceMessageService instanceMessageService;

    @Autowired
    private InstanceMessageHandler instanceMessageHandler;

    @Autowired
    private TaskingService         taskingService;

    @Autowired
    private TaskedService          taskedService;

    @RequestMapping
    public FrontPagingView list(HttpServletRequest request, ProcessProgressQuery query, Integer pageNum, Integer pageSize) {

        QClerk clerk = clerkHelper.getClerkModel(request);
        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        query.setCarOwnerId(carOwner.getId());
        Page<ProcessProgress> page = processProgressService.page(query, start, PAGE_SIZE);
        List<ProcessProgressVO> voList = processProgressHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, pageSize, page.getCount());
        view.addObject("list", voList);
        return view;
    }

    @RequestMapping
    public FrontAjaxView get(HttpServletRequest request, Long formInstanceId, Integer messageSize) {

        AssertUtil.greatZero(formInstanceId, "流程实例id不能为空.");
        QClerk clerk = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        ProcessProgress processProgress = processProgressService.get(carOwner.getId(), formInstanceId);
        AssertUtil.assertNotNull(processProgress, "流程状态不存在." + formInstanceId);
        List<DriverVehicle> driverVehicleList = driverVehicleService.getListByFormInstanceId(formInstanceId);
        List<Driver> driverList = new ArrayList<Driver>();
        // 车辆、驾驶员信息
        Vehicle vehicle = null;
        for (DriverVehicle driverVehicle : driverVehicleList) {
            Driver driver = driverService.get(driverVehicle.getDriverId());
            if (vehicle == null) {
                vehicle = vehicleService.get(driverVehicle.getVehicleId());
            }
            driverList.add(driver);
        }
        // 消息
        InstanceMessageQuery query = new InstanceMessageQuery();
        query.setFormInstanceId(formInstanceId);
        Page<InstanceMessage> instanceMessagePage = instanceMessageService.page(query, 0, messageSize > 0 ? messageSize : 2);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("processProgress", processProgress);
        view.addObject("vehicle", vehicle);
        view.addObject("driverList", driverList);
        view.addObject("instanceMessageList", instanceMessageHandler.toVOList(instanceMessagePage.getData()));
        return view;
    }

    /**
     * 审批端的进度总览
     */
    @RequestMapping
    public FrontPagingView listType(HttpServletRequest request, ProcessProgressQuery query, Integer pageNum, Integer pageSize) {

        QClerk clerk = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        // 过滤门户网的用户
        AssertUtil.assertTrue(carOwner == null, "你不具备查看这个接口的权利.");
        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<ProcessProgress> page = new Page<ProcessProgress>();
        List<ProcessProgressVO> voList = new ArrayList<ProcessProgressVO>();
        switch (query.getType()) {
        case 1:
            query.setType(ProgressType.APPLY.getKey());
            page = processProgressService.page(query, start, PAGE_SIZE);
            voList = processProgressHandler.toApproveInfo(page.getData());
            break;
        case 2: // 续期
            query.setType(ProgressType.XQSQ.getKey());
            page = processProgressService.page(query, start, PAGE_SIZE);
            voList = processProgressHandler.toRenewalInfo(page.getData());
            break;
        case 3:
            query.setType(ProgressType.TJJSY.getKey());
            page = processProgressService.page(query, start, PAGE_SIZE);
            voList = processProgressHandler.toPilotInfo(page.getData());
            break;
        default:
            throw new MacaovehicleException("类型type非法.");
        }
        FrontPagingView view = new FrontPagingView(pageNum, pageSize, page.getCount());
        view.addObject("list", voList);
        return view;
    }

    /**
     * 撤回申请-未经管委会审批
     */
    @RequestMapping
    public FrontAjaxView rollBack(HttpServletRequest request, Long id) {

        AssertUtil.greatZero(id, "id不能为空.");
        ProcessProgress processProgress = processProgressService.get(id);
        AssertUtil.assertNotNull(processProgress, "此数据不存在." + id);
        QClerk clerk = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        if (processProgress.getCarOwnerId() != carOwner.getId()) {
            throw new MacaovehicleException("此数据不属于你.");
        }
        if (processProgress.getProgressState() != ProgressState.SHENGQIN.getKey()) {
            throw new MacaovehicleException("撤回失败，必须未经过审批才能进行取消.");
        }
        if (processProgressService.delete(id)) {
            Tasking tasking = taskingService.getByFormInstanceId(processProgress.getFormInstanceId());
            AssertUtil.assertNotNull(tasking, "任务不存在." + processProgress.getFormInstanceId());
            taskingService.delete(tasking.getId());
            List<DriverVehicle> driverVehicles = driverVehicleService.getListByFormInstanceId(processProgress.getFormInstanceId());
            for (DriverVehicle driverVehicle : driverVehicles) {
                driverVehicleService.delete(driverVehicle.getId());
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("撤回成功.");
        return view;
    }

    /**
     * 获取门户网可申请车辆数量
     * @param request
     * @return
     */
    @RequestMapping
    public FrontAjaxView getAvailVehicle(HttpServletRequest request) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "车主信息不存在.");
        CarOwnerHelper carOwnerHelper = new CarOwnerHelper();
        ProcessProgressQuery query = new ProcessProgressQuery();
        query.setState(ApplyType.PASS.getKey());
        query.setCarOwnerId(carOwner.getId());
        query.setType(ProgressType.APPLY.getKey());
        List<ProcessProgress> data = processProgressService.listByQuery(query);
        int availCount = carOwnerHelper.getAvailVehicle(carOwner.getClerkType(), carOwner.getType());
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("result", availCount - data.size());
        view.setMessage("获取车辆可申请数量成功.");
        return view;
    }
}
