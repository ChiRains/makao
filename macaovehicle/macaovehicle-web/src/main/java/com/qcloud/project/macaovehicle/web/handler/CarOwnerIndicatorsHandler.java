package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.CarOwnerIndicators;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerIndicatorsVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerIndicatorsVO;

public interface CarOwnerIndicatorsHandler {

	List<CarOwnerIndicatorsVO> toVOList(List<CarOwnerIndicators> list);

	CarOwnerIndicatorsVO toVO(CarOwnerIndicators carOwnerIndicators);

	List<AdminCarOwnerIndicatorsVO> toVOList4Admin(List<CarOwnerIndicators> list);

	AdminCarOwnerIndicatorsVO toVO4Admin(CarOwnerIndicators carOwnerIndicators);
}
