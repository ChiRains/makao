package com.qcloud.component.publicdata.web.handler;

import java.util.List;

import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.web.vo.CityVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminCityVO;

public interface CityHandler {

	List<CityVO> toVOList(List<City> list);

	CityVO toVO(City city);

	List<AdminCityVO> toVOList4Admin(List<City> list);

	AdminCityVO toVO4Admin(City city);
}
