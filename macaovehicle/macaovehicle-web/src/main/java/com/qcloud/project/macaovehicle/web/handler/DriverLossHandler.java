package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.DriverLoss;
import com.qcloud.project.macaovehicle.web.vo.DriverLossVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverLossVO;

public interface DriverLossHandler {

	List<DriverLossVO> toVOList(List<DriverLoss> list);

	DriverLossVO toVO(DriverLoss driverLoss);

	List<AdminDriverLossVO> toVOList4Admin(List<DriverLoss> list);

	AdminDriverLossVO toVO4Admin(DriverLoss driverLoss);
}
