package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.DriverCancel;
import com.qcloud.project.macaovehicle.web.vo.DriverCancelVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverCancelVO;

public interface DriverCancelHandler {

	List<DriverCancelVO> toVOList(List<DriverCancel> list);

	DriverCancelVO toVO(DriverCancel driverCancel);

	List<AdminDriverCancelVO> toVOList4Admin(List<DriverCancel> list);

	AdminDriverCancelVO toVO4Admin(DriverCancel driverCancel);
}
