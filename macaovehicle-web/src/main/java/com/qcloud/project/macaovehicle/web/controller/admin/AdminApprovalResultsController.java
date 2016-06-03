package com.qcloud.project.macaovehicle.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.service.ApprovalResultsService;
import com.qcloud.project.macaovehicle.web.handler.ApprovalResultsHandler;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalResultState;
import com.qcloud.project.macaovehicle.model.query.ApprovalResultsQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminApprovalResultsVO;

@Controller
@RequestMapping(value = "/" + AdminApprovalResultsController.DIR)
public class AdminApprovalResultsController {

    public static final String     DIR = "admin/approvalResults";

    @Autowired
    private ApprovalResultsService approvalResultsService;

    @Autowired
    private ApprovalResultsHandler approvalResultsHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, ApprovalResultsQuery query) {

        final int PAGE_SIZE = Integer.MAX_VALUE;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<ApprovalResults> page = approvalResultsService.page(query, start, PAGE_SIZE);
        List<AdminApprovalResultsVO> list = approvalResultsHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-ApprovalResults-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/macaovehicle-ApprovalResults-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(ApprovalResults approvalResults) {

        approvalResultsService.add(approvalResults);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        ApprovalResults approvalResults = approvalResultsService.get(id);
        AdminApprovalResultsVO adminApprovalResultsVO = approvalResultsHandler.toVO4Admin(approvalResults);
        ModelAndView model = new ModelAndView("/admin/macaovehicle-ApprovalResults-edit");
        model.addObject("approvalResults", adminApprovalResultsVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(ApprovalResults approvalResults) {

        approvalResultsService.update(approvalResults);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        approvalResultsService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
