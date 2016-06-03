package com.qcloud.component.publicdata.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.publicdata.service.PopularSearchesService;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;

@Controller
@RequestMapping(value = PopularSearchesController.DIR)
public class PopularSearchesController {

    public static final String     DIR = "/popularSearches";

    @Autowired
    private PopularSearchesService popularSearchesService;

    @RequestMapping
    public FrontAjaxView list(Integer type, Integer number) {

        AssertUtil.assertNotNull(type, "获取热搜数据类型不能为空.");
        number = number == null || number <= 0 || number > 100 ? 20 : number;
        List<String> list = popularSearchesService.listTop(type, number);
        FrontAjaxView frontAjaxView = new FrontAjaxView();
        frontAjaxView.setMessage("查询热搜数据成功");
        frontAjaxView.addObject("list", list);
        return frontAjaxView;
    }
}
