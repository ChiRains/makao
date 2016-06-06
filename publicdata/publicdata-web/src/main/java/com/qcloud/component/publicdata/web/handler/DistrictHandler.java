package com.qcloud.component.publicdata.web.handler;

import java.util.List;

import com.qcloud.component.publicdata.model.District;
import com.qcloud.component.publicdata.web.vo.DistrictVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminDistrictVO;

public interface DistrictHandler {

	List<DistrictVO> toVOList(List<District> list);

	DistrictVO toVO(District district);

	List<AdminDistrictVO> toVOList4Admin(List<District> list);

	AdminDistrictVO toVO4Admin(District district);
}
