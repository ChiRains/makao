package com.qcloud.component.publicdata.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.component.publicdata.model.City;
import com.qcloud.pirates.mvc.FrontAjaxView;

@Controller
@RequestMapping(value = CityController.DIR)
public class CityController {

    //
    public static final String DIR = "/city";

    @Autowired
    private PublicdataClient   publicdataClient;

    // 后端在使用
    @RequestMapping
    public FrontAjaxView queryByProvince(String province) {

        List<String> strList = publicdataClient.listCity(province);
        List<KeyValueVO> voList = publicdataClient.exchageStr(strList, null, "selected");
        FrontAjaxView frontAjaxView = new FrontAjaxView();
        frontAjaxView.setMessage("查询成功");
        frontAjaxView.addObject("cityList", voList);
        return frontAjaxView;
    }

    // 前端 APP 接口
    @RequestMapping
    public FrontAjaxView listByProvince(String province) {

        List<String> strList = publicdataClient.listCity(province);
        FrontAjaxView frontAjaxView = new FrontAjaxView();
        frontAjaxView.setMessage("查询成功");
        frontAjaxView.addObject("cityList", strList);
        return frontAjaxView;
    }

    // 前端 APP 接口
    @Deprecated
    @RequestMapping
    public FrontAjaxView listCityByProvince(String province) {

        List<City> strList = publicdataClient.listAllCity(province);
        FrontAjaxView frontAjaxView = new FrontAjaxView();
        frontAjaxView.setMessage("查询成功");
        frontAjaxView.addObject("cityList", strList);
        return frontAjaxView;
    }
}
