package com.qcloud.component.publicdata.web.handler;

import java.util.List;

import com.qcloud.component.publicdata.model.ExpressDistrict;
import com.qcloud.component.publicdata.web.vo.ExpressDistrictVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminExpressDistrictVO;

public interface ExpressDistrictHandler {

	List<ExpressDistrictVO> toVOList(List<ExpressDistrict> list);

	ExpressDistrictVO toVO(ExpressDistrict expressDistrict);

	List<AdminExpressDistrictVO> toVOList4Admin(List<ExpressDistrict> list);

	AdminExpressDistrictVO toVO4Admin(ExpressDistrict expressDistrict);
}
