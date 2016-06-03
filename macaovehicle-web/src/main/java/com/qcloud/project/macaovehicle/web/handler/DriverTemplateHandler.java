package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.DriverTemplate;
import com.qcloud.project.macaovehicle.web.vo.DriverTemplateVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverTemplateVO;

public interface DriverTemplateHandler {

	List<DriverTemplateVO> toVOList(List<DriverTemplate> list);

	DriverTemplateVO toVO(DriverTemplate driverTemplate);

	List<AdminDriverTemplateVO> toVOList4Admin(List<DriverTemplate> list);

	AdminDriverTemplateVO toVO4Admin(DriverTemplate driverTemplate);
}
