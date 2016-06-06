package com.qcloud.component.publicservice.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.pirates.web.page.PageParameterUtil;
import com.qcloud.pirates.web.page.PiratesParameterKey;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.component.publicservice.model.CommonQuestion;
import com.qcloud.component.publicservice.service.CommonQuestionService;
import com.qcloud.component.publicservice.web.handler.CommonQuestionHandler;
import com.qcloud.component.publicservice.model.query.CommonQuestionQuery;
import com.qcloud.component.publicservice.web.vo.admin.AdminCommonQuestionVO;

@Controller
@RequestMapping(value = "/" + AdminCommonQuestionController.DIR)
public class AdminCommonQuestionController {

    public static final String    DIR = "admin/commonQuestion";

    @Autowired
    private CommonQuestionService commonQuestionService;

    @Autowired
    private CommonQuestionHandler commonQuestionHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(HttpServletRequest request, Integer pageNum, PPage pPage, CommonQuestionQuery query) {

        Page<CommonQuestion> page = commonQuestionService.page(query, pPage.getPageStart(), pPage.getPageSize());
        List<AdminCommonQuestionVO> list = commonQuestionHandler.toVOList4Admin(page.getData());
        String pageQueryStr = StringUtil.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));
        AcePagingView pagingView = new AcePagingView("/admin/publicservice-CommonQuestion-list", DIR + "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
        return pagingView;
    }

    @RequestMapping
    @NoReferer
    public AceAjaxView upward(HttpServletRequest request, Long id, PPage pPage, CommonQuestionQuery query) {

        CommonQuestion commonQuestion = commonQuestionService.get(id);
        CommonQuestion prevCommonQuestion = commonQuestionService.listBySortNo(commonQuestion.getSort() - 1);
        commonQuestion.setSort(commonQuestion.getSort() - 1);
        commonQuestionService.update(commonQuestion);
        if (prevCommonQuestion != null) {
            prevCommonQuestion.setSort(prevCommonQuestion.getSort() + 1);
            commonQuestionService.update(prevCommonQuestion);
        }
        AceAjaxView view = new AceAjaxView();
        return view;
    }

    @RequestMapping
    @NoReferer
    public ModelAndView downward(HttpServletRequest request, Long id, PPage pPage, CommonQuestionQuery query) {

        CommonQuestion commonQuestion = commonQuestionService.get(id);
        CommonQuestion nextCommonQuestion = commonQuestionService.listBySortNo(commonQuestion.getSort() + 1);
        commonQuestion.setSort(commonQuestion.getSort() + 1);
        commonQuestionService.update(commonQuestion);
        if (nextCommonQuestion != null) {
            nextCommonQuestion.setSort(nextCommonQuestion.getSort() - 1);
            commonQuestionService.update(nextCommonQuestion);
        }
        AceAjaxView view = new AceAjaxView();
        return view;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/publicservice-CommonQuestion-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(CommonQuestion commonQuestion) {

        commonQuestion.setTime(new Date());
        commonQuestionService.add(commonQuestion);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id, String queryStr) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        CommonQuestion commonQuestion = commonQuestionService.get(id);
        AdminCommonQuestionVO adminCommonQuestionVO = commonQuestionHandler.toVO4Admin(commonQuestion);
        ModelAndView model = new ModelAndView("/admin/publicservice-CommonQuestion-edit");
        model.addObject("commonQuestion", adminCommonQuestionVO);
        model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(CommonQuestion commonQuestion, String queryStr) {

        commonQuestionService.update(commonQuestion);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        commonQuestionService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
