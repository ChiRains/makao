package com.qcloud.project.macaovehicle.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.project.macaovehicle.model.DriverTemplate;
import com.qcloud.project.macaovehicle.service.DriverTemplateService;
import com.qcloud.project.macaovehicle.web.handler.DriverTemplateHandler;
import com.qcloud.project.macaovehicle.web.vo.DriverTemplateVO;

@Controller
@RequestMapping(value = DriverTemplateController.DIR)
public class DriverTemplateController {

    public static final String    DIR = "/driverTemplate";

    @Autowired
    private DriverTemplateService driverTemplateService;

    @Autowired
    private DriverTemplateHandler driverTemplateHandler;

    @Autowired
    private ClerkHelper           clerkHelper;

    @RequestMapping
    public FrontAjaxView list(HttpServletRequest request) {

        QClerk user = clerkHelper.getClerkModel(request);
        List<DriverTemplate> drivers = driverTemplateService.listByClerkId(user.getId());
        List<DriverTemplateVO> driverVOs = driverTemplateHandler.toVOList(drivers);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("result", driverVOs);
        view.setMessage("获取驾驶员信息成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView add(HttpServletRequest request, DriverTemplate driver) {

        QClerk user = clerkHelper.getClerkModel(request);
        driver.setCarOwnerId(user.getId());
        driverTemplateService.add(driver);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加驾驶员信息成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView get(HttpServletRequest request, Long id) {

        QClerk user = clerkHelper.getClerkModel(request);
        DriverTemplate driver = driverTemplateService.get(id);
        AssertUtil.assertNotNull(driver, "用户驾驶员信息不存在." + id);
        DriverTemplateVO driverVo = driverTemplateHandler.toVO(driver);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("driver", driverVo);
        view.setMessage("获取驾驶员信息成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView edit(HttpServletRequest request, DriverTemplate driver) {

        QClerk user = clerkHelper.getClerkModel(request);
        DriverTemplate oldDriver = driverTemplateService.get(driver.getId());
        AssertUtil.assertNotNull(oldDriver, "用户驾驶员信息不存在." + driver.getId());
        AssertUtil.assertTrue(user.getId() == oldDriver.getCarOwnerId(), "只能修改自己的资料");
        driver.setCarOwnerId(user.getId());
        driverTemplateService.update(driver);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("编辑驾驶员信息成功.");
        return view;
    }

    @RequestMapping
    public FrontAjaxView deleteAll(HttpServletRequest request) {

        QClerk user = clerkHelper.getClerkModel(request);
        driverTemplateService.deleteByClerkId(user.getId());
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("删除驾驶员信息成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView delete(HttpServletRequest request, Long id) {

        AssertUtil.greatZero(id, "id不能为空.");
        QClerk user = clerkHelper.getClerkModel(request);
        driverTemplateService.delete(id);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("删除驾驶员信息成功." + id);
        return view;
    }
}
