package com.qcloud.component.admin.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.admin.exception.AdminException;
import com.qcloud.component.admin.model.Admin;
import com.qcloud.component.admin.model.key.TypeEnum.AdminEnableType;
import com.qcloud.component.admin.service.AdminService;
import com.qcloud.component.admin.web.handler.AdminHandler;
import com.qcloud.component.admin.web.vo.AdminVO;
import com.qcloud.component.token.TokenClient;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.PagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.filter.admin.AdminFilterService;

@Controller
@RequestMapping(value = AdminController.DIR)
public class AdminController {

    public static final String DIR    = "/admin/";

    @Autowired
    AdminService               adminService;

    @Autowired
    AdminFilterService         adminFilterService;

    @Autowired
    TokenClient                tokenClient;

    @Autowired
    AdminHandler               adminHandler;

    Log                        logger = LogFactory.getLog(getClass());

    //
    @RequestMapping
    public ModelAndView list(String keyword, Integer pageNum) {

        // 暂时不分页,管理员不是很多
        int pageSize = Integer.MAX_VALUE;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, pageSize);
        Page<Admin> page = adminService.list(start, pageSize);
        List<AdminVO> list = adminHandler.toVOList(page.getData());
        // 内存中筛选
        keyword=StringUtil.nullToEmpty(keyword);
        List<AdminVO> newList = new ArrayList<AdminVO>();
        for (AdminVO adminVO : list) {
            if (adminVO.getAccount().contains(keyword) || adminVO.getName().contains(keyword)) {
                newList.add(adminVO);
            }
        }
        PagingView model = new PagingView("admin/admin-list", pageNum, pageSize);
        model.addObject("adminList", newList);
        model.addObject("keyword", keyword);
        model.setTotalCount(page.getCount());
        return model;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView modelAndView = new ModelAndView("admin/admin-add");
        return modelAndView;
    }

    @RequestMapping
    public AceAjaxView add(@ModelAttribute Admin admin) {

        AssertUtil.assertNotEmpty(admin.getAccount(), "管理员账号不能为空。");
        AssertUtil.assertNotEmpty(admin.getName(), "管理员名称不能为空");
        adminService.add(admin);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl("admin/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        adminService.delete(id);
        Map<String, String> map = new HashMap<String, String>();
        map.put("url", "/admin/list.do");
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl("admin/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        Admin admin = adminService.get(id);
        AssertUtil.assertNotNull(admin, "管理员不存在.");
        AdminVO vo = adminHandler.toVO(admin);
        ModelAndView modelAndView = new ModelAndView("admin/admin-edit");
        modelAndView.addObject("admin", vo);
        return modelAndView;
    }

    @RequestMapping
    public AceAjaxView edit(@ModelAttribute Admin admin) {

        AssertUtil.assertNotNull(admin.getId(), "ID不能为空");
        adminService.update(admin);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl("admin/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView enable(Long id, Integer value) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        AssertUtil.assertNotNull(value, "value不能为空");
        Admin admin = adminService.get(id);
        AssertUtil.assertNotNull(admin, "管理员不存在." + id);
        logger.info("enable " + id + " " + value);
        String message = null;
        if (AdminEnableType.DISABLE.getKey() == value) {
            admin.setEnable(AdminEnableType.DISABLE.getKey());
            message = "禁用成功";
        } else if (AdminEnableType.ENABLE.getKey() == value) {
            admin.setEnable(AdminEnableType.ENABLE.getKey());
            message = "启用成功";
        } else {
            throw new AdminException("启、禁用状态不正确.");
        }
        adminService.update(admin);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage(message);
        aceAjaxView.setUrl("admin/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView resetPsw(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        Admin admin = adminService.get(id);
        AssertUtil.assertNotNull(admin, "管理员不存在.");
        admin.setPassword(adminService.getEncodeDefaultPsw());
        adminService.update(admin);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("密码已重置");
        aceAjaxView.setUrl("admin/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toAdminPersonalInfo(HttpServletRequest request) {

        String tokenId = adminFilterService.getTokenId(request);
        String value = tokenClient.get(tokenId);
        Long id = Long.parseLong(value);
        AssertUtil.assertNotNull(id, "ID不能为空");
        Admin admin = adminService.get(id);
        AssertUtil.assertNotNull(admin, "管理员不存在.");
        AdminVO vo = adminHandler.toVO(admin);
        ModelAndView modelAndView = new ModelAndView("admin/personal-edit");
        modelAndView.addObject("admin", vo);
        return modelAndView;
    }

    @RequestMapping
    public AceAjaxView modify(@ModelAttribute Admin admin, String oldPsw, String newPsw) {

        AssertUtil.assertNotNull(admin.getId(), "ID不能为空");
        Admin a = adminService.get(admin.getId());
        AssertUtil.assertNotNull(a, "管理员不存在.");
        if (StringUtils.isNotEmpty(oldPsw)) {
            if (adminService.getEncodePsw(oldPsw).equals(a.getPassword())) {
                admin.setPassword(adminService.getEncodePsw(newPsw));
            } else {
                throw new AdminException("原密码不正确");
            }
        }
        adminService.update(admin);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl("admin/toAdminPersonalInfo");
        return aceAjaxView;
    }
}
