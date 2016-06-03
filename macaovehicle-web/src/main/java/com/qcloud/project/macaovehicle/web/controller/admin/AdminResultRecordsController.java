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
import com.qcloud.project.macaovehicle.model.ResultRecords;
import com.qcloud.project.macaovehicle.service.ResultRecordsService;
import com.qcloud.project.macaovehicle.web.handler.ResultRecordsHandler;
import com.qcloud.project.macaovehicle.model.query.ResultRecordsQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminResultRecordsVO;

@Controller
@RequestMapping(value = "/" + AdminResultRecordsController.DIR)
public class AdminResultRecordsController {

    public static final String   DIR = "admin/resultRecords";

    @Autowired
    private ResultRecordsService resultRecordsService;

    @Autowired
    private ResultRecordsHandler resultRecordsHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, ResultRecordsQuery query) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<ResultRecords> page = resultRecordsService.page(query, start, PAGE_SIZE);
        List<AdminResultRecordsVO> list = resultRecordsHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-ResultRecords-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/macaovehicle-ResultRecords-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(ResultRecords resultRecords) {

        resultRecordsService.add(resultRecords);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Integer macaovehicleResultRecordsId) {

        AssertUtil.assertNotNull(macaovehicleResultRecordsId, "ID不能为空");
        ResultRecords resultRecords = resultRecordsService.get(macaovehicleResultRecordsId);
        AdminResultRecordsVO adminResultRecordsVO = resultRecordsHandler.toVO4Admin(resultRecords);
        ModelAndView model = new ModelAndView("/admin/macaovehicle-ResultRecords-edit");
        model.addObject("resultRecords", adminResultRecordsVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(ResultRecords resultRecords) {

        resultRecordsService.update(resultRecords);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Integer macaovehicleResultRecordsId) {

        AssertUtil.assertNotNull(macaovehicleResultRecordsId, "ID不能为空");
        resultRecordsService.delete(macaovehicleResultRecordsId);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
