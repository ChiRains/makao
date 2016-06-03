package com.qcloud.component.snakerext.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.snakerext.web.handler.TaskFormAccessHandler;
import com.qcloud.component.snakerext.model.TaskFormAccess;
import com.qcloud.component.snakerext.web.vo.TaskFormAccessVO;
import com.qcloud.component.snakerext.web.vo.admin.AdminTaskFormAccessVO;

@Component
public class TaskFormAccessHandlerImpl implements TaskFormAccessHandler {

	@Override
	public List<TaskFormAccessVO> toVOList(List<TaskFormAccess> list){
		List<TaskFormAccessVO> voList = new ArrayList<TaskFormAccessVO>();
		for (TaskFormAccess taskFormAccess : list) {
			voList.add(toVO(taskFormAccess));
		}
		return voList;
	}

	@Override
	public TaskFormAccessVO toVO(TaskFormAccess taskFormAccess){
		String json = Json.toJson(taskFormAccess);
		return Json.toObject(json, TaskFormAccessVO.class, true);

	}

	@Override
	public List<AdminTaskFormAccessVO> toVOList4Admin(List<TaskFormAccess> list){
		List<AdminTaskFormAccessVO> voList = new ArrayList<AdminTaskFormAccessVO>();
		for (TaskFormAccess adminTaskFormAccess : list) {
			voList.add(toVO4Admin(adminTaskFormAccess));
		}
		return voList;
	}

	@Override
	public AdminTaskFormAccessVO toVO4Admin(TaskFormAccess taskFormAccess){
		String json = Json.toJson(taskFormAccess);
		return Json.toObject(json, AdminTaskFormAccessVO.class, true);
	}
}
