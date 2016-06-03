package com.qcloud.project.macaovehicle.web.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.IllegalPoliceRecord;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.query.IllegalPoliceRecordQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.IllegalPoliceRecordService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.IllegalPoliceRecordHandler;
import com.qcloud.project.macaovehicle.web.vo.IllegalPoliceRecordVO;

/**
 * 车辆违章记录
 */
@Controller
@RequestMapping(value = IllegalPoliceRecordController.DIR)
public class IllegalPoliceRecordController {

    public static final String         DIR = "/illegalPoliceRecord";

    @Autowired
    private IllegalPoliceRecordService illegalPoliceRecordService;

    @Autowired
    private IllegalPoliceRecordHandler illegalPoliceRecordHandler;

    @Autowired
    private VehicleService             vehicleService;

    @Autowired
    private OrganizationClient         organizationClient;

    @Autowired
    private ClerkHelper                clerkHelper;

    @Autowired
    private CarOwnerService            carOwnerService;

    @RequestMapping
    public FrontAjaxView add(HttpServletRequest request, IllegalPoliceRecord illegalPoliceRecord) {

        AssertUtil.assertNotNull(illegalPoliceRecord.getPlateNumber(), "车辆号码不能为空!");
        Vehicle vehicle = vehicleService.getByPlateNumber(illegalPoliceRecord.getPlateNumber());
        AssertUtil.assertNotNull(vehicle, "境外车牌号不存在." + illegalPoliceRecord.getPlateNumber());
        Clerk clerk = clerkHelper.getClerk(request);
        AssertUtil.assertNotNull(clerk, "用户不存在." + clerk.getId());
        QClerk qClerk = organizationClient.getClerk(clerk.getId());
        AssertUtil.assertNotNull(qClerk, "用户不存在." + clerk.getId());
        illegalPoliceRecord.setCarOwnerId(vehicle.getCarOwnerId());
        illegalPoliceRecord.setDepartmentId(qClerk.getDepartmentId());
        illegalPoliceRecord.setCreateTime(new Date());
        illegalPoliceRecord.setClerkId(clerk.getId());
        boolean isOK = illegalPoliceRecordService.add(illegalPoliceRecord);
        AssertUtil.assertTrue(isOK, "添加失败!");
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加成功.");
        return view;
    }

    /**
     * 审批端-车辆违章列表
     * @param request
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontPagingView list(HttpServletRequest request, IllegalPoliceRecordQuery query, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Clerk clerk = clerkHelper.getClerk(request);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        AssertUtil.assertTrue(carOwner == null, "角色无访问权限.");
        Page<IllegalPoliceRecord> page = illegalPoliceRecordService.page(query, start, PAGE_SIZE);
        List<IllegalPoliceRecordVO> voList = illegalPoliceRecordHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.addObject("result", voList);
        return view;
    }

    /**
     * 门户网-车辆违章列表
     * @param request
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontPagingView listCarOwner(HttpServletRequest request, IllegalPoliceRecordQuery query, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Clerk clerk = clerkHelper.getClerk(request);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        AssertUtil.assertNotNull(carOwner, "车主clerk不存在." + clerk.getId());
        query.setCarOwnerId(carOwner.getId());
        Page<IllegalPoliceRecord> page = illegalPoliceRecordService.page(query, start, PAGE_SIZE);
        List<IllegalPoliceRecordVO> voList = illegalPoliceRecordHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.addObject("result", voList);
        return view;
    }

    @RequestMapping
    public FrontAjaxView get(HttpServletRequest request, Long id) {

        AssertUtil.greatZero(id, "id不能为空.");
        IllegalPoliceRecord illegalPoliceRecord = illegalPoliceRecordService.get(id);
        IllegalPoliceRecordVO vo = illegalPoliceRecordHandler.toVO(illegalPoliceRecord);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("illegalPoliceRecord", vo);
        return view;
    }

    @RequestMapping
    public FrontAjaxView update(HttpServletRequest request, IllegalPoliceRecord illegalPoliceRecord) {

        AssertUtil.greatZero(illegalPoliceRecord.getId(), "id不能为空.");
        IllegalPoliceRecord ieg = illegalPoliceRecordService.get(illegalPoliceRecord.getId());
        AssertUtil.assertNotNull(ieg, "此违章信息不存在." + illegalPoliceRecord.getId());
        Clerk clerk = clerkHelper.getClerk(request);
        if (ieg.getClerkId() != clerk.getId()) {
            throw new MacaovehicleException("此数据不属于您.未具备更改的权利");
        }
        illegalPoliceRecord.setCreateTime(new Date());
        illegalPoliceRecord.setClerkId(ieg.getClerkId());
        illegalPoliceRecord.setDepartmentId(ieg.getDepartmentId());
        illegalPoliceRecord.setCarOwnerId(ieg.getCarOwnerId());
        illegalPoliceRecordService.update(illegalPoliceRecord);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("更改成功.");
        return view;
    }

    @RequestMapping
    public FrontAjaxView delete(HttpServletRequest request, Long id) {

        AssertUtil.greatZero(id, "id不能为空.");
        IllegalPoliceRecord ieg = illegalPoliceRecordService.get(id);
        AssertUtil.assertNotNull(ieg, "此违章信息不存在." + id);
        Clerk clerk = clerkHelper.getClerk(request);
        if (ieg.getClerkId() != clerk.getId()) {
            throw new MacaovehicleException("此数据不属于您.未具备更改的权利");
        }
        illegalPoliceRecordService.delete(id);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("更改成功.");
        return view;
    }
}
