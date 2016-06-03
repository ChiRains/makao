package com.qcloud.project.macaovehicle.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.model.VehicleCancel;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.CancelType;
import com.qcloud.project.macaovehicle.model.query.VehicleCancelQuery;
import com.qcloud.project.macaovehicle.service.VehicleCancelService;
import com.qcloud.project.macaovehicle.web.handler.VehicleCancelHandler;
import com.qcloud.project.macaovehicle.web.vo.VehicleCancelVO;

@Controller
@RequestMapping(value = VehicleCancelController.DIR)
public class VehicleCancelController {

    public static final String   DIR = "/vehicleCancel";

    @Autowired
    private VehicleCancelService vehicleCancelService;

    @Autowired
    private VehicleCancelHandler vehicleCancelHandler;

    @Autowired
    private ClerkHelper          clerkHelper;

    @RequestMapping
    public FrontPagingView list(HttpServletRequest request, Integer pageSize, Integer pageNum, VehicleCancelQuery query) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<VehicleCancel> page = vehicleCancelService.page(query, start, PAGE_SIZE);
        List<VehicleCancelVO> voList = vehicleCancelHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.setMessage("查询成功");
        view.addObject("result", voList);
        return view;
    }

    @RequestMapping
    public FrontAjaxView changeState(HttpServletRequest request, Long id, Integer state) {

        AssertUtil.greatZero(id, "id不能为空.");
        AssertUtil.greatZero(state, "状态不能为空.");
        QClerk clerk = clerkHelper.getClerkModel(request);
        AssertUtil.assertNotNull(clerk, "请重新登录");
        VehicleCancel vehicleCancel = vehicleCancelService.get(id);
        AssertUtil.assertNotNull(vehicleCancel, "此数据不存在." + id);
        vehicleCancel.setState(CancelType.DONE.getKey());
        vehicleCancelService.update(vehicleCancel);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("修改成功.");
        return view;
    }
}
