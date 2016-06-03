package com.qcloud.component.snakerext.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.snakerext.web.handler.ProcessGroupHandler;
import com.qcloud.component.snakerext.model.ProcessGroup;
import com.qcloud.component.snakerext.web.vo.ProcessGroupVO;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessGroupVO;

@Component
public class ProcessGroupHandlerImpl implements ProcessGroupHandler {

	@Override
	public List<ProcessGroupVO> toVOList(List<ProcessGroup> list){
		List<ProcessGroupVO> voList = new ArrayList<ProcessGroupVO>();
		for (ProcessGroup processGroup : list) {
			voList.add(toVO(processGroup));
		}
		return voList;
	}

	@Override
	public ProcessGroupVO toVO(ProcessGroup processGroup){
		String json = Json.toJson(processGroup);
		return Json.toObject(json, ProcessGroupVO.class, true);

	}

	@Override
	public List<AdminProcessGroupVO> toVOList4Admin(List<ProcessGroup> list){
		List<AdminProcessGroupVO> voList = new ArrayList<AdminProcessGroupVO>();
		for (ProcessGroup adminProcessGroup : list) {
			voList.add(toVO4Admin(adminProcessGroup));
		}
		return voList;
	}

	@Override
	public AdminProcessGroupVO toVO4Admin(ProcessGroup processGroup){
		String json = Json.toJson(processGroup);
		return Json.toObject(json, AdminProcessGroupVO.class, true);
	}
}
