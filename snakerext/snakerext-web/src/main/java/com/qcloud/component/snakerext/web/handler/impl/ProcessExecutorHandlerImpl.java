package com.qcloud.component.snakerext.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.snakerext.web.handler.ProcessExecutorHandler;
import com.qcloud.component.snakerext.model.ProcessExecutor;
import com.qcloud.component.snakerext.web.vo.ProcessExecutorVO;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessExecutorVO;

@Component
public class ProcessExecutorHandlerImpl implements ProcessExecutorHandler {

	@Override
	public List<ProcessExecutorVO> toVOList(List<ProcessExecutor> list){
		List<ProcessExecutorVO> voList = new ArrayList<ProcessExecutorVO>();
		for (ProcessExecutor processExecutor : list) {
			voList.add(toVO(processExecutor));
		}
		return voList;
	}

	@Override
	public ProcessExecutorVO toVO(ProcessExecutor processExecutor){
		String json = Json.toJson(processExecutor);
		return Json.toObject(json, ProcessExecutorVO.class, true);

	}

	@Override
	public List<AdminProcessExecutorVO> toVOList4Admin(List<ProcessExecutor> list){
		List<AdminProcessExecutorVO> voList = new ArrayList<AdminProcessExecutorVO>();
		for (ProcessExecutor adminProcessExecutor : list) {
			voList.add(toVO4Admin(adminProcessExecutor));
		}
		return voList;
	}

	@Override
	public AdminProcessExecutorVO toVO4Admin(ProcessExecutor processExecutor){
		String json = Json.toJson(processExecutor);
		return Json.toObject(json, AdminProcessExecutorVO.class, true);
	}
}
