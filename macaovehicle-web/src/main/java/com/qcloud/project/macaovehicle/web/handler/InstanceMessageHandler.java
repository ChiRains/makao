package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.InstanceMessage;
import com.qcloud.project.macaovehicle.web.vo.InstanceMessageVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminInstanceMessageVO;

public interface InstanceMessageHandler {

	List<InstanceMessageVO> toVOList(List<InstanceMessage> list);

	InstanceMessageVO toVO(InstanceMessage instanceMessage);

	List<AdminInstanceMessageVO> toVOList4Admin(List<InstanceMessage> list);

	AdminInstanceMessageVO toVO4Admin(InstanceMessage instanceMessage);
}
