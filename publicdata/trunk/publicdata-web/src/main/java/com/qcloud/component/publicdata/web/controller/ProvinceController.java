package com.qcloud.component.publicdata.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.model.District;
import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.service.CityService;
import com.qcloud.component.publicdata.service.DistrictService;
import com.qcloud.component.publicdata.service.ProvinceService;
import com.qcloud.component.publicdata.web.vo.CityStructVO;
import com.qcloud.component.publicdata.web.vo.DistrictStructVO;
import com.qcloud.component.publicdata.web.vo.ProvinceStructVO;
import com.qcloud.pirates.mvc.FrontAjaxView;

@Controller
@RequestMapping(value = ProvinceController.DIR)
public class ProvinceController {

    //
    public static final String DIR = "/province";

    @Autowired
    private PublicdataClient   publicdataClient;

    @Autowired
    private ProvinceService    provinceService;

    @Autowired
    private CityService        cityService;

    @Autowired
    private DistrictService    districtService;

    @RequestMapping
    public FrontAjaxView list() {

        List<String> strList = publicdataClient.listProvince();
        FrontAjaxView frontAjaxView = new FrontAjaxView();
        frontAjaxView.setMessage("查询成功");
        frontAjaxView.addObject("provinceList", strList);
        return frontAjaxView;
    }

    @Deprecated
    @RequestMapping
    public FrontAjaxView listProvince() {

        List<Province> strList = publicdataClient.listAllProvince();
        FrontAjaxView frontAjaxView = new FrontAjaxView();
        frontAjaxView.setMessage("查询成功");
        frontAjaxView.addObject("provinceList", strList);
        return frontAjaxView;
    }

    @RequestMapping
    public FrontAjaxView listAddress3grade() {

        List<Province> provinceList = provinceService.listAll();
        List<City> cityList = cityService.listAll();
        List<District> districtList = districtService.listAll();
        List<ProvinceStructVO> voList = new ArrayList<ProvinceStructVO>();
        for (Province province : provinceList) {
            ProvinceStructVO provinceStructVO = new ProvinceStructVO();
            provinceStructVO.setP(province.getName());
            for (City city : cityList) {
                if (city.getProvinceId() != province.getId()) {
                    continue;
                }
                CityStructVO cityStructVO = new CityStructVO();
                cityStructVO.setN(city.getName());
                for (District district : districtList) {
                    if (district.getCityId() != city.getId()) {
                        continue;
                    }
                    DistrictStructVO districtStructVO = new DistrictStructVO();
                    districtStructVO.setS(district.getName());
                    cityStructVO.getA().add(districtStructVO);
                }
                provinceStructVO.getC().add(cityStructVO);
            }
            voList.add(provinceStructVO);
        }
        FrontAjaxView frontAjaxView = new FrontAjaxView();
        frontAjaxView.setMessage("查询成功");
        frontAjaxView.addObject("list", voList);
        return frontAjaxView;
    }
}
