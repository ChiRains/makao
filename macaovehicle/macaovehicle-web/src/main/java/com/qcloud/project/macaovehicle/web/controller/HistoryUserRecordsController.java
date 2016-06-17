package com.qcloud.project.macaovehicle.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.HistoryUserRecords;
import com.qcloud.project.macaovehicle.model.InstanceMessage;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.query.HistoryUserRecordsQuery;
import com.qcloud.project.macaovehicle.model.query.InstanceMessageQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.HistoryUserRecordsService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.HistoryUserRecordsHandler;
import com.qcloud.project.macaovehicle.web.vo.HistoryUserRecordsVO;
import com.qcloud.project.macaovehicle.web.vo.InstanceMessageVO;

@Controller
@RequestMapping(value = HistoryUserRecordsController.DIR)
public class HistoryUserRecordsController {

    public static final String        DIR = "/historyUserRecords";

    @Autowired
    private HistoryUserRecordsService historyUserRecordsService;

    @Autowired
    private HistoryUserRecordsHandler historyUserRecordsHandler;

    @Autowired
    private ClerkHelper               clerkHelper;

    @Autowired
    private VehicleService            vehicleService;

    @Autowired
    private CarOwnerService           carOwnerService;

    @RequestMapping
    public FrontPagingView list(HttpServletRequest request, HistoryUserRecordsQuery query, PPage pPage) {

        AssertUtil.greatZero(query.getVehicleId(), "车辆id不能为空.");
        Clerk clerk = clerkHelper.getClerk(request);
        Vehicle vehicle = vehicleService.get(query.getVehicleId());
        AssertUtil.assertNotNull(vehicle, "车辆不存在." + query.getVehicleId());
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        if (vehicle.getCarOwnerId() != carOwner.getId()) {
            throw new MacaovehicleException("你不具备查看别人车辆的权限.");
        }
        Page<HistoryUserRecords> page = historyUserRecordsService.page(query, pPage.getPageStart(), pPage.getPageSize());
        List<HistoryUserRecordsVO> voList = historyUserRecordsHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pPage.getPageNum(), pPage.getPageSize(), page.getCount());
        view.setList(voList);
        return view;
    }
}
