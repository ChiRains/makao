package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.web.vo.DriverVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverVO;

public interface DriverHandler {

	List<DriverVO> toVOList(List<Driver> list);

	DriverVO toVO(Driver driver);

	List<AdminDriverVO> toVOList4Admin(List<Driver> list);

	AdminDriverVO toVO4Admin(Driver driver);
}
