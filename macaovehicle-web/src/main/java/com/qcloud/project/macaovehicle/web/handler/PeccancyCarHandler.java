package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.PeccancyCar;
import com.qcloud.project.macaovehicle.web.vo.PeccancyCarVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminPeccancyCarVO;

public interface PeccancyCarHandler {

	List<PeccancyCarVO> toVOList(List<PeccancyCar> list);

	PeccancyCarVO toVO(PeccancyCar peccancyCar);

	List<AdminPeccancyCarVO> toVOList4Admin(List<PeccancyCar> list);

	AdminPeccancyCarVO toVO4Admin(PeccancyCar peccancyCar);
}
