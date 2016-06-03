package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerPurchaseVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerPurchaseVO;

public interface CarOwnerPurchaseHandler {

	List<CarOwnerPurchaseVO> toVOList(List<CarOwnerPurchase> list);

	CarOwnerPurchaseVO toVO(CarOwnerPurchase carOwnerPurchase);

	List<AdminCarOwnerPurchaseVO> toVOList4Admin(List<CarOwnerPurchase> list);

	AdminCarOwnerPurchaseVO toVO4Admin(CarOwnerPurchase carOwnerPurchase);
}
