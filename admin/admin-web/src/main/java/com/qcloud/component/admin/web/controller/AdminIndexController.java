package com.qcloud.component.admin.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.admin.exception.AdminException;
import com.qcloud.component.admin.model.Admin;
import com.qcloud.component.admin.service.AdminService;
import com.qcloud.component.admin.web.menu.MenuExtendClient;
import com.qcloud.component.permission.MenuClient;
import com.qcloud.component.permission.vo.CatalogVO;
import com.qcloud.component.token.TokenClient;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.web.filter.LisenceLimit;
import com.qcloud.pirates.web.filter.admin.AdminFilterService;
import com.qcloud.pirates.web.filter.permission.PermissionFilterService;
import com.qcloud.pirates.web.filter.user.UserFilterService;

@Controller
@RequestMapping(value = AdminIndexController.DIR)
public class AdminIndexController {

    public static final String      DIR    = "/admin/";

    @Autowired
    private MenuClient              menuClient;

    @Autowired
    UserFilterService               userFilterService;

    @Autowired
    AdminFilterService              adminFilterService;

    @Autowired
    private PermissionFilterService permissionFilterService;

    @Autowired(required = false)
    private MenuExtendClient        menuExtendClient;

    Log                             logger = LogFactory.getLog(getClass());

    @Autowired
    AdminService                    adminService;

    @Autowired
    TokenClient                     tokenClient;

    @RequestMapping
    public ModelAndView toLogin(HttpServletRequest request) {

        ModelAndView modelAndView;
        if (adminFilterService.isAdminLogin(request)) {// 已登录用户重定向到后台页面
            modelAndView = new ModelAndView("redirect:/admin/index.do");
        } else {
            modelAndView = new ModelAndView("admin/login");
        }
        //
        String code = "loginIndex";
        Xml xml = XmlFactory.get(code);
        if (xml != null) {
            Map<String, String> itemMap = new HashMap<String, String>();
            List<XmlItem> itemList = xml.getItemList();
            for (XmlItem xmlItem : itemList) {
                String str = xmlItem.getText();
                itemMap.put(xmlItem.getAttrMap().get("name"), str);
            }
            modelAndView.addObject("itemMap", itemMap);
        }
        Date dffectiveDate = new LisenceLimit().getEffectiveDate();
        if (DateUtil.addDate(new Date(), 30).after(dffectiveDate)) {
            modelAndView.addObject("LisenceLimitDate", "请联系旗云科技更新授权文件:" + DateUtil.date2String(dffectiveDate, DateUtil.DATE_FORMAT_STRING));
        } else {
            modelAndView.addObject("LisenceLimitDate", "");
        }
        return modelAndView;
    }

    @RequestMapping
    public ModelAndView toLoginAgain(HttpServletRequest request) {

        ModelAndView modelAndView;
        if (adminFilterService.isAdminLogin(request)) {// 已登录用户重定向到后台页面
            modelAndView = new ModelAndView("redirect:/admin/index.do");
        } else {
            modelAndView = new ModelAndView("admin/loginAgain");
        }
        //
        String code = "loginIndex";
        Xml xml = XmlFactory.get(code);
        if (xml != null) {
            Map<String, String> itemMap = new HashMap<String, String>();
            List<XmlItem> itemList = xml.getItemList();
            for (XmlItem xmlItem : itemList) {
                String str = xmlItem.getText();
                itemMap.put(xmlItem.getAttrMap().get("name"), str);
            }
            modelAndView.addObject("itemMap", itemMap);
        }
        return modelAndView;
    }

    @RequestMapping
    public AceAjaxView loginAgain(HttpServletRequest request, String username, String pwd) {

        doLogin(request, username, pwd);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("登录成功");
        aceAjaxView.setUrl("");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView login(HttpServletRequest request, String username, String pwd) {

        doLogin(request, username, pwd);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("登录成功");
        aceAjaxView.setUrl("/admin/index.do", false);
        return aceAjaxView;
    }

    private void doLogin(HttpServletRequest request, String username, String pwd) {

        AssertUtil.assertNotEmpty(username, "账号不能为空.");
        AssertUtil.assertNotEmpty(pwd, "密码不能为空.");
        String[] accounts = null;
        String identificationKey = null;
        if (adminService.isSuperman(username, pwd)) {
            accounts = new String[] { adminService.getSupermanPermissionAccountCode()};
            identificationKey = "-1";
        } else if (adminService.isAdmin(username, pwd)) {
            accounts = new String[] { adminService.getAdminPermissionAccountCode(username)};
            Admin admin = adminService.getByAccount(username);
            identificationKey = String.valueOf(admin.getId());
        } else if (adminService.isBussnessAdmin(username, pwd)) {
            accounts = adminService.getBusinessAdminAccountCode(username);
            identificationKey = adminService.getBusinessIdentificationKey(username);
        } else {
            throw new AdminException("账号或密码有误.");
        }
        String tokenId = adminFilterService.doLogin(request, accounts);
        boolean ok = tokenClient.reg(tokenId, identificationKey);
        if (!ok) {
            throw new AdminException("系统服务出现异常,token添加失败.");
        }
    }

    @RequestMapping
    public ModelAndView logout(HttpServletRequest request) {

        userFilterService.doLogout(request);
        adminFilterService.doLogout(request);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/toLogin.do");// 登出跳转
        return modelAndView;
    }

    @RequestMapping
    public ModelAndView index(HttpServletRequest request) {

        String[] accounts = permissionFilterService.getPermissionAccountCodes(request);
        List<CatalogVO> catalogList = menuClient.list(accounts);
        if (menuExtendClient != null) {
            List<CatalogVO> exList = menuExtendClient.list();
            if (!CollectionUtils.isEmpty(exList)) {
                for (CatalogVO catalogVO : exList) {
                    addToCatalogList(catalogList, catalogVO);
                }
            }
        }
        ModelAndView modelAndView = new ModelAndView("admin/index");
        modelAndView.addObject("catalogList", catalogList);
        return modelAndView;
    }

    private void addToCatalogList(List<CatalogVO> catalogList, CatalogVO catalogVO) {

        for (CatalogVO ca : catalogList) {
            if (ca.getCatalog() != null && catalogVO.getCatalog() != null && ca.getCatalog().getId() == catalogVO.getCatalog().getId()) {
                ca.getMenuList().addAll(catalogVO.getMenuList());
                return;
            }
        }
        catalogList.add(catalogVO);
    }
}
