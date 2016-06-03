package com.qcloud.component.snakerext.web.handler;

import java.util.List;

import com.qcloud.component.snakerext.model.ProcessForm;
import com.qcloud.component.snakerext.web.vo.ProcessFormVO;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessFormVO;

public interface ProcessFormHandler {

	List<ProcessFormVO> toVOList(List<ProcessForm> list);

	ProcessFormVO toVO(ProcessForm processForm);

	List<AdminProcessFormVO> toVOList4Admin(List<ProcessForm> list);

	AdminProcessFormVO toVO4Admin(ProcessForm processForm);
}
