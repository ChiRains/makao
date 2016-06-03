package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.OnestopCarRecord;
import com.qcloud.project.macaovehicle.web.vo.OnestopCarRecordVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminOnestopCarRecordVO;

public interface OnestopCarRecordHandler {

	List<OnestopCarRecordVO> toVOList(List<OnestopCarRecord> list);

	OnestopCarRecordVO toVO(OnestopCarRecord onestopCarRecord);

	List<AdminOnestopCarRecordVO> toVOList4Admin(List<OnestopCarRecord> list);

	AdminOnestopCarRecordVO toVO4Admin(OnestopCarRecord onestopCarRecord);
}
