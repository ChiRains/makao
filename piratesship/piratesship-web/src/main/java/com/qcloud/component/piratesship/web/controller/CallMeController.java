package com.qcloud.component.piratesship.web.controller;

import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.piratesship.model.CallMe;
import com.qcloud.component.piratesship.model.query.CallMeQuery;
import com.qcloud.component.piratesship.service.CallMeService;
import com.qcloud.component.piratesship.web.handler.CallMeHandler;
import com.qcloud.component.piratesship.web.vo.admin.AdminCallMeVO;
import com.qcloud.pirates.core.context.PiratesBeanFactoryAware;
import com.qcloud.pirates.core.env.ProjectInfo;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.pirates.web.page.PageParameterUtil;
import com.qcloud.pirates.web.page.PiratesParameterKey;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = CallMeController.DIR)
public class CallMeController {

    public static final String DIR      = "/callMe";

    public static int          question = 1;

    public static int          taked    = 2;

    public static int          finished = 3;

    public static int          closed   = 4;

    @Autowired
    private CallMeService      callMeService;

    @Autowired
    private CallMeHandler      callMeHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(HttpServletRequest request, PPage pPage, CallMeQuery query) {

        //
        ProjectInfo projectInfo = (ProjectInfo) PiratesBeanFactoryAware.getBeanFactory().getBean("projectInfo");
        query.setProject(projectInfo.getCode());
        //
        Page<CallMe> page = callMeService.page(query, pPage.getPageStart(), pPage.getPageSize());
        List<AdminCallMeVO> list = callMeHandler.toVOList4Admin(page.getData());
        String pageQueryStr = StringUtil.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));
        AcePagingView pagingView = new AcePagingView("/piratesship/piratesship-CallMe-list", DIR + "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
        List<String> memberList = callMeService.listCallMember();
        pagingView.addObject("memberList", memberList);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/piratesship/piratesship-CallMe-add");
        List<String> memberList = callMeService.listCallMember();
        model.addObject("memberList", memberList);
        return model;
    }

    @RequestMapping
    public AceAjaxView add(CallMe callMe) {

        AssertUtil.assertNotEmpty(callMe.getFromSeaman(), "Who @ 不能为空.");
        AssertUtil.assertNotEmpty(callMe.getToSeaman(), "@ Who 不能为空.");
        AssertUtil.assertNotEmpty(callMe.getSubject(), "主题不能为空.");
        ProjectInfo projectInfo = (ProjectInfo) PiratesBeanFactoryAware.getBeanFactory().getBean("projectInfo");
        callMe.setProject(projectInfo.getCode());
        //
        String fromWhos = callMe.getFromSeaman().replace("@ ", "");
        String toWhos = callMe.getToSeaman().replace("@", "");
        callMe.setToSeaman(toWhos);
        callMe.setFromSeaman(fromWhos);
        callMe.setState(question);
        //
        callMeService.add(callMe);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id, String queryStr) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        CallMe callMe = callMeService.get(id);
        AdminCallMeVO adminCallMeVO = callMeHandler.toVO4Admin(callMe);
        ModelAndView model = new ModelAndView("/piratesship/piratesship-CallMe-edit");
        model.addObject("callMe", adminCallMeVO);
        model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(CallMe callMe, String queryStr) {

        callMeService.update(callMe);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        callMeService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView take(Long id, String receiveSeaman) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        AssertUtil.assertNotNull(receiveSeaman, "接手人不能为空");
        CallMe callMe = callMeService.get(id);
        AssertUtil.assertTrue(callMe.getState() == question, "状态跳转不成功");
        callMe.setReceiveSeaman(receiveSeaman);
        callMe.setState(taked);
        callMeService.update(callMe);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("接客成功,你将为客人:" + callMe.getFromSeaman() + "服务.");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView finish(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        CallMe callMe = callMeService.get(id);
        AssertUtil.assertTrue(callMe.getState() == taked, "状态跳转不成功");
        callMe.setState(finished);
        callMeService.update(callMe);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("服务结束了哦,赶紧去找：" + callMe.getFromSeaman() + "领取奖励吧.");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView closed(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        CallMe callMe = callMeService.get(id);
        AssertUtil.assertTrue(callMe.getState() == finished, "状态跳转不成功");
        callMe.setState(closed);
        callMeService.update(callMe);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("欢迎再次光临.");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
