package com.qcloud.component.organization.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.component.admin.exception.AdminException;
import com.qcloud.component.admin.model.key.TypeEnum.AdminEnableType;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.service.ClerkService;
import com.qcloud.component.organization.service.UsergroupUserService;
import com.qcloud.component.organization.web.handler.ClerkHandler;
import com.qcloud.component.organization.model.query.ClerkQuery;
import com.qcloud.component.organization.web.vo.admin.AdminClerkVO;

@Controller
@RequestMapping(value = "/" + AdminClerkController.DIR)
public class AdminClerkController {

    public static final String DIR = "admin/clerk";

    @Autowired
    private ClerkService       clerkService;

    @Autowired
    private ClerkHandler       clerkHandler;
    @Autowired
    private UsergroupUserService usergroupUserService;
    

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, ClerkQuery query) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Clerk> page = clerkService.page(query, start, PAGE_SIZE);
        List<AdminClerkVO> list = clerkHandler.toVOList4Admin(page.getData());
        String param = "name=" + StringUtil.nullToEmpty(query.getName());
        AcePagingView pagingView = new AcePagingView("/admin/organization-Clerk-list", DIR + "/list?" + param, pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("query", query);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/organization-Clerk-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(Clerk clerk) {

        clerkService.add(clerk);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        Clerk clerk = clerkService.get(id);
        AdminClerkVO adminClerkVO = clerkHandler.toVO4Admin(clerk);
        ModelAndView model = new ModelAndView("/admin/organization-Clerk-edit");
        model.addObject("clerk", adminClerkVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(Clerk clerk) {

        Clerk c = clerkService.get(clerk.getId());
        c.setName(clerk.getName());
        clerkService.update(c);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        clerkService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView resetPwd(HttpServletRequest request, Long id) {

        // TODO 待处理用户权限验证
        AssertUtil.assertTrue(id > 0, "ID无效");
        Clerk data = clerkService.get(id);
        AssertUtil.assertNotNull(data, "ID无效");
        AceAjaxView aceAjaxView = new AceAjaxView();
//        data.setPassword(clerkService.getEncodeDefaultPwd());/
        if (clerkService.update(data)) {
            aceAjaxView.setMessage("重置成功");
        } else {
            aceAjaxView.setMessage("重置失败");
            aceAjaxView.setStatus(0);
        }
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView enable(Long id, Integer value) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        AssertUtil.assertNotNull(value, "value不能为空");
        Clerk clerk = clerkService.get(id);
        AssertUtil.assertNotNull(clerk, "成员不存在.");
        String message = null;
        if (AdminEnableType.DISABLE.getKey() == value) {
            clerk.setEnable(AdminEnableType.DISABLE.getKey());
            message = "禁用成功";
        } else if (AdminEnableType.ENABLE.getKey() == value) {
            clerk.setEnable(AdminEnableType.ENABLE.getKey());
            message = "启用成功";
        } else {
            throw new AdminException("启、禁用状态不正确.");
        }
        clerkService.update(clerk);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage(message);
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
    
    @RequestMapping
    public ModelAndView selectAllClerk(ClerkQuery query,Long groupId) {
        ModelAndView view=new ModelAndView("/admin/organization-Clerk-allClerk");
        view.addObject("query",query);
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(query.getName());
        map.put("name", query.getName());
        view.addObject("clerkList", clerkService.listAll(map));
        view.addObject("guList",usergroupUserService.getUserByGroupId(groupId));
        view.addObject("groupId",groupId);
        return view;
    }
    
}
