package com.qcloud.component.organization.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.organization.model.ClerkPost;
import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.model.query.ClerkPostQuery;
import com.qcloud.component.organization.service.ClerkPostService;
import com.qcloud.component.organization.service.ClerkService;
import com.qcloud.component.organization.web.form.ClerkPostForm;
import com.qcloud.component.organization.web.handler.ClerkPostHandler;
import com.qcloud.component.organization.web.vo.admin.AdminClerkPostVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = "/" + AdminClerkPostController.DIR)
public class AdminClerkPostController {

    public static final String DIR = "admin/clerkPost";

    @Autowired
    private ClerkPostService   clerkPostService;

    @Autowired
    private ClerkService       clerkService;

    @Autowired
    private ClerkPostHandler   clerkPostHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, ClerkPostQuery query) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<ClerkPost> page = clerkPostService.page(query, start, PAGE_SIZE);
        List<AdminClerkPostVO> list = clerkPostHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/organization-ClerkPost-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/organization-ClerkPost-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(ClerkPost clerkPost) {

        clerkPostService.add(clerkPost);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        ClerkPost clerkPost = clerkPostService.get(id);
        AdminClerkPostVO adminClerkPostVO = clerkPostHandler.toVO4Admin(clerkPost);
        ModelAndView model = new ModelAndView("/admin/organization-ClerkPost-edit");
        model.addObject("clerkPost", adminClerkPostVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(ClerkPostForm clerkPostForm) {
        AceAjaxView aceAjaxView = new AceAjaxView();
        if (clerkPostForm.getIsSelected()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("clerkId", clerkPostForm.getClerkId());
            clerkPostService.delete(map);
            //
            ClerkPost c = new ClerkPost();
            c.setClerkId(clerkPostForm.getClerkId());
            c.setPostId(clerkPostForm.getPostId());
            clerkPostService.add(c);
            aceAjaxView.setMessage("编辑成功");
        } else {
            aceAjaxView.setStatus(-1);
            aceAjaxView.setMessage("编辑失败,职员必须属于一个岗位");
        }
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        clerkPostService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView selectMember(Integer pageNum, ClerkPostQuery query) {

        final int PAGE_SIZE = Integer.MAX_VALUE;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<ClerkPost> page = clerkPostService.page(query, start, PAGE_SIZE);
        List<AdminClerkPostVO> list = clerkPostHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/organization-ClerkPost-selectMember", DIR + "/selectMember", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("query", query);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", query.getName());
        pagingView.addObject("clerkList", clerkService.listAll(map));
        return pagingView;
    }
}
