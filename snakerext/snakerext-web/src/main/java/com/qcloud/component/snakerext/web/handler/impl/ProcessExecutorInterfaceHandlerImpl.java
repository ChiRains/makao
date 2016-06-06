package com.qcloud.component.snakerext.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.snakerext.web.handler.ProcessExecutorInterfaceHandler;
import com.qcloud.component.snakerext.model.ProcessExecutorInterface;
import com.qcloud.component.snakerext.web.vo.ProcessExecutorInterfaceVO;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessExecutorInterfaceVO;

@Component
public class ProcessExecutorInterfaceHandlerImpl implements ProcessExecutorInterfaceHandler {

	@Override
	public List<ProcessExecutorInterfaceVO> toVOList(List<ProcessExecutorInterface> list){
		List<ProcessExecutorInterfaceVO> voList = new ArrayList<ProcessExecutorInterfaceVO>();
		for (ProcessExecutorInterface processExecutorInterface : list) {
			voList.add(toVO(processExecutorInterface));
		}
		return voList;
	}

	@Override
	public ProcessExecutorInterfaceVO toVO(ProcessExecutorInterface processExecutorInterface){
		String json = Json.toJson(processExecutorInterface);
		return Json.toObject(json, ProcessExecutorInterfaceVO.class, true);

	}

	@Override
	public List<AdminProcessExecutorInterfaceVO> toVOList4Admin(List<ProcessExecutorInterface> list){
		List<AdminProcessExecutorInterfaceVO> voList = new ArrayList<AdminProcessExecutorInterfaceVO>();
		for (ProcessExecutorInterface adminProcessExecutorInterface : list) {
			voList.add(toVO4Admin(adminProcessExecutorInterface));
		}
		return voList;
	}

	@Override
	public AdminProcessExecutorInterfaceVO toVO4Admin(ProcessExecutorInterface processExecutorInterface){
		String json = Json.toJson(processExecutorInterface);
		return Json.toObject(json, AdminProcessExecutorInterfaceVO.class, true);
	}
}
