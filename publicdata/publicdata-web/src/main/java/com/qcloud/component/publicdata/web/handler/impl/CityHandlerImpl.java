package com.qcloud.component.publicdata.web.handler.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.service.ProvinceService;
import com.qcloud.component.publicdata.web.handler.CityHandler;
import com.qcloud.component.publicdata.web.vo.CityVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminCityVO;
import com.qcloud.pirates.core.json.Json;
@Component
public class CityHandlerImpl implements CityHandler {
    @Autowired
    private ProvinceService provinceService;

    @Override
    public List<CityVO> toVOList(List<City> list) {
        List<CityVO> voList = new ArrayList<CityVO>();
        for (City city : list) {
            voList.add(toVO(city));
        }
        return voList;
    }

    @Override
    public CityVO toVO(City city) {
        String json = Json.toJson(city);
        return Json.toObject(json, CityVO.class, true);
    }

    @Override
    public List<AdminCityVO> toVOList4Admin(List<City> list) {
        List<AdminCityVO> voList = new ArrayList<AdminCityVO>();
        for (City adminCity : list) {
            voList.add(toVO4Admin(adminCity));
        }
        return voList;
    }

    @Override
    public AdminCityVO toVO4Admin(City city) {
        String json = Json.toJson(city);
        AdminCityVO vo = Json.toObject(json, AdminCityVO.class, true);
        Province p = provinceService.get(city.getProvinceId());
        vo.setProvince(p == null ? "" : p.getName());
        return vo;
    }
}
