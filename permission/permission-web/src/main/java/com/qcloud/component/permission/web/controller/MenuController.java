package com.qcloud.component.permission.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.permission.model.Catalog;
import com.qcloud.component.permission.model.Menu;
import com.qcloud.component.permission.model.query.MenuQuery;
import com.qcloud.component.permission.service.CatalogService;
import com.qcloud.component.permission.service.MenuService;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.util.StringUtil;

@Controller
@RequestMapping(value = MenuController.DIR)
public class MenuController {

    public static final String DIR = "menu";

    @Autowired
    private MenuService        menuService;

    @Autowired
    private CatalogService     catalogService;

    @RequestMapping
    public ModelAndView list(MenuQuery query, Integer pageNum) {

        AssertUtil.assertNotNull(query.getCatalogId(), "目录id不能为空");
        AssertUtil.assertTrue(query.getCatalogId() > 0, "目录id不存在");
        query.setName(StringUtil.nullToEmpty(query.getName()));
        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Menu> page = menuService.page(query, start, PAGE_SIZE);
        List<Menu> list = page.getData();
        List<Menu> newList = new ArrayList<Menu>();
        for (Menu menu : list) {
            if (menu.getName().contains(query.getName())) {
                newList.add(menu);
            }
        }
        AcePagingView view = new AcePagingView("permission/menu-list", DIR + "/list?catalogId=" + query.getCatalogId(), pageNum, PAGE_SIZE, page.getCount());
        view.addObject("menuList", newList);
        view.addObject("query", query);
        return view;
    }

    @RequestMapping
    public ModelAndView toAdd(MenuQuery query) {

        List<Catalog> catalogList = catalogService.list();
        ModelAndView view = new ModelAndView("permission/menu-add");
        view.addObject("query", query);
        view.addObject("catalogList", catalogList);
        return view;
    }

    @RequestMapping
    public AceAjaxView add(Menu menu) {

        menuService.add(menu);
        AceAjaxView view = new AceAjaxView();
        view.setMessage("添加成功");
        return view;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "id不能为空");
        AssertUtil.assertTrue(id > 0, "id不存在");
        Menu menu = menuService.get(id);
        AssertUtil.assertNotNull(menu, "菜单不存在." + id);
        List<Catalog> catalogList = catalogService.list();
        ModelAndView view = new ModelAndView("permission/menu-edit");
        view.addObject("menu", menu);
        view.addObject("catalogList", catalogList);
        return view;
    }

    @RequestMapping
    public AceAjaxView edit(Menu menu) {

        menuService.update(menu);
        AceAjaxView view = new AceAjaxView();
        view.setMessage("修改成功");
        return view;
    }
}
