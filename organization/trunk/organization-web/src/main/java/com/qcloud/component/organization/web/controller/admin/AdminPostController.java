package com.qcloud.component.organization.web.controller.admin;

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
import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.service.PostService;
import com.qcloud.component.organization.web.handler.PostHandler;
import com.qcloud.component.organization.model.query.PostQuery;
import com.qcloud.component.organization.web.vo.admin.AdminPostVO;

@Controller
@RequestMapping(value = "/" + AdminPostController.DIR)
public class AdminPostController {

    public static final String DIR = "admin/post";

    @Autowired
    private PostService        postService;

    @Autowired
    private PostHandler        postHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, PostQuery query) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Post> page = postService.page(query, start, PAGE_SIZE);
        List<AdminPostVO> list = postHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/organization-Post-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/organization-Post-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(Post post) {

        postService.add(post);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        Post post = postService.get(id);
        AdminPostVO adminPostVO = postHandler.toVO4Admin(post);
        ModelAndView model = new ModelAndView("/admin/organization-Post-edit");
        model.addObject("post", adminPostVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(Post post) {

        postService.update(post);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        postService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
