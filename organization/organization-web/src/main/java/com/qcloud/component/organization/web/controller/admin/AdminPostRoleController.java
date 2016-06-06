package com.qcloud.component.organization.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.admin.exception.AdminException;
import com.qcloud.component.admin.model.key.TypeEnum.AdminEnableType;
import com.qcloud.component.organization.model.PostRole;
import com.qcloud.component.organization.model.query.PostRoleQuery;
import com.qcloud.component.organization.service.PostRoleService;
import com.qcloud.component.organization.web.handler.PostRoleHandler;
import com.qcloud.component.organization.web.vo.admin.AdminPostRoleVO;
import com.qcloud.component.permission.QRole;
import com.qcloud.component.permission.RoleClient;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.filter.permission.PermissionFilterService;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = "/" + AdminPostRoleController.DIR)
public class AdminPostRoleController {

    public static final String      DIR = "admin/postRole";

    @Autowired
    private PostRoleService         postRoleService;

    @Autowired
    private PostRoleHandler         postRoleHandler;

    @Autowired
    private RoleClient              roleClient;

    @Autowired
    private PermissionFilterService permissionFilterService;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, PostRoleQuery query, HttpServletRequest request) {

        AssertUtil.notNull(query.getPostId(), "岗位id不能为空!");
        List<QRole> roleList = roleClient.listRoles();
        final int PAGE_SIZE = Integer.MAX_VALUE;
        pageNum = RequestUtil.getPageid(pageNum);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("postId", query.getPostId());
        List<PostRole> list = postRoleService.listAll(map);
        AcePagingView pagingView = new AcePagingView("/admin/organization-PostRole-list", DIR + "/list", pageNum, PAGE_SIZE, list.size());
        pagingView.addObject("result", list);
        pagingView.addObject("roleList", roleList);
        pagingView.addObject("query", query);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/organization-PostRole-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(PostRole postRole, Integer value) {

        AssertUtil.assertNotNull(postRole.getRoleId(), "角色id不能为空!");
        AssertUtil.assertNotNull(postRole.getPostId(), "岗位id不能为空");
        AssertUtil.assertNotNull(value, "value不能为空");
        if (AdminEnableType.DISABLE.getKey() == value) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("roleId", postRole.getRoleId());
            map.put("postId", postRole.getPostId());
            postRoleService.delete(map);
        } else if (AdminEnableType.ENABLE.getKey() == value) {
            postRoleService.add(postRole);
        } else {
            throw new AdminException("启、禁用状态不正确.");
        }
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        PostRole postRole = postRoleService.get(id);
        AdminPostRoleVO adminPostRoleVO = postRoleHandler.toVO4Admin(postRole);
        ModelAndView model = new ModelAndView("/admin/organization-PostRole-edit");
        model.addObject("postRole", adminPostRoleVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(PostRole postRole) {

        postRoleService.update(postRole);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        postRoleService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
