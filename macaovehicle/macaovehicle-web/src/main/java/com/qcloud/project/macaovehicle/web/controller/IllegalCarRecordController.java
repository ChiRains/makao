package com.qcloud.project.macaovehicle.web.controller;

import java.util.Date;
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
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.IllegalCarRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalCarRecordQuery;
import com.qcloud.project.macaovehicle.service.IllegalCarRecordService;
import com.qcloud.project.macaovehicle.web.handler.IllegalCarRecordHandler;
import com.qcloud.project.macaovehicle.web.vo.IllegalCarRecordVO;

/**
 * 车辆诚信记录
 */
@Controller
@RequestMapping(value = IllegalCarRecordController.DIR)
public class IllegalCarRecordController {

    public static final String      DIR = "/illegalCarRecord";

    @Autowired
    private IllegalCarRecordService illegalCarRecordService;

    @Autowired
    private IllegalCarRecordHandler illegalCarRecordHandler;

    @Autowired
    private ClerkHelper             clerkHelper;

    @RequestMapping
    public FrontPagingView list(HttpServletRequest request, Integer pageSize, Integer pageNum, IllegalCarRecordQuery query) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<IllegalCarRecord> page = illegalCarRecordService.page(query, start, PAGE_SIZE);
        List<IllegalCarRecordVO> voList = illegalCarRecordHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.setMessage("查询成功");
        view.addObject("result", voList);
        return view;
    }

    @RequestMapping
    public FrontAjaxView add(HttpServletRequest request, IllegalCarRecord illegalCarRecord) {

        AssertUtil.assertNotNull(illegalCarRecord.getPlateNumber(), "车辆号码不能为空!");
        QClerk clerk = clerkHelper.getClerkModel(request);
        AssertUtil.assertNotNull(clerk, "请重新登录");
        illegalCarRecord.setDepartmentId(clerk.getDepartmentId());
        illegalCarRecord.setCreateTime(new Date());
        illegalCarRecord.setClerkId(clerk.getId());
        boolean isOK = illegalCarRecordService.add(illegalCarRecord);
        AssertUtil.assertTrue(isOK, "添加失败!");
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加成功.");
        return view;
    }

    @RequestMapping
    public FrontAjaxView get(Long id) {

        IllegalCarRecord illegalCarRecord = illegalCarRecordService.get(id);
        IllegalCarRecordVO illegalCarRecordVO = illegalCarRecordHandler.toVO(illegalCarRecord);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("获取信息成功");
        view.addObject("result", illegalCarRecordVO);
        return view;
    }

    @RequestMapping
    public FrontAjaxView edit(HttpServletRequest request, IllegalCarRecord illegalCarRecord) {

        AssertUtil.greatZero(illegalCarRecord.getId(), "标识id不能为空!");
        IllegalCarRecord illegalCar = illegalCarRecordService.get(illegalCarRecord.getId());
        QClerk clerk = clerkHelper.getClerkModel(request);
        if (clerk.getId() != illegalCar.getClerkId()) {
            throw new MacaovehicleException("您不具备修改此数据的权利.");
        }
        AssertUtil.assertNotNull(illegalCar, "此诚信记录不存在." + illegalCarRecord.getId());
        illegalCar.setPlateNumber(illegalCarRecord.getPlateNumber());
        illegalCar.setTplateNumber(illegalCarRecord.getTplateNumber());
        illegalCar.setDesc(illegalCarRecord.getDesc());
        boolean isOK = illegalCarRecordService.update(illegalCar);
        AssertUtil.assertTrue(isOK, "修改失败!");
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("修改成功.");
        return view;
    }

    @RequestMapping
    public FrontAjaxView del(HttpServletRequest request, Long id) {

        QClerk clerk = clerkHelper.getClerkModel(request);
        IllegalCarRecord illegalCar = illegalCarRecordService.get(id);
        if (illegalCar.getDepartmentId() != clerk.getDepartmentId()) {
            throw new MacaovehicleException("您不具备删除此数据的权利.");
        }
        illegalCarRecordService.delete(id);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("刪除成功.");
        return view;
    }
}
