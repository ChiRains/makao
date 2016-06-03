package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerVO;

public interface CarOwnerHandler {

	List<CarOwnerVO> toVOList(List<CarOwner> list);

	CarOwnerVO toVO(CarOwner carOwner);

	List<AdminCarOwnerVO> toVOList4Admin(List<CarOwner> list);

	AdminCarOwnerVO toVO4Admin(CarOwner carOwner);
}
