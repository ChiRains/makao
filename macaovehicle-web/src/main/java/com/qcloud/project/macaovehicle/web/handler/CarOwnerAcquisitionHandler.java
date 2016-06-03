package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerAcquisitionVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerAcquisitionVO;

public interface CarOwnerAcquisitionHandler {

	List<CarOwnerAcquisitionVO> toVOList(List<CarOwnerAcquisition> list);

	CarOwnerAcquisitionVO toVO(CarOwnerAcquisition carOwnerAcquisition);

	List<AdminCarOwnerAcquisitionVO> toVOList4Admin(List<CarOwnerAcquisition> list);

	AdminCarOwnerAcquisitionVO toVO4Admin(CarOwnerAcquisition carOwnerAcquisition);
}
