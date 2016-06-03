package com.qcloud.component.snakerext.web.handler;

import java.util.List;

import com.qcloud.component.snakerext.model.TaskFormAccess;
import com.qcloud.component.snakerext.web.vo.TaskFormAccessVO;
import com.qcloud.component.snakerext.web.vo.admin.AdminTaskFormAccessVO;

public interface TaskFormAccessHandler {

	List<TaskFormAccessVO> toVOList(List<TaskFormAccess> list);

	TaskFormAccessVO toVO(TaskFormAccess taskFormAccess);

	List<AdminTaskFormAccessVO> toVOList4Admin(List<TaskFormAccess> list);

	AdminTaskFormAccessVO toVO4Admin(TaskFormAccess taskFormAccess);
}
