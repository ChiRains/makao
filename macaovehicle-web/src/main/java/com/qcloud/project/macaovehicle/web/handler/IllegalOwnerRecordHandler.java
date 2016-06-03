package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.IllegalOwnerRecord;
import com.qcloud.project.macaovehicle.web.vo.IllegalOwnerRecordVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminIllegalOwnerRecordVO;

public interface IllegalOwnerRecordHandler {

	List<IllegalOwnerRecordVO> toVOList(List<IllegalOwnerRecord> list);

	IllegalOwnerRecordVO toVO(IllegalOwnerRecord illegalOwnerRecord);

	List<AdminIllegalOwnerRecordVO> toVOList4Admin(List<IllegalOwnerRecord> list);

	AdminIllegalOwnerRecordVO toVO4Admin(IllegalOwnerRecord illegalOwnerRecord);
}
