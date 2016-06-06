package com.qcloud.component.permission.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.permission.model.Catalog;
import com.qcloud.component.permission.service.CatalogService;
import com.qcloud.pirates.util.StringUtil;

@Controller
@RequestMapping(value = CatalogController.DIR)
public class CatalogController {

    public static final String DIR = "catalog";

    @Autowired
    private CatalogService     catalogService;

    @RequestMapping
    public ModelAndView list(Integer pageNum, String name) {

        name = StringUtil.nullToEmpty(name);
        List<Catalog> list = catalogService.list();
        List<Catalog> newList = new ArrayList<Catalog>();
        for (Catalog catalog : list) {
            if (catalog.getName().contains(name)) {
                newList.add(catalog);
            }
        }
        ModelAndView view = new ModelAndView("permission/catalog-list");
        view.addObject("catalogList", newList);
        view.addObject("name", name);
        return view;
    }
}
