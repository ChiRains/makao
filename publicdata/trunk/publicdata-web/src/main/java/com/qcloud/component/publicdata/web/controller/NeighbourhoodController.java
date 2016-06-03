package com.qcloud.component.publicdata.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.publicdata.model.Neighbourhood;
import com.qcloud.component.publicdata.service.NeighbourhoodService;
import com.qcloud.component.publicdata.web.handler.NeighbourhoodHandler;
import com.qcloud.component.publicdata.web.vo.NeighbourhoodVO;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.web.mvc.annotation.PiratesApp;

@Controller
@RequestMapping(value = NeighbourhoodController.DIR)
public class NeighbourhoodController {

    public static final String   DIR = "/neighbourhood";

    @Autowired
    private NeighbourhoodService neighbourhoodService;

    @Autowired
    private NeighbourhoodHandler neighbourhoodHandler;

    // 区域中心点列表
    @PiratesApp
    @RequestMapping
    public FrontPagingView centerList() {

        List<Neighbourhood> list = neighbourhoodService.listAll();
        List<NeighbourhoodVO> volist = neighbourhoodHandler.toVOList(list);
        FrontPagingView view = new FrontPagingView(0, volist.size(), volist.size());
        // view.setData(volist);
        view.addObject("centerList", volist);
        view.setMessage("查询区域中心点成功");
        return view;
    }
}
