package com.qcloud.component.snakerext.web.handler;

import java.util.List;

import com.qcloud.component.snakerext.model.ProcessExecutor;
import com.qcloud.component.snakerext.web.vo.ProcessExecutorVO;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessExecutorVO;

public interface ProcessExecutorHandler {

	List<ProcessExecutorVO> toVOList(List<ProcessExecutor> list);

	ProcessExecutorVO toVO(ProcessExecutor processExecutor);

	List<AdminProcessExecutorVO> toVOList4Admin(List<ProcessExecutor> list);

	AdminProcessExecutorVO toVO4Admin(ProcessExecutor processExecutor);
}
