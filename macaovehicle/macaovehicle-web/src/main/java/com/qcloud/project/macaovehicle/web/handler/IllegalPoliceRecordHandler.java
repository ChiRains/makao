package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.IllegalPoliceRecord;
import com.qcloud.project.macaovehicle.web.vo.IllegalPoliceRecordVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminIllegalPoliceRecordVO;

public interface IllegalPoliceRecordHandler {

	List<IllegalPoliceRecordVO> toVOList(List<IllegalPoliceRecord> list);

	IllegalPoliceRecordVO toVO(IllegalPoliceRecord illegalPoliceRecord);

	List<AdminIllegalPoliceRecordVO> toVOList4Admin(List<IllegalPoliceRecord> list);

	AdminIllegalPoliceRecordVO toVO4Admin(IllegalPoliceRecord illegalPoliceRecord);
}
