package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerWorkersVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerWorkersVO;

public interface CarOwnerWorkersHandler {

	List<CarOwnerWorkersVO> toVOList(List<CarOwnerWorkers> list);

	CarOwnerWorkersVO toVO(CarOwnerWorkers carOwnerWorkers);

	List<AdminCarOwnerWorkersVO> toVOList4Admin(List<CarOwnerWorkers> list);

	AdminCarOwnerWorkersVO toVO4Admin(CarOwnerWorkers carOwnerWorkers);
}
