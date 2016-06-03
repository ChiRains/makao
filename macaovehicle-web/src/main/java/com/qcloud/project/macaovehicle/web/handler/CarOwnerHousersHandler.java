package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerHousersVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerHousersVO;

public interface CarOwnerHousersHandler {

	List<CarOwnerHousersVO> toVOList(List<CarOwnerHousers> list);

	CarOwnerHousersVO toVO(CarOwnerHousers carOwnerHousers);

	List<AdminCarOwnerHousersVO> toVOList4Admin(List<CarOwnerHousers> list);

	AdminCarOwnerHousersVO toVO4Admin(CarOwnerHousers carOwnerHousers);
}
