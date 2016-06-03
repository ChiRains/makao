package com.qcloud.component.snakerext.web.handler;

import java.util.List;

import com.qcloud.component.snakerext.model.ProcessGroupClerk;
import com.qcloud.component.snakerext.web.vo.ProcessGroupClerkVO;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessGroupClerkVO;

public interface ProcessGroupClerkHandler {

	List<ProcessGroupClerkVO> toVOList(List<ProcessGroupClerk> list);

	ProcessGroupClerkVO toVO(ProcessGroupClerk processGroupClerk);

	List<AdminProcessGroupClerkVO> toVOList4Admin(List<ProcessGroupClerk> list);

	AdminProcessGroupClerkVO toVO4Admin(ProcessGroupClerk processGroupClerk);
}
