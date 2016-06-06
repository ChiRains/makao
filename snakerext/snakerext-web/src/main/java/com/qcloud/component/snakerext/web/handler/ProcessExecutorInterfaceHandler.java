package com.qcloud.component.snakerext.web.handler;

import java.util.List;

import com.qcloud.component.snakerext.model.ProcessExecutorInterface;
import com.qcloud.component.snakerext.web.vo.ProcessExecutorInterfaceVO;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessExecutorInterfaceVO;

public interface ProcessExecutorInterfaceHandler {

	List<ProcessExecutorInterfaceVO> toVOList(List<ProcessExecutorInterface> list);

	ProcessExecutorInterfaceVO toVO(ProcessExecutorInterface processExecutorInterface);

	List<AdminProcessExecutorInterfaceVO> toVOList4Admin(List<ProcessExecutorInterface> list);

	AdminProcessExecutorInterfaceVO toVO4Admin(ProcessExecutorInterface processExecutorInterface);
}
