package com.qcloud.component.publicdata.web.handler;

import java.util.List;

import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.web.vo.ProvinceVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminProvinceVO;

public interface ProvinceHandler {

	List<ProvinceVO> toVOList(List<Province> list);

	ProvinceVO toVO(Province province);

	List<AdminProvinceVO> toVOList4Admin(List<Province> list);

	AdminProvinceVO toVO4Admin(Province province);
}
