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
import com.qcloud.project.macaovehicle.model.DriverCancel;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.CancelType;
import com.qcloud.project.macaovehicle.model.query.DriverCancelQuery;
import com.qcloud.project.macaovehicle.service.DriverCancelService;
import com.qcloud.project.macaovehicle.web.handler.DriverCancelHandler;
import com.qcloud.project.macaovehicle.web.vo.DriverCancelVO;

@Controller
@RequestMapping(value = DriverCancelController.DIR)
public class DriverCancelController {

    public static final String  DIR = "/driverCancel";

    @Autowired
    private DriverCancelService driverCancelService;

    @Autowired
    private DriverCancelHandler driverCancelHandler;

    @Autowired
    private ClerkHelper         clerkHelper;

    @RequestMapping
    public FrontPagingView list(HttpServletRequest request, Integer pageSize, Integer pageNum, DriverCancelQuery query) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<DriverCancel> page = driverCancelService.page(query, start, PAGE_SIZE);
        List<DriverCancelVO> voList = driverCancelHandler.toVOList(page.getData());
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
        DriverCancel driverCancel = driverCancelService.get(id);
        AssertUtil.assertNotNull(driverCancel, "此数据不存在." + id);
        driverCancel.setState(CancelType.DONE.getKey());
        driverCancelService.update(driverCancel);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("修改成功.");
        return view;
    }
}
