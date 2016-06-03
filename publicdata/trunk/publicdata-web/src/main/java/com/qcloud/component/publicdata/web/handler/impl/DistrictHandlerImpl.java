package com.qcloud.component.publicdata.web.handler.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.model.District;
import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.service.CityService;
import com.qcloud.component.publicdata.service.ProvinceService;
import com.qcloud.component.publicdata.web.handler.DistrictHandler;
import com.qcloud.component.publicdata.web.vo.DistrictVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminDistrictVO;
import com.qcloud.pirates.core.json.Json;
@Component
public class DistrictHandlerImpl implements DistrictHandler {
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CityService     cityService;

    @Override
    public List<DistrictVO> toVOList(List<District> list) {
        List<DistrictVO> voList = new ArrayList<DistrictVO>();
        for (District district : list) {
            voList.add(toVO(district));
        }
        return voList;
    }

    @Override
    public DistrictVO toVO(District district) {
        String json = Json.toJson(district);
        return Json.toObject(json, DistrictVO.class, true);
    }

    @Override
    public List<AdminDistrictVO> toVOList4Admin(List<District> list) {
        List<AdminDistrictVO> voList = new ArrayList<AdminDistrictVO>();
        for (District adminDistrict : list) {
            voList.add(toVO4Admin(adminDistrict));
        }
        return voList;
    }

    @Override
    public AdminDistrictVO toVO4Admin(District district) {
        String json = Json.toJson(district);
        AdminDistrictVO vo = Json.toObject(json, AdminDistrictVO.class, true);
        Province p = provinceService.get(district.getProvinceId());
        City c = cityService.get(district.getCityId());
        vo.setProvince(p != null ? p.getName() : "");
        vo.setCity(c != null ? c.getName() : "");
        return vo;
    }
}
