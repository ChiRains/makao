package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerEnterprisersVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerEnterprisersVO;

public interface CarOwnerEnterprisersHandler {

	List<CarOwnerEnterprisersVO> toVOList(List<CarOwnerEnterprisers> list);

	CarOwnerEnterprisersVO toVO(CarOwnerEnterprisers carOwnerEnterprisers);

	List<AdminCarOwnerEnterprisersVO> toVOList4Admin(List<CarOwnerEnterprisers> list);

	AdminCarOwnerEnterprisersVO toVO4Admin(CarOwnerEnterprisers carOwnerEnterprisers);
}
