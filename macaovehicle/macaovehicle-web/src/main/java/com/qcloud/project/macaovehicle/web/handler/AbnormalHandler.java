package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.Abnormal;
import com.qcloud.project.macaovehicle.web.vo.AbnormalVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminAbnormalVO;

public interface AbnormalHandler {

	List<AbnormalVO> toVOList(List<Abnormal> list);

	AbnormalVO toVO(Abnormal abnormal);

	List<AdminAbnormalVO> toVOList4Admin(List<Abnormal> list);

	AdminAbnormalVO toVO4Admin(Abnormal abnormal);
}
