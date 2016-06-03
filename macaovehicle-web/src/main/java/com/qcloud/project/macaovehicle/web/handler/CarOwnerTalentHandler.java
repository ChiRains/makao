package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerTalentVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerTalentVO;

public interface CarOwnerTalentHandler {

	List<CarOwnerTalentVO> toVOList(List<CarOwnerTalent> list);

	CarOwnerTalentVO toVO(CarOwnerTalent carOwnerTalent);

	List<AdminCarOwnerTalentVO> toVOList4Admin(List<CarOwnerTalent> list);

	AdminCarOwnerTalentVO toVO4Admin(CarOwnerTalent carOwnerTalent);
}
