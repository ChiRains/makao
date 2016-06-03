package com.qcloud.component.permission.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.permission.model.Catalog;
import com.qcloud.component.permission.model.Menu;
import com.qcloud.component.permission.model.Permission;
import com.qcloud.component.permission.model.Role;
import com.qcloud.component.permission.model.RolePermission;
import com.qcloud.component.permission.service.CatalogService;
import com.qcloud.component.permission.service.MenuService;
import com.qcloud.component.permission.service.PermissionService;
import com.qcloud.component.permission.service.RolePermissionService;
import com.qcloud.component.permission.service.RoleService;
import com.qcloud.component.permission.web.handler.RolePermissionHandler;
import com.qcloud.component.permission.web.vo.RolePermissionVo;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.util.AssertUtil;

@Controller
@RequestMapping(value = PermissionController.DIR)
public class PermissionController {

    public static final String    DIR = "permission";

    @Autowired
    private PermissionService     permissionService;

    @Autowired
    private RoleService           roleService;

    @Autowired
    private RolePermissionHandler rolePermissionHandler;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private MenuService           menuService;

    @RequestMapping
    public ModelAndView toGrant(Long id) {

        AssertUtil.assertTrue(id > 0, "id不能为空.");
        Menu menu = menuService.get(id);
        AssertUtil.assertNotNull(menu, "菜单不存在.");
        Permission permission = permissionService.getByMenu(menu.getId());
        AssertUtil.assertNotNull(permission, "菜单--权限不存在.");
        List<Role> roles = roleService.list();
        List<RolePermissionVo> vos = rolePermissionHandler.toVOList(roles, permission);
        AssertUtil.assertNotNull(permission, "权限不存在");
        ModelAndView view = new ModelAndView("permission/menu-grant");
        view.addObject("vos", vos);
        view.addObject("id", id);
        return view;
    }

    @RequestMapping
    public AceAjaxView menuGrant(Long rolePermissionId, Long roleId, Long permissionId) {

        AssertUtil.assertTrue(roleId > 0 && roleId != null, "角色不存在");
        AssertUtil.assertTrue(permissionId > 0 && permissionId != null, "权限不存在");
        if (rolePermissionId == 0) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setPermissionId(permissionId);
            rolePermission.setRoleId(roleId);
            rolePermissionService.add(rolePermission);
        } else {
            rolePermissionService.delete(rolePermissionId);
        }
        AceAjaxView view = new AceAjaxView();
        view.setMessage("编辑成功");
        return view;
    }
}
