package com.qcloud.component.snakerext.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.snakerext.web.handler.ProcessFormHandler;
import com.qcloud.component.snakerext.model.ProcessForm;
import com.qcloud.component.snakerext.web.vo.ProcessFormVO;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessFormVO;

@Component
public class ProcessFormHandlerImpl implements ProcessFormHandler {

	@Override
	public List<ProcessFormVO> toVOList(List<ProcessForm> list){
		List<ProcessFormVO> voList = new ArrayList<ProcessFormVO>();
		for (ProcessForm processForm : list) {
			voList.add(toVO(processForm));
		}
		return voList;
	}

	@Override
	public ProcessFormVO toVO(ProcessForm processForm){
		String json = Json.toJson(processForm);
		return Json.toObject(json, ProcessFormVO.class, true);

	}

	@Override
	public List<AdminProcessFormVO> toVOList4Admin(List<ProcessForm> list){
		List<AdminProcessFormVO> voList = new ArrayList<AdminProcessFormVO>();
		for (ProcessForm adminProcessForm : list) {
			voList.add(toVO4Admin(adminProcessForm));
		}
		return voList;
	}

	@Override
	public AdminProcessFormVO toVO4Admin(ProcessForm processForm){
		String json = Json.toJson(processForm);
		return Json.toObject(json, AdminProcessFormVO.class, true);
	}
}
