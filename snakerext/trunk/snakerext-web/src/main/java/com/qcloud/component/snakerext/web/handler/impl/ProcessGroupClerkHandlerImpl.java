package com.qcloud.component.snakerext.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.snakerext.web.handler.ProcessGroupClerkHandler;
import com.qcloud.component.snakerext.model.ProcessGroupClerk;
import com.qcloud.component.snakerext.web.vo.ProcessGroupClerkVO;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessGroupClerkVO;

@Component
public class ProcessGroupClerkHandlerImpl implements ProcessGroupClerkHandler {

	@Override
	public List<ProcessGroupClerkVO> toVOList(List<ProcessGroupClerk> list){
		List<ProcessGroupClerkVO> voList = new ArrayList<ProcessGroupClerkVO>();
		for (ProcessGroupClerk processGroupClerk : list) {
			voList.add(toVO(processGroupClerk));
		}
		return voList;
	}

	@Override
	public ProcessGroupClerkVO toVO(ProcessGroupClerk processGroupClerk){
		String json = Json.toJson(processGroupClerk);
		return Json.toObject(json, ProcessGroupClerkVO.class, true);

	}

	@Override
	public List<AdminProcessGroupClerkVO> toVOList4Admin(List<ProcessGroupClerk> list){
		List<AdminProcessGroupClerkVO> voList = new ArrayList<AdminProcessGroupClerkVO>();
		for (ProcessGroupClerk adminProcessGroupClerk : list) {
			voList.add(toVO4Admin(adminProcessGroupClerk));
		}
		return voList;
	}

	@Override
	public AdminProcessGroupClerkVO toVO4Admin(ProcessGroupClerk processGroupClerk){
		String json = Json.toJson(processGroupClerk);
		return Json.toObject(json, AdminProcessGroupClerkVO.class, true);
	}
}
