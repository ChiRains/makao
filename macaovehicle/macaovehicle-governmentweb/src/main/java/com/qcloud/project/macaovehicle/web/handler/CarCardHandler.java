package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.CarCard;
import com.qcloud.project.macaovehicle.web.vo.CarCardVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarCardVO;

public interface CarCardHandler {

	List<CarCardVO> toVOList(List<CarCard> list);

	CarCardVO toVO(CarCard carCard);

	List<AdminCarCardVO> toVOList4Admin(List<CarCard> list);

	AdminCarCardVO toVO4Admin(CarCard carCard);
}
