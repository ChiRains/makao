package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.IllegalCarRecord;
import com.qcloud.project.macaovehicle.web.vo.IllegalCarRecordVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminIllegalCarRecordVO;

public interface IllegalCarRecordHandler {

	List<IllegalCarRecordVO> toVOList(List<IllegalCarRecord> list);

	IllegalCarRecordVO toVO(IllegalCarRecord illegalCarRecord);

	List<AdminIllegalCarRecordVO> toVOList4Admin(List<IllegalCarRecord> list);

	AdminIllegalCarRecordVO toVO4Admin(IllegalCarRecord illegalCarRecord);
}
