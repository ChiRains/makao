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
import com.qcloud.project.macaovehicle.model.IllegalOwnerRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalOwnerRecordQuery;
import com.qcloud.project.macaovehicle.service.IllegalOwnerRecordService;
import com.qcloud.project.macaovehicle.web.handler.IllegalOwnerRecordHandler;
import com.qcloud.project.macaovehicle.web.vo.IllegalOwnerRecordVO;

/**
 * 人员诚信记录
 */
@Controller
@RequestMapping(value = IllegalOwnerRecordController.DIR)
public class IllegalOwnerRecordController {

    public static final String        DIR = "/illegalOwnerRecord";

    @Autowired
    private IllegalOwnerRecordService illegalOwnerRecordService;

    @Autowired
    private IllegalOwnerRecordHandler illegalOwnerRecordHandler;

    @Autowired
    private ClerkHelper               clerkHelper;

    @RequestMapping
    public FrontPagingView list(HttpServletRequest request, Integer pageSize, Integer pageNum, IllegalOwnerRecordQuery query) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<IllegalOwnerRecord> page = illegalOwnerRecordService.page(query, start, PAGE_SIZE);
        List<IllegalOwnerRecordVO> voList = illegalOwnerRecordHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.setMessage("查询成功");
        view.addObject("result", voList);
        return view;
    }

    @RequestMapping
    public FrontAjaxView add(HttpServletRequest request, IllegalOwnerRecord illegalOwnerRecord) {

        QClerk clerk = clerkHelper.getClerkModel(request);
        AssertUtil.assertNotNull(clerk, "请重新登录");
        illegalOwnerRecord.setDepartmentId(clerk.getDepartmentId());
        illegalOwnerRecord.setCreateTime(new Date());
        illegalOwnerRecord.setClerkId(clerk.getId());
        boolean isOK = illegalOwnerRecordService.add(illegalOwnerRecord);
        AssertUtil.assertTrue(isOK, "添加失败!");
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加成功.");
        return view;
    }

    @RequestMapping
    public FrontAjaxView get(Long id) {

        IllegalOwnerRecord illegalOwnerRecord = illegalOwnerRecordService.get(id);
        IllegalOwnerRecordVO illegalOwnerRecordVO = illegalOwnerRecordHandler.toVO(illegalOwnerRecord);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("获取信息成功");
        view.addObject("result", illegalOwnerRecordVO);
        return view;
    }

    @RequestMapping
    public FrontAjaxView edit(HttpServletRequest request, IllegalOwnerRecord illegalOwnerRecord) {

        AssertUtil.greatZero(illegalOwnerRecord.getId(), "标识id不能为空!");
        IllegalOwnerRecord illegalOwner = illegalOwnerRecordService.get(illegalOwnerRecord.getId());
        QClerk clerk = clerkHelper.getClerkModel(request);
        if (clerk.getId() != illegalOwner.getClerkId()) {
            throw new MacaovehicleException("您不具备修改此数据的权利.");
        }
        AssertUtil.assertNotNull(illegalOwner, "此诚信记录不存在." + illegalOwnerRecord.getId());
        illegalOwner.setCertificates(illegalOwnerRecord.getCertificates());
        illegalOwner.setCertificatesNo(illegalOwnerRecord.getCertificatesNo());
        illegalOwner.setName(illegalOwnerRecord.getName());
        illegalOwner.setDesc(illegalOwnerRecord.getDesc());
        boolean isOK = illegalOwnerRecordService.update(illegalOwner);
        AssertUtil.assertTrue(isOK, "修改失败!");
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("修改成功.");
        return view;
    }

    @RequestMapping
    public FrontAjaxView del(HttpServletRequest request, Long id) {

        QClerk clerk = clerkHelper.getClerkModel(request);
        IllegalOwnerRecord illegalOwnerRecord = illegalOwnerRecordService.get(id);
        if (illegalOwnerRecord.getDepartmentId() != clerk.getDepartmentId()) {
            throw new MacaovehicleException("您不具备删除此数据的权利.");
        }
        illegalOwnerRecordService.delete(id);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("刪除成功.");
        return view;
    }
}
