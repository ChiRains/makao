package com.qcloud.component.snakerext.web.handler;

import java.util.List;

import com.qcloud.component.snakerext.model.ProcessGroup;
import com.qcloud.component.snakerext.web.vo.ProcessGroupVO;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessGroupVO;

public interface ProcessGroupHandler {

	List<ProcessGroupVO> toVOList(List<ProcessGroup> list);

	ProcessGroupVO toVO(ProcessGroup processGroup);

	List<AdminProcessGroupVO> toVOList4Admin(List<ProcessGroup> list);

	AdminProcessGroupVO toVO4Admin(ProcessGroup processGroup);
}
